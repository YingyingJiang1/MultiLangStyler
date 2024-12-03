package org.example.analysis.feature.featurevalue;

import java.util.HashMap;
import java.util.Map;

public class StyleVector {
    Map<String, AttrValue> attrValueMap = new HashMap<String, AttrValue>(0);

    public void addAttrValue(String attrName, AttrValue attrValue) {
        attrValueMap.put(attrName, attrValue);
    }

    public Map<String, AttrValue> getAttrValueMap() {
        return attrValueMap;
    }

    public Map<String, Double> calculateDistance(StyleVector other) {
        Map<String, Double> ret = new HashMap<>();
        assert attrValueMap.keySet().equals(other.attrValueMap.keySet());


        for (String attrName : attrValueMap.keySet()) {
            double attrDistance = attrValueMap.get(attrName).calculateDistance(other.attrValueMap.get(attrName));
            ret.put(attrName, attrDistance);
        }
        return ret;
    }
}
