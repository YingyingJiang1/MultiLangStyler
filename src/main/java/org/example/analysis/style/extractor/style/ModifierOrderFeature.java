package org.example.analysis.style.extractor.style;

import org.example.analysis.StyleType;
import org.example.analysis.feature.FeatureVector;
import org.example.analysis.feature.featurevalue.BooleanFeatureValue;
import org.example.analysis.style.ComputableStyle;
import org.example.analysis.StyleType.ModifiersOrder;
import org.example.analysis.style.ComputableStyleExtractor;
import org.example.analysis.feature.featurevalue.OrderedFeatureValue;
import org.example.analysis.feature.featurevalue.StyleVector;
import org.example.style.Style;
import org.example.style.rule.StyleProperty;
import org.example.style.rule.StyleRule;
import org.example.styler.arrangement.modifier.style.ModifierOrderProperty;
import org.example.styler.literal.usage.style.LiteralUsageProperty;

import java.util.Map;

public class ModifierOrderFeature extends ComputableStyleExtractor {
    @Override
    protected void updateStyleMap(ComputableStyle cstyle, Map<String, ComputableStyle> styleMap) {
        styleMap.put(ModifiersOrder.styleType, cstyle);
    }

    @Override
    public FeatureVector toFeatureVector(StyleProperty styleProperty) {
        if (styleProperty instanceof ModifierOrderProperty property) {
            FeatureVector fv = new FeatureVector();
            fv.addDimension(ModifiersOrder.orderAttr, new OrderedFeatureValue(property.order));
        }
        return null;
    }

    @Override
    public FeatureVector toDefaultFeatureVector() {
        FeatureVector fv = new FeatureVector();
        fv.addDimension(ModifiersOrder.orderAttr, null);
        return fv;
    }
}
