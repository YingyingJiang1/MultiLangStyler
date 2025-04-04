package org.example.analysis.style.extractor.style;

import org.example.analysis.StyleType;
import org.example.analysis.feature.FeatureVector;
import org.example.analysis.feature.featurevalue.OrderedFeatureValue;
import org.example.analysis.style.ComputableStyle;
import org.example.analysis.StyleType.MostComplexExp;
import org.example.analysis.style.ComputableStyleExtractor;
import org.example.analysis.feature.featurevalue.DoubleFeatureValue;
import org.example.analysis.feature.featurevalue.MapFeatureValue;
import org.example.analysis.feature.featurevalue.StyleVector;
import org.example.style.Style;
import org.example.style.rule.StyleProperty;
import org.example.style.rule.StyleRule;
import org.example.styler.arrangement.modifier.style.ModifierOrderProperty;
import org.example.styler.exp.complexity.style.ExpressionContext;
import org.example.styler.exp.complexity.style.ExpressionProperty;

import java.util.Map;

public class MostComplexExpFeature extends ComputableStyleExtractor {

    @Override
    protected void updateStyleMap(ComputableStyle cstyle, Map<String, ComputableStyle> styleMap) {
        styleMap.put(StyleType.MostComplexExp.styleType, cstyle);
    }

    @Override
    public FeatureVector toFeatureVector(StyleProperty styleProperty) {
        if (styleProperty instanceof ExpressionProperty property) {
            FeatureVector fv = new FeatureVector();
            fv.addDimension(MostComplexExp.maxLengthAttr, new DoubleFeatureValue(property.maxComplexity.textLength));
            fv.addDimension(MostComplexExp.maxSubExpNum, new DoubleFeatureValue(property.maxComplexity.depth));
        }
        return null;
    }

    @Override
    public FeatureVector toDefaultFeatureVector() {
        FeatureVector fv = new FeatureVector();
        fv.addDimension(MostComplexExp.maxLengthAttr, null);
        fv.addDimension(MostComplexExp.maxSubExpNum, null);
        return fv;
    }

}
