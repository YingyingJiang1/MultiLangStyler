package org.example.utils.searcher.javaimpl;

import org.antlr.v4.runtime.tree.ParseTree;
import org.example.parser.common.MyParser;
import org.example.parser.common.context.ExtendContext;
import org.example.parser.java.antlr.JavaParser;
import org.example.utils.searcher.intf.TypeDecSearcher;

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
