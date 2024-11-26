package org.example.analysis.feature.featurevalue;

import java.util.HashMap;
import java.util.Map;

public class FeatureVector {
    Map<String, FeatureValue> featureValueMap = new HashMap<String, FeatureValue>(0);

    public double calculateDistance(FeatureVector fv) {
        return 0;
    }

    public void addFeature(String featureName, FeatureValue featureValue) {
        featureValueMap.put(featureName, featureValue);
    }

}
