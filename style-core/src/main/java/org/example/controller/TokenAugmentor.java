package org.example.controller;

import org.antlr.v4.runtime.CommonToken;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.example.parser.common.AntlrHelper;
import org.example.parser.common.MyParser;
import org.example.parser.common.context.ExtendContext;
import org.example.parser.common.token.AmbigousToken;
import org.example.parser.common.token.ExtendToken;
import org.example.parser.java.antlr.JavaLexer;
import org.example.styler.Stage;
import org.example.utils.TokenStreamUtil;
import org.example.utils.editor.NodeEditorFactory;

import java.util.*;

/*
 * @description
 * @author       Yingying Jiang
 * @create       2024/3/30 20:57
 */
public class TokenAugmentor {
	int curNestingDepth = 0;

	public static void restoreState(List<Token> tokens, MyParser parser) {
		Set<Integer> ambiguousTokens = Set.of(
				parser.getLT(), parser.getGT(), parser.getSub(), parser.getMul()
		);
		for (Token token : tokens) {
			if (ambiguousTokens.contains(token.getType()) && token instanceof ExtendToken extendToken) {
				Optional<AmbigousToken> ambigousTokenEnum = Arrays.stream(AmbigousToken.values())
						.filter(e -> e.name().equals(token.getText())).findAny();
				ambigousTokenEnum.ifPresent(ambigousToken -> extendToken.setText(ambigousToken.getValue()));
			}
		}
	}


	private static  void traverseTree(ParseTree node, MyParser parser) {
		if (node instanceof ExtendContext ctx) {
			NodeEditorFactory.createASTEditor(parser.getLanguage()).updateHierarchy(parser, ctx);
			for (int i = 0; i < node.getChildCount(); i++) {
				traverseTree(node.getChild(i), parser);
			}
		}
	}


//
//  private static  void processBrace(CommonTokenStream tokenStream, int curIndex) {
//    if(!AntlrHelper.isBrace(tokenStream.get(curIndex))) {
//      return;
//    }
//
//    // Extract line break information before and after brace.
//    TokenInfoField.BraceTokenInfo info = new TokenInfoField.BraceTokenInfo();
//    info.before = getBeforeNewlineInfo(tokenStream, curIndex);
//    info.after = getAfterNewlineInfo(tokenStream, curIndex);
//    ((ExtendToken) tokenStream.get(curIndex)).info = info;
//  }


	/**
	 * Treat syntax-independent tokens(hws, vws and comments) as context tokens.
	 * Add comment tokens to the context tokens of first or last token of the commented code.
	 * Add format tokens to the context tokens of the first syntax-dependent token before the format tokens.
	 * @param parser
	 */
	public static void addContextTokens(MyParser parser) {
		CommonTokenStream tokenStream = (CommonTokenStream) parser.getTokenStream();
		List<Token> tokens = tokenStream.getTokens();

		Token firstDefaultToken = TokenStreamUtil.findFirstDefaultTokenOnRight(tokens, -1, parser);
		if (firstDefaultToken == null) {
			return;
		}

		int index = tokens.indexOf(firstDefaultToken);
		if (firstDefaultToken instanceof ExtendToken ext) {
			List<Token> nonDefaultToken = tokens.subList(0, index);
			ext.getContextTokens().addAll(0, nonDefaultToken);
		}

		for (int i = 0; i < tokens.size(); i++) {
			ExtendToken token = (ExtendToken) tokens.get(i);
			if (token.getChannel() != parser.getDefaultChannel()) {
				continue;
			}


			List<Token> contextTokens = TokenStreamUtil.findAllSyntaxIndependentTokensOnRight(tokens, i, parser);
			if (contextTokens.isEmpty()) {
				continue;
			}
			int insertionPoint = token.indexInContextTokens() + 1;
			token.addTokens(insertionPoint, contextTokens);
		}

	}

//	public static void addContextTokens(MyParser parser, CommonTokenStream tokenStream, int tokenIndex) {
//		ExtendToken token = (ExtendToken) tokenStream.get(tokenIndex);
//
//		List<Token> contextTokens = tokenStream.getHiddenTokensToRight(tokenIndex);
//		if (contextTokens == null) {
//			return;
//		}
//
//		// Find the first comment that is not trailing, tokens before the comment token are the context tokens of current default token,
//		int i = 0;
//		boolean isTrailingComment = true;
//
//		for (; i < contextTokens.size(); i++) {
//			Token ct = contextTokens.get(i);
//			if (!isTrailingComment || parser.belongToComment(ct.getType())) {
//				break;
//			}
//			if (ct.getText().endsWith("\n")) {
//				isTrailingComment = false;
//			}
//		}
//
//		int insertionPoint = token.indexInContextTokens() + 1;
//		ExtendToken nextToken = tokenIndex + contextTokens.size() >= tokenStream.size() ?
//				token : (ExtendToken) tokenStream.get(tokenIndex + contextTokens.size() + 1);
//		int nextIP = 0;
//		if (nextToken == token) {
//			nextIP = token.getContextTokens().size();
//		}
//		if (isTrailingComment && i < contextTokens.size()) {
//			token.addTokens(insertionPoint, contextTokens.subList(0, i + 1));
//			nextToken.addTokens(nextIP, contextTokens.subList(i + 1, contextTokens.size()));
//		} else {
//			nextToken.addTokens(nextIP, contextTokens);
//		}
//	}



