class Main {
    // M1356
    public static String nullSafeToString(double[] array) {
        if (array == null) {
            return "null";
        } else {
            int length = array.length;
            if (length == 0) {
                return "{}";
            } else {
                StringBuilder sb = new StringBuilder("{");

                for (int i = 0; i < length; ++i) {
                    if (i > 0) {
                        sb.append(", ");
                    }

                    sb.append(array[i]);
                }

                sb.append("}");
                return sb.toString();
            }
        }
    }


    // M140
    void _processDo(int option) throws IOException {
        if (debugoptions) {
            System.err.println("RECEIVED DO: "
                    + TelnetOption.getOption(option));
        }

        if (__notifhand != null) {
            __notifhand.receivedNegotiation(
                    TelnetNotificationHandler.RECEIVED_DO,
                    option);
        }

        boolean acceptNewState = false;


        /* open TelnetOptionHandler functionality (start)*/
        if (optionHandlers[option] != null) {
            acceptNewState = optionHandlers[option].getAcceptLocal();
        } else {
            /* open TelnetOptionHandler functionality (end)*/
            /* TERMINAL-TYPE option (start)*/
            if (option == TERMINAL_TYPE) {
                if ((terminalType != null) && (terminalType.length() > 0)) {
                    acceptNewState = true;
                }
            }
            /* TERMINAL-TYPE option (end)*/
            /* open TelnetOptionHandler functionality (start)*/
        }
        /* open TelnetOptionHandler functionality (end)*/

        if (_willResponse[option] > 0) {
            --_willResponse[option];
            if (_willResponse[option] > 0 && _stateIsWill(option)) {
                --_willResponse[option];
            }
        }

        if (_willResponse[option] == 0) {
            if (_requestedWont(option)) {

                switch (option) {

                    default:
                        break;

                }


                if (acceptNewState) {
                    _setWantWill(option);
                    _sendWill(option);
                } else {
                    ++_willResponse[option];
                    _sendWont(option);
                }
            } else {
                // Other end has acknowledged option.

                switch (option) {

                    default:
                        break;

                }

            }
        }

        _setWill(option);
    }


