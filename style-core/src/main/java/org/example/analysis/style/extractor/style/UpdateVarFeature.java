package org.example.analysis.style.extractor.style;

import org.example.analysis.feature.FeatureVector;
import org.example.analysis.style.ComputableStyle;
import org.example.analysis.StyleType;
import org.example.analysis.style.ComputableStyleExtractor;
import org.example.analysis.feature.featurevalue.BooleanFeatureValue;
import org.example.analysis.feature.featurevalue.StyleVector;
import org.example.style.Style;
import org.example.style.rule.StyleProperty;
import org.example.style.rule.StyleRule;
import org.example.styler.exp.updatevar.style.UpdateVarContext;
import org.example.styler.exp.updatevar.style.UpdateVarProperty;
import org.example.styler.practice.style.UnusedCodeProperty;

import java.util.Map;

public class UpdateVarFeature extends ComputableStyleExtractor {
    @Override
    protected void updateStyleMap(ComputableStyle cstyle, Map<String, ComputableStyle> styleMap) {
        styleMap.put(StyleType.VarUpdating.styleType, cstyle);
    }

    @Override
    public FeatureVector toFeatureVector(StyleProperty styleProperty) {
        if (styleProperty instanceof UpdateVarProperty property) {
            FeatureVector fv = new FeatureVector();
            fv.addDimension(StyleType.VarUpdating.updateInStmtAttr,new BooleanFeatureValue(property.updateInStmt));
        }
        return null;
    }

    @Override
    public FeatureVector toDefaultFeatureVector() {
        FeatureVector fv = new FeatureVector();
        fv.addDimension(StyleType.VarUpdating.updateInStmtAttr, null);
        return fv;
    }

}
