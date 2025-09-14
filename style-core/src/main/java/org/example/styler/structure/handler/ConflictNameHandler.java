package org.example.styler.structure.handler;

import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.example.parser.common.MyParser;
import org.example.parser.common.context.ExtendContext;
import org.example.parser.common.token.ExtendToken;
import org.example.semantic.Scope;
import org.example.semantic.SymbolTable;
import org.example.semantic.SymbolTableManager;
import org.example.semantic.intf.symbol.Symbol;
import org.example.styler.structure.EquivalentStructure;
import org.example.utils.searcher.NodeSearcherFactory;

import java.util.*;

public class ConflictNameHandler extends Handler{
	public ConflictNameHandler(String[][] argsList) {
		super(argsList);
	}

	/**
	 * Handle conflicts of variable name when moving variable declarations outward.
	 * @param structure
	 * @param args [variable declaration, depth of outward movement]
	 * @param parser
	 */
	@Override
	protected void doHandle(EquivalentStructure structure, List<String> args, MyParser parser) {
		List<ParseTree> nodes = structure.getVNode(args.get(0)).matchedTrees;
		int movement = Integer.parseInt(args.get(1));
		if (nodes.isEmpty()) {
			return;
		}

		if (nodes.get(0) instanceof ExtendContext ctx) {
			ExtendContext declarationNode = ctx;
			if (!parser.isLocalVarDeclaration(declarationNode)) {
				declarationNode = ctx.getAllCtxsRecIf(parser::isLocalVarDeclaration).stream().findAny().orElseGet(() -> null);
			}
			if (declarationNode != null) {
				List<ExtendContext> identifiers = NodeSearcherFactory.getInstance().createVarDeclarationSearcher().searchIdentifiers(declarationNode, parser);
				SymbolTable st = SymbolTableManager.getSymbolTable(parser);
				ParseTree newScopeNode = Scope.getScopeNode(Scope.getScopeNode(identifiers.get(0), parser).getParent(), parser);
				Map<String, Set<Symbol>> conflictCandidatesMap = getPotentialConflicts(st, identifiers, parser);


				for (ExtendContext identifier : identifiers) {
					Symbol symbol = st.getSymbol(identifier, parser);
					st.updateScope(symbol, newScopeNode, parser);
					String oldName = symbol.getText();
					String newName = oldName;
					Set<Symbol> conflicts = conflictCandidatesMap.get(oldName);

					// 不存在命名冲突
					if (conflicts == null || conflicts.size() == 1 && conflicts.contains(symbol)) {
						continue;
					}

					Iterator<Symbol> iter = conflicts.iterator();
					Symbol firstSym = iter.next(); // 从第二个开始
					while (iter.hasNext()) {
						Symbol conflictSym = iter.next();
						for (int i = 1; conflictCandidatesMap.containsKey(newName); i++) {
							newName = String.format("%s%d", oldName, i);
						}

						// Modify identifier name and its references
						Token token = conflictSym.getDecIdentifierNode().getAllTokensByType(parser.getIdentifier()).stream().findFirst().orElseGet(() -> null);
						if (token instanceof ExtendToken t) {
							t.setText(newName);
						}
						for (ExtendContext ref : conflictSym.getReferences()) {
							token = ref.getAllTokensByType(parser.getIdentifier()).stream().findFirst().orElseGet(() -> null);
							if (token instanceof ExtendToken t) {
								t.setText(newName);
							}
						}

						final String key = newName;
						conflictCandidatesMap.compute(newName, (k, v) -> v == null ?
								new TreeSet<>(Comparator.comparingInt(e -> e.getDecIdentifierNode().getStart().getLine()))
								: conflictCandidatesMap.get(key)).add(conflictSym);
					}

					conflicts.clear();
					conflicts.add(firstSym);
				}
			}
		}
	}

	private void removeConflicts(Map<String, Set<Symbol>> candidateConflictsMap, Set<Symbol> conflicts) {

	}


	/**
	 * 返回的Symbol按照行号从小到大排列
	 * @param st
	 * @param identifiers
	 * @param parser
	 * @return
	 */
	private Map<String, Set<Symbol>> getPotentialConflicts(SymbolTable st, List<ExtendContext> identifiers, MyParser parser) {
		ParseTree curScope = Scope.getScopeNode(identifiers.get(0), parser);

		ParseTree newScope = Scope.getScopeNode(curScope.getParent(), parser);


		Map<String, Set<Symbol>> candidates = new HashMap<>();
		getSymbolsInRec(st, newScope, parser, candidates);
		getSymbolsOut(st, newScope.getParent(), parser, candidates);

		return candidates;
	}

	/**
	 * 获取位于当前scope内部的所有声明标识符（包括当前scope）
	 */
	private void getSymbolsInRec(SymbolTable st, ParseTree node, MyParser parser, Map<String, Set<Symbol>> candiates) {
		Set<ExtendContext> existedDecNodes = new HashSet<>();
		if (Scope.isScopeNode(node, parser)) {
			if (st.getAllSymbolsIn(node) != null) {
				st.getAllSymbolsIn(node).forEach(e -> {
					candiates.compute(e.getText(), (k, v) -> v == null ?
									new TreeSet<>(Comparator.comparingInt(e1 -> e1.getDecIdentifierNode().getStart().getLine()))
									: candiates.get(e.getText()))
							.add(e);
				});
			}
		}

		if (node instanceof ExtendContext ctx) {
			for (ParseTree child : ctx.children) {
				getSymbolsInRec(st, child, parser, candiates);
			}
		}
	}

	/**
	 * 获取位于当前scope外部的所有声明标识符（包括当前scope）
	 */
	private Set<ExtendContext> getSymbolsOut(SymbolTable st, ParseTree node, MyParser parser,  Map<String, Set<Symbol>> candiates) {
		Set<ExtendContext> existedDecNodes = new HashSet<>();
		ParseTree cur = node;
		while (cur != null) {
			if (Scope.isScopeNode(cur, parser)) {
				if (st.getAllSymbolsIn(cur) != null) {
					st.getAllSymbolsIn(cur).forEach(e -> {
						candiates.compute(e.getText(), (k, v) -> v == null ?
										new TreeSet<>(Comparator.comparingInt(e1 -> e1.getDecIdentifierNode().getStart().getLine()))
										: candiates.get(e.getText()))
								.add(e);
					});
				}
			}
			cur = cur.getParent();
		}

		return existedDecNodes;
	}

}
