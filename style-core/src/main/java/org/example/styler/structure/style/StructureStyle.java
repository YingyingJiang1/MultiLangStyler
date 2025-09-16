package org.example.styler.structure.style;

import org.example.style.CommonStyle;
import org.example.style.rule.StyleContext;
import org.example.style.rule.StyleProperty;
import org.example.style.rule.StyleRule;

public class StructureStyle extends CommonStyle {
    
    public StructureStyle() {
        super();
        styleName = "structure_preference";
    }

    @Override
    public void addRule(StyleContext styleContext, StyleProperty styleProperty) {
        if (styleContext instanceof StructPreferenceContext context) {
            if (context.getStyleCategory() != null) {
                ruleSet.addRule(new StructPreferenceContext(context.getStyleCategory()), styleProperty);
            } else {
                ruleSet.addRule(new StructPreferenceContext(context.getStructID()), styleProperty);
            }
        }
    }

    @Override
    public StyleProperty getProperty(StyleContext targetContext) {
        if (targetContext instanceof StructPreferenceContext context) {
            StyleProperty property = ruleSet.getProperty(context);
            if (property != null) {
                return property;
            }

            property = ruleSet.getProperty(new StructPreferenceContext(context.styleCategory, -1));
            if (property != null) {
                return property;
            }

            property = ruleSet.getProperty(new StructPreferenceContext(null , context.getStructID()));
            if (property != null) {
                return property;
            }
        }

        return null;
    }

    @Override
    protected StyleRule createRule(String propertyName) {
        StructPreferenceContext context = new StructPreferenceContext();
        StructPreferenceProperty property = new StructPreferenceProperty();
        return new StyleRule(context, property);
    }
}
