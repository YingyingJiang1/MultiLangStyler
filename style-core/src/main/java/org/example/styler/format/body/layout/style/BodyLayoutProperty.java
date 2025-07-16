package org.example.styler.format.body.layout.style;

import org.dom4j.Element;
import org.example.parser.common.MyParser;
import org.example.style.rule.StyleProperty;

import java.util.Objects;

public class BodyLayoutProperty extends StyleProperty {
    public boolean compactStyle;

    @Override
    public void addElement(Element parent, MyParser parser) {
        parent.addAttribute("compactStyle", Boolean.toString(compactStyle));
    }

    @Override
    public void parseElement(Element parent, MyParser parser) {
        compactStyle = parent.attribute("compactStyle") != null && Boolean.parseBoolean(parent.attributeValue("compactStyle"));
    }

    @Override
    public int hashCode() {
        return Objects.hash(compactStyle);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof BodyLayoutProperty property) {
            return compactStyle == property.compactStyle;
        }
        return false;
    }
}
