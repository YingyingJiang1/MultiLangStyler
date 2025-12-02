package org.example.lang.intf;

import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.example.antlr.common.context.ExtendContext;

public interface TreeNodeFactory {
    ExtendContext createBlock(ExtendContext parent);
    ExtendContext createStatement(ExtendContext parent);
    ExtendContext createExpression(ExtendContext parent);
    ExtendContext createExpressionList(ExtendContext parent);
    TerminalNode createTerminal(Token symbol);

    ExtendContext createFieldDeclarationList(ExtendContext parent);
}
