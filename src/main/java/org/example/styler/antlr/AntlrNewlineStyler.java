package org.example.styler.antlr;

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.apache.commons.lang3.StringUtils;
import org.example.antlr.JavaParser;
import org.example.parser.AntlrHelper;
import org.example.parser.ExtendContext;
import org.example.parser.ExtendToken;
import org.example.style.ProgramStyle;
import org.example.style.format.FormatStyle;
import org.example.style.format.NewlineRule;
import org.example.styler.Styler;

import java.util.*;

/*
 * @description
 * @author       Yingying Jiang
 * @create       2024/3/30 11:45
 */
public class AntlrNewlineStyler extends AntlrConcreteStylerBase {
  private static Set<Integer> relevantRules = new HashSet<>(Arrays.asList(
      JavaParser.RULE_compilationUnit,
      JavaParser.RULE_importDeclarationList, JavaParser.RULE_typeDeclarationList,
      JavaParser.RULE_fieldDeclarationList,
      JavaParser.RULE_constructorDeclarationList, JavaParser.RULE_methodDeclarationList,
      JavaParser.RULE_initializerList,
      JavaParser.RULE_block,JavaParser.RULE_body, JavaParser.RULE_switchBlockStatementGroup,
      JavaParser.RULE_annotationList, JavaParser.RULE_annotation, JavaParser.RULE_modifierList
  ));

  public AntlrNewlineStyler() {
  }

  public AntlrNewlineStyler(boolean enableExtraction, boolean enableApplication) {
    super(enableExtraction, enableApplication);
  }

  @Override
  public void extractStyle(ExtendContext ctx, ProgramStyle programStyle) {
    FormatStyle formatStyle = (FormatStyle) programStyle.getStyle(ProgramStyle.FORMAT);
    int len = ctx.getChildCount() - 1;
    for(int i = 0; i < len; ++i) {
      List<Info> infos1 = extractInfos(ctx, i, i + 1, Styler.EXTRACTION_PROCESS);
      List<Info> infos = infos1;
      List<NewlineRule> rules = new ArrayList<>();
      for(Info info : infos) {
        NewlineRule rule = new NewlineRule(extractContext(info), extractProperty(info));
        rules.add(rule);
      }
      formatStyle.addRules(rules);
    }
  }

  @Override
  public ExtendContext applyStyle(ExtendContext ctx, ProgramStyle programStyle) {
    FormatStyle formatStyle = (FormatStyle) programStyle.getStyle(ProgramStyle.FORMAT);
    for(int i = 0; i < ctx.getChildCount() - 1; ++i) {
      List<Info> infos = extractInfos(ctx, i, i + 1, Styler.APPLICATION_PROCESS);
      for(Info info : infos) {
        NewlineRule.Context context = extractContext(info);
        NewlineRule.Property property = formatStyle.getProperty(context);

        // Must update index here! Because index will change after insertion operation.
        info.child1.index = i;
        info.child2.index = i + 1;
        if (property != null) {
          i += applyProperty(ctx, info, property);
        }
      }
    }
    return ctx;
  }

  @Override
  protected Set<Integer> getRelevantRules() {
    return  relevantRules;
  }

  private Info.InnerInfo getInfo(ExtendContext parent, int index, int flag) {
    Info.InnerInfo info = new Info.InnerInfo();
    ParseTree node = parent.getChild(index);
    if (node instanceof ExtendContext) {
      ExtendContext ctx = (ExtendContext) node;
      info.token = (ExtendToken) (flag == 1 ? ctx.getStop() : ctx.getStart());
      info.type = ctx.getRuleIndex();
    } else {
      info.token = (ExtendToken) ((TerminalNode) node).getSymbol();
      info.type = -info.token.getType();
    }

    info.line = info.token.getLine();
    info.textLen = node.getText().length();
    info.index = index;
    return info;
  }

  private NewlineRule.Context extractContext(Info info) {
    Info.InnerInfo info1 = info.child1, info2 = info.child2;
    return new NewlineRule.Context(info1.type, info2.type, info1.textLen + info2.textLen);
  }


  private int getLine(int startLine, String text) {
    if(text.startsWith("//")) {
      return startLine;
    }
    int countNewline = 0;
    for (int i = 0; i < text.length(); i++) {
      if(text.charAt(i) == '\n') {
        ++countNewline;
      }
    }
    return startLine + countNewline;
  }

