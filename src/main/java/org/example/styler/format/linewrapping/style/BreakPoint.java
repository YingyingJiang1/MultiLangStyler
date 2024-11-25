package org.example.styler.format.linewrapping.style;

import org.dom4j.Element;
import org.example.io.DomIO;
import org.example.parser.common.MyParser;

import java.util.Objects;

public class BreakPoint implements DomIO {

    int leftToken, rightToken;

    public BreakPoint() {

    }

    public BreakPoint(int leftToken, int rightToken) {
        this.leftToken = leftToken;
        this.rightToken = rightToken;
    }

    @Override
    public void addElement(Element parent, MyParser parser) {
        parent.addElement("break_point").addText(leftToken + ":" + parser.getTokenName(leftToken) + "," +
                rightToken + ":" + parser.getTokenName(rightToken));
    }

    @Override
    public Object parseElement(Element parent, MyParser parser) {
        String[] strs = parent.element("break_point").getText().split("[,:]");
        leftToken = Integer.parseInt(strs[0]);
        rightToken = Integer.parseInt(strs[2]);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BreakPoint that = (BreakPoint) o;
        return leftToken == that.leftToken && rightToken == that.rightToken;
    }

    @Override
    public int hashCode() {
        return Objects.hash(leftToken, rightToken);
    }
}
