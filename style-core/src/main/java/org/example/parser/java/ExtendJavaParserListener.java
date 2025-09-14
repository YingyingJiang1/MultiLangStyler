package org.example.parser.java;

import org.antlr.v4.runtime.tree.ParseTree;
import org.example.global.GlobalInfo;
import org.example.parser.common.ExtendListener;
import org.example.parser.common.ListenerState;
import org.example.parser.common.context.ExtendContext;
import org.example.parser.common.MyParser;
import org.example.parser.java.antlr.JavaParser;
import org.example.parser.java.antlr.JavaParserBaseListener;
import org.example.parser.java.antlr.JavaParserListener;
import org.example.style.InconsistencyInfo;
import org.example.styler.Stage;
import org.example.styler.Styler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/*
 * @author     : Jiang Yingying
 * @create     : 2024/1/22 17:32
 */
public class ExtendJavaParserListener extends JavaParserBaseListener implements ExtendListener {
	public static Logger logger = LoggerFactory.getLogger(JavaParserListener.class);
	public Stage stage;
	public List<Styler> enterStylers = new ArrayList<>();
	public List<Styler> exitStylers = new ArrayList<>();
	private MyParser parser;
	private ListenerState listenerState = new ListenerState();
	private List<InconsistencyInfo> infos = new ArrayList<>();

	public ExtendJavaParserListener(Stage stage, List<Styler> stylers, MyParser parser) {
		this.stage = stage;
		for (Styler styler : stylers) {
			if (styler.executeWhenExit) {
				exitStylers.add(styler);
			} else {
				enterStylers.add(styler);
			}
		}
		this.parser = parser;
	}

	public ExtendJavaParserListener(MyParser parser) {
		this.parser = parser;
	}

	public List<InconsistencyInfo> getInconsistencyInfos() {
		return infos;
	}

	private void doTask(ExtendContext ctx, List<Styler> stylers) {
		if (stage == Stage.EXTRACT) {
			for (Styler styler : stylers) {
				if (styler.isEnable(stage) && styler.isRelevant(ctx, stage,parser)) {
					try {
						styler.extractStyle(ctx,parser);
					} catch (Exception e) {
						logger.error("{} exception at stage {}.", styler.getClass().getSimpleName(), stage, e);
					}
				}
			}
		} else if (stage == Stage.APPLY) {
			ExtendContext newCtx = ctx;
			for (Styler styler : stylers) {
				if(styler.isEnable(stage) && styler.isRelevant(newCtx, stage,parser)) {
					try {
						newCtx = styler.applyStyle(newCtx,parser);
					} catch (Exception e) {
						logger.error("{} exception at stage {}.", styler.getClass().getSimpleName(), stage, e);
					}
				}
			}
		} else if (stage == Stage.ANALYZE) {
			for (Styler styler : stylers) {
				if(styler.isEnable(stage) && styler.isRelevant(ctx, stage,parser)) {
					try {
						List<InconsistencyInfo> ret = styler.analyzeInconsistency(ctx, parser);
						if (ret != null) {
							infos.addAll(ret);
						}
					} catch (Exception e) {
						logger.error("{} exception at stage {}.", styler.getClass().getSimpleName(), stage, e);
					}
				}
			}
		}
	}

	public ListenerState getListenerState() {
		return listenerState;
	}

	//--------------------------------------------------- enterxxx methods ---------------------------------------------------


	@Override
	public void enterStatement(JavaParser.StatementContext ctx) {
		doTask(ctx, enterStylers);
	}

	@Override
	public void enterBlock(JavaParser.BlockContext ctx) {
		if (parser.isStatement(ctx.parent)) {
			listenerState.curBlock = ctx;
		} else {
			listenerState.curMethodBody = ctx;
		}
		// ctx.deleteStatementCtx(parser); // Ensure delete statement context when entering block.
		ctx.incBraceDepth();
		doTask(ctx, enterStylers);
	}

