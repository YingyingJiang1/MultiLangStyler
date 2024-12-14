package org.example.analysis.feature.impl.style;

import org.example.analysis.StyleType.MostComplexExp;
import org.example.analysis.feature.StyleFeatureExtractor;
import org.example.analysis.feature.featurevalue.DoubleAttrValue;
import org.example.analysis.feature.featurevalue.MapAttrValue;
import org.example.analysis.feature.featurevalue.StyleVector;
import org.example.style.Style;
import org.example.style.rule.StyleRule;
import org.example.styler.exp.style.ExpressionContext;
import org.example.styler.exp.style.ExpressionProperty;

import java.util.Map;

public class MostComplexExpFeature implements StyleFeatureExtractor {

    @Override
    public void toFeatureVector(Style style, Map<String, StyleVector> st2svMap) {
        StyleVector sv = new StyleVector();
        for (StyleRule rule : style.getRules()) {
            if (rule.getStyleContext() instanceof ExpressionContext context &&
                    rule.getStyleProperty() instanceof ExpressionProperty property) {
                MapAttrValue mapAttrValue = new MapAttrValue();
                mapAttrValue.addValue(MostComplexExp.maxLengthAttr, new DoubleAttrValue(property.maxExpressionLength));
                mapAttrValue.addValue(MostComplexExp.maxSubExpNum, new DoubleAttrValue(property.maxSubExpNum));
                sv.addAttrValue(context.expType.name(), mapAttrValue);
            }
        }
        st2svMap.put(MostComplexExp.styleType, sv);
    }
}
