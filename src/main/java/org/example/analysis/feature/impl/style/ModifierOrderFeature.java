package org.example.analysis.feature.impl.style;

import org.example.analysis.StyleType.ModifiersOrder;
import org.example.analysis.feature.StyleFeatureExtractor;
import org.example.analysis.feature.featurevalue.OrderedAttrValue;
import org.example.analysis.feature.featurevalue.StyleVector;
import org.example.style.Style;
import org.example.style.rule.StyleRule;
import org.example.styler.arrangement.modifier.style.ModifierOrderProperty;

import java.util.Map;

public class ModifierOrderFeature implements StyleFeatureExtractor {
    @Override
    public void toFeatureVector(Style style, Map<String, StyleVector> st2svMap) {
        StyleVector sv = new StyleVector();
        for (StyleRule rule : style.getRules()) {
            if (rule.getStyleProperty() instanceof ModifierOrderProperty property) {
                sv.addAttrValue(ModifiersOrder.orderAttr, new OrderedAttrValue(property.order));
            }
        }

        st2svMap.put(ModifiersOrder.styleType, sv);
    }
}
