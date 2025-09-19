package org.example.utils.searcher.javaimpl;

import org.example.parser.common.MyParser;
import org.example.parser.common.context.ExtendContext;
import org.example.parser.java.antlr.JavaParser;
import org.example.utils.searcher.intf.ExpressionSearcher;

public class JavaExpressionSearcher implements ExpressionSearcher {

	@Override
	public ExtendContext searchFunctionCall(ExtendContext exp, MyParser parser) {
		ExtendContext target = exp.getFirstContextRecIf(t -> t instanceof JavaParser.MethodCallContext || t instanceof JavaParser.ClassCreatorRestContext);
		return target == null ? null : target.findFirstParentIf(t -> t instanceof JavaParser.ExpressionContext);
	}
}
