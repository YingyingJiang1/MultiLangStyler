package org.example.styler.comment.syntax.style;

import org.dom4j.Element;
import org.example.parser.common.MyParser;
import org.example.style.rule.StyleContext;
import org.example.styler.comment.CommentType;

public class CommentSyntaxContext extends StyleContext {
    CommentType commentType;

    public CommentSyntaxContext(CommentType commentType) {
        this.commentType = commentType;
    }

    @Override
    public void addElement(Element parent, MyParser parser) {

    }

    @Override
    public Object parseElement(Element parent, MyParser parser) {
        return null;
    }
}
