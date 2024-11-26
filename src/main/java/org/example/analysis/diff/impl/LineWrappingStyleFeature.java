package org.example.analysis.diff.impl;

import org.example.analysis.diff.feature.FeatureVector;
import org.example.analysis.diff.StyleFeature;
import org.example.analysis.diff.feature.VectorFeatureValue;
import org.example.style.CommonStyle;
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
    public void toFeatureVector(CommonStyle commonStyle, Map<String, FeatureVector> styleFeatures) {
        FeatureVector fv = new FeatureVector();
        for (StyleRule rule : commonStyle.getRules()) {
            if (rule.getStyleContext() instanceof LineWrappingContext context &&
            rule.getStyleProperty() instanceof LineWrappingProperty property) {
                if (context.attr == LineWrappingContext.Attr.CODE) {
                    if (property.maxLen == property.maxLenBefore) {
                        fv.addFeature("Wrapping long line", new VectorFeatureValue(List.of(true)));
                    } else if (property.maxLen > maxLen) {
                        fv.addFeature("Wrapping long line", new VectorFeatureValue(List.of(false)));
                    } else {
                        fv = null; // indeterminate
                    }
                }
            }
        }
        styleFeatures.put("Line wrapping", fv);
    }

}
