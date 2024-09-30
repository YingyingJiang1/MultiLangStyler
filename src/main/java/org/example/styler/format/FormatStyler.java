package org.example.styler.format;

import org.antlr.v4.runtime.Vocabulary;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.example.antlr.JavaParser;
import org.example.parser.ExtendContext;
import org.example.interfaces.Style;
import org.example.styler.ASTStyler;
import org.example.styler.StylerBase;
import org.example.styler.brace.BraceStyler;
import org.example.styler.newline.NewlineStyler;
import org.example.styler.brace.AntlrBraceStyler;

/*
 * @description
 * @author       Yingying Jiang
 * @create       2024/3/25 6:22
 */
public class FormatStyler extends StylerBase implements ASTStyler {
  private static FormatStyler instance = new FormatStyler();
  private static StylerBase[] innerStylers = {
      new BraceStyler(),
      new NewlineStyler(), // This must be the end.
  };

  public static FormatStyler getInstance() {
    return instance;
  }

  public FormatStyler() {
  }

  public FormatStyler(boolean enableExtraction, boolean enableApplication) {
    super(enableExtraction, enableApplication);
  }

  public ExtendContext applyStyle(ExtendContext ctx, Style style) {
    for(StylerBase innerStyler : innerStylers) {
      if(innerStyler.isRelevant(ctx)) {
        try {
          innerStyler.applyStyle(ctx, styler);
        } catch(Exception e) {
          System.err.println("apply format style failure: " + e.getMessage());
        }
      }
    }
    return ctx;
  }

  public  void extractStyle(ExtendContext ctx, Style style) {
    for(StylerBase innerStyler : innerStylers) {
      if(innerStyler.isRelevant(ctx)) {
        try{
          innerStyler.extractStyle(ctx, style);
        } catch(Exception e) {
          System.err.println("extract format style failure: " + e.getMessage());
        }
      }
    }
  }

  public  void printChildren(ExtendContext ctx) {
    JavaParser parser = new JavaParser(null);
    String[] ruleNames = parser.getRuleNames();
    Vocabulary vocabulary = parser.getVocabulary();
    System.err.print(ruleNames[ctx.getRuleIndex()] + ":");
    for(ParseTree root : ctx.children) {
      if(root instanceof TerminalNode) {
        System.err.print(vocabulary.getSymbolicName(((TerminalNode) root).getSymbol().getType()).toLowerCase() + " ");
      } else {
        ExtendContext rootCtx = (ExtendContext) root;
        System.err.print(ruleNames[rootCtx.getRuleIndex()] + " ");
      }
    }
    System.out.println(System.lineSeparator());
  }

  //--------------------------------------------------- Private methods ---------------------------------------------------


}
