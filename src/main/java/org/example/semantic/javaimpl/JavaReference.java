package org.example.semantic.javaimpl;

import com.github.javaparser.ast.expr.NameExpr;
import org.example.semantic.intf.Reference;
import org.example.semantic.intf.Symbol;

public class JavaReference implements Reference {
    Symbol defSymbol;
    NameExpr astNode;

    public JavaReference(Symbol defSymbol, NameExpr astNode) {
        this.defSymbol = defSymbol;
        this.astNode = astNode;
    }

    @Override
    public Symbol getDefSymbol() {
        return defSymbol;
    }

    @Override
    public Object getAstNode() {
        return astNode;
    }
}
