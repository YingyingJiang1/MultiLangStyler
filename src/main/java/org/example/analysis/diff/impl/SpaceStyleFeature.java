package org.example.analysis.diff.impl;

import org.example.analysis.diff.feature.FeatureValue;
import org.example.analysis.diff.feature.FeatureVector;
import org.example.analysis.diff.StyleFeature;
import org.example.analysis.diff.feature.VectorFeatureValue;
import org.example.style.CommonStyle;
import org.example.style.rule.StyleRule;
import org.example.styler.format.space.style.SpaceContext;
import org.example.styler.format.space.style.SpaceProperty;

import java.util.List;
import java.util.Map;

public class SpaceStyleFeature extends StyleFeature {
    @Override
    public Map<String, FeatureVector> toFeatureVector(CommonStyle commonStyle) {
        FeatureVector fv = new FeatureVector();
        for (StyleRule rule : commonStyle.getRules()) {
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
        return styleFeatures;
    }

    private String generateFeatureName(SpaceContext context) {
        if (context.tokenName2 == "") {
            return "Around " + context.tokenName1;
        } else {
            return "Between" + context.tokenName1 + "and" + context.tokenName2;
        }
    }
}
