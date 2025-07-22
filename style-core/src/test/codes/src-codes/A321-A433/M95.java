    public static HealthCountsStream getInstance(HystrixCommandKey commandKey, int numBuckets, int bucketSizeInMs) {
        HealthCountsStream initialStream = streams.get(commandKey.name());
        if (initialStream != null) {
            return initialStream;
        } else {
            final HealthCountsStream healthStream;
            synchronized (HealthCountsStream.class) {
                HealthCountsStream existingStream = streams.get(commandKey.name());
                if (existingStream == null) {
                    HealthCountsStream newStream = new HealthCountsStream(commandKey, numBuckets, bucketSizeInMs,
                            HystrixCommandMetrics.appendEventToBucket);

                    streams.putIfAbsent(commandKey.name(), newStream);
                    healthStream = newStream;
                } else {
                    healthStream = existingStream;
                }
            }
            healthStream.startCachingStreamValuesIfUnstarted();
            return healthStream;
        }
    }
