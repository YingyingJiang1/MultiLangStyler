package org.example.utils.editor;

public class NodeEditorFactory {
	public static NodeEditor createASTEditor(String language) {
		switch (language) {
			case "java":
				return new JavaNodeEditor();
			default:
				throw new IllegalArgumentException("Unsupported language: " + language);
		}
	}
}
