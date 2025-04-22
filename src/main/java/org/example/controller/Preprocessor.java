package org.example.controller;

import org.antlr.v4.runtime.CommonToken;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.example.parser.common.MyParser;
import org.example.parser.common.context.ExtendContext;
import org.example.parser.common.token.AmbigousToken;
import org.example.parser.java.antlr.JavaLexer;
import org.example.parser.common.AntlrHelper;
import org.example.parser.common.token.ExtendToken;
import org.example.styler.Stage;

import java.util.*;

/*
 * @description
 * @author       Yingying Jiang
 * @create       2024/3/30 20:57
 */
public class Preprocessor {
  int curNestingDepth = 0;

  public void preprocess(MyParser parser, Stage stage) {
    CommonTokenStream tokenStream = (CommonTokenStream) parser.getTokenStream();
    for (int i = 0; i < tokenStream.size(); i++) {
      setHierarchy(tokenStream, i);
      processComment(parser, tokenStream, i);
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
    if(tokenType == JavaLexer.LBRACE) {
      token.setHierarchy(curNestingDepth);
      ++curNestingDepth;
    } else if(tokenType == JavaLexer.RBRACE) {
      --curNestingDepth;
      token.setHierarchy(curNestingDepth);
    } else {
      token.setHierarchy(curNestingDepth);
    }
  }

  private void traverseTree(ParseTree node, MyParser parser) {
    if (node instanceof ExtendContext ctx) {
      ctx.updateHierarchy(parser);
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
   * @Description Add comment tokens to the first or last token of the commented statement
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
        if(AntlrHelper.inDefaultChannel(preToken.getChannel())) {
          break;
        }
        --preIndex;
      }

      for (int i = 0; i < comments.size(); i++) {
        if(preToken != null && preToken.getLine() == comments.get(i).getLine()){
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
  private void processAmbiguousToken(MyParser parser, TokenStream tStream,int index) {
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
