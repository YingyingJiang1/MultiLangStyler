package org.example.styler.format.style;

import org.dom4j.Element;
import org.example.parser.common.MyParser;
import org.example.style.rule.StyleProperty;

import java.util.Objects;

public class NewlineProperty extends StyleProperty {
    /**
     * The number of newlines between two structure.Except in two cases:
     * 1. The first newline around { and } are excluded.
     * for example:
     * if(true) {VWS1
     *   int a = 1;VWS2
     * }VWS3
     * VWS1 is a newline after {, VWS2 is a newline before }, VWS3 is a VWS after }.
     * So in this example,we will get the result: there is no newline between local variable declaration
     * statement and }.
     *
     * 2. The first newline after a statement in block statement but without brace.
     * if(true)VWS1
     *   a++;VWS2
     * int b = 1;
     * In this case, VWS2 is a vws after expression statement "a++;". So the number of newlines between ifStmt
     * and localVariableDeclarationStmt is 0.
     */
    public int newlines;

    public NewlineProperty() {
    }

    public NewlineProperty(int newlines) {
        this.newlines = newlines;
    }

    @Override
    public void addElement(Element parent, MyParser parser) {
        parent.addAttribute("newlines", Integer.toString(newlines));
    }

    @Override
    public void parseElement(Element parent, MyParser parser) {
        String newlinesStr = parent.attributeValue("newlines");
        if (newlinesStr != null) {
            newlines = Integer.parseInt(newlinesStr);
        }
        
    }

    @Override
    public int hashCode() {
        return Objects.hash(newlines);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof NewlineProperty property) {
            return newlines == property.newlines;
        }
        return false;
    }
}
