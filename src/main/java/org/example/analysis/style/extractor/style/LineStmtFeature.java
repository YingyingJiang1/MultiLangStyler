package org.example.analysis.style.extractor.style;

import org.example.analysis.feature.FeatureVector;
import org.example.analysis.style.ComputableStyle;
import org.example.analysis.StyleType.OneStatementInOneLine;
import org.example.analysis.style.ComputableStyleExtractor;
import org.example.analysis.feature.featurevalue.BooleanFeatureValue;
import org.example.style.rule.StyleProperty;
import org.example.styler.format.style.NewlineProperty;

import java.util.Map;

public class LineStmtFeature extends ComputableStyleExtractor {
    @Override
    protected void updateStyleMap(ComputableStyle cstyle, Map<String, ComputableStyle> styleMap) {
        styleMap.put(OneStatementInOneLine.styleType, cstyle);
    }

    @Override
    public FeatureVector toFeatureVector(StyleProperty styleProperty) {
        if (styleProperty instanceof NewlineProperty property) {
            FeatureVector fv = new FeatureVector();
            fv.addDimension(OneStatementInOneLine.oneStmtPerLineAttr, new BooleanFeatureValue(property.newlines > 0));
        }
        return null;
    }

    @Override
    public FeatureVector toDefaultFeatureVector() {
        FeatureVector fv = new FeatureVector();
        fv.addDimension(OneStatementInOneLine.oneStmtPerLineAttr, null);
        return fv;
    }
}
