package org.example.semantic.intf.symbol;

import org.example.parser.common.context.ExtendContext;
import org.example.semantic.intf.type.Type;
import org.example.styler.naming.NameType;

public class VarSym extends Symbol {
    private Type type;

    public VarSym(Type type, ExtendContext astNode, ExtendContext modifierListNode, NameType nameType) {
        super(astNode, modifierListNode, nameType);
        this.type = type;
    }

    public Type getType() {
        return type;
    }

}
