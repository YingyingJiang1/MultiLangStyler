    private static boolean isValidJakartaMailMultipart(Object multipart) {
        if (multipart == null) return false;

        try {
            // Check if the object implements jakarta.mail.Multipart interface
            Class<?> multipartInterface = Class.forName("jakarta.mail.Multipart");
            if (!multipartInterface.isInstance(multipart)) {
                return false;
            }

            // Additional check for MimeMultipart
            try {
                Class<?> mimeMultipartClass = Class.forName("jakarta.mail.internet.MimeMultipart");
                if (mimeMultipartClass.isInstance(multipart)) {
                    log.debug("Found MimeMultipart instance for enhanced processing");
                    return true;
                }
            } catch (ClassNotFoundException e) {
                log.debug("MimeMultipart not available, using base Multipart interface");
            }

            return true;
        } catch (ClassNotFoundException e) {
            log.debug("Jakarta Mail Multipart interface not available for validation");
            return false;
        }
    }
