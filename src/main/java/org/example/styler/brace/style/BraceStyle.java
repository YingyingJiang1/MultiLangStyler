package org.example.styler.brace.style;

import org.antlr.v4.runtime.Parser;
import org.dom4j.Element;
import org.example.style.Style;
import org.example.style.rule.*;

public class BraceStyle extends Style {
    RuleSet formatRuleSet = new MapRuleSet();
    RuleSet optionalBraceRuleSet = new MapRuleSet();


    @Override
    public void addRule(StyleContext styleContext, StyleProperty styleProperty) {
        if (styleProperty instanceof BraceFormatProperty targetProperty) {
            addRule(styleContext, targetProperty, formatRuleSet);
        } else if (styleProperty instanceof OptionalBraceProperty targetProperty) {
            addRule(styleContext, targetProperty, optionalBraceRuleSet);
        }
    }

    @Override
    public StyleProperty getProperty(StyleContext styleContext) {
        StyleProperty res = null;
        if (styleContext instanceof BraceFormatContext) {
            formatRuleSet.getSimilarProperty(styleContext);
            return res;
        } else if (styleContext == null) {
            res = optionalBraceRuleSet.getProperty(null);
        }
        return res;
    }


    @Override
    public void fill() {
        formatRuleSet.filterRules();
        optionalBraceRuleSet.filterRules();
    }


    @Override
    public void addElement(Element parent, Parser parser) {
        addListElement(parent.element("brace_format_rules"), parser, formatRuleSet, "rule", "In @brace_info.@line_break_info: (beforeLB, afterLB, beforeRB, afterRB)");
        addListElement(parent.element("optional_brace_rules"), parser, optionalBraceRuleSet, "rule", null);
    }

    @Override
    public BraceStyle parseElement(Element parent, Parser parser) {
        Element braceFormatRulesEle = parent.element("brace_format_rules");
        Element optionalBraceRulesEle = parent.element("optional_brace_rules");

        parseListElement(braceFormatRulesEle, parser, formatRuleSet, BraceFormatProperty.class.getSimpleName());
        parseListElement(optionalBraceRulesEle, parser, optionalBraceRuleSet, OptionalBraceProperty.class.getSimpleName());
        return this;
    }

    @Override
    protected StyleRule createRule(String propertyName) {
        if (propertyName.equals(BraceFormatProperty.class.getSimpleName())) {
            return new StyleRule(new BraceFormatContext(), new BraceFormatProperty());
        } else if (propertyName.equals(OptionalBraceProperty.class.getSimpleName())) {
            return new StyleRule(null, new OptionalBraceProperty());
        }
        return null;
    }
}
