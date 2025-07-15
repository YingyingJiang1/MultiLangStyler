package org.example.styler.format.newline.style;

import java.util.List;

public class BlockLevelNewlineStyle extends NewlineStyle {

	public BlockLevelNewlineStyle(NewlineStyle style) {
		ruleSet = style.getRuleSet();
	}

	protected List<Double> getWeights() {
		return List.of(0.0, 0.5, 0.0, 0.5);
	}



}
