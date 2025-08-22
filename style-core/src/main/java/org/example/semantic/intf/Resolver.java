package org.example.semantic.intf;

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.example.parser.common.MyParser;
import org.example.parser.common.context.ExtendContext;
import org.example.semantic.SymbolTable;
import org.example.semantic.intf.symbol.Symbol;
import org.example.semantic.intf.type.Type;

import java.io.File;

public interface Resolver {
    // Resolve for `identifierNode`
    Symbol resolve(ExtendContext identifierNode, MyParser parser);
    SymbolTable resolveAll(ParseTree root, MyParser parser);
    SymbolTable getSymbolTable(MyParser parser);
}
