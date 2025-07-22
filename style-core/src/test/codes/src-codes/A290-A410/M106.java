    private Row createRowIfNecessary(Sheet sheet, Sheet cachedSheet, Integer lastRowIndex, FillConfig fillConfig,
        AnalysisCell analysisCell, boolean isOriginalCell, RowWriteHandlerContext rowWriteHandlerContext) {
        rowWriteHandlerContext.setRowIndex(lastRowIndex);
        Row row = sheet.getRow(lastRowIndex);
        if (row != null) {
            checkRowHeight(analysisCell, fillConfig, isOriginalCell, row);
            rowWriteHandlerContext.setRow(row);
            return row;
        }
        row = cachedSheet.getRow(lastRowIndex);
        if (row == null) {
            rowWriteHandlerContext.setRowIndex(lastRowIndex);
            WriteHandlerUtils.beforeRowCreate(rowWriteHandlerContext);

            if (fillConfig.getForceNewRow()) {
                row = cachedSheet.createRow(lastRowIndex);
            } else {
                // The last row of the middle disk inside empty rows, resulting in cachedSheet can not get inside.
                // Will throw Attempting to write a row[" + rownum + "] " + "in the range [0," + this._sh
                // .getLastRowNum() + "] that is already written to disk.
                try {
                    row = sheet.createRow(lastRowIndex);
                } catch (IllegalArgumentException ignore) {
                    row = cachedSheet.createRow(lastRowIndex);
                }
            }
            rowWriteHandlerContext.setRow(row);
            checkRowHeight(analysisCell, fillConfig, isOriginalCell, row);

            WriteHandlerUtils.afterRowCreate(rowWriteHandlerContext);
        } else {
            checkRowHeight(analysisCell, fillConfig, isOriginalCell, row);
            rowWriteHandlerContext.setRow(row);
        }
        return row;
    }
