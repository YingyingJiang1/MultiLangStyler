package org.example.lang.intf;

import org.antlr.v4.runtime.Token;

import java.util.List;

public interface CodeContextPredicate {
	boolean isIndentionContext(List<Token> tokens, int i, MyParser parser);
	boolean isSpaceContext(List<Token> tokens, int i, MyParser parser);


}
