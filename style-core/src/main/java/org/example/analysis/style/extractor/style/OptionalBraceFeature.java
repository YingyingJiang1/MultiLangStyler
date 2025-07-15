package org.example.analysis.style.extractor.style;

import org.example.analysis.StyleType;
import org.example.analysis.feature.FeatureVector;
import org.example.analysis.style.ComputableStyle;
import org.example.analysis.StyleType.OptionalBrace;
import org.example.analysis.feature.featurevalue.BooleanFeatureValue;
import org.example.analysis.style.ComputableStyleExtractor;
import org.example.style.rule.StyleProperty;
import org.example.styler.format.body.optionalbrace.style.OptionalBraceProperty;

import java.util.Map;

public class OptionalBraceFeature extends ComputableStyleExtractor {
    @Override
    protected void updateStyleMap(ComputableStyle cstyle, Map<String, ComputableStyle> styleMap) {
        styleMap.put(StyleType.OptionalBrace.styleType, cstyle);
    }

    @Override
    public FeatureVector toFeatureVector(StyleProperty styleProperty) {
        if (styleProperty instanceof OptionalBraceProperty property) {
            FeatureVector fv = new FeatureVector();
            fv.addDimension(OptionalBrace.useBracesAttr, new BooleanFeatureValue(property.useBrace));
        }
        return null;
    }

    @Override
    public FeatureVector toDefaultFeatureVector() {
        FeatureVector fv = new FeatureVector();
        fv.addDimension(OptionalBrace.useBracesAttr, null);
        return fv;
    }

}
