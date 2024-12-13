package org.example.analysis.feature.impl.style;

import org.example.analysis.StyleType.Space;
import org.example.analysis.feature.StyleFeatureExtractor;
import org.example.analysis.feature.featurevalue.BooleanAttrValue;
import org.example.analysis.feature.featurevalue.MapAttrValue;
import org.example.analysis.feature.featurevalue.StyleVector;
import org.example.analysis.feature.featurevalue.VectorAttrValue;
import org.example.style.Style;
import org.example.style.rule.StyleRule;
import org.example.styler.format.space.style.SpaceContext;
import org.example.styler.format.space.style.SpaceProperty;

import java.util.List;
import java.util.Map;

public class SpaceFeature implements StyleFeatureExtractor {
    @Override
    public void toFeatureVector(Style style, Map<String, StyleVector> st2svMap) {
        StyleVector sv = new StyleVector();
        for (StyleRule rule : style.getRules()) {
            if (rule.getStyleContext() instanceof SpaceContext context &&
            rule.getStyleProperty() instanceof SpaceProperty property) {
                String key = null;
                if (context.tokenName2.isEmpty()) {
                    key = context.tokenName1;
                    sv.addAttrValue(key, new VectorAttrValue(List.of(property.space1, property.space2)));
                } else {
                    key = context.tokenName1 + "," + context.tokenName2;
                    sv.addAttrValue(key, new BooleanAttrValue(property.space2));
                }
            }
        }
        st2svMap.put(Space.styleType, sv);
    }
}
