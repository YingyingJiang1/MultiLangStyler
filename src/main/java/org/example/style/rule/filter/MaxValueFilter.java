package org.example.style.rule.filter;

import org.example.style.rule.StyleProperty;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class MaxValueFilter implements StylePropertyFilter{
    private static final MaxValueFilter instance = new MaxValueFilter();

    private MaxValueFilter() {}

    public static MaxValueFilter getInstance() {
        return instance;
    }


    @Override
    public List<StyleProperty> get(List<StyleProperty> properties, List<Integer> frequencies) {
        List<StyleProperty> ret = new ArrayList<>();
        Optional<StyleProperty> maxProperty =  properties.stream().max(Comparator.comparing(p -> p));
        maxProperty.ifPresent(ret::add);
        return ret;
    }
}
