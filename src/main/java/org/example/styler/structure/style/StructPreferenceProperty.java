package org.example.styler.structure.style;

import org.dom4j.Element;
import org.example.parser.common.MyParser;
import org.example.style.rule.StyleProperty;

public class StructPreferenceProperty extends StyleProperty {
    public int preferenceIndex;

    public StructPreferenceProperty(int preferenceIndex) {
        this.preferenceIndex = preferenceIndex;
    }

    public int getPreferenceIndex() {
        return preferenceIndex;
    }

    @Override
    public void addElement(Element parent, MyParser parser) {
        parent.addAttribute("preferenceIndex", Integer.toString(preferenceIndex));
    }

    @Override
    public void parseElement(Element parent, MyParser parser) {
        preferenceIndex = Integer.parseInt(parent.attributeValue("preferenceIndex"));
    }
}
