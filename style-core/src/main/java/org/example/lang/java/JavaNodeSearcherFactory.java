package org.example.lang.java;

import lombok.Getter;
import org.example.lang.intf.INodeSearcherFactory;
import org.example.lang.intf.searcher.*;
import org.example.lang.java.searcher.*;

public class JavaNodeSearcherFactory implements INodeSearcherFactory {
	@Getter
    private static final JavaNodeSearcherFactory instance = new JavaNodeSearcherFactory();

	private JavaNodeSearcherFactory() {
	}

    @Override
	public CompilationUnitSearcher createCompilationUnitSearcher() {
		return new JavaCUSearcher();
	}

	@Override
	public VarDeclarationSearcher createVarDeclarationSearcher() {
		return new JavaVarDeclarationSearcher();
	}

	@Override
	public MethodSearcher createMethodDecSearcher() {
		return new JavaMethodSearcher();
	}

	@Override
	public ExpressionSearcher createExpressionSearcher() {
		return new JavaExpressionSearcher();
	}

	@Override
	public TypeDecSearcher createTypeDecSearcher() {
		return new JavaTypeDecSearcher();
	}

	@Override
	public ArgumentsSearcher createArgumentsSearcher() {
		return null;
	}
}
