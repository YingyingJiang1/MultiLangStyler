package org.example.lang.intf.searcher;

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.example.lang.intf.MyParser;
import org.example.antlr.common.context.ExtendContext;

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
    ExtendContext searchInitializerNode(ExtendContext decNode, ExtendContext identifier, MyParser parser);

    ParseTree searchTypeNode(ExtendContext decNode, MyParser parser);

    ExtendContext searchVarDeclaratorsNode(ExtendContext decNode, MyParser parser);

    List<TerminalNode> searchModifiers(ExtendContext decNode, MyParser parser);

    List<ExtendContext> searchVarDeclaratorList(ExtendContext decNode, MyParser parser);
}
