package org.example.styler.brace;

import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.example.parser.common.ExtendContext;
import org.example.parser.common.ExtendToken;
import org.example.parser.common.TokenInfoField;

import org.example.style.Style;
import org.example.styler.Styler;
import org.example.styler.brace.style.*;

import java.util.*;

public class BraceStyler extends Styler {
  private static Set<Integer> relevantRules = null;

  public BraceStyler() {
    style = new BraceStyle();
  }

  @Override
  public ExtendContext applyStyle(ExtendContext ctx) {
    applyOptionalBraceStyle(ctx, style);
    List<ExtendContext> blocks = getAllBlocks(ctx);
    TypeEnum blockType = TypeEnum.getBlockType(ctx.getRuleIndex(), parser);

    // Apply brace information and add blank line.
    int lastIndex = blocks.size() - 1;
    for (int i = 0; i < blocks.size(); ++i) {
      ExtendContext block = blocks.get(i);
      // Specially process the last block of multi-block statement.
      if (blockType == TypeEnum.MULTI_BLOCK_STMT && block == ctx.getLastContextChild()) {
        blockType = TypeEnum.NORMAL_BLOCK;
      }

      BraceFormatContext styleContext = new BraceFormatContext(blockType, getStmtNum(block));
      BraceFormatProperty braceFormatProperty = (BraceFormatProperty) style.getProperty(styleContext);
      applyBraceInfo(braceFormatProperty, block);
    }
    return ctx;
  }

