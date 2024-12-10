package org.example.semantic;

import org.example.semantic.intf.symbol.Symbol;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class SymbolTable {
    public Logger logger = LoggerFactory.getLogger(SymbolTable.class);

    // Map for fast searching. Key is the root node of declaration.
    private Map<String, List<Symbol>> symbols = new HashMap<>(0);

    public void addSym(Symbol symbol) {
        String name = symbol.getName();
        symbols.computeIfAbsent(name, k -> new ArrayList<>()).add(symbol);
    }

    public List<Symbol> getSymbolsHasSameName(String name) {
        return symbols.get(name);
    }

    public List<Symbol> getAllSymbols() {
        List<Symbol> allSymbols = new ArrayList<>();
        for (List<Symbol> symbols : symbols.values()) {
            allSymbols.addAll(symbols);
        }
        return allSymbols;
    }
}
