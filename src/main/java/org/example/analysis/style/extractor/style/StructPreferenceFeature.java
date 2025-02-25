package org.example.analysis.style.extractor.style;

import org.example.analysis.StyleType;
import org.example.analysis.feature.FeatureVector;
import org.example.analysis.style.ComputableStyle;
import org.example.analysis.style.ComputableStyleExtractor;
import org.example.analysis.feature.featurevalue.*;
import org.example.parser.common.factory.MyParserFactory;
import org.example.style.Style;
import org.example.style.rule.StyleProperty;
import org.example.style.rule.StyleRule;
import org.example.styler.format.space.style.SpaceProperty;
import org.example.styler.structure.EquivalentStructure;
import org.example.styler.structure.EquivalentStructureManager;
import org.example.styler.structure.style.StructPreferenceContext;
import org.example.styler.structure.style.StructPreferenceProperty;

import java.util.List;
import java.util.Map;

public class StructPreferenceFeature extends ComputableStyleExtractor {
    @Override
    public void toComputableStyle(Style style, Map<String, ComputableStyle> styleMap) {
        List<EquivalentStructure> equivalences = EquivalentStructureManager.getInstance()
                .loadEquivalences(MyParserFactory.createParser("java").getClass(), "/equivalencesConf.json");

        for (StyleRule rule : style.getRules()) {
            if (rule.getStyleContext() instanceof  StructPreferenceContext context &&
                    rule.getStyleProperty() instanceof StructPreferenceProperty property) {
                EquivalentStructure structure = equivalences.stream().filter(e -> e.getId() == context.getStructID()).toList().get(0);
                String styleType = structure.getCategory();

                FeatureVector fv = new FeatureVector();
                fv.addDimension("The index of written", new StringFeatureValue(Integer.toString(property.getPreferenceIndex())));
                ComputableStyle cStyle = new ComputableStyle();
                cStyle.addRule(context, fv);
                styleMap.put(styleType, cStyle);
            }
        }

        for (String styleName : StyleType.getStructPreferenceTypes()) {
            if (!styleMap.containsKey(styleName)) {
                ComputableStyle cStyle = new ComputableStyle();
                cStyle.addRule(null, toDefaultFeatureVector());
                styleMap.put(styleName, cStyle);
            }
        }
    }

    @Override
    public FeatureVector toDefaultFeatureVector() {
        FeatureVector fv = new FeatureVector();
        fv.addDimension("The index of written", null);
        return fv;
    }
}
