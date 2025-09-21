package org.example.styler.format.newline.intra.style;

import org.example.style.CommonStyle;
import org.example.style.rule.StyleContext;
import org.example.style.rule.StyleProperty;
import org.example.style.rule.StyleRule;
import org.example.utils.MathUtil;

import java.util.*;

public class IntraNewlineStyle extends CommonStyle {
	// 进行换行的行长下界
	List<Double> lineLens = new ArrayList<>();
	List<Double> minLens = new ArrayList<>();
	List<Double> lineRatios = new ArrayList<>();
//	Map<String, int[]> breakCount = new HashMap<>(); // [trueCount, falseCount]
	Map<Integer, List<String>> relativeIndentionMap = new HashMap<>();


	public IntraNewlineStyle() {
		styleName = "intra_newline";
	}

	@Override
	public void addRule(StyleContext styleContext, StyleProperty styleProperty) {
		if (styleContext instanceof IntraNewlineContext intraContext) {
			lineLens.add(intraContext.length);
		}
		if ( styleProperty instanceof IntraNewlineProperty intraProperty) {

			lineRatios.add(intraProperty.length);
			minLens.add(intraProperty.minLen);

//			for (Map.Entry<String, Boolean> entry : intraProperty.breakAfter.entrySet()) {
//				breakCount.computeIfAbsent(entry.getKey(), k -> new int[2]);
//				if (entry.getValue()) {
//					breakCount.get(entry.getKey())[0]++; // trueCount
//				} else {
//					breakCount.get(entry.getKey())[1]++; // falseCount
//				}
//			}

			for (int i = 0; i < intraProperty.relativeIndention.size(); i++) {
				int line = 0; // 只区分起始行和第一行后继行，后继行之间这两种情况
				relativeIndentionMap.computeIfAbsent(line, k -> new ArrayList<>()).add(intraProperty.relativeIndention.get(i));
			}
		}
	}

	@Override
	public StyleProperty getProperty(StyleContext targetContext) {
		if (ruleSet.getRules().isEmpty()) {
			return null;
		}

		StyleRule rule = ruleSet.getRules().get(0);
		if (rule.getStyleContext() instanceof IntraNewlineContext intraContext
		&& targetContext instanceof IntraNewlineContext targetIntraContext
		&& targetIntraContext.length >= intraContext.length) {
			return rule.getStyleProperty();
		}

		return new IntraNewlineProperty(0); // No newline
	}

	@Override
	public void fillStyle() {
		IntraNewlineProperty property = new IntraNewlineProperty(1);
		property.relativeIndention = null;

		if (lineLens.size() > 0 && lineRatios.size() > 0) {
			lineRatios = lineRatios.stream().sorted().toList();
			property.length = MathUtil.median(lineRatios);
			property.minLen = Double.max(MathUtil.median(minLens), 20); // 防止异常情况

//			property.breakAfter = new HashMap<>();
//			for (Map.Entry<String, int[]> entry : breakCount.entrySet()) {
//				int[] counts = entry.getValue();
//				property.breakAfter.put(entry.getKey(), counts[0] >= counts[1]);
//			}

			property.relativeIndention = new ArrayList<>();
			for (int i = 0; i < relativeIndentionMap.size(); i++) {
				List<String> indentions = relativeIndentionMap.get(i);
				String maxFreqStr = indentions.stream()
						.max(Comparator.comparingInt(s -> Collections.frequency(indentions, s)))
						.orElse(null);
				property.relativeIndention.add(maxFreqStr);
			}

			double lineLen = lineLens.stream().max(Comparator.comparingDouble(Double::doubleValue)).get();
			ruleSet.addRule(new IntraNewlineContext(lineLen), property);
		}


	}

}
