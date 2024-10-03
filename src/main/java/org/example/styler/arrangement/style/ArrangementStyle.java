package org.example.styler.arrangement.style;

import org.antlr.v4.runtime.Parser;
import org.dom4j.Element;
import org.example.interfaces.Style;
import org.example.interfaces.StyleContext;
import org.example.interfaces.StyleProperty;
import org.example.interfaces.StyleRule;

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
    }

    public void addElement(Element parent, Parser parser) {
        Element arrangementsEle = parent.addElement("rules");
        for (StyleRule styleRule : rules) {
            Element arrangementEle = arrangementsEle.addElement("arrangement");
            styleRule.getStyleContext().addElement(arrangementEle, parser);
            Element areasEle = arrangementEle.addElement("areas");
            ArrangementProperty property = (ArrangementProperty) styleRule.getStyleProperty();
            for (ArrangementProperty.ContentArea area : property.getAreas()) {
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
            rules.add(new StyleRule(context, property));
        }
        return this;
    }

    public boolean contains(ArrangementContext targetContext) {
        for (StyleRule rule : rules) {
            ArrangementContext context = (ArrangementContext) rule.getStyleContext();
            if (context.include(targetContext)) {
                return true;
            }
        }
        return false;
    }

    public ArrangementProperty getContentArrangement(ArrangementContext context) {
        int maxInclusionDegree = Integer.MIN_VALUE;
        ArrangementProperty res = new ArrangementProperty();
        for (StyleRule styleRule : rules) {
            ArrangementContext context1 = (ArrangementContext) styleRule.getStyleContext();
            int inclusionDegree = context1.inclusionDegree(context);
            if (inclusionDegree > maxInclusionDegree) {
                res = (ArrangementProperty) getProperty(styleRule.getStyleContext());
                maxInclusionDegree = inclusionDegree;
            }
        }
        return res;
    }

    public void addContentArrangement(ArrangementContext context, ArrangementProperty property) {
        rules.add(new StyleRule(context, property));
    }

    @Override
    public void addRule(StyleContext styleContext, StyleProperty styleProperty) {
        StyleRule rule = new StyleRule((ArrangementContext) styleContext, (ArrangementProperty) styleProperty);
        rules.add(rule);
    }
}
