    private void sequentialOverlay(
            Map<Integer, String> overlayGuide,
            File[] overlayFiles,
            int basePageCount,
            List<File> tempFiles)
            throws IOException {
        int overlayFileIndex = 0;
        int pageCountInCurrentOverlay = 0;

        for (int basePageIndex = 1; basePageIndex <= basePageCount; basePageIndex++) {
            if (pageCountInCurrentOverlay == 0
                    || pageCountInCurrentOverlay
                            >= getNumberOfPages(overlayFiles[overlayFileIndex])) {
                pageCountInCurrentOverlay = 0;
                overlayFileIndex = (overlayFileIndex + 1) % overlayFiles.length;
            }

            try (PDDocument overlayPdf = Loader.loadPDF(overlayFiles[overlayFileIndex])) {
                PDDocument singlePageDocument = new PDDocument();
                singlePageDocument.addPage(overlayPdf.getPage(pageCountInCurrentOverlay));
                File tempFile = Files.createTempFile("overlay-page-", ".pdf").toFile();
                singlePageDocument.save(tempFile);
                singlePageDocument.close();

                overlayGuide.put(basePageIndex, tempFile.getAbsolutePath());
                tempFiles.add(tempFile); // Keep track of the temporary file for cleanup
            }

            pageCountInCurrentOverlay++;
        }
    }
