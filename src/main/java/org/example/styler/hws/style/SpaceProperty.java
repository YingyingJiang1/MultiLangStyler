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

    }

    @Override
    public Object parseElement(Element parent, Parser parser) {
        return null;
    }
}
