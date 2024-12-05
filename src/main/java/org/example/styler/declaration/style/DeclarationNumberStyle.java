package org.example.styler.declaration.style;

import org.example.style.CommonStyle;
import org.example.style.rule.StyleContext;
import org.example.style.rule.StyleProperty;
import org.example.style.rule.filter.MaxValueFilter;

import java.util.List;

public class DeclarationNumberStyle extends CommonStyle {
    @Override
    public List<StyleContext> filterRules() {
        return ruleSet.filterRules(MaxValueFilter.getInstance());
    }
}