    // M1324
    private void bind(Configure configure) throws Throwable {

        long start = System.currentTimeMillis();

        if (!isBindRef.compareAndSet(false, true)) {
            throw new IllegalStateException("already bind");
        }

        // init random port
        if (configure.getTelnetPort() != null && configure.getTelnetPort() == 0) {
            int newTelnetPort = SocketUtils.findAvailableTcpPort();
            configure.setTelnetPort(newTelnetPort);
            logger().info("generate random telnet port: " + newTelnetPort);
        }
        if (configure.getHttpPort() != null && configure.getHttpPort() == 0) {
            int newHttpPort = SocketUtils.findAvailableTcpPort();
            configure.setHttpPort(newHttpPort);
            logger().info("generate random http port: " + newHttpPort);
        }
        // try to find appName
        if (configure.getAppName() == null) {
            configure.setAppName(System.getProperty(ArthasConstants.PROJECT_NAME,
                    System.getProperty(ArthasConstants.SPRING_APPLICATION_NAME, null)));
        }

        try {
            if (configure.getTunnelServer() != null) {
                tunnelClient = new TunnelClient();
                tunnelClient.setAppName(configure.getAppName());
                tunnelClient.setId(configure.getAgentId());
                tunnelClient.setTunnelServerUrl(configure.getTunnelServer());
                tunnelClient.setVersion(ArthasBanner.version());
                ChannelFuture channelFuture = tunnelClient.start();
                channelFuture.await(10, TimeUnit.SECONDS);
            }
        } catch (Throwable t) {
            logger().error("start tunnel client error", t);
        }

        try {
            ShellServerOptions options = new ShellServerOptions()
                    .setInstrumentation(instrumentation)
                    .setPid(PidUtils.currentLongPid())
                    .setWelcomeMessage(ArthasBanner.welcome());
            if (configure.getSessionTimeout() != null) {
                options.setSessionTimeout(configure.getSessionTimeout() * 1000);
            }

            this.httpSessionManager = new HttpSessionManager();
            if (IPUtils.isAllZeroIP(configure.getIp()) && StringUtils.isBlank(configure.getPassword())) {
                // 当 listen 0.0.0.0 时，强制生成密码，防止被远程连接
                String errorMsg = "Listening on 0.0.0.0 is very dangerous! External users can connect to your machine! "
                        + "No password is currently configured. " + "Therefore, a default password is generated, "
                        + "and clients need to use the password to connect!";
                AnsiLog.error(errorMsg);
                configure.setPassword(StringUtils.randomString(64));
                AnsiLog.error("Generated arthas password: " + configure.getPassword());

                logger().error(errorMsg);
                logger().info("Generated arthas password: " + configure.getPassword());
            }

            this.securityAuthenticator = new SecurityAuthenticatorImpl(configure.getUsername(), configure.getPassword());

            shellServer = new ShellServerImpl(options);

            List<String> disabledCommands = new ArrayList<String>();
            if (configure.getDisabledCommands() != null) {
                String[] strings = StringUtils.tokenizeToStringArray(configure.getDisabledCommands(), ",");
                if (strings != null) {
                    disabledCommands.addAll(Arrays.asList(strings));
                }
            }
            BuiltinCommandPack builtinCommands = new BuiltinCommandPack(disabledCommands);
            List<CommandResolver> resolvers = new ArrayList<CommandResolver>();
            resolvers.add(builtinCommands);

            //worker group
            workerGroup = new NioEventLoopGroup(new DefaultThreadFactory("arthas-TermServer", true));

            // TODO: discover user provided command resolver
            if (configure.getTelnetPort() != null && configure.getTelnetPort() > 0) {
                logger().info("try to bind telnet server, host: {}, port: {}.", configure.getIp(), configure.getTelnetPort());
                shellServer.registerTermServer(new HttpTelnetTermServer(configure.getIp(), configure.getTelnetPort(),
                        options.getConnectionTimeout(), workerGroup, httpSessionManager));
            } else {
                logger().info("telnet port is {}, skip bind telnet server.", configure.getTelnetPort());
            }
            if (configure.getHttpPort() != null && configure.getHttpPort() > 0) {
                logger().info("try to bind http server, host: {}, port: {}.", configure.getIp(), configure.getHttpPort());
                shellServer.registerTermServer(new HttpTermServer(configure.getIp(), configure.getHttpPort(),
                        options.getConnectionTimeout(), workerGroup, httpSessionManager));
            } else {
                // listen local address in VM communication
                if (configure.getTunnelServer() != null) {
                    shellServer.registerTermServer(new HttpTermServer(configure.getIp(), configure.getHttpPort(),
                            options.getConnectionTimeout(), workerGroup, httpSessionManager));
                }
                logger().info("http port is {}, skip bind http server.", configure.getHttpPort());
            }

            for (CommandResolver resolver : resolvers) {
                shellServer.registerCommandResolver(resolver);
            }

            shellServer.listen(new BindHandler(isBindRef));
            if (!isBind()) {
                throw new IllegalStateException("Arthas failed to bind telnet or http port! Telnet port: "
                        + String.valueOf(configure.getTelnetPort()) + ", http port: "
                        + String.valueOf(configure.getHttpPort()));
            }

            //http api session manager
            sessionManager = new SessionManagerImpl(options, shellServer.getCommandManager(), shellServer.getJobController());
            //http api handler
            httpApiHandler = new HttpApiHandler(historyManager, sessionManager);

            logger().info("as-server listening on network={};telnet={};http={};timeout={};", configure.getIp(),
                    configure.getTelnetPort(), configure.getHttpPort(), options.getConnectionTimeout());

            // 异步回报启动次数
            if (configure.getStatUrl() != null) {
                logger().info("arthas stat url: {}", configure.getStatUrl());
            }
            UserStatUtil.setStatUrl(configure.getStatUrl());
            UserStatUtil.setAgentId(configure.getAgentId());
            UserStatUtil.arthasStart();

            try {
                SpyAPI.init();
            } catch (Throwable e) {
                // ignore
            }

            logger().info("as-server started in {} ms", System.currentTimeMillis() - start);
        } catch (Throwable e) {
            logger().error("Error during start as-server", e);
            destroy();
            throw e;
        }
    }
}

