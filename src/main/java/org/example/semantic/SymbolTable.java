package org.example.semantic;

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.example.semantic.symbol.ClassSym;
import org.example.semantic.symbol.FunctionSym;
import org.example.semantic.symbol.Symbol;
import org.example.semantic.symbol.VarSym;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class SymbolTable {
    public Logger logger = LoggerFactory.getLogger(SymbolTable.class);

    // Map for fast searching. Key is the root node of declaration.
    private Map<String, List<VarSym>> vars = new HashMap<>(0);
    private Map<String, List<FunctionSym>> methods = new HashMap<>(0);
    private Map<String, List<ClassSym>> classes = new HashMap<>(0);

    public void addSym(String name, Symbol symbol) {
        if (symbol instanceof VarSym) {
            vars.computeIfAbsent(name, k -> new ArrayList<>()).add((VarSym) symbol);
        } else if (symbol instanceof FunctionSym) {
            methods.computeIfAbsent(name, k -> new ArrayList<>()).add((FunctionSym) symbol);
        } else if (symbol instanceof ClassSym) {
            classes.computeIfAbsent(name, k -> new ArrayList<>()).add((ClassSym) symbol);
        } else {
            logger.error("Unknown symbol type: " + symbol.getClass().getName());
        }
    }

    public void addVarSym(VarSym varSym) {
        vars.computeIfAbsent(varSym.getName(), k -> new ArrayList<>()).add(varSym);
    }

    public void addMethodSym(FunctionSym functionSym) {
        methods.computeIfAbsent(functionSym.getName(), k -> new ArrayList<>()).add(functionSym);
    }

    public void addClassSym(ClassSym classSym) {
        classes.computeIfAbsent(classSym.getName(), k -> new ArrayList<>()).add(classSym);
    }

    public Symbol getSymbol(TerminalNode terminalNode) {
        List<Symbol> candidates = new ArrayList<>();
        String name = terminalNode.getText();
        if (vars.get(name) != null) {
            candidates.addAll(vars.get(name));
        } else if (methods.get(name) != null) {
            candidates.addAll(methods.get(name));
        } else if (classes.get(name) != null) {
            candidates.addAll(classes.get(name));
        }
        for (Symbol candidate : candidates) {
            if (candidate.getIdentifierNode() ==  terminalNode) {
                return candidate;
            }
        }
        return null;
    }

    public List<Symbol> getSymbolsHasSameName(String name) {
        List<Symbol> symbols = new ArrayList<>();
        if (vars.get(name) != null) {
            symbols.addAll(vars.get(name));
        }
        if (methods.get(name) != null) {
            symbols.addAll(methods.get(name));
        }
        if (classes.get(name) != null) {
            symbols.addAll(classes.get(name));
        }
        return symbols;
    }

}
