package org.example.semantic.javaimpl;

import com.github.javaparser.ast.Modifier;
import com.github.javaparser.ast.body.VariableDeclarator;
import com.github.javaparser.resolution.declarations.ResolvedValueDeclaration;
import org.example.semantic.intf.VarSym;
import org.example.styler.naming.SymbolType;

import java.util.List;

public class JavaVarSym extends JavaSymbol implements VarSym {

    public JavaVarSym(SymbolType symbolType, ResolvedValueDeclaration declaration,
                      List<String> modifiers) {
        super(symbolType, declaration, modifiers);
    }


    @Override
    public String getTypeName() {
        return declaration.getType().describe();
    }

    @Override
    public String getFullTypeName() {
        return declaration.getType().describe();
    }

    @Override
    public boolean isPrimitive() {
        return declaration.getType().isPrimitive();
    }

    @Override
    public boolean isReference() {
        return declaration.getType().isReferenceType();
    }

    @Override
    public boolean isConst() {
        return false;
    }

}
