package org.example.analysis.feature.featurevalue;

import java.util.List;
import java.util.Map;

public class MapAttrValue implements AttrValue {
    Map<String, AttrValue> value;

    @Override
    public double calculateDistance(AttrValue other) {
        if (other instanceof MapAttrValue otherMap) {
            List<String> keys = keys = value.keySet().stream().filter(k -> otherMap.value.containsKey(k)).toList();
            if (keys.isEmpty()) return -1;

            double distance = 0;
            for (String key : keys) {
                distance += Math.pow(value.get(key).calculateDistance(otherMap.value.get(key)), 2);
            }
            return Math.sqrt(distance) / keys.size();
        }
        return -1;
    }

    public void addValue(String key, AttrValue value) {
        this.value.put(key, value);
    }
}
