
    @
        PostMapping(value = "/auto-split-pdf", consumes = "multipart/form-data") @Operation(summary = "Auto split PDF pages into separate documents", description = "This endpoint accepts a PDF file, scans each page for a specific QR code, and" + " splits the document at the QR code boundaries. The output is a zip file"
+ " containing each separate PDF document. Input:PDF Output:ZIP-PDF" + " Type:SISO") public ResponseEntity<byte[]> autoSplitPdf(@ModelAttribute AutoSplitPdfRequest request) throws IOException {
        MultipartFile file = request.getFileInput();
        boolean duplexMode = Boolean.TRUE.equals(request.getDuplexMode());
        PDDocument document = null;
        List<PDDocument> splitDocuments = new ArrayList< >();
        Path zipFile = null;
        byte[] data = null;
        try {
            document = pdfDocumentFactory.load(file.getInputStream());
            PDFRenderer pdfRenderer = new PDFRenderer(document);
            pdfRenderer.setSubsamplingAllowed(true);
            for(int page = 0; page < document.getNumberOfPages(); ++page) {
                BufferedImage bim = pdfRenderer.renderImageWithDPI(page, 150);
                String result = decodeQRCode(bim);
                boolean isValidQrCode = VALID_QR_CONTENTS.contains(result);
                log.debug("detected qr code {}, code is vale={}", result, isValidQrCode);
                if (isValidQrCode && page != 0) {
                    splitDocuments.add(new PDDocument());
                }

                if (!splitDocuments.isEmpty() && !isValidQrCode) {
                    splitDocuments.get(splitDocuments.size() - 1).addPage(document.getPage(page));
                } else if (page == 0) {
                           PDDocument firstDocument = new PDDocument();
                           firstDocument.addPage(document.getPage(page));
                           splitDocuments.add(firstDocument);
                       }

                // If duplexMode is true and current page is a divider, then skip next page

                if (duplexMode && isValidQrCode) {
                    page++;
                }
            }

            // Remove split documents that have no pages

            splitDocuments.removeIf(pdDocument->pdDocument.getNumberOfPages() == 0);
            zipFile = Files.createTempFile("split_documents", ".zip");
            String filename = Filenames.toSimpleFileName(file.getOriginalFilename())
                .replaceFirst("[.][^.]+$", "");
            try (ZipOutputStream zipOut = new ZipOutputStream(Files.newOutputStream(zipFile))) {
                for(int i = 0; i < splitDocuments.size(); i++) {
                    String fileName = filename
                        + "_"
+ (i + 1)
+ ".pdf";
                    PDDocument splitDocument = splitDocuments.get(i);
                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    splitDocument.save(baos);
                    byte[] pdf = baos.toByteArray();
                    ZipEntry pdfEntry = new ZipEntry(fileName);
                    zipOut.putNextEntry(pdfEntry);
                    zipOut.write(pdf);
                    zipOut.closeEntry();
                }
            }

            data = Files.readAllBytes(zipFile);
            return WebResponseUtils.bytesToWebResponse(data, filename + ".zip", MediaType.APPLICATION_OCTET_STREAM);
        } catch (Exception e) {
            log.error("Error in auto split", e);
            throw e;
        }

        finally {
            // Clean up resources
                if (document != null) {
                    try {
                        document.close();
                    } catch (IOException e) {
                        log.error("Error closing main PDDocument", e);
                    }
                }

                for (PDDocument splitDoc : splitDocuments) {
                    try {
                        splitDoc.close();
                    } catch (IOException e) {
                        log.error("Error closing split PDDocument", e);
                    }
                }

                if (zipFile != null) {
                    try {
                        Files.deleteIfExists(zipFile);
                    } catch (IOException e) {
                        log.error("Error deleting temporary zip file", e);
                    }
                }
        }
    }

