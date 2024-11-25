package org.example.styler.format.linewrapping.style;

import org.dom4j.Element;
import org.example.io.DomIO;
import org.example.parser.common.MyParser;

import java.util.Objects;

public class BreakInfo implements DomIO {
    public static final int ALIGN = 1;
    public static final int FIX_INDENTION = 2;


    public int count = 0;
    public int way;
    public int offRelated; // the value of @way determines the meaning of $off.

    public BreakInfo() {
        this.count = 1;
    }

    @Override
    public void addElement(Element parent, MyParser parser) {
        Element breakInfoEle = parent.addElement("break_info");
        if (way == ALIGN) {
            breakInfoEle.addElement("way").addText("ALIGN");
            breakInfoEle.addElement("start_position").addText(Integer.toString(offRelated) + ":" + parser.getTokenName(offRelated));
        } else {
            breakInfoEle.addElement("way").addText("FIXED_INDENTION");
            breakInfoEle.addElement("start_position").addText(Integer.toString(offRelated));
        }

    }

    @Override
    public Object parseElement(Element parent, MyParser parser) {
        Element breakInfoEle = parent.element("break_info");
        String wayStr = breakInfoEle.elementText("way");
        if (wayStr.equals("ALIGN")) {
            way = ALIGN;
            offRelated = Integer.parseInt(breakInfoEle.elementText("start_position").split(":")[0]);
        } else {
            way = FIX_INDENTION;
            offRelated = Integer.parseInt(breakInfoEle.elementText("start_position"));
            breakInfoEle.addElement("way").addText("FIXED_INDENTION");
        }
        return this;
    }

    public void merge(BreakInfo breakInfo) {
        count += breakInfo.count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BreakInfo breakInfo = (BreakInfo) o;
        return way == breakInfo.way && offRelated == breakInfo.offRelated;
    }

    @Override
    public int hashCode() {
        return Objects.hash(way, offRelated);
    }
}
