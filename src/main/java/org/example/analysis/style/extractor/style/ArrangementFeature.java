package org.example.analysis.style.extractor.style;

import org.example.analysis.style.ComputableStyle;
import org.example.analysis.feature.FeatureVector;
import org.example.analysis.StyleType.Arrangement;
import org.example.analysis.feature.featurevalue.*;
import org.example.analysis.style.ComputableStyleExtractor;
import org.example.style.Style;
import org.example.style.rule.StyleProperty;
import org.example.style.rule.StyleRule;
import org.example.styler.arrangement.classmember.style.ArrangementProperty;
import org.example.styler.arrangement.classmember.style.EnumType;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ArrangementFeature extends ComputableStyleExtractor {
    @Override
    protected void updateStyleMap(ComputableStyle cstyle, Map<String, ComputableStyle> styleMap) {
        styleMap.put(Arrangement.styleType, cstyle);
    }

    @Override
    public FeatureVector toFeatureVector(StyleProperty styleProperty) {
        if (styleProperty instanceof ArrangementProperty property) {
            // member list order
            List<String> memberList = new ArrayList<>();
            MapFeatureValue mapAttrValue =  new MapFeatureValue();
            for (ArrangementProperty.ContentArea area   : property.getAreas()) {
                String areaName = area.getClass().getSimpleName();
                memberList.add(areaName);

                boolean  isLogicalOrder = area.getOrder().getLogicalOrder() != EnumType.UNKNOWN;
                mapAttrValue.addValue(areaName, new BooleanFeatureValue(isLogicalOrder));
            }

            FeatureVector fv = new FeatureVector();
            fv.addDimension(Arrangement.logicalOrderAttr, mapAttrValue);
            fv.addDimension(Arrangement.memberListOrderAttr, new OrderedFeatureValue(memberList));
        }
        return null;
    }

    @Override
    public FeatureVector toDefaultFeatureVector() {
        FeatureVector fv = new FeatureVector();
        fv.addDimension(Arrangement.logicalOrderAttr,null);
        fv.addDimension(Arrangement.memberListOrderAttr,null);
        return fv;
    }
}
