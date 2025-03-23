package org.example.styler.format.body;

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.example.parser.common.MyParser;
import org.example.parser.common.context.ExtendContext;
import org.example.styler.Styler;

import java.util.*;

import static org.example.styler.format.body.BodyTypeEnum.*;

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
    protected BodyContext extractStyleContext(ExtendContext stmt, ExtendContext body, MyParser parser) {
        BodyTypeEnum blockType = getBodyType(parser.getSpecificStmtType(stmt), parser);
        BodyNumType bodyNum = getBodyNumType(body, parser);
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
     * @param body
     * @return
     * @implNote If `body` is a `BodyContext` instance, then only empty or non-empty body is concerned about.
     * If `body` is a `BlockContext` instance, then empty block, one single statement block or multiple statements block
     * is concerned about.
     */
    private BodyNumType getBodyNumType(ExtendContext body, MyParser parser) {
        if (!parser.isBlock(body)) {
            return BodyNumType.SINGLE;
        } else {
            if (parser.isBody(body)) {
                return body.getAllContextsIf(Objects::nonNull).isEmpty() ? BodyNumType.EMPTY : BodyNumType.MULTI;
            } else {
                List<ExtendContext> stmts = body.getAllContextsIf(parser::isStatement); // Exclude LBRACE and RBRACE.
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

}
