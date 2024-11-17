package org.example.core.tokenOp;

import org.antlr.v4.runtime.Token;
import org.example.parser.java.antlr.JavaLexer;
import org.example.style.literal.LiteralStyle;
import org.example.style.literal.LiteralStyle.*;
import org.example.style.ProgramStyle;

import java.util.List;
import java.util.function.BiPredicate;
import java.util.regex.Pattern;

/*
 * @description: Numeric literal includes DECIMAL_LITERAL,HEX_LITERAL, OCT_LITERAL,BINARY_LITERAL
 * FLOAT_LITERAL, HEX_FLOAT_LITERAL in JavaLexer.
 * @author     : Jiang Yingying
 * @create     : 2024/1/20 22:49
 */
public class NumericLiteralTokenOperation extends TokenOperation{

  @Override
  public int applyStyle(List<Token> tokens, int curIndex, ProgramStyle programStyle) {
    System.out.println("Implement NumericLiteralTokenOperation.applyStyle!");
    return 0;
  }

  @Override
  public int extractStyle(List<Token> tokens, int curIndex, ProgramStyle programStyle) {
    Token token = tokens.get(curIndex);
    int type = token.getType();
    String text = token.getText();
    LiteralStyle literalStyle = (LiteralStyle) programStyle.getStyle(ProgramStyle.LITERAL);
    StyleLabel label;
    StyleValue value;
    if(JavaLexer.DECIMAL_LITERAL <= type && type <= JavaLexer.BINARY_LITERAL) {
      label = StyleLabel.LONG_SUFFIX;
      value = extractLUinfo(text, "l", "L", (str, pattern) -> str.lastIndexOf(pattern) != -1);
      updateStatistic(label, value);

      if(type == JavaLexer.BINARY_LITERAL) {
        label = StyleLabel.BIN_PREFIX;
        value = extractLUinfo(text, "0b", "0B", String::startsWith);
        updateStatistic(label, value);
      } else if(type == JavaLexer.HEX_LITERAL) {
        label = StyleLabel.HEX_PREFIX;
        value = extractLUinfo(text, "0x", "0X", String::startsWith);
        updateStatistic(label, value);

        // Extract hex literal case info.
        value = extractLUinfo(text.substring(2),
            "[0-9a-f] ([0-9a-f_]* [0-9a-f])? [lL]?",
            "[0-9A-F] ([0-9A-F_]* [0-9A-F])? [lL]?",
            (str, pattern) -> Pattern.matches(pattern, str));
        updateStatistic(StyleLabel.HEX_LITERAL, value);
      }
    } else { // Float literals
      label = StyleLabel.FLOAT_SUFFIX;
      value = extractLUinfo(text, "f", "F", (str, pattern) -> str.lastIndexOf(pattern) != -1);
      if(value == StyleValue.UNKNOWN) {
        value = extractLUinfo(text, "d", "D", (str, pattern) -> str.lastIndexOf(pattern) != -1);
      }
      updateStatistic(label, value);
    }
    return 0;
  }


  /*
   * @description: Extract case info for prefix or suffix of numeric literal.
   * @param text: token text.
   * @param lStr: lower case string.
   * @param uStr: upper case string.
   * @return: StyleValue.LOWER_CASE or StyleValue.UPPER_CASE.
   * @author     : Jiang Yingying
   * @create     : 2024/1/8 2:31
   */
  private StyleValue extractLUinfo(String text, String lStr, String uStr, BiPredicate<String, String> cond) {
    if(cond.test(text, lStr)) {
      return StyleValue.LOWER_CASE;
    }
    if(cond.test(text, uStr)) {
      return StyleValue.UPPER_CASE;
    }
    return StyleValue.UNKNOWN;
  }

}
