package org.example.styler.format.linewrapping.style;

import org.dom4j.Element;
import org.example.parser.common.MyParser;
import org.example.style.rule.StyleContext;

import java.util.Objects;

public class LineWrappingContext extends StyleContext {

    public Attr attr;

    public LineWrappingContext(Attr attr) {
        this.attr = attr;
    }

    @Override
    public double calculateDistance(StyleContext targetContext) {
        if (targetContext instanceof LineWrappingContext context) {
            if (attr != context.attr) {
                return -1;
            }
            return 0;
        }
        return -1;
    }

    @Override
    public void addElement(Element parent, MyParser parser) {

    }

    @Override
    public void parseElement(Element parent, MyParser parser) {
    }

    @Override
    public int hashCode() {
        return Objects.hash(attr);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof LineWrappingContext context) {
            return Objects.equals(attr, context.attr);
        }
        return false;
    }

    public enum Attr {
        CODE, COMMENT
    }
}
