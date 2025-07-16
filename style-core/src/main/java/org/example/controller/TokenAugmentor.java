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
import org.example.utils.editor.NodeEditorFactory;

import java.util.*;

/*
 * @description
 * @author       Yingying Jiang
 * @create       2024/3/30 20:57
 */
public class TokenAugmentor {
	int curNestingDepth = 0;

	public void process(MyParser parser, Stage stage) {
		CommonTokenStream tokenStream = (CommonTokenStream) parser.getTokenStream();
		for (int i = 0; i < tokenStream.size(); i++) {
			ExtendToken token = (ExtendToken) tokenStream.get(i);
			if (token.getChannel() != parser.getDefaultChannel()) {
				continue;
			}

			setHierarchy(tokenStream, i);
//			processComment(parser, tokenStream, i);
			addContextTokens(parser, tokenStream, i);
			processAmbiguousToken(parser, tokenStream, i);
		}

		traverseTree(parser.getRoot(), parser);
	}

	public void restoreState(List<Token> tokens, MyParser parser) {
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

	private void setHierarchy(TokenStream tokenStream, int curIndex) {

		ExtendToken token = (ExtendToken) tokenStream.get(curIndex);
		int tokenType = token.getType();
		// Update brace depth.
		if (tokenType == JavaLexer.LBRACE) {
			token.setHierarchy(curNestingDepth);
			++curNestingDepth;
		} else if (tokenType == JavaLexer.RBRACE) {
			--curNestingDepth;
			token.setHierarchy(curNestingDepth);
		} else {
			token.setHierarchy(curNestingDepth);
		}
	}

	private void traverseTree(ParseTree node, MyParser parser) {
		if (node instanceof ExtendContext ctx) {
			NodeEditorFactory.createASTEditor(parser.getLanguage()).updateHierarchy(parser, ctx);
			for (int i = 0; i < node.getChildCount(); i++) {
				traverseTree(node.getChild(i), parser);
			}
		}
	}


//
//  private void processBrace(CommonTokenStream tokenStream, int curIndex) {
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
	 * @param tokenStream
	 * @param tokenIndex index of current syntax-dependent token
	 */
	public void addContextTokens(MyParser parser, CommonTokenStream tokenStream, int tokenIndex) {
		ExtendToken token = (ExtendToken) tokenStream.get(tokenIndex);

		List<Token> contextTokens = tokenStream.getHiddenTokensToRight(tokenIndex);
		if (contextTokens == null) {
			return;
		}

		// Find the first comment that is not trailing, tokens before the comment token are the context tokens of current default token,
		int i = 0;
		boolean isTrailingComment = true;
		int insertionPoint = token.indexInContextTokens() + 1;
		token.addTokens(insertionPoint, contextTokens);
//		for (; i < contextTokens.size(); i++) {
//			Token ct = contextTokens.get(i);
//
//			if (ct.getText().endsWith("\n")) {
//				isTrailingComment = false;
//			}
//
//			if (parser.belongToComment(ct.getType()) && !isTrailingComment) {
//				break;
//			}
//			token.addToken(insertionPoint++, ct);
//		}
//
//		if (isTrailingComment) {
//			token.hasTrailingComment = isTrailingComment;
//		}
//
//		// tokens after the non-trailing comment token and the comment token are the context tokens of the next default token.
//		ExtendToken targetToken = tokenIndex + contextTokens.size() >= tokenStream.size() ?
//				token : (ExtendToken) tokenStream.get(tokenIndex + contextTokens.size() + 1);
//		if (targetToken != token) {
//			insertionPoint = targetToken.indexInContextTokens();
//		}
//		targetToken.addTokens(insertionPoint, contextTokens.subList(i, contextTokens.size()));

	}

//	public void addContextTokens(MyParser parser, CommonTokenStream tokenStream, int tokenIndex) {
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
	public void processComment(MyParser parser, CommonTokenStream tokenStream, int tokenIndex) {
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
	private void processAmbiguousToken(MyParser parser, TokenStream tStream, int index) {
		int type = tStream.get(index).getType();
		if (type == parser.getLT()) {
			processAngleBracket(tStream, index, parser);
		} else if (type == parser.getSub()) {
			processNegativeOperator(tStream, index, parser);
		} else if (type == parser.getMul()) {
			processWildcard(tStream, index, parser);
		}
	}

	private void processWildcard(TokenStream tStream, int index, MyParser parser) {
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
	private List<Token> processNegativeOperator(TokenStream tStream, int curIndex, MyParser parser) {
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

	private Token findFirstDefaultToken(TokenStream tokenStream, int curIndex, MyParser parser) {
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
	private List<Token> processAngleBracket(TokenStream tStream, int curIndex, MyParser parser) {
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
