package org.example.analysis.feature.impl;

import org.example.analysis.feature.featurevalue.FeatureVector;
import org.example.analysis.feature.StyleFeature;
import org.example.analysis.feature.featurevalue.DoubleFeatureValue;
import org.example.analysis.feature.featurevalue.VectorFeatureValue;
import org.example.style.Style;
import org.example.style.rule.StyleRule;
import org.example.styler.format.indention.style.IndentionProperty;

import java.util.List;
import java.util.Map;

public class IndentionStyleFeature extends StyleFeature {
    @Override
    public void toFeatureVector(Style style, Map<String, FeatureVector> styleFeatures) {
        FeatureVector fv = new FeatureVector();
        for (StyleRule rule : style.getRules()) {
            if (rule.getStyleProperty() instanceof IndentionProperty property) {
                fv.addFeature("Indention unit", new DoubleFeatureValue(property.indentionUnit));
                fv.addFeature("Indention type", new VectorFeatureValue(List.of(property.indentionType == ' ')));
            }
        }
        styleFeatures.put("Indention", fv);
    }

}
