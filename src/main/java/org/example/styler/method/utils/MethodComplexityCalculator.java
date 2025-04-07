package org.example.styler.method.utils;

import org.antlr.v4.runtime.tree.ParseTree;
import org.example.global.GlobalInfo;
import org.example.parser.common.MyParser;
import org.example.parser.common.context.ExtendContext;
import org.example.styler.method.complexity.style.MethodComplexity;
import org.example.utils.searcher.intf.MethodSearcher;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class MethodComplexityCalculator {

	private static MethodComplexityCalculator instance = new MethodComplexityCalculator();

	private MethodComplexityCalculator() {}

	public static MethodComplexityCalculator getInstance() {
		return instance;
	}


	public MethodComplexity calculateComplexity(ExtendContext methodDeclaration, MyParser parser) {
		MethodComplexity complexity = new MethodComplexity();
		MethodSearcher searcher = GlobalInfo.getConf().getLanguageConfig().getNodeSearcherFactory().createMethodDecSearcher();
		ExtendContext methodBody = searcher.searchMethodBody(methodDeclaration, parser);
		complexity.lineNumber = methodDeclaration.getStart().getLine();
		complexity.methodName = searcher.searchMethodName(searcher.searchMethodHead(methodDeclaration, parser), parser).getText();

		complexity.lines = methodBody.getStop().getLine() - methodBody.getStart().getLine() + 1;

		Predicate<ExtendContext> isBranch = node -> {
			int ruleIndex = node.getRuleIndex();
			return ruleIndex == parser.getRuleIfStmt() || ruleIndex == parser.getRuleIfElseStmt() || ruleIndex == parser.getRuleSwitchStmt();
		};
		complexity.branchCount = methodDeclaration.getAllCtxsRecIf(isBranch::test).size();



		Predicate<ExtendContext> isLoop = node -> {
			int ruleIndex = node.getRuleIndex();
			return parser.belongToLoop(ruleIndex);
		};
		complexity.nestingDepth = calMaxStmtNestingDepth(methodBody, parser, null);
		complexity.nestingLoop = calMaxStmtNestingDepth(methodDeclaration, parser, isLoop);
		complexity.paraCount = searcher.searchParaTypes(searcher.searchMethodHead(methodDeclaration, parser), parser).size();
		
		complexity.cognitiveComplexity = CognitiveComplexityCalculator.getInstance().calCognitiveComplexity(methodDeclaration, parser);
		complexity.cyclomaticComplexity = CyclomaticComplexityCalculator.createCalculator().calculateMethod(methodDeclaration, parser);

		return complexity;
	}


	protected int calMaxStmtNestingDepth(ExtendContext methodBody, MyParser parser, Predicate<ExtendContext> cond) {
		int maxDepth = 0;
		for (ParseTree child : methodBody.children) {
			if (parser.belongToStmt(child)) {
				int depth = doCalculate((ExtendContext) child, parser, cond);
				if (depth > maxDepth) {
					maxDepth = depth;
				}
			}
		}
		return maxDepth;
	}



	// 遍历语法树
	private int doCalculate(ExtendContext node, MyParser parser, Predicate<ExtendContext> cond) {
		ExtendContext specificStmt = (ExtendContext) parser.getSpecificStmt(node);
		int specificStmtType = specificStmt.getRuleIndex();
		boolean isSingleStmt = parser.getSingleStmts().contains(specificStmtType);
		if (isSingleStmt) {
			return 0;
		}

		boolean isControlStructure = parser.getCompoundStmts().contains(specificStmtType);
		if (isControlStructure) {
			int maxDepthOfSubStmt = 0;
			List<ExtendContext> innerStmts = new ArrayList<>();
			for (ParseTree child : specificStmt.children) {
				if (child instanceof ExtendContext ctx && parser.belongToStmt(child)) {
					ExtendContext specificStmt1 = parser.getSpecificStmt(ctx);
					if (specificStmt1.getRuleIndex() == parser.getRuleBlock()) {
						innerStmts.addAll(specificStmt1.getAllChildContextsIf(parser::belongToStmt));
					} else {
						innerStmts.add(ctx);
					}
				}
			}

			for (int i = 0; i < innerStmts.size(); i++) {
				if (parser.belongToStmt(innerStmts.get(i))) {
					int curInc = cond == null || cond.test(parser.getSpecificStmt(innerStmts.get(i))) ? 1 : 0;
					int depth = curInc + doCalculate(innerStmts.get(i), parser, cond);
					if (depth > maxDepthOfSubStmt) {
						maxDepthOfSubStmt = depth;
					}
				}
			}

			return maxDepthOfSubStmt;
		}
		return 0;
	}
}
