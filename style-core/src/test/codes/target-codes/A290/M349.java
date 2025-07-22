    private static Map<String, ExcelContentProperty> declaredFieldContentMap(Class<?> clazz,
        ConfigurationHolder configurationHolder) {
        if (clazz == null) {
            return null;
        }
        switch (configurationHolder.globalConfiguration().getFiledCacheLocation()) {
            case THREAD_LOCAL:
                Map<Class<?>, Map<String, ExcelContentProperty>> classContentCacheMap
                    = CLASS_CONTENT_THREAD_LOCAL.get();
                if (classContentCacheMap == null) {
                    classContentCacheMap = MapUtils.newHashMap();
                    CLASS_CONTENT_THREAD_LOCAL.set(classContentCacheMap);
                }
                return classContentCacheMap.computeIfAbsent(clazz, key -> {
                    return doDeclaredFieldContentMap(clazz);
                });
            case MEMORY:
                return CLASS_CONTENT_CACHE.computeIfAbsent(clazz, key -> {
                    return doDeclaredFieldContentMap(clazz);
                });
            case NONE:
                return doDeclaredFieldContentMap(clazz);
            default:
                throw new UnsupportedOperationException("unsupported enum");
        }

    }
