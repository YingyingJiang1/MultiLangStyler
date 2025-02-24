package org.example.analysis.feature;

import org.example.analysis.feature.featurevalue.FeatureValue;

import java.util.List;
import java.util.Map;

public class FeatureVector {

    Map<String, FeatureValue> vector;

    public void addDimension(String name, FeatureValue value) {
        vector.put(name, value);
    }

    public List<Double> calculateDistance(FeatureVector other) {
        return null;
    }


    public int getDimension() {
        return 0;
    }
}
