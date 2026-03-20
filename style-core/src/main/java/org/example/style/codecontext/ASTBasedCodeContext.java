package org.example.style.codecontext;

import org.example.antlr.common.context.ExtendContext;

public class ASTBasedCodeContext extends CodeContext{
    ExtendContext ctx;
        public ASTBasedCodeContext(ExtendContext ctx) {
            this.ctx = ctx;
             this.startLoc = new int[]{ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine()};
             this.endLoc = new int[]{ctx.getStop().getLine(), ctx.getStop().getCharPositionInLine() + ctx.getStop().getText().length()};
        }
}
