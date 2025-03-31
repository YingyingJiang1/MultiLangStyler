package org.example.styler.practice.style;

import org.dom4j.Element;
import org.example.parser.common.MyParser;
import org.example.style.rule.StyleContext;
import org.example.styler.naming.NameType;

public class UnusedCodeContext extends StyleContext {
    NameType codeLevel;

    public UnusedCodeContext() {
    }

    public UnusedCodeContext(NameType codeLevel) {
        this.codeLevel = codeLevel;
    }

    @Override
    public void addElement(Element parent, MyParser parser) {
        parent.addAttribute("codeLevel",  codeLevel.name());
    }

    @Override
    public void parseElement(Element parent, MyParser parser) {
        codeLevel = NameType.valueOf(parent.attributeValue("codeLevel"));
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof UnusedCodeContext targetContext && codeLevel == targetContext.codeLevel;
    }

    @Override
    public int hashCode() {
        return codeLevel.hashCode();
    }
}
