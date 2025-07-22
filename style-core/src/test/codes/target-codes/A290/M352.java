    private static FieldCache doDeclaredFields(Class<?> clazz, ConfigurationHolder configurationHolder) {
        List<Field> tempFieldList = new ArrayList<>();
        Class<?> tempClass = clazz;
        // When the parent class is null, it indicates that the parent class (Object class) has reached the top
        // level.
        while (tempClass != null) {
            Collections.addAll(tempFieldList, tempClass.getDeclaredFields());
            // Get the parent class and give it to yourself
            tempClass = tempClass.getSuperclass();
        }
        // Screening of field
        Map<Integer, List<FieldWrapper>> orderFieldMap = new TreeMap<>();
        Map<Integer, FieldWrapper> indexFieldMap = new TreeMap<>();
        Set<String> ignoreSet = new HashSet<>();

        ExcelIgnoreUnannotated excelIgnoreUnannotated = clazz.getAnnotation(ExcelIgnoreUnannotated.class);
        for (Field field : tempFieldList) {
            declaredOneField(field, orderFieldMap, indexFieldMap, ignoreSet, excelIgnoreUnannotated);
        }
        Map<Integer, FieldWrapper> sortedFieldMap = buildSortedAllFieldMap(orderFieldMap, indexFieldMap);
        FieldCache fieldCache = new FieldCache(sortedFieldMap, indexFieldMap);

        if (!(configurationHolder instanceof WriteHolder)) {
            return fieldCache;
        }

        WriteHolder writeHolder = (WriteHolder)configurationHolder;

        boolean needIgnore = !CollectionUtils.isEmpty(writeHolder.excludeColumnFieldNames())
            || !CollectionUtils.isEmpty(writeHolder.excludeColumnIndexes())
            || !CollectionUtils.isEmpty(writeHolder.includeColumnFieldNames())
            || !CollectionUtils.isEmpty(writeHolder.includeColumnIndexes());

        if (!needIgnore) {
            return fieldCache;
        }
        // ignore filed
        Map<Integer, FieldWrapper> tempSortedFieldMap = MapUtils.newHashMap();
        int index = 0;
        for (Map.Entry<Integer, FieldWrapper> entry : sortedFieldMap.entrySet()) {
            Integer key = entry.getKey();
            FieldWrapper field = entry.getValue();

            // The current field needs to be ignored
            if (writeHolder.ignore(field.getFieldName(), entry.getKey())) {
                ignoreSet.add(field.getFieldName());
                indexFieldMap.remove(index);
            } else {
                // Mandatory sorted fields
                if (indexFieldMap.containsKey(key)) {
                    tempSortedFieldMap.put(key, field);
                } else {
                    // Need to reorder automatically
                    // Check whether the current key is already in use
                    while (tempSortedFieldMap.containsKey(index)) {
                        index++;
                    }
                    tempSortedFieldMap.put(index++, field);
                }
            }
        }
        fieldCache.setSortedFieldMap(tempSortedFieldMap);

        // resort field
        resortField(writeHolder, fieldCache);
        return fieldCache;
    }
