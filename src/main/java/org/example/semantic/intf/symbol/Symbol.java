package org.example.semantic.intf.symbol;

import org.example.global.GlobalInfo;
import org.example.parser.common.context.ExtendContext;
import org.example.parser.common.token.ExtendToken;
import org.example.semantic.intf.ReferenceResolver;
import org.example.semantic.intf.Resolver;
import org.example.styler.naming.SymbolType;

import java.util.ArrayList;
import java.util.List;

public abstract class Symbol {
    protected ExtendContext identifierNode; // identifier node in declaration statement.
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

    public ExtendContext getDecIdentifierNode() {
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


    public List<ExtendContext> getReferences() {
        return references;
    }
}
