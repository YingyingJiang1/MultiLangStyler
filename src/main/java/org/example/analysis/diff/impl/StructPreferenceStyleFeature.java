package org.example.analysis.diff.impl;

import org.example.analysis.diff.feature.FeatureValue;
import org.example.analysis.diff.feature.FeatureVector;
import org.example.analysis.diff.StyleFeature;
import org.example.analysis.diff.feature.OneHotEncoder;
import org.example.analysis.diff.feature.VectorFeatureValue;
import org.example.style.CommonStyle;
import org.example.style.rule.StyleRule;
import org.example.styler.structure.style.StructPreferenceContext;
import org.example.styler.structure.style.StructPreferenceProperty;

import java.util.List;
import java.util.Map;

public class StructPreferenceStyleFeature extends StyleFeature {

    @Override
    public Map<String, FeatureVector> toFeatureVector(CommonStyle commonStyle) {
        List<StyleRule> rules = commonStyle.getRules();
        for (StyleRule rule : rules) {
            String styleName = rule.getStyleContext() instanceof StructPreferenceContext context ?
                    context.getStructName() : null;
            FeatureValue featureValue = rule.getStyleProperty() instanceof StructPreferenceProperty property ?
                    new VectorFeatureValue(OneHotEncoder.encode(property.getPreferenceIndex())) : null;
            FeatureVector fv = new FeatureVector();
            fv.addFeature("Preference", featureValue);
            styleFeatures.put(styleName, fv);
        }
        return styleFeatures;
    }
}
