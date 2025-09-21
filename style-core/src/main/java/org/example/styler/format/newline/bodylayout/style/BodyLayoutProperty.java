package org.example.styler.format.newline.bodylayout.style;

import org.dom4j.Element;
import org.example.parser.common.MyParser;
import org.example.style.rule.StyleProperty;

import java.util.Objects;

public class BodyLayoutProperty extends StyleProperty {
    /**
     * If there isn't {}, only `beforeLB` is meaningful.
     * e.g.: if (bool) [beforeLB] return a;
     */
    public int beforeLB, afterLB, beforeRB, afterRB;


    public BodyLayoutProperty(int beforeLB) {
        this.beforeLB = beforeLB;
    }

    public BodyLayoutProperty(int beforeLB, int afterLB, int afterRB) {
        this.afterLB = afterLB;
        this.beforeLB = beforeLB;
        this.afterRB = afterRB;
    }

    public BodyLayoutProperty(int beforeLB, int afterLB, int beforeRB, int afterRB) {
        this.beforeLB = beforeLB;
        this.afterLB = afterLB;
        this.beforeRB = beforeRB;
        this.afterRB = afterRB;
    }

	public BodyLayoutProperty() {

	}

//    public void updateStatistic(int beforeLB, int afterLB, int beforeRB, int afterRB) {
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
        parent.addAttribute("beforeLB", Integer.toString(beforeLB));
//        parent.addAttribute("afterLB", Integer.toString(afterLB));
//        parent.addAttribute("beforeRB", Integer.toString(beforeRB));
        parent.addAttribute("afterRB", Integer.toString(afterRB));
    }

    @Override
    public void parseElement(Element parent, MyParser parser) {
        // Default value is true
        beforeLB = Integer.parseInt(parent.attributeValue("beforeLB"));
//        afterLB = parent.attributeValue("afterLB") == null || Integer.parseInt(parent.attributeValue("afterLB"));
//        beforeRB = parent.attributeValue("beforeRB") == null || Integer.parseInt(parent.attributeValue("beforeRB"));
        afterRB = Integer.parseInt(parent.attributeValue("afterRB"));
    }

    @Override
    public int hashCode() {
        return Objects.hash(beforeLB, afterLB, beforeRB, afterRB);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof BodyLayoutProperty property) {
            return beforeLB == property.beforeLB && afterLB == property.afterLB && beforeRB == property.beforeRB && afterRB == property.afterRB;
        }
        return false;
    }
}
