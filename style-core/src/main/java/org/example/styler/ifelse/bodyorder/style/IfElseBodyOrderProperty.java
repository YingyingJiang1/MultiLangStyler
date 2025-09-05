package org.example.styler.ifelse.bodyorder.style;

import org.dom4j.Element;
import org.example.parser.common.MyParser;
import org.example.style.rule.StyleProperty;

import java.util.Objects;

public class IfElseBodyOrderProperty extends StyleProperty {
    public boolean shortBodyComesFirst;

    public IfElseBodyOrderProperty() {
    }

    public IfElseBodyOrderProperty(boolean shortBodyComesFirst) {
        this.shortBodyComesFirst = shortBodyComesFirst;
    }

    @Override
    public void addElement(Element parent, MyParser parser) {
        parent.addAttribute("shortBodyComesFirst", Boolean.toString(shortBodyComesFirst));
    }

    @Override
    public void parseElement(Element parent, MyParser parser) {
        shortBodyComesFirst = Boolean.parseBoolean(parent.attributeValue("shortBodyComesFirst"));
    }

    @Override
    public int hashCode() {
        return Objects.hash(shortBodyComesFirst);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof IfElseBodyOrderProperty other) {
            return other.shortBodyComesFirst == shortBodyComesFirst;
        }
        return false;
    }
}
