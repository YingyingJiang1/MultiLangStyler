package org.example.styler.structure.style;

import org.dom4j.Element;
import org.example.parser.common.MyParser;
import org.example.style.rule.StyleProperty;

import java.util.Objects;

public class StructPreferenceProperty extends StyleProperty {
    // 两个属性互斥，style优先级更高
    private int preferenceIndex = -1;
    private String style; // 当style无效时，使用preferenceIndex（当所有配置的写法都填充了style时，可以删除preferenceIndex）

    public StructPreferenceProperty() {
    }

    public StructPreferenceProperty(int preferenceIndex, String style) {
        this.preferenceIndex = preferenceIndex;
        this.style = style;

        // 当配置了有效的style时，index无效，统一设置为0
        if (style != null && !style.isEmpty()) {
            this.preferenceIndex = -1;
        }
    }

    public int getPreferenceIndex() {
        return preferenceIndex;
    }

    public String getStyle() {
        return style;
    }

    @Override
    public void addElement(Element parent, MyParser parser) {
        if (preferenceIndex >= 0) {
            parent.addAttribute("preferenceIndex", Integer.toString(preferenceIndex));
        }
        if (style != null && !style.isEmpty()) {
            parent.addAttribute("style", style);
        }
    }

    @Override
    public void parseElement(Element parent, MyParser parser) {
        if (parent.attribute("preferenceIndex") != null) {
            preferenceIndex = Integer.parseInt(parent.attributeValue("preferenceIndex"));
        }
        if (parent.attribute("style") != null) {
            style = parent.attributeValue("style");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StructPreferenceProperty that = (StructPreferenceProperty) o;
        return preferenceIndex == that.preferenceIndex && Objects.equals(style, that.style);
    }

    @Override
    public int hashCode() {
        return Objects.hash(preferenceIndex, style);
    }
}
