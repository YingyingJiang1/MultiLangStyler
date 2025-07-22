    private BufferedImage processAndCompressImage(
            PDImageXObject image, double scaleFactor, float jpegQuality, boolean convertToGrayscale)
            throws IOException {
        BufferedImage bufferedImage = image.getImage();
        int originalWidth = bufferedImage.getWidth();
        int originalHeight = bufferedImage.getHeight();

        // Minimum dimensions to preserve reasonable quality
        int MIN_WIDTH = 400;
        int MIN_HEIGHT = 400;

        log.info("Original dimensions: {}x{}", originalWidth, originalHeight);

        // Skip if already small enough
        if ((originalWidth <= MIN_WIDTH || originalHeight <= MIN_HEIGHT) && !convertToGrayscale) {
            log.info("Skipping - below minimum dimensions threshold");
            return null;
        }

        // Convert to grayscale first if requested (before resizing for better quality)
        if (convertToGrayscale) {
            bufferedImage = convertToGrayscale(bufferedImage);
            log.info("Converted image to grayscale");
        }

        // Adjust scale factor for very large or very small images
        double adjustedScaleFactor = scaleFactor;
        if (originalWidth > 3000 || originalHeight > 3000) {
            // More aggressive for very large images
            adjustedScaleFactor = Math.min(scaleFactor, 0.75);
            log.info("Very large image, using more aggressive scale: {}", adjustedScaleFactor);
        } else if (originalWidth < 1000 || originalHeight < 1000) {
            // More conservative for smaller images
            adjustedScaleFactor = Math.max(scaleFactor, 0.9);
            log.info("Smaller image, using conservative scale: {}", adjustedScaleFactor);
        }

        int newWidth = (int) (originalWidth * adjustedScaleFactor);
        int newHeight = (int) (originalHeight * adjustedScaleFactor);

        // Ensure minimum dimensions
        newWidth = Math.max(newWidth, MIN_WIDTH);
        newHeight = Math.max(newHeight, MIN_HEIGHT);

        // Skip if change is negligible
        if ((double) newWidth / originalWidth > 0.95
                && (double) newHeight / originalHeight > 0.95
                && !convertToGrayscale) {
            log.info("Change too small, skipping compression");
            return null;
        }

        log.info(
                "Resizing to {}x{} ({}% of original)",
                newWidth, newHeight, Math.round((newWidth * 100.0) / originalWidth));

        BufferedImage scaledImage;
        if (convertToGrayscale) {
            // If already grayscale, maintain the grayscale format
            scaledImage = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_BYTE_GRAY);
        } else {
            // Otherwise use original color model
            scaledImage =
                    new BufferedImage(
                            newWidth,
                            newHeight,
                            bufferedImage.getColorModel().hasAlpha()
                                    ? BufferedImage.TYPE_INT_ARGB
                                    : BufferedImage.TYPE_INT_RGB);
        }
        Graphics2D g2d = scaledImage.createGraphics();
        g2d.setRenderingHint(
                RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.drawImage(bufferedImage, 0, 0, newWidth, newHeight, null);
        g2d.dispose();

        return scaledImage;
    }
