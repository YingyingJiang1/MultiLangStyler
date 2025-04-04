package org.example.utils.searcher.intf;

import org.example.parser.common.MyParser;
import org.example.parser.common.context.ExtendContext;

import java.util.List;

public interface CompilationUnitSearcher {
    List<ExtendContext> searchImports(ExtendContext compilationUnit, MyParser parser);

    List<ExtendContext> searchAllTypeDecs(ExtendContext compilationUnit, MyParser parser);

    ExtendContext searchPackageName(ExtendContext compilationUnit, MyParser parser);

    int getIndexOfImportList(ExtendContext compilationUnit, MyParser parser);
}
