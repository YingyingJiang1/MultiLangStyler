package org.example.styler.format.body;

import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.example.parser.common.ExtendContext;
import org.example.parser.common.ExtendToken;
import org.example.parser.common.TokenInfoField;
import org.example.style.Style;
import org.example.styler.Styler;
import org.example.styler.format.body.style.BodyLayoutContext;
import org.example.styler.format.body.style.BodyLayoutProperty;
import org.example.styler.format.body.style.TypeEnum;

import java.util.*;

public class BodyLayoutStyler extends Styler {
  private static Set<Integer> relevantRules = null;

  public BodyLayoutStyler() {
    style.setStyleName("body_layout");
  }

  public BodyLayoutStyler(boolean executeWhenExit) {
    super(executeWhenExit);
    style.setStyleName("body_layout");
  }

  @Override
  public ExtendContext applyStyle(ExtendContext ctx) {
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

      BodyLayoutContext styleContext = new BodyLayoutContext(blockType, getStmtNum(block));
      BodyLayoutProperty bodyLayoutProperty = (BodyLayoutProperty) style.getSimilarProperty(styleContext);
      applyBraceInfo(bodyLayoutProperty, block);
    }
    return ctx;
  }

  @Override
  public void extractStyle(ExtendContext ctx) {
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
      ctx.addTerNode(parser.getVws(), System.lineSeparator(), ctx.findFirstTerChildByType(braceType));
    }
  }

  private void addVwsAfter(ExtendContext ctx, int braceType) {
    ExtendToken token = (ExtendToken) ctx.getFirstTokenByType(braceType);
    if(!(token.trailingComment && parser.getLineComment() == token.comments.get(token.comments.size() - 1).getType())) {
      ctx.addTerNode(parser.getVws(), System.lineSeparator(), ctx.findFirstTerChildByType(braceType) + 1);
    }
  }

  /**
   * @param ctx A block.
   */
  private void applyBraceInfo(BodyLayoutProperty bodyLayoutProperty, ExtendContext ctx) {
    // Insert VWS terminal node near LBRACE and RBRACE terminal nodes.
    if (bodyLayoutProperty != null) {
      if (bodyLayoutProperty.beforeLB) {
        addVwsBefore(ctx, parser.getLBrace());
      }
      if (bodyLayoutProperty.afterLB) {
        addVwsAfter(ctx, parser.getLBrace());
      }
      if (bodyLayoutProperty.beforeRB) {
        addVwsBefore(ctx, parser.getRBrace());
      }
      if (bodyLayoutProperty.afterRB) {
        addVwsAfter(ctx, parser.getRBrace());
      }
    }

  }

  private void extractBraceInfo(TypeEnum blockType, ExtendContext ctx, Style style) {
    int stmtNum = 0;
    stmtNum = getStmtNum(ctx);
    BodyLayoutContext styleContext = new BodyLayoutContext(blockType, stmtNum);

    boolean beforeLB, afterLB, beforeRB, afterRB;
    TokenInfoField.BraceTokenInfo lbInfo, rbInfo;
    TokenInfoField.BraceTokenInfo[] infos = getBraceTokenInfo(ctx);
    lbInfo = infos[0];
    rbInfo = infos[1];
    BodyLayoutProperty styleProperty = new BodyLayoutProperty(lbInfo.before, lbInfo.after, rbInfo.before, rbInfo.after);

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
