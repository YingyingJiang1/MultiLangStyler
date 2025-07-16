package org.example.styler.exp.complexity.style;

import org.example.style.CommonStyle;
import org.example.style.rule.StyleRule;

public class ExpressionStyle extends CommonStyle {
    public ExpressionStyle() {
        super();
        styleName = "expression_complexity";
    }

    @Override
    protected StyleRule createRule(String propertyName) {
        ExpressionContext context = new ExpressionContext();
        ExpressionProperty property = new ExpressionProperty();
        return new StyleRule(context, property);
    }
}
