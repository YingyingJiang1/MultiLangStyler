package org.example.styler.brace.style;

import org.antlr.v4.runtime.Parser;
import org.dom4j.Element;
import org.example.interfaces.Style;
import org.example.interfaces.StyleContext;
import org.example.interfaces.StyleProperty;
import org.example.interfaces.StyleRule;

import java.util.*;

public class BraceStyle extends Style {
    // key: index of rule.
    // value: frequency.
    private List<Integer> frequencies = new ArrayList<>();

    @Override
    public void addRule(StyleContext styleContext, StyleProperty styleProperty) {
        BraceFormatRule targetRule = new BraceFormatRule((BraceFormatContext) styleContext, (BraceFormatProperty) styleProperty);
        int index = rules.indexOf(targetRule);
        if(index < 0) {
            rules.add(targetRule);
            index = rules.size() - 1;
        }
        int frequency = frequencies.size() > index ? frequencies.get(index) + 1 : 1;
        frequencies.set(index, frequency);
    }

    @Override
    public BraceFormatProperty getProperty(StyleContext styleContext) {
        BraceFormatProperty res = null;
        int minDis = Integer.MAX_VALUE;
        BraceFormatProperty lineBreakInfo = null;
        for(StyleRule styleRule : rules) {
            BraceFormatRule rule = (BraceFormatRule) styleRule;
            int distance = rule.getStyleContext().calculateDis(styleContext);
            if(distance < minDis) {
                minDis = distance;
                res = rule.getStyleProperty();
            }
        }
        return res;
    }

    @Override
    public void fill() {
        if(frequencies == null) {
            return;
        }
        ruleFilter.filterRepeatedRules(rules, frequencies);
        frequencies = null;
    }


    @Override
    public void addElement(Element parent, Parser parser) {
        Element braceInfosEle = parent.addElement("brace_infos");
        braceInfosEle.addComment("In @brace_info.@line_break_info: (beforeLB, afterLB, beforeRB, afterRB)");
        for(StyleRule styleRule : rules) {
            BraceFormatRule rule = (BraceFormatRule) styleRule;
            rule.getStyleContext().addElement(braceInfosEle, parser);
            rule.getStyleProperty().addElement(braceInfosEle, parser);
        }
    }

    @Override
    public BraceStyle parseElement(Element parent, Parser parser) {
        Element braceInfosEle = parent.element("brace_infos");
        List<Element> braceInfoEleList = braceInfosEle.elements();
        for(Element braceInfoEle : braceInfoEleList) {
            BraceFormatRule rule = new BraceFormatRule(new BraceFormatContext().parseElement(braceInfoEle, parser),
                    new BraceFormatProperty().parseElement(braceInfoEle, parser)
            );
            rules.add(rule);
        }
        return this;
    }
}
