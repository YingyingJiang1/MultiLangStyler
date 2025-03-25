package org.example.styler.format.indention.style;

import org.dom4j.Element;
import org.example.parser.common.MyParser;
import org.example.style.rule.StyleProperty;

import java.util.Objects;

public class IndentionProperty extends StyleProperty {
    public int indentionUnit;
    public char indentionType = ' ';

    public IndentionProperty() {
    }

    public IndentionProperty(int indentionUnit, char indentionType) {
        this.indentionUnit = indentionUnit;
        this.indentionType = indentionType;
    }

    @Override
    public void addElement(Element parent, MyParser parser) {
        parent.addAttribute("indentionUnit", String.valueOf(indentionUnit));
        parent.addAttribute("indentionType", indentionType == ' ' ? " " : "\\t");
    }

    @Override
    public void parseElement(Element parent, MyParser parser) {
        indentionUnit = Integer.parseInt(parent.attributeValue("indentionUnit"));
        indentionType = parent.attributeValue("indentionType").equals(" ") ? ' ' : '\t';
    }

    @Override
    public int hashCode() {
        return Objects.hash(indentionUnit, indentionType);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof IndentionProperty property) {
            return indentionUnit == property.indentionUnit && indentionType == property.indentionType;
        }
        return false;
    }
}
