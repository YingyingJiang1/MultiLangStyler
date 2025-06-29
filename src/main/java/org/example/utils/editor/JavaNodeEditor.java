package org.example.utils.editor;

import org.example.parser.common.MyParser;
import org.example.parser.common.context.ExtendContext;
import org.example.parser.java.antlr.JavaParser;

public class JavaNodeEditor implements NodeEditor {
	@Override
	public void updateHierarchy(MyParser parser, ExtendContext node)  {
		for (int i = 0; i < node.children.size(); i++) {
			if (node.children.get(i) instanceof ExtendContext childCtx) {
				boolean isSubStmtOfCompoundStmt = parser.getCompoundStmts().contains(node.getRuleIndex())
						&& parser.isStatement(childCtx)
						&& !parser.isBlock(parser.getSpecificStmt(childCtx));
				boolean isUnderCaseLabel = (node instanceof JavaParser.SwitchLabeledRuleContext || node instanceof JavaParser.SwitchBlockStatementGroupContext)
						&& (childCtx instanceof JavaParser.TypeDeclarationContext || childCtx instanceof JavaParser.StatementContext);
				if (parser.isBody(node) || parser.isBlock(node) || isSubStmtOfCompoundStmt || isUnderCaseLabel) {
					childCtx.hierarchy = node.hierarchy + 1;
				} else {
					childCtx.hierarchy = node.hierarchy;
				}
			}
		}
	}
}
