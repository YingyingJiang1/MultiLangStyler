package org.example.lang.python;

import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.antlr.v4.runtime.tree.TerminalNodeImpl;
import org.example.antlr.common.context.ExtendContext;
import org.example.antlr.python.PythonParser;
import org.example.lang.intf.TreeNodeFactory;

public class PythonTreeNodeFactory implements TreeNodeFactory {
	@Override
	public ExtendContext createBlock(ExtendContext parent) {
		return new PythonParser.BlockContext(parent, parent == null ? -1 : parent.invokingState);
	}

	@Override
	public ExtendContext createStatement(ExtendContext parent) {
		return new PythonParser.StatementContext(parent, parent == null ? -1 : parent.invokingState);
	}

	@Override
	public ExtendContext createExpression(ExtendContext parent) {
		return new PythonParser.ExpressionContext(parent, parent == null ? -1 : parent.invokingState);
	}

	@Override
	public ExtendContext createExpressionList(ExtendContext parent) {
		return null;
	}

	@Override
	public TerminalNode createTerminal(Token symbol) {
		return new TerminalNodeImpl(symbol);
	}

	@Override
	public ExtendContext createFieldDeclarationList(ExtendContext parent) {
		return null;
	}
}
