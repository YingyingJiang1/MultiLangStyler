package org.example.semantic;

import org.antlr.v4.runtime.tree.ParseTree;
import org.checkerframework.checker.units.qual.K;
import org.example.global.GlobalInfo;
import org.example.parser.common.MyParser;
import org.example.semantic.factory.ResolverFactory;
import org.example.semantic.intf.symbol.Symbol;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class SymbolTableManager {
    private static final Map<Key, SymbolTable> stCache = new HashMap<>();

    public static List<Symbol> getAllSymbols(MyParser parser) {
        SymbolTable st = stCache.get(parser.getRoot());
        if (st == null) {
            st = ResolverFactory.createResolver(GlobalInfo.getLanguage()).resolveAll(parser.getRoot(), parser);
            stCache.put(createSTKey(parser.getRoot()), st);
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
            st = ResolverFactory.createResolver(parser.getLanguage()).resolveAll(root, parser);
            stCache.put(createSTKey(root), st);
        }
        return st;
    }

    public static void addSymbolTable(ParseTree root, SymbolTable st) {
        stCache.put(createSTKey(root), st);
    }

    private static Key createSTKey(ParseTree root) {
        return new Key(root, root.getText());
    }

    private static class Key {
        private ParseTree root;
        private String text;

        public Key(ParseTree root, String text) {
            this.root = root;
            this.text = text;
        }

        @Override
        public int hashCode() {
            return Objects.hash(root, text);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Key key) {
                return text.equals(key.text) && root.equals(key.root);
            }
            return false;
        }
    }
}
