package org.example.styler.exp.updatevar.style;

import org.dom4j.Element;
import org.example.parser.common.MyParser;
import org.example.style.rule.StyleProperty;

public class UpdateVarProperty extends StyleProperty {
    public boolean updateInStmt; // Updates variable in independent statement.

    public UpdateVarProperty(boolean updateInStmt) {
        this.updateInStmt = updateInStmt;
    }

    @Override
    public void addElement(Element parent, MyParser parser) {
        parent.addAttribute("updateInStmt", Boolean.toString(updateInStmt));
    }

    @Override
    public void parseElement(Element parent, MyParser parser) {
        updateInStmt = Boolean.parseBoolean(parent.attributeValue("updateInStmt"));
    }

    @Override
    public int hashCode() {
        return Boolean.hashCode(updateInStmt);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof UpdateVarProperty) {
            return updateInStmt == ((UpdateVarProperty) obj).updateInStmt;
        } else {
            return false;
        }
    }
}
