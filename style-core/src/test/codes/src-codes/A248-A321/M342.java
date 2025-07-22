    private static String convertEmlToHtmlBasic(byte[] emlBytes, EmlToPdfRequest request) {
        if (emlBytes == null || emlBytes.length == 0) {
            throw new IllegalArgumentException("EML file is empty or null");
        }

        String emlContent = new String(emlBytes, StandardCharsets.UTF_8);

        // Basic email parsing
        String subject = extractBasicHeader(emlContent, "Subject:");
        String from = extractBasicHeader(emlContent, "From:");
        String to = extractBasicHeader(emlContent, "To:");
        String cc = extractBasicHeader(emlContent, "Cc:");
        String bcc = extractBasicHeader(emlContent, "Bcc:");
        String date = extractBasicHeader(emlContent, "Date:");

        // Try to extract HTML content
        String htmlBody = extractHtmlBody(emlContent);
        if (htmlBody == null) {
            String textBody = extractTextBody(emlContent);
            htmlBody =
                    convertTextToHtml(
                            textBody != null ? textBody : "Email content could not be parsed");
        }

        // Generate HTML with custom styling based on request
        StringBuilder html = new StringBuilder();
        html.append("<!DOCTYPE html>\n");
        html.append("<html><head><meta charset=\"UTF-8\">\n");
        html.append("<title>").append(escapeHtml(subject)).append("</title>\n");
        html.append("<style>\n");
        appendEnhancedStyles(html);
        html.append("</style>\n");
        html.append("</head><body>\n");

        html.append("<div class=\"email-container\">\n");
        html.append("<div class=\"email-header\">\n");
        html.append("<h1>").append(escapeHtml(subject)).append("</h1>\n");
        html.append("<div class=\"email-meta\">\n");
        html.append("<div><strong>From:</strong> ").append(escapeHtml(from)).append("</div>\n");
        html.append("<div><strong>To:</strong> ").append(escapeHtml(to)).append("</div>\n");

        // Include CC and BCC if present and requested
        if (request != null && request.isIncludeAllRecipients()) {
            if (!cc.trim().isEmpty()) {
                html.append("<div><strong>CC:</strong> ").append(escapeHtml(cc)).append("</div>\n");
            }
            if (!bcc.trim().isEmpty()) {
                html.append("<div><strong>BCC:</strong> ")
                        .append(escapeHtml(bcc))
                        .append("</div>\n");
            }
        }

        if (!date.trim().isEmpty()) {
            html.append("<div><strong>Date:</strong> ").append(escapeHtml(date)).append("</div>\n");
        }
        html.append("</div></div>\n");

        html.append("<div class=\"email-body\">\n");
        html.append(processEmailHtmlBody(htmlBody));
        html.append("</div>\n");

        // Add attachment information - always check for and display attachments
        String attachmentInfo = extractAttachmentInfo(emlContent);
        if (!attachmentInfo.isEmpty()) {
            html.append("<div class=\"attachment-section\">\n");
            html.append("<h3>Attachments</h3>\n");
            html.append(attachmentInfo);

            // Add a status message about attachment inclusion
            if (request != null && request.isIncludeAttachments()) {
                html.append("<div class=\"attachment-inclusion-note\">\n");
                html.append(
                        "<p><strong>Note:</strong> Attachments are saved as external files and linked in this PDF. Click the links to open files externally.</p>\n");
                html.append("</div>\n");
            } else {
                html.append("<div class=\"attachment-info-note\">\n");
                html.append(
                        "<p><em>Attachment information displayed - files not included in PDF. Enable 'Include attachments' to embed files.</em></p>\n");
                html.append("</div>\n");
            }

            html.append("</div>\n");
        }

        // Show advanced features status if requested
        assert request != null;
        if (request.getFileInput().isEmpty()) {
            html.append("<div class=\"advanced-features-notice\">\n");
            html.append(
                    "<p><em>Note: Some advanced features require Jakarta Mail dependencies.</em></p>\n");
            html.append("</div>\n");
        }

        html.append("</div>\n");
        html.append("</body></html>");

        return html.toString();
    }
