    private List<Monitor<?>> getServoMonitors() {

        List<Monitor<?>> monitors = new ArrayList<Monitor<?>>();

        monitors.add(new InformationalMetric<String>(MonitorConfig.builder("name").build()) {
            @Override
            public String getValue() {
                return key.name();
            }
        });

        // allow Servo and monitor to know exactly at what point in time these stats are for so they can be plotted accurately
        monitors.add(new GaugeMetric(MonitorConfig.builder("currentTime").withTag(DataSourceLevel.DEBUG).build()) {
            @Override
            public Number getValue() {
                return System.currentTimeMillis();
            }
        });

        //collapser event cumulative metrics
        monitors.add(safelyGetCumulativeMonitor("countRequestsBatched", new Func0<HystrixEventType.Collapser>() {
            @Override
            public HystrixEventType.Collapser call() {
                return HystrixEventType.Collapser.ADDED_TO_BATCH;
            }
        }));
        monitors.add(safelyGetCumulativeMonitor("countBatches", new Func0<HystrixEventType.Collapser>() {
            @Override
            public HystrixEventType.Collapser call() {
                return HystrixEventType.Collapser.BATCH_EXECUTED;
            }
        }));
        monitors.add(safelyGetCumulativeMonitor("countResponsesFromCache", new Func0<HystrixEventType.Collapser>() {
            @Override
            public HystrixEventType.Collapser call() {
                return HystrixEventType.Collapser.RESPONSE_FROM_CACHE;
            }
        }));

        //batch size distribution metrics
        monitors.add(getBatchSizeMeanMonitor("batchSize_mean"));
        monitors.add(getBatchSizePercentileMonitor("batchSize_percentile_25", 25));
        monitors.add(getBatchSizePercentileMonitor("batchSize_percentile_50", 50));
        monitors.add(getBatchSizePercentileMonitor("batchSize_percentile_75", 75));
        monitors.add(getBatchSizePercentileMonitor("batchSize_percentile_95", 95));
        monitors.add(getBatchSizePercentileMonitor("batchSize_percentile_99", 99));
        monitors.add(getBatchSizePercentileMonitor("batchSize_percentile_99_5", 99.5));
        monitors.add(getBatchSizePercentileMonitor("batchSize_percentile_100", 100));

        //shard size distribution metrics
        monitors.add(getShardSizeMeanMonitor("shardSize_mean"));
        monitors.add(getShardSizePercentileMonitor("shardSize_percentile_25", 25));
        monitors.add(getShardSizePercentileMonitor("shardSize_percentile_50", 50));
        monitors.add(getShardSizePercentileMonitor("shardSize_percentile_75", 75));
        monitors.add(getShardSizePercentileMonitor("shardSize_percentile_95", 95));
        monitors.add(getShardSizePercentileMonitor("shardSize_percentile_99", 99));
        monitors.add(getShardSizePercentileMonitor("shardSize_percentile_99_5", 99.5));
        monitors.add(getShardSizePercentileMonitor("shardSize_percentile_100", 100));

        // properties (so the values can be inspected and monitored)
        monitors.add(new InformationalMetric<Number>(MonitorConfig.builder("propertyValue_rollingStatisticalWindowInMilliseconds").build()) {
            @Override
            public Number getValue() {
                return properties.metricsRollingStatisticalWindowInMilliseconds().get();
            }
        });

        monitors.add(new InformationalMetric<Boolean>(MonitorConfig.builder("propertyValue_requestCacheEnabled").build()) {
            @Override
            public Boolean getValue() {
                return properties.requestCacheEnabled().get();
            }
        });

        monitors.add(new InformationalMetric<Number>(MonitorConfig.builder("propertyValue_maxRequestsInBatch").build()) {
            @Override
            public Number getValue() {
                return properties.maxRequestsInBatch().get();
            }
        });

        monitors.add(new InformationalMetric<Number>(MonitorConfig.builder("propertyValue_timerDelayInMilliseconds").build()) {
            @Override
            public Number getValue() {
                return properties.timerDelayInMilliseconds().get();
            }
        });

        return monitors;
    }
