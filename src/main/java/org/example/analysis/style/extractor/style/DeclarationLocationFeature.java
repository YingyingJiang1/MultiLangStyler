package org.example.analysis.style.extractor.style;

import org.example.analysis.StyleType;
import org.example.analysis.feature.FeatureVector;
import org.example.analysis.style.ComputableStyle;
import org.example.analysis.StyleType.LocOfVarDeclaration;
import org.example.analysis.style.ComputableStyleExtractor;
import org.example.analysis.feature.featurevalue.StringFeatureValue;
import org.example.analysis.feature.featurevalue.StyleVector;
import org.example.style.Style;
import org.example.style.rule.StyleProperty;
import org.example.style.rule.StyleRule;
import org.example.styler.comment.syntax.style.CommentSyntaxProperty;
import org.example.styler.declaration.location.style.DeclarationLocationProperty;

import java.util.Map;

public class DeclarationLocationFeature extends ComputableStyleExtractor {
    @Override
    protected void updateStyleMap(ComputableStyle cstyle, Map<String, ComputableStyle> styleMap) {
        styleMap.put(LocOfVarDeclaration.styleType, cstyle);
    }

    @Override
    public FeatureVector toFeatureVector(StyleProperty styleProperty) {
        if (styleProperty instanceof DeclarationLocationProperty property) {
            FeatureVector fv = new FeatureVector();
            fv.addDimension(LocOfVarDeclaration.locationAttr, new StringFeatureValue(property.location.name()));
        }
        return null;
    }

    @Override
    public FeatureVector toDefaultFeatureVector() {
        FeatureVector fv = new FeatureVector();
        fv.addDimension(LocOfVarDeclaration.locationAttr, null);
        return fv;
    }

}
