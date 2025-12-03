package org.example.lang.intf;

import org.antlr.v4.runtime.Token;

import java.util.List;

public interface CodeContextPredicate {
	/**
	 * Return true if the current token is the first token on its line.
	 * <p>
	 * The default implementation relies on the token's character position within the line.
	 * Ensure that this position value is valid when using the default behavior.
	 */
	boolean isIndentionContext(List<Token> tokens, int i, MyParser parser);

	/**
	 * Return true if the current token is a default token, and both the token
	 * itself and its next adjacent default token are neither identifiers nor keywords.
	 * <p>
	 * A default token is any token that is not whitespace, newline, or comment.
	 */
	boolean isSpaceContext(List<Token> tokens, int i, MyParser parser);


}
