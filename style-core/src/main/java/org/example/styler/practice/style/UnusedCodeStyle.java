package org.example.styler.practice.style;

import org.example.style.CommonStyle;
import org.example.style.rule.StyleRule;

public class UnusedCodeStyle extends CommonStyle {
    
    public UnusedCodeStyle() {
        super();
        styleName = "unused_code";
    }

    @Override
    protected StyleRule createRule(String propertyName) {
        UnusedCodeContext context = new UnusedCodeContext();
        UnusedCodeProperty property = new UnusedCodeProperty();
        return new StyleRule(context, property);
    }
}
