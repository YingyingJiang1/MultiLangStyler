// Generated from .\cpp\CPPParser.g4 by ANTLR 4.9.3
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link CPPParser}.
 */
public interface CPPParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link CPPParser#translationUnit}.
	 * @param ctx the parse tree
	 */
	void enterTranslationUnit(CPPParser.TranslationUnitContext ctx);
	/**
	 * Exit a parse tree produced by {@link CPPParser#translationUnit}.
	 * @param ctx the parse tree
	 */
	void exitTranslationUnit(CPPParser.TranslationUnitContext ctx);
	/**
	 * Enter a parse tree produced by {@link CPPParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryExpression(CPPParser.PrimaryExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CPPParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryExpression(CPPParser.PrimaryExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CPPParser#idExpression}.
	 * @param ctx the parse tree
	 */
	void enterIdExpression(CPPParser.IdExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CPPParser#idExpression}.
	 * @param ctx the parse tree
	 */
	void exitIdExpression(CPPParser.IdExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CPPParser#unqualifiedId}.
	 * @param ctx the parse tree
	 */
	void enterUnqualifiedId(CPPParser.UnqualifiedIdContext ctx);
	/**
	 * Exit a parse tree produced by {@link CPPParser#unqualifiedId}.
	 * @param ctx the parse tree
	 */
	void exitUnqualifiedId(CPPParser.UnqualifiedIdContext ctx);
	/**
	 * Enter a parse tree produced by {@link CPPParser#qualifiedId}.
	 * @param ctx the parse tree
	 */
	void enterQualifiedId(CPPParser.QualifiedIdContext ctx);
	/**
	 * Exit a parse tree produced by {@link CPPParser#qualifiedId}.
	 * @param ctx the parse tree
	 */
	void exitQualifiedId(CPPParser.QualifiedIdContext ctx);
	/**
	 * Enter a parse tree produced by {@link CPPParser#nestedNameSpecifier}.
	 * @param ctx the parse tree
	 */
	void enterNestedNameSpecifier(CPPParser.NestedNameSpecifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link CPPParser#nestedNameSpecifier}.
	 * @param ctx the parse tree
	 */
	void exitNestedNameSpecifier(CPPParser.NestedNameSpecifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link CPPParser#lambdaExpression}.
	 * @param ctx the parse tree
	 */
	void enterLambdaExpression(CPPParser.LambdaExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CPPParser#lambdaExpression}.
	 * @param ctx the parse tree
	 */
	void exitLambdaExpression(CPPParser.LambdaExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CPPParser#lambdaIntroducer}.
	 * @param ctx the parse tree
	 */
	void enterLambdaIntroducer(CPPParser.LambdaIntroducerContext ctx);
	/**
	 * Exit a parse tree produced by {@link CPPParser#lambdaIntroducer}.
	 * @param ctx the parse tree
	 */
	void exitLambdaIntroducer(CPPParser.LambdaIntroducerContext ctx);
	/**
	 * Enter a parse tree produced by {@link CPPParser#lambdaCapture}.
	 * @param ctx the parse tree
	 */
	void enterLambdaCapture(CPPParser.LambdaCaptureContext ctx);
	/**
	 * Exit a parse tree produced by {@link CPPParser#lambdaCapture}.
	 * @param ctx the parse tree
	 */
	void exitLambdaCapture(CPPParser.LambdaCaptureContext ctx);
	/**
	 * Enter a parse tree produced by {@link CPPParser#captureDefault}.
	 * @param ctx the parse tree
	 */
	void enterCaptureDefault(CPPParser.CaptureDefaultContext ctx);
	/**
	 * Exit a parse tree produced by {@link CPPParser#captureDefault}.
	 * @param ctx the parse tree
	 */
	void exitCaptureDefault(CPPParser.CaptureDefaultContext ctx);
	/**
	 * Enter a parse tree produced by {@link CPPParser#captureList}.
	 * @param ctx the parse tree
	 */
	void enterCaptureList(CPPParser.CaptureListContext ctx);
	/**
	 * Exit a parse tree produced by {@link CPPParser#captureList}.
	 * @param ctx the parse tree
	 */
	void exitCaptureList(CPPParser.CaptureListContext ctx);
	/**
	 * Enter a parse tree produced by {@link CPPParser#capture}.
	 * @param ctx the parse tree
	 */
	void enterCapture(CPPParser.CaptureContext ctx);
	/**
	 * Exit a parse tree produced by {@link CPPParser#capture}.
	 * @param ctx the parse tree
	 */
	void exitCapture(CPPParser.CaptureContext ctx);
	/**
	 * Enter a parse tree produced by {@link CPPParser#simpleCapture}.
	 * @param ctx the parse tree
	 */
	void enterSimpleCapture(CPPParser.SimpleCaptureContext ctx);
	/**
	 * Exit a parse tree produced by {@link CPPParser#simpleCapture}.
	 * @param ctx the parse tree
	 */
	void exitSimpleCapture(CPPParser.SimpleCaptureContext ctx);
	/**
	 * Enter a parse tree produced by {@link CPPParser#initcapture}.
	 * @param ctx the parse tree
	 */
	void enterInitcapture(CPPParser.InitcaptureContext ctx);
	/**
	 * Exit a parse tree produced by {@link CPPParser#initcapture}.
	 * @param ctx the parse tree
	 */
	void exitInitcapture(CPPParser.InitcaptureContext ctx);
	/**
	 * Enter a parse tree produced by {@link CPPParser#lambdaDeclarator}.
	 * @param ctx the parse tree
	 */
	void enterLambdaDeclarator(CPPParser.LambdaDeclaratorContext ctx);
	/**
	 * Exit a parse tree produced by {@link CPPParser#lambdaDeclarator}.
	 * @param ctx the parse tree
	 */
	void exitLambdaDeclarator(CPPParser.LambdaDeclaratorContext ctx);
	/**
	 * Enter a parse tree produced by {@link CPPParser#postfixExpression}.
	 * @param ctx the parse tree
	 */
	void enterPostfixExpression(CPPParser.PostfixExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CPPParser#postfixExpression}.
	 * @param ctx the parse tree
	 */
	void exitPostfixExpression(CPPParser.PostfixExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CPPParser#typeIdOfTheTypeId}.
	 * @param ctx the parse tree
	 */
	void enterTypeIdOfTheTypeId(CPPParser.TypeIdOfTheTypeIdContext ctx);
	/**
	 * Exit a parse tree produced by {@link CPPParser#typeIdOfTheTypeId}.
	 * @param ctx the parse tree
	 */
	void exitTypeIdOfTheTypeId(CPPParser.TypeIdOfTheTypeIdContext ctx);
	/**
	 * Enter a parse tree produced by {@link CPPParser#expressionList}.
	 * @param ctx the parse tree
	 */
	void enterExpressionList(CPPParser.ExpressionListContext ctx);
	/**
	 * Exit a parse tree produced by {@link CPPParser#expressionList}.
	 * @param ctx the parse tree
	 */
	void exitExpressionList(CPPParser.ExpressionListContext ctx);
	/**
	 * Enter a parse tree produced by {@link CPPParser#pseudoDestructorName}.
	 * @param ctx the parse tree
	 */
	void enterPseudoDestructorName(CPPParser.PseudoDestructorNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link CPPParser#pseudoDestructorName}.
	 * @param ctx the parse tree
	 */
	void exitPseudoDestructorName(CPPParser.PseudoDestructorNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link CPPParser#unaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterUnaryExpression(CPPParser.UnaryExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CPPParser#unaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitUnaryExpression(CPPParser.UnaryExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CPPParser#unaryOperator}.
	 * @param ctx the parse tree
	 */
	void enterUnaryOperator(CPPParser.UnaryOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link CPPParser#unaryOperator}.
	 * @param ctx the parse tree
	 */
	void exitUnaryOperator(CPPParser.UnaryOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link CPPParser#newExpression_}.
	 * @param ctx the parse tree
	 */
	void enterNewExpression_(CPPParser.NewExpression_Context ctx);
	/**
	 * Exit a parse tree produced by {@link CPPParser#newExpression_}.
	 * @param ctx the parse tree
	 */
	void exitNewExpression_(CPPParser.NewExpression_Context ctx);
	/**
	 * Enter a parse tree produced by {@link CPPParser#newPlacement}.
	 * @param ctx the parse tree
	 */
	void enterNewPlacement(CPPParser.NewPlacementContext ctx);
	/**
	 * Exit a parse tree produced by {@link CPPParser#newPlacement}.
	 * @param ctx the parse tree
	 */
	void exitNewPlacement(CPPParser.NewPlacementContext ctx);
	/**
	 * Enter a parse tree produced by {@link CPPParser#newTypeId}.
	 * @param ctx the parse tree
	 */
	void enterNewTypeId(CPPParser.NewTypeIdContext ctx);
	/**
	 * Exit a parse tree produced by {@link CPPParser#newTypeId}.
	 * @param ctx the parse tree
	 */
	void exitNewTypeId(CPPParser.NewTypeIdContext ctx);
	/**
	 * Enter a parse tree produced by {@link CPPParser#newDeclarator_}.
	 * @param ctx the parse tree
	 */
	void enterNewDeclarator_(CPPParser.NewDeclarator_Context ctx);
	/**
	 * Exit a parse tree produced by {@link CPPParser#newDeclarator_}.
	 * @param ctx the parse tree
	 */
	void exitNewDeclarator_(CPPParser.NewDeclarator_Context ctx);
	/**
	 * Enter a parse tree produced by {@link CPPParser#noPointerNewDeclarator}.
	 * @param ctx the parse tree
	 */
	void enterNoPointerNewDeclarator(CPPParser.NoPointerNewDeclaratorContext ctx);
	/**
	 * Exit a parse tree produced by {@link CPPParser#noPointerNewDeclarator}.
	 * @param ctx the parse tree
	 */
	void exitNoPointerNewDeclarator(CPPParser.NoPointerNewDeclaratorContext ctx);
	/**
	 * Enter a parse tree produced by {@link CPPParser#newInitializer_}.
	 * @param ctx the parse tree
	 */
	void enterNewInitializer_(CPPParser.NewInitializer_Context ctx);
	/**
	 * Exit a parse tree produced by {@link CPPParser#newInitializer_}.
	 * @param ctx the parse tree
	 */
	void exitNewInitializer_(CPPParser.NewInitializer_Context ctx);
	/**
	 * Enter a parse tree produced by {@link CPPParser#deleteExpression}.
	 * @param ctx the parse tree
	 */
	void enterDeleteExpression(CPPParser.DeleteExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CPPParser#deleteExpression}.
	 * @param ctx the parse tree
	 */
	void exitDeleteExpression(CPPParser.DeleteExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CPPParser#noExceptExpression}.
	 * @param ctx the parse tree
	 */
	void enterNoExceptExpression(CPPParser.NoExceptExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CPPParser#noExceptExpression}.
	 * @param ctx the parse tree
	 */
	void exitNoExceptExpression(CPPParser.NoExceptExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CPPParser#castExpression}.
	 * @param ctx the parse tree
	 */
	void enterCastExpression(CPPParser.CastExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CPPParser#castExpression}.
	 * @param ctx the parse tree
	 */
	void exitCastExpression(CPPParser.CastExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CPPParser#pointerMemberExpression}.
	 * @param ctx the parse tree
	 */
	void enterPointerMemberExpression(CPPParser.PointerMemberExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CPPParser#pointerMemberExpression}.
	 * @param ctx the parse tree
	 */
	void exitPointerMemberExpression(CPPParser.PointerMemberExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CPPParser#multiplicativeExpression}.
	 * @param ctx the parse tree
	 */
	void enterMultiplicativeExpression(CPPParser.MultiplicativeExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CPPParser#multiplicativeExpression}.
	 * @param ctx the parse tree
	 */
	void exitMultiplicativeExpression(CPPParser.MultiplicativeExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CPPParser#additiveExpression}.
	 * @param ctx the parse tree
	 */
	void enterAdditiveExpression(CPPParser.AdditiveExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CPPParser#additiveExpression}.
	 * @param ctx the parse tree
	 */
	void exitAdditiveExpression(CPPParser.AdditiveExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CPPParser#shiftExpression}.
	 * @param ctx the parse tree
	 */
	void enterShiftExpression(CPPParser.ShiftExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CPPParser#shiftExpression}.
	 * @param ctx the parse tree
	 */
	void exitShiftExpression(CPPParser.ShiftExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CPPParser#shiftOperator}.
	 * @param ctx the parse tree
	 */
	void enterShiftOperator(CPPParser.ShiftOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link CPPParser#shiftOperator}.
	 * @param ctx the parse tree
	 */
	void exitShiftOperator(CPPParser.ShiftOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link CPPParser#relationalExpression}.
	 * @param ctx the parse tree
	 */
	void enterRelationalExpression(CPPParser.RelationalExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CPPParser#relationalExpression}.
	 * @param ctx the parse tree
	 */
	void exitRelationalExpression(CPPParser.RelationalExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CPPParser#equalityExpression}.
	 * @param ctx the parse tree
	 */
	void enterEqualityExpression(CPPParser.EqualityExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CPPParser#equalityExpression}.
	 * @param ctx the parse tree
	 */
	void exitEqualityExpression(CPPParser.EqualityExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CPPParser#andExpression}.
	 * @param ctx the parse tree
	 */
	void enterAndExpression(CPPParser.AndExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CPPParser#andExpression}.
	 * @param ctx the parse tree
	 */
	void exitAndExpression(CPPParser.AndExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CPPParser#exclusiveOrExpression}.
	 * @param ctx the parse tree
	 */
	void enterExclusiveOrExpression(CPPParser.ExclusiveOrExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CPPParser#exclusiveOrExpression}.
	 * @param ctx the parse tree
	 */
	void exitExclusiveOrExpression(CPPParser.ExclusiveOrExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CPPParser#inclusiveOrExpression}.
	 * @param ctx the parse tree
	 */
	void enterInclusiveOrExpression(CPPParser.InclusiveOrExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CPPParser#inclusiveOrExpression}.
	 * @param ctx the parse tree
	 */
	void exitInclusiveOrExpression(CPPParser.InclusiveOrExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CPPParser#logicalAndExpression}.
	 * @param ctx the parse tree
	 */
	void enterLogicalAndExpression(CPPParser.LogicalAndExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CPPParser#logicalAndExpression}.
	 * @param ctx the parse tree
	 */
	void exitLogicalAndExpression(CPPParser.LogicalAndExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CPPParser#logicalOrExpression}.
	 * @param ctx the parse tree
	 */
	void enterLogicalOrExpression(CPPParser.LogicalOrExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CPPParser#logicalOrExpression}.
	 * @param ctx the parse tree
	 */
	void exitLogicalOrExpression(CPPParser.LogicalOrExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CPPParser#conditionalExpression}.
	 * @param ctx the parse tree
	 */
	void enterConditionalExpression(CPPParser.ConditionalExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CPPParser#conditionalExpression}.
	 * @param ctx the parse tree
	 */
	void exitConditionalExpression(CPPParser.ConditionalExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CPPParser#assignmentExpression}.
	 * @param ctx the parse tree
	 */
	void enterAssignmentExpression(CPPParser.AssignmentExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CPPParser#assignmentExpression}.
	 * @param ctx the parse tree
	 */
	void exitAssignmentExpression(CPPParser.AssignmentExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CPPParser#assignmentOperator}.
	 * @param ctx the parse tree
	 */
	void enterAssignmentOperator(CPPParser.AssignmentOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link CPPParser#assignmentOperator}.
	 * @param ctx the parse tree
	 */
	void exitAssignmentOperator(CPPParser.AssignmentOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link CPPParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(CPPParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CPPParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(CPPParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CPPParser#constantExpression}.
	 * @param ctx the parse tree
	 */
	void enterConstantExpression(CPPParser.ConstantExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CPPParser#constantExpression}.
	 * @param ctx the parse tree
	 */
	void exitConstantExpression(CPPParser.ConstantExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CPPParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(CPPParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link CPPParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(CPPParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link CPPParser#labeledStatement}.
	 * @param ctx the parse tree
	 */
	void enterLabeledStatement(CPPParser.LabeledStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link CPPParser#labeledStatement}.
	 * @param ctx the parse tree
	 */
	void exitLabeledStatement(CPPParser.LabeledStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link CPPParser#expressionStatement}.
	 * @param ctx the parse tree
	 */
	void enterExpressionStatement(CPPParser.ExpressionStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link CPPParser#expressionStatement}.
	 * @param ctx the parse tree
	 */
	void exitExpressionStatement(CPPParser.ExpressionStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link CPPParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(CPPParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link CPPParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(CPPParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link CPPParser#statementSeq}.
	 * @param ctx the parse tree
	 */
	void enterStatementSeq(CPPParser.StatementSeqContext ctx);
	/**
	 * Exit a parse tree produced by {@link CPPParser#statementSeq}.
	 * @param ctx the parse tree
	 */
	void exitStatementSeq(CPPParser.StatementSeqContext ctx);
	/**
	 * Enter a parse tree produced by {@link CPPParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfStatement(CPPParser.IfStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link CPPParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfStatement(CPPParser.IfStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link CPPParser#ifElseStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfElseStatement(CPPParser.IfElseStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link CPPParser#ifElseStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfElseStatement(CPPParser.IfElseStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link CPPParser#switchStatement}.
	 * @param ctx the parse tree
	 */
	void enterSwitchStatement(CPPParser.SwitchStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link CPPParser#switchStatement}.
	 * @param ctx the parse tree
	 */
	void exitSwitchStatement(CPPParser.SwitchStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link CPPParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterCondition(CPPParser.ConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CPPParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitCondition(CPPParser.ConditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CPPParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void enterWhileStatement(CPPParser.WhileStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link CPPParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void exitWhileStatement(CPPParser.WhileStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link CPPParser#doWhileStatement}.
	 * @param ctx the parse tree
	 */
	void enterDoWhileStatement(CPPParser.DoWhileStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link CPPParser#doWhileStatement}.
	 * @param ctx the parse tree
	 */
	void exitDoWhileStatement(CPPParser.DoWhileStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link CPPParser#forStatement}.
	 * @param ctx the parse tree
	 */
	void enterForStatement(CPPParser.ForStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link CPPParser#forStatement}.
	 * @param ctx the parse tree
	 */
	void exitForStatement(CPPParser.ForStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link CPPParser#forInitStatement}.
	 * @param ctx the parse tree
	 */
	void enterForInitStatement(CPPParser.ForInitStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link CPPParser#forInitStatement}.
	 * @param ctx the parse tree
	 */
	void exitForInitStatement(CPPParser.ForInitStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link CPPParser#forRangeDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterForRangeDeclaration(CPPParser.ForRangeDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link CPPParser#forRangeDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitForRangeDeclaration(CPPParser.ForRangeDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link CPPParser#forRangeInitializer}.
	 * @param ctx the parse tree
	 */
	void enterForRangeInitializer(CPPParser.ForRangeInitializerContext ctx);
	/**
	 * Exit a parse tree produced by {@link CPPParser#forRangeInitializer}.
	 * @param ctx the parse tree
	 */
	void exitForRangeInitializer(CPPParser.ForRangeInitializerContext ctx);
	/**
	 * Enter a parse tree produced by {@link CPPParser#jumpStatement}.
	 * @param ctx the parse tree
	 */
	void enterJumpStatement(CPPParser.JumpStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link CPPParser#jumpStatement}.
	 * @param ctx the parse tree
	 */
	void exitJumpStatement(CPPParser.JumpStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link CPPParser#declarationStatement}.
	 * @param ctx the parse tree
	 */
	void enterDeclarationStatement(CPPParser.DeclarationStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link CPPParser#declarationStatement}.
	 * @param ctx the parse tree
	 */
	void exitDeclarationStatement(CPPParser.DeclarationStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link CPPParser#declarationseq}.
	 * @param ctx the parse tree
	 */
	void enterDeclarationseq(CPPParser.DeclarationseqContext ctx);
	/**
	 * Exit a parse tree produced by {@link CPPParser#declarationseq}.
	 * @param ctx the parse tree
	 */
	void exitDeclarationseq(CPPParser.DeclarationseqContext ctx);
	/**
	 * Enter a parse tree produced by {@link CPPParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterDeclaration(CPPParser.DeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link CPPParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitDeclaration(CPPParser.DeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link CPPParser#blockDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterBlockDeclaration(CPPParser.BlockDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link CPPParser#blockDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitBlockDeclaration(CPPParser.BlockDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link CPPParser#aliasDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterAliasDeclaration(CPPParser.AliasDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link CPPParser#aliasDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitAliasDeclaration(CPPParser.AliasDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link CPPParser#simpleDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterSimpleDeclaration(CPPParser.SimpleDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link CPPParser#simpleDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitSimpleDeclaration(CPPParser.SimpleDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link CPPParser#staticAssertDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterStaticAssertDeclaration(CPPParser.StaticAssertDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link CPPParser#staticAssertDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitStaticAssertDeclaration(CPPParser.StaticAssertDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link CPPParser#emptyDeclaration_}.
	 * @param ctx the parse tree
	 */
	void enterEmptyDeclaration_(CPPParser.EmptyDeclaration_Context ctx);
	/**
	 * Exit a parse tree produced by {@link CPPParser#emptyDeclaration_}.
	 * @param ctx the parse tree
	 */
	void exitEmptyDeclaration_(CPPParser.EmptyDeclaration_Context ctx);
	/**
	 * Enter a parse tree produced by {@link CPPParser#attributeDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterAttributeDeclaration(CPPParser.AttributeDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link CPPParser#attributeDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitAttributeDeclaration(CPPParser.AttributeDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link CPPParser#declSpecifier}.
	 * @param ctx the parse tree
	 */
	void enterDeclSpecifier(CPPParser.DeclSpecifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link CPPParser#declSpecifier}.
	 * @param ctx the parse tree
	 */
	void exitDeclSpecifier(CPPParser.DeclSpecifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link CPPParser#declSpecifierSeq}.
	 * @param ctx the parse tree
	 */
	void enterDeclSpecifierSeq(CPPParser.DeclSpecifierSeqContext ctx);
	/**
	 * Exit a parse tree produced by {@link CPPParser#declSpecifierSeq}.
	 * @param ctx the parse tree
	 */
	void exitDeclSpecifierSeq(CPPParser.DeclSpecifierSeqContext ctx);
	/**
	 * Enter a parse tree produced by {@link CPPParser#storageClassSpecifier}.
	 * @param ctx the parse tree
	 */
	void enterStorageClassSpecifier(CPPParser.StorageClassSpecifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link CPPParser#storageClassSpecifier}.
	 * @param ctx the parse tree
	 */
	void exitStorageClassSpecifier(CPPParser.StorageClassSpecifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link CPPParser#functionSpecifier}.
	 * @param ctx the parse tree
	 */
	void enterFunctionSpecifier(CPPParser.FunctionSpecifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link CPPParser#functionSpecifier}.
	 * @param ctx the parse tree
	 */
	void exitFunctionSpecifier(CPPParser.FunctionSpecifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link CPPParser#typedefName}.
	 * @param ctx the parse tree
	 */
	void enterTypedefName(CPPParser.TypedefNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link CPPParser#typedefName}.
	 * @param ctx the parse tree
	 */
	void exitTypedefName(CPPParser.TypedefNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link CPPParser#typeSpecifier}.
	 * @param ctx the parse tree
	 */
	void enterTypeSpecifier(CPPParser.TypeSpecifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link CPPParser#typeSpecifier}.
	 * @param ctx the parse tree
	 */
	void exitTypeSpecifier(CPPParser.TypeSpecifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link CPPParser#trailingTypeSpecifier}.
	 * @param ctx the parse tree
	 */
	void enterTrailingTypeSpecifier(CPPParser.TrailingTypeSpecifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link CPPParser#trailingTypeSpecifier}.
	 * @param ctx the parse tree
	 */
	void exitTrailingTypeSpecifier(CPPParser.TrailingTypeSpecifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link CPPParser#typeSpecifierSeq}.
	 * @param ctx the parse tree
	 */
	void enterTypeSpecifierSeq(CPPParser.TypeSpecifierSeqContext ctx);
	/**
	 * Exit a parse tree produced by {@link CPPParser#typeSpecifierSeq}.
	 * @param ctx the parse tree
	 */
	void exitTypeSpecifierSeq(CPPParser.TypeSpecifierSeqContext ctx);
	/**
	 * Enter a parse tree produced by {@link CPPParser#trailingTypeSpecifierSeq}.
	 * @param ctx the parse tree
	 */
	void enterTrailingTypeSpecifierSeq(CPPParser.TrailingTypeSpecifierSeqContext ctx);
	/**
	 * Exit a parse tree produced by {@link CPPParser#trailingTypeSpecifierSeq}.
	 * @param ctx the parse tree
	 */
	void exitTrailingTypeSpecifierSeq(CPPParser.TrailingTypeSpecifierSeqContext ctx);
	/**
	 * Enter a parse tree produced by {@link CPPParser#simpleTypeLengthModifier}.
	 * @param ctx the parse tree
	 */
	void enterSimpleTypeLengthModifier(CPPParser.SimpleTypeLengthModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link CPPParser#simpleTypeLengthModifier}.
	 * @param ctx the parse tree
	 */
	void exitSimpleTypeLengthModifier(CPPParser.SimpleTypeLengthModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link CPPParser#simpleTypeSignednessModifier}.
	 * @param ctx the parse tree
	 */
	void enterSimpleTypeSignednessModifier(CPPParser.SimpleTypeSignednessModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link CPPParser#simpleTypeSignednessModifier}.
	 * @param ctx the parse tree
	 */
	void exitSimpleTypeSignednessModifier(CPPParser.SimpleTypeSignednessModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link CPPParser#simpleTypeSpecifier}.
	 * @param ctx the parse tree
	 */
	void enterSimpleTypeSpecifier(CPPParser.SimpleTypeSpecifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link CPPParser#simpleTypeSpecifier}.
	 * @param ctx the parse tree
	 */
	void exitSimpleTypeSpecifier(CPPParser.SimpleTypeSpecifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link CPPParser#theTypeName}.
	 * @param ctx the parse tree
	 */
	void enterTheTypeName(CPPParser.TheTypeNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link CPPParser#theTypeName}.
	 * @param ctx the parse tree
	 */
	void exitTheTypeName(CPPParser.TheTypeNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link CPPParser#decltypeSpecifier}.
	 * @param ctx the parse tree
	 */
	void enterDecltypeSpecifier(CPPParser.DecltypeSpecifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link CPPParser#decltypeSpecifier}.
	 * @param ctx the parse tree
	 */
	void exitDecltypeSpecifier(CPPParser.DecltypeSpecifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link CPPParser#elaboratedTypeSpecifier}.
	 * @param ctx the parse tree
	 */
	void enterElaboratedTypeSpecifier(CPPParser.ElaboratedTypeSpecifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link CPPParser#elaboratedTypeSpecifier}.
	 * @param ctx the parse tree
	 */
	void exitElaboratedTypeSpecifier(CPPParser.ElaboratedTypeSpecifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link CPPParser#enumName}.
	 * @param ctx the parse tree
	 */
	void enterEnumName(CPPParser.EnumNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link CPPParser#enumName}.
	 * @param ctx the parse tree
	 */
	void exitEnumName(CPPParser.EnumNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link CPPParser#enumSpecifier}.
	 * @param ctx the parse tree
	 */
	void enterEnumSpecifier(CPPParser.EnumSpecifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link CPPParser#enumSpecifier}.
	 * @param ctx the parse tree
	 */
	void exitEnumSpecifier(CPPParser.EnumSpecifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link CPPParser#enumHead}.
	 * @param ctx the parse tree
	 */
	void enterEnumHead(CPPParser.EnumHeadContext ctx);
	/**
	 * Exit a parse tree produced by {@link CPPParser#enumHead}.
	 * @param ctx the parse tree
	 */
	void exitEnumHead(CPPParser.EnumHeadContext ctx);
	/**
	 * Enter a parse tree produced by {@link CPPParser#opaqueEnumDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterOpaqueEnumDeclaration(CPPParser.OpaqueEnumDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link CPPParser#opaqueEnumDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitOpaqueEnumDeclaration(CPPParser.OpaqueEnumDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link CPPParser#enumkey}.
	 * @param ctx the parse tree
	 */
	void enterEnumkey(CPPParser.EnumkeyContext ctx);
	/**
	 * Exit a parse tree produced by {@link CPPParser#enumkey}.
	 * @param ctx the parse tree
	 */
	void exitEnumkey(CPPParser.EnumkeyContext ctx);
	/**
	 * Enter a parse tree produced by {@link CPPParser#enumbase}.
	 * @param ctx the parse tree
	 */
	void enterEnumbase(CPPParser.EnumbaseContext ctx);
	/**
	 * Exit a parse tree produced by {@link CPPParser#enumbase}.
	 * @param ctx the parse tree
	 */
	void exitEnumbase(CPPParser.EnumbaseContext ctx);
	/**
	 * Enter a parse tree produced by {@link CPPParser#enumeratorList}.
	 * @param ctx the parse tree
	 */
	void enterEnumeratorList(CPPParser.EnumeratorListContext ctx);
	/**
	 * Exit a parse tree produced by {@link CPPParser#enumeratorList}.
	 * @param ctx the parse tree
	 */
	void exitEnumeratorList(CPPParser.EnumeratorListContext ctx);
	/**
	 * Enter a parse tree produced by {@link CPPParser#enumeratorDefinition}.
	 * @param ctx the parse tree
	 */
	void enterEnumeratorDefinition(CPPParser.EnumeratorDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CPPParser#enumeratorDefinition}.
	 * @param ctx the parse tree
	 */
	void exitEnumeratorDefinition(CPPParser.EnumeratorDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CPPParser#enumerator}.
	 * @param ctx the parse tree
	 */
	void enterEnumerator(CPPParser.EnumeratorContext ctx);
	/**
	 * Exit a parse tree produced by {@link CPPParser#enumerator}.
	 * @param ctx the parse tree
	 */
	void exitEnumerator(CPPParser.EnumeratorContext ctx);
	/**
	 * Enter a parse tree produced by {@link CPPParser#namespaceName}.
	 * @param ctx the parse tree
	 */
	void enterNamespaceName(CPPParser.NamespaceNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link CPPParser#namespaceName}.
	 * @param ctx the parse tree
	 */
	void exitNamespaceName(CPPParser.NamespaceNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link CPPParser#originalNamespaceName}.
	 * @param ctx the parse tree
	 */
	void enterOriginalNamespaceName(CPPParser.OriginalNamespaceNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link CPPParser#originalNamespaceName}.
	 * @param ctx the parse tree
	 */
	void exitOriginalNamespaceName(CPPParser.OriginalNamespaceNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link CPPParser#namespaceDefinition}.
	 * @param ctx the parse tree
	 */
	void enterNamespaceDefinition(CPPParser.NamespaceDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CPPParser#namespaceDefinition}.
	 * @param ctx the parse tree
	 */
	void exitNamespaceDefinition(CPPParser.NamespaceDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CPPParser#namespaceAlias}.
	 * @param ctx the parse tree
	 */
	void enterNamespaceAlias(CPPParser.NamespaceAliasContext ctx);
	/**
	 * Exit a parse tree produced by {@link CPPParser#namespaceAlias}.
	 * @param ctx the parse tree
	 */
	void exitNamespaceAlias(CPPParser.NamespaceAliasContext ctx);
	/**
	 * Enter a parse tree produced by {@link CPPParser#namespaceAliasDefinition}.
	 * @param ctx the parse tree
	 */
	void enterNamespaceAliasDefinition(CPPParser.NamespaceAliasDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CPPParser#namespaceAliasDefinition}.
	 * @param ctx the parse tree
	 */
	void exitNamespaceAliasDefinition(CPPParser.NamespaceAliasDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CPPParser#qualifiednamespacespecifier}.
	 * @param ctx the parse tree
	 */
	void enterQualifiednamespacespecifier(CPPParser.QualifiednamespacespecifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link CPPParser#qualifiednamespacespecifier}.
	 * @param ctx the parse tree
	 */
	void exitQualifiednamespacespecifier(CPPParser.QualifiednamespacespecifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link CPPParser#usingDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterUsingDeclaration(CPPParser.UsingDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link CPPParser#usingDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitUsingDeclaration(CPPParser.UsingDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link CPPParser#usingDirective}.
	 * @param ctx the parse tree
	 */
	void enterUsingDirective(CPPParser.UsingDirectiveContext ctx);
	/**
	 * Exit a parse tree produced by {@link CPPParser#usingDirective}.
	 * @param ctx the parse tree
	 */
	void exitUsingDirective(CPPParser.UsingDirectiveContext ctx);
	/**
	 * Enter a parse tree produced by {@link CPPParser#asmDefinition}.
	 * @param ctx the parse tree
	 */
	void enterAsmDefinition(CPPParser.AsmDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CPPParser#asmDefinition}.
	 * @param ctx the parse tree
	 */
	void exitAsmDefinition(CPPParser.AsmDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CPPParser#linkageSpecification}.
	 * @param ctx the parse tree
	 */
	void enterLinkageSpecification(CPPParser.LinkageSpecificationContext ctx);
	/**
	 * Exit a parse tree produced by {@link CPPParser#linkageSpecification}.
	 * @param ctx the parse tree
	 */
	void exitLinkageSpecification(CPPParser.LinkageSpecificationContext ctx);
	/**
	 * Enter a parse tree produced by {@link CPPParser#attributeSpecifierSeq}.
	 * @param ctx the parse tree
	 */
	void enterAttributeSpecifierSeq(CPPParser.AttributeSpecifierSeqContext ctx);
	/**
	 * Exit a parse tree produced by {@link CPPParser#attributeSpecifierSeq}.
	 * @param ctx the parse tree
	 */
	void exitAttributeSpecifierSeq(CPPParser.AttributeSpecifierSeqContext ctx);
	/**
	 * Enter a parse tree produced by {@link CPPParser#attributeSpecifier}.
	 * @param ctx the parse tree
	 */
	void enterAttributeSpecifier(CPPParser.AttributeSpecifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link CPPParser#attributeSpecifier}.
	 * @param ctx the parse tree
	 */
	void exitAttributeSpecifier(CPPParser.AttributeSpecifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link CPPParser#alignmentspecifier}.
	 * @param ctx the parse tree
	 */
	void enterAlignmentspecifier(CPPParser.AlignmentspecifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link CPPParser#alignmentspecifier}.
	 * @param ctx the parse tree
	 */
	void exitAlignmentspecifier(CPPParser.AlignmentspecifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link CPPParser#attributeList}.
	 * @param ctx the parse tree
	 */
	void enterAttributeList(CPPParser.AttributeListContext ctx);
	/**
	 * Exit a parse tree produced by {@link CPPParser#attributeList}.
	 * @param ctx the parse tree
	 */
	void exitAttributeList(CPPParser.AttributeListContext ctx);
	/**
	 * Enter a parse tree produced by {@link CPPParser#attribute}.
	 * @param ctx the parse tree
	 */
	void enterAttribute(CPPParser.AttributeContext ctx);
	/**
	 * Exit a parse tree produced by {@link CPPParser#attribute}.
	 * @param ctx the parse tree
	 */
	void exitAttribute(CPPParser.AttributeContext ctx);
	/**
	 * Enter a parse tree produced by {@link CPPParser#attributeNamespace}.
	 * @param ctx the parse tree
	 */
	void enterAttributeNamespace(CPPParser.AttributeNamespaceContext ctx);
	/**
	 * Exit a parse tree produced by {@link CPPParser#attributeNamespace}.
	 * @param ctx the parse tree
	 */
	void exitAttributeNamespace(CPPParser.AttributeNamespaceContext ctx);
	/**
	 * Enter a parse tree produced by {@link CPPParser#attributeArgumentClause}.
	 * @param ctx the parse tree
	 */
	void enterAttributeArgumentClause(CPPParser.AttributeArgumentClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link CPPParser#attributeArgumentClause}.
	 * @param ctx the parse tree
	 */
	void exitAttributeArgumentClause(CPPParser.AttributeArgumentClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link CPPParser#balancedTokenSeq}.
	 * @param ctx the parse tree
	 */
	void enterBalancedTokenSeq(CPPParser.BalancedTokenSeqContext ctx);
	/**
	 * Exit a parse tree produced by {@link CPPParser#balancedTokenSeq}.
	 * @param ctx the parse tree
	 */
	void exitBalancedTokenSeq(CPPParser.BalancedTokenSeqContext ctx);
	/**
	 * Enter a parse tree produced by {@link CPPParser#balancedtoken}.
	 * @param ctx the parse tree
	 */
	void enterBalancedtoken(CPPParser.BalancedtokenContext ctx);
	/**
	 * Exit a parse tree produced by {@link CPPParser#balancedtoken}.
	 * @param ctx the parse tree
	 */
	void exitBalancedtoken(CPPParser.BalancedtokenContext ctx);
	/**
	 * Enter a parse tree produced by {@link CPPParser#initDeclaratorList}.
	 * @param ctx the parse tree
	 */
	void enterInitDeclaratorList(CPPParser.InitDeclaratorListContext ctx);
	/**
	 * Exit a parse tree produced by {@link CPPParser#initDeclaratorList}.
	 * @param ctx the parse tree
	 */
	void exitInitDeclaratorList(CPPParser.InitDeclaratorListContext ctx);
	/**
	 * Enter a parse tree produced by {@link CPPParser#initDeclarator}.
	 * @param ctx the parse tree
	 */
	void enterInitDeclarator(CPPParser.InitDeclaratorContext ctx);
	/**
	 * Exit a parse tree produced by {@link CPPParser#initDeclarator}.
	 * @param ctx the parse tree
	 */
	void exitInitDeclarator(CPPParser.InitDeclaratorContext ctx);
	/**
	 * Enter a parse tree produced by {@link CPPParser#declarator}.
	 * @param ctx the parse tree
	 */
	void enterDeclarator(CPPParser.DeclaratorContext ctx);
	/**
	 * Exit a parse tree produced by {@link CPPParser#declarator}.
	 * @param ctx the parse tree
	 */
	void exitDeclarator(CPPParser.DeclaratorContext ctx);
	/**
	 * Enter a parse tree produced by {@link CPPParser#pointerDeclarator}.
	 * @param ctx the parse tree
	 */
	void enterPointerDeclarator(CPPParser.PointerDeclaratorContext ctx);
	/**
	 * Exit a parse tree produced by {@link CPPParser#pointerDeclarator}.
	 * @param ctx the parse tree
	 */
	void exitPointerDeclarator(CPPParser.PointerDeclaratorContext ctx);
	/**
	 * Enter a parse tree produced by {@link CPPParser#noPointerDeclarator}.
	 * @param ctx the parse tree
	 */
	void enterNoPointerDeclarator(CPPParser.NoPointerDeclaratorContext ctx);
	/**
	 * Exit a parse tree produced by {@link CPPParser#noPointerDeclarator}.
	 * @param ctx the parse tree
	 */
	void exitNoPointerDeclarator(CPPParser.NoPointerDeclaratorContext ctx);
	/**
	 * Enter a parse tree produced by {@link CPPParser#parametersAndQualifiers}.
	 * @param ctx the parse tree
	 */
	void enterParametersAndQualifiers(CPPParser.ParametersAndQualifiersContext ctx);
	/**
	 * Exit a parse tree produced by {@link CPPParser#parametersAndQualifiers}.
	 * @param ctx the parse tree
	 */
	void exitParametersAndQualifiers(CPPParser.ParametersAndQualifiersContext ctx);
	/**
	 * Enter a parse tree produced by {@link CPPParser#trailingReturnType}.
	 * @param ctx the parse tree
	 */
	void enterTrailingReturnType(CPPParser.TrailingReturnTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link CPPParser#trailingReturnType}.
	 * @param ctx the parse tree
	 */
	void exitTrailingReturnType(CPPParser.TrailingReturnTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link CPPParser#pointerOperator}.
	 * @param ctx the parse tree
	 */
	void enterPointerOperator(CPPParser.PointerOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link CPPParser#pointerOperator}.
	 * @param ctx the parse tree
	 */
	void exitPointerOperator(CPPParser.PointerOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link CPPParser#cvqualifierseq}.
	 * @param ctx the parse tree
	 */
	void enterCvqualifierseq(CPPParser.CvqualifierseqContext ctx);
	/**
	 * Exit a parse tree produced by {@link CPPParser#cvqualifierseq}.
	 * @param ctx the parse tree
	 */
	void exitCvqualifierseq(CPPParser.CvqualifierseqContext ctx);
	/**
	 * Enter a parse tree produced by {@link CPPParser#cvQualifier}.
	 * @param ctx the parse tree
	 */
	void enterCvQualifier(CPPParser.CvQualifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link CPPParser#cvQualifier}.
	 * @param ctx the parse tree
	 */
	void exitCvQualifier(CPPParser.CvQualifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link CPPParser#refqualifier}.
	 * @param ctx the parse tree
	 */
	void enterRefqualifier(CPPParser.RefqualifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link CPPParser#refqualifier}.
	 * @param ctx the parse tree
	 */
	void exitRefqualifier(CPPParser.RefqualifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link CPPParser#declaratorid}.
	 * @param ctx the parse tree
	 */
	void enterDeclaratorid(CPPParser.DeclaratoridContext ctx);
	/**
	 * Exit a parse tree produced by {@link CPPParser#declaratorid}.
	 * @param ctx the parse tree
	 */
	void exitDeclaratorid(CPPParser.DeclaratoridContext ctx);
	/**
	 * Enter a parse tree produced by {@link CPPParser#theTypeId}.
	 * @param ctx the parse tree
	 */
	void enterTheTypeId(CPPParser.TheTypeIdContext ctx);
	/**
	 * Exit a parse tree produced by {@link CPPParser#theTypeId}.
	 * @param ctx the parse tree
	 */
	void exitTheTypeId(CPPParser.TheTypeIdContext ctx);
	/**
	 * Enter a parse tree produced by {@link CPPParser#abstractDeclarator}.
	 * @param ctx the parse tree
	 */
	void enterAbstractDeclarator(CPPParser.AbstractDeclaratorContext ctx);
	/**
	 * Exit a parse tree produced by {@link CPPParser#abstractDeclarator}.
	 * @param ctx the parse tree
	 */
	void exitAbstractDeclarator(CPPParser.AbstractDeclaratorContext ctx);
	/**
	 * Enter a parse tree produced by {@link CPPParser#pointerAbstractDeclarator}.
	 * @param ctx the parse tree
	 */
	void enterPointerAbstractDeclarator(CPPParser.PointerAbstractDeclaratorContext ctx);
	/**
	 * Exit a parse tree produced by {@link CPPParser#pointerAbstractDeclarator}.
	 * @param ctx the parse tree
	 */
	void exitPointerAbstractDeclarator(CPPParser.PointerAbstractDeclaratorContext ctx);
	/**
	 * Enter a parse tree produced by {@link CPPParser#noPointerAbstractDeclarator}.
	 * @param ctx the parse tree
	 */
	void enterNoPointerAbstractDeclarator(CPPParser.NoPointerAbstractDeclaratorContext ctx);
	/**
	 * Exit a parse tree produced by {@link CPPParser#noPointerAbstractDeclarator}.
	 * @param ctx the parse tree
	 */
	void exitNoPointerAbstractDeclarator(CPPParser.NoPointerAbstractDeclaratorContext ctx);
	/**
	 * Enter a parse tree produced by {@link CPPParser#abstractPackDeclarator}.
	 * @param ctx the parse tree
	 */
	void enterAbstractPackDeclarator(CPPParser.AbstractPackDeclaratorContext ctx);
	/**
	 * Exit a parse tree produced by {@link CPPParser#abstractPackDeclarator}.
	 * @param ctx the parse tree
	 */
	void exitAbstractPackDeclarator(CPPParser.AbstractPackDeclaratorContext ctx);
	/**
	 * Enter a parse tree produced by {@link CPPParser#noPointerAbstractPackDeclarator}.
	 * @param ctx the parse tree
	 */
	void enterNoPointerAbstractPackDeclarator(CPPParser.NoPointerAbstractPackDeclaratorContext ctx);
	/**
	 * Exit a parse tree produced by {@link CPPParser#noPointerAbstractPackDeclarator}.
	 * @param ctx the parse tree
	 */
	void exitNoPointerAbstractPackDeclarator(CPPParser.NoPointerAbstractPackDeclaratorContext ctx);
	/**
	 * Enter a parse tree produced by {@link CPPParser#parameterDeclarationClause}.
	 * @param ctx the parse tree
	 */
	void enterParameterDeclarationClause(CPPParser.ParameterDeclarationClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link CPPParser#parameterDeclarationClause}.
	 * @param ctx the parse tree
	 */
	void exitParameterDeclarationClause(CPPParser.ParameterDeclarationClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link CPPParser#parameterDeclarationList}.
	 * @param ctx the parse tree
	 */
	void enterParameterDeclarationList(CPPParser.ParameterDeclarationListContext ctx);
	/**
	 * Exit a parse tree produced by {@link CPPParser#parameterDeclarationList}.
	 * @param ctx the parse tree
	 */
	void exitParameterDeclarationList(CPPParser.ParameterDeclarationListContext ctx);
	/**
	 * Enter a parse tree produced by {@link CPPParser#parameterDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterParameterDeclaration(CPPParser.ParameterDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link CPPParser#parameterDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitParameterDeclaration(CPPParser.ParameterDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link CPPParser#functionDefinition}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDefinition(CPPParser.FunctionDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CPPParser#functionDefinition}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDefinition(CPPParser.FunctionDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CPPParser#functionBody}.
	 * @param ctx the parse tree
	 */
	void enterFunctionBody(CPPParser.FunctionBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link CPPParser#functionBody}.
	 * @param ctx the parse tree
	 */
	void exitFunctionBody(CPPParser.FunctionBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link CPPParser#initializer}.
	 * @param ctx the parse tree
	 */
	void enterInitializer(CPPParser.InitializerContext ctx);
	/**
	 * Exit a parse tree produced by {@link CPPParser#initializer}.
	 * @param ctx the parse tree
	 */
	void exitInitializer(CPPParser.InitializerContext ctx);
	/**
	 * Enter a parse tree produced by {@link CPPParser#braceOrEqualInitializer}.
	 * @param ctx the parse tree
	 */
	void enterBraceOrEqualInitializer(CPPParser.BraceOrEqualInitializerContext ctx);
	/**
	 * Exit a parse tree produced by {@link CPPParser#braceOrEqualInitializer}.
	 * @param ctx the parse tree
	 */
	void exitBraceOrEqualInitializer(CPPParser.BraceOrEqualInitializerContext ctx);
	/**
	 * Enter a parse tree produced by {@link CPPParser#initializerClause}.
	 * @param ctx the parse tree
	 */
	void enterInitializerClause(CPPParser.InitializerClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link CPPParser#initializerClause}.
	 * @param ctx the parse tree
	 */
	void exitInitializerClause(CPPParser.InitializerClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link CPPParser#initializerList}.
	 * @param ctx the parse tree
	 */
	void enterInitializerList(CPPParser.InitializerListContext ctx);
	/**
	 * Exit a parse tree produced by {@link CPPParser#initializerList}.
	 * @param ctx the parse tree
	 */
	void exitInitializerList(CPPParser.InitializerListContext ctx);
	/**
	 * Enter a parse tree produced by {@link CPPParser#bracedInitList}.
	 * @param ctx the parse tree
	 */
	void enterBracedInitList(CPPParser.BracedInitListContext ctx);
	/**
	 * Exit a parse tree produced by {@link CPPParser#bracedInitList}.
	 * @param ctx the parse tree
	 */
	void exitBracedInitList(CPPParser.BracedInitListContext ctx);
	/**
	 * Enter a parse tree produced by {@link CPPParser#className}.
	 * @param ctx the parse tree
	 */
	void enterClassName(CPPParser.ClassNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link CPPParser#className}.
	 * @param ctx the parse tree
	 */
	void exitClassName(CPPParser.ClassNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link CPPParser#classSpecifier}.
	 * @param ctx the parse tree
	 */
	void enterClassSpecifier(CPPParser.ClassSpecifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link CPPParser#classSpecifier}.
	 * @param ctx the parse tree
	 */
	void exitClassSpecifier(CPPParser.ClassSpecifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link CPPParser#classHead}.
	 * @param ctx the parse tree
	 */
	void enterClassHead(CPPParser.ClassHeadContext ctx);
	/**
	 * Exit a parse tree produced by {@link CPPParser#classHead}.
	 * @param ctx the parse tree
	 */
	void exitClassHead(CPPParser.ClassHeadContext ctx);
	/**
	 * Enter a parse tree produced by {@link CPPParser#classHeadName}.
	 * @param ctx the parse tree
	 */
	void enterClassHeadName(CPPParser.ClassHeadNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link CPPParser#classHeadName}.
	 * @param ctx the parse tree
	 */
	void exitClassHeadName(CPPParser.ClassHeadNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link CPPParser#classVirtSpecifier}.
	 * @param ctx the parse tree
	 */
	void enterClassVirtSpecifier(CPPParser.ClassVirtSpecifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link CPPParser#classVirtSpecifier}.
	 * @param ctx the parse tree
	 */
	void exitClassVirtSpecifier(CPPParser.ClassVirtSpecifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link CPPParser#classKey}.
	 * @param ctx the parse tree
	 */
	void enterClassKey(CPPParser.ClassKeyContext ctx);
	/**
	 * Exit a parse tree produced by {@link CPPParser#classKey}.
	 * @param ctx the parse tree
	 */
	void exitClassKey(CPPParser.ClassKeyContext ctx);
	/**
	 * Enter a parse tree produced by {@link CPPParser#memberSpecification}.
	 * @param ctx the parse tree
	 */
	void enterMemberSpecification(CPPParser.MemberSpecificationContext ctx);
	/**
	 * Exit a parse tree produced by {@link CPPParser#memberSpecification}.
	 * @param ctx the parse tree
	 */
	void exitMemberSpecification(CPPParser.MemberSpecificationContext ctx);
	/**
	 * Enter a parse tree produced by {@link CPPParser#memberdeclaration}.
	 * @param ctx the parse tree
	 */
	void enterMemberdeclaration(CPPParser.MemberdeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link CPPParser#memberdeclaration}.
	 * @param ctx the parse tree
	 */
	void exitMemberdeclaration(CPPParser.MemberdeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link CPPParser#memberDeclaratorList}.
	 * @param ctx the parse tree
	 */
	void enterMemberDeclaratorList(CPPParser.MemberDeclaratorListContext ctx);
	/**
	 * Exit a parse tree produced by {@link CPPParser#memberDeclaratorList}.
	 * @param ctx the parse tree
	 */
	void exitMemberDeclaratorList(CPPParser.MemberDeclaratorListContext ctx);
	/**
	 * Enter a parse tree produced by {@link CPPParser#memberDeclarator}.
	 * @param ctx the parse tree
	 */
	void enterMemberDeclarator(CPPParser.MemberDeclaratorContext ctx);
	/**
	 * Exit a parse tree produced by {@link CPPParser#memberDeclarator}.
	 * @param ctx the parse tree
	 */
	void exitMemberDeclarator(CPPParser.MemberDeclaratorContext ctx);
	/**
	 * Enter a parse tree produced by {@link CPPParser#virtualSpecifierSeq}.
	 * @param ctx the parse tree
	 */
	void enterVirtualSpecifierSeq(CPPParser.VirtualSpecifierSeqContext ctx);
	/**
	 * Exit a parse tree produced by {@link CPPParser#virtualSpecifierSeq}.
	 * @param ctx the parse tree
	 */
	void exitVirtualSpecifierSeq(CPPParser.VirtualSpecifierSeqContext ctx);
	/**
	 * Enter a parse tree produced by {@link CPPParser#virtualSpecifier}.
	 * @param ctx the parse tree
	 */
	void enterVirtualSpecifier(CPPParser.VirtualSpecifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link CPPParser#virtualSpecifier}.
	 * @param ctx the parse tree
	 */
	void exitVirtualSpecifier(CPPParser.VirtualSpecifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link CPPParser#pureSpecifier}.
	 * @param ctx the parse tree
	 */
	void enterPureSpecifier(CPPParser.PureSpecifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link CPPParser#pureSpecifier}.
	 * @param ctx the parse tree
	 */
	void exitPureSpecifier(CPPParser.PureSpecifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link CPPParser#baseClause}.
	 * @param ctx the parse tree
	 */
	void enterBaseClause(CPPParser.BaseClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link CPPParser#baseClause}.
	 * @param ctx the parse tree
	 */
	void exitBaseClause(CPPParser.BaseClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link CPPParser#baseSpecifierList}.
	 * @param ctx the parse tree
	 */
	void enterBaseSpecifierList(CPPParser.BaseSpecifierListContext ctx);
	/**
	 * Exit a parse tree produced by {@link CPPParser#baseSpecifierList}.
	 * @param ctx the parse tree
	 */
	void exitBaseSpecifierList(CPPParser.BaseSpecifierListContext ctx);
	/**
	 * Enter a parse tree produced by {@link CPPParser#baseSpecifier}.
	 * @param ctx the parse tree
	 */
	void enterBaseSpecifier(CPPParser.BaseSpecifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link CPPParser#baseSpecifier}.
	 * @param ctx the parse tree
	 */
	void exitBaseSpecifier(CPPParser.BaseSpecifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link CPPParser#classOrDeclType}.
	 * @param ctx the parse tree
	 */
	void enterClassOrDeclType(CPPParser.ClassOrDeclTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link CPPParser#classOrDeclType}.
	 * @param ctx the parse tree
	 */
	void exitClassOrDeclType(CPPParser.ClassOrDeclTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link CPPParser#baseTypeSpecifier}.
	 * @param ctx the parse tree
	 */
	void enterBaseTypeSpecifier(CPPParser.BaseTypeSpecifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link CPPParser#baseTypeSpecifier}.
	 * @param ctx the parse tree
	 */
	void exitBaseTypeSpecifier(CPPParser.BaseTypeSpecifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link CPPParser#accessSpecifier}.
	 * @param ctx the parse tree
	 */
	void enterAccessSpecifier(CPPParser.AccessSpecifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link CPPParser#accessSpecifier}.
	 * @param ctx the parse tree
	 */
	void exitAccessSpecifier(CPPParser.AccessSpecifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link CPPParser#conversionFunctionId}.
	 * @param ctx the parse tree
	 */
	void enterConversionFunctionId(CPPParser.ConversionFunctionIdContext ctx);
	/**
	 * Exit a parse tree produced by {@link CPPParser#conversionFunctionId}.
	 * @param ctx the parse tree
	 */
	void exitConversionFunctionId(CPPParser.ConversionFunctionIdContext ctx);
	/**
	 * Enter a parse tree produced by {@link CPPParser#conversionTypeId}.
	 * @param ctx the parse tree
	 */
	void enterConversionTypeId(CPPParser.ConversionTypeIdContext ctx);
	/**
	 * Exit a parse tree produced by {@link CPPParser#conversionTypeId}.
	 * @param ctx the parse tree
	 */
	void exitConversionTypeId(CPPParser.ConversionTypeIdContext ctx);
	/**
	 * Enter a parse tree produced by {@link CPPParser#conversionDeclarator}.
	 * @param ctx the parse tree
	 */
	void enterConversionDeclarator(CPPParser.ConversionDeclaratorContext ctx);
	/**
	 * Exit a parse tree produced by {@link CPPParser#conversionDeclarator}.
	 * @param ctx the parse tree
	 */
	void exitConversionDeclarator(CPPParser.ConversionDeclaratorContext ctx);
	/**
	 * Enter a parse tree produced by {@link CPPParser#constructorInitializer}.
	 * @param ctx the parse tree
	 */
	void enterConstructorInitializer(CPPParser.ConstructorInitializerContext ctx);
	/**
	 * Exit a parse tree produced by {@link CPPParser#constructorInitializer}.
	 * @param ctx the parse tree
	 */
	void exitConstructorInitializer(CPPParser.ConstructorInitializerContext ctx);
	/**
	 * Enter a parse tree produced by {@link CPPParser#memInitializerList}.
	 * @param ctx the parse tree
	 */
	void enterMemInitializerList(CPPParser.MemInitializerListContext ctx);
	/**
	 * Exit a parse tree produced by {@link CPPParser#memInitializerList}.
	 * @param ctx the parse tree
	 */
	void exitMemInitializerList(CPPParser.MemInitializerListContext ctx);
	/**
	 * Enter a parse tree produced by {@link CPPParser#memInitializer}.
	 * @param ctx the parse tree
	 */
	void enterMemInitializer(CPPParser.MemInitializerContext ctx);
	/**
	 * Exit a parse tree produced by {@link CPPParser#memInitializer}.
	 * @param ctx the parse tree
	 */
	void exitMemInitializer(CPPParser.MemInitializerContext ctx);
	/**
	 * Enter a parse tree produced by {@link CPPParser#meminitializerid}.
	 * @param ctx the parse tree
	 */
	void enterMeminitializerid(CPPParser.MeminitializeridContext ctx);
	/**
	 * Exit a parse tree produced by {@link CPPParser#meminitializerid}.
	 * @param ctx the parse tree
	 */
	void exitMeminitializerid(CPPParser.MeminitializeridContext ctx);
	/**
	 * Enter a parse tree produced by {@link CPPParser#operatorFunctionId}.
	 * @param ctx the parse tree
	 */
	void enterOperatorFunctionId(CPPParser.OperatorFunctionIdContext ctx);
	/**
	 * Exit a parse tree produced by {@link CPPParser#operatorFunctionId}.
	 * @param ctx the parse tree
	 */
	void exitOperatorFunctionId(CPPParser.OperatorFunctionIdContext ctx);
	/**
	 * Enter a parse tree produced by {@link CPPParser#literalOperatorId}.
	 * @param ctx the parse tree
	 */
	void enterLiteralOperatorId(CPPParser.LiteralOperatorIdContext ctx);
	/**
	 * Exit a parse tree produced by {@link CPPParser#literalOperatorId}.
	 * @param ctx the parse tree
	 */
	void exitLiteralOperatorId(CPPParser.LiteralOperatorIdContext ctx);
	/**
	 * Enter a parse tree produced by {@link CPPParser#templateDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterTemplateDeclaration(CPPParser.TemplateDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link CPPParser#templateDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitTemplateDeclaration(CPPParser.TemplateDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link CPPParser#templateparameterList}.
	 * @param ctx the parse tree
	 */
	void enterTemplateparameterList(CPPParser.TemplateparameterListContext ctx);
	/**
	 * Exit a parse tree produced by {@link CPPParser#templateparameterList}.
	 * @param ctx the parse tree
	 */
	void exitTemplateparameterList(CPPParser.TemplateparameterListContext ctx);
	/**
	 * Enter a parse tree produced by {@link CPPParser#templateParameter}.
	 * @param ctx the parse tree
	 */
	void enterTemplateParameter(CPPParser.TemplateParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link CPPParser#templateParameter}.
	 * @param ctx the parse tree
	 */
	void exitTemplateParameter(CPPParser.TemplateParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link CPPParser#typeParameter}.
	 * @param ctx the parse tree
	 */
	void enterTypeParameter(CPPParser.TypeParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link CPPParser#typeParameter}.
	 * @param ctx the parse tree
	 */
	void exitTypeParameter(CPPParser.TypeParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link CPPParser#simpleTemplateId}.
	 * @param ctx the parse tree
	 */
	void enterSimpleTemplateId(CPPParser.SimpleTemplateIdContext ctx);
	/**
	 * Exit a parse tree produced by {@link CPPParser#simpleTemplateId}.
	 * @param ctx the parse tree
	 */
	void exitSimpleTemplateId(CPPParser.SimpleTemplateIdContext ctx);
	/**
	 * Enter a parse tree produced by {@link CPPParser#templateId}.
	 * @param ctx the parse tree
	 */
	void enterTemplateId(CPPParser.TemplateIdContext ctx);
	/**
	 * Exit a parse tree produced by {@link CPPParser#templateId}.
	 * @param ctx the parse tree
	 */
	void exitTemplateId(CPPParser.TemplateIdContext ctx);
	/**
	 * Enter a parse tree produced by {@link CPPParser#templateName}.
	 * @param ctx the parse tree
	 */
	void enterTemplateName(CPPParser.TemplateNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link CPPParser#templateName}.
	 * @param ctx the parse tree
	 */
	void exitTemplateName(CPPParser.TemplateNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link CPPParser#templateArgumentList}.
	 * @param ctx the parse tree
	 */
	void enterTemplateArgumentList(CPPParser.TemplateArgumentListContext ctx);
	/**
	 * Exit a parse tree produced by {@link CPPParser#templateArgumentList}.
	 * @param ctx the parse tree
	 */
	void exitTemplateArgumentList(CPPParser.TemplateArgumentListContext ctx);
	/**
	 * Enter a parse tree produced by {@link CPPParser#templateArgument}.
	 * @param ctx the parse tree
	 */
	void enterTemplateArgument(CPPParser.TemplateArgumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link CPPParser#templateArgument}.
	 * @param ctx the parse tree
	 */
	void exitTemplateArgument(CPPParser.TemplateArgumentContext ctx);
	/**
	 * Enter a parse tree produced by {@link CPPParser#typeNameSpecifier}.
	 * @param ctx the parse tree
	 */
	void enterTypeNameSpecifier(CPPParser.TypeNameSpecifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link CPPParser#typeNameSpecifier}.
	 * @param ctx the parse tree
	 */
	void exitTypeNameSpecifier(CPPParser.TypeNameSpecifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link CPPParser#explicitInstantiation}.
	 * @param ctx the parse tree
	 */
	void enterExplicitInstantiation(CPPParser.ExplicitInstantiationContext ctx);
	/**
	 * Exit a parse tree produced by {@link CPPParser#explicitInstantiation}.
	 * @param ctx the parse tree
	 */
	void exitExplicitInstantiation(CPPParser.ExplicitInstantiationContext ctx);
	/**
	 * Enter a parse tree produced by {@link CPPParser#explicitSpecialization}.
	 * @param ctx the parse tree
	 */
	void enterExplicitSpecialization(CPPParser.ExplicitSpecializationContext ctx);
	/**
	 * Exit a parse tree produced by {@link CPPParser#explicitSpecialization}.
	 * @param ctx the parse tree
	 */
	void exitExplicitSpecialization(CPPParser.ExplicitSpecializationContext ctx);
	/**
	 * Enter a parse tree produced by {@link CPPParser#tryBlock}.
	 * @param ctx the parse tree
	 */
	void enterTryBlock(CPPParser.TryBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link CPPParser#tryBlock}.
	 * @param ctx the parse tree
	 */
	void exitTryBlock(CPPParser.TryBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link CPPParser#functionTryBlock}.
	 * @param ctx the parse tree
	 */
	void enterFunctionTryBlock(CPPParser.FunctionTryBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link CPPParser#functionTryBlock}.
	 * @param ctx the parse tree
	 */
	void exitFunctionTryBlock(CPPParser.FunctionTryBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link CPPParser#handlerSeq}.
	 * @param ctx the parse tree
	 */
	void enterHandlerSeq(CPPParser.HandlerSeqContext ctx);
	/**
	 * Exit a parse tree produced by {@link CPPParser#handlerSeq}.
	 * @param ctx the parse tree
	 */
	void exitHandlerSeq(CPPParser.HandlerSeqContext ctx);
	/**
	 * Enter a parse tree produced by {@link CPPParser#handler}.
	 * @param ctx the parse tree
	 */
	void enterHandler(CPPParser.HandlerContext ctx);
	/**
	 * Exit a parse tree produced by {@link CPPParser#handler}.
	 * @param ctx the parse tree
	 */
	void exitHandler(CPPParser.HandlerContext ctx);
	/**
	 * Enter a parse tree produced by {@link CPPParser#exceptionDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterExceptionDeclaration(CPPParser.ExceptionDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link CPPParser#exceptionDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitExceptionDeclaration(CPPParser.ExceptionDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link CPPParser#throwExpression}.
	 * @param ctx the parse tree
	 */
	void enterThrowExpression(CPPParser.ThrowExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CPPParser#throwExpression}.
	 * @param ctx the parse tree
	 */
	void exitThrowExpression(CPPParser.ThrowExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CPPParser#exceptionSpecification}.
	 * @param ctx the parse tree
	 */
	void enterExceptionSpecification(CPPParser.ExceptionSpecificationContext ctx);
	/**
	 * Exit a parse tree produced by {@link CPPParser#exceptionSpecification}.
	 * @param ctx the parse tree
	 */
	void exitExceptionSpecification(CPPParser.ExceptionSpecificationContext ctx);
	/**
	 * Enter a parse tree produced by {@link CPPParser#dynamicExceptionSpecification}.
	 * @param ctx the parse tree
	 */
	void enterDynamicExceptionSpecification(CPPParser.DynamicExceptionSpecificationContext ctx);
	/**
	 * Exit a parse tree produced by {@link CPPParser#dynamicExceptionSpecification}.
	 * @param ctx the parse tree
	 */
	void exitDynamicExceptionSpecification(CPPParser.DynamicExceptionSpecificationContext ctx);
	/**
	 * Enter a parse tree produced by {@link CPPParser#typeIdList}.
	 * @param ctx the parse tree
	 */
	void enterTypeIdList(CPPParser.TypeIdListContext ctx);
	/**
	 * Exit a parse tree produced by {@link CPPParser#typeIdList}.
	 * @param ctx the parse tree
	 */
	void exitTypeIdList(CPPParser.TypeIdListContext ctx);
	/**
	 * Enter a parse tree produced by {@link CPPParser#noeExceptSpecification}.
	 * @param ctx the parse tree
	 */
	void enterNoeExceptSpecification(CPPParser.NoeExceptSpecificationContext ctx);
	/**
	 * Exit a parse tree produced by {@link CPPParser#noeExceptSpecification}.
	 * @param ctx the parse tree
	 */
	void exitNoeExceptSpecification(CPPParser.NoeExceptSpecificationContext ctx);
	/**
	 * Enter a parse tree produced by {@link CPPParser#theOperator}.
	 * @param ctx the parse tree
	 */
	void enterTheOperator(CPPParser.TheOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link CPPParser#theOperator}.
	 * @param ctx the parse tree
	 */
	void exitTheOperator(CPPParser.TheOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link CPPParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(CPPParser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link CPPParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(CPPParser.LiteralContext ctx);
}