package org.example.analysis.feature.impl;

import org.example.analysis.feature.featurevalue.FeatureValue;
import org.example.analysis.feature.featurevalue.StyleVector;
import org.example.analysis.feature.StyleFeature;
import org.example.analysis.feature.featurevalue.VectorFeatureValue;
import org.example.style.Style;
import org.example.style.rule.StyleRule;
import org.example.styler.format.space.style.SpaceContext;
import org.example.styler.format.space.style.SpaceProperty;

import java.util.List;
import java.util.Map;

public class SpaceStyleFeature extends StyleFeature {
    @Override
    public void toFeatureVector(Style style, Map<String, StyleVector> styleFeatures) {
        StyleVector fv = new StyleVector();
        for (StyleRule rule : style.getRules()) {
            if (rule.getStyleContext() instanceof SpaceContext context &&
            rule.getStyleProperty() instanceof SpaceProperty property) {
                String fName = generateFeatureName(context);
                FeatureValue fValue = context.tokenName2 == "" ?
                        new VectorFeatureValue(List.of(property.space1, property.space2)) :
                        new VectorFeatureValue(List.of(property.space1));
                fv.addFeature(fName, fValue);
            }
        }
        styleFeatures.put("Space", fv);
    }

    private String generateFeatureName(SpaceContext context) {
        if (context.tokenName2 == "") {
            return "Around " + context.tokenName1;
        } else {
            return "Between" + context.tokenName1 + "and" + context.tokenName2;
        }
    }
}
