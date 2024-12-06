package org.example.semantic;

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.example.parser.common.MyParser;
import org.example.semantic.symbol.Symbol;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Resolver {
    private static Resolver instance = new Resolver();

    private Resolver() {}

    public static Resolver getInstance() {
        return instance;
    }


    /**
     *
     * @param terminalNode the terminalNode to be resolved
     * @param root the root of the entire tree.
     * @return
     */
    public Symbol resolve(TerminalNode terminalNode, ParseTree root, MyParser parser) {
        SymbolTable st = SymbolManager.createAndGetSymbolTable(root, parser);
        if (st == null) {
            return null;
        }
        Map<String, TerminalNode> toBeResolved = new HashMap<String, TerminalNode>();
        return doResolve(terminalNode, st, parser, toBeResolved);
    }

    private Symbol doResolve(TerminalNode terminalNode, SymbolTable st,
                             MyParser parser, Map<String, TerminalNode> toBeResolved) {
        Symbol symbol = st.getSymbol(terminalNode);
        if (symbol != null) {
            return symbol;
        }

        // Check symbol table
        List<Symbol> symbols = st.getSymbolsHasSameName(terminalNode.getText());
        for (Symbol symbol1 : symbols) {
            if (symbol1.isReference(terminalNode)) {
                return symbol1;
            }
        }


    }

}
