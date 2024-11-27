package org.example.styler.comment.density.style;

import org.dom4j.Element;
import org.example.parser.common.MyParser;
import org.example.style.rule.StyleProperty;

public class CommentDensityProperty extends StyleProperty {
    double density;

    public CommentDensityProperty(double density) {
        this.density = density;
    }

    @Override
    public void addElement(Element parent, MyParser parser) {

    }

    @Override
    public void parseElement(Element parent, MyParser parser) {
    }
}
