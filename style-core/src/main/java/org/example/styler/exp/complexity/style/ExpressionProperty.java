package org.example.styler.exp.complexity.style;

import org.dom4j.Element;
import org.example.parser.common.MyParser;
import org.example.style.rule.StyleProperty;

import java.util.Objects;

public class ExpressionProperty extends StyleProperty {
    public ExpressionComplexity maxComplexity;
    public ExpressionComplexity avgComplexity;

    public ExpressionProperty() {
    }

    public ExpressionProperty(ExpressionComplexity maxComplexity, ExpressionComplexity avgComplexity) {
        this.maxComplexity = maxComplexity;
        this.avgComplexity = avgComplexity;
    }


    @Override
    public void addElement(Element parent, MyParser parser) {
        Element maxEle = parent.addElement("maxComplexity");
        maxComplexity.addElement(maxEle);
        Element avgEle = parent.addElement("avgComplexity");
        avgComplexity.addElement(avgEle);
    }

    @Override
    public void parseElement(Element parent, MyParser parser) {
        maxComplexity = new ExpressionComplexity();
        avgComplexity = new ExpressionComplexity();
        maxComplexity.parseElement(parent.element("maxComplexity"));
        avgComplexity.parseElement(parent.element("avgComplexity"));
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                maxComplexity,
                avgComplexity
        );
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ExpressionProperty property) {
            return avgComplexity == property.avgComplexity
                    && maxComplexity == property.maxComplexity;
        }
        return false;
    }


}
