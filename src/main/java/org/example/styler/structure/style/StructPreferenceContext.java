package org.example.styler.structure.style;

import org.dom4j.Element;
import org.example.parser.common.MyParser;
import org.example.style.rule.StyleContext;

import java.util.Objects;

public class StructPreferenceContext extends StyleContext {
    int structID;
    String structCategory;

    public StructPreferenceContext() {
    }

    public StructPreferenceContext(String structCategory, int structID) {
        this.structCategory = structCategory;
        this.structID = structID;
    }

    public int getStructID() {
        return structID;
    }

    public String getStructCategory() {
        return structCategory;
    }

    @Override
    public void addElement(Element parent, MyParser parser) {
        parent.addAttribute("id", Integer.toString(structID));
        parent.addAttribute("category", structCategory);
    }

    @Override
    public void parseElement(Element parent, MyParser parser) {
        structID = Integer.parseInt(parent.attributeValue("id"));
        if (parent.attribute("category") != null) {
            structCategory = parent.attributeValue("category");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StructPreferenceContext that = (StructPreferenceContext) o;
        return structID == that.structID && Objects.equals(structCategory, that.structCategory);
    }

    @Override
    public int hashCode() {
        return Objects.hash(structID, structCategory);
    }
}
