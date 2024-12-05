package org.example.semantic;

import org.antlr.v4.runtime.tree.ParseTree;
import org.example.semantic.symbol.ClassSym;
import org.example.semantic.symbol.MethodSym;
import org.example.semantic.symbol.Symbol;
import org.example.semantic.symbol.VarSym;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SymbolTable {
    public Logger logger = LoggerFactory.getLogger(SymbolTable.class);

    // Map for fast searching. Key is the root node of declaration.
    private Map<ParseTree, VarSym> vars = new HashMap<>(0);
    private Map<ParseTree, MethodSym> methods = new HashMap<>(0);
    private Map<ParseTree, ClassSym> classes = new HashMap<>(0);

    public void addSym(ParseTree declarationRoot, Symbol symbol) {
        if (symbol instanceof VarSym) {
            vars.put(declarationRoot, (VarSym) symbol);
        } else if (symbol instanceof MethodSym) {
            methods.put(declarationRoot, (MethodSym) symbol);
        } else if (symbol instanceof ClassSym) {
            classes.put(declarationRoot, (ClassSym) symbol);
        } else {
            logger.error("Unknown symbol type: " + symbol.getClass().getName());
        }
    }

    public void addVarSym(VarSym varSym) {
        vars.put(varSym.getDeclarationNode(), varSym);
    }

    public void addMethodSym(MethodSym methodSym) {
        methods.put(methodSym.getDeclarationNode(), methodSym);
    }

    public void addClassSym(ClassSym classSym) {
        classes.put(classSym.getDeclarationNode(), classSym);
    }

    public Symbol getSymbol(ParseTree node) {
        if (vars.get(node) != null) {
            return vars.get(node);
        } else if (methods.get(node) != null) {
            return methods.get(node);
        } else if (classes.get(node) != null) {
            return classes.get(node);
        } else {
            return null;
        }
    }
}
