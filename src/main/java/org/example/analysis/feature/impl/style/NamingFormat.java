package org.example.analysis.feature.impl.style;

import org.example.analysis.StyleType;
import org.example.analysis.feature.StyleFeatureExtractor;
import org.example.analysis.feature.featurevalue.DoubleAttrValue;
import org.example.analysis.feature.featurevalue.MapAttrValue;
import org.example.analysis.feature.featurevalue.StringAttrValue;
import org.example.analysis.feature.featurevalue.StyleVector;
import org.example.style.Style;
import org.example.style.rule.StyleRule;
import org.example.styler.naming.style.NamingFormatContext;
import org.example.styler.naming.style.NamingFormatProperty;

import java.util.Map;

public class NamingFormat implements StyleFeatureExtractor {
    @Override
    public void toFeatureVector(Style style, Map<String, StyleVector> st2svMap) {
        StyleVector sv = new StyleVector();
        for (StyleRule rule : style.getRules()) {
            if (rule.getStyleContext() instanceof NamingFormatContext context
            && rule.getStyleProperty() instanceof NamingFormatProperty property) {
                MapAttrValue mapAttrValue = new MapAttrValue();
                mapAttrValue.addValue(StyleType.NamingFormat.caseFormatAttr, new StringAttrValue(property.caseFormat.name()));
                mapAttrValue.addValue(StyleType.NamingFormat.maxLengthAttr, new DoubleAttrValue(property.maxLength));
                sv.addAttrValue(context.symbolType.name(), mapAttrValue);
            }
        }

        st2svMap.put(StyleType.NamingFormat.styleType, sv);

    }
}
