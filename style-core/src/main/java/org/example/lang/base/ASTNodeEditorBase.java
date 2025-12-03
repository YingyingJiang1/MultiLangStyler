package org.example.lang.base;

import org.antlr.v4.runtime.tree.TerminalNode;
import org.example.antlr.common.context.ExtendContext;
import org.example.lang.intf.ASTNodeEditor;
import org.example.lang.intf.MyParser;

public class ASTNodeEditorBase implements ASTNodeEditor {
	private static ASTNodeEditorBase instance = new ASTNodeEditorBase();

	protected ASTNodeEditorBase() {}

	public static ASTNodeEditorBase getInstance() {
		return instance;
	}


	@Override
	public void updateHierarchy(ExtendContext node)  {
		if (node.getParent() == null) return;
		if (node.getParent() == null) {
			node.hierarchy = 0;
			return;
		}

		ExtendContext parent = (ExtendContext) node.getParent();

		processGeneralIndentCase(node, this.getParser());
		// Note: The following call overrides the result produced by the previous function.
		processForLang(node, this.getParser());
	}

	/**
	 * Handles the general indentation case for the given node.
	 * */
	protected void processGeneralIndentCase(ExtendContext node, MyParser parser) {
		ExtendContext parent = (ExtendContext) node.getParent();
		int parentRule = parent.getRuleIndex();
		if (parser.getRuleIfElseStmt() == parentRule) {
			if (parser.isBlock(parser.getSpecificStmt(node))) {
				node.hierarchy = parent.hierarchy;
			} else {
				boolean ifLeftOfElse = parent.children.indexOf(node) < parent.children.size() - 1;
				int rule = parser.getSpecificStmtType(node);
				if (ifLeftOfElse || (parser.getRuleIfElseStmt() != rule && parser.getRuleIfStmt() != rule)) {
					node.hierarchy = parent.hierarchy + 1;
				} else {
					node.hierarchy = parent.hierarchy;
				}
			}
			return;
		}

		if (isBracedContent(node)
				|| isUnderLabeledElement(node) || isSubStmt(node)) {
			node.hierarchy = parent.hierarchy + 1;
		} else {
			node.hierarchy = parent.hierarchy;
		}
	}


	/**
	 * Handle the given node differently for different languages
	 */
	protected void processForLang(ExtendContext node, MyParser parser) {
	}

	/**
	 *
	 * @return {@code true} if the node is wrapped by {} (such as function body, type declaration body); {@code false} otherwise
	 */
	protected boolean isBracedContent(ExtendContext node) {
		ExtendContext parent = (ExtendContext) node.getParent();
		int index = parent.indexOfIf(t -> t == node);

		int leftBraceIndex = parent.indexOfIf(t -> t instanceof TerminalNode terminal && terminal.getText().equals("{"));
		if (leftBraceIndex < 0 || leftBraceIndex >= index) {
			return false;
		}

		for (int i = parent.getChildCount() - 1; i > index; i--) {
			if (parent.getChild(i) instanceof TerminalNode terminalNode && terminalNode.getText().equals("}")) {
				return true;
			}
		}

		return false;
	}

	protected boolean isUnderLabeledElement(ExtendContext node) {
		return false;
	}

	/**
	 * @return {@code true} if the node is a sub-statement and not a block statement; {@code false} otherwise
	 */
	protected boolean isSubStmt(ExtendContext node) {
		return false;
	}

	protected MyParser getParser() {
		return null;
	}
}
