    private void sanitizeJavaScript(PDDocument document) throws IOException {
        // Get the root dictionary (catalog) of the PDF
        PDDocumentCatalog catalog = document.getDocumentCatalog();

        // Get the Names dictionary
        COSDictionary namesDict =
                (COSDictionary) catalog.getCOSObject().getDictionaryObject(COSName.NAMES);

        if (namesDict != null) {
            // Get the JavaScript dictionary
            COSDictionary javaScriptDict =
                    (COSDictionary) namesDict.getDictionaryObject(COSName.getPDFName("JavaScript"));

            if (javaScriptDict != null) {
                // Remove the JavaScript dictionary
                namesDict.removeItem(COSName.getPDFName("JavaScript"));
            }
        }

        for (PDPage page : document.getPages()) {
            for (PDAnnotation annotation : page.getAnnotations()) {
                if (annotation instanceof PDAnnotationWidget widget) {
                    PDAction action = widget.getAction();
                    if (action instanceof PDActionJavaScript) {
                        widget.setAction(null);
                    }
                }
            }
            PDAcroForm acroForm = document.getDocumentCatalog().getAcroForm();
            if (acroForm != null) {
                for (PDField field : acroForm.getFields()) {
                    PDFormFieldAdditionalActions actions = field.getActions();
                    if (actions != null) {
                        if (actions.getC() instanceof PDActionJavaScript) {
                            actions.setC(null);
                        }
                        if (actions.getF() instanceof PDActionJavaScript) {
                            actions.setF(null);
                        }
                        if (actions.getK() instanceof PDActionJavaScript) {
                            actions.setK(null);
                        }
                        if (actions.getV() instanceof PDActionJavaScript) {
                            actions.setV(null);
                        }
                    }
                }
            }
        }
    }
