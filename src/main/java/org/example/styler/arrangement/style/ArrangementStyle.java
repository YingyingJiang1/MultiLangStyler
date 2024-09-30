package org.example.styler.arrangement.style;

import org.antlr.v4.runtime.Parser;
import org.dom4j.Element;
import org.example.style.Style;
import org.example.style.StyleContext;
import org.example.style.StyleProperty;
import org.example.style.StyleRule;

import java.util.ArrayList;
import java.util.List;

/*
 * @description
 * @author       Yingying Jiang
 * @create       2024/2/1 14:31
 */
public class ArrangementStyle extends Style {
    
    public ArrangementStyle() {
        styleName = "Arrangement";
        rules = new ArrayList<>();
    }

    public void addElement(Element parent, Parser parser) {
        Element arrangementsEle = parent.addElement("rules");
        for (StyleRule styleRule : rules) {
            ArrangementRule rule = (ArrangementRule) styleRule;
            Element arrangementEle = arrangementsEle.addElement("arrangement");
            rule.styleContext.addElement(arrangementEle, parser);
            Element areasEle = arrangementEle.addElement("areas");
            for (ArrangementProperty.ContentArea area : rule.getStyleProperty().getAreas()) {
                area.addElement(areasEle, parser);
            }
        }
    }

    public Object parseElement(Element parent, Parser parser) {
        Element arrangementsEle = parent.element("rules");
        List<Element> arrangementEleList = arrangementsEle.elements();
        for (Element arrangementEle : arrangementEleList) {
            ArrangementContext context = new ArrangementContext();
            context.parseElement(arrangementEle, parser);
            ArrangementProperty property = new ArrangementProperty();
            List<Element> areaEleList = arrangementEle.element("areas").elements();
            for (Element areaEle : areaEleList) {
                property.areas.add(ArrangementProperty.ContentArea.parseElement(areaEle, parser));
            }
            rules.add(new ArrangementRule(context, property));
        }
        return this;
    }

    public boolean contains(ArrangementContext context) {
        for (StyleRule styleRule : rules) {
            ArrangementRule rule = (ArrangementRule) styleRule;
            if (rule.getStyleContext().include(context)) {
                return true;
            }
        }
        return false;
    }

    public ArrangementProperty getContentArrangement(ArrangementContext context) {
        int maxInclusionDegree = Integer.MIN_VALUE;
        ArrangementProperty property = new ArrangementProperty();
        ArrangementProperty res = new ArrangementProperty();
        for (StyleRule styleRule : rules) {
            ArrangementRule rule = (ArrangementRule) styleRule;
            int inclusionDegree = rule.getStyleContext().inclusionDegree(context);
            if (inclusionDegree > maxInclusionDegree) {
                res = getProperty(rule.styleContext);
                maxInclusionDegree = inclusionDegree;
            }
        }
        return res;
    }

    public void addContentArrangement(ArrangementContext context, ArrangementProperty property) {
        rules.add(new ArrangementRule(context, property));
    }

    @Override
    public void addRule(StyleContext styleContext, StyleProperty styleProperty) {
        ArrangementRule rule = new ArrangementRule((ArrangementContext) styleContext, (ArrangementProperty) styleProperty);
        rules.add(rule);
    }

    @Override
    public ArrangementProperty getProperty(StyleContext styleContext) {
        ArrangementContext targetContext = (ArrangementContext) styleContext;
        for (StyleRule styleRule : rules) {
            ArrangementRule rule = (ArrangementRule) styleRule;
            if (rule.styleContext.equals(targetContext)) {
                return rule.getStyleProperty();
            }
        }
        return null;
    }
}
