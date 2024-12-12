package org.example.styler.exp.style;

import org.dom4j.Element;
import org.example.parser.common.MyParser;
import org.example.style.rule.StyleProperty;

import java.util.Objects;

public class ExpressionProperty extends StyleProperty {
    public int maxExpressionLength;
    public int maxSubExpNum;

    public ExpressionProperty(int length, int maxPredicateNum) {
        this.maxExpressionLength = length;
        this.maxSubExpNum = maxPredicateNum;
    }

    @Override
    public void addElement(Element parent, MyParser parser) {
        parent.addAttribute("maxExpressionLength", Integer.toString(maxExpressionLength));
        parent.addAttribute("maxSubExpNum", Integer.toString(maxSubExpNum));
    }

    @Override
    public void parseElement(Element parent, MyParser parser) {
        maxExpressionLength = Integer.parseInt(parent.attributeValue("maxExpressionLength"));
        maxSubExpNum = Integer.parseInt(parent.attributeValue("maxSubExpNum"));
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                maxExpressionLength,
                maxSubExpNum
        );
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ExpressionProperty property) {
            return maxExpressionLength == property.maxExpressionLength
                    && maxSubExpNum == property.maxSubExpNum;
        }
        return false;
    }

}
