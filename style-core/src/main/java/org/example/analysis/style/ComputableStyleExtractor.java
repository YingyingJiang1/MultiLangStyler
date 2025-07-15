package org.example.analysis.style;

import org.example.analysis.StyleType;
import org.example.analysis.feature.FeatureVector;
import org.example.analysis.feature.featurevalue.StyleVector;
import org.example.parser.common.MyParser;
import org.example.style.Style;
import org.example.style.rule.StyleProperty;
import org.example.style.rule.StyleRule;

import java.util.Map;

public abstract class ComputableStyleExtractor {
    /**
     *
     * @param style style type of style transformer
     * @param styleMap key: name of style, value: ComputableStyle instance
     */
    public void toComputableStyle(Style style, Map<String, ComputableStyle> styleMap) {
        ComputableStyle cstyle = new ComputableStyle();
        for (StyleRule rule : style.getRules()) {
            FeatureVector fv = toFeatureVector(rule.getStyleProperty());
            if (fv != null) {
                cstyle.addRule(rule.getStyleContext(), fv);
            }
        }

        if (cstyle.isEmpty()) {
            cstyle.addRule(null, toDefaultFeatureVector());
        }
        updateStyleMap(cstyle, styleMap);
    }

    public void toComputableStyle(MyParser parser, Map<String, ComputableStyle> styleMap) {

    }

    protected void updateStyleMap(ComputableStyle cstyle, Map<String, ComputableStyle> styleMap) {

    }

    public FeatureVector toFeatureVector(StyleProperty styleProperty) {
        return null;
    }

    public FeatureVector toDefaultFeatureVector() {
        return null;
    }
}
