package org.example.analysis.feature.impl;

import org.example.analysis.feature.featurevalue.FeatureValue;
import org.example.analysis.feature.featurevalue.FeatureVector;
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
    public void toFeatureVector(Style style, Map<String, FeatureVector> styleFeatures) {
        List<StyleRule> rules = style.getRules();
        for (StyleRule rule : rules) {
            String styleName = rule.getStyleContext() instanceof StructPreferenceContext context ?
                    context.getStructName() : null;
            FeatureValue featureValue = rule.getStyleProperty() instanceof StructPreferenceProperty property ?
                    new VectorFeatureValue(OneHotEncoder.encode(property.getPreferenceIndex())) : null;
            FeatureVector fv = new FeatureVector();
            fv.addFeature("Preference", featureValue);
            styleFeatures.put(styleName, fv);
        }
    }
}
