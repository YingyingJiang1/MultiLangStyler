package org.example.styler.declaration.location.style;

import org.dom4j.Element;
import org.example.parser.common.MyParser;
import org.example.style.rule.StyleProperty;
import org.example.styler.declaration.location.Location;

public class DeclarationLocationProperty extends StyleProperty {

    public double avgLineDis2firstUse;
    public Location location;

    public DeclarationLocationProperty() {
    }

    public DeclarationLocationProperty(double avgLineDis2firstUse, Location location) {
        this.location = location;
        this.avgLineDis2firstUse = avgLineDis2firstUse;
    }

    @Override
    public void addElement(Element parent, MyParser parser) {
        parent.addElement("avgLineDis2firstUse").setText(Double.toString(avgLineDis2firstUse));
        parent.addElement("location").setText(location.toString());
    }

    @Override
    public void parseElement(Element parent, MyParser parser) {
        location = Location.valueOf(parent.element("location").getText());
        avgLineDis2firstUse = Double.parseDouble(parent.element("avgLineDis2firstUse").getText());
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
