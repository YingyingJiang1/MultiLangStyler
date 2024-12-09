package org.example.analysis.feature.impl.style;

import org.example.analysis.StyleType.OrderOfFunctionPara;
import org.example.analysis.feature.StyleFeatureExtractor;
import org.example.analysis.feature.featurevalue.BooleanAttrValue;
import org.example.analysis.feature.featurevalue.DoubleAttrValue;
import org.example.analysis.feature.featurevalue.StringAttrValue;
import org.example.analysis.feature.featurevalue.StyleVector;
import org.example.style.Style;
import org.example.style.rule.StyleRule;
import org.example.styler.arrangement.param.style.ParameterOrderProperty;

import java.util.Map;

public class ParameterOrderFeature implements StyleFeatureExtractor {
    @Override
    public void toFeatureVector(Style style, Map<String, StyleVector> st2svMap) {
        StyleVector sv = new StyleVector();
        for (StyleRule rule  : style.getRules()) {
            if (rule.getStyleProperty() instanceof ParameterOrderProperty property) {
                sv.addAttrValue(OrderOfFunctionPara.logicalOrderAttr,
                        property.order == null ? null : new StringAttrValue(property.order.name()));
                sv.addAttrValue(OrderOfFunctionPara.separateSameTypeAttr,
                        property.isSameTypeParamSeparated == null ? null : new BooleanAttrValue(property.isSameTypeParamSeparated));

            }
        }
        st2svMap.put(OrderOfFunctionPara.styleType, sv);
    }
}