	@Override
	public void enterBody(JavaParser.BodyContext ctx) {
		listenerState.curClassBody = ctx;
		ctx.incBraceDepth();
		doTask(ctx, enterStylers);
	}

	@Override
	public void enterTypeDeclaration(JavaParser.TypeDeclarationContext ctx) {
		// Change child of body to list-type nodes.
		ExtendContext body = ctx.getFirstCtxChildIf(child -> parser.isBody(child));
		body.expandChildren(parser);

		doTask(ctx, enterStylers);
	}

	@Override
	public void enterIfStmt(JavaParser.IfStmtContext ctx) {
		doTask(ctx, enterStylers);
	}

	@Override
	public void enterIfElseStmt(JavaParser.IfElseStmtContext ctx) {
		doTask(ctx, enterStylers);
	}

	@Override
	public void enterForStmt(JavaParser.ForStmtContext ctx) {
		doTask(ctx, enterStylers);
	}

	@Override
	public void enterWhileStmt(JavaParser.WhileStmtContext ctx) {
		doTask(ctx, enterStylers);
	}

	@Override
	public void enterDoWhileStmt(JavaParser.DoWhileStmtContext ctx) {
		doTask(ctx, enterStylers);
	}

	@Override
	public void enterSwitchStmt(JavaParser.SwitchStmtContext ctx) {
		doTask(ctx, enterStylers);
	}

	@Override
	public void enterTryCatchStmt(JavaParser.TryCatchStmtContext ctx) {
		doTask(ctx, enterStylers);
	}

	@Override
	public void enterTryResourceStmt(JavaParser.TryResourceStmtContext ctx) {
		doTask(ctx, enterStylers);
	}

	@Override
	public void enterConstructorDeclaration(JavaParser.ConstructorDeclarationContext ctx) {
		doTask(ctx, enterStylers);
	}

	@Override
	public void enterMethodDeclaration(JavaParser.MethodDeclarationContext ctx) {
		doTask(ctx, enterStylers);
	}

	@Override
	public void enterModifierList(JavaParser.ModifierListContext ctx) {
		doTask(ctx, enterStylers);
	}

	@Override
	public void enterSyncStmt(JavaParser.SyncStmtContext ctx) {
		doTask(ctx, enterStylers);
	}

	@Override
	public void enterInitializer(JavaParser.InitializerContext ctx) {
		doTask(ctx, enterStylers);
	}

	@Override
	public void enterArrayInitializer(JavaParser.ArrayInitializerContext ctx) {
		doTask(ctx, enterStylers);
	}

	@Override
	public void enterAnnotationList(JavaParser.AnnotationListContext ctx) {
		doTask(ctx, enterStylers);
	}

	@Override
	public void enterAnnotation(JavaParser.AnnotationContext ctx) {
		doTask(ctx, enterStylers);
	}

	@Override
	public void enterElementValueArrayInitializer(JavaParser.ElementValueArrayInitializerContext ctx) {
		doTask(ctx, enterStylers);
	}

	@Override
	public void enterSwitchBlockStatementGroup(JavaParser.SwitchBlockStatementGroupContext ctx) {
		doTask(ctx, enterStylers);
	}

	@Override
	public void enterLabelStmt(JavaParser.LabelStmtContext ctx) {
		doTask(ctx, enterStylers);
	}

	@Override
	public void enterTypeDeclarationList(JavaParser.TypeDeclarationListContext ctx) {
		doTask(ctx, enterStylers);
	}

	@Override
	public void enterInitializerList(JavaParser.InitializerListContext ctx) {
		doTask(ctx, enterStylers);
	}

	@Override
	public void enterFieldDeclarationList(JavaParser.FieldDeclarationListContext ctx) {
		doTask(ctx, enterStylers);
	}

	@Override
	public void enterConstructorDeclarationList(JavaParser.ConstructorDeclarationListContext ctx) {
		doTask(ctx, enterStylers);
	}

	@Override
	public void enterMethodDeclarationList(JavaParser.MethodDeclarationListContext ctx) {
		doTask(ctx, enterStylers);
	}

