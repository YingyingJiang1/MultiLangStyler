package org.example.semantic;

import org.antlr.v4.runtime.tree.ParseTree;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * Manage the symbol tables for all files.
 */
public class SymbolManager {
    public Logger logger = LoggerFactory.getLogger(SymbolManager.class);
    Map<ParseTree, SymbolTable> symbolTables;

}
