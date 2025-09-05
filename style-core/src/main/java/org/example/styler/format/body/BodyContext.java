package org.example.styler.format.body;

import org.dom4j.Element;
import org.example.parser.common.MyParser;
import org.example.style.rule.StyleContext;

import java.util.Objects;

public class BodyContext extends StyleContext {
    public BodyTypeEnum bodyType;
    public BodySizeType bodySizeType;

    public BodyContext() {}

    public BodyContext(BodyTypeEnum bodyType, BodySizeType bodySizeType) {
        this.bodyType = bodyType;
        this.bodySizeType = bodySizeType;
    }

    @Override
    public double calculateDistance(StyleContext targetContext) {
        int distance = INIT_DISTANCE;
        if (targetContext instanceof BodyContext context) {
            if (bodyType.equals(context.bodyType)) {
                distance -= context.DEC_WHEN_EQUAL;
            } else if (context.bodyType.equals(BodyTypeEnum.NORMAL_BODY) || bodyType.equals(BodyTypeEnum.NORMAL_BODY)) {
                distance -= context.DEC_WHEN_HIGH_SIMILAR;
            } else if (context.bodyType.equals(BodyTypeEnum.ANY_BODY) || bodyType.equals(BodyTypeEnum.ANY_BODY)) {
                distance -= context.DEC_WHEN_MIDDLE_SIMILAR;
            }

            boolean numMeet = bodySizeType.equals(context.bodySizeType) ||
                    bodySizeType.equals(BodySizeType.ANY) ||
                    context.bodySizeType.equals(BodySizeType.ANY);
            return numMeet && distance != INIT_DISTANCE ? distance : INVALID_DISTANCE;
        }

        return INVALID_DISTANCE;
    }

    @Override
    public void addElement(Element parent, MyParser parser) {
        parent.addElement("bodyType").addText(bodyType.name());
        parent.addElement("bodySize").addText(bodySizeType.name());
    }

    @Override
    public void parseElement(Element parent, MyParser parser) {
        bodyType = BodyTypeEnum.valueOf(parent.element("bodyType").getText().toUpperCase());
        bodySizeType = BodySizeType.valueOf(parent.element("bodySize").getText().toUpperCase());
    }

    @Override
    public int hashCode() {
        return Objects.hash(bodyType, bodySizeType);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof BodyContext context) {
            return bodyType.equals(context.bodyType) && bodySizeType.equals(context.bodySizeType);
        }
        return false;
    }
}
