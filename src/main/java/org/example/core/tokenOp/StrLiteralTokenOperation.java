package org.example.core.tokenOp;

import org.antlr.v4.runtime.Token;
import org.example.antlr.JavaLexer;
import org.example.style.literal.LiteralStyle;
import org.example.style.literal.LiteralStyle.*;
import org.example.style.ProgramStyle;

import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/*
 * @description:
 * @author     : Jiang Yingying
 * @create     : 2024/1/20 22:50
 */
public class StrLiteralTokenOperation extends TokenOperation{
  @Override
  public int applyStyle(List<Token> tokens, int curIndex, ProgramStyle programStyle) {
    return 0;
  }

  // In most cases, this method only processes one token in each round.
  // But in some cases, this method may process more than one token.
  // The number of processed tokens in a round = one + extra number. The method will return the extra number.
  @Override
  public int extractStyle(List<Token> tokens, int curIndex, ProgramStyle programStyle) {
    Token token = tokens.get(curIndex);
    int type = token.getType();
    String text = token.getText();
    LiteralStyle literalStyle = (LiteralStyle) programStyle.getStyle(ProgramStyle.LITERAL);
    int off = 0;

    if(type == JavaLexer.TEXT_BLOCK && text.contains("\n")) {
      updateStatistic(StyleLabel.TEXT_BLOCK_EXP, StyleValue.TRIPLE_QUOTE);
    } else if(type == JavaLexer.STRING_LITERAL) {
      StringBuilder str = new StringBuilder("s");
      boolean hasMultipleLines = false;

      // Try to match multi-line written, double-quoted string literals concatenated with add operator.
      int nextToken = curIndex + 1, tokensLen = tokens.size();
      while(nextToken < tokensLen) {
        type = tokens.get(nextToken).getType();
        if(type == JavaLexer.VWS && !hasMultipleLines) {
          hasMultipleLines = true;
        } else if(type == JavaLexer.HWS) {
        } else if(type == JavaLexer.ADD) {
          str.append('a');
        } else if(type == JavaLexer.STRING_LITERAL) {
          str.append('s');
        } else {
          break;
        }
        ++nextToken;
      }
      off = nextToken - curIndex - 1;
      if(hasMultipleLines && Pattern.matches("(sa)+s", str))
        updateStatistic(StyleLabel.TEXT_BLOCK_EXP, StyleValue.DOUBLE_QUOTE_CONCAT);
    }
    return off;
  }

  /**
   * This method fills the literal style of a style object.
   */
  @Override
  public void doFinalize() {
    LiteralStyle literalStyle = (LiteralStyle) programStyle.getStyle(ProgramStyle.LITERAL);
    for(int i = 0; i < literalsStyleTmp.size(); ++i) {
      StyleValue resValue = StyleValue.UNKNOWN;
      int resCount = 0;
      for(Map.Entry<StyleValue, Integer> entry : literalsStyleTmp.get(i).entrySet()) {
        if(entry.getValue() > resCount) {
          resCount = entry.getValue();
          resValue = entry.getKey();
        }
      }
      literalStyle.setLiteralsStyle(i, resValue);
    }
  }
}
