package org.example.analysis.style.extractor.style;

import org.example.analysis.style.ComputableStyle;
import org.example.analysis.DiffAnalyzer;
import org.example.analysis.style.ComputableStyleExtractor;
import org.example.analysis.feature.featurevalue.*;
import org.example.parser.common.factory.MyParserFactory;
import org.example.style.Style;
import org.example.style.rule.StyleRule;
import org.example.styler.structure.EquivalentStructure;
import org.example.styler.structure.EquivalentStructureManager;
import org.example.styler.structure.style.StructPreferenceContext;
import org.example.styler.structure.style.StructPreferenceProperty;

import java.util.List;
import java.util.Map;

public class StructPreferenceFeature implements ComputableStyleExtractor {
    /**
     * All style types:
     *
     *
     */

    @Override
    public void toComputableStyle(Style style, Map<String, ComputableStyle> styleMap) {
        List<EquivalentStructure> equivalences = EquivalentStructureManager.getInstance()
                .loadEquivalences(MyParserFactory.createParser(DiffAnalyzer.language).getClass(), "/equivalencesConf.json");

        for (StyleRule rule : style.getRules()) {
            if (rule.getStyleContext() instanceof  StructPreferenceContext context &&
            rule.getStyleProperty() instanceof StructPreferenceProperty property) {
                EquivalentStructure structure = equivalences.stream().filter(e -> e.getId() == context.getStructID()).toList().get(0);
                String styleType = structure.getCategory();

                // set writings
//                List<Boolean> writings = new java.util.ArrayList<>(Collections.nCopies(structure.getWrittingNum(), false));
//                writings.set(property.getPreferenceIndex(), true);


                StyleVector sv = styleMap.computeIfAbsent(styleType, k -> new StyleVector());
                StringFeatureValue value = new StringFeatureValue(Integer.toString(property.getPreferenceIndex()));
                sv.addAttrValue("struct id:" + context.getStructID(), value);
            }
        }
    }
}
