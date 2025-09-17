package org.example.styler.structure.style;

import org.dom4j.Element;
import org.example.parser.common.MyParser;
import org.example.style.rule.StyleContext;

import java.util.Objects;

public class StructPreferenceContext extends StyleContext {
    // 两个属性互斥，styleCategory优先级更高
    int structID = -1;
    StyleCategory styleCategory = null;

    public StructPreferenceContext() {
    }

    public StructPreferenceContext(int structID) {
        this.structID = structID;
    }

    public StructPreferenceContext(StyleCategory styleCategory) {
        this.styleCategory = styleCategory;
    }

    public StructPreferenceContext(StyleCategory styleCategory, int structID) {
        this.styleCategory = styleCategory;
        this.structID = structID;
    }

    public int getStructID() {
        return structID;
    }

    public StyleCategory getStyleCategory() {
        return styleCategory;
    }

    @Override
    public void addElement(Element parent, MyParser parser) {
        if (structID >= 0) {
            parent.addAttribute("id", Integer.toString(structID));
        }
        if(styleCategory != null) {
            parent.addAttribute("category", styleCategory.toString());
        }
    }

    @Override
    public void parseElement(Element parent, MyParser parser) {
        if (parent.attribute("id") != null) {
            structID = Integer.parseInt(parent.attributeValue("id"));
        }
        if (parent.attribute("category") != null) {
            try {
                styleCategory = StyleCategory.valueOf(parent.attributeValue("category"));
            } catch (Exception e) {
                styleCategory = null;
            }

        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StructPreferenceContext that = (StructPreferenceContext) o;
        return structID == that.structID && Objects.equals(styleCategory, that.styleCategory) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(structID, styleCategory) ;
    }
}
