package org.example.semantic.javaimpl;

import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.body.VariableDeclarator;
import com.github.javaparser.ast.expr.NameExpr;
import com.github.javaparser.resolution.declarations.ResolvedValueDeclaration;
import org.example.semantic.intf.Reference;
import org.example.semantic.intf.Symbol;
import org.example.styler.naming.SymbolType;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class JavaSymbol implements Symbol {
    SymbolType symbolType;
    ResolvedValueDeclaration declaration;
    List<Reference> references = new ArrayList<>();
    List<String> modifiers;

    public JavaSymbol(SymbolType symbolType, ResolvedValueDeclaration declaration,
                      List<String> modifiers) {
        this.symbolType = symbolType;
        this.declaration = declaration;
        this.modifiers = modifiers;
    }

    @Override
    public String getName() {
        return declaration.getName();
    }

    @Override
    public void modifyName(String name) {
        Node decNode = declaration.toAst().get();
        decNode.findFirst(VariableDeclarator.class).get().setName(name);
        for (Reference reference : references) {
            Object nameNode = reference.getAstNode();
            if (nameNode instanceof NameExpr) {
                ((NameExpr) nameNode).setName(name);
            }
        }
    }

    @Override
    public SymbolType getSymbolType() {
        return symbolType;
    }

    @Override
    public void addReference(Reference reference) {
        references.add(reference);
    }
}
