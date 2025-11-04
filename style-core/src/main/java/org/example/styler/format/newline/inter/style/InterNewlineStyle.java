package org.example.styler.format.newline.inter.style;

import org.example.style.CommonStyle;
import org.example.style.Style;
import org.example.style.rule.StyleRule;
import org.example.styler.format.newline.bodylayout.style.BodyContext;
import org.example.styler.format.newline.bodylayout.style.BodyLayoutProperty;

public class InterNewlineStyle extends CommonStyle {
	public InterNewlineStyle() {
		styleName = "inter_newline";
	}

	@Override
	protected StyleRule createRule(String propertyName) {
		return new StyleRule(new InterNewlineContext(), new InterNewlineProperty());
	}
}
