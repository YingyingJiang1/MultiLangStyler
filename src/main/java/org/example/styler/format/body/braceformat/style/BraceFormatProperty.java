package org.example.styler.format.body.braceformat.style;

import org.dom4j.Element;
import org.example.parser.common.MyParser;
import org.example.style.rule.StyleProperty;

import java.util.Objects;

public class BraceFormatProperty extends StyleProperty {
    public boolean beforeLB, afterLB, beforeRB, afterRB;


    public BraceFormatProperty() {
    }

    public BraceFormatProperty(boolean beforeLB, boolean afterLB, boolean beforeRB, boolean afterRB) {
        this.beforeLB = beforeLB;
        this.afterLB = afterLB;
        this.beforeRB = beforeRB;
        this.afterRB = afterRB;
    }

//    public void updateStatistic(boolean beforeLB, boolean afterLB, boolean beforeRB, boolean afterRB) {
//        int integer = beforeLB ? 1 : 0;
//        integer <<= 1;
//        integer |= afterLB ? 1 : 0;
//        integer <<= 1;
//        integer |= beforeRB ? 1 : 0;
//        integer <<= 1;
//        integer |= afterRB ? 1 : 0;
//        frequency.compute(integer, (k, v) -> v == null ? 1 : v + 1);
//    }



    @Override
    public void addElement(Element parent, MyParser parser) {
        parent.addAttribute("beforeLB", Boolean.toString(beforeLB));
        parent.addAttribute("afterLB", Boolean.toString(afterLB));
        parent.addAttribute("beforeRB", Boolean.toString(beforeRB));
        parent.addAttribute("afterRB", Boolean.toString(afterRB));
    }

    @Override
    public void parseElement(Element parent, MyParser parser) {
        // Default value is true
        beforeLB = parent.attributeValue("beforeLB") == null || Boolean.parseBoolean(parent.attributeValue("beforeLB"));
        afterLB = parent.attributeValue("afterLB") == null || Boolean.parseBoolean(parent.attributeValue("afterLB"));
        beforeRB = parent.attributeValue("beforeRB") == null || Boolean.parseBoolean(parent.attributeValue("beforeRB"));
        afterRB = parent.attributeValue("afterRB") == null || Boolean.parseBoolean(parent.attributeValue("afterRB"));
    }

    @Override
    public int hashCode() {
        return Objects.hash(beforeLB, afterLB, beforeRB, afterRB);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof BraceFormatProperty property) {
            return beforeLB == property.beforeLB && afterLB == property.afterLB && beforeRB == property.beforeRB && afterRB == property.afterRB;
        }
        return false;
    }
}
