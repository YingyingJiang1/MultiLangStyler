package org.example.styler.method.complexity.style;

import org.dom4j.Element;
import org.example.parser.common.MyParser;
import org.example.style.rule.StyleProperty;

import java.util.Objects;

public class MethodComplexityProperty extends StyleProperty {
    public MethodComplexity maxComplexity, avgComplexity;

    public MethodComplexityProperty() {
        maxComplexity = new MethodComplexity();
    }

    public MethodComplexityProperty(MethodComplexity maxComplexity, MethodComplexity avgComplexity) {
        this.maxComplexity = maxComplexity;
        this.avgComplexity = avgComplexity;
    }


    @Override
    public void addElement(Element parent, MyParser parser) {
        Element maxEle = parent.addElement("maxComplexity");
        maxComplexity.addElement(maxEle);

        Element avgEle = parent.addElement("avgComplexity");
        avgComplexity.addElement(maxEle);
    }

    @Override
    public void parseElement(Element parent, MyParser parser) {
        Element maxEle = parent.element("maxComplexity");
        maxComplexity = new MethodComplexity();
        maxComplexity.parseElement(maxEle);

        Element avgEle = parent.element("avgComplexity");
        avgComplexity = new MethodComplexity();
        avgComplexity.parseElement(avgEle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maxComplexity);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof MethodComplexityProperty other) {
            return maxComplexity == other.maxComplexity;
        }
        return false;
    }
}
