package org.example.style.rule;

import org.dom4j.Element;
import org.example.style.DomIO;
import org.example.parser.common.MyParser;

import java.util.Objects;

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
    public void parseElement(Element parent, MyParser parser) {
        Element contextEle = parent.element("style_context");
        if (contextEle != null && styleContext != null) {
            styleContext.parseElement(contextEle, parser);
        }
        Element propertyEle = parent.element("style_property");
        if (propertyEle != null && styleProperty != null) {
            styleProperty.parseElement(propertyEle, parser);
        }
        
    }

    @Override
    public int hashCode() {
        return Objects.hash(styleContext, styleProperty);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof StyleRule other) {
            return Objects.equals(styleContext, other.styleContext) && Objects.equals(styleProperty, other.styleProperty);
        }
        return false;
    }
}
