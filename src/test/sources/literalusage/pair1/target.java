public void draw(GraphicsHandler graphicsHandler) {
    // if camera is at bottom of screen, textbox is drawn at top of screen instead
    // of the bottom like usual
    // to prevent it from covering the player
    if (!map.getCamera().isAtBottomOfMap()) {
        graphicsHandler.drawFilledRectangleWithBorder(Color.black, 2);
    }
    if (text != null) {
        text.drawWithParsedNewLines(graphicsHandler, 10);
    }
}