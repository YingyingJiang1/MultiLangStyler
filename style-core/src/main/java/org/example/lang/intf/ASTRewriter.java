package org.example.lang.intf;

import org.example.antlr.common.context.ExtendContext;

import java.util.List;

/**
 * Provides operations to rewrite subtrees of an AST.
 *
 * <p>Each method produces a new subtree that can replace the original subtree
 * in the parent node. Original AST nodes are reused in newly created tree if necessary.</p>
 */
public interface ASTRewriter {

	/**
	 * Creates a new subtree representing the logical negation of the given expression.
	 *
	 * @param expCtx the expression to negate
	 * @param parser parser instance for creating new AST nodes
	 * @return root node of the newly created negated expression subtree
	 */
	ExtendContext negateExpression(ExtendContext expCtx, MyParser parser);

	/**
	 * Creates a new subtree representing the negation of the given expression,
	 * applying operator-aware simplifications (e.g., replacing {@code a == b} with {@code a != b}).
	 *
	 * @param expCtx the expression to negate
	 * @param parser parser instance for creating new AST nodes
	 * @return root node of the newly created negated expression subtree
	 */
	ExtendContext negateExpressionSmart(ExtendContext expCtx, MyParser parser);

	/**
	 * Wraps the given expression in parentheses, producing a new subtree.
	 *
	 * @param expCtx the expression to parenthesize
	 * @param parser parser instance for creating new AST nodes
	 * @return root node of the newly created parenthesized expression subtree
	 */
	ExtendContext encapsulateExpWithParen(ExtendContext expCtx, MyParser parser);

	/**
	 * Wraps the given statement in braces, producing a new block statement subtree.
	 *
	 * @param stmtCtx the statement to wrap
	 * @param parser parser instance for creating new AST nodes
	 * @return root node of the newly created braced statement subtree
	 */
	ExtendContext encapsulateStmtWithBrace(ExtendContext stmtCtx, MyParser parser);

	/**
	 * Produces a new subtree corresponding to the statement with its surrounding braces removed.
	 *
	 * @param stmtCtx the braced statement to unwrap
	 * @param parser parser instance for creating new AST nodes
	 * @return root node of the unbraced statement subtree
	 */
	ExtendContext removeBraceOfStmt(ExtendContext stmtCtx, MyParser parser);

	/**
	 * Merges multiple variable declaration statements into a single new declaration subtree.
	 *
	 * @param decGroup list of variable declarations to merge
	 * @param parser parser instance for creating new AST nodes
	 * @return root node of the merged variable declaration subtree
	 */
	ExtendContext mergeVarDeclarations(List<ExtendContext> decGroup, MyParser parser);

	/**
	 * Splits a variable declaration statement into multiple new declaration subtrees.
	 *
	 * @param decGroup list of variable declarations to split
	 * @param parser parser instance for creating new AST nodes
	 * @return root node of the first resulting declaration subtree
	 */
	ExtendContext splitVarDeclarations(List<ExtendContext> decGroup, MyParser parser);
}