	@Override
	public void enterImportDeclarationList(JavaParser.ImportDeclarationListContext ctx) {
		doTask(ctx, enterStylers);
	}

	@Override
	public void enterCompilationUnit(JavaParser.CompilationUnitContext ctx) {
		doTask(ctx, enterStylers);
	}

	@Override
	public void enterParExpression(JavaParser.ParExpressionContext ctx) {
		doTask(ctx, enterStylers);
	}

	@Override
	public void enterExpression(JavaParser.ExpressionContext ctx) {
		doTask(ctx, enterStylers);
	}

	@Override
	public void enterFormalParameterList(JavaParser.FormalParameterListContext ctx) {
		doTask(ctx, enterStylers);
	}

	@Override
	public void enterLocalVariableDeclaration(JavaParser.LocalVariableDeclarationContext ctx) {
		doTask(ctx, enterStylers);
	}

	//--------------------------------------------------- exitxxx methods ---------------------------------------------------

	@Override
	public void exitCompilationUnit(JavaParser.CompilationUnitContext ctx) {
		ctx.expandChildIf(root -> root instanceof JavaParser.TypeDeclarationListContext);
		doTask(ctx, exitStylers);
	}

	@Override
	public void exitConstructorDeclaration(JavaParser.ConstructorDeclarationContext ctx) {
		doTask(ctx, exitStylers);
	}


	@Override
	public void exitConstructorDeclarationList(JavaParser.ConstructorDeclarationListContext ctx) {
		doTask(ctx, exitStylers);
	}

	@Override
	public void exitBody(JavaParser.BodyContext ctx) {
		ctx.expandChildIf(root -> root instanceof JavaParser.ClassBodyDeclarationContext);
		ctx.decBraceDepth();
		doTask(ctx, exitStylers);
	}

	@Override
	public void exitClassHead(JavaParser.ClassHeadContext ctx) {
		doTask(ctx, exitStylers);
	}

	@Override
	public void exitInterfaceHead(JavaParser.InterfaceHeadContext ctx) {
		doTask(ctx, exitStylers);
	}

	@Override
	public void exitRecordHead(JavaParser.RecordHeadContext ctx) {
		doTask(ctx, exitStylers);
	}

	@Override
	public void exitEnumHead(JavaParser.EnumHeadContext ctx) {
		doTask(ctx, exitStylers);
	}


	@Override
	public void exitAnnotationTypeHead(JavaParser.AnnotationTypeHeadContext ctx) {
		doTask(ctx, exitStylers);
	}

	@Override
	public void exitMethodHead(JavaParser.MethodHeadContext ctx) {
		
		doTask(ctx, exitStylers);
	}

	@Override
	public void exitConstructorHead(JavaParser.ConstructorHeadContext ctx) {
		
		doTask(ctx, exitStylers);
	}

	@Override
	public void exitFieldDeclaration(JavaParser.FieldDeclarationContext ctx) {
		doTask(ctx, exitStylers);
	}


	@Override
	public void exitFieldDeclarationList(JavaParser.FieldDeclarationListContext ctx) {
		doTask(ctx, exitStylers);
	}

	@Override
	public void exitInitializerList(JavaParser.InitializerListContext ctx) {
		doTask(ctx, exitStylers);
	}


	@Override
	public void exitMethodDeclaration(JavaParser.MethodDeclarationContext ctx) {
		doTask(ctx, exitStylers);
	}


	@Override
	public void exitMethodDeclarationList(JavaParser.MethodDeclarationListContext ctx) {
		doTask(ctx, exitStylers);
	}

	@Override
	public void exitTypeDeclarationList(JavaParser.TypeDeclarationListContext ctx) {
		doTask(ctx, exitStylers);
	}

	@Override
	public void exitIfStmt(JavaParser.IfStmtContext ctx) {
		// ctx.deleteStatementCtx(parser);
		doTask(ctx, exitStylers);
	}

