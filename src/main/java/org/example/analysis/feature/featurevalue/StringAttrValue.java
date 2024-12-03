package org.example.analysis.feature.featurevalue;

public class StringAttrValue implements AttrValue {
    String value;

    public StringAttrValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public double calculateDistance(AttrValue other) {
        if (other instanceof StringAttrValue otherString) {
            return value.equals(otherString.value) ? 0 : 1;
        }
        return  -1;
    }
}
