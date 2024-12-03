package org.example.analysis.feature.featurevalue;

public class BooleanAttrValue implements AttrValue {
    boolean value;

    public BooleanAttrValue(boolean value) {
        this.value = value;
    }

    public void setValue(boolean value) {
        this.value = value;
    }

    @Override
    public double calculateDistance(AttrValue other) {
        if (other instanceof BooleanAttrValue otherBoolean) {
            return value == otherBoolean.value ? 0 : 1;
        }
        return -1;
    }

    public boolean isValue() {
        return value;
    }
}
