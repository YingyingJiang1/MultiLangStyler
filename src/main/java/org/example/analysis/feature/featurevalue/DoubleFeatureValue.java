package org.example.analysis.feature.featurevalue;

public class DoubleFeatureValue implements FeatureValue {
    double value;

    public DoubleFeatureValue(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    @Override
    public double calculateDistance(FeatureValue other) {
        if (other instanceof DoubleFeatureValue otherDouble) {
            return Math.round(Math.abs(value - otherDouble.value) * 100.0) / 100.0;
        }
        return -1;
    }
}
