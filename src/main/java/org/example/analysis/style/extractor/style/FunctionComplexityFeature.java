package org.example.analysis.style.extractor.style;

import org.example.analysis.feature.FeatureVector;
import org.example.analysis.style.ComputableStyle;
import org.example.analysis.StyleType.FunctionComplexity;
import org.example.analysis.style.ComputableStyleExtractor;
import org.example.analysis.feature.featurevalue.DoubleFeatureValue;
import org.example.style.rule.StyleProperty;
import org.example.styler.function.style.FunctionComplexityProperty;

import java.util.Map;

public class FunctionComplexityFeature extends ComputableStyleExtractor {
    @Override
    protected void updateStyleMap(ComputableStyle cstyle, Map<String, ComputableStyle> styleMap) {
        styleMap.put(FunctionComplexity.styleType, cstyle);
    }

    @Override
    public FeatureVector toFeatureVector(StyleProperty styleProperty) {
        if (styleProperty instanceof FunctionComplexityProperty property) {
            FeatureVector fv = new FeatureVector();
            fv.addDimension(FunctionComplexity.maxNestingDepth, new DoubleFeatureValue(property.maxNestingDepth));
            fv.addDimension(FunctionComplexity.maxLines, new DoubleFeatureValue(property.maxLines));
        }
        return null;
    }

    @Override
    public FeatureVector toDefaultFeatureVector() {
        FeatureVector fv = new FeatureVector();
        fv.addDimension(FunctionComplexity.maxNestingDepth, null);
        fv.addDimension(FunctionComplexity.maxLines, null);
        return fv;
    }
}
