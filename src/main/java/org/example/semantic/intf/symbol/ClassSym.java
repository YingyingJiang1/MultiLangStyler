package org.example.semantic.intf.symbol;

import org.example.parser.common.context.ExtendContext;
import org.example.styler.naming.NameType;

import java.util.ArrayList;
import java.util.List;

public class ClassSym extends Symbol{
    List<ExtendContext> parents; // parents are stored as type nodes.
    String path;
    List<Symbol> typeParameters = new ArrayList<>();
    Symbol outerClass;

    public ClassSym(List<ExtendContext> parents, String path, List<Symbol> typeParameters, Symbol outerClass,
                    ExtendContext astNode, ExtendContext modifierListNode, NameType nameType) {
        super(astNode, modifierListNode, nameType);
        this.parents = parents;
        this.path = path;
        this.typeParameters = typeParameters;
        this.outerClass = outerClass;
    }

    public ClassSym(String text) {
        super(null, null, NameType.TYPE);
        this.text = text;
    }

    public String getQualifiedName() {
        StringBuilder qualifiedName = new StringBuilder();
        qualifiedName.append(path);

        Symbol outerClassSym = this.outerClass;
        while (outerClassSym != null) {
            qualifiedName.append(".").append(outerClassSym.getText());
            outerClassSym = ((ClassSym) outerClassSym).outerClass;
        }
        qualifiedName.append(".").append(getText());
        return qualifiedName.toString();
    }
}
