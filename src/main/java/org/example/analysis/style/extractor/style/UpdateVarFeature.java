package org.example.analysis.style.extractor.style;

import org.example.analysis.style.ComputableStyle;
import org.example.analysis.StyleType;
import org.example.analysis.style.ComputableStyleExtractor;
import org.example.analysis.feature.featurevalue.BooleanFeatureValue;
import org.example.analysis.feature.featurevalue.StyleVector;
import org.example.style.Style;
import org.example.style.rule.StyleRule;
import org.example.styler.exp.updatevar.style.UpdateVarContext;
import org.example.styler.exp.updatevar.style.UpdateVarProperty;

import java.util.Map;

public class UpdateVarFeature implements ComputableStyleExtractor {
    @Override
    public void toComputableStyle(Style style, Map<String, ComputableStyle> styleMap) {
        StyleVector sv = new StyleVector();
        for (StyleRule rule : style.getRules()) {
            if (rule.getStyleContext() instanceof UpdateVarContext context &&
            rule.getStyleProperty() instanceof UpdateVarProperty property) {
                sv.addAttrValue(context.expType.name(), new BooleanFeatureValue(property.updateInStmt));
            }
        }
        styleMap.put(StyleType.VarUpdating.styleType, sv);
    }
}
