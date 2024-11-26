package org.example.analysis.diff.impl;

import org.example.analysis.diff.feature.FeatureVector;
import org.example.analysis.diff.StyleFeature;
import org.example.analysis.diff.feature.VectorFeatureValue;
import org.example.style.CommonStyle;
import org.example.style.rule.StyleRule;
import org.example.styler.brace.style.OptionalBraceProperty;

import java.util.List;
import java.util.Map;

public class OptionalBraceStyleFeature extends StyleFeature {
    @Override
    public Map<String, FeatureVector> toFeatureVector(CommonStyle commonStyle) {
        FeatureVector fv1 = new FeatureVector();
        FeatureVector fv2 = null;
        for (StyleRule rule : commonStyle.getRules()) {
            if (rule.getStyleProperty() instanceof OptionalBraceProperty property) {
                fv1.addFeature("Use brace", new VectorFeatureValue(List.of(property.useBrace)));
                if (!property.useBrace) {
                    fv2 = new FeatureVector();
                    fv2.addFeature("Compact style", new VectorFeatureValue(List.of(property.compactStyle)));
                }
            }
        }
        styleFeatures.put("Optional brace", fv1);
        styleFeatures.put("Layout of control statement without braces", fv2);
        return styleFeatures;
    }

}
