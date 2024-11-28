package org.example.analysis.feature.impl;

import org.example.analysis.feature.featurevalue.FeatureValue;
import org.example.analysis.feature.featurevalue.StyleVector;
import org.example.analysis.feature.StyleFeature;
import org.example.analysis.feature.featurevalue.OneHotEncoder;
import org.example.analysis.feature.featurevalue.VectorFeatureValue;
import org.example.style.Style;
import org.example.style.rule.StyleRule;
import org.example.styler.structure.style.StructPreferenceContext;
import org.example.styler.structure.style.StructPreferenceProperty;

import java.util.List;
import java.util.Map;

public class StructPreferenceStyleFeature extends StyleFeature {

    @Override
    public void toFeatureVector(Style style, Map<String, StyleVector> styleFeatures) {
        List<StyleRule> rules = style.getRules();
        for (StyleRule rule : rules) {
            String styleName = rule.getStyleContext() instanceof StructPreferenceContext context ?
                    context.getStructCategory() : null;
            FeatureValue featureValue = rule.getStyleProperty() instanceof StructPreferenceProperty property ?
                    new VectorFeatureValue(OneHotEncoder.encode(property.getPreferenceIndex())) : null;
            StyleVector fv = new StyleVector();
            fv.addFeature("Preference", featureValue);
            styleFeatures.put(styleName, fv);
        }
    }
}
