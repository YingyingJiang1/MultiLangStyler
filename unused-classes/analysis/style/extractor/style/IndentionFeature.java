package org.example.analysis.style.extractor.style;

import org.example.analysis.StyleType;
import org.example.analysis.feature.FeatureVector;
import org.example.analysis.feature.featurevalue.BooleanFeatureValue;
import org.example.analysis.style.ComputableStyle;
import org.example.analysis.StyleType.Indention;
import org.example.analysis.style.ComputableStyleExtractor;
import org.example.analysis.feature.featurevalue.StringFeatureValue;
import org.example.analysis.feature.featurevalue.StyleVector;
import org.example.analysis.feature.featurevalue.DoubleFeatureValue;
import org.example.style.Style;
import org.example.style.rule.StyleProperty;
import org.example.style.rule.StyleRule;
import org.example.styler.format.indention.style.IndentionProperty;
import org.example.styler.ifelse.bodyorder.style.IfElseBodyOrderProperty;

import java.util.Map;

public class IndentionFeature extends ComputableStyleExtractor {
    @Override
    protected void updateStyleMap(ComputableStyle cstyle, Map<String, ComputableStyle> styleMap) {
        styleMap.put(Indention.styleType, cstyle);
    }

    @Override
    public FeatureVector toFeatureVector(StyleProperty styleProperty) {
        if (styleProperty instanceof IndentionProperty property) {
            FeatureVector fv = new FeatureVector();
            fv.addDimension(Indention.indentationUnitAttr, new DoubleFeatureValue(property.indentionUnit));
            fv.addDimension(Indention.indentionTypeAttr, new StringFeatureValue(Character.toString(property.indentionType)));
        }
        return null;
    }

    @Override
    public FeatureVector toDefaultFeatureVector() {
        FeatureVector fv = new FeatureVector();
        fv.addDimension(Indention.indentationUnitAttr, null);
        fv.addDimension(Indention.indentionTypeAttr, null);
        return fv;
    }

}
