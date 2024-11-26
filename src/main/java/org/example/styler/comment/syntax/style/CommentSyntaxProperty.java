package org.example.styler.comment.syntax.style;

import org.dom4j.Element;
import org.example.parser.common.MyParser;
import org.example.style.rule.StyleProperty;

public class CommentSyntaxProperty extends StyleProperty {
    String syntax;

    public CommentSyntaxProperty(String syntax) {
        this.syntax = syntax;
    }

    @Override
    public void addElement(Element parent, MyParser parser) {

    }

    @Override
    public Object parseElement(Element parent, MyParser parser) {
        return null;
    }
}
