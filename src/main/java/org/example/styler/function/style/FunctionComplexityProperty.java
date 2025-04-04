package org.example.styler.function.style;

import org.dom4j.Element;
import org.example.parser.common.MyParser;
import org.example.style.rule.StyleProperty;
import org.example.styler.function.FunctionComplexityStyler;

import java.util.Objects;

public class FunctionComplexityProperty extends StyleProperty {
    public FunctionComplexity maxComplexity;

    public FunctionComplexityProperty() {
        maxComplexity = new FunctionComplexity();
    }

    public FunctionComplexityProperty(FunctionComplexity maxComplexity) {
        this.maxComplexity = maxComplexity;
    }


    @Override
    public void addElement(Element parent, MyParser parser) {
        Element maxEle = parent.addElement("maxComplexity");
        maxComplexity.addElement(maxEle);
    }

    @Override
    public void parseElement(Element parent, MyParser parser) {
        Element maxEle = parent.element("maxComplexity");
        maxComplexity = new FunctionComplexity();
        maxComplexity.parseElement(maxEle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maxComplexity);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof FunctionComplexityProperty other) {
            return maxComplexity == other.maxComplexity;
        }
        return false;
    }
}
