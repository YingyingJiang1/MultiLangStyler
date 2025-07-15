package org.example.styler.arrangement.classmember.style;

import org.example.style.CommonStyle;
import org.example.style.rule.StyleRule;

/*
 * @description
 * @author       Yingying Jiang
 * @create       2024/2/1 14:31
 */
public class ArrangementStyle extends CommonStyle {
    
    public ArrangementStyle() {
        super();
        styleName = "arrangement";
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
