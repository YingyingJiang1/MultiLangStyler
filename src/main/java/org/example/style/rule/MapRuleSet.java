package org.example.style.rule;

import java.util.*;

public class MapRuleSet implements RuleSet{
    protected Map<StyleContext, List<StyleProperty>> rules = new HashMap<>();
    protected Map<StyleContext, List<Integer>> frequencies = new HashMap<>();

    @Override
    public void addRule(StyleContext context, StyleProperty property) {
        List<StyleProperty> properties = rules.computeIfAbsent(context, k -> new ArrayList<>());
        properties.add(property);

        List<Integer> ruleFrequencies = frequencies.computeIfAbsent(context, k -> new ArrayList<>());
        int index = properties.size() - 1;
        if (index >= ruleFrequencies.size()) {
            ruleFrequencies.add(1);
        } else {
            ruleFrequencies.set(index, ruleFrequencies.get(index) + 1);
        }
    }


    @Override
    public boolean contains(StyleContext targetContext) {
        return rules.get(targetContext) != null;
    }

    @Override
    public StyleProperty getProperty(StyleContext targetContext) {
        List<? extends StyleProperty> properties = rules.get(targetContext);
        if (!properties.isEmpty()) {
            return properties.get(0);
        }
        return null;
    }

    @Override
    public StyleProperty getSimilarProperty(StyleContext targetContext) {
        StyleProperty res = null;
        double minDis = Double.MAX_VALUE;
        for (Map.Entry<StyleContext, List<StyleProperty>> entry : rules.entrySet()) {
            double distance = entry.getKey().calculateDistance(targetContext);
            // Must be less than, because `Double.MAX_VALUE` is a special value which represents
            // that a context similar to `targetContext` cannot be found
            if(distance < minDis) {
                minDis = distance;
                if (!entry.getValue().isEmpty()) {
                    res = entry.getValue().get(0);
                }
            }
        }
        return res;
    }

    @Override
    public List<StyleRule> getRules() {
        List<StyleRule> ruleList = new ArrayList<>();
        for(Map.Entry<StyleContext, List<StyleProperty>> entry : rules.entrySet()) {
            for (StyleProperty property : entry.getValue()) {
                StyleRule rule = new StyleRule(entry.getKey(), property);
                ruleList.add(rule);
            }
        }
        return ruleList;
    }

    @Override
    public void filterRules() {
        for (Map.Entry<StyleContext, List<StyleProperty>> entry : rules.entrySet()) {
            int maxFrequency = frequencies.get(entry.getKey()).stream().max(Comparator.comparingInt(i -> i)).get();
            StyleProperty property = entry.getValue().get(frequencies.get(entry.getKey()).indexOf(maxFrequency));
            entry.getValue().clear();
            entry.getValue().add(property);
        }
    }

}
