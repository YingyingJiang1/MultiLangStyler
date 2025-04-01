package org.example.styler.declaration.layout;

import org.antlr.v4.runtime.tree.ParseTree;
import org.example.RunStatistic;
import org.example.parser.common.MyParser;
import org.example.parser.common.context.ExtendContext;
import org.example.parser.common.factory.ParseTreeUtil;
import org.example.parser.common.factory.TreeNodeFactoryGetter;
import org.example.parser.common.factory.context.TreeNodeFactory;
import org.example.parser.common.token.ExtendToken;
import org.example.style.rule.StyleProperty;
import org.example.style.rule.StyleRule;
import org.example.styler.Stage;
import org.example.styler.Styler;
import org.example.styler.declaration.layout.style.DeclarationLayoutContext;
import org.example.styler.declaration.layout.style.DeclarationLayoutProperty;
import org.example.styler.declaration.layout.style.DeclarationNumberStyle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DeclarationLayoutStyler extends Styler {
    private Map<DeclarationLayoutContext, Integer> maxLengthMap = new HashMap<>();

    public DeclarationLayoutStyler() {
        style = new DeclarationNumberStyle();
    }


    /**
     *
     * @param ctx Local variable declaration statement node or field declaration statement node.
     * @param parser
     */
    @Override
    public void extractStyle(ExtendContext ctx, MyParser parser) {
        ExtendContext declaratorsNode = ctx.getContextRecIf(parser::isVariableDeclarators);
        int decCount = (declaratorsNode.getChildCount() + 1) / 2;
        DeclarationLayoutContext context = extractContext(ctx, parser);

		maxLengthMap.merge(context, ctx.getText().length(), Math::max);
        if (decCount > 1) {
            style.addRule(context, new DeclarationLayoutProperty(decCount));
        } else {
            // Declare one variable in a declaration statement, we need to further check the next adjacent declaration
            // statement declares one variable of the same type.
            if (ctx.parent instanceof ExtendContext parentCtx) {
                int next = parentCtx.children.indexOf(ctx) + 1;
                if (next < parentCtx.getChildCount() && parentCtx.children.get(next) instanceof ExtendContext nextDecStmt) {
                    if (!parser.belongToVarDeclarationStmt(nextDecStmt.getRuleIndex())) {
                        return;
                    }
                    if (extractContext(nextDecStmt, parser).equals(context)) {
                        ExtendContext nextDeclarators = nextDecStmt.getContextRecIf(parser::isVariableDeclarators);
                        int variableCount = (nextDeclarators.getChildCount() + 1)/2;
                        if (variableCount == 1 && hasSameDeclarationPrefix(declaratorsNode, nextDeclarators, parser)) {
                            style.addRule(context, new DeclarationLayoutProperty(1));
                        }
                    }
                }
            }
        }
    }

    @Override
    public ExtendContext applyStyle(ExtendContext ctx, MyParser parser) {
        DeclarationLayoutContext context = extractContext(ctx, parser);
        StyleProperty styleProperty = style.getProperty(context);
        ExtendContext declaratorsNode = ctx.getContextRecIf(parser::isVariableDeclarators);
        int decCount = (declaratorsNode.getChildCount() + 1) / 2;

        if (styleProperty instanceof DeclarationLayoutProperty property) {
            if (decCount > 1 && property.maxVariableCount == 1) {
                splitDeclarations(ctx, parser);
            } else if (property.maxVariableCount > 1) {
                mergeDeclarations(ctx, parser, context, property);
            }
        }
        return ctx;
    }


    @Override
    public boolean isRelevant(ExtendContext ctx, Stage stage, MyParser parser) {
        return parser.isLocalVarDeclarationStmt(ctx) || parser.isFieldDeclaration(ctx);
    }

    @Override
    public void extractFinalize() {
        super.extractFinalize();
        for (StyleRule rule : style.getRules()) {
            Integer maxLength = maxLengthMap.get(rule.getStyleContext());
            if (maxLength != null && rule.getStyleProperty() instanceof DeclarationLayoutProperty property) {
                property.maxLength = maxLength;
            }
        }
    }

    private DeclarationLayoutContext extractContext(ExtendContext ctx, MyParser parser) {
        ExtendToken extStart = (ExtendToken) ctx.start;
        ExtendToken extStop = (ExtendToken) ctx.stop;
        boolean hasComment = extStart.hasContextTokens(parser::belongToComment) || extStop.hasContextTokens(parser::belongToComment);
        return new DeclarationLayoutContext(hasComment);
    }

    private boolean hasSameDeclarationPrefix(ExtendContext declarators1, ExtendContext declarators2, MyParser parser) {
        ExtendContext parent1 = (ExtendContext) declarators1.parent;
        ExtendContext parent2 = (ExtendContext) declarators2.parent;
        StringBuilder str1 = new StringBuilder();
        StringBuilder str2 = new StringBuilder();
        parent1.children.subList(0, parent1.children.indexOf(declarators1))
                .forEach(p -> str1.append(p.getText()));
        parent2.children.subList(0, parent2.children.indexOf(declarators2))
                .forEach(p -> str2.append(p.getText()));
        return str1.toString().contentEquals(str2);
    }

    /**
     * Split declarations of the same type and style context.
     * @param ctx Local variable declaration statement node or field declaration statement node.
     * @param parser
     */
    private void splitDeclarations(ExtendContext ctx, MyParser parser) {
        ExtendContext declaratorsNode = ctx.getContextRecIf(parser::isVariableDeclarators);

        // Clear declarators.
        List<ParseTree> declaratorList = declaratorsNode.children.stream().filter(t -> t instanceof ExtendContext).toList();
        declaratorsNode.children = new ArrayList<ParseTree>();

        // Copy declaration statement with an empty declarators.
        ParseTreeUtil factory = ParseTreeUtil.getInstance();
        List<ParseTree> declarationStmtList = new ArrayList<>();
        declarationStmtList.add(ctx);
        for (int i = 0; i < declaratorList.size() - 1; i++) {
            ExtendContext decStmtCopy = (ExtendContext) factory.copyTree(ctx, false);
            declarationStmtList.add(decStmtCopy);
        }

        // Add a child for declarators in each declaration statement.
        for (int i = 0; i < declaratorList.size(); i++) {
            ExtendContext curDecStmt = (ExtendContext) declarationStmtList.get(i);
            ExtendContext curDeclarators = getDeclarators(curDecStmt, parser);
            curDeclarators.addChild(declaratorList.get(i));
        }

        // Replace the old declaration statement with multiple statements.
        ExtendContext blockContainer = getBlockContainer(ctx, parser);
        int index = blockContainer.indexOfFirstChild(child -> child instanceof  ExtendContext childCtx && parser.getSpecificStmt(childCtx) == parser.getSpecificStmt(ctx));
        blockContainer.replaceChildren(index, index + 1, declarationStmtList);

        RunStatistic.hit(this.getClass());
    }


    /**
     * Merge declarations of the same type and style context.
     */
    private void mergeDeclarations(ExtendContext decStmt, MyParser parser,
                                   DeclarationLayoutContext styleContext, DeclarationLayoutProperty property) {
        ExtendContext declaratorsNode = decStmt.getContextRecIf(parser::isVariableDeclarators);
        int decCount = (declaratorsNode.getChildCount() + 1) / 2;
        int curLength = decStmt.getText().length();

        ExtendContext blockContainer = getBlockContainer(decStmt, parser);
        int curIndex = blockContainer.indexOfFirstChild(child -> child instanceof  ExtendContext childCtx && parser.getSpecificStmt(childCtx) == parser.getSpecificStmt(decStmt));
        int nextIndex = curIndex + 1;
        ExtendToken comma = (ExtendToken) parser.getTokenFactory().create(parser.getComma(), ",");
        TreeNodeFactory treeFactory = TreeNodeFactoryGetter.getFactory(parser);
        List<ParseTree> tobeAdded = new ArrayList<>();

        // Collect the variables to be merged.
        while (nextIndex < blockContainer.getChildCount()) {
            if (blockContainer.getChild(nextIndex) instanceof ExtendContext nextStmt) {
                ExtendContext nextSpecificStmt = parser.getSpecificStmt(nextStmt);
                boolean isNextDeclarationMergable = (parser.isLocalVarDeclarationStmt(nextSpecificStmt) || parser.isFieldDeclaration(nextSpecificStmt))
                        && extractContext(nextSpecificStmt, parser).equals(styleContext);
                if (isNextDeclarationMergable) {
                    ExtendContext declaratorsOfNext = nextStmt.getContextRecIf(parser::isVariableDeclarators);
                    decCount += (declaratorsOfNext.getChildCount() + 1) / 2;
                    curLength += declaratorsOfNext.getText().length() + 1;
                    if (!hasSameDeclarationPrefix(declaratorsNode, declaratorsOfNext, parser) ||
                            decCount > property.maxVariableCount || curLength > property.maxLength) {
                        break;
                    }
                    tobeAdded.add(treeFactory.createTerminal(comma.clone()));
                    tobeAdded.addAll(declaratorsOfNext.children);
                    ++nextIndex;
                } else {
                    break;
                }
            } else {
                break;
            }
        }

        // Modify the ast structure.
        if (!tobeAdded.isEmpty()) {
            declaratorsNode.addChildren(tobeAdded);
            blockContainer.children.removeAll(blockContainer.children.subList(curIndex + 1, nextIndex));
        }

        RunStatistic.hit(this.getClass());
    }


    private ExtendContext getDeclarators(ExtendContext decStmt, MyParser parser) {
        ExtendContext declarators = decStmt.getFirstCtxChildIf(parser::isVariableDeclarators);
        if (declarators == null) {
            // decStmt is local declaration statement.
            return ((ExtendContext)decStmt.getChild(0)).getFirstCtxChildIf(parser::isVariableDeclarators);
        }
        return declarators;
    }

    private ExtendContext getBlockContainer(ExtendContext ctx, MyParser parser) {
        return ctx.getFirstParentIf(t -> parser.isBlock(t) || parser.isBody(t));
    }

}
