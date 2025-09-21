class Main {
  // M53
  @Override
  public Object build(Object data) {
    if (data == null) return null;

    if (data instanceof List) {
      final List list = (List) data;
      if (list.isEmpty()) {
        return list == Protocol.PROTOCOL_EMPTY_MAP ? Collections.emptyMap() : Collections.emptyList();
      }

      if (list.get(0) instanceof KeyValue) {
        return ((List<KeyValue>) data).stream()
                .filter(kv -> kv != null && kv.getKey() != null && kv.getValue() != null)
                .collect(Collectors.toMap(kv -> STRING.build(kv.getKey()),
                        kv -> this.build(kv.getValue())));
      } else {
        return list.stream().map(this::build).collect(Collectors.toList());
      }
    } else if (data instanceof byte[]) {
      return STRING.build(data);
    } else {
      return data;
    }
  }


  // M28
  @Override
  public <T> T executeCommand(final CommandObject<T> commandObject) {
    final CacheKey cacheKey = new CacheKey(commandObject);
    if (!cache.isCacheable(cacheKey)) {
      cache.getStats().nonCacheable();
      return super.executeCommand(commandObject);
    }

    CacheEntry<T> cacheEntry = cache.get(cacheKey);
    if (cacheEntry != null) { // (probable) CACHE HIT !!
      cacheEntry = validateEntry(cacheEntry);
      if (cacheEntry != null) {
        // CACHE HIT confirmed !!!
        cache.getStats().hit();
        return cacheEntry.getValue();
      }
    }

    // CACHE MISS !!
    cache.getStats().miss();
    T value = super.executeCommand(commandObject);
    cacheEntry = new CacheEntry<>(cacheKey, value, this);
    cache.set(cacheKey, cacheEntry);
    // this line actually provides a deep copy of cached object instance 
    value = cacheEntry.getValue();
    return value;
  }


  // M43
  @Override
  public List<Object> exec() {
    if (!inMulti) {
      throw new IllegalStateException("EXEC without MULTI");
    }

    try {
      // processPipelinedResponses(pipelinedResponses.size());
      // do nothing
      connection.sendCommand(EXEC);

      List<Object> unformatted = connection.getObjectMultiBulkReply();
      if (unformatted == null) {
        pipelinedResponses.clear();
        return null;
      }

      List<Object> formatted = new ArrayList<>(unformatted.size());
      for (Object o : unformatted) {
        try {
          Response<?> response = pipelinedResponses.poll();
          response.set(o);
          formatted.add(response.get());
        } catch (JedisDataException e) {
          formatted.add(e);
        }
      }
      return formatted;
    } catch (JedisConnectionException jce) {
      broken = true;
      throw jce;
    } finally {
      inMulti = false;
      inWatch = false;
      pipelinedResponses.clear();
    }
  }


  // M934
  private Socket createSslSocket(HostAndPort _hostAndPort, Socket socket) throws IOException, GeneralSecurityException {

    Socket plainSocket = socket;

    SSLSocketFactory _sslSocketFactory;
    SSLParameters _sslParameters;

    if (sslOptions != null) {

      SSLContext _sslContext = sslOptions.createSslContext();
      _sslSocketFactory = _sslContext.getSocketFactory();

      _sslParameters = sslOptions.getSslParameters();

    } else {

      _sslSocketFactory = this.sslSocketFactory;
      _sslParameters = this.sslParameters;
    }

    if (_sslSocketFactory == null) {
      _sslSocketFactory = (SSLSocketFactory) SSLSocketFactory.getDefault();
    }

    SSLSocket sslSocket = (SSLSocket) _sslSocketFactory.createSocket(socket,
            _hostAndPort.getHost(), _hostAndPort.getPort(), true);

    if (_sslParameters != null) {
      sslSocket.setSSLParameters(_sslParameters);
    }

    // allowing HostnameVerifier for both SslOptions and legacy ssl config
    if (hostnameVerifier != null && !hostnameVerifier.verify(_hostAndPort.getHost(), sslSocket.getSession())) {
      String message = String.format("The connection to '%s' failed ssl/tls hostname verification.",
              _hostAndPort.getHost());
      throw new JedisConnectionException(message);
    }

    return new SSLSocketWrapper(sslSocket, plainSocket);
  }


  // M1218
  private HostAndPort initSentinels(Set<HostAndPort> sentinels) {

    HostAndPort master = null;
    boolean sentinelAvailable = false;

    LOG.debug("Trying to find master from available sentinels...");

    for (HostAndPort sentinel : sentinels) {

      LOG.debug("Connecting to Sentinel {}...", sentinel);

      try (Jedis jedis = new Jedis(sentinel, sentinelClientConfig)) {

        List<String> masterAddr = jedis.sentinelGetMasterAddrByName(masterName);

        // connected to sentinel...
        sentinelAvailable = true;

        if (masterAddr == null || masterAddr.size() != 2) {
          LOG.warn("Sentinel {} is not monitoring master {}.", sentinel, masterName);
          continue;
        }

        master = toHostAndPort(masterAddr);
        LOG.debug("Redis master reported at {}.", master);
        break;
      } catch (JedisException e) {
        // resolves #1036, it should handle JedisException there's another chance
        // of raising JedisDataException
        LOG.warn("Could not get master address from {}.", sentinel, e);
      }
    }

    if (master == null) {
      if (sentinelAvailable) {
        // can connect to sentinel, but master name seems to not monitored
        throw new JedisException(
                "Can connect to sentinel, but " + masterName + " seems to be not monitored.");
      } else {
        throw new JedisConnectionException(
                "All sentinels down, cannot determine where " + masterName + " is running.");
      }
    }

    LOG.info("Redis master running at {}. Starting sentinel listeners...", master);

    for (HostAndPort sentinel : sentinels) {

      SentinelListener listener = new SentinelListener(sentinel);
      // whether SentinelListener threads are alive or not, process can be stopped
      listener.setDaemon(true);
      sentinelListeners.add(listener);
      listener.start();
    }

    return master;
  }


  // M1146
  private <T> T doExecuteCommand(CommandObject<T> commandObject, boolean toReplica) {
    Instant deadline = Instant.now().plus(maxTotalRetriesDuration);

    JedisRedirectionException redirect = null;
    int consecutiveConnectionFailures = 0;
    Exception lastException = null;
    for (int attemptsLeft = this.maxAttempts; attemptsLeft > 0; attemptsLeft--) {
      Connection connection = null;
      try {
        if (redirect != null) {
          connection = provider.getConnection(redirect.getTargetNode());
          if (redirect instanceof JedisAskDataException) {
            // TODO: Pipeline asking with the original command to make it faster....
            connection.executeCommand(Protocol.Command.ASKING);
          }
        } else {
          connection = toReplica ? provider.getReplicaConnection(commandObject.getArguments())
                  : provider.getConnection(commandObject.getArguments());
        }

        return execute(connection, commandObject);

      } catch (JedisClusterOperationException jnrcne) {
        throw jnrcne;
      } catch (JedisConnectionException jce) {
        lastException = jce;
        ++consecutiveConnectionFailures;
        log.debug("Failed connecting to Redis: {}", connection, jce);
        // "- 1" because we just did one, but the attemptsLeft counter hasn't been decremented yet
        boolean reset = handleConnectionProblem(attemptsLeft - 1, consecutiveConnectionFailures, deadline);
        if (reset) {
          consecutiveConnectionFailures = 0;
          redirect = null;
        }
      } catch (JedisRedirectionException jre) {
        // avoid updating lastException if it is a connection exception
        if (lastException == null || lastException instanceof JedisRedirectionException) {
          lastException = jre;
        }
        log.debug("Redirected by server to {}", jre.getTargetNode());
        consecutiveConnectionFailures = 0;
        redirect = jre;
        // if MOVED redirection occurred,
        if (jre instanceof JedisMovedDataException) {
          // it rebuilds cluster's slot cache recommended by Redis cluster specification
          provider.renewSlotCache(connection);
        }
      } finally {
        IOUtils.closeQuietly(connection);
      }
      if (Instant.now().isAfter(deadline)) {
        throw new JedisClusterOperationException("Cluster retry deadline exceeded.", lastException);
      }
    }

    JedisClusterOperationException maxAttemptsException
            = new JedisClusterOperationException("No more cluster attempts left.");
    maxAttemptsException.addSuppressed(lastException);
    throw maxAttemptsException;
  }

}
