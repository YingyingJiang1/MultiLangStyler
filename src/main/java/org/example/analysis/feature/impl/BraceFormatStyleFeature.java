package org.example.analysis.feature.impl;

import org.example.analysis.feature.featurevalue.FeatureValue;
import org.example.analysis.feature.featurevalue.StyleVector;
import org.example.analysis.feature.StyleFeature;
import org.example.analysis.feature.featurevalue.VectorFeatureValue;
import org.example.style.Style;
import org.example.style.rule.StyleRule;
import org.example.styler.body.BodyContext;
import org.example.styler.body.braceformat.style.BraceFormatProperty;

import java.util.List;
import java.util.Map;

public class BraceFormatStyleFeature extends StyleFeature {
    @Override
    public void toFeatureVector(Style style, Map<String, StyleVector> styleFeatures) {
        StyleVector fv = new StyleVector();
        for (StyleRule rule : style.getRules()) {
            if (rule.getStyleContext() instanceof BodyContext context &&
                    rule.getStyleProperty() instanceof BraceFormatProperty property) {
                String fName = generateFeatureName(context);
                FeatureValue fValue = new VectorFeatureValue(List.of(
                        property.beforeLB, property.afterLB, property.beforeRB, property.afterRB
                ));
                fv.addFeature(fName, fValue);
            }
        }

        styleFeatures.put("Brace format", fv);
    }

    private String generateFeatureName(BodyContext context) {
        String typeName = context.bodyType.name();
        String innerStmt = context.bodyNumType.name().toLowerCase();
        return typeName.charAt(0) + typeName.substring(1).toLowerCase() + "-" + innerStmt;
    }
}
