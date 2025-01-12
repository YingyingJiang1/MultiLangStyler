package org.example.styler.practice.style;

import org.dom4j.Element;
import org.example.parser.common.MyParser;
import org.example.style.rule.StyleProperty;

public class UnusedCodeProperty extends StyleProperty {
    public boolean hasUnusedVar;

    public UnusedCodeProperty(boolean hasUnusedVar) {
        this.hasUnusedVar = hasUnusedVar;
    }

    @Override
    public void addElement(Element parent, MyParser parser) {
        parent.addAttribute("hasUnusedVar", Boolean.toString(hasUnusedVar));
    }

    @Override
    public void parseElement(Element parent, MyParser parser) {
        hasUnusedVar = Boolean.parseBoolean(parent.attributeValue("hasUnusedVar"));
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof UnusedCodeProperty targetProperty && hasUnusedVar == targetProperty.hasUnusedVar;
    }

    @Override
    public int hashCode() {
        return Boolean.hashCode(hasUnusedVar);
    }
}
