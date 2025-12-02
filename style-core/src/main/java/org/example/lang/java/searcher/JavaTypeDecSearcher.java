package org.example.lang.java.searcher;

import org.antlr.v4.runtime.tree.ParseTree;
import org.example.lang.intf.MyParser;
import org.example.antlr.common.context.ExtendContext;
import org.example.antlr.java.JavaParser;
import org.example.lang.intf.searcher.TypeDecSearcher;

public class JavaTypeDecSearcher implements TypeDecSearcher {

	@Override
	public ExtendContext searchName(ExtendContext typeDec, MyParser parser) {
		if (typeDec.getChild(1) instanceof ExtendContext headNode) {
			return headNode.getFirstCtxChildIf(parser::isIdentifier);
		}
		return null;
	}

	@Override
	public ParseTree searchPublicModifier(ExtendContext typeDec, MyParser parser) {
		if (typeDec.getChild(0) instanceof ExtendContext modifierListNode) {
			return modifierListNode.getFirstTerChildByType(JavaParser.PUBLIC);
		}
		return null;
	}
}
