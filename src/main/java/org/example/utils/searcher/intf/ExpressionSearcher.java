package org.example.utils.searcher.intf;

import org.example.parser.common.MyParser;
import org.example.parser.common.context.ExtendContext;

public interface ExpressionSearcher {
	/**
	 * @return the method call or constructor call expression
	 */
	ExtendContext searchFunctionCall(ExtendContext exp, MyParser parser);
}
