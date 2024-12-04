package org.example.semantic;

import org.antlr.v4.runtime.tree.ParseTree;
import org.example.semantic.symbol.Symbol;

public class Resolver {
    private static Resolver instance = new Resolver();

    private Resolver() {}

    public static Resolver getInstance() {
        return instance;
    }


    /**
     *
     * @param name the text of identifier to be resolved
     * @param root the root of the entire tree.
     * @return
     */
    public Symbol resolve(String name, ParseTree root) {
        return null;
    }
}
