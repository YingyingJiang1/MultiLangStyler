package org.example.styler.hws.style;

import org.antlr.v4.runtime.Parser;
import org.dom4j.Element;
import org.example.style.Style;
import org.example.style.rule.*;

public class HwsStyle extends Style {
    RuleSet indentionRuleSet = new MapRuleSet();
    RuleSet spaceRuleSet = new MapRuleSet();

    public HwsStyle() {
        styleName = "hws_style";
    }

    @Override
    public void addRule(StyleContext styleContext, StyleProperty styleProperty) {
        if (styleProperty instanceof IndentionProperty indentionProperty) {
            indentionRuleSet.addRule(styleContext, indentionProperty);
        } else if (styleContext instanceof SpaceContext spaceContext && styleProperty instanceof SpaceProperty spaceProperty)  {
            spaceRuleSet.addRule(styleContext, spaceProperty);
        }
    }


    @Override
    public StyleProperty getProperty(StyleContext styleContext) {
        if (styleContext instanceof SpaceContext) {
            return spaceRuleSet.getProperty(styleContext);
        }
        return indentionRuleSet.getProperty(styleContext);
    }

    @Override
    public void fill() {
        spaceRuleSet.filterRules();
        indentionRuleSet.filterRules();
    }


    @Override
    public void addElement(Element parent, Parser parser) {
        addListElement(parent, parser, indentionRuleSet, "indentation_rules", null);
        addListElement(parent, parser, spaceRuleSet, "space_rules", "space_rule: (left token group type, right token group type)");
    }

    @Override
    public HwsStyle parseElement(Element parent, Parser parser) {
        parseListElement(parent, parser, spaceRuleSet, "space_rules");
        parseListElement(parent, parser, indentionRuleSet, "indentation_rules");
        return this;
    }
}
