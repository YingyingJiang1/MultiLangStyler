package org.example.semantic.intf.type;

import org.antlr.v4.runtime.tree.ParseTree;
import org.example.semantic.intf.symbol.ClassSym;
import org.example.semantic.intf.symbol.Symbol;

public class ReferenceType extends Type{
    Symbol symbol;


    public ReferenceType(ParseTree astNode, Symbol symbol) {
        super(astNode, null);
        if (astNode != null) {
            this.typeName = astNode.getText();
        } else if (symbol != null) {
            this.typeName = symbol.getText();
        }
        this.symbol = symbol;
    }

    public String getQualifiedName() {
        if (symbol instanceof ClassSym classSym) {
            return classSym.getQualifiedName();
        }
        return null;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }
}

