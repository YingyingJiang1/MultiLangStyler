package org.example.analysis.style.extractor.style;

import org.example.analysis.StyleType;
import org.example.analysis.feature.FeatureVector;
import org.example.analysis.feature.featurevalue.DoubleFeatureValue;
import org.example.analysis.style.ComputableStyle;
import org.example.analysis.StyleType.Mutlibranch;
import org.example.analysis.style.ComputableStyleExtractor;
import org.example.analysis.feature.featurevalue.StringFeatureValue;
import org.example.analysis.feature.featurevalue.StyleVector;
import org.example.style.Style;
import org.example.style.rule.StyleProperty;
import org.example.style.rule.StyleRule;
import org.example.styler.exp.complexity.style.ExpressionProperty;
import org.example.styler.ifelse.multibranch.style.MultiBranchContext;
import org.example.styler.ifelse.multibranch.style.MultiBranchProperty;

import java.util.Map;

public class MultiBranchFeature extends ComputableStyleExtractor {
    @Override
    protected void updateStyleMap(ComputableStyle cstyle, Map<String, ComputableStyle> styleMap) {
        styleMap.put(StyleType.Mutlibranch.styleType, cstyle);
    }

    @Override
    public FeatureVector toFeatureVector(StyleProperty styleProperty) {
        if (styleProperty instanceof MultiBranchProperty property) {
            FeatureVector fv = new FeatureVector();
            fv.addDimension(Mutlibranch.branchTypeAttr, new StringFeatureValue(property.branchType.name()));
        }
        return null;
    }

    @Override
    public FeatureVector toDefaultFeatureVector() {
        FeatureVector fv = new FeatureVector();
        fv.addDimension(Mutlibranch.branchTypeAttr, null);
        return fv;
    }

}
