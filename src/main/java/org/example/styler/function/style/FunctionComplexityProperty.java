package org.example.styler.function.style;

import org.dom4j.Element;
import org.example.parser.common.MyParser;
import org.example.style.rule.StyleProperty;

import java.util.Objects;

public class FunctionComplexityProperty extends StyleProperty {
    public int maxLines;
    public int maxNestingDepth;

    public FunctionComplexityProperty(int maxLines, int maxNestingDepth) {
        this.maxLines = maxLines;
        this.maxNestingDepth = maxNestingDepth;
    }

    @Override
    public void addElement(Element parent, MyParser parser) {
        parent.addAttribute("maxLines", String.valueOf(maxLines));
        parent.addAttribute("maxNestingDepth", String.valueOf(maxNestingDepth));
    }

    @Override
    public void parseElement(Element parent, MyParser parser) {
        maxLines = Integer.parseInt(parent.attributeValue("maxLines"));
        maxNestingDepth = Integer.parseInt(parent.attributeValue("maxNestingDepth"));
    }

    @Override
    public int hashCode() {
        return Objects.hash(maxLines, maxNestingDepth);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof FunctionComplexityProperty other) {
            return maxLines == other.maxLines && maxNestingDepth == other.maxNestingDepth;
        }
        return false;
    }
}
