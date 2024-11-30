package org.example.styler.format.newline.style;

import org.example.style.CommonStyle;
import org.example.style.rule.StyleContext;
import org.example.style.rule.StyleProperty;
import org.example.style.rule.StyleRule;
import org.example.styler.Stage;

import java.util.List;
import java.util.Objects;

public class NewlineStyle extends CommonStyle {
    @Override
    public void addRule(StyleContext styleContext, StyleProperty styleProperty) {
        if (styleContext instanceof NewlineContext context) {
            // If `ruleset` already has a newline context whose fields except for `minCodeBlockLines` are same with `styleContext`, then updates 'minCodeBlockLines' of the newline context in `ruleset`.
            List<StyleRule> rules = ruleSet.getRules().stream().filter(styleRule -> styleRule.styleContext instanceof NewlineContext context1 &&
                    Objects.equals(context.typeName1, context1.typeName1) &&
                    Objects.equals(context.typeName2, context1.typeName2)).toList();
            for (StyleRule rule : rules) {
                if (Objects.equals(rule.styleProperty, styleProperty) && context.minTextLength < ((NewlineContext) rule.styleContext).minTextLength) {
                    ruleSet.replace(rule.styleContext, styleContext);
                }
            }

            ruleSet.addRule(styleContext, styleProperty);
        }
    }
}
