package org.example.lang.intf.symbol;

import org.example.lang.intf.MyParser;
import org.example.antlr.common.context.ExtendContext;
import org.example.semantic.intf.type.Type;

public interface TypeResolver {
	Type getType(ExtendContext node, MyParser parser);

	Type calculateType(Type t1, Type t2, String operator, MyParser parser);

}
