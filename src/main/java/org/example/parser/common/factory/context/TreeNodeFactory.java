package org.example.parser.common.factory.context;

import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenFactory;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.example.parser.common.ExtendContext;
import org.example.parser.common.ExtendToken;

public interface TreeNodeFactory {
    ExtendContext createBlock(ExtendContext parent);
    TerminalNode createTerminal(Token symbol);
}
