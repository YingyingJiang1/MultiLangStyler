package org.example.analysis.feature.impl;

import org.example.analysis.StyleType.OneStatementInOneLine;
import org.example.analysis.feature.StyleFeature;
import org.example.analysis.feature.featurevalue.BooleanAttrValue;
import org.example.analysis.feature.featurevalue.StyleVector;
import org.example.style.Style;
import org.example.style.rule.StyleRule;
import org.example.styler.format.newline.style.NewlineProperty;

import java.util.Map;

public class LineStmtStyleFeature extends StyleFeature {
    public void toFeatureVector(Style style, Map<String, StyleVector> st2svMap) {
        StyleVector sv = new StyleVector();
        BooleanAttrValue value = new BooleanAttrValue(true);
        for (StyleRule rule : style.getRules()) {
            if (rule.getStyleProperty() instanceof NewlineProperty property) {
                if (property.newlines == 0) {
                    value.setValue(false);
                }
            }
        }
        sv.addAttrValue(OneStatementInOneLine.oneStmtPerLineAttr, value);
        st2svMap.put(OneStatementInOneLine.styleType, sv);
    }
}
