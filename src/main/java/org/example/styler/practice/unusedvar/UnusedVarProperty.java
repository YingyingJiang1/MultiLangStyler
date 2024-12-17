package org.example.styler.naming.usage;

import org.dom4j.Element;
import org.example.parser.common.MyParser;
import org.example.style.rule.StyleProperty;

public class UnusedVarProperty extends StyleProperty {
    public boolean hasUnusedVar;

    public UnusedVarProperty(boolean hasUnusedVar) {
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
}
