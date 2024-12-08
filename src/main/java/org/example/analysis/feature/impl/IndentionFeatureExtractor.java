package org.example.analysis.feature.impl;

import org.example.analysis.StyleType.Indention;
import org.example.analysis.feature.StyleFeatureExtractor;
import org.example.analysis.feature.featurevalue.StringAttrValue;
import org.example.analysis.feature.featurevalue.StyleVector;
import org.example.analysis.feature.featurevalue.DoubleAttrValue;
import org.example.style.Style;
import org.example.style.rule.StyleRule;
import org.example.styler.format.indention.style.IndentionProperty;

import java.util.Map;

public class IndentionFeatureExtractor extends StyleFeatureExtractor {
    @Override
    public void toFeatureVector(Style style, Map<String, StyleVector> st2svMap) {
        StyleVector sv = new StyleVector();
        for (StyleRule rule : style.getRules()) {
            if (rule.getStyleProperty() instanceof IndentionProperty property) {
                sv.addAttrValue(Indention.indentationUnitAttr, new DoubleAttrValue(property.indentionUnit));
                sv.addAttrValue(Indention.indentionTypeAttr, new StringAttrValue(Character.toString(property.indentionType)));
            }
        }
        st2svMap.put(Indention.styleType, sv);
    }
}
