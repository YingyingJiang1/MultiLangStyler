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
				Set<ExtendContext> existedDecNodes = getExistedDecNodes(st, identifiers.get(0), parser);
				Set<String> existedNames = new HashSet<>();
				existedDecNodes.stream().filter(e -> !identifiers.contains(e)).forEach(e -> existedNames.add(e.getText()));

				for (ExtendContext identifier : identifiers) {
					Symbol symbol = st.getSymbol(identifier, parser);
					String oldName = symbol.getText();
					if (existedNames.contains(symbol.getText())) {
						// Try to get alternative names first, if failed then add suffix to `oldName` util conflicts removed.
						String newName = null;
						do {
							newName = NameGenerator.getAlternativeName(oldName);
						} while (newName != null && existedNames.contains(newName));
						for (int i = 1; existedNames.contains(newName); i++) {
							newName = String.format("%s%d", oldName, i);
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
				}
			}
		}
	}

	private Set<ExtendContext> getExistedDecNodes(SymbolTable st, ParseTree node, MyParser parser) {
		ParseTree curScopeNode = Scope.getScopeNode(node, parser);
		Set<ExtendContext> existedNames = new HashSet<>();
		do {
			st.getAllSymbolsIn(curScopeNode).forEach(s -> existedNames.add(s.getDecIdentifierNode()));
			curScopeNode = Scope.getScopeNode(curScopeNode.getParent(), parser);
		} while (curScopeNode != null);
		return existedNames;
	}

}
