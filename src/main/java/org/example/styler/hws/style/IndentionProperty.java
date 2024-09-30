package org.example.styler.hws.style;

import org.antlr.v4.runtime.Parser;
import org.dom4j.Element;
import org.example.interfaces.StyleProperty;

public class IndentionProperty extends StyleProperty {
    public int indentionUnit;
    public char indentionType = ' ';

    public IndentionProperty() {}

    public IndentionProperty(int unit, char type) {
        indentionUnit = unit;
        indentionType = type;
    }


    @Override
    public void addElement(Element parent, Parser parser) {
        Element indentionRleEle = parent.addElement("indention_rule");
        indentionRleEle.addElement("indention_unit").addText(Integer.toString(indentionUnit));
        String type = "space";
        if(indentionType == '\t') {
            type = "tab";
        }
        indentionRleEle.addElement("indention_type").addText(type);
    }



    @Override
    public IndentionProperty parseElement(Element parent, Parser parser){
        indentionUnit = Integer.parseInt(parent.element("indention_unit").getText());

        String type = parent.element("indention_type").getText();
        if(type.equals("space")) {
            indentionType = ' ';
        } else {
            indentionType = '\t';
        }
        return this;
    }
}
