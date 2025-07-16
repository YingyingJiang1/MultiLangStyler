package org.example.styler.format.style;

import org.example.style.CommonStyle;
import org.example.style.rule.StyleRule;

public class LineStmtStyle extends CommonStyle {

    public LineStmtStyle() {
        super();
        styleName = "line_statement";
    }

    @Override
    protected StyleRule createRule(String propertyName) {
        LineStmtContext context = new LineStmtContext();
        NewlineProperty property = new NewlineProperty(); // may be modified if another property is added
        return new StyleRule(context, property);
    }
}
