package org.example.semantic;

import org.antlr.v4.runtime.tree.ParseTree;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Manage the symbol tables for all files.
 */
public class SymbolManager {
    public Logger logger = LoggerFactory.getLogger(SymbolManager.class);
    private static Map<ParseTree, SymbolTable> symbolTables = new HashMap<>(0);

    public static SymbolTable createSymbolTable(ParseTree root) {
        SymbolTable symbolTable =  new SymbolTable();

        doCreate(root, symbolTable);

        symbolTables.put(root, symbolTable);
        return symbolTable;
    }

    public static SymbolTable getSymbolTable(ParseTree root) {
        return symbolTables.get(root);
    }

    /**
     *
     * @return the symbol table if it exists, otherwise it will try to create one.
     */
    public static SymbolTable createAndGetSymbolTable(ParseTree root) {
        SymbolTable st = symbolTables.get(root);
        if (st == null) {
            st = createSymbolTable(root);
        }
        return st;
    }

    private static void doCreate(ParseTree root, SymbolTable symbolTable) {
    }


}
