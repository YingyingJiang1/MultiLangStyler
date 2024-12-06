package org.example.semantic.symbol;

import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.example.parser.common.MyParser;
import org.example.parser.common.context.ExtendContext;
import org.example.parser.common.token.ExtendToken;
import org.example.semantic.Scope;
import org.example.semantic.type.Type;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class Symbol {
    protected TerminalNode identifierNode;
    protected ExtendContext declarationNode;
    protected Scope scope;
    protected Set<TerminalNode> references;
    protected List<String> modifiers;
    protected Symbol containingSymbol;

    public Symbol(ExtendContext declarationNode, TerminalNode identifierNode, List<String> modifiers) {
        this.declarationNode = declarationNode;
        this.identifierNode = identifierNode;
        this.modifiers = modifiers;
    }

    public Token getToken() {
        return null;
    }

    public  String getName() {
        return identifierNode.getText();
    }

    public  void setName(String name) {
        if (identifierNode.getSymbol() instanceof ExtendToken token) {
            token.setText(name);
        }
    }

    public TerminalNode getIdentifierNode() {
        return identifierNode;
    }

    public  ExtendContext getDeclarationNode() {
        return declarationNode;
    }
    public  void setDeclarationNode(ExtendContext declarationNode) {
        this.declarationNode = declarationNode;
    }

    public  Scope getScope() {
        if (scope == null) {
            parseScope();
        }
        return scope;
    }

    public  void setScope(Scope scope) {
        this.scope = scope;
    }

    public  Set<TerminalNode> getReferences() {
        return references;
    }

    public void setReferences(Set<TerminalNode> references) {
        this.references = references;
    }

    public void setContainingSymbol(Symbol containingSymbol) {
        this.containingSymbol = containingSymbol;
    }

    public boolean isReference(TerminalNode identifierNode) {
        return references != null && references.contains(identifierNode);
    }


    protected static List<String> parseModifierKeywords(ExtendContext declarationNode, MyParser parser) {
        List<String> ret = new ArrayList<>();
        ExtendContext modifierList = declarationNode.getContextRecIf(parser::isMethodDeclarationList);
        for (ParseTree child : modifierList.children) {
            if (!parser.isAnnotation(child)) {
                ret.add(child.getText());
            }
        }
        return ret;
    }

    protected static Type parseType(ExtendContext typeNode, MyParser parser) {
        System.out.println("to do: implement Symbol@parseType");
        return null;
    }

    protected static TerminalNode parseIdentifier(ExtendContext idParent, MyParser parser) {
        ExtendContext idCtx = idParent.getFirstCtxChildIf(parser::isIdentifier);
        if (idCtx != null) {
            return (TerminalNode) idCtx.getChild(0);
        } else {
            return idParent.getFirstTerChildByType(parser.getIdentifier());
        }
    }

    private void parseScope() {
        if (containingSymbol instanceof ClassSym || containingSymbol == null) {
            if (modifiers.contains("public")) {
                scope = Scope.GLOBAL;
            } else if (modifiers.contains("private")) {
                scope = Scope.CLASS;
            } else if(modifiers.contains("protected")) {
                scope = Scope.CLASS_TREE;
            } else {
                scope = Scope.PACKAGE;
            }
        } else if (containingSymbol instanceof FunctionSym) {
            scope = Scope.LOCAL;
        }
    }

    public void addReference(TerminalNode ter) {
        if (references == null) {
            references = new HashSet<>();
        }
        references.add(ter);
    }
}
