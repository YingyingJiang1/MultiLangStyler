package org.example.antlr.common;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.TerminalNodeImpl;
import org.example.antlr.common.context.ExtendContext;
import org.example.antlr.common.token.ExtendToken;
import org.example.antlr.java.JavaParser;

/*
 * @description
 * @author       Yingying Jiang
 * @create       2024/3/27 0:28
 */
public class AntlrErrorHandler extends DefaultErrorStrategy {
  @Override
  public void recover(Parser recognizer, RecognitionException e) {
    ExtendContext currentCtx = (ExtendContext) recognizer.getContext();
    ExtendToken offendToken = (ExtendToken) recognizer.getCurrentToken();
    System.out.println("offendToken:");
    System.out.println(offendToken.getText());
    if(offendToken.getType() == JavaParser.BLOCK_COMMENT
        || offendToken.getType() == JavaParser.LINE_COMMENT) {
      assert currentCtx.children != null;
      currentCtx.children.add(new TerminalNodeImpl(offendToken));
    }
    super.recover(recognizer, e);
  }
}
