package org.example.semantic.javaimpl;

import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.body.VariableDeclarator;
import com.github.javaparser.resolution.declarations.ResolvedValueDeclaration;
import org.example.semantic.intf.ClassSym;
import org.example.styler.naming.SymbolType;

import java.util.List;

public class JavaClassSym extends JavaSymbol implements ClassSym {
    public JavaClassSym(SymbolType symbolType, ResolvedValueDeclaration declaration,
                        Node defNode) {
        super(symbolType, declaration, defNode);
    }
}
