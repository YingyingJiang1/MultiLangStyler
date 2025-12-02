package org.example.lang.intf;

import org.antlr.v4.runtime.Token;
import org.example.antlr.common.context.RuleGroup;
import org.example.antlr.common.token.TokenGroup;

public interface FormatUnitGrouper {
	TokenGroup getTokenGroup(Token token, MyParser parser);

	RuleGroup getRuleGroup();
}
