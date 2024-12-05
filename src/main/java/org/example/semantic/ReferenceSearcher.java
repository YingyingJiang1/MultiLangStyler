package org.example.semantic;

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.example.parser.common.MyParser;
import org.example.semantic.symbol.Symbol;

import java.util.ArrayList;
import java.util.List;

public class ReferenceSearcher {
    public static List<TerminalNode> search(Symbol symbol, MyParser parser) {
        SymbolTable st = SymbolManager.createAndGetSymbolTable(parser.getRoot(), parser);
        if (symbol.getReferences() != null) {
            return symbol.getReferences();
        }

        List<TerminalNode> references = new ArrayList<>();
        Scope scope = symbol.getScope();

        symbol.setReferences(references);
        return references;
    }
}