	@Override
	public void exitIfElseStmt(JavaParser.IfElseStmtContext ctx) {
		// ctx.deleteStatementCtx(parser);
		doTask(ctx, exitStylers);
	}

	@Override
	public void exitForStmt(JavaParser.ForStmtContext ctx) {
		// ctx.deleteStatementCtx(parser);
		doTask(ctx, exitStylers);
	}

	@Override
	public void exitWhileStmt(JavaParser.WhileStmtContext ctx) {
		// ctx.deleteStatementCtx(parser);
		doTask(ctx, exitStylers);
	}

	@Override
	public void exitDoWhileStmt(JavaParser.DoWhileStmtContext ctx) {
		// ctx.deleteStatementCtx(parser);
		doTask(ctx, exitStylers);
	}

	@Override
	public void exitLabelStmt(JavaParser.LabelStmtContext ctx) {
		// ctx.deleteStatementCtx(parser);
		doTask(ctx, exitStylers);
	}

	@Override
	public void exitSwitchStmt(JavaParser.SwitchStmtContext ctx) {
		// ctx.deleteStatementCtx(parser);
		doTask(ctx, exitStylers);
	}

	@Override
	public void exitSyncStmt(JavaParser.SyncStmtContext ctx) {
		// ctx.deleteStatementCtx(parser);
		doTask(ctx, exitStylers);
	}

	@Override
	public void exitInitializer(JavaParser.InitializerContext ctx) {
		doTask(ctx, exitStylers);
	}

	@Override
	public void exitArrayInitializer(JavaParser.ArrayInitializerContext ctx) {
		doTask(ctx, exitStylers);
	}

	@Override
	public void exitElementValueArrayInitializer(JavaParser.ElementValueArrayInitializerContext ctx) {
		doTask(ctx, exitStylers);
	}

	@Override
	public void exitImportDeclarationList(JavaParser.ImportDeclarationListContext ctx) {
		doTask(ctx, exitStylers);
	}

	@Override
	public void exitPackageDeclaration(JavaParser.PackageDeclarationContext ctx) {
		// ctx.expandChildren(parser);
		doTask(ctx, exitStylers);
	}

	@Override
	public void exitImportDeclaration(JavaParser.ImportDeclarationContext ctx) {
		// ctx.expandChildren(parser);
		doTask(ctx, exitStylers);
	}

	@Override
	public void exitModifierList(JavaParser.ModifierListContext ctx) {
		doTask(ctx, exitStylers);
	}

	@Override
	public void exitTypeParameters(JavaParser.TypeParametersContext ctx) {
//		// ctx.expandChildren(parser);
		doTask(ctx, exitStylers);
	}

	@Override
	public void exitTypeParameter(JavaParser.TypeParameterContext ctx) {
		// ctx.expandChildren(parser);
		doTask(ctx, exitStylers);
	}

	@Override
	public void exitTypeBound(JavaParser.TypeBoundContext ctx) {
		// ctx.expandChildren(parser);
		doTask(ctx, exitStylers);
	}

	@Override
	public void exitEnumConstants(JavaParser.EnumConstantsContext ctx) {
		// ctx.expandChildren(parser);
		doTask(ctx, exitStylers);
	}

	@Override
	public void exitConstDeclarationList(JavaParser.ConstDeclarationListContext ctx) {
		// ctx.expandChildren(parser);
		doTask(ctx, exitStylers);
	}

	@Override
	public void exitConstDeclaration(JavaParser.ConstDeclarationContext ctx) {
		// ctx.expandChildren(parser);
		doTask(ctx, exitStylers);
	}

	@Override
	public void exitConstantDeclarator(JavaParser.ConstantDeclaratorContext ctx) {
		// ctx.expandChildren(parser);
		doTask(ctx, exitStylers);
	}

	@Override
	public void exitVariableDeclarators(JavaParser.VariableDeclaratorsContext ctx) {
		doTask(ctx, exitStylers);
	}

