package org.example.styler.comment.density.style;

import org.dom4j.Element;
import org.example.parser.common.MyParser;
import org.example.style.rule.StyleProperty;

public class CommentDensityProperty extends StyleProperty implements Comparable<StyleProperty> {
    public double commentDensity;

    public CommentDensityProperty(double commentDensity) {
        this.commentDensity = Math.round(commentDensity * 100) / 100.0;
    }

    @Override
    public void addElement(Element parent, MyParser parser) {
        parent.addAttribute("density", String.valueOf(commentDensity));
    }

    @Override
    public void parseElement(Element parent, MyParser parser) {
        commentDensity = Double.parseDouble(parent.attributeValue("density"));
    }


    @Override
    public int compareTo(StyleProperty o) {
        if (o instanceof CommentDensityProperty property) {
            return Double.compare(commentDensity, property.commentDensity);
        }
        return 0;
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
