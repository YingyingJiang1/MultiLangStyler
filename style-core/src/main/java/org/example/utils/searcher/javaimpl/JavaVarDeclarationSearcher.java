package org.example.utils.searcher.javaimpl;

import org.example.parser.common.MyParser;
import org.example.parser.common.context.ExtendContext;
import org.example.utils.searcher.intf.VarDeclarationSearcher;

import java.util.ArrayList;
import java.util.List;

public class JavaVarDeclarationSearcher implements VarDeclarationSearcher {
    public JavaVarDeclarationSearcher() {}


    public List<ExtendContext> searchIdentifiers(ExtendContext decNode, MyParser parser) {
        List<ExtendContext> result = new ArrayList<>();
        List<ExtendContext> declaratorList = decNode.getAllCtxsRecIf(parser::isVariableDeclaratorId);
        for (ExtendContext declarator : declaratorList) {
            ExtendContext identifierNode = declarator.getFirstCtxChildIf(parser::isIdentifier);
            result.add(identifierNode);
        }
        return result;
    }

    @Override
    public ExtendContext searchInitializer(ExtendContext decNode, ExtendContext identifier, MyParser parser) {
        if (identifier.parent.parent instanceof ExtendContext ctx) {
            return ctx.getFirstCtxChildIf(parser::isVariableInitializer);
        }
        return null;
    }
}
