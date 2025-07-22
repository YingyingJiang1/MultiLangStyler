  @Override
  public CacheEntry set(CacheKey cacheKey, CacheEntry entry) {
    lock.lock();
    try {
      entry = putIntoStore(cacheKey, entry);
      EvictionPolicy policy = getEvictionPolicy();
      policy.touch(cacheKey);
      CacheKey evictedKey = policy.evictNext();
      if (evictedKey != null) {
        delete(evictedKey);
        stats.evict();
      }
      for (Object redisKey : cacheKey.getRedisKeys()) {
        ByteBuffer mapKey = makeKeyForRedisKeysToCacheKeys(redisKey);
        if (redisKeysToCacheKeys.containsKey(mapKey)) {
          redisKeysToCacheKeys.get(mapKey).add(cacheKey);
        } else {
          Set<CacheKey<?>> set = ConcurrentHashMap.newKeySet();
          set.add(cacheKey);
          redisKeysToCacheKeys.put(mapKey, set);
        }
      }
      stats.load();
      return entry;
    } finally {
      lock.unlock();
    }
  }
