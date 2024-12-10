package org.example.semantic.intf.type;

import org.antlr.v4.runtime.tree.ParseTree;
import org.example.semantic.intf.symbol.Symbol;

public abstract class Type {
    ParseTree astNode;

    public Type(ParseTree astNode) {
        this.astNode = astNode;
    }

    public Symbol resolve() {
        return null;
    }

    public String getName() {
        return astNode.getText();
    }
}
