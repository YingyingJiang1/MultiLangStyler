package org.example.lang.java.searcher;

import org.example.lang.intf.MyParser;
import org.example.antlr.common.context.ExtendContext;
import org.example.antlr.java.JavaParser;
import org.example.lang.intf.searcher.ExpressionSearcher;

public class JavaExpressionSearcher implements ExpressionSearcher {

	@Override
	public ExtendContext searchFunctionCall(ExtendContext exp, MyParser parser) {
		ExtendContext target = exp.getFirstContextRecIf(t -> t instanceof JavaParser.MethodCallContext || t instanceof JavaParser.ClassCreatorRestContext);
		return target == null ? null : target.findFirstParentIf(t -> t instanceof JavaParser.ExpressionContext);
	}
}
