package org.example.parser.java.antlr;// Generated from C:/Users/pity/IdeaProjects/code-style-transfer/src/main/antlr4/JavaParser.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link JavaParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface JavaParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link JavaParser#compilationUnit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompilationUnit(JavaParser.CompilationUnitContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaParser#importDeclarationList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImportDeclarationList(JavaParser.ImportDeclarationListContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaParser#typeDeclarationList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeDeclarationList(JavaParser.TypeDeclarationListContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaParser#packageDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPackageDeclaration(JavaParser.PackageDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaParser#importDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImportDeclaration(JavaParser.ImportDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaParser#modifierList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModifierList(JavaParser.ModifierListContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaParser#typeDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeDeclaration(JavaParser.TypeDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaParser#classHead}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassHead(JavaParser.ClassHeadContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaParser#interfaceHead}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInterfaceHead(JavaParser.InterfaceHeadContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaParser#recordHead}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRecordHead(JavaParser.RecordHeadContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaParser#enumHead}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumHead(JavaParser.EnumHeadContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaParser#annotationTypeHead}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnnotationTypeHead(JavaParser.AnnotationTypeHeadContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaParser#body}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBody(JavaParser.BodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaParser#typeParameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeParameters(JavaParser.TypeParametersContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaParser#typeParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeParameter(JavaParser.TypeParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaParser#typeBound}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeBound(JavaParser.TypeBoundContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaParser#enumConstants}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumConstants(JavaParser.EnumConstantsContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaParser#enumConstant}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumConstant(JavaParser.EnumConstantContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaParser#classBodyDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassBodyDeclaration(JavaParser.ClassBodyDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaParser#initializer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInitializer(JavaParser.InitializerContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaParser#initializerList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInitializerList(JavaParser.InitializerListContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaParser#fieldDeclarationList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldDeclarationList(JavaParser.FieldDeclarationListContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaParser#constructorDeclarationList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstructorDeclarationList(JavaParser.ConstructorDeclarationListContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaParser#methodDeclarationList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodDeclarationList(JavaParser.MethodDeclarationListContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaParser#methodDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodDeclaration(JavaParser.MethodDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaParser#methodHead}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodHead(JavaParser.MethodHeadContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaParser#constructorDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstructorDeclaration(JavaParser.ConstructorDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaParser#constructorHead}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstructorHead(JavaParser.ConstructorHeadContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaParser#fieldDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldDeclaration(JavaParser.FieldDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaParser#constDeclarationList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstDeclarationList(JavaParser.ConstDeclarationListContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaParser#constDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstDeclaration(JavaParser.ConstDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaParser#constantDeclarator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstantDeclarator(JavaParser.ConstantDeclaratorContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaParser#variableDeclarators}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDeclarators(JavaParser.VariableDeclaratorsContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaParser#variableDeclarator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDeclarator(JavaParser.VariableDeclaratorContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaParser#variableDeclaratorId}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDeclaratorId(JavaParser.VariableDeclaratorIdContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaParser#variableInitializer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableInitializer(JavaParser.VariableInitializerContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaParser#arrayInitializer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayInitializer(JavaParser.ArrayInitializerContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaParser#classOrInterfaceType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassOrInterfaceType(JavaParser.ClassOrInterfaceTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaParser#typeArgument}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeArgument(JavaParser.TypeArgumentContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaParser#qualifiedNameList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQualifiedNameList(JavaParser.QualifiedNameListContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaParser#formalParameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormalParameters(JavaParser.FormalParametersContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaParser#receiverParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReceiverParameter(JavaParser.ReceiverParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaParser#formalParameterList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormalParameterList(JavaParser.FormalParameterListContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaParser#formalParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormalParameter(JavaParser.FormalParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaParser#lastFormalParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLastFormalParameter(JavaParser.LastFormalParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaParser#lambdaLVTIList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLambdaLVTIList(JavaParser.LambdaLVTIListContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaParser#lambdaLVTIParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLambdaLVTIParameter(JavaParser.LambdaLVTIParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaParser#qualifiedName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQualifiedName(JavaParser.QualifiedNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(JavaParser.LiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaParser#integerLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntegerLiteral(JavaParser.IntegerLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaParser#floatLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFloatLiteral(JavaParser.FloatLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaParser#altAnnotationQualifiedName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAltAnnotationQualifiedName(JavaParser.AltAnnotationQualifiedNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaParser#annotationList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnnotationList(JavaParser.AnnotationListContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaParser#annotation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnnotation(JavaParser.AnnotationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaParser#elementValuePairs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElementValuePairs(JavaParser.ElementValuePairsContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaParser#elementValuePair}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElementValuePair(JavaParser.ElementValuePairContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaParser#elementValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElementValue(JavaParser.ElementValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaParser#elementValueArrayInitializer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElementValueArrayInitializer(JavaParser.ElementValueArrayInitializerContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaParser#annotationTypeElementDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnnotationTypeElementDeclaration(JavaParser.AnnotationTypeElementDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaParser#annotationTypeElementRest}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnnotationTypeElementRest(JavaParser.AnnotationTypeElementRestContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaParser#annotationMethodOrConstantRest}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnnotationMethodOrConstantRest(JavaParser.AnnotationMethodOrConstantRestContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaParser#annotationMethodRest}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnnotationMethodRest(JavaParser.AnnotationMethodRestContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaParser#annotationConstantRest}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnnotationConstantRest(JavaParser.AnnotationConstantRestContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaParser#defaultValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefaultValue(JavaParser.DefaultValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaParser#moduleDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModuleDeclaration(JavaParser.ModuleDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaParser#moduleDirective}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModuleDirective(JavaParser.ModuleDirectiveContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaParser#requiresModifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRequiresModifier(JavaParser.RequiresModifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaParser#recordHeader}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRecordHeader(JavaParser.RecordHeaderContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaParser#recordComponentList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRecordComponentList(JavaParser.RecordComponentListContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaParser#recordComponent}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRecordComponent(JavaParser.RecordComponentContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(JavaParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaParser#switchBlockStatementGroup}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSwitchBlockStatementGroup(JavaParser.SwitchBlockStatementGroupContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaParser#localVariableDeclarationStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocalVariableDeclarationStmt(JavaParser.LocalVariableDeclarationStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaParser#localVariableDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocalVariableDeclaration(JavaParser.LocalVariableDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaParser#identifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifier(JavaParser.IdentifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaParser#typeIdentifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeIdentifier(JavaParser.TypeIdentifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(JavaParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaParser#assertStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssertStmt(JavaParser.AssertStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaParser#ifStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStmt(JavaParser.IfStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaParser#ifElseStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfElseStmt(JavaParser.IfElseStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaParser#forStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForStmt(JavaParser.ForStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaParser#whileStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStmt(JavaParser.WhileStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaParser#doWhileStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoWhileStmt(JavaParser.DoWhileStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaParser#tryCatchStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTryCatchStmt(JavaParser.TryCatchStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaParser#tryResourceStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTryResourceStmt(JavaParser.TryResourceStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaParser#switchStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSwitchStmt(JavaParser.SwitchStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaParser#syncStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSyncStmt(JavaParser.SyncStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaParser#returnStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStmt(JavaParser.ReturnStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaParser#throwStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitThrowStmt(JavaParser.ThrowStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaParser#breakStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBreakStmt(JavaParser.BreakStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaParser#continueStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContinueStmt(JavaParser.ContinueStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaParser#yieldStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitYieldStmt(JavaParser.YieldStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaParser#expressionStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionStmt(JavaParser.ExpressionStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaParser#labelStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLabelStmt(JavaParser.LabelStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaParser#catchClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCatchClause(JavaParser.CatchClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaParser#catchType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCatchType(JavaParser.CatchTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaParser#finallyBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFinallyBlock(JavaParser.FinallyBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaParser#resourceSpecification}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitResourceSpecification(JavaParser.ResourceSpecificationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaParser#resources}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitResources(JavaParser.ResourcesContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaParser#resource}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitResource(JavaParser.ResourceContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaParser#switchLabel}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSwitchLabel(JavaParser.SwitchLabelContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaParser#forControl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForControl(JavaParser.ForControlContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaParser#forInit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForInit(JavaParser.ForInitContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaParser#enhancedForControl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnhancedForControl(JavaParser.EnhancedForControlContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaParser#parExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParExpression(JavaParser.ParExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaParser#expressionList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionList(JavaParser.ExpressionListContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaParser#methodCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodCall(JavaParser.MethodCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(JavaParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaParser#pattern}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPattern(JavaParser.PatternContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaParser#lambdaExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLambdaExpression(JavaParser.LambdaExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaParser#lambdaParameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLambdaParameters(JavaParser.LambdaParametersContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaParser#lambdaBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLambdaBody(JavaParser.LambdaBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaParser#switchLabeledRule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSwitchLabeledRule(JavaParser.SwitchLabeledRuleContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaParser#guardedPattern}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGuardedPattern(JavaParser.GuardedPatternContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaParser#classType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassType(JavaParser.ClassTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaParser#creator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreator(JavaParser.CreatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaParser#createdName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreatedName(JavaParser.CreatedNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaParser#innerCreator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInnerCreator(JavaParser.InnerCreatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaParser#arrayCreatorRest}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayCreatorRest(JavaParser.ArrayCreatorRestContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaParser#classCreatorRest}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassCreatorRest(JavaParser.ClassCreatorRestContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaParser#explicitGenericInvocation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExplicitGenericInvocation(JavaParser.ExplicitGenericInvocationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaParser#typeArgumentsOrDiamond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeArgumentsOrDiamond(JavaParser.TypeArgumentsOrDiamondContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaParser#nonWildcardTypeArguments}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNonWildcardTypeArguments(JavaParser.NonWildcardTypeArgumentsContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaParser#typeList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeList(JavaParser.TypeListContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaParser#typeType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeType(JavaParser.TypeTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaParser#primitiveType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimitiveType(JavaParser.PrimitiveTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaParser#typeArguments}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeArguments(JavaParser.TypeArgumentsContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaParser#superSuffix}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSuperSuffix(JavaParser.SuperSuffixContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaParser#explicitGenericInvocationSuffix}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExplicitGenericInvocationSuffix(JavaParser.ExplicitGenericInvocationSuffixContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaParser#arguments}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArguments(JavaParser.ArgumentsContext ctx);
}