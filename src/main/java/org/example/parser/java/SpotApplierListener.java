package org.example.parser.java;

import java.util.Map;

import org.antlr.v4.runtime.Token;
import org.example.parser.common.MyParser;
import org.example.parser.common.context.ExtendContext;
import org.example.parser.java.antlr.JavaParser;
import org.example.parser.java.antlr.JavaParserBaseListener;
import org.example.styler.structure.StructureStyler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SpotApplierListener extends JavaParserBaseListener {
    private static final Logger logger = LoggerFactory.getLogger(SpotApplierListener.class);
    private Map<Integer, Spot> spots;
    private Map<Integer, Integer> spotToTreeId;
	private MyParser parser;

    public SpotApplierListener(Map<Integer, Spot> spots, Map<Integer, Integer> spotToTreeId, MyParser parser) {
        this.spots = spots;
        this.spotToTreeId = spotToTreeId;
        this.parser = parser;
    }

    private void apply(ExtendContext ctx) {
        Token start = ctx.getStart();
        if (start == null) {
            return;
        }
        Spot spot = spots.get(start.getTokenIndex());
        Integer to = spotToTreeId.get(start.getTokenIndex());
        if (spot == null || to == null || spot.treeIndex() == to) {
            return;
        }
        StructureStyler.applyStructure(ctx, parser, spot, to);
    }

	@Override
	public void exitCompilationUnit(JavaParser.CompilationUnitContext ctx) {
		ctx.expandChildIf(root -> root instanceof JavaParser.TypeDeclarationListContext);
		apply(ctx);
	}

	@Override
	public void exitConstructorDeclaration(JavaParser.ConstructorDeclarationContext ctx) {
		apply(ctx);
	}

	@Override
	public void exitConstructorDeclarationList(JavaParser.ConstructorDeclarationListContext ctx) {
		apply(ctx);
	}

	@Override
	public void exitBody(JavaParser.BodyContext ctx) {
		ctx.expandChildIf(root -> root instanceof JavaParser.ClassBodyDeclarationContext);
		ctx.decBraceDepth();
		apply(ctx);
	}

	@Override
	public void exitClassHead(JavaParser.ClassHeadContext ctx) {
		apply(ctx);
	}

	@Override
	public void exitInterfaceHead(JavaParser.InterfaceHeadContext ctx) {
		apply(ctx);
	}

	@Override
	public void exitRecordHead(JavaParser.RecordHeadContext ctx) {
		apply(ctx);
	}

	@Override
	public void exitEnumHead(JavaParser.EnumHeadContext ctx) {
		apply(ctx);
	}

	@Override
	public void exitAnnotationTypeHead(JavaParser.AnnotationTypeHeadContext ctx) {
		apply(ctx);
	}

	@Override
	public void exitMethodHead(JavaParser.MethodHeadContext ctx) {
		apply(ctx);
	}

	@Override
	public void exitConstructorHead(JavaParser.ConstructorHeadContext ctx) {
		apply(ctx);
	}

	@Override
	public void exitFieldDeclaration(JavaParser.FieldDeclarationContext ctx) {
		apply(ctx);
	}

	@Override
	public void exitFieldDeclarationList(JavaParser.FieldDeclarationListContext ctx) {
		apply(ctx);
	}

	@Override
	public void exitInitializerList(JavaParser.InitializerListContext ctx) {
		apply(ctx);
	}

	@Override
	public void exitMethodDeclaration(JavaParser.MethodDeclarationContext ctx) {
		apply(ctx);
	}

	@Override
	public void exitMethodDeclarationList(JavaParser.MethodDeclarationListContext ctx) {
		apply(ctx);
	}

	@Override
	public void exitTypeDeclarationList(JavaParser.TypeDeclarationListContext ctx) {
		apply(ctx);
	}

	@Override
	public void exitIfStmt(JavaParser.IfStmtContext ctx) {
		apply(ctx);
	}

	@Override
	public void exitIfElseStmt(JavaParser.IfElseStmtContext ctx) {
		apply(ctx);
	}

	@Override
	public void exitForStmt(JavaParser.ForStmtContext ctx) {
		apply(ctx);
	}

	@Override
	public void exitWhileStmt(JavaParser.WhileStmtContext ctx) {
		apply(ctx);
	}

	@Override
	public void exitDoWhileStmt(JavaParser.DoWhileStmtContext ctx) {
		apply(ctx);
	}

	@Override
	public void exitLabelStmt(JavaParser.LabelStmtContext ctx) {
		apply(ctx);
	}

	@Override
	public void exitSwitchStmt(JavaParser.SwitchStmtContext ctx) {
		apply(ctx);
	}

	@Override
	public void exitSyncStmt(JavaParser.SyncStmtContext ctx) {
		apply(ctx);
	}

	@Override
	public void exitInitializer(JavaParser.InitializerContext ctx) {
		apply(ctx);
	}

	@Override
	public void exitArrayInitializer(JavaParser.ArrayInitializerContext ctx) {
		apply(ctx);
	}

	@Override
	public void exitElementValueArrayInitializer(JavaParser.ElementValueArrayInitializerContext ctx) {
		apply(ctx);
	}

	@Override
	public void exitImportDeclarationList(JavaParser.ImportDeclarationListContext ctx) {
		apply(ctx);
	}

	@Override
	public void exitPackageDeclaration(JavaParser.PackageDeclarationContext ctx) {
		apply(ctx);
	}

	@Override
	public void exitImportDeclaration(JavaParser.ImportDeclarationContext ctx) {
		apply(ctx);
	}

	@Override
	public void exitModifierList(JavaParser.ModifierListContext ctx) {
		apply(ctx);
	}

	@Override
	public void exitTypeParameters(JavaParser.TypeParametersContext ctx) {
		apply(ctx);
	}

	@Override
	public void exitTypeParameter(JavaParser.TypeParameterContext ctx) {
		apply(ctx);
	}

	@Override
	public void exitTypeBound(JavaParser.TypeBoundContext ctx) {
		apply(ctx);
	}

	@Override
	public void exitEnumConstants(JavaParser.EnumConstantsContext ctx) {
		apply(ctx);
	}

	@Override
	public void exitConstDeclarationList(JavaParser.ConstDeclarationListContext ctx) {
		apply(ctx);
	}

	@Override
	public void exitConstDeclaration(JavaParser.ConstDeclarationContext ctx) {
		apply(ctx);
	}

	@Override
	public void exitConstantDeclarator(JavaParser.ConstantDeclaratorContext ctx) {
		apply(ctx);
	}

	@Override
	public void exitVariableDeclarators(JavaParser.VariableDeclaratorsContext ctx) {
		apply(ctx);
	}

	@Override
	public void exitVariableDeclarator(JavaParser.VariableDeclaratorContext ctx) {
		apply(ctx);
	}

	@Override
	public void exitTypeArgument(JavaParser.TypeArgumentContext ctx) {
		apply(ctx);
	}

	@Override
	public void exitQualifiedNameList(JavaParser.QualifiedNameListContext ctx) {
		apply(ctx);
	}

	@Override
	public void exitFormalParameters(JavaParser.FormalParametersContext ctx) {
		apply(ctx);
	}

	@Override
	public void exitFormalParameterList(JavaParser.FormalParameterListContext ctx) {
		apply(ctx);
	}


	@Override
	public void exitLambdaLVTIList(JavaParser.LambdaLVTIListContext ctx) {
		apply(ctx);
	}

	@Override
	public void exitQualifiedName(JavaParser.QualifiedNameContext ctx) {
		apply(ctx);
	}

	@Override
	public void exitLiteral(JavaParser.LiteralContext ctx) {
		apply(ctx);
	}

	@Override
	public void exitIntegerLiteral(JavaParser.IntegerLiteralContext ctx) {
		apply(ctx);
	}

	@Override
	public void exitFloatLiteral(JavaParser.FloatLiteralContext ctx) {
		apply(ctx);
	}

	@Override
	public void exitAltAnnotationQualifiedName(JavaParser.AltAnnotationQualifiedNameContext ctx) {
		apply(ctx);
	}

	@Override
	public void exitAnnotationList(JavaParser.AnnotationListContext ctx) {
		apply(ctx);
	}

	@Override
	public void exitAnnotation(JavaParser.AnnotationContext ctx) {
		apply(ctx);
	}

	@Override
	public void exitElementValuePairs(JavaParser.ElementValuePairsContext ctx) {
		apply(ctx);
	}

	@Override
	public void exitElementValuePair(JavaParser.ElementValuePairContext ctx) {
		apply(ctx);
	}

	@Override
	public void exitElementValue(JavaParser.ElementValueContext ctx) {
		apply(ctx);
	}

	@Override
	public void exitAnnotationTypeElementDeclaration(JavaParser.AnnotationTypeElementDeclarationContext ctx) {
		apply(ctx);
	}

	@Override
	public void exitAnnotationTypeElementRest(JavaParser.AnnotationTypeElementRestContext ctx) {
		apply(ctx);
	}

	@Override
	public void exitAnnotationMethodOrConstantRest(JavaParser.AnnotationMethodOrConstantRestContext ctx) {
		apply(ctx);
	}

	@Override
	public void exitAnnotationMethodRest(JavaParser.AnnotationMethodRestContext ctx) {
		apply(ctx);
	}

	@Override
	public void exitAnnotationConstantRest(JavaParser.AnnotationConstantRestContext ctx) {
		apply(ctx);
	}

	@Override
	public void exitDefaultValue(JavaParser.DefaultValueContext ctx) {
		apply(ctx);
	}

	@Override
	public void exitModuleDeclaration(JavaParser.ModuleDeclarationContext ctx) {
		apply(ctx);
	}

	@Override
	public void exitModuleDirective(JavaParser.ModuleDirectiveContext ctx) {
		apply(ctx);
	}

	@Override
	public void exitRequiresModifier(JavaParser.RequiresModifierContext ctx) {
		apply(ctx);
	}

	@Override
	public void exitRecordHeader(JavaParser.RecordHeaderContext ctx) {
		apply(ctx);
	}

	@Override
	public void exitRecordComponentList(JavaParser.RecordComponentListContext ctx) {
		apply(ctx);
	}

	@Override
	public void exitRecordComponent(JavaParser.RecordComponentContext ctx) {
		apply(ctx);
	}

	@Override
	public void exitBlock(JavaParser.BlockContext ctx) {
		ctx.decBraceDepth(); // This statement must be placed before the @doOperation is called.
		apply(ctx);
	}

	@Override
	public void exitLocalVariableDeclaration(JavaParser.LocalVariableDeclarationContext ctx) {
		apply(ctx);
	}

	@Override
	public void exitIdentifier(JavaParser.IdentifierContext ctx) {
		apply(ctx);
	}

	@Override
	public void exitTypeIdentifier(JavaParser.TypeIdentifierContext ctx) {
		apply(ctx);
	}

	@Override
	public void exitCatchType(JavaParser.CatchTypeContext ctx) {
		apply(ctx);
	}

	@Override
	public void exitFinallyBlock(JavaParser.FinallyBlockContext ctx) {
		apply(ctx);
	}

	@Override
	public void exitResourceSpecification(JavaParser.ResourceSpecificationContext ctx) {
		apply(ctx);
	}

	@Override
	public void exitResources(JavaParser.ResourcesContext ctx) {
		apply(ctx);
	}

	@Override
	public void exitResource(JavaParser.ResourceContext ctx) {
		apply(ctx);
	}

	@Override
	public void exitSwitchLabel(JavaParser.SwitchLabelContext ctx) {
		apply(ctx);
	}

	@Override
	public void exitForControl(JavaParser.ForControlContext ctx) {
		apply(ctx);
	}

	@Override
	public void exitForInit(JavaParser.ForInitContext ctx) {
		apply(ctx);
	}

	@Override
	public void exitEnhancedForControl(JavaParser.EnhancedForControlContext ctx) {
		apply(ctx);
	}

	@Override
	public void exitParExpression(JavaParser.ParExpressionContext ctx) {
		apply(ctx);
	}

	@Override
	public void exitExpressionList(JavaParser.ExpressionListContext ctx) {
		apply(ctx);
	}

	@Override
	public void exitMethodCall(JavaParser.MethodCallContext ctx) {
		apply(ctx);
	}

	@Override
	public void exitExpression(JavaParser.ExpressionContext ctx) {
		apply(ctx);
	}

	@Override
	public void exitPattern(JavaParser.PatternContext ctx) {
		apply(ctx);
	}

	@Override
	public void exitLambdaExpression(JavaParser.LambdaExpressionContext ctx) {
		apply(ctx);
	}

	@Override
	public void exitLambdaParameters(JavaParser.LambdaParametersContext ctx) {
		apply(ctx);
	}

	@Override
	public void exitLambdaBody(JavaParser.LambdaBodyContext ctx) {
		apply(ctx);
	}

	@Override
	public void exitGuardedPattern(JavaParser.GuardedPatternContext ctx) {
		apply(ctx);
	}

	@Override
	public void exitClassType(JavaParser.ClassTypeContext ctx) {
		apply(ctx);
	}

	@Override
	public void exitCreator(JavaParser.CreatorContext ctx) {
		apply(ctx);
	}

	@Override
	public void exitCreatedName(JavaParser.CreatedNameContext ctx) {
		apply(ctx);
	}

	@Override
	public void exitInnerCreator(JavaParser.InnerCreatorContext ctx) {
		apply(ctx);
	}

	@Override
	public void exitArrayCreatorRest(JavaParser.ArrayCreatorRestContext ctx) {
		apply(ctx);
	}

	@Override
	public void exitClassCreatorRest(JavaParser.ClassCreatorRestContext ctx) {
		apply(ctx);
	}

	@Override
	public void exitExplicitGenericInvocation(JavaParser.ExplicitGenericInvocationContext ctx) {
		apply(ctx);
	}

	@Override
	public void exitTypeArgumentsOrDiamond(JavaParser.TypeArgumentsOrDiamondContext ctx) {
		apply(ctx);
	}

	@Override
	public void exitNonWildcardTypeArguments(JavaParser.NonWildcardTypeArgumentsContext ctx) {
		apply(ctx);
	}

	@Override
	public void exitTypeList(JavaParser.TypeListContext ctx) {
		apply(ctx);
	}

	@Override
	public void exitTypeDeclaration(JavaParser.TypeDeclarationContext ctx) {
		apply(ctx);
	}

	@Override
	public void exitEnumConstant(JavaParser.EnumConstantContext ctx) {
		apply(ctx);
	}

	@Override
	public void exitClassBodyDeclaration(JavaParser.ClassBodyDeclarationContext ctx) {
		apply(ctx);
	}

	@Override
	public void exitVariableDeclaratorId(JavaParser.VariableDeclaratorIdContext ctx) {
		apply(ctx);
	}

	@Override
	public void exitVariableInitializer(JavaParser.VariableInitializerContext ctx) {
		apply(ctx);
	}

	@Override
	public void exitClassOrInterfaceType(JavaParser.ClassOrInterfaceTypeContext ctx) {
		apply(ctx);
	}

	@Override
	public void exitLambdaLVTIParameter(JavaParser.LambdaLVTIParameterContext ctx) {
		apply(ctx);
	}

	@Override
	public void exitSwitchBlockStatementGroup(JavaParser.SwitchBlockStatementGroupContext ctx) {
		apply(ctx);
	}

	@Override
	public void exitLocalVariableDeclarationStmt(JavaParser.LocalVariableDeclarationStmtContext ctx) {
		apply(ctx);
	}

	@Override
	public void exitStatement(JavaParser.StatementContext ctx) {
		apply(ctx);
	}

	@Override
	public void exitAssertStmt(JavaParser.AssertStmtContext ctx) {
		apply(ctx);
	}

	@Override
	public void exitTryCatchStmt(JavaParser.TryCatchStmtContext ctx) {
		apply(ctx);
	}

	@Override
	public void exitTryResourceStmt(JavaParser.TryResourceStmtContext ctx) {
		apply(ctx);
	}

	@Override
	public void exitReturnStmt(JavaParser.ReturnStmtContext ctx) {
		apply(ctx);
	}

	@Override
	public void exitThrowStmt(JavaParser.ThrowStmtContext ctx) {
		apply(ctx);
	}

	@Override
	public void exitBreakStmt(JavaParser.BreakStmtContext ctx) {
		apply(ctx);
	}

	@Override
	public void exitContinueStmt(JavaParser.ContinueStmtContext ctx) {
		apply(ctx);
	}

	@Override
	public void exitYieldStmt(JavaParser.YieldStmtContext ctx) {
		apply(ctx);
	}

	@Override
	public void exitExpressionStmt(JavaParser.ExpressionStmtContext ctx) {
		apply(ctx);
	}

	@Override
	public void exitCatchClause(JavaParser.CatchClauseContext ctx) {
		apply(ctx);
	}

	@Override
	public void exitSwitchLabeledRule(JavaParser.SwitchLabeledRuleContext ctx) {
		apply(ctx);
	}

	@Override
	public void exitTypeType(JavaParser.TypeTypeContext ctx) {
		apply(ctx);
	}

	@Override
	public void exitPrimitiveType(JavaParser.PrimitiveTypeContext ctx) {
		apply(ctx);
	}

	@Override
	public void exitTypeArguments(JavaParser.TypeArgumentsContext ctx) {
		apply(ctx);
	}

	@Override
	public void exitSuperSuffix(JavaParser.SuperSuffixContext ctx) {
		apply(ctx);
	}

	@Override
	public void exitExplicitGenericInvocationSuffix(JavaParser.ExplicitGenericInvocationSuffixContext ctx) {
		apply(ctx);
	}

	@Override
	public void exitArguments(JavaParser.ArgumentsContext ctx) {
		apply(ctx);
	}
}
