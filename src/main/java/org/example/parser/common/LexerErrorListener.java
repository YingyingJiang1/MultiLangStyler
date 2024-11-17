package org.example.parser.common;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;

/*
 * @description
 * @author       Yingying Jiang
 * @create       2024/4/1 10:39
 */
public class LexerErrorListener extends BaseErrorListener {
  boolean error = false;
  @Override
  public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {
    // super.syntaxError(recognizer, offendingSymbol, line, charPositionInLine, msg, e);
    error = true;
  }

  public boolean isError() {
    return error;
  }
}
