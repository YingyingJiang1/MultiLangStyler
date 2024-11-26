package org.example.analysis.diff.impl;

import org.example.analysis.diff.feature.FeatureVector;
import org.example.analysis.diff.StyleFeature;
import org.example.analysis.diff.feature.OrderedFeatureValue;
import org.example.style.CommonStyle;
import org.example.style.rule.StyleRule;
import org.example.styler.arrangement.style.ArrangementProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ArrangementStyleFeature extends StyleFeature {
    @Override
    public void toFeatureVector(CommonStyle commonStyle, Map<String, FeatureVector> styleFeatures) {
        FeatureVector fv = new FeatureVector();
        for (StyleRule rule : commonStyle.getRules()) {
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
