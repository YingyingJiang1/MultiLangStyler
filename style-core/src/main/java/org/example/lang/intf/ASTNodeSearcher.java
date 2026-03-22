package org.example.lang.intf;

import org.antlr.v4.runtime.tree.ParseTree;
import org.example.antlr.common.context.ExtendContext;

import java.util.List;

public interface ASTNodeSearcher {
	// Search for all modifier nodes in the given context.
	List<ParseTree> searchAllModifiers(ExtendContext ctx);

	/**
	 * Search all declared identifiers in the given context.
	 * e.g.: int a = c + 1, b = 2; then the result is [a, b].
	 */
	List<ParseTree> searchAllDeclaredIdentifiers(ExtendContext ctx);
}
