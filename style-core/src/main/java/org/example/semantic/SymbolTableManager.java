package org.example.semantic;

import org.antlr.v4.runtime.tree.ParseTree;
import org.example.MyEnvironment;
import org.example.lang.LangAdapterCreator;
import org.example.lang.intf.MyParser;
import org.example.semantic.intf.symbol.Symbol;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SymbolTableManager {
    private static final Map<ParseTree, SymbolTable> stCache = new HashMap<>();

    public static List<Symbol> getAllSymbols(MyParser parser) {
        SymbolTable st = stCache.get(parser.getRoot());
        if (st == null) {
            st = LangAdapterCreator.createSymbolResolver(parser.getLanguage()).resolveAll(parser.getRoot(), parser);
            stCache.put(parser.getRoot(), st);
        }

        if (st == null) {
            return null;
        }

        return st.getAllSymbols();
    }

    public static SymbolTable getSymbolTable(MyParser parser) {
        ParseTree root = parser.getRoot();
        SymbolTable st =  stCache.get(root);
        if (st == null) {
            st = LangAdapterCreator.createSymbolResolver(parser.getLanguage()).resolveAll(root, parser);
            stCache.put(root, st);
        }
        return st;
    }

    public static void addSymbolTable(ParseTree root, SymbolTable st) {
        stCache.put(root, st);
    }

    public static SymbolTable updateSymbolTable(MyParser parser) {
        stCache.remove(parser.getRoot());
        return getSymbolTable(parser);
    }

    public static SymbolTable removeCache(ParseTree root) {
        SymbolTable st = stCache.get(root);
        stCache.remove(root);
        return st;
    }

}
