package org.example.semantic.symbol;

import org.example.parser.common.context.ExtendContext;
import org.example.semantic.type.Type;

import java.util.List;

public class MethodSym extends Symbol{
    Type retType;
    List<VarSym> param;


    public MethodSym(ExtendContext declarationNode, List<String> modifiers) {
        super(declarationNode, modifiers);
    }

    public void addParam(VarSym symbol) {
        param.add(symbol);
    }



}
