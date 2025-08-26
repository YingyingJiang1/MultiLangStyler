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
import org.example.utils.NameGenerator;
import org.example.utils.searcher.NodeSearcherFactory;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
				List<ExtendContext> identifiers = NodeSearcherFactory.getInstance().createDeclarationSearcher().searchIdentifiers(declarationNode, parser);
				SymbolTable st = SymbolTableManager.getSymbolTable(parser);
				ParseTree newScopeNode = Scope.getScopeNode(Scope.getScopeNode(identifiers.get(0), parser).getParent(), parser);
				Set<ExtendContext> existedDecNodes = getExistedDecNodes(st, newScopeNode, parser);

				Set<String> existedNames = new HashSet<>();
				existedDecNodes.stream().filter(e -> !identifiers.contains(e)).forEach(e -> existedNames.add(e.getText()));

				for (ExtendContext identifier : identifiers) {
					Symbol symbol = st.getSymbol(identifier, parser);
					st.updateScope(symbol, newScopeNode, parser);
					String oldName = symbol.getText();
					String newName = oldName;
					if (existedNames.contains(symbol.getText())) {
						// Try to get alternative names first, if failed then add suffix to `oldName` util conflicts removed.
						newName = NameGenerator.getAlternativeName(oldName, existedNames.stream().toList());
						if (newName == null) {
							newName = oldName;
							for (int i = 1; existedNames.contains(newName); i++) {
								newName = String.format("%s%d", oldName, i);
							}
						}


						// Modify identifier name and its references
						Token token = symbol.getDecIdentifierNode().getAllTokensByType(parser.getIdentifier()).stream().findFirst().orElseGet(() -> null);
						if (token instanceof ExtendToken t) {
							t.setText(newName);
						}
						for (ExtendContext ref : symbol.getReferences()) {
							token = ref.getAllTokensByType(parser.getIdentifier()).stream().findFirst().orElseGet(() -> null);
							if (token instanceof ExtendToken t) {
								t.setText(newName);
							}
						}

					}

					// Update existed names
					existedNames.add(newName);
				}
			}
		}
	}

	/**
	 * 获取所有可能和当前变量声明存在冲突的声明标识符：
	 */
	private Set<ExtendContext> getExistedDecNodes(SymbolTable st, ParseTree node, MyParser parser) {
		Set<ExtendContext> existedDecNodes = new HashSet<>();
		if (Scope.isScopeNode(node, parser)) {
			if (st.getAllSymbolsIn(node) != null) {
				st.getAllSymbolsIn(node).forEach(e -> existedDecNodes.add((e.getDecIdentifierNode())));
			}
		}

		if (node instanceof ExtendContext ctx) {
			for (ParseTree child : ctx.children) {
				getExistedDecNodes(st, child, parser);
			}
		}

		return existedDecNodes;
	}


}
