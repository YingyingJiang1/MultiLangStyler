package org.example.styler;

import org.antlr.v4.runtime.Token;
import org.example.parser.ExtendContext;
import org.example.style.ProgramStyle;

import java.util.List;
import java.util.Set;

/*
 * @description
 * @author       Yingying Jiang
 * @create       2024/3/25 7:33
 */
public abstract class AntlrConcreteStylerBase {

  public static int triggerCount = 0;
  public boolean error = false;
  protected boolean enableExtraction = true;
  protected boolean enableApplication = true;

  public AntlrConcreteStylerBase() {}

  public AntlrConcreteStylerBase(boolean enableExtraction, boolean enableApplication) {
    this.enableExtraction = enableExtraction;
    this.enableApplication = enableApplication;
  }

  public ExtendContext applyStyle(ExtendContext ctx, ProgramStyle programStyle) {
    return ctx;
  }

  public  void extractStyle(ExtendContext ctx, ProgramStyle programStyle) {}

  public int extractStyle(List<Token> tokens, int curIndex, ProgramStyle programStyle){
    return 0;
  }

  public int applyStyle(List<Token> tokens, int curIndex, ProgramStyle programStyle){
    return 0;
  }

  public boolean isEnable(int process) {
    if (process == AntlrStyler.EXTRACTION_PROCESS) {
      return enableExtraction;
    }
    if (process == AntlrStyler.APPLICATION_PROCESS) {
      return enableApplication;
    }
    return true;
  }

  public void enable(int process) {
    if (process == AntlrStyler.EXTRACTION_PROCESS) {
      enableExtraction = true;
    }
    if (process == AntlrStyler.APPLICATION_PROCESS) {
      enableApplication = true;
    }
  }

  public void disable(int process) {
    if (process == AntlrStyler.EXTRACTION_PROCESS) {
      enableExtraction = false;
    }
    if (process == AntlrStyler.APPLICATION_PROCESS) {
      enableApplication = false;
    }
  }

  public void doFinalize(ProgramStyle programStyle) {
  }

  protected Set<Integer> getRelevantRules() {return null;}

  public boolean isRelevant(ExtendContext ctx){
    Set<Integer> relevantRules = getRelevantRules();
    // Special case: all rules is relevant.
    if (relevantRules == null) {
      return true;
    }
    int targetRule = ctx.getRuleIndex();
    return relevantRules.contains(targetRule);
  }
}
