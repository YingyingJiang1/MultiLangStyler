package org.example.lang.cpp;

import org.example.antlr.cpp.CPPParser;
import org.example.antlr.java.JavaParser;
import org.example.lang.base.ASTNodeEditorBase;
import org.example.lang.intf.MyParser;
import org.example.antlr.common.context.ExtendContext;

public class CppASTNodeEditor extends ASTNodeEditorBase {
	protected MyParser parser = new MyCppParser();
	private static CppASTNodeEditor instance = new CppASTNodeEditor();

	public static CppASTNodeEditor getInstance() {
		return instance;
	}

	@Override
	protected boolean isUnderLabeledElement(ExtendContext node) {
		return node.getParent() instanceof CPPParser.LabeledStatementContext && node instanceof CPPParser.StatementContext &&
				!(parser.getSpecificStmt(node) instanceof CPPParser.BlockContext); // 排除block statement
	}


	@Override
	protected boolean isSubStmt(ExtendContext node) {
		ExtendContext parent = (ExtendContext) node.getParent();
		return parser.belongToCompoundStmt(parent) && node instanceof CPPParser.StatementContext && !(parser.getSpecificStmt(node) instanceof CPPParser.BlockContext);
	}

	@Override
	protected MyParser getParser() {
		return parser;
	}
}
