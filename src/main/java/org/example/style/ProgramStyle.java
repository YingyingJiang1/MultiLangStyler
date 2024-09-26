package org.example.style;

import org.antlr.v4.runtime.Parser;
import org.dom4j.Element;
import org.example.style.arrangement.Arrangement;
import org.example.style.comment.Comment;
import org.example.style.format.FormatStyle;
import org.example.style.literal.LiteralStyle;
import org.example.style.name.NamingStyle;

import java.util.*;

/*
 * @description:
 * @author     : Jiang Yingying
 * @create     : 2024/1/8 22:27
 */
public class ProgramStyle extends Style {
  Map<Integer, Style> styles = new HashMap<>();
  public static final int FORMAT = 0;
  public static final int LITERAL = 1;
  public static final int ARRANGEMENT = 2;
  public static final int NAMING = 3;
  public static final int COMMENT = 4;
  public static final int EQUIVALENCES = 5;

  public ProgramStyle() {
    styles.put(FORMAT, new FormatStyle());
    styles.put(LITERAL, new LiteralStyle());
    styles.put(ARRANGEMENT, new Arrangement());
    styles.put(NAMING, new NamingStyle());
    styles.put(COMMENT, new Comment());
    styles.put(EQUIVALENCES, new EquivalencesStyle());
  }

  public void fill() {
    for(Style style : styles.values()) {
      style.fill();
    }
  }

  @Override
  public void addElement(Element root, Parser parser) {
    for(Style style : styles.values()) {
      style.addElement(root, parser);
    }
  }

  @Override
  public Object parseElement(Element root, Parser parser) {
    for(Style style : styles.values()) {
      style.parseElement(root, parser);
    }
    return this;
  }

  public Style getStyle(int styleType) {
    return styles.get(styleType);
  }

  public boolean isRulesEnough() {
    return ((FormatStyle)styles.get(FORMAT)).isRulesEnough;
  }
}
