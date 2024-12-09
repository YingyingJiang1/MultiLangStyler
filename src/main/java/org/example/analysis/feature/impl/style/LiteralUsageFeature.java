package org.example.analysis.feature.impl.style;

import org.example.analysis.StyleType.LiteralUsage;
import org.example.analysis.feature.StyleFeatureExtractor;
import org.example.analysis.feature.featurevalue.BooleanAttrValue;
import org.example.analysis.feature.featurevalue.StyleVector;
import org.example.style.Style;
import org.example.style.rule.StyleRule;
import org.example.styler.literal.usage.style.LiteralUsageContext;
import org.example.styler.literal.usage.style.LiteralUsageProperty;

import java.util.Map;

public class LiteralUsageFeature implements StyleFeatureExtractor {
    @Override
    public void toFeatureVector(Style style, Map<String, StyleVector> st2svMap) {
        StyleVector sv = new StyleVector();
        for (StyleRule rule : style.getRules()) {
            if (rule.getStyleContext() instanceof LiteralUsageContext context
            && rule.getStyleProperty() instanceof LiteralUsageProperty property) {
                sv.addAttrValue(context.literalType.name(), new BooleanAttrValue(property.declareCons));
            }
        }

        st2svMap.put(LiteralUsage.styleType, sv);
    }
}
