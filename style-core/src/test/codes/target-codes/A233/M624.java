    public static boolean checkForStandard(PDDocument document, String standardKeyword) {
        // Check XMP Metadata
        try {
            PDMetadata pdMetadata = document.getDocumentCatalog().getMetadata();
            if (pdMetadata != null) {
                try (COSInputStream metaStream = pdMetadata.createInputStream()) {
                    // First try to read raw metadata as string to check for standard keywords
                    byte[] metadataBytes = metaStream.readAllBytes();
                    String rawMetadata = new String(metadataBytes, StandardCharsets.UTF_8);

                    if (rawMetadata.contains(standardKeyword)) {
                        return true;
                    }
                }

                // If raw check doesn't find it, try parsing with XMP parser
                try (COSInputStream metaStream = pdMetadata.createInputStream()) {
                    try {
                        DomXmpParser domXmpParser = new DomXmpParser();
                        XMPMetadata xmpMeta = domXmpParser.parse(metaStream);

                        ByteArrayOutputStream baos = new ByteArrayOutputStream();
                        new XmpSerializer().serialize(xmpMeta, baos, true);
                        String xmpString = new String(baos.toByteArray(), StandardCharsets.UTF_8);

                        if (xmpString.contains(standardKeyword)) {
                            return true;
                        }
                    } catch (XmpParsingException e) {
                        // XMP parsing failed, but we already checked raw metadata above
                        log.debug(
                                "XMP parsing failed for standard check, but raw metadata was already checked: {}",
                                e.getMessage());
                    }
                }
            }
        } catch (Exception e) {
            ExceptionUtils.logException("PDF standard checking", e);
        }

        return false;
    }
