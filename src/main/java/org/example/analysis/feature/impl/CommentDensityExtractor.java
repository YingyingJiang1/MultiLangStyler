package org.example.analysis.feature.impl;

import org.example.analysis.StyleType.CommentDensity;
import org.example.analysis.feature.StyleFeatureExtractor;
import org.example.analysis.feature.featurevalue.DoubleAttrValue;
import org.example.analysis.feature.featurevalue.StyleVector;
import org.example.style.Style;
import org.example.style.rule.StyleRule;
import org.example.styler.comment.density.style.CommentDensityProperty;

import java.util.Map;

public class CommentDensityExtractor extends StyleFeatureExtractor {
    @Override
    public void toFeatureVector(Style style, Map<String, StyleVector> st2svMap) {
        StyleVector sv = new StyleVector();
        for (StyleRule rule : style.getRules()) {
            if (rule.getStyleProperty() instanceof CommentDensityProperty property) {
                sv.addAttrValue(CommentDensity.LineDensityAttr, new DoubleAttrValue(property.lineDensity));
            }
        }

        st2svMap.put(CommentDensity.styleType, sv);
    }
}
