package org.example.style;

import org.dom4j.Element;
import org.example.parser.common.MyParser;


/*
 * @description
 * @author       Yingying Jiang
 * @create       2024/3/30 14:55
 */
public interface DomIO {
  void addElement(Element parent, MyParser parser);
  void parseElement(Element parent, MyParser parser);

}
