package org.example.styler.hws.style;

import org.antlr.v4.runtime.Parser;
import org.dom4j.Element;
import org.example.interfaces.Style;
import org.example.interfaces.StyleContext;
import org.example.interfaces.StyleProperty;
import org.example.interfaces.StyleRule;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HwsStyle extends Style {
    List<StyleRule> indentionRules = new ArrayList<>(0);
    List<StyleRule> spaceRules = new ArrayList<>(0);

    // If there's a space between the ith pair token, then increase the count of pair,
    // otherwise, decrease the count.
    private List<Integer> spaceRuleFrequencies;
    private List<Integer> indentionRuleFrequencies;


    @Override
    public void addRule(StyleContext styleContext, StyleProperty styleProperty) {
        if (styleProperty instanceof IndentionProperty indentionProperty) {
            IndentionRule rule = new IndentionRule(indentionProperty);
            addRule(rule, indentionRules, indentionRuleFrequencies);
        } else if (styleContext instanceof SpaceContext spaceContext && styleProperty instanceof SpaceProperty spaceProperty)  {
            SpaceRule rule = new SpaceRule(spaceContext, spaceProperty);
            addRule(rule, spaceRules, spaceRuleFrequencies);
        }
    }


    @Override
    public StyleProperty getProperty(StyleContext styleContext) {
        List<? extends StyleRule> properties = indentionRules;
        if (styleContext instanceof SpaceContext) {
            properties = spaceRules.stream().filter(spaceRule -> spaceRule.getStyleContext().equals(styleContext)).toList();
        }
        return properties.isEmpty() ? null : properties.get(0).getStyleProperty();
    }

    @Override
    public void fill() {
        if (indentionRuleFrequencies != null && !indentionRuleFrequencies.isEmpty()) {
           ruleFilter.filterRules2one(indentionRules, indentionRuleFrequencies);
        }
        if (spaceRuleFrequencies != null && !spaceRuleFrequencies.isEmpty()) {
            ruleFilter.filterRepeatedRules(spaceRules, spaceRuleFrequencies);
        }
    }

    private void addRule(StyleRule rule, List<StyleRule> rules, List<Integer> frequencies) {
        int index = rules.indexOf(rule);
        if (index < 0) {
            rules.add(rule);
            index = rules.size() - 1;
        }
        int frequency = index < frequencies.size() ? frequencies.get(index) + 1 : 1;
        frequencies.set(index, frequency);
    }

    @Override
    public void addElement(Element root, Parser parser) {
        Element indentionRulesEle = root.addElement("indention_rules");
        for(StyleRule indentionRule : indentionRules) {
            indentionRule.getStyleProperty().addElement(indentionRulesEle, parser);
        }
    }

    @Override
    public HwsStyle parseElement(Element root, Parser parser) {
        Element indentionRulesEle = root.element("indention_rules");
        for(Element indentionRuleEle : indentionRulesEle.elements()) {
            IndentionRule indentionRule = new IndentionRule();
            indentionRule.parseElement(indentionRuleEle, parser);
            indentionRules.add(indentionRule);
        }
        return this;
    }
}
