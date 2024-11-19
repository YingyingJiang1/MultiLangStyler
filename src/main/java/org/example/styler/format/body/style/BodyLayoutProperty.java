package org.example.styler.format.body.style;

import org.antlr.v4.runtime.Parser;
import org.dom4j.Element;
import org.example.style.rule.StyleProperty;

public class BodyLayoutProperty extends StyleProperty {
    public boolean beforeLB, afterLB, beforeRB, afterRB;


    public BodyLayoutProperty() {
    }

    public BodyLayoutProperty(boolean beforeLB, boolean afterLB, boolean beforeRB, boolean afterRB) {
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
    public String toString() {
        return Boolean.toString(beforeLB) + "," + Boolean.toString(afterLB) + "," +
                Boolean.toString(beforeRB) + "," + Boolean.toString(afterRB);
    }


    @Override
    public void addElement(Element parent, Parser parser) {
        Element braceInfoEle = parent.addElement("brace_info");
        braceInfoEle.addElement("line_break_info").addText(
                "(" + toString() + ")"
        );
    }

    @Override
    public BodyLayoutProperty parseElement(Element parent, Parser parser) {
        String[] arr = parent.element("line_break_info").getText().split("[(),]");
        return new BodyLayoutProperty(
                Boolean.parseBoolean(arr[0]), Boolean.parseBoolean(arr[1]),
                Boolean.parseBoolean(arr[2]), Boolean.parseBoolean(arr[3]));
    }
}
