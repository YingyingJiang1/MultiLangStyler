package org.example.styler.structure.handler;

import org.antlr.v4.runtime.tree.ParseTree;
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

public class VarUndefExceptionHandler extends Handler implements ExcepH{
	public VarUndefExceptionHandler(String[][] argsList) {
		super(argsList);
	}

	/**
	 * TODO: handle conflicts of variable name in specified domain.
	 * @param structure
	 * @param args [variable declaration, new scope]
	 * @param parser
	 */
	@Override
	protected void doHandle(EquivalentStructure structure, List<String> args, MyParser parser) {
		List<ParseTree> nodes = structure.getVNode(args.get(0)).matchedTrees;
		List<ParseTree> scopeNodes = structure.getVNode(args.get(1)).matchedTrees;
		if (nodes.isEmpty() || scopeNodes.isEmpty()) {
			return;
		}

		if (nodes.get(0) instanceof ExtendContext ctx) {
			ExtendContext declarationNode = ctx.getAllCtxsRecIf(parser::isLocalVarDeclaration).stream().findAny().orElseGet(null);
			if (declarationNode != null) {
				List<ExtendContext> identifiers = NodeSearcherFactory.getInstance().createDeclarationSearcher().searchIdentifiers(declarationNode, parser);

				SymbolTableManager.getAllSymbols(parser);
				SymbolTable st = SymbolTableManager.getSymbolTable(parser.getRoot());
				for (ExtendContext identifier : identifiers) {
					Symbol symbol = st.getSymbol(identifier, parser);
					Set<ParseTree> scopeNodeOfUsages = new HashSet<>();
					for (ParseTree ref : symbol.getReferences()) {
						scopeNodeOfUsages.add(Scope.getScopeNode(ref, parser));
					}

					// Check whether `new scope` < any original scope
					ParseTree newScopeNode = Scope.getScopeNode(scopeNodes.get(0), parser);
					for (ParseTree originalScope : scopeNodeOfUsages) {
						if (Scope.compareTo(newScopeNode, originalScope, parser) < 0) {
							throw new UndefException("May result in undefined exceptions!");
						}
					}
				}
			}
		}
	}
}
