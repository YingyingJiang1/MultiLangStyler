package org.example.styler.practice.style;

import org.dom4j.Element;
import org.example.parser.common.MyParser;
import org.example.style.rule.StyleProperty;

public class UnusedCodeProperty extends StyleProperty {
    public boolean hasUnusedCode;

    public UnusedCodeProperty() {
    }

    public UnusedCodeProperty(boolean hasUnusedCode) {
        this.hasUnusedCode = hasUnusedCode;
    }

    @Override
    public void addElement(Element parent, MyParser parser) {
        parent.addAttribute("hasUnusedCode", Boolean.toString(hasUnusedCode));
    }

    @Override
    public void parseElement(Element parent, MyParser parser) {
        hasUnusedCode = Boolean.parseBoolean(parent.attributeValue("hasUnusedCode"));
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof UnusedCodeProperty targetProperty && hasUnusedCode == targetProperty.hasUnusedCode;
    }

    @Override
    public int hashCode() {
        return Boolean.hashCode(hasUnusedCode);
    }
}
