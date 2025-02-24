package org.example.analysis.style.extractor.style;

import org.example.analysis.StyleType;
import org.example.analysis.feature.FeatureVector;
import org.example.analysis.feature.featurevalue.StringFeatureValue;
import org.example.analysis.style.ComputableStyle;
import org.example.analysis.StyleType.Space;
import org.example.analysis.style.ComputableStyleExtractor;
import org.example.analysis.feature.featurevalue.BooleanFeatureValue;
import org.example.analysis.feature.featurevalue.StyleVector;
import org.example.analysis.feature.featurevalue.VectorFeatureValue;
import org.example.style.Style;
import org.example.style.rule.StyleProperty;
import org.example.style.rule.StyleRule;
import org.example.styler.arrangement.param.style.ParameterOrderProperty;
import org.example.styler.format.space.style.SpaceContext;
import org.example.styler.format.space.style.SpaceProperty;

import java.util.List;
import java.util.Map;

public class SpaceFeature extends ComputableStyleExtractor {
    @Override
    protected void updateStyleMap(ComputableStyle cstyle, Map<String, ComputableStyle> styleMap) {
        styleMap.put(StyleType.Space.styleType, cstyle);
    }

    @Override
    public FeatureVector toFeatureVector(StyleProperty styleProperty) {
        if (styleProperty instanceof SpaceProperty property) {
            FeatureVector fv = new FeatureVector();
            fv.addDimension(Space.spaceAroundAttr, new VectorFeatureValue(List.of(property.space1, property.space2)));
            fv.addDimension(Space.spaceBetweenAttr, new BooleanFeatureValue(property.space2));
        }
        return null;
    }

    @Override
    public FeatureVector toDefaultFeatureVector() {
        FeatureVector fv = new FeatureVector();
        fv.addDimension(Space.spaceAroundAttr, null);
        fv.addDimension(Space.spaceBetweenAttr, null);
        return fv;
    }

}
