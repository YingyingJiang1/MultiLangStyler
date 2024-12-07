package org.example.semantic.javaimpl;

import com.github.javaparser.ast.body.VariableDeclarator;
import com.github.javaparser.resolution.declarations.ResolvedValueDeclaration;
import org.example.styler.naming.SymbolType;

import java.util.List;

public class JavaFunctionSym extends JavaSymbol{
    public JavaFunctionSym(SymbolType symbolType, ResolvedValueDeclaration declaration,
                           List<String> modifiers) {
        super(symbolType, declaration, modifiers);
    }
}
