package org.example.semantic.symbol;

import org.antlr.v4.runtime.tree.TerminalNode;
import org.example.parser.common.MyParser;
import org.example.parser.common.context.ExtendContext;
import org.example.semantic.type.PrimitiveType;
import org.example.semantic.type.Type;

import java.util.List;

public class VarSym extends Symbol {
    Type type;

    public static VarSym createSym(ExtendContext declarationNode, MyParser parser) {
        VarSym varSym = new VarSym(declarationNode, parseIdentifier(declarationNode, parser),
                parseModifierKeywords(declarationNode, parser));
        ExtendContext typeNode = getTypeNode(declarationNode, parser);
        varSym.type = parseType(typeNode, parser);
        return varSym;
    }

    private VarSym(ExtendContext declarationNode, TerminalNode identifier, List<String> modifiers) {
        super(declarationNode, identifier, modifiers);
    }

    public boolean isConst(String constKeyword) {
        return modifiers.contains(constKeyword);
    }

    public boolean isPrimitiveType() {
        return type instanceof PrimitiveType;
    }

    public String getTypeName() {
        return type.getName();
    }

    public Type getType() {
        return type;
    }

    private static ExtendContext getTypeNode(ExtendContext declarationNode, MyParser parser) {
        return declarationNode.getFirstCtxChildIf(t ->
                t instanceof ExtendContext ctx && ctx.getRuleIndex() == parser.getRuleTypeType()
        || t instanceof TerminalNode ter && ter.getText().equals("var"));
    }
}
