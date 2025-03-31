package org.example.semantic.intf.symbol;

import org.example.parser.common.context.ExtendContext;
import org.example.semantic.intf.type.Type;
import org.example.styler.naming.NameType;

import java.util.List;

public class FunctionSym extends Symbol{
    Type retType;
    List<Symbol> typeParameters;


    public FunctionSym(Type retType, List<Symbol> typeParameters, ExtendContext astNode, ExtendContext modifierListNode, NameType nameType) {
        super(astNode, modifierListNode, nameType);
        this.retType = retType;
        this.typeParameters = typeParameters;
    }

    public FunctionSym() {
    }

    public Type getRetType() {
        return retType;
    }

    public List<Symbol> getTypeParameters() {
        return typeParameters;
    }
}
