package org.example.styler.comment.syntax.style;

import org.dom4j.Element;
import org.example.parser.common.MyParser;
import org.example.style.rule.StyleContext;
import org.example.styler.comment.CommentType;

import java.util.Objects;

public class CommentSyntaxContext extends StyleContext {
    public CommentType commentType;

    public CommentSyntaxContext() {
    }

    public CommentSyntaxContext(CommentType commentType) {
        this.commentType = commentType;
    }

    @Override
    public void addElement(Element parent, MyParser parser) {
        parent.addAttribute("comment_type", commentType.name());
    }

    @Override
    public void parseElement(Element parent, MyParser parser) {
        commentType = CommentType.valueOf(parent.attributeValue("comment_type"));
    }

    @Override
    public int hashCode() {
        return Objects.hash(commentType);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof CommentSyntaxContext context) {
            return Objects.equals(commentType, context.commentType);
        }
        return false;
    }
}
