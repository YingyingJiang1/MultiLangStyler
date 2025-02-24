package org.example.analysis.style.extractor.style;

import org.example.analysis.style.ComputableStyle;
import org.example.analysis.StyleType;
import org.example.analysis.style.ComputableStyleExtractor;
import org.example.analysis.feature.featurevalue.DoubleFeatureValue;
import org.example.analysis.feature.featurevalue.MapFeatureValue;
import org.example.analysis.feature.featurevalue.StringFeatureValue;
import org.example.analysis.feature.featurevalue.StyleVector;
import org.example.style.Style;
import org.example.style.rule.StyleRule;
import org.example.styler.naming.format.style.NamingFormatContext;
import org.example.styler.naming.format.style.NamingFormatProperty;


import java.util.Map;

public class NamingFormatFeature implements ComputableStyleExtractor {
    @Override
    public void toComputableStyle(Style style, Map<String, ComputableStyle> styleMap) {
        StyleVector sv = new StyleVector();
        for (StyleRule rule : style.getRules()) {
            if (rule.getStyleContext() instanceof NamingFormatContext context
            && rule.getStyleProperty() instanceof NamingFormatProperty property) {
                MapFeatureValue mapAttrValue = new MapFeatureValue();
                mapAttrValue.addValue(StyleType.NamingFormat.caseFormatAttr, new StringFeatureValue(property.caseFormat.name()));
                mapAttrValue.addValue(StyleType.NamingFormat.maxLengthAttr, new DoubleFeatureValue(property.maxLength));
                sv.addAttrValue(context.symbolType.name(), mapAttrValue);
            }
        }

        styleMap.put(StyleType.NamingFormat.styleType, sv);

    }
}
