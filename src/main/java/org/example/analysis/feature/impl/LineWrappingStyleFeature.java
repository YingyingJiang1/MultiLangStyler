package org.example.analysis.feature.impl;

import org.example.analysis.feature.featurevalue.FeatureVector;
import org.example.analysis.feature.StyleFeature;
import org.example.analysis.feature.featurevalue.VectorFeatureValue;
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
    public void toFeatureVector(Style style, Map<String, FeatureVector> styleFeatures) {
        FeatureVector fv = new FeatureVector();
        for (StyleRule rule : style.getRules()) {
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
