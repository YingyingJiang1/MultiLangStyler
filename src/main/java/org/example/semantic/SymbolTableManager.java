package org.example.semantic;

import org.antlr.v4.runtime.tree.ParseTree;
import org.example.global.GlobalInfo;
import org.example.parser.common.MyParser;
import org.example.semantic.ResolverFactory;
import org.example.semantic.SymbolTable;
import org.example.semantic.intf.symbol.Symbol;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SymbolTableManager {
    private static final Map<ParseTree, SymbolTable> stCache = new HashMap<>();

    public static List<Symbol> getAllSymbols(MyParser parser) {
        SymbolTable st = stCache.get(parser.getRoot());
        if (st == null) {
            st = ResolverFactory.createResolver(GlobalInfo.getLanguage()).resolveAll(parser.getRoot(), parser);
            stCache.put(parser.getRoot(), st);
        }

        if (st == null) {
            return null;
        }

        return st.getAllSymbols();
    }

    public static SymbolTable getSymbolTable(ParseTree root) {
        return stCache.get(root);
    }

    public static void addSymbolTable(ParseTree root, SymbolTable st) {
        stCache.put(root, st);
    }
}
