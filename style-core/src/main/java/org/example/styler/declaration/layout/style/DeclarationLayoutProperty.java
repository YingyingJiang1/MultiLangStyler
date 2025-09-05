package org.example.styler.declaration.layout.style;

import org.dom4j.Element;
import org.example.parser.common.MyParser;
import org.example.style.rule.StyleProperty;

import java.util.Objects;

public class DeclarationLayoutProperty extends StyleProperty {
    public int maxVariableCount;
    public int maxLength;

    public DeclarationLayoutProperty() {
    }

    public DeclarationLayoutProperty(int maxVariableCount) {
        this.maxVariableCount = maxVariableCount;
    }

    @Override
    public void addElement(Element parent, MyParser parser) {
        parent.addAttribute("maxVariableCount", Integer.toString(maxVariableCount));
        parent.addAttribute("maxLength", Integer.toString(maxLength));
    }

    @Override
    public void parseElement(Element parent, MyParser parser) {
        maxVariableCount = Integer.parseInt(parent.attributeValue("maxVariableCount"));
        maxLength = Integer.parseInt(parent.attributeValue("maxLength"));
    }

    @Override
    public int hashCode() {
        return Objects.hash(maxVariableCount);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof DeclarationLayoutProperty other) {
            return other.maxVariableCount == maxVariableCount;
        }
        return false;
    }

    @Override
    public int compareTo(StyleProperty o) {
        if (o instanceof DeclarationLayoutProperty other) {
            return Integer.compare(maxVariableCount, other.maxVariableCount);
        }
        return -1;
    }
}
