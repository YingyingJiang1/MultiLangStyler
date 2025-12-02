package org.example.lang.intf.searcher;

import org.example.lang.intf.MyParser;
import org.example.antlr.common.context.ExtendContext;

public interface ExpressionSearcher {
	/**
	 * @return the method call or constructor call expression
	 */
	ExtendContext searchFunctionCall(ExtendContext exp, MyParser parser);
}
