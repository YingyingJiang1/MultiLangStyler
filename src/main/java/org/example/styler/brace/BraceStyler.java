package org.example.styler.brace;

import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.example.antlr.JavaParser;
import org.example.parser.AntlrHelper;
import org.example.parser.ExtendContext;
import org.example.parser.ExtendToken;
import org.example.parser.TokenInfoField;
import org.example.style.ProgramStyle;
import org.example.style.Style;
import org.example.style.format.BraceInfo;
import org.example.style.format.FormatStyle;
import org.example.style.format.SingleLineBlockProperty;
<<<<<<< HEAD:src/main/java/org/example/styler/brace/BraceStyler.java
import org.example.styler.ASTStyler;
import org.example.styler.StylerBase;

=======
>>>>>>> master:src/main/java/org/example/styler/antlr/AntlrBraceStyler.java

import java.util.*;

public class BraceStyler extends StylerBase implements ASTStyler {
  private static Set<Integer> relevantRules = new HashSet<>(Arrays.asList(
      JavaParser.RULE_typeDeclaration,
      JavaParser.RULE_ifStmt, JavaParser.RULE_ifElseStmt, JavaParser.RULE_switchStmt,
      JavaParser.RULE_switchBlockStatementGroup,
      JavaParser.RULE_forStmt, JavaParser.RULE_doWhileStmt, JavaParser.RULE_whileStmt,
      JavaParser.RULE_constructorDeclaration, JavaParser.RULE_methodDeclaration,
      JavaParser.RULE_syncStmt, JavaParser.RULE_initializer,
      JavaParser.RULE_tryCatchStmt,JavaParser.RULE_tryResourceStmt,
      JavaParser.RULE_arrayInitializer, JavaParser.RULE_elementValueArrayInitializer
  ));

  public BraceStyler() {
  }

  public BraceStyler(boolean enableExtraction, boolean enableApplication) {
    super(enableExtraction, enableApplication);
  }

  @Override
  public ExtendContext applyStyle(ExtendContext ctx, Style style) {
    applySingleLineBlockStyle(ctx, style);
    List<ExtendContext> blocks = getAllBlocks(ctx);
    BraceInfo.TypeEnum blockType = getBlockType(ctx.getRuleIndex());

    // Apply brace information and add blank line.
    int lastIndex = blocks.size() - 1;
    FormatStyle formatStyle = (FormatStyle) style;
    for (int i = 0; i < blocks.size(); ++i) {
      ExtendContext block = blocks.get(i);
      // Specially process the last block of multi-block statement.
      if (blockType == BraceInfo.TypeEnum.MULTI_BLOCK_STMT && block == ctx.getLastContextChild()) {
        blockType = BraceInfo.TypeEnum.NORMAL_BLOCK;
      }
      BraceInfo.BraceLineBreakInfo braceLineBreakInfo =
          formatStyle.getBraceLineBreakInfo(blockType, getStmtNum(block));
      applyBraceInfo(braceLineBreakInfo, block, formatStyle);
    }
    return ctx;
  }

  @Override
  public void extractStyle(ExtendContext ctx, Style style) {
    extractSingleLineBlockStyle(ctx, style);
    List<ExtendContext> blocks = getAllBlocks(ctx);
    int ruleIndex = ctx.getRuleIndex();
    BraceInfo.TypeEnum blockType = getBlockType(ruleIndex);
    boolean isNotMultiBlockStmt = ruleIndex != JavaParser.RULE_ifElseStmt && ruleIndex != JavaParser.RULE_tryCatchStmt;
    // Extract brace information and blank line.
    for (int i = 0; i < blocks.size(); ++i) {
      try {
        ExtendContext block = (ExtendContext) blocks.get(i);
        // Skip the last block of multi-block statement.
        if (isNotMultiBlockStmt || block != ctx.getLastContextChild()) {
          extractBraceInfo(blockType, block, style);
        }
      } catch (NullPointerException e) {
        System.err.println("brace information extraction failure: " + e.getMessage());
      }
    }
  }

  /**
   * Try to add vws.
   * @param ctx
   * @param style
   */
  private void applySingleLineBlockStyle(ExtendContext ctx, Style style) {
    if(!AntlrHelper.isBraceOptionalBlocks(ctx.getRuleIndex())) {
      return;
    }
    FormatStyle formatStyle = (FormatStyle)  style;
    SingleLineBlockProperty property = formatStyle.getSingleBlockProperty();
    for (int i = 0; i < ctx.getChildCount(); i++) {
      ParseTree child = ctx.getChild(i);
      if(AntlrHelper.isStmt(child) && child instanceof ExtendContext stmtCtx) {
        if (stmtCtx.getRuleIndex() != JavaParser.RULE_block) {
          ExtendToken stop = (ExtendToken) stmtCtx.stop;
          if(!property.isInlineBlock) {
            ctx.addVws(i, 1);
            ++i;
          } else {
            ExtendToken start = (ExtendToken) stmtCtx.start;
            // Move line comment to the end of statement.
            if(!start.trailingComment && !start.comments.isEmpty() &&
                AntlrHelper.isLineComment(start.comments.get(start.comments.size() - 1))) {
              stop = (ExtendToken) stmtCtx.stop;
              stop.trailingComment = true;
              stop.comments.addAll(start.comments);
              start.comments.clear();
            }
          }
          if(!(stop.trailingComment && AntlrHelper.isLineComment(stop.comments.get(0)))) {
            ctx.addVws(i + 1, 1); // Add vws after statement
            ++i;
          }
        }
      }
    }
  }

