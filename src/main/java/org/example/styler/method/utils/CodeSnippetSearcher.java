package org.example.styler.method.utils;

import org.example.parser.common.context.ExtendContext;

import java.util.List;

public class CodeSnippetSearcher {
	List<ExtendContext> statementList;
	int slideWindow;

	public CodeSnippetSearcher(List<ExtendContext> statementList, int slideWindow) {
		this.statementList = statementList;
		this.slideWindow = slideWindow;
	}



	static class CodeSnippet {
		int startIndex, endIndex; // start and end index of statement in a statement list.

	}


}
