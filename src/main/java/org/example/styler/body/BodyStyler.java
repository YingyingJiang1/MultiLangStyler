package org.example.styler.body;

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.example.parser.common.MyParser;
import org.example.parser.common.context.ExtendContext;
import org.example.styler.Styler;

import java.util.*;

import static org.example.styler.body.BodyTypeEnum.*;

public abstract class BodyStyler extends Styler {
    private static Map<BodyTypeEnum, Set<Integer>> map = null;
    private static Class<? extends MyParser> parserClass = null;

    public BodyStyler() {}

    public BodyStyler(boolean executeWhenExit) {
        super(executeWhenExit);
        style.setStyleName("body_styler");
    }

    /**
     *
     * @param stmt
     * @param body body(a specific statement) of stmt.
     * @return
     */
    protected BodyContext extractStyleContext(ExtendContext stmt, ParseTree body, MyParser parser) {
        BodyTypeEnum blockType = getBodyType(parser.getSpecificStmtType(stmt), parser);
        BodyNumType bodyNum = body instanceof TerminalNode ? BodyNumType.EMPTY : getBodyNumType(parser.getSpecificStmt((ExtendContext) body), parser);
        return new BodyContext(blockType,bodyNum);
    }

    public BodyTypeEnum getBodyType(int rule, MyParser parser) {
        init(parser);
        for (Map.Entry<BodyTypeEnum, Set<Integer>> entry : map.entrySet()) {
            if (entry.getValue().contains(rule)) {
                return entry.getKey();
            }
        }
        return BodyTypeEnum.NORMAL_BODY;
    }

    private void init(MyParser parser) {
        if (parserClass == null || parserClass != parser.getClass()) {
            parserClass = parser.getClass();
            map = new HashMap<>();
            map.put(BodyTypeEnum.DEC_BODY, new HashSet<>(List.of(
                    parser.getRuleConstructorDeclaration(),
                    parser.getRuleMethodDeclaration(),
                    parser.getRuleTypeDeclaration()
            )));
            map.put(MULTI_BLOCK_STMT_BODY, new HashSet<>(List.of(
                    parser.getRuleIfElseStmt(),
                    parser.getRuleTryCatchStmt()
            )));
            map.put(ARRAY_INITIALIZER_BODY, parser.getArrayInitializerRules());
            map.put(BodyTypeEnum.DO_WHILE_BODY, Set.of(parser.getRuleDoWhileStmt()));
        }
    }


    /**
     * @param ctx @BodyContext or @BlockContext instance.
     * @return
     * @implNote If @ctx is a @BodyContext instance, then only empty or non-empty body is concerned about.
     * If @ctx is a @BlockContext instance, then empty block, one single statement block or multiple statements block
     * is concerned about.
     */
    private BodyNumType getBodyNumType(ExtendContext ctx, MyParser parser) {
        if (parser.isBody(ctx)) {
            return ctx.getAllContextsIf(child -> child != null).isEmpty() ? BodyNumType.EMPTY : BodyNumType.MULTI;
        } else {
            List<ExtendContext> stmts = ctx.getAllContextsIf(parser::isStatement); // Exclude LBRACE and RBRACE.
            int stmtNum = stmts.size();
            if (stmtNum == 0) {
                return BodyNumType.EMPTY;
            } else if(stmtNum == 1 && parser.belongToSingleStmt(parser.getSpecificStmt(stmts.get(0)))) {
                return BodyNumType.SINGLE;
            } else {
                return BodyNumType.MULTI;
            }
        }
    }

}
