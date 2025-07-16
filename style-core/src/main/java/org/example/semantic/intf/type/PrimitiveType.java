package org.example.semantic.intf.type;

import org.antlr.v4.runtime.tree.ParseTree;

import java.util.List;
import java.util.Set;

public class PrimitiveType extends Type {
    private static final Set<String> primitiveTypes = Set.of(
            "byte", "short", "int", "long", "float", "double", "boolean", "char", "void"
    );

    public PrimitiveType(ParseTree astNode, String typeName) {
        super(astNode, typeName);
    }

    public static boolean isPrimitiveType(String text) {
        return primitiveTypes.contains(text);
    }

    public boolean isInt() {
        return typeName.equals("int");
    }

    public boolean isFloat() {
        return typeName.equals("float");
    }

    public boolean isDouble() {
        return typeName.equals("double");
    }

    public boolean isBoolean() {
        return typeName.equals("boolean");
    }

    public boolean isVoid() {
        return typeName.equals("void");
    }

    public boolean isChar() {
        return typeName.equals("char");
    }

    public boolean isByte() {
        return typeName.equals("byte");
    }

    public boolean isShort() {
        return typeName.equals("short");
    }

    public boolean isLong() {
        return typeName.equals("long");
    }

    public boolean isWider(PrimitiveType other) {
       return this.getSize() > other.getSize();
    }

    private int getSize() {
		return switch (typeName) {
			case "byte", "boolean" -> 1;
			case "short", "char" -> 2;
			case "int", "float" -> 4;
			case "long", "double" -> 8;
			case "void" -> 0;
			default -> 0;
		};
    }

}
