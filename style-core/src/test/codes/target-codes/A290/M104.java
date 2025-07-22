    private void createCell(AnalysisCell analysisCell, FillConfig fillConfig,
        CellWriteHandlerContext cellWriteHandlerContext, RowWriteHandlerContext rowWriteHandlerContext) {
        Sheet cachedSheet = writeContext.writeSheetHolder().getCachedSheet();
        if (WriteTemplateAnalysisCellTypeEnum.COMMON.equals(analysisCell.getCellType())) {
            Row row = cachedSheet.getRow(analysisCell.getRowIndex());
            cellWriteHandlerContext.setRow(row);
            Cell cell = row.getCell(analysisCell.getColumnIndex());
            cellWriteHandlerContext.setCell(cell);
            rowWriteHandlerContext.setRow(row);
            rowWriteHandlerContext.setRowIndex(analysisCell.getRowIndex());
            return;
        }
        Sheet sheet = writeContext.writeSheetHolder().getSheet();

        Map<AnalysisCell, Integer> collectionLastIndexMap = collectionLastIndexCache
            .computeIfAbsent(currentUniqueDataFlag, key -> MapUtils.newHashMap());

        boolean isOriginalCell = false;
        Integer lastRowIndex;
        Integer lastColumnIndex;
        switch (fillConfig.getDirection()) {
            case VERTICAL:
                lastRowIndex = collectionLastIndexMap.get(analysisCell);
                if (lastRowIndex == null) {
                    lastRowIndex = analysisCell.getRowIndex();
                    collectionLastIndexMap.put(analysisCell, lastRowIndex);
                    isOriginalCell = true;
                } else {
                    collectionLastIndexMap.put(analysisCell, ++lastRowIndex);
                }
                lastColumnIndex = analysisCell.getColumnIndex();
                break;
            case HORIZONTAL:
                lastRowIndex = analysisCell.getRowIndex();
                lastColumnIndex = collectionLastIndexMap.get(analysisCell);
                if (lastColumnIndex == null) {
                    lastColumnIndex = analysisCell.getColumnIndex();
                    collectionLastIndexMap.put(analysisCell, lastColumnIndex);
                    isOriginalCell = true;
                } else {
                    collectionLastIndexMap.put(analysisCell, ++lastColumnIndex);
                }
                break;
            default:
                throw new ExcelGenerateException("The wrong direction.");
        }

        Row row = createRowIfNecessary(sheet, cachedSheet, lastRowIndex, fillConfig, analysisCell, isOriginalCell,
            rowWriteHandlerContext);
        cellWriteHandlerContext.setRow(row);

        cellWriteHandlerContext.setRowIndex(lastRowIndex);
        cellWriteHandlerContext.setColumnIndex(lastColumnIndex);
        Cell cell = createCellIfNecessary(row, lastColumnIndex, cellWriteHandlerContext);
        cellWriteHandlerContext.setCell(cell);

        if (isOriginalCell) {
            Map<AnalysisCell, CellStyle> collectionFieldStyleMap = collectionFieldStyleCache.computeIfAbsent(
                currentUniqueDataFlag, key -> MapUtils.newHashMap());
            collectionFieldStyleMap.put(analysisCell, cell.getCellStyle());
        }
    }
