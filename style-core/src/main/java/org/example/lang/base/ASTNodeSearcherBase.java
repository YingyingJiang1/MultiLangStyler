package org.example.lang.base;

import org.antlr.v4.runtime.tree.ParseTree;
import org.example.antlr.common.context.ExtendContext;
import org.example.lang.intf.ASTNodeSearcher;

import java.util.List;

public class ASTNodeSearcherBase implements ASTNodeSearcher {
	@Override
	public List<ParseTree> searchAllModifiers(ExtendContext ctx) {
		return null;
	}

	@Override
	public List<ParseTree> searchAllDeclaredIdentifiers(ExtendContext ctx) {
		return null;
	}



}
