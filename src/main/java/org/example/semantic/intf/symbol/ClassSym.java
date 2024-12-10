package org.example.semantic.intf.symbol;

import org.antlr.v4.runtime.tree.TerminalNode;
import org.example.parser.common.context.ExtendContext;
import org.example.styler.naming.SymbolType;

import java.util.ArrayList;
import java.util.List;

public class ClassSym extends Symbol{
    List<ExtendContext> parents; // parents are stored as type nodes.
    String path;
    List<Symbol> typeParameters = new ArrayList<>();
    Symbol outerClass;

    public ClassSym(List<ExtendContext> parents, String path, List<Symbol> typeParameters, Symbol outerClass,
                    TerminalNode astNode, ExtendContext modifierListNode, SymbolType symbolType) {
        super(astNode, modifierListNode, symbolType);
        this.parents = parents;
        this.path = path;
        this.typeParameters = typeParameters;
        this.outerClass = outerClass;
    }

    public String getQualifiedName() {
        StringBuilder qualifiedName = new StringBuilder();
        qualifiedName.append(path);

        Symbol outerClassSym = this.outerClass;
        while (outerClassSym != null) {
            qualifiedName.append(".").append(outerClassSym.getName());
            outerClassSym = ((ClassSym) outerClassSym).outerClass;
        }
        qualifiedName.append(".").append(getName());
        return qualifiedName.toString();
    }
}
