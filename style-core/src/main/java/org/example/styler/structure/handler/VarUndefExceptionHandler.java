package org.example.styler.structure.handler;

import org.antlr.v4.runtime.tree.ParseTree;
import org.example.myException.TreeConvertException;
import org.example.myException.UndefException;
import org.example.parser.common.MyParser;
import org.example.parser.common.context.ExtendContext;
import org.example.semantic.Scope;
import org.example.semantic.SymbolTable;
import org.example.semantic.SymbolTableManager;
import org.example.semantic.intf.symbol.Symbol;
import org.example.styler.structure.EquivalentStructure;
import org.example.utils.searcher.NodeSearcherFactory;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class VarUndefExceptionHandler extends Handler implements ExceptionHandler{
	public VarUndefExceptionHandler(String[][] argsList) {
		super(argsList);
	}


	/**
	 *
	 * Move variable declarations to new scope, if undefined then throw exception. Otherwise, do nothing.
	 * argsList:[[from index, to index, variable declaration, new scope]]
	 */
	@Override
	public void handleException(EquivalentStructure structure, int from, int to, MyParser parser) throws TreeConvertException {
		for (String[] args : argsList) {
			if (args.length < 4) {
				logger.error("Arguments error! Arguments format: {}", "[[from index, to index, variable declaration]]");
			}

			int configFrom = Integer.parseInt(args[0]), configTo = Integer.parseInt(args[1]);
			if (from != configFrom || to != configTo) {
				continue;
			}

			List<ParseTree> nodes = structure.getVNode(args[2]).matchedTrees;
			List<ParseTree> scopeNodes = structure.getVNode(args[3]).matchedTrees;
			if (nodes.isEmpty() || scopeNodes.isEmpty()) {
				continue;
			}

			if (nodes.get(0) instanceof ExtendContext ctx) {
				ExtendContext declarationNode = ctx;
				if (!parser.isLocalVarDeclaration(declarationNode)) {
					declarationNode = ctx.getAllCtxsRecIf(parser::isLocalVarDeclaration).stream().findAny().orElseGet(() -> null);
				}
				if (declarationNode != null) {
					List<ExtendContext> identifiers = NodeSearcherFactory.getInstance().createVarDeclarationSearcher().searchIdentifiers(declarationNode, parser);

					// Get all scope nodes that use the variables in the declaration
					SymbolTable st = SymbolTableManager.getSymbolTable(parser);
					Set<ParseTree> scopeNodeOfUsages = new HashSet<>();
					for (ExtendContext identifier : identifiers) {
						Symbol symbol = st.getSymbol(identifier, parser);
						// 符号表缓存失效
						if (symbol == null) {
							st = SymbolTableManager.updateSymbolTable(parser);
							symbol = st.getSymbol(identifier, parser);
						}
						for (ParseTree ref : symbol.getReferences()) {
							scopeNodeOfUsages.add(Scope.getScopeNode(ref, parser));
						}
					}


					// Check whether `new scope` < any original scope
					ParseTree newScopeNode = Scope.getScopeNode(scopeNodes.get(0), parser);
					for (ParseTree originalScope : scopeNodeOfUsages) {
						try {
							if (Scope.compareTo(newScopeNode, originalScope, parser) < 0) {
								throw new UndefException("May result in undefined exceptions!");
							}
						} catch (Exception e) {
							// Scopes are in the same level.
							throw new UndefException("May result in undefined exceptions!");
						}

					}

				}
			}

		}
	}
}
