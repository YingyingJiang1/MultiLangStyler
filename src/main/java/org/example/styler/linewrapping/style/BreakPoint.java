package org.example.styler.linewrapping.style;

import org.dom4j.Element;
import org.example.parser.AntlrHelper;
import org.example.interfaces.DomIO;

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
  public void addElement(Element parent) {
    parent.addElement("break_point").addText(leftToken + ":" + AntlrHelper.getTokenName(leftToken) + "," +
        rightToken + ":" + AntlrHelper.getTokenName(rightToken));
  }

  @Override
  public void parseElement(Element parent) {
    String[] strs = parent.element("break_point").getText().split("[,:]");
    leftToken = Integer.parseInt(strs[0]);
    rightToken = Integer.parseInt(strs[2]);
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
