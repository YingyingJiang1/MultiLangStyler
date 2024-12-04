package org.example.semantic.symbol;

import org.antlr.v4.runtime.Token;
import org.example.parser.common.context.ExtendContext;
import org.example.semantic.Scope;

import java.util.List;

public abstract class Symbol {
    String name;
    ExtendContext declarationNode;
    Scope scope;
    List<Token> references;

    public Token getToken() {
        return null;
    }

    public  String getName() {
        return name;
    }

    public  void setName(String name) {
        this.name = name;
    }

    public  ExtendContext getDeclarationNode() {
        return declarationNode;
    }
    public  void setDeclarationNode(ExtendContext declarationNode) {
        this.declarationNode = declarationNode;
    }

    public  Scope getScope() {
        return scope;
    }

    public  void setScope(Scope scope) {
        this.scope = scope;
    }

    public  List<Token> getReferences() {
        return references;
    }

    public  void setReferences(List<Token> references) {
        this.references = references;
    }
}
