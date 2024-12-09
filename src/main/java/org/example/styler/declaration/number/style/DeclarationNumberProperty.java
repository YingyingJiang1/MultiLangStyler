package org.example.styler.declaration.number.style;

import org.dom4j.Element;
import org.example.parser.common.MyParser;
import org.example.style.rule.StyleProperty;

import java.util.Objects;

public class DeclarationNumberProperty extends StyleProperty {
    public int maxVariableCount;

    public DeclarationNumberProperty(int maxVariableCount) {
        this.maxVariableCount = maxVariableCount;
    }

    @Override
    public void addElement(Element parent, MyParser parser) {
        parent.addAttribute("variable_count", Integer.toString(maxVariableCount));
    }

    @Override
    public void parseElement(Element parent, MyParser parser) {
        maxVariableCount = Integer.parseInt(parent.attributeValue("variable_count"));
    }

    @Override
    public int hashCode() {
        return Objects.hash(maxVariableCount);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof DeclarationNumberProperty other) {
            return other.maxVariableCount == maxVariableCount;
        }
        return false;
    }

    @Override
    public int compareTo(StyleProperty o) {
        if (o instanceof DeclarationNumberProperty other) {
            return Integer.compare(maxVariableCount, other.maxVariableCount);
        }
        return -1;
    }
}
