package org.example.styler;

import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;
import org.example.parser.common.MyParser;
import org.example.parser.java.antlr.JavaLexer;
import org.example.parser.common.AntlrHelper;
import org.example.parser.common.ExtendToken;
import org.example.parser.common.TokenInfoField;

import java.util.List;

/*
 * @description
 * @author       Yingying Jiang
 * @create       2024/3/30 20:57
 */
public class Preprocessor {
  int curNestingDepth = 0;
  public void preprocess(MyParser parser, int process) {
    CommonTokenStream tokenStream = (CommonTokenStream) parser.getTokenStream();
    for (int i = 0; i < tokenStream.size(); i++) {
      setHierarchy(tokenStream, i);
      if (process == Styler.EXTRACTION_PROCESS) {
        processBrace(tokenStream, i);
      }
      processComment(tokenStream, i);
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
  private void processComment(CommonTokenStream tokenStream, int tokenIndex) {
    ExtendToken token = (ExtendToken) tokenStream.get(tokenIndex);
    if (token.getChannel() != JavaLexer.DEFAULT_TOKEN_CHANNEL) {
      return;
    }

    List<Token> comments = tokenStream.getHiddenTokensToLeft(tokenIndex, JavaLexer.COMMENT_CHANNEL);
    if (comments != null) {
      /*System.out.println("token:" + token.getType());
      System.out.println("comments:");
      for(Token comment : comments) {
        System.out.println(comment.getText());
      }*/

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
          preToken.comments.add(comments.get(i));
          preToken.hasTrailingComment = true;
        } else {
          token.comments = comments.subList(i, comments.size());
          token.hasTrailingComment = false;
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
}
