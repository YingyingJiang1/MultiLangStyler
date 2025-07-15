package org.example.styler.arrangement.modifier.style;

import org.example.style.CommonStyle;
import org.example.style.rule.StyleContext;
import org.example.style.rule.StyleProperty;
import org.example.style.rule.StyleRule;

import java.util.List;

public class ModifierOrderStyle extends CommonStyle {

    public ModifierOrderStyle() {
        super();
        styleName = "modifier_order";
    }

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
                    if (p instanceof ModifierOrderProperty existedProperty) {
                        if (isSubsequence(property.order, existedProperty.order)) {
                            property.order = existedProperty.order;
                        } else if (isSubsequence(existedProperty.order, property.order)) {
                            existedProperty.order = property.order;
                        }
                    }
                }
                ruleSet.addRule(styleContext, styleProperty);
            }
        }
    }

    private boolean isSubsequence(List<String> sub, List<String> sequence) {
        int n = sub.size(), m = sequence.size();
        int i = 0, j = 0;
        while (i < n && j < m) {
            if (sub.get(i).equals(sequence.get(j))) {
                i++;
            }
            j++;
        }
        return i == n;
    }

    @Override
    protected StyleRule createRule(String propertyName) {
        ModifierOrderProperty property = new ModifierOrderProperty();
        return new StyleRule(property);
    }
}
