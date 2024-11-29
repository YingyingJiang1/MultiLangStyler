package org.example.styler;

import org.antlr.v4.runtime.CommonToken;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.example.parser.common.MyParser;
import org.example.parser.common.token.AmbigousToken;
import org.example.parser.java.antlr.JavaLexer;
import org.example.parser.common.AntlrHelper;
import org.example.parser.common.token.ExtendToken;
import org.example.parser.common.token.TokenInfoField;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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
      if (stage == Stage.EXTRACT) {
        processBrace(tokenStream, i);
      }
      processComment(parser, tokenStream, i);
      processAmbiguousToken(parser, tokenStream, i);
    }
  }

  public void restoreState(Token token, MyParser parser) {
    Set<Integer> ambiguousTokens = Set.of(
            parser.getLT(), parser.getGT(), parser.getSub()
    );
    if (ambiguousTokens.contains(token.getType()) && token instanceof ExtendToken extendToken) {
      extendToken.setText(AmbigousToken.valueOf(token.getText()).getValue());
    }
  }

  private void setHierarchy(CommonTokenStream tokenStream, int curIndex) {
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

  private void processBrace(CommonTokenStream tokenStream, int curIndex) {
    if(!AntlrHelper.isBrace(tokenStream.get(curIndex))) {
      return;
    }

    // Extract line break information before and after brace.
    TokenInfoField.BraceTokenInfo info = new TokenInfoField.BraceTokenInfo();
    info.before = getBeforeNewlineInfo(tokenStream, curIndex);
    info.after = getAfterNewlineInfo(tokenStream, curIndex);
    ((ExtendToken) tokenStream.get(curIndex)).info = info;
  }

  /**
   * @Description Add comment tokens to the first or last token of the commented statement
   * @param tokenStream
   * @param tokenIndex
   */
  private void processComment(MyParser parser, CommonTokenStream tokenStream, int tokenIndex) {
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
   * @implNote
   * Consider the following scenario:
   * if(...) {
   *   int a = 1;\r\n // This newline together with ';' are matched as SEMI token,so it isn't a newline before RBRACE token.
   *   \r\n -> This is a real newline before RBRACE.
   * }
   *
   * @param tokenStream
   * @param curIndex index of LBRACE or RBRACE.
   * @return
   */
  private boolean getBeforeNewlineInfo(CommonTokenStream tokenStream, int curIndex) {
    int preIndex = curIndex - 1;
    if(preIndex < 0) {
      return false;
    }
    Token preToken = tokenStream.get(preIndex), curToken = tokenStream.get(curIndex);
    boolean isIndentionHws = preToken.getType() == JavaLexer.HWS && preToken.getCharPositionInLine() == 0;
    if (curToken.getType() == JavaLexer.LBRACE &&
        (isIndentionHws || preToken.getLine() != curToken.getLine())) {
      return true;
    } else if (curToken.getType() == JavaLexer.RBRACE){
      while (preToken.getType() == JavaLexer.HWS) {
        --preIndex;
        preToken = tokenStream.get(preIndex);
      }
      if (preToken.getType() == JavaLexer.VWS) {
        return true;
      }
    }

    return false;
  }

  private boolean getAfterNewlineInfo(CommonTokenStream tokenStream, int curIndex) {
    int afterIndex = curIndex + 1;
    while (afterIndex < tokenStream.size() && AntlrHelper.isHws(tokenStream.get(afterIndex))) {
      ++afterIndex;
    }
    if(afterIndex < tokenStream.size() && AntlrHelper.isVws(tokenStream.get(afterIndex))) {
      return true;
    }
    return false;
  }

  /**
   * @Description Set real type for '<' and '-'.
   */
  private void processAmbiguousToken(MyParser parser, TokenStream tStream,int index) {
    int type = tStream.get(index).getType();
    if (type == JavaLexer.LT) {
      processAngleBracket(tStream, index, parser);
    } else if (AntlrHelper.isSub(type)) {
      processNegativeOperator(tStream, index, parser);
    }
  }

  /**
   * @param curIndex index of '-'
   * @return
   */
  private List<Token> processNegativeOperator(TokenStream tStream, int curIndex, MyParser parser) {
    List<Token> negativeTokens = new ArrayList<>(1);
    int i = curIndex - 1;
    for (; i >= 0; i--) {
      if (AntlrHelper.inDefaultChannel(tStream.get(i).getChannel())) {
        break;
      }
    }

    int preType = tStream.get(i).getType();
    if (preType != JavaLexer.IDENTIFIER && preType != JavaLexer.RPAREN && preType != JavaLexer.RBRACK) {
      ExtendToken subToken = (ExtendToken) tStream.get(curIndex);
//      subToken.setType(-subToken.getType());
      subToken.setText(AmbigousToken.NEGATIVE.name());
      negativeTokens.add(tStream.get(curIndex));
    }

    return negativeTokens;
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
      } else if (tokenType != parser.getIdentifier() && tokenType != parser.getComma() &&
              tokenType != parser.getHws() && tokenType != parser.getVws()) {
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
