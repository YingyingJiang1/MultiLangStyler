package org.example.lang.cpp;

import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.antlr.v4.runtime.tree.TerminalNodeImpl;
import org.example.antlr.common.context.ExtendContext;
import org.example.lang.intf.TreeNodeFactory;
import org.example.antlr.cpp.CPPParser;
import org.example.antlr.java.JavaParser;
import org.w3c.dom.xpath.XPathNSResolver;

public class CppTreeNodeFactory implements TreeNodeFactory {
	private static final CppTreeNodeFactory instance = new CppTreeNodeFactory();

	private CppTreeNodeFactory() {}

	public static CppTreeNodeFactory getInstance() {
		return instance;
	}

	@Override
	public ExtendContext createBlock(ExtendContext parent) {
		return new JavaParser.BlockContext(parent, parent == null ? -1 : parent.invokingState);
	}

	@Override
	public ExtendContext createStatement(ExtendContext parent) {
		return new CPPParser.StatementContext(parent, parent == null ? -1 : parent.invokingState);
	}

	@Override
	public ExtendContext createExpression(ExtendContext parent) {
		return new CPPParser.ExpressionContext(parent, parent == null ? -1 : parent.invokingState);
	}

	@Override
	public ExtendContext createExpressionList(ExtendContext parent) {
		return new CPPParser.ExpressionListContext(parent, parent == null ? -1 : parent.invokingState);
	}


	@Override
	public TerminalNode createTerminal(Token symbol) {
		return new TerminalNodeImpl(symbol);
	}

	@Override
	public ExtendContext createFieldDeclarationList(ExtendContext parent) {
		return new JavaParser.FieldDeclarationListContext(parent, parent == null ? -1 : parent.invokingState);
	}
}
