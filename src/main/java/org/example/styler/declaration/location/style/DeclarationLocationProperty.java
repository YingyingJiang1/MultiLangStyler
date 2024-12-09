package org.example.styler.declaration.location.style;

import org.dom4j.Element;
import org.example.parser.common.MyParser;
import org.example.style.rule.StyleProperty;
import org.example.styler.declaration.location.Location;

public class DeclarationLocationProperty extends StyleProperty {

    public Location location;

    public DeclarationLocationProperty(Location location) {
        this.location = location;
    }

    @Override
    public void addElement(Element parent, MyParser parser) {
        parent.addElement("location").setText(location.toString());
    }

    @Override
    public void parseElement(Element parent, MyParser parser) {
        location = Location.valueOf(parent.getText());
    }

    @Override
    public int hashCode() {
        return location.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof DeclarationLocationProperty other) {
            return location == other.location;
        }
        return false;
    }
}
