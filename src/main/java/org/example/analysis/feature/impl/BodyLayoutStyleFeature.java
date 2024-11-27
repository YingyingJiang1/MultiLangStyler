package org.example.analysis.feature.impl;

import org.example.analysis.feature.featurevalue.FeatureValue;
import org.example.analysis.feature.featurevalue.StyleVector;
import org.example.analysis.feature.StyleFeature;
import org.example.analysis.feature.featurevalue.VectorFeatureValue;
import org.example.style.Style;
import org.example.style.rule.StyleRule;
import org.example.styler.format.body.style.BodyLayoutContext;
import org.example.styler.format.body.style.BodyLayoutProperty;

import java.util.List;
import java.util.Map;

public class BodyLayoutStyleFeature extends StyleFeature {
    @Override
    public void toFeatureVector(Style style, Map<String, StyleVector> styleFeatures) {
        StyleVector fv = new StyleVector();
        for (StyleRule rule : style.getRules()) {
            if (rule.getStyleContext() instanceof BodyLayoutContext context &&
                    rule.getStyleProperty() instanceof BodyLayoutProperty property) {
                String fName = generateFeatureName(context);
                FeatureValue fValue = new VectorFeatureValue(List.of(
                        property.beforeLB, property.afterLB, property.beforeRB, property.afterRB
                ));
                fv.addFeature(fName, fValue);
            }
        }

        styleFeatures.put("Brace format", fv);
    }

    private String generateFeatureName(BodyLayoutContext context) {
        String typeName = context.blockType.name();
        String innerStmt = context.bodyType.name().toLowerCase();
        return typeName.charAt(0) + typeName.substring(1).toLowerCase() + "-" + innerStmt;
    }
}
