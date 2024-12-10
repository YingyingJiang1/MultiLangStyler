package org.example.semantic;

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.example.parser.common.MyParser;
import org.example.parser.common.context.ExtendContext;
import org.example.semantic.intf.symbol.Symbol;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class SymbolTable {
    public Logger logger = LoggerFactory.getLogger(SymbolTable.class);

    // Map for fast searching.
    // Key is the location where the symbol is defined, it can be compound statements, method declarations, type declarations, lambda expressions.
    // Value is the list of symbols those are defined in the same scope.
    private Map<ParseTree, List<Symbol>> symbolMap = new HashMap<>(0);

    public void addSymbol(Symbol symbol, MyParser parser) {
        ParseTree  defLocation = getOuterScope(symbol.getIdentifierNode(), parser);
        symbolMap.computeIfAbsent(defLocation, k -> new ArrayList<>()).add(symbol);
    }

    public List<Symbol> getAllSymbols() {
        List<Symbol> allSymbols = new ArrayList<>();
        for (List<Symbol> symbols : symbolMap.values()) {
            allSymbols.addAll(symbols);
        }
        return allSymbols;
    }


    public Symbol getSymbol(TerminalNode identifierNode, MyParser parser) {
        String name = identifierNode.getText();
        ParseTree curScope = getOuterScope(identifierNode, parser);
        while (curScope != null) {
            List<Symbol> symbols = symbolMap.get(curScope);
            if (symbols != null) {
                for (Symbol symbol : symbols ) {
                    if (symbol.getName().equals(name)) {
                        return symbol;
                    }
                }
            }
            curScope = getOuterScope(curScope, parser);
        }
        return null;
    }

    /**
     *
     * @return Location where the symbol is defined, including: compound statements, method declarations, type declarations
     */
    private ParseTree getOuterScope(ParseTree node, MyParser parser) {
        ParseTree parent = node.getParent();
        while (parent != null) {
            if (parent instanceof ExtendContext ctx){
                int ruleIndex = ctx.getRuleIndex();
                if (parser.getCompoundStmts().contains(ruleIndex) || parser.belongToFunctionDec(ruleIndex) ||
                        parser.isLambdaExpression(parent) || parser.isTypeDeclaration(parent)) {
                    return parent;
                }
            }
            parent = parent.getParent();
        }
        return null;
    }

}
