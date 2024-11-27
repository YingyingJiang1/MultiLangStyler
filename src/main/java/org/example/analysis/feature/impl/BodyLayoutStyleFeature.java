package org.example.analysis.feature.impl;

import org.example.analysis.feature.StyleFeature;
import org.example.analysis.feature.featurevalue.StyleVector;
import org.example.analysis.feature.featurevalue.VectorFeatureValue;
import org.example.parser.common.MyParser;
import org.example.style.Style;
import org.example.style.rule.StyleRule;
import org.example.styler.body.layout.style.BodyLayoutProperty;
import org.example.styler.body.optionalbrace.style.OptionalBraceProperty;

import java.util.List;
import java.util.Map;

public class BodyLayoutStyleFeature extends StyleFeature {

    @Override
    public void toFeatureVector(Style style, Map<String, StyleVector> styleFeatures) {
        StyleVector fv = new StyleVector();
        for (StyleRule rule : style.getRules()) {
            if (rule.getStyleProperty() instanceof BodyLayoutProperty property) {
                fv.addFeature("compact style", new VectorFeatureValue(List.of(property.compactStyle)));
            }
        }
        styleFeatures.put("Layout of control statement without braces", fv);
    }
}
