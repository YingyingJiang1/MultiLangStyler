package org.example.semantic;

import org.example.semantic.intf.Symbol;

import java.util.*;

public class ScopeStack {
    // Store terminal node of all defined symbols in different scopes.
    // Peek is the current scope.
    private Stack<Map<String, Symbol>> scopeStack = new Stack<>();


    public void addScope() {
        scopeStack.push(new HashMap<>());
    }

    public Map<String, Symbol> popScope() {
        if (scopeStack.isEmpty()) {
            return null;
        }
        return scopeStack.pop();
    }

    public Symbol getSymbol(String name) {
        if (scopeStack.isEmpty()) {
            return null;
        }
        return scopeStack.peek().get(name);
    }

    public void addSymbol(Symbol sym) {
        if (scopeStack.isEmpty()) {
            return;
        }
        scopeStack.peek().put(sym.getName(), sym);
    }
}
