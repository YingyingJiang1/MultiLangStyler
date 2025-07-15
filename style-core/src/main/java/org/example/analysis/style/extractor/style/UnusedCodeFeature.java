package org.example.analysis.style.extractor.style;

import org.example.analysis.feature.FeatureVector;
import org.example.analysis.style.ComputableStyle;
import org.example.analysis.StyleType;
import org.example.analysis.style.ComputableStyleExtractor;
import org.example.analysis.feature.featurevalue.BooleanFeatureValue;
import org.example.style.rule.StyleProperty;
import org.example.styler.practice.style.UnusedCodeProperty;

import java.util.Map;

public class UnusedCodeFeature extends ComputableStyleExtractor {
    @Override
    protected void updateStyleMap(ComputableStyle cstyle, Map<String, ComputableStyle> styleMap) {
        styleMap.put(StyleType.UnusedVar.styleType, cstyle);
    }

    @Override
    public FeatureVector toFeatureVector(StyleProperty styleProperty) {
        if (styleProperty instanceof UnusedCodeProperty property) {
            FeatureVector fv = new FeatureVector();
            fv.addDimension(StyleType.UnusedVar.unusedVarAttr, new BooleanFeatureValue(property.hasUnusedCode));
        }
        return null;
    }

    @Override
    public FeatureVector toDefaultFeatureVector() {
        FeatureVector fv = new FeatureVector();
        fv.addDimension(StyleType.UnusedVar.unusedVarAttr, null);
        return fv;
    }

}
