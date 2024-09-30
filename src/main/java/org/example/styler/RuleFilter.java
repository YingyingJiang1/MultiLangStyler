package org.example.styler;

import org.example.interfaces.StyleContext;
import org.example.interfaces.StyleRule;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description: When more than one rule with the same style context appears, the rule with the largest frequency is retained.
 */
public class RuleFilter {
    public void filterRepeatedRules(List<StyleRule> rules, List<Integer> frequencies) {
        Map<StyleContext, Integer> map = new HashMap<>(); // key: context, value: index of current max frequency.
        for (int i = 0; i < rules.size() - 1; i++) {
            StyleContext context = rules.get(i).getStyleContext();
            if (map.get(context) == null) {
                map.put(context, i);
            } else {
                int index = map.get(context);
                if (frequencies.get(i) > frequencies.get(index)) {
                    map.put(context, i);
                }
            }
        }

        List<StyleRule> newRules = map.values().stream()
                .map(index -> rules.get(index))
                .toList();
        rules.clear();
        rules.addAll(newRules);
    }

    public void filterRules2one(List<StyleRule> rules, List<Integer> frequencies) {
        int maxFrequency = Collections.max(frequencies);
        StyleRule rule = rules.get(frequencies.indexOf(maxFrequency));
        rules.clear();
        rules.add(rule);
    }

}
