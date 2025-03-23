package org.example.styler.declaration.location;

import org.antlr.v4.runtime.CommonToken;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.apache.xmlbeans.SchemaIdentityConstraint;
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
import org.example.styler.naming.SymbolType;

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
                if (symbol.getSymbolType() != SymbolType.LOCAL_VARIABLE) {
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
                    if (symbol.getSymbolType() != SymbolType.LOCAL_VARIABLE) {
                        continue;
                    }

                    ExtendContext decStmt = symbol.getDecIdentifierNode();
                    while (decStmt.getParent() != null && !parser.isLocalVarDeclarationStmt(decStmt)) {
                        decStmt = (ExtendContext) decStmt.getParent();
                    }
                    ExtendContext block = decStmt;
                    Predicate<ExtendContext> isScopeCtx = (ExtendContext cur) -> cur != null && (
                            parser.getSpecificStmtType(cur) == parser.getRuleBlock() || parser.belongToCompoundStmt(cur));
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
     *
     * @param block The block that contains the declaration statement.
     * @param decStmt The declaration statement.
     * @param parser The parser.
     */
    private void moveToBlockStart(ExtendContext block, ExtendContext decStmt, MyParser parser) {
        int index = block.indexOfFirstChild(child -> child instanceof ExtendContext childCtx &&  parser.getSpecificStmt(childCtx) == parser.getSpecificStmt(decStmt));
        int j = index - 1;
        for (; j >= 0; j--) {
            if (block.getChild(j) instanceof ExtendContext stmt1) {
                if (parser.getSpecificStmtType(stmt1) == parser.getRuleLocalVarDeclarationStmt()) {
                    break;
                }
            } else {
                break; // reach brace.
            }
        }

        int insertionPoint = j + 1;
        if (index > insertionPoint) {
            block.children.remove(index);
            block.insertChild(insertionPoint, decStmt);
            updateCurrentLine(block, index, insertionPoint);
        }
    }


    /**
     *
     * @param block The block that contains the declaration statement.
     * @param decStmt The declaration statement.
     * @param parser The parser.
     */
    private void moveToFirstUse(ExtendContext block, ExtendContext decStmt, MyParser parser) {
        List<ExtendContext> decIdentifiers = parser.getDecStmtSearcher().searchIdentifiers(decStmt, parser);
        Resolver resolver = GlobalInfo.getResolver();

        // Get index of first statement that uses these declared variables in the given block structure.
        for (ExtendContext identifierNode : decIdentifiers) {
            List<ExtendContext> references = resolver.resolve(identifierNode, parser).getReferences();
            int minUsingIndex =  Integer.MAX_VALUE;
            for (ExtendContext ref : references) {
                ExtendContext usageStmt = ref.getFirstParentIf(parser::isStatement);
                int index = usageStmt == null ? -1 : indexOf(block, usageStmt, parser);
                if (index >= 0 && index < minUsingIndex) {
                    minUsingIndex = index;
                }
            }

            // Get the index of last statement that declares the variables used in the initializers of the declaration statement.
            int maxDependentIndex = -1;
            ExtendContext initializer = parser.getDecStmtSearcher().searchInitializer(decStmt, identifierNode, parser);
            if (initializer != null) {
                List<ExtendContext> initializerReferences = initializer.getAllContextsByTypeRec(parser.getRuleIdentifier());
                for (ExtendContext ref : initializerReferences) {
                    Symbol symbol = resolver.resolve(ref, parser);
                    if (symbol == null) {
                        continue;
                    }
                    ExtendContext decIdentifierNode = symbol.getDecIdentifierNode();
                    int index = indexOfContainerStmt(block.children, decIdentifierNode);
                    if (index >= 0 && index > maxDependentIndex) {
                        maxDependentIndex = index;
                    }
                }
            }

            // Move the declaration statement to the position whose index satisfies: max({index < minUsingIndex and index > maxDependentIndex})
            if (minUsingIndex == Integer.MAX_VALUE) {
                continue;
            }

            int insertionPoint = getNearUseInsertionPoint(minUsingIndex, maxDependentIndex);
            int curIndex = block.indexOfFirstChild(child -> child instanceof ExtendContext childCtx && parser.getSpecificStmt(childCtx) == parser.getSpecificStmt(decStmt));
            if (insertionPoint >= 0 && insertionPoint != curIndex) {
                ExtendContext targetStmt = (ExtendContext) block.children.remove(curIndex);
                if (curIndex < insertionPoint) {
                    insertionPoint--;
                }
                block.insertChild(insertionPoint, targetStmt);
                updateCurrentLine(block, curIndex, insertionPoint);
            }
        }
    }


    private int getNearUseInsertionPoint(int minUsingIndex, int maxDependentIndex) {
        int lowerBound = Math.min(minUsingIndex, maxDependentIndex);
        int upperBound = Math.max(minUsingIndex, maxDependentIndex);

        for (int index = upperBound - 1; index > lowerBound; index--) {
            if (index > maxDependentIndex && index < minUsingIndex) {
                return index;
            }
        }
        return -1;
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
                if (stmt.getAllContextsByTypeRec(usageStmt.getRuleIndex()).contains(usageStmt)) {
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
        for (int i = oldIndex + sign; i != newIndex + sign; i += sign) {
            ExtendContext curStmt = (ExtendContext) block.getChild(i);
            for (Token token : curStmt.getAllTokensRec()) {
                ((CommonToken) token).setLine(token.getLine() - sign * lines);
            }
        }
    }
}
