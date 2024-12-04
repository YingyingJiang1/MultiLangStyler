package org.example.styler.arrangement.modifier.style;

import org.example.style.CommonStyle;
import org.example.style.rule.StyleContext;
import org.example.style.rule.StyleProperty;

import java.util.List;

public class ModifierOrderStyle extends CommonStyle {

    /**
     *
     * @param styleContext always null.
     * @param styleProperty
     */
    @Override
    public void addRule(StyleContext styleContext, StyleProperty styleProperty) {
        if (styleProperty instanceof ModifierOrderProperty property) {
            List<StyleProperty> properties = ruleSet.getProperties(styleContext);
            if (properties == null) {
                ruleSet.addRule(styleContext, styleProperty);
            } else {
                for (StyleProperty p : properties) {
                    if (p instanceof ModifierOrderProperty modifierProperty) {

                    }
                }
                ruleSet.addRule(styleContext, styleProperty);
            }
        }
    }
}
