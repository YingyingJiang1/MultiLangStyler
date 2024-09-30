package org.example.styler.brace.style;

import org.example.style.StyleContext;
import org.example.style.StyleProperty;
import org.example.style.StyleRule;

public class BraceFormatRule extends StyleRule {

    BraceFormatContext styleContext = new BraceFormatContext()  ;
    BraceFormatProperty styleProperty = new BraceFormatProperty()  ;


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
