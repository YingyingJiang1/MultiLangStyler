package org.example.styler.declaration.number;

import org.antlr.v4.runtime.tree.ParseTree;
import org.example.parser.common.MyParser;
import org.example.parser.common.context.ExtendContext;
import org.example.parser.common.factory.ParseTreeUtil;
import org.example.parser.common.factory.TreeNodeFactoryGetter;
import org.example.parser.common.factory.context.TreeNodeFactory;
import org.example.parser.common.token.ExtendToken;
import org.example.style.rule.StyleProperty;
import org.example.styler.Stage;
import org.example.styler.Styler;
import org.example.styler.declaration.number.style.DeclarationNumberContext;
import org.example.styler.declaration.number.style.DeclarationNumberProperty;
import org.example.styler.declaration.number.style.DeclarationNumberStyle;

import java.util.ArrayList;
import java.util.List;

public class DeclarationNumberStyler extends Styler {
    public DeclarationNumberStyler() {
        style = new DeclarationNumberStyle();
        style.setStyleName("declaration_number");
    }

    @Override
    public void extractStyle(ExtendContext ctx, MyParser parser) {
        ExtendContext decStmt = findDecStmt(ctx, parser);
        if (decStmt == null) {
            return;
        }

        int count = (ctx.getChildCount() + 1) / 2;
        DeclarationNumberContext context = extractContext(decStmt, parser);
        if (count > 1) {
            style.addRule(context, new DeclarationNumberProperty(count));
        } else {
            // Declare one variable in a declaration statement, we need to further check the next adjacent declaration
            // statement declares one variable of the same type.
            if (decStmt.parent instanceof ExtendContext parentCtx) {
                int next = parentCtx.children.indexOf(decStmt) + 1;
                if (next < parentCtx.getChildCount() && parentCtx.children.get(next) instanceof ExtendContext nextDecStmt) {
                    if (!parser.belongToVarDeclarationStmt(nextDecStmt.getRuleIndex())) {
                        return;
                    }
                    if (extractContext(nextDecStmt, parser).equals(context)) {
                        ExtendContext nextDeclarators = nextDecStmt.getContextRecIf(parser::isVariableDeclarators);
                        int variableCount = (nextDeclarators.getChildCount() + 1)/2;
                        if (variableCount == 1 && hasSameDeclarationPrefix(ctx, nextDeclarators, parser)) {
                            style.addRule(context, new DeclarationNumberProperty(1));
                        }
                    }
                }
            }
        }
    }

    @Override
    public ExtendContext applyStyle(ExtendContext ctx, MyParser parser) {
        ExtendContext decStmt = findDecStmt(ctx, parser);
        if (decStmt == null) {
            return ctx;
        }
        int count = (ctx.getChildCount() + 1) / 2;
        DeclarationNumberContext context = extractContext(decStmt, parser);
        StyleProperty styleProperty = style.getProperty(context);

        if (styleProperty instanceof DeclarationNumberProperty property) {
            if (count > 1 && property.maxVariableCount == 1) {
                splitDeclarations(ctx, parser);
            } else if (property.maxVariableCount > 1) {
                // Merge declarations of the same type and style context.
                ExtendContext parent = (ExtendContext) decStmt.parent;
                int nextIndex = parent.children.indexOf(decStmt) + 1;
                ExtendToken comma = (ExtendToken) parser.getTokenFactory().create(parser.getComma(), ",");
                TreeNodeFactory treeFactory = TreeNodeFactoryGetter.getFactory(parser);
                List<ParseTree> tobeAdded = new ArrayList<ParseTree>();
                while (nextIndex < parent.getChildCount()) {
                    if (parent.getChild(nextIndex) instanceof ExtendContext nextStmt
                            && parser.belongToVarDeclarationStmt(nextStmt.getRuleIndex())
                            && extractContext(nextStmt, parser).equals(context)) {
                        ExtendContext declaratorsOfNext = getDeclarators(nextStmt, parser);
                        count += (declaratorsOfNext.getChildCount() + 1) / 2;
                        if (count > property.maxVariableCount || !hasSameDeclarationPrefix(ctx, declaratorsOfNext, parser)) {
                            break;
                        }

                        tobeAdded.add(treeFactory.createTerminal(comma.clone()));
                        tobeAdded.addAll(declaratorsOfNext.children);
                        ++nextIndex;
                        continue;
                    }
                    break;
                }
                if (!tobeAdded.isEmpty()) {
                    ctx.addChildren(tobeAdded);
                    parent.children.removeAll(parent.children.subList(parent.children.indexOf(decStmt) + 1, nextIndex));
                }
            }
        }
        return ctx;
    }


    @Override
    public boolean isRelevant(ExtendContext ctx, Stage stage, MyParser parser) {
        int ruleIndex = ctx.getRuleIndex();
        return ruleIndex == parser.getRuleVariableDeclarators();
    }


    private DeclarationNumberContext extractContext(ExtendContext ctx, MyParser parser) {
        ExtendToken extStart = (ExtendToken) ctx.start;
        ExtendToken extStop = (ExtendToken) ctx.stop;
        boolean hasComment = extStart.hasContextTokens(parser::belongToComment) || extStop.hasContextTokens(parser::belongToComment);
        return new DeclarationNumberContext(hasComment);
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

    private void splitDeclarations(ExtendContext ctx, MyParser parser) {
        // Clear declarators.
        ExtendContext decStmt = findDecStmt(ctx, parser);
        if (decStmt == null) {
            return;
        }
        List<ParseTree> declaratorList = ctx.children.stream().filter(t -> t instanceof ExtendContext).toList();
        ctx.children = new ArrayList<ParseTree>();

        // Copy declaration statement with an empty declarators.
        ParseTreeUtil factory = ParseTreeUtil.getInstance();
        List<ParseTree> declarationStmtList = new ArrayList<>();
        declarationStmtList.add(decStmt);
        for (int i = 0; i < declaratorList.size() - 1; i++) {
            ExtendContext decStmtCopy = (ExtendContext) factory.copyTree(decStmt, false);
            declarationStmtList.add(decStmtCopy);
        }

        // Add a child for declarators in each declaration statement.
        for (int i = 0; i < declaratorList.size(); i++) {
            ExtendContext curDecStmt = (ExtendContext) declarationStmtList.get(i);
            ExtendContext curDeclarators = getDeclarators(curDecStmt, parser);
            curDeclarators.addChild(declaratorList.get(i));
        }

        // Replace the old declaration statement with multiple statements.
        ExtendContext parent = (ExtendContext) decStmt.parent;
        int index = parent.children.indexOf(decStmt);
        parent.replaceChildren(index, index + 1, declarationStmtList);
    }

    private ExtendContext findDecStmt(ExtendContext ctx, MyParser parser) {
        ExtendContext parent = (ExtendContext) ctx.parent;
        while (parent != null && !parser.belongToVarDeclarationStmt(parent.getRuleIndex())) {
            parent = (ExtendContext) parent.parent;
        }
        return parent;
    }

    private ExtendContext getDeclarators(ExtendContext decStmt, MyParser parser) {
        ExtendContext declarators = decStmt.getFirstCtxChildIf(parser::isVariableDeclarators);
        if (declarators == null) {
            // decStmt is local declaration statement.
            return ((ExtendContext)decStmt.getChild(0)).getFirstCtxChildIf(parser::isVariableDeclarators);
        }
        return declarators;
    }


}
