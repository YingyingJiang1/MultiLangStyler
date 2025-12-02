package org.example.utils.editor;

import org.example.lang.intf.MyParser;
import org.example.antlr.common.context.ExtendContext;

public interface NodeEditor {
	/**
	 * Update the hierarchy of children of the node.
	 * @param parser
	 * @param node
	 */
	void updateHierarchy(MyParser parser, ExtendContext node);
}
