package org.example.analysis.feature.impl;

import org.example.analysis.feature.StyleFeature;
import org.example.analysis.feature.featurevalue.FeatureVector;
import org.example.analysis.feature.featurevalue.VectorFeatureValue;
import org.example.style.Style;
import org.example.style.rule.StyleRule;
import org.example.styler.format.linestmt.style.LineStmtProperty;

import java.util.List;
import java.util.Map;

public class LineStmtStyleFeature extends StyleFeature {
    public void toFeatureVector(Style style, Map<String, FeatureVector> styleFeatures) {
        FeatureVector fv = new FeatureVector();
        for (StyleRule rule : style.getRules()) {
            if (rule.getStyleProperty() instanceof LineStmtProperty property) {
                styleFeatures.put("Line statement", new FeatureVector());
                fv.addFeature("One line one statement", new VectorFeatureValue(List.of(property.isOneStmtPerLine)));
            }
        }
        styleFeatures.put("One statement in one line", fv);
    }
}
