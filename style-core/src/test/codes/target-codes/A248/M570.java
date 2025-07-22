    private BufferedImage applyGaussianBlur(BufferedImage image, double sigma) {
        if (sigma <= 0) {
            return image;
        }

        // Scale sigma based on image size to maintain consistent blur effect
        double scaledSigma = sigma * Math.min(image.getWidth(), image.getHeight()) / 1000.0;

        int radius = Math.max(1, (int) Math.ceil(scaledSigma * 3));
        int size = 2 * radius + 1;
        float[] data = new float[size * size];
        double sum = 0.0;

        // Generate Gaussian kernel
        for (int i = -radius; i <= radius; i++) {
            for (int j = -radius; j <= radius; j++) {
                double xDistance = (double) i * i;
                double yDistance = (double) j * j;
                double g = Math.exp(-(xDistance + yDistance) / (2 * scaledSigma * scaledSigma));
                data[(i + radius) * size + j + radius] = (float) g;
                sum += g;
            }
        }

        // Normalize kernel
        for (int i = 0; i < data.length; i++) {
            data[i] /= (float) sum;
        }

        // Create and apply convolution
        java.awt.image.Kernel kernel = new java.awt.image.Kernel(size, size, data);
        java.awt.image.ConvolveOp op =
                new java.awt.image.ConvolveOp(kernel, java.awt.image.ConvolveOp.EDGE_NO_OP, null);

        // Apply blur with high-quality rendering hints
        BufferedImage result =
                new BufferedImage(image.getWidth(), image.getHeight(), image.getType());
        Graphics2D g2d = result.createGraphics();
        g2d.setRenderingHint(
                RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.drawImage(op.filter(image, null), 0, 0, null);
        g2d.dispose();

        return result;
    }
