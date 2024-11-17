package org.example.core.tokenOp;

import org.antlr.v4.runtime.Token;
import org.example.parser.java.antlr.JavaLexer;
import org.example.style.literal.LiteralStyle;
import org.example.style.literal.LiteralStyle.*;
import org.example.style.ProgramStyle;

import java.util.List;

/*
 * @description:
 * @author     : Jiang Yingying
 * @create     : 2024/1/20 22:50
 */
public class CommentTokenOperation extends TokenOperation {

  @Override
  public int applyStyle(List<Token> tokens, int curIndex, ProgramStyle programStyle) {
    return 0;
  }

  @Override
  public int extractStyle(List<Token> tokens, int curIndex, ProgramStyle programStyle) {
    Token token = tokens.get(curIndex);
    int type = token.getType();
    String text = token.getText();
    LiteralStyle literalStyle = (LiteralStyle) programStyle.getStyle(ProgramStyle.LITERAL);
    
    StyleValue value;
    StyleLabel label = StyleLabel.SINGLE_LINE_COMMENT;
    Token preToken = tokens.get(curIndex - 1);

    if (preToken.getType() == JavaLexer.HWS || preToken.getType() == JavaLexer.VWS) {
      handleNonLineEndComments(tokens, curIndex, curIndex + 1, literalStyle);
    }

    if (token.getType() == JavaLexer.BLOCK_COMMENT) {
      value = StyleValue.SLASH_STAR_COMMENT;
      if (text.contains("\n")) {
        label = StyleLabel.MUL_LINE_COMMENT;
      }
    } else {
      value = StyleValue.SLASH_SLASH_COMMENT;
      int nextToken = curIndex + 1;
      int tokensLen = tokens.size();
      int count = 1;
      while (nextToken < tokensLen) {
        type = tokens.get(nextToken).getType();
        if (type == JavaLexer.HWS || type == JavaLexer.VWS) {
        } else if (type == JavaLexer.LINE_COMMENT) {
          ++count;
        } else {
          break;
        }
        ++nextToken;
      }
      if (count > 1) {
        label = StyleLabel.MUL_LINE_COMMENT;
      }
      handleNonLineEndComments(tokens, curIndex, nextToken, literalStyle);
    }
    updateStatistic(label, value);
    return 0;
  }

  private void handleNonLineEndComments(List<Token> tokens, int start, int end, LiteralStyle literalStyle) {
    // System.out.println("Implement the logic of calculating comment max and average columns in LexicalStyle.handleNonLineEndComments!");

    // Delete non line-end comment lines.
    /*deleteLines += tokens.get(end).getLine() - tokens.get(start).getLine();
    int len = tokens.size();
    while(end < len) {
      CommonToken token = (CommonToken) tokens.get(end);
      int type = token.getType();
      if(type == JavaLexer.BLOCK_COMMENT || type == JavaLexer.LINE_COMMENT)
        break;
      token.setLine(token.getLine() - deleteLines);
      ++end;
    }*/
  }


}
