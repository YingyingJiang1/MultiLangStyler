package org.example.analysis.style.extractor.style;

import org.example.analysis.style.ComputableStyle;
import org.example.analysis.StyleType;
import org.example.analysis.style.ComputableStyleExtractor;
import org.example.analysis.feature.featurevalue.BooleanFeatureValue;
import org.example.analysis.feature.featurevalue.StyleVector;
import org.example.style.Style;
import org.example.style.rule.StyleRule;
import org.example.styler.practice.style.UnusedCodeProperty;

import java.util.Map;

public class UnusedVarFeature implements ComputableStyleExtractor {
    @Override
    public void toComputableStyle(Style style, Map<String, ComputableStyle> styleMap) {
        StyleVector sv = new StyleVector();
        for (StyleRule rule : style.getRules()) {
            if (rule.getStyleProperty() instanceof UnusedCodeProperty property) {
                sv.addAttrValue(StyleType.UnusedVar.unusedVarAttr, new BooleanFeatureValue(property.hasUnusedVar));
            }
        }
        styleMap.put(StyleType.UnusedVar.styleType, sv);
    }
}
