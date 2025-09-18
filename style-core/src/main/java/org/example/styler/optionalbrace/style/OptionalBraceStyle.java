package org.example.styler.optionalbrace.style;

import org.example.style.CommonStyle;
import org.example.style.rule.StyleRule;

public class OptionalBraceStyle extends CommonStyle {
	public OptionalBraceStyle() {
		styleName = "optional_brace";
	}


	@Override
	protected StyleRule createRule(String propertyName) {
		return new StyleRule(new OptionalBraceContext(), new OptionalBraceProperty());
	}
}
