package org.example.semantic.intf.symbol;

public interface VarSym extends Symbol {
    String getTypeName();
    String getFullTypeName();
    boolean isPrimitive();
    boolean isReference();
    boolean isConst();
}
