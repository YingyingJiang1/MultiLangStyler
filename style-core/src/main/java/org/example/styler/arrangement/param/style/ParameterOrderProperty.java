package org.example.styler.arrangement.param.style;

import org.dom4j.Element;
import org.example.parser.common.MyParser;
import org.example.style.rule.StyleProperty;
import org.example.styler.arrangement.LogicalOrder;

import java.util.Objects;

public class ParameterOrderProperty extends StyleProperty {
    public LogicalOrder order;
    public Boolean isSameTypeParamSeparated;

    public ParameterOrderProperty() {
    }

    public ParameterOrderProperty(LogicalOrder order, Boolean isSameTypeParamSeparated) {
        this.order = order;
        this.isSameTypeParamSeparated = isSameTypeParamSeparated;
    }

    @Override
    public void addElement(Element parent, MyParser parser) {
        if (order != null) {
            parent.addElement("order").setText(order.toString());
        }
        if (isSameTypeParamSeparated != null) {
            parent.addElement("separate_same_type").setText(String.valueOf(isSameTypeParamSeparated));
        }
    }

    @Override
    public void parseElement(Element parent, MyParser parser) {
        if (parent.attribute("order") != null) {
            order = LogicalOrder.valueOf(parent.attributeValue("order"));
        }
        if (parent.attribute("separate_same_type") != null) {
            isSameTypeParamSeparated = Boolean.parseBoolean(parent.attributeValue("separate_same_type"));
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(order, isSameTypeParamSeparated);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ParameterOrderProperty other) {
            return order == other.order && isSameTypeParamSeparated == other.isSameTypeParamSeparated;
        }
        return false;
    }
}
