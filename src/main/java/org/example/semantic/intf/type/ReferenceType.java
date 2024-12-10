package org.example.semantic.intf.type;

import org.antlr.v4.runtime.tree.ParseTree;
import org.example.semantic.intf.symbol.Symbol;

public class ReferenceType extends Type{
    Symbol symbol;


    public ReferenceType(ParseTree astNode, Symbol symbol) {
        super(astNode);
        this.symbol = symbol;
    }
}

