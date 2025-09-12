package org.example.styler.format.newline.intra.style;

import com.google.common.math.Quantiles;
import org.example.style.rule.StyleContext;
import org.example.style.rule.StyleProperty;
import org.example.style.rule.StyleRule;
import org.example.styler.format.newline.block.style.NewlineStyle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IntraNewlineStyle extends NewlineStyle {
	// 进行换行的行长下界
	List<Double> lineLens = new ArrayList<>();
	List<Double> lineRatios = new ArrayList<>();
	Map<String, int[]> breakCount = new HashMap<>(); // [trueCount, falseCount]
	List<String> relativeIndention = new ArrayList<>();


	public IntraNewlineStyle() {
		styleName = "intra_newline";
	}

	@Override
	public void addRule(StyleContext styleContext, StyleProperty styleProperty) {
		if (styleContext instanceof IntraNewlineContext intraContext
		&& styleProperty instanceof IntraNewlineProperty intraProperty) {
			lineLens.add(intraContext.length);

			lineRatios.add(intraProperty.lineLengthRatio);

			for (Map.Entry<String, Boolean> entry : intraProperty.breakAfter.entrySet()) {
				breakCount.computeIfAbsent(entry.getKey(), k -> new int[2]);
				if (entry.getValue()) {
					breakCount.get(entry.getKey())[0]++; // trueCount
				} else {
					breakCount.get(entry.getKey())[1]++; // falseCount
				}
			}

			if (intraProperty.relativeIndention.size() > relativeIndention.size()) {
				relativeIndention.addAll(intraProperty.relativeIndention);
			}
		}
	}

	@Override
	public StyleProperty getProperty(StyleContext targetContext) {
		if (ruleSet.getRules().isEmpty()) {
			return new IntraNewlineProperty(0);
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

		if (lineRatios.size() > 0) {
			lineRatios = lineRatios.stream().sorted().toList();
			property.lineLengthRatio = Quantiles.median().compute(lineRatios);

			property.breakAfter = new HashMap<>();
			for (Map.Entry<String, int[]> entry : breakCount.entrySet()) {
				int[] counts = entry.getValue();
				property.breakAfter.put(entry.getKey(), counts[0] >= counts[1]);
			}

			property.relativeIndention = relativeIndention;

			ruleSet.addRule(new IntraNewlineContext(Quantiles.median().compute(lineLens)), property);
		}


	}

}
