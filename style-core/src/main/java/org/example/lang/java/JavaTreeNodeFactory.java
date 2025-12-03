package org.example.lang.java;

import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.antlr.v4.runtime.tree.TerminalNodeImpl;
import org.example.antlr.common.context.ExtendContext;
import org.example.lang.intf.TreeNodeFactory;
import org.example.antlr.java.JavaParser;

public class JavaTreeNodeFactory implements TreeNodeFactory {
    private static final JavaTreeNodeFactory instance = new JavaTreeNodeFactory();

    private JavaTreeNodeFactory() {}

    public static JavaTreeNodeFactory getInstance() {
        return instance;
    }

    @Override
    public ExtendContext createBlock(ExtendContext parent) {
        return new JavaParser.BlockContext(parent, parent == null ? -1 : parent.invokingState);
    }

    @Override
    public ExtendContext createStatement(ExtendContext parent) {
        return new JavaParser.StatementContext(parent, parent == null ? -1 : parent.invokingState);
    }

    @Override
    public ExtendContext createExpression(ExtendContext parent) {
        return new JavaParser.ExpressionContext(parent, parent == null ? -1 : parent.invokingState);
    }

    @Override
    public ExtendContext createExpressionList(ExtendContext parent) {
        return new JavaParser.ExpressionListContext(parent, -1);
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