  @Override
  public void extractStyle(ExtendContext ctx) {
    extractOptionalBraceStyle(ctx, style);

    List<ExtendContext> blocks = getAllBlocks(ctx);
    int ruleIndex = ctx.getRuleIndex();
    TypeEnum blockType = TypeEnum.getBlockType(ruleIndex, parser);
    boolean isNotMultiBlockStmt = ruleIndex != parser.getRuleIfElseStmt() && ruleIndex != parser.getRuleTryCatchStmt();
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
  private void applyOptionalBraceStyle(ExtendContext ctx, Style style) {
    if(!parser.belongToBraceOptionalStmt(ctx.getRuleIndex())) {
      return;
    }
    OptionalBraceProperty property = (OptionalBraceProperty) style.getProperty(null);
    for (int i = 0; i < ctx.getChildCount(); i++) {
      ParseTree child = ctx.getChild(i);
      if(parser.isStatement(child) && child instanceof ExtendContext stmtCtx) {
        if (!parser.isBlock(stmtCtx)) {
          ExtendToken stop = (ExtendToken) stmtCtx.stop;
          if(!property.compactStyle) {
            ctx.addVws(i, 1);
            ++i;
          } else {
            ExtendToken start = (ExtendToken) stmtCtx.start;
            // Move line comment to the end of statement.
            if(!start.trailingComment && !start.comments.isEmpty() &&
                parser.getLineComment() == start.comments.get(start.comments.size() - 1).getType()) {
              stop = (ExtendToken) stmtCtx.stop;
              stop.trailingComment = true;
              stop.comments.addAll(start.comments);
              start.comments.clear();
            }
          }
          if(!(stop.trailingComment && parser.getLineComment() == stop.comments.get(0).getType())) {
            ctx.addVws(i + 1, 1); // Add vws after statement
            ++i;
          }
        }
      }
    }
  }

  private void extractOptionalBraceStyle(ExtendContext ctx, Style style) {
    if(!parser.belongToBraceOptionalStmt(ctx.getRuleIndex())) {
      return;
    }
    for (int i = 0; i < ctx.getChildCount(); i++) {
      ParseTree child = ctx.getChild(i);
      if(parser.isStatement(child) && child instanceof ExtendContext stmtCtx) {
        OptionalBraceProperty property = new OptionalBraceProperty();
        if(parser.isBlock(stmtCtx)) {
          int innerStmtRule = stmtCtx.getRuleIndex();
          boolean braceNotOptional = innerStmtRule == parser.getRuleIfElseStmt() ||
              ctx.getRuleIndex() == parser.getRuleIfElseStmt() && innerStmtRule == parser.getRuleIfStmt();
          property.useBrace = stmtCtx.countChildIf(parser::isStatement) == 1 && !braceNotOptional;
        } else {
          ParseTree preChild = ctx.getChild(i - 1);
          int preChildLine = preChild instanceof TerminalNode ? ((TerminalNode) preChild).getSymbol().getLine() :
              ((ExtendContext) preChild).stop.getLine();
          property.compactStyle = (stmtCtx.start.getLine() == preChildLine);
        }
        style.addRule(null, property);
      }
    }
  }

  @Override
  protected Set<Integer> getRelevantRules() {
    if (relevantRules == null) {
      relevantRules = new HashSet<>(Arrays.asList(
              parser.getRuleTypeDeclaration(),
              parser.getRuleSwitchBlockStatementGroup(),
              parser.getRuleConstructorDeclaration(),
              parser.getRuleMethodDeclaration(),
              parser.getRuleSyncStmt(),
              parser.getRuleInitializer(),
              parser.getRuleArrayInitializer(),
              parser.getRuleElementValueArrayInitializer()
      ));
      relevantRules.addAll(parser.getCompoundStmts());
    }
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
      if (parser.isTypeDeclaration(child) || parser.isStatement(child)) {
        // SKip block statement
        if (child.getChildCount() > 0 &&  parser.isBlock(child.getChild(0))) {
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
        parser.getBlockComment() == token.comments.get(token.comments.size() - 1).getType()) {
      token.comments.add(new ExtendToken(parser.getVws(), System.lineSeparator()));
    } else {
      ctx.addVws(ctx.findFirstTerChildByType(braceType),1);
    }
  }

  private void addVwsAfter(ExtendContext ctx, int braceType) {
    ExtendToken token = (ExtendToken) ctx.getFirstTokenByType(braceType);
    if(!(token.trailingComment && parser.getLineComment() == token.comments.get(token.comments.size() - 1).getType())) {
      ctx.addVws(ctx.findFirstTerChildByType(braceType) + 1, 1);
    }
  }

  /**
   * @param ctx A block.
   */
  private void applyBraceInfo(BraceFormatProperty braceFormatProperty, ExtendContext ctx) {
    // Insert VWS terminal node near LBRACE and RBRACE terminal nodes.
    if (braceFormatProperty != null) {
      if (braceFormatProperty.beforeLB) {
        addVwsBefore(ctx, parser.getLBrace());
      }
      if (braceFormatProperty.afterLB) {
        addVwsAfter(ctx, parser.getLBrace());
      }
      if (braceFormatProperty.beforeRB) {
        addVwsBefore(ctx, parser.getRBrace());
      }
      if (braceFormatProperty.afterRB) {
        addVwsAfter(ctx, parser.getRBrace());
      }
    }

  }

  private void extractBraceInfo(TypeEnum blockType, ExtendContext ctx, Style style) {
    int stmtNum = 0;
    stmtNum = getStmtNum(ctx);
    BraceFormatContext styleContext = new BraceFormatContext(blockType, stmtNum);

    boolean beforeLB, afterLB, beforeRB, afterRB;
    TokenInfoField.BraceTokenInfo lbInfo, rbInfo;
    TokenInfoField.BraceTokenInfo[] infos = getBraceTokenInfo(ctx);
    lbInfo = infos[0];
    rbInfo = infos[1];
    BraceFormatProperty styleProperty = new BraceFormatProperty(lbInfo.before, lbInfo.after, rbInfo.before, rbInfo.after);

    style.addRule(styleContext, styleProperty);
  }

  private List<ExtendContext> getAllBlocks(ExtendContext ctx) {
    int ruleIndex = ctx.getRuleIndex();
    List<ExtendContext> blocks = new ArrayList<>();

    if (ruleIndex == parser.getRuleBody() ||
        ruleIndex == parser.getRuleArrayInitializer() || ruleIndex == parser.getRuleElementValueArrayInitializer()) {
      blocks.add(ctx);
    } else {
      for (ParseTree child : ctx.children) {
        if (parser.isBlock(child) || parser.isBody(child)) {
          blocks.add((ExtendContext) child);
        } else if (parser.isCatchClause(child)) {
          blocks.add(((ExtendContext) child).getFirstInnerChildByType(parser.getRuleBlock()));
        }
      }
    }
    return blocks;
  }

  private TokenInfoField.BraceTokenInfo[] getBraceTokenInfo(ExtendContext ctx) {
    int lbIndex = ctx.findFirstTerChildByType(parser.getLBrace());
    int rbIndex = ctx.findFirstTerChildByType(parser.getRBrace());
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
    if (stmtNum == 1 && !parser.belongToSingleStmt(ctx.getChild(1))) {
      stmtNum = 2;
    }
    return stmtNum;
  }
}
