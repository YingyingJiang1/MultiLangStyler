package org.example.styler.body.layout.style;

import org.dom4j.Element;
import org.example.parser.common.MyParser;
import org.example.style.rule.StyleProperty;

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
}
