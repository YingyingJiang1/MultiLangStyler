package org.example.analysis.style.extractor.style;

import org.example.analysis.style.ComputableStyle;
import org.example.analysis.StyleType.OptionalBrace;
import org.example.analysis.feature.featurevalue.BooleanFeatureValue;
import org.example.analysis.feature.featurevalue.StyleVector;
import org.example.analysis.style.ComputableStyleExtractor;
import org.example.style.Style;
import org.example.style.rule.StyleRule;
import org.example.styler.body.optionalbrace.style.OptionalBraceProperty;

import java.util.Map;

public class OptionalBraceFeature implements ComputableStyleExtractor {
    @Override
    public void toComputableStyle(Style style, Map<String, ComputableStyle> styleMap) {
        StyleVector sv = new StyleVector();
        for (StyleRule rule : style.getRules()) {
            if (rule.getStyleProperty() instanceof OptionalBraceProperty property) {
                sv.addAttrValue(OptionalBrace.useBracesAttr, new BooleanFeatureValue(property.useBrace));
            }
        }
        styleMap.put(OptionalBrace.styleType, sv);
    }

}
