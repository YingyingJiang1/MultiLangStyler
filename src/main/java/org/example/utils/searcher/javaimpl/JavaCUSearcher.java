package org.example.utils.searcher.javaimpl;

import org.antlr.v4.runtime.tree.ParseTree;
import org.example.parser.common.MyParser;
import org.example.parser.common.context.ExtendContext;
import org.example.utils.searcher.intf.CompilationUnitSearcher;

import java.util.ArrayList;
import java.util.List;

public class JavaCUSearcher implements CompilationUnitSearcher {
    private static JavaCUSearcher instance = new JavaCUSearcher();

    private JavaCUSearcher() {}

    public static JavaCUSearcher getInstance() {
        return instance;
    }

    @Override
    public List<ExtendContext> searchImports(ExtendContext compilationUnit, MyParser parser) {
        List<ExtendContext> result = new ArrayList<>();
        ExtendContext importList = compilationUnit.getFirstCtxChildIf(ctx -> ctx.getRuleIndex() == parser.getRuleImportDeclarationList());
        if (importList != null) {
            for (ParseTree child : importList.children) {
                result.add((ExtendContext) child);
            }
        }
        return result;
    }

    @Override
    public int getIndexOfImportList(ExtendContext compilationUnit, MyParser parser) {
        return compilationUnit.indexOfFirstInnerChildByType(parser.getRulePackageDeclaration()) + 1;
    }
}
