package org.example.styler.structure.handler;

import org.antlr.v4.runtime.tree.ParseTree;
import org.example.myException.TreeConvertException;
import org.example.lang.intf.MyParser;
import org.example.styler.structure.EquivalentStructure;

import java.util.List;

public class CheckThenAssignHandler extends Handler implements ExceptionHandler {
	public CheckThenAssignHandler(String[][] argsList) {
		super(argsList);
	}

	/**
	 * from==0或者to==0时，需要检查第一个赋值语句产生的副作用是否会对后面语句产生影响.
	 * $E = $E3 ; if ( $E1 ) { $E4 = $E2 ; }
	 */
	@Override
	public void handleException(EquivalentStructure structure, int from, int to, MyParser parser) throws TreeConvertException {
		if (from == 0 || to == 0) {
			List<ParseTree> nodes1 = structure.getVNode("$E1").matchedTrees;
			List<ParseTree> nodes2 = structure.getVNode("$E2").matchedTrees;
			List<ParseTree> updatedNode = structure.getVNode("$E").matchedTrees;
			if (updatedNode.size() != 1){
				return;
			}

			String targetText = updatedNode.get(0).getText();
			if (HandlerUtil.containExpContent(nodes1, targetText, parser) || HandlerUtil.containExpContent(nodes2, targetText, parser)) {
				throw new TreeConvertException("Unsupported convert because of side effect of writing: $E = $E3 ; if ( $E1 ) { $E4 = $E2 ; }");
			}
		}
	}
}
