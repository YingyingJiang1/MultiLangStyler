package org.example.style.rule;

import org.antlr.v4.runtime.Parser;
import org.dom4j.Element;
import org.example.io.DomIO;
import org.example.parser.common.MyParser;

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

    public void fillStyle() {
        if (styleContext != null) {
            styleContext.fillStyle();
        }
        if (styleProperty!= null) {
            styleProperty.fillStyle();
        }
    }

    public StyleContext getStyleContext() {
        return styleContext;
    }

    public StyleProperty getStyleProperty() {
        return styleProperty;
    }


    @Override
    public void addElement(Element parent, MyParser parser) {
        if (styleContext != null) {
            Element contextEle = parent.addElement("style_context");
            styleContext.addElement(contextEle, parser);
        }
        if (styleProperty != null) {
            Element contextEle = parent.addElement("style_property");
            styleProperty.addElement(contextEle, parser);
        }
    }

    @Override
    public StyleRule parseElement(Element parent, MyParser parser) {
        if (styleContext != null) {
            styleContext.parseElement(parent, parser);
        }
        if (styleProperty != null) {
            styleProperty.parseElement(parent, parser);
        }
        return this;
    }
}
