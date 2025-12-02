package org.example.lang.intf.searcher;

import org.antlr.v4.runtime.tree.ParseTree;
import org.example.lang.intf.MyParser;
import org.example.antlr.common.context.ExtendContext;

public interface TypeDecSearcher {
	ExtendContext searchName(ExtendContext typeDec, MyParser parser);

	ParseTree searchPublicModifier(ExtendContext typeDec, MyParser parser);
}
