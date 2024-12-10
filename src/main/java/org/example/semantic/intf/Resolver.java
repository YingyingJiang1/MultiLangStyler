package org.example.semantic.intf;

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.example.parser.common.MyParser;
import org.example.semantic.SymbolTable;
import org.example.semantic.intf.symbol.Symbol;

import java.io.File;

public interface Resolver {
    // Resolve for `identifierNode`
    Symbol resolve(TerminalNode identifierNode, MyParser parser);
    SymbolTable getSymbolTable(ParseTree root);

}
