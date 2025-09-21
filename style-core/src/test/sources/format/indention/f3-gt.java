@PostMapping(value = "/auto-split-pdf", consumes = "multipart/form-data")
@Operation(
summary = "Auto split PDF pages into separate documents",
description =
"This endpoint accepts a PDF file, scans each page for a specific QR code, and"
+ " splits the document at the QR code boundaries. The output is a zip file"
+ " containing each separate PDF document. Input:PDF Output:ZIP-PDF"
+ " Type:SISO")
public ResponseEntity<byte[]> autoSplitPdf(@ModelAttribute AutoSplitPdfRequest request)
throws IOException {
    if (document != null) {
        try {
            document.close();
        } catch (IOException e) {
            log.error("Error closing main PDDocument", e);
        }
    }
}
