package org.example.analysis.feature.impl.style;

import org.example.analysis.StyleType.FunctionComplexity;
import org.example.analysis.feature.StyleFeatureExtractor;
import org.example.analysis.feature.featurevalue.DoubleAttrValue;
import org.example.analysis.feature.featurevalue.StyleVector;
import org.example.style.Style;
import org.example.style.rule.StyleRule;
import org.example.styler.function.style.FunctionComplexityProperty;

import java.util.Map;

public class FunctionComplexityFeature implements StyleFeatureExtractor {
    @Override
    public void toFeatureVector(Style style, Map<String, StyleVector> st2svMap) {
        StyleVector sv = new StyleVector();
        for (StyleRule rule : style.getRules()) {
            if (rule.getStyleProperty() instanceof FunctionComplexityProperty property) {
                sv.addAttrValue(FunctionComplexity.maxNestingDepth, new DoubleAttrValue(property.maxNestingDepth));
                sv.addAttrValue(FunctionComplexity.maxLines, new DoubleAttrValue(property.maxLines));
            }
        }
        st2svMap.put(FunctionComplexity.styleType, sv);
    }
}
