    public Map<ExecutionSignature, List<Integer>> getExecutionsMappedToLatencies() {
        Map<CommandAndCacheKey, Integer> cachingDetector = new HashMap<CommandAndCacheKey, Integer>();
        List<HystrixInvokableInfo<?>> nonCachedExecutions = new ArrayList<HystrixInvokableInfo<?>>(executions.size());
        for (HystrixInvokableInfo<?> execution: executions) {
            if (execution.getPublicCacheKey() != null) {
                //eligible for caching - might be the initial, or might be from cache
                CommandAndCacheKey key = new CommandAndCacheKey(execution.getCommandKey().name(), execution.getPublicCacheKey());
                Integer count = cachingDetector.get(key);
                if (count != null) {
                    //key already seen
                    cachingDetector.put(key, count + 1);
                } else {
                    //key not seen yet
                    cachingDetector.put(key, 0);
                }
            }
            if (!execution.isResponseFromCache()) {
                nonCachedExecutions.add(execution);
            }
        }

        Map<ExecutionSignature, List<Integer>> commandDeduper = new HashMap<ExecutionSignature, List<Integer>>();
        for (HystrixInvokableInfo<?> execution: nonCachedExecutions) {
            int cachedCount = 0;
            String cacheKey = execution.getPublicCacheKey();
            if (cacheKey != null) {
                CommandAndCacheKey key = new CommandAndCacheKey(execution.getCommandKey().name(), cacheKey);
                cachedCount = cachingDetector.get(key);
            }
            ExecutionSignature signature;
            if (cachedCount > 0) {
                //this has a RESPONSE_FROM_CACHE and needs to get split off
                signature = ExecutionSignature.from(execution, cacheKey, cachedCount);
            } else {
                //nothing cached from this, can collapse further
                signature = ExecutionSignature.from(execution);
            }
            List<Integer> currentLatencyList = commandDeduper.get(signature);
            if (currentLatencyList != null) {
                currentLatencyList.add(execution.getExecutionTimeInMilliseconds());
            } else {
                List<Integer> newLatencyList = new ArrayList<Integer>();
                newLatencyList.add(execution.getExecutionTimeInMilliseconds());
                commandDeduper.put(signature, newLatencyList);
            }
        }

        return commandDeduper;
    }
