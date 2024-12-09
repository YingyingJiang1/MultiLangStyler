package org.example.analysis.feature.impl.style;

import org.example.analysis.StyleType.Mutlibranch;
import org.example.analysis.feature.StyleFeatureExtractor;
import org.example.analysis.feature.featurevalue.StringAttrValue;
import org.example.analysis.feature.featurevalue.StyleVector;
import org.example.style.Style;
import org.example.style.rule.StyleRule;
import org.example.styler.ifelse.multibranch.style.MultiBranchContext;
import org.example.styler.ifelse.multibranch.style.MultiBranchProperty;

import java.util.Map;

public class MultiBranchFeature implements StyleFeatureExtractor {
    @Override
    public void toFeatureVector(Style style, Map<String, StyleVector> st2svMap) {
        StyleVector sv = new StyleVector();
        for (StyleRule rule :  style.getRules()) {
            if (rule.getStyleContext() instanceof MultiBranchContext context
            && rule.getStyleProperty() instanceof MultiBranchProperty property) {
                sv.addAttrValue(Integer.toString(context.branches), new StringAttrValue(property.branchType.name()));
            }
        }

        st2svMap.put(Mutlibranch.styleType, sv);
    }
}
