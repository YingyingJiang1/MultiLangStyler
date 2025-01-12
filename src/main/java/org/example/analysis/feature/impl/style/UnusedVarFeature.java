package org.example.analysis.feature.impl.style;

import org.example.analysis.StyleType;
import org.example.analysis.feature.StyleFeatureExtractor;
import org.example.analysis.feature.featurevalue.BooleanAttrValue;
import org.example.analysis.feature.featurevalue.StyleVector;
import org.example.style.Style;
import org.example.style.rule.StyleRule;
import org.example.styler.practice.style.UnusedCodeProperty;

import java.util.Map;

public class UnusedVarFeature implements StyleFeatureExtractor {
    @Override
    public void toFeatureVector(Style style, Map<String, StyleVector> st2svMap) {
        StyleVector sv = new StyleVector();
        for (StyleRule rule : style.getRules()) {
            if (rule.getStyleProperty() instanceof UnusedCodeProperty property) {
                sv.addAttrValue(StyleType.UnusedVar.unusedVarAttr, new BooleanAttrValue(property.hasUnusedVar));
            }
        }
        st2svMap.put(StyleType.UnusedVar.styleType, sv);
    }
}
