package org.example.semantic.intf;

import org.example.parser.common.MyParser;
import org.example.parser.common.context.ExtendContext;
import org.example.semantic.intf.type.Type;

public interface TypeResolver {
	Type getType(ExtendContext node, MyParser parser);

	Type calculateType(Type t1, Type t2, String operator, MyParser parser);

}
