package org.example.analysis.feature.impl;

import org.example.analysis.StyleType.OptionalBrace;
import org.example.analysis.feature.featurevalue.BooleanAttrValue;
import org.example.analysis.feature.featurevalue.StyleVector;
import org.example.analysis.feature.FeatureExtractor;
import org.example.style.Style;
import org.example.style.rule.StyleRule;
import org.example.styler.body.optionalbrace.style.OptionalBraceProperty;

import java.util.Map;

public class OptionalBraceFeatureExtractor extends FeatureExtractor {
    @Override
    public void toFeatureVector(Style style, Map<String, StyleVector> st2svMap) {
        StyleVector sv = new StyleVector();
        for (StyleRule rule : style.getRules()) {
            if (rule.getStyleProperty() instanceof OptionalBraceProperty property) {
                sv.addAttrValue(OptionalBrace.useBracesAttr, new BooleanAttrValue(property.useBrace));
            }
        }
        st2svMap.put(OptionalBrace.styleType, sv);
    }

}