  private void extractSingleLineBlockStyle(ExtendContext ctx, Style style) {
    if(!AntlrHelper.isBraceOptionalBlocks(ctx.getRuleIndex())) {
      return;
    }
    FormatStyle formatStyle = (FormatStyle) style;
    SingleLineBlockProperty property = formatStyle.getSingleBlockProperty();
    for (int i = 0; i < ctx.getChildCount(); i++) {
      ParseTree child = ctx.getChild(i);
      if(AntlrHelper.isStmt(child) && child instanceof ExtendContext stmtCtx) {
        if(stmtCtx.getRuleIndex() == JavaParser.RULE_block) {
          int innerStmtRule = stmtCtx.getRuleIndex();
          boolean braceNotOptional = innerStmtRule == JavaParser.RULE_ifElseStmt ||
              ctx.getRuleIndex() == JavaParser.RULE_ifElseStmt && innerStmtRule == JavaParser.RULE_ifStmt;
          if(stmtCtx.countChildIf(AntlrHelper::isStmt) == 1 && !braceNotOptional) {
            property.addUseBrace(true);
          }
        } else {
          ParseTree preChild = ctx.getChild(i - 1);
          int preChildLine = preChild instanceof TerminalNode ? ((TerminalNode) preChild).getSymbol().getLine() :
              ((ExtendContext) preChild).stop.getLine();
          property.addIsInlineBlock(stmtCtx.start.getLine() == preChildLine);
          property.addUseBrace(false);
        }
      }
    }
  }

  @Override
  protected Set<Integer> getRelevantRules() {
    return relevantRules;
  }

  //--------------------------------------------------- Private methods ---------------------------------------------------

  /**
   * This method process the following scenario:
   * case CONST:
   * if(...) {
   * ...
   * }
   * The above case group statement is not wrapped by {},
   * but the statement in the case group should be indented one level more than the case label.
   *
   * @param ctx A case group of switch statement.
   */
  private void addIndentionForCaseGroup(ExtendContext ctx, Style style) {
    for (ParseTree child : ctx.children) {
      if (child instanceof JavaParser.TypeDeclarationContext ||
          child instanceof JavaParser.StatementContext) {
        // SKip block statement
        if (child.getChildCount() > 0 && child.getChild(0) instanceof JavaParser.BlockContext) {
          continue;
        }
        List<Token> tokens = ((ExtendContext) child).getAllTokensRec();
        for (Token token : tokens) {
          if (token instanceof ExtendToken extendToken) {
            extendToken.setHierarchy(1 + extendToken.getHierarchy());
          }
        }
      }
    }
  }

  private void addVwsBefore(ExtendContext ctx, int braceType) {
    ExtendToken token = (ExtendToken) ctx.getFirstTokenByType(braceType);
    if (!token.trailingComment && !token.comments.isEmpty() &&
        AntlrHelper.isBlockComment(token.comments.get(token.comments.size() - 1))) {
      token.comments.add(new ExtendToken(JavaParser.VWS, System.lineSeparator()));
    } else {
      ctx.addVws(ctx.findFirstTerChildByType(braceType),1);
    }
  }

  private void addVwsAfter(ExtendContext ctx, int braceType) {
    ExtendToken token = (ExtendToken) ctx.getFirstTokenByType(braceType);
    if(!(token.trailingComment && AntlrHelper.isLineComment(token.comments.get(token.comments.size() - 1)))) {
      ctx.addVws(ctx.findFirstTerChildByType(braceType) + 1, 1);
    }
  }

  /**
   * @param ctx A block.
   */
  private void applyBraceInfo(BraceInfo.BraceLineBreakInfo braceLineBreakInfo,
                              ExtendContext ctx, FormatStyle formatStyle) {
    // Insert VWS terminal node near LBRACE and RBRACE terminal nodes.
    if (braceLineBreakInfo != null) {
      if (braceLineBreakInfo.beforeLB) {
        addVwsBefore(ctx, JavaParser.LBRACE);
      }
      if (braceLineBreakInfo.afterLB) {
        addVwsAfter(ctx, JavaParser.LBRACE);
      }
      if (braceLineBreakInfo.beforeRB) {
        addVwsBefore(ctx, JavaParser.RBRACE);
      }
      if (braceLineBreakInfo.afterRB) {
        addVwsAfter(ctx, JavaParser.RBRACE);
      }
    }

  }

