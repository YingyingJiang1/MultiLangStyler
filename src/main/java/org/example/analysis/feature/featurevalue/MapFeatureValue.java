package org.example.analysis.feature.featurevalue;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapFeatureValue implements FeatureValue {
    Map<String, FeatureValue> value = new HashMap<String, FeatureValue>();

    @Override
    public double calculateDistance(FeatureValue other) {
        if (other instanceof MapFeatureValue otherMap) {
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

    public void addValue(String key, FeatureValue value) {
        this.value.put(key, value);
    }

    public Map<String, FeatureValue> getValue() {
        return value;
    }
}
