package org.example.analysis.style.extractor.style;

import org.example.analysis.StyleType;
import org.example.analysis.feature.FeatureVector;
import org.example.analysis.style.ComputableStyle;
import org.example.analysis.StyleType.OrderOfFunctionPara;
import org.example.analysis.style.ComputableStyleExtractor;
import org.example.analysis.feature.featurevalue.BooleanFeatureValue;
import org.example.analysis.feature.featurevalue.StringFeatureValue;
import org.example.analysis.feature.featurevalue.StyleVector;
import org.example.style.Style;
import org.example.style.rule.StyleProperty;
import org.example.style.rule.StyleRule;
import org.example.styler.arrangement.param.style.ParameterOrderProperty;
import org.example.styler.body.optionalbrace.style.OptionalBraceProperty;

import java.util.Map;

public class ParameterOrderFeature extends ComputableStyleExtractor {
    @Override
    protected void updateStyleMap(ComputableStyle cstyle, Map<String, ComputableStyle> styleMap) {
        styleMap.put(StyleType.OrderOfFunctionPara.styleType, cstyle);
    }

    @Override
    public FeatureVector toFeatureVector(StyleProperty styleProperty) {
        if (styleProperty instanceof ParameterOrderProperty property) {
            FeatureVector fv = new FeatureVector();
            fv.addDimension(OrderOfFunctionPara.logicalOrderAttr,
                    property.order == null ? null : new StringFeatureValue(property.order.name()));
            fv.addDimension(OrderOfFunctionPara.separateSameTypeAttr,
                    property.isSameTypeParamSeparated == null ? null : new BooleanFeatureValue(property.isSameTypeParamSeparated));
        }
        return null;
    }

    @Override
    public FeatureVector toDefaultFeatureVector() {
        FeatureVector fv = new FeatureVector();
        fv.addDimension(OrderOfFunctionPara.logicalOrderAttr, null);
        fv.addDimension(OrderOfFunctionPara.separateSameTypeAttr, null);
        return fv;
    }

}
