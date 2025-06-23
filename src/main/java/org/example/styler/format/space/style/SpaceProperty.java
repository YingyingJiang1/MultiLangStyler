package org.example.styler.format.space.style;

import org.dom4j.Element;
import org.example.parser.common.MyParser;
import org.example.style.rule.StyleProperty;

public class SpaceProperty extends StyleProperty {
    /**
     * int a = 1;
     * context:(int, a) -> property:(, " ")
     * context:(=, ) -> property:(" ", " ")
     */
    public boolean space1, space2;

    public SpaceProperty() {
    }

    public SpaceProperty(boolean space1, boolean space2) {
        this.space1 = space1;
        this.space2 = space2;
    }

    public SpaceProperty(boolean space2) {
        this.space2 = space2;
    }

    @Override
    public void addElement(Element parent, MyParser parser) {
        parent.addAttribute("space1", String.valueOf(space1));
        parent.addAttribute("space2", String.valueOf(space2));
    }

    @Override
    public void parseElement(Element parent, MyParser parser) {
        space1 = Boolean.parseBoolean(parent.attributeValue("space1"));
        if (parent.attribute("space2") != null) {
            space2 = Boolean.parseBoolean(parent.attributeValue("space2"));
        }
    }

    @Override
    public int hashCode() {
        return Boolean.hashCode(space1) + Boolean.hashCode(space2);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof SpaceProperty property) {
            return space1 == property.space1 && space2 == property.space2;
        }
        return false;
    }
}
