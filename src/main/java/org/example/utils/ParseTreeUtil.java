package org.example.utils;


import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.antlr.v4.runtime.tree.TerminalNodeImpl;
import org.example.parser.common.context.ExtendContext;
import org.example.parser.common.MyParser;
import org.example.parser.common.token.ExtendToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

  // key: compare operator, value: reversing compare operator
  static Map<String, String> compareOpMap ;
  static Map<String, String> logicalOpMap;

  static {
    compareOpMap = new HashMap<>();
    compareOpMap.put(">", "<=");
    compareOpMap.put("<", ">=");
    compareOpMap.put(">=", "<");
    compareOpMap.put("<=", ">=");
    compareOpMap.put("==", "!=");
    compareOpMap.put("!=", "==");

    logicalOpMap = new HashMap<>();
    logicalOpMap.put("&&", "||");
    logicalOpMap.put("||", "&&");
  }

  public ParseTree copyTree(ParseTree t , boolean shallow) {
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

    return newNode;
  }

  /**
   * deep copy
   * @param node node to be copied.
   * @return
   */
  public ParseTree copyNode(ParseTree node) {
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


  /**
   * @apiNote Create a negative expression of @expCtx,
   * @implNote just wrap the original expression and add a "!" token in the front.
   * @param expCtx
   * @return
   */
  public ExtendContext negateExpression(ExtendContext expCtx, MyParser parser) {
    ExtendContext parent = (ExtendContext) expCtx.getParent();
    if(expCtx.start.getText().equals("!")) {
      ExtendContext notExpression = (ExtendContext) expCtx.getChild(1);;
      notExpression.setParent(expCtx.getParent());
      return notExpression;
    } else {
      ExtendContext notExpression = (ExtendContext) parser.createExpression(parent, expCtx.invokingState);
      List<ParseTree> children = new ArrayList<>();
      ParseTree bangChild = new TerminalNodeImpl(parser.getTokenFactory().create(parser.getBang(), "!"));
      ExtendContext wrapped = encapsulateExpWithParen(expCtx, parser);
      children.add(bangChild);
      children.add(wrapped);
      notExpression.children.clear();
      notExpression.addChildren(children);
      return notExpression;
    }
  }

  /**
   * @apiNote Create a negative expression of @expCtx,
   * @implNote just wrap the original expression and add a "!" token in the front.
   * @param expCtx
   * @return
   */
  public ExtendContext negateExpressionSmart(ExtendContext expCtx, MyParser parser) {
    ExtendToken op = (ExtendToken) getOp(expCtx, parser);
    String reversedOp = compareOpMap.get(op.getText());
    if (reversedOp != null) {
      // reverse compare or logical operator
      op.setType(parser.getType(reversedOp));
      op.setText(reversedOp);
      return expCtx;
    }

    reversedOp = logicalOpMap.get(op.getText());
    ExtendContext exp = expCtx;
    if (reversedOp != null) {
      exp = ParseTreeUtil.getInstance().encapsulateExpWithParen(expCtx, parser);
    }
    // expression -> !expression or !expression -> expression
    ExtendContext notExp = ParseTreeUtil.getInstance().negateExpression(exp, parser);
    return notExp;
  }

  /**
   * Find the comparison and logical operators.
   * @param ctx
   * @return
   */
  private Token getOp(ExtendContext ctx, MyParser parser) {
    List<TerminalNode> ters = ctx.getAllTerminalsIf(v -> true);
    if (ters.isEmpty()) {
      return parser.getTokenFactory().create(0, "");
    }
    return ters.get(0).getSymbol();
  }


  public ExtendContext encapsulateExpWithParen(ExtendContext expCtx, MyParser parser) {
    if (expCtx.start.getType() == parser.getLParen() && expCtx.stop.getType() == parser.getRParen()) {
      return expCtx;
    }
    Token lParen = parser.getTokenFactory().create(parser.getLParen(), "(");
    Token rParen = parser.getTokenFactory().create(parser.getRParen(), ")");

    ExtendContext parent = (ExtendContext) expCtx.getParent();
    ExtendContext parenExpression = (ExtendContext) parser.createExpression(parent, expCtx.invokingState);
    List<ParseTree> children = new ArrayList<>();
    children.add(new TerminalNodeImpl(lParen));
    children.add(expCtx);
    children.add(new TerminalNodeImpl(rParen));
    parenExpression.children.clear();
    parenExpression.addChildren(children);
    return parenExpression;
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
