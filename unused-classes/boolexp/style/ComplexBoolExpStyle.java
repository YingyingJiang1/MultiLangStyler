package org.example.styler.exp.style;

import org.example.style.CommonStyle;
import org.example.style.rule.StyleContext;
import org.example.style.rule.filter.MaxValueFilter;

import java.util.List;

public class ComplexBoolExpStyle extends CommonStyle {
    @Override
    public List<StyleContext> filterRules() {
        return ruleSet.filterRules(MaxValueFilter.getInstance());
    }
}