  private void extractBraceInfo(BraceInfo.TypeEnum blockType, ExtendContext ctx, Style style) {
    FormatStyle formatStyle = (FormatStyle) style;
    int stmtNum = 0;
    stmtNum = getStmtNum(ctx);
    boolean beforeLB, afterLB, beforeRB, afterRB;
    TokenInfoField.BraceTokenInfo lbInfo, rbInfo;
    TokenInfoField.BraceTokenInfo[] infos = getBraceTokenInfo(ctx);
    lbInfo = infos[0];
    rbInfo = infos[1];
    beforeLB = lbInfo.before;
    afterLB = lbInfo.after;
    beforeRB = rbInfo.before;
    afterRB = rbInfo.after;

    formatStyle.updateBraceInfoStatistic(blockType, stmtNum, beforeLB, afterLB, beforeRB, afterRB);
  }

  private List<ExtendContext> getAllBlocks(ExtendContext ctx) {
    int ruleIndex = ctx.getRuleIndex();
    List<ExtendContext> blocks = new ArrayList<>();

    if (ruleIndex == JavaParser.RULE_body ||
        ruleIndex == JavaParser.RULE_arrayInitializer || ruleIndex == JavaParser.RULE_elementValueArrayInitializer) {
      blocks.add(ctx);
    } else {
      for (ParseTree child : ctx.children) {
        if (child instanceof JavaParser.BlockContext || child instanceof JavaParser.BodyContext) {
          blocks.add((ExtendContext) child);
        } else if (child instanceof JavaParser.CatchClauseContext) {
          blocks.add(((ExtendContext) child).getFirstInnerChildByType(JavaParser.RULE_block));
        }
      }
    }
    return blocks;
  }

  /**
   * @param ruleIndex Rule index of the real parent of the block.
   * @implNote This method doesn't handle the case: the block is a @BodyContext instance.
   */
  private BraceInfo.TypeEnum getBlockType(int ruleIndex) {
    BraceInfo.TypeEnum blockType;
    switch (ruleIndex) {
      case JavaParser.RULE_constructorDeclaration:
      case JavaParser.RULE_methodDeclaration:
      case JavaParser.RULE_typeDeclaration:
        blockType = BraceInfo.TypeEnum.BODY_BLOCK;
        break;
      case JavaParser.RULE_ifElseStmt:
      case JavaParser.RULE_tryCatchStmt:
        blockType = BraceInfo.TypeEnum.MULTI_BLOCK_STMT;
        break;
      case JavaParser.RULE_initializer:
      case JavaParser.RULE_arrayInitializer:
      case JavaParser.RULE_elementValueArrayInitializer:
        blockType = BraceInfo.TypeEnum.ARRAY_INITIALIZER_BLOCK;
        break;
      default:
        blockType = BraceInfo.TypeEnum.NORMAL_BLOCK;
    }
    return blockType;
  }

  private TokenInfoField.BraceTokenInfo[] getBraceTokenInfo(ExtendContext ctx) {
    int lbIndex = ctx.findFirstTerChildByType(JavaParser.LBRACE);
    int rbIndex = ctx.findFirstTerChildByType(JavaParser.RBRACE);
    TokenInfoField.BraceTokenInfo[] infos = new TokenInfoField.BraceTokenInfo[2];
    if (lbIndex == -1 || rbIndex == -1) {
      return infos;
    }
    ExtendToken lbToken = (ExtendToken) ((TerminalNode) ctx.getChild(lbIndex)).getSymbol();
    ExtendToken rbToken = (ExtendToken) ((TerminalNode) ctx.getChild(rbIndex)).getSymbol();
    infos[0] = (TokenInfoField.BraceTokenInfo) lbToken.info;
    infos[1] = (TokenInfoField.BraceTokenInfo) rbToken.info;
    return infos;
  }


  /**
   * @param ctx @BodyContext or @BlockContext instance.
   * @return
   * @implNote If @ctx is a @BodyContext instance, then only empty or non-empty body is concerned about.
   * If @ctx is a @BlockContext instance, then empty block, one single statement block or multiple statements block
   * is concerned about.
   */
  private int getStmtNum(ExtendContext ctx) {
    int stmtNum = ctx.countChildIf(child -> child instanceof ExtendContext); // Exclude LBRACE and RBRACE.
    if (stmtNum > 2) {
      stmtNum = 2;
    }
    if (stmtNum == 1 && !isSingleStmt(ctx.getChild(1))) {
      stmtNum = 2;
    }
    return stmtNum;
  }

  private boolean isSingleStmt(ParseTree root) {
    if (root instanceof TerminalNode) {
      return true;
    }

    ExtendContext ctx = (ExtendContext) root;
    int ruleIndex = ctx.getRuleIndex();
    if (ruleIndex == JavaParser.RULE_localVariableDeclarationStmt || ruleIndex == JavaParser.RULE_assertStmt ||
        ruleIndex == JavaParser.RULE_returnStmt || ruleIndex == JavaParser.RULE_throwStmt ||
        ruleIndex == JavaParser.RULE_breakStmt || ruleIndex == JavaParser.RULE_continueStmt ||
        ruleIndex == JavaParser.RULE_yieldStmt || ruleIndex == JavaParser.RULE_expressionStmt) {
      return true;
    }
    return false;
  }
}
