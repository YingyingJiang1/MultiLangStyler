package org.example.analysis.feature.impl.style;

import org.example.analysis.StyleType.OrderOfIfElseBodies;
import org.example.analysis.feature.StyleFeatureExtractor;
import org.example.analysis.feature.featurevalue.BooleanAttrValue;
import org.example.analysis.feature.featurevalue.StyleVector;
import org.example.style.Style;
import org.example.style.rule.StyleRule;
import org.example.styler.ifelse.bodyorder.style.IfElseBodyOrderProperty;

import java.util.Map;

public class IfElseBodyOrderFeature implements StyleFeatureExtractor {
    @Override
    public void toFeatureVector(Style style, Map<String, StyleVector> st2svMap) {
        StyleVector sv = new StyleVector();
        for (StyleRule rule : style.getRules()) {
            if (rule.getStyleProperty() instanceof IfElseBodyOrderProperty property) {
                sv.addAttrValue(OrderOfIfElseBodies.shortBodyComesFirstAttr, new BooleanAttrValue(property.shortBodyComesFirst));
            }
        }
        st2svMap.put(OrderOfIfElseBodies.styleType, sv);
    }
}
