package org.example.semantic;

import org.antlr.v4.runtime.tree.ParseTree;
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
        ParseTree  defLocation = Scope.getScopeNode(symbol.getDecIdentifierNode(), parser);
        symbolMap.computeIfAbsent(defLocation, k -> new ArrayList<>()).add(symbol);
    }

    public void updateScope(Symbol symbol, ParseTree newScopeNode, MyParser parser) {
        ParseTree  defLocation = Scope.getScopeNode(symbol.getDecIdentifierNode(), parser);
        symbolMap.get(defLocation).remove(symbol);
        symbolMap.computeIfAbsent(newScopeNode, k -> new ArrayList<>()).add(symbol);
    }

    public List<Symbol> getAllSymbols() {
        List<Symbol> allSymbols = new ArrayList<>();
        for (List<Symbol> symbols : symbolMap.values()) {
            allSymbols.addAll(symbols);
        }
        return allSymbols;
    }

    public List<Symbol> getAllSymbolsIn(ParseTree scopeNode) {
        return symbolMap.get(scopeNode);
    }


    public Symbol getSymbol(ExtendContext identifierNode, MyParser parser) {
        String name = identifierNode.getText();
        ParseTree curScope = Scope.getScopeNode(identifierNode, parser);
        while (curScope != null) {
            List<Symbol> symbols = symbolMap.get(curScope);
            if (symbols != null) {
                for (Symbol symbol : symbols ) {
                    if (symbol.getText().equals(name)) {
                        return symbol;
                    }
                }
            }
            curScope = Scope.getScopeNode(curScope.getParent(), parser);
        }
        return null;
    }

    public boolean hasSymbol(String text) {
        for (List<Symbol> symbols : symbolMap.values()) {
            for (Symbol symbol : symbols) {
                if (symbol.getText().equals(text)) {
                    return true;
                }
            }
        }
        return false;
    }


}
