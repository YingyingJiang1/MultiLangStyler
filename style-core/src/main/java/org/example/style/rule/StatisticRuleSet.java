package org.example.style.rule;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StatisticRuleSet extends MapRuleSet{
	@Override
	public List<StyleContext> filterRules() {
		return new ArrayList<>();
	}


	public Map<StyleContext, Map<StyleProperty, Integer>> getRuleMap() {
		Map<StyleContext, Map<StyleProperty, Integer>> result = new HashMap<>();
		for (Map.Entry<StyleContext, List<StyleProperty>> entry : rules.entrySet()) {
			Map<StyleProperty, Integer> propertyMap = result.computeIfAbsent(entry.getKey(), k -> new HashMap<>());
			for (int i = 0; i < entry.getValue().size(); i++) {
				propertyMap.put(entry.getValue().get(i), frequencies.get(entry.getKey()).get(i));
			}
		}
		return result;
	}
}
