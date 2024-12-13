package org.example.analysis.feature.featurevalue;

import org.example.utils.DistanceCalculator;

import java.util.ArrayList;
import java.util.List;

public class OrderedAttrValue implements AttrValue {
    private List<String> value = new ArrayList<String>();

    public OrderedAttrValue(List<String> value) {
        this.value = value;
    }

    public List<String> getValue() {
        return value;
    }

    @Override
    public double calculateDistance(AttrValue other) {
        if (other instanceof OrderedAttrValue otherOrdered) {
            List<String> removes = value.stream()
                    .filter(s -> !otherOrdered.value.contains(s))
                    .toList();
            List<String> newValue = value.stream().filter(s -> !removes.contains(s)).toList();
            List<String> newOtherValue = otherOrdered.value.stream().filter(s -> !removes.contains(s)).toList();
            otherOrdered.value.removeAll(removes);
            if (newValue.isEmpty()) {
                return -1;
            }
            double editDistance = DistanceCalculator.calculateEditDistance(newValue, newOtherValue);
            double maxDistance = newValue.size() - 1;
            return maxDistance == 0 ? 0 : DistanceCalculator.calculateEditDistance(newValue, newOtherValue) / maxDistance;
        }
        return -1;
    }
}
