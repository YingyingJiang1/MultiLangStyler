package org.example.analysis.feature.impl;

import org.example.analysis.DiffAnalyzer;
import org.example.analysis.feature.StyleFeatureExtractor;
import org.example.analysis.feature.featurevalue.*;
import org.example.parser.common.factory.MyParserFactory;
import org.example.style.Style;
import org.example.style.rule.StyleRule;
import org.example.styler.structure.EquivalentStructure;
import org.example.styler.structure.EquivalentStructureManager;
import org.example.styler.structure.style.StructPreferenceContext;
import org.example.styler.structure.style.StructPreferenceProperty;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class StructPreferenceFeatureExtractor extends StyleFeatureExtractor {
    /**
     * All style types:
     *
     *
     */

    @Override
    public void toFeatureVector(Style style, Map<String, StyleVector> st2svMap) {
        List<EquivalentStructure> equivalences = EquivalentStructureManager.getInstance()
                .loadEquivalences(MyParserFactory.createParser(DiffAnalyzer.language).getClass());

        for (StyleRule rule : style.getRules()) {
            if (rule.getStyleContext() instanceof  StructPreferenceContext context &&
            rule.getStyleProperty() instanceof StructPreferenceProperty property) {
                EquivalentStructure structure = equivalences.stream().filter(e -> e.getId() == context.getStructID()).toList().get(0);
                String styleType = structure.getCategory();

                // set writings
                List<Boolean> writings = new java.util.ArrayList<>(Collections.nCopies(structure.getWrittingNum(), false));
                writings.set(property.getPreferenceIndex(), true);


                StyleVector sv = st2svMap.computeIfAbsent(styleType, k -> new StyleVector());
                sv.addAttrValue("struct id:" + context.getStructID(), new VectorAttrValue(writings));
            }
        }
    }
}
