    private void addJavaObjectToExcel(Object oneRowData, Row row, int rowIndex, int relativeRowIndex) {
        WriteHolder currentWriteHolder = writeContext.currentWriteHolder();
        BeanMap beanMap = BeanMapUtils.create(oneRowData);
        // Bean the contains of the Map Key method with poor performance,So to create a keySet here
        Set<String> beanKeySet = new HashSet<>(beanMap.keySet());
        Set<String> beanMapHandledSet = new HashSet<>();
        int maxCellIndex = -1;
        // If it's a class it needs to be cast by type
        if (HeadKindEnum.CLASS.equals(writeContext.currentWriteHolder().excelWriteHeadProperty().getHeadKind())) {
            Map<Integer, Head> headMap = writeContext.currentWriteHolder().excelWriteHeadProperty().getHeadMap();
            for (Map.Entry<Integer, Head> entry : headMap.entrySet()) {
                int columnIndex = entry.getKey();
                Head head = entry.getValue();
                String name = head.getFieldName();
                if (!beanKeySet.contains(name)) {
                    continue;
                }

                ExcelContentProperty excelContentProperty = ClassUtils.declaredExcelContentProperty(beanMap,
                    currentWriteHolder.excelWriteHeadProperty().getHeadClazz(), name, currentWriteHolder);
                CellWriteHandlerContext cellWriteHandlerContext = WriteHandlerUtils.createCellWriteHandlerContext(
                    writeContext, row, rowIndex, head, columnIndex, relativeRowIndex, Boolean.FALSE,
                    excelContentProperty);
                WriteHandlerUtils.beforeCellCreate(cellWriteHandlerContext);

                Cell cell = WorkBookUtil.createCell(row, columnIndex);
                cellWriteHandlerContext.setCell(cell);

                WriteHandlerUtils.afterCellCreate(cellWriteHandlerContext);

                cellWriteHandlerContext.setOriginalValue(beanMap.get(name));
                cellWriteHandlerContext.setOriginalFieldClass(head.getField().getType());
                converterAndSet(cellWriteHandlerContext);

                WriteHandlerUtils.afterCellDispose(cellWriteHandlerContext);

                beanMapHandledSet.add(name);
                maxCellIndex = Math.max(maxCellIndex, columnIndex);
            }
        }
        // Finish
        if (beanMapHandledSet.size() == beanMap.size()) {
            return;
        }
        maxCellIndex++;

        FieldCache fieldCache = ClassUtils.declaredFields(oneRowData.getClass(), writeContext.currentWriteHolder());
        for (Map.Entry<Integer, FieldWrapper> entry : fieldCache.getSortedFieldMap().entrySet()) {
            FieldWrapper field = entry.getValue();
            String fieldName = field.getFieldName();
            boolean uselessData = !beanKeySet.contains(fieldName) || beanMapHandledSet.contains(fieldName);
            if (uselessData) {
                continue;
            }
            Object value = beanMap.get(fieldName);
            ExcelContentProperty excelContentProperty = ClassUtils.declaredExcelContentProperty(beanMap,
                currentWriteHolder.excelWriteHeadProperty().getHeadClazz(), fieldName, currentWriteHolder);
            CellWriteHandlerContext cellWriteHandlerContext = WriteHandlerUtils.createCellWriteHandlerContext(
                writeContext, row, rowIndex, null, maxCellIndex, relativeRowIndex, Boolean.FALSE, excelContentProperty);
            WriteHandlerUtils.beforeCellCreate(cellWriteHandlerContext);

            // fix https://github.com/alibaba/easyexcel/issues/1870
            // If there is data, it is written to the next cell
            Cell cell = WorkBookUtil.createCell(row, maxCellIndex);
            cellWriteHandlerContext.setCell(cell);

            WriteHandlerUtils.afterCellCreate(cellWriteHandlerContext);

            cellWriteHandlerContext.setOriginalValue(value);
            cellWriteHandlerContext.setOriginalFieldClass(FieldUtils.getFieldClass(beanMap, fieldName, value));
            converterAndSet(cellWriteHandlerContext);

            WriteHandlerUtils.afterCellDispose(cellWriteHandlerContext);
            maxCellIndex++;
        }
    }
