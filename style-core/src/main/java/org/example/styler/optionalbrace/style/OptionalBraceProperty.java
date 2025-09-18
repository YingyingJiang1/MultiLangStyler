package org.example.styler.optionalbrace.style;

import org.dom4j.Element;
import org.example.parser.common.MyParser;
import org.example.style.rule.StyleProperty;

import java.util.Objects;

public class OptionalBraceProperty extends StyleProperty {
    public boolean useBrace;

    public OptionalBraceProperty(boolean useBrace) {
        this.useBrace = useBrace;
    }

    public OptionalBraceProperty() {
    }

    @Override
    public void addElement(Element parent, MyParser parser) {
        parent.addAttribute("useBrace", Boolean.toString(useBrace));
    }

    @Override
    public void parseElement(Element parent, MyParser parser) {
        useBrace = Boolean.parseBoolean(parent.attributeValue("useBrace"));
    }

    @Override
    public int hashCode() {
        return Objects.hash(useBrace);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof OptionalBraceProperty property) {
            return useBrace == property.useBrace;
        }
        return false;
    }
}
