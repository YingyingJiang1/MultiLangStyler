package org.example.styler.format.style;

import org.dom4j.Element;
import org.example.parser.common.MyParser;
import org.example.style.rule.StyleContext;

import java.util.Objects;

public class LineStmtContext extends StyleContext {
    public static final LineStmtContext DEFAULT = new LineStmtContext(0);
    // case 1: max sum of text length of all single statements in one line.
    // case 2: When no multiple single statements are in one line, this field is set to 0.
    public int maxTextLength = 0;

    public LineStmtContext() {
    }

    public LineStmtContext(int maxTextLength) {
        this.maxTextLength = maxTextLength;
    }

    @Override
    public double calculateDistance(StyleContext targetContext) {
        if (targetContext instanceof LineStmtContext context) {
            // case 1 always has a higher priority than case 2
            if (maxTextLength > 0 && context.maxTextLength <= maxTextLength) {
                return 0;
            }
            return 1;
        } else {
            return INVALID_DISTANCE;
        }
    }

    @Override
    public void addElement(Element parent, MyParser parser) {
        parent.addAttribute("maxTextLength", Integer.toString(maxTextLength));
    }

    @Override
    public void parseElement(Element parent, MyParser parser) {
        maxTextLength = Integer.parseInt(parent.attributeValue("maxTextLength"));
    }

    @Override
    public int hashCode() {
        return Objects.hash(maxTextLength);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof LineStmtContext context) {
            return maxTextLength == context.maxTextLength;
        }
        return false;
    }
}
