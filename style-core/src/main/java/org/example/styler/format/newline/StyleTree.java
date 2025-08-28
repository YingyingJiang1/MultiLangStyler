package org.example.styler.format.newline;

import org.antlr.v4.runtime.tree.ParseTree;

import java.util.List;

public class StyleTree {
}


class StyleNode {
	private String nodeName;
	private List<StyleNode> children;
	private List<ParseTree> astNodes;
}