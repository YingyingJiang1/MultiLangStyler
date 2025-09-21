    public void start() throws Exception {
        // Configure SSL.
        final SslContext sslCtx;
        if (ssl) {
            SelfSignedCertificate ssc = new SelfSignedCertificate();
            sslCtx = SslContextBuilder.forServer(ssc.certificate(), ssc.privateKey()).build();
        } else {
            sslCtx = null;
        }

        ServerBootstrap b = new ServerBootstrap();
        b.group(bossGroup, workerGroup).channel(NioServerSocketChannel.class).handler(new LoggingHandler(LogLevel.INFO))
                .childHandler(new TunnelSocketServerInitializer(this, sslCtx));

        if (StringUtils.isBlank(host)) {
            channel = b.bind(port).sync().channel();
        } else {
            channel = b.bind(host, port).sync().channel();
        }

        logger.info("Tunnel server listen at {}:{}", host, port);

        workerGroup.scheduleWithFixedDelay(new Runnable() {
            @Override
            public void run() {
                agentInfoMap.entrySet().removeIf(e -> !e.getValue().getChannelHandlerContext().channel().isActive());
                clientConnectionInfoMap.entrySet()
                        .removeIf(e -> !e.getValue().getChannelHandlerContext().channel().isActive());

                // 更新集群key信息
                if (tunnelClusterStore != null && clientConnectHost != null) {
                    try {
                        for (Entry<String, AgentInfo> entry : agentInfoMap.entrySet()) {
                            tunnelClusterStore.addAgent(entry.getKey(), new AgentClusterInfo(entry.getValue(), clientConnectHost, port), 60 * 60, TimeUnit.SECONDS);
                        }
                    } catch (Throwable t) {
                        logger.error("update tunnel info error", t);
                    }
                }
            }

        }, 60, 60, TimeUnit.SECONDS);
    }
