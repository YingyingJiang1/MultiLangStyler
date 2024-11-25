package org.example.styler.brace.style;

import org.antlr.v4.runtime.Parser;
import org.dom4j.Element;
import org.example.parser.common.MyParser;
import org.example.style.rule.StyleProperty;

public class OptionalBraceProperty extends StyleProperty {
    public boolean useBrace;
    public boolean compactStyle; // The field is meaningful when @useBrace == false


    public OptionalBraceProperty(boolean useBrace, boolean compactStyle) {
        this.useBrace = useBrace;
        this.compactStyle = compactStyle;
    }

    public OptionalBraceProperty() {
    }

    @Override
    public void addElement(Element parent, MyParser parser) {
        parent.addElement("use_brace").addText(Boolean.toString(useBrace));
        if(!useBrace) {
            parent.addElement("is_inline_block").addText(Boolean.toString(compactStyle));
        }
    }

    @Override
    public Object parseElement(Element parent, MyParser parser) {
        if (parent != null) {
            useBrace = Boolean.parseBoolean(parent.elementText("use_brace"));
            if(!useBrace) {
                compactStyle = Boolean.parseBoolean(parent.elementText("is_inline_block"));
            }
        }
        return this;
    }
}
