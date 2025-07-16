package org.example.styler.arrangement.param.style;

import org.example.style.CommonStyle;
import org.example.style.rule.StyleRule;

public class ParameterOrderStyle extends CommonStyle {
    
    public ParameterOrderStyle() {
        super();
        styleName = "parameter_order";
    }
    
    @Override
    protected StyleRule createRule(String propertyName) {
        ParameterOrderProperty property = new ParameterOrderProperty();
        return new StyleRule(property);
    }
}
