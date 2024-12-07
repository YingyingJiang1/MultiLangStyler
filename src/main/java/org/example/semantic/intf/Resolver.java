package org.example.semantic.intf;

import org.antlr.v4.runtime.tree.TerminalNode;
import org.example.parser.common.MyParser;
import org.example.semantic.SymbolTable;

import java.io.File;

public interface Resolver {

    SymbolTable parse(String code);
    SymbolTable parse(File file);
    String getParsedSourceCode();
    Symbol resolve(TerminalNode identifierNode, MyParser parser);

}
