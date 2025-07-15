package org.example.analysis.feature.featurevalue;

public class StringFeatureValue implements FeatureValue {
    String value;

    public StringFeatureValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public double calculateDistance(FeatureValue other) {
        if (other instanceof StringFeatureValue otherString) {
            return value.equals(otherString.value) ? 0 : 1;
        }
        return  -1;
    }
}
