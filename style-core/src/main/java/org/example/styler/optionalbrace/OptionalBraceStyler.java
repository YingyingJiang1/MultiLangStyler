package org.example.styler.optionalbrace;

import org.antlr.v4.runtime.tree.ParseTree;
import org.example.lang.LangAdapterCreator;
import org.example.lang.intf.MyParser;
import org.example.antlr.common.context.ExtendContext;
import org.example.style.InconsistencyInfo;
import org.example.style.codecontext.ASTBasedCodeContext;
import org.example.style.codecontext.CodeContext;
import org.example.style.rule.StyleContext;
import org.example.style.rule.StyleProperty;
import org.example.styler.InconsistencyInfoGenerator;
import org.example.styler.format.newline.bodylayout.BodySizeType;
import org.example.styler.format.newline.bodylayout.BodyStyler;
import org.example.styler.format.newline.bodylayout.style.BodyContext;
import org.example.styler.optionalbrace.style.OptionalBraceContext;
import org.example.styler.optionalbrace.style.OptionalBraceProperty;
import org.example.styler.optionalbrace.style.OptionalBraceStyle;

import java.util.*;
import java.util.ArrayList;

public class OptionalBraceStyler extends BodyStyler {
    private static Set<Integer> relevantRules = null;

    public OptionalBraceStyler() {
        style = new OptionalBraceStyle();
    }

    @Override
    protected List<CodeContext> constructCodeContext(ExtendContext ctx, MyParser parser) {
        List<ExtendContext> bodyNodes = getBodyNodes(ctx, parser);
        List<CodeContext> codeContexts = new ArrayList<>();
        for (ExtendContext bodyNode : bodyNodes) {
            codeContexts.add(new ASTBasedCodeContext(bodyNode));
        }
        return codeContexts;
    }

    @Override
    protected StyleContext extractStyleContext(CodeContext codeContext, MyParser parser) {
        ExtendContext bodyNode = ((ASTBasedCodeContext) codeContext).getContextNode();
        ExtendContext typeNode = (ExtendContext) bodyNode.getParent();
        BodyContext bodyContext = extractBodyContext(bodyNode, typeNode, parser);
        return new OptionalBraceContext(bodyContext.bodyType, bodyContext.bodySizeType, bodyContext.hasRightNeighbour);
    }

    @Override
    protected StyleProperty extractStyleProperty(CodeContext codeContext, MyParser parser) {
        ExtendContext bodyNode = ((ASTBasedCodeContext) codeContext).getContextNode();
        int subStmt = parser.getSpecificStmtType(bodyNode);
        boolean useBrace = subStmt == parser.getRuleBlock();
        return new OptionalBraceProperty(useBrace);
    }

    @Override
    protected InconsistencyInfo generateInconsistencyInfo(CodeContext codeContext, StyleContext styleContext, StyleProperty currentProperty,
                                                          StyleProperty targetProperty, MyParser parser) {
        if (codeContext instanceof ASTBasedCodeContext nodeContext &&
                styleContext instanceof OptionalBraceContext optionalBraceContext
                && currentProperty instanceof OptionalBraceProperty current
                && targetProperty instanceof OptionalBraceProperty target) {
            ExtendContext body = nodeContext.getContextNode();
            ExtendContext specificBody = parser.getSpecificStmt(body);
            if (target.useBrace && !parser.isBlock(specificBody)) {
                return InconsistencyInfoGenerator.generateForOptionalBrace(nodeContext,
                        optionalBraceContext, current, target);
            } else if (!target.useBrace) {
                boolean isBraceRemovable = parser.isBlock(specificBody) &&
                        (optionalBraceContext.bodySizeType == BodySizeType.EMPTY
                                || optionalBraceContext.bodySizeType == BodySizeType.ONE_SINGLE_STMT);
                if (isBraceRemovable) {
                    return InconsistencyInfoGenerator.generateForOptionalBrace(nodeContext, optionalBraceContext, current, target);
                }
            }
        }
        return null;
    }

    @Override
    protected ExtendContext doApply(CodeContext codeContext, StyleProperty currentProperty,
                                    StyleProperty targetProperty, MyParser parser) {
        if (codeContext instanceof ASTBasedCodeContext nodeContext &&
                currentProperty instanceof OptionalBraceProperty current && targetProperty instanceof OptionalBraceProperty target) {
            ExtendContext body = nodeContext.getContextNode();
            ExtendContext typeNode = (ExtendContext) body.getParent();
            ExtendContext specificBody = parser.getSpecificStmt(body);
            if (target.useBrace && !parser.isBlock(specificBody)) {
                // Add {}
                ExtendContext bracedBody = LangAdapterCreator.createASTRewriter(parser.getLanguage()).encapsulateStmtWithBrace(body, parser);
                typeNode.replaceChild(body, bracedBody);

            } else if (!target.useBrace) {
                OptionalBraceContext optionalBraceContext = (OptionalBraceContext) extractStyleContext(codeContext, parser);
                boolean isBraceRemovable = parser.isBlock(specificBody) &&
                        (optionalBraceContext.bodySizeType == BodySizeType.EMPTY
                                || optionalBraceContext.bodySizeType == BodySizeType.ONE_SINGLE_STMT);
                if (isBraceRemovable) {
                    ExtendContext innerStmt = LangAdapterCreator.createASTRewriter(parser.getLanguage()).removeBraceOfStmt(body, parser);
                    nodeContext.getSourceNode().replaceChild(body, innerStmt);
                }
            }
        }
        return null;
    }



    @Override
    protected boolean testStyleContext(StyleContext context) {
        return isBraceOptional((OptionalBraceContext) context);
    }

    private boolean isBraceOptional(OptionalBraceContext context) {
        return context.bodySizeType == BodySizeType.ONE_SINGLE_STMT
                || context.bodySizeType == BodySizeType.EMPTY
                || context.bodySizeType == BodySizeType.ONE_COMPOUND_STMT;
    }



    /**
     *
     * @param typeNode a specific statement node
     * @param parser
     * @return
     */
    @Override
    protected List<ExtendContext> getBodyNodes(ExtendContext typeNode, MyParser parser) {
        List<ExtendContext> bodies = new ArrayList<>();

        // 特殊处理if-else, 如果最后一个stmt节点为if或者if-else类型，那么不属于当前语句的body
        if (typeNode.getRuleIndex() == parser.getRuleIfElseStmt()) {
            ExtendContext lastStmt = (ExtendContext) typeNode.getChild(typeNode.getChildCount() - 1);
            int rule = parser.getSpecificStmtType(lastStmt);
            if (rule == parser.getRuleIfStmt() || rule == parser.getRuleIfElseStmt()) {
                return List.of(typeNode.getFirstInnerChildByType(parser.getRuleStmt()));
            }
        }

        for (ParseTree child : typeNode.children) {
            if (parser.isBlock(child) || parser.isBody(child) || parser.isStatement(child)) {
                bodies.add((ExtendContext) child);
            }
        }
        return bodies;
    }

    @Override
    protected Set<Integer> getRelevantRules(MyParser parser) {
        if (relevantRules == null) {
            relevantRules = new HashSet<>(List.of(
                    parser.getRuleIfElseStmt(), parser.getRuleIfStmt(), parser.getRuleWhileStmt(), parser.getRuleForStmt(),
                    parser.getRuleDoWhileStmt()
            ));
        }
        return relevantRules;
    }

}
