private void setCommonMetadata(PDDocument pdf, PdfMetadata pdfMetadata) {
    String title = pdfMetadata.getTitle();
    pdf.getDocumentInformation().setTitle(title);
    pdf.getDocumentInformation().setProducer(stirlingPDFLabel);
    pdf.getDocumentInformation().setSubject(pdfMetadata.getSubject());
    pdf.getDocumentInformation().setKeywords(pdfMetadata.getKeywords());
    pdf.getDocumentInformation().setModificationDate(Calendar.getInstance());
    String author = pdfMetadata.getAuthor();
    if (applicationProperties.getPremium().getProFeatures().getCustomMetadata().isAutoUpdateMetadata() && runningProOrHigher) {
        author = applicationProperties.getPremium().getProFeatures().getCustomMetadata().getAuthor();
        if (userService != null) {
            author = author.replace("username", userService.getCurrentUsername());
        }
    }

    pdf.getDocumentInformation().setAuthor(author);
}
