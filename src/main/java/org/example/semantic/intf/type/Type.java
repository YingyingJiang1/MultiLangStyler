package org.example.semantic.intf.type;

import org.antlr.v4.runtime.tree.ParseTree;
import org.example.semantic.intf.symbol.Symbol;

public abstract class Type {
    Symbol symbol;
    ParseTree astNode;

    public Symbol resolve() {
        return null;
    }
}
