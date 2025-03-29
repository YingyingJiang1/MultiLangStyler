package org.example.styler.exp.complexity.style;

import org.dom4j.Element;
import org.example.parser.common.MyParser;
import org.example.style.rule.StyleContext;
import org.example.styler.exp.ExpType;

public class ExpressionContext extends StyleContext {
    public ExpType expType;

    public ExpressionContext() {
    }

    public ExpressionContext(ExpType expType) {
        this.expType = expType;
    }

    @Override
    public void addElement(Element parent, MyParser parser) {
        parent.addAttribute("expType", expType.toString());
    }

    @Override
    public void parseElement(Element parent, MyParser parser) {
        expType = ExpType.valueOf(parent.attributeValue("expType"));
    }

    @Override
    public int hashCode() {
        return expType.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ExpressionContext other) {
            return expType == other.expType;
        }
        return false;
    }
}
