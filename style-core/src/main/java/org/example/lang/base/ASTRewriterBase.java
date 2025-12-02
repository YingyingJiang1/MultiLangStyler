package org.example.lang.base;

import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.antlr.v4.runtime.tree.TerminalNodeImpl;
import org.example.lang.LangAdapterCreator;
import org.example.lang.intf.ASTRewriter;
import org.example.lang.intf.MyParser;
import org.example.lang.intf.TreeNodeFactory;
import org.example.antlr.common.context.ExtendContext;
import org.example.antlr.common.token.ExtendToken;
import org.example.utils.NodeUtil;
import org.example.utils.ParseTreeUtil;
import org.example.lang.intf.searcher.VarDeclarationSearcher;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ASTRewriterBase implements ASTRewriter {
	// key: compare operator, value: reversing compare operator
	static Map<String, String> compareOpMap ;
	static Map<String, String> logicalOpMap;
	static ASTRewriter instance = null;

	public static ASTRewriter getInstance() {
		if (instance == null) {
			instance = new ASTRewriterBase();
		}
		return instance;
	}

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

	@Override
	public ExtendContext negateExpression(ExtendContext expCtx, MyParser parser) {
		ExtendContext parent = (ExtendContext) expCtx.getParent();
		if(expCtx.start.getText().equals("!")) {
			ExtendContext notExpression = (ExtendContext) expCtx.getChild(1);;
			notExpression.setParent(expCtx.getParent());
			return notExpression;
		} else {
			ExtendContext notExpression = LangAdapterCreator.createTreeNodeFactory(parser.getLanguage()).createExpression(parent);
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

	@Override
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
			exp = encapsulateExpWithParen(expCtx, parser);
		}
		// expression -> !expression or !expression -> expression
		ExtendContext notExp = negateExpression(exp, parser);
		return notExp;
	}

	@Override
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

		TreeNodeFactory nodeFactory = LangAdapterCreator.createTreeNodeFactory(parser.getLanguage());

		ExtendContext parent = (ExtendContext) expCtx.getParent();
		ExtendContext parenExpression = nodeFactory.createExpression(parent);
		List<ParseTree> children = new ArrayList<>();
		children.add(new TerminalNodeImpl(lParen));
		children.add(expCtx);
		children.add(new TerminalNodeImpl(rParen));
		parenExpression.children.clear();
		parenExpression.addChildren(children);
		return parenExpression;
	}

	@Override
	public ExtendContext encapsulateStmtWithBrace(ExtendContext stmtCtx, MyParser parser) {
		ExtendContext parent = (ExtendContext) stmtCtx.getParent();
		Token stop = stmtCtx.getStop();
		
		ExtendContext newStmt = LangAdapterCreator.createTreeNodeFactory(parser.getLanguage()).createStatement(parent);
		ExtendContext blockNode = LangAdapterCreator.createTreeNodeFactory(parser.getLanguage()).createBlock(newStmt);
		ExtendToken lBrace = parser.getTokenFactory().create(parser.getLBrace(), "{");
		ExtendToken rBrace = parser.getTokenFactory().create(parser.getRBrace(), "}");
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
			int index = leftToken.indexOfFirstTokenAfterIf(t -> parser.getVws() == t || parser.isComment(t));
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

	@Override
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
			TreeNodeFactory factory = LangAdapterCreator.createTreeNodeFactory(parser.getLanguage());
			innerStmt = factory.createStatement(parent);
			ExtendToken semiToken = parser.getTokenFactory().create(parser.getSemi(), ";");
//      semiToken.addTokenAfter(parser.getTokenFactory().create(parser.getVws(), "\n"), parser);
			innerStmt.addChild(factory.createTerminal(semiToken));
			innerStmt.updateStopToken();
			innerStmt.updateStartToken();
		}

		// 把lbrace后面的内容移到）后面，如果内部是空语句，那么仅把lbrace后面的注释内容移到空语句后面
		ExtendToken lbBrace = (ExtendToken) block.getStart();
		ExtendToken preToken = ParseTreeUtil.getPreToken(stmtCtx, lbBrace);
		if (isEmptyStmt && innerStmt.getStop() instanceof ExtendToken stmtEndToken) {
			List<Token> commentTokens = lbBrace.getContextTokens().stream().filter(t -> parser.isComment(t.getType())).toList();
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

	@Override
	public ExtendContext mergeVarDeclarations(List<ExtendContext> decGroup, MyParser parser) {
		if (decGroup.size() < 2) {
			return null;
		}

		int index = 0;
		// 合并声明
		List<ExtendContext> newDecGroup = new ArrayList<>();
		ExtendContext firstStmt = decGroup.get(index);
		newDecGroup.add(firstStmt);
		VarDeclarationSearcher searcher = LangAdapterCreator.createNodeSearcherFactory(parser.getLanguage()).createVarDeclarationSearcher();
		ExtendContext targetStmt = firstStmt;
		boolean oneVarDec = (searcher.searchVarDeclaratorsNode(firstStmt, parser).getChildCount() + 1) / 2 == 1;  // 去除comma的计算

		// 和下一条语句合并
		if (oneVarDec) {
			index = 1;
			doMerge(targetStmt, decGroup.get(index), parser);
		}

		for (int i = index + 1; i < decGroup.size(); i++) {
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
		VarDeclarationSearcher searcher = LangAdapterCreator.createNodeSearcherFactory(parser.getLanguage()).createVarDeclarationSearcher();
		ExtendContext declaratorsNode = searcher.searchVarDeclaratorsNode(targetStmt, parser);
		TerminalNode comma = LangAdapterCreator.createTreeNodeFactory(parser.getLanguage()).createTerminal(parser.getTokenFactory().create(parser.getComma(), ","));
		ExtendContext mergedDeclaratorsNode = searcher.searchVarDeclaratorsNode(mergedStmt, parser);
		declaratorsNode.addChild(comma);
		declaratorsNode.addChildren(mergedDeclaratorsNode.children);

		// 移动语句末尾的语法无关token
		ExtendToken mergedStop = NodeUtil.getStopToken(mergedStmt);
		List<Token> commentContext = mergedStop.getContextTokens().stream().filter(t -> parser.isComment(t.getType())).toList();
		NodeUtil.getStopToken(targetStmt).addAllContextTokens(commentContext, parser);
		mergedStop.setContextTokens(null);
	}

	@Override
	public ExtendContext splitVarDeclarations(List<ExtendContext> decGroup, MyParser parser) {
		if (decGroup.isEmpty()) {
			return null;
		}

		// 拆分变量声明
		List<ExtendContext> newDecList = new ArrayList<>();
		VarDeclarationSearcher searcher = LangAdapterCreator.createNodeSearcherFactory(parser.getLanguage()).createVarDeclarationSearcher();
		for (ExtendContext decStmt : decGroup) {
			List<ExtendContext> varDeclaratorList = searcher.searchVarDeclaratorList(decStmt, parser);
			if (varDeclaratorList.size() > 1) {
				// 移除当前声明语句第一个变量后面的声明
				ExtendContext declaratorsNode = searcher.searchVarDeclaratorsNode(decStmt, parser);
				declaratorsNode.removeAll(1, declaratorsNode.getChildCount());
				newDecList.add(decStmt);

				for (int i = 1; i < varDeclaratorList.size(); i++) {
					ExtendContext varDeclarator = varDeclaratorList.get(i);
					ParseTree newDecStmt = ParseTreeUtil.copyTree(decStmt, false);

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

	private void fixContextTokensWhenRemove(ExtendToken leftToken, ExtendToken removedToken, MyParser parser) {
		if (leftToken != null) {
//      int targetInex = removedToken.indexInContextTokens() + 1;
			int targetInex = removedToken.indexOfFirstTokenAfterIf(parser::isComment);
			if (targetInex >= 0) {
				List<Token> movenTokens = removedToken.getContextTokens().subList(targetInex, removedToken.getContextTokens().size());
				leftToken.addAllContextTokens(movenTokens, parser);
				removedToken.getContextTokens().removeAll(movenTokens);
			}
		}

	}
}
