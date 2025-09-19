package org.example.styler.declaration.layout.style;

import org.example.style.CommonStyle;
import org.example.style.rule.StyleContext;
import org.example.style.rule.StyleProperty;
import org.example.style.rule.StyleRule;

public class DeclarationLayoutStyle extends CommonStyle {
    private double mergeCount, totalCount;

    public DeclarationLayoutStyle() {
        super();
        styleName = "declaration_layout";
    }


    @Override
    public void addRule(StyleContext styleContext, StyleProperty styleProperty) {
        if (styleProperty instanceof DeclarationLayoutProperty property) {
            mergeCount += property.mergeCount;
            totalCount += property.totalCount;
        }
    }

    @Override
    public void fillStyle() {
        if (totalCount != 0) {
            ruleSet.addRule(null, new DeclarationLayoutProperty(mergeCount, totalCount));
        }
        // reset
        mergeCount = 0;
        totalCount = 0;
    }

    @Override
    protected StyleRule createRule(String propertyName) {
        DeclarationLayoutProperty property = new DeclarationLayoutProperty();
        return new StyleRule(property);
    }
}
