package org.example.styler.optionalbrace.style;

import org.apache.poi.xwpf.usermodel.BodyType;
import org.dom4j.Element;
import org.example.parser.common.MyParser;
import org.example.style.rule.StyleContext;
import org.example.styler.format.newline.bodylayout.BodySizeType;
import org.example.styler.format.newline.bodylayout.BodyTypeEnum;

import java.util.Objects;

public class OptionalBraceContext extends StyleContext {
    public BodyTypeEnum bodyType;
    public BodySizeType bodySizeType;
    public boolean hasRightNeighbour;

    public OptionalBraceContext() {}

    public OptionalBraceContext(BodyTypeEnum bodyType, BodySizeType bodySizeType, boolean hasRightNeighbour) {
        this.bodyType = bodyType;
        this.bodySizeType = bodySizeType;
        this.hasRightNeighbour = hasRightNeighbour;
    }



    @Override
    public void addElement(Element parent, MyParser parser) {
        parent.addAttribute("bodyType", bodyType.name());
        parent.addAttribute("bodySize", bodySizeType.name());
        parent.addAttribute("hasRightNeighbour", String.valueOf(hasRightNeighbour));
    }

    @Override
    public void parseElement(Element parent, MyParser parser) {
        bodyType = BodyTypeEnum.valueOf(parent.attributeValue("bodyType"));
        bodySizeType = BodySizeType.valueOf(parent.attributeValue("bodySize"));
        hasRightNeighbour = Boolean.parseBoolean(parent.attributeValue("hasRightNeighbour"));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OptionalBraceContext context = (OptionalBraceContext) o;
        return hasRightNeighbour == context.hasRightNeighbour && bodyType == context.bodyType && bodySizeType == context.bodySizeType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(bodyType, bodySizeType, hasRightNeighbour);
    }
}
