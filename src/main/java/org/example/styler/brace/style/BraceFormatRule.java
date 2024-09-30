package org.example.styler.brace.style;

import org.example.interfaces.StyleRule;

public class BraceFormatRule extends StyleRule {

    public BraceFormatRule(BraceFormatContext styleContext, BraceFormatProperty styleProperty) {
        super(styleContext, styleProperty);
    }

    @Override
    public BraceFormatContext getStyleContext() {
        return (BraceFormatContext) super.getStyleContext();
    }

    @Override
    public BraceFormatProperty getStyleProperty() {
        return (BraceFormatProperty) super.getStyleProperty();
    }
}
