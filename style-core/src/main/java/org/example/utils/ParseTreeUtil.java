package org.example.utils;


import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.antlr.v4.runtime.tree.TerminalNodeImpl;
import org.example.antlr.common.context.ExtendContext;
import org.example.lang.LangAdapterCreator;
import org.example.lang.intf.MyParser;
import org.example.antlr.common.factory.ExtendTokenFactory;
import org.example.antlr.common.token.ExtendToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/*
 * @description
 * @author       Yingying Jiang
 * @create       2024/4/5 16:26
 */
public class ParseTreeUtil {
  public static Logger logger = LoggerFactory.getLogger(ParseTreeUtil.class);

  private static ParseTreeUtil instance = new ParseTreeUtil();

  public static ParseTreeUtil getInstance() {
    return instance;
  }



  public static ParseTree copyTree(ParseTree t , boolean shallow) {
    if (t == null) {
      return null;
    }
    ParseTree newNode = copyNode(t);

    // Recursively copy children.
    if (newNode instanceof ExtendContext newCtx) {
      ExtendContext oldCtx =  (ExtendContext) t;
      if (shallow) {
        newCtx.addChildren(oldCtx.children);
      } else {
        List<ParseTree> newChildren = new ArrayList<>();
        for (ParseTree child : oldCtx.children) {
          newChildren.add(copyTree(child, shallow));
        }
        newCtx.addChildren(newChildren);
      }
    }

    if (newNode instanceof ExtendContext newCtx) {
      newCtx.updateStartToken();
      newCtx.updateStopToken();
    }
    return newNode;
  }

  /**
   * deep copy
   * @param node node to be copied.
   * @return
   */
  public static ParseTree copyNode(ParseTree node) {
    ExtendContext parent = (ExtendContext) node.getParent();
    if (node instanceof TerminalNode terminalNode) {
      ExtendToken token = ((ExtendToken) terminalNode.getSymbol()).clone();
      TerminalNode newTer = new TerminalNodeImpl(token);
      newTer.setParent(parent);
      return newTer;
    } else {
      ExtendContext oldCtx = (ExtendContext) node;
      ExtendContext newCtx = null;
      try {
        newCtx = oldCtx.clone();
      } catch (CloneNotSupportedException e) {
        logger.error(e.getMessage(), e);
      }

      if (newCtx == null) {
        throw new RuntimeException("copy tree node \"" + node.getClass().getSimpleName() + "\" failed!");
      }
      return newCtx;
    }
  }


  public int getTreeDepth(ParseTree root) {
    if (root == null) {
      return 0;
    }
    if (root.getChildCount() == 0) {
      return 1;
    }

    int maxDepth = 0;
    if (root instanceof ExtendContext ctx) {
      for (ParseTree child : ctx.children) {
        int childDepth = getTreeDepth(child);
        maxDepth = Math.max(maxDepth, childDepth + 1);
      }
      return maxDepth;
    }
    return maxDepth;
  }

  public static void generateTokens(ParseTree root, List<Token> tokens, MyParser parser) {
    generateTokensRec(root, tokens, parser);
    updateTokenLocation(tokens);
  }

  public static void generateTokensRec(ParseTree root, List<Token> tokens, MyParser parser) {
    if (root == null) {
      return;
    }

    if (root instanceof TerminalNode) {
      int hierarchy = ((ExtendContext) root.getParent()).hierarchy;
      ExtendToken token = (ExtendToken) (((TerminalNode) root).getSymbol());
      List<Token> contextTokens = token.getContextTokens();
      contextTokens.forEach(t -> {
        if (t instanceof ExtendToken extToken) {
          extToken.setHierarchy(hierarchy);
        }
      });

      int idxInList = tokens.size() + token.indexInContextTokens();
//      token.resetContextTokens();
      tokens.addAll(contextTokens);

      Token leftToken = TokenStreamUtil.findFirstDefaultTokenOnLeft(tokens, idxInList, parser);
      int greaterHierarchy = token.getHierarchy();
      if (leftToken instanceof ExtendToken leftExt && leftExt.getHierarchy() > greaterHierarchy) {
        greaterHierarchy = leftExt.getHierarchy();
      }
      for (int i = idxInList - 1; i >= 0; i--) {
        if (tokens.get(i).getChannel() == parser.getDefaultChannel()) {
          break;
        }
        if (tokens.get(i) instanceof ExtendToken extendToken) {
          extendToken.setHierarchy(token.getHierarchy());
        }
      }

      // case: token1 format_token_1...format_token_n token2
      // set hierarchy of format_token_n to token2's hierarchy, and set hierarchy of other format tokens to the greater hierarchy between token1 and token2.
//      if (idxInList - 1 >= 0 && tokens.get(idxInList - 1) instanceof ExtendToken extendToken && extendToken.getChannel() != parser.getDefaultChannel()) {
//        extendToken.setHierarchy(token.getHierarchy());
//      }
//      for (int i = idxInList - 2; i >= 0; i--) {
//        if (tokens.get(i).getChannel() == parser.getDefaultChannel()) {
//          break;
//        }
//        if (tokens.get(i) instanceof ExtendToken extendToken && extendToken.getHierarchy() < token.getHierarchy()) {
//          extendToken.setHierarchy(token.getHierarchy());
//        }
//      }
    } else {
      ExtendContext ctx = (ExtendContext) root;
      LangAdapterCreator.createASTNodeEditor(parser.getLanguage()).updateHierarchy(ctx);
      for (ParseTree child : ctx.children) {
        generateTokens(child, tokens, parser);
      }
    }
  }

