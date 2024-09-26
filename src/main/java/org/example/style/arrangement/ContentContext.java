package org.example.style.arrangement;

import org.antlr.v4.runtime.Parser;
import org.dom4j.Attribute;
import org.dom4j.Element;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @description
 * @author       Yingying Jiang
 * @create       2024/3/25 21:43
 */
public class ContentContext {
  String typeType;
  Map<String, Integer> statistic = new HashMap<>();

  public ContentContext() {}
  public ContentContext(String typeType, Map<String, Integer> statistic) {
    this.typeType = typeType;
    this.statistic = statistic;
  }

  public void addElement(Element parent, Parser parser) {
    Element contentEle = parent.addElement("content_context");
    contentEle.addText(typeType);
    for(Map.Entry<String, Integer> entry : statistic.entrySet()) {
      contentEle.addAttribute(entry.getKey(), entry.getValue().toString());
    }
  }

  // Calculate the degree that $this including $contentContext.
  public int inclusionDegree(ContentContext contentContext) {
    int degree = typeType.equals(contentContext.typeType) ? 1 : -1;
    for(Map.Entry<String, Integer> entry : statistic.entrySet()) {
      Integer value = contentContext.statistic.get(entry.getKey());
      if(value != null && entry.getValue() >= value) {
        ++degree;
      } else {
        --degree;
      }
    }
    return degree;
  }

  public boolean include(ContentContext contentContext) {
    if(!typeType.equals(contentContext.typeType)) {
      return false;
    }
    for(Map.Entry<String, Integer> entry : contentContext.statistic.entrySet()) {
      Integer value = statistic.get(entry.getKey());
      if(value == null || entry.getValue() >= value) {
        return false;
      }
    }
    return true;
  }


  public static ContentContext parseElement(Element parent, Parser parser) {
    Element contentEle = parent.element("content_context");
    ContentContext contentContext = new ContentContext();
    contentContext.typeType = contentEle.getText();
    List<Attribute> attributes = contentEle.attributes();
    for(Attribute attribute : attributes) {
      contentContext.statistic.put(attribute.getName(), Integer.parseInt(attribute.getValue()));
    }
    return contentContext;
  }

}
