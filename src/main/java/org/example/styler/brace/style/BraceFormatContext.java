package org.example.styler.brace.style;

import org.antlr.v4.runtime.Parser;
import org.dom4j.Element;
import org.example.interfaces.StyleContext;

public class BraceFormatContext extends StyleContext {
    private TypeEnum blockType;
    private int stmtNumInBlock; // 0:empty block, 1: only one single statement in block, 2: one single block statement or exceed one statement.

    public BraceFormatContext() {}

    public BraceFormatContext(TypeEnum blockType, int stmtNum) {
        this.blockType = blockType;
        this.stmtNumInBlock = stmtNum;
    }

    public int calculateDis(StyleContext context) {
        BraceFormatContext braceContext = (BraceFormatContext) context;
        if(this.equals(braceContext)) {
            return 0;
        }
        int typeDis = blockType == braceContext.blockType ? 0 : 1;
        return typeDis + Math.abs(stmtNumInBlock - braceContext.stmtNumInBlock);
    }


    @Override
    public void addElement(Element parent, Parser parser) {
        Element braceInfoEle = parent.addElement("brace_info");
        braceInfoEle.addElement("block_type").addText(blockType.name());
        Element stmtNumEle = braceInfoEle.addElement("number_of_stmt");
        if(stmtNumInBlock < 2) {
            stmtNumEle.addText(Integer.toString(stmtNumInBlock));
        } else {
            stmtNumEle.addText("exceed 1");
        }
    }

    @Override
    public BraceFormatContext parseElement(Element parent, Parser parser) {
        BraceFormatContext context = new BraceFormatContext();
        context.blockType = TypeEnum.valueOf(parent.element("block_type").getText());
        Element stmtNumEle = parent.element("number_of_stmt");
        String stmtNumText = stmtNumEle.getText();
        if(stmtNumText.equals("exceed 1")) {
            context.stmtNumInBlock = 2;
        } else {
            context.stmtNumInBlock = Integer.parseInt(stmtNumText);
        }
        String[] arr = parent.element("line_break_info").getText().split("[(),]");
        return context;
    }


}
