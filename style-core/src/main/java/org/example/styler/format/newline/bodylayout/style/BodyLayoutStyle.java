package org.example.styler.format.newline.bodylayout.style;

import org.example.style.CommonStyle;
import org.example.style.rule.StyleRule;

public class BodyLayoutStyle extends CommonStyle {
	public BodyLayoutStyle() {
		styleName = "body_layout";
	}

	@Override
	protected StyleRule createRule(String propertyName) {
		return new StyleRule(new BodyContext(), new BodyLayoutProperty());
	}
}
