package org.example.parser.java;

import java.util.Map;

import org.example.parser.common.MyParser;
import org.example.parser.common.context.ExtendContext;
import org.example.parser.java.antlr.JavaParser;
import org.example.parser.java.antlr.JavaParserBaseListener;
import org.example.styler.structure.StructureStyler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SpotDetectorListener extends JavaParserBaseListener {
    private static final Logger logger = LoggerFactory.getLogger(SpotDetectorListener.class);
    private Map<Integer, Spot> spots;
	private MyParser parser;

    public SpotDetectorListener(Map<Integer, Spot> spots, MyParser parser) {
        this.spots = spots;
        this.parser = parser;
    }

    private void detect(ExtendContext ctx) {
        StructureStyler structureStyler = new StructureStyler();
        if (structureStyler.isRelevant(ctx, null, parser)) {
            structureStyler.extractStyle(ctx, parser);
            Spot spot = StructureStyler.extractSpot(ctx, parser);
            if (spot != null) {
                spots.put(ctx.getStart().getTokenIndex(), spot);
            }
        }
    }

	@Override
	public void exitCompilationUnit(JavaParser.CompilationUnitContext ctx) {
		ctx.expandChildIf(root -> root instanceof JavaParser.TypeDeclarationListContext);
		detect(ctx);
	}

	@Override
	public void exitConstructorDeclaration(JavaParser.ConstructorDeclarationContext ctx) {
		detect(ctx);
	}

	@Override
	public void exitConstructorDeclarationList(JavaParser.ConstructorDeclarationListContext ctx) {
		detect(ctx);
	}

	@Override
	public void exitBody(JavaParser.BodyContext ctx) {
		ctx.expandChildIf(root -> root instanceof JavaParser.ClassBodyDeclarationContext);
		ctx.decBraceDepth();
		detect(ctx);
	}

	@Override
	public void exitClassHead(JavaParser.ClassHeadContext ctx) {
		detect(ctx);
	}

	@Override
	public void exitInterfaceHead(JavaParser.InterfaceHeadContext ctx) {
		detect(ctx);
	}

	@Override
	public void exitRecordHead(JavaParser.RecordHeadContext ctx) {
		detect(ctx);
	}

	@Override
	public void exitEnumHead(JavaParser.EnumHeadContext ctx) {
		detect(ctx);
	}

	@Override
	public void exitAnnotationTypeHead(JavaParser.AnnotationTypeHeadContext ctx) {
		detect(ctx);
	}

	@Override
	public void exitMethodHead(JavaParser.MethodHeadContext ctx) {
		detect(ctx);
	}

	@Override
	public void exitConstructorHead(JavaParser.ConstructorHeadContext ctx) {
		detect(ctx);
	}

	@Override
	public void exitFieldDeclaration(JavaParser.FieldDeclarationContext ctx) {
		detect(ctx);
	}

	@Override
	public void exitFieldDeclarationList(JavaParser.FieldDeclarationListContext ctx) {
		detect(ctx);
	}

	@Override
	public void exitInitializerList(JavaParser.InitializerListContext ctx) {
		detect(ctx);
	}

	@Override
	public void exitMethodDeclaration(JavaParser.MethodDeclarationContext ctx) {
		detect(ctx);
	}

	@Override
	public void exitMethodDeclarationList(JavaParser.MethodDeclarationListContext ctx) {
		detect(ctx);
	}

	@Override
	public void exitTypeDeclarationList(JavaParser.TypeDeclarationListContext ctx) {
		detect(ctx);
	}

	@Override
	public void exitIfStmt(JavaParser.IfStmtContext ctx) {
		detect(ctx);
	}

	@Override
	public void exitIfElseStmt(JavaParser.IfElseStmtContext ctx) {
		detect(ctx);
	}

	@Override
	public void exitForStmt(JavaParser.ForStmtContext ctx) {
		detect(ctx);
	}

	@Override
	public void exitWhileStmt(JavaParser.WhileStmtContext ctx) {
		detect(ctx);
	}

	@Override
	public void exitDoWhileStmt(JavaParser.DoWhileStmtContext ctx) {
		detect(ctx);
	}

	@Override
	public void exitLabelStmt(JavaParser.LabelStmtContext ctx) {
		detect(ctx);
	}

	@Override
	public void exitSwitchStmt(JavaParser.SwitchStmtContext ctx) {
		detect(ctx);
	}

	@Override
	public void exitSyncStmt(JavaParser.SyncStmtContext ctx) {
		detect(ctx);
	}

	@Override
	public void exitInitializer(JavaParser.InitializerContext ctx) {
		detect(ctx);
	}

	@Override
	public void exitArrayInitializer(JavaParser.ArrayInitializerContext ctx) {
		detect(ctx);
	}

	@Override
	public void exitElementValueArrayInitializer(JavaParser.ElementValueArrayInitializerContext ctx) {
		detect(ctx);
	}

	@Override
	public void exitImportDeclarationList(JavaParser.ImportDeclarationListContext ctx) {
		detect(ctx);
	}

	@Override
	public void exitPackageDeclaration(JavaParser.PackageDeclarationContext ctx) {
		detect(ctx);
	}

	@Override
	public void exitImportDeclaration(JavaParser.ImportDeclarationContext ctx) {
		detect(ctx);
	}

	@Override
	public void exitModifierList(JavaParser.ModifierListContext ctx) {
		detect(ctx);
	}

	@Override
	public void exitTypeParameters(JavaParser.TypeParametersContext ctx) {
		detect(ctx);
	}

	@Override
	public void exitTypeParameter(JavaParser.TypeParameterContext ctx) {
		detect(ctx);
	}

	@Override
	public void exitTypeBound(JavaParser.TypeBoundContext ctx) {
		detect(ctx);
	}

	@Override
	public void exitEnumConstants(JavaParser.EnumConstantsContext ctx) {
		detect(ctx);
	}

	@Override
	public void exitConstDeclarationList(JavaParser.ConstDeclarationListContext ctx) {
		detect(ctx);
	}

	@Override
	public void exitConstDeclaration(JavaParser.ConstDeclarationContext ctx) {
		detect(ctx);
	}

	@Override
	public void exitConstantDeclarator(JavaParser.ConstantDeclaratorContext ctx) {
		detect(ctx);
	}

	@Override
	public void exitVariableDeclarators(JavaParser.VariableDeclaratorsContext ctx) {
		detect(ctx);
	}

	@Override
	public void exitVariableDeclarator(JavaParser.VariableDeclaratorContext ctx) {
		detect(ctx);
	}

	@Override
	public void exitTypeArgument(JavaParser.TypeArgumentContext ctx) {
		detect(ctx);
	}

	@Override
	public void exitQualifiedNameList(JavaParser.QualifiedNameListContext ctx) {
		detect(ctx);
	}

	@Override
	public void exitFormalParameters(JavaParser.FormalParametersContext ctx) {
		detect(ctx);
	}

	@Override
	public void exitFormalParameterList(JavaParser.FormalParameterListContext ctx) {
		detect(ctx);
	}


	@Override
	public void exitLambdaLVTIList(JavaParser.LambdaLVTIListContext ctx) {
		detect(ctx);
	}

	@Override
	public void exitQualifiedName(JavaParser.QualifiedNameContext ctx) {
		detect(ctx);
	}

	@Override
	public void exitLiteral(JavaParser.LiteralContext ctx) {
		detect(ctx);
	}

	@Override
	public void exitIntegerLiteral(JavaParser.IntegerLiteralContext ctx) {
		detect(ctx);
	}

	@Override
	public void exitFloatLiteral(JavaParser.FloatLiteralContext ctx) {
		detect(ctx);
	}

	@Override
	public void exitAltAnnotationQualifiedName(JavaParser.AltAnnotationQualifiedNameContext ctx) {
		detect(ctx);
	}

	@Override
	public void exitAnnotationList(JavaParser.AnnotationListContext ctx) {
		detect(ctx);
	}

	@Override
	public void exitAnnotation(JavaParser.AnnotationContext ctx) {
		detect(ctx);
	}

	@Override
	public void exitElementValuePairs(JavaParser.ElementValuePairsContext ctx) {
		detect(ctx);
	}

	@Override
	public void exitElementValuePair(JavaParser.ElementValuePairContext ctx) {
		detect(ctx);
	}

	@Override
	public void exitElementValue(JavaParser.ElementValueContext ctx) {
		detect(ctx);
	}

	@Override
	public void exitAnnotationTypeElementDeclaration(JavaParser.AnnotationTypeElementDeclarationContext ctx) {
		detect(ctx);
	}

	@Override
	public void exitAnnotationTypeElementRest(JavaParser.AnnotationTypeElementRestContext ctx) {
		detect(ctx);
	}

	@Override
	public void exitAnnotationMethodOrConstantRest(JavaParser.AnnotationMethodOrConstantRestContext ctx) {
		detect(ctx);
	}

	@Override
	public void exitAnnotationMethodRest(JavaParser.AnnotationMethodRestContext ctx) {
		detect(ctx);
	}

	@Override
	public void exitAnnotationConstantRest(JavaParser.AnnotationConstantRestContext ctx) {
		detect(ctx);
	}

	@Override
	public void exitDefaultValue(JavaParser.DefaultValueContext ctx) {
		detect(ctx);
	}

	@Override
	public void exitModuleDeclaration(JavaParser.ModuleDeclarationContext ctx) {
		detect(ctx);
	}

	@Override
	public void exitModuleDirective(JavaParser.ModuleDirectiveContext ctx) {
		detect(ctx);
	}

	@Override
	public void exitRequiresModifier(JavaParser.RequiresModifierContext ctx) {
		detect(ctx);
	}

	@Override
	public void exitRecordHeader(JavaParser.RecordHeaderContext ctx) {
		detect(ctx);
	}

	@Override
	public void exitRecordComponentList(JavaParser.RecordComponentListContext ctx) {
		detect(ctx);
	}

	@Override
	public void exitRecordComponent(JavaParser.RecordComponentContext ctx) {
		detect(ctx);
	}

	@Override
	public void exitBlock(JavaParser.BlockContext ctx) {
		ctx.decBraceDepth(); // This statement must be placed before the @doOperation is called.
		detect(ctx);
	}

	@Override
	public void exitLocalVariableDeclaration(JavaParser.LocalVariableDeclarationContext ctx) {
		detect(ctx);
	}

	@Override
	public void exitIdentifier(JavaParser.IdentifierContext ctx) {
		detect(ctx);
	}

	@Override
	public void exitTypeIdentifier(JavaParser.TypeIdentifierContext ctx) {
		detect(ctx);
	}

	@Override
	public void exitCatchType(JavaParser.CatchTypeContext ctx) {
		detect(ctx);
	}

	@Override
	public void exitFinallyBlock(JavaParser.FinallyBlockContext ctx) {
		detect(ctx);
	}

	@Override
	public void exitResourceSpecification(JavaParser.ResourceSpecificationContext ctx) {
		detect(ctx);
	}

	@Override
	public void exitResources(JavaParser.ResourcesContext ctx) {
		detect(ctx);
	}

	@Override
	public void exitResource(JavaParser.ResourceContext ctx) {
		detect(ctx);
	}

	@Override
	public void exitSwitchLabel(JavaParser.SwitchLabelContext ctx) {
		detect(ctx);
	}

	@Override
	public void exitForControl(JavaParser.ForControlContext ctx) {
		detect(ctx);
	}

	@Override
	public void exitForInit(JavaParser.ForInitContext ctx) {
		detect(ctx);
	}

	@Override
	public void exitEnhancedForControl(JavaParser.EnhancedForControlContext ctx) {
		detect(ctx);
	}

	@Override
	public void exitParExpression(JavaParser.ParExpressionContext ctx) {
		detect(ctx);
	}

	@Override
	public void exitExpressionList(JavaParser.ExpressionListContext ctx) {
		detect(ctx);
	}

	@Override
	public void exitMethodCall(JavaParser.MethodCallContext ctx) {
		detect(ctx);
	}

	@Override
	public void exitExpression(JavaParser.ExpressionContext ctx) {
		detect(ctx);
	}

	@Override
	public void exitPattern(JavaParser.PatternContext ctx) {
		detect(ctx);
	}

	@Override
	public void exitLambdaExpression(JavaParser.LambdaExpressionContext ctx) {
		detect(ctx);
	}

	@Override
	public void exitLambdaParameters(JavaParser.LambdaParametersContext ctx) {
		detect(ctx);
	}

	@Override
	public void exitLambdaBody(JavaParser.LambdaBodyContext ctx) {
		detect(ctx);
	}

	@Override
	public void exitGuardedPattern(JavaParser.GuardedPatternContext ctx) {
		detect(ctx);
	}

	@Override
	public void exitClassType(JavaParser.ClassTypeContext ctx) {
		detect(ctx);
	}

	@Override
	public void exitCreator(JavaParser.CreatorContext ctx) {
		detect(ctx);
	}

	@Override
	public void exitCreatedName(JavaParser.CreatedNameContext ctx) {
		detect(ctx);
	}

	@Override
	public void exitInnerCreator(JavaParser.InnerCreatorContext ctx) {
		detect(ctx);
	}

	@Override
	public void exitArrayCreatorRest(JavaParser.ArrayCreatorRestContext ctx) {
		detect(ctx);
	}

	@Override
	public void exitClassCreatorRest(JavaParser.ClassCreatorRestContext ctx) {
		detect(ctx);
	}

	@Override
	public void exitExplicitGenericInvocation(JavaParser.ExplicitGenericInvocationContext ctx) {
		detect(ctx);
	}

	@Override
	public void exitTypeArgumentsOrDiamond(JavaParser.TypeArgumentsOrDiamondContext ctx) {
		detect(ctx);
	}

	@Override
	public void exitNonWildcardTypeArguments(JavaParser.NonWildcardTypeArgumentsContext ctx) {
		detect(ctx);
	}

	@Override
	public void exitTypeList(JavaParser.TypeListContext ctx) {
		detect(ctx);
	}

	@Override
	public void exitTypeDeclaration(JavaParser.TypeDeclarationContext ctx) {
		detect(ctx);
	}

	@Override
	public void exitEnumConstant(JavaParser.EnumConstantContext ctx) {
		detect(ctx);
	}

	@Override
	public void exitClassBodyDeclaration(JavaParser.ClassBodyDeclarationContext ctx) {
		detect(ctx);
	}

	@Override
	public void exitVariableDeclaratorId(JavaParser.VariableDeclaratorIdContext ctx) {
		detect(ctx);
	}

	@Override
	public void exitVariableInitializer(JavaParser.VariableInitializerContext ctx) {
		detect(ctx);
	}

	@Override
	public void exitClassOrInterfaceType(JavaParser.ClassOrInterfaceTypeContext ctx) {
		detect(ctx);
	}

	@Override
	public void exitLambdaLVTIParameter(JavaParser.LambdaLVTIParameterContext ctx) {
		detect(ctx);
	}

	@Override
	public void exitSwitchBlockStatementGroup(JavaParser.SwitchBlockStatementGroupContext ctx) {
		detect(ctx);
	}

	@Override
	public void exitLocalVariableDeclarationStmt(JavaParser.LocalVariableDeclarationStmtContext ctx) {
		detect(ctx);
	}

	@Override
	public void exitStatement(JavaParser.StatementContext ctx) {
		detect(ctx);
	}

	@Override
	public void exitAssertStmt(JavaParser.AssertStmtContext ctx) {
		detect(ctx);
	}

	@Override
	public void exitTryCatchStmt(JavaParser.TryCatchStmtContext ctx) {
		detect(ctx);
	}

	@Override
	public void exitTryResourceStmt(JavaParser.TryResourceStmtContext ctx) {
		detect(ctx);
	}

	@Override
	public void exitReturnStmt(JavaParser.ReturnStmtContext ctx) {
		detect(ctx);
	}

	@Override
	public void exitThrowStmt(JavaParser.ThrowStmtContext ctx) {
		detect(ctx);
	}

	@Override
	public void exitBreakStmt(JavaParser.BreakStmtContext ctx) {
		detect(ctx);
	}

	@Override
	public void exitContinueStmt(JavaParser.ContinueStmtContext ctx) {
		detect(ctx);
	}

	@Override
	public void exitYieldStmt(JavaParser.YieldStmtContext ctx) {
		detect(ctx);
	}

	@Override
	public void exitExpressionStmt(JavaParser.ExpressionStmtContext ctx) {
		detect(ctx);
	}

	@Override
	public void exitCatchClause(JavaParser.CatchClauseContext ctx) {
		detect(ctx);
	}

	@Override
	public void exitSwitchLabeledRule(JavaParser.SwitchLabeledRuleContext ctx) {
		detect(ctx);
	}

	@Override
	public void exitTypeType(JavaParser.TypeTypeContext ctx) {
		detect(ctx);
	}

	@Override
	public void exitPrimitiveType(JavaParser.PrimitiveTypeContext ctx) {
		detect(ctx);
	}

	@Override
	public void exitTypeArguments(JavaParser.TypeArgumentsContext ctx) {
		detect(ctx);
	}

	@Override
	public void exitSuperSuffix(JavaParser.SuperSuffixContext ctx) {
		detect(ctx);
	}

	@Override
	public void exitExplicitGenericInvocationSuffix(JavaParser.ExplicitGenericInvocationSuffixContext ctx) {
		detect(ctx);
	}

	@Override
	public void exitArguments(JavaParser.ArgumentsContext ctx) {
		detect(ctx);
	}
}
