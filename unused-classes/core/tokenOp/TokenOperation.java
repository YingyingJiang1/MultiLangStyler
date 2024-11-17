package org.example.core.tokenOp;

import org.antlr.v4.runtime.Token;
import org.example.Helper;
import org.example.style.literal.LiteralStyle;
import org.example.style.ProgramStyle;

import java.util.*;

/*
 * @description:
 * @author     : Jiang Yingying
 * @create     : 2024/1/20 22:21
 */
public class TokenOperation {
  public static ProgramStyle programStyle;
  public static int curNestingDepth = 0;

  public static List<Map<LiteralStyle.StyleValue, Integer>> literalsStyleTmp; // Records the number of occurrences of each value(type is StyleValue) for each label(type is StyleLabel).
  public static int deleteLines;


  public int applyStyle(List<Token> tokens, int curIndex, ProgramStyle programStyle) {
    return 0;
  }

  public int extractStyle(List<Token> tokens, int curIndex, ProgramStyle programStyle) {
    return 0;
  }

  public static void initializeProcess() {
    curNestingDepth = 0;
    deleteLines = 0;
    literalsStyleTmp = new ArrayList<>(LiteralStyle.StyleLabel.values().length);
    doInit();
  }

  public void doFinalize() {}

  public int getCurNestingDepth() {
    return curNestingDepth;
  }

  public static void setStyleObj(ProgramStyle programStyle) {
    TokenOperation.programStyle = programStyle;
  }

  protected void updateStatistic(LiteralStyle.StyleLabel label, LiteralStyle.StyleValue value) {
    if(value != LiteralStyle.StyleValue.UNKNOWN) {
      Map<LiteralStyle.StyleValue, Integer> values = literalsStyleTmp.get(label.ordinal());
      values.put(value, values.get(value) != null ? values.get(value) + 1 : 1);
    }
  }

  private static void doInit() {
    int len = LiteralStyle.StyleLabel.values().length;
    literalsStyleTmp.addAll(Collections.nCopies(len, new HashMap<>()));

    int start = LiteralStyle.StyleLabel.LONG_SUFFIX.ordinal(), end = LiteralStyle.StyleLabel.HEX_LITERAL.ordinal();
    while(start <= end) {
      Map<LiteralStyle.StyleValue, Integer> values = new HashMap<>();
      values.put(LiteralStyle.StyleValue.LOWER_CASE, 0);
      values.put(LiteralStyle.StyleValue.UPPER_CASE, 0);
      literalsStyleTmp.set(start, values);
      ++start;
    }
    Map<LiteralStyle.StyleValue, Integer> values = new HashMap<>();
    values.put(LiteralStyle.StyleValue.DOUBLE_QUOTE_CONCAT, 0);
    values.put(LiteralStyle.StyleValue.TRIPLE_QUOTE, 0);
    literalsStyleTmp.set(LiteralStyle.StyleLabel.TEXT_BLOCK_EXP.ordinal(), values);
    start = LiteralStyle.StyleLabel.SINGLE_LINE_COMMENT.ordinal();
    end = LiteralStyle.StyleLabel.MUL_LINE_COMMENT.ordinal();
    while(start < end) {
      values = new HashMap<>();
      values.put(LiteralStyle.StyleValue.SLASH_SLASH_COMMENT, 0);
      values.put(LiteralStyle.StyleValue.SLASH_STAR_COMMENT, 0);
      literalsStyleTmp.set(start, values);
      ++start;
    }
  }


}
