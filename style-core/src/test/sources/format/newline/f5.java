private static boolean hasLiteralNull(DetailAST caseAST) {
	return Optional.ofNullable(caseAST.findFirstToken(TokenTypes.EXPR))
			.map(exp -> exp.findFirstToken(TokenTypes.LITERAL_NULL));
}
