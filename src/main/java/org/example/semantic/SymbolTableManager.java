package org.example.semantic;

import org.antlr.v4.runtime.tree.ParseTree;

import java.util.HashMap;
import java.util.Map;

public class SymbolTableManager {
    private static final SymbolTableManager instance = new SymbolTableManager();
    Map<ParseTree, SymbolTable> stMap = new HashMap<>();

    private SymbolTableManager() {
    }

    public static SymbolTableManager getInstance() {
        return instance;
    }

    public SymbolTable getSymbolTable(ParseTree root) {
        return stMap.get(root);
    }

    public void addSymbolTable(ParseTree root, SymbolTable st) {
        stMap.put(root, st);
    }
}
