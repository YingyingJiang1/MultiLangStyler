package org.example.styler.ifelse.multibranch.style;

import org.example.style.CommonStyle;
import org.example.style.rule.StyleRule;

public class MultiBranchStyle extends CommonStyle {
    public MultiBranchStyle() {
        super();
        styleName = "multi_branch";
    }

    @Override
    protected StyleRule createRule(String propertyName) {
        MultiBranchContext context = new MultiBranchContext();
        MultiBranchProperty property = new MultiBranchProperty();
        return new StyleRule(context, property);
    }
}
