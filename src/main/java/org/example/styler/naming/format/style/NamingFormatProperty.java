package org.example.styler.naming.style;

import com.google.common.base.CaseFormat;
import org.apache.commons.lang3.StringUtils;
import org.dom4j.Element;
import org.example.parser.common.MyParser;
import org.example.style.rule.StyleProperty;

import java.util.Objects;

public class NamingFormatProperty extends StyleProperty {
    public boolean startsWithUnderScore;
    public CaseFormat caseFormat;
    // When th length of name exceeds the length of `maxLength`, try to abbreviate the name.
    public int maxLength = Integer.MAX_VALUE;

    public NamingFormatProperty(boolean startsWithUnderScore, CaseFormat caseFormat, int maxLength) {
        this.startsWithUnderScore = startsWithUnderScore;
        this.caseFormat = caseFormat;
        this.maxLength = maxLength;
    }

    @Override
    public void addElement(Element parent, MyParser parser) {
        parent.addAttribute("case_format", caseFormat.name());
        parent.addAttribute("start_with_underscore", String.valueOf(startsWithUnderScore));
        if (maxLength != Integer.MAX_VALUE) {
            parent.addAttribute("max_length", String.valueOf(maxLength));
        }
    }

    @Override
    public void parseElement(Element parent, MyParser parser) {
        caseFormat = CaseFormat.valueOf(parent.attributeValue("case_format"));
        if (parent.attributeValue("max_length") != null) {
            maxLength = Integer.parseInt(parent.attributeValue("max_length"));
        } else {
            maxLength = Integer.MAX_VALUE;
        }
        if (parent.attributeValue("start_with_underscore") != null) {
            startsWithUnderScore = Boolean.parseBoolean(parent.attributeValue("start_with_underscore"));
        } else {
            startsWithUnderScore = false;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(startsWithUnderScore, caseFormat, maxLength);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof NamingFormatProperty other) {
            return startsWithUnderScore == other.startsWithUnderScore
                    && caseFormat == other.caseFormat
                    && maxLength == other.maxLength;
        }
        return false;
    }
}
