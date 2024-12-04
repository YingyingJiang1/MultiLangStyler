package org.example.semantic.type;

public class PrimitiveType implements Type{
    String typeName;

    @Override
    public String getName() {
        return typeName;
    }
}