	@Override
	public void exitVariableDeclarator(JavaParser.VariableDeclaratorContext ctx) {
		// ctx.expandChildren(parser);
		doTask(ctx, exitStylers);
	}


	@Override
	public void exitTypeArgument(JavaParser.TypeArgumentContext ctx) {
		// ctx.expandChildren(parser);
		doTask(ctx, exitStylers);
	}

	@Override
	public void exitQualifiedNameList(JavaParser.QualifiedNameListContext ctx) {
		// ctx.expandChildren(parser);
		doTask(ctx, exitStylers);
	}

	@Override
	public void exitFormalParameters(JavaParser.FormalParametersContext ctx) {
		doTask(ctx, exitStylers);
	}


	@Override
	public void exitFormalParameterList(JavaParser.FormalParameterListContext ctx) {
		doTask(ctx, exitStylers);
	}


	@Override
	public void exitLambdaLVTIList(JavaParser.LambdaLVTIListContext ctx) {
		// ctx.expandChildren(parser);
		doTask(ctx, exitStylers);
	}

	@Override
	public void exitQualifiedName(JavaParser.QualifiedNameContext ctx) {
		// ctx.expandChildren(parser);
		doTask(ctx, exitStylers);
	}

	@Override
	public void exitLiteral(JavaParser.LiteralContext ctx) {
//		// ctx.expandChildren(parser);
		doTask(ctx, exitStylers);
	}

	@Override
	public void exitIntegerLiteral(JavaParser.IntegerLiteralContext ctx) {
//		// ctx.expandChildren(parser);
		doTask(ctx, exitStylers);
	}

	@Override
	public void exitFloatLiteral(JavaParser.FloatLiteralContext ctx) {
//		// ctx.expandChildren(parser);
		doTask(ctx, exitStylers);
	}

	@Override
	public void exitAltAnnotationQualifiedName(JavaParser.AltAnnotationQualifiedNameContext ctx) {
		// ctx.expandChildren(parser);
		doTask(ctx, exitStylers);
	}

	@Override
	public void exitAnnotationList(JavaParser.AnnotationListContext ctx) {
		doTask(ctx, exitStylers);
	}

	@Override
	public void exitAnnotation(JavaParser.AnnotationContext ctx) {
		// ctx.expandChildren(parser);
		doTask(ctx, exitStylers);
	}

	@Override
	public void exitElementValuePairs(JavaParser.ElementValuePairsContext ctx) {
		// ctx.expandChildren(parser);
		doTask(ctx, exitStylers);
	}

	@Override
	public void exitElementValuePair(JavaParser.ElementValuePairContext ctx) {
		// ctx.expandChildren(parser);
		doTask(ctx, exitStylers);
	}

	@Override
	public void exitElementValue(JavaParser.ElementValueContext ctx) {
		// ctx.expandChildren(parser);
		doTask(ctx, exitStylers);
	}

	@Override
	public void exitAnnotationTypeElementDeclaration(JavaParser.AnnotationTypeElementDeclarationContext ctx) {
		// ctx.expandChildren(parser);
		doTask(ctx, exitStylers);
	}

	@Override
	public void exitAnnotationTypeElementRest(JavaParser.AnnotationTypeElementRestContext ctx) {
		// ctx.expandChildren(parser);
		doTask(ctx, exitStylers);
	}

	@Override
	public void exitAnnotationMethodOrConstantRest(JavaParser.AnnotationMethodOrConstantRestContext ctx) {
		// ctx.expandChildren(parser);
		doTask(ctx, exitStylers);
	}

	@Override
	public void exitAnnotationMethodRest(JavaParser.AnnotationMethodRestContext ctx) {
		// ctx.expandChildren(parser);
		doTask(ctx, exitStylers);
	}

	@Override
	public void exitAnnotationConstantRest(JavaParser.AnnotationConstantRestContext ctx) {
		// ctx.expandChildren(parser);
		doTask(ctx, exitStylers);
	}

	@Override
	public void exitDefaultValue(JavaParser.DefaultValueContext ctx) {
		// ctx.expandChildren(parser);
		doTask(ctx, exitStylers);
	}

