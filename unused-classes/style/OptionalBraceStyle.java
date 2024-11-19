package org.example.styler.brace.style;

import org.antlr.v4.runtime.Parser;
import org.dom4j.Element;
import org.example.style.Style;
import org.example.style.rule.*;
import org.example.styler.format.body.style.BodyLayoutContext;
import org.example.styler.format.body.style.BodyLayoutProperty;

public class OptionalBraceStyle extends Style {


    @Override
    public void addRule(StyleContext styleContext, StyleProperty styleProperty) {
        if (styleProperty instanceof BodyLayoutProperty targetProperty) {
            addRule(styleContext, targetProperty, formatRuleSet);
        } else if (styleProperty instanceof OptionalBraceProperty targetProperty) {
            addRule(styleContext, targetProperty, optionalBraceRuleSet);
        }
    }

    @Override
    public StyleProperty getProperty(StyleContext styleContext) {
        StyleProperty res = null;
        if (styleContext instanceof BodyLayoutContext) {
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
    public OptionalBraceStyle parseElement(Element parent, Parser parser) {
        Element braceFormatRulesEle = parent.element("brace_format_rules");
        Element optionalBraceRulesEle = parent.element("optional_brace_rules");

        parseListElement(braceFormatRulesEle, parser, formatRuleSet, BodyLayoutProperty.class.getSimpleName());
        parseListElement(optionalBraceRulesEle, parser, optionalBraceRuleSet, OptionalBraceProperty.class.getSimpleName());
        return this;
    }

    @Override
    protected StyleRule createRule(String propertyName) {
        if (propertyName.equals(BodyLayoutProperty.class.getSimpleName())) {
            return new StyleRule(new BodyLayoutContext(), new BodyLayoutProperty());
        } else if (propertyName.equals(OptionalBraceProperty.class.getSimpleName())) {
            return new StyleRule(null, new OptionalBraceProperty());
        }
        return null;
    }
}
