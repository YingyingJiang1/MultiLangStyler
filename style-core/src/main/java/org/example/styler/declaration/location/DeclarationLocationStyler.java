package org.example.styler.declaration.location;

import org.antlr.v4.runtime.CommonToken;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.example.RunStatistic;
import org.example.global.GlobalInfo;
import org.example.parser.common.MyParser;
import org.example.parser.common.context.ExtendContext;
import org.example.semantic.SymbolTableManager;
import org.example.semantic.intf.Resolver;
import org.example.semantic.intf.symbol.Symbol;
import org.example.styler.Stage;
import org.example.styler.Styler;
import org.example.styler.declaration.location.style.DeclarationLocationProperty;
import org.example.styler.declaration.location.style.DeclarationLocationStyle;
import org.example.styler.naming.NameType;
import org.example.utils.searcher.intf.VarDeclarationSearcher;
import org.example.utils.searcher.intf.ExpressionSearcher;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class DeclarationLocationStyler extends Styler {
    public static double CLOSE_TO_FIRST_USE_THRESHOLD = 3.0;

    public DeclarationLocationStyler() {
        style = new DeclarationLocationStyle();
    }

    @Override
    public void extractStyle(ExtendContext ctx, MyParser parser) {
        List<Symbol> symbols = SymbolTableManager.getAllSymbols(parser);
        List<Integer> lineDistances = new ArrayList<>();
        if (symbols != null) {
            // Get line distances of all local variables.
            for (Symbol symbol : symbols) {
                if (symbol.getSymbolType() != NameType.LOCAL_VARIABLE) {
                    continue;
                }
                int lineDis = calculateLineDis2firstUse(symbol);
                if (lineDis >= 0) {
                    lineDistances.add(lineDis);
                }
            }

            // Generate the location property.
            if (!lineDistances.isEmpty()) {
                double avgLineDis = lineDistances.stream().mapToDouble(Integer::doubleValue).average().orElse(0.0);
                Location location = avgLineDis <= CLOSE_TO_FIRST_USE_THRESHOLD ? Location.NEAR_USE : Location.BLOCK_START;
                style.addRule(null, new DeclarationLocationProperty(avgLineDis, location));
            }
        }
    }

    @Override
    public ExtendContext applyStyle(ExtendContext ctx, MyParser parser) {
        if (style.getProperty(null) instanceof DeclarationLocationProperty property) {
            List<Symbol> symbols = SymbolTableManager.getAllSymbols(parser);
            if (symbols != null) {
                for (Symbol symbol : symbols) {
                    if (symbol.getSymbolType() != NameType.LOCAL_VARIABLE) {
                        continue;
                    }

                    ExtendContext decStmt = symbol.getDecIdentifierNode();
                    while (decStmt.getParent() != null && !parser.isLocalVarDeclarationStmt(decStmt)) {
                        decStmt = (ExtendContext) decStmt.getParent();
                    }
                    ExtendContext block = decStmt;
                    Predicate<ExtendContext> isScopeCtx = (ExtendContext cur) -> cur != null && (
                            parser.getSpecificStmtType(cur) == parser.getRuleBlock() || parser.belongToCompoundStmt(parser.getSpecificStmt(cur)));
                    while (block.getParent() != null && !isScopeCtx.test(block)) {
                        block = (ExtendContext) block.getParent();
                    }

                    // Apply rules after a second check.
                    if (parser.isLocalVarDeclarationStmt(decStmt) && isScopeCtx.test(block)) {
                        if (property.location == Location.NEAR_USE) {
                            moveToFirstUse(block, decStmt, parser);
                        } else if (property.location == Location.BLOCK_START) {
                            moveToBlockStart(block, decStmt, parser);
                        }
                    }
                }
            }
        }

        return ctx;
    }

    @Override
    public boolean isRelevant(ExtendContext ctx, Stage stage, MyParser parser) {
        return ctx.getRuleIndex() == parser.getRuleCompilationUnit();
    }

    private int calculateLineDis2firstUse(Symbol symbol) {
        Optional<ExtendContext> closedRef = symbol.getReferences().stream().min(Comparator.comparing(ref -> ref.getStart().getLine()));
        if (closedRef.isPresent()) {
            int lineDis = closedRef.get().getStart().getLine() - symbol.getDecIdentifierNode().getStart().getLine();
            return lineDis;
        }
        return -1;
    }

    /**
     * Check whether the first statement containing the @identifierNode is in the @stmts, if true then return the index of the statement, else return -1.
     * @param stmts
     * @param identifierNode a usage identifier node
     * @return index of stmt
     */
    private int indexOfContainerStmt(List<ParseTree> stmts, ExtendContext identifierNode) {
        if (stmts.isEmpty()) {
            return -1;
        }
        ParseTree parent = identifierNode.getParent();
        while (parent != null) {
            int index = stmts.indexOf(parent);
            if (index >= 0) {
                return index;
            }
            parent = parent.getParent();
        }
        return -1;
    }

    /**
     * @return Declaration statements initialized with a method or constructor are not allowed to move.
     * This is a safe but overly restrictive condition.
     */
    private boolean isMovable(ExtendContext decStmt, MyParser parser) {
        ExpressionSearcher searcher = GlobalInfo.getConf().getLanguageConfig().getNodeSearcherFactory().createExpressionSearcher();
        return searcher.searchFunctionCall(decStmt, parser) == null;
    }

    private int getForwardInsertionPoint(ExtendContext decStmt, ExtendContext block, MyParser parser) {
        VarDeclarationSearcher varDeclarationSearcher = GlobalInfo.getConf().getLanguageConfig().getNodeSearcherFactory().createVarDeclarationSearcher();
        List<ExtendContext> decIdentifiers = varDeclarationSearcher.searchIdentifiers(decStmt, parser);

        // Init insertion point with the next index of last variable declaration statement in the block start.
        int insetionPoint = 1;
        while (insetionPoint < block.getChildCount()) {
            boolean isDecStmt = block.getChild(insetionPoint) instanceof ExtendContext ctx && parser.isLocalVarDeclarationStmt(parser.getSpecificStmt(ctx));
            if (!isDecStmt) {
                break;
            }
            insetionPoint++;
        }


        for (ExtendContext decIdentifier : decIdentifiers) {
            ExtendContext initializer = varDeclarationSearcher.searchInitializerNode(decStmt, decIdentifier, parser);
            List<ExtendContext> usedNodes = initializer.getAllChildContextsIf(parser::isIdentifier); // The identifiers that the initializer depends on.
            Resolver resolver = GlobalInfo.getResolver();
            for (ExtendContext node : usedNodes) {
                Symbol symbol = resolver.resolve(node, parser);
                if (symbol == null) {
                    continue;
                }

                Optional<ExtendContext> closetRefNode = symbol.getReferences().stream().filter(t -> t.isDescendantOf(block))
                        .max(Comparator.comparing(e -> e.getStart().getLine()));
                if (closetRefNode.isPresent()) {
                    int index = indexOfContainerStmt(block.children, closetRefNode.get());
                    if (index >= 0 && index + 1 > insetionPoint) {
                        insetionPoint = index + 1;
                    }
                }

            }
        }

        return insetionPoint;
    }


    private int getBackwardInsertionPoint(ExtendContext decStmt, ExtendContext block, MyParser parser) {
        VarDeclarationSearcher varDeclarationSearcher = GlobalInfo.getConf().getLanguageConfig().getNodeSearcherFactory().createVarDeclarationSearcher();
        List<ExtendContext> decIdentifiers = varDeclarationSearcher.searchIdentifiers(decStmt, parser);
        Resolver resolver = GlobalInfo.getResolver();

        int insertionPoint = block.indexOfIf(t -> t instanceof ExtendContext ctx && parser.getSpecificStmt(ctx) == decStmt); // before }
        for (ExtendContext decIdentifier : decIdentifiers) {
            Symbol symbol = resolver.resolve(decIdentifier, parser);
            if (symbol == null) {
                continue;
            }
            Optional<ExtendContext> closetRefNode = symbol.getReferences().stream().filter(t -> t.isDescendantOf(block))
                    .min(Comparator.comparing(e -> e.getStart().getLine()));
            if (closetRefNode.isPresent()) {
                int index = indexOfContainerStmt(block.children, closetRefNode.get());
                if (index >= 0 && index < insertionPoint) {
                    insertionPoint = index;
                }
            }
        }
        return insertionPoint;
    }



    /**
     *
     * @param block The block that contains the declaration statement.
     * @param decStmt The declaration statement.
     * @param parser The parser.
     */
    private void moveToBlockStart(ExtendContext block, ExtendContext decStmt, MyParser parser) {
        if (!isMovable(decStmt, parser)) {
            return;
        }

        int currentIndex = block.indexOfFirstChild(t -> t instanceof ExtendContext ctxNode && parser.getSpecificStmt(ctxNode) == parser.getSpecificStmt(decStmt));
        int insertionPoint = getForwardInsertionPoint(decStmt, block, parser);

        if (insertionPoint < currentIndex) {
            block.children.remove(currentIndex);
            block.insertChild(insertionPoint, decStmt);
            updateCurrentLine(block, currentIndex, insertionPoint);

            RunStatistic.addTriggeredStyle(parser.getSourceFile(), style.getStyleName());
        }
    }


    /**
     *
     * @param block The block that contains the declaration statement.
     * @param decStmt The declaration statement.
     * @param parser The parser.
     */
    private void moveToFirstUse(ExtendContext block, ExtendContext decStmt, MyParser parser) {
        if (!isMovable(decStmt, parser)) {
            return;
        }

        int insertionPoint = getBackwardInsertionPoint(decStmt, block, parser); // Before } or before first usage.
        int currentIndex = block.indexOfFirstChild(t -> t instanceof ExtendContext ctxNode && parser.getSpecificStmt(ctxNode) == parser.getSpecificStmt(decStmt));

        if (insertionPoint > currentIndex) {
            block.insertChild(insertionPoint, block.getChild(currentIndex));
            block.children.remove(currentIndex);
            updateCurrentLine(block, currentIndex, insertionPoint - 1);

            RunStatistic.addTriggeredStyle(parser.getSourceFile(), style.getStyleName());
        }
    }


    /**
     *
     * @param block
     * @param usageStmt
     * @return The index of the statement in the block that contains the usage statement.
     */
    private int indexOf(ExtendContext block, ExtendContext usageStmt, MyParser parser) {
        int index = block.indexOfFirstChild(child -> child instanceof ExtendContext childCtx && parser.getSpecificStmt(childCtx) == parser.getSpecificStmt(usageStmt));
        if (index >= 0) {
            return index;
        }

        for (int i = 0; i < block.getChildCount(); i++) {
            if (block.getChild(i) instanceof ExtendContext stmt) {
                if (stmt.getAllCtxsRecIf(ctx -> ctx.getRuleIndex() == usageStmt.getRuleIndex()).contains(usageStmt)) {
                    return i;
                }
            }
        }

        return -1;
    }

    private void updateCurrentLine(ExtendContext block, int oldIndex, int newIndex) {
        ExtendContext stmt = (ExtendContext) block.getChild(newIndex);
        int sign = newIndex > oldIndex ? 1 : -1;

        // Update line number of all tokens in the statement.
        ParseTree next = block.getChild(Math.min(oldIndex + 1, newIndex - 1)), last = block.getChild(Math.max(oldIndex + 1, newIndex - 1));
        int nextLine = next instanceof TerminalNode ter ? ter.getSymbol().getLine() : ((ExtendContext) next).getStart().getLine();
        int lastLine = last instanceof TerminalNode ter ? ter.getSymbol().getLine() : ((ExtendContext) last).getStop().getLine();
        int targetStmtLineChange = lastLine - nextLine + 1;
        for (Token token : stmt.getAllTokensRec()) {
            ((CommonToken) token).setLine(token.getLine() + sign * targetStmtLineChange);
        }

        // Update line number of all tokens between @oldIndex and @newIndex.
        int lines = stmt.getStop().getLine() - stmt.getStart().getLine() + 1;
        for (int i = oldIndex; i != newIndex; i += sign) {
            ExtendContext curStmt = (ExtendContext) block.getChild(i);
            for (Token token : curStmt.getAllTokensRec()) {
                ((CommonToken) token).setLine(token.getLine() - sign * lines);
            }
        }
    }
}
