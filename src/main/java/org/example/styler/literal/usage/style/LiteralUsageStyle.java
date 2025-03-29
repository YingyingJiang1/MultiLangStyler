package org.example.styler.literal.usage.style;

import org.example.style.CommonStyle;
import org.example.style.rule.StyleRule;

public class LiteralUsageStyle extends CommonStyle {
    public LiteralUsageStyle() {
        super();
        styleName = "literal_usage";
    }

    @Override
    protected StyleRule createRule(String propertyName) {
        LiteralUsageContext context = new LiteralUsageContext();
        LiteralUsageProperty property = new LiteralUsageProperty();
        return new StyleRule(context, property);
    }
}
