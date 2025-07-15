package org.example.styler.declaration.location.style;

import org.dom4j.Element;
import org.example.parser.common.MyParser;
import org.example.style.rule.StyleProperty;
import org.example.styler.declaration.location.Location;

import java.util.Objects;

public class DeclarationLocationProperty extends StyleProperty {

    public double avgLineDis2firstUse;
    public Location location;

    public DeclarationLocationProperty() {
    }

    public DeclarationLocationProperty(double avgLineDis2firstUse, Location location) {
        this.location = location;
        this.avgLineDis2firstUse = Math.round(avgLineDis2firstUse * 100) / 100.0;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DeclarationLocationProperty property = (DeclarationLocationProperty) o;
        return Double.compare(avgLineDis2firstUse, property.avgLineDis2firstUse) == 0 && location == property.location;
    }

    @Override
    public int hashCode() {
        return Objects.hash(avgLineDis2firstUse, location);
    }
}
