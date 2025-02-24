package org.example.analysis.style.extractor.style;

import org.example.analysis.StyleType;
import org.example.analysis.feature.FeatureVector;
import org.example.analysis.feature.featurevalue.DoubleFeatureValue;
import org.example.analysis.style.ComputableStyle;
import org.example.analysis.StyleType.OrderOfIfElseBodies;
import org.example.analysis.style.ComputableStyleExtractor;
import org.example.analysis.feature.featurevalue.BooleanFeatureValue;
import org.example.analysis.feature.featurevalue.StyleVector;
import org.example.style.Style;
import org.example.style.rule.StyleProperty;
import org.example.style.rule.StyleRule;
import org.example.styler.function.style.FunctionComplexityProperty;
import org.example.styler.ifelse.bodyorder.style.IfElseBodyOrderProperty;

import java.util.Map;

public class IfElseBodyOrderFeature extends ComputableStyleExtractor {
    @Override
    protected void updateStyleMap(ComputableStyle cstyle, Map<String, ComputableStyle> styleMap) {
        styleMap.put(OrderOfIfElseBodies.styleType, cstyle);
    }

    @Override
    public FeatureVector toFeatureVector(StyleProperty styleProperty) {
        if (styleProperty instanceof IfElseBodyOrderProperty property) {
            FeatureVector fv = new FeatureVector();
            fv.addDimension(OrderOfIfElseBodies.shortBodyComesFirstAttr, new BooleanFeatureValue(property.shortBodyComesFirst));
        }
        return null;
    }

    @Override
    public FeatureVector toDefaultFeatureVector() {
        FeatureVector fv = new FeatureVector();
        fv.addDimension(OrderOfIfElseBodies.shortBodyComesFirstAttr, null);
        return fv;
    }
}
