package org.example.semantic.intf.type;

import org.antlr.v4.runtime.tree.ParseTree;

import java.util.List;
import java.util.Set;

public class PrimitiveType extends Type {
    private static final Set<String> primitiveTypes = Set.of(
            "byte", "short", "int", "long", "float", "double", "boolean", "char", "void"
    );

    public PrimitiveType(ParseTree astNode) {
        super(astNode);
    }

    public static boolean isPrimitiveType(String text) {
        return primitiveTypes.contains(text);
    }
}
