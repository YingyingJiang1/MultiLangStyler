package org.example.semantic;

import org.antlr.v4.runtime.tree.ParseTree;
import org.example.parser.common.MyParser;
import org.example.parser.common.context.ExtendContext;
import org.example.semantic.intf.ClassSym;
import org.example.semantic.intf.FunctionSym;
import org.example.semantic.intf.Symbol;
import org.example.semantic.intf.VarSym;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * Manage the symbol tables for all files.
 */
public class SymbolManager {
    public Logger logger = LoggerFactory.getLogger(SymbolManager.class);
    private static Map<ParseTree, SymbolTable> symbolTables = new HashMap<>(0);

    public static SymbolTable createSymbolTable(ParseTree root, MyParser parser) {
        SymbolTable symbolTable =  new SymbolTable();

        if (root instanceof ExtendContext ctx) {
            doCreate(ctx, symbolTable, new Stack<>(), parser);
        }

        symbolTables.put(root, symbolTable);
        return symbolTable;
    }

    public static SymbolTable getSymbolTable(ParseTree root) {
        return symbolTables.get(root);
    }

    /**
     *
     * @return the symbol table if it exists, otherwise it will try to create one.
     */
    public static SymbolTable createAndGetSymbolTable(ParseTree root, MyParser parser) {
        SymbolTable st = symbolTables.get(root);
        if (st == null) {
            st = createSymbolTable(root, parser);
        }
        return st;
    }


    private static void doCreate(ExtendContext root, SymbolTable symbolTable, Stack<Symbol> containerSymbolStack, MyParser parser) {
        boolean isContainerSymbol = false;
        Symbol symbol = null;
        if (parser.isTypeDeclaration(root)) {
            ClassSym classSym = ClassSym.createSym(root, parser);
            symbolTable.addClassSym(classSym);
            containerSymbolStack.push(classSym);
            symbol  = classSym;
            isContainerSymbol = true;
        } else if(parser.belongToFunctionDec(root.getRuleIndex())) {
            FunctionSym functionSym = FunctionSym.createSym(root, parser);
            symbol = functionSym;
            symbolTable.addMethodSym(functionSym);
            isContainerSymbol = true;
        } else if(parser.isFieldDeclaration(root) || parser.belongToLocalDeclaration(root)) {
            VarSym varSym = VarSym.createSym(root, parser);
            symbol = varSym;
            symbolTable.addVarSym(varSym);
        }

        if (symbol != null && !containerSymbolStack.isEmpty()) {
            symbol.setContainingSymbol(containerSymbolStack.peek());
        }
        if (isContainerSymbol) {
            containerSymbolStack.push(symbol);
        }

        for (ParseTree child : root.children) {
            if (child instanceof ExtendContext ctx) {
                doCreate(ctx, symbolTable, containerSymbolStack, parser);
            }
        }

        if (isContainerSymbol) {
            containerSymbolStack.pop();
        }

    }

}
