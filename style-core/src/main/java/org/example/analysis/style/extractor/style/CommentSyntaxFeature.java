package org.example.analysis.style.extractor.style;

import org.example.analysis.feature.FeatureVector;
import org.example.analysis.feature.featurevalue.DoubleFeatureValue;
import org.example.analysis.style.ComputableStyle;
import org.example.analysis.StyleType;
import org.example.analysis.style.ComputableStyleExtractor;
import org.example.analysis.feature.featurevalue.StringFeatureValue;
import org.example.analysis.feature.featurevalue.StyleVector;
import org.example.style.Style;
import org.example.style.rule.StyleProperty;
import org.example.style.rule.StyleRule;
import org.example.styler.comment.density.style.CommentDensityProperty;
import org.example.styler.comment.syntax.style.CommentSyntaxContext;
import org.example.styler.comment.syntax.style.CommentSyntaxProperty;

import java.util.Map;

public class CommentSyntaxFeature extends ComputableStyleExtractor {
    @Override
    protected void updateStyleMap(ComputableStyle cstyle, Map<String, ComputableStyle> styleMap) {
        styleMap.put(StyleType.CommentSyntax.styleType, cstyle);
    }

    @Override
    public FeatureVector toFeatureVector(StyleProperty styleProperty) {
        if (styleProperty instanceof CommentSyntaxProperty property) {
            FeatureVector fv = new FeatureVector();
            fv.addDimension(StyleType.CommentSyntax.commentSyntaxAttr, new StringFeatureValue(property.syntax));
        }
        return null;
    }

    @Override
    public FeatureVector toDefaultFeatureVector() {
        FeatureVector fv = new FeatureVector();
        fv.addDimension(StyleType.CommentSyntax.commentSyntaxAttr, null);
        return fv;
    }

}
