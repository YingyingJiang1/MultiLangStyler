package org.example.analysis.feature.featurevalue;

import org.example.utils.DistanceCalculator;

import java.util.ArrayList;
import java.util.List;

public class OrderedFeatureValue implements FeatureValue {
    private List<String> value = new ArrayList<String>();

    public OrderedFeatureValue(List<String> value) {
        this.value = value;
    }

    public List<String> getValue() {
        return value;
    }

    @Override
    public double calculateDistance(FeatureValue other) {
        if (other instanceof OrderedFeatureValue otherOrdered) {
            List<String> removes = value.stream()
                    .filter(s -> !otherOrdered.value.contains(s))
                    .toList();
            List<String> newValue = value.stream().filter(s -> !removes.contains(s)).toList();
            List<String> newOtherValue = otherOrdered.value.stream().filter(s -> !removes.contains(s)).toList();
            otherOrdered.value.removeAll(removes);
            if (newValue.isEmpty()) {
                return -1;
            }
            return DistanceCalculator.calculateEditDistance(newValue, newOtherValue);
        }
        return -1;
    }
}
