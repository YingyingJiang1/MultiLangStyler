package org.example.style.rule.filter;

import org.example.style.rule.StyleProperty;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class MaxFrequencyFilter implements StylePropertyFilter {
    private static final MaxFrequencyFilter instance = new MaxFrequencyFilter();

    private MaxFrequencyFilter() {}

    public static MaxFrequencyFilter getInstance() {
        return instance;
    }

    @Override
    public List<StyleProperty> get(List<StyleProperty> properties, List<Integer> frequencies) {
        List<StyleProperty> ret = new ArrayList<>();
        Optional<Integer> maxFrequency = frequencies.stream().max(Comparator.comparingInt(i -> i));
        if (maxFrequency.isPresent()) {
            int max = maxFrequency.get();
            for (int i = 0; i < properties.size(); i++) {
                if (frequencies.get(i) == max) {
                    ret.add(properties.get(i));
                }
            }
        }
        return ret;
    }
}
