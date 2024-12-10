package org.example.semantic.intf.symbol;

import org.antlr.v4.runtime.tree.TerminalNode;
import org.example.parser.common.context.ExtendContext;
import org.example.semantic.intf.type.Type;
import org.example.styler.naming.SymbolType;

import java.util.List;

public class FunctionSym extends Symbol{
    Type retType;
    List<Symbol> typeParameters;


    public FunctionSym(Type retType, List<Symbol> typeParameters, TerminalNode astNode, ExtendContext modifierListNode, SymbolType symbolType) {
        super(astNode, modifierListNode, symbolType);
        this.retType = retType;
        this.typeParameters = typeParameters;
    }

    public FunctionSym() {
    }
}