	@Override
	public void exitModuleDeclaration(JavaParser.ModuleDeclarationContext ctx) {
		// ctx.expandChildren(parser);
		doTask(ctx, exitStylers);
	}

	@Override
	public void exitModuleDirective(JavaParser.ModuleDirectiveContext ctx) {
		// ctx.expandChildren(parser);
		doTask(ctx, exitStylers);
	}

	@Override
	public void exitRequiresModifier(JavaParser.RequiresModifierContext ctx) {
		// ctx.expandChildren(parser);
		doTask(ctx, exitStylers);
	}

	@Override
	public void exitRecordHeader(JavaParser.RecordHeaderContext ctx) {
		// ctx.expandChildren(parser);
		doTask(ctx, exitStylers);
	}

	@Override
	public void exitRecordComponentList(JavaParser.RecordComponentListContext ctx) {
		// ctx.expandChildren(parser);
		doTask(ctx, exitStylers);
	}

	@Override
	public void exitRecordComponent(JavaParser.RecordComponentContext ctx) {
		// ctx.expandChildren(parser);
		doTask(ctx, exitStylers);
	}

	@Override
	public void exitBlock(JavaParser.BlockContext ctx) {
		ctx.decBraceDepth(); // This statement must be placed before the @doOperation is called.
		doTask(ctx, exitStylers);
	}

	@Override
	public void exitLocalVariableDeclaration(JavaParser.LocalVariableDeclarationContext ctx) {
		doTask(ctx, exitStylers);
	}

	@Override
	public void exitIdentifier(JavaParser.IdentifierContext ctx) {
		// ctx.expandChildren(parser);
		doTask(ctx, exitStylers);
	}

	@Override
	public void exitTypeIdentifier(JavaParser.TypeIdentifierContext ctx) {
		// ctx.expandChildren(parser);
		doTask(ctx, exitStylers);
	}

	@Override
	public void exitCatchType(JavaParser.CatchTypeContext ctx) {
		// ctx.expandChildren(parser);
		doTask(ctx, exitStylers);
	}

	@Override
	public void exitFinallyBlock(JavaParser.FinallyBlockContext ctx) {
		// ctx.expandChildren(parser);
		doTask(ctx, exitStylers);
	}

	@Override
	public void exitResourceSpecification(JavaParser.ResourceSpecificationContext ctx) {
		// ctx.expandChildren(parser);
		doTask(ctx, exitStylers);
	}

	@Override
	public void exitResources(JavaParser.ResourcesContext ctx) {
		// ctx.expandChildren(parser);
		doTask(ctx, exitStylers);
	}

	@Override
	public void exitResource(JavaParser.ResourceContext ctx) {
		// ctx.expandChildren(parser);
		doTask(ctx, exitStylers);
	}

	@Override
	public void exitSwitchLabel(JavaParser.SwitchLabelContext ctx) {
		// ctx.expandChildren(parser);
		doTask(ctx, exitStylers);
	}

	@Override
	public void exitForControl(JavaParser.ForControlContext ctx) {
		// // ctx.expandChildren(parser);
		doTask(ctx, exitStylers);
	}

	@Override
	public void exitForInit(JavaParser.ForInitContext ctx) {
		// ctx.expandChildren(parser);
		doTask(ctx, exitStylers);
	}

	@Override
	public void exitEnhancedForControl(JavaParser.EnhancedForControlContext ctx) {
		// ctx.expandChildren(parser);
		doTask(ctx, exitStylers);
	}

	@Override
	public void exitParExpression(JavaParser.ParExpressionContext ctx) {
		// // ctx.expandChildren(parser);
		doTask(ctx, exitStylers);
	}

	@Override
	public void exitExpressionList(JavaParser.ExpressionListContext ctx) {
		// ctx.expandChildren(parser);
		doTask(ctx, exitStylers);
	}

