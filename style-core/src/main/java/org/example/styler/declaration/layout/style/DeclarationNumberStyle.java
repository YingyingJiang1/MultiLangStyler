package org.example.styler.declaration.layout.style;

import org.example.style.CommonStyle;
import org.example.style.rule.StyleContext;
import org.example.style.rule.StyleProperty;
import org.example.style.rule.StyleRule;

import java.util.List;

public class DeclarationNumberStyle extends CommonStyle {

    public DeclarationNumberStyle() {
        super();
        styleName = "declaration_layout";
    }


    @Override
    public void addRule(StyleContext styleContext, StyleProperty styleProperty) {
        if (ruleSet.getProperties(styleContext) instanceof DeclarationLayoutProperty property
        && styleProperty instanceof DeclarationLayoutProperty newProperty) {
            if (property.maxVariableCount < newProperty.maxVariableCount) {
                property.maxVariableCount = newProperty.maxVariableCount;
            }
            if(property.maxLength < newProperty.maxLength) {
                property.maxLength = newProperty.maxLength;
            }
        } else {
            ruleSet.addRule(styleContext, styleProperty);
        }
    }

    @Override
    protected StyleRule createRule(String propertyName) {
        DeclarationLayoutProperty property = new DeclarationLayoutProperty();
        return new StyleRule(property);
    }
}
