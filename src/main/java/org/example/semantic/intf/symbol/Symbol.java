package org.example.semantic.intf.symbol;

import org.example.parser.common.context.ExtendContext;
import org.example.parser.common.token.ExtendToken;
import org.example.styler.naming.NameType;

import java.util.ArrayList;
import java.util.List;

public abstract class Symbol {
    protected ExtendContext identifierNode; // identifier node in declaration statement.
    protected List<ExtendContext> references = new ArrayList<>(0);
    protected ExtendContext modifierListNode;
    protected NameType nameType;
    protected String text;

    public Symbol(ExtendContext identifierNode, ExtendContext modifierListNode, NameType nameType) {
        this.identifierNode = identifierNode;
        this.modifierListNode = modifierListNode;
        this.nameType = nameType;
        this.text = identifierNode.getText();
    }

    public Symbol() {}

    public String getText() {
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

    public NameType getSymbolType() {
        return nameType;
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

    public boolean isPrivate() {
        return hasModifier("private");
    }
}
