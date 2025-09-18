package org.example.styler.optionalbrace;

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.example.RunStatistic;
import org.example.parser.common.MyParser;
import org.example.parser.common.context.ExtendContext;
import org.example.parser.common.factory.TreeNodeFactoryGetter;
import org.example.parser.common.factory.context.TreeNodeFactory;
import org.example.parser.common.token.ExtendToken;
import org.example.styler.format.newline.bodylayout.BodySizeType;
import org.example.styler.format.newline.bodylayout.BodyStyler;
import org.example.styler.format.newline.bodylayout.style.BodyContext;
import org.example.styler.optionalbrace.style.OptionalBraceContext;
import org.example.styler.optionalbrace.style.OptionalBraceProperty;
import org.example.styler.optionalbrace.style.OptionalBraceStyle;
import org.example.utils.ParseTreeUtil;

import java.util.*;
import java.util.ArrayList;

public class OptionalBraceStyler extends BodyStyler {
    private static Set<Integer> relevantRules = null;

    public OptionalBraceStyler() {
        style = new OptionalBraceStyle();
    }

    @Override
    public void extractStyle(ExtendContext ctx, MyParser parser) {
        List<ExtendContext> bodyNodes = getBodyNodes(ctx, parser);
        ExtendContext typeNode = parser.getSpecificStmt(ctx);
        for (ExtendContext bodyNode : bodyNodes) {
            OptionalBraceContext context = extractContext(bodyNode, typeNode, parser);
            OptionalBraceProperty property = extractProperty(bodyNode, parser);

            if (isBraceOptional(context)) {
                style.addRule(context, property);

            }
        }
    }

    private boolean isBraceOptional(OptionalBraceContext context) {
        return context.bodySizeType == BodySizeType.ONE_SINGLE_STMT || context.bodySizeType == BodySizeType.EMPTY;
    }

    private OptionalBraceContext extractContext(ExtendContext bodyNode, ExtendContext typeNode, MyParser parser) {
        BodyContext bodyContext = extractBodyContext(bodyNode, typeNode, parser);
        return new OptionalBraceContext(bodyContext.bodyType, bodyContext.bodySizeType, bodyContext.hasRightNeighbour);
    }

    private OptionalBraceProperty extractProperty(ExtendContext bodyNode, MyParser parser) {
        int subStmt = parser.getSpecificStmtType(bodyNode);
        boolean useBrace = subStmt == parser.getRuleBlock();
        return new OptionalBraceProperty(useBrace);
    }

    @Override
    public ExtendContext applyStyle(ExtendContext ctx, MyParser parser) {
        ExtendContext typeNode = parser.getSpecificStmt(ctx);
        List<ExtendContext> bodyNodes = getBodyNodes(typeNode, parser);
        for (ExtendContext body : bodyNodes) {
            OptionalBraceContext optionalBraceContext = extractContext(body, typeNode, parser);
            OptionalBraceProperty property = extractProperty(body, parser);
            if (style.getProperty(optionalBraceContext) instanceof OptionalBraceProperty targetProperty
            && !targetProperty.equals(property)) {
                ExtendContext specificBody = parser.getSpecificStmt(body);
                if (targetProperty.useBrace && !parser.isBlock(specificBody)) {
                    // Add {}
//                    TreeNodeFactory factory = TreeNodeFactoryGetter.getFactory(parser);
//                    ExtendContext block = factory.createBlock((ExtendContext) body.getParent());
                    ExtendContext bracedBody = ParseTreeUtil.getInstance().encapsulateStmtWithBrace(body, parser);
//                    TerminalNode lb = factory.createTerminal(parser.getTokenFactory().create(parser.getLBrace(), "{"));
//                    TerminalNode rb = factory.createTerminal(parser.getTokenFactory().create(parser.getRBrace(), "}"));
//                    List<ParseTree> children = new ArrayList<>();
//                    children.add(lb);
//                    children.add(body);
//                    children.add(rb);
//                    block.addChildren(children);
                    typeNode.replaceChild(body, bracedBody);

                    RunStatistic.addTriggeredStyle(parser.getSourceFile(), style.getStyleName());
                } else if (!targetProperty.useBrace) {
                    // Removing {} happens when the bodyNumType is EMPTY or SINGLE. Otherwise, it may cause an error.
                    boolean isBraceRemovable = parser.isBlock(specificBody) &&
                            (optionalBraceContext.bodySizeType == BodySizeType.EMPTY
                                    || optionalBraceContext.bodySizeType == BodySizeType.ONE_SINGLE_STMT);
                    if (isBraceRemovable) {
                        ExtendContext innerStmt = specificBody.getFirstCtxChildIf(t -> true);
                        // 添加空语句
                        if (innerStmt == null) {
                            TreeNodeFactory factory = parser.getTreeNodeFactory();
                            innerStmt = factory.createStatement(ctx);
                            ExtendToken semiToken = parser.getTokenFactory().create(parser.getSemi(), ";");
                            semiToken.addTokenAfter(parser.getTokenFactory().create(parser.getVws(), "\n"), parser);
                            innerStmt.addChild(factory.createTerminal(semiToken));
                        }
                        ctx.replaceChild(body, innerStmt);

                        RunStatistic.addTriggeredStyle(parser.getSourceFile(), style.getStyleName());
                    }
                }
            }
        }

        return ctx;
    }

    @Override
    protected List<ExtendContext> getBodyNodes(ExtendContext typeNode, MyParser parser) {
        List<ExtendContext> bodies = new ArrayList<>();
        for (ParseTree child : typeNode.children) {
            if (parser.isBlock(child) || parser.isBody(child) || parser.isStatement(child) || parser.isCatchClause(child)) {
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
