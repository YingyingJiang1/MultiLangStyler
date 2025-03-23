package org.example.styler.naming.format.style;

import org.dom4j.Element;
import org.example.parser.common.MyParser;
import org.example.style.rule.StyleContext;
import org.example.styler.naming.SymbolType;
import org.example.styler.naming.format.SymbolAttr;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class NamingFormatContext extends StyleContext {
    public SymbolType symbolType;
    public List<SymbolAttr> attrs = null;

    public NamingFormatContext() {
    }

    public NamingFormatContext(SymbolType symbolType) {
        this.symbolType = symbolType;
    }

    public void addAttr(SymbolAttr attr) {
        if (attrs == null) {
            attrs = new ArrayList<>();
        }
        attrs.add(attr);
    }

    @Override
    public void addElement(Element parent, MyParser parser) {
        parent.addAttribute("name_type", symbolType.name());
    }

    @Override
    public void parseElement(Element parent, MyParser parser) {
        symbolType = SymbolType.valueOf(parent.attributeValue("name_type"));
    }

    @Override
    public int hashCode() {
        return Objects.hash(symbolType, attrs);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof NamingFormatContext other) {
            return symbolType == other.symbolType && Objects.equals(attrs, other.attrs);
        }
        return false;
    }
}
