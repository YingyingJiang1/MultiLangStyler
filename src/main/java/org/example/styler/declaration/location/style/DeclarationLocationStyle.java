package org.example.styler.declaration.location.style;

import org.example.style.CommonStyle;
import org.example.style.rule.StyleRule;

public class DeclarationLocationStyle extends CommonStyle {
    
    public DeclarationLocationStyle() {
        super();
        styleName = "declaration_location";
    }

    @Override
    protected StyleRule createRule(String propertyName) {
        DeclarationLocationProperty property = new DeclarationLocationProperty();
        return new StyleRule(property);
    }
}
