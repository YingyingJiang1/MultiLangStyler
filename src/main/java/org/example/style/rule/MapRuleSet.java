package org.example.style.rule;

import org.example.styler.body.BodyContext;

import java.util.*;

public class MapRuleSet implements RuleSet{
    protected Map<StyleContext, List<StyleProperty>> rules = new HashMap<>();
    protected Map<StyleContext, List<Integer>> frequencies = new HashMap<>();

    @Override
    public void addRule(StyleContext context, StyleProperty property) {
        List<StyleProperty> properties = rules.computeIfAbsent(context, k -> new ArrayList<>());
        List<Integer> ruleFrequencies = frequencies.computeIfAbsent(context, k -> new ArrayList<>());
        if (!properties.contains(property)) {
            properties.add(property);
            ruleFrequencies.add(1);
        } else {
            int index = properties.indexOf(property);
            ruleFrequencies.set(index, ruleFrequencies.get(index) + 1);
        }
    }


    @Override
    public boolean contains(StyleContext targetContext) {
        return rules.get(targetContext) != null;
    }

    @Override
    public StyleProperty getProperty(StyleContext targetContext) {
        List<StyleProperty> properties = rules.get(targetContext);
        if (properties != null && !properties.isEmpty()) {
            return selectProperty(properties);
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
            if(distance >= 0 && distance < minDis) {
                minDis = distance;
                if (!entry.getValue().isEmpty()) {
                    res = selectProperty(entry.getValue());
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

    @Override
    public boolean updateKey(StyleContext oldContext, StyleContext newContext) {
        List<StyleProperty> properties = rules.remove(oldContext);
        if (properties == null) {
            return false;
        }
        rules.put(newContext, properties);
        frequencies.put(newContext, frequencies.remove(oldContext));
        return true;
    }

    @Override
    public StyleProperty remove(StyleContext styleContext) {
        if (rules.containsKey(styleContext)) {
            List<StyleProperty> properties = rules.remove(styleContext);
            frequencies.remove(styleContext);
            if (properties != null && !properties.isEmpty()) {
                return selectProperty(properties);
            }
        }
        return null;
    }

    @Override
    public void clear() {
        rules.clear();
        frequencies.clear();
    }

    @Override
    public Map<StyleContext, List<StyleProperty>> getRuleMap() {
        return rules;
    }

    /**
     * Select strategy: randomly select
     */
    private StyleProperty selectProperty(List<StyleProperty> properties) {
        int index = new Random().nextInt(0, properties.size());
        return properties.get(index);
    }

}
