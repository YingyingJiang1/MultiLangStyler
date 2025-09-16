package org.example.style.rule;

import org.example.global.GlobalInfo;

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
        if (properties != null) {
            return properties.get(0);
        }
        return null;
    }

    @Override
    public List<StyleProperty> getProperties(StyleContext targetContext) {
        return rules.get(targetContext);
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
    public List<StyleContext> filterRules() {
        List<StyleContext> toBeRemoved = new ArrayList<>();
        for (Map.Entry<StyleContext, List<StyleProperty>> entry : rules.entrySet()) {
            List<Integer> curFreList = frequencies.get(entry.getKey());
            int index = getMaxFreqIndex(curFreList);
            int totalFreq = curFreList.stream().reduce(Integer::sum).orElse(0);
            double dominantRatio = totalFreq == 0 ? 0 : (double) curFreList.get(index) / (double) totalFreq;
            double threshold = GlobalInfo.getConf().getStyleConfig().getMinDominantRatio();
            if (dominantRatio >= threshold) {
                entry.setValue(List.of(entry.getValue().get(index)));
            } else {
                toBeRemoved.add(entry.getKey());
            }
        }

        for (StyleContext context : toBeRemoved) {
            rules.remove(context);
        }
        return toBeRemoved;
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
            if (properties != null) {
                return properties.get(0);
            }
        }
        return null;
    }

    @Override
    public void clear() {
        rules.clear();
        frequencies.clear();
    }

    private int getMaxFreqIndex(List<Integer> frequencies) {
        List<StyleProperty> ret = new ArrayList<>();
        Optional<Integer> maxFrequency = frequencies.stream().max(Comparator.comparingInt(i -> i));
        if (maxFrequency.isPresent()) {
            int max = maxFrequency.get();
            for (int i = 0; i < frequencies.size(); i++) {
                if (frequencies.get(i) == max) {
                   return i;
                }
            }
        }
        return -1;
    }

}
