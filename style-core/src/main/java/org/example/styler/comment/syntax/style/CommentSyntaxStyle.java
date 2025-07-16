package org.example.styler.comment.syntax.style;

import org.example.style.CommonStyle;
import org.example.style.rule.StyleRule;

public class CommentSyntaxStyle extends CommonStyle {
    public CommentSyntaxStyle() {
        super();
        styleName = "comment_syntax";
    }

    @Override
    protected StyleRule createRule(String propertyName) {
        CommentSyntaxContext context = new CommentSyntaxContext();
        CommentSyntaxProperty property = new CommentSyntaxProperty();
        return new StyleRule(context, property);
    }
}
