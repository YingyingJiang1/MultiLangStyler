package org.example.lang.intf.searcher;

import org.example.lang.intf.MyParser;
import org.example.antlr.common.context.ExtendContext;

import java.util.List;

public interface CompilationUnitSearcher {
    List<ExtendContext> searchImports(ExtendContext compilationUnit, MyParser parser);

    List<ExtendContext> searchAllTypeDecs(ExtendContext compilationUnit, MyParser parser);

    ExtendContext searchPackageName(ExtendContext compilationUnit, MyParser parser);

    int getIndexOfImportList(ExtendContext compilationUnit, MyParser parser);
}
