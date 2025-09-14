package org.example.utils.searcher.intf;

import org.example.parser.common.MyParser;
import org.example.parser.common.context.ExtendContext;

import java.util.List;

public interface VarDeclarationSearcher {
    /**
     *
     * @param decNode specific declaration statement or declaration node
     * @return all identifiers declared in the declaration statement
     */
    List<ExtendContext> searchIdentifiers(ExtendContext decNode, MyParser parser);

    /**
     *
     * @param decNode specific declaration statement or declaration node
     * @param identifier identifier declared in @decNode
     * @param parser
     * @return initializer node of @identifier in @decNode
     */
    ExtendContext searchInitializer(ExtendContext decNode, ExtendContext identifier, MyParser parser);
}
