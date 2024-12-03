package org.example.analysis.feature.impl;

import org.example.analysis.feature.featurevalue.StyleVector;
import org.example.analysis.feature.StyleFeature;
import org.example.analysis.feature.featurevalue.VectorAttrValue;
import org.example.style.Style;
import org.example.style.rule.StyleRule;
import org.example.styler.format.linewrapping.style.LineWrappingContext;
import org.example.styler.format.linewrapping.style.LineWrappingProperty;

import java.util.List;
import java.util.Map;

public class LineWrappingStyleFeature extends StyleFeature {
    /**
     * oracle java convention:Avoid lines longer than 80 characters, since they're not handled well by many terminals and tools.
     * google java guide:column limit:100
     */
    int maxLen = 80;
    @Override
    public void toFeatureVector(Style style, Map<String, StyleVector> st2svMap) {
        StyleVector sv = new StyleVector();
        for (StyleRule rule : style.getRules()) {
            if (rule.getStyleContext() instanceof LineWrappingContext context &&
            rule.getStyleProperty() instanceof LineWrappingProperty property) {
                if (context.attr == LineWrappingContext.Attr.CODE) {
                    if (property.maxLen == property.maxLenBefore) {
                        sv.addAttrValue("Wrapping long line", new VectorAttrValue(List.of(true)));
                    } else if (property.maxLen > maxLen) {
                        sv.addAttrValue("Wrapping long line", new VectorAttrValue(List.of(false)));
                    } else {
                        sv = null; // indeterminate
                    }
                }
            }
        }
        st2svMap.put("Line wrapping", sv);
    }

}
