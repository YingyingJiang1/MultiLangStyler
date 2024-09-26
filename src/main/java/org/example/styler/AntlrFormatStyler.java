package org.example.styler;

import org.antlr.v4.runtime.Vocabulary;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.example.antlr.JavaParser;
import org.example.parser.ExtendContext;
import org.example.style.ProgramStyle;

/*
 * @description
 * @author       Yingying Jiang
 * @create       2024/3/25 6:22
 */
public class AntlrFormatStyler extends AntlrConcreteStylerBase {
  private static AntlrFormatStyler instance = new AntlrFormatStyler();
  private static AntlrConcreteStylerBase[] innerStylers = {
      new AntlrBraceStyler(),
      new AntlrNewlineStyler(), // This must be the end.
  };

  public static AntlrFormatStyler getInstance() {
    return instance;
  }

  public AntlrFormatStyler() {
  }

  public AntlrFormatStyler(boolean enableExtraction, boolean enableApplication) {
    super(enableExtraction, enableApplication);
  }

  public ExtendContext applyStyle(ExtendContext ctx, ProgramStyle programStyle) {
    for(AntlrConcreteStylerBase innerStyler : innerStylers) {
      if(innerStyler.isRelevant(ctx)) {
        try {
          innerStyler.applyStyle(ctx, programStyle);
        } catch(Exception e) {
          System.err.println("apply format style failure: " + e.getMessage());
        }
      }
    }
    return ctx;
  }

  public  void extractStyle(ExtendContext ctx, ProgramStyle programStyle) {
    for(AntlrConcreteStylerBase innerStyler : innerStylers) {
      if(innerStyler.isRelevant(ctx)) {
        try{
          innerStyler.extractStyle(ctx, programStyle);
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
