package org.example.styler.hws;

import org.antlr.v4.runtime.Token;
import org.example.parser.AntlrHelper;
import org.example.parser.ExtendToken;
import org.example.style.Style;
import org.example.styler.StylerBase;
import org.example.styler.TSStyler;
import org.example.styler.hws.style.IndentionProperty;
import org.example.styler.hws.style.SpaceContext;
import org.example.styler.hws.style.SpaceProperty;

import java.util.*;

/*
 * @description
 * @author       Yingying Jiang
 * @create       2024/3/30 20:44
 */
public class HwsStyler extends StylerBase implements TSStyler {

  @Override
  public int extractStyle(List<Token> tokens, int curIndex, Style style) {
    ExtendToken token = (ExtendToken) tokens.get(curIndex);

    if(AntlrHelper.isVws(token)) {
      return 0;
    }

    int left = curIndex - 1, right = curIndex + 1;
    if(AntlrHelper.isHws(token)) {
      if(token.getCharPositionInLine() == 0) {
        // Extract indention.
        String text = token.getText();
        int curLineIndention = text.length();
        char indentionType = '\0';
        
        if(text.matches(" +")){
          indentionType = ' ';
        } else if(text.matches("\t+")) {
          indentionType = '\t';
        }
        int hierarchy = token.getHierarchy();
        int indentionUnit = 0;
        if(hierarchy > 0){
          indentionUnit = curLineIndention / hierarchy;
        }

        if (indentionType != '\0' && indentionUnit != 0) {
          style.addRule(null, new IndentionProperty(indentionUnit, indentionType));
        }

        // Extract column limit info.
        int i = curIndex - 1;
        // Skip comment token.
        while(i >= 0 && AntlrHelper.isComment(tokens.get(i)))
          --i;
//        if(i >= 0 && tokens.get(i).getLine() == tokens.get(curIndex).getLine() - 1) {
//          Token lastTokenInLine = tokens.get(i);
//          int columnLimit = lastTokenInLine.getCharPositionInLine() + lastTokenInLine.getText().length();
//          formatStyle.updateColumnLimit(columnLimit);
//        }
      } else if(left >= 0 && right < tokens.size()) {
        if(!AntlrHelper.isWs(tokens.get(left)) && !AntlrHelper.isWs(tokens.get(right))) {
          style.addRule(new SpaceContext(tokens.get(left).getType(), tokens.get(right).getType()), new SpaceProperty(true));
        }
      }
    } else if(right < tokens.size() && !AntlrHelper.isWs(tokens.get(right))) {
      style.addRule(new SpaceContext(token.getType(), tokens.get(right).getType()), new SpaceProperty(false));
    }
    return 0;
  }

  @Override
  public int applyStyle(List<Token> tokens, int curIndex, Style style) {
    return 0;
  }

}
