package org.example.semantic;

import org.example.lang.intf.MyParser;
import org.example.antlr.common.context.ExtendContext;
import org.example.lang.intf.symbol.ReferenceResolver;
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
