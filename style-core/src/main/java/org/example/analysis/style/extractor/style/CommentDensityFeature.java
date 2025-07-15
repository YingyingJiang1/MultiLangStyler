package org.example.analysis.style.extractor.style;

import org.example.analysis.feature.FeatureVector;
import org.example.analysis.style.ComputableStyle;
import org.example.analysis.StyleType;
import org.example.analysis.style.ComputableStyleExtractor;
import org.example.analysis.feature.featurevalue.DoubleFeatureValue;
import org.example.style.rule.StyleProperty;
import org.example.styler.comment.density.style.CommentDensityProperty;

import java.util.Map;

public class CommentDensityFeature extends ComputableStyleExtractor {

    @Override
    protected void updateStyleMap(ComputableStyle cstyle, Map<String, ComputableStyle> styleMap) {
        styleMap.put(StyleType.CommentDensity.styleType, cstyle);
    }

    @Override
    public FeatureVector toFeatureVector(StyleProperty styleProperty) {
        if (styleProperty instanceof CommentDensityProperty property) {
            FeatureVector fv = new FeatureVector();
            fv.addDimension(StyleType.CommentDensity.LineDensityAttr, new DoubleFeatureValue(property.commentDensity));
        }
        return null;
    }

    @Override
    public FeatureVector toDefaultFeatureVector() {
        FeatureVector fv = new FeatureVector();
        fv.addDimension(StyleType.CommentDensity.LineDensityAttr, null);
        return fv;
    }
}
