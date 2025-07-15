package org.example.styler.literal.usage.style;

import org.dom4j.Element;
import org.example.parser.common.MyParser;
import org.example.style.rule.StyleProperty;

import java.util.Objects;

public class LiteralUsageProperty extends StyleProperty {
    public boolean declareCons;

    public LiteralUsageProperty() {
    }

    public LiteralUsageProperty(boolean declareCons) {
        this.declareCons = declareCons;
    }

    @Override
    public void addElement(Element parent, MyParser parser) {
        parent.addAttribute("declare_constant_for_use", String.valueOf(declareCons));
    }

    @Override
    public void parseElement(Element parent, MyParser parser) {
        declareCons = Boolean.parseBoolean(parent.attributeValue("declare_constant_for_use"));
    }

    @Override
    public int hashCode() {
        return Objects.hash(declareCons);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof LiteralUsageProperty other) {
            return declareCons == other.declareCons;
        }
        return false;
    }
}
