package org.example.semantic;

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.example.parser.common.MyParser;
import org.example.semantic.intf.Resolver;
import org.example.semantic.intf.symbol.Symbol;

public class ResolverImpl implements Resolver {
    @Override
    public Symbol resolve(TerminalNode identifierNode, MyParser parser) {
        return null;
    }

    @Override
    public SymbolTable resolve(MyParser parser) {
        ParseTree root = parser.getRoot();
        if (SymbolTableManager.getInstance().getSymbolTable(root) != null) {
            return SymbolTableManager.getInstance().getSymbolTable(root);
        }

        SymbolTable st = new SymbolTable();
        doResolve();
        return null;
    }
}
