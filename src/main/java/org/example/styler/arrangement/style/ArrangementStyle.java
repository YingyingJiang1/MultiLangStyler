package org.example.styler.arrangement.style;

import org.antlr.v4.runtime.Parser;
import org.dom4j.Element;
import org.example.parser.common.MyParser;
import org.example.style.Style;
import org.example.style.rule.StyleRule;

/*
 * @description
 * @author       Yingying Jiang
 * @create       2024/2/1 14:31
 */
public class ArrangementStyle extends Style {
    
    public ArrangementStyle(MyParser parser) {
        super(parser);
        styleName = "Arrangement";
    }

    public void addElement(Element parent, Parser parser) {
        addListElement(parent, parser, ruleSet, "arrangement_rule", null);
    }

    public Object parseElement(Element parent, Parser parser) {
        parseListElement(parent, parser, ruleSet, "arrangement_rule");
        return this;
    }

    @Override
    protected StyleRule createRule(String propertyName) {
        ArrangementContext context = new ArrangementContext();
        ArrangementProperty property = new ArrangementProperty();
        return new StyleRule(context, property);
    }


//    public ArrangementProperty getContentArrangement(ArrangementContext context) {
//        int maxInclusionDegree = Integer.MIN_VALUE;
//        ArrangementProperty res = new ArrangementProperty();
//        for (StyleRule styleRule : rules) {
//            ArrangementContext context1 = (ArrangementContext) styleRule.getStyleContext();
//            int inclusionDegree = context1.inclusionDegree(context);
//            if (inclusionDegree > maxInclusionDegree) {
//                res = (ArrangementProperty) getProperty(styleRule.getStyleContext());
//                maxInclusionDegree = inclusionDegree;
//            }
//        }
//        return res;
//    }
//
//    public void addContentArrangement(ArrangementContext context, ArrangementProperty property) {
//
//        rules.add(new StyleRule(context, property));
//    }
}
