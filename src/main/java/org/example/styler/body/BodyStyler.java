package org.example.styler.body;

import org.example.parser.common.ExtendContext;
import org.example.styler.Styler;

public abstract class BodyStyler extends Styler {
    public BodyStyler() {}

    public BodyStyler(boolean executeWhenExit) {
        super(executeWhenExit);
        style.setStyleName("body_styler");
    }

    /**
     *
     * @param stmt Statement context which the block belongs to.
     * @param block Block context.
     * @return
     */
    protected BodyContext extractStyleContext(ExtendContext stmt, ExtendContext block) {
        BodyTypeEnum blockType = BodyTypeEnum.getBlockType(stmt.getRuleIndex(), parser);
        return new BodyContext(blockType, getBodyType(block));
    }


    /**
     * @param ctx @BodyContext or @BlockContext instance.
     * @return
     * @implNote If @ctx is a @BodyContext instance, then only empty or non-empty body is concerned about.
     * If @ctx is a @BlockContext instance, then empty block, one single statement block or multiple statements block
     * is concerned about.
     */
    private BodyNumType getBodyType(ExtendContext ctx) {
        int stmtNum = ctx.countChildIf(child -> child instanceof ExtendContext); // Exclude LBRACE and RBRACE.
        if (stmtNum == 0) {
            return BodyNumType.EMPTY;
        } else if(stmtNum == 1 && parser.belongToSingleStmt(ctx.getFirstCtxChildIf(child -> true))) {
            return BodyNumType.SINGLE;
        } else {
            return BodyNumType.MULTI;
        }
    }

}
