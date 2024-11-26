package org.example.analysis.diff.impl;

import org.example.analysis.diff.StyleFeature;
import org.example.analysis.diff.feature.FeatureVector;
import org.example.analysis.diff.feature.VectorFeatureValue;
import org.example.style.CommonStyle;
import org.example.style.rule.StyleRule;
import org.example.styler.format.linestmt.style.LineStmtProperty;

import java.util.List;
import java.util.Map;

public class LineStmtStyleFeature extends StyleFeature {
    public void toFeatureVector(CommonStyle commonStyle, Map<String, FeatureVector> styleFeatures) {
        FeatureVector fv = new FeatureVector();
        for (StyleRule rule : commonStyle.getRules()) {
            if (rule.getStyleProperty() instanceof LineStmtProperty property) {
                styleFeatures.put("Line statement", new FeatureVector());
                fv.addFeature("One line one statement", new VectorFeatureValue(List.of(property.isOneStmtPerLine)));
            }
        }
        styleFeatures.put("One statement in one line", fv);
    }
}
