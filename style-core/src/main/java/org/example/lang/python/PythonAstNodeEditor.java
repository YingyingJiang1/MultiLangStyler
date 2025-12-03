package org.example.lang.python;

import org.example.antlr.common.context.ExtendContext;
import org.example.lang.base.ASTNodeEditorBase;
import org.example.lang.intf.ASTNodeEditor;

public class PythonAstNodeEditor implements ASTNodeEditor {
	private static PythonAstNodeEditor instance = new PythonAstNodeEditor();

	private PythonAstNodeEditor() {}

	public static ASTNodeEditor getInstance() {
		return instance;
	}

	@Override
	public void updateHierarchy(ExtendContext node) {
		System.out.println("TODO: implement PythonAstNodeEditor.updateHierarchy!");
	}
}
