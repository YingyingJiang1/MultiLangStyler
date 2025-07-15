package org.example.analysis.feature.featurevalue;

public class BooleanFeatureValue implements FeatureValue {
    boolean value;

    public BooleanFeatureValue(boolean value) {
        this.value = value;
    }

    public void setValue(boolean value) {
        this.value = value;
    }

    @Override
    public double calculateDistance(FeatureValue other) {
        if (other instanceof BooleanFeatureValue otherBoolean) {
            return value == otherBoolean.value ? 0 : 1;
        }
        return -1;
    }

    public boolean isValue() {
        return value;
    }
}
