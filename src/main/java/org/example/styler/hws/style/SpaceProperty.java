package org.example.styler.hws.style;

import org.antlr.v4.runtime.Parser;
import org.dom4j.Element;
import org.example.interfaces.StyleProperty;

public class SpaceProperty extends StyleProperty {
    boolean addSpace;

    public SpaceProperty(boolean addSpace) {
        this.addSpace = addSpace;
    }

    @Override
    public void addElement(Element parent, Parser parser) {
        parent.addElement("style_property").setText(String.valueOf(addSpace));
    }

    @Override
    public Object parseElement(Element parent, Parser parser) {
        addSpace = Boolean.parseBoolean(parent.elementText("style_property"));
        return this;
    }
}
