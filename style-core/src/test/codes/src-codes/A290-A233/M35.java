    private static void buildStyleProperty(StyleProperty styleProperty, WriteCellStyle writeCellStyle) {
        if (styleProperty == null) {
            return;
        }
        if (styleProperty.getDataFormatData() != null) {
            if (writeCellStyle.getDataFormatData() == null) {
                writeCellStyle.setDataFormatData(styleProperty.getDataFormatData());
            } else {
                DataFormatData.merge(styleProperty.getDataFormatData(), writeCellStyle.getDataFormatData());
            }
        }
        if (styleProperty.getHidden() != null) {
            writeCellStyle.setHidden(styleProperty.getHidden());
        }
        if (styleProperty.getLocked() != null) {
            writeCellStyle.setLocked(styleProperty.getLocked());
        }
        if (styleProperty.getQuotePrefix() != null) {
            writeCellStyle.setQuotePrefix(styleProperty.getQuotePrefix());
        }
        if (styleProperty.getHorizontalAlignment() != null) {
            writeCellStyle.setHorizontalAlignment(styleProperty.getHorizontalAlignment());
        }
        if (styleProperty.getWrapped() != null) {
            writeCellStyle.setWrapped(styleProperty.getWrapped());
        }
        if (styleProperty.getVerticalAlignment() != null) {
            writeCellStyle.setVerticalAlignment(styleProperty.getVerticalAlignment());
        }
        if (styleProperty.getRotation() != null) {
            writeCellStyle.setRotation(styleProperty.getRotation());
        }
        if (styleProperty.getIndent() != null) {
            writeCellStyle.setIndent(styleProperty.getIndent());
        }
        if (styleProperty.getBorderLeft() != null) {
            writeCellStyle.setBorderLeft(styleProperty.getBorderLeft());
        }
        if (styleProperty.getBorderRight() != null) {
            writeCellStyle.setBorderRight(styleProperty.getBorderRight());
        }
        if (styleProperty.getBorderTop() != null) {
            writeCellStyle.setBorderTop(styleProperty.getBorderTop());
        }
        if (styleProperty.getBorderBottom() != null) {
            writeCellStyle.setBorderBottom(styleProperty.getBorderBottom());
        }
        if (styleProperty.getLeftBorderColor() != null) {
            writeCellStyle.setLeftBorderColor(styleProperty.getLeftBorderColor());
        }
        if (styleProperty.getRightBorderColor() != null) {
            writeCellStyle.setRightBorderColor(styleProperty.getRightBorderColor());
        }
        if (styleProperty.getTopBorderColor() != null) {
            writeCellStyle.setTopBorderColor(styleProperty.getTopBorderColor());
        }
        if (styleProperty.getBottomBorderColor() != null) {
            writeCellStyle.setBottomBorderColor(styleProperty.getBottomBorderColor());
        }
        if (styleProperty.getFillPatternType() != null) {
            writeCellStyle.setFillPatternType(styleProperty.getFillPatternType());
        }
        if (styleProperty.getFillBackgroundColor() != null) {
            writeCellStyle.setFillBackgroundColor(styleProperty.getFillBackgroundColor());
        }
        if (styleProperty.getFillForegroundColor() != null) {
            writeCellStyle.setFillForegroundColor(styleProperty.getFillForegroundColor());
        }
        if (styleProperty.getShrinkToFit() != null) {
            writeCellStyle.setShrinkToFit(styleProperty.getShrinkToFit());
        }

    }
