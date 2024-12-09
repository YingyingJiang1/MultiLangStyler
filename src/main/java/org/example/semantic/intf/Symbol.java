package org.example.semantic.intf;

import org.antlr.v4.runtime.tree.TerminalNode;
import org.example.styler.naming.SymbolType;

import java.sql.Ref;

public interface Symbol {
    String getName();
    void modifyName(String name);;
    SymbolType getSymbolType();
    void addReference(Reference reference);
    void addReference(TerminalNode identifierNode);
    boolean isReference(TerminalNode identifierNode);
}
