package org.example.analysis.feature.impl;

import org.example.analysis.StyleType.LayoutOfControlStmtWithoutBraces;
import org.example.analysis.feature.StyleFeature;
import org.example.analysis.feature.featurevalue.BooleanAttrValue;
import org.example.analysis.feature.featurevalue.StyleVector;
import org.example.style.Style;
import org.example.style.rule.StyleRule;
import org.example.styler.body.layout.style.BodyLayoutProperty;

import java.util.Map;

public class BodyLayoutStyleFeature extends StyleFeature {

    @Override
    public void toFeatureVector(Style style, Map<String, StyleVector> st2svMap) {
        StyleVector sv = new StyleVector();
        for (StyleRule rule : style.getRules()) {
            if (rule.getStyleProperty() instanceof BodyLayoutProperty property) {
                sv.addAttrValue(LayoutOfControlStmtWithoutBraces.inCompactModeAttr, new BooleanAttrValue(property.compactStyle));
            }
        }
        st2svMap.put(LayoutOfControlStmtWithoutBraces.styleType, sv);
    }
}
