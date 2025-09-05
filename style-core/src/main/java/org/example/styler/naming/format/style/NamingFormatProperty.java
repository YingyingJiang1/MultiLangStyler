package org.example.styler.naming.format.style;

import com.google.common.base.CaseFormat;
import org.dom4j.Element;
import org.example.parser.common.MyParser;
import org.example.style.rule.StyleProperty;
import org.example.styler.naming.MyCaseFormat;

import java.util.Objects;

public class NamingFormatProperty extends StyleProperty {
    public boolean startsWithUnderScore;
    public MyCaseFormat caseFormat;
    // When th length of name exceeds the length of `maxLength`, try to abbreviate the name.
    public int maxLength = Integer.MAX_VALUE;

    public NamingFormatProperty() {
    }

    public NamingFormatProperty(boolean startsWithUnderScore, MyCaseFormat caseFormat, int maxLength) {
        this.startsWithUnderScore = startsWithUnderScore;
        this.caseFormat = caseFormat;
        this.maxLength = maxLength;
    }

    @Override
    public void addElement(Element parent, MyParser parser) {
        if (caseFormat != null) {
            parent.addAttribute("caseFormat", caseFormat.name());
        }
        parent.addAttribute("startsWithUnderScore", String.valueOf(startsWithUnderScore));
        if (maxLength != Integer.MAX_VALUE) {
            parent.addAttribute("maxLength", String.valueOf(maxLength));
        }

    }

    @Override
    public void parseElement(Element parent, MyParser parser) {
        String caseFormatName = parent.attributeValue("caseFormat");
        caseFormat = MyCaseFormat.valueOf(caseFormatName);

        if (parent.attributeValue("maxLength") != null) {
            maxLength = Integer.parseInt(parent.attributeValue("maxLength"));
        } else {
            maxLength = Integer.MAX_VALUE;
        }
        if (parent.attributeValue("startsWithUnderScore") != null) {
            startsWithUnderScore = Boolean.parseBoolean(parent.attributeValue("startsWithUnderScore"));
        } else {
            startsWithUnderScore = false;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NamingFormatProperty property = (NamingFormatProperty) o;
        return startsWithUnderScore == property.startsWithUnderScore && maxLength == property.maxLength && caseFormat == property.caseFormat;
    }

    @Override
    public int hashCode() {
        return Objects.hash(startsWithUnderScore, caseFormat, maxLength);
    }
}
