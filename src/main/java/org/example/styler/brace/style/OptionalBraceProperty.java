package org.example.styler.brace.style;

import org.dom4j.Element;
import org.example.parser.common.MyParser;
import org.example.style.rule.StyleProperty;

public class OptionalBraceProperty extends StyleProperty {
    public boolean useBrace;
    public boolean compactStyle; // The field is meaningful when @useBrace == false


    public OptionalBraceProperty(boolean useBrace, boolean compactStyle) {
        this.useBrace = useBrace;
        this.compactStyle = compactStyle;
    }

    public OptionalBraceProperty() {
    }

    @Override
    public void addElement(Element parent, MyParser parser) {
        parent.addAttribute("use_brace", Boolean.toString(useBrace));
        if(!useBrace) {
            parent.addAttribute("compactStyle", Boolean.toString(compactStyle));
        }
    }

    @Override
    public void parseElement(Element parent, MyParser parser) {
        useBrace = Boolean.parseBoolean(parent.attributeValue("use_brace"));
        compactStyle = parent.attribute("compactStyle") != null && Boolean.parseBoolean(parent.attributeValue("compactStyle"));
    }
}
