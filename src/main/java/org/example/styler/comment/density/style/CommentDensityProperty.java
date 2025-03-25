package org.example.styler.comment.density.style;

import org.dom4j.Element;
import org.example.parser.common.MyParser;
import org.example.style.rule.StyleProperty;

public class CommentDensityProperty extends StyleProperty {
    public double lineDensity;

    public CommentDensityProperty(double lineDensity) {
        this.lineDensity = Math.round(lineDensity * 100) / 100.0;
    }

    @Override
    public void addElement(Element parent, MyParser parser) {
        parent.addAttribute("density", String.valueOf(lineDensity));
    }

    @Override
    public void parseElement(Element parent, MyParser parser) {
        lineDensity = Double.parseDouble(parent.attributeValue("density"));
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
