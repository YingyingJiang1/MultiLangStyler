package org.example.analysis.diff.impl;

import org.example.analysis.diff.feature.FeatureVector;
import org.example.analysis.diff.StyleFeature;
import org.example.analysis.diff.feature.DoubleFeatureValue;
import org.example.analysis.diff.feature.VectorFeatureValue;
import org.example.style.CommonStyle;
import org.example.style.rule.StyleRule;
import org.example.styler.format.indention.style.IndentionProperty;

import java.util.List;
import java.util.Map;

public class IndentionStyleFeature extends StyleFeature {
    @Override
    public void toFeatureVector(CommonStyle commonStyle, Map<String, FeatureVector> styleFeatures) {
        FeatureVector fv = new FeatureVector();
        for (StyleRule rule : commonStyle.getRules()) {
            if (rule.getStyleProperty() instanceof IndentionProperty property) {
                fv.addFeature("Indention unit", new DoubleFeatureValue(property.indentionUnit));
                fv.addFeature("Indention type", new VectorFeatureValue(List.of(property.indentionType == ' ')));
            }
        }
        styleFeatures.put("Indention", fv);
    }

}
