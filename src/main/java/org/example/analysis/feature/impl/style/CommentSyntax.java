package org.example.analysis.feature.impl.style;

import org.example.analysis.StyleType;
import org.example.analysis.feature.StyleFeatureExtractor;
import org.example.analysis.feature.featurevalue.StringAttrValue;
import org.example.analysis.feature.featurevalue.StyleVector;
import org.example.style.Style;
import org.example.style.rule.StyleRule;
import org.example.styler.comment.syntax.style.CommentSyntaxContext;
import org.example.styler.comment.syntax.style.CommentSyntaxProperty;

import java.util.Map;

public class CommentSyntax implements StyleFeatureExtractor {
    @Override
    public void toFeatureVector(Style style, Map<String, StyleVector> st2svMap) {
        StyleVector sv = new StyleVector();
        for (StyleRule rule : style.getRules()) {
            if (rule.getStyleContext() instanceof CommentSyntaxContext context
            && rule.getStyleProperty() instanceof CommentSyntaxProperty property) {
                sv.addAttrValue(context.commentType.name(), new StringAttrValue(property.syntax));
            }
        }
        st2svMap.put(StyleType.CommentSyntax.styleType, sv);
    }
}
