package org.example.styler.arrangement.style;

import org.antlr.v4.runtime.Parser;
import org.dom4j.Element;
import org.example.style.Style;
import org.example.style.StyleContext;
import org.example.style.StyleProperty;

import java.util.ArrayList;
import java.util.List;

/*
 * @description
 * @author       Yingying Jiang
 * @create       2024/2/1 14:31
 */
public class ArrangementStyle extends Style {

    private List<ArrangementRule> arrangements;

    public ArrangementStyle() {
        styleName = "Arrangement";
        arrangements = new ArrayList<>();
    }

    public void addElement(Element parent, Parser parser) {
        Element arrangementsEle = parent.addElement("arrangements");
        for (ArrangementRule rule : arrangements) {
            Element arrangementEle = arrangementsEle.addElement("arrangement");
            rule.arrangementContext.addElement(arrangementEle, parser);
            Element areasEle = arrangementEle.addElement("areas");
            for (ArrangementProperty.ContentArea area : rule.arrangementProperty.getAreas()) {
                area.addElement(areasEle, parser);
            }
        }
    }

    public Object parseElement(Element parent, Parser parser) {
        Element arrangementsEle = parent.element("arrangements");
        List<Element> arrangementEleList = arrangementsEle.elements();
        for (Element arrangementEle : arrangementEleList) {
            ArrangementContext context = (ArrangementContext) ArrangementContext.parseElement(arrangementEle, parser);
            ArrangementProperty property = new ArrangementProperty();
            List<Element> areaEleList = arrangementEle.element("areas").elements();
            for (Element areaEle : areaEleList) {
                property.areas.add(ArrangementProperty.ContentArea.parseElement(areaEle, parser));
            }
            arrangements.add(new ArrangementRule(context, property));
        }
        return this;
    }

    public boolean contains(ArrangementContext context) {
        for (ArrangementRule rule : arrangements) {
            if (rule.arrangementContext.include(context)) {
                return true;
            }
        }
        return false;
    }

    public ArrangementProperty getContentArrangement(ArrangementContext context) {
        int maxInclusionDegree = Integer.MIN_VALUE;
        ArrangementProperty property = new ArrangementProperty();
        ArrangementProperty res = new ArrangementProperty();
        for (ArrangementRule rule : arrangements) {
            int inclusionDegree = rule.arrangementContext.inclusionDegree(context);
            if (inclusionDegree > maxInclusionDegree) {
                res = getProperty(rule.arrangementContext);
                maxInclusionDegree = inclusionDegree;
            }
        }
        return res;
    }

    public void addContentArrangement(ArrangementContext context, ArrangementProperty property) {
        arrangements.add(new ArrangementRule(context, property));
    }

    @Override
    public void addRule(StyleContext styleContext, StyleProperty styleProperty) {
        ArrangementRule rule = new ArrangementRule((ArrangementContext) styleContext, (ArrangementProperty) styleProperty);
        arrangements.add(rule);
    }

    @Override
    public ArrangementProperty getProperty(StyleContext styleContext) {
        ArrangementContext targetContext = (ArrangementContext) styleContext;
        for (ArrangementRule rule : arrangements) {
            if (rule.arrangementContext.equals(targetContext)) {
                return rule.arrangementProperty;
            }
        }
        return null;
    }
}
