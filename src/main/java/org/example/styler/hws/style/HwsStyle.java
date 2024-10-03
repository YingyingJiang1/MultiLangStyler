package org.example.styler.hws.style;

import org.antlr.v4.runtime.Parser;
import org.dom4j.Element;
import org.example.interfaces.Style;
import org.example.interfaces.StyleContext;
import org.example.interfaces.StyleProperty;
import org.example.interfaces.StyleRule;

import java.util.ArrayList;
import java.util.List;

public class HwsStyle extends Style {
    List<StyleRule> indentionRules = new ArrayList<>(0);
    List<StyleRule> spaceRules = new ArrayList<>(0);

    private List<Integer> spaceRuleFrequencies;
    private List<Integer> indentionRuleFrequencies;

    public HwsStyle() {
        styleName = "hws_style";
    }

    @Override
    public void addRule(StyleContext styleContext, StyleProperty styleProperty) {
        if (styleProperty instanceof IndentionProperty indentionProperty) {
            StyleRule rule = new StyleRule(indentionProperty);
            addRule(rule, indentionRules, indentionRuleFrequencies);
        } else if (styleContext instanceof SpaceContext spaceContext && styleProperty instanceof SpaceProperty spaceProperty)  {
            StyleRule rule = new StyleRule(spaceContext, spaceProperty);
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


    @Override
    public void addElement(Element parent, Parser parser) {
        addListElement(parent, parser, indentionRules, "indentation_rules", null);
        addListElement(parent, parser, spaceRules, "space_rules", "space_rule: (left token group type, right token group type)");
    }

    @Override
    public HwsStyle parseElement(Element parent, Parser parser) {
        parseListElement(parent, parser, spaceRules, "space_rules");
        parseListElement(parent, parser, indentionRules, "indentation_rules");
        return this;
    }
}
