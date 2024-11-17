package org.example.styler.format.indention.style;

import org.antlr.v4.runtime.Parser;
import org.dom4j.Element;
import org.example.style.rule.StyleProperty;

public class IndentionProperty extends StyleProperty {
    public int indentionUnit;
    public char indentionType = ' ';

    @Override
    public void addElement(Element parent, Parser parser) {
        parent.addAttribute("indentionUnit", String.valueOf(indentionUnit));
        parent.addAttribute("indentionType", String.valueOf(indentionType));
    }

    @Override
    public Object parseElement(Element parent, Parser parser) {
        indentionUnit = Integer.parseInt(parent.attributeValue("indentionUnit"));
        indentionType = parent.attributeValue("indentionType").charAt(0);
        return this;
    }
}
