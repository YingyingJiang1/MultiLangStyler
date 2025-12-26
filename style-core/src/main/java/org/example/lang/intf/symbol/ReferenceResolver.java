package org.example.lang.intf.symbol;

import org.example.lang.intf.MyParser;
import org.example.antlr.common.context.ExtendContext;
import org.example.semantic.intf.symbol.Symbol;

import java.util.List;

public interface ReferenceResolver {
    List<ExtendContext> resolveReference(Symbol symbol, MyParser parser);
}
