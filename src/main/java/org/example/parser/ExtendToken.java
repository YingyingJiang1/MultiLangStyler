package org.example.parser;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonToken;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenSource;
import org.antlr.v4.runtime.misc.Pair;

import java.util.ArrayList;
import java.util.List;

/*
 * @description
 * @author       Yingying Jiang
 * @create       2024/2/1 14:59
 */
public class ExtendToken extends CommonToken {

  // This field, together with the brace depth, determines the indentation of tokens.
  // This field is useful in the case statement,
  // as in most scenarios, the indentation depth is associated with the brace depth.
  // However, in case statements, there might be no braces.
  protected int hierarchy = 0;
  public int indention = 0;
  public List<Token> comments = new ArrayList<>(0);
  public boolean trailingComment;
  // The meaning of @info depends on the type of the token.
  public Object info;

  public ExtendToken(int type) {
    super(type);
  }

  public ExtendToken(Pair<TokenSource, CharStream> source, int type, int channel, int start, int stop) {
    super(source, type, channel, start, stop);
  }

  public ExtendToken(int type, String text) {
    super(type, text);
  }

  public ExtendToken(Token oldToken) {
    super(oldToken);
  }

  public void setIndention(int indention) {
    this.indention = indention;
  }

  @Override
  public ExtendToken clone() {
    ExtendToken ret = new ExtendToken(this);
    ret.hierarchy = hierarchy;
    ret.info = info;
    /*ret.comments.addAll(comments);
    ret.trailingComment = trailingComment;*/
    return ret;
  }

  public String getComments() {
    StringBuilder build = new StringBuilder();
    for(Token commentToken : comments) {
      build.append(commentToken.getText());
    }
    return build.toString();
  }

  public int getHierarchy() {
    return hierarchy;
  }

  public void setHierarchy(int depth) {
    this.hierarchy = depth;
  }

  public Object getInfo() {
    return this.info;
  }
}
