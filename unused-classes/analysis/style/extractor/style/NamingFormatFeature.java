package org.example.analysis.style.extractor.style;

import org.example.analysis.feature.FeatureVector;
import org.example.analysis.style.ComputableStyle;
import org.example.analysis.StyleType;
import org.example.analysis.style.ComputableStyleExtractor;
import org.example.analysis.feature.featurevalue.DoubleFeatureValue;
import org.example.analysis.feature.featurevalue.MapFeatureValue;
import org.example.analysis.feature.featurevalue.StringFeatureValue;
import org.example.analysis.feature.featurevalue.StyleVector;
import org.example.style.Style;
import org.example.style.rule.StyleProperty;
import org.example.style.rule.StyleRule;
import org.example.styler.ifelse.multibranch.style.MultiBranchProperty;
import org.example.styler.naming.format.style.NamingFormatContext;
import org.example.styler.naming.format.style.NamingFormatProperty;


import java.util.Map;

public class NamingFormatFeature extends ComputableStyleExtractor {

    @Override
    protected void updateStyleMap(ComputableStyle cstyle, Map<String, ComputableStyle> styleMap) {
        styleMap.put(StyleType.NamingFormat.styleType, cstyle);
    }

    @Override
    public FeatureVector toFeatureVector(StyleProperty styleProperty) {
        if (styleProperty instanceof NamingFormatProperty property) {
            FeatureVector fv = new FeatureVector();
            fv.addDimension(StyleType.NamingFormat.caseFormatAttr, new StringFeatureValue(property.caseFormat.name()));
            fv.addDimension(StyleType.NamingFormat.maxLengthAttr, new DoubleFeatureValue(property.maxLength));
        }
        return null;
    }

    @Override
    public FeatureVector toDefaultFeatureVector() {
        FeatureVector fv = new FeatureVector();
        fv.addDimension(StyleType.NamingFormat.caseFormatAttr, null);
        fv.addDimension(StyleType.NamingFormat.maxLengthAttr, null);
        return fv;
    }

}
