    private static void buildFontProperty(FontProperty fontProperty, WriteCellStyle writeCellStyle) {
        if (fontProperty == null) {
            return;
        }
        if (writeCellStyle.getWriteFont() == null) {
            writeCellStyle.setWriteFont(new WriteFont());
        }
        WriteFont writeFont = writeCellStyle.getWriteFont();

        if (StringUtils.isNotBlank(fontProperty.getFontName())) {
            writeFont.setFontName(fontProperty.getFontName());
        }
        if (fontProperty.getFontHeightInPoints() != null) {
            writeFont.setFontHeightInPoints(fontProperty.getFontHeightInPoints());
        }
        if (fontProperty.getItalic() != null) {
            writeFont.setItalic(fontProperty.getItalic());
        }
        if (fontProperty.getStrikeout() != null) {
            writeFont.setStrikeout(fontProperty.getStrikeout());
        }
        if (fontProperty.getColor() != null) {
            writeFont.setColor(fontProperty.getColor());
        }
        if (fontProperty.getTypeOffset() != null) {
            writeFont.setTypeOffset(fontProperty.getTypeOffset());
        }
        if (fontProperty.getUnderline() != null) {
            writeFont.setUnderline(fontProperty.getUnderline());
        }
        if (fontProperty.getCharset() != null) {
            writeFont.setCharset(fontProperty.getCharset());
        }
        if (fontProperty.getBold() != null) {
            writeFont.setBold(fontProperty.getBold());
        }
    }
