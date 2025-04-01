package org.example.styler.declaration.number.style;

import org.dom4j.Element;
import org.example.parser.common.MyParser;
import org.example.style.rule.StyleContext;

import java.util.Objects;

public class DeclarationLayoutContext extends StyleContext {
    // If one statement among all the declaration statements checked at a time has a comment,
    // then this field value is set to true.
    public boolean hasComment;

    public DeclarationLayoutContext(boolean hasComment) {
        this.hasComment = hasComment;
    }

    @Override
    public void addElement(Element parent, MyParser parser) {
        parent.addAttribute("has_comment", Boolean.toString(hasComment));
    }

    @Override
    public void parseElement(Element parent, MyParser parser) {
        hasComment = Boolean.parseBoolean(parent.attributeValue("has_comment"));
    }

    @Override
    public int hashCode() {
        return Objects.hash(hasComment);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof DeclarationLayoutContext other) {
            return other.hasComment == hasComment;
        }
        return false;
    }
}
