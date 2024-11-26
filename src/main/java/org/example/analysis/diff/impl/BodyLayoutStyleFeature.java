package org.example.analysis.diff.impl;

import org.example.analysis.diff.feature.FeatureValue;
import org.example.analysis.diff.feature.FeatureVector;
import org.example.analysis.diff.StyleFeature;
import org.example.analysis.diff.feature.VectorFeatureValue;
import org.example.style.CommonStyle;
import org.example.style.rule.StyleRule;
import org.example.styler.format.body.style.BodyLayoutContext;
import org.example.styler.format.body.style.BodyLayoutProperty;

import java.util.List;
import java.util.Map;

public class BodyLayoutStyleFeature extends StyleFeature {
    @Override
    public void toFeatureVector(CommonStyle commonStyle, Map<String, FeatureVector> styleFeatures) {
        FeatureVector fv = new FeatureVector();
        for (StyleRule rule : commonStyle.getRules()) {
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
        String innerStmt = context.stmtNumInBlock == 0 ? "empty" :
                context.stmtNumInBlock == 1 ? "single" : "multiple";
        return typeName.charAt(0) + typeName.substring(1).toLowerCase() + "-" + innerStmt;
    }
}
