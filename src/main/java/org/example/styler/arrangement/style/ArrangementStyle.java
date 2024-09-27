package org.example.styler.arrangement.style;

import org.antlr.v4.runtime.Parser;
import org.dom4j.Element;
import org.example.style.Style;
import org.example.style.StyleContext;
import org.example.style.StyleProperty;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @description
 * @author       Yingying Jiang
 * @create       2024/2/1 14:31
 */
public class ArrangementStyle extends Style {

    private Map<ArrangementContext, ArrangementProperty> arrangements;

    public ArrangementStyle() {
        styleName = "Arrangement";
        arrangements = new HashMap<>();
    }

    public void addElement(Element parent, Parser parser) {
        Element arrangementsEle = parent.addElement("arrangements");
        for (Map.Entry<ArrangementContext, ArrangementProperty> entry : arrangements.entrySet()) {
            Element arrangementEle = arrangementsEle.addElement("arrangement");
            entry.getKey().addElement(arrangementEle, parser);
            Element areasEle = arrangementEle.addElement("areas");
            for (ArrangementProperty.ContentArea area : entry.getValue().getAreas()) {
                area.addElement(areasEle, parser);
            }
        }
    }

    public Object parseElement(Element parent, Parser parser) {
        Element arrangementsEle = parent.element("arrangements");
        List<Element> arrangementEleList = arrangementsEle.elements();
        for (Element arrangementEle : arrangementEleList) {
            ArrangementContext arrangementContext = (ArrangementContext) ArrangementContext.parseElement(arrangementEle, parser);
            ArrangementProperty arrangementProperty = new ArrangementProperty();
            List<Element> areaEleList = arrangementEle.element("areas").elements();
            for (Element areaEle : areaEleList) {
                arrangementProperty.areas.add(ArrangementProperty.ContentArea.parseElement(areaEle, parser));
            }
            arrangements.put(arrangementContext, arrangementProperty);
        }
        return this;
    }

    public boolean contains(ArrangementContext arrangementContext) {
        for (ArrangementContext arrangementContext1 : arrangements.keySet()) {
            if (arrangementContext1.include(arrangementContext)) {
                return true;
            }
        }
        return false;
    }

    public ArrangementProperty getContentArrangement(ArrangementContext arrangementContext) {
        int maxInclusionDegree = Integer.MIN_VALUE;
        ArrangementProperty arrangementProperty = new ArrangementProperty();
        ArrangementProperty res = new ArrangementProperty();
        for (ArrangementContext arrangementContext1 : arrangements.keySet()) {
            int inclusionDegree = arrangementContext1.inclusionDegree(arrangementContext);
            if (inclusionDegree > maxInclusionDegree) {
                res = arrangements.get(arrangementContext1);
                maxInclusionDegree = inclusionDegree;
            }
        }
        return res;
    }

    public void addContentArrangement(ArrangementContext arrangementContext, ArrangementProperty arrangementProperty) {
        arrangements.put(arrangementContext, arrangementProperty);
    }

  @Override
  public void addRule(StyleContext styleContext, StyleProperty styleProperty) {
    arrangements.put((ArrangementContext) styleContext, (ArrangementProperty) styleProperty);
  }

  @Override
  public ArrangementProperty getProperty(StyleContext styleContext) {
    return (ArrangementProperty) arrangements.get((ArrangementContext) styleContext);
  }
}
