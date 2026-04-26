package org.example.lang.base;

import org.antlr.v4.runtime.tree.ParseTree;
import org.example.antlr.common.context.ExtendContext;
import org.example.lang.intf.ASTNodeSearcher;

import java.util.List;

public class ASTNodeSearcherBase implements ASTNodeSearcher {
	private static final ASTNodeSearcherBase instance = new ASTNodeSearcherBase();

	private ASTNodeSearcherBase() {}

	public static ASTNodeSearcherBase getInstance() {
		return instance;
	}

	@Override
	public List<ParseTree> searchAllModifiers(ExtendContext ctx) {
		return List.of();
	}

	@Override
	public List<ParseTree> searchAllDeclaredIdentifiers(ExtendContext ctx) {
		return List.of();
	}



}
