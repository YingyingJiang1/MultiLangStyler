package org.example.semantic.symbol;

import org.example.parser.common.context.ExtendContext;
import org.example.semantic.type.PrimitiveType;
import org.example.semantic.type.Type;

import java.util.List;

public class VarSym extends Symbol {
    Type type;

    public VarSym(ExtendContext declarationNode, List<String> modifiers) {
        super(declarationNode, modifiers);
    }

    public boolean isConst(String constKeyword) {
        return modifiers.contains(constKeyword);
    }

    public boolean isPrimitiveType() {
        return type instanceof PrimitiveType;
    }

    public String getTypeName() {
        return type.getName();
    }

    public Type getType() {
        return type;
    }
}
