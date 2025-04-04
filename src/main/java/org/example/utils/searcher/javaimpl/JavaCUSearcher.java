package org.example.utils.searcher.javaimpl;

import org.antlr.v4.runtime.tree.ParseTree;
import org.example.parser.common.MyParser;
import org.example.parser.common.context.ExtendContext;
import org.example.parser.java.antlr.JavaParser;
import org.example.utils.searcher.intf.CompilationUnitSearcher;

import java.util.ArrayList;
import java.util.List;

public class JavaCUSearcher implements CompilationUnitSearcher {

    public JavaCUSearcher() {}


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
    public List<ExtendContext> searchAllTypeDecs(ExtendContext compilationUnit, MyParser parser) {
        ExtendContext decListNode = compilationUnit.getFirstCtxChildIf(parser::isTypeDeclarationList);
        return decListNode.getAllChildContextsIf(parser::isTypeDeclaration);
    }

    @Override
    public ExtendContext searchPackageName(ExtendContext compilationUnit, MyParser parser) {
        ExtendContext packageNode = compilationUnit.getFirstCtxChildIf(node -> node instanceof JavaParser.PackageDeclarationContext);
        if (packageNode == null) {
            return null;
        }
        return packageNode.getFirstCtxChildIf(node -> node instanceof JavaParser.QualifiedNameContext);
    }

    @Override
    public int getIndexOfImportList(ExtendContext compilationUnit, MyParser parser) {
        return compilationUnit.indexOfFirstInnerChildByType(parser.getRulePackageDeclaration()) + 1;
    }
}
