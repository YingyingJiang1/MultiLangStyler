package org.example.analysis.feature.impl;

import org.example.analysis.feature.featurevalue.StyleVector;
import org.example.analysis.feature.StyleFeature;
import org.example.analysis.feature.featurevalue.VectorFeatureValue;
import org.example.style.Style;
import org.example.style.rule.StyleRule;
import org.example.styler.brace.style.OptionalBraceProperty;

import java.util.List;
import java.util.Map;

public class OptionalBraceStyleFeature extends StyleFeature {
    @Override
    public void toFeatureVector(Style style, Map<String, StyleVector> styleFeatures) {
        StyleVector fv1 = new StyleVector();
        StyleVector fv2 = null;
        for (StyleRule rule : style.getRules()) {
            if (rule.getStyleProperty() instanceof OptionalBraceProperty property) {
                fv1.addFeature("Use brace", new VectorFeatureValue(List.of(property.useBrace)));
                if (!property.useBrace) {
                    fv2 = new StyleVector();
                    fv2.addFeature("Compact style", new VectorFeatureValue(List.of(property.compactStyle)));
                }
            }
        }
        styleFeatures.put("Optional brace", fv1);
        styleFeatures.put("Layout of control statement without braces", fv2);
    }

}
