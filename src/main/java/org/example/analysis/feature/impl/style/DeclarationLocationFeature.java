package org.example.analysis.feature.impl.style;

import org.example.analysis.StyleType.LocOfVarDeclaration;
import org.example.analysis.feature.StyleFeatureExtractor;
import org.example.analysis.feature.featurevalue.StringAttrValue;
import org.example.analysis.feature.featurevalue.StyleVector;
import org.example.style.Style;
import org.example.style.rule.StyleRule;
import org.example.styler.declaration.location.style.DeclarationLocationProperty;

import java.util.Map;

public class DeclarationLocationFeature implements StyleFeatureExtractor {
    @Override
    public void toFeatureVector(Style style, Map<String, StyleVector> st2svMap) {
        StyleVector sv = new StyleVector();
        for (StyleRule rule : style.getRules()) {
            if (rule.getStyleProperty() instanceof DeclarationLocationProperty property) {
                sv.addAttrValue(LocOfVarDeclaration.locationAttr, new StringAttrValue(property.location.name()));
            }
        }
        st2svMap.put(LocOfVarDeclaration.styleType, sv);
    }
}
