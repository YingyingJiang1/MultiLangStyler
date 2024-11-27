package org.example.styler.body.optionalbrace.style;

import org.dom4j.Element;
import org.example.parser.common.MyParser;
import org.example.style.rule.StyleProperty;

public class OptionalBraceProperty extends StyleProperty {
    public boolean useBrace;

    public OptionalBraceProperty(boolean useBrace) {
        this.useBrace = useBrace;
    }

    public OptionalBraceProperty() {
    }

    @Override
    public void addElement(Element parent, MyParser parser) {
        parent.addAttribute("use_brace", Boolean.toString(useBrace));
    }

    @Override
    public void parseElement(Element parent, MyParser parser) {
        useBrace = Boolean.parseBoolean(parent.attributeValue("use_brace"));
    }
}
