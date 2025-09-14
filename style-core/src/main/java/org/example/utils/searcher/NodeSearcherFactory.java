package org.example.utils.searcher;

import org.example.global.GlobalInfo;
import org.example.utils.searcher.impl.ArgumentsSearcherImpl;
import org.example.utils.searcher.intf.*;
import org.example.utils.searcher.javaimpl.*;

public class NodeSearcherFactory {
	private static NodeSearcherFactory instance = new NodeSearcherFactory();

	public static NodeSearcherFactory getInstance() {
		return instance;
	}

	public ArgumentsSearcher createArgumentsSearcher() {
		String language = GlobalInfo.getConf().getLanguageConfig().getLanguage();
		switch (language) {
			case "java":
				return new ArgumentsSearcherImpl();
			default:
				throw new IllegalArgumentException("Unsupported language: " + language);
		}
	}

	public CompilationUnitSearcher createCompilationUnitSearcher() {
		String language = GlobalInfo.getConf().getLanguageConfig().getLanguage();
		switch (language) {
			case "java":
				return new JavaCUSearcher();
			default:
				throw new IllegalArgumentException("Unsupported language: " + language);
		}
	}

	public VarDeclarationSearcher createVarDeclarationSearcher() {
		String language = GlobalInfo.getConf().getLanguageConfig().getLanguage();
		switch (GlobalInfo.getConf().getLanguageConfig().getLanguage()) {
			case "java":
				return new JavaVarDeclarationSearcher();
			default:
				throw new IllegalArgumentException("Unsupported language: " + GlobalInfo.getConf().getLanguageConfig().getLanguage());
		}
	}

	public MethodSearcher createMethodDecSearcher() {
		String language = GlobalInfo.getConf().getLanguageConfig().getLanguage();
		switch (language) {
			case "java":
				return new JavaMethodSearcher();
			default:
				throw new IllegalArgumentException("Unsupported language: " + language);
		}
	}

	public ExpressionSearcher createExpressionSearcher() {
		String language = GlobalInfo.getConf().getLanguageConfig().getLanguage();
		switch (language) {
			case "java":
				return new JavaExpressionSearcher();
			default:
				throw new IllegalArgumentException("Unsupported language: " + language);
		}
	}

	public TypeDecSearcher createTypeDecSearcher() {
		String language = GlobalInfo.getConf().getLanguageConfig().getLanguage();
		switch (language) {
			case "java":
				return new JavaTypeDecSearcher();
			default:
				throw new IllegalArgumentException("Unsupported language: " + language);
		}
	}
}
