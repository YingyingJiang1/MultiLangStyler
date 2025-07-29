package org.example.styler.structure.handler;

import org.antlr.v4.runtime.tree.ParseTree;
import org.example.myException.TreeConvertException;
import org.example.parser.common.MyParser;
import org.example.parser.common.context.ExtendContext;
import org.example.styler.structure.EquivalentStructure;

import java.util.Arrays;
import java.util.List;

public class DecThenAssignExceptionHandler extends Handler implements ExceptionHandler {
	public DecThenAssignExceptionHandler(String[][] argsList) {
		super(argsList);
	}


	/**
	 * argsList:[[from_index, to_index, $I, $E1, $E2...]]
	 * @param structure
	 * @param from
	 * @param to
	 * @param parser
	 * @throws TreeConvertException
	 */
	@Override
	public void handleException(EquivalentStructure structure, int from, int to, MyParser parser) throws TreeConvertException {
		for(String[] args : argsList) {
			if (args.length < 2) {
				logger.error("Arguments error: at least 2 arguments required but got {}", args.length);
				continue;
			}
			int index1 = Integer.parseInt(args[0]), index2 = Integer.parseInt(args[1]);
			if(index1 == from && index2 == to) {
				String decIdentifierHolderName = args[2];
				List<ParseTree> matchedDecIdentifiers = structure.getVNode(decIdentifierHolderName).matchedTrees;
				if (matchedDecIdentifiers.isEmpty()) {
					return;
				}

				ExtendContext decIdentifier = (ExtendContext) matchedDecIdentifiers.get(0);
				for (int i = 3; i < args.length; i++) {
					List<ParseTree> conditionExp = structure.getVNode(args[i]).matchedTrees;
					for (ParseTree node : conditionExp) {
						if (node instanceof ExtendContext ctx) {
							ctx.getAllCtxsRecIf(e -> e.getRuleIndex() == decIdentifier.getRuleIndex()).forEach(e -> {
								if (e.getText().equals(decIdentifier.getText())) {
									throw new TreeConvertException("This convert will cause \"use before declaration\" exception.");
								}
							});
						}
					}
				}
			}
		}
	}
}
