package org.example.style.rule.filter;

import org.example.style.rule.StyleProperty;

import java.util.List;

public interface StylePropertyFilter {
    List<StyleProperty> get(List<StyleProperty> properties, List<Integer> frequencies);
}
