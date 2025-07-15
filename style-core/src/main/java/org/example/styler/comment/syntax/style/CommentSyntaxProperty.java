package org.example.styler.comment.syntax.style;

import org.dom4j.Element;
import org.example.parser.common.MyParser;
import org.example.style.rule.StyleProperty;

public class CommentSyntaxProperty extends StyleProperty {
    public String syntax;

    public CommentSyntaxProperty() {
    }

    public CommentSyntaxProperty(String syntax) {
        this.syntax = syntax;
    }

    @Override
    public void addElement(Element parent, MyParser parser) {
        parent.addAttribute("syntax", syntax);
    }

    @Override
    public void parseElement(Element parent, MyParser parser) {
        syntax = parent.attributeValue("syntax");
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof CommentSyntaxProperty property) {
            return syntax.equals(property.syntax);
        }
        return false;
    }
}
