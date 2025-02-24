package org.example.analysis.style.extractor.style;

import org.example.analysis.style.ComputableStyle;
import org.example.analysis.StyleType.OrderOfFunctionPara;
import org.example.analysis.style.ComputableStyleExtractor;
import org.example.analysis.feature.featurevalue.BooleanFeatureValue;
import org.example.analysis.feature.featurevalue.StringFeatureValue;
import org.example.analysis.feature.featurevalue.StyleVector;
import org.example.style.Style;
import org.example.style.rule.StyleRule;
import org.example.styler.arrangement.param.style.ParameterOrderProperty;

import java.util.Map;

public class ParameterOrderFeature implements ComputableStyleExtractor {
    @Override
    public void toComputableStyle(Style style, Map<String, ComputableStyle> styleMap) {
        StyleVector sv = new StyleVector();
        for (StyleRule rule  : style.getRules()) {
            if (rule.getStyleProperty() instanceof ParameterOrderProperty property) {
                sv.addAttrValue(OrderOfFunctionPara.logicalOrderAttr,
                        property.order == null ? null : new StringFeatureValue(property.order.name()));
                sv.addAttrValue(OrderOfFunctionPara.separateSameTypeAttr,
                        property.isSameTypeParamSeparated == null ? null : new BooleanFeatureValue(property.isSameTypeParamSeparated));

            }
        }
        styleMap.put(OrderOfFunctionPara.styleType, sv);
    }
}
