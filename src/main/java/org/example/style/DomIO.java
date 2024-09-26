package org.example.style;

import org.dom4j.Element;
import org.example.antlr.JavaLexer;
import org.example.antlr.JavaParser;

import java.util.ArrayList;
import java.util.List;

/*
 * @description
 * @author       Yingying Jiang
 * @create       2024/3/30 14:55
 */
public interface DomIO {
  void addElement(Element parent);
  void parseElement(Element parent);


}
