public void draw(GraphicsHandler graphicsHandler) {
    // if camera is at bottom of screen, textbox is drawn at top of screen instead
    // of the bottom like usual
    // to prevent it from covering the player
    if (!map.getCamera().isAtBottomOfMap()) {
        graphicsHandler.drawFilledRectangleWithBorder(x, bottomY, width, height, Color.white, Color.black, 2);
    } else {
        graphicsHandler.drawFilledRectangleWithBorder(x, topY, width, height, Color.white, Color.black, 2);
    }

    if (text != null) {
        text.drawWithParsedNewLines(graphicsHandler, 10);
    }
    if (!decideTurn.isEmpty()) {
        if (selectionText[0] != null && decideTurn.peek().equals("1")) {
            if (this.currentTextItemHovered < compiledCount && this.currentTextItemHovered > 0) {
                selectionText[currentTextItemHovered].setColor(Color.red);
            }
            if (this.currentTextItemHovered < compiledCount - 1) {
                selectionText[currentTextItemHovered + 1].setColor(Color.black);
            }
            if (this.currentTextItemHovered > 0) {
                selectionText[currentTextItemHovered - 1].setColor(Color.black);
            }
            selectionText[0].drawWithParsedNewLines(graphicsHandler, 10);
            int x = fontX;
            for (int i = 0; i <= compiledCount; i++) {
                if (selectionText[i + 1] != null) {
                    selectionText[i + 1].setY(fontBottomY + 40);
                    selectionText[i + 1].setX(x);
                    x += (selectionText[i + 1].getText().length() * 17 + 15);
                    selectionText[i + 1].drawWithParsedNewLines(graphicsHandler, 10);
                }
            }
        }
    }
}