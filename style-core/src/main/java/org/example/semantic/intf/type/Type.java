package org.example.semantic.intf.type;

import org.antlr.v4.runtime.tree.ParseTree;
import org.example.semantic.intf.symbol.Symbol;

public abstract class Type {
    protected ParseTree astNode;
    protected String typeName;

    public Type(ParseTree astNode, String typeName) {
        this.astNode = astNode;
        this.typeName = typeName;
    }

    public Symbol resolve() {
        return null;
    }

    public String getName() {
        return typeName;
    }

    public ParseTree getAstNode() {
        return astNode;
    }
}
