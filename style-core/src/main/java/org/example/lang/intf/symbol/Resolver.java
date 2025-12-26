package org.example.lang.intf.symbol;

import org.antlr.v4.runtime.tree.ParseTree;
import org.example.lang.intf.MyParser;
import org.example.antlr.common.context.ExtendContext;
import org.example.semantic.SymbolTable;
import org.example.semantic.intf.symbol.Symbol;

public interface Resolver {
    // Resolve for `identifierNode`
    Symbol resolve(ExtendContext identifierNode, MyParser parser);
    SymbolTable resolveAll(ParseTree root, MyParser parser);
    SymbolTable getSymbolTable(MyParser parser);
}
