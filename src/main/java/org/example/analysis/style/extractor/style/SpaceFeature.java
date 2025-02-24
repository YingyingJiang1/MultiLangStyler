package org.example.analysis.style.extractor.style;

import org.example.analysis.style.ComputableStyle;
import org.example.analysis.StyleType.Space;
import org.example.analysis.style.ComputableStyleExtractor;
import org.example.analysis.feature.featurevalue.BooleanFeatureValue;
import org.example.analysis.feature.featurevalue.StyleVector;
import org.example.analysis.feature.featurevalue.VectorFeatureValue;
import org.example.style.Style;
import org.example.style.rule.StyleRule;
import org.example.styler.format.space.style.SpaceContext;
import org.example.styler.format.space.style.SpaceProperty;

import java.util.List;
import java.util.Map;

public class SpaceFeature implements ComputableStyleExtractor {
    @Override
    public void toComputableStyle(Style style, Map<String, ComputableStyle> styleMap) {
        StyleVector sv = new StyleVector();
        for (StyleRule rule : style.getRules()) {
            if (rule.getStyleContext() instanceof SpaceContext context &&
            rule.getStyleProperty() instanceof SpaceProperty property) {
                String key = null;
                if (context.tokenName2.isEmpty()) {
                    key = context.tokenName1;
                    sv.addAttrValue(key, new VectorFeatureValue(List.of(property.space1, property.space2)));
                } else {
                    key = context.tokenName1 + "," + context.tokenName2;
                    sv.addAttrValue(key, new BooleanFeatureValue(property.space2));
                }
            }
        }
        styleMap.put(Space.styleType, sv);
    }
}
