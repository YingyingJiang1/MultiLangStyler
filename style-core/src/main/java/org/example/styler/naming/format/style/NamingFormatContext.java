package org.example.styler.naming.format.style;

import org.dom4j.Attribute;
import org.dom4j.Element;
import org.example.parser.common.MyParser;
import org.example.style.rule.StyleContext;
import org.example.styler.naming.NameType;
import org.example.styler.naming.format.SymbolAttr;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class NamingFormatContext extends StyleContext {
    public NameType nameType;
    public List<SymbolAttr> attrs = null;

    public NamingFormatContext() {
    }

    public NamingFormatContext(NameType nameType) {
        this.nameType = nameType;
    }

    public void addAttr(SymbolAttr attr) {
        if (attrs == null) {
            attrs = new ArrayList<>();
        }
        attrs.add(attr);
    }

    @Override
    public void addElement(Element parent, MyParser parser) {
        parent.addAttribute("nameType", nameType.name());
        if (attrs != null) {
            parent.addAttribute("attrs", attrs.toString());
        }
    }

    @Override
    public void parseElement(Element parent, MyParser parser) {
        nameType = NameType.valueOf(parent.attributeValue("nameType"));
       if (parent.attribute("attrs") != null) {
           attrs = new ArrayList<>();
           String[] arr = parent.attributeValue("attrs").substring(1, parent.attributeValue("attrs").length() - 1).split(",");
           for (String attr : arr) {
               attrs.add(SymbolAttr.valueOf(attr));
           }
       }

    }

    @Override
    public int hashCode() {
        return Objects.hash(nameType, attrs);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof NamingFormatContext other) {
            return nameType == other.nameType && Objects.equals(attrs, other.attrs);
        }
        return false;
    }
}
