package org.example.parser.common;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenFactory;
import org.antlr.v4.runtime.TokenSource;
import org.antlr.v4.runtime.misc.Interval;
import org.antlr.v4.runtime.misc.Pair;

/*
 * @description
 * @author       Yingying Jiang
 * @create       2024/2/1 15:03
 */
public class ExtendTokenFactory extends CommonTokenFactory {
  public static ExtendTokenFactory DEFAULT = new ExtendTokenFactory();
  public ExtendTokenFactory(boolean copyText) {
    super(copyText);
  }

  public ExtendTokenFactory() {
    super();
  }

  @Override
  public ExtendToken create(Pair<TokenSource, CharStream> source, int type, String text, int channel, int start, int stop, int line, int charPositionInLine) {
   ExtendToken t = new ExtendToken(source, type, channel, start, stop);
    t.setLine(line);
    t.setCharPositionInLine(charPositionInLine);
    if ( text!=null ) {
      t.setText(text);
    }
    else if ( copyText && source.b != null ) {
      t.setText(source.b.getText(Interval.of(start,stop)));
    }

    return t;
  }

  @Override
  public ExtendToken create(int type, String text) {
    return new ExtendToken(type, text);
  }
}
