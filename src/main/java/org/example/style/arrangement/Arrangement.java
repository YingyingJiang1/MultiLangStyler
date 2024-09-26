package org.example.style.arrangement;

import org.antlr.v4.runtime.Parser;
import org.dom4j.Element;
import org.example.style.Style;
import org.example.style.arrangement.Area.ContentArea;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @description
 * @author       Yingying Jiang
 * @create       2024/2/1 14:31
 */
public class Arrangement extends Style {

  private Map<ContentContext, List<ContentArea>> arrangements;

  public Arrangement() {
    styleName = "Arrangement";
    arrangements = new HashMap<>();
  }

  @Override
  public void addElement(Element parent, Parser parser) {
    Element arrangementsEle = parent.addElement("arrangements");
    for(Map.Entry<ContentContext, List<ContentArea>> entry : arrangements.entrySet()) {
      Element arrangementEle = arrangementsEle.addElement("arrangement");
      entry.getKey().addElement(arrangementEle, parser);
      Element areasEle = arrangementEle.addElement("areas");
      for(ContentArea area : entry.getValue()) {
        area.addElement(areasEle, parser);
      }
    }
  }

  @Override
  public Object parseElement(Element parent, Parser parser) {
    Element arrangementsEle = parent.element("arrangements");
    List<Element> arrangementEleList = arrangementsEle.elements();
    for(Element arrangementEle : arrangementEleList) {
      ContentContext contentContext = ContentContext.parseElement(arrangementEle, parser);
      List<ContentArea> areas = new ArrayList<>();
      List<Element> areaEleList = arrangementEle.element("areas").elements();
      for(Element areaEle : areaEleList) {
        areas.add(ContentArea.parseElement(areaEle, parser));
      }
      arrangements.put(contentContext, areas);
    }
    return this;
  }

  public boolean contains(ContentContext contentContext) {
    for(ContentContext contentContext1 : arrangements.keySet()) {
      if(contentContext1.include(contentContext)) {
        return true;
      }
    }
    return false;
  }

  public List<ContentArea> getContentArrangement(ContentContext contentContext) {
    int maxInclusionDegree = Integer.MIN_VALUE;
    List<ContentArea> res = new ArrayList<>(0);
    for(ContentContext contentContext1 : arrangements.keySet()) {
      int inclusionDegree = contentContext1.inclusionDegree(contentContext);
      if(inclusionDegree > maxInclusionDegree) {
        res = arrangements.get(contentContext1);
        maxInclusionDegree = inclusionDegree;
      }
    }
    return res;
  }

  public void addContentArrangement(ContentContext contentContext, List<ContentArea> areas) {
    arrangements.put(contentContext, areas);
  }
}
