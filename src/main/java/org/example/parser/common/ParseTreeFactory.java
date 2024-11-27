package org.example.parser.common;


import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.antlr.v4.runtime.tree.TerminalNodeImpl;
import org.example.parser.common.factory.ExtendTokenFactory;

import java.util.ArrayList;
import java.util.List;

/*
 * @description
 * @author       Yingying Jiang
 * @create       2024/4/5 16:26
 */
public class ParseTreeFactory {
  private static ParseTreeFactory instance = new ParseTreeFactory();

  public static ParseTreeFactory getInstance() {
    return instance;
  }

  public static TerminalNode createTerminalNode(ExtendToken symbol) {
    return new TerminalNodeImpl(symbol);
  }


  /**
   * @apiNote If @children is null, then copy children from @t.
   * If @children is not null then set the children of new created context to @children.
   * @param t
   * @param children
   * @param shallow Determines shallow or deep copy of children.
   * @return
   */
  public ParseTree copyFrom(ParseTree t, List<ParseTree> children, boolean shallow) {
    ExtendContext parent = (ExtendContext) t.getParent();
    if (t instanceof TerminalNode terminalNode) {
      ExtendToken token = ((ExtendToken) terminalNode.getSymbol()).clone();
      TerminalNode newTer = new TerminalNodeImpl(token);
      newTer.setParent(parent);
      return newTer;
    } else {

      ExtendContext oldCtx = (ExtendContext) t;
      ExtendContext newCtx = null;
      try {
        newCtx = oldCtx.clone();
      } catch (CloneNotSupportedException e) {
        System.err.println(e.getMessage());
      }

      /*int rule = oldCtx.getRuleIndex();
      newCtx = switch (rule) {
        case JavaParser.RULE_expression -> new JavaParser.ExpressionContext(parent, oldCtx.invokingState);
        case JavaParser.RULE_expressionStmt -> new JavaParser.ExpressionStmtContext(parent, oldCtx.invokingState);
        case JavaParser.RULE_parExpression -> new JavaParser.ParExpressionContext(parent, oldCtx.invokingState);
        case JavaParser.RULE_block -> new JavaParser.BlockContext(parent, oldCtx.invokingState);
        case JavaParser.RULE_ifStmt -> new JavaParser.IfStmtContext(parent, oldCtx.invokingState);
        case JavaParser.RULE_ifElseStmt -> new JavaParser.IfElseStmtContext(parent, oldCtx.invokingState);
        case JavaParser.RULE_forStmt -> new JavaParser.ForStmtContext(parent, oldCtx.invokingState);
        case JavaParser.RULE_forControl -> new JavaParser.ForControlContext(parent, oldCtx.invokingState);
        case JavaParser.RULE_whileStmt -> new JavaParser.WhileStmtContext(parent, oldCtx.invokingState);
        case JavaParser.RULE_returnStmt -> new JavaParser.ReturnStmtContext(parent, oldCtx.invokingState);
        case JavaParser.RULE_identifier -> new JavaParser.IdentifierContext(parent, oldCtx.invokingState);
        case JavaParser.RULE_literal -> new JavaParser.LiteralContext(parent, oldCtx.invokingState);
        case JavaParser.RULE_modifierList -> new JavaParser.ModifierListContext(parent, oldCtx.invokingState);
        case JavaParser.RULE_annotationList -> new JavaParser.AnnotationListContext(parent, oldCtx.invokingState);
        case JavaParser.RULE_typeType -> new JavaParser.TypeTypeContext(parent, oldCtx.invokingState);
        case JavaParser.RULE_localVariableDeclaration -> new JavaParser.LocalVariableDeclarationContext(parent, oldCtx.invokingState);
        case JavaParser.RULE_localVariableDeclarationStmt -> new JavaParser.LocalVariableDeclarationStmtContext(parent, oldCtx.invokingState);
        default -> newCtx;
      };*/
      if (newCtx == null) {
        throw new RuntimeException("copy tree node \"" + t.getClass().getSimpleName() + "\" failed!");
      }

      // add children
      if (children != null) {
        newCtx.children.clear();
        newCtx.addChildren(children);
      } else if(shallow) {
        newCtx.addChildren(oldCtx.children);
      } else {
        List<ParseTree> newChildren = new ArrayList<>();
        for(ParseTree child : oldCtx.children) {
          newChildren.add(copyFrom(child, null, false));
        }
        newCtx.addChildren(newChildren);
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
