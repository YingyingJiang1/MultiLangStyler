package org.example.utils.searcher;

import org.example.global.GlobalInfo;
import org.example.utils.searcher.impl.ArgumentsSearcherImpl;
import org.example.utils.searcher.intf.*;
import org.example.utils.searcher.javaimpl.JavaCUSearcher;
import org.example.utils.searcher.javaimpl.JavaDecStmtSearcher;
import org.example.utils.searcher.javaimpl.JavaExpressionSearcher;
import org.example.utils.searcher.javaimpl.JavaFunctionDecSearcher;

public class NodeSearcherFactory {
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

	public DecStmtSearcher createDecStmtSearcher() {
		String language = GlobalInfo.getConf().getLanguageConfig().getLanguage();
		switch (GlobalInfo.getConf().getLanguageConfig().getLanguage()) {
			case "java":
				return new JavaDecStmtSearcher();
			default:
				throw new IllegalArgumentException("Unsupported language: " + GlobalInfo.getConf().getLanguageConfig().getLanguage());
		}
	}

	public FunctionDecSearcher createFunctionDecSearcher() {
		String language = GlobalInfo.getConf().getLanguageConfig().getLanguage();
		switch (language) {
			case "java":
				return new JavaFunctionDecSearcher();
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
}
