// Generated from C:/Users/pity/IdeaProjects/code-style-transfer/src/main/antlr4/JavaParser.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link JavaParser}.
 */
public interface JavaParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link JavaParser#compilationUnit}.
	 * @param ctx the parse tree
	 */
	void enterCompilationUnit(JavaParser.CompilationUnitContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#compilationUnit}.
	 * @param ctx the parse tree
	 */
	void exitCompilationUnit(JavaParser.CompilationUnitContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaParser#importDeclarationList}.
	 * @param ctx the parse tree
	 */
	void enterImportDeclarationList(JavaParser.ImportDeclarationListContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#importDeclarationList}.
	 * @param ctx the parse tree
	 */
	void exitImportDeclarationList(JavaParser.ImportDeclarationListContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaParser#typeDeclarationList}.
	 * @param ctx the parse tree
	 */
	void enterTypeDeclarationList(JavaParser.TypeDeclarationListContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#typeDeclarationList}.
	 * @param ctx the parse tree
	 */
	void exitTypeDeclarationList(JavaParser.TypeDeclarationListContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaParser#packageDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterPackageDeclaration(JavaParser.PackageDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#packageDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitPackageDeclaration(JavaParser.PackageDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaParser#importDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterImportDeclaration(JavaParser.ImportDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#importDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitImportDeclaration(JavaParser.ImportDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaParser#modifierList}.
	 * @param ctx the parse tree
	 */
	void enterModifierList(JavaParser.ModifierListContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#modifierList}.
	 * @param ctx the parse tree
	 */
	void exitModifierList(JavaParser.ModifierListContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaParser#typeDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterTypeDeclaration(JavaParser.TypeDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#typeDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitTypeDeclaration(JavaParser.TypeDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaParser#classHead}.
	 * @param ctx the parse tree
	 */
	void enterClassHead(JavaParser.ClassHeadContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#classHead}.
	 * @param ctx the parse tree
	 */
	void exitClassHead(JavaParser.ClassHeadContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaParser#interfaceHead}.
	 * @param ctx the parse tree
	 */
	void enterInterfaceHead(JavaParser.InterfaceHeadContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#interfaceHead}.
	 * @param ctx the parse tree
	 */
	void exitInterfaceHead(JavaParser.InterfaceHeadContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaParser#recordHead}.
	 * @param ctx the parse tree
	 */
	void enterRecordHead(JavaParser.RecordHeadContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#recordHead}.
	 * @param ctx the parse tree
	 */
	void exitRecordHead(JavaParser.RecordHeadContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaParser#enumHead}.
	 * @param ctx the parse tree
	 */
	void enterEnumHead(JavaParser.EnumHeadContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#enumHead}.
	 * @param ctx the parse tree
	 */
	void exitEnumHead(JavaParser.EnumHeadContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaParser#annotationTypeHead}.
	 * @param ctx the parse tree
	 */
	void enterAnnotationTypeHead(JavaParser.AnnotationTypeHeadContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#annotationTypeHead}.
	 * @param ctx the parse tree
	 */
	void exitAnnotationTypeHead(JavaParser.AnnotationTypeHeadContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaParser#body}.
	 * @param ctx the parse tree
	 */
	void enterBody(JavaParser.BodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#body}.
	 * @param ctx the parse tree
	 */
	void exitBody(JavaParser.BodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaParser#typeParameters}.
	 * @param ctx the parse tree
	 */
	void enterTypeParameters(JavaParser.TypeParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#typeParameters}.
	 * @param ctx the parse tree
	 */
	void exitTypeParameters(JavaParser.TypeParametersContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaParser#typeParameter}.
	 * @param ctx the parse tree
	 */
	void enterTypeParameter(JavaParser.TypeParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#typeParameter}.
	 * @param ctx the parse tree
	 */
	void exitTypeParameter(JavaParser.TypeParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaParser#typeBound}.
	 * @param ctx the parse tree
	 */
	void enterTypeBound(JavaParser.TypeBoundContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#typeBound}.
	 * @param ctx the parse tree
	 */
	void exitTypeBound(JavaParser.TypeBoundContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaParser#enumConstants}.
	 * @param ctx the parse tree
	 */
	void enterEnumConstants(JavaParser.EnumConstantsContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#enumConstants}.
	 * @param ctx the parse tree
	 */
	void exitEnumConstants(JavaParser.EnumConstantsContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaParser#enumConstant}.
	 * @param ctx the parse tree
	 */
	void enterEnumConstant(JavaParser.EnumConstantContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#enumConstant}.
	 * @param ctx the parse tree
	 */
	void exitEnumConstant(JavaParser.EnumConstantContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaParser#classBodyDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterClassBodyDeclaration(JavaParser.ClassBodyDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#classBodyDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitClassBodyDeclaration(JavaParser.ClassBodyDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaParser#initializer}.
	 * @param ctx the parse tree
	 */
	void enterInitializer(JavaParser.InitializerContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#initializer}.
	 * @param ctx the parse tree
	 */
	void exitInitializer(JavaParser.InitializerContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaParser#initializerList}.
	 * @param ctx the parse tree
	 */
	void enterInitializerList(JavaParser.InitializerListContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#initializerList}.
	 * @param ctx the parse tree
	 */
	void exitInitializerList(JavaParser.InitializerListContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaParser#fieldDeclarationList}.
	 * @param ctx the parse tree
	 */
	void enterFieldDeclarationList(JavaParser.FieldDeclarationListContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#fieldDeclarationList}.
	 * @param ctx the parse tree
	 */
	void exitFieldDeclarationList(JavaParser.FieldDeclarationListContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaParser#constructorDeclarationList}.
	 * @param ctx the parse tree
	 */
	void enterConstructorDeclarationList(JavaParser.ConstructorDeclarationListContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#constructorDeclarationList}.
	 * @param ctx the parse tree
	 */
	void exitConstructorDeclarationList(JavaParser.ConstructorDeclarationListContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaParser#methodDeclarationList}.
	 * @param ctx the parse tree
	 */
	void enterMethodDeclarationList(JavaParser.MethodDeclarationListContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#methodDeclarationList}.
	 * @param ctx the parse tree
	 */
	void exitMethodDeclarationList(JavaParser.MethodDeclarationListContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaParser#methodDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterMethodDeclaration(JavaParser.MethodDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#methodDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitMethodDeclaration(JavaParser.MethodDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaParser#methodHead}.
	 * @param ctx the parse tree
	 */
	void enterMethodHead(JavaParser.MethodHeadContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#methodHead}.
	 * @param ctx the parse tree
	 */
	void exitMethodHead(JavaParser.MethodHeadContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaParser#constructorDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterConstructorDeclaration(JavaParser.ConstructorDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#constructorDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitConstructorDeclaration(JavaParser.ConstructorDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaParser#constructorHead}.
	 * @param ctx the parse tree
	 */
	void enterConstructorHead(JavaParser.ConstructorHeadContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#constructorHead}.
	 * @param ctx the parse tree
	 */
	void exitConstructorHead(JavaParser.ConstructorHeadContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaParser#fieldDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterFieldDeclaration(JavaParser.FieldDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#fieldDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitFieldDeclaration(JavaParser.FieldDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaParser#constDeclarationList}.
	 * @param ctx the parse tree
	 */
	void enterConstDeclarationList(JavaParser.ConstDeclarationListContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#constDeclarationList}.
	 * @param ctx the parse tree
	 */
	void exitConstDeclarationList(JavaParser.ConstDeclarationListContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaParser#constDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterConstDeclaration(JavaParser.ConstDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#constDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitConstDeclaration(JavaParser.ConstDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaParser#constantDeclarator}.
	 * @param ctx the parse tree
	 */
	void enterConstantDeclarator(JavaParser.ConstantDeclaratorContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#constantDeclarator}.
	 * @param ctx the parse tree
	 */
	void exitConstantDeclarator(JavaParser.ConstantDeclaratorContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaParser#variableDeclarators}.
	 * @param ctx the parse tree
	 */
	void enterVariableDeclarators(JavaParser.VariableDeclaratorsContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#variableDeclarators}.
	 * @param ctx the parse tree
	 */
	void exitVariableDeclarators(JavaParser.VariableDeclaratorsContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaParser#variableDeclarator}.
	 * @param ctx the parse tree
	 */
	void enterVariableDeclarator(JavaParser.VariableDeclaratorContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#variableDeclarator}.
	 * @param ctx the parse tree
	 */
	void exitVariableDeclarator(JavaParser.VariableDeclaratorContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaParser#variableDeclaratorId}.
	 * @param ctx the parse tree
	 */
	void enterVariableDeclaratorId(JavaParser.VariableDeclaratorIdContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#variableDeclaratorId}.
	 * @param ctx the parse tree
	 */
	void exitVariableDeclaratorId(JavaParser.VariableDeclaratorIdContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaParser#variableInitializer}.
	 * @param ctx the parse tree
	 */
	void enterVariableInitializer(JavaParser.VariableInitializerContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#variableInitializer}.
	 * @param ctx the parse tree
	 */
	void exitVariableInitializer(JavaParser.VariableInitializerContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaParser#arrayInitializer}.
	 * @param ctx the parse tree
	 */
	void enterArrayInitializer(JavaParser.ArrayInitializerContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#arrayInitializer}.
	 * @param ctx the parse tree
	 */
	void exitArrayInitializer(JavaParser.ArrayInitializerContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaParser#classOrInterfaceType}.
	 * @param ctx the parse tree
	 */
	void enterClassOrInterfaceType(JavaParser.ClassOrInterfaceTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#classOrInterfaceType}.
	 * @param ctx the parse tree
	 */
	void exitClassOrInterfaceType(JavaParser.ClassOrInterfaceTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaParser#typeArgument}.
	 * @param ctx the parse tree
	 */
	void enterTypeArgument(JavaParser.TypeArgumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#typeArgument}.
	 * @param ctx the parse tree
	 */
	void exitTypeArgument(JavaParser.TypeArgumentContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaParser#qualifiedNameList}.
	 * @param ctx the parse tree
	 */
	void enterQualifiedNameList(JavaParser.QualifiedNameListContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#qualifiedNameList}.
	 * @param ctx the parse tree
	 */
	void exitQualifiedNameList(JavaParser.QualifiedNameListContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaParser#formalParameters}.
	 * @param ctx the parse tree
	 */
	void enterFormalParameters(JavaParser.FormalParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#formalParameters}.
	 * @param ctx the parse tree
	 */
	void exitFormalParameters(JavaParser.FormalParametersContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaParser#receiverParameter}.
	 * @param ctx the parse tree
	 */
	void enterReceiverParameter(JavaParser.ReceiverParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#receiverParameter}.
	 * @param ctx the parse tree
	 */
	void exitReceiverParameter(JavaParser.ReceiverParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaParser#formalParameterList}.
	 * @param ctx the parse tree
	 */
	void enterFormalParameterList(JavaParser.FormalParameterListContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#formalParameterList}.
	 * @param ctx the parse tree
	 */
	void exitFormalParameterList(JavaParser.FormalParameterListContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaParser#formalParameter}.
	 * @param ctx the parse tree
	 */
	void enterFormalParameter(JavaParser.FormalParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#formalParameter}.
	 * @param ctx the parse tree
	 */
	void exitFormalParameter(JavaParser.FormalParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaParser#lastFormalParameter}.
	 * @param ctx the parse tree
	 */
	void enterLastFormalParameter(JavaParser.LastFormalParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#lastFormalParameter}.
	 * @param ctx the parse tree
	 */
	void exitLastFormalParameter(JavaParser.LastFormalParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaParser#lambdaLVTIList}.
	 * @param ctx the parse tree
	 */
	void enterLambdaLVTIList(JavaParser.LambdaLVTIListContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#lambdaLVTIList}.
	 * @param ctx the parse tree
	 */
	void exitLambdaLVTIList(JavaParser.LambdaLVTIListContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaParser#lambdaLVTIParameter}.
	 * @param ctx the parse tree
	 */
	void enterLambdaLVTIParameter(JavaParser.LambdaLVTIParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#lambdaLVTIParameter}.
	 * @param ctx the parse tree
	 */
	void exitLambdaLVTIParameter(JavaParser.LambdaLVTIParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaParser#qualifiedName}.
	 * @param ctx the parse tree
	 */
	void enterQualifiedName(JavaParser.QualifiedNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#qualifiedName}.
	 * @param ctx the parse tree
	 */
	void exitQualifiedName(JavaParser.QualifiedNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(JavaParser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(JavaParser.LiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaParser#integerLiteral}.
	 * @param ctx the parse tree
	 */
	void enterIntegerLiteral(JavaParser.IntegerLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#integerLiteral}.
	 * @param ctx the parse tree
	 */
	void exitIntegerLiteral(JavaParser.IntegerLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaParser#floatLiteral}.
	 * @param ctx the parse tree
	 */
	void enterFloatLiteral(JavaParser.FloatLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#floatLiteral}.
	 * @param ctx the parse tree
	 */
	void exitFloatLiteral(JavaParser.FloatLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaParser#altAnnotationQualifiedName}.
	 * @param ctx the parse tree
	 */
	void enterAltAnnotationQualifiedName(JavaParser.AltAnnotationQualifiedNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#altAnnotationQualifiedName}.
	 * @param ctx the parse tree
	 */
	void exitAltAnnotationQualifiedName(JavaParser.AltAnnotationQualifiedNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaParser#annotationList}.
	 * @param ctx the parse tree
	 */
	void enterAnnotationList(JavaParser.AnnotationListContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#annotationList}.
	 * @param ctx the parse tree
	 */
	void exitAnnotationList(JavaParser.AnnotationListContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaParser#annotation}.
	 * @param ctx the parse tree
	 */
	void enterAnnotation(JavaParser.AnnotationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#annotation}.
	 * @param ctx the parse tree
	 */
	void exitAnnotation(JavaParser.AnnotationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaParser#elementValuePairs}.
	 * @param ctx the parse tree
	 */
	void enterElementValuePairs(JavaParser.ElementValuePairsContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#elementValuePairs}.
	 * @param ctx the parse tree
	 */
	void exitElementValuePairs(JavaParser.ElementValuePairsContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaParser#elementValuePair}.
	 * @param ctx the parse tree
	 */
	void enterElementValuePair(JavaParser.ElementValuePairContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#elementValuePair}.
	 * @param ctx the parse tree
	 */
	void exitElementValuePair(JavaParser.ElementValuePairContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaParser#elementValue}.
	 * @param ctx the parse tree
	 */
	void enterElementValue(JavaParser.ElementValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#elementValue}.
	 * @param ctx the parse tree
	 */
	void exitElementValue(JavaParser.ElementValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaParser#elementValueArrayInitializer}.
	 * @param ctx the parse tree
	 */
	void enterElementValueArrayInitializer(JavaParser.ElementValueArrayInitializerContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#elementValueArrayInitializer}.
	 * @param ctx the parse tree
	 */
	void exitElementValueArrayInitializer(JavaParser.ElementValueArrayInitializerContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaParser#annotationTypeElementDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterAnnotationTypeElementDeclaration(JavaParser.AnnotationTypeElementDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#annotationTypeElementDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitAnnotationTypeElementDeclaration(JavaParser.AnnotationTypeElementDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaParser#annotationTypeElementRest}.
	 * @param ctx the parse tree
	 */
	void enterAnnotationTypeElementRest(JavaParser.AnnotationTypeElementRestContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#annotationTypeElementRest}.
	 * @param ctx the parse tree
	 */
	void exitAnnotationTypeElementRest(JavaParser.AnnotationTypeElementRestContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaParser#annotationMethodOrConstantRest}.
	 * @param ctx the parse tree
	 */
	void enterAnnotationMethodOrConstantRest(JavaParser.AnnotationMethodOrConstantRestContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#annotationMethodOrConstantRest}.
	 * @param ctx the parse tree
	 */
	void exitAnnotationMethodOrConstantRest(JavaParser.AnnotationMethodOrConstantRestContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaParser#annotationMethodRest}.
	 * @param ctx the parse tree
	 */
	void enterAnnotationMethodRest(JavaParser.AnnotationMethodRestContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#annotationMethodRest}.
	 * @param ctx the parse tree
	 */
	void exitAnnotationMethodRest(JavaParser.AnnotationMethodRestContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaParser#annotationConstantRest}.
	 * @param ctx the parse tree
	 */
	void enterAnnotationConstantRest(JavaParser.AnnotationConstantRestContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#annotationConstantRest}.
	 * @param ctx the parse tree
	 */
	void exitAnnotationConstantRest(JavaParser.AnnotationConstantRestContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaParser#defaultValue}.
	 * @param ctx the parse tree
	 */
	void enterDefaultValue(JavaParser.DefaultValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#defaultValue}.
	 * @param ctx the parse tree
	 */
	void exitDefaultValue(JavaParser.DefaultValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaParser#moduleDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterModuleDeclaration(JavaParser.ModuleDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#moduleDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitModuleDeclaration(JavaParser.ModuleDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaParser#moduleDirective}.
	 * @param ctx the parse tree
	 */
	void enterModuleDirective(JavaParser.ModuleDirectiveContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#moduleDirective}.
	 * @param ctx the parse tree
	 */
	void exitModuleDirective(JavaParser.ModuleDirectiveContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaParser#requiresModifier}.
	 * @param ctx the parse tree
	 */
	void enterRequiresModifier(JavaParser.RequiresModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#requiresModifier}.
	 * @param ctx the parse tree
	 */
	void exitRequiresModifier(JavaParser.RequiresModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaParser#recordHeader}.
	 * @param ctx the parse tree
	 */
	void enterRecordHeader(JavaParser.RecordHeaderContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#recordHeader}.
	 * @param ctx the parse tree
	 */
	void exitRecordHeader(JavaParser.RecordHeaderContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaParser#recordComponentList}.
	 * @param ctx the parse tree
	 */
	void enterRecordComponentList(JavaParser.RecordComponentListContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#recordComponentList}.
	 * @param ctx the parse tree
	 */
	void exitRecordComponentList(JavaParser.RecordComponentListContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaParser#recordComponent}.
	 * @param ctx the parse tree
	 */
	void enterRecordComponent(JavaParser.RecordComponentContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#recordComponent}.
	 * @param ctx the parse tree
	 */
	void exitRecordComponent(JavaParser.RecordComponentContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(JavaParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(JavaParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaParser#switchBlockStatementGroup}.
	 * @param ctx the parse tree
	 */
	void enterSwitchBlockStatementGroup(JavaParser.SwitchBlockStatementGroupContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#switchBlockStatementGroup}.
	 * @param ctx the parse tree
	 */
	void exitSwitchBlockStatementGroup(JavaParser.SwitchBlockStatementGroupContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaParser#localVariableDeclarationStmt}.
	 * @param ctx the parse tree
	 */
	void enterLocalVariableDeclarationStmt(JavaParser.LocalVariableDeclarationStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#localVariableDeclarationStmt}.
	 * @param ctx the parse tree
	 */
	void exitLocalVariableDeclarationStmt(JavaParser.LocalVariableDeclarationStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaParser#localVariableDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterLocalVariableDeclaration(JavaParser.LocalVariableDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#localVariableDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitLocalVariableDeclaration(JavaParser.LocalVariableDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaParser#identifier}.
	 * @param ctx the parse tree
	 */
	void enterIdentifier(JavaParser.IdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#identifier}.
	 * @param ctx the parse tree
	 */
	void exitIdentifier(JavaParser.IdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaParser#typeIdentifier}.
	 * @param ctx the parse tree
	 */
	void enterTypeIdentifier(JavaParser.TypeIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#typeIdentifier}.
	 * @param ctx the parse tree
	 */
	void exitTypeIdentifier(JavaParser.TypeIdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(JavaParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(JavaParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaParser#assertStmt}.
	 * @param ctx the parse tree
	 */
	void enterAssertStmt(JavaParser.AssertStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#assertStmt}.
	 * @param ctx the parse tree
	 */
	void exitAssertStmt(JavaParser.AssertStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaParser#ifStmt}.
	 * @param ctx the parse tree
	 */
	void enterIfStmt(JavaParser.IfStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#ifStmt}.
	 * @param ctx the parse tree
	 */
	void exitIfStmt(JavaParser.IfStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaParser#ifElseStmt}.
	 * @param ctx the parse tree
	 */
	void enterIfElseStmt(JavaParser.IfElseStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#ifElseStmt}.
	 * @param ctx the parse tree
	 */
	void exitIfElseStmt(JavaParser.IfElseStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaParser#forStmt}.
	 * @param ctx the parse tree
	 */
	void enterForStmt(JavaParser.ForStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#forStmt}.
	 * @param ctx the parse tree
	 */
	void exitForStmt(JavaParser.ForStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaParser#whileStmt}.
	 * @param ctx the parse tree
	 */
	void enterWhileStmt(JavaParser.WhileStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#whileStmt}.
	 * @param ctx the parse tree
	 */
	void exitWhileStmt(JavaParser.WhileStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaParser#doWhileStmt}.
	 * @param ctx the parse tree
	 */
	void enterDoWhileStmt(JavaParser.DoWhileStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#doWhileStmt}.
	 * @param ctx the parse tree
	 */
	void exitDoWhileStmt(JavaParser.DoWhileStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaParser#tryCatchStmt}.
	 * @param ctx the parse tree
	 */
	void enterTryCatchStmt(JavaParser.TryCatchStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#tryCatchStmt}.
	 * @param ctx the parse tree
	 */
	void exitTryCatchStmt(JavaParser.TryCatchStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaParser#tryResourceStmt}.
	 * @param ctx the parse tree
	 */
	void enterTryResourceStmt(JavaParser.TryResourceStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#tryResourceStmt}.
	 * @param ctx the parse tree
	 */
	void exitTryResourceStmt(JavaParser.TryResourceStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaParser#switchStmt}.
	 * @param ctx the parse tree
	 */
	void enterSwitchStmt(JavaParser.SwitchStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#switchStmt}.
	 * @param ctx the parse tree
	 */
	void exitSwitchStmt(JavaParser.SwitchStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaParser#syncStmt}.
	 * @param ctx the parse tree
	 */
	void enterSyncStmt(JavaParser.SyncStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#syncStmt}.
	 * @param ctx the parse tree
	 */
	void exitSyncStmt(JavaParser.SyncStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaParser#returnStmt}.
	 * @param ctx the parse tree
	 */
	void enterReturnStmt(JavaParser.ReturnStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#returnStmt}.
	 * @param ctx the parse tree
	 */
	void exitReturnStmt(JavaParser.ReturnStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaParser#throwStmt}.
	 * @param ctx the parse tree
	 */
	void enterThrowStmt(JavaParser.ThrowStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#throwStmt}.
	 * @param ctx the parse tree
	 */
	void exitThrowStmt(JavaParser.ThrowStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaParser#breakStmt}.
	 * @param ctx the parse tree
	 */
	void enterBreakStmt(JavaParser.BreakStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#breakStmt}.
	 * @param ctx the parse tree
	 */
	void exitBreakStmt(JavaParser.BreakStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaParser#continueStmt}.
	 * @param ctx the parse tree
	 */
	void enterContinueStmt(JavaParser.ContinueStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#continueStmt}.
	 * @param ctx the parse tree
	 */
	void exitContinueStmt(JavaParser.ContinueStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaParser#yieldStmt}.
	 * @param ctx the parse tree
	 */
	void enterYieldStmt(JavaParser.YieldStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#yieldStmt}.
	 * @param ctx the parse tree
	 */
	void exitYieldStmt(JavaParser.YieldStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaParser#expressionStmt}.
	 * @param ctx the parse tree
	 */
	void enterExpressionStmt(JavaParser.ExpressionStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#expressionStmt}.
	 * @param ctx the parse tree
	 */
	void exitExpressionStmt(JavaParser.ExpressionStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaParser#labelStmt}.
	 * @param ctx the parse tree
	 */
	void enterLabelStmt(JavaParser.LabelStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#labelStmt}.
	 * @param ctx the parse tree
	 */
	void exitLabelStmt(JavaParser.LabelStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaParser#catchClause}.
	 * @param ctx the parse tree
	 */
	void enterCatchClause(JavaParser.CatchClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#catchClause}.
	 * @param ctx the parse tree
	 */
	void exitCatchClause(JavaParser.CatchClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaParser#catchType}.
	 * @param ctx the parse tree
	 */
	void enterCatchType(JavaParser.CatchTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#catchType}.
	 * @param ctx the parse tree
	 */
	void exitCatchType(JavaParser.CatchTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaParser#finallyBlock}.
	 * @param ctx the parse tree
	 */
	void enterFinallyBlock(JavaParser.FinallyBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#finallyBlock}.
	 * @param ctx the parse tree
	 */
	void exitFinallyBlock(JavaParser.FinallyBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaParser#resourceSpecification}.
	 * @param ctx the parse tree
	 */
	void enterResourceSpecification(JavaParser.ResourceSpecificationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#resourceSpecification}.
	 * @param ctx the parse tree
	 */
	void exitResourceSpecification(JavaParser.ResourceSpecificationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaParser#resources}.
	 * @param ctx the parse tree
	 */
	void enterResources(JavaParser.ResourcesContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#resources}.
	 * @param ctx the parse tree
	 */
	void exitResources(JavaParser.ResourcesContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaParser#resource}.
	 * @param ctx the parse tree
	 */
	void enterResource(JavaParser.ResourceContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#resource}.
	 * @param ctx the parse tree
	 */
	void exitResource(JavaParser.ResourceContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaParser#switchLabel}.
	 * @param ctx the parse tree
	 */
	void enterSwitchLabel(JavaParser.SwitchLabelContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#switchLabel}.
	 * @param ctx the parse tree
	 */
	void exitSwitchLabel(JavaParser.SwitchLabelContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaParser#forControl}.
	 * @param ctx the parse tree
	 */
	void enterForControl(JavaParser.ForControlContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#forControl}.
	 * @param ctx the parse tree
	 */
	void exitForControl(JavaParser.ForControlContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaParser#forInit}.
	 * @param ctx the parse tree
	 */
	void enterForInit(JavaParser.ForInitContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#forInit}.
	 * @param ctx the parse tree
	 */
	void exitForInit(JavaParser.ForInitContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaParser#enhancedForControl}.
	 * @param ctx the parse tree
	 */
	void enterEnhancedForControl(JavaParser.EnhancedForControlContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#enhancedForControl}.
	 * @param ctx the parse tree
	 */
	void exitEnhancedForControl(JavaParser.EnhancedForControlContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaParser#parExpression}.
	 * @param ctx the parse tree
	 */
	void enterParExpression(JavaParser.ParExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#parExpression}.
	 * @param ctx the parse tree
	 */
	void exitParExpression(JavaParser.ParExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaParser#expressionList}.
	 * @param ctx the parse tree
	 */
	void enterExpressionList(JavaParser.ExpressionListContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#expressionList}.
	 * @param ctx the parse tree
	 */
	void exitExpressionList(JavaParser.ExpressionListContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaParser#methodCall}.
	 * @param ctx the parse tree
	 */
	void enterMethodCall(JavaParser.MethodCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#methodCall}.
	 * @param ctx the parse tree
	 */
	void exitMethodCall(JavaParser.MethodCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(JavaParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(JavaParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaParser#pattern}.
	 * @param ctx the parse tree
	 */
	void enterPattern(JavaParser.PatternContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#pattern}.
	 * @param ctx the parse tree
	 */
	void exitPattern(JavaParser.PatternContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaParser#lambdaExpression}.
	 * @param ctx the parse tree
	 */
	void enterLambdaExpression(JavaParser.LambdaExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#lambdaExpression}.
	 * @param ctx the parse tree
	 */
	void exitLambdaExpression(JavaParser.LambdaExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaParser#lambdaParameters}.
	 * @param ctx the parse tree
	 */
	void enterLambdaParameters(JavaParser.LambdaParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#lambdaParameters}.
	 * @param ctx the parse tree
	 */
	void exitLambdaParameters(JavaParser.LambdaParametersContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaParser#lambdaBody}.
	 * @param ctx the parse tree
	 */
	void enterLambdaBody(JavaParser.LambdaBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#lambdaBody}.
	 * @param ctx the parse tree
	 */
	void exitLambdaBody(JavaParser.LambdaBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaParser#switchLabeledRule}.
	 * @param ctx the parse tree
	 */
	void enterSwitchLabeledRule(JavaParser.SwitchLabeledRuleContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#switchLabeledRule}.
	 * @param ctx the parse tree
	 */
	void exitSwitchLabeledRule(JavaParser.SwitchLabeledRuleContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaParser#guardedPattern}.
	 * @param ctx the parse tree
	 */
	void enterGuardedPattern(JavaParser.GuardedPatternContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#guardedPattern}.
	 * @param ctx the parse tree
	 */
	void exitGuardedPattern(JavaParser.GuardedPatternContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaParser#classType}.
	 * @param ctx the parse tree
	 */
	void enterClassType(JavaParser.ClassTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#classType}.
	 * @param ctx the parse tree
	 */
	void exitClassType(JavaParser.ClassTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaParser#creator}.
	 * @param ctx the parse tree
	 */
	void enterCreator(JavaParser.CreatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#creator}.
	 * @param ctx the parse tree
	 */
	void exitCreator(JavaParser.CreatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaParser#createdName}.
	 * @param ctx the parse tree
	 */
	void enterCreatedName(JavaParser.CreatedNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#createdName}.
	 * @param ctx the parse tree
	 */
	void exitCreatedName(JavaParser.CreatedNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaParser#innerCreator}.
	 * @param ctx the parse tree
	 */
	void enterInnerCreator(JavaParser.InnerCreatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#innerCreator}.
	 * @param ctx the parse tree
	 */
	void exitInnerCreator(JavaParser.InnerCreatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaParser#arrayCreatorRest}.
	 * @param ctx the parse tree
	 */
	void enterArrayCreatorRest(JavaParser.ArrayCreatorRestContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#arrayCreatorRest}.
	 * @param ctx the parse tree
	 */
	void exitArrayCreatorRest(JavaParser.ArrayCreatorRestContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaParser#classCreatorRest}.
	 * @param ctx the parse tree
	 */
	void enterClassCreatorRest(JavaParser.ClassCreatorRestContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#classCreatorRest}.
	 * @param ctx the parse tree
	 */
	void exitClassCreatorRest(JavaParser.ClassCreatorRestContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaParser#explicitGenericInvocation}.
	 * @param ctx the parse tree
	 */
	void enterExplicitGenericInvocation(JavaParser.ExplicitGenericInvocationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#explicitGenericInvocation}.
	 * @param ctx the parse tree
	 */
	void exitExplicitGenericInvocation(JavaParser.ExplicitGenericInvocationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaParser#typeArgumentsOrDiamond}.
	 * @param ctx the parse tree
	 */
	void enterTypeArgumentsOrDiamond(JavaParser.TypeArgumentsOrDiamondContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#typeArgumentsOrDiamond}.
	 * @param ctx the parse tree
	 */
	void exitTypeArgumentsOrDiamond(JavaParser.TypeArgumentsOrDiamondContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaParser#nonWildcardTypeArguments}.
	 * @param ctx the parse tree
	 */
	void enterNonWildcardTypeArguments(JavaParser.NonWildcardTypeArgumentsContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#nonWildcardTypeArguments}.
	 * @param ctx the parse tree
	 */
	void exitNonWildcardTypeArguments(JavaParser.NonWildcardTypeArgumentsContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaParser#typeList}.
	 * @param ctx the parse tree
	 */
	void enterTypeList(JavaParser.TypeListContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#typeList}.
	 * @param ctx the parse tree
	 */
	void exitTypeList(JavaParser.TypeListContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaParser#typeType}.
	 * @param ctx the parse tree
	 */
	void enterTypeType(JavaParser.TypeTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#typeType}.
	 * @param ctx the parse tree
	 */
	void exitTypeType(JavaParser.TypeTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaParser#primitiveType}.
	 * @param ctx the parse tree
	 */
	void enterPrimitiveType(JavaParser.PrimitiveTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#primitiveType}.
	 * @param ctx the parse tree
	 */
	void exitPrimitiveType(JavaParser.PrimitiveTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaParser#typeArguments}.
	 * @param ctx the parse tree
	 */
	void enterTypeArguments(JavaParser.TypeArgumentsContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#typeArguments}.
	 * @param ctx the parse tree
	 */
	void exitTypeArguments(JavaParser.TypeArgumentsContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaParser#superSuffix}.
	 * @param ctx the parse tree
	 */
	void enterSuperSuffix(JavaParser.SuperSuffixContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#superSuffix}.
	 * @param ctx the parse tree
	 */
	void exitSuperSuffix(JavaParser.SuperSuffixContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaParser#explicitGenericInvocationSuffix}.
	 * @param ctx the parse tree
	 */
	void enterExplicitGenericInvocationSuffix(JavaParser.ExplicitGenericInvocationSuffixContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#explicitGenericInvocationSuffix}.
	 * @param ctx the parse tree
	 */
	void exitExplicitGenericInvocationSuffix(JavaParser.ExplicitGenericInvocationSuffixContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaParser#arguments}.
	 * @param ctx the parse tree
	 */
	void enterArguments(JavaParser.ArgumentsContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#arguments}.
	 * @param ctx the parse tree
	 */
	void exitArguments(JavaParser.ArgumentsContext ctx);
}