package org.example.styler.linewrapping;

import org.antlr.v4.runtime.Token;
import org.example.parser.AntlrHelper;
import org.example.parser.ExtendToken;
import org.example.style.ProgramStyle;
import org.example.style.Style;
import org.example.style.format.*;
import org.example.styler.StylerBase;
import org.example.styler.TSStyler;

import java.util.*;

/*
 * @description
 * @author       Yingying Jiang
 * @create       2024/4/7 10:20
 */
public class LineWrappingStyler extends StylerBase implements TSStyler {
  int start = 0;
  List<Integer> columns = new ArrayList<>();
  int maxColumn = 0;
  List<Token> saveTokens = null;
  int nextIndex = 0;


  @Override
  public int extractStyle(List<Token> tokens, int curIndex, Style style) {
    checkFileChange(tokens, curIndex, style);
    Token curToken = tokens.get(curIndex);
    if (curToken.getCharPositionInLine() == 0) {
      start = curIndex;
    }

    if(AntlrHelper.isVws(curToken) || AntlrHelper.isLineComment(curToken)) {
      // extract column length, omit the end vws.
      int column = curToken.getCharPositionInLine();
      ExtendToken extendToken = (ExtendToken) curToken;
      if (extendToken.trailingComment) {
        column += extendToken.getComments().length();
      }
      if (column > maxColumn) {
        maxColumn = column;
      }
      columns.add(column);

      int next = curIndex + 1, pre = curIndex - 1;
      while(next < tokens.size() && AntlrHelper.isHws(tokens.get(next)))
        ++next;
      while(pre >= 0 && AntlrHelper.isHws(tokens.get(pre)))
        --pre;
      if (pre >= 0 && next < tokens.size()) {
        Token preToken = tokens.get(pre), nextToken = tokens.get(next);
        if(AntlrHelper.isBrace(preToken) || AntlrHelper.isBrace(nextToken)) {
          return 0;
        }
        if(AntlrHelper.inDefaultChannel(preToken.getChannel())
            && AntlrHelper.inDefaultChannel(nextToken.getChannel())) {
          /*System.out.println("left:" + AntlrHelper.getTokenName(preToken.getType()));
          System.out.println("right:" + AntlrHelper.getTokenName(nextToken.getType()));*/

          LineWrappingRule.Property property = new LineWrappingRule.Property();

          for (int i = start; i < curIndex; i++) {
            if (tokens.get(i).getCharPositionInLine() == nextToken.getCharPositionInLine()) {
              property.addAlignToken(tokens.get(i).getType());
              break;
            }
          }
          Token startToken = tokens.get(start);
          if(AntlrHelper.isHws(startToken)) {
            startToken = tokens.get(start + 1);
          }

          int fixIndention = nextToken.getCharPositionInLine() - startToken.getCharPositionInLine();
          if (fixIndention >= 0) {
            property.addIndention(fixIndention);
            FormatStyle formatStyle = (FormatStyle) style;
            formatStyle.getRule().addRule(preToken.getType(), nextToken.getType(), property);
          }
        }
      }
      start = curIndex + 1;
    }
    return 0;
  }

  @Override
  public int applyStyle(List<Token> tokens, int curIndex, Style style) {
    if (curIndex < nextIndex) {
      return 0;
    }
    checkFileChange(tokens, curIndex, style);
    start = curIndex;

    // Calculate column length.
    int column = 0;
    int end = 0;
    Map<Integer, Integer> indexColumnLenMap = new HashMap<>();
    for (int i = start; i < tokens.size() - 1; i++) {
      Token curToken = tokens.get(i);
      if(!AntlrHelper.isVws(curToken)) {
        column += curToken.getText().length();
      }
      indexColumnLenMap.put(i, column);
      if(curToken.getText().endsWith("\n")) {
        end = i;
        nextIndex = i + 1;
        break;
      }
    }

    // Compare column and maxColumn
    FormatStyle formatStyle = (FormatStyle) style;
    LineWrappingRule rule = formatStyle.getRule();
    if (column < rule.maxColumn) {
      return 0;
    }

    // Collect all positions where can break.
    // pair.first: token index, pair.second: property
    List<Info> breakPos = new ArrayList<>();
    int columnLen = 0;
    for (int i = start; i < end; i++) {
      columnLen += tokens.get(i).getText().length();
      if(AntlrHelper.isHws(tokens.get(i))) {
        continue;
      }
      LineWrappingRule.Property property = rule.getProperty(tokens.get(i).getType());
      if (property != null) {
        breakPos.add(new Info(i, columnLen, property));
      }
    }

    // Try to break line.
    int threshold = Math.min(rule.maxColumn / 2, 3 * rule.avgColumn / 2);
    while (column > rule.maxColumn && !breakPos.isEmpty()) {
      Info info =
          breakPos.stream().max((info1, info2) -> Integer.compare(info1.property.count,
          info2.property.count)).get();
      boolean before = info.property.before;
      int decrease = before ? info.columnLen - tokens.get(info.index).getText().length() : info.columnLen;

      if(info.columnLen > threshold) {
        breakLine(info.property, tokens, before ? info.index - 1 : info.index);
        // Update @breakPos.
        Iterator<Info> iterator = breakPos.iterator();
        while (iterator.hasNext()) {
          Info info1 = iterator.next();
          if(info1.index < info.index) {
            iterator.remove();
          } else {
            info1.columnLen -= decrease;
          }
        }
      }
      breakPos.remove(info);
    }
    return 0;
  }

  private void breakLine(LineWrappingRule.Property property, List<Token> tokens, int breakIndex) {
    boolean setted = false;
    ExtendToken startToken = (ExtendToken) tokens.get(breakIndex + 1);
    ExtendToken insertAfter = (ExtendToken) tokens.get(breakIndex);
    insertAfter.setText(insertAfter.getText() + System.lineSeparator());
    // tokens.add(startTokenIndex - 1, new ExtendToken(JavaParser.VWS, System.lineSeparator()));

    for(int i = start; i <= breakIndex; ++i) {
      if(property.alignTokens.contains(tokens.get(i).getType())) {
        startToken.setHierarchy(0);
        startToken.setIndention(tokens.get(i).getCharPositionInLine());
        setted = true;
        break;
      }
    }
    if (!setted) {
      startToken.setIndention(property.fixedIndention);
    }
  }

  private void checkFileChange(List<Token> tokens, int curIndex, Style style) {
    if (saveTokens == null) {
      saveTokens = tokens;
      return;
    }
    // condition "curIndex >= tokens.size() - 2" is used for the last file.
    if(saveTokens != tokens || curIndex >= tokens.size() - 2) {
      FormatStyle formatStyle = (FormatStyle) style;
      formatStyle.getRule().addMaxColumn(maxColumn);
      Optional<Integer> sum = columns.stream().reduce(Integer::sum);
      formatStyle.getRule().addAvgColumn(sum.map(integer -> integer / columns.size()).orElse(0));

      saveTokens = tokens;
      columns.clear();
      maxColumn = 0;
      start = 0;
    }
  }

  static class Info {
    int index;
    int columnLen;
    LineWrappingRule.Property property;

    public Info(int index, int columnLen, LineWrappingRule.Property property) {
      this.index = index;
      this.columnLen = columnLen;
      this.property = property;
    }
  }

}
