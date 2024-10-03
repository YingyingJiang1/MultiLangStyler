package org.example.styler.linewrapping.style;

import org.antlr.v4.runtime.Parser;
import org.dom4j.Element;
import org.example.interfaces.StyleContext;
import org.example.parser.AntlrHelper;

import java.util.Objects;

public class LineWrappingContext extends StyleContext {
  int maxColumn, avgColumn;

  @Override
  public void addElement(Element parent, Parser parser) {

  }

  @Override
  public Object parseElement(Element parent, Parser parser) {
    return null;
  }
}
