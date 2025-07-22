    private Object buildNoModel(Map<Integer, ReadCellData<?>> cellDataMap, ReadSheetHolder readSheetHolder,
        AnalysisContext context) {
        int index = 0;
        Map<Integer, Object> map = MapUtils.newLinkedHashMapWithExpectedSize(cellDataMap.size());
        for (Map.Entry<Integer, ReadCellData<?>> entry : cellDataMap.entrySet()) {
            Integer key = entry.getKey();
            ReadCellData<?> cellData = entry.getValue();
            while (index < key) {
                map.put(index, null);
                index++;
            }
            index++;

            ReadDefaultReturnEnum readDefaultReturn = context.readWorkbookHolder().getReadDefaultReturn();
            if (readDefaultReturn == ReadDefaultReturnEnum.STRING) {
                // string
                map.put(key,
                    (String)ConverterUtils.convertToJavaObject(cellData, null, null, readSheetHolder.converterMap(),
                        context, context.readRowHolder().getRowIndex(), key));
            } else {
                // retrun ReadCellData
                ReadCellData<?> convertedReadCellData = convertReadCellData(cellData,
                    context.readWorkbookHolder().getReadDefaultReturn(), readSheetHolder, context, key);
                if (readDefaultReturn == ReadDefaultReturnEnum.READ_CELL_DATA) {
                    map.put(key, convertedReadCellData);
                } else {
                    map.put(key, convertedReadCellData.getData());
                }
            }
        }
        // fix https://github.com/alibaba/easyexcel/issues/2014
        int headSize = calculateHeadSize(readSheetHolder);
        while (index < headSize) {
            map.put(index, null);
            index++;
        }
        return map;
    }
