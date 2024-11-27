package org.example.styler.format.indention.style;

import org.dom4j.Element;
import org.example.parser.common.MyParser;
import org.example.style.rule.StyleProperty;

public class IndentionProperty extends StyleProperty {
    public int indentionUnit;
    public char indentionType = ' ';

    public IndentionProperty(int indentionUnit, char indentionType) {
        this.indentionUnit = indentionUnit;
        this.indentionType = indentionType;
    }

    @Override
    public void addElement(Element parent, MyParser parser) {
        parent.addAttribute("indentionUnit", String.valueOf(indentionUnit));
        parent.addAttribute("indentionType", String.valueOf(indentionType));
    }

    @Override
    public void parseElement(Element parent, MyParser parser) {
        indentionUnit = Integer.parseInt(parent.attributeValue("indentionUnit"));
        indentionType = parent.attributeValue("indentionType").charAt(0);
        
    }
}
