package org.example.lang.java;

import org.example.antlr.cpp.CPPParser;
import org.example.lang.base.ASTNodeEditorBase;
import org.example.lang.intf.MyParser;
import org.example.antlr.common.context.ExtendContext;
import org.example.antlr.java.JavaParser;

public class JavaASTNodeEditor extends ASTNodeEditorBase {
	private static MyParser parser = new MyJavaParser();
	private static JavaASTNodeEditor instance = new JavaASTNodeEditor();

	private JavaASTNodeEditor() {}

	public static JavaASTNodeEditor getInstance() {
		return instance;
	}

//	@Override
//	protected boolean isBracedContent(ExtendContext node) {
//		ExtendContext parent = (ExtendContext) node.getParent();
//		return parent instanceof JavaParser.BodyContext || parent instanceof JavaParser.BlockContext;
//	}

	@Override
	protected boolean isUnderLabeledElement(ExtendContext node) {
		ExtendContext parent = (ExtendContext) node.getParent();
		return (parent instanceof JavaParser.SwitchLabeledRuleContext || parent instanceof JavaParser.SwitchBlockStatementGroupContext || parent instanceof JavaParser.LabelStmtContext)
				&& (node instanceof JavaParser.TypeDeclarationContext || node instanceof JavaParser.StatementContext);
	}

	@Override
	protected boolean isSubStmt(ExtendContext node) {
		ExtendContext parent = (ExtendContext) node.getParent();
		return parser.belongToCompoundStmt(parent) && node instanceof JavaParser.StatementContext && !(parser.getSpecificStmt(node) instanceof JavaParser.BlockContext);
	}

	@Override
	protected MyParser getParser() {
		return parser;
	}
}
