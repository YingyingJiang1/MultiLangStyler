package org.example.analysis.style.extractor.style;

import org.example.analysis.StyleType;
import org.example.analysis.feature.FeatureVector;
import org.example.analysis.feature.featurevalue.DoubleFeatureValue;
import org.example.analysis.feature.featurevalue.StringFeatureValue;
import org.example.analysis.style.ComputableStyle;
import org.example.analysis.StyleType.LiteralUsage;
import org.example.analysis.style.ComputableStyleExtractor;
import org.example.analysis.feature.featurevalue.BooleanFeatureValue;
import org.example.analysis.feature.featurevalue.StyleVector;
import org.example.style.Style;
import org.example.style.rule.StyleProperty;
import org.example.style.rule.StyleRule;
import org.example.styler.format.indention.style.IndentionProperty;
import org.example.styler.literal.usage.style.LiteralUsageContext;
import org.example.styler.literal.usage.style.LiteralUsageProperty;

import java.util.Map;

public class LiteralUsageFeature extends ComputableStyleExtractor {
    @Override
    protected void updateStyleMap(ComputableStyle cstyle, Map<String, ComputableStyle> styleMap) {
        styleMap.put(LiteralUsage.styleType, cstyle);
    }

    @Override
    public FeatureVector toFeatureVector(StyleProperty styleProperty) {
        if (styleProperty instanceof LiteralUsageProperty property) {
            FeatureVector fv = new FeatureVector();
            fv.addDimension(LiteralUsage.decCons, new BooleanFeatureValue(property.declareCons));
        }
        return null;
    }

    @Override
    public FeatureVector toDefaultFeatureVector() {
        FeatureVector fv = new FeatureVector();
        fv.addDimension(LiteralUsage.decCons, null);
        return fv;
    }
}
