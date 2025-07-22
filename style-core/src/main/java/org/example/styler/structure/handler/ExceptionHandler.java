package org.example.styler.structure.handler;

import org.example.myException.TreeConvertException;
import org.example.parser.common.MyParser;
import org.example.styler.structure.EquivalentStructure;

import java.util.List;

public interface ExceptionHandler {
	// Only do some exception check, prohibit to modify the tree.
	// Handlers that implement this interface should come first.
	void handleException(EquivalentStructure structure, int from, int to, MyParser parser)  throws TreeConvertException;
}