	/**
	 * Add comment tokens to the first or last token of the commented code
	 * @param tokenStream
	 * @param tokenIndex
	 */
	public static void processComment(MyParser parser, CommonTokenStream tokenStream, int tokenIndex) {
		ExtendToken token = (ExtendToken) tokenStream.get(tokenIndex);
		if (token.getChannel() != JavaLexer.DEFAULT_TOKEN_CHANNEL) {
			return;
		}

		List<Token> comments = tokenStream.getHiddenTokensToLeft(tokenIndex, JavaLexer.COMMENT_CHANNEL);
		if (comments != null) {
			// Get first token in default channel on the left of all comments.
			ExtendToken preToken = null;
			Token comment = comments.get(0);
			int preIndex = comment.getTokenIndex() - 1;
			while (preIndex >= 0) {
				preToken = (ExtendToken) tokenStream.get(preIndex);
				if (AntlrHelper.inDefaultChannel(preToken.getChannel())) {
					break;
				}
				--preIndex;
			}

			for (int i = 0; i < comments.size(); i++) {
				if (preToken != null && preToken.getLine() == comments.get(i).getLine()) {
					preToken.addTokenAfter(comments.get(i), parser);
					preToken.hasTrailingComment = true;
				} else {
					List<Token> leadingTokens = comments.subList(i, comments.size());
					leadingTokens.forEach(t -> token.addTokenBefore(t, parser));
					break;
				}
			}
		}
	}

	/**
	 * @Description Set real type for '<' and '-'.
	 */
	public static void processAmbiguousToken(List<Token> tokens, MyParser parser) {
		for (int i = 0; i < tokens.size(); i++) {
			ExtendToken token = (ExtendToken) tokens.get(i);
			if (token.getChannel() != parser.getDefaultChannel()) {
				continue;
			}

			int type = tokens.get(i).getType();
			if (type == parser.getLT()) {
				processAngleBracket(tokens, i, parser);
			} else if (type == parser.getSub()) {
				processNegativeOperator(tokens, i, parser);
			} else if (type == parser.getMul()) {
				processWildcard(tokens, i, parser);
			}
		}

	}

	private static  void processWildcard(List<Token> tStream, int index, MyParser parser) {
		Token leftToken = findFirstDefaultToken(tStream, index, parser);
		if (leftToken == null) {
			return;
		}
		if (leftToken.getText().equals(".") && tStream.get(index) instanceof ExtendToken extToken) {
			extToken.setText(AmbigousToken.WILDCARD.name());
		}
	}

	/**
	 * @param curIndex index of '-'
	 * @return
	 */
	private static  List<Token> processNegativeOperator(List<Token> tStream, int curIndex, MyParser parser) {
		List<Token> negativeTokens = new ArrayList<>(1);
		Token leftToken = findFirstDefaultToken(tStream, curIndex, parser);
		if (leftToken == null) {
			return negativeTokens;
		}

		int leftType = leftToken.getType();
		if (leftType != parser.getIdentifier() && leftType != parser.getRParen() && leftType != parser.getRBrack()) {
			ExtendToken subToken = (ExtendToken) tStream.get(curIndex);
//      subToken.setType(-subToken.getType());
			subToken.setText(AmbigousToken.NEGATIVE.name());
			negativeTokens.add(tStream.get(curIndex));
		}

		return negativeTokens;
	}

	private static  Token findFirstDefaultToken(List<Token> tokenStream, int curIndex, MyParser parser) {
		int i = curIndex - 1;
		for (; i >= 0; i--) {
			if (tokenStream.get(i).getChannel() == parser.getDefaultChannel()) {
				break;
			}
		}
		if (i >= 0) {
			return tokenStream.get(i);
		}
		return null;
	}


	/**
	 * Try to match angle brackets, and then set the type of all matched tokens to -type.
	 *
	 * @param curIndex Index of '<'
	 */
	private static  List<Token> processAngleBracket(List<Token> tStream, int curIndex, MyParser parser) {
		int count = 1;
		List<Token> matchedTokens = new ArrayList<>();
		matchedTokens.add(tStream.get(curIndex));
		for (int i = curIndex + 1; i < tStream.size(); ++i) {
			Token token = tStream.get(i);
			int tokenType = token.getType();
			if (tokenType == parser.getLT()) {
				++count;
				matchedTokens.add(token);
			} else if (tokenType == parser.getGT()) {
				--count;
				matchedTokens.add(token);
			} else if (parser.belongToOperator(token.getText()) && !token.getText().equals("[") && !token.getText().equals("]") && !token.getText().equals("?")) {
				break;
			}
		}

		if (count == 0) {
			for (Token ambigousToken : matchedTokens) {
				if (ambigousToken instanceof CommonToken commonToken) {
//          commonToken.setType(-commonToken.getType());
					if (commonToken.getType() == parser.getLT()) {
						commonToken.setText(AmbigousToken.LEFT_ANGLE_BRACKET.name());
					} else if (commonToken.getType() == parser.getGT()) {
						commonToken.setText(AmbigousToken.RIGHT_ANGLE_BRACKET.name());
					}
				}
			}
			return matchedTokens;
		}
		matchedTokens.clear();
		return matchedTokens;
	}


}
