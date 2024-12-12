package org.example.semantic.intf.symbol;

import org.antlr.v4.runtime.tree.TerminalNode;
import org.example.parser.common.context.ExtendContext;
import org.example.semantic.intf.type.Type;
import org.example.styler.naming.SymbolType;

public class VarSym extends Symbol {
    private Type type;

    public VarSym(Type type, ExtendContext astNode, ExtendContext modifierListNode, SymbolType symbolType) {
        super(astNode, modifierListNode, symbolType);
    }

    public Type getType() {
        return type;
    }

}
