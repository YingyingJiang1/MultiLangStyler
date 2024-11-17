package org.example.io;

import org.antlr.v4.runtime.Parser;
import org.dom4j.Element;


/*
 * @description
 * @author       Yingying Jiang
 * @create       2024/3/30 14:55
 */
public interface DomIO {
  void addElement(Element parent, Parser parser);
  Object parseElement(Element parent, Parser parser);

}
