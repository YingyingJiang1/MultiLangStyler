package org.example.styler.brace.style;

import org.antlr.v4.runtime.Parser;
import org.dom4j.Element;
import org.example.style.Style;
import org.example.style.StyleContext;
import org.example.style.StyleProperty;
import org.example.style.StyleRule;
import org.example.style.format.BraceInfo;

import java.util.*;
import java.util.stream.Collectors;

public class BraceStyle extends Style {
    // key: index of rule.
    // value: frequency.
    private Map<Integer, Integer> frequency = new HashMap<>();

    @Override
    public void addRule(StyleContext styleContext, StyleProperty styleProperty) {
        BraceFormatContext targetContext = (BraceFormatContext) styleContext;
        BraceFormatRule targetRule = new BraceFormatRule((BraceFormatContext) styleContext, (BraceFormatProperty) styleProperty);
        int index = rules.indexOf(targetRule);
        if(index < 0) {
            rules.add(targetRule);
            index = rules.size() - 1;
        }
        frequency.put(index, frequency.getOrDefault(index, 0) + 1);
    }

    @Override
    public BraceFormatProperty getProperty(StyleContext styleContext) {
        BraceFormatProperty res = null;
        BraceFormatContext targetContext = (BraceFormatContext) styleContext;
        int minDis = Integer.MAX_VALUE;
        BraceFormatProperty lineBreakInfo = null;
        for(StyleRule styleRule : rules) {
            BraceFormatRule rule = (BraceFormatRule) styleRule;
            int distance = rule.getStyleContext().calculateDis(targetContext);
            if(distance < minDis) {
                minDis = distance;
                res = rule.getStyleProperty();
            }
        }
        return res;
    }

    @Override
    public void fill() {
        if(frequency == null) {
            return;
        }

        // Reserve the style property with the highest frequency for the rules having the same style context.
        Map<StyleContext, Integer> map = new HashMap<>(); // key: context, value: index of current max frequency.
        for (int i = 0; i < rules.size() - 1; i++) {
            StyleContext context = rules.get(i).getStyleContext();
            if (map.get(context) == null) {
                map.put(context, i);
            } else {
                int index = map.get(context);
                if (frequency.get(i) > frequency.get(index)) {
                    map.put(context, i);
                }
            }
        }

        List<StyleRule> newRules = map.values().stream()
                .map(index -> rules.get(index))
                .toList();
        rules.clear();
        rules.addAll(newRules);
        frequency = null;
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
