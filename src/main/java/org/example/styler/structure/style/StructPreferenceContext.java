package org.example.styler.structure.style;

import org.dom4j.Element;
import org.example.parser.common.MyParser;
import org.example.style.rule.StyleContext;

public class StructPreferenceContext extends StyleContext {
    int structID;
    String structName;

    public StructPreferenceContext(String structName, int structID) {
        this.structName = structName;
        this.structID = structID;
    }

    public int getStructID() {
        return structID;
    }

    public String getStructName() {
        return structName;
    }

    @Override
    public void addElement(Element parent, MyParser parser) {

    }

    @Override
    public Object parseElement(Element parent, MyParser parser) {
        return null;
    }
}