  private List<Info> extractInfos(ExtendContext ctx, int index1, int index2, int process) {
    List<Info> infos = new ArrayList<>();
    Info.InnerInfo info1 = getInfo(ctx, index1, 1);
    Info.InnerInfo info2 = getInfo(ctx, index2, 2);
    if(AntlrHelper.isVws(info1.token) || AntlrHelper.isVws(info2.token)) {
      return  infos;
    }
    // Application process
    if (process == Styler.APPLICATION_PROCESS) {
      infos.add(new Info(ctx, info1, info2));
      return infos;
    }

    // Extraction process
    boolean hasCommentBefore = !info2.token.comments.isEmpty() && !info2.token.trailingComment;
    if(hasCommentBefore) {
      ExtendToken firstCmtToken = (ExtendToken) info2.token.comments.get(0);
      ExtendToken lastCmtToken = (ExtendToken) info2.token.comments.get(info2.token.comments.size() - 1);
      Info.InnerInfo firstCmtInfo = new Info.InnerInfo(-2, -firstCmtToken.getType(), firstCmtToken.getText().length(),
          firstCmtToken);
      Info.InnerInfo lastCmtInfo = new Info.InnerInfo(-2, -lastCmtToken.getType(), lastCmtToken.getText().length(),
          lastCmtToken);
      lastCmtInfo.line = getLine(lastCmtToken.getLine(), lastCmtToken.getText());

      infos.add(new Info(ctx, info1, firstCmtInfo));
      infos.add(new Info(ctx, lastCmtInfo, info2));

      /*
       * line1:a = 1;
       * line2:// comment
       * line3:b = 2;
       * extraction: get a newline between (line1, line2),(line2,line3),(line1,line3)
       * application: insert a newline between (line1,line2),(line2,line3)
       */
      if (process == Styler.EXTRACTION_PROCESS) {
        Info.InnerInfo info3 = new Info.InnerInfo(info2);
        info3.line = firstCmtToken.getLine();
        infos.add(new Info(ctx, info1, info3));
      }
    } else {
      infos.add(new Info(ctx, info1, info2));
    }

    return infos;
  }

  private NewlineRule.Property extractProperty(Info info) {
    Info.InnerInfo info1 = info.child1, info2 = info.child2;
    int newlines = info2.line - info1.line;

    if (AntlrHelper.isBrace(info1.token) ||
        (AntlrHelper.isBraceOptionalBlocks(info1.type) && AntlrHelper.isSemi(info1.token))) {
      --newlines;
    }
    if(AntlrHelper.isBrace(info2.token)) {
      --newlines;
    }
    if (newlines < 0) {
      newlines = 0;
    }
    return new NewlineRule.Property(newlines);
  }

  /**
   *
   * @param info
   * @param property
   * @return the length of the shift to right.
   */
  private int applyProperty(ExtendContext parent, Info info, NewlineRule.Property property) {
    int insertionPoint = info.child1.index + 1;
    if (property.newlines > 0) {
      // info1: the latest comment info before a rule.
      // info2: a rule info.
      if(AntlrHelper.isComment(info.child1.token)) {
        String vwsStr = StringUtils.repeat(System.lineSeparator(), property.newlines);
        info.child2.token.comments.add(new ExtendToken(JavaParser.VWS, vwsStr));
      } else if(insertionPoint >= 0) { // info1: a rule info
        ExtendToken token1 = info.child1.token;
        int newlines = property.newlines;
        newlines -= getNewlineAfter(parent, info.child1);
        if (newlines > 0) {
          info.parentCtx.addVws(insertionPoint, newlines);
          return 1;
        }
      }
    }
    return 0;
  }

  private int getNewlineAfter(ExtendContext parent, Info.InnerInfo info) {
    int count = 0;
    // line comment has a newline at the end, so sub 1.
    if(info.token.trailingComment && AntlrHelper.isLineComment(info.token.comments.get(info.token.comments.size() - 1))) {
      count = 1;
    }
    if(parent.getChild(info.index) instanceof ExtendContext stmt) {
      for (int i = stmt.getChildCount() - 1; i >= 0 ; i--) {
        if(stmt.getChild(i) instanceof TerminalNode &&
            AntlrHelper.isVws(((TerminalNode) stmt.getChild(i)).getSymbol())) {
          ++count;
        } else {
          break;
        }
      }
    } else {
      for (int i = info.index + 1; i < parent.getChildCount(); i++) {
        if(parent.getChild(i) instanceof TerminalNode &&
            AntlrHelper.isVws(((TerminalNode) parent.getChild(i)).getSymbol())) {
          ++count;
        } else {
          break;
        }
      }
    }
    return count;
  }

  // Information of relevant structure.
  static class Info {
    ExtendContext parentCtx;
    InnerInfo child1, child2;
    static class InnerInfo {
      public InnerInfo() {
      }

      int index;
      int type,line, textLen;
      ExtendToken token;

      public InnerInfo(int index, int type, int textLen, ExtendToken token) {
        this.index = index;
        this.type = type;
        this.textLen = textLen;
        this.token = token;
        this.line = token.getLine();
      }

      public InnerInfo(InnerInfo info) {
        index = info.index;
        type = info.type;
        line = info.line;
        token = info.token;
      }
    }

    public Info() {}

    public Info(ExtendContext parentCtx, InnerInfo child1, InnerInfo child2) {
      this.parentCtx = parentCtx;
      this.child1 = child1;
      this.child2 = child2;
    }
  }
}
