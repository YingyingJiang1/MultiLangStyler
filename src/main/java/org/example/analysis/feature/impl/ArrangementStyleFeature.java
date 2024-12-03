package org.example.analysis.feature.impl;

import org.example.analysis.StyleType.Arrangement;
import org.example.analysis.feature.featurevalue.*;
import org.example.analysis.feature.StyleFeature;
import org.example.style.Style;
import org.example.style.rule.StyleRule;
import org.example.styler.arrangement.style.ArrangementProperty;
import org.example.styler.arrangement.style.EnumType;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ArrangementStyleFeature extends StyleFeature {
    @Override
    public void toFeatureVector(Style style, Map<String, StyleVector> st2svMap) {
        StyleVector sv = new StyleVector();
        for (StyleRule rule : style.getRules()) {
            if (rule.getStyleProperty() instanceof ArrangementProperty property) {
                // member list order
                List<String> memberList = new ArrayList<>();
                MapAttrValue mapAttrValue =  new MapAttrValue();
                for (ArrangementProperty.ContentArea area   : property.getAreas()) {
                    String areaName = area.getClass().getSimpleName();
                    memberList.add(areaName);

                    boolean  isLogicalOrder = area.getOrder().getLogicalOrder() != EnumType.UNKNOWN;
                    mapAttrValue.addValue(areaName, new BooleanAttrValue(isLogicalOrder));
                }
                sv.addAttrValue(Arrangement.logicalOrderAttr, mapAttrValue);
                sv.addAttrValue(Arrangement.memberListOrderAttr, new OrderedAttrValue(memberList));
            }
        }
        st2svMap.put(Arrangement.styleType, sv);
    }


}
