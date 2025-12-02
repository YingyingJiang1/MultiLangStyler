package org.example.lang.intf;

import org.example.lang.intf.searcher.*;

public interface INodeSearcherFactory {
	CompilationUnitSearcher createCompilationUnitSearcher();

	VarDeclarationSearcher createVarDeclarationSearcher();

	MethodSearcher createMethodDecSearcher();

	ExpressionSearcher createExpressionSearcher();

	TypeDecSearcher createTypeDecSearcher();

	ArgumentsSearcher createArgumentsSearcher();
}
