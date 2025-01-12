package org.example.utils.searcher.intf;

import org.example.parser.common.MyParser;
import org.example.parser.common.context.ExtendContext;

import java.util.List;

public interface DecStmtSearcher {
    /**
     *
     * @param decStmt specific declaration statement
     * @return all identifiers declared in the declaration statement
     */
    List<ExtendContext> searchIdentifiers(ExtendContext decStmt, MyParser parser);

    /**
     *
     * @param decStmt
     * @param identifier identifier declared in @decStmt
     * @param parser
     * @return initializer node of @identifier in @decStmt
     */
    ExtendContext searchInitializer(ExtendContext decStmt, ExtendContext identifier, MyParser parser);
}
