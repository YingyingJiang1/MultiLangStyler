package org.example.parser.common.factory;


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
import java.util.List;

/*
 * @description
 * @author       Yingying Jiang
 * @create       2024/4/5 16:26
 */
public class ParseTreeFactory {
  public static Logger logger = LoggerFactory.getLogger(ParseTreeFactory.class);

  private static ParseTreeFactory instance = new ParseTreeFactory();

  public static ParseTreeFactory getInstance() {
    return instance;
  }

  public ParseTree copyTree(ParseTree t , boolean shallow) {
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
   * the parent of the negative expression is the same as @expCtx's parent.
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
      children.add(bangChild);
      children.add(expCtx);
      notExpression.children.clear();
      notExpression.addChildren(children);
      return notExpression;
    }
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
