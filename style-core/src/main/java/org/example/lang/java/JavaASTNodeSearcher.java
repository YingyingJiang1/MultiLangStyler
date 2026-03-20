package org.example.lang.java;

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.example.antlr.common.context.ExtendContext;
import org.example.antlr.java.JavaParser;
import org.example.lang.intf.ASTNodeSearcher;

import java.util.List;

public class JavaASTNodeSearcher implements ASTNodeSearcher {
	private static JavaASTNodeSearcher instance = new JavaASTNodeSearcher();

	private JavaASTNodeSearcher() {}

	public static JavaASTNodeSearcher getInstance() {
		return instance;
	}

	@Override
	public List<ParseTree> searchAllModifiers(ExtendContext ctx) {
		if (ctx instanceof JavaParser.ModifierListContext) {
			return List.copyOf(ctx.children);
		}

		List<ParseTree> modifiers = new java.util.ArrayList<>();
		for (ParseTree child : ctx.children) {
			if (child instanceof TerminalNode terminalNode && isModifier(terminalNode)) {
				modifiers.add(child);
			}
		}
		return modifiers;
	}

	private boolean isModifier(TerminalNode node) {
		int type = node.getSymbol().getType();
		return type == JavaParser.PUBLIC || type == JavaParser.PROTECTED || type == JavaParser.PRIVATE || type == JavaParser.STATIC || type == JavaParser.ABSTRACT
				|| type == JavaParser.FINAL || type == JavaParser.STRICTFP || type == JavaParser.SEALED || type == JavaParser.NON_SEALED || type == JavaParser.NATIVE
				|| type == JavaParser.SYNCHRONIZED || type == JavaParser.TRANSIENT || type == JavaParser.VOLATILE;
	}
}
