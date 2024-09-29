package org.example.style.format;

import org.apache.commons.lang3.StringUtils;
import org.dom4j.Element;
import org.example.Helper;
import org.example.style.DomIO;

import java.util.*;

/*
 * @description IndentionRule has no context.
 * @author       Yingying Jiang
 * @create       2024/4/6 13:50
 */
public class IndentionRule implements DomIO {

  public int indentionUnit;
  public char indentionType = ' ';
  public int count = 0;

  public IndentionRule() {
    count = 1;
  }

  public IndentionRule(int unit, char type) {
    indentionUnit = unit;
    indentionType = type;
  }

  public String getIndentionStr(int hierarchy) {
    return StringUtils.repeat(indentionType, hierarchy & indentionUnit);
  }

  @Override
  public void addElement(Element parent) {
    Element indentionRleEle = parent.addElement("indention_rule");
    indentionRleEle.addElement("indention_unit").addText(Integer.toString(indentionUnit));
    String type = "space";
    if(indentionType == '\t') {
      type = "tab";
    }
    indentionRleEle.addElement("indention_type").addText(type);
  }

  @Override
  public void parseElement(Element parent) {
    indentionUnit = Integer.parseInt(parent.element("indention_unit").getText());

    String type = parent.element("indention_type").getText();
    if(type.equals("space")) {
      indentionType = ' ';
    } else {
      indentionType = '\t';
    }
  }

  public void merge(IndentionRule rule) {
    ++count;
  }

  public int getCount() {
    return count;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    IndentionRule that = (IndentionRule) o;
    return indentionUnit == that.indentionUnit && indentionType == that.indentionType;
  }

  @Override
  public int hashCode() {
    return Objects.hash(indentionUnit, indentionType);
  }
}
