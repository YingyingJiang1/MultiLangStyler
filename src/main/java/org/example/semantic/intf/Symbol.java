package org.example.semantic.intf;

import org.example.styler.naming.SymbolType;

import java.sql.Ref;

public interface Symbol {
    String getName();
    void modifyName(String name);;
    SymbolType getSymbolType();
    void addReference(Reference reference);
}
