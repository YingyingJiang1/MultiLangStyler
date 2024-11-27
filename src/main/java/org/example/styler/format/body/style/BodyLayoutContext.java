package org.example.styler.format.body.style;

import org.dom4j.Element;
import org.example.parser.common.MyParser;
import org.example.style.rule.StyleContext;

public class BodyLayoutContext extends StyleContext {
    public TypeEnum blockType;
    public BodyType bodyType;

    public BodyLayoutContext() {}

    public BodyLayoutContext(TypeEnum blockType, BodyType bodyType) {
        this.blockType = blockType;
        this.bodyType = bodyType;
    }

//    public int calculateDis(StyleContext context) {
//        BodyLayoutContext braceContext = (BodyLayoutContext) context;
//        if(this.equals(braceContext)) {
//            return 0;
//        }
//        int typeDis = blockType == braceContext.blockType ? 0 : 1;
//        return typeDis + Math.abs(bodyType - braceContext.bodyType);
//    }


    @Override
    public void addElement(Element parent, MyParser parser) {
        parent.addElement("block_type").addText(blockType.name());
        parent.addElement("body_type").addText(bodyType.name());
    }

    @Override
    public void parseElement(Element parent, MyParser parser) {
        BodyLayoutContext context = new BodyLayoutContext();
        context.blockType = TypeEnum.valueOf(parent.element("block_type").getText().toUpperCase());
        context.bodyType = BodyType.valueOf(parent.element("body_type").getText().toUpperCase());
    }
}
