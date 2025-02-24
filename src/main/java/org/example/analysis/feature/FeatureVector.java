package org.example.analysis.feature;

import org.example.analysis.feature.featurevalue.FeatureValue;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FeatureVector {

    Map<String, FeatureValue> vector = new HashMap<>();

    public void addDimension(String name, FeatureValue value) {
        vector.put(name, value);
    }

    public List<Double> calculateDistance(FeatureVector other) {
        List<Double> distance = new ArrayList<>();
        for (String key : vector.keySet()) {
            if (!other.vector.containsKey(key)) {
                System.err.println("Inconsistent dimension error.");
                System.err.println("vector1:" + vector.keySet());
                System.err.println("vector2:" + other.vector.keySet());
                continue;
            }
            distance.add(vector.get(key).calculateDistance(other.vector.get(key)));
        }
        return distance;
    }


    public int getDimension() {
        return vector.size();
    }
}
