package org.example.utils.editor;

import org.example.lang.intf.MyParser;
import org.example.antlr.common.context.ExtendContext;
import org.example.antlr.cpp.CPPParser;

public class CppNodeEditor implements NodeEditor{
	@Override
	public void updateHierarchy(MyParser parser, ExtendContext node) {
		if (node.getParent() == null) return;

		ExtendContext parent = (ExtendContext) node.getParent();
		int parentRule = parent.getRuleIndex();
		boolean isUnderCaseLabel = parent instanceof CPPParser.LabeledStatementContext && node instanceof CPPParser.StatementContext;
		if (parser.isBody(parent) || parser.isBlock(parent) || isUnderCaseLabel) {
			node.hierarchy = parent.hierarchy + 1;
		} else if (parser.getRuleIfElseStmt() == parentRule) {
			if (parser.isBlock(parser.getSpecificStmt(node))) {
				node.hierarchy = parent.hierarchy;
			} else {
				boolean ifLeftOfElse = parent instanceof CPPParser.IfElseStatementContext && parent.children.indexOf(node) < parent.children.size() - 1;
				ExtendContext specificStmt = parser.getSpecificStmt(node);
				if (ifLeftOfElse || !(specificStmt instanceof CPPParser.IfElseStatementContext || specificStmt instanceof CPPParser.IfStatementContext)) {
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
