package org.example.utils.editor;

public class NodeEditorFactory {
	public static NodeEditor createASTEditor(String language) {
		return switch (language) {
			case "java" -> new JavaNodeEditor();
			case "cpp" -> new CppNodeEditor();
			default -> throw new IllegalArgumentException("Unsupported language: " + language);
		};
	}
}
