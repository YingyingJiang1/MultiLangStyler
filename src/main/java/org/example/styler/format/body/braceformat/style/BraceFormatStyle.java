package org.example.styler.format.body.braceformat.style;

import org.example.style.CommonStyle;
import org.example.style.rule.StyleContext;
import org.example.style.rule.StyleRule;
import org.example.styler.format.body.BodyContext;

import java.util.List;

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

    @Override
    public List<StyleContext> filterRules() {
        return super.filterRules();
    }
}
