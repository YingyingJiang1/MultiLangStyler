package org.example.styler.exp.style;

import org.dom4j.Element;
import org.example.parser.common.MyParser;
import org.example.style.rule.StyleProperty;

import java.util.Objects;

public class ComplexBoolExpProperty extends StyleProperty {
    public int maxExpressionLength;
    public int maxLogicalOpNum;
    public int maxSubExpNum;

    public ComplexBoolExpProperty(int length, int maxPredicateNum) {
        this.maxExpressionLength = length;
        this.maxLogicalOpNum = maxPredicateNum;
    }

    @Override
    public void addElement(Element parent, MyParser parser) {
        parent.addAttribute("maxExpressionLength", Integer.toString(maxExpressionLength));
        parent.addAttribute("maxPredicateNum", Integer.toString(maxLogicalOpNum));
    }

    @Override
    public void parseElement(Element parent, MyParser parser) {
        maxExpressionLength = Integer.parseInt(parent.attributeValue("maxExpressionLength"));
        maxLogicalOpNum = Integer.parseInt(parent.attributeValue("maxPredicateNum"));
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                maxExpressionLength,
                maxLogicalOpNum
        );
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ComplexBoolExpProperty property) {
            return maxExpressionLength == property.maxExpressionLength
                    && maxLogicalOpNum == property.maxLogicalOpNum;
        }
        return false;
    }

}
