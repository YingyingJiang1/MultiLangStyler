package org.example.analysis.style.extractor.style;

import org.example.analysis.feature.FeatureVector;
import org.example.analysis.style.ComputableStyle;
import org.example.analysis.StyleType.BraceFormat;
import org.example.analysis.feature.featurevalue.FeatureValue;
import org.example.analysis.feature.featurevalue.MapFeatureValue;
import org.example.analysis.feature.featurevalue.StyleVector;
import org.example.analysis.style.ComputableStyleExtractor;
import org.example.analysis.feature.featurevalue.VectorFeatureValue;
import org.example.style.Style;
import org.example.style.rule.StyleProperty;
import org.example.style.rule.StyleRule;
import org.example.styler.body.BodyContext;
import org.example.styler.body.braceformat.style.BraceFormatProperty;

import java.util.List;
import java.util.Map;

public class BraceFormatFeature extends ComputableStyleExtractor {

    @Override
    protected void updateStyleMap(ComputableStyle cstyle, Map<String, ComputableStyle> styleMap) {
        styleMap.put(BraceFormat.styleType, cstyle);
    }

    @Override
    public FeatureVector toFeatureVector(StyleProperty styleProperty) {
        if (styleProperty instanceof BraceFormatProperty property) {
            FeatureVector fv = new FeatureVector();
            FeatureValue vectorValue = new VectorFeatureValue(List.of(
                    property.beforeLB, property.afterLB, property.beforeRB, property.afterRB
            ));
            fv.addDimension(BraceFormat.newlineAroundBraceAttr, vectorValue);
        }
        return null;
    }

    @Override
    public FeatureVector toDefaultFeatureVector() {
        FeatureVector fv = new FeatureVector();
        fv.addDimension(BraceFormat.newlineAroundBraceAttr, null);
        return fv;
    }
}