	@Override
	public void exitMethodCall(JavaParser.MethodCallContext ctx) {
		// ctx.expandChildren(parser);
		doTask(ctx, exitStylers);
	}

	@Override
	public void exitExpression(JavaParser.ExpressionContext ctx) {
		// // ctx.expandChildren(parser);
		doTask(ctx, exitStylers);
	}

	@Override
	public void exitPattern(JavaParser.PatternContext ctx) {
		// ctx.expandChildren(parser);
		doTask(ctx, exitStylers);
	}

	@Override
	public void exitLambdaExpression(JavaParser.LambdaExpressionContext ctx) {
		// ctx.expandChildren(parser);
		doTask(ctx, exitStylers);
	}

	@Override
	public void exitLambdaParameters(JavaParser.LambdaParametersContext ctx) {
		// ctx.expandChildren(parser);
		doTask(ctx, exitStylers);
	}

	@Override
	public void exitLambdaBody(JavaParser.LambdaBodyContext ctx) {
		// ctx.expandChildren(parser);
		doTask(ctx, exitStylers);
	}

	@Override
	public void exitGuardedPattern(JavaParser.GuardedPatternContext ctx) {
		// ctx.expandChildren(parser);
		doTask(ctx, exitStylers);
	}

	@Override
	public void exitClassType(JavaParser.ClassTypeContext ctx) {
		// ctx.expandChildren(parser);
		doTask(ctx, exitStylers);
	}

	@Override
	public void exitCreator(JavaParser.CreatorContext ctx) {
		// ctx.expandChildren(parser);
		doTask(ctx, exitStylers);
	}

	@Override
	public void exitCreatedName(JavaParser.CreatedNameContext ctx) {
		// ctx.expandChildren(parser);
		doTask(ctx, exitStylers);
	}

	@Override
	public void exitInnerCreator(JavaParser.InnerCreatorContext ctx) {
		// ctx.expandChildren(parser);
		doTask(ctx, exitStylers);
	}

	@Override
	public void exitArrayCreatorRest(JavaParser.ArrayCreatorRestContext ctx) {
		// ctx.expandChildren(parser);
		doTask(ctx, exitStylers);
	}

	@Override
	public void exitClassCreatorRest(JavaParser.ClassCreatorRestContext ctx) {
		// ctx.expandChildren(parser);
		doTask(ctx, exitStylers);
	}

	@Override
	public void exitExplicitGenericInvocation(JavaParser.ExplicitGenericInvocationContext ctx) {
		// ctx.expandChildren(parser);
		doTask(ctx, exitStylers);
	}

	@Override
	public void exitTypeArgumentsOrDiamond(JavaParser.TypeArgumentsOrDiamondContext ctx) {
		// ctx.expandChildren(parser);
		doTask(ctx, exitStylers);
	}

	@Override
	public void exitNonWildcardTypeArguments(JavaParser.NonWildcardTypeArgumentsContext ctx) {
		// ctx.expandChildren(parser);
		doTask(ctx, exitStylers);
	}

	@Override
	public void exitTypeList(JavaParser.TypeListContext ctx) {
		// ctx.expandChildren(parser);
		doTask(ctx, exitStylers);
	}

	@Override
	public void exitTypeDeclaration(JavaParser.TypeDeclarationContext ctx) {
		doTask(ctx, exitStylers);
	}

	@Override
	public void exitEnumConstant(JavaParser.EnumConstantContext ctx) {
		doTask(ctx, exitStylers);
	}

	@Override
	public void exitClassBodyDeclaration(JavaParser.ClassBodyDeclarationContext ctx) {
		doTask(ctx, exitStylers);
	}

	@Override
	public void exitVariableDeclaratorId(JavaParser.VariableDeclaratorIdContext ctx) {
		doTask(ctx, exitStylers);
	}

	@Override
	public void exitVariableInitializer(JavaParser.VariableInitializerContext ctx) {
		doTask(ctx, exitStylers);
	}

