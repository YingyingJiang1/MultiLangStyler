package org.example.styler.ifelse.bodyorder.style;

import org.example.style.CommonStyle;
import org.example.style.rule.StyleRule;

public class IfElseBodyOrderStyle extends CommonStyle {

    public IfElseBodyOrderStyle() {
        super();
        styleName = "if_else_body_order";
    }

    @Override
    protected StyleRule createRule(String propertyName) {
        IfElseBodyOrderProperty property = new IfElseBodyOrderProperty();
        return new StyleRule(property);
    }
    
}
