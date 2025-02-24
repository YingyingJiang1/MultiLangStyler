package org.example.analysis.style.extractor.style;

import org.example.analysis.feature.FeatureVector;
import org.example.analysis.style.ComputableStyle;
import org.example.analysis.StyleType.LayoutOfControlStmtWithoutBraces;
import org.example.analysis.style.ComputableStyleExtractor;
import org.example.analysis.feature.featurevalue.BooleanFeatureValue;
import org.example.analysis.feature.featurevalue.StyleVector;
import org.example.style.Style;
import org.example.style.rule.StyleProperty;
import org.example.style.rule.StyleRule;
import org.example.styler.body.layout.style.BodyLayoutProperty;

import java.util.Map;

public class BodyLayoutFeature extends ComputableStyleExtractor {
    @Override
    public FeatureVector toFeatureVector(StyleProperty styleProperty) {
        if (styleProperty instanceof BodyLayoutProperty property) {
            FeatureVector fv = new FeatureVector();
            fv.addDimension(LayoutOfControlStmtWithoutBraces.inCompactModeAttr, new BooleanFeatureValue(property.compactStyle));
            return null;
        }
        return null;
    }

    @Override
    public FeatureVector toDefaultFeatureVector() {
        FeatureVector fv = new FeatureVector();
        fv.addDimension(LayoutOfControlStmtWithoutBraces.inCompactModeAttr, null);
        return fv;
    }

    @Override
    protected void updateStyleMap(ComputableStyle cstyle, Map<String, ComputableStyle> styleMap) {
        styleMap.put(LayoutOfControlStmtWithoutBraces.styleType, cstyle);
    }
}
