package org.example.analysis.feature.impl.style;

import org.example.analysis.StyleType;
import org.example.analysis.feature.StyleFeatureExtractor;
import org.example.analysis.feature.featurevalue.BooleanAttrValue;
import org.example.analysis.feature.featurevalue.StyleVector;
import org.example.style.Style;
import org.example.style.rule.StyleRule;
import org.example.styler.exp.updatevar.style.UpdateVarContext;
import org.example.styler.exp.updatevar.style.UpdateVarProperty;

import java.util.Map;

public class VarUpdatingFeature implements StyleFeatureExtractor {
    @Override
    public void toFeatureVector(Style style, Map<String, StyleVector> st2svMap) {
        StyleVector sv = new StyleVector();
        for (StyleRule rule : style.getRules()) {
            if (rule.getStyleContext() instanceof UpdateVarContext context &&
            rule.getStyleProperty() instanceof UpdateVarProperty property) {
                sv.addAttrValue(context.expType.name(), new BooleanAttrValue(property.allowUpdatingInExp));
            }
        }
        st2svMap.put(StyleType.VarUpdating.styleType, sv);
    }
}
