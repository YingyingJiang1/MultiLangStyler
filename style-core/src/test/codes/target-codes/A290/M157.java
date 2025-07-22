    public static FontProperty build(ContentFontStyle contentFontStyle) {
        if (contentFontStyle == null) {
            return null;
        }
        FontProperty styleProperty = new FontProperty();
        if (StringUtils.isNotBlank(contentFontStyle.fontName())) {
            styleProperty.setFontName(contentFontStyle.fontName());
        }
        if (contentFontStyle.fontHeightInPoints() >= 0) {
            styleProperty.setFontHeightInPoints(contentFontStyle.fontHeightInPoints());
        }
        styleProperty.setItalic(contentFontStyle.italic().getBooleanValue());
        styleProperty.setStrikeout(contentFontStyle.strikeout().getBooleanValue());
        if (contentFontStyle.color() >= 0) {
            styleProperty.setColor(contentFontStyle.color());
        }
        if (contentFontStyle.typeOffset() >= 0) {
            styleProperty.setTypeOffset(contentFontStyle.typeOffset());
        }
        if (contentFontStyle.underline() >= 0) {
            styleProperty.setUnderline(contentFontStyle.underline());
        }
        if (contentFontStyle.charset() >= 0) {
            styleProperty.setCharset(contentFontStyle.charset());
        }
        styleProperty.setBold(contentFontStyle.bold().getBooleanValue());
        return styleProperty;
    }
