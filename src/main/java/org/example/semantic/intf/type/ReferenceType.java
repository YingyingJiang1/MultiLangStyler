package org.example.semantic.intf.type;

import org.antlr.v4.runtime.tree.ParseTree;
import org.example.semantic.intf.symbol.ClassSym;
import org.example.semantic.intf.symbol.Symbol;

public class ReferenceType extends Type{
    Symbol symbol;


    public ReferenceType(ParseTree astNode, Symbol symbol) {
        super(astNode);
        this.symbol = symbol;
    }

    @Override
    public String getName() {
        if (symbol instanceof ClassSym classSym) {
            return classSym.getName();
        }
        return null;
    }

    public String getQualifiedName() {
        if (symbol instanceof ClassSym classSym) {
            return classSym.getQualifiedName();
        }
        return null;
    }
}

