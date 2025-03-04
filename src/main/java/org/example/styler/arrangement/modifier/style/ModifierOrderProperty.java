package org.example.styler.arrangement.modifier.style;

import org.dom4j.Element;
import org.example.parser.common.MyParser;
import org.example.style.rule.StyleProperty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class ModifierOrderProperty extends StyleProperty {
    public List<String> order = new ArrayList<String>(0);

    public ModifierOrderProperty() {
    }

    public ModifierOrderProperty(List<String> modifiers) {
        order = modifiers;
    }

    @Override
    public void addElement(Element parent, MyParser parser) {
        if (order.isEmpty()) {
            parent.addAttribute("order", "");
        } else {
            parent.addAttribute("order", order.toString().substring(1, order.toString().length() - 1));
        }
    }

    @Override
    public void parseElement(Element parent, MyParser parser) {
        String[] modifiers = parent.attributeValue("order").split(",");
        if (modifiers.length > 0) {
            order = Arrays.stream(modifiers)
                .map(String::trim)
                .toList();
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(order);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ModifierOrderProperty other) {
            return Objects.equals(order, other.order);
        }
        return false;
    }
}
