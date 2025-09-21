package org.example.styler.format.newline.bodylayout;

import org.antlr.v4.runtime.tree.ParseTree;
import org.example.parser.common.MyParser;
import org.example.parser.common.context.ExtendContext;
import org.example.styler.Styler;
import org.example.styler.format.newline.bodylayout.style.BodyContext;
import org.slf4j.LoggerFactory;

import java.util.*;

import static org.example.styler.format.newline.bodylayout.BodyTypeEnum.*;

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
     * @param bodyNode block or body
     * @param typeNode declaration node or statement node
     * @param parser
     * @return
     */
    protected BodyContext extractBodyContext(ExtendContext bodyNode, ExtendContext typeNode, MyParser parser) {
        BodyTypeEnum bodyType = getBodyType(typeNode, parser);

        int bodyNodeIndex = typeNode.children.indexOf(bodyNode);
        BodySizeType bodySizeType = getBodySizeType(bodyNode, parser);
        if (bodySizeType == null) {
            return null;
        }
        boolean hasLeftNeighbour = false, hasRightNeighbour = false;
        if (bodyNodeIndex > 0) {
            hasLeftNeighbour = true; // has left neighbour
        }
        if (typeNode.getChildCount() - 1 > bodyNodeIndex) {
            hasRightNeighbour = true; // has right neighbour
        }
        boolean hasBrace = ! (parser.isStatement(bodyNode) && !parser.isBlock(parser.getSpecificStmt(bodyNode)));
        return new BodyContext(bodyType, bodySizeType, hasLeftNeighbour, hasRightNeighbour, hasBrace);
    }



    public BodyTypeEnum getBodyType(ExtendContext node, MyParser parser) {
        int rule = node.getRuleIndex();
        if (parser.getArrayInitializerRules().contains(rule)) {
            return ARRAY_INITIALIZER_BODY;
        } else if (rule == parser.getRuleMethodDeclaration() || rule == parser.getRuleConstructorDeclaration() || rule == parser.getRuleTypeDeclaration()) {
            return DEC_BODY;
        } else if (parser.isStatement(node) || parser.isStatement(node.getParent())) {
            return STMT_BODY;
        }
        return ANY_BODY;
    }

    /**
     *
     * @param typeNode declaration node or specific statement node
     * @param parser
     * @return a list of statement, block, body or array initializer
     */
    protected List<ExtendContext> getBodyNodes(ExtendContext typeNode, MyParser parser) {
        int ruleIndex = typeNode.getRuleIndex();
        List<ExtendContext> bodies = new ArrayList<>();

        // 特殊处理if-else, 如果最后一个stmt节点为if或者if-else类型，那么不属于当前语句的body
        if (typeNode.getRuleIndex() == parser.getRuleIfElseStmt()) {
            ExtendContext lastStmt = (ExtendContext) typeNode.getChild(typeNode.getChildCount() - 1);
            int rule = parser.getSpecificStmtType(lastStmt);
            if (rule == parser.getRuleIfStmt() || rule == parser.getRuleIfElseStmt()) {
                return List.of(typeNode.getFirstInnerChildByType(parser.getRuleStmt()));
            }
        }

        if (ruleIndex == parser.getRuleBody() ||
                ruleIndex == parser.getRuleArrayInitializer() || ruleIndex == parser.getRuleElementValueArrayInitializer()) {
            bodies.add(typeNode);
        }  else {
            for (ParseTree child : typeNode.children) {
                if (parser.isBlock(child) || parser.isBody(child) || parser.isStatement(child)) {
                    bodies.add((ExtendContext) child);
                }
            }
        }
        return bodies;
    }


    /**
     * @param body BodyContext or StatementContext or CatchClauseContext or FinallyBlockContext
     * @return
     * @implNote If `body` is a `BodyContext` instance, then only empty or non-empty body is concerned about.
     * If `body` is a `BlockContext` instance, then empty block, one single statement block or multiple statements block
     * is concerned about.
     */
    public BodySizeType getBodySizeType(ExtendContext body, MyParser parser) {
        if (parser.isBody(body)) {
            return body.getAllChildContextsIf(Objects::nonNull).isEmpty() ? BodySizeType.EMPTY : BodySizeType.MULTI_STMTS;
        } else {
            List<ExtendContext> stmts = null;
            ExtendContext specificNode = null;
            if (parser.isStatement(body)) {
                specificNode = parser.getSpecificStmt(body);
                if (parser.isStatement(specificNode)) { // 空语句
                    stmts = new ArrayList<>();
                } else if (parser.isBlock(specificNode)) {
                    stmts = specificNode.getAllChildContextsIf(parser::isStatement);
                } else {
                    stmts = List.of(specificNode);
                }
            } else if (parser.isBlock(body)) {
                stmts = body.getAllChildContextsIf(parser::isStatement);
            } else if (parser.getRuleArrayInitializer() == body.getRuleIndex() || parser.getRuleElementValueArrayInitializer() == body.getRuleIndex()) {
                stmts = body.getAllChildContextsIf(t -> true);
                return stmts.isEmpty() ? BodySizeType.EMPTY : stmts.size() == 1 ? BodySizeType.ONE_INITIALIZER : BodySizeType.MULTI_INITIALIZER;
            } else{
                specificNode = body.getFirstCtxChildIf(parser::isBlock);
                stmts = specificNode.getAllChildContextsIf(parser::isStatement);
            }



            int stmtNum = stmts.size();
            if (stmtNum == 0) {
                return BodySizeType.EMPTY;
            } else if(stmtNum == 1) {
                return parser.belongToSingleStmt(parser.getSpecificStmt(stmts.get(0))) ?  BodySizeType.ONE_SINGLE_STMT : BodySizeType.ONE_COMPOUND_STMT;
            } else {
                return BodySizeType.MULTI_STMTS;
            }
        }

    }

}
