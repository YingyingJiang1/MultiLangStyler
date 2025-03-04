package org.example.styler.body.braceformat.style;

import org.example.style.CommonStyle;
import org.example.style.rule.StyleRule;
import org.example.styler.body.BodyContext;

public class BraceFormatStyle extends CommonStyle {
    
    public BraceFormatStyle() {
        super();
        styleName = "brace_format";
    }
    
    @Override
    protected StyleRule createRule(String propertyName) {
        BodyContext bodyContext = new BodyContext();
        BraceFormatProperty property = new BraceFormatProperty();
        return new StyleRule(bodyContext, property);
    }
    
}
