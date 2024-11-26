package org.example.styler.format.linestmt.style;

import org.dom4j.Element;
import org.example.parser.common.MyParser;
import org.example.style.rule.StyleProperty;
import org.example.styler.format.space.style.SpaceProperty;

public class LineStmtProperty extends StyleProperty {
    public boolean isOneStmtPerLine;

    public LineStmtProperty(boolean isOneStmtPerLine) {
        this.isOneStmtPerLine = isOneStmtPerLine;
    }

    @Override
    public void addElement(Element parent, MyParser parser) {

    }

    @Override
    public Object parseElement(Element parent, MyParser parser) {
        return null;
    }
}
