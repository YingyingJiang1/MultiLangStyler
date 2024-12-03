package org.example.analysis.feature.featurevalue;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class StyleVector {
    Map<String, FeatureValue> featureValueMap = new HashMap<String, FeatureValue>(0);

    public double calculateDistance(StyleVector fv) {
        return 0;
    }

    public void addFeature(String featureName, FeatureValue featureValue) {
        featureValueMap.put(featureName, featureValue);
    }

    public Map<String, FeatureValue> getFeatureValueMap() {
        return featureValueMap;
    }
}
