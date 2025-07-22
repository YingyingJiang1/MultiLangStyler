    public CellStyle createCellStyle(WriteCellStyle writeCellStyle, CellStyle originCellStyle) {
        if (writeCellStyle == null) {
            return originCellStyle;
        }

        short styleIndex = -1;
        Font originFont = null;
        boolean useCache = true;
        if (originCellStyle != null) {
            styleIndex = originCellStyle.getIndex();
            if (originCellStyle instanceof XSSFCellStyle) {
                originFont = ((XSSFCellStyle)originCellStyle).getFont();
            } else if (originCellStyle instanceof HSSFCellStyle) {
                originFont = ((HSSFCellStyle)originCellStyle).getFont(workbook);
            }
            useCache = false;
        }

        Map<WriteCellStyle, CellStyle> cellStyleMap = cellStyleIndexMap.computeIfAbsent(styleIndex,
            key -> MapUtils.newHashMap());
        CellStyle cellStyle = cellStyleMap.get(writeCellStyle);
        if (cellStyle != null) {
            return cellStyle;
        }
        if (log.isDebugEnabled()) {
            log.info("create new style:{},{}", writeCellStyle, originCellStyle);
        }
        WriteCellStyle tempWriteCellStyle = new WriteCellStyle();
        WriteCellStyle.merge(writeCellStyle, tempWriteCellStyle);

        cellStyle = StyleUtil.buildCellStyle(workbook, originCellStyle, tempWriteCellStyle);
        Short dataFormat = createDataFormat(tempWriteCellStyle.getDataFormatData(), useCache);
        if (dataFormat != null) {
            cellStyle.setDataFormat(dataFormat);
        }
        Font font = createFont(tempWriteCellStyle.getWriteFont(), originFont, useCache);
        if (font != null) {
            cellStyle.setFont(font);
        }
        cellStyleMap.put(tempWriteCellStyle, cellStyle);
        return cellStyle;
    }
