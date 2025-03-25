package org.example.utils.searcher.javaimpl;

import org.example.global.GlobalInfo;
import org.example.parser.common.MyParser;
import org.example.parser.common.context.ExtendContext;
import org.example.semantic.intf.Resolver;
import org.example.utils.searcher.intf.DecStmtSearcher;

import java.util.ArrayList;
import java.util.List;

public class JavaDecStmtSearcher implements DecStmtSearcher {
    private static JavaDecStmtSearcher instance = new JavaDecStmtSearcher();

    private JavaDecStmtSearcher() {}

    public static JavaDecStmtSearcher getInstance() {
        return instance;
    }

    public List<ExtendContext> searchIdentifiers(ExtendContext decStmt, MyParser parser) {
        List<ExtendContext> result = new ArrayList<>();
        List<ExtendContext> declaratorList = decStmt.getAllContextsIf(ctx -> ctx.getRuleIndex() == parser.getRuleVariableDeclarator());
        for (ExtendContext declarator : declaratorList) {
            ExtendContext identifierNode = declarator.getFirstCtxChildIf(parser::isVariableDeclaratorId).getFirstInnerChildByType(parser.getRuleIdentifier());
            result.add(identifierNode);
        }
        return result;
    }

    @Override
    public ExtendContext searchInitializer(ExtendContext decStmt, ExtendContext identifier, MyParser parser) {
        if (identifier.parent.parent instanceof ExtendContext ctx) {
            return ctx.getFirstCtxChildIf(parser::isVariableInitializer);
        }
        return null;
    }
}
