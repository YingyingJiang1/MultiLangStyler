package org.example.semantic.intf;

import org.example.parser.common.MyParser;
import org.example.parser.common.context.ExtendContext;
import org.example.semantic.intf.symbol.Symbol;

import java.util.List;

public interface ReferenceResolver {
    List<ExtendContext> resolveReference(Symbol symbol, MyParser parser);
}
