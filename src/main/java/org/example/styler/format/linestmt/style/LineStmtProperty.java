package org.example.styler.format.linestmt.style;

import org.dom4j.Element;
import org.example.parser.common.MyParser;
import org.example.style.rule.StyleProperty;

import java.util.Objects;

public class LineStmtProperty extends StyleProperty {
    public boolean isOneStmtPerLine;

    public LineStmtProperty(boolean isOneStmtPerLine) {
        this.isOneStmtPerLine = isOneStmtPerLine;
    }

    @Override
    public void addElement(Element parent, MyParser parser) {

    }

    @Override
    public void parseElement(Element parent, MyParser parser) {
    }

    @Override
    public int hashCode() {
        return Objects.hash(isOneStmtPerLine);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof LineStmtProperty property) {
            return isOneStmtPerLine == property.isOneStmtPerLine;
        }
        return false;
    }
}
