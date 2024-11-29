package org.example.styler.body.braceformat;

import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.example.parser.common.context.ExtendContext;
import org.example.parser.common.token.ExtendToken;
import org.example.parser.common.token.TokenInfoField;
import org.example.style.Style;

import org.example.styler.body.BodyContext;
import org.example.styler.body.BodyStyler;
import org.example.styler.body.braceformat.style.BraceFormatProperty;
import org.example.styler.body.BodyTypeEnum;

import java.util.*;

public class BraceFormatStyler extends BodyStyler {
  private static Set<Integer> relevantRules = null;

  private static final BraceFormatProperty DEFAULT_PROPERTY = new BraceFormatProperty(false, true, true, true);

  public BraceFormatStyler() {
    style.setStyleName("brace_format");
    executeWhenExit = false;
  }

  @Override
  public ExtendContext applyStyle(ExtendContext ctx) {
    List<ExtendContext> blocks = getAllBlocks(ctx);

    // Apply brace information.
    int lastIndex = blocks.size() - 1;
    for (int i = 0; i < blocks.size(); ++i) {
      ExtendContext block = blocks.get(i);
      BodyContext context = extractStyleContext(ctx, block);
      // Specially process the last block of multi-block statement.
      if (context.bodyType == BodyTypeEnum.MULTI_BLOCK_STMT_BODY && block == ctx.getLastContextChild()) {
        context.bodyType = BodyTypeEnum.NORMAL_BODY;
      }

      BraceFormatProperty braceFormatProperty = (BraceFormatProperty) style.getProperty(context);
      if (braceFormatProperty == null) {
        braceFormatProperty = DEFAULT_PROPERTY;
      }
      applyBraceInfo(braceFormatProperty, block);
    }
    return ctx;
  }

  @Override
  public void extractStyle(ExtendContext ctx) {
    List<ExtendContext> blocks = getAllBlocks(ctx);
    int ruleIndex = ctx.getRuleIndex();
    boolean isNotMultiBlockStmt = ruleIndex != parser.getRuleIfElseStmt() && ruleIndex != parser.getRuleTryCatchStmt();
    // Extract brace information.
    for (int i = 0; i < blocks.size(); ++i) {
      ExtendContext block = (ExtendContext) blocks.get(i);
      // Skip the last block of multi-block statement.
      if (isNotMultiBlockStmt || block != ctx.getLastContextChild()) {
        TokenInfoField.BraceTokenInfo lbInfo, rbInfo;
        TokenInfoField.BraceTokenInfo[] infos = getBraceTokenInfo(block);
        lbInfo = infos[0];
        rbInfo = infos[1];
        BraceFormatProperty styleProperty = new BraceFormatProperty(lbInfo.before, lbInfo.after, rbInfo.before, rbInfo.after);
        style.addRule(extractStyleContext(ctx, block), styleProperty);
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
    Token vwsToken = parser.getTokenFactory().create(parser.getVws(), System.lineSeparator());
    token.addToken(token.indexInContextTokens(), vwsToken);
  }

  private void addVwsAfter(ExtendContext ctx, int braceType) {
    ExtendToken token = (ExtendToken) ctx.getFirstTokenByType(braceType);
    boolean hasTrailingComment = token.indexOfLastTokenAfterIf(type -> type == parser.getLineComment()) >= 0;
    if(!hasTrailingComment) {
      Token vwsToken = parser.getTokenFactory().create(parser.getVws(), System.lineSeparator());
      token.addToken(token.indexInContextTokens() + 1, vwsToken);
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
}