	@Override
	public void exitClassOrInterfaceType(JavaParser.ClassOrInterfaceTypeContext ctx) {
		doTask(ctx, exitStylers);
	}

	@Override
	public void exitLambdaLVTIParameter(JavaParser.LambdaLVTIParameterContext ctx) {
		doTask(ctx, exitStylers);
	}

	@Override
	public void exitSwitchBlockStatementGroup(JavaParser.SwitchBlockStatementGroupContext ctx) {
		doTask(ctx, exitStylers);
	}

	@Override
	public void exitLocalVariableDeclarationStmt(JavaParser.LocalVariableDeclarationStmtContext ctx) {
		// ctx.deleteStatementCtx(parser);
		doTask(ctx, exitStylers);
	}

	@Override
	public void exitStatement(JavaParser.StatementContext ctx) {
		// ctx.deleteStatementCtx(parser);
		doTask(ctx, exitStylers);
	}

	@Override
	public void exitAssertStmt(JavaParser.AssertStmtContext ctx) {
		// ctx.deleteStatementCtx(parser);
		doTask(ctx, exitStylers);
	}

	@Override
	public void exitTryCatchStmt(JavaParser.TryCatchStmtContext ctx) {
		// ctx.deleteStatementCtx(parser);
		doTask(ctx, exitStylers);
	}

	@Override
	public void exitTryResourceStmt(JavaParser.TryResourceStmtContext ctx) {
		// ctx.deleteStatementCtx(parser);
		doTask(ctx, exitStylers);
	}

	@Override
	public void exitReturnStmt(JavaParser.ReturnStmtContext ctx) {
		// ctx.deleteStatementCtx(parser);
		doTask(ctx, exitStylers);
	}

	@Override
	public void exitThrowStmt(JavaParser.ThrowStmtContext ctx) {
		// ctx.deleteStatementCtx(parser);
		doTask(ctx, exitStylers);
	}

	@Override
	public void exitBreakStmt(JavaParser.BreakStmtContext ctx) {
		// ctx.deleteStatementCtx(parser);
		doTask(ctx, exitStylers);
	}

	@Override
	public void exitContinueStmt(JavaParser.ContinueStmtContext ctx) {
		// ctx.deleteStatementCtx(parser);
		doTask(ctx, exitStylers);
	}

	@Override
	public void exitYieldStmt(JavaParser.YieldStmtContext ctx) {
		// ctx.deleteStatementCtx(parser);
		doTask(ctx, exitStylers);
	}

	@Override
	public void exitExpressionStmt(JavaParser.ExpressionStmtContext ctx) {
		// ctx.deleteStatementCtx(parser);
		doTask(ctx, exitStylers);
	}



	@Override
	public void exitCatchClause(JavaParser.CatchClauseContext ctx) {
		doTask(ctx, exitStylers);
	}

	@Override
	public void exitSwitchLabeledRule(JavaParser.SwitchLabeledRuleContext ctx) {
		doTask(ctx, exitStylers);
	}

	@Override
	public void exitTypeType(JavaParser.TypeTypeContext ctx) {
		doTask(ctx, exitStylers);
	}

	@Override
	public void exitPrimitiveType(JavaParser.PrimitiveTypeContext ctx) {
		doTask(ctx, exitStylers);
	}

	@Override
	public void exitTypeArguments(JavaParser.TypeArgumentsContext ctx) {
		// ctx.expandChildren(parser);
		doTask(ctx, exitStylers);
	}

	@Override
	public void exitSuperSuffix(JavaParser.SuperSuffixContext ctx) {
		// ctx.expandChildren(parser);
		doTask(ctx, exitStylers);
	}

	@Override
	public void exitExplicitGenericInvocationSuffix(JavaParser.ExplicitGenericInvocationSuffixContext ctx) {
		// ctx.expandChildren(parser);
		doTask(ctx, exitStylers);
	}

	@Override
	public void exitArguments(JavaParser.ArgumentsContext ctx) {
		// ctx.expandChildren(parser);
		doTask(ctx, exitStylers);
	}

}
