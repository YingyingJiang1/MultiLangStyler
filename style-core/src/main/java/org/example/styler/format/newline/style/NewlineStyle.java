package org.example.styler.format.newline.style;

import com.google.common.math.Quantiles;
import org.apache.commons.lang3.tuple.MutablePair;
import org.example.style.CommonStyle;
import org.example.style.rule.StyleContext;
import org.example.style.rule.StyleProperty;


import java.util.*;

public class NewlineStyle extends CommonStyle {
	Map<MutablePair<List<String>, NewlineProperty>, List<Double>> nodeType2LengthMap;
	Map<List<String>, Set<NewlineContext>> lookupIndex = new HashMap<>();


	public NewlineStyle() {
		styleName = "newline";
	}

	@Override
	public void addRule(StyleContext styleContext, StyleProperty styleProperty) {
		if (nodeType2LengthMap == null) {
			nodeType2LengthMap = new HashMap<>();
		}
		if (styleContext instanceof NewlineContext context
				&& styleProperty instanceof NewlineProperty property) {
			MutablePair<List<String>, NewlineProperty> key = new MutablePair<>(context.getNodeTypes(), property);
			List<Double> lengths = nodeType2LengthMap.computeIfAbsent(key, k -> new ArrayList<>());
			lengths.addAll(context.getLengths());
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
		if (nodeType2LengthMap != null) {
			ruleSet.clear();
			for (Map.Entry<MutablePair<List<String>, NewlineProperty>, List<Double>> entry : nodeType2LengthMap.entrySet()) {
				List<String> nodeTypes = entry.getKey().getLeft();
				NewlineProperty property = entry.getKey().getRight();
//				List<Double> lengths = List.of(Quantiles.median().compute(entry.getValue()));
				List<Double> lengths = null; // 不考虑长度

				NewlineContext context = new NewlineContext(nodeTypes, lengths);
				// 一共有entry.getValue().size个property，不是一个
				for (int i = 0; i < entry.getValue().size(); i++) {
					ruleSet.addRule(context, property);
				}

				lookupIndex.computeIfAbsent(nodeTypes, k -> new HashSet<>()).add(context);
			}

			nodeType2LengthMap = null;
		}

	}


	/**
     *
     * @return vertical weight, horizontal weight
     */
    protected List<Double> getWeights(NewlineContext context) {
        return List.of(0.0, 1.0);
    }
}
