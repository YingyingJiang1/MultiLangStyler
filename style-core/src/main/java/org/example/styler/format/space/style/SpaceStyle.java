package org.example.styler.format.space.style;

import org.example.style.CommonStyle;
import org.example.style.rule.StyleRule;

public class SpaceStyle extends CommonStyle {

    public SpaceStyle() {
        super();
        styleName = "space";
    }

    @Override
    protected StyleRule createRule(String propertyName) {
        SpaceContext context = new SpaceContext();
        SpaceProperty property = new SpaceProperty();
        return new StyleRule(context, property);
    }
}
