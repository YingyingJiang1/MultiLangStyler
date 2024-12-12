package org.example.semantic.intf.symbol;

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.example.parser.common.MyParser;
import org.example.parser.common.context.ExtendContext;
import org.example.parser.common.token.ExtendToken;
import org.example.styler.naming.SymbolType;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public abstract class Symbol {
    protected ExtendContext identifierNode;
    protected List<ExtendContext> references = new ArrayList<>(0);
    protected ExtendContext modifierListNode;
    protected SymbolType symbolType;

    public Symbol(ExtendContext identifierNode, ExtendContext modifierListNode, SymbolType symbolType) {
        this.identifierNode = identifierNode;
        this.modifierListNode = modifierListNode;
        this.symbolType = symbolType;
    }

    public Symbol() {}

    public String getName() {
        return identifierNode.getText();
    }

    public void modifyName(String name) {
        ExtendToken extendToken = (ExtendToken) identifierNode.start;
        extendToken.setText(name);
        for (ExtendContext reference : references) {
            extendToken = (ExtendToken) reference.start;
            extendToken.setText(name);
        }
    }

    public SymbolType getSymbolType() {
        return symbolType;
    }

    public ExtendContext getIdentifierNode() {
        return identifierNode;
    }

    public void addReference(ExtendContext reference) {
        references.add(reference);
    }

    public boolean hasModifier(String modifier) {
        if (modifierListNode == null) {
            return false;
        }
        return modifierListNode.children.stream().anyMatch(node -> node.getText().equals(modifier));
    }



}
