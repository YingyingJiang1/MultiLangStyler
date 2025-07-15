package org.example.styler.declaration.layout.style;

import org.example.style.CommonStyle;
import org.example.style.rule.StyleContext;
import org.example.style.rule.StyleRule;
import org.example.style.rule.filter.MaxValueFilter;

import java.util.List;

public class DeclarationNumberStyle extends CommonStyle {

    public DeclarationNumberStyle() {
        super();
        styleName = "declaration_layout";
    }

    @Override
    public List<StyleContext> filterRules() {
        return ruleSet.filterRules(MaxValueFilter.getInstance());
    }

    @Override
    protected StyleRule createRule(String propertyName) {
        DeclarationLayoutProperty property = new DeclarationLayoutProperty();
        return new StyleRule(property);
    }
}
