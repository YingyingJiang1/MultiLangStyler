package org.example.analysis.feature.impl.style;

import org.example.analysis.feature.StyleFeatureExtractor;
import org.example.analysis.feature.featurevalue.DoubleAttrValue;
import org.example.analysis.feature.featurevalue.StyleVector;
import org.example.style.Style;
import org.example.style.rule.StyleRule;
import org.example.styler.declaration.number.style.DeclarationNumberContext;
import org.example.styler.declaration.number.style.DeclarationNumberProperty;

import java.util.Map;

public class DeclarationNumberFeature implements StyleFeatureExtractor {
    @Override
    public void toFeatureVector(Style style, Map<String, StyleVector> st2svMap) {
        StyleVector sv = new StyleVector();
        for (StyleRule rule : style.getRules()) {
            if (rule.getStyleContext() instanceof DeclarationNumberContext context &&
                    rule.getStyleProperty() instanceof DeclarationNumberProperty property) {
                String name = context.hasComment ? "hasComment" : "noComment";
                sv.addAttrValue(name, new DoubleAttrValue(property.maxVariableCount));
            }
        }
        st2svMap.put(style.getStyleName(), sv);
    }
}
