package org.example.style;

import org.example.styler.arrangement.style.ArrangementProperty;
import org.example.styler.brace.style.BraceFormatContext;
import org.example.styler.brace.style.BraceFormatProperty;

public class StyleRule {
    public StyleContext styleContext;
    public StyleProperty styleProperty;

    public StyleRule(BraceFormatContext styleContext, BraceFormatProperty styleProperty) {
        this.styleContext = styleContext;
        this.styleProperty = styleProperty;
    }

    void fill() {
        styleContext.fill();
        styleProperty.fill();
    }

    public StyleContext getStyleContext() {
        return styleContext;
    }

    public StyleProperty getStyleProperty() {
        return styleProperty;
    }
}
