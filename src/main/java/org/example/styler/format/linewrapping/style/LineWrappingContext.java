package org.example.styler.format.linewrapping.style;

import org.antlr.v4.runtime.Parser;
import org.dom4j.Element;
import org.example.style.rule.StyleContext;

public class LineWrappingContext extends StyleContext {
  int maxColumn, avgColumn;
  Attr attr;

  public LineWrappingContext(int maxColumn, int avgColumn, Attr attr) {
    this.maxColumn = maxColumn;
    this.avgColumn = avgColumn;
    this.attr = attr;
  }

  @Override
  public void addElement(Element parent, Parser parser) {

  }

  @Override
  public Object parseElement(Element parent, Parser parser) {
    return null;
  }

  public enum Attr {
    CODE, COMMENT
  }
}
