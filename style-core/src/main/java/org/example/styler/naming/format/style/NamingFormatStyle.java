package org.example.styler.naming.format.style;

import org.example.style.CommonStyle;
import org.example.style.rule.StyleRule;

public class NamingFormatStyle extends CommonStyle {
    
    public NamingFormatStyle() {
        super();
        styleName = "naming_format";
    }

    @Override
    protected StyleRule createRule(String propertyName) {
        NamingFormatContext context = new NamingFormatContext();
        NamingFormatProperty property = new NamingFormatProperty();
        return new StyleRule(context, property);
    }


}
