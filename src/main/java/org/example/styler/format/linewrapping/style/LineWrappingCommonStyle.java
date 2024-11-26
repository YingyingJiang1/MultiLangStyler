package org.example.styler.format.linewrapping.style;

import org.example.parser.common.MyParser;
import org.example.style.CommonStyle;
import org.example.style.rule.StyleContext;
import org.example.style.rule.StyleProperty;

/*
 * @description
 * @author       Yingying Jiang
 * @create       2024/4/8 1:24
 */
public class LineWrappingCommonStyle extends CommonStyle {

    public LineWrappingCommonStyle(MyParser parser) {
        super(parser);
        styleName = "lineWrapping";
    }

    @Override
    public void addRule(StyleContext styleContext, StyleProperty styleProperty) {
        if (styleContext instanceof LineWrappingContext context) {
            if (context.attr == LineWrappingContext.Attr.CODE) {
                ruleSet.addRule(context, LineWrappingProperty.CODE_PROPERTY);
            } else if (context.attr == LineWrappingContext.Attr.COMMENT) {
                ruleSet.addRule(context, LineWrappingProperty.COMMENT_PROPERTY);
            }
        }
    }
}
