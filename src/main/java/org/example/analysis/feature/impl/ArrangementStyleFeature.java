package org.example.analysis.feature.impl;

import org.example.analysis.feature.featurevalue.StyleVector;
import org.example.analysis.feature.StyleFeature;
import org.example.analysis.feature.featurevalue.OrderedFeatureValue;
import org.example.style.Style;
import org.example.style.rule.StyleRule;
import org.example.styler.arrangement.style.ArrangementProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ArrangementStyleFeature extends StyleFeature {
    @Override
    public void toFeatureVector(Style style, Map<String, StyleVector> styleFeatures) {
        StyleVector fv = new StyleVector();
        for (StyleRule rule : style.getRules()) {
            if (rule.getStyleProperty() instanceof ArrangementProperty property) {
                // member list order
                List<String> memberList = new ArrayList<>();
                property.getAreas().forEach(area -> memberList.add(area.getClass().getSimpleName()));
                fv.addFeature("Member list order", new OrderedFeatureValue(memberList));
            }
        }
        styleFeatures.put("Arrangement", fv);
    }
}
