package org.example.analysis.feature.impl.style;

import org.example.analysis.StyleType;
import org.example.analysis.feature.StyleFeatureExtractor;
import org.example.analysis.feature.featurevalue.DoubleAttrValue;
import org.example.analysis.feature.featurevalue.StyleVector;
import org.example.style.Style;
import org.example.style.rule.StyleRule;
import org.example.styler.comment.density.style.CommentDensityProperty;

import java.util.Map;

public class CommentDensity implements StyleFeatureExtractor {
    @Override
    public void toFeatureVector(Style style, Map<String, StyleVector> st2svMap) {
        StyleVector sv = new StyleVector();
        for (StyleRule rule : style.getRules()) {
            if (rule.getStyleProperty() instanceof CommentDensityProperty property) {
                sv.addAttrValue(StyleType.CommentDensity.LineDensityAttr, new DoubleAttrValue(property.lineDensity));
            }
        }

        st2svMap.put(StyleType.CommentDensity.styleType, sv);
    }
}
