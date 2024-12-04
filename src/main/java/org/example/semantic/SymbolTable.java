package org.example.semantic;

import org.example.semantic.symbol.ClassSym;
import org.example.semantic.symbol.MethodSym;
import org.example.semantic.symbol.Symbol;
import org.example.semantic.symbol.VarSym;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class SymbolTable {
    public Logger logger = LoggerFactory.getLogger(SymbolTable.class);

    List<VarSym> vars = new ArrayList<VarSym>(0);
    List<MethodSym> methods = new ArrayList<MethodSym>(0);
    List<ClassSym> classes = new ArrayList<ClassSym>(0);

    public void addSym(Symbol symbol) {
        if (symbol instanceof VarSym) {
            vars.add((VarSym) symbol);
        } else if (symbol instanceof MethodSym) {
            methods.add((MethodSym) symbol);
        } else if (symbol instanceof ClassSym) {
            classes.add((ClassSym) symbol);
        } else {
            logger.error("Unknown symbol type: " + symbol.getClass().getName());
        }
    }
}
