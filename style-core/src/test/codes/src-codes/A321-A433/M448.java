    private static void writeThreadPoolMetrics(final HystrixThreadPoolMetrics threadPoolMetrics, JsonGenerator json) throws IOException {
        HystrixThreadPoolKey key = threadPoolMetrics.getThreadPoolKey();

        json.writeStartObject();

        json.writeStringField("type", "HystrixThreadPool");
        json.writeStringField("name", key.name());
        json.writeNumberField("currentTime", System.currentTimeMillis());

        json.writeNumberField("currentActiveCount", threadPoolMetrics.getCurrentActiveCount().intValue());
        json.writeNumberField("currentCompletedTaskCount", threadPoolMetrics.getCurrentCompletedTaskCount().longValue());
        json.writeNumberField("currentCorePoolSize", threadPoolMetrics.getCurrentCorePoolSize().intValue());
        json.writeNumberField("currentLargestPoolSize", threadPoolMetrics.getCurrentLargestPoolSize().intValue());
        json.writeNumberField("currentMaximumPoolSize", threadPoolMetrics.getCurrentMaximumPoolSize().intValue());
        json.writeNumberField("currentPoolSize", threadPoolMetrics.getCurrentPoolSize().intValue());
        json.writeNumberField("currentQueueSize", threadPoolMetrics.getCurrentQueueSize().intValue());
        json.writeNumberField("currentTaskCount", threadPoolMetrics.getCurrentTaskCount().longValue());
        safelyWriteNumberField(json, "rollingCountThreadsExecuted", new Func0<Long>() {
            @Override
            public Long call() {
                return threadPoolMetrics.getRollingCount(HystrixEventType.ThreadPool.EXECUTED);
            }
        });
        json.writeNumberField("rollingMaxActiveThreads", threadPoolMetrics.getRollingMaxActiveThreads());
        safelyWriteNumberField(json, "rollingCountCommandRejections", new Func0<Long>() {
            @Override
            public Long call() {
                return threadPoolMetrics.getRollingCount(HystrixEventType.ThreadPool.REJECTED);
            }
        });

        json.writeNumberField("propertyValue_queueSizeRejectionThreshold", threadPoolMetrics.getProperties().queueSizeRejectionThreshold().get());
        json.writeNumberField("propertyValue_metricsRollingStatisticalWindowInMilliseconds", threadPoolMetrics.getProperties().metricsRollingStatisticalWindowInMilliseconds().get());

        json.writeNumberField("reportingHosts", 1); // this will get summed across all instances in a cluster

        json.writeEndObject();
    }
