package org.example.styler.exp.updatevar.style;

import org.dom4j.Element;
import org.example.parser.common.MyParser;
import org.example.style.rule.StyleContext;
import org.example.styler.exp.ExpType;

public class UpdateVarContext extends StyleContext {
    public ExpType expType;

    public UpdateVarContext(ExpType expType) {
        this.expType = expType;
    }

    @Override
    public void addElement(Element parent, MyParser parser) {
        parent.addAttribute("expType", expType.name());
    }

    @Override
    public void parseElement(Element parent, MyParser parser) {
        expType = ExpType.valueOf(parent.attributeValue("expType"));
    }

    @Override
    public int hashCode() {
        return expType.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof UpdateVarContext) {
            return expType.equals(((UpdateVarContext) obj).expType);
        }
        return false;
    }
}
