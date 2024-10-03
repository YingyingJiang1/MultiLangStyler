package org.example.styler.brace.style;

import org.antlr.v4.runtime.Parser;
import org.dom4j.Element;
import org.example.interfaces.Style;
import org.example.interfaces.StyleContext;
import org.example.interfaces.StyleProperty;
import org.example.interfaces.StyleRule;

import java.beans.BeanProperty;
import java.util.*;

public class BraceStyle extends Style {
    List<StyleRule> braceFormatRules = new ArrayList<>();
    List<StyleRule> optionalBraceRules = new ArrayList<>();
    
    // key: index of rule.
    // value: frequency.
    private List<Integer> formatFrequencies = new ArrayList<>();
    private List<Integer> optionalFrequencies = new ArrayList<>();

    public BraceStyle() {
        styleName = "Brace_Style";
    }

    @Override
    public void addRule(StyleContext styleContext, StyleProperty styleProperty) {
        StyleRule targetRule = new StyleRule(styleContext, styleProperty);
        if (styleProperty instanceof BraceFormatProperty targetProperty) {
            addRule(targetRule, braceFormatRules, formatFrequencies);
        } else if (styleProperty instanceof OptionalBraceProperty targetProperty) {
            addRule(targetRule, optionalBraceRules, optionalFrequencies);
        }
    }

    @Override
    public StyleProperty getProperty(StyleContext styleContext) {
        StyleProperty res = null;
        if (styleContext instanceof BraceFormatContext) {
            int minDis = Integer.MAX_VALUE;
            BraceFormatProperty lineBreakInfo = null;
            for(StyleRule rule : braceFormatRules) {
                BraceFormatContext braceFormatContext = (BraceFormatContext) rule.getStyleContext();
                int distance = braceFormatContext.calculateDis(styleContext);
                if(distance < minDis) {
                    minDis = distance;
                    res = rule.getStyleProperty();
                }
            }
            return res;
        } else if (styleContext == null) {
            res = optionalBraceRules.isEmpty() ? null : optionalBraceRules.get(0).getStyleProperty();
        }
        return res;
    }


    @Override
    public void fill() {
        ruleFilter.filterRepeatedRules(braceFormatRules, formatFrequencies);

        boolean compactStyle = false;
        int maxFrequency = 0;
        for (int i = 0; i < optionalBraceRules.size(); i++) {
            OptionalBraceProperty property = (OptionalBraceProperty) optionalBraceRules.get(i).getStyleProperty();
            if (!property.useBrace && optionalFrequencies.get(i) > maxFrequency) {
                compactStyle = property.compactStyle;
                maxFrequency = optionalFrequencies.get(i);
            }
        }
        ruleFilter.filterRules2one(optionalBraceRules, optionalFrequencies);
        if (!optionalBraceRules.isEmpty()) {
            OptionalBraceProperty property = (OptionalBraceProperty) optionalBraceRules.get(0).getStyleProperty();
            property.compactStyle = compactStyle;
        }

        formatFrequencies = null;
        optionalFrequencies = null;
    }


    @Override
    public void addElement(Element parent, Parser parser) {
        Element braceRulesEle = parent.element("brace_rules");
        addListElement(braceRulesEle, parser, braceFormatRules, "brace_format_rules", "In @brace_info.@line_break_info: (beforeLB, afterLB, beforeRB, afterRB)");
        addListElement(braceRulesEle, parser, optionalBraceRules, "optional_brace_rules", null);
    }

    @Override
    public BraceStyle parseElement(Element parent, Parser parser) {
        Element braceRulesEle = parent.element("brace_rules");
        Element braceFormatRulesEle = braceRulesEle.element("brace_format_rules");
        Element optionalBraceRulesEle = braceRulesEle.element("optional_brace_rules");

        parseListElement(braceFormatRulesEle, parser, braceFormatRules, "brace_format_rules");
        parseListElement(optionalBraceRulesEle, parser, optionalBraceRules, "optional_brace_rules");
        return this;
    }

    @Override
    protected StyleRule createRule(Element element) {
        return super.createRule(element);
    }
}
