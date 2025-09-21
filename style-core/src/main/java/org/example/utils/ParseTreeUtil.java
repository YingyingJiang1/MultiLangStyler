package org.example.utils;


import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.antlr.v4.runtime.tree.TerminalNodeImpl;
import org.example.parser.common.context.ExtendContext;
import org.example.parser.common.MyParser;
import org.example.parser.common.factory.ExtendTokenFactory;
import org.example.parser.common.factory.TreeNodeFactoryGetter;
import org.example.parser.common.factory.context.TreeNodeFactory;
import org.example.parser.common.token.ExtendToken;
import org.example.utils.editor.NodeEditorFactory;
import org.example.utils.searcher.NodeSearcherFactory;
import org.example.utils.searcher.intf.VarDeclarationSearcher;
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
    compareOpMap.put("<=", ">");
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
    // expression has wrapped by () already
    if (expCtx.getChildCount() == 3
            && expCtx.getChild(0) instanceof TerminalNode ter1 && ter1.getSymbol().getType() == parser.getLParen()
    && expCtx.getChild(2) instanceof TerminalNode ter2 && ter2.getSymbol().getType() == parser.getRParen()) {
      return expCtx;
    }

    if (expCtx.getChildCount() == 1) {
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

  public ExtendContext encapsulateStmtWithBrace(ExtendContext stmtCtx, MyParser parser) {
    ExtendContext parent = (ExtendContext) stmtCtx.getParent();
    Token stop = stmtCtx.getStop();

    ExtendContext newStmt = TreeNodeFactoryGetter.getFactory(parser).createStatement(parent);

    ExtendContext blockNode = TreeNodeFactoryGetter.getFactory(parser).createBlock(newStmt);
    ExtendToken lBrace = parser.getTokenFactory().create(parser.getLParen(), "{");
    ExtendToken rBrace = parser.getTokenFactory().create(parser.getRParen(), "}");
    // Add Format tokens
//    lBrace.addTokenAfter(ExtendTokenFactory.DEFAULT.create(parser.getVws(), "\n"), parser);
//    rBrace.addTokenBefore(ExtendTokenFactory.DEFAULT.create(parser.getVws(), "\n"), parser);
//    rBrace.addTokenAfter(ExtendTokenFactory.DEFAULT.create(parser.getVws(), "\n"), parser);

//    ((ExtendToken) lBrace).addTokenAfter(parser.getTokenFactory().create(parser.getVws(), "\n"), parser);
//    ((ExtendToken) rBrace).addTokenAfter(parser.getTokenFactory().create(parser.getVws(), "\n"), parser);

    List<ParseTree> children = new ArrayList<>();
    children.add(new TerminalNodeImpl(lBrace));
    children.add(stmtCtx);
    children.add(new TerminalNodeImpl(rBrace));
    blockNode.children.clear();
    blockNode.addChildren(children);

    newStmt.addChild(blockNode);
    parent.replaceChild(stmtCtx, newStmt);

    newStmt.updateStartToken();
    newStmt.updateStopToken();

    // 修正{附近的context tokens
    while (parent != null && parent.getStart() == lBrace) {
      if (parent.getParent() == null) {
        break;
      }
      parent = (ExtendContext) parent.getParent();
    }
    List<Token> tokens = parent.getAllTokensRec();
    int lbIndex = tokens.indexOf(lBrace);
    if (lbIndex - 1 >= 0 &&  tokens.get(lbIndex - 1) instanceof ExtendToken leftToken) {
      // 将{前面一个的token的context tokens从第一个换行或者注释开始，移动到{的context tokens中
      int index = leftToken.indexOfFirstTokenAfterIf(t -> parser.getVws() == t || parser.belongToComment(t));
      if (index >= 0) {
        List<Token> movenTokens = leftToken.getContextTokens().subList(index, leftToken.getContextTokens().size());
        lBrace.getContextTokens().addAll(movenTokens);
        leftToken.getContextTokens().removeAll(movenTokens);
      }
    }

    // 移除空语句
    if (stmtCtx.getChild(0) instanceof TerminalNode terminal) {
      blockNode.removeChildIf(e -> e == stmtCtx);
      if (terminal.getSymbol() instanceof ExtendToken extendToken) {
        List<Token> moveTokens = extendToken.getContextTokens().subList(extendToken.indexInContextTokens() + 1, extendToken.getTrailingCommentIndex(parser) + 1);
        lBrace.getContextTokens().addAll(moveTokens);
      }
    }
    // 修正}附近的context tokens
    if (stop instanceof ExtendToken extendToken) {
      int trailingCommentIndex = extendToken.getTrailingCommentIndex(parser);
      int targetIndex = 0;
      if (trailingCommentIndex >= 0) {
        targetIndex = trailingCommentIndex;
      } else {
        targetIndex = extendToken.indexInContextTokens();
      }
      List<Token> moveTokens = extendToken.getContextTokens().subList(targetIndex + 1, extendToken.getContextTokens().size());
      // AddAll 和removeAll操作不能变更顺序，否则会出错
      rBrace.getContextTokens().addAll(moveTokens);
      extendToken.getContextTokens().removeAll(moveTokens);
    }

    return newStmt;
  }


  public ExtendContext removeBraceOfStmt(ExtendContext stmtCtx, MyParser parser) {

    ExtendContext block = parser.getSpecificStmt(stmtCtx);
    ExtendContext innerStmt = block.getFirstCtxChildIf(t -> true);
    ExtendContext parent = new ExtendContext();
    if (stmtCtx.getParent() instanceof ExtendContext) {
      parent = (ExtendContext) stmtCtx.getParent();
    }

    // 添加空语句
    boolean isEmptyStmt = false;
    if (innerStmt == null) {
      isEmptyStmt = true;
      TreeNodeFactory factory = parser.getTreeNodeFactory();
      innerStmt = factory.createStatement(parent);
      ExtendToken semiToken = parser.getTokenFactory().create(parser.getSemi(), ";");
//      semiToken.addTokenAfter(parser.getTokenFactory().create(parser.getVws(), "\n"), parser);
      innerStmt.addChild(factory.createTerminal(semiToken));
      innerStmt.updateStopToken();
      innerStmt.updateStartToken();
    }

    // 把lbrace后面的内容移到）后面，如果内部是空语句，那么仅把lbrace后面的注释内容移到空语句后面
    ExtendToken lbBrace = (ExtendToken) block.getStart();
    ExtendToken preToken = getPreToken(stmtCtx, lbBrace);
    if (isEmptyStmt && innerStmt.getStop() instanceof ExtendToken stmtEndToken) {
      List<Token> commentTokens = lbBrace.getContextTokens().stream().filter(t -> parser.belongToComment(t.getType())).toList();
      if (!commentTokens.isEmpty()) {
        stmtEndToken.getContextTokens().addAll(commentTokens);
        lbBrace.getContextTokens().removeAll(commentTokens);
      }
    } else {
      fixContextTokensWhenRemove(preToken, lbBrace, parser);
    }

    // 把rbrace后面内容移到内部语句的最后一个token后面，注意检查合并后的换行符
    ExtendToken rbBrace = (ExtendToken) block.getStop();
    fixContextTokensWhenRemove((ExtendToken) innerStmt.getStop(), rbBrace, parser);

    parent.replaceChild(stmtCtx, innerStmt);
    stmtCtx.updateStartToken();
    stmtCtx.updateStopToken();
    return innerStmt;
  }

  /**
   * Merge declarations of the same type and style context.
   */
  public ExtendContext mergeDeclarations(List<ExtendContext> decGroup, MyParser parser) {
    if (decGroup.size() < 2) {
      return null;
    }

    int index = 0;
    // 合并声明
    List<ExtendContext> newDecGroup = new ArrayList<>();
    ExtendContext firstStmt = decGroup.get(index);
    newDecGroup.add(firstStmt);
    VarDeclarationSearcher searcher = NodeSearcherFactory.getInstance().createVarDeclarationSearcher();
    ExtendContext targetStmt = firstStmt;
    boolean oneVarDec = (searcher.searchVarDeclaratorsNode(firstStmt, parser).getChildCount() + 1) / 2 == 1;  // 去除comma的计算

    // 和下一条语句合并
    if (oneVarDec) {
      index = 1;
      doMerge(targetStmt, decGroup.get(index), parser);
      ++index;// 跳过下一条语句
    }

    for (int i = index; i < decGroup.size(); i++) {
      ExtendContext decStmt = decGroup.get(i);
      ExtendContext declaratorsNode = searcher.searchVarDeclaratorsNode(decStmt, parser);

      // 将单独的变量声明和前一条合并
      if ((declaratorsNode.getChildCount() + 1) / 2 == 1) {
        doMerge(targetStmt, decGroup.get(i), parser);
      } else {
        targetStmt = decStmt;
        newDecGroup.add(decStmt);
      }
    }

    if (newDecGroup.size() != decGroup.size()) {
      ExtendContext parent = (ExtendContext) decGroup.get(0).getParent();
      int origIndex = parent.children.indexOf(decGroup.get(0));
      parent.removeAll(origIndex, origIndex + decGroup.size());
      for (ExtendContext decStmt : newDecGroup) {
        parent.insertChild(origIndex++, decStmt);
      }
    }

    return firstStmt;
  }

  private void doMerge(ExtendContext targetStmt, ExtendContext mergedStmt, MyParser parser) {
    targetStmt = parser.getSpecificStmt(targetStmt);
    mergedStmt = parser.getSpecificStmt(mergedStmt);
    VarDeclarationSearcher searcher = NodeSearcherFactory.getInstance().createVarDeclarationSearcher();
    ExtendContext declaratorsNode = searcher.searchVarDeclaratorsNode(targetStmt, parser);
    TerminalNode comma = parser.getTreeNodeFactory().createTerminal(parser.getTokenFactory().create(parser.getComma(), ","));
    ExtendContext mergedDeclaratorsNode = searcher.searchVarDeclaratorsNode(mergedStmt, parser);
    declaratorsNode.addChild(comma);
    declaratorsNode.addChildren(mergedDeclaratorsNode.children);

    // 移动语句末尾的语法无关token
    ExtendToken mergedStop = NodeUtil.getStopToken(mergedStmt);
    List<Token> commentContext = mergedStop.getContextTokens().stream().filter(t -> parser.belongToComment(t.getType())).toList();
    NodeUtil.getStopToken(targetStmt).addAllContextTokens(commentContext, parser);
    mergedStop.setContextTokens(null);
  }

  /**
   * Split declarations of the same type and style context.
   */
  public ExtendContext splitDeclarations(List<ExtendContext> decGroup, MyParser parser) {
    if (decGroup.isEmpty()) {
      return null;
    }

    // 拆分变量声明
    List<ExtendContext> newDecList = new ArrayList<>();
    VarDeclarationSearcher searcher = NodeSearcherFactory.getInstance().createVarDeclarationSearcher();
    for (ExtendContext decStmt : decGroup) {
      List<ExtendContext> varDeclaratorList = searcher.searchVarDeclaratorList(decStmt, parser);
      if (varDeclaratorList.size() > 1) {
        // 移除当前声明语句第一个变量后面的声明
        ExtendContext declaratorsNode = searcher.searchVarDeclaratorsNode(decStmt, parser);
        declaratorsNode.removeAll(1, declaratorsNode.getChildCount());
        newDecList.add(decStmt);

        for (int i = 1; i < varDeclaratorList.size(); i++) {
          ExtendContext varDeclarator = varDeclaratorList.get(i);
          ParseTree newDecStmt = copyTree(decStmt, false);

          // 删除复制来的语句末尾的语法无关token
          ExtendToken stop = NodeUtil.getStopToken(newDecStmt);
          stop.setContextTokens(null);

          if (newDecStmt instanceof ExtendContext copyStmt) {
            declaratorsNode = searcher.searchVarDeclaratorsNode(copyStmt, parser);
            declaratorsNode.replaceChildren(0, declaratorsNode.getChildCount(), List.of(varDeclarator));
            newDecList.add(copyStmt);
          }
        }

        // 将第一条语句的末尾的语法无关token移到最后一条语句末尾
        ExtendToken stop = NodeUtil.getStopToken(decStmt);
        ExtendToken lastStmtStop = NodeUtil.getStopToken(newDecList.get(newDecList.size() - 1));
        int insertionIndex = stop.indexInContextTokens();
        stop.getContextTokens().remove(stop);
        stop.addToken(insertionIndex, lastStmtStop);
        lastStmtStop.setContextTokens(stop.getContextTokens());
        stop.setContextTokens(null);
      } else {
        newDecList.add(decStmt);
      }
    }

   if (newDecList.size() != decGroup.size()) {
     ExtendContext parent = (ExtendContext) decGroup.get(0).getParent();
     int index = parent.children.indexOf(decGroup.get(0));
     parent.removeAll(index, index + decGroup.size());
     for (ExtendContext decStmt : newDecList) {
       parent.insertChild(index++, decStmt);
     }
   }

   return newDecList.get(0);

  }

  public static void generateTokens(ParseTree root, List<Token> tokens, MyParser parser) {
    generateTokensRec(root, tokens, parser);
    updateTokenLocation(tokens);
  }

  public static void generateTokensRec(ParseTree root, List<Token> tokens, MyParser parser) {
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
      NodeEditorFactory.createASTEditor(parser.getLanguage()).updateHierarchy(parser, ctx);
      for (ParseTree child : ctx.children) {
        generateTokens(child, tokens, parser);
      }
    }
  }

  public ExtendToken getPreToken(ExtendContext ctx, Token targetToken) {
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


  private void fixContextTokensWhenRemove(ExtendToken leftToken, ExtendToken removedToken, MyParser parser) {
    if (leftToken != null) {
//      int targetInex = removedToken.indexInContextTokens() + 1;
      int targetInex = removedToken.indexOfFirstTokenAfterIf(parser::belongToComment);
      if (targetInex >= 0) {
        List<Token> movenTokens = removedToken.getContextTokens().subList(targetInex, removedToken.getContextTokens().size());
        leftToken.addAllContextTokens(movenTokens, parser);
        removedToken.getContextTokens().removeAll(movenTokens);
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
