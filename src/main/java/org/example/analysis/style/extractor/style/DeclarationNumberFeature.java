package org.example.analysis.style.extractor.style;

import org.example.analysis.feature.FeatureVector;
import org.example.analysis.style.ComputableStyle;
import org.example.analysis.StyleType;
import org.example.analysis.style.ComputableStyleExtractor;
import org.example.analysis.feature.featurevalue.DoubleFeatureValue;
import org.example.style.rule.StyleProperty;
import org.example.styler.declaration.layout.style.DeclarationLayoutProperty;

import java.util.Map;

public class DeclarationNumberFeature extends ComputableStyleExtractor {
    @Override
    protected void updateStyleMap(ComputableStyle cstyle, Map<String, ComputableStyle> styleMap) {
        styleMap.put(StyleType.NumberOfVarInOneDecStmt.styleType, cstyle);
    }

    @Override
    public FeatureVector toFeatureVector(StyleProperty styleProperty) {
        if (styleProperty instanceof DeclarationLayoutProperty property) {
            FeatureVector fv = new FeatureVector();
            fv.addDimension(StyleType.NumberOfVarInOneDecStmt.varsPerDec, new DoubleFeatureValue(property.maxVariableCount));
        }
        return null;
    }

    @Override
    public FeatureVector toDefaultFeatureVector() {
        FeatureVector fv = new FeatureVector();
        fv.addDimension(StyleType.NumberOfVarInOneDecStmt.varsPerDec, null);
        return fv;
    }

}
