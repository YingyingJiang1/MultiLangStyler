package org.example.styler.exp.updatevar.style;

import org.dom4j.Element;
import org.example.parser.common.MyParser;
import org.example.style.rule.StyleProperty;

public class UpdateVarProperty extends StyleProperty {
    public boolean allowUpdatingInExp;

    public UpdateVarProperty(boolean allowUpdatingInExp) {
        this.allowUpdatingInExp = allowUpdatingInExp;
    }

    @Override
    public void addElement(Element parent, MyParser parser) {
        parent.addAttribute("allowUpdatingInExp", Boolean.toString(allowUpdatingInExp));
    }

    @Override
    public void parseElement(Element parent, MyParser parser) {
        allowUpdatingInExp = Boolean.parseBoolean(parent.attributeValue("allowUpdatingInExp"));
    }
}
