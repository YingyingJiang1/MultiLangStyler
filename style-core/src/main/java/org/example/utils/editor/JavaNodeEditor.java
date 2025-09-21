package org.example.utils.editor;

import org.antlr.v4.runtime.tree.ParseTree;
import org.example.parser.common.MyParser;
import org.example.parser.common.context.ExtendContext;
import org.example.parser.java.antlr.JavaParser;

public class JavaNodeEditor implements NodeEditor {
//	@Override
//	public void updateHierarchy(MyParser parser, ExtendContext node)  {
//		for (int i = 0; i < node.children.size(); i++) {
//			if (node.children.get(i) instanceof ExtendContext childCtx) {
//				boolean isSubStmtOfCompoundStmt = parser.getCompoundStmts().contains(node.getRuleIndex())
//						&& parser.isStatement(childCtx)
//						&& !parser.isBlock(parser.getSpecificStmt(childCtx));
//				boolean isUnderCaseLabel = (node instanceof JavaParser.SwitchLabeledRuleContext || node instanceof JavaParser.SwitchBlockStatementGroupContext)
//						&& (childCtx instanceof JavaParser.TypeDeclarationContext || childCtx instanceof JavaParser.StatementContext);
//				if (parser.isBody(node) || parser.isBlock(node) || isSubStmtOfCompoundStmt || isUnderCaseLabel) {
//					childCtx.hierarchy = node.hierarchy + 1;
//				} else {
//					childCtx.hierarchy = node.hierarchy;
//				}
//			}
//		}
//	}

	@Override
	public void updateHierarchy(MyParser parser, ExtendContext node)  {
		if (node.getParent() == null) return;

		ExtendContext parent = (ExtendContext) node.getParent();
		int parentRule = parent.getRuleIndex();
		boolean isUnderCaseLabel = (parent instanceof JavaParser.SwitchLabeledRuleContext || parent instanceof JavaParser.SwitchBlockStatementGroupContext)
				&& (node instanceof JavaParser.TypeDeclarationContext || node instanceof JavaParser.StatementContext);
		if (parser.isBody(parent) || parser.isBlock(parent) || isUnderCaseLabel) {
			node.hierarchy = parent.hierarchy + 1;
		} else if (parser.getRuleIfElseStmt() == parentRule) {
			if (parser.isBlock(parser.getSpecificStmt(node))) {
				node.hierarchy = parent.hierarchy;
			} else {
				boolean ifLeftOfElse = parent instanceof JavaParser.IfElseStmtContext && parent.children.indexOf(node) < parent.children.size() - 1;
				int rule = parser.getSpecificStmtType(node);
				if (ifLeftOfElse || (parser.getRuleIfElseStmt() != rule && parser.getRuleIfStmt() != rule)) {
					node.hierarchy = parent.hierarchy + 1;
				} else {
					node.hierarchy = parent.hierarchy;
				}
			}

		} else if (parser.belongToCompoundStmt(parent) && parser.isStatement(node) && !parser.isBlock(parser.getSpecificStmt(node))) {
			node.hierarchy = parent.hierarchy + 1;
		} else {
			node.hierarchy = parent.hierarchy;
		}
	}
}
