package org.example.styler.format.space.style;

import org.antlr.v4.runtime.Parser;
import org.dom4j.Element;
import org.example.style.rule.StyleProperty;

public class SpaceProperty extends StyleProperty {
    public boolean space1, space2;

    public SpaceProperty(boolean space1, boolean space2) {
        this.space1 = space1;
        this.space2 = space2;
    }

    public SpaceProperty(boolean space1) {
        this.space1 = space1;
    }

    @Override
    public void addElement(Element parent, Parser parser) {
        parent.addAttribute("leftSpace", String.valueOf(space1));
        parent.addAttribute("rightSpace", String.valueOf(space2));
    }

    @Override
    public Object parseElement(Element parent, Parser parser) {
        space1 = Boolean.parseBoolean(parent.attributeValue("leftSpace"));
        space2 = Boolean.parseBoolean(parent.attributeValue("rightSpace"));
        return this;
    }
}
