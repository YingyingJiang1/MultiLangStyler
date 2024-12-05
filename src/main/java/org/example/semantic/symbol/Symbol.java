package org.example.semantic.symbol;

import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.example.parser.common.MyParser;
import org.example.parser.common.context.ExtendContext;
import org.example.semantic.Scope;

import java.util.ArrayList;
import java.util.List;

public abstract class Symbol {
    protected String name;
    protected ExtendContext declarationNode;
    protected Scope scope;
    protected List<TerminalNode> references;
    protected List<String> modifiers;
    protected Symbol containingSymbol;

    public Symbol(ExtendContext declarationNode, List<String> modifiers) {
        this.modifiers = modifiers;
        this.declarationNode = declarationNode;
    }

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
        if (scope == null) {
            parseScope();
        }
        return scope;
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
        } else if (containingSymbol instanceof MethodSym) {
            scope = Scope.LOCAL;
        }
    }

    public  void setScope(Scope scope) {
        this.scope = scope;
    }

    public  List<TerminalNode> getReferences() {
        return references;
    }

    public  void setReferences(List<TerminalNode> references) {
        this.references = references;
    }

    public void setContainingSymbol(Symbol containingSymbol) {
        this.containingSymbol = containingSymbol;
    }


    protected static List<String> getModifierKeywords(ExtendContext declarationNode, MyParser parser) {
        List<String> ret = new ArrayList<>();
        ExtendContext modifierList = declarationNode.getContextRecIf(parser::isMethodDeclarationList);
        for (ParseTree child : modifierList.children) {
            if (!parser.isAnnotation(child)) {
                ret.add(child.getText());
            }
        }
        return ret;
    }
}
