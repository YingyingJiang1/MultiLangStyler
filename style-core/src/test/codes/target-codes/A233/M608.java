    private void redactAreas(
            List<RedactionArea> redactionAreas, PDDocument document, PDPageTree allPages)
            throws IOException {
        // Group redaction areas by page
        Map<Integer, List<RedactionArea>> redactionsByPage = new HashMap<>();

        // Process and validate each redaction area
        for (RedactionArea redactionArea : redactionAreas) {
            if (redactionArea.getPage() == null
                    || redactionArea.getPage() <= 0
                    || redactionArea.getHeight() == null
                    || redactionArea.getHeight() <= 0.0D
                    || redactionArea.getWidth() == null
                    || redactionArea.getWidth() <= 0.0D) continue;

            // Group by page number
            redactionsByPage
                    .computeIfAbsent(redactionArea.getPage(), k -> new ArrayList<>())
                    .add(redactionArea);
        }

        // Process each page only once
        for (Map.Entry<Integer, List<RedactionArea>> entry : redactionsByPage.entrySet()) {
            Integer pageNumber = entry.getKey();
            List<RedactionArea> areasForPage = entry.getValue();

            if (pageNumber > allPages.getCount()) {
                continue; // Skip if page number is out of bounds
            }

            PDPage page = allPages.get(pageNumber - 1);
            PDRectangle box = page.getBBox();

            // Create only one content stream per page
            PDPageContentStream contentStream =
                    new PDPageContentStream(
                            document, page, PDPageContentStream.AppendMode.APPEND, true, true);

            // Process all redactions for this page
            for (RedactionArea redactionArea : areasForPage) {
                Color redactColor = decodeOrDefault(redactionArea.getColor(), Color.BLACK);
                contentStream.setNonStrokingColor(redactColor);

                float x = redactionArea.getX().floatValue();
                float y = redactionArea.getY().floatValue();
                float width = redactionArea.getWidth().floatValue();
                float height = redactionArea.getHeight().floatValue();

                contentStream.addRect(x, box.getHeight() - y - height, width, height);
                contentStream.fill();
            }

            contentStream.close();
        }
    }
