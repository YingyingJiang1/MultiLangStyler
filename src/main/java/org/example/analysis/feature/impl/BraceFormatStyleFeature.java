package org.example.analysis.feature.impl;

import org.example.analysis.StyleType.BraceFormat;
import org.example.analysis.feature.featurevalue.AttrValue;
import org.example.analysis.feature.featurevalue.MapAttrValue;
import org.example.analysis.feature.featurevalue.StyleVector;
import org.example.analysis.feature.StyleFeature;
import org.example.analysis.feature.featurevalue.VectorAttrValue;
import org.example.style.Style;
import org.example.style.rule.StyleRule;
import org.example.styler.body.BodyContext;
import org.example.styler.body.braceformat.style.BraceFormatProperty;

import java.util.List;
import java.util.Map;

public class BraceFormatStyleFeature extends StyleFeature {
    @Override
    public void toFeatureVector(Style style, Map<String, StyleVector> st2svMap) {
        StyleVector sv = new StyleVector();
        MapAttrValue mapAttrValue = new MapAttrValue();

        for (StyleRule rule : style.getRules()) {
            if (rule.getStyleContext() instanceof BodyContext context &&
                    rule.getStyleProperty() instanceof BraceFormatProperty property) {
                String attrName = context.bodyType.name() + "-" + context.bodyNumType.name();
                AttrValue vectorValue = new VectorAttrValue(List.of(
                        property.beforeLB, property.afterLB, property.beforeRB, property.afterRB
                ));
                mapAttrValue.addValue(attrName, vectorValue);
            }
        }

        sv.addAttrValue(BraceFormat.newlineAroundBraceAttr, mapAttrValue);
        st2svMap.put(BraceFormat.styleType, sv);
    }

    private String generateFeatureName(BodyContext context) {
        String typeName = context.bodyType.name();
        String innerStmt = context.bodyNumType.name().toLowerCase();
        return typeName.charAt(0) + typeName.substring(1).toLowerCase() + "-" + innerStmt;
    }
}
