package org.example.styler.body.optionalbrace.style;

import org.example.style.CommonStyle;
import org.example.style.rule.StyleRule;
import org.example.styler.body.BodyContext;

public class OptionalBraceStyle extends CommonStyle {
	public OptionalBraceStyle() {
		styleName = "optional_brace";
	}



	@Override
	protected StyleRule createRule(String propertyName) {
		return new StyleRule(new BodyContext(), new OptionalBraceProperty());
	}
}
