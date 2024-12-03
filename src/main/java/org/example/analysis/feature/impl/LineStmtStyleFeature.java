package org.example.analysis.feature.impl;

import org.example.analysis.feature.StyleFeature;
import org.example.analysis.feature.featurevalue.StyleVector;
import org.example.analysis.feature.featurevalue.VectorFeatureValue;
import org.example.style.Style;
import org.example.style.rule.StyleRule;
import org.example.styler.format.newline.style.NewlineProperty;

import java.util.List;
import java.util.Map;

public class LineStmtStyleFeature extends StyleFeature {
    public void toFeatureVector(Style style, Map<String, StyleVector> styleFeatures) {
        StyleVector fv = new StyleVector();
        for (StyleRule rule : style.getRules()) {
            if (rule.getStyleProperty() instanceof NewlineProperty property) {
                styleFeatures.put("Line statement", new StyleVector());
                fv.addFeature("One line one statement", new VectorFeatureValue(List.of(property.newlines == 0)));
            }
        }
        styleFeatures.put("One statement in one line", fv);
    }
}
