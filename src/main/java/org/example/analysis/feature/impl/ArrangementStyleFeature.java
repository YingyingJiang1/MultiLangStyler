package org.example.analysis.feature.impl;

import org.example.analysis.feature.featurevalue.*;
import org.example.analysis.feature.StyleFeature;
import org.example.style.Style;
import org.example.style.rule.StyleRule;
import org.example.styler.arrangement.style.ArrangementProperty;
import org.example.styler.arrangement.style.EnumType;
import org.example.styler.arrangement.style.Order;

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
                for (ArrangementProperty.ContentArea area   : property.getAreas()) {
                    memberList.add(area.getClass().getSimpleName());
                    boolean  isLogicalOrder = area.getOrder().getLogicalOrder() != EnumType.UNKNOWN;
                    String key = "has a logical order in " + area.getClass().getSimpleName();
                    fv.addFeature("has a logical order in a ", new BooleanFeatureValue(isLogicalOrder));
                }
                fv.addFeature("Member list order", new OrderedFeatureValue(memberList));
            }
        }
        styleFeatures.put("Arrangement", fv);
    }


}
