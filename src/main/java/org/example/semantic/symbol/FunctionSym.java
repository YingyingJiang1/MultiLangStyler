package org.example.semantic.symbol;

import org.antlr.v4.runtime.tree.TerminalNode;
import org.example.parser.common.MyParser;
import org.example.parser.common.context.ExtendContext;
import org.example.semantic.type.Type;

import java.util.ArrayList;
import java.util.List;

public class FunctionSym extends Symbol{
    Type retType; // `retType` of constructor function is null.
    List<VarSym> param;

    public static FunctionSym createSym(ExtendContext declarationNode, MyParser parser) {
        ExtendContext methodHead = getFunctionHead(declarationNode, parser);
        FunctionSym functionSym = new FunctionSym(declarationNode,
                parseIdentifier(methodHead, parser),
                parseModifierKeywords(declarationNode, parser));
        functionSym.declarationNode = declarationNode;
        ExtendContext typeNode = declarationNode.getFirstCtxChildIf(t ->
                t instanceof ExtendContext ctx && parser.belongToFunctionHead(ctx.getRuleIndex()));
        functionSym.retType = typeNode == null ? null : parseType(typeNode, parser);
        functionSym.param = parseParams(methodHead, parser);
        for (VarSym param : functionSym.param) {
            param.setContainingSymbol(functionSym);
        }
        return functionSym;
    }

    private FunctionSym(ExtendContext declarationNode, TerminalNode identifier, List<String> modifiers) {
        super(declarationNode, identifier, modifiers);
    }


    public void addParam(VarSym symbol) {
        param.add(symbol);
    }

    private static List<VarSym> parseParams(ExtendContext functionHead, MyParser parser) {
        List<ExtendContext> formalParaList = functionHead.getAllContextsByTypeRec(parser.getRuleFormalParameter());
        List<VarSym> ret = new ArrayList<VarSym>();
        for (ExtendContext formalPara : formalParaList) {
            VarSym varSym = VarSym.createSym(formalPara, parser);
            ret.add(varSym);
        }
        return ret;
    }

    private static ExtendContext getFunctionHead(ExtendContext declarationNode, MyParser parser) {
        return (ExtendContext) declarationNode.getChild(1);
    }
}
