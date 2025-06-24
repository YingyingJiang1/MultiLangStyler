package org.example.styler.format.style;

import org.example.style.CommonStyle;
import org.example.style.rule.StyleContext;
import org.example.style.rule.StyleProperty;
import org.example.style.rule.StyleRule;

import java.util.*;

public class NewlineStyle extends CommonStyle {

    public NewlineStyle() {
        super();
        styleName = "newline";
    }

    @Override
    public void addRule(StyleContext styleContext, StyleProperty styleProperty) {
        if (styleContext instanceof NewlineContext context) {
            // If `ruleset` already has a newline context whose fields except for `minCodeBlockLines` are same with `styleContext`, then updates 'minCodeBlockLines' of the newline context in `ruleset`.
            List<StyleRule> rules = ruleSet.getRules().stream().filter(styleRule -> styleRule.styleContext instanceof NewlineContext context1 &&
                    Objects.equals(context.typeName1, context1.typeName1) &&
                    Objects.equals(context.typeName2, context1.typeName2)).toList();
            for (StyleRule rule : rules) {
                if (Objects.equals(rule.styleProperty, styleProperty) && context.minTextLength < ((NewlineContext) rule.styleContext).minTextLength) {
                    ruleSet.updateKey(rule.styleContext, styleContext);
                }
            }
        }
        super.addRule(styleContext, styleProperty);
    }

    @Override
    protected StyleRule createRule(String propertyName) {
        NewlineContext context = new NewlineContext();
        NewlineProperty property = new NewlineProperty();
        return new StyleRule(context, property);
    }

}
