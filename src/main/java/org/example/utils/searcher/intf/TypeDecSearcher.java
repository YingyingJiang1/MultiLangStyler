package org.example.utils.searcher.intf;

import org.antlr.v4.runtime.tree.ParseTree;
import org.example.parser.common.MyParser;
import org.example.parser.common.context.ExtendContext;

public interface TypeDecSearcher {
	ExtendContext searchName(ExtendContext typeDec, MyParser parser);

	ParseTree searchPublicModifier(ExtendContext typeDec, MyParser parser);
}
