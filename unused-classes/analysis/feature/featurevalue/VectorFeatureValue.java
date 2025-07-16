package org.example.analysis.feature.featurevalue;

import java.util.ArrayList;
import java.util.List;

public class VectorFeatureValue implements FeatureValue {
    List<Boolean> value = new ArrayList<Boolean>();

    public VectorFeatureValue(List<Boolean> bitVector) {
        this.value = bitVector;
    }

    public VectorFeatureValue() {}

    public void add(boolean value) {
        this.value.add(value);
    }

    public List<Boolean> getValue() {
        return value;
    }

    @Override
    public double calculateDistance(FeatureValue other) {
        if (other instanceof VectorFeatureValue otherVector) {
            assert value.size() == otherVector.value.size();
            if (value.isEmpty()) return -1;

            double distance = 0;
            for (int i = 0; i < value.size(); i++) {
                distance += value.get(i) == otherVector.value.get(i) ? 0 : 1;
            }
            return distance;
        }
        return 0;
    }
}
