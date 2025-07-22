    public ThreadPoolExecutor getThreadPool(final HystrixThreadPoolKey threadPoolKey, HystrixThreadPoolProperties threadPoolProperties) {
        final ThreadFactory threadFactory = getThreadFactory(threadPoolKey);

        final boolean allowMaximumSizeToDivergeFromCoreSize = threadPoolProperties.getAllowMaximumSizeToDivergeFromCoreSize().get();
        final int dynamicCoreSize = threadPoolProperties.coreSize().get();
        final int keepAliveTime = threadPoolProperties.keepAliveTimeMinutes().get();
        final int maxQueueSize = threadPoolProperties.maxQueueSize().get();
        final BlockingQueue<Runnable> workQueue = getBlockingQueue(maxQueueSize);

        if (allowMaximumSizeToDivergeFromCoreSize) {
            final int dynamicMaximumSize = threadPoolProperties.maximumSize().get();
            if (dynamicCoreSize > dynamicMaximumSize) {
                logger.error("Hystrix ThreadPool configuration at startup for : " + threadPoolKey.name() + " is trying to set coreSize = " +
                        dynamicCoreSize + " and maximumSize = " + dynamicMaximumSize + ".  Maximum size will be set to " +
                        dynamicCoreSize + ", the coreSize value, since it must be equal to or greater than the coreSize value");
                return new ThreadPoolExecutor(dynamicCoreSize, dynamicCoreSize, keepAliveTime, TimeUnit.MINUTES, workQueue, threadFactory);
            } else {
                return new ThreadPoolExecutor(dynamicCoreSize, dynamicMaximumSize, keepAliveTime, TimeUnit.MINUTES, workQueue, threadFactory);
            }
        } else {
            return new ThreadPoolExecutor(dynamicCoreSize, dynamicCoreSize, keepAliveTime, TimeUnit.MINUTES, workQueue, threadFactory);
        }
    }
