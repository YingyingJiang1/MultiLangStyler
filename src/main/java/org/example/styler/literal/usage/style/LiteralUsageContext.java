package org.example.styler.literal.usage.style;

import org.dom4j.Element;
import org.example.parser.common.MyParser;
import org.example.style.rule.StyleContext;
import org.example.styler.literal.LiteralEnum;

import java.util.Objects;

public class LiteralUsageContext extends StyleContext {
    public LiteralEnum literalType;

    public LiteralUsageContext() {
    }

    public LiteralUsageContext(LiteralEnum literalType) {
        this.literalType = literalType;
    }

    @Override
    public void addElement(Element parent, MyParser parser) {
        parent.addAttribute("literal_type", literalType.name());
    }

    @Override
    public void parseElement(Element parent, MyParser parser) {
        literalType = LiteralEnum.valueOf(parent.attributeValue("literal_type"));
    }

    @Override
    public int hashCode() {
        return Objects.hash(literalType);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof LiteralUsageContext other) {
         return literalType == other.literalType;
        }
        return false;
    }
}
