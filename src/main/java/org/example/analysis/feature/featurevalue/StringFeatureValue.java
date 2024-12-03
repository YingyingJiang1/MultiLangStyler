package org.example.analysis.feature.featurevalue;

public class StringFeatureValue implements FeatureValue {
    String value;

    public StringFeatureValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
