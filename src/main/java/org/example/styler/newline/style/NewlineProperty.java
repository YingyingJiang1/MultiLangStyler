package org.example.styler.newline.style;

import org.dom4j.Element;
import org.example.styler.hws.style.SpaceProperty;

import java.util.Objects;

public class NewlineProperty extends SpaceProperty {
    /**
     * The number of newlines between two structure.Except in two cases:
     * 1. The first newline around { and } are excluded.
     * for example:
     * if(true) {VWS1
     * int a = 1;VWS2
     * }VWS3
     * VWS1 is a newline after {, VWS2 is a newline before }, VWS3 is a VWS after }.
     * So in this example,we will get the result: there is no newline between local variable declaration
     * statement and }.
     * <p>
     * 2. The first newline after a statement in block statement but without brace.
     * if(true)VWS1
     * a++;VWS2
     * int b = 1;
     * In this case, VWS2 is a vws after expression statement "a++;". So the number of newlines between ifStmt
     * and localVariableDeclarationStmt is 0.
     */
    public int newlines;

    public NewlineProperty(int newlines) {
        this.newlines = newlines;
    }

    public NewlineProperty() {
    }

    @Override
    public void addElement(Element parent) {
        Element propertyEle = parent.addElement("property");
        propertyEle.addElement("newlines").addText(Integer.toString(newlines));
    }

    @Override
    public void parseElement(Element parent) {
        Element propertyEle = parent.element("property");
        newlines = Integer.parseInt(propertyEle.addElement("newlines").getText());
    }

    @Override
    public NewlineProperty clone() {
        return new NewlineProperty(newlines);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NewlineProperty newlineProperty = (NewlineProperty) o;
        return newlines == newlineProperty.newlines;
    }

    @Override
    public int hashCode() {
        return Objects.hash(newlines);
    }
}
