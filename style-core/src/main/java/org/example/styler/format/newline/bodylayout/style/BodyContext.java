package org.example.styler.format.newline.bodylayout.style;

import org.dom4j.Element;
import org.example.parser.common.MyParser;
import org.example.style.rule.StyleContext;
import org.example.styler.format.newline.bodylayout.BodySizeType;
import org.example.styler.format.newline.bodylayout.BodyTypeEnum;

import java.util.Objects;

public class BodyContext extends StyleContext {
    public BodyTypeEnum bodyType;
    public BodySizeType bodySizeType;
    public boolean hasLeftNeighbour;
    public boolean hasRightNeighbour;
    public boolean hasBrace;

    public BodyContext() {}

    public BodyContext(BodyTypeEnum bodyType, BodySizeType bodySizeType,
                       boolean hasLeftNeighbour, boolean hasRightNeighbour, boolean hasBrace) {
        this.bodyType = bodyType;
        this.bodySizeType = bodySizeType;
        this.hasLeftNeighbour = hasLeftNeighbour;
        this.hasRightNeighbour = hasRightNeighbour;
        this.hasBrace = hasBrace;
    }


    @Override
    public void addElement(Element parent, MyParser parser) {
        parent.addElement("bodyType").addText(bodyType.name());
        parent.addElement("bodySize").addText(bodySizeType.name());
        parent.addElement("hasLeftNeighbour").addText(String.valueOf(hasLeftNeighbour));
        parent.addElement("hasRightNeighbour").addText(String.valueOf(hasRightNeighbour));
        parent.addElement("hasBrace").addText(String.valueOf(hasBrace));
    }

    @Override
    public void parseElement(Element parent, MyParser parser) {
        bodyType = BodyTypeEnum.valueOf(parent.element("bodyType").getText().toUpperCase());
        bodySizeType = BodySizeType.valueOf(parent.element("bodySize").getText().toUpperCase());
        hasLeftNeighbour = Boolean.parseBoolean(parent.element("hasLeftNeighbour").getText());
        hasRightNeighbour = Boolean.parseBoolean(parent.element("hasRightNeighbour").getText());
        hasBrace = Boolean.parseBoolean(parent.element("hasBrace").getText());
    }

    @Override
    public int hashCode() {
        return Objects.hash(bodyType, bodySizeType, hasLeftNeighbour, hasRightNeighbour, hasBrace);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof BodyContext context) {
            return bodyType.equals(context.bodyType) && bodySizeType.equals(context.bodySizeType)
                    && hasLeftNeighbour == context.hasLeftNeighbour
                    && hasRightNeighbour == context.hasRightNeighbour
                    && hasBrace == context.hasBrace;
        }
        return false;
    }
}
