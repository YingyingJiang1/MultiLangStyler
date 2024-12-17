package org.example.analysis.feature.featurevalue;

public class DoubleAttrValue implements AttrValue {
    double value;

    public DoubleAttrValue(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    @Override
    public double calculateDistance(AttrValue other) {
        if (other instanceof DoubleAttrValue otherDouble) {
            return Math.round(Math.abs(value - otherDouble.value) * 100.0) / 100.0;
        }
        return -1;
    }
}
