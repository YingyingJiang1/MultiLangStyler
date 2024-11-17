package org.example.styler.format.space.style;

import org.antlr.v4.runtime.Parser;
import org.dom4j.Element;
import org.example.style.rule.StyleProperty;

public class SpaceProperty extends StyleProperty {

    public boolean leftSpace, rightSpace;

    public SpaceProperty(boolean leftSpace, boolean rightSpace) {
        this.leftSpace = leftSpace;
        this.rightSpace = rightSpace;
    }

    @Override
    public void addElement(Element parent, Parser parser) {
        parent.addAttribute("leftSpace", String.valueOf(leftSpace));
        parent.addAttribute("rightSpace", String.valueOf(rightSpace));
    }

    @Override
    public Object parseElement(Element parent, Parser parser) {
        leftSpace = Boolean.parseBoolean(parent.attributeValue("leftSpace"));
        rightSpace = Boolean.parseBoolean(parent.attributeValue("rightSpace"));
        return this;
    }
}
