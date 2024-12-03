package org.example.analysis.feature.featurevalue;

import java.util.ArrayList;
import java.util.List;

public class VectorFeatureValue implements FeatureValue{
    List<Boolean> bitVector = new ArrayList<Boolean>();

    public VectorFeatureValue(List<Boolean> bitVector) {
        this.bitVector = bitVector;
    }

    public VectorFeatureValue() {}

    public void add(boolean value) {
        bitVector.add(value);
    }

    public List<Boolean> getBitVector() {
        return bitVector;
    }
}
