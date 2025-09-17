package org.example.styler.format.newline.style;

import com.google.common.math.Quantiles;
import org.apache.commons.lang3.tuple.MutablePair;
import org.example.style.CommonStyle;
import org.example.style.rule.StyleContext;
import org.example.style.rule.StyleProperty;
import org.example.style.rule.StyleRule;


import java.util.*;

public class NewlineStyle extends CommonStyle {
	Map<List<String>, Map<NewlineProperty, List<Double>>> nodeTypeMap;
	Map<List<String>, Set<NewlineContext>> lookupIndex = new HashMap<>();


	public NewlineStyle() {
		styleName = "newline";
	}

	@Override
	public void addRule(StyleContext styleContext, StyleProperty styleProperty) {
		if (nodeTypeMap == null) {
			nodeTypeMap = new HashMap<>();
		}
		if (styleContext instanceof NewlineContext context
				&& styleProperty instanceof NewlineProperty property) {
			MutablePair<List<String>, NewlineProperty> key = new MutablePair<>(context.getNodeTypes(), property);
			Map<NewlineProperty, List<Double>> propertyMap = nodeTypeMap.computeIfAbsent(context.getNodeTypes(), k -> new HashMap<>());
			propertyMap.computeIfAbsent(property, k -> new ArrayList<>()).addAll(context.getLengths());
		}
	}

	@Override
	public StyleProperty getProperty(StyleContext styleContext) {
		if (styleContext instanceof NewlineContext context) {
			Set<NewlineContext> keyContexts = lookupIndex.get(context.getNodeTypes());
			if (keyContexts != null) {
				double minDistance = Double.MAX_VALUE;
				NewlineContext targetContext = null;
				for (NewlineContext keyContext : keyContexts) {
					double distance = context.calLengthDistance(keyContext);
					if (distance < minDistance) {
						minDistance = distance;
						targetContext = keyContext;
					}
				}

				return ruleSet.getProperty(targetContext);
			}
		}

		return null;
	}

	@Override
	public void fillStyle() {
		if (nodeTypeMap != null) {
			ruleSet.clear();
			for (List<String> nodeTypes : nodeTypeMap.keySet()) {
				Map<NewlineProperty, List<Double>> propertyMap = nodeTypeMap.get(nodeTypes);
				propertyMap = removeConflictProperties(propertyMap);
				for (NewlineProperty property : propertyMap.keySet()) {
					List<Double> lengths = List.of(Quantiles.median().compute(propertyMap.get(property)));
//					List<Double> lengths = null; // 不考虑长度
					NewlineContext context = new NewlineContext(nodeTypes, lengths);

//					for (int i = 0; i < propertyMap.size(); i++) {
//						ruleSet.addRule(context, property);
//					}

					ruleSet.addRule(context, property);
				}
			}

			nodeTypeMap = null;
		}

		for (StyleRule rule : ruleSet.getRules()) {
			if (rule.getStyleContext() instanceof NewlineContext context) {
				lookupIndex.computeIfAbsent(context.getNodeTypes(), k -> new HashSet<>()).add(context);
			}
		}
	}

	// 当某个property的区间被包含时，删除该property（因为从统计上来讲大概率是非dominant的）
	private Map<NewlineProperty, List<Double>> removeConflictProperties(
			Map<NewlineProperty, List<Double>> propertyMap) {

		// 先计算每个 property 的区间 [min, max]
		Map<NewlineProperty, double[]> intervals = new HashMap<>();
		for (NewlineProperty property : propertyMap.keySet()) {
			List<Double> lengths = propertyMap.get(property);
			double min = lengths.stream().min(Double::compareTo).get();
			double max = lengths.stream().max(Double::compareTo).get();
			intervals.put(property, new double[]{min, max});
		}

		// 找出被包含的 property
		Set<NewlineProperty> toRemove = new HashSet<>();
		for (Map.Entry<NewlineProperty, double[]> e1 : intervals.entrySet()) {
			for (Map.Entry<NewlineProperty, double[]> e2 : intervals.entrySet()) {
				if (e1.getKey() == e2.getKey()) continue;

				double[] i1 = e1.getValue();
				double[] i2 = e2.getValue();

				// 判断 i1 是否被 i2 包含
				if (i1[0] >= i2[0] && i1[1] <= i2[1]) {
					toRemove.add(e1.getKey());
				}
			}
		}

		// 删除被包含的 property
		Map<NewlineProperty, List<Double>> filtered = new HashMap<>(propertyMap);
		for (NewlineProperty p : toRemove) {
			filtered.remove(p);
		}

		return filtered;
	}


	/**
     *
     * @return vertical weight, horizontal weight
     */
    protected List<Double> getWeights(NewlineContext context) {
        return List.of(0.0, 1.0);
    }

    @Override
    protected StyleRule createRule(String propertyName) {
        return new StyleRule(new NewlineContext(), new NewlineProperty());
    }
}
