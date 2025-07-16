package org.example.parser.common.factory.context;

import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.example.parser.common.context.ExtendContext;

public interface TreeNodeFactory {
    ExtendContext createBlock(ExtendContext parent);
    ExtendContext createStatement(ExtendContext parent);
    ExtendContext createExpressionList(ExtendContext parent);
    TerminalNode createTerminal(Token symbol);

    ExtendContext createFieldDeclarationList(ExtendContext parent);
}
