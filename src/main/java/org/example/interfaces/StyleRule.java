package org.example.interfaces;

import org.antlr.v4.runtime.Parser;
import org.dom4j.Element;

/**
 * @description Try to concentrate type conversions in a single file.
 */
public class StyleRule implements DomIO {
    public StyleContext styleContext;
    public StyleProperty styleProperty;

    public StyleRule() {}

    public StyleRule(StyleProperty styleProperty) {
        this.styleProperty = styleProperty;
    }
    public StyleRule(StyleContext styleContext, StyleProperty styleProperty) {
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

    @Override
    public void addElement(Element parent, Parser parser) {
        if (styleContext != null) {
            styleContext.addElement(parent, parser);
        }
        if (styleProperty != null) {
            styleProperty.addElement(parent, parser);
        }
    }

    @Override
    public StyleRule parseElement(Element parent, Parser parser) {
        if (styleContext != null) {
            styleContext.parseElement(parent, parser);
        }
        if (styleProperty != null) {
            styleProperty.parseElement(parent, parser);
        }
        return this;
    }
}