  public static ExtendToken getPreToken(ExtendContext ctx, Token targetToken) {
    ParserRuleContext parent = ctx.getParent();
    while (parent != null && parent.getStart() == targetToken) {
      if (parent.getParent() == null) {
        break;
      }
      parent = parent.getParent();
    }

    if (parent == null) {
      return null;
    }
    List<Token> tokens = ((ExtendContext) parent).getAllTokensRec();
    int index = tokens.indexOf(targetToken) -1;
    return index >= 0 ? (ExtendToken) tokens.get(index) : null;
  }

  public static void updateTokenLocation(List<Token> tokens) {
    int curLine = 1;
    int curPositionInLine = 0;

    for (Token t : tokens) {
      if (t instanceof ExtendToken extendToken) {
        extendToken.setLine(curLine);
        extendToken.setCharPositionInLine(curPositionInLine);
      }

      long newlineCount = t.getText().chars().filter(ch -> ch == '\n').count();

      if (newlineCount == 0) {
        curPositionInLine += t.getText().length();
      } else {
        curLine += (int) newlineCount;
        curPositionInLine = 0;
      }
    }
  }

  public static void toNiceFormat(ParseTree root, MyParser parser) {
    if (root instanceof ExtendContext ctx) {
      if (parser.isStatement(ctx)) {
        if (ctx.getStop() instanceof ExtendToken token && ctx.getStop().getText().equals(";") ) {
          token.addTokenAfter(ExtendTokenFactory.DEFAULT.create(parser.getVws(), "\n"), parser);
        }
        if (parser.isBlock(parser.getSpecificStmt(ctx))) {
          ExtendContext block = parser.getSpecificStmt(ctx);
          for (ParseTree child : block.children) {
            if (child instanceof TerminalNode ter && ter.getSymbol() instanceof ExtendToken extendToken) {
              if (extendToken.getText().equals("{")) {
                extendToken.addTokenAfter(ExtendTokenFactory.DEFAULT.create(parser.getVws(), "\n"), parser);
              } else if (extendToken.getText().equals("}")) {
                extendToken.addTokenAfter(ExtendTokenFactory.DEFAULT.create(parser.getVws(), "\n"), parser);
                extendToken.addTokenBefore(ExtendTokenFactory.DEFAULT.create(parser.getVws(), "\n"), parser);
              }
            }
          }
        }
      }

      for (ParseTree child : ctx.children) {
        toNiceFormat(child, parser);
      }
    }
  }


  public void replaceTree(ParseTree parent, ParseTree newTree, ParseTree oldTree) {
    if (parent instanceof ExtendContext parentCtx) {
      for (int i = 0; i < parent.getChildCount(); i++) {
        ParseTree child = parent.getChild(i);
        if(child.equals(oldTree)) {
          parentCtx.children.set(i, newTree);
        }
      }
    }
  }




//  private void modifyLink(ExtendContext parent, ParseTree newChild, ParseTree oldChild) {
//    for (int i = 0; i < parent.getChildCount(); i++) {
//      ParseTree child = parent.getChild(i);
//      if(child.equals(oldChild)) {
//        parent.children.set(i, newChild);
//      }
//    }
//
//    if(newChild instanceof ExtendContext newCtxChilld) {
//      for(ParseTree child : newCtxChilld.children) {
//        child.setParent(newCtxChilld);
//      }
//      newCtxChilld.updateStartToken();
//      newCtxChilld.updateStopToken();
//    }
//  }

}
