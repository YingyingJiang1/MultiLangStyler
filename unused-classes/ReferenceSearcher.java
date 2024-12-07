package org.example.semantic;

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.example.parser.common.MyParser;
import org.example.parser.common.context.ExtendContext;
import org.example.semantic.intf.Symbol;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class ReferenceSearcher {
    private static final ReferenceSearcher INSTANCE = new ReferenceSearcher();
    public static Logger logger = LoggerFactory.getLogger(ReferenceSearcher.class);

    private ReferenceSearcher() {}

    public static ReferenceSearcher getInstance() {
        return INSTANCE;
    }


    public Set<TerminalNode> search(Symbol symbol, MyParser parser) {
        SymbolTable st = SymbolManager.createAndGetSymbolTable(parser.getRoot(), parser);
        if (symbol.getReferences() != null) {
            return symbol.getReferences();
        }

        Set<TerminalNode> references = new HashSet<>();
        Scope scope = symbol.getScope();
        doSearch(symbol, scope);
        symbol.setReferences(references);
        return references;
    }

    private void doSearch(Symbol symbol, Scope scope) {

    }

    /**
     * Recursively search references for all the local symbols defined in the tree with a root of 'root'.
     */
    private void searchInLocal(ParseTree root, MyParser parser, SymbolTable st, ScopeStack scopeStack) {
        if (root instanceof TerminalNode ter && ter.getSymbol().getType() == parser.getIdentifier()) {
            String name = ter.getText();
            // `ter` is a terminal node of a declaration. Add symbol in current scope dynamically.
            Symbol sym = st.getSymbol(ter);
            if (sym != null) {
                scopeStack.addSymbol(sym);
                return;
            }

            // `ter` is a reference of a declaration
            Symbol symbol = scopeStack.getSymbol(name);
            if (symbol == null) {
                logger.warn("Variable {} used before definition!", name);
            } else {
                symbol.addReference(ter);
            }
            return;
        }

        ExtendContext ctx = (ExtendContext) root;
        int ruleIndex = ctx.getRuleIndex();
        // Carefully handle parameters of function and local variables in for loop.
        boolean isNewScope = parser.belongToFunctionDec(ruleIndex) || parser.getCompoundStmts().contains(ruleIndex);
        if (isNewScope) {
            scopeStack.addScope();
        }

        // Recursively search in the children
        for (ParseTree child : ctx.children) {
            searchInLocal(child, parser, st, scopeStack);
        }

        // exit the current block scope.
        if (isNewScope) {
            scopeStack.popScope();
        }
    }

    private static void searchInClass(
            ParseTree root, MyParser parser, SymbolTable st,
            Map<String, Stack<Symbol>> lookupTable, ScopeStack scopeStack
    ) {

    }

}
