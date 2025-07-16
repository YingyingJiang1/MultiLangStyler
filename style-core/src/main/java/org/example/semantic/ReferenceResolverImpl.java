package org.example.semantic;

import org.example.parser.common.MyParser;
import org.example.parser.common.context.ExtendContext;
import org.example.semantic.intf.ReferenceResolver;
import org.example.semantic.intf.symbol.Symbol;

import java.util.ArrayList;
import java.util.List;

public class ReferenceResolverImpl implements ReferenceResolver {
    @Override
    public List<ExtendContext> resolveReference(Symbol symbol, MyParser parser) {
        System.out.println("ReferenceResolverImpl@resolveReference is called, implement it!");
        return new ArrayList<>();
    }
}
