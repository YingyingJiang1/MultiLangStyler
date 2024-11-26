package org.example.styler.comment.syntax.style;

import org.example.parser.common.MyParser;
import org.example.style.CommonStyle;

public class CommentSyntaxCommonStyle extends CommonStyle {
    public CommentSyntaxCommonStyle(MyParser parser) {
        super(parser);
        styleName = "comment_syntax";
    }
}
