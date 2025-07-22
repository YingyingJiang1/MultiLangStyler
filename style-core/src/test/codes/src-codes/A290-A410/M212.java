    private Format getFormat(Double data, Short dataFormat, String dataFormatString) {

        // Might be better to separate out the n p and z formats, falling back to p when n and z are not set.
        // That however would require other code to be re factored.
        // String[] formatBits = formatStrIn.split(";");
        // int i = cellValue > 0.0 ? 0 : cellValue < 0.0 ? 1 : 2;
        // String formatStr = (i < formatBits.length) ? formatBits[i] : formatBits[0];
        String formatStr = dataFormatString;

        // Excel supports 2+ part conditional data formats, eg positive/negative/zero,
        //  or (>1000),(>0),(0),(negative). As Java doesn't handle these kinds
        //  of different formats for different ranges, just +ve/-ve, we need to
        //  handle these ourselves in a special way.
        // For now, if we detect 2+ parts, we call out to CellFormat to handle it
        // TODO Going forward, we should really merge the logic between the two classes
        if (formatStr.contains(";") &&
            (formatStr.indexOf(';') != formatStr.lastIndexOf(';')
                || rangeConditionalPattern.matcher(formatStr).matches()
            )) {
            try {
                // Ask CellFormat to get a formatter for it
                CellFormat cfmt = CellFormat.getInstance(locale, formatStr);
                // CellFormat requires callers to identify date vs not, so do so
                Object cellValueO = data;
                if (DateUtils.isADateFormat(dataFormat, formatStr) &&
                    // don't try to handle Date value 0, let a 3 or 4-part format take care of it
                    data.doubleValue() != 0.0) {
                    cellValueO = DateUtils.getJavaDate(data, use1904windowing);
                }
                // Wrap and return (non-cachable - CellFormat does that)
                return new CellFormatResultWrapper(cfmt.apply(cellValueO));
            } catch (Exception e) {
                LOGGER.warn("Formatting failed for format {}, falling back", formatStr, e);
            }
        }

        // See if we already have it cached
        Format format = formats.get(formatStr);
        if (format != null) {
            return format;
        }

        // Is it one of the special built in types, General or @?
        if ("General".equalsIgnoreCase(formatStr) || "@".equals(formatStr)) {
            format = getDefaultFormat();
            addFormat(formatStr, format);
            return format;
        }

        // Build a formatter, and cache it
        format = createFormat(dataFormat, formatStr);
        addFormat(formatStr, format);
        return format;
    }
