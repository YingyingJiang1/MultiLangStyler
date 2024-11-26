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

    }

    @Override
    public Object parseElement(Element parent, MyParser parser) {
        return null;
    }
}
