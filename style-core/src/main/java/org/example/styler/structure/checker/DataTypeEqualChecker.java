package org.example.styler.structure.checker;

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.example.parser.common.MyParser;
import org.example.parser.common.context.ExtendContext;
import org.example.styler.structure.EquivalentStructure;


import java.util.List;

public class DataTypeEqualChecker extends Checker{
	public DataTypeEqualChecker(String[][] argsList) {
		super(argsList);
	}

	/**
	 *
	 * @param structure
	 * @param args [placeholder1, placeholder2, ...]
	 *             检查所有表达式的数据类型是否相同
	 * @param parser
	 * @return
	 */
	@Override
	protected boolean doCheck(EquivalentStructure structure, List<String> args, MyParser parser) {
		List<ParseTree> nodes = structure.getVNode(args.get(0)).matchedTrees;
		if (nodes.isEmpty() || !(nodes.get(0) instanceof ExtendContext)) {
			return false;
		}

		// TODO: 实现TypeResolver完成数据类型解析
//		String targetDataType = getExpDataType((ExtendContext) nodes.get(0), parser);
//		for (int i = 1; i < args.size(); i++) {
//			List<ParseTree> nodes1 = structure.getVNode(args.get(i)).matchedTrees;
//			if (nodes.isEmpty() || !(nodes.get(0) instanceof ExtendContext)) {
//				return false;
//			}
//
//			String dataType = getExpDataType((ExtendContext) nodes.get(0), parser);
//			if (!targetDataType.equals(dataType)) {
//				return false;
//			}
//		}

		return true;
	}

}
