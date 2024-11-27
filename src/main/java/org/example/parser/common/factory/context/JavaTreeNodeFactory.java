package org.example.parser.common.factory.context;

import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.antlr.v4.runtime.tree.TerminalNodeImpl;
import org.example.parser.common.ExtendContext;
import org.example.parser.common.ExtendToken;
import org.example.parser.java.antlr.JavaParser;

public class JavaTreeNodeFactory implements TreeNodeFactory {
    private static JavaTreeNodeFactory instance = new JavaTreeNodeFactory();

    private JavaTreeNodeFactory() {}

    public static JavaTreeNodeFactory getInstance() {
        return instance;
    }

    @Override
    public ExtendContext createBlock(ExtendContext parent) {
        return new JavaParser.BlockContext(parent, parent.invokingState);
    }

    @Override
    public TerminalNode createTerminal(Token symbol) {
        return new TerminalNodeImpl(symbol);
    }
}
