package org.example.style.literal;

import org.antlr.v4.runtime.Parser;
import org.dom4j.Element;
import org.example.interfaces.Style;

import java.util.*;
import java.util.List;

/*
 * @author     : Jiang Yingying
 * @create     : 2024/1/8 22:15
 */
public class LiteralStyle extends Style {
  private List<StyleValue> literalsStyle; // Index of @literalsStyle correspond with ordinal of @StyleLabel enum types.
  // Ignore line-end comment.
  // e.g.: int a = 1; // this is a line-end comment.
  private int commentMaxColumn;
  private int commentAvgColumn;


  public LiteralStyle() {
    styleName = "Literal";
    int len = StyleLabel.values().length;
    this.literalsStyle = new ArrayList<>(len);
    literalsStyle.addAll(Collections.nCopies(len, StyleValue.UNKNOWN));
  }

  public void fill() {}

  public void setLiteralsStyle(int i, StyleValue value) {
    this.literalsStyle.set(i, value);
  }

  @Override
  public void addElement(Element root, Parser parser)  {
    Element lexicalStyleEle = root.addElement("lexical_style");
    StyleLabel[] labels = StyleLabel.values();
    for(StyleLabel label : labels) {
      if(label == StyleLabel.SPLIT_INTEGER_UNIT_WITH_UNDERSCORE || label == StyleLabel.SPECIAL_CHAR_EXP) {
        lexicalStyleEle.addElement(label.name().toLowerCase()).addText("待完成...");
      } else {
        lexicalStyleEle.addElement(label.name().toLowerCase())
            .addText(literalsStyle.get(label.ordinal()).name().toLowerCase());
      }
    }
  }

  public enum StyleLabel {
    // Ordinal of these enums corresponds with @literalsStyle index.
    //------------------------------------------------------------------------------------------------------
    LONG_SUFFIX, FLOAT_SUFFIX, DOUBLE_SUFFIX, HEX_PREFIX, BIN_PREFIX,
    HEX_LITERAL,
    SPLIT_INTEGER_UNIT_WITH_UNDERSCORE,
    // text block is a string that distributes in multiple rows.
    // So it can be written in two different ways: use """...""" or concat with plus operator.
    TEXT_BLOCK_EXP,
    SPECIAL_CHAR_EXP,
    SINGLE_LINE_COMMENT, MUL_LINE_COMMENT,
    //------------------------------------------------------------------------------------------------------
  }

  public enum StyleValue {
    LOWER_CASE, UPPER_CASE,
    DOUBLE_QUOTE_CONCAT, TRIPLE_QUOTE,
    ESCAPE, UNICODE,
    SLASH_SLASH_COMMENT, SLASH_STAR_COMMENT,
    UNKNOWN,
    INVALID
  }

}
