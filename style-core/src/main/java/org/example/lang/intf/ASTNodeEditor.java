package org.example.lang.intf;

import org.example.antlr.common.context.ExtendContext;

/**
 * Provides operations to modify the state of an AST node
 * without altering AST's structure.
 */
public interface ASTNodeEditor {
	/**
	 * Update the hierarchy of the given node.
	 */
	void updateHierarchy(ExtendContext node);
}
