package org.example.lang.intf;

import org.antlr.v4.runtime.tree.ParseTree;
import org.example.antlr.common.context.ExtendContext;

import java.util.List;

/**
 * @description: Interface for searching specific AST nodes in a given context.
 * Default implementation is to search direct children of the given context, but it can be implemented in a more flexible way if needed.
 */
public interface ASTNodeSearcher {
	List<ParseTree> searchAllModifiers(ExtendContext ctx);
}
