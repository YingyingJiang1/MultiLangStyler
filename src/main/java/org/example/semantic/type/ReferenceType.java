package org.example.semantic.type;

import org.example.global.GlobalInfo;
import org.example.semantic.symbol.ClassSym;

public class ReferenceType implements Type{
    private ClassSym type;

    @Override
    public String getName() {
        return type.getName();
    }

    public String getFullName() {
        return type.getPath() + GlobalInfo.getPathSeparator() + type.getName();
    }

    public boolean isMatched(String path, String name) {
        return type.getPath().equals(path) && type.getName().equals(name);
    }
}
