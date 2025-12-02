// Generated from .\cpp\CPPParser.g4 by ANTLR 4.9.3
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CPPParser extends CPPParserBase {
	static { RuntimeMetaData.checkVersion("4.9.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		IntegerLiteral=1, CharacterLiteral=2, FloatingLiteral=3, StringLiteral=4, 
		BooleanLiteral=5, PointerLiteral=6, UserDefinedLiteral=7, MultiLineMacro=8, 
		Directive=9, Alignas=10, Alignof=11, Asm=12, Auto=13, Bool=14, Break=15, 
		Case=16, Catch=17, Char=18, Char16=19, Char32=20, Class=21, Const=22, 
		Constexpr=23, Const_cast=24, Continue=25, Decltype=26, Default=27, Delete=28, 
		Do=29, Double=30, Dynamic_cast=31, Else=32, Enum=33, Explicit=34, Export=35, 
		Extern=36, False_=37, Final=38, Float=39, For=40, Friend=41, Goto=42, 
		If=43, Inline=44, Int=45, Long=46, Mutable=47, Namespace=48, New=49, Noexcept=50, 
		Nullptr=51, Operator=52, Override=53, Private=54, Protected=55, Public=56, 
		Register=57, Reinterpret_cast=58, Return=59, Short=60, Signed=61, Sizeof=62, 
		Static=63, Static_assert=64, Static_cast=65, Struct=66, Switch=67, Template=68, 
		This=69, Thread_local=70, Throw=71, True_=72, Try=73, Typedef=74, Typeid_=75, 
		Typename_=76, Union=77, Unsigned=78, Using=79, Virtual=80, Void=81, Volatile=82, 
		Wchar=83, While=84, LeftParen=85, RightParen=86, LeftBracket=87, RightBracket=88, 
		LeftBrace=89, RightBrace=90, Plus=91, Minus=92, Star=93, Div=94, Mod=95, 
		Caret=96, And=97, Or=98, Tilde=99, Not=100, Assign=101, Less=102, Greater=103, 
		PlusAssign=104, MinusAssign=105, StarAssign=106, DivAssign=107, ModAssign=108, 
		XorAssign=109, AndAssign=110, OrAssign=111, LeftShiftAssign=112, RightShiftAssign=113, 
		Equal=114, NotEqual=115, LessEqual=116, GreaterEqual=117, AndAnd=118, 
		OrOr=119, PlusPlus=120, MinusMinus=121, Comma=122, ArrowStar=123, Arrow=124, 
		Question=125, Colon=126, Doublecolon=127, Semi=128, Dot=129, DotStar=130, 
		Ellipsis=131, Identifier=132, DecimalLiteral=133, OctalLiteral=134, HexadecimalLiteral=135, 
		BinaryLiteral=136, Integersuffix=137, UserDefinedIntegerLiteral=138, UserDefinedFloatingLiteral=139, 
		UserDefinedStringLiteral=140, UserDefinedCharacterLiteral=141, Whitespace=142, 
		Newline=143, BlockComment=144, LineComment=145;
	public static final int
		RULE_translationUnit = 0, RULE_primaryExpression = 1, RULE_idExpression = 2, 
		RULE_unqualifiedId = 3, RULE_qualifiedId = 4, RULE_nestedNameSpecifier = 5, 
		RULE_lambdaExpression = 6, RULE_lambdaIntroducer = 7, RULE_lambdaCapture = 8, 
		RULE_captureDefault = 9, RULE_captureList = 10, RULE_capture = 11, RULE_simpleCapture = 12, 
		RULE_initcapture = 13, RULE_lambdaDeclarator = 14, RULE_postfixExpression = 15, 
		RULE_typeIdOfTheTypeId = 16, RULE_expressionList = 17, RULE_pseudoDestructorName = 18, 
		RULE_unaryExpression = 19, RULE_unaryOperator = 20, RULE_newExpression_ = 21, 
		RULE_newPlacement = 22, RULE_newTypeId = 23, RULE_newDeclarator_ = 24, 
		RULE_noPointerNewDeclarator = 25, RULE_newInitializer_ = 26, RULE_deleteExpression = 27, 
		RULE_noExceptExpression = 28, RULE_castExpression = 29, RULE_pointerMemberExpression = 30, 
		RULE_multiplicativeExpression = 31, RULE_additiveExpression = 32, RULE_shiftExpression = 33, 
		RULE_shiftOperator = 34, RULE_relationalExpression = 35, RULE_equalityExpression = 36, 
		RULE_andExpression = 37, RULE_exclusiveOrExpression = 38, RULE_inclusiveOrExpression = 39, 
		RULE_logicalAndExpression = 40, RULE_logicalOrExpression = 41, RULE_conditionalExpression = 42, 
		RULE_assignmentExpression = 43, RULE_assignmentOperator = 44, RULE_expression = 45, 
		RULE_constantExpression = 46, RULE_statement = 47, RULE_labeledStatement = 48, 
		RULE_expressionStatement = 49, RULE_block = 50, RULE_statementSeq = 51, 
		RULE_ifStatement = 52, RULE_ifElseStatement = 53, RULE_switchStatement = 54, 
		RULE_condition = 55, RULE_whileStatement = 56, RULE_doWhileStatement = 57, 
		RULE_forStatement = 58, RULE_forInitStatement = 59, RULE_forRangeDeclaration = 60, 
		RULE_forRangeInitializer = 61, RULE_jumpStatement = 62, RULE_declarationStatement = 63, 
		RULE_declarationseq = 64, RULE_declaration = 65, RULE_blockDeclaration = 66, 
		RULE_aliasDeclaration = 67, RULE_simpleDeclaration = 68, RULE_staticAssertDeclaration = 69, 
		RULE_emptyDeclaration_ = 70, RULE_attributeDeclaration = 71, RULE_declSpecifier = 72, 
		RULE_declSpecifierSeq = 73, RULE_storageClassSpecifier = 74, RULE_functionSpecifier = 75, 
		RULE_typedefName = 76, RULE_typeSpecifier = 77, RULE_trailingTypeSpecifier = 78, 
		RULE_typeSpecifierSeq = 79, RULE_trailingTypeSpecifierSeq = 80, RULE_simpleTypeLengthModifier = 81, 
		RULE_simpleTypeSignednessModifier = 82, RULE_simpleTypeSpecifier = 83, 
		RULE_theTypeName = 84, RULE_decltypeSpecifier = 85, RULE_elaboratedTypeSpecifier = 86, 
		RULE_enumName = 87, RULE_enumSpecifier = 88, RULE_enumHead = 89, RULE_opaqueEnumDeclaration = 90, 
		RULE_enumkey = 91, RULE_enumbase = 92, RULE_enumeratorList = 93, RULE_enumeratorDefinition = 94, 
		RULE_enumerator = 95, RULE_namespaceName = 96, RULE_originalNamespaceName = 97, 
		RULE_namespaceDefinition = 98, RULE_namespaceAlias = 99, RULE_namespaceAliasDefinition = 100, 
		RULE_qualifiednamespacespecifier = 101, RULE_usingDeclaration = 102, RULE_usingDirective = 103, 
		RULE_asmDefinition = 104, RULE_linkageSpecification = 105, RULE_attributeSpecifierSeq = 106, 
		RULE_attributeSpecifier = 107, RULE_alignmentspecifier = 108, RULE_attributeList = 109, 
		RULE_attribute = 110, RULE_attributeNamespace = 111, RULE_attributeArgumentClause = 112, 
		RULE_balancedTokenSeq = 113, RULE_balancedtoken = 114, RULE_initDeclaratorList = 115, 
		RULE_initDeclarator = 116, RULE_declarator = 117, RULE_pointerDeclarator = 118, 
		RULE_noPointerDeclarator = 119, RULE_parametersAndQualifiers = 120, RULE_trailingReturnType = 121, 
		RULE_pointerOperator = 122, RULE_cvqualifierseq = 123, RULE_cvQualifier = 124, 
		RULE_refqualifier = 125, RULE_declaratorid = 126, RULE_theTypeId = 127, 
		RULE_abstractDeclarator = 128, RULE_pointerAbstractDeclarator = 129, RULE_noPointerAbstractDeclarator = 130, 
		RULE_abstractPackDeclarator = 131, RULE_noPointerAbstractPackDeclarator = 132, 
		RULE_parameterDeclarationClause = 133, RULE_parameterDeclarationList = 134, 
		RULE_parameterDeclaration = 135, RULE_functionDefinition = 136, RULE_functionBody = 137, 
		RULE_initializer = 138, RULE_braceOrEqualInitializer = 139, RULE_initializerClause = 140, 
		RULE_initializerList = 141, RULE_bracedInitList = 142, RULE_className = 143, 
		RULE_classSpecifier = 144, RULE_classHead = 145, RULE_classHeadName = 146, 
		RULE_classVirtSpecifier = 147, RULE_classKey = 148, RULE_memberSpecification = 149, 
		RULE_memberdeclaration = 150, RULE_memberDeclaratorList = 151, RULE_memberDeclarator = 152, 
		RULE_virtualSpecifierSeq = 153, RULE_virtualSpecifier = 154, RULE_pureSpecifier = 155, 
		RULE_baseClause = 156, RULE_baseSpecifierList = 157, RULE_baseSpecifier = 158, 
		RULE_classOrDeclType = 159, RULE_baseTypeSpecifier = 160, RULE_accessSpecifier = 161, 
		RULE_conversionFunctionId = 162, RULE_conversionTypeId = 163, RULE_conversionDeclarator = 164, 
		RULE_constructorInitializer = 165, RULE_memInitializerList = 166, RULE_memInitializer = 167, 
		RULE_meminitializerid = 168, RULE_operatorFunctionId = 169, RULE_literalOperatorId = 170, 
		RULE_templateDeclaration = 171, RULE_templateparameterList = 172, RULE_templateParameter = 173, 
		RULE_typeParameter = 174, RULE_simpleTemplateId = 175, RULE_templateId = 176, 
		RULE_templateName = 177, RULE_templateArgumentList = 178, RULE_templateArgument = 179, 
		RULE_typeNameSpecifier = 180, RULE_explicitInstantiation = 181, RULE_explicitSpecialization = 182, 
		RULE_tryBlock = 183, RULE_functionTryBlock = 184, RULE_handlerSeq = 185, 
		RULE_handler = 186, RULE_exceptionDeclaration = 187, RULE_throwExpression = 188, 
		RULE_exceptionSpecification = 189, RULE_dynamicExceptionSpecification = 190, 
		RULE_typeIdList = 191, RULE_noeExceptSpecification = 192, RULE_theOperator = 193, 
		RULE_literal = 194;
	private static String[] makeRuleNames() {
		return new String[] {
			"translationUnit", "primaryExpression", "idExpression", "unqualifiedId", 
			"qualifiedId", "nestedNameSpecifier", "lambdaExpression", "lambdaIntroducer", 
			"lambdaCapture", "captureDefault", "captureList", "capture", "simpleCapture", 
			"initcapture", "lambdaDeclarator", "postfixExpression", "typeIdOfTheTypeId", 
			"expressionList", "pseudoDestructorName", "unaryExpression", "unaryOperator", 
			"newExpression_", "newPlacement", "newTypeId", "newDeclarator_", "noPointerNewDeclarator", 
			"newInitializer_", "deleteExpression", "noExceptExpression", "castExpression", 
			"pointerMemberExpression", "multiplicativeExpression", "additiveExpression", 
			"shiftExpression", "shiftOperator", "relationalExpression", "equalityExpression", 
			"andExpression", "exclusiveOrExpression", "inclusiveOrExpression", "logicalAndExpression", 
			"logicalOrExpression", "conditionalExpression", "assignmentExpression", 
			"assignmentOperator", "expression", "constantExpression", "statement", 
			"labeledStatement", "expressionStatement", "block", "statementSeq", "ifStatement", 
			"ifElseStatement", "switchStatement", "condition", "whileStatement", 
			"doWhileStatement", "forStatement", "forInitStatement", "forRangeDeclaration", 
			"forRangeInitializer", "jumpStatement", "declarationStatement", "declarationseq", 
			"declaration", "blockDeclaration", "aliasDeclaration", "simpleDeclaration", 
			"staticAssertDeclaration", "emptyDeclaration_", "attributeDeclaration", 
			"declSpecifier", "declSpecifierSeq", "storageClassSpecifier", "functionSpecifier", 
			"typedefName", "typeSpecifier", "trailingTypeSpecifier", "typeSpecifierSeq", 
			"trailingTypeSpecifierSeq", "simpleTypeLengthModifier", "simpleTypeSignednessModifier", 
			"simpleTypeSpecifier", "theTypeName", "decltypeSpecifier", "elaboratedTypeSpecifier", 
			"enumName", "enumSpecifier", "enumHead", "opaqueEnumDeclaration", "enumkey", 
			"enumbase", "enumeratorList", "enumeratorDefinition", "enumerator", "namespaceName", 
			"originalNamespaceName", "namespaceDefinition", "namespaceAlias", "namespaceAliasDefinition", 
			"qualifiednamespacespecifier", "usingDeclaration", "usingDirective", 
			"asmDefinition", "linkageSpecification", "attributeSpecifierSeq", "attributeSpecifier", 
			"alignmentspecifier", "attributeList", "attribute", "attributeNamespace", 
			"attributeArgumentClause", "balancedTokenSeq", "balancedtoken", "initDeclaratorList", 
			"initDeclarator", "declarator", "pointerDeclarator", "noPointerDeclarator", 
			"parametersAndQualifiers", "trailingReturnType", "pointerOperator", "cvqualifierseq", 
			"cvQualifier", "refqualifier", "declaratorid", "theTypeId", "abstractDeclarator", 
			"pointerAbstractDeclarator", "noPointerAbstractDeclarator", "abstractPackDeclarator", 
			"noPointerAbstractPackDeclarator", "parameterDeclarationClause", "parameterDeclarationList", 
			"parameterDeclaration", "functionDefinition", "functionBody", "initializer", 
			"braceOrEqualInitializer", "initializerClause", "initializerList", "bracedInitList", 
			"className", "classSpecifier", "classHead", "classHeadName", "classVirtSpecifier", 
			"classKey", "memberSpecification", "memberdeclaration", "memberDeclaratorList", 
			"memberDeclarator", "virtualSpecifierSeq", "virtualSpecifier", "pureSpecifier", 
			"baseClause", "baseSpecifierList", "baseSpecifier", "classOrDeclType", 
			"baseTypeSpecifier", "accessSpecifier", "conversionFunctionId", "conversionTypeId", 
			"conversionDeclarator", "constructorInitializer", "memInitializerList", 
			"memInitializer", "meminitializerid", "operatorFunctionId", "literalOperatorId", 
			"templateDeclaration", "templateparameterList", "templateParameter", 
			"typeParameter", "simpleTemplateId", "templateId", "templateName", "templateArgumentList", 
			"templateArgument", "typeNameSpecifier", "explicitInstantiation", "explicitSpecialization", 
			"tryBlock", "functionTryBlock", "handlerSeq", "handler", "exceptionDeclaration", 
			"throwExpression", "exceptionSpecification", "dynamicExceptionSpecification", 
			"typeIdList", "noeExceptSpecification", "theOperator", "literal"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, "'alignas'", 
			"'alignof'", "'asm'", "'auto'", "'bool'", "'break'", "'case'", "'catch'", 
			"'char'", "'char16_t'", "'char32_t'", "'class'", "'const'", "'constexpr'", 
			"'const_cast'", "'continue'", "'decltype'", "'default'", "'delete'", 
			"'do'", "'double'", "'dynamic_cast'", "'else'", "'enum'", "'explicit'", 
			"'export'", "'extern'", "'false'", "'final'", "'float'", "'for'", "'friend'", 
			"'goto'", "'if'", "'inline'", "'int'", "'long'", "'mutable'", "'namespace'", 
			"'new'", "'noexcept'", "'nullptr'", "'operator'", "'override'", "'private'", 
			"'protected'", "'public'", "'register'", "'reinterpret_cast'", "'return'", 
			"'short'", "'signed'", "'sizeof'", "'static'", "'static_assert'", "'static_cast'", 
			"'struct'", "'switch'", "'template'", "'this'", "'thread_local'", "'throw'", 
			"'true'", "'try'", "'typedef'", "'typeid'", "'typename'", "'union'", 
			"'unsigned'", "'using'", "'virtual'", "'void'", "'volatile'", "'wchar_t'", 
			"'while'", "'('", "')'", "'['", "']'", "'{'", "'}'", "'+'", "'-'", "'*'", 
			"'/'", "'%'", "'^'", "'&'", "'|'", "'~'", null, "'='", "'<'", "'>'", 
			"'+='", "'-='", "'*='", "'/='", "'%='", "'^='", "'&='", "'|='", "'<<='", 
			"'>>='", "'=='", "'!='", "'<='", "'>='", null, null, "'++'", "'--'", 
			"','", "'->*'", "'->'", "'?'", "':'", "'::'", "';'", "'.'", "'.*'", "'...'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "IntegerLiteral", "CharacterLiteral", "FloatingLiteral", "StringLiteral", 
			"BooleanLiteral", "PointerLiteral", "UserDefinedLiteral", "MultiLineMacro", 
			"Directive", "Alignas", "Alignof", "Asm", "Auto", "Bool", "Break", "Case", 
			"Catch", "Char", "Char16", "Char32", "Class", "Const", "Constexpr", "Const_cast", 
			"Continue", "Decltype", "Default", "Delete", "Do", "Double", "Dynamic_cast", 
			"Else", "Enum", "Explicit", "Export", "Extern", "False_", "Final", "Float", 
			"For", "Friend", "Goto", "If", "Inline", "Int", "Long", "Mutable", "Namespace", 
			"New", "Noexcept", "Nullptr", "Operator", "Override", "Private", "Protected", 
			"Public", "Register", "Reinterpret_cast", "Return", "Short", "Signed", 
			"Sizeof", "Static", "Static_assert", "Static_cast", "Struct", "Switch", 
			"Template", "This", "Thread_local", "Throw", "True_", "Try", "Typedef", 
			"Typeid_", "Typename_", "Union", "Unsigned", "Using", "Virtual", "Void", 
			"Volatile", "Wchar", "While", "LeftParen", "RightParen", "LeftBracket", 
			"RightBracket", "LeftBrace", "RightBrace", "Plus", "Minus", "Star", "Div", 
			"Mod", "Caret", "And", "Or", "Tilde", "Not", "Assign", "Less", "Greater", 
			"PlusAssign", "MinusAssign", "StarAssign", "DivAssign", "ModAssign", 
			"XorAssign", "AndAssign", "OrAssign", "LeftShiftAssign", "RightShiftAssign", 
			"Equal", "NotEqual", "LessEqual", "GreaterEqual", "AndAnd", "OrOr", "PlusPlus", 
			"MinusMinus", "Comma", "ArrowStar", "Arrow", "Question", "Colon", "Doublecolon", 
			"Semi", "Dot", "DotStar", "Ellipsis", "Identifier", "DecimalLiteral", 
			"OctalLiteral", "HexadecimalLiteral", "BinaryLiteral", "Integersuffix", 
			"UserDefinedIntegerLiteral", "UserDefinedFloatingLiteral", "UserDefinedStringLiteral", 
			"UserDefinedCharacterLiteral", "Whitespace", "Newline", "BlockComment", 
			"LineComment"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "CPPParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public CPPParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class TranslationUnitContext extends org.example.antlr.common.context.ExtendContext {
		public TerminalNode EOF() { return getToken(CPPParser.EOF, 0); }
		public DeclarationseqContext declarationseq() {
			return getRuleContext(DeclarationseqContext.class,0);
		}
		public TranslationUnitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_translationUnit; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).enterTranslationUnit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).exitTranslationUnit(this);
		}
	}

	public final TranslationUnitContext translationUnit() throws RecognitionException {
		TranslationUnitContext _localctx = new TranslationUnitContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_translationUnit);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(391);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 10)) & ~0x3f) == 0 && ((1L << (_la - 10)) & ((1L << (Alignas - 10)) | (1L << (Asm - 10)) | (1L << (Auto - 10)) | (1L << (Bool - 10)) | (1L << (Char - 10)) | (1L << (Char16 - 10)) | (1L << (Char32 - 10)) | (1L << (Class - 10)) | (1L << (Const - 10)) | (1L << (Constexpr - 10)) | (1L << (Decltype - 10)) | (1L << (Double - 10)) | (1L << (Enum - 10)) | (1L << (Explicit - 10)) | (1L << (Extern - 10)) | (1L << (Float - 10)) | (1L << (Friend - 10)) | (1L << (Inline - 10)) | (1L << (Int - 10)) | (1L << (Long - 10)) | (1L << (Mutable - 10)) | (1L << (Namespace - 10)) | (1L << (Operator - 10)) | (1L << (Register - 10)) | (1L << (Short - 10)) | (1L << (Signed - 10)) | (1L << (Static - 10)) | (1L << (Static_assert - 10)) | (1L << (Struct - 10)) | (1L << (Template - 10)) | (1L << (Thread_local - 10)))) != 0) || ((((_la - 74)) & ~0x3f) == 0 && ((1L << (_la - 74)) & ((1L << (Typedef - 74)) | (1L << (Typename_ - 74)) | (1L << (Union - 74)) | (1L << (Unsigned - 74)) | (1L << (Using - 74)) | (1L << (Virtual - 74)) | (1L << (Void - 74)) | (1L << (Volatile - 74)) | (1L << (Wchar - 74)) | (1L << (LeftParen - 74)) | (1L << (LeftBracket - 74)) | (1L << (Star - 74)) | (1L << (And - 74)) | (1L << (Tilde - 74)) | (1L << (AndAnd - 74)) | (1L << (Doublecolon - 74)) | (1L << (Semi - 74)) | (1L << (Ellipsis - 74)) | (1L << (Identifier - 74)))) != 0)) {
				{
				setState(390);
				declarationseq();
				}
			}

			setState(393);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PrimaryExpressionContext extends org.example.antlr.common.context.ExtendContext {
		public List<LiteralContext> literal() {
			return getRuleContexts(LiteralContext.class);
		}
		public LiteralContext literal(int i) {
			return getRuleContext(LiteralContext.class,i);
		}
		public TerminalNode This() { return getToken(CPPParser.This, 0); }
		public TerminalNode LeftParen() { return getToken(CPPParser.LeftParen, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RightParen() { return getToken(CPPParser.RightParen, 0); }
		public IdExpressionContext idExpression() {
			return getRuleContext(IdExpressionContext.class,0);
		}
		public LambdaExpressionContext lambdaExpression() {
			return getRuleContext(LambdaExpressionContext.class,0);
		}
		public PrimaryExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primaryExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).enterPrimaryExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).exitPrimaryExpression(this);
		}
	}

	public final PrimaryExpressionContext primaryExpression() throws RecognitionException {
		PrimaryExpressionContext _localctx = new PrimaryExpressionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_primaryExpression);
		try {
			int _alt;
			setState(407);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IntegerLiteral:
			case CharacterLiteral:
			case FloatingLiteral:
			case StringLiteral:
			case BooleanLiteral:
			case PointerLiteral:
			case UserDefinedLiteral:
				enterOuterAlt(_localctx, 1);
				{
				setState(396); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(395);
						literal();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(398); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			case This:
				enterOuterAlt(_localctx, 2);
				{
				setState(400);
				match(This);
				}
				break;
			case LeftParen:
				enterOuterAlt(_localctx, 3);
				{
				setState(401);
				match(LeftParen);
				setState(402);
				expression();
				setState(403);
				match(RightParen);
				}
				break;
			case Decltype:
			case Operator:
			case Tilde:
			case Doublecolon:
			case Identifier:
				enterOuterAlt(_localctx, 4);
				{
				setState(405);
				idExpression();
				}
				break;
			case LeftBracket:
				enterOuterAlt(_localctx, 5);
				{
				setState(406);
				lambdaExpression();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IdExpressionContext extends org.example.antlr.common.context.ExtendContext {
		public UnqualifiedIdContext unqualifiedId() {
			return getRuleContext(UnqualifiedIdContext.class,0);
		}
		public QualifiedIdContext qualifiedId() {
			return getRuleContext(QualifiedIdContext.class,0);
		}
		public IdExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_idExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).enterIdExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).exitIdExpression(this);
		}
	}

	public final IdExpressionContext idExpression() throws RecognitionException {
		IdExpressionContext _localctx = new IdExpressionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_idExpression);
		try {
			setState(411);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(409);
				unqualifiedId();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(410);
				qualifiedId();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UnqualifiedIdContext extends org.example.antlr.common.context.ExtendContext {
		public TerminalNode Identifier() { return getToken(CPPParser.Identifier, 0); }
		public OperatorFunctionIdContext operatorFunctionId() {
			return getRuleContext(OperatorFunctionIdContext.class,0);
		}
		public ConversionFunctionIdContext conversionFunctionId() {
			return getRuleContext(ConversionFunctionIdContext.class,0);
		}
		public LiteralOperatorIdContext literalOperatorId() {
			return getRuleContext(LiteralOperatorIdContext.class,0);
		}
		public TerminalNode Tilde() { return getToken(CPPParser.Tilde, 0); }
		public ClassNameContext className() {
			return getRuleContext(ClassNameContext.class,0);
		}
		public DecltypeSpecifierContext decltypeSpecifier() {
			return getRuleContext(DecltypeSpecifierContext.class,0);
		}
		public TemplateIdContext templateId() {
			return getRuleContext(TemplateIdContext.class,0);
		}
		public UnqualifiedIdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unqualifiedId; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).enterUnqualifiedId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).exitUnqualifiedId(this);
		}
	}

	public final UnqualifiedIdContext unqualifiedId() throws RecognitionException {
		UnqualifiedIdContext _localctx = new UnqualifiedIdContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_unqualifiedId);
		try {
			setState(423);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(413);
				match(Identifier);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(414);
				operatorFunctionId();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(415);
				conversionFunctionId();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(416);
				literalOperatorId();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(417);
				match(Tilde);
				setState(420);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case Identifier:
					{
					setState(418);
					className();
					}
					break;
				case Decltype:
					{
					setState(419);
					decltypeSpecifier();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(422);
				templateId();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class QualifiedIdContext extends org.example.antlr.common.context.ExtendContext {
		public NestedNameSpecifierContext nestedNameSpecifier() {
			return getRuleContext(NestedNameSpecifierContext.class,0);
		}
		public UnqualifiedIdContext unqualifiedId() {
			return getRuleContext(UnqualifiedIdContext.class,0);
		}
		public TerminalNode Template() { return getToken(CPPParser.Template, 0); }
		public QualifiedIdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_qualifiedId; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).enterQualifiedId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).exitQualifiedId(this);
		}
	}

	public final QualifiedIdContext qualifiedId() throws RecognitionException {
		QualifiedIdContext _localctx = new QualifiedIdContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_qualifiedId);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(425);
			nestedNameSpecifier(0);
			setState(427);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Template) {
				{
				setState(426);
				match(Template);
				}
			}

			setState(429);
			unqualifiedId();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NestedNameSpecifierContext extends org.example.antlr.common.context.ExtendContext {
		public TerminalNode Doublecolon() { return getToken(CPPParser.Doublecolon, 0); }
		public TheTypeNameContext theTypeName() {
			return getRuleContext(TheTypeNameContext.class,0);
		}
		public NamespaceNameContext namespaceName() {
			return getRuleContext(NamespaceNameContext.class,0);
		}
		public DecltypeSpecifierContext decltypeSpecifier() {
			return getRuleContext(DecltypeSpecifierContext.class,0);
		}
		public NestedNameSpecifierContext nestedNameSpecifier() {
			return getRuleContext(NestedNameSpecifierContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(CPPParser.Identifier, 0); }
		public SimpleTemplateIdContext simpleTemplateId() {
			return getRuleContext(SimpleTemplateIdContext.class,0);
		}
		public TerminalNode Template() { return getToken(CPPParser.Template, 0); }
		public NestedNameSpecifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nestedNameSpecifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).enterNestedNameSpecifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).exitNestedNameSpecifier(this);
		}
	}

	public final NestedNameSpecifierContext nestedNameSpecifier() throws RecognitionException {
		return nestedNameSpecifier(0);
	}

	private NestedNameSpecifierContext nestedNameSpecifier(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		NestedNameSpecifierContext _localctx = new NestedNameSpecifierContext(_ctx, _parentState);
		NestedNameSpecifierContext _prevctx = _localctx;
		int _startState = 10;
		enterRecursionRule(_localctx, 10, RULE_nestedNameSpecifier, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(435);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				{
				setState(432);
				theTypeName();
				}
				break;
			case 2:
				{
				setState(433);
				namespaceName();
				}
				break;
			case 3:
				{
				setState(434);
				decltypeSpecifier();
				}
				break;
			}
			setState(437);
			match(Doublecolon);
			}
			_ctx.stop = _input.LT(-1);
			setState(450);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new NestedNameSpecifierContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_nestedNameSpecifier);
					setState(439);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(445);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
					case 1:
						{
						setState(440);
						match(Identifier);
						}
						break;
					case 2:
						{
						setState(442);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==Template) {
							{
							setState(441);
							match(Template);
							}
						}

						setState(444);
						simpleTemplateId();
						}
						break;
					}
					setState(447);
					match(Doublecolon);
					}
					} 
				}
				setState(452);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class LambdaExpressionContext extends org.example.antlr.common.context.ExtendContext {
		public LambdaIntroducerContext lambdaIntroducer() {
			return getRuleContext(LambdaIntroducerContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public LambdaDeclaratorContext lambdaDeclarator() {
			return getRuleContext(LambdaDeclaratorContext.class,0);
		}
		public LambdaExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lambdaExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).enterLambdaExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).exitLambdaExpression(this);
		}
	}

	public final LambdaExpressionContext lambdaExpression() throws RecognitionException {
		LambdaExpressionContext _localctx = new LambdaExpressionContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_lambdaExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(453);
			lambdaIntroducer();
			setState(455);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LeftParen) {
				{
				setState(454);
				lambdaDeclarator();
				}
			}

			setState(457);
			block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LambdaIntroducerContext extends org.example.antlr.common.context.ExtendContext {
		public TerminalNode LeftBracket() { return getToken(CPPParser.LeftBracket, 0); }
		public TerminalNode RightBracket() { return getToken(CPPParser.RightBracket, 0); }
		public LambdaCaptureContext lambdaCapture() {
			return getRuleContext(LambdaCaptureContext.class,0);
		}
		public LambdaIntroducerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lambdaIntroducer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).enterLambdaIntroducer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).exitLambdaIntroducer(this);
		}
	}

	public final LambdaIntroducerContext lambdaIntroducer() throws RecognitionException {
		LambdaIntroducerContext _localctx = new LambdaIntroducerContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_lambdaIntroducer);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(459);
			match(LeftBracket);
			setState(461);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & ((1L << (This - 69)) | (1L << (And - 69)) | (1L << (Assign - 69)) | (1L << (Identifier - 69)))) != 0)) {
				{
				setState(460);
				lambdaCapture();
				}
			}

			setState(463);
			match(RightBracket);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LambdaCaptureContext extends org.example.antlr.common.context.ExtendContext {
		public CaptureListContext captureList() {
			return getRuleContext(CaptureListContext.class,0);
		}
		public CaptureDefaultContext captureDefault() {
			return getRuleContext(CaptureDefaultContext.class,0);
		}
		public TerminalNode Comma() { return getToken(CPPParser.Comma, 0); }
		public LambdaCaptureContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lambdaCapture; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).enterLambdaCapture(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).exitLambdaCapture(this);
		}
	}

	public final LambdaCaptureContext lambdaCapture() throws RecognitionException {
		LambdaCaptureContext _localctx = new LambdaCaptureContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_lambdaCapture);
		int _la;
		try {
			setState(471);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(465);
				captureList();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(466);
				captureDefault();
				setState(469);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Comma) {
					{
					setState(467);
					match(Comma);
					setState(468);
					captureList();
					}
				}

				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CaptureDefaultContext extends org.example.antlr.common.context.ExtendContext {
		public TerminalNode And() { return getToken(CPPParser.And, 0); }
		public TerminalNode Assign() { return getToken(CPPParser.Assign, 0); }
		public CaptureDefaultContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_captureDefault; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).enterCaptureDefault(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).exitCaptureDefault(this);
		}
	}

	public final CaptureDefaultContext captureDefault() throws RecognitionException {
		CaptureDefaultContext _localctx = new CaptureDefaultContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_captureDefault);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(473);
			_la = _input.LA(1);
			if ( !(_la==And || _la==Assign) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CaptureListContext extends org.example.antlr.common.context.ExtendContext {
		public List<CaptureContext> capture() {
			return getRuleContexts(CaptureContext.class);
		}
		public CaptureContext capture(int i) {
			return getRuleContext(CaptureContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(CPPParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(CPPParser.Comma, i);
		}
		public TerminalNode Ellipsis() { return getToken(CPPParser.Ellipsis, 0); }
		public CaptureListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_captureList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).enterCaptureList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).exitCaptureList(this);
		}
	}

	public final CaptureListContext captureList() throws RecognitionException {
		CaptureListContext _localctx = new CaptureListContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_captureList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(475);
			capture();
			setState(480);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(476);
				match(Comma);
				setState(477);
				capture();
				}
				}
				setState(482);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(484);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Ellipsis) {
				{
				setState(483);
				match(Ellipsis);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CaptureContext extends org.example.antlr.common.context.ExtendContext {
		public SimpleCaptureContext simpleCapture() {
			return getRuleContext(SimpleCaptureContext.class,0);
		}
		public InitcaptureContext initcapture() {
			return getRuleContext(InitcaptureContext.class,0);
		}
		public CaptureContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_capture; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).enterCapture(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).exitCapture(this);
		}
	}

	public final CaptureContext capture() throws RecognitionException {
		CaptureContext _localctx = new CaptureContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_capture);
		try {
			setState(488);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(486);
				simpleCapture();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(487);
				initcapture();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SimpleCaptureContext extends org.example.antlr.common.context.ExtendContext {
		public TerminalNode Identifier() { return getToken(CPPParser.Identifier, 0); }
		public TerminalNode And() { return getToken(CPPParser.And, 0); }
		public TerminalNode This() { return getToken(CPPParser.This, 0); }
		public SimpleCaptureContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simpleCapture; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).enterSimpleCapture(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).exitSimpleCapture(this);
		}
	}

	public final SimpleCaptureContext simpleCapture() throws RecognitionException {
		SimpleCaptureContext _localctx = new SimpleCaptureContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_simpleCapture);
		int _la;
		try {
			setState(495);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case And:
			case Identifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(491);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==And) {
					{
					setState(490);
					match(And);
					}
				}

				setState(493);
				match(Identifier);
				}
				break;
			case This:
				enterOuterAlt(_localctx, 2);
				{
				setState(494);
				match(This);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InitcaptureContext extends org.example.antlr.common.context.ExtendContext {
		public TerminalNode Identifier() { return getToken(CPPParser.Identifier, 0); }
		public InitializerContext initializer() {
			return getRuleContext(InitializerContext.class,0);
		}
		public TerminalNode And() { return getToken(CPPParser.And, 0); }
		public InitcaptureContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_initcapture; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).enterInitcapture(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).exitInitcapture(this);
		}
	}

	public final InitcaptureContext initcapture() throws RecognitionException {
		InitcaptureContext _localctx = new InitcaptureContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_initcapture);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(498);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==And) {
				{
				setState(497);
				match(And);
				}
			}

			setState(500);
			match(Identifier);
			setState(501);
			initializer();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LambdaDeclaratorContext extends org.example.antlr.common.context.ExtendContext {
		public TerminalNode LeftParen() { return getToken(CPPParser.LeftParen, 0); }
		public TerminalNode RightParen() { return getToken(CPPParser.RightParen, 0); }
		public ParameterDeclarationClauseContext parameterDeclarationClause() {
			return getRuleContext(ParameterDeclarationClauseContext.class,0);
		}
		public TerminalNode Mutable() { return getToken(CPPParser.Mutable, 0); }
		public ExceptionSpecificationContext exceptionSpecification() {
			return getRuleContext(ExceptionSpecificationContext.class,0);
		}
		public AttributeSpecifierSeqContext attributeSpecifierSeq() {
			return getRuleContext(AttributeSpecifierSeqContext.class,0);
		}
		public TrailingReturnTypeContext trailingReturnType() {
			return getRuleContext(TrailingReturnTypeContext.class,0);
		}
		public LambdaDeclaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lambdaDeclarator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).enterLambdaDeclarator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).exitLambdaDeclarator(this);
		}
	}

	public final LambdaDeclaratorContext lambdaDeclarator() throws RecognitionException {
		LambdaDeclaratorContext _localctx = new LambdaDeclaratorContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_lambdaDeclarator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(503);
			match(LeftParen);
			setState(505);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 10)) & ~0x3f) == 0 && ((1L << (_la - 10)) & ((1L << (Alignas - 10)) | (1L << (Auto - 10)) | (1L << (Bool - 10)) | (1L << (Char - 10)) | (1L << (Char16 - 10)) | (1L << (Char32 - 10)) | (1L << (Class - 10)) | (1L << (Const - 10)) | (1L << (Constexpr - 10)) | (1L << (Decltype - 10)) | (1L << (Double - 10)) | (1L << (Enum - 10)) | (1L << (Explicit - 10)) | (1L << (Extern - 10)) | (1L << (Float - 10)) | (1L << (Friend - 10)) | (1L << (Inline - 10)) | (1L << (Int - 10)) | (1L << (Long - 10)) | (1L << (Mutable - 10)) | (1L << (Register - 10)) | (1L << (Short - 10)) | (1L << (Signed - 10)) | (1L << (Static - 10)) | (1L << (Struct - 10)) | (1L << (Thread_local - 10)))) != 0) || ((((_la - 74)) & ~0x3f) == 0 && ((1L << (_la - 74)) & ((1L << (Typedef - 74)) | (1L << (Typename_ - 74)) | (1L << (Union - 74)) | (1L << (Unsigned - 74)) | (1L << (Virtual - 74)) | (1L << (Void - 74)) | (1L << (Volatile - 74)) | (1L << (Wchar - 74)) | (1L << (LeftBracket - 74)) | (1L << (Doublecolon - 74)) | (1L << (Identifier - 74)))) != 0)) {
				{
				setState(504);
				parameterDeclarationClause();
				}
			}

			setState(507);
			match(RightParen);
			setState(509);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Mutable) {
				{
				setState(508);
				match(Mutable);
				}
			}

			setState(512);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Noexcept || _la==Throw) {
				{
				setState(511);
				exceptionSpecification();
				}
			}

			setState(515);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Alignas || _la==LeftBracket) {
				{
				setState(514);
				attributeSpecifierSeq();
				}
			}

			setState(518);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Arrow) {
				{
				setState(517);
				trailingReturnType();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PostfixExpressionContext extends org.example.antlr.common.context.ExtendContext {
		public PrimaryExpressionContext primaryExpression() {
			return getRuleContext(PrimaryExpressionContext.class,0);
		}
		public SimpleTypeSpecifierContext simpleTypeSpecifier() {
			return getRuleContext(SimpleTypeSpecifierContext.class,0);
		}
		public TypeNameSpecifierContext typeNameSpecifier() {
			return getRuleContext(TypeNameSpecifierContext.class,0);
		}
		public TerminalNode LeftParen() { return getToken(CPPParser.LeftParen, 0); }
		public TerminalNode RightParen() { return getToken(CPPParser.RightParen, 0); }
		public BracedInitListContext bracedInitList() {
			return getRuleContext(BracedInitListContext.class,0);
		}
		public ExpressionListContext expressionList() {
			return getRuleContext(ExpressionListContext.class,0);
		}
		public TerminalNode Less() { return getToken(CPPParser.Less, 0); }
		public TheTypeIdContext theTypeId() {
			return getRuleContext(TheTypeIdContext.class,0);
		}
		public TerminalNode Greater() { return getToken(CPPParser.Greater, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode Dynamic_cast() { return getToken(CPPParser.Dynamic_cast, 0); }
		public TerminalNode Static_cast() { return getToken(CPPParser.Static_cast, 0); }
		public TerminalNode Reinterpret_cast() { return getToken(CPPParser.Reinterpret_cast, 0); }
		public TerminalNode Const_cast() { return getToken(CPPParser.Const_cast, 0); }
		public TypeIdOfTheTypeIdContext typeIdOfTheTypeId() {
			return getRuleContext(TypeIdOfTheTypeIdContext.class,0);
		}
		public PostfixExpressionContext postfixExpression() {
			return getRuleContext(PostfixExpressionContext.class,0);
		}
		public TerminalNode LeftBracket() { return getToken(CPPParser.LeftBracket, 0); }
		public TerminalNode RightBracket() { return getToken(CPPParser.RightBracket, 0); }
		public TerminalNode Dot() { return getToken(CPPParser.Dot, 0); }
		public TerminalNode Arrow() { return getToken(CPPParser.Arrow, 0); }
		public IdExpressionContext idExpression() {
			return getRuleContext(IdExpressionContext.class,0);
		}
		public PseudoDestructorNameContext pseudoDestructorName() {
			return getRuleContext(PseudoDestructorNameContext.class,0);
		}
		public TerminalNode Template() { return getToken(CPPParser.Template, 0); }
		public TerminalNode PlusPlus() { return getToken(CPPParser.PlusPlus, 0); }
		public TerminalNode MinusMinus() { return getToken(CPPParser.MinusMinus, 0); }
		public PostfixExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_postfixExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).enterPostfixExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).exitPostfixExpression(this);
		}
	}

	public final PostfixExpressionContext postfixExpression() throws RecognitionException {
		return postfixExpression(0);
	}

	private PostfixExpressionContext postfixExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		PostfixExpressionContext _localctx = new PostfixExpressionContext(_ctx, _parentState);
		PostfixExpressionContext _prevctx = _localctx;
		int _startState = 30;
		enterRecursionRule(_localctx, 30, RULE_postfixExpression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(550);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
			case 1:
				{
				setState(521);
				primaryExpression();
				}
				break;
			case 2:
				{
				setState(524);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case Auto:
				case Bool:
				case Char:
				case Char16:
				case Char32:
				case Decltype:
				case Double:
				case Float:
				case Int:
				case Long:
				case Short:
				case Signed:
				case Unsigned:
				case Void:
				case Wchar:
				case Doublecolon:
				case Identifier:
					{
					setState(522);
					simpleTypeSpecifier();
					}
					break;
				case Typename_:
					{
					setState(523);
					typeNameSpecifier();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(532);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case LeftParen:
					{
					setState(526);
					match(LeftParen);
					setState(528);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IntegerLiteral) | (1L << CharacterLiteral) | (1L << FloatingLiteral) | (1L << StringLiteral) | (1L << BooleanLiteral) | (1L << PointerLiteral) | (1L << UserDefinedLiteral) | (1L << Alignof) | (1L << Auto) | (1L << Bool) | (1L << Char) | (1L << Char16) | (1L << Char32) | (1L << Const_cast) | (1L << Decltype) | (1L << Delete) | (1L << Double) | (1L << Dynamic_cast) | (1L << Float) | (1L << Int) | (1L << Long) | (1L << New) | (1L << Noexcept) | (1L << Operator) | (1L << Reinterpret_cast) | (1L << Short) | (1L << Signed) | (1L << Sizeof))) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (Static_cast - 65)) | (1L << (This - 65)) | (1L << (Throw - 65)) | (1L << (Typeid_ - 65)) | (1L << (Typename_ - 65)) | (1L << (Unsigned - 65)) | (1L << (Void - 65)) | (1L << (Wchar - 65)) | (1L << (LeftParen - 65)) | (1L << (LeftBracket - 65)) | (1L << (LeftBrace - 65)) | (1L << (Plus - 65)) | (1L << (Minus - 65)) | (1L << (Star - 65)) | (1L << (And - 65)) | (1L << (Or - 65)) | (1L << (Tilde - 65)) | (1L << (Not - 65)) | (1L << (PlusPlus - 65)) | (1L << (MinusMinus - 65)) | (1L << (Doublecolon - 65)))) != 0) || _la==Identifier) {
						{
						setState(527);
						expressionList();
						}
					}

					setState(530);
					match(RightParen);
					}
					break;
				case LeftBrace:
					{
					setState(531);
					bracedInitList();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case 3:
				{
				setState(534);
				_la = _input.LA(1);
				if ( !(((((_la - 24)) & ~0x3f) == 0 && ((1L << (_la - 24)) & ((1L << (Const_cast - 24)) | (1L << (Dynamic_cast - 24)) | (1L << (Reinterpret_cast - 24)) | (1L << (Static_cast - 24)))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(535);
				match(Less);
				setState(536);
				theTypeId();
				setState(537);
				match(Greater);
				setState(538);
				match(LeftParen);
				setState(539);
				expression();
				setState(540);
				match(RightParen);
				}
				break;
			case 4:
				{
				setState(542);
				typeIdOfTheTypeId();
				setState(543);
				match(LeftParen);
				setState(546);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
				case 1:
					{
					setState(544);
					expression();
					}
					break;
				case 2:
					{
					setState(545);
					theTypeId();
					}
					break;
				}
				setState(548);
				match(RightParen);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(579);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,36,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(577);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,35,_ctx) ) {
					case 1:
						{
						_localctx = new PostfixExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_postfixExpression);
						setState(552);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(553);
						match(LeftBracket);
						setState(556);
						_errHandler.sync(this);
						switch (_input.LA(1)) {
						case IntegerLiteral:
						case CharacterLiteral:
						case FloatingLiteral:
						case StringLiteral:
						case BooleanLiteral:
						case PointerLiteral:
						case UserDefinedLiteral:
						case Alignof:
						case Auto:
						case Bool:
						case Char:
						case Char16:
						case Char32:
						case Const_cast:
						case Decltype:
						case Delete:
						case Double:
						case Dynamic_cast:
						case Float:
						case Int:
						case Long:
						case New:
						case Noexcept:
						case Operator:
						case Reinterpret_cast:
						case Short:
						case Signed:
						case Sizeof:
						case Static_cast:
						case This:
						case Throw:
						case Typeid_:
						case Typename_:
						case Unsigned:
						case Void:
						case Wchar:
						case LeftParen:
						case LeftBracket:
						case Plus:
						case Minus:
						case Star:
						case And:
						case Or:
						case Tilde:
						case Not:
						case PlusPlus:
						case MinusMinus:
						case Doublecolon:
						case Identifier:
							{
							setState(554);
							expression();
							}
							break;
						case LeftBrace:
							{
							setState(555);
							bracedInitList();
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(558);
						match(RightBracket);
						}
						break;
					case 2:
						{
						_localctx = new PostfixExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_postfixExpression);
						setState(560);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(561);
						match(LeftParen);
						setState(563);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IntegerLiteral) | (1L << CharacterLiteral) | (1L << FloatingLiteral) | (1L << StringLiteral) | (1L << BooleanLiteral) | (1L << PointerLiteral) | (1L << UserDefinedLiteral) | (1L << Alignof) | (1L << Auto) | (1L << Bool) | (1L << Char) | (1L << Char16) | (1L << Char32) | (1L << Const_cast) | (1L << Decltype) | (1L << Delete) | (1L << Double) | (1L << Dynamic_cast) | (1L << Float) | (1L << Int) | (1L << Long) | (1L << New) | (1L << Noexcept) | (1L << Operator) | (1L << Reinterpret_cast) | (1L << Short) | (1L << Signed) | (1L << Sizeof))) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (Static_cast - 65)) | (1L << (This - 65)) | (1L << (Throw - 65)) | (1L << (Typeid_ - 65)) | (1L << (Typename_ - 65)) | (1L << (Unsigned - 65)) | (1L << (Void - 65)) | (1L << (Wchar - 65)) | (1L << (LeftParen - 65)) | (1L << (LeftBracket - 65)) | (1L << (LeftBrace - 65)) | (1L << (Plus - 65)) | (1L << (Minus - 65)) | (1L << (Star - 65)) | (1L << (And - 65)) | (1L << (Or - 65)) | (1L << (Tilde - 65)) | (1L << (Not - 65)) | (1L << (PlusPlus - 65)) | (1L << (MinusMinus - 65)) | (1L << (Doublecolon - 65)))) != 0) || _la==Identifier) {
							{
							setState(562);
							expressionList();
							}
						}

						setState(565);
						match(RightParen);
						}
						break;
					case 3:
						{
						_localctx = new PostfixExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_postfixExpression);
						setState(566);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(567);
						_la = _input.LA(1);
						if ( !(_la==Arrow || _la==Dot) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(573);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,34,_ctx) ) {
						case 1:
							{
							setState(569);
							_errHandler.sync(this);
							_la = _input.LA(1);
							if (_la==Template) {
								{
								setState(568);
								match(Template);
								}
							}

							setState(571);
							idExpression();
							}
							break;
						case 2:
							{
							setState(572);
							pseudoDestructorName();
							}
							break;
						}
						}
						break;
					case 4:
						{
						_localctx = new PostfixExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_postfixExpression);
						setState(575);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(576);
						_la = _input.LA(1);
						if ( !(_la==PlusPlus || _la==MinusMinus) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						}
						break;
					}
					} 
				}
				setState(581);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,36,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class TypeIdOfTheTypeIdContext extends org.example.antlr.common.context.ExtendContext {
		public TerminalNode Typeid_() { return getToken(CPPParser.Typeid_, 0); }
		public TypeIdOfTheTypeIdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeIdOfTheTypeId; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).enterTypeIdOfTheTypeId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).exitTypeIdOfTheTypeId(this);
		}
	}

	public final TypeIdOfTheTypeIdContext typeIdOfTheTypeId() throws RecognitionException {
		TypeIdOfTheTypeIdContext _localctx = new TypeIdOfTheTypeIdContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_typeIdOfTheTypeId);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(582);
			match(Typeid_);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionListContext extends org.example.antlr.common.context.ExtendContext {
		public InitializerListContext initializerList() {
			return getRuleContext(InitializerListContext.class,0);
		}
		public ExpressionListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).enterExpressionList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).exitExpressionList(this);
		}
	}

	public final ExpressionListContext expressionList() throws RecognitionException {
		ExpressionListContext _localctx = new ExpressionListContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_expressionList);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(584);
			initializerList();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PseudoDestructorNameContext extends org.example.antlr.common.context.ExtendContext {
		public TerminalNode Tilde() { return getToken(CPPParser.Tilde, 0); }
		public List<TheTypeNameContext> theTypeName() {
			return getRuleContexts(TheTypeNameContext.class);
		}
		public TheTypeNameContext theTypeName(int i) {
			return getRuleContext(TheTypeNameContext.class,i);
		}
		public NestedNameSpecifierContext nestedNameSpecifier() {
			return getRuleContext(NestedNameSpecifierContext.class,0);
		}
		public TerminalNode Doublecolon() { return getToken(CPPParser.Doublecolon, 0); }
		public TerminalNode Template() { return getToken(CPPParser.Template, 0); }
		public SimpleTemplateIdContext simpleTemplateId() {
			return getRuleContext(SimpleTemplateIdContext.class,0);
		}
		public DecltypeSpecifierContext decltypeSpecifier() {
			return getRuleContext(DecltypeSpecifierContext.class,0);
		}
		public PseudoDestructorNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pseudoDestructorName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).enterPseudoDestructorName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).exitPseudoDestructorName(this);
		}
	}

	public final PseudoDestructorNameContext pseudoDestructorName() throws RecognitionException {
		PseudoDestructorNameContext _localctx = new PseudoDestructorNameContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_pseudoDestructorName);
		int _la;
		try {
			setState(605);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,39,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(587);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,37,_ctx) ) {
				case 1:
					{
					setState(586);
					nestedNameSpecifier(0);
					}
					break;
				}
				setState(592);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Identifier) {
					{
					setState(589);
					theTypeName();
					setState(590);
					match(Doublecolon);
					}
				}

				setState(594);
				match(Tilde);
				setState(595);
				theTypeName();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(596);
				nestedNameSpecifier(0);
				setState(597);
				match(Template);
				setState(598);
				simpleTemplateId();
				setState(599);
				match(Doublecolon);
				setState(600);
				match(Tilde);
				setState(601);
				theTypeName();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(603);
				match(Tilde);
				setState(604);
				decltypeSpecifier();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UnaryExpressionContext extends org.example.antlr.common.context.ExtendContext {
		public PostfixExpressionContext postfixExpression() {
			return getRuleContext(PostfixExpressionContext.class,0);
		}
		public UnaryExpressionContext unaryExpression() {
			return getRuleContext(UnaryExpressionContext.class,0);
		}
		public TerminalNode PlusPlus() { return getToken(CPPParser.PlusPlus, 0); }
		public TerminalNode MinusMinus() { return getToken(CPPParser.MinusMinus, 0); }
		public UnaryOperatorContext unaryOperator() {
			return getRuleContext(UnaryOperatorContext.class,0);
		}
		public TerminalNode Sizeof() { return getToken(CPPParser.Sizeof, 0); }
		public TerminalNode LeftParen() { return getToken(CPPParser.LeftParen, 0); }
		public TheTypeIdContext theTypeId() {
			return getRuleContext(TheTypeIdContext.class,0);
		}
		public TerminalNode RightParen() { return getToken(CPPParser.RightParen, 0); }
		public TerminalNode Ellipsis() { return getToken(CPPParser.Ellipsis, 0); }
		public TerminalNode Identifier() { return getToken(CPPParser.Identifier, 0); }
		public TerminalNode Alignof() { return getToken(CPPParser.Alignof, 0); }
		public NoExceptExpressionContext noExceptExpression() {
			return getRuleContext(NoExceptExpressionContext.class,0);
		}
		public NewExpression_Context newExpression_() {
			return getRuleContext(NewExpression_Context.class,0);
		}
		public DeleteExpressionContext deleteExpression() {
			return getRuleContext(DeleteExpressionContext.class,0);
		}
		public UnaryExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unaryExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).enterUnaryExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).exitUnaryExpression(this);
		}
	}

	public final UnaryExpressionContext unaryExpression() throws RecognitionException {
		UnaryExpressionContext _localctx = new UnaryExpressionContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_unaryExpression);
		try {
			setState(634);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,42,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(607);
				postfixExpression(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(612);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case PlusPlus:
					{
					setState(608);
					match(PlusPlus);
					}
					break;
				case MinusMinus:
					{
					setState(609);
					match(MinusMinus);
					}
					break;
				case Plus:
				case Minus:
				case Star:
				case And:
				case Or:
				case Tilde:
				case Not:
					{
					setState(610);
					unaryOperator();
					}
					break;
				case Sizeof:
					{
					setState(611);
					match(Sizeof);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(614);
				unaryExpression();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(615);
				match(Sizeof);
				setState(624);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case LeftParen:
					{
					setState(616);
					match(LeftParen);
					setState(617);
					theTypeId();
					setState(618);
					match(RightParen);
					}
					break;
				case Ellipsis:
					{
					setState(620);
					match(Ellipsis);
					setState(621);
					match(LeftParen);
					setState(622);
					match(Identifier);
					setState(623);
					match(RightParen);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(626);
				match(Alignof);
				setState(627);
				match(LeftParen);
				setState(628);
				theTypeId();
				setState(629);
				match(RightParen);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(631);
				noExceptExpression();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(632);
				newExpression_();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(633);
				deleteExpression();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UnaryOperatorContext extends org.example.antlr.common.context.ExtendContext {
		public TerminalNode Or() { return getToken(CPPParser.Or, 0); }
		public TerminalNode Star() { return getToken(CPPParser.Star, 0); }
		public TerminalNode And() { return getToken(CPPParser.And, 0); }
		public TerminalNode Plus() { return getToken(CPPParser.Plus, 0); }
		public TerminalNode Tilde() { return getToken(CPPParser.Tilde, 0); }
		public TerminalNode Minus() { return getToken(CPPParser.Minus, 0); }
		public TerminalNode Not() { return getToken(CPPParser.Not, 0); }
		public UnaryOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unaryOperator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).enterUnaryOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).exitUnaryOperator(this);
		}
	}

	public final UnaryOperatorContext unaryOperator() throws RecognitionException {
		UnaryOperatorContext _localctx = new UnaryOperatorContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_unaryOperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(636);
			_la = _input.LA(1);
			if ( !(((((_la - 91)) & ~0x3f) == 0 && ((1L << (_la - 91)) & ((1L << (Plus - 91)) | (1L << (Minus - 91)) | (1L << (Star - 91)) | (1L << (And - 91)) | (1L << (Or - 91)) | (1L << (Tilde - 91)) | (1L << (Not - 91)))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NewExpression_Context extends org.example.antlr.common.context.ExtendContext {
		public TerminalNode New() { return getToken(CPPParser.New, 0); }
		public NewTypeIdContext newTypeId() {
			return getRuleContext(NewTypeIdContext.class,0);
		}
		public TerminalNode LeftParen() { return getToken(CPPParser.LeftParen, 0); }
		public TheTypeIdContext theTypeId() {
			return getRuleContext(TheTypeIdContext.class,0);
		}
		public TerminalNode RightParen() { return getToken(CPPParser.RightParen, 0); }
		public TerminalNode Doublecolon() { return getToken(CPPParser.Doublecolon, 0); }
		public NewPlacementContext newPlacement() {
			return getRuleContext(NewPlacementContext.class,0);
		}
		public NewInitializer_Context newInitializer_() {
			return getRuleContext(NewInitializer_Context.class,0);
		}
		public NewExpression_Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_newExpression_; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).enterNewExpression_(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).exitNewExpression_(this);
		}
	}

	public final NewExpression_Context newExpression_() throws RecognitionException {
		NewExpression_Context _localctx = new NewExpression_Context(_ctx, getState());
		enterRule(_localctx, 42, RULE_newExpression_);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(639);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Doublecolon) {
				{
				setState(638);
				match(Doublecolon);
				}
			}

			setState(641);
			match(New);
			setState(643);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,44,_ctx) ) {
			case 1:
				{
				setState(642);
				newPlacement();
				}
				break;
			}
			setState(650);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Auto:
			case Bool:
			case Char:
			case Char16:
			case Char32:
			case Class:
			case Const:
			case Decltype:
			case Double:
			case Enum:
			case Float:
			case Int:
			case Long:
			case Short:
			case Signed:
			case Struct:
			case Typename_:
			case Union:
			case Unsigned:
			case Void:
			case Volatile:
			case Wchar:
			case Doublecolon:
			case Identifier:
				{
				setState(645);
				newTypeId();
				}
				break;
			case LeftParen:
				{
				setState(646);
				match(LeftParen);
				setState(647);
				theTypeId();
				setState(648);
				match(RightParen);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(653);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LeftParen || _la==LeftBrace) {
				{
				setState(652);
				newInitializer_();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NewPlacementContext extends org.example.antlr.common.context.ExtendContext {
		public TerminalNode LeftParen() { return getToken(CPPParser.LeftParen, 0); }
		public ExpressionListContext expressionList() {
			return getRuleContext(ExpressionListContext.class,0);
		}
		public TerminalNode RightParen() { return getToken(CPPParser.RightParen, 0); }
		public NewPlacementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_newPlacement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).enterNewPlacement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).exitNewPlacement(this);
		}
	}

	public final NewPlacementContext newPlacement() throws RecognitionException {
		NewPlacementContext _localctx = new NewPlacementContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_newPlacement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(655);
			match(LeftParen);
			setState(656);
			expressionList();
			setState(657);
			match(RightParen);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NewTypeIdContext extends org.example.antlr.common.context.ExtendContext {
		public TypeSpecifierSeqContext typeSpecifierSeq() {
			return getRuleContext(TypeSpecifierSeqContext.class,0);
		}
		public NewDeclarator_Context newDeclarator_() {
			return getRuleContext(NewDeclarator_Context.class,0);
		}
		public NewTypeIdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_newTypeId; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).enterNewTypeId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).exitNewTypeId(this);
		}
	}

	public final NewTypeIdContext newTypeId() throws RecognitionException {
		NewTypeIdContext _localctx = new NewTypeIdContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_newTypeId);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(659);
			typeSpecifierSeq();
			setState(661);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,47,_ctx) ) {
			case 1:
				{
				setState(660);
				newDeclarator_();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NewDeclarator_Context extends org.example.antlr.common.context.ExtendContext {
		public PointerOperatorContext pointerOperator() {
			return getRuleContext(PointerOperatorContext.class,0);
		}
		public NewDeclarator_Context newDeclarator_() {
			return getRuleContext(NewDeclarator_Context.class,0);
		}
		public NoPointerNewDeclaratorContext noPointerNewDeclarator() {
			return getRuleContext(NoPointerNewDeclaratorContext.class,0);
		}
		public NewDeclarator_Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_newDeclarator_; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).enterNewDeclarator_(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).exitNewDeclarator_(this);
		}
	}

	public final NewDeclarator_Context newDeclarator_() throws RecognitionException {
		NewDeclarator_Context _localctx = new NewDeclarator_Context(_ctx, getState());
		enterRule(_localctx, 48, RULE_newDeclarator_);
		try {
			setState(668);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Decltype:
			case Star:
			case And:
			case AndAnd:
			case Doublecolon:
			case Identifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(663);
				pointerOperator();
				setState(665);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,48,_ctx) ) {
				case 1:
					{
					setState(664);
					newDeclarator_();
					}
					break;
				}
				}
				break;
			case LeftBracket:
				enterOuterAlt(_localctx, 2);
				{
				setState(667);
				noPointerNewDeclarator(0);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NoPointerNewDeclaratorContext extends org.example.antlr.common.context.ExtendContext {
		public TerminalNode LeftBracket() { return getToken(CPPParser.LeftBracket, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RightBracket() { return getToken(CPPParser.RightBracket, 0); }
		public AttributeSpecifierSeqContext attributeSpecifierSeq() {
			return getRuleContext(AttributeSpecifierSeqContext.class,0);
		}
		public NoPointerNewDeclaratorContext noPointerNewDeclarator() {
			return getRuleContext(NoPointerNewDeclaratorContext.class,0);
		}
		public ConstantExpressionContext constantExpression() {
			return getRuleContext(ConstantExpressionContext.class,0);
		}
		public NoPointerNewDeclaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_noPointerNewDeclarator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).enterNoPointerNewDeclarator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).exitNoPointerNewDeclarator(this);
		}
	}

	public final NoPointerNewDeclaratorContext noPointerNewDeclarator() throws RecognitionException {
		return noPointerNewDeclarator(0);
	}

	private NoPointerNewDeclaratorContext noPointerNewDeclarator(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		NoPointerNewDeclaratorContext _localctx = new NoPointerNewDeclaratorContext(_ctx, _parentState);
		NoPointerNewDeclaratorContext _prevctx = _localctx;
		int _startState = 50;
		enterRecursionRule(_localctx, 50, RULE_noPointerNewDeclarator, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(671);
			match(LeftBracket);
			setState(672);
			expression();
			setState(673);
			match(RightBracket);
			setState(675);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,50,_ctx) ) {
			case 1:
				{
				setState(674);
				attributeSpecifierSeq();
				}
				break;
			}
			}
			_ctx.stop = _input.LT(-1);
			setState(686);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,52,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new NoPointerNewDeclaratorContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_noPointerNewDeclarator);
					setState(677);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(678);
					match(LeftBracket);
					setState(679);
					constantExpression();
					setState(680);
					match(RightBracket);
					setState(682);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,51,_ctx) ) {
					case 1:
						{
						setState(681);
						attributeSpecifierSeq();
						}
						break;
					}
					}
					} 
				}
				setState(688);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,52,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class NewInitializer_Context extends org.example.antlr.common.context.ExtendContext {
		public TerminalNode LeftParen() { return getToken(CPPParser.LeftParen, 0); }
		public TerminalNode RightParen() { return getToken(CPPParser.RightParen, 0); }
		public ExpressionListContext expressionList() {
			return getRuleContext(ExpressionListContext.class,0);
		}
		public BracedInitListContext bracedInitList() {
			return getRuleContext(BracedInitListContext.class,0);
		}
		public NewInitializer_Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_newInitializer_; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).enterNewInitializer_(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).exitNewInitializer_(this);
		}
	}

	public final NewInitializer_Context newInitializer_() throws RecognitionException {
		NewInitializer_Context _localctx = new NewInitializer_Context(_ctx, getState());
		enterRule(_localctx, 52, RULE_newInitializer_);
		int _la;
		try {
			setState(695);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LeftParen:
				enterOuterAlt(_localctx, 1);
				{
				setState(689);
				match(LeftParen);
				setState(691);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IntegerLiteral) | (1L << CharacterLiteral) | (1L << FloatingLiteral) | (1L << StringLiteral) | (1L << BooleanLiteral) | (1L << PointerLiteral) | (1L << UserDefinedLiteral) | (1L << Alignof) | (1L << Auto) | (1L << Bool) | (1L << Char) | (1L << Char16) | (1L << Char32) | (1L << Const_cast) | (1L << Decltype) | (1L << Delete) | (1L << Double) | (1L << Dynamic_cast) | (1L << Float) | (1L << Int) | (1L << Long) | (1L << New) | (1L << Noexcept) | (1L << Operator) | (1L << Reinterpret_cast) | (1L << Short) | (1L << Signed) | (1L << Sizeof))) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (Static_cast - 65)) | (1L << (This - 65)) | (1L << (Throw - 65)) | (1L << (Typeid_ - 65)) | (1L << (Typename_ - 65)) | (1L << (Unsigned - 65)) | (1L << (Void - 65)) | (1L << (Wchar - 65)) | (1L << (LeftParen - 65)) | (1L << (LeftBracket - 65)) | (1L << (LeftBrace - 65)) | (1L << (Plus - 65)) | (1L << (Minus - 65)) | (1L << (Star - 65)) | (1L << (And - 65)) | (1L << (Or - 65)) | (1L << (Tilde - 65)) | (1L << (Not - 65)) | (1L << (PlusPlus - 65)) | (1L << (MinusMinus - 65)) | (1L << (Doublecolon - 65)))) != 0) || _la==Identifier) {
					{
					setState(690);
					expressionList();
					}
				}

				setState(693);
				match(RightParen);
				}
				break;
			case LeftBrace:
				enterOuterAlt(_localctx, 2);
				{
				setState(694);
				bracedInitList();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeleteExpressionContext extends org.example.antlr.common.context.ExtendContext {
		public TerminalNode Delete() { return getToken(CPPParser.Delete, 0); }
		public CastExpressionContext castExpression() {
			return getRuleContext(CastExpressionContext.class,0);
		}
		public TerminalNode Doublecolon() { return getToken(CPPParser.Doublecolon, 0); }
		public TerminalNode LeftBracket() { return getToken(CPPParser.LeftBracket, 0); }
		public TerminalNode RightBracket() { return getToken(CPPParser.RightBracket, 0); }
		public DeleteExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_deleteExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).enterDeleteExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).exitDeleteExpression(this);
		}
	}

	public final DeleteExpressionContext deleteExpression() throws RecognitionException {
		DeleteExpressionContext _localctx = new DeleteExpressionContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_deleteExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(698);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Doublecolon) {
				{
				setState(697);
				match(Doublecolon);
				}
			}

			setState(700);
			match(Delete);
			setState(703);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,56,_ctx) ) {
			case 1:
				{
				setState(701);
				match(LeftBracket);
				setState(702);
				match(RightBracket);
				}
				break;
			}
			setState(705);
			castExpression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NoExceptExpressionContext extends org.example.antlr.common.context.ExtendContext {
		public TerminalNode Noexcept() { return getToken(CPPParser.Noexcept, 0); }
		public TerminalNode LeftParen() { return getToken(CPPParser.LeftParen, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RightParen() { return getToken(CPPParser.RightParen, 0); }
		public NoExceptExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_noExceptExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).enterNoExceptExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).exitNoExceptExpression(this);
		}
	}

	public final NoExceptExpressionContext noExceptExpression() throws RecognitionException {
		NoExceptExpressionContext _localctx = new NoExceptExpressionContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_noExceptExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(707);
			match(Noexcept);
			setState(708);
			match(LeftParen);
			setState(709);
			expression();
			setState(710);
			match(RightParen);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CastExpressionContext extends org.example.antlr.common.context.ExtendContext {
		public UnaryExpressionContext unaryExpression() {
			return getRuleContext(UnaryExpressionContext.class,0);
		}
		public TerminalNode LeftParen() { return getToken(CPPParser.LeftParen, 0); }
		public TheTypeIdContext theTypeId() {
			return getRuleContext(TheTypeIdContext.class,0);
		}
		public TerminalNode RightParen() { return getToken(CPPParser.RightParen, 0); }
		public CastExpressionContext castExpression() {
			return getRuleContext(CastExpressionContext.class,0);
		}
		public CastExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_castExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).enterCastExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).exitCastExpression(this);
		}
	}

	public final CastExpressionContext castExpression() throws RecognitionException {
		CastExpressionContext _localctx = new CastExpressionContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_castExpression);
		try {
			setState(718);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,57,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(712);
				unaryExpression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(713);
				match(LeftParen);
				setState(714);
				theTypeId();
				setState(715);
				match(RightParen);
				setState(716);
				castExpression();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PointerMemberExpressionContext extends org.example.antlr.common.context.ExtendContext {
		public List<CastExpressionContext> castExpression() {
			return getRuleContexts(CastExpressionContext.class);
		}
		public CastExpressionContext castExpression(int i) {
			return getRuleContext(CastExpressionContext.class,i);
		}
		public List<TerminalNode> DotStar() { return getTokens(CPPParser.DotStar); }
		public TerminalNode DotStar(int i) {
			return getToken(CPPParser.DotStar, i);
		}
		public List<TerminalNode> ArrowStar() { return getTokens(CPPParser.ArrowStar); }
		public TerminalNode ArrowStar(int i) {
			return getToken(CPPParser.ArrowStar, i);
		}
		public PointerMemberExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pointerMemberExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).enterPointerMemberExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).exitPointerMemberExpression(this);
		}
	}

	public final PointerMemberExpressionContext pointerMemberExpression() throws RecognitionException {
		PointerMemberExpressionContext _localctx = new PointerMemberExpressionContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_pointerMemberExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(720);
			castExpression();
			setState(725);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ArrowStar || _la==DotStar) {
				{
				{
				setState(721);
				_la = _input.LA(1);
				if ( !(_la==ArrowStar || _la==DotStar) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(722);
				castExpression();
				}
				}
				setState(727);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MultiplicativeExpressionContext extends org.example.antlr.common.context.ExtendContext {
		public List<PointerMemberExpressionContext> pointerMemberExpression() {
			return getRuleContexts(PointerMemberExpressionContext.class);
		}
		public PointerMemberExpressionContext pointerMemberExpression(int i) {
			return getRuleContext(PointerMemberExpressionContext.class,i);
		}
		public List<TerminalNode> Star() { return getTokens(CPPParser.Star); }
		public TerminalNode Star(int i) {
			return getToken(CPPParser.Star, i);
		}
		public List<TerminalNode> Div() { return getTokens(CPPParser.Div); }
		public TerminalNode Div(int i) {
			return getToken(CPPParser.Div, i);
		}
		public List<TerminalNode> Mod() { return getTokens(CPPParser.Mod); }
		public TerminalNode Mod(int i) {
			return getToken(CPPParser.Mod, i);
		}
		public MultiplicativeExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiplicativeExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).enterMultiplicativeExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).exitMultiplicativeExpression(this);
		}
	}

	public final MultiplicativeExpressionContext multiplicativeExpression() throws RecognitionException {
		MultiplicativeExpressionContext _localctx = new MultiplicativeExpressionContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_multiplicativeExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(728);
			pointerMemberExpression();
			setState(733);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 93)) & ~0x3f) == 0 && ((1L << (_la - 93)) & ((1L << (Star - 93)) | (1L << (Div - 93)) | (1L << (Mod - 93)))) != 0)) {
				{
				{
				setState(729);
				_la = _input.LA(1);
				if ( !(((((_la - 93)) & ~0x3f) == 0 && ((1L << (_la - 93)) & ((1L << (Star - 93)) | (1L << (Div - 93)) | (1L << (Mod - 93)))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(730);
				pointerMemberExpression();
				}
				}
				setState(735);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AdditiveExpressionContext extends org.example.antlr.common.context.ExtendContext {
		public List<MultiplicativeExpressionContext> multiplicativeExpression() {
			return getRuleContexts(MultiplicativeExpressionContext.class);
		}
		public MultiplicativeExpressionContext multiplicativeExpression(int i) {
			return getRuleContext(MultiplicativeExpressionContext.class,i);
		}
		public List<TerminalNode> Plus() { return getTokens(CPPParser.Plus); }
		public TerminalNode Plus(int i) {
			return getToken(CPPParser.Plus, i);
		}
		public List<TerminalNode> Minus() { return getTokens(CPPParser.Minus); }
		public TerminalNode Minus(int i) {
			return getToken(CPPParser.Minus, i);
		}
		public AdditiveExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_additiveExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).enterAdditiveExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).exitAdditiveExpression(this);
		}
	}

	public final AdditiveExpressionContext additiveExpression() throws RecognitionException {
		AdditiveExpressionContext _localctx = new AdditiveExpressionContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_additiveExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(736);
			multiplicativeExpression();
			setState(741);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Plus || _la==Minus) {
				{
				{
				setState(737);
				_la = _input.LA(1);
				if ( !(_la==Plus || _la==Minus) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(738);
				multiplicativeExpression();
				}
				}
				setState(743);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ShiftExpressionContext extends org.example.antlr.common.context.ExtendContext {
		public List<AdditiveExpressionContext> additiveExpression() {
			return getRuleContexts(AdditiveExpressionContext.class);
		}
		public AdditiveExpressionContext additiveExpression(int i) {
			return getRuleContext(AdditiveExpressionContext.class,i);
		}
		public List<ShiftOperatorContext> shiftOperator() {
			return getRuleContexts(ShiftOperatorContext.class);
		}
		public ShiftOperatorContext shiftOperator(int i) {
			return getRuleContext(ShiftOperatorContext.class,i);
		}
		public ShiftExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_shiftExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).enterShiftExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).exitShiftExpression(this);
		}
	}

	public final ShiftExpressionContext shiftExpression() throws RecognitionException {
		ShiftExpressionContext _localctx = new ShiftExpressionContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_shiftExpression);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(744);
			additiveExpression();
			setState(750);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,61,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(745);
					shiftOperator();
					setState(746);
					additiveExpression();
					}
					} 
				}
				setState(752);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,61,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ShiftOperatorContext extends org.example.antlr.common.context.ExtendContext {
		public List<TerminalNode> Greater() { return getTokens(CPPParser.Greater); }
		public TerminalNode Greater(int i) {
			return getToken(CPPParser.Greater, i);
		}
		public List<TerminalNode> Less() { return getTokens(CPPParser.Less); }
		public TerminalNode Less(int i) {
			return getToken(CPPParser.Less, i);
		}
		public ShiftOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_shiftOperator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).enterShiftOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).exitShiftOperator(this);
		}
	}

	public final ShiftOperatorContext shiftOperator() throws RecognitionException {
		ShiftOperatorContext _localctx = new ShiftOperatorContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_shiftOperator);
		try {
			setState(757);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Greater:
				enterOuterAlt(_localctx, 1);
				{
				setState(753);
				match(Greater);
				setState(754);
				match(Greater);
				}
				break;
			case Less:
				enterOuterAlt(_localctx, 2);
				{
				setState(755);
				match(Less);
				setState(756);
				match(Less);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RelationalExpressionContext extends org.example.antlr.common.context.ExtendContext {
		public List<ShiftExpressionContext> shiftExpression() {
			return getRuleContexts(ShiftExpressionContext.class);
		}
		public ShiftExpressionContext shiftExpression(int i) {
			return getRuleContext(ShiftExpressionContext.class,i);
		}
		public List<TerminalNode> Less() { return getTokens(CPPParser.Less); }
		public TerminalNode Less(int i) {
			return getToken(CPPParser.Less, i);
		}
		public List<TerminalNode> Greater() { return getTokens(CPPParser.Greater); }
		public TerminalNode Greater(int i) {
			return getToken(CPPParser.Greater, i);
		}
		public List<TerminalNode> LessEqual() { return getTokens(CPPParser.LessEqual); }
		public TerminalNode LessEqual(int i) {
			return getToken(CPPParser.LessEqual, i);
		}
		public List<TerminalNode> GreaterEqual() { return getTokens(CPPParser.GreaterEqual); }
		public TerminalNode GreaterEqual(int i) {
			return getToken(CPPParser.GreaterEqual, i);
		}
		public RelationalExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relationalExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).enterRelationalExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).exitRelationalExpression(this);
		}
	}

	public final RelationalExpressionContext relationalExpression() throws RecognitionException {
		RelationalExpressionContext _localctx = new RelationalExpressionContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_relationalExpression);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(759);
			shiftExpression();
			setState(764);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,63,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(760);
					_la = _input.LA(1);
					if ( !(((((_la - 102)) & ~0x3f) == 0 && ((1L << (_la - 102)) & ((1L << (Less - 102)) | (1L << (Greater - 102)) | (1L << (LessEqual - 102)) | (1L << (GreaterEqual - 102)))) != 0)) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(761);
					shiftExpression();
					}
					} 
				}
				setState(766);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,63,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EqualityExpressionContext extends org.example.antlr.common.context.ExtendContext {
		public List<RelationalExpressionContext> relationalExpression() {
			return getRuleContexts(RelationalExpressionContext.class);
		}
		public RelationalExpressionContext relationalExpression(int i) {
			return getRuleContext(RelationalExpressionContext.class,i);
		}
		public List<TerminalNode> Equal() { return getTokens(CPPParser.Equal); }
		public TerminalNode Equal(int i) {
			return getToken(CPPParser.Equal, i);
		}
		public List<TerminalNode> NotEqual() { return getTokens(CPPParser.NotEqual); }
		public TerminalNode NotEqual(int i) {
			return getToken(CPPParser.NotEqual, i);
		}
		public EqualityExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_equalityExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).enterEqualityExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).exitEqualityExpression(this);
		}
	}

	public final EqualityExpressionContext equalityExpression() throws RecognitionException {
		EqualityExpressionContext _localctx = new EqualityExpressionContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_equalityExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(767);
			relationalExpression();
			setState(772);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Equal || _la==NotEqual) {
				{
				{
				setState(768);
				_la = _input.LA(1);
				if ( !(_la==Equal || _la==NotEqual) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(769);
				relationalExpression();
				}
				}
				setState(774);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AndExpressionContext extends org.example.antlr.common.context.ExtendContext {
		public List<EqualityExpressionContext> equalityExpression() {
			return getRuleContexts(EqualityExpressionContext.class);
		}
		public EqualityExpressionContext equalityExpression(int i) {
			return getRuleContext(EqualityExpressionContext.class,i);
		}
		public List<TerminalNode> And() { return getTokens(CPPParser.And); }
		public TerminalNode And(int i) {
			return getToken(CPPParser.And, i);
		}
		public AndExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_andExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).enterAndExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).exitAndExpression(this);
		}
	}

	public final AndExpressionContext andExpression() throws RecognitionException {
		AndExpressionContext _localctx = new AndExpressionContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_andExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(775);
			equalityExpression();
			setState(780);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==And) {
				{
				{
				setState(776);
				match(And);
				setState(777);
				equalityExpression();
				}
				}
				setState(782);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExclusiveOrExpressionContext extends org.example.antlr.common.context.ExtendContext {
		public List<AndExpressionContext> andExpression() {
			return getRuleContexts(AndExpressionContext.class);
		}
		public AndExpressionContext andExpression(int i) {
			return getRuleContext(AndExpressionContext.class,i);
		}
		public List<TerminalNode> Caret() { return getTokens(CPPParser.Caret); }
		public TerminalNode Caret(int i) {
			return getToken(CPPParser.Caret, i);
		}
		public ExclusiveOrExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exclusiveOrExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).enterExclusiveOrExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).exitExclusiveOrExpression(this);
		}
	}

	public final ExclusiveOrExpressionContext exclusiveOrExpression() throws RecognitionException {
		ExclusiveOrExpressionContext _localctx = new ExclusiveOrExpressionContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_exclusiveOrExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(783);
			andExpression();
			setState(788);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Caret) {
				{
				{
				setState(784);
				match(Caret);
				setState(785);
				andExpression();
				}
				}
				setState(790);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InclusiveOrExpressionContext extends org.example.antlr.common.context.ExtendContext {
		public List<ExclusiveOrExpressionContext> exclusiveOrExpression() {
			return getRuleContexts(ExclusiveOrExpressionContext.class);
		}
		public ExclusiveOrExpressionContext exclusiveOrExpression(int i) {
			return getRuleContext(ExclusiveOrExpressionContext.class,i);
		}
		public List<TerminalNode> Or() { return getTokens(CPPParser.Or); }
		public TerminalNode Or(int i) {
			return getToken(CPPParser.Or, i);
		}
		public InclusiveOrExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inclusiveOrExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).enterInclusiveOrExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).exitInclusiveOrExpression(this);
		}
	}

	public final InclusiveOrExpressionContext inclusiveOrExpression() throws RecognitionException {
		InclusiveOrExpressionContext _localctx = new InclusiveOrExpressionContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_inclusiveOrExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(791);
			exclusiveOrExpression();
			setState(796);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Or) {
				{
				{
				setState(792);
				match(Or);
				setState(793);
				exclusiveOrExpression();
				}
				}
				setState(798);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LogicalAndExpressionContext extends org.example.antlr.common.context.ExtendContext {
		public List<InclusiveOrExpressionContext> inclusiveOrExpression() {
			return getRuleContexts(InclusiveOrExpressionContext.class);
		}
		public InclusiveOrExpressionContext inclusiveOrExpression(int i) {
			return getRuleContext(InclusiveOrExpressionContext.class,i);
		}
		public List<TerminalNode> AndAnd() { return getTokens(CPPParser.AndAnd); }
		public TerminalNode AndAnd(int i) {
			return getToken(CPPParser.AndAnd, i);
		}
		public LogicalAndExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logicalAndExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).enterLogicalAndExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).exitLogicalAndExpression(this);
		}
	}

	public final LogicalAndExpressionContext logicalAndExpression() throws RecognitionException {
		LogicalAndExpressionContext _localctx = new LogicalAndExpressionContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_logicalAndExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(799);
			inclusiveOrExpression();
			setState(804);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AndAnd) {
				{
				{
				setState(800);
				match(AndAnd);
				setState(801);
				inclusiveOrExpression();
				}
				}
				setState(806);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LogicalOrExpressionContext extends org.example.antlr.common.context.ExtendContext {
		public List<LogicalAndExpressionContext> logicalAndExpression() {
			return getRuleContexts(LogicalAndExpressionContext.class);
		}
		public LogicalAndExpressionContext logicalAndExpression(int i) {
			return getRuleContext(LogicalAndExpressionContext.class,i);
		}
		public List<TerminalNode> OrOr() { return getTokens(CPPParser.OrOr); }
		public TerminalNode OrOr(int i) {
			return getToken(CPPParser.OrOr, i);
		}
		public LogicalOrExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logicalOrExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).enterLogicalOrExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).exitLogicalOrExpression(this);
		}
	}

	public final LogicalOrExpressionContext logicalOrExpression() throws RecognitionException {
		LogicalOrExpressionContext _localctx = new LogicalOrExpressionContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_logicalOrExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(807);
			logicalAndExpression();
			setState(812);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OrOr) {
				{
				{
				setState(808);
				match(OrOr);
				setState(809);
				logicalAndExpression();
				}
				}
				setState(814);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConditionalExpressionContext extends org.example.antlr.common.context.ExtendContext {
		public LogicalOrExpressionContext logicalOrExpression() {
			return getRuleContext(LogicalOrExpressionContext.class,0);
		}
		public TerminalNode Question() { return getToken(CPPParser.Question, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode Colon() { return getToken(CPPParser.Colon, 0); }
		public AssignmentExpressionContext assignmentExpression() {
			return getRuleContext(AssignmentExpressionContext.class,0);
		}
		public ConditionalExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conditionalExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).enterConditionalExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).exitConditionalExpression(this);
		}
	}

	public final ConditionalExpressionContext conditionalExpression() throws RecognitionException {
		ConditionalExpressionContext _localctx = new ConditionalExpressionContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_conditionalExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(815);
			logicalOrExpression();
			setState(821);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Question) {
				{
				setState(816);
				match(Question);
				setState(817);
				expression();
				setState(818);
				match(Colon);
				setState(819);
				assignmentExpression();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AssignmentExpressionContext extends org.example.antlr.common.context.ExtendContext {
		public ConditionalExpressionContext conditionalExpression() {
			return getRuleContext(ConditionalExpressionContext.class,0);
		}
		public LogicalOrExpressionContext logicalOrExpression() {
			return getRuleContext(LogicalOrExpressionContext.class,0);
		}
		public AssignmentOperatorContext assignmentOperator() {
			return getRuleContext(AssignmentOperatorContext.class,0);
		}
		public InitializerClauseContext initializerClause() {
			return getRuleContext(InitializerClauseContext.class,0);
		}
		public ThrowExpressionContext throwExpression() {
			return getRuleContext(ThrowExpressionContext.class,0);
		}
		public AssignmentExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignmentExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).enterAssignmentExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).exitAssignmentExpression(this);
		}
	}

	public final AssignmentExpressionContext assignmentExpression() throws RecognitionException {
		AssignmentExpressionContext _localctx = new AssignmentExpressionContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_assignmentExpression);
		try {
			setState(829);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,71,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(823);
				conditionalExpression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(824);
				logicalOrExpression();
				setState(825);
				assignmentOperator();
				setState(826);
				initializerClause();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(828);
				throwExpression();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AssignmentOperatorContext extends org.example.antlr.common.context.ExtendContext {
		public TerminalNode Assign() { return getToken(CPPParser.Assign, 0); }
		public TerminalNode StarAssign() { return getToken(CPPParser.StarAssign, 0); }
		public TerminalNode DivAssign() { return getToken(CPPParser.DivAssign, 0); }
		public TerminalNode ModAssign() { return getToken(CPPParser.ModAssign, 0); }
		public TerminalNode PlusAssign() { return getToken(CPPParser.PlusAssign, 0); }
		public TerminalNode MinusAssign() { return getToken(CPPParser.MinusAssign, 0); }
		public TerminalNode RightShiftAssign() { return getToken(CPPParser.RightShiftAssign, 0); }
		public TerminalNode LeftShiftAssign() { return getToken(CPPParser.LeftShiftAssign, 0); }
		public TerminalNode AndAssign() { return getToken(CPPParser.AndAssign, 0); }
		public TerminalNode XorAssign() { return getToken(CPPParser.XorAssign, 0); }
		public TerminalNode OrAssign() { return getToken(CPPParser.OrAssign, 0); }
		public AssignmentOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignmentOperator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).enterAssignmentOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).exitAssignmentOperator(this);
		}
	}

	public final AssignmentOperatorContext assignmentOperator() throws RecognitionException {
		AssignmentOperatorContext _localctx = new AssignmentOperatorContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_assignmentOperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(831);
			_la = _input.LA(1);
			if ( !(((((_la - 101)) & ~0x3f) == 0 && ((1L << (_la - 101)) & ((1L << (Assign - 101)) | (1L << (PlusAssign - 101)) | (1L << (MinusAssign - 101)) | (1L << (StarAssign - 101)) | (1L << (DivAssign - 101)) | (1L << (ModAssign - 101)) | (1L << (XorAssign - 101)) | (1L << (AndAssign - 101)) | (1L << (OrAssign - 101)) | (1L << (LeftShiftAssign - 101)) | (1L << (RightShiftAssign - 101)))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends org.example.antlr.common.context.ExtendContext {
		public List<AssignmentExpressionContext> assignmentExpression() {
			return getRuleContexts(AssignmentExpressionContext.class);
		}
		public AssignmentExpressionContext assignmentExpression(int i) {
			return getRuleContext(AssignmentExpressionContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(CPPParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(CPPParser.Comma, i);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).exitExpression(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(833);
			assignmentExpression();
			setState(838);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(834);
				match(Comma);
				setState(835);
				assignmentExpression();
				}
				}
				setState(840);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstantExpressionContext extends org.example.antlr.common.context.ExtendContext {
		public ConditionalExpressionContext conditionalExpression() {
			return getRuleContext(ConditionalExpressionContext.class,0);
		}
		public ConstantExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constantExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).enterConstantExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).exitConstantExpression(this);
		}
	}

	public final ConstantExpressionContext constantExpression() throws RecognitionException {
		ConstantExpressionContext _localctx = new ConstantExpressionContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_constantExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(841);
			conditionalExpression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementContext extends org.example.antlr.common.context.ExtendContext {
		public LabeledStatementContext labeledStatement() {
			return getRuleContext(LabeledStatementContext.class,0);
		}
		public DeclarationStatementContext declarationStatement() {
			return getRuleContext(DeclarationStatementContext.class,0);
		}
		public ExpressionStatementContext expressionStatement() {
			return getRuleContext(ExpressionStatementContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public IfStatementContext ifStatement() {
			return getRuleContext(IfStatementContext.class,0);
		}
		public IfElseStatementContext ifElseStatement() {
			return getRuleContext(IfElseStatementContext.class,0);
		}
		public SwitchStatementContext switchStatement() {
			return getRuleContext(SwitchStatementContext.class,0);
		}
		public WhileStatementContext whileStatement() {
			return getRuleContext(WhileStatementContext.class,0);
		}
		public DoWhileStatementContext doWhileStatement() {
			return getRuleContext(DoWhileStatementContext.class,0);
		}
		public ForStatementContext forStatement() {
			return getRuleContext(ForStatementContext.class,0);
		}
		public JumpStatementContext jumpStatement() {
			return getRuleContext(JumpStatementContext.class,0);
		}
		public TryBlockContext tryBlock() {
			return getRuleContext(TryBlockContext.class,0);
		}
		public AttributeSpecifierSeqContext attributeSpecifierSeq() {
			return getRuleContext(AttributeSpecifierSeqContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).exitStatement(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_statement);
		try {
			setState(860);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,75,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(843);
				labeledStatement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(844);
				declarationStatement();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(846);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,73,_ctx) ) {
				case 1:
					{
					setState(845);
					attributeSpecifierSeq();
					}
					break;
				}
				setState(858);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,74,_ctx) ) {
				case 1:
					{
					setState(848);
					expressionStatement();
					}
					break;
				case 2:
					{
					setState(849);
					block();
					}
					break;
				case 3:
					{
					setState(850);
					ifStatement();
					}
					break;
				case 4:
					{
					setState(851);
					ifElseStatement();
					}
					break;
				case 5:
					{
					setState(852);
					switchStatement();
					}
					break;
				case 6:
					{
					setState(853);
					whileStatement();
					}
					break;
				case 7:
					{
					setState(854);
					doWhileStatement();
					}
					break;
				case 8:
					{
					setState(855);
					forStatement();
					}
					break;
				case 9:
					{
					setState(856);
					jumpStatement();
					}
					break;
				case 10:
					{
					setState(857);
					tryBlock();
					}
					break;
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LabeledStatementContext extends org.example.antlr.common.context.ExtendContext {
		public TerminalNode Colon() { return getToken(CPPParser.Colon, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(CPPParser.Identifier, 0); }
		public TerminalNode Case() { return getToken(CPPParser.Case, 0); }
		public ConstantExpressionContext constantExpression() {
			return getRuleContext(ConstantExpressionContext.class,0);
		}
		public TerminalNode Default() { return getToken(CPPParser.Default, 0); }
		public AttributeSpecifierSeqContext attributeSpecifierSeq() {
			return getRuleContext(AttributeSpecifierSeqContext.class,0);
		}
		public LabeledStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_labeledStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).enterLabeledStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).exitLabeledStatement(this);
		}
	}

	public final LabeledStatementContext labeledStatement() throws RecognitionException {
		LabeledStatementContext _localctx = new LabeledStatementContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_labeledStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(863);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Alignas || _la==LeftBracket) {
				{
				setState(862);
				attributeSpecifierSeq();
				}
			}

			setState(869);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Identifier:
				{
				setState(865);
				match(Identifier);
				}
				break;
			case Case:
				{
				setState(866);
				match(Case);
				setState(867);
				constantExpression();
				}
				break;
			case Default:
				{
				setState(868);
				match(Default);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(871);
			match(Colon);
			setState(872);
			statement();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionStatementContext extends org.example.antlr.common.context.ExtendContext {
		public TerminalNode Semi() { return getToken(CPPParser.Semi, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ExpressionStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).enterExpressionStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).exitExpressionStatement(this);
		}
	}

	public final ExpressionStatementContext expressionStatement() throws RecognitionException {
		ExpressionStatementContext _localctx = new ExpressionStatementContext(_ctx, getState());
		enterRule(_localctx, 98, RULE_expressionStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(875);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IntegerLiteral) | (1L << CharacterLiteral) | (1L << FloatingLiteral) | (1L << StringLiteral) | (1L << BooleanLiteral) | (1L << PointerLiteral) | (1L << UserDefinedLiteral) | (1L << Alignof) | (1L << Auto) | (1L << Bool) | (1L << Char) | (1L << Char16) | (1L << Char32) | (1L << Const_cast) | (1L << Decltype) | (1L << Delete) | (1L << Double) | (1L << Dynamic_cast) | (1L << Float) | (1L << Int) | (1L << Long) | (1L << New) | (1L << Noexcept) | (1L << Operator) | (1L << Reinterpret_cast) | (1L << Short) | (1L << Signed) | (1L << Sizeof))) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (Static_cast - 65)) | (1L << (This - 65)) | (1L << (Throw - 65)) | (1L << (Typeid_ - 65)) | (1L << (Typename_ - 65)) | (1L << (Unsigned - 65)) | (1L << (Void - 65)) | (1L << (Wchar - 65)) | (1L << (LeftParen - 65)) | (1L << (LeftBracket - 65)) | (1L << (Plus - 65)) | (1L << (Minus - 65)) | (1L << (Star - 65)) | (1L << (And - 65)) | (1L << (Or - 65)) | (1L << (Tilde - 65)) | (1L << (Not - 65)) | (1L << (PlusPlus - 65)) | (1L << (MinusMinus - 65)) | (1L << (Doublecolon - 65)))) != 0) || _la==Identifier) {
				{
				setState(874);
				expression();
				}
			}

			setState(877);
			match(Semi);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlockContext extends org.example.antlr.common.context.ExtendContext {
		public TerminalNode LeftBrace() { return getToken(CPPParser.LeftBrace, 0); }
		public TerminalNode RightBrace() { return getToken(CPPParser.RightBrace, 0); }
		public StatementSeqContext statementSeq() {
			return getRuleContext(StatementSeqContext.class,0);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).exitBlock(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 100, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(879);
			match(LeftBrace);
			setState(881);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IntegerLiteral) | (1L << CharacterLiteral) | (1L << FloatingLiteral) | (1L << StringLiteral) | (1L << BooleanLiteral) | (1L << PointerLiteral) | (1L << UserDefinedLiteral) | (1L << Alignas) | (1L << Alignof) | (1L << Asm) | (1L << Auto) | (1L << Bool) | (1L << Break) | (1L << Case) | (1L << Char) | (1L << Char16) | (1L << Char32) | (1L << Class) | (1L << Const) | (1L << Constexpr) | (1L << Const_cast) | (1L << Continue) | (1L << Decltype) | (1L << Default) | (1L << Delete) | (1L << Do) | (1L << Double) | (1L << Dynamic_cast) | (1L << Enum) | (1L << Explicit) | (1L << Extern) | (1L << Float) | (1L << For) | (1L << Friend) | (1L << Goto) | (1L << If) | (1L << Inline) | (1L << Int) | (1L << Long) | (1L << Mutable) | (1L << Namespace) | (1L << New) | (1L << Noexcept) | (1L << Operator) | (1L << Register) | (1L << Reinterpret_cast) | (1L << Return) | (1L << Short) | (1L << Signed) | (1L << Sizeof) | (1L << Static))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (Static_assert - 64)) | (1L << (Static_cast - 64)) | (1L << (Struct - 64)) | (1L << (Switch - 64)) | (1L << (This - 64)) | (1L << (Thread_local - 64)) | (1L << (Throw - 64)) | (1L << (Try - 64)) | (1L << (Typedef - 64)) | (1L << (Typeid_ - 64)) | (1L << (Typename_ - 64)) | (1L << (Union - 64)) | (1L << (Unsigned - 64)) | (1L << (Using - 64)) | (1L << (Virtual - 64)) | (1L << (Void - 64)) | (1L << (Volatile - 64)) | (1L << (Wchar - 64)) | (1L << (While - 64)) | (1L << (LeftParen - 64)) | (1L << (LeftBracket - 64)) | (1L << (LeftBrace - 64)) | (1L << (Plus - 64)) | (1L << (Minus - 64)) | (1L << (Star - 64)) | (1L << (And - 64)) | (1L << (Or - 64)) | (1L << (Tilde - 64)) | (1L << (Not - 64)) | (1L << (AndAnd - 64)) | (1L << (PlusPlus - 64)) | (1L << (MinusMinus - 64)) | (1L << (Doublecolon - 64)))) != 0) || ((((_la - 128)) & ~0x3f) == 0 && ((1L << (_la - 128)) & ((1L << (Semi - 128)) | (1L << (Ellipsis - 128)) | (1L << (Identifier - 128)))) != 0)) {
				{
				setState(880);
				statementSeq();
				}
			}

			setState(883);
			match(RightBrace);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementSeqContext extends org.example.antlr.common.context.ExtendContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public StatementSeqContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statementSeq; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).enterStatementSeq(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).exitStatementSeq(this);
		}
	}

	public final StatementSeqContext statementSeq() throws RecognitionException {
		StatementSeqContext _localctx = new StatementSeqContext(_ctx, getState());
		enterRule(_localctx, 102, RULE_statementSeq);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(886); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(885);
				statement();
				}
				}
				setState(888); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IntegerLiteral) | (1L << CharacterLiteral) | (1L << FloatingLiteral) | (1L << StringLiteral) | (1L << BooleanLiteral) | (1L << PointerLiteral) | (1L << UserDefinedLiteral) | (1L << Alignas) | (1L << Alignof) | (1L << Asm) | (1L << Auto) | (1L << Bool) | (1L << Break) | (1L << Case) | (1L << Char) | (1L << Char16) | (1L << Char32) | (1L << Class) | (1L << Const) | (1L << Constexpr) | (1L << Const_cast) | (1L << Continue) | (1L << Decltype) | (1L << Default) | (1L << Delete) | (1L << Do) | (1L << Double) | (1L << Dynamic_cast) | (1L << Enum) | (1L << Explicit) | (1L << Extern) | (1L << Float) | (1L << For) | (1L << Friend) | (1L << Goto) | (1L << If) | (1L << Inline) | (1L << Int) | (1L << Long) | (1L << Mutable) | (1L << Namespace) | (1L << New) | (1L << Noexcept) | (1L << Operator) | (1L << Register) | (1L << Reinterpret_cast) | (1L << Return) | (1L << Short) | (1L << Signed) | (1L << Sizeof) | (1L << Static))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (Static_assert - 64)) | (1L << (Static_cast - 64)) | (1L << (Struct - 64)) | (1L << (Switch - 64)) | (1L << (This - 64)) | (1L << (Thread_local - 64)) | (1L << (Throw - 64)) | (1L << (Try - 64)) | (1L << (Typedef - 64)) | (1L << (Typeid_ - 64)) | (1L << (Typename_ - 64)) | (1L << (Union - 64)) | (1L << (Unsigned - 64)) | (1L << (Using - 64)) | (1L << (Virtual - 64)) | (1L << (Void - 64)) | (1L << (Volatile - 64)) | (1L << (Wchar - 64)) | (1L << (While - 64)) | (1L << (LeftParen - 64)) | (1L << (LeftBracket - 64)) | (1L << (LeftBrace - 64)) | (1L << (Plus - 64)) | (1L << (Minus - 64)) | (1L << (Star - 64)) | (1L << (And - 64)) | (1L << (Or - 64)) | (1L << (Tilde - 64)) | (1L << (Not - 64)) | (1L << (AndAnd - 64)) | (1L << (PlusPlus - 64)) | (1L << (MinusMinus - 64)) | (1L << (Doublecolon - 64)))) != 0) || ((((_la - 128)) & ~0x3f) == 0 && ((1L << (_la - 128)) & ((1L << (Semi - 128)) | (1L << (Ellipsis - 128)) | (1L << (Identifier - 128)))) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IfStatementContext extends org.example.antlr.common.context.ExtendContext {
		public TerminalNode If() { return getToken(CPPParser.If, 0); }
		public TerminalNode LeftParen() { return getToken(CPPParser.LeftParen, 0); }
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public TerminalNode RightParen() { return getToken(CPPParser.RightParen, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public IfStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).enterIfStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).exitIfStatement(this);
		}
	}

	public final IfStatementContext ifStatement() throws RecognitionException {
		IfStatementContext _localctx = new IfStatementContext(_ctx, getState());
		enterRule(_localctx, 104, RULE_ifStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(890);
			match(If);
			setState(891);
			match(LeftParen);
			setState(892);
			condition();
			setState(893);
			match(RightParen);
			setState(894);
			statement();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IfElseStatementContext extends org.example.antlr.common.context.ExtendContext {
		public TerminalNode If() { return getToken(CPPParser.If, 0); }
		public TerminalNode LeftParen() { return getToken(CPPParser.LeftParen, 0); }
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public TerminalNode RightParen() { return getToken(CPPParser.RightParen, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public TerminalNode Else() { return getToken(CPPParser.Else, 0); }
		public IfElseStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifElseStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).enterIfElseStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).exitIfElseStatement(this);
		}
	}

	public final IfElseStatementContext ifElseStatement() throws RecognitionException {
		IfElseStatementContext _localctx = new IfElseStatementContext(_ctx, getState());
		enterRule(_localctx, 106, RULE_ifElseStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(896);
			match(If);
			setState(897);
			match(LeftParen);
			setState(898);
			condition();
			setState(899);
			match(RightParen);
			setState(900);
			statement();
			setState(901);
			match(Else);
			setState(902);
			statement();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SwitchStatementContext extends org.example.antlr.common.context.ExtendContext {
		public TerminalNode Switch() { return getToken(CPPParser.Switch, 0); }
		public TerminalNode LeftParen() { return getToken(CPPParser.LeftParen, 0); }
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public TerminalNode RightParen() { return getToken(CPPParser.RightParen, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public SwitchStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_switchStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).enterSwitchStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).exitSwitchStatement(this);
		}
	}

	public final SwitchStatementContext switchStatement() throws RecognitionException {
		SwitchStatementContext _localctx = new SwitchStatementContext(_ctx, getState());
		enterRule(_localctx, 108, RULE_switchStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(904);
			match(Switch);
			setState(905);
			match(LeftParen);
			setState(906);
			condition();
			setState(907);
			match(RightParen);
			setState(908);
			statement();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConditionContext extends org.example.antlr.common.context.ExtendContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public DeclSpecifierSeqContext declSpecifierSeq() {
			return getRuleContext(DeclSpecifierSeqContext.class,0);
		}
		public DeclaratorContext declarator() {
			return getRuleContext(DeclaratorContext.class,0);
		}
		public TerminalNode Assign() { return getToken(CPPParser.Assign, 0); }
		public InitializerClauseContext initializerClause() {
			return getRuleContext(InitializerClauseContext.class,0);
		}
		public BracedInitListContext bracedInitList() {
			return getRuleContext(BracedInitListContext.class,0);
		}
		public AttributeSpecifierSeqContext attributeSpecifierSeq() {
			return getRuleContext(AttributeSpecifierSeqContext.class,0);
		}
		public ConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).enterCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).exitCondition(this);
		}
	}

	public final ConditionContext condition() throws RecognitionException {
		ConditionContext _localctx = new ConditionContext(_ctx, getState());
		enterRule(_localctx, 110, RULE_condition);
		int _la;
		try {
			setState(921);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,83,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(910);
				expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(912);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Alignas || _la==LeftBracket) {
					{
					setState(911);
					attributeSpecifierSeq();
					}
				}

				setState(914);
				declSpecifierSeq();
				setState(915);
				declarator();
				setState(919);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case Assign:
					{
					setState(916);
					match(Assign);
					setState(917);
					initializerClause();
					}
					break;
				case LeftBrace:
					{
					setState(918);
					bracedInitList();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WhileStatementContext extends org.example.antlr.common.context.ExtendContext {
		public TerminalNode While() { return getToken(CPPParser.While, 0); }
		public TerminalNode LeftParen() { return getToken(CPPParser.LeftParen, 0); }
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public TerminalNode RightParen() { return getToken(CPPParser.RightParen, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public WhileStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).enterWhileStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).exitWhileStatement(this);
		}
	}

	public final WhileStatementContext whileStatement() throws RecognitionException {
		WhileStatementContext _localctx = new WhileStatementContext(_ctx, getState());
		enterRule(_localctx, 112, RULE_whileStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(923);
			match(While);
			setState(924);
			match(LeftParen);
			setState(925);
			condition();
			setState(926);
			match(RightParen);
			setState(927);
			statement();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DoWhileStatementContext extends org.example.antlr.common.context.ExtendContext {
		public TerminalNode Do() { return getToken(CPPParser.Do, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public TerminalNode While() { return getToken(CPPParser.While, 0); }
		public TerminalNode LeftParen() { return getToken(CPPParser.LeftParen, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RightParen() { return getToken(CPPParser.RightParen, 0); }
		public TerminalNode Semi() { return getToken(CPPParser.Semi, 0); }
		public DoWhileStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_doWhileStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).enterDoWhileStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).exitDoWhileStatement(this);
		}
	}

	public final DoWhileStatementContext doWhileStatement() throws RecognitionException {
		DoWhileStatementContext _localctx = new DoWhileStatementContext(_ctx, getState());
		enterRule(_localctx, 114, RULE_doWhileStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(929);
			match(Do);
			setState(930);
			statement();
			setState(931);
			match(While);
			setState(932);
			match(LeftParen);
			setState(933);
			expression();
			setState(934);
			match(RightParen);
			setState(935);
			match(Semi);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ForStatementContext extends org.example.antlr.common.context.ExtendContext {
		public TerminalNode For() { return getToken(CPPParser.For, 0); }
		public TerminalNode LeftParen() { return getToken(CPPParser.LeftParen, 0); }
		public TerminalNode RightParen() { return getToken(CPPParser.RightParen, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public ForInitStatementContext forInitStatement() {
			return getRuleContext(ForInitStatementContext.class,0);
		}
		public TerminalNode Semi() { return getToken(CPPParser.Semi, 0); }
		public ForRangeDeclarationContext forRangeDeclaration() {
			return getRuleContext(ForRangeDeclarationContext.class,0);
		}
		public TerminalNode Colon() { return getToken(CPPParser.Colon, 0); }
		public ForRangeInitializerContext forRangeInitializer() {
			return getRuleContext(ForRangeInitializerContext.class,0);
		}
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ForStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).enterForStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).exitForStatement(this);
		}
	}

	public final ForStatementContext forStatement() throws RecognitionException {
		ForStatementContext _localctx = new ForStatementContext(_ctx, getState());
		enterRule(_localctx, 116, RULE_forStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(937);
			match(For);
			setState(938);
			match(LeftParen);
			setState(951);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,86,_ctx) ) {
			case 1:
				{
				setState(939);
				forInitStatement();
				setState(941);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IntegerLiteral) | (1L << CharacterLiteral) | (1L << FloatingLiteral) | (1L << StringLiteral) | (1L << BooleanLiteral) | (1L << PointerLiteral) | (1L << UserDefinedLiteral) | (1L << Alignas) | (1L << Alignof) | (1L << Auto) | (1L << Bool) | (1L << Char) | (1L << Char16) | (1L << Char32) | (1L << Class) | (1L << Const) | (1L << Constexpr) | (1L << Const_cast) | (1L << Decltype) | (1L << Delete) | (1L << Double) | (1L << Dynamic_cast) | (1L << Enum) | (1L << Explicit) | (1L << Extern) | (1L << Float) | (1L << Friend) | (1L << Inline) | (1L << Int) | (1L << Long) | (1L << Mutable) | (1L << New) | (1L << Noexcept) | (1L << Operator) | (1L << Register) | (1L << Reinterpret_cast) | (1L << Short) | (1L << Signed) | (1L << Sizeof) | (1L << Static))) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (Static_cast - 65)) | (1L << (Struct - 65)) | (1L << (This - 65)) | (1L << (Thread_local - 65)) | (1L << (Throw - 65)) | (1L << (Typedef - 65)) | (1L << (Typeid_ - 65)) | (1L << (Typename_ - 65)) | (1L << (Union - 65)) | (1L << (Unsigned - 65)) | (1L << (Virtual - 65)) | (1L << (Void - 65)) | (1L << (Volatile - 65)) | (1L << (Wchar - 65)) | (1L << (LeftParen - 65)) | (1L << (LeftBracket - 65)) | (1L << (Plus - 65)) | (1L << (Minus - 65)) | (1L << (Star - 65)) | (1L << (And - 65)) | (1L << (Or - 65)) | (1L << (Tilde - 65)) | (1L << (Not - 65)) | (1L << (PlusPlus - 65)) | (1L << (MinusMinus - 65)) | (1L << (Doublecolon - 65)))) != 0) || _la==Identifier) {
					{
					setState(940);
					condition();
					}
				}

				setState(943);
				match(Semi);
				setState(945);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IntegerLiteral) | (1L << CharacterLiteral) | (1L << FloatingLiteral) | (1L << StringLiteral) | (1L << BooleanLiteral) | (1L << PointerLiteral) | (1L << UserDefinedLiteral) | (1L << Alignof) | (1L << Auto) | (1L << Bool) | (1L << Char) | (1L << Char16) | (1L << Char32) | (1L << Const_cast) | (1L << Decltype) | (1L << Delete) | (1L << Double) | (1L << Dynamic_cast) | (1L << Float) | (1L << Int) | (1L << Long) | (1L << New) | (1L << Noexcept) | (1L << Operator) | (1L << Reinterpret_cast) | (1L << Short) | (1L << Signed) | (1L << Sizeof))) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (Static_cast - 65)) | (1L << (This - 65)) | (1L << (Throw - 65)) | (1L << (Typeid_ - 65)) | (1L << (Typename_ - 65)) | (1L << (Unsigned - 65)) | (1L << (Void - 65)) | (1L << (Wchar - 65)) | (1L << (LeftParen - 65)) | (1L << (LeftBracket - 65)) | (1L << (Plus - 65)) | (1L << (Minus - 65)) | (1L << (Star - 65)) | (1L << (And - 65)) | (1L << (Or - 65)) | (1L << (Tilde - 65)) | (1L << (Not - 65)) | (1L << (PlusPlus - 65)) | (1L << (MinusMinus - 65)) | (1L << (Doublecolon - 65)))) != 0) || _la==Identifier) {
					{
					setState(944);
					expression();
					}
				}

				}
				break;
			case 2:
				{
				setState(947);
				forRangeDeclaration();
				setState(948);
				match(Colon);
				setState(949);
				forRangeInitializer();
				}
				break;
			}
			setState(953);
			match(RightParen);
			setState(954);
			statement();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ForInitStatementContext extends org.example.antlr.common.context.ExtendContext {
		public ExpressionStatementContext expressionStatement() {
			return getRuleContext(ExpressionStatementContext.class,0);
		}
		public SimpleDeclarationContext simpleDeclaration() {
			return getRuleContext(SimpleDeclarationContext.class,0);
		}
		public ForInitStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forInitStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).enterForInitStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).exitForInitStatement(this);
		}
	}

	public final ForInitStatementContext forInitStatement() throws RecognitionException {
		ForInitStatementContext _localctx = new ForInitStatementContext(_ctx, getState());
		enterRule(_localctx, 118, RULE_forInitStatement);
		try {
			setState(958);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,87,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(956);
				expressionStatement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(957);
				simpleDeclaration();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ForRangeDeclarationContext extends org.example.antlr.common.context.ExtendContext {
		public DeclSpecifierSeqContext declSpecifierSeq() {
			return getRuleContext(DeclSpecifierSeqContext.class,0);
		}
		public DeclaratorContext declarator() {
			return getRuleContext(DeclaratorContext.class,0);
		}
		public AttributeSpecifierSeqContext attributeSpecifierSeq() {
			return getRuleContext(AttributeSpecifierSeqContext.class,0);
		}
		public ForRangeDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forRangeDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).enterForRangeDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).exitForRangeDeclaration(this);
		}
	}

	public final ForRangeDeclarationContext forRangeDeclaration() throws RecognitionException {
		ForRangeDeclarationContext _localctx = new ForRangeDeclarationContext(_ctx, getState());
		enterRule(_localctx, 120, RULE_forRangeDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(961);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Alignas || _la==LeftBracket) {
				{
				setState(960);
				attributeSpecifierSeq();
				}
			}

			setState(963);
			declSpecifierSeq();
			setState(964);
			declarator();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ForRangeInitializerContext extends org.example.antlr.common.context.ExtendContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public BracedInitListContext bracedInitList() {
			return getRuleContext(BracedInitListContext.class,0);
		}
		public ForRangeInitializerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forRangeInitializer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).enterForRangeInitializer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).exitForRangeInitializer(this);
		}
	}

	public final ForRangeInitializerContext forRangeInitializer() throws RecognitionException {
		ForRangeInitializerContext _localctx = new ForRangeInitializerContext(_ctx, getState());
		enterRule(_localctx, 122, RULE_forRangeInitializer);
		try {
			setState(968);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IntegerLiteral:
			case CharacterLiteral:
			case FloatingLiteral:
			case StringLiteral:
			case BooleanLiteral:
			case PointerLiteral:
			case UserDefinedLiteral:
			case Alignof:
			case Auto:
			case Bool:
			case Char:
			case Char16:
			case Char32:
			case Const_cast:
			case Decltype:
			case Delete:
			case Double:
			case Dynamic_cast:
			case Float:
			case Int:
			case Long:
			case New:
			case Noexcept:
			case Operator:
			case Reinterpret_cast:
			case Short:
			case Signed:
			case Sizeof:
			case Static_cast:
			case This:
			case Throw:
			case Typeid_:
			case Typename_:
			case Unsigned:
			case Void:
			case Wchar:
			case LeftParen:
			case LeftBracket:
			case Plus:
			case Minus:
			case Star:
			case And:
			case Or:
			case Tilde:
			case Not:
			case PlusPlus:
			case MinusMinus:
			case Doublecolon:
			case Identifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(966);
				expression();
				}
				break;
			case LeftBrace:
				enterOuterAlt(_localctx, 2);
				{
				setState(967);
				bracedInitList();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class JumpStatementContext extends org.example.antlr.common.context.ExtendContext {
		public TerminalNode Semi() { return getToken(CPPParser.Semi, 0); }
		public TerminalNode Break() { return getToken(CPPParser.Break, 0); }
		public TerminalNode Continue() { return getToken(CPPParser.Continue, 0); }
		public TerminalNode Return() { return getToken(CPPParser.Return, 0); }
		public TerminalNode Goto() { return getToken(CPPParser.Goto, 0); }
		public TerminalNode Identifier() { return getToken(CPPParser.Identifier, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public BracedInitListContext bracedInitList() {
			return getRuleContext(BracedInitListContext.class,0);
		}
		public JumpStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jumpStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).enterJumpStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).exitJumpStatement(this);
		}
	}

	public final JumpStatementContext jumpStatement() throws RecognitionException {
		JumpStatementContext _localctx = new JumpStatementContext(_ctx, getState());
		enterRule(_localctx, 124, RULE_jumpStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(979);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Break:
				{
				setState(970);
				match(Break);
				}
				break;
			case Continue:
				{
				setState(971);
				match(Continue);
				}
				break;
			case Return:
				{
				setState(972);
				match(Return);
				setState(975);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case IntegerLiteral:
				case CharacterLiteral:
				case FloatingLiteral:
				case StringLiteral:
				case BooleanLiteral:
				case PointerLiteral:
				case UserDefinedLiteral:
				case Alignof:
				case Auto:
				case Bool:
				case Char:
				case Char16:
				case Char32:
				case Const_cast:
				case Decltype:
				case Delete:
				case Double:
				case Dynamic_cast:
				case Float:
				case Int:
				case Long:
				case New:
				case Noexcept:
				case Operator:
				case Reinterpret_cast:
				case Short:
				case Signed:
				case Sizeof:
				case Static_cast:
				case This:
				case Throw:
				case Typeid_:
				case Typename_:
				case Unsigned:
				case Void:
				case Wchar:
				case LeftParen:
				case LeftBracket:
				case Plus:
				case Minus:
				case Star:
				case And:
				case Or:
				case Tilde:
				case Not:
				case PlusPlus:
				case MinusMinus:
				case Doublecolon:
				case Identifier:
					{
					setState(973);
					expression();
					}
					break;
				case LeftBrace:
					{
					setState(974);
					bracedInitList();
					}
					break;
				case Semi:
					break;
				default:
					break;
				}
				}
				break;
			case Goto:
				{
				setState(977);
				match(Goto);
				setState(978);
				match(Identifier);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(981);
			match(Semi);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclarationStatementContext extends org.example.antlr.common.context.ExtendContext {
		public BlockDeclarationContext blockDeclaration() {
			return getRuleContext(BlockDeclarationContext.class,0);
		}
		public DeclarationStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declarationStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).enterDeclarationStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).exitDeclarationStatement(this);
		}
	}

	public final DeclarationStatementContext declarationStatement() throws RecognitionException {
		DeclarationStatementContext _localctx = new DeclarationStatementContext(_ctx, getState());
		enterRule(_localctx, 126, RULE_declarationStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(983);
			blockDeclaration();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclarationseqContext extends org.example.antlr.common.context.ExtendContext {
		public List<DeclarationContext> declaration() {
			return getRuleContexts(DeclarationContext.class);
		}
		public DeclarationContext declaration(int i) {
			return getRuleContext(DeclarationContext.class,i);
		}
		public DeclarationseqContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declarationseq; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).enterDeclarationseq(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).exitDeclarationseq(this);
		}
	}

	public final DeclarationseqContext declarationseq() throws RecognitionException {
		DeclarationseqContext _localctx = new DeclarationseqContext(_ctx, getState());
		enterRule(_localctx, 128, RULE_declarationseq);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(986); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(985);
				declaration();
				}
				}
				setState(988); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( ((((_la - 10)) & ~0x3f) == 0 && ((1L << (_la - 10)) & ((1L << (Alignas - 10)) | (1L << (Asm - 10)) | (1L << (Auto - 10)) | (1L << (Bool - 10)) | (1L << (Char - 10)) | (1L << (Char16 - 10)) | (1L << (Char32 - 10)) | (1L << (Class - 10)) | (1L << (Const - 10)) | (1L << (Constexpr - 10)) | (1L << (Decltype - 10)) | (1L << (Double - 10)) | (1L << (Enum - 10)) | (1L << (Explicit - 10)) | (1L << (Extern - 10)) | (1L << (Float - 10)) | (1L << (Friend - 10)) | (1L << (Inline - 10)) | (1L << (Int - 10)) | (1L << (Long - 10)) | (1L << (Mutable - 10)) | (1L << (Namespace - 10)) | (1L << (Operator - 10)) | (1L << (Register - 10)) | (1L << (Short - 10)) | (1L << (Signed - 10)) | (1L << (Static - 10)) | (1L << (Static_assert - 10)) | (1L << (Struct - 10)) | (1L << (Template - 10)) | (1L << (Thread_local - 10)))) != 0) || ((((_la - 74)) & ~0x3f) == 0 && ((1L << (_la - 74)) & ((1L << (Typedef - 74)) | (1L << (Typename_ - 74)) | (1L << (Union - 74)) | (1L << (Unsigned - 74)) | (1L << (Using - 74)) | (1L << (Virtual - 74)) | (1L << (Void - 74)) | (1L << (Volatile - 74)) | (1L << (Wchar - 74)) | (1L << (LeftParen - 74)) | (1L << (LeftBracket - 74)) | (1L << (Star - 74)) | (1L << (And - 74)) | (1L << (Tilde - 74)) | (1L << (AndAnd - 74)) | (1L << (Doublecolon - 74)) | (1L << (Semi - 74)) | (1L << (Ellipsis - 74)) | (1L << (Identifier - 74)))) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclarationContext extends org.example.antlr.common.context.ExtendContext {
		public BlockDeclarationContext blockDeclaration() {
			return getRuleContext(BlockDeclarationContext.class,0);
		}
		public FunctionDefinitionContext functionDefinition() {
			return getRuleContext(FunctionDefinitionContext.class,0);
		}
		public TemplateDeclarationContext templateDeclaration() {
			return getRuleContext(TemplateDeclarationContext.class,0);
		}
		public ExplicitInstantiationContext explicitInstantiation() {
			return getRuleContext(ExplicitInstantiationContext.class,0);
		}
		public ExplicitSpecializationContext explicitSpecialization() {
			return getRuleContext(ExplicitSpecializationContext.class,0);
		}
		public LinkageSpecificationContext linkageSpecification() {
			return getRuleContext(LinkageSpecificationContext.class,0);
		}
		public NamespaceDefinitionContext namespaceDefinition() {
			return getRuleContext(NamespaceDefinitionContext.class,0);
		}
		public EmptyDeclaration_Context emptyDeclaration_() {
			return getRuleContext(EmptyDeclaration_Context.class,0);
		}
		public AttributeDeclarationContext attributeDeclaration() {
			return getRuleContext(AttributeDeclarationContext.class,0);
		}
		public DeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).enterDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).exitDeclaration(this);
		}
	}

	public final DeclarationContext declaration() throws RecognitionException {
		DeclarationContext _localctx = new DeclarationContext(_ctx, getState());
		enterRule(_localctx, 130, RULE_declaration);
		try {
			setState(999);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,93,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(990);
				blockDeclaration();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(991);
				functionDefinition();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(992);
				templateDeclaration();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(993);
				explicitInstantiation();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(994);
				explicitSpecialization();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(995);
				linkageSpecification();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(996);
				namespaceDefinition();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(997);
				emptyDeclaration_();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(998);
				attributeDeclaration();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlockDeclarationContext extends org.example.antlr.common.context.ExtendContext {
		public SimpleDeclarationContext simpleDeclaration() {
			return getRuleContext(SimpleDeclarationContext.class,0);
		}
		public AsmDefinitionContext asmDefinition() {
			return getRuleContext(AsmDefinitionContext.class,0);
		}
		public NamespaceAliasDefinitionContext namespaceAliasDefinition() {
			return getRuleContext(NamespaceAliasDefinitionContext.class,0);
		}
		public UsingDeclarationContext usingDeclaration() {
			return getRuleContext(UsingDeclarationContext.class,0);
		}
		public UsingDirectiveContext usingDirective() {
			return getRuleContext(UsingDirectiveContext.class,0);
		}
		public StaticAssertDeclarationContext staticAssertDeclaration() {
			return getRuleContext(StaticAssertDeclarationContext.class,0);
		}
		public AliasDeclarationContext aliasDeclaration() {
			return getRuleContext(AliasDeclarationContext.class,0);
		}
		public OpaqueEnumDeclarationContext opaqueEnumDeclaration() {
			return getRuleContext(OpaqueEnumDeclarationContext.class,0);
		}
		public BlockDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blockDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).enterBlockDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).exitBlockDeclaration(this);
		}
	}

	public final BlockDeclarationContext blockDeclaration() throws RecognitionException {
		BlockDeclarationContext _localctx = new BlockDeclarationContext(_ctx, getState());
		enterRule(_localctx, 132, RULE_blockDeclaration);
		try {
			setState(1009);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,94,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1001);
				simpleDeclaration();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1002);
				asmDefinition();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1003);
				namespaceAliasDefinition();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1004);
				usingDeclaration();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(1005);
				usingDirective();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(1006);
				staticAssertDeclaration();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(1007);
				aliasDeclaration();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(1008);
				opaqueEnumDeclaration();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AliasDeclarationContext extends org.example.antlr.common.context.ExtendContext {
		public TerminalNode Using() { return getToken(CPPParser.Using, 0); }
		public TerminalNode Identifier() { return getToken(CPPParser.Identifier, 0); }
		public TerminalNode Assign() { return getToken(CPPParser.Assign, 0); }
		public TheTypeIdContext theTypeId() {
			return getRuleContext(TheTypeIdContext.class,0);
		}
		public TerminalNode Semi() { return getToken(CPPParser.Semi, 0); }
		public AttributeSpecifierSeqContext attributeSpecifierSeq() {
			return getRuleContext(AttributeSpecifierSeqContext.class,0);
		}
		public AliasDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_aliasDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).enterAliasDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).exitAliasDeclaration(this);
		}
	}

	public final AliasDeclarationContext aliasDeclaration() throws RecognitionException {
		AliasDeclarationContext _localctx = new AliasDeclarationContext(_ctx, getState());
		enterRule(_localctx, 134, RULE_aliasDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1011);
			match(Using);
			setState(1012);
			match(Identifier);
			setState(1014);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Alignas || _la==LeftBracket) {
				{
				setState(1013);
				attributeSpecifierSeq();
				}
			}

			setState(1016);
			match(Assign);
			setState(1017);
			theTypeId();
			setState(1018);
			match(Semi);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SimpleDeclarationContext extends org.example.antlr.common.context.ExtendContext {
		public TerminalNode Semi() { return getToken(CPPParser.Semi, 0); }
		public DeclSpecifierSeqContext declSpecifierSeq() {
			return getRuleContext(DeclSpecifierSeqContext.class,0);
		}
		public InitDeclaratorListContext initDeclaratorList() {
			return getRuleContext(InitDeclaratorListContext.class,0);
		}
		public AttributeSpecifierSeqContext attributeSpecifierSeq() {
			return getRuleContext(AttributeSpecifierSeqContext.class,0);
		}
		public SimpleDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simpleDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).enterSimpleDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).exitSimpleDeclaration(this);
		}
	}

	public final SimpleDeclarationContext simpleDeclaration() throws RecognitionException {
		SimpleDeclarationContext _localctx = new SimpleDeclarationContext(_ctx, getState());
		enterRule(_localctx, 136, RULE_simpleDeclaration);
		int _la;
		try {
			setState(1034);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Auto:
			case Bool:
			case Char:
			case Char16:
			case Char32:
			case Class:
			case Const:
			case Constexpr:
			case Decltype:
			case Double:
			case Enum:
			case Explicit:
			case Extern:
			case Float:
			case Friend:
			case Inline:
			case Int:
			case Long:
			case Mutable:
			case Operator:
			case Register:
			case Short:
			case Signed:
			case Static:
			case Struct:
			case Thread_local:
			case Typedef:
			case Typename_:
			case Union:
			case Unsigned:
			case Virtual:
			case Void:
			case Volatile:
			case Wchar:
			case LeftParen:
			case Star:
			case And:
			case Tilde:
			case AndAnd:
			case Doublecolon:
			case Semi:
			case Ellipsis:
			case Identifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(1021);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,96,_ctx) ) {
				case 1:
					{
					setState(1020);
					declSpecifierSeq();
					}
					break;
				}
				setState(1024);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Decltype || _la==Operator || ((((_la - 85)) & ~0x3f) == 0 && ((1L << (_la - 85)) & ((1L << (LeftParen - 85)) | (1L << (Star - 85)) | (1L << (And - 85)) | (1L << (Tilde - 85)) | (1L << (AndAnd - 85)) | (1L << (Doublecolon - 85)) | (1L << (Ellipsis - 85)) | (1L << (Identifier - 85)))) != 0)) {
					{
					setState(1023);
					initDeclaratorList();
					}
				}

				setState(1026);
				match(Semi);
				}
				break;
			case Alignas:
			case LeftBracket:
				enterOuterAlt(_localctx, 2);
				{
				setState(1027);
				attributeSpecifierSeq();
				setState(1029);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,98,_ctx) ) {
				case 1:
					{
					setState(1028);
					declSpecifierSeq();
					}
					break;
				}
				setState(1031);
				initDeclaratorList();
				setState(1032);
				match(Semi);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StaticAssertDeclarationContext extends org.example.antlr.common.context.ExtendContext {
		public TerminalNode Static_assert() { return getToken(CPPParser.Static_assert, 0); }
		public TerminalNode LeftParen() { return getToken(CPPParser.LeftParen, 0); }
		public ConstantExpressionContext constantExpression() {
			return getRuleContext(ConstantExpressionContext.class,0);
		}
		public TerminalNode Comma() { return getToken(CPPParser.Comma, 0); }
		public TerminalNode StringLiteral() { return getToken(CPPParser.StringLiteral, 0); }
		public TerminalNode RightParen() { return getToken(CPPParser.RightParen, 0); }
		public TerminalNode Semi() { return getToken(CPPParser.Semi, 0); }
		public StaticAssertDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_staticAssertDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).enterStaticAssertDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).exitStaticAssertDeclaration(this);
		}
	}

	public final StaticAssertDeclarationContext staticAssertDeclaration() throws RecognitionException {
		StaticAssertDeclarationContext _localctx = new StaticAssertDeclarationContext(_ctx, getState());
		enterRule(_localctx, 138, RULE_staticAssertDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1036);
			match(Static_assert);
			setState(1037);
			match(LeftParen);
			setState(1038);
			constantExpression();
			setState(1039);
			match(Comma);
			setState(1040);
			match(StringLiteral);
			setState(1041);
			match(RightParen);
			setState(1042);
			match(Semi);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EmptyDeclaration_Context extends org.example.antlr.common.context.ExtendContext {
		public TerminalNode Semi() { return getToken(CPPParser.Semi, 0); }
		public EmptyDeclaration_Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_emptyDeclaration_; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).enterEmptyDeclaration_(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).exitEmptyDeclaration_(this);
		}
	}

	public final EmptyDeclaration_Context emptyDeclaration_() throws RecognitionException {
		EmptyDeclaration_Context _localctx = new EmptyDeclaration_Context(_ctx, getState());
		enterRule(_localctx, 140, RULE_emptyDeclaration_);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1044);
			match(Semi);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AttributeDeclarationContext extends org.example.antlr.common.context.ExtendContext {
		public AttributeSpecifierSeqContext attributeSpecifierSeq() {
			return getRuleContext(AttributeSpecifierSeqContext.class,0);
		}
		public TerminalNode Semi() { return getToken(CPPParser.Semi, 0); }
		public AttributeDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attributeDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).enterAttributeDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).exitAttributeDeclaration(this);
		}
	}

	public final AttributeDeclarationContext attributeDeclaration() throws RecognitionException {
		AttributeDeclarationContext _localctx = new AttributeDeclarationContext(_ctx, getState());
		enterRule(_localctx, 142, RULE_attributeDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1046);
			attributeSpecifierSeq();
			setState(1047);
			match(Semi);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclSpecifierContext extends org.example.antlr.common.context.ExtendContext {
		public StorageClassSpecifierContext storageClassSpecifier() {
			return getRuleContext(StorageClassSpecifierContext.class,0);
		}
		public TypeSpecifierContext typeSpecifier() {
			return getRuleContext(TypeSpecifierContext.class,0);
		}
		public FunctionSpecifierContext functionSpecifier() {
			return getRuleContext(FunctionSpecifierContext.class,0);
		}
		public TerminalNode Friend() { return getToken(CPPParser.Friend, 0); }
		public TerminalNode Typedef() { return getToken(CPPParser.Typedef, 0); }
		public TerminalNode Constexpr() { return getToken(CPPParser.Constexpr, 0); }
		public DeclSpecifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declSpecifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).enterDeclSpecifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).exitDeclSpecifier(this);
		}
	}

	public final DeclSpecifierContext declSpecifier() throws RecognitionException {
		DeclSpecifierContext _localctx = new DeclSpecifierContext(_ctx, getState());
		enterRule(_localctx, 144, RULE_declSpecifier);
		try {
			setState(1055);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Extern:
			case Mutable:
			case Register:
			case Static:
			case Thread_local:
				enterOuterAlt(_localctx, 1);
				{
				setState(1049);
				storageClassSpecifier();
				}
				break;
			case Auto:
			case Bool:
			case Char:
			case Char16:
			case Char32:
			case Class:
			case Const:
			case Decltype:
			case Double:
			case Enum:
			case Float:
			case Int:
			case Long:
			case Short:
			case Signed:
			case Struct:
			case Typename_:
			case Union:
			case Unsigned:
			case Void:
			case Volatile:
			case Wchar:
			case Doublecolon:
			case Identifier:
				enterOuterAlt(_localctx, 2);
				{
				setState(1050);
				typeSpecifier();
				}
				break;
			case Explicit:
			case Inline:
			case Virtual:
				enterOuterAlt(_localctx, 3);
				{
				setState(1051);
				functionSpecifier();
				}
				break;
			case Friend:
				enterOuterAlt(_localctx, 4);
				{
				setState(1052);
				match(Friend);
				}
				break;
			case Typedef:
				enterOuterAlt(_localctx, 5);
				{
				setState(1053);
				match(Typedef);
				}
				break;
			case Constexpr:
				enterOuterAlt(_localctx, 6);
				{
				setState(1054);
				match(Constexpr);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclSpecifierSeqContext extends org.example.antlr.common.context.ExtendContext {
		public List<DeclSpecifierContext> declSpecifier() {
			return getRuleContexts(DeclSpecifierContext.class);
		}
		public DeclSpecifierContext declSpecifier(int i) {
			return getRuleContext(DeclSpecifierContext.class,i);
		}
		public AttributeSpecifierSeqContext attributeSpecifierSeq() {
			return getRuleContext(AttributeSpecifierSeqContext.class,0);
		}
		public DeclSpecifierSeqContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declSpecifierSeq; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).enterDeclSpecifierSeq(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).exitDeclSpecifierSeq(this);
		}
	}

	public final DeclSpecifierSeqContext declSpecifierSeq() throws RecognitionException {
		DeclSpecifierSeqContext _localctx = new DeclSpecifierSeqContext(_ctx, getState());
		enterRule(_localctx, 146, RULE_declSpecifierSeq);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1058); 
			_errHandler.sync(this);
			_alt = 1+1;
			do {
				switch (_alt) {
				case 1+1:
					{
					{
					setState(1057);
					declSpecifier();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1060); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,101,_ctx);
			} while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(1063);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,102,_ctx) ) {
			case 1:
				{
				setState(1062);
				attributeSpecifierSeq();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StorageClassSpecifierContext extends org.example.antlr.common.context.ExtendContext {
		public TerminalNode Register() { return getToken(CPPParser.Register, 0); }
		public TerminalNode Static() { return getToken(CPPParser.Static, 0); }
		public TerminalNode Thread_local() { return getToken(CPPParser.Thread_local, 0); }
		public TerminalNode Extern() { return getToken(CPPParser.Extern, 0); }
		public TerminalNode Mutable() { return getToken(CPPParser.Mutable, 0); }
		public StorageClassSpecifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_storageClassSpecifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).enterStorageClassSpecifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).exitStorageClassSpecifier(this);
		}
	}

	public final StorageClassSpecifierContext storageClassSpecifier() throws RecognitionException {
		StorageClassSpecifierContext _localctx = new StorageClassSpecifierContext(_ctx, getState());
		enterRule(_localctx, 148, RULE_storageClassSpecifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1065);
			_la = _input.LA(1);
			if ( !(((((_la - 36)) & ~0x3f) == 0 && ((1L << (_la - 36)) & ((1L << (Extern - 36)) | (1L << (Mutable - 36)) | (1L << (Register - 36)) | (1L << (Static - 36)) | (1L << (Thread_local - 36)))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionSpecifierContext extends org.example.antlr.common.context.ExtendContext {
		public TerminalNode Inline() { return getToken(CPPParser.Inline, 0); }
		public TerminalNode Virtual() { return getToken(CPPParser.Virtual, 0); }
		public TerminalNode Explicit() { return getToken(CPPParser.Explicit, 0); }
		public FunctionSpecifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionSpecifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).enterFunctionSpecifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).exitFunctionSpecifier(this);
		}
	}

	public final FunctionSpecifierContext functionSpecifier() throws RecognitionException {
		FunctionSpecifierContext _localctx = new FunctionSpecifierContext(_ctx, getState());
		enterRule(_localctx, 150, RULE_functionSpecifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1067);
			_la = _input.LA(1);
			if ( !(((((_la - 34)) & ~0x3f) == 0 && ((1L << (_la - 34)) & ((1L << (Explicit - 34)) | (1L << (Inline - 34)) | (1L << (Virtual - 34)))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypedefNameContext extends org.example.antlr.common.context.ExtendContext {
		public TerminalNode Identifier() { return getToken(CPPParser.Identifier, 0); }
		public TypedefNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typedefName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).enterTypedefName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).exitTypedefName(this);
		}
	}

	public final TypedefNameContext typedefName() throws RecognitionException {
		TypedefNameContext _localctx = new TypedefNameContext(_ctx, getState());
		enterRule(_localctx, 152, RULE_typedefName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1069);
			match(Identifier);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeSpecifierContext extends org.example.antlr.common.context.ExtendContext {
		public TrailingTypeSpecifierContext trailingTypeSpecifier() {
			return getRuleContext(TrailingTypeSpecifierContext.class,0);
		}
		public ClassSpecifierContext classSpecifier() {
			return getRuleContext(ClassSpecifierContext.class,0);
		}
		public EnumSpecifierContext enumSpecifier() {
			return getRuleContext(EnumSpecifierContext.class,0);
		}
		public TypeSpecifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeSpecifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).enterTypeSpecifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).exitTypeSpecifier(this);
		}
	}

	public final TypeSpecifierContext typeSpecifier() throws RecognitionException {
		TypeSpecifierContext _localctx = new TypeSpecifierContext(_ctx, getState());
		enterRule(_localctx, 154, RULE_typeSpecifier);
		try {
			setState(1074);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,103,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1071);
				trailingTypeSpecifier();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1072);
				classSpecifier();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1073);
				enumSpecifier();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TrailingTypeSpecifierContext extends org.example.antlr.common.context.ExtendContext {
		public SimpleTypeSpecifierContext simpleTypeSpecifier() {
			return getRuleContext(SimpleTypeSpecifierContext.class,0);
		}
		public ElaboratedTypeSpecifierContext elaboratedTypeSpecifier() {
			return getRuleContext(ElaboratedTypeSpecifierContext.class,0);
		}
		public TypeNameSpecifierContext typeNameSpecifier() {
			return getRuleContext(TypeNameSpecifierContext.class,0);
		}
		public CvQualifierContext cvQualifier() {
			return getRuleContext(CvQualifierContext.class,0);
		}
		public TrailingTypeSpecifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_trailingTypeSpecifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).enterTrailingTypeSpecifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).exitTrailingTypeSpecifier(this);
		}
	}

	public final TrailingTypeSpecifierContext trailingTypeSpecifier() throws RecognitionException {
		TrailingTypeSpecifierContext _localctx = new TrailingTypeSpecifierContext(_ctx, getState());
		enterRule(_localctx, 156, RULE_trailingTypeSpecifier);
		try {
			setState(1080);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Auto:
			case Bool:
			case Char:
			case Char16:
			case Char32:
			case Decltype:
			case Double:
			case Float:
			case Int:
			case Long:
			case Short:
			case Signed:
			case Unsigned:
			case Void:
			case Wchar:
			case Doublecolon:
			case Identifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(1076);
				simpleTypeSpecifier();
				}
				break;
			case Class:
			case Enum:
			case Struct:
				enterOuterAlt(_localctx, 2);
				{
				setState(1077);
				elaboratedTypeSpecifier();
				}
				break;
			case Typename_:
				enterOuterAlt(_localctx, 3);
				{
				setState(1078);
				typeNameSpecifier();
				}
				break;
			case Const:
			case Volatile:
				enterOuterAlt(_localctx, 4);
				{
				setState(1079);
				cvQualifier();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeSpecifierSeqContext extends org.example.antlr.common.context.ExtendContext {
		public List<TypeSpecifierContext> typeSpecifier() {
			return getRuleContexts(TypeSpecifierContext.class);
		}
		public TypeSpecifierContext typeSpecifier(int i) {
			return getRuleContext(TypeSpecifierContext.class,i);
		}
		public AttributeSpecifierSeqContext attributeSpecifierSeq() {
			return getRuleContext(AttributeSpecifierSeqContext.class,0);
		}
		public TypeSpecifierSeqContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeSpecifierSeq; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).enterTypeSpecifierSeq(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).exitTypeSpecifierSeq(this);
		}
	}

	public final TypeSpecifierSeqContext typeSpecifierSeq() throws RecognitionException {
		TypeSpecifierSeqContext _localctx = new TypeSpecifierSeqContext(_ctx, getState());
		enterRule(_localctx, 158, RULE_typeSpecifierSeq);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1083); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(1082);
					typeSpecifier();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1085); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,105,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(1088);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,106,_ctx) ) {
			case 1:
				{
				setState(1087);
				attributeSpecifierSeq();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TrailingTypeSpecifierSeqContext extends org.example.antlr.common.context.ExtendContext {
		public List<TrailingTypeSpecifierContext> trailingTypeSpecifier() {
			return getRuleContexts(TrailingTypeSpecifierContext.class);
		}
		public TrailingTypeSpecifierContext trailingTypeSpecifier(int i) {
			return getRuleContext(TrailingTypeSpecifierContext.class,i);
		}
		public AttributeSpecifierSeqContext attributeSpecifierSeq() {
			return getRuleContext(AttributeSpecifierSeqContext.class,0);
		}
		public TrailingTypeSpecifierSeqContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_trailingTypeSpecifierSeq; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).enterTrailingTypeSpecifierSeq(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).exitTrailingTypeSpecifierSeq(this);
		}
	}

	public final TrailingTypeSpecifierSeqContext trailingTypeSpecifierSeq() throws RecognitionException {
		TrailingTypeSpecifierSeqContext _localctx = new TrailingTypeSpecifierSeqContext(_ctx, getState());
		enterRule(_localctx, 160, RULE_trailingTypeSpecifierSeq);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1091); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(1090);
					trailingTypeSpecifier();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1093); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,107,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(1096);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,108,_ctx) ) {
			case 1:
				{
				setState(1095);
				attributeSpecifierSeq();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SimpleTypeLengthModifierContext extends org.example.antlr.common.context.ExtendContext {
		public TerminalNode Short() { return getToken(CPPParser.Short, 0); }
		public TerminalNode Long() { return getToken(CPPParser.Long, 0); }
		public SimpleTypeLengthModifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simpleTypeLengthModifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).enterSimpleTypeLengthModifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).exitSimpleTypeLengthModifier(this);
		}
	}

	public final SimpleTypeLengthModifierContext simpleTypeLengthModifier() throws RecognitionException {
		SimpleTypeLengthModifierContext _localctx = new SimpleTypeLengthModifierContext(_ctx, getState());
		enterRule(_localctx, 162, RULE_simpleTypeLengthModifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1098);
			_la = _input.LA(1);
			if ( !(_la==Long || _la==Short) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SimpleTypeSignednessModifierContext extends org.example.antlr.common.context.ExtendContext {
		public TerminalNode Unsigned() { return getToken(CPPParser.Unsigned, 0); }
		public TerminalNode Signed() { return getToken(CPPParser.Signed, 0); }
		public SimpleTypeSignednessModifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simpleTypeSignednessModifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).enterSimpleTypeSignednessModifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).exitSimpleTypeSignednessModifier(this);
		}
	}

	public final SimpleTypeSignednessModifierContext simpleTypeSignednessModifier() throws RecognitionException {
		SimpleTypeSignednessModifierContext _localctx = new SimpleTypeSignednessModifierContext(_ctx, getState());
		enterRule(_localctx, 164, RULE_simpleTypeSignednessModifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1100);
			_la = _input.LA(1);
			if ( !(_la==Signed || _la==Unsigned) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SimpleTypeSpecifierContext extends org.example.antlr.common.context.ExtendContext {
		public TheTypeNameContext theTypeName() {
			return getRuleContext(TheTypeNameContext.class,0);
		}
		public NestedNameSpecifierContext nestedNameSpecifier() {
			return getRuleContext(NestedNameSpecifierContext.class,0);
		}
		public TerminalNode Template() { return getToken(CPPParser.Template, 0); }
		public SimpleTemplateIdContext simpleTemplateId() {
			return getRuleContext(SimpleTemplateIdContext.class,0);
		}
		public TerminalNode Char() { return getToken(CPPParser.Char, 0); }
		public TerminalNode Char16() { return getToken(CPPParser.Char16, 0); }
		public TerminalNode Char32() { return getToken(CPPParser.Char32, 0); }
		public TerminalNode Wchar() { return getToken(CPPParser.Wchar, 0); }
		public TerminalNode Bool() { return getToken(CPPParser.Bool, 0); }
		public TerminalNode Short() { return getToken(CPPParser.Short, 0); }
		public TerminalNode Int() { return getToken(CPPParser.Int, 0); }
		public TerminalNode Long() { return getToken(CPPParser.Long, 0); }
		public TerminalNode Float() { return getToken(CPPParser.Float, 0); }
		public TerminalNode Signed() { return getToken(CPPParser.Signed, 0); }
		public TerminalNode Unsigned() { return getToken(CPPParser.Unsigned, 0); }
		public TerminalNode Double() { return getToken(CPPParser.Double, 0); }
		public TerminalNode Void() { return getToken(CPPParser.Void, 0); }
		public TerminalNode Auto() { return getToken(CPPParser.Auto, 0); }
		public DecltypeSpecifierContext decltypeSpecifier() {
			return getRuleContext(DecltypeSpecifierContext.class,0);
		}
		public SimpleTypeSpecifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simpleTypeSpecifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).enterSimpleTypeSpecifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).exitSimpleTypeSpecifier(this);
		}
	}

	public final SimpleTypeSpecifierContext simpleTypeSpecifier() throws RecognitionException {
		SimpleTypeSpecifierContext _localctx = new SimpleTypeSpecifierContext(_ctx, getState());
		enterRule(_localctx, 166, RULE_simpleTypeSpecifier);
		try {
			setState(1126);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,110,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1103);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,109,_ctx) ) {
				case 1:
					{
					setState(1102);
					nestedNameSpecifier(0);
					}
					break;
				}
				setState(1105);
				theTypeName();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1106);
				nestedNameSpecifier(0);
				setState(1107);
				match(Template);
				setState(1108);
				simpleTemplateId();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1110);
				match(Char);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1111);
				match(Char16);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(1112);
				match(Char32);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(1113);
				match(Wchar);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(1114);
				match(Bool);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(1115);
				match(Short);
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(1116);
				match(Int);
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(1117);
				match(Long);
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(1118);
				match(Float);
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(1119);
				match(Signed);
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(1120);
				match(Unsigned);
				}
				break;
			case 14:
				enterOuterAlt(_localctx, 14);
				{
				setState(1121);
				match(Float);
				}
				break;
			case 15:
				enterOuterAlt(_localctx, 15);
				{
				setState(1122);
				match(Double);
				}
				break;
			case 16:
				enterOuterAlt(_localctx, 16);
				{
				setState(1123);
				match(Void);
				}
				break;
			case 17:
				enterOuterAlt(_localctx, 17);
				{
				setState(1124);
				match(Auto);
				}
				break;
			case 18:
				enterOuterAlt(_localctx, 18);
				{
				setState(1125);
				decltypeSpecifier();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TheTypeNameContext extends org.example.antlr.common.context.ExtendContext {
		public ClassNameContext className() {
			return getRuleContext(ClassNameContext.class,0);
		}
		public EnumNameContext enumName() {
			return getRuleContext(EnumNameContext.class,0);
		}
		public TypedefNameContext typedefName() {
			return getRuleContext(TypedefNameContext.class,0);
		}
		public SimpleTemplateIdContext simpleTemplateId() {
			return getRuleContext(SimpleTemplateIdContext.class,0);
		}
		public TheTypeNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_theTypeName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).enterTheTypeName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).exitTheTypeName(this);
		}
	}

	public final TheTypeNameContext theTypeName() throws RecognitionException {
		TheTypeNameContext _localctx = new TheTypeNameContext(_ctx, getState());
		enterRule(_localctx, 168, RULE_theTypeName);
		try {
			setState(1132);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,111,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1128);
				className();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1129);
				enumName();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1130);
				typedefName();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1131);
				simpleTemplateId();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DecltypeSpecifierContext extends org.example.antlr.common.context.ExtendContext {
		public TerminalNode Decltype() { return getToken(CPPParser.Decltype, 0); }
		public TerminalNode LeftParen() { return getToken(CPPParser.LeftParen, 0); }
		public TerminalNode RightParen() { return getToken(CPPParser.RightParen, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode Auto() { return getToken(CPPParser.Auto, 0); }
		public DecltypeSpecifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decltypeSpecifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).enterDecltypeSpecifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).exitDecltypeSpecifier(this);
		}
	}

	public final DecltypeSpecifierContext decltypeSpecifier() throws RecognitionException {
		DecltypeSpecifierContext _localctx = new DecltypeSpecifierContext(_ctx, getState());
		enterRule(_localctx, 170, RULE_decltypeSpecifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1134);
			match(Decltype);
			setState(1135);
			match(LeftParen);
			setState(1138);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,112,_ctx) ) {
			case 1:
				{
				setState(1136);
				expression();
				}
				break;
			case 2:
				{
				setState(1137);
				match(Auto);
				}
				break;
			}
			setState(1140);
			match(RightParen);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ElaboratedTypeSpecifierContext extends org.example.antlr.common.context.ExtendContext {
		public ClassKeyContext classKey() {
			return getRuleContext(ClassKeyContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(CPPParser.Identifier, 0); }
		public SimpleTemplateIdContext simpleTemplateId() {
			return getRuleContext(SimpleTemplateIdContext.class,0);
		}
		public NestedNameSpecifierContext nestedNameSpecifier() {
			return getRuleContext(NestedNameSpecifierContext.class,0);
		}
		public AttributeSpecifierSeqContext attributeSpecifierSeq() {
			return getRuleContext(AttributeSpecifierSeqContext.class,0);
		}
		public TerminalNode Template() { return getToken(CPPParser.Template, 0); }
		public TerminalNode Enum() { return getToken(CPPParser.Enum, 0); }
		public ElaboratedTypeSpecifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elaboratedTypeSpecifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).enterElaboratedTypeSpecifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).exitElaboratedTypeSpecifier(this);
		}
	}

	public final ElaboratedTypeSpecifierContext elaboratedTypeSpecifier() throws RecognitionException {
		ElaboratedTypeSpecifierContext _localctx = new ElaboratedTypeSpecifierContext(_ctx, getState());
		enterRule(_localctx, 172, RULE_elaboratedTypeSpecifier);
		int _la;
		try {
			setState(1164);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Class:
			case Struct:
				enterOuterAlt(_localctx, 1);
				{
				setState(1142);
				classKey();
				setState(1157);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,116,_ctx) ) {
				case 1:
					{
					setState(1144);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==Alignas || _la==LeftBracket) {
						{
						setState(1143);
						attributeSpecifierSeq();
						}
					}

					setState(1147);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,114,_ctx) ) {
					case 1:
						{
						setState(1146);
						nestedNameSpecifier(0);
						}
						break;
					}
					setState(1149);
					match(Identifier);
					}
					break;
				case 2:
					{
					setState(1150);
					simpleTemplateId();
					}
					break;
				case 3:
					{
					setState(1151);
					nestedNameSpecifier(0);
					setState(1153);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==Template) {
						{
						setState(1152);
						match(Template);
						}
					}

					setState(1155);
					simpleTemplateId();
					}
					break;
				}
				}
				break;
			case Enum:
				enterOuterAlt(_localctx, 2);
				{
				setState(1159);
				match(Enum);
				setState(1161);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,117,_ctx) ) {
				case 1:
					{
					setState(1160);
					nestedNameSpecifier(0);
					}
					break;
				}
				setState(1163);
				match(Identifier);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EnumNameContext extends org.example.antlr.common.context.ExtendContext {
		public TerminalNode Identifier() { return getToken(CPPParser.Identifier, 0); }
		public EnumNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).enterEnumName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).exitEnumName(this);
		}
	}

	public final EnumNameContext enumName() throws RecognitionException {
		EnumNameContext _localctx = new EnumNameContext(_ctx, getState());
		enterRule(_localctx, 174, RULE_enumName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1166);
			match(Identifier);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EnumSpecifierContext extends org.example.antlr.common.context.ExtendContext {
		public EnumHeadContext enumHead() {
			return getRuleContext(EnumHeadContext.class,0);
		}
		public TerminalNode LeftBrace() { return getToken(CPPParser.LeftBrace, 0); }
		public TerminalNode RightBrace() { return getToken(CPPParser.RightBrace, 0); }
		public EnumeratorListContext enumeratorList() {
			return getRuleContext(EnumeratorListContext.class,0);
		}
		public TerminalNode Comma() { return getToken(CPPParser.Comma, 0); }
		public EnumSpecifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumSpecifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).enterEnumSpecifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).exitEnumSpecifier(this);
		}
	}

	public final EnumSpecifierContext enumSpecifier() throws RecognitionException {
		EnumSpecifierContext _localctx = new EnumSpecifierContext(_ctx, getState());
		enterRule(_localctx, 176, RULE_enumSpecifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1168);
			enumHead();
			setState(1169);
			match(LeftBrace);
			setState(1174);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Identifier) {
				{
				setState(1170);
				enumeratorList();
				setState(1172);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Comma) {
					{
					setState(1171);
					match(Comma);
					}
				}

				}
			}

			setState(1176);
			match(RightBrace);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EnumHeadContext extends org.example.antlr.common.context.ExtendContext {
		public EnumkeyContext enumkey() {
			return getRuleContext(EnumkeyContext.class,0);
		}
		public AttributeSpecifierSeqContext attributeSpecifierSeq() {
			return getRuleContext(AttributeSpecifierSeqContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(CPPParser.Identifier, 0); }
		public EnumbaseContext enumbase() {
			return getRuleContext(EnumbaseContext.class,0);
		}
		public NestedNameSpecifierContext nestedNameSpecifier() {
			return getRuleContext(NestedNameSpecifierContext.class,0);
		}
		public EnumHeadContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumHead; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).enterEnumHead(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).exitEnumHead(this);
		}
	}

	public final EnumHeadContext enumHead() throws RecognitionException {
		EnumHeadContext _localctx = new EnumHeadContext(_ctx, getState());
		enterRule(_localctx, 178, RULE_enumHead);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1178);
			enumkey();
			setState(1180);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Alignas || _la==LeftBracket) {
				{
				setState(1179);
				attributeSpecifierSeq();
				}
			}

			setState(1186);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Decltype || _la==Doublecolon || _la==Identifier) {
				{
				setState(1183);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,122,_ctx) ) {
				case 1:
					{
					setState(1182);
					nestedNameSpecifier(0);
					}
					break;
				}
				setState(1185);
				match(Identifier);
				}
			}

			setState(1189);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Colon) {
				{
				setState(1188);
				enumbase();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OpaqueEnumDeclarationContext extends org.example.antlr.common.context.ExtendContext {
		public EnumkeyContext enumkey() {
			return getRuleContext(EnumkeyContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(CPPParser.Identifier, 0); }
		public TerminalNode Semi() { return getToken(CPPParser.Semi, 0); }
		public AttributeSpecifierSeqContext attributeSpecifierSeq() {
			return getRuleContext(AttributeSpecifierSeqContext.class,0);
		}
		public EnumbaseContext enumbase() {
			return getRuleContext(EnumbaseContext.class,0);
		}
		public OpaqueEnumDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_opaqueEnumDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).enterOpaqueEnumDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).exitOpaqueEnumDeclaration(this);
		}
	}

	public final OpaqueEnumDeclarationContext opaqueEnumDeclaration() throws RecognitionException {
		OpaqueEnumDeclarationContext _localctx = new OpaqueEnumDeclarationContext(_ctx, getState());
		enterRule(_localctx, 180, RULE_opaqueEnumDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1191);
			enumkey();
			setState(1193);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Alignas || _la==LeftBracket) {
				{
				setState(1192);
				attributeSpecifierSeq();
				}
			}

			setState(1195);
			match(Identifier);
			setState(1197);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Colon) {
				{
				setState(1196);
				enumbase();
				}
			}

			setState(1199);
			match(Semi);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EnumkeyContext extends org.example.antlr.common.context.ExtendContext {
		public TerminalNode Enum() { return getToken(CPPParser.Enum, 0); }
		public TerminalNode Class() { return getToken(CPPParser.Class, 0); }
		public TerminalNode Struct() { return getToken(CPPParser.Struct, 0); }
		public EnumkeyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumkey; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).enterEnumkey(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).exitEnumkey(this);
		}
	}

	public final EnumkeyContext enumkey() throws RecognitionException {
		EnumkeyContext _localctx = new EnumkeyContext(_ctx, getState());
		enterRule(_localctx, 182, RULE_enumkey);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1201);
			match(Enum);
			setState(1203);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Class || _la==Struct) {
				{
				setState(1202);
				_la = _input.LA(1);
				if ( !(_la==Class || _la==Struct) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EnumbaseContext extends org.example.antlr.common.context.ExtendContext {
		public TerminalNode Colon() { return getToken(CPPParser.Colon, 0); }
		public TypeSpecifierSeqContext typeSpecifierSeq() {
			return getRuleContext(TypeSpecifierSeqContext.class,0);
		}
		public EnumbaseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumbase; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).enterEnumbase(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).exitEnumbase(this);
		}
	}

	public final EnumbaseContext enumbase() throws RecognitionException {
		EnumbaseContext _localctx = new EnumbaseContext(_ctx, getState());
		enterRule(_localctx, 184, RULE_enumbase);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1205);
			match(Colon);
			setState(1206);
			typeSpecifierSeq();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EnumeratorListContext extends org.example.antlr.common.context.ExtendContext {
		public List<EnumeratorDefinitionContext> enumeratorDefinition() {
			return getRuleContexts(EnumeratorDefinitionContext.class);
		}
		public EnumeratorDefinitionContext enumeratorDefinition(int i) {
			return getRuleContext(EnumeratorDefinitionContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(CPPParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(CPPParser.Comma, i);
		}
		public EnumeratorListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumeratorList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).enterEnumeratorList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).exitEnumeratorList(this);
		}
	}

	public final EnumeratorListContext enumeratorList() throws RecognitionException {
		EnumeratorListContext _localctx = new EnumeratorListContext(_ctx, getState());
		enterRule(_localctx, 186, RULE_enumeratorList);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1208);
			enumeratorDefinition();
			setState(1213);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,128,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1209);
					match(Comma);
					setState(1210);
					enumeratorDefinition();
					}
					} 
				}
				setState(1215);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,128,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EnumeratorDefinitionContext extends org.example.antlr.common.context.ExtendContext {
		public EnumeratorContext enumerator() {
			return getRuleContext(EnumeratorContext.class,0);
		}
		public TerminalNode Assign() { return getToken(CPPParser.Assign, 0); }
		public ConstantExpressionContext constantExpression() {
			return getRuleContext(ConstantExpressionContext.class,0);
		}
		public EnumeratorDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumeratorDefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).enterEnumeratorDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).exitEnumeratorDefinition(this);
		}
	}

	public final EnumeratorDefinitionContext enumeratorDefinition() throws RecognitionException {
		EnumeratorDefinitionContext _localctx = new EnumeratorDefinitionContext(_ctx, getState());
		enterRule(_localctx, 188, RULE_enumeratorDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1216);
			enumerator();
			setState(1219);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Assign) {
				{
				setState(1217);
				match(Assign);
				setState(1218);
				constantExpression();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EnumeratorContext extends org.example.antlr.common.context.ExtendContext {
		public TerminalNode Identifier() { return getToken(CPPParser.Identifier, 0); }
		public EnumeratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumerator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).enterEnumerator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).exitEnumerator(this);
		}
	}

	public final EnumeratorContext enumerator() throws RecognitionException {
		EnumeratorContext _localctx = new EnumeratorContext(_ctx, getState());
		enterRule(_localctx, 190, RULE_enumerator);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1221);
			match(Identifier);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NamespaceNameContext extends org.example.antlr.common.context.ExtendContext {
		public OriginalNamespaceNameContext originalNamespaceName() {
			return getRuleContext(OriginalNamespaceNameContext.class,0);
		}
		public NamespaceAliasContext namespaceAlias() {
			return getRuleContext(NamespaceAliasContext.class,0);
		}
		public NamespaceNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_namespaceName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).enterNamespaceName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).exitNamespaceName(this);
		}
	}

	public final NamespaceNameContext namespaceName() throws RecognitionException {
		NamespaceNameContext _localctx = new NamespaceNameContext(_ctx, getState());
		enterRule(_localctx, 192, RULE_namespaceName);
		try {
			setState(1225);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,130,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1223);
				originalNamespaceName();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1224);
				namespaceAlias();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OriginalNamespaceNameContext extends org.example.antlr.common.context.ExtendContext {
		public TerminalNode Identifier() { return getToken(CPPParser.Identifier, 0); }
		public OriginalNamespaceNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_originalNamespaceName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).enterOriginalNamespaceName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).exitOriginalNamespaceName(this);
		}
	}

	public final OriginalNamespaceNameContext originalNamespaceName() throws RecognitionException {
		OriginalNamespaceNameContext _localctx = new OriginalNamespaceNameContext(_ctx, getState());
		enterRule(_localctx, 194, RULE_originalNamespaceName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1227);
			match(Identifier);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NamespaceDefinitionContext extends org.example.antlr.common.context.ExtendContext {
		public DeclarationseqContext namespaceBody;
		public TerminalNode Namespace() { return getToken(CPPParser.Namespace, 0); }
		public TerminalNode LeftBrace() { return getToken(CPPParser.LeftBrace, 0); }
		public TerminalNode RightBrace() { return getToken(CPPParser.RightBrace, 0); }
		public TerminalNode Inline() { return getToken(CPPParser.Inline, 0); }
		public TerminalNode Identifier() { return getToken(CPPParser.Identifier, 0); }
		public OriginalNamespaceNameContext originalNamespaceName() {
			return getRuleContext(OriginalNamespaceNameContext.class,0);
		}
		public DeclarationseqContext declarationseq() {
			return getRuleContext(DeclarationseqContext.class,0);
		}
		public NamespaceDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_namespaceDefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).enterNamespaceDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).exitNamespaceDefinition(this);
		}
	}

	public final NamespaceDefinitionContext namespaceDefinition() throws RecognitionException {
		NamespaceDefinitionContext _localctx = new NamespaceDefinitionContext(_ctx, getState());
		enterRule(_localctx, 196, RULE_namespaceDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1230);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Inline) {
				{
				setState(1229);
				match(Inline);
				}
			}

			setState(1232);
			match(Namespace);
			setState(1235);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,132,_ctx) ) {
			case 1:
				{
				setState(1233);
				match(Identifier);
				}
				break;
			case 2:
				{
				setState(1234);
				originalNamespaceName();
				}
				break;
			}
			setState(1237);
			match(LeftBrace);
			setState(1239);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 10)) & ~0x3f) == 0 && ((1L << (_la - 10)) & ((1L << (Alignas - 10)) | (1L << (Asm - 10)) | (1L << (Auto - 10)) | (1L << (Bool - 10)) | (1L << (Char - 10)) | (1L << (Char16 - 10)) | (1L << (Char32 - 10)) | (1L << (Class - 10)) | (1L << (Const - 10)) | (1L << (Constexpr - 10)) | (1L << (Decltype - 10)) | (1L << (Double - 10)) | (1L << (Enum - 10)) | (1L << (Explicit - 10)) | (1L << (Extern - 10)) | (1L << (Float - 10)) | (1L << (Friend - 10)) | (1L << (Inline - 10)) | (1L << (Int - 10)) | (1L << (Long - 10)) | (1L << (Mutable - 10)) | (1L << (Namespace - 10)) | (1L << (Operator - 10)) | (1L << (Register - 10)) | (1L << (Short - 10)) | (1L << (Signed - 10)) | (1L << (Static - 10)) | (1L << (Static_assert - 10)) | (1L << (Struct - 10)) | (1L << (Template - 10)) | (1L << (Thread_local - 10)))) != 0) || ((((_la - 74)) & ~0x3f) == 0 && ((1L << (_la - 74)) & ((1L << (Typedef - 74)) | (1L << (Typename_ - 74)) | (1L << (Union - 74)) | (1L << (Unsigned - 74)) | (1L << (Using - 74)) | (1L << (Virtual - 74)) | (1L << (Void - 74)) | (1L << (Volatile - 74)) | (1L << (Wchar - 74)) | (1L << (LeftParen - 74)) | (1L << (LeftBracket - 74)) | (1L << (Star - 74)) | (1L << (And - 74)) | (1L << (Tilde - 74)) | (1L << (AndAnd - 74)) | (1L << (Doublecolon - 74)) | (1L << (Semi - 74)) | (1L << (Ellipsis - 74)) | (1L << (Identifier - 74)))) != 0)) {
				{
				setState(1238);
				((NamespaceDefinitionContext)_localctx).namespaceBody = declarationseq();
				}
			}

			setState(1241);
			match(RightBrace);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NamespaceAliasContext extends org.example.antlr.common.context.ExtendContext {
		public TerminalNode Identifier() { return getToken(CPPParser.Identifier, 0); }
		public NamespaceAliasContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_namespaceAlias; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).enterNamespaceAlias(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).exitNamespaceAlias(this);
		}
	}

	public final NamespaceAliasContext namespaceAlias() throws RecognitionException {
		NamespaceAliasContext _localctx = new NamespaceAliasContext(_ctx, getState());
		enterRule(_localctx, 198, RULE_namespaceAlias);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1243);
			match(Identifier);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NamespaceAliasDefinitionContext extends org.example.antlr.common.context.ExtendContext {
		public TerminalNode Namespace() { return getToken(CPPParser.Namespace, 0); }
		public TerminalNode Identifier() { return getToken(CPPParser.Identifier, 0); }
		public TerminalNode Assign() { return getToken(CPPParser.Assign, 0); }
		public QualifiednamespacespecifierContext qualifiednamespacespecifier() {
			return getRuleContext(QualifiednamespacespecifierContext.class,0);
		}
		public TerminalNode Semi() { return getToken(CPPParser.Semi, 0); }
		public NamespaceAliasDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_namespaceAliasDefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).enterNamespaceAliasDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).exitNamespaceAliasDefinition(this);
		}
	}

	public final NamespaceAliasDefinitionContext namespaceAliasDefinition() throws RecognitionException {
		NamespaceAliasDefinitionContext _localctx = new NamespaceAliasDefinitionContext(_ctx, getState());
		enterRule(_localctx, 200, RULE_namespaceAliasDefinition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1245);
			match(Namespace);
			setState(1246);
			match(Identifier);
			setState(1247);
			match(Assign);
			setState(1248);
			qualifiednamespacespecifier();
			setState(1249);
			match(Semi);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class QualifiednamespacespecifierContext extends org.example.antlr.common.context.ExtendContext {
		public NamespaceNameContext namespaceName() {
			return getRuleContext(NamespaceNameContext.class,0);
		}
		public NestedNameSpecifierContext nestedNameSpecifier() {
			return getRuleContext(NestedNameSpecifierContext.class,0);
		}
		public QualifiednamespacespecifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_qualifiednamespacespecifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).enterQualifiednamespacespecifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).exitQualifiednamespacespecifier(this);
		}
	}

	public final QualifiednamespacespecifierContext qualifiednamespacespecifier() throws RecognitionException {
		QualifiednamespacespecifierContext _localctx = new QualifiednamespacespecifierContext(_ctx, getState());
		enterRule(_localctx, 202, RULE_qualifiednamespacespecifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1252);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,134,_ctx) ) {
			case 1:
				{
				setState(1251);
				nestedNameSpecifier(0);
				}
				break;
			}
			setState(1254);
			namespaceName();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UsingDeclarationContext extends org.example.antlr.common.context.ExtendContext {
		public TerminalNode Using() { return getToken(CPPParser.Using, 0); }
		public UnqualifiedIdContext unqualifiedId() {
			return getRuleContext(UnqualifiedIdContext.class,0);
		}
		public TerminalNode Semi() { return getToken(CPPParser.Semi, 0); }
		public NestedNameSpecifierContext nestedNameSpecifier() {
			return getRuleContext(NestedNameSpecifierContext.class,0);
		}
		public TerminalNode Doublecolon() { return getToken(CPPParser.Doublecolon, 0); }
		public TerminalNode Typename_() { return getToken(CPPParser.Typename_, 0); }
		public UsingDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_usingDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).enterUsingDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).exitUsingDeclaration(this);
		}
	}

	public final UsingDeclarationContext usingDeclaration() throws RecognitionException {
		UsingDeclarationContext _localctx = new UsingDeclarationContext(_ctx, getState());
		enterRule(_localctx, 204, RULE_usingDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1256);
			match(Using);
			setState(1262);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,136,_ctx) ) {
			case 1:
				{
				setState(1258);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Typename_) {
					{
					setState(1257);
					match(Typename_);
					}
				}

				setState(1260);
				nestedNameSpecifier(0);
				}
				break;
			case 2:
				{
				setState(1261);
				match(Doublecolon);
				}
				break;
			}
			setState(1264);
			unqualifiedId();
			setState(1265);
			match(Semi);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UsingDirectiveContext extends org.example.antlr.common.context.ExtendContext {
		public TerminalNode Using() { return getToken(CPPParser.Using, 0); }
		public TerminalNode Namespace() { return getToken(CPPParser.Namespace, 0); }
		public NamespaceNameContext namespaceName() {
			return getRuleContext(NamespaceNameContext.class,0);
		}
		public TerminalNode Semi() { return getToken(CPPParser.Semi, 0); }
		public AttributeSpecifierSeqContext attributeSpecifierSeq() {
			return getRuleContext(AttributeSpecifierSeqContext.class,0);
		}
		public NestedNameSpecifierContext nestedNameSpecifier() {
			return getRuleContext(NestedNameSpecifierContext.class,0);
		}
		public UsingDirectiveContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_usingDirective; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).enterUsingDirective(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).exitUsingDirective(this);
		}
	}

	public final UsingDirectiveContext usingDirective() throws RecognitionException {
		UsingDirectiveContext _localctx = new UsingDirectiveContext(_ctx, getState());
		enterRule(_localctx, 206, RULE_usingDirective);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1268);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Alignas || _la==LeftBracket) {
				{
				setState(1267);
				attributeSpecifierSeq();
				}
			}

			setState(1270);
			match(Using);
			setState(1271);
			match(Namespace);
			setState(1273);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,138,_ctx) ) {
			case 1:
				{
				setState(1272);
				nestedNameSpecifier(0);
				}
				break;
			}
			setState(1275);
			namespaceName();
			setState(1276);
			match(Semi);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AsmDefinitionContext extends org.example.antlr.common.context.ExtendContext {
		public TerminalNode Asm() { return getToken(CPPParser.Asm, 0); }
		public TerminalNode LeftParen() { return getToken(CPPParser.LeftParen, 0); }
		public TerminalNode StringLiteral() { return getToken(CPPParser.StringLiteral, 0); }
		public TerminalNode RightParen() { return getToken(CPPParser.RightParen, 0); }
		public TerminalNode Semi() { return getToken(CPPParser.Semi, 0); }
		public AsmDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_asmDefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).enterAsmDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).exitAsmDefinition(this);
		}
	}

	public final AsmDefinitionContext asmDefinition() throws RecognitionException {
		AsmDefinitionContext _localctx = new AsmDefinitionContext(_ctx, getState());
		enterRule(_localctx, 208, RULE_asmDefinition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1278);
			match(Asm);
			setState(1279);
			match(LeftParen);
			setState(1280);
			match(StringLiteral);
			setState(1281);
			match(RightParen);
			setState(1282);
			match(Semi);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LinkageSpecificationContext extends org.example.antlr.common.context.ExtendContext {
		public TerminalNode Extern() { return getToken(CPPParser.Extern, 0); }
		public TerminalNode StringLiteral() { return getToken(CPPParser.StringLiteral, 0); }
		public TerminalNode LeftBrace() { return getToken(CPPParser.LeftBrace, 0); }
		public TerminalNode RightBrace() { return getToken(CPPParser.RightBrace, 0); }
		public DeclarationContext declaration() {
			return getRuleContext(DeclarationContext.class,0);
		}
		public DeclarationseqContext declarationseq() {
			return getRuleContext(DeclarationseqContext.class,0);
		}
		public LinkageSpecificationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_linkageSpecification; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).enterLinkageSpecification(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).exitLinkageSpecification(this);
		}
	}

	public final LinkageSpecificationContext linkageSpecification() throws RecognitionException {
		LinkageSpecificationContext _localctx = new LinkageSpecificationContext(_ctx, getState());
		enterRule(_localctx, 210, RULE_linkageSpecification);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1284);
			match(Extern);
			setState(1285);
			match(StringLiteral);
			setState(1292);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LeftBrace:
				{
				setState(1286);
				match(LeftBrace);
				setState(1288);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 10)) & ~0x3f) == 0 && ((1L << (_la - 10)) & ((1L << (Alignas - 10)) | (1L << (Asm - 10)) | (1L << (Auto - 10)) | (1L << (Bool - 10)) | (1L << (Char - 10)) | (1L << (Char16 - 10)) | (1L << (Char32 - 10)) | (1L << (Class - 10)) | (1L << (Const - 10)) | (1L << (Constexpr - 10)) | (1L << (Decltype - 10)) | (1L << (Double - 10)) | (1L << (Enum - 10)) | (1L << (Explicit - 10)) | (1L << (Extern - 10)) | (1L << (Float - 10)) | (1L << (Friend - 10)) | (1L << (Inline - 10)) | (1L << (Int - 10)) | (1L << (Long - 10)) | (1L << (Mutable - 10)) | (1L << (Namespace - 10)) | (1L << (Operator - 10)) | (1L << (Register - 10)) | (1L << (Short - 10)) | (1L << (Signed - 10)) | (1L << (Static - 10)) | (1L << (Static_assert - 10)) | (1L << (Struct - 10)) | (1L << (Template - 10)) | (1L << (Thread_local - 10)))) != 0) || ((((_la - 74)) & ~0x3f) == 0 && ((1L << (_la - 74)) & ((1L << (Typedef - 74)) | (1L << (Typename_ - 74)) | (1L << (Union - 74)) | (1L << (Unsigned - 74)) | (1L << (Using - 74)) | (1L << (Virtual - 74)) | (1L << (Void - 74)) | (1L << (Volatile - 74)) | (1L << (Wchar - 74)) | (1L << (LeftParen - 74)) | (1L << (LeftBracket - 74)) | (1L << (Star - 74)) | (1L << (And - 74)) | (1L << (Tilde - 74)) | (1L << (AndAnd - 74)) | (1L << (Doublecolon - 74)) | (1L << (Semi - 74)) | (1L << (Ellipsis - 74)) | (1L << (Identifier - 74)))) != 0)) {
					{
					setState(1287);
					declarationseq();
					}
				}

				setState(1290);
				match(RightBrace);
				}
				break;
			case Alignas:
			case Asm:
			case Auto:
			case Bool:
			case Char:
			case Char16:
			case Char32:
			case Class:
			case Const:
			case Constexpr:
			case Decltype:
			case Double:
			case Enum:
			case Explicit:
			case Extern:
			case Float:
			case Friend:
			case Inline:
			case Int:
			case Long:
			case Mutable:
			case Namespace:
			case Operator:
			case Register:
			case Short:
			case Signed:
			case Static:
			case Static_assert:
			case Struct:
			case Template:
			case Thread_local:
			case Typedef:
			case Typename_:
			case Union:
			case Unsigned:
			case Using:
			case Virtual:
			case Void:
			case Volatile:
			case Wchar:
			case LeftParen:
			case LeftBracket:
			case Star:
			case And:
			case Tilde:
			case AndAnd:
			case Doublecolon:
			case Semi:
			case Ellipsis:
			case Identifier:
				{
				setState(1291);
				declaration();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AttributeSpecifierSeqContext extends org.example.antlr.common.context.ExtendContext {
		public List<AttributeSpecifierContext> attributeSpecifier() {
			return getRuleContexts(AttributeSpecifierContext.class);
		}
		public AttributeSpecifierContext attributeSpecifier(int i) {
			return getRuleContext(AttributeSpecifierContext.class,i);
		}
		public AttributeSpecifierSeqContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attributeSpecifierSeq; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).enterAttributeSpecifierSeq(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).exitAttributeSpecifierSeq(this);
		}
	}

	public final AttributeSpecifierSeqContext attributeSpecifierSeq() throws RecognitionException {
		AttributeSpecifierSeqContext _localctx = new AttributeSpecifierSeqContext(_ctx, getState());
		enterRule(_localctx, 212, RULE_attributeSpecifierSeq);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1295); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(1294);
					attributeSpecifier();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1297); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,141,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AttributeSpecifierContext extends org.example.antlr.common.context.ExtendContext {
		public List<TerminalNode> LeftBracket() { return getTokens(CPPParser.LeftBracket); }
		public TerminalNode LeftBracket(int i) {
			return getToken(CPPParser.LeftBracket, i);
		}
		public List<TerminalNode> RightBracket() { return getTokens(CPPParser.RightBracket); }
		public TerminalNode RightBracket(int i) {
			return getToken(CPPParser.RightBracket, i);
		}
		public AttributeListContext attributeList() {
			return getRuleContext(AttributeListContext.class,0);
		}
		public AlignmentspecifierContext alignmentspecifier() {
			return getRuleContext(AlignmentspecifierContext.class,0);
		}
		public AttributeSpecifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attributeSpecifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).enterAttributeSpecifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).exitAttributeSpecifier(this);
		}
	}

	public final AttributeSpecifierContext attributeSpecifier() throws RecognitionException {
		AttributeSpecifierContext _localctx = new AttributeSpecifierContext(_ctx, getState());
		enterRule(_localctx, 214, RULE_attributeSpecifier);
		int _la;
		try {
			setState(1307);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LeftBracket:
				enterOuterAlt(_localctx, 1);
				{
				setState(1299);
				match(LeftBracket);
				setState(1300);
				match(LeftBracket);
				setState(1302);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Identifier) {
					{
					setState(1301);
					attributeList();
					}
				}

				setState(1304);
				match(RightBracket);
				setState(1305);
				match(RightBracket);
				}
				break;
			case Alignas:
				enterOuterAlt(_localctx, 2);
				{
				setState(1306);
				alignmentspecifier();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AlignmentspecifierContext extends org.example.antlr.common.context.ExtendContext {
		public TerminalNode Alignas() { return getToken(CPPParser.Alignas, 0); }
		public TerminalNode LeftParen() { return getToken(CPPParser.LeftParen, 0); }
		public TerminalNode RightParen() { return getToken(CPPParser.RightParen, 0); }
		public TheTypeIdContext theTypeId() {
			return getRuleContext(TheTypeIdContext.class,0);
		}
		public ConstantExpressionContext constantExpression() {
			return getRuleContext(ConstantExpressionContext.class,0);
		}
		public TerminalNode Ellipsis() { return getToken(CPPParser.Ellipsis, 0); }
		public AlignmentspecifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_alignmentspecifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).enterAlignmentspecifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).exitAlignmentspecifier(this);
		}
	}

	public final AlignmentspecifierContext alignmentspecifier() throws RecognitionException {
		AlignmentspecifierContext _localctx = new AlignmentspecifierContext(_ctx, getState());
		enterRule(_localctx, 216, RULE_alignmentspecifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1309);
			match(Alignas);
			setState(1310);
			match(LeftParen);
			setState(1313);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,144,_ctx) ) {
			case 1:
				{
				setState(1311);
				theTypeId();
				}
				break;
			case 2:
				{
				setState(1312);
				constantExpression();
				}
				break;
			}
			setState(1316);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Ellipsis) {
				{
				setState(1315);
				match(Ellipsis);
				}
			}

			setState(1318);
			match(RightParen);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AttributeListContext extends org.example.antlr.common.context.ExtendContext {
		public List<AttributeContext> attribute() {
			return getRuleContexts(AttributeContext.class);
		}
		public AttributeContext attribute(int i) {
			return getRuleContext(AttributeContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(CPPParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(CPPParser.Comma, i);
		}
		public TerminalNode Ellipsis() { return getToken(CPPParser.Ellipsis, 0); }
		public AttributeListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attributeList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).enterAttributeList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).exitAttributeList(this);
		}
	}

	public final AttributeListContext attributeList() throws RecognitionException {
		AttributeListContext _localctx = new AttributeListContext(_ctx, getState());
		enterRule(_localctx, 218, RULE_attributeList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1320);
			attribute();
			setState(1325);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(1321);
				match(Comma);
				setState(1322);
				attribute();
				}
				}
				setState(1327);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1329);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Ellipsis) {
				{
				setState(1328);
				match(Ellipsis);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AttributeContext extends org.example.antlr.common.context.ExtendContext {
		public TerminalNode Identifier() { return getToken(CPPParser.Identifier, 0); }
		public AttributeNamespaceContext attributeNamespace() {
			return getRuleContext(AttributeNamespaceContext.class,0);
		}
		public TerminalNode Doublecolon() { return getToken(CPPParser.Doublecolon, 0); }
		public AttributeArgumentClauseContext attributeArgumentClause() {
			return getRuleContext(AttributeArgumentClauseContext.class,0);
		}
		public AttributeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attribute; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).enterAttribute(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).exitAttribute(this);
		}
	}

	public final AttributeContext attribute() throws RecognitionException {
		AttributeContext _localctx = new AttributeContext(_ctx, getState());
		enterRule(_localctx, 220, RULE_attribute);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1334);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,148,_ctx) ) {
			case 1:
				{
				setState(1331);
				attributeNamespace();
				setState(1332);
				match(Doublecolon);
				}
				break;
			}
			setState(1336);
			match(Identifier);
			setState(1338);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LeftParen) {
				{
				setState(1337);
				attributeArgumentClause();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AttributeNamespaceContext extends org.example.antlr.common.context.ExtendContext {
		public TerminalNode Identifier() { return getToken(CPPParser.Identifier, 0); }
		public AttributeNamespaceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attributeNamespace; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).enterAttributeNamespace(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).exitAttributeNamespace(this);
		}
	}

	public final AttributeNamespaceContext attributeNamespace() throws RecognitionException {
		AttributeNamespaceContext _localctx = new AttributeNamespaceContext(_ctx, getState());
		enterRule(_localctx, 222, RULE_attributeNamespace);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1340);
			match(Identifier);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AttributeArgumentClauseContext extends org.example.antlr.common.context.ExtendContext {
		public TerminalNode LeftParen() { return getToken(CPPParser.LeftParen, 0); }
		public TerminalNode RightParen() { return getToken(CPPParser.RightParen, 0); }
		public BalancedTokenSeqContext balancedTokenSeq() {
			return getRuleContext(BalancedTokenSeqContext.class,0);
		}
		public AttributeArgumentClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attributeArgumentClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).enterAttributeArgumentClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).exitAttributeArgumentClause(this);
		}
	}

	public final AttributeArgumentClauseContext attributeArgumentClause() throws RecognitionException {
		AttributeArgumentClauseContext _localctx = new AttributeArgumentClauseContext(_ctx, getState());
		enterRule(_localctx, 224, RULE_attributeArgumentClause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1342);
			match(LeftParen);
			setState(1344);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IntegerLiteral) | (1L << CharacterLiteral) | (1L << FloatingLiteral) | (1L << StringLiteral) | (1L << BooleanLiteral) | (1L << PointerLiteral) | (1L << UserDefinedLiteral) | (1L << MultiLineMacro) | (1L << Directive) | (1L << Alignas) | (1L << Alignof) | (1L << Asm) | (1L << Auto) | (1L << Bool) | (1L << Break) | (1L << Case) | (1L << Catch) | (1L << Char) | (1L << Char16) | (1L << Char32) | (1L << Class) | (1L << Const) | (1L << Constexpr) | (1L << Const_cast) | (1L << Continue) | (1L << Decltype) | (1L << Default) | (1L << Delete) | (1L << Do) | (1L << Double) | (1L << Dynamic_cast) | (1L << Else) | (1L << Enum) | (1L << Explicit) | (1L << Export) | (1L << Extern) | (1L << False_) | (1L << Final) | (1L << Float) | (1L << For) | (1L << Friend) | (1L << Goto) | (1L << If) | (1L << Inline) | (1L << Int) | (1L << Long) | (1L << Mutable) | (1L << Namespace) | (1L << New) | (1L << Noexcept) | (1L << Nullptr) | (1L << Operator) | (1L << Override) | (1L << Private) | (1L << Protected) | (1L << Public) | (1L << Register) | (1L << Reinterpret_cast) | (1L << Return) | (1L << Short) | (1L << Signed) | (1L << Sizeof) | (1L << Static))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (Static_assert - 64)) | (1L << (Static_cast - 64)) | (1L << (Struct - 64)) | (1L << (Switch - 64)) | (1L << (Template - 64)) | (1L << (This - 64)) | (1L << (Thread_local - 64)) | (1L << (Throw - 64)) | (1L << (True_ - 64)) | (1L << (Try - 64)) | (1L << (Typedef - 64)) | (1L << (Typeid_ - 64)) | (1L << (Typename_ - 64)) | (1L << (Union - 64)) | (1L << (Unsigned - 64)) | (1L << (Using - 64)) | (1L << (Virtual - 64)) | (1L << (Void - 64)) | (1L << (Volatile - 64)) | (1L << (Wchar - 64)) | (1L << (While - 64)) | (1L << (LeftParen - 64)) | (1L << (LeftBracket - 64)) | (1L << (LeftBrace - 64)) | (1L << (Plus - 64)) | (1L << (Minus - 64)) | (1L << (Star - 64)) | (1L << (Div - 64)) | (1L << (Mod - 64)) | (1L << (Caret - 64)) | (1L << (And - 64)) | (1L << (Or - 64)) | (1L << (Tilde - 64)) | (1L << (Not - 64)) | (1L << (Assign - 64)) | (1L << (Less - 64)) | (1L << (Greater - 64)) | (1L << (PlusAssign - 64)) | (1L << (MinusAssign - 64)) | (1L << (StarAssign - 64)) | (1L << (DivAssign - 64)) | (1L << (ModAssign - 64)) | (1L << (XorAssign - 64)) | (1L << (AndAssign - 64)) | (1L << (OrAssign - 64)) | (1L << (LeftShiftAssign - 64)) | (1L << (RightShiftAssign - 64)) | (1L << (Equal - 64)) | (1L << (NotEqual - 64)) | (1L << (LessEqual - 64)) | (1L << (GreaterEqual - 64)) | (1L << (AndAnd - 64)) | (1L << (OrOr - 64)) | (1L << (PlusPlus - 64)) | (1L << (MinusMinus - 64)) | (1L << (Comma - 64)) | (1L << (ArrowStar - 64)) | (1L << (Arrow - 64)) | (1L << (Question - 64)) | (1L << (Colon - 64)) | (1L << (Doublecolon - 64)))) != 0) || ((((_la - 128)) & ~0x3f) == 0 && ((1L << (_la - 128)) & ((1L << (Semi - 128)) | (1L << (Dot - 128)) | (1L << (DotStar - 128)) | (1L << (Ellipsis - 128)) | (1L << (Identifier - 128)) | (1L << (DecimalLiteral - 128)) | (1L << (OctalLiteral - 128)) | (1L << (HexadecimalLiteral - 128)) | (1L << (BinaryLiteral - 128)) | (1L << (Integersuffix - 128)) | (1L << (UserDefinedIntegerLiteral - 128)) | (1L << (UserDefinedFloatingLiteral - 128)) | (1L << (UserDefinedStringLiteral - 128)) | (1L << (UserDefinedCharacterLiteral - 128)) | (1L << (Whitespace - 128)) | (1L << (Newline - 128)) | (1L << (BlockComment - 128)) | (1L << (LineComment - 128)))) != 0)) {
				{
				setState(1343);
				balancedTokenSeq();
				}
			}

			setState(1346);
			match(RightParen);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BalancedTokenSeqContext extends org.example.antlr.common.context.ExtendContext {
		public List<BalancedtokenContext> balancedtoken() {
			return getRuleContexts(BalancedtokenContext.class);
		}
		public BalancedtokenContext balancedtoken(int i) {
			return getRuleContext(BalancedtokenContext.class,i);
		}
		public BalancedTokenSeqContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_balancedTokenSeq; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).enterBalancedTokenSeq(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).exitBalancedTokenSeq(this);
		}
	}

	public final BalancedTokenSeqContext balancedTokenSeq() throws RecognitionException {
		BalancedTokenSeqContext _localctx = new BalancedTokenSeqContext(_ctx, getState());
		enterRule(_localctx, 226, RULE_balancedTokenSeq);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1349); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(1348);
				balancedtoken();
				}
				}
				setState(1351); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IntegerLiteral) | (1L << CharacterLiteral) | (1L << FloatingLiteral) | (1L << StringLiteral) | (1L << BooleanLiteral) | (1L << PointerLiteral) | (1L << UserDefinedLiteral) | (1L << MultiLineMacro) | (1L << Directive) | (1L << Alignas) | (1L << Alignof) | (1L << Asm) | (1L << Auto) | (1L << Bool) | (1L << Break) | (1L << Case) | (1L << Catch) | (1L << Char) | (1L << Char16) | (1L << Char32) | (1L << Class) | (1L << Const) | (1L << Constexpr) | (1L << Const_cast) | (1L << Continue) | (1L << Decltype) | (1L << Default) | (1L << Delete) | (1L << Do) | (1L << Double) | (1L << Dynamic_cast) | (1L << Else) | (1L << Enum) | (1L << Explicit) | (1L << Export) | (1L << Extern) | (1L << False_) | (1L << Final) | (1L << Float) | (1L << For) | (1L << Friend) | (1L << Goto) | (1L << If) | (1L << Inline) | (1L << Int) | (1L << Long) | (1L << Mutable) | (1L << Namespace) | (1L << New) | (1L << Noexcept) | (1L << Nullptr) | (1L << Operator) | (1L << Override) | (1L << Private) | (1L << Protected) | (1L << Public) | (1L << Register) | (1L << Reinterpret_cast) | (1L << Return) | (1L << Short) | (1L << Signed) | (1L << Sizeof) | (1L << Static))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (Static_assert - 64)) | (1L << (Static_cast - 64)) | (1L << (Struct - 64)) | (1L << (Switch - 64)) | (1L << (Template - 64)) | (1L << (This - 64)) | (1L << (Thread_local - 64)) | (1L << (Throw - 64)) | (1L << (True_ - 64)) | (1L << (Try - 64)) | (1L << (Typedef - 64)) | (1L << (Typeid_ - 64)) | (1L << (Typename_ - 64)) | (1L << (Union - 64)) | (1L << (Unsigned - 64)) | (1L << (Using - 64)) | (1L << (Virtual - 64)) | (1L << (Void - 64)) | (1L << (Volatile - 64)) | (1L << (Wchar - 64)) | (1L << (While - 64)) | (1L << (LeftParen - 64)) | (1L << (LeftBracket - 64)) | (1L << (LeftBrace - 64)) | (1L << (Plus - 64)) | (1L << (Minus - 64)) | (1L << (Star - 64)) | (1L << (Div - 64)) | (1L << (Mod - 64)) | (1L << (Caret - 64)) | (1L << (And - 64)) | (1L << (Or - 64)) | (1L << (Tilde - 64)) | (1L << (Not - 64)) | (1L << (Assign - 64)) | (1L << (Less - 64)) | (1L << (Greater - 64)) | (1L << (PlusAssign - 64)) | (1L << (MinusAssign - 64)) | (1L << (StarAssign - 64)) | (1L << (DivAssign - 64)) | (1L << (ModAssign - 64)) | (1L << (XorAssign - 64)) | (1L << (AndAssign - 64)) | (1L << (OrAssign - 64)) | (1L << (LeftShiftAssign - 64)) | (1L << (RightShiftAssign - 64)) | (1L << (Equal - 64)) | (1L << (NotEqual - 64)) | (1L << (LessEqual - 64)) | (1L << (GreaterEqual - 64)) | (1L << (AndAnd - 64)) | (1L << (OrOr - 64)) | (1L << (PlusPlus - 64)) | (1L << (MinusMinus - 64)) | (1L << (Comma - 64)) | (1L << (ArrowStar - 64)) | (1L << (Arrow - 64)) | (1L << (Question - 64)) | (1L << (Colon - 64)) | (1L << (Doublecolon - 64)))) != 0) || ((((_la - 128)) & ~0x3f) == 0 && ((1L << (_la - 128)) & ((1L << (Semi - 128)) | (1L << (Dot - 128)) | (1L << (DotStar - 128)) | (1L << (Ellipsis - 128)) | (1L << (Identifier - 128)) | (1L << (DecimalLiteral - 128)) | (1L << (OctalLiteral - 128)) | (1L << (HexadecimalLiteral - 128)) | (1L << (BinaryLiteral - 128)) | (1L << (Integersuffix - 128)) | (1L << (UserDefinedIntegerLiteral - 128)) | (1L << (UserDefinedFloatingLiteral - 128)) | (1L << (UserDefinedStringLiteral - 128)) | (1L << (UserDefinedCharacterLiteral - 128)) | (1L << (Whitespace - 128)) | (1L << (Newline - 128)) | (1L << (BlockComment - 128)) | (1L << (LineComment - 128)))) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BalancedtokenContext extends org.example.antlr.common.context.ExtendContext {
		public List<TerminalNode> LeftParen() { return getTokens(CPPParser.LeftParen); }
		public TerminalNode LeftParen(int i) {
			return getToken(CPPParser.LeftParen, i);
		}
		public BalancedTokenSeqContext balancedTokenSeq() {
			return getRuleContext(BalancedTokenSeqContext.class,0);
		}
		public List<TerminalNode> RightParen() { return getTokens(CPPParser.RightParen); }
		public TerminalNode RightParen(int i) {
			return getToken(CPPParser.RightParen, i);
		}
		public List<TerminalNode> LeftBracket() { return getTokens(CPPParser.LeftBracket); }
		public TerminalNode LeftBracket(int i) {
			return getToken(CPPParser.LeftBracket, i);
		}
		public List<TerminalNode> RightBracket() { return getTokens(CPPParser.RightBracket); }
		public TerminalNode RightBracket(int i) {
			return getToken(CPPParser.RightBracket, i);
		}
		public List<TerminalNode> LeftBrace() { return getTokens(CPPParser.LeftBrace); }
		public TerminalNode LeftBrace(int i) {
			return getToken(CPPParser.LeftBrace, i);
		}
		public List<TerminalNode> RightBrace() { return getTokens(CPPParser.RightBrace); }
		public TerminalNode RightBrace(int i) {
			return getToken(CPPParser.RightBrace, i);
		}
		public BalancedtokenContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_balancedtoken; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).enterBalancedtoken(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).exitBalancedtoken(this);
		}
	}

	public final BalancedtokenContext balancedtoken() throws RecognitionException {
		BalancedtokenContext _localctx = new BalancedtokenContext(_ctx, getState());
		enterRule(_localctx, 228, RULE_balancedtoken);
		int _la;
		try {
			int _alt;
			setState(1370);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LeftParen:
				enterOuterAlt(_localctx, 1);
				{
				setState(1353);
				match(LeftParen);
				setState(1354);
				balancedTokenSeq();
				setState(1355);
				match(RightParen);
				}
				break;
			case LeftBracket:
				enterOuterAlt(_localctx, 2);
				{
				setState(1357);
				match(LeftBracket);
				setState(1358);
				balancedTokenSeq();
				setState(1359);
				match(RightBracket);
				}
				break;
			case LeftBrace:
				enterOuterAlt(_localctx, 3);
				{
				setState(1361);
				match(LeftBrace);
				setState(1362);
				balancedTokenSeq();
				setState(1363);
				match(RightBrace);
				}
				break;
			case IntegerLiteral:
			case CharacterLiteral:
			case FloatingLiteral:
			case StringLiteral:
			case BooleanLiteral:
			case PointerLiteral:
			case UserDefinedLiteral:
			case MultiLineMacro:
			case Directive:
			case Alignas:
			case Alignof:
			case Asm:
			case Auto:
			case Bool:
			case Break:
			case Case:
			case Catch:
			case Char:
			case Char16:
			case Char32:
			case Class:
			case Const:
			case Constexpr:
			case Const_cast:
			case Continue:
			case Decltype:
			case Default:
			case Delete:
			case Do:
			case Double:
			case Dynamic_cast:
			case Else:
			case Enum:
			case Explicit:
			case Export:
			case Extern:
			case False_:
			case Final:
			case Float:
			case For:
			case Friend:
			case Goto:
			case If:
			case Inline:
			case Int:
			case Long:
			case Mutable:
			case Namespace:
			case New:
			case Noexcept:
			case Nullptr:
			case Operator:
			case Override:
			case Private:
			case Protected:
			case Public:
			case Register:
			case Reinterpret_cast:
			case Return:
			case Short:
			case Signed:
			case Sizeof:
			case Static:
			case Static_assert:
			case Static_cast:
			case Struct:
			case Switch:
			case Template:
			case This:
			case Thread_local:
			case Throw:
			case True_:
			case Try:
			case Typedef:
			case Typeid_:
			case Typename_:
			case Union:
			case Unsigned:
			case Using:
			case Virtual:
			case Void:
			case Volatile:
			case Wchar:
			case While:
			case Plus:
			case Minus:
			case Star:
			case Div:
			case Mod:
			case Caret:
			case And:
			case Or:
			case Tilde:
			case Not:
			case Assign:
			case Less:
			case Greater:
			case PlusAssign:
			case MinusAssign:
			case StarAssign:
			case DivAssign:
			case ModAssign:
			case XorAssign:
			case AndAssign:
			case OrAssign:
			case LeftShiftAssign:
			case RightShiftAssign:
			case Equal:
			case NotEqual:
			case LessEqual:
			case GreaterEqual:
			case AndAnd:
			case OrOr:
			case PlusPlus:
			case MinusMinus:
			case Comma:
			case ArrowStar:
			case Arrow:
			case Question:
			case Colon:
			case Doublecolon:
			case Semi:
			case Dot:
			case DotStar:
			case Ellipsis:
			case Identifier:
			case DecimalLiteral:
			case OctalLiteral:
			case HexadecimalLiteral:
			case BinaryLiteral:
			case Integersuffix:
			case UserDefinedIntegerLiteral:
			case UserDefinedFloatingLiteral:
			case UserDefinedStringLiteral:
			case UserDefinedCharacterLiteral:
			case Whitespace:
			case Newline:
			case BlockComment:
			case LineComment:
				enterOuterAlt(_localctx, 4);
				{
				setState(1366); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(1365);
						_la = _input.LA(1);
						if ( _la <= 0 || (((((_la - 85)) & ~0x3f) == 0 && ((1L << (_la - 85)) & ((1L << (LeftParen - 85)) | (1L << (RightParen - 85)) | (1L << (LeftBracket - 85)) | (1L << (RightBracket - 85)) | (1L << (LeftBrace - 85)) | (1L << (RightBrace - 85)))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(1368); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,152,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InitDeclaratorListContext extends org.example.antlr.common.context.ExtendContext {
		public List<InitDeclaratorContext> initDeclarator() {
			return getRuleContexts(InitDeclaratorContext.class);
		}
		public InitDeclaratorContext initDeclarator(int i) {
			return getRuleContext(InitDeclaratorContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(CPPParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(CPPParser.Comma, i);
		}
		public InitDeclaratorListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_initDeclaratorList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).enterInitDeclaratorList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).exitInitDeclaratorList(this);
		}
	}

	public final InitDeclaratorListContext initDeclaratorList() throws RecognitionException {
		InitDeclaratorListContext _localctx = new InitDeclaratorListContext(_ctx, getState());
		enterRule(_localctx, 230, RULE_initDeclaratorList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1372);
			initDeclarator();
			setState(1377);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(1373);
				match(Comma);
				setState(1374);
				initDeclarator();
				}
				}
				setState(1379);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InitDeclaratorContext extends org.example.antlr.common.context.ExtendContext {
		public DeclaratorContext declarator() {
			return getRuleContext(DeclaratorContext.class,0);
		}
		public InitializerContext initializer() {
			return getRuleContext(InitializerContext.class,0);
		}
		public InitDeclaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_initDeclarator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).enterInitDeclarator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).exitInitDeclarator(this);
		}
	}

	public final InitDeclaratorContext initDeclarator() throws RecognitionException {
		InitDeclaratorContext _localctx = new InitDeclaratorContext(_ctx, getState());
		enterRule(_localctx, 232, RULE_initDeclarator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1380);
			declarator();
			setState(1382);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 85)) & ~0x3f) == 0 && ((1L << (_la - 85)) & ((1L << (LeftParen - 85)) | (1L << (LeftBrace - 85)) | (1L << (Assign - 85)))) != 0)) {
				{
				setState(1381);
				initializer();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclaratorContext extends org.example.antlr.common.context.ExtendContext {
		public PointerDeclaratorContext pointerDeclarator() {
			return getRuleContext(PointerDeclaratorContext.class,0);
		}
		public NoPointerDeclaratorContext noPointerDeclarator() {
			return getRuleContext(NoPointerDeclaratorContext.class,0);
		}
		public ParametersAndQualifiersContext parametersAndQualifiers() {
			return getRuleContext(ParametersAndQualifiersContext.class,0);
		}
		public TrailingReturnTypeContext trailingReturnType() {
			return getRuleContext(TrailingReturnTypeContext.class,0);
		}
		public DeclaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declarator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).enterDeclarator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).exitDeclarator(this);
		}
	}

	public final DeclaratorContext declarator() throws RecognitionException {
		DeclaratorContext _localctx = new DeclaratorContext(_ctx, getState());
		enterRule(_localctx, 234, RULE_declarator);
		try {
			setState(1389);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,156,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1384);
				pointerDeclarator();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1385);
				noPointerDeclarator(0);
				setState(1386);
				parametersAndQualifiers();
				setState(1387);
				trailingReturnType();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PointerDeclaratorContext extends org.example.antlr.common.context.ExtendContext {
		public NoPointerDeclaratorContext noPointerDeclarator() {
			return getRuleContext(NoPointerDeclaratorContext.class,0);
		}
		public List<PointerOperatorContext> pointerOperator() {
			return getRuleContexts(PointerOperatorContext.class);
		}
		public PointerOperatorContext pointerOperator(int i) {
			return getRuleContext(PointerOperatorContext.class,i);
		}
		public List<TerminalNode> Const() { return getTokens(CPPParser.Const); }
		public TerminalNode Const(int i) {
			return getToken(CPPParser.Const, i);
		}
		public PointerDeclaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pointerDeclarator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).enterPointerDeclarator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).exitPointerDeclarator(this);
		}
	}

	public final PointerDeclaratorContext pointerDeclarator() throws RecognitionException {
		PointerDeclaratorContext _localctx = new PointerDeclaratorContext(_ctx, getState());
		enterRule(_localctx, 236, RULE_pointerDeclarator);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1397);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,158,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1391);
					pointerOperator();
					setState(1393);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==Const) {
						{
						setState(1392);
						match(Const);
						}
					}

					}
					} 
				}
				setState(1399);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,158,_ctx);
			}
			setState(1400);
			noPointerDeclarator(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NoPointerDeclaratorContext extends org.example.antlr.common.context.ExtendContext {
		public DeclaratoridContext declaratorid() {
			return getRuleContext(DeclaratoridContext.class,0);
		}
		public AttributeSpecifierSeqContext attributeSpecifierSeq() {
			return getRuleContext(AttributeSpecifierSeqContext.class,0);
		}
		public TerminalNode LeftParen() { return getToken(CPPParser.LeftParen, 0); }
		public PointerDeclaratorContext pointerDeclarator() {
			return getRuleContext(PointerDeclaratorContext.class,0);
		}
		public TerminalNode RightParen() { return getToken(CPPParser.RightParen, 0); }
		public NoPointerDeclaratorContext noPointerDeclarator() {
			return getRuleContext(NoPointerDeclaratorContext.class,0);
		}
		public ParametersAndQualifiersContext parametersAndQualifiers() {
			return getRuleContext(ParametersAndQualifiersContext.class,0);
		}
		public TerminalNode LeftBracket() { return getToken(CPPParser.LeftBracket, 0); }
		public TerminalNode RightBracket() { return getToken(CPPParser.RightBracket, 0); }
		public ConstantExpressionContext constantExpression() {
			return getRuleContext(ConstantExpressionContext.class,0);
		}
		public NoPointerDeclaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_noPointerDeclarator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).enterNoPointerDeclarator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).exitNoPointerDeclarator(this);
		}
	}

	public final NoPointerDeclaratorContext noPointerDeclarator() throws RecognitionException {
		return noPointerDeclarator(0);
	}

	private NoPointerDeclaratorContext noPointerDeclarator(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		NoPointerDeclaratorContext _localctx = new NoPointerDeclaratorContext(_ctx, _parentState);
		NoPointerDeclaratorContext _prevctx = _localctx;
		int _startState = 238;
		enterRecursionRule(_localctx, 238, RULE_noPointerDeclarator, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1411);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Decltype:
			case Operator:
			case Tilde:
			case Doublecolon:
			case Ellipsis:
			case Identifier:
				{
				setState(1403);
				declaratorid();
				setState(1405);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,159,_ctx) ) {
				case 1:
					{
					setState(1404);
					attributeSpecifierSeq();
					}
					break;
				}
				}
				break;
			case LeftParen:
				{
				setState(1407);
				match(LeftParen);
				setState(1408);
				pointerDeclarator();
				setState(1409);
				match(RightParen);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(1427);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,164,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new NoPointerDeclaratorContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_noPointerDeclarator);
					setState(1413);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(1423);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case LeftParen:
						{
						setState(1414);
						parametersAndQualifiers();
						}
						break;
					case LeftBracket:
						{
						setState(1415);
						match(LeftBracket);
						setState(1417);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IntegerLiteral) | (1L << CharacterLiteral) | (1L << FloatingLiteral) | (1L << StringLiteral) | (1L << BooleanLiteral) | (1L << PointerLiteral) | (1L << UserDefinedLiteral) | (1L << Alignof) | (1L << Auto) | (1L << Bool) | (1L << Char) | (1L << Char16) | (1L << Char32) | (1L << Const_cast) | (1L << Decltype) | (1L << Delete) | (1L << Double) | (1L << Dynamic_cast) | (1L << Float) | (1L << Int) | (1L << Long) | (1L << New) | (1L << Noexcept) | (1L << Operator) | (1L << Reinterpret_cast) | (1L << Short) | (1L << Signed) | (1L << Sizeof))) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (Static_cast - 65)) | (1L << (This - 65)) | (1L << (Typeid_ - 65)) | (1L << (Typename_ - 65)) | (1L << (Unsigned - 65)) | (1L << (Void - 65)) | (1L << (Wchar - 65)) | (1L << (LeftParen - 65)) | (1L << (LeftBracket - 65)) | (1L << (Plus - 65)) | (1L << (Minus - 65)) | (1L << (Star - 65)) | (1L << (And - 65)) | (1L << (Or - 65)) | (1L << (Tilde - 65)) | (1L << (Not - 65)) | (1L << (PlusPlus - 65)) | (1L << (MinusMinus - 65)) | (1L << (Doublecolon - 65)))) != 0) || _la==Identifier) {
							{
							setState(1416);
							constantExpression();
							}
						}

						setState(1419);
						match(RightBracket);
						setState(1421);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,162,_ctx) ) {
						case 1:
							{
							setState(1420);
							attributeSpecifierSeq();
							}
							break;
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					} 
				}
				setState(1429);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,164,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class ParametersAndQualifiersContext extends org.example.antlr.common.context.ExtendContext {
		public TerminalNode LeftParen() { return getToken(CPPParser.LeftParen, 0); }
		public TerminalNode RightParen() { return getToken(CPPParser.RightParen, 0); }
		public ParameterDeclarationClauseContext parameterDeclarationClause() {
			return getRuleContext(ParameterDeclarationClauseContext.class,0);
		}
		public CvqualifierseqContext cvqualifierseq() {
			return getRuleContext(CvqualifierseqContext.class,0);
		}
		public RefqualifierContext refqualifier() {
			return getRuleContext(RefqualifierContext.class,0);
		}
		public ExceptionSpecificationContext exceptionSpecification() {
			return getRuleContext(ExceptionSpecificationContext.class,0);
		}
		public AttributeSpecifierSeqContext attributeSpecifierSeq() {
			return getRuleContext(AttributeSpecifierSeqContext.class,0);
		}
		public ParametersAndQualifiersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parametersAndQualifiers; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).enterParametersAndQualifiers(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).exitParametersAndQualifiers(this);
		}
	}

	public final ParametersAndQualifiersContext parametersAndQualifiers() throws RecognitionException {
		ParametersAndQualifiersContext _localctx = new ParametersAndQualifiersContext(_ctx, getState());
		enterRule(_localctx, 240, RULE_parametersAndQualifiers);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1430);
			match(LeftParen);
			setState(1432);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 10)) & ~0x3f) == 0 && ((1L << (_la - 10)) & ((1L << (Alignas - 10)) | (1L << (Auto - 10)) | (1L << (Bool - 10)) | (1L << (Char - 10)) | (1L << (Char16 - 10)) | (1L << (Char32 - 10)) | (1L << (Class - 10)) | (1L << (Const - 10)) | (1L << (Constexpr - 10)) | (1L << (Decltype - 10)) | (1L << (Double - 10)) | (1L << (Enum - 10)) | (1L << (Explicit - 10)) | (1L << (Extern - 10)) | (1L << (Float - 10)) | (1L << (Friend - 10)) | (1L << (Inline - 10)) | (1L << (Int - 10)) | (1L << (Long - 10)) | (1L << (Mutable - 10)) | (1L << (Register - 10)) | (1L << (Short - 10)) | (1L << (Signed - 10)) | (1L << (Static - 10)) | (1L << (Struct - 10)) | (1L << (Thread_local - 10)))) != 0) || ((((_la - 74)) & ~0x3f) == 0 && ((1L << (_la - 74)) & ((1L << (Typedef - 74)) | (1L << (Typename_ - 74)) | (1L << (Union - 74)) | (1L << (Unsigned - 74)) | (1L << (Virtual - 74)) | (1L << (Void - 74)) | (1L << (Volatile - 74)) | (1L << (Wchar - 74)) | (1L << (LeftBracket - 74)) | (1L << (Doublecolon - 74)) | (1L << (Identifier - 74)))) != 0)) {
				{
				setState(1431);
				parameterDeclarationClause();
				}
			}

			setState(1434);
			match(RightParen);
			setState(1436);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,166,_ctx) ) {
			case 1:
				{
				setState(1435);
				cvqualifierseq();
				}
				break;
			}
			setState(1439);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,167,_ctx) ) {
			case 1:
				{
				setState(1438);
				refqualifier();
				}
				break;
			}
			setState(1442);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,168,_ctx) ) {
			case 1:
				{
				setState(1441);
				exceptionSpecification();
				}
				break;
			}
			setState(1445);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,169,_ctx) ) {
			case 1:
				{
				setState(1444);
				attributeSpecifierSeq();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TrailingReturnTypeContext extends org.example.antlr.common.context.ExtendContext {
		public TerminalNode Arrow() { return getToken(CPPParser.Arrow, 0); }
		public TrailingTypeSpecifierSeqContext trailingTypeSpecifierSeq() {
			return getRuleContext(TrailingTypeSpecifierSeqContext.class,0);
		}
		public AbstractDeclaratorContext abstractDeclarator() {
			return getRuleContext(AbstractDeclaratorContext.class,0);
		}
		public TrailingReturnTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_trailingReturnType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).enterTrailingReturnType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).exitTrailingReturnType(this);
		}
	}

	public final TrailingReturnTypeContext trailingReturnType() throws RecognitionException {
		TrailingReturnTypeContext _localctx = new TrailingReturnTypeContext(_ctx, getState());
		enterRule(_localctx, 242, RULE_trailingReturnType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1447);
			match(Arrow);
			setState(1448);
			trailingTypeSpecifierSeq();
			setState(1450);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,170,_ctx) ) {
			case 1:
				{
				setState(1449);
				abstractDeclarator();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PointerOperatorContext extends org.example.antlr.common.context.ExtendContext {
		public TerminalNode And() { return getToken(CPPParser.And, 0); }
		public TerminalNode AndAnd() { return getToken(CPPParser.AndAnd, 0); }
		public AttributeSpecifierSeqContext attributeSpecifierSeq() {
			return getRuleContext(AttributeSpecifierSeqContext.class,0);
		}
		public TerminalNode Star() { return getToken(CPPParser.Star, 0); }
		public NestedNameSpecifierContext nestedNameSpecifier() {
			return getRuleContext(NestedNameSpecifierContext.class,0);
		}
		public CvqualifierseqContext cvqualifierseq() {
			return getRuleContext(CvqualifierseqContext.class,0);
		}
		public PointerOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pointerOperator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).enterPointerOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).exitPointerOperator(this);
		}
	}

	public final PointerOperatorContext pointerOperator() throws RecognitionException {
		PointerOperatorContext _localctx = new PointerOperatorContext(_ctx, getState());
		enterRule(_localctx, 244, RULE_pointerOperator);
		int _la;
		try {
			setState(1466);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case And:
			case AndAnd:
				enterOuterAlt(_localctx, 1);
				{
				setState(1452);
				_la = _input.LA(1);
				if ( !(_la==And || _la==AndAnd) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(1454);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,171,_ctx) ) {
				case 1:
					{
					setState(1453);
					attributeSpecifierSeq();
					}
					break;
				}
				}
				break;
			case Decltype:
			case Star:
			case Doublecolon:
			case Identifier:
				enterOuterAlt(_localctx, 2);
				{
				setState(1457);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Decltype || _la==Doublecolon || _la==Identifier) {
					{
					setState(1456);
					nestedNameSpecifier(0);
					}
				}

				setState(1459);
				match(Star);
				setState(1461);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,173,_ctx) ) {
				case 1:
					{
					setState(1460);
					attributeSpecifierSeq();
					}
					break;
				}
				setState(1464);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,174,_ctx) ) {
				case 1:
					{
					setState(1463);
					cvqualifierseq();
					}
					break;
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CvqualifierseqContext extends org.example.antlr.common.context.ExtendContext {
		public List<CvQualifierContext> cvQualifier() {
			return getRuleContexts(CvQualifierContext.class);
		}
		public CvQualifierContext cvQualifier(int i) {
			return getRuleContext(CvQualifierContext.class,i);
		}
		public CvqualifierseqContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cvqualifierseq; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).enterCvqualifierseq(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).exitCvqualifierseq(this);
		}
	}

	public final CvqualifierseqContext cvqualifierseq() throws RecognitionException {
		CvqualifierseqContext _localctx = new CvqualifierseqContext(_ctx, getState());
		enterRule(_localctx, 246, RULE_cvqualifierseq);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1469); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(1468);
					cvQualifier();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1471); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,176,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CvQualifierContext extends org.example.antlr.common.context.ExtendContext {
		public TerminalNode Const() { return getToken(CPPParser.Const, 0); }
		public TerminalNode Volatile() { return getToken(CPPParser.Volatile, 0); }
		public CvQualifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cvQualifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).enterCvQualifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).exitCvQualifier(this);
		}
	}

	public final CvQualifierContext cvQualifier() throws RecognitionException {
		CvQualifierContext _localctx = new CvQualifierContext(_ctx, getState());
		enterRule(_localctx, 248, RULE_cvQualifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1473);
			_la = _input.LA(1);
			if ( !(_la==Const || _la==Volatile) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RefqualifierContext extends org.example.antlr.common.context.ExtendContext {
		public TerminalNode And() { return getToken(CPPParser.And, 0); }
		public TerminalNode AndAnd() { return getToken(CPPParser.AndAnd, 0); }
		public RefqualifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_refqualifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).enterRefqualifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).exitRefqualifier(this);
		}
	}

	public final RefqualifierContext refqualifier() throws RecognitionException {
		RefqualifierContext _localctx = new RefqualifierContext(_ctx, getState());
		enterRule(_localctx, 250, RULE_refqualifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1475);
			_la = _input.LA(1);
			if ( !(_la==And || _la==AndAnd) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclaratoridContext extends org.example.antlr.common.context.ExtendContext {
		public IdExpressionContext idExpression() {
			return getRuleContext(IdExpressionContext.class,0);
		}
		public TerminalNode Ellipsis() { return getToken(CPPParser.Ellipsis, 0); }
		public DeclaratoridContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaratorid; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).enterDeclaratorid(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).exitDeclaratorid(this);
		}
	}

	public final DeclaratoridContext declaratorid() throws RecognitionException {
		DeclaratoridContext _localctx = new DeclaratoridContext(_ctx, getState());
		enterRule(_localctx, 252, RULE_declaratorid);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1478);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Ellipsis) {
				{
				setState(1477);
				match(Ellipsis);
				}
			}

			setState(1480);
			idExpression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TheTypeIdContext extends org.example.antlr.common.context.ExtendContext {
		public TypeSpecifierSeqContext typeSpecifierSeq() {
			return getRuleContext(TypeSpecifierSeqContext.class,0);
		}
		public AbstractDeclaratorContext abstractDeclarator() {
			return getRuleContext(AbstractDeclaratorContext.class,0);
		}
		public TheTypeIdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_theTypeId; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).enterTheTypeId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).exitTheTypeId(this);
		}
	}

	public final TheTypeIdContext theTypeId() throws RecognitionException {
		TheTypeIdContext _localctx = new TheTypeIdContext(_ctx, getState());
		enterRule(_localctx, 254, RULE_theTypeId);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1482);
			typeSpecifierSeq();
			setState(1484);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,178,_ctx) ) {
			case 1:
				{
				setState(1483);
				abstractDeclarator();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AbstractDeclaratorContext extends org.example.antlr.common.context.ExtendContext {
		public PointerAbstractDeclaratorContext pointerAbstractDeclarator() {
			return getRuleContext(PointerAbstractDeclaratorContext.class,0);
		}
		public ParametersAndQualifiersContext parametersAndQualifiers() {
			return getRuleContext(ParametersAndQualifiersContext.class,0);
		}
		public TrailingReturnTypeContext trailingReturnType() {
			return getRuleContext(TrailingReturnTypeContext.class,0);
		}
		public NoPointerAbstractDeclaratorContext noPointerAbstractDeclarator() {
			return getRuleContext(NoPointerAbstractDeclaratorContext.class,0);
		}
		public AbstractPackDeclaratorContext abstractPackDeclarator() {
			return getRuleContext(AbstractPackDeclaratorContext.class,0);
		}
		public AbstractDeclaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_abstractDeclarator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).enterAbstractDeclarator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).exitAbstractDeclarator(this);
		}
	}

	public final AbstractDeclaratorContext abstractDeclarator() throws RecognitionException {
		AbstractDeclaratorContext _localctx = new AbstractDeclaratorContext(_ctx, getState());
		enterRule(_localctx, 256, RULE_abstractDeclarator);
		try {
			setState(1494);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,180,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1486);
				pointerAbstractDeclarator();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1488);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,179,_ctx) ) {
				case 1:
					{
					setState(1487);
					noPointerAbstractDeclarator();
					}
					break;
				}
				setState(1490);
				parametersAndQualifiers();
				setState(1491);
				trailingReturnType();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1493);
				abstractPackDeclarator();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PointerAbstractDeclaratorContext extends org.example.antlr.common.context.ExtendContext {
		public NoPointerAbstractDeclaratorContext noPointerAbstractDeclarator() {
			return getRuleContext(NoPointerAbstractDeclaratorContext.class,0);
		}
		public List<PointerOperatorContext> pointerOperator() {
			return getRuleContexts(PointerOperatorContext.class);
		}
		public PointerOperatorContext pointerOperator(int i) {
			return getRuleContext(PointerOperatorContext.class,i);
		}
		public PointerAbstractDeclaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pointerAbstractDeclarator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).enterPointerAbstractDeclarator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).exitPointerAbstractDeclarator(this);
		}
	}

	public final PointerAbstractDeclaratorContext pointerAbstractDeclarator() throws RecognitionException {
		PointerAbstractDeclaratorContext _localctx = new PointerAbstractDeclaratorContext(_ctx, getState());
		enterRule(_localctx, 258, RULE_pointerAbstractDeclarator);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1499);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,181,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1496);
					pointerOperator();
					}
					} 
				}
				setState(1501);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,181,_ctx);
			}
			setState(1504);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LeftParen:
				{
				setState(1502);
				noPointerAbstractDeclarator();
				}
				break;
			case Decltype:
			case Star:
			case And:
			case AndAnd:
			case Doublecolon:
			case Identifier:
				{
				setState(1503);
				pointerOperator();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NoPointerAbstractDeclaratorContext extends org.example.antlr.common.context.ExtendContext {
		public List<ParametersAndQualifiersContext> parametersAndQualifiers() {
			return getRuleContexts(ParametersAndQualifiersContext.class);
		}
		public ParametersAndQualifiersContext parametersAndQualifiers(int i) {
			return getRuleContext(ParametersAndQualifiersContext.class,i);
		}
		public TerminalNode LeftParen() { return getToken(CPPParser.LeftParen, 0); }
		public PointerAbstractDeclaratorContext pointerAbstractDeclarator() {
			return getRuleContext(PointerAbstractDeclaratorContext.class,0);
		}
		public TerminalNode RightParen() { return getToken(CPPParser.RightParen, 0); }
		public List<TerminalNode> LeftBracket() { return getTokens(CPPParser.LeftBracket); }
		public TerminalNode LeftBracket(int i) {
			return getToken(CPPParser.LeftBracket, i);
		}
		public List<TerminalNode> RightBracket() { return getTokens(CPPParser.RightBracket); }
		public TerminalNode RightBracket(int i) {
			return getToken(CPPParser.RightBracket, i);
		}
		public List<ConstantExpressionContext> constantExpression() {
			return getRuleContexts(ConstantExpressionContext.class);
		}
		public ConstantExpressionContext constantExpression(int i) {
			return getRuleContext(ConstantExpressionContext.class,i);
		}
		public List<AttributeSpecifierSeqContext> attributeSpecifierSeq() {
			return getRuleContexts(AttributeSpecifierSeqContext.class);
		}
		public AttributeSpecifierSeqContext attributeSpecifierSeq(int i) {
			return getRuleContext(AttributeSpecifierSeqContext.class,i);
		}
		public NoPointerAbstractDeclaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_noPointerAbstractDeclarator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).enterNoPointerAbstractDeclarator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).exitNoPointerAbstractDeclarator(this);
		}
	}

	public final NoPointerAbstractDeclaratorContext noPointerAbstractDeclarator() throws RecognitionException {
		NoPointerAbstractDeclaratorContext _localctx = new NoPointerAbstractDeclaratorContext(_ctx, getState());
		enterRule(_localctx, 260, RULE_noPointerAbstractDeclarator);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1511);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,183,_ctx) ) {
			case 1:
				{
				setState(1506);
				parametersAndQualifiers();
				}
				break;
			case 2:
				{
				setState(1507);
				match(LeftParen);
				setState(1508);
				pointerAbstractDeclarator();
				setState(1509);
				match(RightParen);
				}
				break;
			}
			setState(1524);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,187,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(1522);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case LeftParen:
						{
						setState(1513);
						parametersAndQualifiers();
						}
						break;
					case LeftBracket:
						{
						setState(1514);
						match(LeftBracket);
						setState(1516);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IntegerLiteral) | (1L << CharacterLiteral) | (1L << FloatingLiteral) | (1L << StringLiteral) | (1L << BooleanLiteral) | (1L << PointerLiteral) | (1L << UserDefinedLiteral) | (1L << Alignof) | (1L << Auto) | (1L << Bool) | (1L << Char) | (1L << Char16) | (1L << Char32) | (1L << Const_cast) | (1L << Decltype) | (1L << Delete) | (1L << Double) | (1L << Dynamic_cast) | (1L << Float) | (1L << Int) | (1L << Long) | (1L << New) | (1L << Noexcept) | (1L << Operator) | (1L << Reinterpret_cast) | (1L << Short) | (1L << Signed) | (1L << Sizeof))) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (Static_cast - 65)) | (1L << (This - 65)) | (1L << (Typeid_ - 65)) | (1L << (Typename_ - 65)) | (1L << (Unsigned - 65)) | (1L << (Void - 65)) | (1L << (Wchar - 65)) | (1L << (LeftParen - 65)) | (1L << (LeftBracket - 65)) | (1L << (Plus - 65)) | (1L << (Minus - 65)) | (1L << (Star - 65)) | (1L << (And - 65)) | (1L << (Or - 65)) | (1L << (Tilde - 65)) | (1L << (Not - 65)) | (1L << (PlusPlus - 65)) | (1L << (MinusMinus - 65)) | (1L << (Doublecolon - 65)))) != 0) || _la==Identifier) {
							{
							setState(1515);
							constantExpression();
							}
						}

						setState(1518);
						match(RightBracket);
						setState(1520);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,185,_ctx) ) {
						case 1:
							{
							setState(1519);
							attributeSpecifierSeq();
							}
							break;
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					} 
				}
				setState(1526);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,187,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AbstractPackDeclaratorContext extends org.example.antlr.common.context.ExtendContext {
		public NoPointerAbstractPackDeclaratorContext noPointerAbstractPackDeclarator() {
			return getRuleContext(NoPointerAbstractPackDeclaratorContext.class,0);
		}
		public List<PointerOperatorContext> pointerOperator() {
			return getRuleContexts(PointerOperatorContext.class);
		}
		public PointerOperatorContext pointerOperator(int i) {
			return getRuleContext(PointerOperatorContext.class,i);
		}
		public AbstractPackDeclaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_abstractPackDeclarator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).enterAbstractPackDeclarator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).exitAbstractPackDeclarator(this);
		}
	}

	public final AbstractPackDeclaratorContext abstractPackDeclarator() throws RecognitionException {
		AbstractPackDeclaratorContext _localctx = new AbstractPackDeclaratorContext(_ctx, getState());
		enterRule(_localctx, 262, RULE_abstractPackDeclarator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1530);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Decltype || ((((_la - 93)) & ~0x3f) == 0 && ((1L << (_la - 93)) & ((1L << (Star - 93)) | (1L << (And - 93)) | (1L << (AndAnd - 93)) | (1L << (Doublecolon - 93)) | (1L << (Identifier - 93)))) != 0)) {
				{
				{
				setState(1527);
				pointerOperator();
				}
				}
				setState(1532);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1533);
			noPointerAbstractPackDeclarator();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NoPointerAbstractPackDeclaratorContext extends org.example.antlr.common.context.ExtendContext {
		public TerminalNode Ellipsis() { return getToken(CPPParser.Ellipsis, 0); }
		public List<ParametersAndQualifiersContext> parametersAndQualifiers() {
			return getRuleContexts(ParametersAndQualifiersContext.class);
		}
		public ParametersAndQualifiersContext parametersAndQualifiers(int i) {
			return getRuleContext(ParametersAndQualifiersContext.class,i);
		}
		public List<TerminalNode> LeftBracket() { return getTokens(CPPParser.LeftBracket); }
		public TerminalNode LeftBracket(int i) {
			return getToken(CPPParser.LeftBracket, i);
		}
		public List<TerminalNode> RightBracket() { return getTokens(CPPParser.RightBracket); }
		public TerminalNode RightBracket(int i) {
			return getToken(CPPParser.RightBracket, i);
		}
		public List<ConstantExpressionContext> constantExpression() {
			return getRuleContexts(ConstantExpressionContext.class);
		}
		public ConstantExpressionContext constantExpression(int i) {
			return getRuleContext(ConstantExpressionContext.class,i);
		}
		public List<AttributeSpecifierSeqContext> attributeSpecifierSeq() {
			return getRuleContexts(AttributeSpecifierSeqContext.class);
		}
		public AttributeSpecifierSeqContext attributeSpecifierSeq(int i) {
			return getRuleContext(AttributeSpecifierSeqContext.class,i);
		}
		public NoPointerAbstractPackDeclaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_noPointerAbstractPackDeclarator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).enterNoPointerAbstractPackDeclarator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).exitNoPointerAbstractPackDeclarator(this);
		}
	}

	public final NoPointerAbstractPackDeclaratorContext noPointerAbstractPackDeclarator() throws RecognitionException {
		NoPointerAbstractPackDeclaratorContext _localctx = new NoPointerAbstractPackDeclaratorContext(_ctx, getState());
		enterRule(_localctx, 264, RULE_noPointerAbstractPackDeclarator);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1535);
			match(Ellipsis);
			setState(1547);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,192,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(1545);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case LeftParen:
						{
						setState(1536);
						parametersAndQualifiers();
						}
						break;
					case LeftBracket:
						{
						setState(1537);
						match(LeftBracket);
						setState(1539);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IntegerLiteral) | (1L << CharacterLiteral) | (1L << FloatingLiteral) | (1L << StringLiteral) | (1L << BooleanLiteral) | (1L << PointerLiteral) | (1L << UserDefinedLiteral) | (1L << Alignof) | (1L << Auto) | (1L << Bool) | (1L << Char) | (1L << Char16) | (1L << Char32) | (1L << Const_cast) | (1L << Decltype) | (1L << Delete) | (1L << Double) | (1L << Dynamic_cast) | (1L << Float) | (1L << Int) | (1L << Long) | (1L << New) | (1L << Noexcept) | (1L << Operator) | (1L << Reinterpret_cast) | (1L << Short) | (1L << Signed) | (1L << Sizeof))) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (Static_cast - 65)) | (1L << (This - 65)) | (1L << (Typeid_ - 65)) | (1L << (Typename_ - 65)) | (1L << (Unsigned - 65)) | (1L << (Void - 65)) | (1L << (Wchar - 65)) | (1L << (LeftParen - 65)) | (1L << (LeftBracket - 65)) | (1L << (Plus - 65)) | (1L << (Minus - 65)) | (1L << (Star - 65)) | (1L << (And - 65)) | (1L << (Or - 65)) | (1L << (Tilde - 65)) | (1L << (Not - 65)) | (1L << (PlusPlus - 65)) | (1L << (MinusMinus - 65)) | (1L << (Doublecolon - 65)))) != 0) || _la==Identifier) {
							{
							setState(1538);
							constantExpression();
							}
						}

						setState(1541);
						match(RightBracket);
						setState(1543);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,190,_ctx) ) {
						case 1:
							{
							setState(1542);
							attributeSpecifierSeq();
							}
							break;
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					} 
				}
				setState(1549);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,192,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParameterDeclarationClauseContext extends org.example.antlr.common.context.ExtendContext {
		public ParameterDeclarationListContext parameterDeclarationList() {
			return getRuleContext(ParameterDeclarationListContext.class,0);
		}
		public TerminalNode Ellipsis() { return getToken(CPPParser.Ellipsis, 0); }
		public TerminalNode Comma() { return getToken(CPPParser.Comma, 0); }
		public ParameterDeclarationClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameterDeclarationClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).enterParameterDeclarationClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).exitParameterDeclarationClause(this);
		}
	}

	public final ParameterDeclarationClauseContext parameterDeclarationClause() throws RecognitionException {
		ParameterDeclarationClauseContext _localctx = new ParameterDeclarationClauseContext(_ctx, getState());
		enterRule(_localctx, 266, RULE_parameterDeclarationClause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1550);
			parameterDeclarationList();
			setState(1555);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Comma || _la==Ellipsis) {
				{
				setState(1552);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Comma) {
					{
					setState(1551);
					match(Comma);
					}
				}

				setState(1554);
				match(Ellipsis);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParameterDeclarationListContext extends org.example.antlr.common.context.ExtendContext {
		public List<ParameterDeclarationContext> parameterDeclaration() {
			return getRuleContexts(ParameterDeclarationContext.class);
		}
		public ParameterDeclarationContext parameterDeclaration(int i) {
			return getRuleContext(ParameterDeclarationContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(CPPParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(CPPParser.Comma, i);
		}
		public ParameterDeclarationListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameterDeclarationList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).enterParameterDeclarationList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).exitParameterDeclarationList(this);
		}
	}

	public final ParameterDeclarationListContext parameterDeclarationList() throws RecognitionException {
		ParameterDeclarationListContext _localctx = new ParameterDeclarationListContext(_ctx, getState());
		enterRule(_localctx, 268, RULE_parameterDeclarationList);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1557);
			parameterDeclaration();
			setState(1562);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,195,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1558);
					match(Comma);
					setState(1559);
					parameterDeclaration();
					}
					} 
				}
				setState(1564);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,195,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParameterDeclarationContext extends org.example.antlr.common.context.ExtendContext {
		public DeclSpecifierSeqContext declSpecifierSeq() {
			return getRuleContext(DeclSpecifierSeqContext.class,0);
		}
		public DeclaratorContext declarator() {
			return getRuleContext(DeclaratorContext.class,0);
		}
		public AttributeSpecifierSeqContext attributeSpecifierSeq() {
			return getRuleContext(AttributeSpecifierSeqContext.class,0);
		}
		public TerminalNode Assign() { return getToken(CPPParser.Assign, 0); }
		public InitializerClauseContext initializerClause() {
			return getRuleContext(InitializerClauseContext.class,0);
		}
		public AbstractDeclaratorContext abstractDeclarator() {
			return getRuleContext(AbstractDeclaratorContext.class,0);
		}
		public ParameterDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameterDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).enterParameterDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).exitParameterDeclaration(this);
		}
	}

	public final ParameterDeclarationContext parameterDeclaration() throws RecognitionException {
		ParameterDeclarationContext _localctx = new ParameterDeclarationContext(_ctx, getState());
		enterRule(_localctx, 270, RULE_parameterDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1566);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Alignas || _la==LeftBracket) {
				{
				setState(1565);
				attributeSpecifierSeq();
				}
			}

			setState(1568);
			declSpecifierSeq();
			setState(1573);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,198,_ctx) ) {
			case 1:
				{
				setState(1569);
				declarator();
				}
				break;
			case 2:
				{
				setState(1571);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,197,_ctx) ) {
				case 1:
					{
					setState(1570);
					abstractDeclarator();
					}
					break;
				}
				}
				break;
			}
			setState(1577);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Assign) {
				{
				setState(1575);
				match(Assign);
				setState(1576);
				initializerClause();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionDefinitionContext extends org.example.antlr.common.context.ExtendContext {
		public DeclaratorContext declarator() {
			return getRuleContext(DeclaratorContext.class,0);
		}
		public FunctionBodyContext functionBody() {
			return getRuleContext(FunctionBodyContext.class,0);
		}
		public AttributeSpecifierSeqContext attributeSpecifierSeq() {
			return getRuleContext(AttributeSpecifierSeqContext.class,0);
		}
		public DeclSpecifierSeqContext declSpecifierSeq() {
			return getRuleContext(DeclSpecifierSeqContext.class,0);
		}
		public VirtualSpecifierSeqContext virtualSpecifierSeq() {
			return getRuleContext(VirtualSpecifierSeqContext.class,0);
		}
		public FunctionDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionDefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).enterFunctionDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).exitFunctionDefinition(this);
		}
	}

	public final FunctionDefinitionContext functionDefinition() throws RecognitionException {
		FunctionDefinitionContext _localctx = new FunctionDefinitionContext(_ctx, getState());
		enterRule(_localctx, 272, RULE_functionDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1580);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Alignas || _la==LeftBracket) {
				{
				setState(1579);
				attributeSpecifierSeq();
				}
			}

			setState(1583);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,201,_ctx) ) {
			case 1:
				{
				setState(1582);
				declSpecifierSeq();
				}
				break;
			}
			setState(1585);
			declarator();
			setState(1587);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Final || _la==Override) {
				{
				setState(1586);
				virtualSpecifierSeq();
				}
			}

			setState(1589);
			functionBody();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionBodyContext extends org.example.antlr.common.context.ExtendContext {
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public ConstructorInitializerContext constructorInitializer() {
			return getRuleContext(ConstructorInitializerContext.class,0);
		}
		public FunctionTryBlockContext functionTryBlock() {
			return getRuleContext(FunctionTryBlockContext.class,0);
		}
		public TerminalNode Assign() { return getToken(CPPParser.Assign, 0); }
		public TerminalNode Semi() { return getToken(CPPParser.Semi, 0); }
		public TerminalNode Default() { return getToken(CPPParser.Default, 0); }
		public TerminalNode Delete() { return getToken(CPPParser.Delete, 0); }
		public FunctionBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).enterFunctionBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).exitFunctionBody(this);
		}
	}

	public final FunctionBodyContext functionBody() throws RecognitionException {
		FunctionBodyContext _localctx = new FunctionBodyContext(_ctx, getState());
		enterRule(_localctx, 274, RULE_functionBody);
		int _la;
		try {
			setState(1599);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LeftBrace:
			case Colon:
				enterOuterAlt(_localctx, 1);
				{
				setState(1592);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Colon) {
					{
					setState(1591);
					constructorInitializer();
					}
				}

				setState(1594);
				block();
				}
				break;
			case Try:
				enterOuterAlt(_localctx, 2);
				{
				setState(1595);
				functionTryBlock();
				}
				break;
			case Assign:
				enterOuterAlt(_localctx, 3);
				{
				setState(1596);
				match(Assign);
				setState(1597);
				_la = _input.LA(1);
				if ( !(_la==Default || _la==Delete) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(1598);
				match(Semi);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InitializerContext extends org.example.antlr.common.context.ExtendContext {
		public BraceOrEqualInitializerContext braceOrEqualInitializer() {
			return getRuleContext(BraceOrEqualInitializerContext.class,0);
		}
		public TerminalNode LeftParen() { return getToken(CPPParser.LeftParen, 0); }
		public ExpressionListContext expressionList() {
			return getRuleContext(ExpressionListContext.class,0);
		}
		public TerminalNode RightParen() { return getToken(CPPParser.RightParen, 0); }
		public InitializerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_initializer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).enterInitializer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).exitInitializer(this);
		}
	}

	public final InitializerContext initializer() throws RecognitionException {
		InitializerContext _localctx = new InitializerContext(_ctx, getState());
		enterRule(_localctx, 276, RULE_initializer);
		try {
			setState(1606);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LeftBrace:
			case Assign:
				enterOuterAlt(_localctx, 1);
				{
				setState(1601);
				braceOrEqualInitializer();
				}
				break;
			case LeftParen:
				enterOuterAlt(_localctx, 2);
				{
				setState(1602);
				match(LeftParen);
				setState(1603);
				expressionList();
				setState(1604);
				match(RightParen);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BraceOrEqualInitializerContext extends org.example.antlr.common.context.ExtendContext {
		public TerminalNode Assign() { return getToken(CPPParser.Assign, 0); }
		public InitializerClauseContext initializerClause() {
			return getRuleContext(InitializerClauseContext.class,0);
		}
		public BracedInitListContext bracedInitList() {
			return getRuleContext(BracedInitListContext.class,0);
		}
		public BraceOrEqualInitializerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_braceOrEqualInitializer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).enterBraceOrEqualInitializer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).exitBraceOrEqualInitializer(this);
		}
	}

	public final BraceOrEqualInitializerContext braceOrEqualInitializer() throws RecognitionException {
		BraceOrEqualInitializerContext _localctx = new BraceOrEqualInitializerContext(_ctx, getState());
		enterRule(_localctx, 278, RULE_braceOrEqualInitializer);
		try {
			setState(1611);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Assign:
				enterOuterAlt(_localctx, 1);
				{
				setState(1608);
				match(Assign);
				setState(1609);
				initializerClause();
				}
				break;
			case LeftBrace:
				enterOuterAlt(_localctx, 2);
				{
				setState(1610);
				bracedInitList();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InitializerClauseContext extends org.example.antlr.common.context.ExtendContext {
		public AssignmentExpressionContext assignmentExpression() {
			return getRuleContext(AssignmentExpressionContext.class,0);
		}
		public BracedInitListContext bracedInitList() {
			return getRuleContext(BracedInitListContext.class,0);
		}
		public InitializerClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_initializerClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).enterInitializerClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).exitInitializerClause(this);
		}
	}

	public final InitializerClauseContext initializerClause() throws RecognitionException {
		InitializerClauseContext _localctx = new InitializerClauseContext(_ctx, getState());
		enterRule(_localctx, 280, RULE_initializerClause);
		try {
			setState(1615);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IntegerLiteral:
			case CharacterLiteral:
			case FloatingLiteral:
			case StringLiteral:
			case BooleanLiteral:
			case PointerLiteral:
			case UserDefinedLiteral:
			case Alignof:
			case Auto:
			case Bool:
			case Char:
			case Char16:
			case Char32:
			case Const_cast:
			case Decltype:
			case Delete:
			case Double:
			case Dynamic_cast:
			case Float:
			case Int:
			case Long:
			case New:
			case Noexcept:
			case Operator:
			case Reinterpret_cast:
			case Short:
			case Signed:
			case Sizeof:
			case Static_cast:
			case This:
			case Throw:
			case Typeid_:
			case Typename_:
			case Unsigned:
			case Void:
			case Wchar:
			case LeftParen:
			case LeftBracket:
			case Plus:
			case Minus:
			case Star:
			case And:
			case Or:
			case Tilde:
			case Not:
			case PlusPlus:
			case MinusMinus:
			case Doublecolon:
			case Identifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(1613);
				assignmentExpression();
				}
				break;
			case LeftBrace:
				enterOuterAlt(_localctx, 2);
				{
				setState(1614);
				bracedInitList();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InitializerListContext extends org.example.antlr.common.context.ExtendContext {
		public List<InitializerClauseContext> initializerClause() {
			return getRuleContexts(InitializerClauseContext.class);
		}
		public InitializerClauseContext initializerClause(int i) {
			return getRuleContext(InitializerClauseContext.class,i);
		}
		public List<TerminalNode> Ellipsis() { return getTokens(CPPParser.Ellipsis); }
		public TerminalNode Ellipsis(int i) {
			return getToken(CPPParser.Ellipsis, i);
		}
		public List<TerminalNode> Comma() { return getTokens(CPPParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(CPPParser.Comma, i);
		}
		public InitializerListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_initializerList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).enterInitializerList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).exitInitializerList(this);
		}
	}

	public final InitializerListContext initializerList() throws RecognitionException {
		InitializerListContext _localctx = new InitializerListContext(_ctx, getState());
		enterRule(_localctx, 282, RULE_initializerList);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1617);
			initializerClause();
			setState(1619);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Ellipsis) {
				{
				setState(1618);
				match(Ellipsis);
				}
			}

			setState(1628);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,210,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1621);
					match(Comma);
					setState(1622);
					initializerClause();
					setState(1624);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==Ellipsis) {
						{
						setState(1623);
						match(Ellipsis);
						}
					}

					}
					} 
				}
				setState(1630);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,210,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BracedInitListContext extends org.example.antlr.common.context.ExtendContext {
		public TerminalNode LeftBrace() { return getToken(CPPParser.LeftBrace, 0); }
		public TerminalNode RightBrace() { return getToken(CPPParser.RightBrace, 0); }
		public InitializerListContext initializerList() {
			return getRuleContext(InitializerListContext.class,0);
		}
		public TerminalNode Comma() { return getToken(CPPParser.Comma, 0); }
		public BracedInitListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bracedInitList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).enterBracedInitList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).exitBracedInitList(this);
		}
	}

	public final BracedInitListContext bracedInitList() throws RecognitionException {
		BracedInitListContext _localctx = new BracedInitListContext(_ctx, getState());
		enterRule(_localctx, 284, RULE_bracedInitList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1631);
			match(LeftBrace);
			setState(1636);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IntegerLiteral) | (1L << CharacterLiteral) | (1L << FloatingLiteral) | (1L << StringLiteral) | (1L << BooleanLiteral) | (1L << PointerLiteral) | (1L << UserDefinedLiteral) | (1L << Alignof) | (1L << Auto) | (1L << Bool) | (1L << Char) | (1L << Char16) | (1L << Char32) | (1L << Const_cast) | (1L << Decltype) | (1L << Delete) | (1L << Double) | (1L << Dynamic_cast) | (1L << Float) | (1L << Int) | (1L << Long) | (1L << New) | (1L << Noexcept) | (1L << Operator) | (1L << Reinterpret_cast) | (1L << Short) | (1L << Signed) | (1L << Sizeof))) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (Static_cast - 65)) | (1L << (This - 65)) | (1L << (Throw - 65)) | (1L << (Typeid_ - 65)) | (1L << (Typename_ - 65)) | (1L << (Unsigned - 65)) | (1L << (Void - 65)) | (1L << (Wchar - 65)) | (1L << (LeftParen - 65)) | (1L << (LeftBracket - 65)) | (1L << (LeftBrace - 65)) | (1L << (Plus - 65)) | (1L << (Minus - 65)) | (1L << (Star - 65)) | (1L << (And - 65)) | (1L << (Or - 65)) | (1L << (Tilde - 65)) | (1L << (Not - 65)) | (1L << (PlusPlus - 65)) | (1L << (MinusMinus - 65)) | (1L << (Doublecolon - 65)))) != 0) || _la==Identifier) {
				{
				setState(1632);
				initializerList();
				setState(1634);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Comma) {
					{
					setState(1633);
					match(Comma);
					}
				}

				}
			}

			setState(1638);
			match(RightBrace);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassNameContext extends org.example.antlr.common.context.ExtendContext {
		public TerminalNode Identifier() { return getToken(CPPParser.Identifier, 0); }
		public SimpleTemplateIdContext simpleTemplateId() {
			return getRuleContext(SimpleTemplateIdContext.class,0);
		}
		public ClassNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_className; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).enterClassName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).exitClassName(this);
		}
	}

	public final ClassNameContext className() throws RecognitionException {
		ClassNameContext _localctx = new ClassNameContext(_ctx, getState());
		enterRule(_localctx, 286, RULE_className);
		try {
			setState(1642);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,213,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1640);
				match(Identifier);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1641);
				simpleTemplateId();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassSpecifierContext extends org.example.antlr.common.context.ExtendContext {
		public ClassHeadContext classHead() {
			return getRuleContext(ClassHeadContext.class,0);
		}
		public TerminalNode LeftBrace() { return getToken(CPPParser.LeftBrace, 0); }
		public TerminalNode RightBrace() { return getToken(CPPParser.RightBrace, 0); }
		public MemberSpecificationContext memberSpecification() {
			return getRuleContext(MemberSpecificationContext.class,0);
		}
		public ClassSpecifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classSpecifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).enterClassSpecifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).exitClassSpecifier(this);
		}
	}

	public final ClassSpecifierContext classSpecifier() throws RecognitionException {
		ClassSpecifierContext _localctx = new ClassSpecifierContext(_ctx, getState());
		enterRule(_localctx, 288, RULE_classSpecifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1644);
			classHead();
			setState(1645);
			match(LeftBrace);
			setState(1647);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 10)) & ~0x3f) == 0 && ((1L << (_la - 10)) & ((1L << (Alignas - 10)) | (1L << (Auto - 10)) | (1L << (Bool - 10)) | (1L << (Char - 10)) | (1L << (Char16 - 10)) | (1L << (Char32 - 10)) | (1L << (Class - 10)) | (1L << (Const - 10)) | (1L << (Constexpr - 10)) | (1L << (Decltype - 10)) | (1L << (Double - 10)) | (1L << (Enum - 10)) | (1L << (Explicit - 10)) | (1L << (Extern - 10)) | (1L << (Float - 10)) | (1L << (Friend - 10)) | (1L << (Inline - 10)) | (1L << (Int - 10)) | (1L << (Long - 10)) | (1L << (Mutable - 10)) | (1L << (Operator - 10)) | (1L << (Private - 10)) | (1L << (Protected - 10)) | (1L << (Public - 10)) | (1L << (Register - 10)) | (1L << (Short - 10)) | (1L << (Signed - 10)) | (1L << (Static - 10)) | (1L << (Static_assert - 10)) | (1L << (Struct - 10)) | (1L << (Template - 10)) | (1L << (Thread_local - 10)))) != 0) || ((((_la - 74)) & ~0x3f) == 0 && ((1L << (_la - 74)) & ((1L << (Typedef - 74)) | (1L << (Typename_ - 74)) | (1L << (Union - 74)) | (1L << (Unsigned - 74)) | (1L << (Using - 74)) | (1L << (Virtual - 74)) | (1L << (Void - 74)) | (1L << (Volatile - 74)) | (1L << (Wchar - 74)) | (1L << (LeftParen - 74)) | (1L << (LeftBracket - 74)) | (1L << (Star - 74)) | (1L << (And - 74)) | (1L << (Tilde - 74)) | (1L << (AndAnd - 74)) | (1L << (Colon - 74)) | (1L << (Doublecolon - 74)) | (1L << (Semi - 74)) | (1L << (Ellipsis - 74)) | (1L << (Identifier - 74)))) != 0)) {
				{
				setState(1646);
				memberSpecification();
				}
			}

			setState(1649);
			match(RightBrace);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassHeadContext extends org.example.antlr.common.context.ExtendContext {
		public ClassKeyContext classKey() {
			return getRuleContext(ClassKeyContext.class,0);
		}
		public AttributeSpecifierSeqContext attributeSpecifierSeq() {
			return getRuleContext(AttributeSpecifierSeqContext.class,0);
		}
		public ClassHeadNameContext classHeadName() {
			return getRuleContext(ClassHeadNameContext.class,0);
		}
		public BaseClauseContext baseClause() {
			return getRuleContext(BaseClauseContext.class,0);
		}
		public ClassVirtSpecifierContext classVirtSpecifier() {
			return getRuleContext(ClassVirtSpecifierContext.class,0);
		}
		public TerminalNode Union() { return getToken(CPPParser.Union, 0); }
		public ClassHeadContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classHead; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).enterClassHead(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).exitClassHead(this);
		}
	}

	public final ClassHeadContext classHead() throws RecognitionException {
		ClassHeadContext _localctx = new ClassHeadContext(_ctx, getState());
		enterRule(_localctx, 290, RULE_classHead);
		int _la;
		try {
			setState(1674);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Class:
			case Struct:
				enterOuterAlt(_localctx, 1);
				{
				setState(1651);
				classKey();
				setState(1653);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Alignas || _la==LeftBracket) {
					{
					setState(1652);
					attributeSpecifierSeq();
					}
				}

				setState(1659);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Decltype || _la==Doublecolon || _la==Identifier) {
					{
					setState(1655);
					classHeadName();
					setState(1657);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==Final) {
						{
						setState(1656);
						classVirtSpecifier();
						}
					}

					}
				}

				setState(1662);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Colon) {
					{
					setState(1661);
					baseClause();
					}
				}

				}
				break;
			case Union:
				enterOuterAlt(_localctx, 2);
				{
				setState(1664);
				match(Union);
				setState(1666);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Alignas || _la==LeftBracket) {
					{
					setState(1665);
					attributeSpecifierSeq();
					}
				}

				setState(1672);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Decltype || _la==Doublecolon || _la==Identifier) {
					{
					setState(1668);
					classHeadName();
					setState(1670);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==Final) {
						{
						setState(1669);
						classVirtSpecifier();
						}
					}

					}
				}

				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassHeadNameContext extends org.example.antlr.common.context.ExtendContext {
		public ClassNameContext className() {
			return getRuleContext(ClassNameContext.class,0);
		}
		public NestedNameSpecifierContext nestedNameSpecifier() {
			return getRuleContext(NestedNameSpecifierContext.class,0);
		}
		public ClassHeadNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classHeadName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).enterClassHeadName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).exitClassHeadName(this);
		}
	}

	public final ClassHeadNameContext classHeadName() throws RecognitionException {
		ClassHeadNameContext _localctx = new ClassHeadNameContext(_ctx, getState());
		enterRule(_localctx, 292, RULE_classHeadName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1677);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,223,_ctx) ) {
			case 1:
				{
				setState(1676);
				nestedNameSpecifier(0);
				}
				break;
			}
			setState(1679);
			className();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassVirtSpecifierContext extends org.example.antlr.common.context.ExtendContext {
		public TerminalNode Final() { return getToken(CPPParser.Final, 0); }
		public ClassVirtSpecifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classVirtSpecifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).enterClassVirtSpecifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).exitClassVirtSpecifier(this);
		}
	}

	public final ClassVirtSpecifierContext classVirtSpecifier() throws RecognitionException {
		ClassVirtSpecifierContext _localctx = new ClassVirtSpecifierContext(_ctx, getState());
		enterRule(_localctx, 294, RULE_classVirtSpecifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1681);
			match(Final);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassKeyContext extends org.example.antlr.common.context.ExtendContext {
		public TerminalNode Class() { return getToken(CPPParser.Class, 0); }
		public TerminalNode Struct() { return getToken(CPPParser.Struct, 0); }
		public ClassKeyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classKey; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).enterClassKey(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).exitClassKey(this);
		}
	}

	public final ClassKeyContext classKey() throws RecognitionException {
		ClassKeyContext _localctx = new ClassKeyContext(_ctx, getState());
		enterRule(_localctx, 296, RULE_classKey);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1683);
			_la = _input.LA(1);
			if ( !(_la==Class || _la==Struct) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MemberSpecificationContext extends org.example.antlr.common.context.ExtendContext {
		public List<MemberdeclarationContext> memberdeclaration() {
			return getRuleContexts(MemberdeclarationContext.class);
		}
		public MemberdeclarationContext memberdeclaration(int i) {
			return getRuleContext(MemberdeclarationContext.class,i);
		}
		public List<AccessSpecifierContext> accessSpecifier() {
			return getRuleContexts(AccessSpecifierContext.class);
		}
		public AccessSpecifierContext accessSpecifier(int i) {
			return getRuleContext(AccessSpecifierContext.class,i);
		}
		public List<TerminalNode> Colon() { return getTokens(CPPParser.Colon); }
		public TerminalNode Colon(int i) {
			return getToken(CPPParser.Colon, i);
		}
		public MemberSpecificationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_memberSpecification; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).enterMemberSpecification(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).exitMemberSpecification(this);
		}
	}

	public final MemberSpecificationContext memberSpecification() throws RecognitionException {
		MemberSpecificationContext _localctx = new MemberSpecificationContext(_ctx, getState());
		enterRule(_localctx, 298, RULE_memberSpecification);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1689); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(1689);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case Alignas:
				case Auto:
				case Bool:
				case Char:
				case Char16:
				case Char32:
				case Class:
				case Const:
				case Constexpr:
				case Decltype:
				case Double:
				case Enum:
				case Explicit:
				case Extern:
				case Float:
				case Friend:
				case Inline:
				case Int:
				case Long:
				case Mutable:
				case Operator:
				case Register:
				case Short:
				case Signed:
				case Static:
				case Static_assert:
				case Struct:
				case Template:
				case Thread_local:
				case Typedef:
				case Typename_:
				case Union:
				case Unsigned:
				case Using:
				case Virtual:
				case Void:
				case Volatile:
				case Wchar:
				case LeftParen:
				case LeftBracket:
				case Star:
				case And:
				case Tilde:
				case AndAnd:
				case Colon:
				case Doublecolon:
				case Semi:
				case Ellipsis:
				case Identifier:
					{
					setState(1685);
					memberdeclaration();
					}
					break;
				case Private:
				case Protected:
				case Public:
					{
					setState(1686);
					accessSpecifier();
					setState(1687);
					match(Colon);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(1691); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( ((((_la - 10)) & ~0x3f) == 0 && ((1L << (_la - 10)) & ((1L << (Alignas - 10)) | (1L << (Auto - 10)) | (1L << (Bool - 10)) | (1L << (Char - 10)) | (1L << (Char16 - 10)) | (1L << (Char32 - 10)) | (1L << (Class - 10)) | (1L << (Const - 10)) | (1L << (Constexpr - 10)) | (1L << (Decltype - 10)) | (1L << (Double - 10)) | (1L << (Enum - 10)) | (1L << (Explicit - 10)) | (1L << (Extern - 10)) | (1L << (Float - 10)) | (1L << (Friend - 10)) | (1L << (Inline - 10)) | (1L << (Int - 10)) | (1L << (Long - 10)) | (1L << (Mutable - 10)) | (1L << (Operator - 10)) | (1L << (Private - 10)) | (1L << (Protected - 10)) | (1L << (Public - 10)) | (1L << (Register - 10)) | (1L << (Short - 10)) | (1L << (Signed - 10)) | (1L << (Static - 10)) | (1L << (Static_assert - 10)) | (1L << (Struct - 10)) | (1L << (Template - 10)) | (1L << (Thread_local - 10)))) != 0) || ((((_la - 74)) & ~0x3f) == 0 && ((1L << (_la - 74)) & ((1L << (Typedef - 74)) | (1L << (Typename_ - 74)) | (1L << (Union - 74)) | (1L << (Unsigned - 74)) | (1L << (Using - 74)) | (1L << (Virtual - 74)) | (1L << (Void - 74)) | (1L << (Volatile - 74)) | (1L << (Wchar - 74)) | (1L << (LeftParen - 74)) | (1L << (LeftBracket - 74)) | (1L << (Star - 74)) | (1L << (And - 74)) | (1L << (Tilde - 74)) | (1L << (AndAnd - 74)) | (1L << (Colon - 74)) | (1L << (Doublecolon - 74)) | (1L << (Semi - 74)) | (1L << (Ellipsis - 74)) | (1L << (Identifier - 74)))) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MemberdeclarationContext extends org.example.antlr.common.context.ExtendContext {
		public TerminalNode Semi() { return getToken(CPPParser.Semi, 0); }
		public AttributeSpecifierSeqContext attributeSpecifierSeq() {
			return getRuleContext(AttributeSpecifierSeqContext.class,0);
		}
		public DeclSpecifierSeqContext declSpecifierSeq() {
			return getRuleContext(DeclSpecifierSeqContext.class,0);
		}
		public MemberDeclaratorListContext memberDeclaratorList() {
			return getRuleContext(MemberDeclaratorListContext.class,0);
		}
		public FunctionDefinitionContext functionDefinition() {
			return getRuleContext(FunctionDefinitionContext.class,0);
		}
		public UsingDeclarationContext usingDeclaration() {
			return getRuleContext(UsingDeclarationContext.class,0);
		}
		public StaticAssertDeclarationContext staticAssertDeclaration() {
			return getRuleContext(StaticAssertDeclarationContext.class,0);
		}
		public TemplateDeclarationContext templateDeclaration() {
			return getRuleContext(TemplateDeclarationContext.class,0);
		}
		public AliasDeclarationContext aliasDeclaration() {
			return getRuleContext(AliasDeclarationContext.class,0);
		}
		public EmptyDeclaration_Context emptyDeclaration_() {
			return getRuleContext(EmptyDeclaration_Context.class,0);
		}
		public MemberdeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_memberdeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).enterMemberdeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).exitMemberdeclaration(this);
		}
	}

	public final MemberdeclarationContext memberdeclaration() throws RecognitionException {
		MemberdeclarationContext _localctx = new MemberdeclarationContext(_ctx, getState());
		enterRule(_localctx, 300, RULE_memberdeclaration);
		int _la;
		try {
			setState(1709);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,229,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1694);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,226,_ctx) ) {
				case 1:
					{
					setState(1693);
					attributeSpecifierSeq();
					}
					break;
				}
				setState(1697);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,227,_ctx) ) {
				case 1:
					{
					setState(1696);
					declSpecifierSeq();
					}
					break;
				}
				setState(1700);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Alignas) | (1L << Decltype) | (1L << Operator))) != 0) || ((((_la - 85)) & ~0x3f) == 0 && ((1L << (_la - 85)) & ((1L << (LeftParen - 85)) | (1L << (LeftBracket - 85)) | (1L << (Star - 85)) | (1L << (And - 85)) | (1L << (Tilde - 85)) | (1L << (AndAnd - 85)) | (1L << (Colon - 85)) | (1L << (Doublecolon - 85)) | (1L << (Ellipsis - 85)) | (1L << (Identifier - 85)))) != 0)) {
					{
					setState(1699);
					memberDeclaratorList();
					}
				}

				setState(1702);
				match(Semi);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1703);
				functionDefinition();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1704);
				usingDeclaration();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1705);
				staticAssertDeclaration();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(1706);
				templateDeclaration();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(1707);
				aliasDeclaration();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(1708);
				emptyDeclaration_();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MemberDeclaratorListContext extends org.example.antlr.common.context.ExtendContext {
		public List<MemberDeclaratorContext> memberDeclarator() {
			return getRuleContexts(MemberDeclaratorContext.class);
		}
		public MemberDeclaratorContext memberDeclarator(int i) {
			return getRuleContext(MemberDeclaratorContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(CPPParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(CPPParser.Comma, i);
		}
		public MemberDeclaratorListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_memberDeclaratorList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).enterMemberDeclaratorList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).exitMemberDeclaratorList(this);
		}
	}

	public final MemberDeclaratorListContext memberDeclaratorList() throws RecognitionException {
		MemberDeclaratorListContext _localctx = new MemberDeclaratorListContext(_ctx, getState());
		enterRule(_localctx, 302, RULE_memberDeclaratorList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1711);
			memberDeclarator();
			setState(1716);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(1712);
				match(Comma);
				setState(1713);
				memberDeclarator();
				}
				}
				setState(1718);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MemberDeclaratorContext extends org.example.antlr.common.context.ExtendContext {
		public DeclaratorContext declarator() {
			return getRuleContext(DeclaratorContext.class,0);
		}
		public VirtualSpecifierSeqContext virtualSpecifierSeq() {
			return getRuleContext(VirtualSpecifierSeqContext.class,0);
		}
		public PureSpecifierContext pureSpecifier() {
			return getRuleContext(PureSpecifierContext.class,0);
		}
		public BraceOrEqualInitializerContext braceOrEqualInitializer() {
			return getRuleContext(BraceOrEqualInitializerContext.class,0);
		}
		public TerminalNode Colon() { return getToken(CPPParser.Colon, 0); }
		public ConstantExpressionContext constantExpression() {
			return getRuleContext(ConstantExpressionContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(CPPParser.Identifier, 0); }
		public AttributeSpecifierSeqContext attributeSpecifierSeq() {
			return getRuleContext(AttributeSpecifierSeqContext.class,0);
		}
		public MemberDeclaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_memberDeclarator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).enterMemberDeclarator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).exitMemberDeclarator(this);
		}
	}

	public final MemberDeclaratorContext memberDeclarator() throws RecognitionException {
		MemberDeclaratorContext _localctx = new MemberDeclaratorContext(_ctx, getState());
		enterRule(_localctx, 304, RULE_memberDeclarator);
		int _la;
		try {
			setState(1739);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,234,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1719);
				declarator();
				setState(1728);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,231,_ctx) ) {
				case 1:
					{
					setState(1720);
					virtualSpecifierSeq();
					}
					break;
				case 2:
					{
					setState(1721);
					if (!( this.IsPureSpecifierAllowed() )) throw new FailedPredicateException(this, " this.IsPureSpecifierAllowed() ");
					setState(1722);
					pureSpecifier();
					}
					break;
				case 3:
					{
					setState(1723);
					if (!( this.IsPureSpecifierAllowed() )) throw new FailedPredicateException(this, " this.IsPureSpecifierAllowed() ");
					setState(1724);
					virtualSpecifierSeq();
					setState(1725);
					pureSpecifier();
					}
					break;
				case 4:
					{
					setState(1727);
					braceOrEqualInitializer();
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1730);
				declarator();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1732);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Identifier) {
					{
					setState(1731);
					match(Identifier);
					}
				}

				setState(1735);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Alignas || _la==LeftBracket) {
					{
					setState(1734);
					attributeSpecifierSeq();
					}
				}

				setState(1737);
				match(Colon);
				setState(1738);
				constantExpression();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VirtualSpecifierSeqContext extends org.example.antlr.common.context.ExtendContext {
		public List<VirtualSpecifierContext> virtualSpecifier() {
			return getRuleContexts(VirtualSpecifierContext.class);
		}
		public VirtualSpecifierContext virtualSpecifier(int i) {
			return getRuleContext(VirtualSpecifierContext.class,i);
		}
		public VirtualSpecifierSeqContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_virtualSpecifierSeq; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).enterVirtualSpecifierSeq(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).exitVirtualSpecifierSeq(this);
		}
	}

	public final VirtualSpecifierSeqContext virtualSpecifierSeq() throws RecognitionException {
		VirtualSpecifierSeqContext _localctx = new VirtualSpecifierSeqContext(_ctx, getState());
		enterRule(_localctx, 306, RULE_virtualSpecifierSeq);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1742); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(1741);
				virtualSpecifier();
				}
				}
				setState(1744); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==Final || _la==Override );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VirtualSpecifierContext extends org.example.antlr.common.context.ExtendContext {
		public TerminalNode Override() { return getToken(CPPParser.Override, 0); }
		public TerminalNode Final() { return getToken(CPPParser.Final, 0); }
		public VirtualSpecifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_virtualSpecifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).enterVirtualSpecifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).exitVirtualSpecifier(this);
		}
	}

	public final VirtualSpecifierContext virtualSpecifier() throws RecognitionException {
		VirtualSpecifierContext _localctx = new VirtualSpecifierContext(_ctx, getState());
		enterRule(_localctx, 308, RULE_virtualSpecifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1746);
			_la = _input.LA(1);
			if ( !(_la==Final || _la==Override) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PureSpecifierContext extends org.example.antlr.common.context.ExtendContext {
		public TerminalNode Assign() { return getToken(CPPParser.Assign, 0); }
		public TerminalNode IntegerLiteral() { return getToken(CPPParser.IntegerLiteral, 0); }
		public PureSpecifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pureSpecifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).enterPureSpecifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).exitPureSpecifier(this);
		}
	}

	public final PureSpecifierContext pureSpecifier() throws RecognitionException {
		PureSpecifierContext _localctx = new PureSpecifierContext(_ctx, getState());
		enterRule(_localctx, 310, RULE_pureSpecifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1748);
			match(Assign);
			setState(1749);
			match(IntegerLiteral);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BaseClauseContext extends org.example.antlr.common.context.ExtendContext {
		public TerminalNode Colon() { return getToken(CPPParser.Colon, 0); }
		public BaseSpecifierListContext baseSpecifierList() {
			return getRuleContext(BaseSpecifierListContext.class,0);
		}
		public BaseClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_baseClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).enterBaseClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).exitBaseClause(this);
		}
	}

	public final BaseClauseContext baseClause() throws RecognitionException {
		BaseClauseContext _localctx = new BaseClauseContext(_ctx, getState());
		enterRule(_localctx, 312, RULE_baseClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1751);
			match(Colon);
			setState(1752);
			baseSpecifierList();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BaseSpecifierListContext extends org.example.antlr.common.context.ExtendContext {
		public List<BaseSpecifierContext> baseSpecifier() {
			return getRuleContexts(BaseSpecifierContext.class);
		}
		public BaseSpecifierContext baseSpecifier(int i) {
			return getRuleContext(BaseSpecifierContext.class,i);
		}
		public List<TerminalNode> Ellipsis() { return getTokens(CPPParser.Ellipsis); }
		public TerminalNode Ellipsis(int i) {
			return getToken(CPPParser.Ellipsis, i);
		}
		public List<TerminalNode> Comma() { return getTokens(CPPParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(CPPParser.Comma, i);
		}
		public BaseSpecifierListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_baseSpecifierList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).enterBaseSpecifierList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).exitBaseSpecifierList(this);
		}
	}

	public final BaseSpecifierListContext baseSpecifierList() throws RecognitionException {
		BaseSpecifierListContext _localctx = new BaseSpecifierListContext(_ctx, getState());
		enterRule(_localctx, 314, RULE_baseSpecifierList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1754);
			baseSpecifier();
			setState(1756);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Ellipsis) {
				{
				setState(1755);
				match(Ellipsis);
				}
			}

			setState(1765);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(1758);
				match(Comma);
				setState(1759);
				baseSpecifier();
				setState(1761);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Ellipsis) {
					{
					setState(1760);
					match(Ellipsis);
					}
				}

				}
				}
				setState(1767);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BaseSpecifierContext extends org.example.antlr.common.context.ExtendContext {
		public BaseTypeSpecifierContext baseTypeSpecifier() {
			return getRuleContext(BaseTypeSpecifierContext.class,0);
		}
		public TerminalNode Virtual() { return getToken(CPPParser.Virtual, 0); }
		public AccessSpecifierContext accessSpecifier() {
			return getRuleContext(AccessSpecifierContext.class,0);
		}
		public AttributeSpecifierSeqContext attributeSpecifierSeq() {
			return getRuleContext(AttributeSpecifierSeqContext.class,0);
		}
		public BaseSpecifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_baseSpecifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).enterBaseSpecifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).exitBaseSpecifier(this);
		}
	}

	public final BaseSpecifierContext baseSpecifier() throws RecognitionException {
		BaseSpecifierContext _localctx = new BaseSpecifierContext(_ctx, getState());
		enterRule(_localctx, 316, RULE_baseSpecifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1769);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Alignas || _la==LeftBracket) {
				{
				setState(1768);
				attributeSpecifierSeq();
				}
			}

			setState(1783);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Decltype:
			case Doublecolon:
			case Identifier:
				{
				setState(1771);
				baseTypeSpecifier();
				}
				break;
			case Virtual:
				{
				setState(1772);
				match(Virtual);
				setState(1774);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Private) | (1L << Protected) | (1L << Public))) != 0)) {
					{
					setState(1773);
					accessSpecifier();
					}
				}

				setState(1776);
				baseTypeSpecifier();
				}
				break;
			case Private:
			case Protected:
			case Public:
				{
				setState(1777);
				accessSpecifier();
				setState(1779);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Virtual) {
					{
					setState(1778);
					match(Virtual);
					}
				}

				setState(1781);
				baseTypeSpecifier();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassOrDeclTypeContext extends org.example.antlr.common.context.ExtendContext {
		public ClassNameContext className() {
			return getRuleContext(ClassNameContext.class,0);
		}
		public NestedNameSpecifierContext nestedNameSpecifier() {
			return getRuleContext(NestedNameSpecifierContext.class,0);
		}
		public DecltypeSpecifierContext decltypeSpecifier() {
			return getRuleContext(DecltypeSpecifierContext.class,0);
		}
		public ClassOrDeclTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classOrDeclType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).enterClassOrDeclType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).exitClassOrDeclType(this);
		}
	}

	public final ClassOrDeclTypeContext classOrDeclType() throws RecognitionException {
		ClassOrDeclTypeContext _localctx = new ClassOrDeclTypeContext(_ctx, getState());
		enterRule(_localctx, 318, RULE_classOrDeclType);
		try {
			setState(1790);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,244,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1786);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,243,_ctx) ) {
				case 1:
					{
					setState(1785);
					nestedNameSpecifier(0);
					}
					break;
				}
				setState(1788);
				className();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1789);
				decltypeSpecifier();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BaseTypeSpecifierContext extends org.example.antlr.common.context.ExtendContext {
		public ClassOrDeclTypeContext classOrDeclType() {
			return getRuleContext(ClassOrDeclTypeContext.class,0);
		}
		public BaseTypeSpecifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_baseTypeSpecifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).enterBaseTypeSpecifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).exitBaseTypeSpecifier(this);
		}
	}

	public final BaseTypeSpecifierContext baseTypeSpecifier() throws RecognitionException {
		BaseTypeSpecifierContext _localctx = new BaseTypeSpecifierContext(_ctx, getState());
		enterRule(_localctx, 320, RULE_baseTypeSpecifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1792);
			classOrDeclType();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AccessSpecifierContext extends org.example.antlr.common.context.ExtendContext {
		public TerminalNode Private() { return getToken(CPPParser.Private, 0); }
		public TerminalNode Protected() { return getToken(CPPParser.Protected, 0); }
		public TerminalNode Public() { return getToken(CPPParser.Public, 0); }
		public AccessSpecifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_accessSpecifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).enterAccessSpecifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).exitAccessSpecifier(this);
		}
	}

	public final AccessSpecifierContext accessSpecifier() throws RecognitionException {
		AccessSpecifierContext _localctx = new AccessSpecifierContext(_ctx, getState());
		enterRule(_localctx, 322, RULE_accessSpecifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1794);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Private) | (1L << Protected) | (1L << Public))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConversionFunctionIdContext extends org.example.antlr.common.context.ExtendContext {
		public TerminalNode Operator() { return getToken(CPPParser.Operator, 0); }
		public ConversionTypeIdContext conversionTypeId() {
			return getRuleContext(ConversionTypeIdContext.class,0);
		}
		public ConversionFunctionIdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conversionFunctionId; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).enterConversionFunctionId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).exitConversionFunctionId(this);
		}
	}

	public final ConversionFunctionIdContext conversionFunctionId() throws RecognitionException {
		ConversionFunctionIdContext _localctx = new ConversionFunctionIdContext(_ctx, getState());
		enterRule(_localctx, 324, RULE_conversionFunctionId);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1796);
			match(Operator);
			setState(1797);
			conversionTypeId();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConversionTypeIdContext extends org.example.antlr.common.context.ExtendContext {
		public TypeSpecifierSeqContext typeSpecifierSeq() {
			return getRuleContext(TypeSpecifierSeqContext.class,0);
		}
		public ConversionDeclaratorContext conversionDeclarator() {
			return getRuleContext(ConversionDeclaratorContext.class,0);
		}
		public ConversionTypeIdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conversionTypeId; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).enterConversionTypeId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).exitConversionTypeId(this);
		}
	}

	public final ConversionTypeIdContext conversionTypeId() throws RecognitionException {
		ConversionTypeIdContext _localctx = new ConversionTypeIdContext(_ctx, getState());
		enterRule(_localctx, 326, RULE_conversionTypeId);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1799);
			typeSpecifierSeq();
			setState(1801);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,245,_ctx) ) {
			case 1:
				{
				setState(1800);
				conversionDeclarator();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConversionDeclaratorContext extends org.example.antlr.common.context.ExtendContext {
		public PointerOperatorContext pointerOperator() {
			return getRuleContext(PointerOperatorContext.class,0);
		}
		public ConversionDeclaratorContext conversionDeclarator() {
			return getRuleContext(ConversionDeclaratorContext.class,0);
		}
		public ConversionDeclaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conversionDeclarator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).enterConversionDeclarator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).exitConversionDeclarator(this);
		}
	}

	public final ConversionDeclaratorContext conversionDeclarator() throws RecognitionException {
		ConversionDeclaratorContext _localctx = new ConversionDeclaratorContext(_ctx, getState());
		enterRule(_localctx, 328, RULE_conversionDeclarator);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1803);
			pointerOperator();
			setState(1805);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,246,_ctx) ) {
			case 1:
				{
				setState(1804);
				conversionDeclarator();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstructorInitializerContext extends org.example.antlr.common.context.ExtendContext {
		public TerminalNode Colon() { return getToken(CPPParser.Colon, 0); }
		public MemInitializerListContext memInitializerList() {
			return getRuleContext(MemInitializerListContext.class,0);
		}
		public ConstructorInitializerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constructorInitializer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).enterConstructorInitializer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).exitConstructorInitializer(this);
		}
	}

	public final ConstructorInitializerContext constructorInitializer() throws RecognitionException {
		ConstructorInitializerContext _localctx = new ConstructorInitializerContext(_ctx, getState());
		enterRule(_localctx, 330, RULE_constructorInitializer);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1807);
			match(Colon);
			setState(1808);
			memInitializerList();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MemInitializerListContext extends org.example.antlr.common.context.ExtendContext {
		public List<MemInitializerContext> memInitializer() {
			return getRuleContexts(MemInitializerContext.class);
		}
		public MemInitializerContext memInitializer(int i) {
			return getRuleContext(MemInitializerContext.class,i);
		}
		public List<TerminalNode> Ellipsis() { return getTokens(CPPParser.Ellipsis); }
		public TerminalNode Ellipsis(int i) {
			return getToken(CPPParser.Ellipsis, i);
		}
		public List<TerminalNode> Comma() { return getTokens(CPPParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(CPPParser.Comma, i);
		}
		public MemInitializerListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_memInitializerList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).enterMemInitializerList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).exitMemInitializerList(this);
		}
	}

	public final MemInitializerListContext memInitializerList() throws RecognitionException {
		MemInitializerListContext _localctx = new MemInitializerListContext(_ctx, getState());
		enterRule(_localctx, 332, RULE_memInitializerList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1810);
			memInitializer();
			setState(1812);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Ellipsis) {
				{
				setState(1811);
				match(Ellipsis);
				}
			}

			setState(1821);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(1814);
				match(Comma);
				setState(1815);
				memInitializer();
				setState(1817);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Ellipsis) {
					{
					setState(1816);
					match(Ellipsis);
					}
				}

				}
				}
				setState(1823);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MemInitializerContext extends org.example.antlr.common.context.ExtendContext {
		public MeminitializeridContext meminitializerid() {
			return getRuleContext(MeminitializeridContext.class,0);
		}
		public TerminalNode LeftParen() { return getToken(CPPParser.LeftParen, 0); }
		public TerminalNode RightParen() { return getToken(CPPParser.RightParen, 0); }
		public BracedInitListContext bracedInitList() {
			return getRuleContext(BracedInitListContext.class,0);
		}
		public ExpressionListContext expressionList() {
			return getRuleContext(ExpressionListContext.class,0);
		}
		public MemInitializerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_memInitializer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).enterMemInitializer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).exitMemInitializer(this);
		}
	}

	public final MemInitializerContext memInitializer() throws RecognitionException {
		MemInitializerContext _localctx = new MemInitializerContext(_ctx, getState());
		enterRule(_localctx, 334, RULE_memInitializer);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1824);
			meminitializerid();
			setState(1831);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LeftParen:
				{
				setState(1825);
				match(LeftParen);
				setState(1827);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IntegerLiteral) | (1L << CharacterLiteral) | (1L << FloatingLiteral) | (1L << StringLiteral) | (1L << BooleanLiteral) | (1L << PointerLiteral) | (1L << UserDefinedLiteral) | (1L << Alignof) | (1L << Auto) | (1L << Bool) | (1L << Char) | (1L << Char16) | (1L << Char32) | (1L << Const_cast) | (1L << Decltype) | (1L << Delete) | (1L << Double) | (1L << Dynamic_cast) | (1L << Float) | (1L << Int) | (1L << Long) | (1L << New) | (1L << Noexcept) | (1L << Operator) | (1L << Reinterpret_cast) | (1L << Short) | (1L << Signed) | (1L << Sizeof))) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (Static_cast - 65)) | (1L << (This - 65)) | (1L << (Throw - 65)) | (1L << (Typeid_ - 65)) | (1L << (Typename_ - 65)) | (1L << (Unsigned - 65)) | (1L << (Void - 65)) | (1L << (Wchar - 65)) | (1L << (LeftParen - 65)) | (1L << (LeftBracket - 65)) | (1L << (LeftBrace - 65)) | (1L << (Plus - 65)) | (1L << (Minus - 65)) | (1L << (Star - 65)) | (1L << (And - 65)) | (1L << (Or - 65)) | (1L << (Tilde - 65)) | (1L << (Not - 65)) | (1L << (PlusPlus - 65)) | (1L << (MinusMinus - 65)) | (1L << (Doublecolon - 65)))) != 0) || _la==Identifier) {
					{
					setState(1826);
					expressionList();
					}
				}

				setState(1829);
				match(RightParen);
				}
				break;
			case LeftBrace:
				{
				setState(1830);
				bracedInitList();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MeminitializeridContext extends org.example.antlr.common.context.ExtendContext {
		public ClassOrDeclTypeContext classOrDeclType() {
			return getRuleContext(ClassOrDeclTypeContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(CPPParser.Identifier, 0); }
		public MeminitializeridContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_meminitializerid; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).enterMeminitializerid(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).exitMeminitializerid(this);
		}
	}

	public final MeminitializeridContext meminitializerid() throws RecognitionException {
		MeminitializeridContext _localctx = new MeminitializeridContext(_ctx, getState());
		enterRule(_localctx, 336, RULE_meminitializerid);
		try {
			setState(1835);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,252,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1833);
				classOrDeclType();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1834);
				match(Identifier);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OperatorFunctionIdContext extends org.example.antlr.common.context.ExtendContext {
		public TerminalNode Operator() { return getToken(CPPParser.Operator, 0); }
		public TheOperatorContext theOperator() {
			return getRuleContext(TheOperatorContext.class,0);
		}
		public OperatorFunctionIdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operatorFunctionId; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).enterOperatorFunctionId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).exitOperatorFunctionId(this);
		}
	}

	public final OperatorFunctionIdContext operatorFunctionId() throws RecognitionException {
		OperatorFunctionIdContext _localctx = new OperatorFunctionIdContext(_ctx, getState());
		enterRule(_localctx, 338, RULE_operatorFunctionId);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1837);
			match(Operator);
			setState(1838);
			theOperator();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LiteralOperatorIdContext extends org.example.antlr.common.context.ExtendContext {
		public TerminalNode Operator() { return getToken(CPPParser.Operator, 0); }
		public TerminalNode StringLiteral() { return getToken(CPPParser.StringLiteral, 0); }
		public TerminalNode Identifier() { return getToken(CPPParser.Identifier, 0); }
		public TerminalNode UserDefinedStringLiteral() { return getToken(CPPParser.UserDefinedStringLiteral, 0); }
		public LiteralOperatorIdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literalOperatorId; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).enterLiteralOperatorId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).exitLiteralOperatorId(this);
		}
	}

	public final LiteralOperatorIdContext literalOperatorId() throws RecognitionException {
		LiteralOperatorIdContext _localctx = new LiteralOperatorIdContext(_ctx, getState());
		enterRule(_localctx, 340, RULE_literalOperatorId);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1840);
			match(Operator);
			setState(1844);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case StringLiteral:
				{
				setState(1841);
				match(StringLiteral);
				setState(1842);
				match(Identifier);
				}
				break;
			case UserDefinedStringLiteral:
				{
				setState(1843);
				match(UserDefinedStringLiteral);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TemplateDeclarationContext extends org.example.antlr.common.context.ExtendContext {
		public TerminalNode Template() { return getToken(CPPParser.Template, 0); }
		public TerminalNode Less() { return getToken(CPPParser.Less, 0); }
		public TemplateparameterListContext templateparameterList() {
			return getRuleContext(TemplateparameterListContext.class,0);
		}
		public TerminalNode Greater() { return getToken(CPPParser.Greater, 0); }
		public DeclarationContext declaration() {
			return getRuleContext(DeclarationContext.class,0);
		}
		public TemplateDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_templateDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).enterTemplateDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).exitTemplateDeclaration(this);
		}
	}

	public final TemplateDeclarationContext templateDeclaration() throws RecognitionException {
		TemplateDeclarationContext _localctx = new TemplateDeclarationContext(_ctx, getState());
		enterRule(_localctx, 342, RULE_templateDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1846);
			match(Template);
			setState(1847);
			match(Less);
			setState(1848);
			templateparameterList();
			setState(1849);
			match(Greater);
			setState(1850);
			declaration();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TemplateparameterListContext extends org.example.antlr.common.context.ExtendContext {
		public List<TemplateParameterContext> templateParameter() {
			return getRuleContexts(TemplateParameterContext.class);
		}
		public TemplateParameterContext templateParameter(int i) {
			return getRuleContext(TemplateParameterContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(CPPParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(CPPParser.Comma, i);
		}
		public TemplateparameterListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_templateparameterList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).enterTemplateparameterList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).exitTemplateparameterList(this);
		}
	}

	public final TemplateparameterListContext templateparameterList() throws RecognitionException {
		TemplateparameterListContext _localctx = new TemplateparameterListContext(_ctx, getState());
		enterRule(_localctx, 344, RULE_templateparameterList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1852);
			templateParameter();
			setState(1857);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(1853);
				match(Comma);
				setState(1854);
				templateParameter();
				}
				}
				setState(1859);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TemplateParameterContext extends org.example.antlr.common.context.ExtendContext {
		public TypeParameterContext typeParameter() {
			return getRuleContext(TypeParameterContext.class,0);
		}
		public ParameterDeclarationContext parameterDeclaration() {
			return getRuleContext(ParameterDeclarationContext.class,0);
		}
		public TemplateParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_templateParameter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).enterTemplateParameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).exitTemplateParameter(this);
		}
	}

	public final TemplateParameterContext templateParameter() throws RecognitionException {
		TemplateParameterContext _localctx = new TemplateParameterContext(_ctx, getState());
		enterRule(_localctx, 346, RULE_templateParameter);
		try {
			setState(1862);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,255,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1860);
				typeParameter();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1861);
				parameterDeclaration();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeParameterContext extends org.example.antlr.common.context.ExtendContext {
		public TerminalNode Class() { return getToken(CPPParser.Class, 0); }
		public TerminalNode Typename_() { return getToken(CPPParser.Typename_, 0); }
		public TerminalNode Assign() { return getToken(CPPParser.Assign, 0); }
		public TheTypeIdContext theTypeId() {
			return getRuleContext(TheTypeIdContext.class,0);
		}
		public TerminalNode Template() { return getToken(CPPParser.Template, 0); }
		public TerminalNode Less() { return getToken(CPPParser.Less, 0); }
		public TemplateparameterListContext templateparameterList() {
			return getRuleContext(TemplateparameterListContext.class,0);
		}
		public TerminalNode Greater() { return getToken(CPPParser.Greater, 0); }
		public TerminalNode Ellipsis() { return getToken(CPPParser.Ellipsis, 0); }
		public TerminalNode Identifier() { return getToken(CPPParser.Identifier, 0); }
		public TypeParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeParameter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).enterTypeParameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).exitTypeParameter(this);
		}
	}

	public final TypeParameterContext typeParameter() throws RecognitionException {
		TypeParameterContext _localctx = new TypeParameterContext(_ctx, getState());
		enterRule(_localctx, 348, RULE_typeParameter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1873);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Class:
			case Template:
				{
				setState(1869);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Template) {
					{
					setState(1864);
					match(Template);
					setState(1865);
					match(Less);
					setState(1866);
					templateparameterList();
					setState(1867);
					match(Greater);
					}
				}

				setState(1871);
				match(Class);
				}
				break;
			case Typename_:
				{
				setState(1872);
				match(Typename_);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(1886);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,261,_ctx) ) {
			case 1:
				{
				setState(1876);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Ellipsis) {
					{
					setState(1875);
					match(Ellipsis);
					}
				}

				setState(1879);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Identifier) {
					{
					setState(1878);
					match(Identifier);
					}
				}

				}
				break;
			case 2:
				{
				setState(1882);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Identifier) {
					{
					setState(1881);
					match(Identifier);
					}
				}

				setState(1884);
				match(Assign);
				setState(1885);
				theTypeId();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SimpleTemplateIdContext extends org.example.antlr.common.context.ExtendContext {
		public TemplateNameContext templateName() {
			return getRuleContext(TemplateNameContext.class,0);
		}
		public TerminalNode Less() { return getToken(CPPParser.Less, 0); }
		public TerminalNode Greater() { return getToken(CPPParser.Greater, 0); }
		public TemplateArgumentListContext templateArgumentList() {
			return getRuleContext(TemplateArgumentListContext.class,0);
		}
		public SimpleTemplateIdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simpleTemplateId; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).enterSimpleTemplateId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).exitSimpleTemplateId(this);
		}
	}

	public final SimpleTemplateIdContext simpleTemplateId() throws RecognitionException {
		SimpleTemplateIdContext _localctx = new SimpleTemplateIdContext(_ctx, getState());
		enterRule(_localctx, 350, RULE_simpleTemplateId);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1888);
			templateName();
			setState(1889);
			match(Less);
			setState(1891);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IntegerLiteral) | (1L << CharacterLiteral) | (1L << FloatingLiteral) | (1L << StringLiteral) | (1L << BooleanLiteral) | (1L << PointerLiteral) | (1L << UserDefinedLiteral) | (1L << Alignof) | (1L << Auto) | (1L << Bool) | (1L << Char) | (1L << Char16) | (1L << Char32) | (1L << Class) | (1L << Const) | (1L << Const_cast) | (1L << Decltype) | (1L << Delete) | (1L << Double) | (1L << Dynamic_cast) | (1L << Enum) | (1L << Float) | (1L << Int) | (1L << Long) | (1L << New) | (1L << Noexcept) | (1L << Operator) | (1L << Reinterpret_cast) | (1L << Short) | (1L << Signed) | (1L << Sizeof))) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (Static_cast - 65)) | (1L << (Struct - 65)) | (1L << (This - 65)) | (1L << (Typeid_ - 65)) | (1L << (Typename_ - 65)) | (1L << (Union - 65)) | (1L << (Unsigned - 65)) | (1L << (Void - 65)) | (1L << (Volatile - 65)) | (1L << (Wchar - 65)) | (1L << (LeftParen - 65)) | (1L << (LeftBracket - 65)) | (1L << (Plus - 65)) | (1L << (Minus - 65)) | (1L << (Star - 65)) | (1L << (And - 65)) | (1L << (Or - 65)) | (1L << (Tilde - 65)) | (1L << (Not - 65)) | (1L << (PlusPlus - 65)) | (1L << (MinusMinus - 65)) | (1L << (Doublecolon - 65)))) != 0) || _la==Identifier) {
				{
				setState(1890);
				templateArgumentList();
				}
			}

			setState(1893);
			match(Greater);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TemplateIdContext extends org.example.antlr.common.context.ExtendContext {
		public SimpleTemplateIdContext simpleTemplateId() {
			return getRuleContext(SimpleTemplateIdContext.class,0);
		}
		public TerminalNode Less() { return getToken(CPPParser.Less, 0); }
		public TerminalNode Greater() { return getToken(CPPParser.Greater, 0); }
		public OperatorFunctionIdContext operatorFunctionId() {
			return getRuleContext(OperatorFunctionIdContext.class,0);
		}
		public LiteralOperatorIdContext literalOperatorId() {
			return getRuleContext(LiteralOperatorIdContext.class,0);
		}
		public TemplateArgumentListContext templateArgumentList() {
			return getRuleContext(TemplateArgumentListContext.class,0);
		}
		public TemplateIdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_templateId; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).enterTemplateId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).exitTemplateId(this);
		}
	}

	public final TemplateIdContext templateId() throws RecognitionException {
		TemplateIdContext _localctx = new TemplateIdContext(_ctx, getState());
		enterRule(_localctx, 352, RULE_templateId);
		int _la;
		try {
			setState(1906);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Identifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(1895);
				simpleTemplateId();
				}
				break;
			case Operator:
				enterOuterAlt(_localctx, 2);
				{
				setState(1898);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,263,_ctx) ) {
				case 1:
					{
					setState(1896);
					operatorFunctionId();
					}
					break;
				case 2:
					{
					setState(1897);
					literalOperatorId();
					}
					break;
				}
				setState(1900);
				match(Less);
				setState(1902);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IntegerLiteral) | (1L << CharacterLiteral) | (1L << FloatingLiteral) | (1L << StringLiteral) | (1L << BooleanLiteral) | (1L << PointerLiteral) | (1L << UserDefinedLiteral) | (1L << Alignof) | (1L << Auto) | (1L << Bool) | (1L << Char) | (1L << Char16) | (1L << Char32) | (1L << Class) | (1L << Const) | (1L << Const_cast) | (1L << Decltype) | (1L << Delete) | (1L << Double) | (1L << Dynamic_cast) | (1L << Enum) | (1L << Float) | (1L << Int) | (1L << Long) | (1L << New) | (1L << Noexcept) | (1L << Operator) | (1L << Reinterpret_cast) | (1L << Short) | (1L << Signed) | (1L << Sizeof))) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (Static_cast - 65)) | (1L << (Struct - 65)) | (1L << (This - 65)) | (1L << (Typeid_ - 65)) | (1L << (Typename_ - 65)) | (1L << (Union - 65)) | (1L << (Unsigned - 65)) | (1L << (Void - 65)) | (1L << (Volatile - 65)) | (1L << (Wchar - 65)) | (1L << (LeftParen - 65)) | (1L << (LeftBracket - 65)) | (1L << (Plus - 65)) | (1L << (Minus - 65)) | (1L << (Star - 65)) | (1L << (And - 65)) | (1L << (Or - 65)) | (1L << (Tilde - 65)) | (1L << (Not - 65)) | (1L << (PlusPlus - 65)) | (1L << (MinusMinus - 65)) | (1L << (Doublecolon - 65)))) != 0) || _la==Identifier) {
					{
					setState(1901);
					templateArgumentList();
					}
				}

				setState(1904);
				match(Greater);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TemplateNameContext extends org.example.antlr.common.context.ExtendContext {
		public TerminalNode Identifier() { return getToken(CPPParser.Identifier, 0); }
		public TemplateNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_templateName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).enterTemplateName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).exitTemplateName(this);
		}
	}

	public final TemplateNameContext templateName() throws RecognitionException {
		TemplateNameContext _localctx = new TemplateNameContext(_ctx, getState());
		enterRule(_localctx, 354, RULE_templateName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1908);
			match(Identifier);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TemplateArgumentListContext extends org.example.antlr.common.context.ExtendContext {
		public List<TemplateArgumentContext> templateArgument() {
			return getRuleContexts(TemplateArgumentContext.class);
		}
		public TemplateArgumentContext templateArgument(int i) {
			return getRuleContext(TemplateArgumentContext.class,i);
		}
		public List<TerminalNode> Ellipsis() { return getTokens(CPPParser.Ellipsis); }
		public TerminalNode Ellipsis(int i) {
			return getToken(CPPParser.Ellipsis, i);
		}
		public List<TerminalNode> Comma() { return getTokens(CPPParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(CPPParser.Comma, i);
		}
		public TemplateArgumentListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_templateArgumentList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).enterTemplateArgumentList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).exitTemplateArgumentList(this);
		}
	}

	public final TemplateArgumentListContext templateArgumentList() throws RecognitionException {
		TemplateArgumentListContext _localctx = new TemplateArgumentListContext(_ctx, getState());
		enterRule(_localctx, 356, RULE_templateArgumentList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1910);
			templateArgument();
			setState(1912);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Ellipsis) {
				{
				setState(1911);
				match(Ellipsis);
				}
			}

			setState(1921);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(1914);
				match(Comma);
				setState(1915);
				templateArgument();
				setState(1917);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Ellipsis) {
					{
					setState(1916);
					match(Ellipsis);
					}
				}

				}
				}
				setState(1923);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TemplateArgumentContext extends org.example.antlr.common.context.ExtendContext {
		public TheTypeIdContext theTypeId() {
			return getRuleContext(TheTypeIdContext.class,0);
		}
		public ConstantExpressionContext constantExpression() {
			return getRuleContext(ConstantExpressionContext.class,0);
		}
		public IdExpressionContext idExpression() {
			return getRuleContext(IdExpressionContext.class,0);
		}
		public TemplateArgumentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_templateArgument; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).enterTemplateArgument(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).exitTemplateArgument(this);
		}
	}

	public final TemplateArgumentContext templateArgument() throws RecognitionException {
		TemplateArgumentContext _localctx = new TemplateArgumentContext(_ctx, getState());
		enterRule(_localctx, 358, RULE_templateArgument);
		try {
			setState(1927);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,269,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1924);
				theTypeId();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1925);
				constantExpression();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1926);
				idExpression();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeNameSpecifierContext extends org.example.antlr.common.context.ExtendContext {
		public TerminalNode Typename_() { return getToken(CPPParser.Typename_, 0); }
		public NestedNameSpecifierContext nestedNameSpecifier() {
			return getRuleContext(NestedNameSpecifierContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(CPPParser.Identifier, 0); }
		public SimpleTemplateIdContext simpleTemplateId() {
			return getRuleContext(SimpleTemplateIdContext.class,0);
		}
		public TerminalNode Template() { return getToken(CPPParser.Template, 0); }
		public TypeNameSpecifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeNameSpecifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).enterTypeNameSpecifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).exitTypeNameSpecifier(this);
		}
	}

	public final TypeNameSpecifierContext typeNameSpecifier() throws RecognitionException {
		TypeNameSpecifierContext _localctx = new TypeNameSpecifierContext(_ctx, getState());
		enterRule(_localctx, 360, RULE_typeNameSpecifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1929);
			match(Typename_);
			setState(1930);
			nestedNameSpecifier(0);
			setState(1936);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,271,_ctx) ) {
			case 1:
				{
				setState(1931);
				match(Identifier);
				}
				break;
			case 2:
				{
				setState(1933);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Template) {
					{
					setState(1932);
					match(Template);
					}
				}

				setState(1935);
				simpleTemplateId();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExplicitInstantiationContext extends org.example.antlr.common.context.ExtendContext {
		public TerminalNode Template() { return getToken(CPPParser.Template, 0); }
		public DeclarationContext declaration() {
			return getRuleContext(DeclarationContext.class,0);
		}
		public TerminalNode Extern() { return getToken(CPPParser.Extern, 0); }
		public ExplicitInstantiationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_explicitInstantiation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).enterExplicitInstantiation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).exitExplicitInstantiation(this);
		}
	}

	public final ExplicitInstantiationContext explicitInstantiation() throws RecognitionException {
		ExplicitInstantiationContext _localctx = new ExplicitInstantiationContext(_ctx, getState());
		enterRule(_localctx, 362, RULE_explicitInstantiation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1939);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Extern) {
				{
				setState(1938);
				match(Extern);
				}
			}

			setState(1941);
			match(Template);
			setState(1942);
			declaration();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExplicitSpecializationContext extends org.example.antlr.common.context.ExtendContext {
		public TerminalNode Template() { return getToken(CPPParser.Template, 0); }
		public TerminalNode Less() { return getToken(CPPParser.Less, 0); }
		public TerminalNode Greater() { return getToken(CPPParser.Greater, 0); }
		public DeclarationContext declaration() {
			return getRuleContext(DeclarationContext.class,0);
		}
		public ExplicitSpecializationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_explicitSpecialization; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).enterExplicitSpecialization(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).exitExplicitSpecialization(this);
		}
	}

	public final ExplicitSpecializationContext explicitSpecialization() throws RecognitionException {
		ExplicitSpecializationContext _localctx = new ExplicitSpecializationContext(_ctx, getState());
		enterRule(_localctx, 364, RULE_explicitSpecialization);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1944);
			match(Template);
			setState(1945);
			match(Less);
			setState(1946);
			match(Greater);
			setState(1947);
			declaration();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TryBlockContext extends org.example.antlr.common.context.ExtendContext {
		public TerminalNode Try() { return getToken(CPPParser.Try, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public HandlerSeqContext handlerSeq() {
			return getRuleContext(HandlerSeqContext.class,0);
		}
		public TryBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tryBlock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).enterTryBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).exitTryBlock(this);
		}
	}

	public final TryBlockContext tryBlock() throws RecognitionException {
		TryBlockContext _localctx = new TryBlockContext(_ctx, getState());
		enterRule(_localctx, 366, RULE_tryBlock);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1949);
			match(Try);
			setState(1950);
			block();
			setState(1951);
			handlerSeq();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionTryBlockContext extends org.example.antlr.common.context.ExtendContext {
		public TerminalNode Try() { return getToken(CPPParser.Try, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public HandlerSeqContext handlerSeq() {
			return getRuleContext(HandlerSeqContext.class,0);
		}
		public ConstructorInitializerContext constructorInitializer() {
			return getRuleContext(ConstructorInitializerContext.class,0);
		}
		public FunctionTryBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionTryBlock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).enterFunctionTryBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).exitFunctionTryBlock(this);
		}
	}

	public final FunctionTryBlockContext functionTryBlock() throws RecognitionException {
		FunctionTryBlockContext _localctx = new FunctionTryBlockContext(_ctx, getState());
		enterRule(_localctx, 368, RULE_functionTryBlock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1953);
			match(Try);
			setState(1955);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Colon) {
				{
				setState(1954);
				constructorInitializer();
				}
			}

			setState(1957);
			block();
			setState(1958);
			handlerSeq();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class HandlerSeqContext extends org.example.antlr.common.context.ExtendContext {
		public List<HandlerContext> handler() {
			return getRuleContexts(HandlerContext.class);
		}
		public HandlerContext handler(int i) {
			return getRuleContext(HandlerContext.class,i);
		}
		public HandlerSeqContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_handlerSeq; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).enterHandlerSeq(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).exitHandlerSeq(this);
		}
	}

	public final HandlerSeqContext handlerSeq() throws RecognitionException {
		HandlerSeqContext _localctx = new HandlerSeqContext(_ctx, getState());
		enterRule(_localctx, 370, RULE_handlerSeq);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1961); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(1960);
				handler();
				}
				}
				setState(1963); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==Catch );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class HandlerContext extends org.example.antlr.common.context.ExtendContext {
		public TerminalNode Catch() { return getToken(CPPParser.Catch, 0); }
		public TerminalNode LeftParen() { return getToken(CPPParser.LeftParen, 0); }
		public ExceptionDeclarationContext exceptionDeclaration() {
			return getRuleContext(ExceptionDeclarationContext.class,0);
		}
		public TerminalNode RightParen() { return getToken(CPPParser.RightParen, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public HandlerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_handler; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).enterHandler(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).exitHandler(this);
		}
	}

	public final HandlerContext handler() throws RecognitionException {
		HandlerContext _localctx = new HandlerContext(_ctx, getState());
		enterRule(_localctx, 372, RULE_handler);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1965);
			match(Catch);
			setState(1966);
			match(LeftParen);
			setState(1967);
			exceptionDeclaration();
			setState(1968);
			match(RightParen);
			setState(1969);
			block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExceptionDeclarationContext extends org.example.antlr.common.context.ExtendContext {
		public TypeSpecifierSeqContext typeSpecifierSeq() {
			return getRuleContext(TypeSpecifierSeqContext.class,0);
		}
		public AttributeSpecifierSeqContext attributeSpecifierSeq() {
			return getRuleContext(AttributeSpecifierSeqContext.class,0);
		}
		public DeclaratorContext declarator() {
			return getRuleContext(DeclaratorContext.class,0);
		}
		public AbstractDeclaratorContext abstractDeclarator() {
			return getRuleContext(AbstractDeclaratorContext.class,0);
		}
		public TerminalNode Ellipsis() { return getToken(CPPParser.Ellipsis, 0); }
		public ExceptionDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exceptionDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).enterExceptionDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).exitExceptionDeclaration(this);
		}
	}

	public final ExceptionDeclarationContext exceptionDeclaration() throws RecognitionException {
		ExceptionDeclarationContext _localctx = new ExceptionDeclarationContext(_ctx, getState());
		enterRule(_localctx, 374, RULE_exceptionDeclaration);
		int _la;
		try {
			setState(1980);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Alignas:
			case Auto:
			case Bool:
			case Char:
			case Char16:
			case Char32:
			case Class:
			case Const:
			case Decltype:
			case Double:
			case Enum:
			case Float:
			case Int:
			case Long:
			case Short:
			case Signed:
			case Struct:
			case Typename_:
			case Union:
			case Unsigned:
			case Void:
			case Volatile:
			case Wchar:
			case LeftBracket:
			case Doublecolon:
			case Identifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(1972);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Alignas || _la==LeftBracket) {
					{
					setState(1971);
					attributeSpecifierSeq();
					}
				}

				setState(1974);
				typeSpecifierSeq();
				setState(1977);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,276,_ctx) ) {
				case 1:
					{
					setState(1975);
					declarator();
					}
					break;
				case 2:
					{
					setState(1976);
					abstractDeclarator();
					}
					break;
				}
				}
				break;
			case Ellipsis:
				enterOuterAlt(_localctx, 2);
				{
				setState(1979);
				match(Ellipsis);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ThrowExpressionContext extends org.example.antlr.common.context.ExtendContext {
		public TerminalNode Throw() { return getToken(CPPParser.Throw, 0); }
		public AssignmentExpressionContext assignmentExpression() {
			return getRuleContext(AssignmentExpressionContext.class,0);
		}
		public ThrowExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_throwExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).enterThrowExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).exitThrowExpression(this);
		}
	}

	public final ThrowExpressionContext throwExpression() throws RecognitionException {
		ThrowExpressionContext _localctx = new ThrowExpressionContext(_ctx, getState());
		enterRule(_localctx, 376, RULE_throwExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1982);
			match(Throw);
			setState(1984);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IntegerLiteral) | (1L << CharacterLiteral) | (1L << FloatingLiteral) | (1L << StringLiteral) | (1L << BooleanLiteral) | (1L << PointerLiteral) | (1L << UserDefinedLiteral) | (1L << Alignof) | (1L << Auto) | (1L << Bool) | (1L << Char) | (1L << Char16) | (1L << Char32) | (1L << Const_cast) | (1L << Decltype) | (1L << Delete) | (1L << Double) | (1L << Dynamic_cast) | (1L << Float) | (1L << Int) | (1L << Long) | (1L << New) | (1L << Noexcept) | (1L << Operator) | (1L << Reinterpret_cast) | (1L << Short) | (1L << Signed) | (1L << Sizeof))) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (Static_cast - 65)) | (1L << (This - 65)) | (1L << (Throw - 65)) | (1L << (Typeid_ - 65)) | (1L << (Typename_ - 65)) | (1L << (Unsigned - 65)) | (1L << (Void - 65)) | (1L << (Wchar - 65)) | (1L << (LeftParen - 65)) | (1L << (LeftBracket - 65)) | (1L << (Plus - 65)) | (1L << (Minus - 65)) | (1L << (Star - 65)) | (1L << (And - 65)) | (1L << (Or - 65)) | (1L << (Tilde - 65)) | (1L << (Not - 65)) | (1L << (PlusPlus - 65)) | (1L << (MinusMinus - 65)) | (1L << (Doublecolon - 65)))) != 0) || _la==Identifier) {
				{
				setState(1983);
				assignmentExpression();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExceptionSpecificationContext extends org.example.antlr.common.context.ExtendContext {
		public DynamicExceptionSpecificationContext dynamicExceptionSpecification() {
			return getRuleContext(DynamicExceptionSpecificationContext.class,0);
		}
		public NoeExceptSpecificationContext noeExceptSpecification() {
			return getRuleContext(NoeExceptSpecificationContext.class,0);
		}
		public ExceptionSpecificationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exceptionSpecification; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).enterExceptionSpecification(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).exitExceptionSpecification(this);
		}
	}

	public final ExceptionSpecificationContext exceptionSpecification() throws RecognitionException {
		ExceptionSpecificationContext _localctx = new ExceptionSpecificationContext(_ctx, getState());
		enterRule(_localctx, 378, RULE_exceptionSpecification);
		try {
			setState(1988);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Throw:
				enterOuterAlt(_localctx, 1);
				{
				setState(1986);
				dynamicExceptionSpecification();
				}
				break;
			case Noexcept:
				enterOuterAlt(_localctx, 2);
				{
				setState(1987);
				noeExceptSpecification();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DynamicExceptionSpecificationContext extends org.example.antlr.common.context.ExtendContext {
		public TerminalNode Throw() { return getToken(CPPParser.Throw, 0); }
		public TerminalNode LeftParen() { return getToken(CPPParser.LeftParen, 0); }
		public TerminalNode RightParen() { return getToken(CPPParser.RightParen, 0); }
		public TypeIdListContext typeIdList() {
			return getRuleContext(TypeIdListContext.class,0);
		}
		public DynamicExceptionSpecificationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dynamicExceptionSpecification; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).enterDynamicExceptionSpecification(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).exitDynamicExceptionSpecification(this);
		}
	}

	public final DynamicExceptionSpecificationContext dynamicExceptionSpecification() throws RecognitionException {
		DynamicExceptionSpecificationContext _localctx = new DynamicExceptionSpecificationContext(_ctx, getState());
		enterRule(_localctx, 380, RULE_dynamicExceptionSpecification);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1990);
			match(Throw);
			setState(1991);
			match(LeftParen);
			setState(1993);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 13)) & ~0x3f) == 0 && ((1L << (_la - 13)) & ((1L << (Auto - 13)) | (1L << (Bool - 13)) | (1L << (Char - 13)) | (1L << (Char16 - 13)) | (1L << (Char32 - 13)) | (1L << (Class - 13)) | (1L << (Const - 13)) | (1L << (Decltype - 13)) | (1L << (Double - 13)) | (1L << (Enum - 13)) | (1L << (Float - 13)) | (1L << (Int - 13)) | (1L << (Long - 13)) | (1L << (Short - 13)) | (1L << (Signed - 13)) | (1L << (Struct - 13)) | (1L << (Typename_ - 13)))) != 0) || ((((_la - 77)) & ~0x3f) == 0 && ((1L << (_la - 77)) & ((1L << (Union - 77)) | (1L << (Unsigned - 77)) | (1L << (Void - 77)) | (1L << (Volatile - 77)) | (1L << (Wchar - 77)) | (1L << (Doublecolon - 77)) | (1L << (Identifier - 77)))) != 0)) {
				{
				setState(1992);
				typeIdList();
				}
			}

			setState(1995);
			match(RightParen);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeIdListContext extends org.example.antlr.common.context.ExtendContext {
		public List<TheTypeIdContext> theTypeId() {
			return getRuleContexts(TheTypeIdContext.class);
		}
		public TheTypeIdContext theTypeId(int i) {
			return getRuleContext(TheTypeIdContext.class,i);
		}
		public List<TerminalNode> Ellipsis() { return getTokens(CPPParser.Ellipsis); }
		public TerminalNode Ellipsis(int i) {
			return getToken(CPPParser.Ellipsis, i);
		}
		public List<TerminalNode> Comma() { return getTokens(CPPParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(CPPParser.Comma, i);
		}
		public TypeIdListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeIdList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).enterTypeIdList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).exitTypeIdList(this);
		}
	}

	public final TypeIdListContext typeIdList() throws RecognitionException {
		TypeIdListContext _localctx = new TypeIdListContext(_ctx, getState());
		enterRule(_localctx, 382, RULE_typeIdList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1997);
			theTypeId();
			setState(1999);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Ellipsis) {
				{
				setState(1998);
				match(Ellipsis);
				}
			}

			setState(2008);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(2001);
				match(Comma);
				setState(2002);
				theTypeId();
				setState(2004);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Ellipsis) {
					{
					setState(2003);
					match(Ellipsis);
					}
				}

				}
				}
				setState(2010);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NoeExceptSpecificationContext extends org.example.antlr.common.context.ExtendContext {
		public TerminalNode Noexcept() { return getToken(CPPParser.Noexcept, 0); }
		public TerminalNode LeftParen() { return getToken(CPPParser.LeftParen, 0); }
		public ConstantExpressionContext constantExpression() {
			return getRuleContext(ConstantExpressionContext.class,0);
		}
		public TerminalNode RightParen() { return getToken(CPPParser.RightParen, 0); }
		public NoeExceptSpecificationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_noeExceptSpecification; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).enterNoeExceptSpecification(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).exitNoeExceptSpecification(this);
		}
	}

	public final NoeExceptSpecificationContext noeExceptSpecification() throws RecognitionException {
		NoeExceptSpecificationContext _localctx = new NoeExceptSpecificationContext(_ctx, getState());
		enterRule(_localctx, 384, RULE_noeExceptSpecification);
		try {
			setState(2017);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,284,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2011);
				match(Noexcept);
				setState(2012);
				match(LeftParen);
				setState(2013);
				constantExpression();
				setState(2014);
				match(RightParen);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2016);
				match(Noexcept);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TheOperatorContext extends org.example.antlr.common.context.ExtendContext {
		public TerminalNode New() { return getToken(CPPParser.New, 0); }
		public TerminalNode LeftBracket() { return getToken(CPPParser.LeftBracket, 0); }
		public TerminalNode RightBracket() { return getToken(CPPParser.RightBracket, 0); }
		public TerminalNode Delete() { return getToken(CPPParser.Delete, 0); }
		public TerminalNode Plus() { return getToken(CPPParser.Plus, 0); }
		public TerminalNode Minus() { return getToken(CPPParser.Minus, 0); }
		public TerminalNode Star() { return getToken(CPPParser.Star, 0); }
		public TerminalNode Div() { return getToken(CPPParser.Div, 0); }
		public TerminalNode Mod() { return getToken(CPPParser.Mod, 0); }
		public TerminalNode Caret() { return getToken(CPPParser.Caret, 0); }
		public TerminalNode And() { return getToken(CPPParser.And, 0); }
		public TerminalNode Or() { return getToken(CPPParser.Or, 0); }
		public TerminalNode Tilde() { return getToken(CPPParser.Tilde, 0); }
		public TerminalNode Not() { return getToken(CPPParser.Not, 0); }
		public TerminalNode Assign() { return getToken(CPPParser.Assign, 0); }
		public List<TerminalNode> Greater() { return getTokens(CPPParser.Greater); }
		public TerminalNode Greater(int i) {
			return getToken(CPPParser.Greater, i);
		}
		public List<TerminalNode> Less() { return getTokens(CPPParser.Less); }
		public TerminalNode Less(int i) {
			return getToken(CPPParser.Less, i);
		}
		public TerminalNode GreaterEqual() { return getToken(CPPParser.GreaterEqual, 0); }
		public TerminalNode PlusAssign() { return getToken(CPPParser.PlusAssign, 0); }
		public TerminalNode MinusAssign() { return getToken(CPPParser.MinusAssign, 0); }
		public TerminalNode StarAssign() { return getToken(CPPParser.StarAssign, 0); }
		public TerminalNode ModAssign() { return getToken(CPPParser.ModAssign, 0); }
		public TerminalNode XorAssign() { return getToken(CPPParser.XorAssign, 0); }
		public TerminalNode AndAssign() { return getToken(CPPParser.AndAssign, 0); }
		public TerminalNode OrAssign() { return getToken(CPPParser.OrAssign, 0); }
		public TerminalNode RightShiftAssign() { return getToken(CPPParser.RightShiftAssign, 0); }
		public TerminalNode LeftShiftAssign() { return getToken(CPPParser.LeftShiftAssign, 0); }
		public TerminalNode Equal() { return getToken(CPPParser.Equal, 0); }
		public TerminalNode NotEqual() { return getToken(CPPParser.NotEqual, 0); }
		public TerminalNode LessEqual() { return getToken(CPPParser.LessEqual, 0); }
		public TerminalNode AndAnd() { return getToken(CPPParser.AndAnd, 0); }
		public TerminalNode OrOr() { return getToken(CPPParser.OrOr, 0); }
		public TerminalNode PlusPlus() { return getToken(CPPParser.PlusPlus, 0); }
		public TerminalNode MinusMinus() { return getToken(CPPParser.MinusMinus, 0); }
		public TerminalNode Comma() { return getToken(CPPParser.Comma, 0); }
		public TerminalNode ArrowStar() { return getToken(CPPParser.ArrowStar, 0); }
		public TerminalNode Arrow() { return getToken(CPPParser.Arrow, 0); }
		public TerminalNode LeftParen() { return getToken(CPPParser.LeftParen, 0); }
		public TerminalNode RightParen() { return getToken(CPPParser.RightParen, 0); }
		public TheOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_theOperator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).enterTheOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).exitTheOperator(this);
		}
	}

	public final TheOperatorContext theOperator() throws RecognitionException {
		TheOperatorContext _localctx = new TheOperatorContext(_ctx, getState());
		enterRule(_localctx, 386, RULE_theOperator);
		try {
			setState(2070);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,287,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2019);
				match(New);
				setState(2022);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,285,_ctx) ) {
				case 1:
					{
					setState(2020);
					match(LeftBracket);
					setState(2021);
					match(RightBracket);
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2024);
				match(Delete);
				setState(2027);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,286,_ctx) ) {
				case 1:
					{
					setState(2025);
					match(LeftBracket);
					setState(2026);
					match(RightBracket);
					}
					break;
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2029);
				match(Plus);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(2030);
				match(Minus);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(2031);
				match(Star);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(2032);
				match(Div);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(2033);
				match(Mod);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(2034);
				match(Caret);
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(2035);
				match(And);
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(2036);
				match(Or);
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(2037);
				match(Tilde);
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(2038);
				match(Not);
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(2039);
				match(Assign);
				}
				break;
			case 14:
				enterOuterAlt(_localctx, 14);
				{
				setState(2040);
				match(Greater);
				}
				break;
			case 15:
				enterOuterAlt(_localctx, 15);
				{
				setState(2041);
				match(Less);
				}
				break;
			case 16:
				enterOuterAlt(_localctx, 16);
				{
				setState(2042);
				match(GreaterEqual);
				}
				break;
			case 17:
				enterOuterAlt(_localctx, 17);
				{
				setState(2043);
				match(PlusAssign);
				}
				break;
			case 18:
				enterOuterAlt(_localctx, 18);
				{
				setState(2044);
				match(MinusAssign);
				}
				break;
			case 19:
				enterOuterAlt(_localctx, 19);
				{
				setState(2045);
				match(StarAssign);
				}
				break;
			case 20:
				enterOuterAlt(_localctx, 20);
				{
				setState(2046);
				match(ModAssign);
				}
				break;
			case 21:
				enterOuterAlt(_localctx, 21);
				{
				setState(2047);
				match(XorAssign);
				}
				break;
			case 22:
				enterOuterAlt(_localctx, 22);
				{
				setState(2048);
				match(AndAssign);
				}
				break;
			case 23:
				enterOuterAlt(_localctx, 23);
				{
				setState(2049);
				match(OrAssign);
				}
				break;
			case 24:
				enterOuterAlt(_localctx, 24);
				{
				setState(2050);
				match(Less);
				setState(2051);
				match(Less);
				}
				break;
			case 25:
				enterOuterAlt(_localctx, 25);
				{
				setState(2052);
				match(Greater);
				setState(2053);
				match(Greater);
				}
				break;
			case 26:
				enterOuterAlt(_localctx, 26);
				{
				setState(2054);
				match(RightShiftAssign);
				}
				break;
			case 27:
				enterOuterAlt(_localctx, 27);
				{
				setState(2055);
				match(LeftShiftAssign);
				}
				break;
			case 28:
				enterOuterAlt(_localctx, 28);
				{
				setState(2056);
				match(Equal);
				}
				break;
			case 29:
				enterOuterAlt(_localctx, 29);
				{
				setState(2057);
				match(NotEqual);
				}
				break;
			case 30:
				enterOuterAlt(_localctx, 30);
				{
				setState(2058);
				match(LessEqual);
				}
				break;
			case 31:
				enterOuterAlt(_localctx, 31);
				{
				setState(2059);
				match(AndAnd);
				}
				break;
			case 32:
				enterOuterAlt(_localctx, 32);
				{
				setState(2060);
				match(OrOr);
				}
				break;
			case 33:
				enterOuterAlt(_localctx, 33);
				{
				setState(2061);
				match(PlusPlus);
				}
				break;
			case 34:
				enterOuterAlt(_localctx, 34);
				{
				setState(2062);
				match(MinusMinus);
				}
				break;
			case 35:
				enterOuterAlt(_localctx, 35);
				{
				setState(2063);
				match(Comma);
				}
				break;
			case 36:
				enterOuterAlt(_localctx, 36);
				{
				setState(2064);
				match(ArrowStar);
				}
				break;
			case 37:
				enterOuterAlt(_localctx, 37);
				{
				setState(2065);
				match(Arrow);
				}
				break;
			case 38:
				enterOuterAlt(_localctx, 38);
				{
				setState(2066);
				match(LeftParen);
				setState(2067);
				match(RightParen);
				}
				break;
			case 39:
				enterOuterAlt(_localctx, 39);
				{
				setState(2068);
				match(LeftBracket);
				setState(2069);
				match(RightBracket);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LiteralContext extends org.example.antlr.common.context.ExtendContext {
		public TerminalNode IntegerLiteral() { return getToken(CPPParser.IntegerLiteral, 0); }
		public TerminalNode CharacterLiteral() { return getToken(CPPParser.CharacterLiteral, 0); }
		public TerminalNode FloatingLiteral() { return getToken(CPPParser.FloatingLiteral, 0); }
		public TerminalNode StringLiteral() { return getToken(CPPParser.StringLiteral, 0); }
		public TerminalNode BooleanLiteral() { return getToken(CPPParser.BooleanLiteral, 0); }
		public TerminalNode PointerLiteral() { return getToken(CPPParser.PointerLiteral, 0); }
		public TerminalNode UserDefinedLiteral() { return getToken(CPPParser.UserDefinedLiteral, 0); }
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).enterLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPPParserListener ) ((CPPParserListener)listener).exitLiteral(this);
		}
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 388, RULE_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2072);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IntegerLiteral) | (1L << CharacterLiteral) | (1L << FloatingLiteral) | (1L << StringLiteral) | (1L << BooleanLiteral) | (1L << PointerLiteral) | (1L << UserDefinedLiteral))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 5:
			return nestedNameSpecifier_sempred((NestedNameSpecifierContext)_localctx, predIndex);
		case 15:
			return postfixExpression_sempred((PostfixExpressionContext)_localctx, predIndex);
		case 25:
			return noPointerNewDeclarator_sempred((NoPointerNewDeclaratorContext)_localctx, predIndex);
		case 119:
			return noPointerDeclarator_sempred((NoPointerDeclaratorContext)_localctx, predIndex);
		case 152:
			return memberDeclarator_sempred((MemberDeclaratorContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean nestedNameSpecifier_sempred(NestedNameSpecifierContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean postfixExpression_sempred(PostfixExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 7);
		case 2:
			return precpred(_ctx, 6);
		case 3:
			return precpred(_ctx, 4);
		case 4:
			return precpred(_ctx, 3);
		}
		return true;
	}
	private boolean noPointerNewDeclarator_sempred(NoPointerNewDeclaratorContext _localctx, int predIndex) {
		switch (predIndex) {
		case 5:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean noPointerDeclarator_sempred(NoPointerDeclaratorContext _localctx, int predIndex) {
		switch (predIndex) {
		case 6:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean memberDeclarator_sempred(MemberDeclaratorContext _localctx, int predIndex) {
		switch (predIndex) {
		case 7:
			return  this.IsPureSpecifierAllowed() ;
		case 8:
			return  this.IsPureSpecifierAllowed() ;
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\u0093\u081d\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4I"+
		"\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\4O\tO\4P\tP\4Q\tQ\4R\tR\4S\tS\4T\tT"+
		"\4U\tU\4V\tV\4W\tW\4X\tX\4Y\tY\4Z\tZ\4[\t[\4\\\t\\\4]\t]\4^\t^\4_\t_\4"+
		"`\t`\4a\ta\4b\tb\4c\tc\4d\td\4e\te\4f\tf\4g\tg\4h\th\4i\ti\4j\tj\4k\t"+
		"k\4l\tl\4m\tm\4n\tn\4o\to\4p\tp\4q\tq\4r\tr\4s\ts\4t\tt\4u\tu\4v\tv\4"+
		"w\tw\4x\tx\4y\ty\4z\tz\4{\t{\4|\t|\4}\t}\4~\t~\4\177\t\177\4\u0080\t\u0080"+
		"\4\u0081\t\u0081\4\u0082\t\u0082\4\u0083\t\u0083\4\u0084\t\u0084\4\u0085"+
		"\t\u0085\4\u0086\t\u0086\4\u0087\t\u0087\4\u0088\t\u0088\4\u0089\t\u0089"+
		"\4\u008a\t\u008a\4\u008b\t\u008b\4\u008c\t\u008c\4\u008d\t\u008d\4\u008e"+
		"\t\u008e\4\u008f\t\u008f\4\u0090\t\u0090\4\u0091\t\u0091\4\u0092\t\u0092"+
		"\4\u0093\t\u0093\4\u0094\t\u0094\4\u0095\t\u0095\4\u0096\t\u0096\4\u0097"+
		"\t\u0097\4\u0098\t\u0098\4\u0099\t\u0099\4\u009a\t\u009a\4\u009b\t\u009b"+
		"\4\u009c\t\u009c\4\u009d\t\u009d\4\u009e\t\u009e\4\u009f\t\u009f\4\u00a0"+
		"\t\u00a0\4\u00a1\t\u00a1\4\u00a2\t\u00a2\4\u00a3\t\u00a3\4\u00a4\t\u00a4"+
		"\4\u00a5\t\u00a5\4\u00a6\t\u00a6\4\u00a7\t\u00a7\4\u00a8\t\u00a8\4\u00a9"+
		"\t\u00a9\4\u00aa\t\u00aa\4\u00ab\t\u00ab\4\u00ac\t\u00ac\4\u00ad\t\u00ad"+
		"\4\u00ae\t\u00ae\4\u00af\t\u00af\4\u00b0\t\u00b0\4\u00b1\t\u00b1\4\u00b2"+
		"\t\u00b2\4\u00b3\t\u00b3\4\u00b4\t\u00b4\4\u00b5\t\u00b5\4\u00b6\t\u00b6"+
		"\4\u00b7\t\u00b7\4\u00b8\t\u00b8\4\u00b9\t\u00b9\4\u00ba\t\u00ba\4\u00bb"+
		"\t\u00bb\4\u00bc\t\u00bc\4\u00bd\t\u00bd\4\u00be\t\u00be\4\u00bf\t\u00bf"+
		"\4\u00c0\t\u00c0\4\u00c1\t\u00c1\4\u00c2\t\u00c2\4\u00c3\t\u00c3\4\u00c4"+
		"\t\u00c4\3\2\5\2\u018a\n\2\3\2\3\2\3\3\6\3\u018f\n\3\r\3\16\3\u0190\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3\u019a\n\3\3\4\3\4\5\4\u019e\n\4\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\5\5\u01a7\n\5\3\5\5\5\u01aa\n\5\3\6\3\6\5\6\u01ae"+
		"\n\6\3\6\3\6\3\7\3\7\3\7\3\7\5\7\u01b6\n\7\3\7\3\7\3\7\3\7\3\7\5\7\u01bd"+
		"\n\7\3\7\5\7\u01c0\n\7\3\7\7\7\u01c3\n\7\f\7\16\7\u01c6\13\7\3\b\3\b\5"+
		"\b\u01ca\n\b\3\b\3\b\3\t\3\t\5\t\u01d0\n\t\3\t\3\t\3\n\3\n\3\n\3\n\5\n"+
		"\u01d8\n\n\5\n\u01da\n\n\3\13\3\13\3\f\3\f\3\f\7\f\u01e1\n\f\f\f\16\f"+
		"\u01e4\13\f\3\f\5\f\u01e7\n\f\3\r\3\r\5\r\u01eb\n\r\3\16\5\16\u01ee\n"+
		"\16\3\16\3\16\5\16\u01f2\n\16\3\17\5\17\u01f5\n\17\3\17\3\17\3\17\3\20"+
		"\3\20\5\20\u01fc\n\20\3\20\3\20\5\20\u0200\n\20\3\20\5\20\u0203\n\20\3"+
		"\20\5\20\u0206\n\20\3\20\5\20\u0209\n\20\3\21\3\21\3\21\3\21\5\21\u020f"+
		"\n\21\3\21\3\21\5\21\u0213\n\21\3\21\3\21\5\21\u0217\n\21\3\21\3\21\3"+
		"\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\5\21\u0225\n\21\3\21"+
		"\3\21\5\21\u0229\n\21\3\21\3\21\3\21\3\21\5\21\u022f\n\21\3\21\3\21\3"+
		"\21\3\21\3\21\5\21\u0236\n\21\3\21\3\21\3\21\3\21\5\21\u023c\n\21\3\21"+
		"\3\21\5\21\u0240\n\21\3\21\3\21\7\21\u0244\n\21\f\21\16\21\u0247\13\21"+
		"\3\22\3\22\3\23\3\23\3\24\5\24\u024e\n\24\3\24\3\24\3\24\5\24\u0253\n"+
		"\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\5\24\u0260"+
		"\n\24\3\25\3\25\3\25\3\25\3\25\5\25\u0267\n\25\3\25\3\25\3\25\3\25\3\25"+
		"\3\25\3\25\3\25\3\25\3\25\5\25\u0273\n\25\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\3\25\3\25\5\25\u027d\n\25\3\26\3\26\3\27\5\27\u0282\n\27\3\27\3\27\5"+
		"\27\u0286\n\27\3\27\3\27\3\27\3\27\3\27\5\27\u028d\n\27\3\27\5\27\u0290"+
		"\n\27\3\30\3\30\3\30\3\30\3\31\3\31\5\31\u0298\n\31\3\32\3\32\5\32\u029c"+
		"\n\32\3\32\5\32\u029f\n\32\3\33\3\33\3\33\3\33\3\33\5\33\u02a6\n\33\3"+
		"\33\3\33\3\33\3\33\3\33\5\33\u02ad\n\33\7\33\u02af\n\33\f\33\16\33\u02b2"+
		"\13\33\3\34\3\34\5\34\u02b6\n\34\3\34\3\34\5\34\u02ba\n\34\3\35\5\35\u02bd"+
		"\n\35\3\35\3\35\3\35\5\35\u02c2\n\35\3\35\3\35\3\36\3\36\3\36\3\36\3\36"+
		"\3\37\3\37\3\37\3\37\3\37\3\37\5\37\u02d1\n\37\3 \3 \3 \7 \u02d6\n \f"+
		" \16 \u02d9\13 \3!\3!\3!\7!\u02de\n!\f!\16!\u02e1\13!\3\"\3\"\3\"\7\""+
		"\u02e6\n\"\f\"\16\"\u02e9\13\"\3#\3#\3#\3#\7#\u02ef\n#\f#\16#\u02f2\13"+
		"#\3$\3$\3$\3$\5$\u02f8\n$\3%\3%\3%\7%\u02fd\n%\f%\16%\u0300\13%\3&\3&"+
		"\3&\7&\u0305\n&\f&\16&\u0308\13&\3\'\3\'\3\'\7\'\u030d\n\'\f\'\16\'\u0310"+
		"\13\'\3(\3(\3(\7(\u0315\n(\f(\16(\u0318\13(\3)\3)\3)\7)\u031d\n)\f)\16"+
		")\u0320\13)\3*\3*\3*\7*\u0325\n*\f*\16*\u0328\13*\3+\3+\3+\7+\u032d\n"+
		"+\f+\16+\u0330\13+\3,\3,\3,\3,\3,\3,\5,\u0338\n,\3-\3-\3-\3-\3-\3-\5-"+
		"\u0340\n-\3.\3.\3/\3/\3/\7/\u0347\n/\f/\16/\u034a\13/\3\60\3\60\3\61\3"+
		"\61\3\61\5\61\u0351\n\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61"+
		"\3\61\5\61\u035d\n\61\5\61\u035f\n\61\3\62\5\62\u0362\n\62\3\62\3\62\3"+
		"\62\3\62\5\62\u0368\n\62\3\62\3\62\3\62\3\63\5\63\u036e\n\63\3\63\3\63"+
		"\3\64\3\64\5\64\u0374\n\64\3\64\3\64\3\65\6\65\u0379\n\65\r\65\16\65\u037a"+
		"\3\66\3\66\3\66\3\66\3\66\3\66\3\67\3\67\3\67\3\67\3\67\3\67\3\67\3\67"+
		"\38\38\38\38\38\38\39\39\59\u0393\n9\39\39\39\39\39\59\u039a\n9\59\u039c"+
		"\n9\3:\3:\3:\3:\3:\3:\3;\3;\3;\3;\3;\3;\3;\3;\3<\3<\3<\3<\5<\u03b0\n<"+
		"\3<\3<\5<\u03b4\n<\3<\3<\3<\3<\5<\u03ba\n<\3<\3<\3<\3=\3=\5=\u03c1\n="+
		"\3>\5>\u03c4\n>\3>\3>\3>\3?\3?\5?\u03cb\n?\3@\3@\3@\3@\3@\5@\u03d2\n@"+
		"\3@\3@\5@\u03d6\n@\3@\3@\3A\3A\3B\6B\u03dd\nB\rB\16B\u03de\3C\3C\3C\3"+
		"C\3C\3C\3C\3C\3C\5C\u03ea\nC\3D\3D\3D\3D\3D\3D\3D\3D\5D\u03f4\nD\3E\3"+
		"E\3E\5E\u03f9\nE\3E\3E\3E\3E\3F\5F\u0400\nF\3F\5F\u0403\nF\3F\3F\3F\5"+
		"F\u0408\nF\3F\3F\3F\5F\u040d\nF\3G\3G\3G\3G\3G\3G\3G\3G\3H\3H\3I\3I\3"+
		"I\3J\3J\3J\3J\3J\3J\5J\u0422\nJ\3K\6K\u0425\nK\rK\16K\u0426\3K\5K\u042a"+
		"\nK\3L\3L\3M\3M\3N\3N\3O\3O\3O\5O\u0435\nO\3P\3P\3P\3P\5P\u043b\nP\3Q"+
		"\6Q\u043e\nQ\rQ\16Q\u043f\3Q\5Q\u0443\nQ\3R\6R\u0446\nR\rR\16R\u0447\3"+
		"R\5R\u044b\nR\3S\3S\3T\3T\3U\5U\u0452\nU\3U\3U\3U\3U\3U\3U\3U\3U\3U\3"+
		"U\3U\3U\3U\3U\3U\3U\3U\3U\3U\3U\3U\5U\u0469\nU\3V\3V\3V\3V\5V\u046f\n"+
		"V\3W\3W\3W\3W\5W\u0475\nW\3W\3W\3X\3X\5X\u047b\nX\3X\5X\u047e\nX\3X\3"+
		"X\3X\3X\5X\u0484\nX\3X\3X\5X\u0488\nX\3X\3X\5X\u048c\nX\3X\5X\u048f\n"+
		"X\3Y\3Y\3Z\3Z\3Z\3Z\5Z\u0497\nZ\5Z\u0499\nZ\3Z\3Z\3[\3[\5[\u049f\n[\3"+
		"[\5[\u04a2\n[\3[\5[\u04a5\n[\3[\5[\u04a8\n[\3\\\3\\\5\\\u04ac\n\\\3\\"+
		"\3\\\5\\\u04b0\n\\\3\\\3\\\3]\3]\5]\u04b6\n]\3^\3^\3^\3_\3_\3_\7_\u04be"+
		"\n_\f_\16_\u04c1\13_\3`\3`\3`\5`\u04c6\n`\3a\3a\3b\3b\5b\u04cc\nb\3c\3"+
		"c\3d\5d\u04d1\nd\3d\3d\3d\5d\u04d6\nd\3d\3d\5d\u04da\nd\3d\3d\3e\3e\3"+
		"f\3f\3f\3f\3f\3f\3g\5g\u04e7\ng\3g\3g\3h\3h\5h\u04ed\nh\3h\3h\5h\u04f1"+
		"\nh\3h\3h\3h\3i\5i\u04f7\ni\3i\3i\3i\5i\u04fc\ni\3i\3i\3i\3j\3j\3j\3j"+
		"\3j\3j\3k\3k\3k\3k\5k\u050b\nk\3k\3k\5k\u050f\nk\3l\6l\u0512\nl\rl\16"+
		"l\u0513\3m\3m\3m\5m\u0519\nm\3m\3m\3m\5m\u051e\nm\3n\3n\3n\3n\5n\u0524"+
		"\nn\3n\5n\u0527\nn\3n\3n\3o\3o\3o\7o\u052e\no\fo\16o\u0531\13o\3o\5o\u0534"+
		"\no\3p\3p\3p\5p\u0539\np\3p\3p\5p\u053d\np\3q\3q\3r\3r\5r\u0543\nr\3r"+
		"\3r\3s\6s\u0548\ns\rs\16s\u0549\3t\3t\3t\3t\3t\3t\3t\3t\3t\3t\3t\3t\3"+
		"t\6t\u0559\nt\rt\16t\u055a\5t\u055d\nt\3u\3u\3u\7u\u0562\nu\fu\16u\u0565"+
		"\13u\3v\3v\5v\u0569\nv\3w\3w\3w\3w\3w\5w\u0570\nw\3x\3x\5x\u0574\nx\7"+
		"x\u0576\nx\fx\16x\u0579\13x\3x\3x\3y\3y\3y\5y\u0580\ny\3y\3y\3y\3y\5y"+
		"\u0586\ny\3y\3y\3y\3y\5y\u058c\ny\3y\3y\5y\u0590\ny\5y\u0592\ny\7y\u0594"+
		"\ny\fy\16y\u0597\13y\3z\3z\5z\u059b\nz\3z\3z\5z\u059f\nz\3z\5z\u05a2\n"+
		"z\3z\5z\u05a5\nz\3z\5z\u05a8\nz\3{\3{\3{\5{\u05ad\n{\3|\3|\5|\u05b1\n"+
		"|\3|\5|\u05b4\n|\3|\3|\5|\u05b8\n|\3|\5|\u05bb\n|\5|\u05bd\n|\3}\6}\u05c0"+
		"\n}\r}\16}\u05c1\3~\3~\3\177\3\177\3\u0080\5\u0080\u05c9\n\u0080\3\u0080"+
		"\3\u0080\3\u0081\3\u0081\5\u0081\u05cf\n\u0081\3\u0082\3\u0082\5\u0082"+
		"\u05d3\n\u0082\3\u0082\3\u0082\3\u0082\3\u0082\5\u0082\u05d9\n\u0082\3"+
		"\u0083\7\u0083\u05dc\n\u0083\f\u0083\16\u0083\u05df\13\u0083\3\u0083\3"+
		"\u0083\5\u0083\u05e3\n\u0083\3\u0084\3\u0084\3\u0084\3\u0084\3\u0084\5"+
		"\u0084\u05ea\n\u0084\3\u0084\3\u0084\3\u0084\5\u0084\u05ef\n\u0084\3\u0084"+
		"\3\u0084\5\u0084\u05f3\n\u0084\7\u0084\u05f5\n\u0084\f\u0084\16\u0084"+
		"\u05f8\13\u0084\3\u0085\7\u0085\u05fb\n\u0085\f\u0085\16\u0085\u05fe\13"+
		"\u0085\3\u0085\3\u0085\3\u0086\3\u0086\3\u0086\3\u0086\5\u0086\u0606\n"+
		"\u0086\3\u0086\3\u0086\5\u0086\u060a\n\u0086\7\u0086\u060c\n\u0086\f\u0086"+
		"\16\u0086\u060f\13\u0086\3\u0087\3\u0087\5\u0087\u0613\n\u0087\3\u0087"+
		"\5\u0087\u0616\n\u0087\3\u0088\3\u0088\3\u0088\7\u0088\u061b\n\u0088\f"+
		"\u0088\16\u0088\u061e\13\u0088\3\u0089\5\u0089\u0621\n\u0089\3\u0089\3"+
		"\u0089\3\u0089\5\u0089\u0626\n\u0089\5\u0089\u0628\n\u0089\3\u0089\3\u0089"+
		"\5\u0089\u062c\n\u0089\3\u008a\5\u008a\u062f\n\u008a\3\u008a\5\u008a\u0632"+
		"\n\u008a\3\u008a\3\u008a\5\u008a\u0636\n\u008a\3\u008a\3\u008a\3\u008b"+
		"\5\u008b\u063b\n\u008b\3\u008b\3\u008b\3\u008b\3\u008b\3\u008b\5\u008b"+
		"\u0642\n\u008b\3\u008c\3\u008c\3\u008c\3\u008c\3\u008c\5\u008c\u0649\n"+
		"\u008c\3\u008d\3\u008d\3\u008d\5\u008d\u064e\n\u008d\3\u008e\3\u008e\5"+
		"\u008e\u0652\n\u008e\3\u008f\3\u008f\5\u008f\u0656\n\u008f\3\u008f\3\u008f"+
		"\3\u008f\5\u008f\u065b\n\u008f\7\u008f\u065d\n\u008f\f\u008f\16\u008f"+
		"\u0660\13\u008f\3\u0090\3\u0090\3\u0090\5\u0090\u0665\n\u0090\5\u0090"+
		"\u0667\n\u0090\3\u0090\3\u0090\3\u0091\3\u0091\5\u0091\u066d\n\u0091\3"+
		"\u0092\3\u0092\3\u0092\5\u0092\u0672\n\u0092\3\u0092\3\u0092\3\u0093\3"+
		"\u0093\5\u0093\u0678\n\u0093\3\u0093\3\u0093\5\u0093\u067c\n\u0093\5\u0093"+
		"\u067e\n\u0093\3\u0093\5\u0093\u0681\n\u0093\3\u0093\3\u0093\5\u0093\u0685"+
		"\n\u0093\3\u0093\3\u0093\5\u0093\u0689\n\u0093\5\u0093\u068b\n\u0093\5"+
		"\u0093\u068d\n\u0093\3\u0094\5\u0094\u0690\n\u0094\3\u0094\3\u0094\3\u0095"+
		"\3\u0095\3\u0096\3\u0096\3\u0097\3\u0097\3\u0097\3\u0097\6\u0097\u069c"+
		"\n\u0097\r\u0097\16\u0097\u069d\3\u0098\5\u0098\u06a1\n\u0098\3\u0098"+
		"\5\u0098\u06a4\n\u0098\3\u0098\5\u0098\u06a7\n\u0098\3\u0098\3\u0098\3"+
		"\u0098\3\u0098\3\u0098\3\u0098\3\u0098\5\u0098\u06b0\n\u0098\3\u0099\3"+
		"\u0099\3\u0099\7\u0099\u06b5\n\u0099\f\u0099\16\u0099\u06b8\13\u0099\3"+
		"\u009a\3\u009a\3\u009a\3\u009a\3\u009a\3\u009a\3\u009a\3\u009a\3\u009a"+
		"\5\u009a\u06c3\n\u009a\3\u009a\3\u009a\5\u009a\u06c7\n\u009a\3\u009a\5"+
		"\u009a\u06ca\n\u009a\3\u009a\3\u009a\5\u009a\u06ce\n\u009a\3\u009b\6\u009b"+
		"\u06d1\n\u009b\r\u009b\16\u009b\u06d2\3\u009c\3\u009c\3\u009d\3\u009d"+
		"\3\u009d\3\u009e\3\u009e\3\u009e\3\u009f\3\u009f\5\u009f\u06df\n\u009f"+
		"\3\u009f\3\u009f\3\u009f\5\u009f\u06e4\n\u009f\7\u009f\u06e6\n\u009f\f"+
		"\u009f\16\u009f\u06e9\13\u009f\3\u00a0\5\u00a0\u06ec\n\u00a0\3\u00a0\3"+
		"\u00a0\3\u00a0\5\u00a0\u06f1\n\u00a0\3\u00a0\3\u00a0\3\u00a0\5\u00a0\u06f6"+
		"\n\u00a0\3\u00a0\3\u00a0\5\u00a0\u06fa\n\u00a0\3\u00a1\5\u00a1\u06fd\n"+
		"\u00a1\3\u00a1\3\u00a1\5\u00a1\u0701\n\u00a1\3\u00a2\3\u00a2\3\u00a3\3"+
		"\u00a3\3\u00a4\3\u00a4\3\u00a4\3\u00a5\3\u00a5\5\u00a5\u070c\n\u00a5\3"+
		"\u00a6\3\u00a6\5\u00a6\u0710\n\u00a6\3\u00a7\3\u00a7\3\u00a7\3\u00a8\3"+
		"\u00a8\5\u00a8\u0717\n\u00a8\3\u00a8\3\u00a8\3\u00a8\5\u00a8\u071c\n\u00a8"+
		"\7\u00a8\u071e\n\u00a8\f\u00a8\16\u00a8\u0721\13\u00a8\3\u00a9\3\u00a9"+
		"\3\u00a9\5\u00a9\u0726\n\u00a9\3\u00a9\3\u00a9\5\u00a9\u072a\n\u00a9\3"+
		"\u00aa\3\u00aa\5\u00aa\u072e\n\u00aa\3\u00ab\3\u00ab\3\u00ab\3\u00ac\3"+
		"\u00ac\3\u00ac\3\u00ac\5\u00ac\u0737\n\u00ac\3\u00ad\3\u00ad\3\u00ad\3"+
		"\u00ad\3\u00ad\3\u00ad\3\u00ae\3\u00ae\3\u00ae\7\u00ae\u0742\n\u00ae\f"+
		"\u00ae\16\u00ae\u0745\13\u00ae\3\u00af\3\u00af\5\u00af\u0749\n\u00af\3"+
		"\u00b0\3\u00b0\3\u00b0\3\u00b0\3\u00b0\5\u00b0\u0750\n\u00b0\3\u00b0\3"+
		"\u00b0\5\u00b0\u0754\n\u00b0\3\u00b0\5\u00b0\u0757\n\u00b0\3\u00b0\5\u00b0"+
		"\u075a\n\u00b0\3\u00b0\5\u00b0\u075d\n\u00b0\3\u00b0\3\u00b0\5\u00b0\u0761"+
		"\n\u00b0\3\u00b1\3\u00b1\3\u00b1\5\u00b1\u0766\n\u00b1\3\u00b1\3\u00b1"+
		"\3\u00b2\3\u00b2\3\u00b2\5\u00b2\u076d\n\u00b2\3\u00b2\3\u00b2\5\u00b2"+
		"\u0771\n\u00b2\3\u00b2\3\u00b2\5\u00b2\u0775\n\u00b2\3\u00b3\3\u00b3\3"+
		"\u00b4\3\u00b4\5\u00b4\u077b\n\u00b4\3\u00b4\3\u00b4\3\u00b4\5\u00b4\u0780"+
		"\n\u00b4\7\u00b4\u0782\n\u00b4\f\u00b4\16\u00b4\u0785\13\u00b4\3\u00b5"+
		"\3\u00b5\3\u00b5\5\u00b5\u078a\n\u00b5\3\u00b6\3\u00b6\3\u00b6\3\u00b6"+
		"\5\u00b6\u0790\n\u00b6\3\u00b6\5\u00b6\u0793\n\u00b6\3\u00b7\5\u00b7\u0796"+
		"\n\u00b7\3\u00b7\3\u00b7\3\u00b7\3\u00b8\3\u00b8\3\u00b8\3\u00b8\3\u00b8"+
		"\3\u00b9\3\u00b9\3\u00b9\3\u00b9\3\u00ba\3\u00ba\5\u00ba\u07a6\n\u00ba"+
		"\3\u00ba\3\u00ba\3\u00ba\3\u00bb\6\u00bb\u07ac\n\u00bb\r\u00bb\16\u00bb"+
		"\u07ad\3\u00bc\3\u00bc\3\u00bc\3\u00bc\3\u00bc\3\u00bc\3\u00bd\5\u00bd"+
		"\u07b7\n\u00bd\3\u00bd\3\u00bd\3\u00bd\5\u00bd\u07bc\n\u00bd\3\u00bd\5"+
		"\u00bd\u07bf\n\u00bd\3\u00be\3\u00be\5\u00be\u07c3\n\u00be\3\u00bf\3\u00bf"+
		"\5\u00bf\u07c7\n\u00bf\3\u00c0\3\u00c0\3\u00c0\5\u00c0\u07cc\n\u00c0\3"+
		"\u00c0\3\u00c0\3\u00c1\3\u00c1\5\u00c1\u07d2\n\u00c1\3\u00c1\3\u00c1\3"+
		"\u00c1\5\u00c1\u07d7\n\u00c1\7\u00c1\u07d9\n\u00c1\f\u00c1\16\u00c1\u07dc"+
		"\13\u00c1\3\u00c2\3\u00c2\3\u00c2\3\u00c2\3\u00c2\3\u00c2\5\u00c2\u07e4"+
		"\n\u00c2\3\u00c3\3\u00c3\3\u00c3\5\u00c3\u07e9\n\u00c3\3\u00c3\3\u00c3"+
		"\3\u00c3\5\u00c3\u07ee\n\u00c3\3\u00c3\3\u00c3\3\u00c3\3\u00c3\3\u00c3"+
		"\3\u00c3\3\u00c3\3\u00c3\3\u00c3\3\u00c3\3\u00c3\3\u00c3\3\u00c3\3\u00c3"+
		"\3\u00c3\3\u00c3\3\u00c3\3\u00c3\3\u00c3\3\u00c3\3\u00c3\3\u00c3\3\u00c3"+
		"\3\u00c3\3\u00c3\3\u00c3\3\u00c3\3\u00c3\3\u00c3\3\u00c3\3\u00c3\3\u00c3"+
		"\3\u00c3\3\u00c3\3\u00c3\3\u00c3\3\u00c3\3\u00c3\3\u00c3\3\u00c3\3\u00c3"+
		"\5\u00c3\u0819\n\u00c3\3\u00c4\3\u00c4\3\u00c4\3\u0426\6\f \64\u00f0\u00c5"+
		"\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BDFH"+
		"JLNPRTVXZ\\^`bdfhjlnprtvxz|~\u0080\u0082\u0084\u0086\u0088\u008a\u008c"+
		"\u008e\u0090\u0092\u0094\u0096\u0098\u009a\u009c\u009e\u00a0\u00a2\u00a4"+
		"\u00a6\u00a8\u00aa\u00ac\u00ae\u00b0\u00b2\u00b4\u00b6\u00b8\u00ba\u00bc"+
		"\u00be\u00c0\u00c2\u00c4\u00c6\u00c8\u00ca\u00cc\u00ce\u00d0\u00d2\u00d4"+
		"\u00d6\u00d8\u00da\u00dc\u00de\u00e0\u00e2\u00e4\u00e6\u00e8\u00ea\u00ec"+
		"\u00ee\u00f0\u00f2\u00f4\u00f6\u00f8\u00fa\u00fc\u00fe\u0100\u0102\u0104"+
		"\u0106\u0108\u010a\u010c\u010e\u0110\u0112\u0114\u0116\u0118\u011a\u011c"+
		"\u011e\u0120\u0122\u0124\u0126\u0128\u012a\u012c\u012e\u0130\u0132\u0134"+
		"\u0136\u0138\u013a\u013c\u013e\u0140\u0142\u0144\u0146\u0148\u014a\u014c"+
		"\u014e\u0150\u0152\u0154\u0156\u0158\u015a\u015c\u015e\u0160\u0162\u0164"+
		"\u0166\u0168\u016a\u016c\u016e\u0170\u0172\u0174\u0176\u0178\u017a\u017c"+
		"\u017e\u0180\u0182\u0184\u0186\2\31\4\2ccgg\6\2\32\32!!<<CC\4\2~~\u0083"+
		"\u0083\3\2z{\4\2]_cf\4\2}}\u0084\u0084\3\2_a\3\2]^\4\2hivw\3\2tu\4\2g"+
		"gjs\7\2&&\61\61;;AAHH\5\2$$..RR\4\2\60\60>>\4\2??PP\4\2\27\27DD\3\2W\\"+
		"\4\2ccxx\4\2\30\30TT\3\2\35\36\4\2((\67\67\3\28:\3\2\3\t\2\u08f8\2\u0189"+
		"\3\2\2\2\4\u0199\3\2\2\2\6\u019d\3\2\2\2\b\u01a9\3\2\2\2\n\u01ab\3\2\2"+
		"\2\f\u01b1\3\2\2\2\16\u01c7\3\2\2\2\20\u01cd\3\2\2\2\22\u01d9\3\2\2\2"+
		"\24\u01db\3\2\2\2\26\u01dd\3\2\2\2\30\u01ea\3\2\2\2\32\u01f1\3\2\2\2\34"+
		"\u01f4\3\2\2\2\36\u01f9\3\2\2\2 \u0228\3\2\2\2\"\u0248\3\2\2\2$\u024a"+
		"\3\2\2\2&\u025f\3\2\2\2(\u027c\3\2\2\2*\u027e\3\2\2\2,\u0281\3\2\2\2."+
		"\u0291\3\2\2\2\60\u0295\3\2\2\2\62\u029e\3\2\2\2\64\u02a0\3\2\2\2\66\u02b9"+
		"\3\2\2\28\u02bc\3\2\2\2:\u02c5\3\2\2\2<\u02d0\3\2\2\2>\u02d2\3\2\2\2@"+
		"\u02da\3\2\2\2B\u02e2\3\2\2\2D\u02ea\3\2\2\2F\u02f7\3\2\2\2H\u02f9\3\2"+
		"\2\2J\u0301\3\2\2\2L\u0309\3\2\2\2N\u0311\3\2\2\2P\u0319\3\2\2\2R\u0321"+
		"\3\2\2\2T\u0329\3\2\2\2V\u0331\3\2\2\2X\u033f\3\2\2\2Z\u0341\3\2\2\2\\"+
		"\u0343\3\2\2\2^\u034b\3\2\2\2`\u035e\3\2\2\2b\u0361\3\2\2\2d\u036d\3\2"+
		"\2\2f\u0371\3\2\2\2h\u0378\3\2\2\2j\u037c\3\2\2\2l\u0382\3\2\2\2n\u038a"+
		"\3\2\2\2p\u039b\3\2\2\2r\u039d\3\2\2\2t\u03a3\3\2\2\2v\u03ab\3\2\2\2x"+
		"\u03c0\3\2\2\2z\u03c3\3\2\2\2|\u03ca\3\2\2\2~\u03d5\3\2\2\2\u0080\u03d9"+
		"\3\2\2\2\u0082\u03dc\3\2\2\2\u0084\u03e9\3\2\2\2\u0086\u03f3\3\2\2\2\u0088"+
		"\u03f5\3\2\2\2\u008a\u040c\3\2\2\2\u008c\u040e\3\2\2\2\u008e\u0416\3\2"+
		"\2\2\u0090\u0418\3\2\2\2\u0092\u0421\3\2\2\2\u0094\u0424\3\2\2\2\u0096"+
		"\u042b\3\2\2\2\u0098\u042d\3\2\2\2\u009a\u042f\3\2\2\2\u009c\u0434\3\2"+
		"\2\2\u009e\u043a\3\2\2\2\u00a0\u043d\3\2\2\2\u00a2\u0445\3\2\2\2\u00a4"+
		"\u044c\3\2\2\2\u00a6\u044e\3\2\2\2\u00a8\u0468\3\2\2\2\u00aa\u046e\3\2"+
		"\2\2\u00ac\u0470\3\2\2\2\u00ae\u048e\3\2\2\2\u00b0\u0490\3\2\2\2\u00b2"+
		"\u0492\3\2\2\2\u00b4\u049c\3\2\2\2\u00b6\u04a9\3\2\2\2\u00b8\u04b3\3\2"+
		"\2\2\u00ba\u04b7\3\2\2\2\u00bc\u04ba\3\2\2\2\u00be\u04c2\3\2\2\2\u00c0"+
		"\u04c7\3\2\2\2\u00c2\u04cb\3\2\2\2\u00c4\u04cd\3\2\2\2\u00c6\u04d0\3\2"+
		"\2\2\u00c8\u04dd\3\2\2\2\u00ca\u04df\3\2\2\2\u00cc\u04e6\3\2\2\2\u00ce"+
		"\u04ea\3\2\2\2\u00d0\u04f6\3\2\2\2\u00d2\u0500\3\2\2\2\u00d4\u0506\3\2"+
		"\2\2\u00d6\u0511\3\2\2\2\u00d8\u051d\3\2\2\2\u00da\u051f\3\2\2\2\u00dc"+
		"\u052a\3\2\2\2\u00de\u0538\3\2\2\2\u00e0\u053e\3\2\2\2\u00e2\u0540\3\2"+
		"\2\2\u00e4\u0547\3\2\2\2\u00e6\u055c\3\2\2\2\u00e8\u055e\3\2\2\2\u00ea"+
		"\u0566\3\2\2\2\u00ec\u056f\3\2\2\2\u00ee\u0577\3\2\2\2\u00f0\u0585\3\2"+
		"\2\2\u00f2\u0598\3\2\2\2\u00f4\u05a9\3\2\2\2\u00f6\u05bc\3\2\2\2\u00f8"+
		"\u05bf\3\2\2\2\u00fa\u05c3\3\2\2\2\u00fc\u05c5\3\2\2\2\u00fe\u05c8\3\2"+
		"\2\2\u0100\u05cc\3\2\2\2\u0102\u05d8\3\2\2\2\u0104\u05dd\3\2\2\2\u0106"+
		"\u05e9\3\2\2\2\u0108\u05fc\3\2\2\2\u010a\u0601\3\2\2\2\u010c\u0610\3\2"+
		"\2\2\u010e\u0617\3\2\2\2\u0110\u0620\3\2\2\2\u0112\u062e\3\2\2\2\u0114"+
		"\u0641\3\2\2\2\u0116\u0648\3\2\2\2\u0118\u064d\3\2\2\2\u011a\u0651\3\2"+
		"\2\2\u011c\u0653\3\2\2\2\u011e\u0661\3\2\2\2\u0120\u066c\3\2\2\2\u0122"+
		"\u066e\3\2\2\2\u0124\u068c\3\2\2\2\u0126\u068f\3\2\2\2\u0128\u0693\3\2"+
		"\2\2\u012a\u0695\3\2\2\2\u012c\u069b\3\2\2\2\u012e\u06af\3\2\2\2\u0130"+
		"\u06b1\3\2\2\2\u0132\u06cd\3\2\2\2\u0134\u06d0\3\2\2\2\u0136\u06d4\3\2"+
		"\2\2\u0138\u06d6\3\2\2\2\u013a\u06d9\3\2\2\2\u013c\u06dc\3\2\2\2\u013e"+
		"\u06eb\3\2\2\2\u0140\u0700\3\2\2\2\u0142\u0702\3\2\2\2\u0144\u0704\3\2"+
		"\2\2\u0146\u0706\3\2\2\2\u0148\u0709\3\2\2\2\u014a\u070d\3\2\2\2\u014c"+
		"\u0711\3\2\2\2\u014e\u0714\3\2\2\2\u0150\u0722\3\2\2\2\u0152\u072d\3\2"+
		"\2\2\u0154\u072f\3\2\2\2\u0156\u0732\3\2\2\2\u0158\u0738\3\2\2\2\u015a"+
		"\u073e\3\2\2\2\u015c\u0748\3\2\2\2\u015e\u0753\3\2\2\2\u0160\u0762\3\2"+
		"\2\2\u0162\u0774\3\2\2\2\u0164\u0776\3\2\2\2\u0166\u0778\3\2\2\2\u0168"+
		"\u0789\3\2\2\2\u016a\u078b\3\2\2\2\u016c\u0795\3\2\2\2\u016e\u079a\3\2"+
		"\2\2\u0170\u079f\3\2\2\2\u0172\u07a3\3\2\2\2\u0174\u07ab\3\2\2\2\u0176"+
		"\u07af\3\2\2\2\u0178\u07be\3\2\2\2\u017a\u07c0\3\2\2\2\u017c\u07c6\3\2"+
		"\2\2\u017e\u07c8\3\2\2\2\u0180\u07cf\3\2\2\2\u0182\u07e3\3\2\2\2\u0184"+
		"\u0818\3\2\2\2\u0186\u081a\3\2\2\2\u0188\u018a\5\u0082B\2\u0189\u0188"+
		"\3\2\2\2\u0189\u018a\3\2\2\2\u018a\u018b\3\2\2\2\u018b\u018c\7\2\2\3\u018c"+
		"\3\3\2\2\2\u018d\u018f\5\u0186\u00c4\2\u018e\u018d\3\2\2\2\u018f\u0190"+
		"\3\2\2\2\u0190\u018e\3\2\2\2\u0190\u0191\3\2\2\2\u0191\u019a\3\2\2\2\u0192"+
		"\u019a\7G\2\2\u0193\u0194\7W\2\2\u0194\u0195\5\\/\2\u0195\u0196\7X\2\2"+
		"\u0196\u019a\3\2\2\2\u0197\u019a\5\6\4\2\u0198\u019a\5\16\b\2\u0199\u018e"+
		"\3\2\2\2\u0199\u0192\3\2\2\2\u0199\u0193\3\2\2\2\u0199\u0197\3\2\2\2\u0199"+
		"\u0198\3\2\2\2\u019a\5\3\2\2\2\u019b\u019e\5\b\5\2\u019c\u019e\5\n\6\2"+
		"\u019d\u019b\3\2\2\2\u019d\u019c\3\2\2\2\u019e\7\3\2\2\2\u019f\u01aa\7"+
		"\u0086\2\2\u01a0\u01aa\5\u0154\u00ab\2\u01a1\u01aa\5\u0146\u00a4\2\u01a2"+
		"\u01aa\5\u0156\u00ac\2\u01a3\u01a6\7e\2\2\u01a4\u01a7\5\u0120\u0091\2"+
		"\u01a5\u01a7\5\u00acW\2\u01a6\u01a4\3\2\2\2\u01a6\u01a5\3\2\2\2\u01a7"+
		"\u01aa\3\2\2\2\u01a8\u01aa\5\u0162\u00b2\2\u01a9\u019f\3\2\2\2\u01a9\u01a0"+
		"\3\2\2\2\u01a9\u01a1\3\2\2\2\u01a9\u01a2\3\2\2\2\u01a9\u01a3\3\2\2\2\u01a9"+
		"\u01a8\3\2\2\2\u01aa\t\3\2\2\2\u01ab\u01ad\5\f\7\2\u01ac\u01ae\7F\2\2"+
		"\u01ad\u01ac\3\2\2\2\u01ad\u01ae\3\2\2\2\u01ae\u01af\3\2\2\2\u01af\u01b0"+
		"\5\b\5\2\u01b0\13\3\2\2\2\u01b1\u01b5\b\7\1\2\u01b2\u01b6\5\u00aaV\2\u01b3"+
		"\u01b6\5\u00c2b\2\u01b4\u01b6\5\u00acW\2\u01b5\u01b2\3\2\2\2\u01b5\u01b3"+
		"\3\2\2\2\u01b5\u01b4\3\2\2\2\u01b5\u01b6\3\2\2\2\u01b6\u01b7\3\2\2\2\u01b7"+
		"\u01b8\7\u0081\2\2\u01b8\u01c4\3\2\2\2\u01b9\u01bf\f\3\2\2\u01ba\u01c0"+
		"\7\u0086\2\2\u01bb\u01bd\7F\2\2\u01bc\u01bb\3\2\2\2\u01bc\u01bd\3\2\2"+
		"\2\u01bd\u01be\3\2\2\2\u01be\u01c0\5\u0160\u00b1\2\u01bf\u01ba\3\2\2\2"+
		"\u01bf\u01bc\3\2\2\2\u01c0\u01c1\3\2\2\2\u01c1\u01c3\7\u0081\2\2\u01c2"+
		"\u01b9\3\2\2\2\u01c3\u01c6\3\2\2\2\u01c4\u01c2\3\2\2\2\u01c4\u01c5\3\2"+
		"\2\2\u01c5\r\3\2\2\2\u01c6\u01c4\3\2\2\2\u01c7\u01c9\5\20\t\2\u01c8\u01ca"+
		"\5\36\20\2\u01c9\u01c8\3\2\2\2\u01c9\u01ca\3\2\2\2\u01ca\u01cb\3\2\2\2"+
		"\u01cb\u01cc\5f\64\2\u01cc\17\3\2\2\2\u01cd\u01cf\7Y\2\2\u01ce\u01d0\5"+
		"\22\n\2\u01cf\u01ce\3\2\2\2\u01cf\u01d0\3\2\2\2\u01d0\u01d1\3\2\2\2\u01d1"+
		"\u01d2\7Z\2\2\u01d2\21\3\2\2\2\u01d3\u01da\5\26\f\2\u01d4\u01d7\5\24\13"+
		"\2\u01d5\u01d6\7|\2\2\u01d6\u01d8\5\26\f\2\u01d7\u01d5\3\2\2\2\u01d7\u01d8"+
		"\3\2\2\2\u01d8\u01da\3\2\2\2\u01d9\u01d3\3\2\2\2\u01d9\u01d4\3\2\2\2\u01da"+
		"\23\3\2\2\2\u01db\u01dc\t\2\2\2\u01dc\25\3\2\2\2\u01dd\u01e2\5\30\r\2"+
		"\u01de\u01df\7|\2\2\u01df\u01e1\5\30\r\2\u01e0\u01de\3\2\2\2\u01e1\u01e4"+
		"\3\2\2\2\u01e2\u01e0\3\2\2\2\u01e2\u01e3\3\2\2\2\u01e3\u01e6\3\2\2\2\u01e4"+
		"\u01e2\3\2\2\2\u01e5\u01e7\7\u0085\2\2\u01e6\u01e5\3\2\2\2\u01e6\u01e7"+
		"\3\2\2\2\u01e7\27\3\2\2\2\u01e8\u01eb\5\32\16\2\u01e9\u01eb\5\34\17\2"+
		"\u01ea\u01e8\3\2\2\2\u01ea\u01e9\3\2\2\2\u01eb\31\3\2\2\2\u01ec\u01ee"+
		"\7c\2\2\u01ed\u01ec\3\2\2\2\u01ed\u01ee\3\2\2\2\u01ee\u01ef\3\2\2\2\u01ef"+
		"\u01f2\7\u0086\2\2\u01f0\u01f2\7G\2\2\u01f1\u01ed\3\2\2\2\u01f1\u01f0"+
		"\3\2\2\2\u01f2\33\3\2\2\2\u01f3\u01f5\7c\2\2\u01f4\u01f3\3\2\2\2\u01f4"+
		"\u01f5\3\2\2\2\u01f5\u01f6\3\2\2\2\u01f6\u01f7\7\u0086\2\2\u01f7\u01f8"+
		"\5\u0116\u008c\2\u01f8\35\3\2\2\2\u01f9\u01fb\7W\2\2\u01fa\u01fc\5\u010c"+
		"\u0087\2\u01fb\u01fa\3\2\2\2\u01fb\u01fc\3\2\2\2\u01fc\u01fd\3\2\2\2\u01fd"+
		"\u01ff\7X\2\2\u01fe\u0200\7\61\2\2\u01ff\u01fe\3\2\2\2\u01ff\u0200\3\2"+
		"\2\2\u0200\u0202\3\2\2\2\u0201\u0203\5\u017c\u00bf\2\u0202\u0201\3\2\2"+
		"\2\u0202\u0203\3\2\2\2\u0203\u0205\3\2\2\2\u0204\u0206\5\u00d6l\2\u0205"+
		"\u0204\3\2\2\2\u0205\u0206\3\2\2\2\u0206\u0208\3\2\2\2\u0207\u0209\5\u00f4"+
		"{\2\u0208\u0207\3\2\2\2\u0208\u0209\3\2\2\2\u0209\37\3\2\2\2\u020a\u020b"+
		"\b\21\1\2\u020b\u0229\5\4\3\2\u020c\u020f\5\u00a8U\2\u020d\u020f\5\u016a"+
		"\u00b6\2\u020e\u020c\3\2\2\2\u020e\u020d\3\2\2\2\u020f\u0216\3\2\2\2\u0210"+
		"\u0212\7W\2\2\u0211\u0213\5$\23\2\u0212\u0211\3\2\2\2\u0212\u0213\3\2"+
		"\2\2\u0213\u0214\3\2\2\2\u0214\u0217\7X\2\2\u0215\u0217\5\u011e\u0090"+
		"\2\u0216\u0210\3\2\2\2\u0216\u0215\3\2\2\2\u0217\u0229\3\2\2\2\u0218\u0219"+
		"\t\3\2\2\u0219\u021a\7h\2\2\u021a\u021b\5\u0100\u0081\2\u021b\u021c\7"+
		"i\2\2\u021c\u021d\7W\2\2\u021d\u021e\5\\/\2\u021e\u021f\7X\2\2\u021f\u0229"+
		"\3\2\2\2\u0220\u0221\5\"\22\2\u0221\u0224\7W\2\2\u0222\u0225\5\\/\2\u0223"+
		"\u0225\5\u0100\u0081\2\u0224\u0222\3\2\2\2\u0224\u0223\3\2\2\2\u0225\u0226"+
		"\3\2\2\2\u0226\u0227\7X\2\2\u0227\u0229\3\2\2\2\u0228\u020a\3\2\2\2\u0228"+
		"\u020e\3\2\2\2\u0228\u0218\3\2\2\2\u0228\u0220\3\2\2\2\u0229\u0245\3\2"+
		"\2\2\u022a\u022b\f\t\2\2\u022b\u022e\7Y\2\2\u022c\u022f\5\\/\2\u022d\u022f"+
		"\5\u011e\u0090\2\u022e\u022c\3\2\2\2\u022e\u022d\3\2\2\2\u022f\u0230\3"+
		"\2\2\2\u0230\u0231\7Z\2\2\u0231\u0244\3\2\2\2\u0232\u0233\f\b\2\2\u0233"+
		"\u0235\7W\2\2\u0234\u0236\5$\23\2\u0235\u0234\3\2\2\2\u0235\u0236\3\2"+
		"\2\2\u0236\u0237\3\2\2\2\u0237\u0244\7X\2\2\u0238\u0239\f\6\2\2\u0239"+
		"\u023f\t\4\2\2\u023a\u023c\7F\2\2\u023b\u023a\3\2\2\2\u023b\u023c\3\2"+
		"\2\2\u023c\u023d\3\2\2\2\u023d\u0240\5\6\4\2\u023e\u0240\5&\24\2\u023f"+
		"\u023b\3\2\2\2\u023f\u023e\3\2\2\2\u0240\u0244\3\2\2\2\u0241\u0242\f\5"+
		"\2\2\u0242\u0244\t\5\2\2\u0243\u022a\3\2\2\2\u0243\u0232\3\2\2\2\u0243"+
		"\u0238\3\2\2\2\u0243\u0241\3\2\2\2\u0244\u0247\3\2\2\2\u0245\u0243\3\2"+
		"\2\2\u0245\u0246\3\2\2\2\u0246!\3\2\2\2\u0247\u0245\3\2\2\2\u0248\u0249"+
		"\7M\2\2\u0249#\3\2\2\2\u024a\u024b\5\u011c\u008f\2\u024b%\3\2\2\2\u024c"+
		"\u024e\5\f\7\2\u024d\u024c\3\2\2\2\u024d\u024e\3\2\2\2\u024e\u0252\3\2"+
		"\2\2\u024f\u0250\5\u00aaV\2\u0250\u0251\7\u0081\2\2\u0251\u0253\3\2\2"+
		"\2\u0252\u024f\3\2\2\2\u0252\u0253\3\2\2\2\u0253\u0254\3\2\2\2\u0254\u0255"+
		"\7e\2\2\u0255\u0260\5\u00aaV\2\u0256\u0257\5\f\7\2\u0257\u0258\7F\2\2"+
		"\u0258\u0259\5\u0160\u00b1\2\u0259\u025a\7\u0081\2\2\u025a\u025b\7e\2"+
		"\2\u025b\u025c\5\u00aaV\2\u025c\u0260\3\2\2\2\u025d\u025e\7e\2\2\u025e"+
		"\u0260\5\u00acW\2\u025f\u024d\3\2\2\2\u025f\u0256\3\2\2\2\u025f\u025d"+
		"\3\2\2\2\u0260\'\3\2\2\2\u0261\u027d\5 \21\2\u0262\u0267\7z\2\2\u0263"+
		"\u0267\7{\2\2\u0264\u0267\5*\26\2\u0265\u0267\7@\2\2\u0266\u0262\3\2\2"+
		"\2\u0266\u0263\3\2\2\2\u0266\u0264\3\2\2\2\u0266\u0265\3\2\2\2\u0267\u0268"+
		"\3\2\2\2\u0268\u027d\5(\25\2\u0269\u0272\7@\2\2\u026a\u026b\7W\2\2\u026b"+
		"\u026c\5\u0100\u0081\2\u026c\u026d\7X\2\2\u026d\u0273\3\2\2\2\u026e\u026f"+
		"\7\u0085\2\2\u026f\u0270\7W\2\2\u0270\u0271\7\u0086\2\2\u0271\u0273\7"+
		"X\2\2\u0272\u026a\3\2\2\2\u0272\u026e\3\2\2\2\u0273\u027d\3\2\2\2\u0274"+
		"\u0275\7\r\2\2\u0275\u0276\7W\2\2\u0276\u0277\5\u0100\u0081\2\u0277\u0278"+
		"\7X\2\2\u0278\u027d\3\2\2\2\u0279\u027d\5:\36\2\u027a\u027d\5,\27\2\u027b"+
		"\u027d\58\35\2\u027c\u0261\3\2\2\2\u027c\u0266\3\2\2\2\u027c\u0269\3\2"+
		"\2\2\u027c\u0274\3\2\2\2\u027c\u0279\3\2\2\2\u027c\u027a\3\2\2\2\u027c"+
		"\u027b\3\2\2\2\u027d)\3\2\2\2\u027e\u027f\t\6\2\2\u027f+\3\2\2\2\u0280"+
		"\u0282\7\u0081\2\2\u0281\u0280\3\2\2\2\u0281\u0282\3\2\2\2\u0282\u0283"+
		"\3\2\2\2\u0283\u0285\7\63\2\2\u0284\u0286\5.\30\2\u0285\u0284\3\2\2\2"+
		"\u0285\u0286\3\2\2\2\u0286\u028c\3\2\2\2\u0287\u028d\5\60\31\2\u0288\u0289"+
		"\7W\2\2\u0289\u028a\5\u0100\u0081\2\u028a\u028b\7X\2\2\u028b\u028d\3\2"+
		"\2\2\u028c\u0287\3\2\2\2\u028c\u0288\3\2\2\2\u028d\u028f\3\2\2\2\u028e"+
		"\u0290\5\66\34\2\u028f\u028e\3\2\2\2\u028f\u0290\3\2\2\2\u0290-\3\2\2"+
		"\2\u0291\u0292\7W\2\2\u0292\u0293\5$\23\2\u0293\u0294\7X\2\2\u0294/\3"+
		"\2\2\2\u0295\u0297\5\u00a0Q\2\u0296\u0298\5\62\32\2\u0297\u0296\3\2\2"+
		"\2\u0297\u0298\3\2\2\2\u0298\61\3\2\2\2\u0299\u029b\5\u00f6|\2\u029a\u029c"+
		"\5\62\32\2\u029b\u029a\3\2\2\2\u029b\u029c\3\2\2\2\u029c\u029f\3\2\2\2"+
		"\u029d\u029f\5\64\33\2\u029e\u0299\3\2\2\2\u029e\u029d\3\2\2\2\u029f\63"+
		"\3\2\2\2\u02a0\u02a1\b\33\1\2\u02a1\u02a2\7Y\2\2\u02a2\u02a3\5\\/\2\u02a3"+
		"\u02a5\7Z\2\2\u02a4\u02a6\5\u00d6l\2\u02a5\u02a4\3\2\2\2\u02a5\u02a6\3"+
		"\2\2\2\u02a6\u02b0\3\2\2\2\u02a7\u02a8\f\3\2\2\u02a8\u02a9\7Y\2\2\u02a9"+
		"\u02aa\5^\60\2\u02aa\u02ac\7Z\2\2\u02ab\u02ad\5\u00d6l\2\u02ac\u02ab\3"+
		"\2\2\2\u02ac\u02ad\3\2\2\2\u02ad\u02af\3\2\2\2\u02ae\u02a7\3\2\2\2\u02af"+
		"\u02b2\3\2\2\2\u02b0\u02ae\3\2\2\2\u02b0\u02b1\3\2\2\2\u02b1\65\3\2\2"+
		"\2\u02b2\u02b0\3\2\2\2\u02b3\u02b5\7W\2\2\u02b4\u02b6\5$\23\2\u02b5\u02b4"+
		"\3\2\2\2\u02b5\u02b6\3\2\2\2\u02b6\u02b7\3\2\2\2\u02b7\u02ba\7X\2\2\u02b8"+
		"\u02ba\5\u011e\u0090\2\u02b9\u02b3\3\2\2\2\u02b9\u02b8\3\2\2\2\u02ba\67"+
		"\3\2\2\2\u02bb\u02bd\7\u0081\2\2\u02bc\u02bb\3\2\2\2\u02bc\u02bd\3\2\2"+
		"\2\u02bd\u02be\3\2\2\2\u02be\u02c1\7\36\2\2\u02bf\u02c0\7Y\2\2\u02c0\u02c2"+
		"\7Z\2\2\u02c1\u02bf\3\2\2\2\u02c1\u02c2\3\2\2\2\u02c2\u02c3\3\2\2\2\u02c3"+
		"\u02c4\5<\37\2\u02c49\3\2\2\2\u02c5\u02c6\7\64\2\2\u02c6\u02c7\7W\2\2"+
		"\u02c7\u02c8\5\\/\2\u02c8\u02c9\7X\2\2\u02c9;\3\2\2\2\u02ca\u02d1\5(\25"+
		"\2\u02cb\u02cc\7W\2\2\u02cc\u02cd\5\u0100\u0081\2\u02cd\u02ce\7X\2\2\u02ce"+
		"\u02cf\5<\37\2\u02cf\u02d1\3\2\2\2\u02d0\u02ca\3\2\2\2\u02d0\u02cb\3\2"+
		"\2\2\u02d1=\3\2\2\2\u02d2\u02d7\5<\37\2\u02d3\u02d4\t\7\2\2\u02d4\u02d6"+
		"\5<\37\2\u02d5\u02d3\3\2\2\2\u02d6\u02d9\3\2\2\2\u02d7\u02d5\3\2\2\2\u02d7"+
		"\u02d8\3\2\2\2\u02d8?\3\2\2\2\u02d9\u02d7\3\2\2\2\u02da\u02df\5> \2\u02db"+
		"\u02dc\t\b\2\2\u02dc\u02de\5> \2\u02dd\u02db\3\2\2\2\u02de\u02e1\3\2\2"+
		"\2\u02df\u02dd\3\2\2\2\u02df\u02e0\3\2\2\2\u02e0A\3\2\2\2\u02e1\u02df"+
		"\3\2\2\2\u02e2\u02e7\5@!\2\u02e3\u02e4\t\t\2\2\u02e4\u02e6\5@!\2\u02e5"+
		"\u02e3\3\2\2\2\u02e6\u02e9\3\2\2\2\u02e7\u02e5\3\2\2\2\u02e7\u02e8\3\2"+
		"\2\2\u02e8C\3\2\2\2\u02e9\u02e7\3\2\2\2\u02ea\u02f0\5B\"\2\u02eb\u02ec"+
		"\5F$\2\u02ec\u02ed\5B\"\2\u02ed\u02ef\3\2\2\2\u02ee\u02eb\3\2\2\2\u02ef"+
		"\u02f2\3\2\2\2\u02f0\u02ee\3\2\2\2\u02f0\u02f1\3\2\2\2\u02f1E\3\2\2\2"+
		"\u02f2\u02f0\3\2\2\2\u02f3\u02f4\7i\2\2\u02f4\u02f8\7i\2\2\u02f5\u02f6"+
		"\7h\2\2\u02f6\u02f8\7h\2\2\u02f7\u02f3\3\2\2\2\u02f7\u02f5\3\2\2\2\u02f8"+
		"G\3\2\2\2\u02f9\u02fe\5D#\2\u02fa\u02fb\t\n\2\2\u02fb\u02fd\5D#\2\u02fc"+
		"\u02fa\3\2\2\2\u02fd\u0300\3\2\2\2\u02fe\u02fc\3\2\2\2\u02fe\u02ff\3\2"+
		"\2\2\u02ffI\3\2\2\2\u0300\u02fe\3\2\2\2\u0301\u0306\5H%\2\u0302\u0303"+
		"\t\13\2\2\u0303\u0305\5H%\2\u0304\u0302\3\2\2\2\u0305\u0308\3\2\2\2\u0306"+
		"\u0304\3\2\2\2\u0306\u0307\3\2\2\2\u0307K\3\2\2\2\u0308\u0306\3\2\2\2"+
		"\u0309\u030e\5J&\2\u030a\u030b\7c\2\2\u030b\u030d\5J&\2\u030c\u030a\3"+
		"\2\2\2\u030d\u0310\3\2\2\2\u030e\u030c\3\2\2\2\u030e\u030f\3\2\2\2\u030f"+
		"M\3\2\2\2\u0310\u030e\3\2\2\2\u0311\u0316\5L\'\2\u0312\u0313\7b\2\2\u0313"+
		"\u0315\5L\'\2\u0314\u0312\3\2\2\2\u0315\u0318\3\2\2\2\u0316\u0314\3\2"+
		"\2\2\u0316\u0317\3\2\2\2\u0317O\3\2\2\2\u0318\u0316\3\2\2\2\u0319\u031e"+
		"\5N(\2\u031a\u031b\7d\2\2\u031b\u031d\5N(\2\u031c\u031a\3\2\2\2\u031d"+
		"\u0320\3\2\2\2\u031e\u031c\3\2\2\2\u031e\u031f\3\2\2\2\u031fQ\3\2\2\2"+
		"\u0320\u031e\3\2\2\2\u0321\u0326\5P)\2\u0322\u0323\7x\2\2\u0323\u0325"+
		"\5P)\2\u0324\u0322\3\2\2\2\u0325\u0328\3\2\2\2\u0326\u0324\3\2\2\2\u0326"+
		"\u0327\3\2\2\2\u0327S\3\2\2\2\u0328\u0326\3\2\2\2\u0329\u032e\5R*\2\u032a"+
		"\u032b\7y\2\2\u032b\u032d\5R*\2\u032c\u032a\3\2\2\2\u032d\u0330\3\2\2"+
		"\2\u032e\u032c\3\2\2\2\u032e\u032f\3\2\2\2\u032fU\3\2\2\2\u0330\u032e"+
		"\3\2\2\2\u0331\u0337\5T+\2\u0332\u0333\7\177\2\2\u0333\u0334\5\\/\2\u0334"+
		"\u0335\7\u0080\2\2\u0335\u0336\5X-\2\u0336\u0338\3\2\2\2\u0337\u0332\3"+
		"\2\2\2\u0337\u0338\3\2\2\2\u0338W\3\2\2\2\u0339\u0340\5V,\2\u033a\u033b"+
		"\5T+\2\u033b\u033c\5Z.\2\u033c\u033d\5\u011a\u008e\2\u033d\u0340\3\2\2"+
		"\2\u033e\u0340\5\u017a\u00be\2\u033f\u0339\3\2\2\2\u033f\u033a\3\2\2\2"+
		"\u033f\u033e\3\2\2\2\u0340Y\3\2\2\2\u0341\u0342\t\f\2\2\u0342[\3\2\2\2"+
		"\u0343\u0348\5X-\2\u0344\u0345\7|\2\2\u0345\u0347\5X-\2\u0346\u0344\3"+
		"\2\2\2\u0347\u034a\3\2\2\2\u0348\u0346\3\2\2\2\u0348\u0349\3\2\2\2\u0349"+
		"]\3\2\2\2\u034a\u0348\3\2\2\2\u034b\u034c\5V,\2\u034c_\3\2\2\2\u034d\u035f"+
		"\5b\62\2\u034e\u035f\5\u0080A\2\u034f\u0351\5\u00d6l\2\u0350\u034f\3\2"+
		"\2\2\u0350\u0351\3\2\2\2\u0351\u035c\3\2\2\2\u0352\u035d\5d\63\2\u0353"+
		"\u035d\5f\64\2\u0354\u035d\5j\66\2\u0355\u035d\5l\67\2\u0356\u035d\5n"+
		"8\2\u0357\u035d\5r:\2\u0358\u035d\5t;\2\u0359\u035d\5v<\2\u035a\u035d"+
		"\5~@\2\u035b\u035d\5\u0170\u00b9\2\u035c\u0352\3\2\2\2\u035c\u0353\3\2"+
		"\2\2\u035c\u0354\3\2\2\2\u035c\u0355\3\2\2\2\u035c\u0356\3\2\2\2\u035c"+
		"\u0357\3\2\2\2\u035c\u0358\3\2\2\2\u035c\u0359\3\2\2\2\u035c\u035a\3\2"+
		"\2\2\u035c\u035b\3\2\2\2\u035d\u035f\3\2\2\2\u035e\u034d\3\2\2\2\u035e"+
		"\u034e\3\2\2\2\u035e\u0350\3\2\2\2\u035fa\3\2\2\2\u0360\u0362\5\u00d6"+
		"l\2\u0361\u0360\3\2\2\2\u0361\u0362\3\2\2\2\u0362\u0367\3\2\2\2\u0363"+
		"\u0368\7\u0086\2\2\u0364\u0365\7\22\2\2\u0365\u0368\5^\60\2\u0366\u0368"+
		"\7\35\2\2\u0367\u0363\3\2\2\2\u0367\u0364\3\2\2\2\u0367\u0366\3\2\2\2"+
		"\u0368\u0369\3\2\2\2\u0369\u036a\7\u0080\2\2\u036a\u036b\5`\61\2\u036b"+
		"c\3\2\2\2\u036c\u036e\5\\/\2\u036d\u036c\3\2\2\2\u036d\u036e\3\2\2\2\u036e"+
		"\u036f\3\2\2\2\u036f\u0370\7\u0082\2\2\u0370e\3\2\2\2\u0371\u0373\7[\2"+
		"\2\u0372\u0374\5h\65\2\u0373\u0372\3\2\2\2\u0373\u0374\3\2\2\2\u0374\u0375"+
		"\3\2\2\2\u0375\u0376\7\\\2\2\u0376g\3\2\2\2\u0377\u0379\5`\61\2\u0378"+
		"\u0377\3\2\2\2\u0379\u037a\3\2\2\2\u037a\u0378\3\2\2\2\u037a\u037b\3\2"+
		"\2\2\u037bi\3\2\2\2\u037c\u037d\7-\2\2\u037d\u037e\7W\2\2\u037e\u037f"+
		"\5p9\2\u037f\u0380\7X\2\2\u0380\u0381\5`\61\2\u0381k\3\2\2\2\u0382\u0383"+
		"\7-\2\2\u0383\u0384\7W\2\2\u0384\u0385\5p9\2\u0385\u0386\7X\2\2\u0386"+
		"\u0387\5`\61\2\u0387\u0388\7\"\2\2\u0388\u0389\5`\61\2\u0389m\3\2\2\2"+
		"\u038a\u038b\7E\2\2\u038b\u038c\7W\2\2\u038c\u038d\5p9\2\u038d\u038e\7"+
		"X\2\2\u038e\u038f\5`\61\2\u038fo\3\2\2\2\u0390\u039c\5\\/\2\u0391\u0393"+
		"\5\u00d6l\2\u0392\u0391\3\2\2\2\u0392\u0393\3\2\2\2\u0393\u0394\3\2\2"+
		"\2\u0394\u0395\5\u0094K\2\u0395\u0399\5\u00ecw\2\u0396\u0397\7g\2\2\u0397"+
		"\u039a\5\u011a\u008e\2\u0398\u039a\5\u011e\u0090\2\u0399\u0396\3\2\2\2"+
		"\u0399\u0398\3\2\2\2\u039a\u039c\3\2\2\2\u039b\u0390\3\2\2\2\u039b\u0392"+
		"\3\2\2\2\u039cq\3\2\2\2\u039d\u039e\7V\2\2\u039e\u039f\7W\2\2\u039f\u03a0"+
		"\5p9\2\u03a0\u03a1\7X\2\2\u03a1\u03a2\5`\61\2\u03a2s\3\2\2\2\u03a3\u03a4"+
		"\7\37\2\2\u03a4\u03a5\5`\61\2\u03a5\u03a6\7V\2\2\u03a6\u03a7\7W\2\2\u03a7"+
		"\u03a8\5\\/\2\u03a8\u03a9\7X\2\2\u03a9\u03aa\7\u0082\2\2\u03aau\3\2\2"+
		"\2\u03ab\u03ac\7*\2\2\u03ac\u03b9\7W\2\2\u03ad\u03af\5x=\2\u03ae\u03b0"+
		"\5p9\2\u03af\u03ae\3\2\2\2\u03af\u03b0\3\2\2\2\u03b0\u03b1\3\2\2\2\u03b1"+
		"\u03b3\7\u0082\2\2\u03b2\u03b4\5\\/\2\u03b3\u03b2\3\2\2\2\u03b3\u03b4"+
		"\3\2\2\2\u03b4\u03ba\3\2\2\2\u03b5\u03b6\5z>\2\u03b6\u03b7\7\u0080\2\2"+
		"\u03b7\u03b8\5|?\2\u03b8\u03ba\3\2\2\2\u03b9\u03ad\3\2\2\2\u03b9\u03b5"+
		"\3\2\2\2\u03ba\u03bb\3\2\2\2\u03bb\u03bc\7X\2\2\u03bc\u03bd\5`\61\2\u03bd"+
		"w\3\2\2\2\u03be\u03c1\5d\63\2\u03bf\u03c1\5\u008aF\2\u03c0\u03be\3\2\2"+
		"\2\u03c0\u03bf\3\2\2\2\u03c1y\3\2\2\2\u03c2\u03c4\5\u00d6l\2\u03c3\u03c2"+
		"\3\2\2\2\u03c3\u03c4\3\2\2\2\u03c4\u03c5\3\2\2\2\u03c5\u03c6\5\u0094K"+
		"\2\u03c6\u03c7\5\u00ecw\2\u03c7{\3\2\2\2\u03c8\u03cb\5\\/\2\u03c9\u03cb"+
		"\5\u011e\u0090\2\u03ca\u03c8\3\2\2\2\u03ca\u03c9\3\2\2\2\u03cb}\3\2\2"+
		"\2\u03cc\u03d6\7\21\2\2\u03cd\u03d6\7\33\2\2\u03ce\u03d1\7=\2\2\u03cf"+
		"\u03d2\5\\/\2\u03d0\u03d2\5\u011e\u0090\2\u03d1\u03cf\3\2\2\2\u03d1\u03d0"+
		"\3\2\2\2\u03d1\u03d2\3\2\2\2\u03d2\u03d6\3\2\2\2\u03d3\u03d4\7,\2\2\u03d4"+
		"\u03d6\7\u0086\2\2\u03d5\u03cc\3\2\2\2\u03d5\u03cd\3\2\2\2\u03d5\u03ce"+
		"\3\2\2\2\u03d5\u03d3\3\2\2\2\u03d6\u03d7\3\2\2\2\u03d7\u03d8\7\u0082\2"+
		"\2\u03d8\177\3\2\2\2\u03d9\u03da\5\u0086D\2\u03da\u0081\3\2\2\2\u03db"+
		"\u03dd\5\u0084C\2\u03dc\u03db\3\2\2\2\u03dd\u03de\3\2\2\2\u03de\u03dc"+
		"\3\2\2\2\u03de\u03df\3\2\2\2\u03df\u0083\3\2\2\2\u03e0\u03ea\5\u0086D"+
		"\2\u03e1\u03ea\5\u0112\u008a\2\u03e2\u03ea\5\u0158\u00ad\2\u03e3\u03ea"+
		"\5\u016c\u00b7\2\u03e4\u03ea\5\u016e\u00b8\2\u03e5\u03ea\5\u00d4k\2\u03e6"+
		"\u03ea\5\u00c6d\2\u03e7\u03ea\5\u008eH\2\u03e8\u03ea\5\u0090I\2\u03e9"+
		"\u03e0\3\2\2\2\u03e9\u03e1\3\2\2\2\u03e9\u03e2\3\2\2\2\u03e9\u03e3\3\2"+
		"\2\2\u03e9\u03e4\3\2\2\2\u03e9\u03e5\3\2\2\2\u03e9\u03e6\3\2\2\2\u03e9"+
		"\u03e7\3\2\2\2\u03e9\u03e8\3\2\2\2\u03ea\u0085\3\2\2\2\u03eb\u03f4\5\u008a"+
		"F\2\u03ec\u03f4\5\u00d2j\2\u03ed\u03f4\5\u00caf\2\u03ee\u03f4\5\u00ce"+
		"h\2\u03ef\u03f4\5\u00d0i\2\u03f0\u03f4\5\u008cG\2\u03f1\u03f4\5\u0088"+
		"E\2\u03f2\u03f4\5\u00b6\\\2\u03f3\u03eb\3\2\2\2\u03f3\u03ec\3\2\2\2\u03f3"+
		"\u03ed\3\2\2\2\u03f3\u03ee\3\2\2\2\u03f3\u03ef\3\2\2\2\u03f3\u03f0\3\2"+
		"\2\2\u03f3\u03f1\3\2\2\2\u03f3\u03f2\3\2\2\2\u03f4\u0087\3\2\2\2\u03f5"+
		"\u03f6\7Q\2\2\u03f6\u03f8\7\u0086\2\2\u03f7\u03f9\5\u00d6l\2\u03f8\u03f7"+
		"\3\2\2\2\u03f8\u03f9\3\2\2\2\u03f9\u03fa\3\2\2\2\u03fa\u03fb\7g\2\2\u03fb"+
		"\u03fc\5\u0100\u0081\2\u03fc\u03fd\7\u0082\2\2\u03fd\u0089\3\2\2\2\u03fe"+
		"\u0400\5\u0094K\2\u03ff\u03fe\3\2\2\2\u03ff\u0400\3\2\2\2\u0400\u0402"+
		"\3\2\2\2\u0401\u0403\5\u00e8u\2\u0402\u0401\3\2\2\2\u0402\u0403\3\2\2"+
		"\2\u0403\u0404\3\2\2\2\u0404\u040d\7\u0082\2\2\u0405\u0407\5\u00d6l\2"+
		"\u0406\u0408\5\u0094K\2\u0407\u0406\3\2\2\2\u0407\u0408\3\2\2\2\u0408"+
		"\u0409\3\2\2\2\u0409\u040a\5\u00e8u\2\u040a\u040b\7\u0082\2\2\u040b\u040d"+
		"\3\2\2\2\u040c\u03ff\3\2\2\2\u040c\u0405\3\2\2\2\u040d\u008b\3\2\2\2\u040e"+
		"\u040f\7B\2\2\u040f\u0410\7W\2\2\u0410\u0411\5^\60\2\u0411\u0412\7|\2"+
		"\2\u0412\u0413\7\6\2\2\u0413\u0414\7X\2\2\u0414\u0415\7\u0082\2\2\u0415"+
		"\u008d\3\2\2\2\u0416\u0417\7\u0082\2\2\u0417\u008f\3\2\2\2\u0418\u0419"+
		"\5\u00d6l\2\u0419\u041a\7\u0082\2\2\u041a\u0091\3\2\2\2\u041b\u0422\5"+
		"\u0096L\2\u041c\u0422\5\u009cO\2\u041d\u0422\5\u0098M\2\u041e\u0422\7"+
		"+\2\2\u041f\u0422\7L\2\2\u0420\u0422\7\31\2\2\u0421\u041b\3\2\2\2\u0421"+
		"\u041c\3\2\2\2\u0421\u041d\3\2\2\2\u0421\u041e\3\2\2\2\u0421\u041f\3\2"+
		"\2\2\u0421\u0420\3\2\2\2\u0422\u0093\3\2\2\2\u0423\u0425\5\u0092J\2\u0424"+
		"\u0423\3\2\2\2\u0425\u0426\3\2\2\2\u0426\u0427\3\2\2\2\u0426\u0424\3\2"+
		"\2\2\u0427\u0429\3\2\2\2\u0428\u042a\5\u00d6l\2\u0429\u0428\3\2\2\2\u0429"+
		"\u042a\3\2\2\2\u042a\u0095\3\2\2\2\u042b\u042c\t\r\2\2\u042c\u0097\3\2"+
		"\2\2\u042d\u042e\t\16\2\2\u042e\u0099\3\2\2\2\u042f\u0430\7\u0086\2\2"+
		"\u0430\u009b\3\2\2\2\u0431\u0435\5\u009eP\2\u0432\u0435\5\u0122\u0092"+
		"\2\u0433\u0435\5\u00b2Z\2\u0434\u0431\3\2\2\2\u0434\u0432\3\2\2\2\u0434"+
		"\u0433\3\2\2\2\u0435\u009d\3\2\2\2\u0436\u043b\5\u00a8U\2\u0437\u043b"+
		"\5\u00aeX\2\u0438\u043b\5\u016a\u00b6\2\u0439\u043b\5\u00fa~\2\u043a\u0436"+
		"\3\2\2\2\u043a\u0437\3\2\2\2\u043a\u0438\3\2\2\2\u043a\u0439\3\2\2\2\u043b"+
		"\u009f\3\2\2\2\u043c\u043e\5\u009cO\2\u043d\u043c\3\2\2\2\u043e\u043f"+
		"\3\2\2\2\u043f\u043d\3\2\2\2\u043f\u0440\3\2\2\2\u0440\u0442\3\2\2\2\u0441"+
		"\u0443\5\u00d6l\2\u0442\u0441\3\2\2\2\u0442\u0443\3\2\2\2\u0443\u00a1"+
		"\3\2\2\2\u0444\u0446\5\u009eP\2\u0445\u0444\3\2\2\2\u0446\u0447\3\2\2"+
		"\2\u0447\u0445\3\2\2\2\u0447\u0448\3\2\2\2\u0448\u044a\3\2\2\2\u0449\u044b"+
		"\5\u00d6l\2\u044a\u0449\3\2\2\2\u044a\u044b\3\2\2\2\u044b\u00a3\3\2\2"+
		"\2\u044c\u044d\t\17\2\2\u044d\u00a5\3\2\2\2\u044e\u044f\t\20\2\2\u044f"+
		"\u00a7\3\2\2\2\u0450\u0452\5\f\7\2\u0451\u0450\3\2\2\2\u0451\u0452\3\2"+
		"\2\2\u0452\u0453\3\2\2\2\u0453\u0469\5\u00aaV\2\u0454\u0455\5\f\7\2\u0455"+
		"\u0456\7F\2\2\u0456\u0457\5\u0160\u00b1\2\u0457\u0469\3\2\2\2\u0458\u0469"+
		"\7\24\2\2\u0459\u0469\7\25\2\2\u045a\u0469\7\26\2\2\u045b\u0469\7U\2\2"+
		"\u045c\u0469\7\20\2\2\u045d\u0469\7>\2\2\u045e\u0469\7/\2\2\u045f\u0469"+
		"\7\60\2\2\u0460\u0469\7)\2\2\u0461\u0469\7?\2\2\u0462\u0469\7P\2\2\u0463"+
		"\u0469\7)\2\2\u0464\u0469\7 \2\2\u0465\u0469\7S\2\2\u0466\u0469\7\17\2"+
		"\2\u0467\u0469\5\u00acW\2\u0468\u0451\3\2\2\2\u0468\u0454\3\2\2\2\u0468"+
		"\u0458\3\2\2\2\u0468\u0459\3\2\2\2\u0468\u045a\3\2\2\2\u0468\u045b\3\2"+
		"\2\2\u0468\u045c\3\2\2\2\u0468\u045d\3\2\2\2\u0468\u045e\3\2\2\2\u0468"+
		"\u045f\3\2\2\2\u0468\u0460\3\2\2\2\u0468\u0461\3\2\2\2\u0468\u0462\3\2"+
		"\2\2\u0468\u0463\3\2\2\2\u0468\u0464\3\2\2\2\u0468\u0465\3\2\2\2\u0468"+
		"\u0466\3\2\2\2\u0468\u0467\3\2\2\2\u0469\u00a9\3\2\2\2\u046a\u046f\5\u0120"+
		"\u0091\2\u046b\u046f\5\u00b0Y\2\u046c\u046f\5\u009aN\2\u046d\u046f\5\u0160"+
		"\u00b1\2\u046e\u046a\3\2\2\2\u046e\u046b\3\2\2\2\u046e\u046c\3\2\2\2\u046e"+
		"\u046d\3\2\2\2\u046f\u00ab\3\2\2\2\u0470\u0471\7\34\2\2\u0471\u0474\7"+
		"W\2\2\u0472\u0475\5\\/\2\u0473\u0475\7\17\2\2\u0474\u0472\3\2\2\2\u0474"+
		"\u0473\3\2\2\2\u0475\u0476\3\2\2\2\u0476\u0477\7X\2\2\u0477\u00ad\3\2"+
		"\2\2\u0478\u0487\5\u012a\u0096\2\u0479\u047b\5\u00d6l\2\u047a\u0479\3"+
		"\2\2\2\u047a\u047b\3\2\2\2\u047b\u047d\3\2\2\2\u047c\u047e\5\f\7\2\u047d"+
		"\u047c\3\2\2\2\u047d\u047e\3\2\2\2\u047e\u047f\3\2\2\2\u047f\u0488\7\u0086"+
		"\2\2\u0480\u0488\5\u0160\u00b1\2\u0481\u0483\5\f\7\2\u0482\u0484\7F\2"+
		"\2\u0483\u0482\3\2\2\2\u0483\u0484\3\2\2\2\u0484\u0485\3\2\2\2\u0485\u0486"+
		"\5\u0160\u00b1\2\u0486\u0488\3\2\2\2\u0487\u047a\3\2\2\2\u0487\u0480\3"+
		"\2\2\2\u0487\u0481\3\2\2\2\u0488\u048f\3\2\2\2\u0489\u048b\7#\2\2\u048a"+
		"\u048c\5\f\7\2\u048b\u048a\3\2\2\2\u048b\u048c\3\2\2\2\u048c\u048d\3\2"+
		"\2\2\u048d\u048f\7\u0086\2\2\u048e\u0478\3\2\2\2\u048e\u0489\3\2\2\2\u048f"+
		"\u00af\3\2\2\2\u0490\u0491\7\u0086\2\2\u0491\u00b1\3\2\2\2\u0492\u0493"+
		"\5\u00b4[\2\u0493\u0498\7[\2\2\u0494\u0496\5\u00bc_\2\u0495\u0497\7|\2"+
		"\2\u0496\u0495\3\2\2\2\u0496\u0497\3\2\2\2\u0497\u0499\3\2\2\2\u0498\u0494"+
		"\3\2\2\2\u0498\u0499\3\2\2\2\u0499\u049a\3\2\2\2\u049a\u049b\7\\\2\2\u049b"+
		"\u00b3\3\2\2\2\u049c\u049e\5\u00b8]\2\u049d\u049f\5\u00d6l\2\u049e\u049d"+
		"\3\2\2\2\u049e\u049f\3\2\2\2\u049f\u04a4\3\2\2\2\u04a0\u04a2\5\f\7\2\u04a1"+
		"\u04a0\3\2\2\2\u04a1\u04a2\3\2\2\2\u04a2\u04a3\3\2\2\2\u04a3\u04a5\7\u0086"+
		"\2\2\u04a4\u04a1\3\2\2\2\u04a4\u04a5\3\2\2\2\u04a5\u04a7\3\2\2\2\u04a6"+
		"\u04a8\5\u00ba^\2\u04a7\u04a6\3\2\2\2\u04a7\u04a8\3\2\2\2\u04a8\u00b5"+
		"\3\2\2\2\u04a9\u04ab\5\u00b8]\2\u04aa\u04ac\5\u00d6l\2\u04ab\u04aa\3\2"+
		"\2\2\u04ab\u04ac\3\2\2\2\u04ac\u04ad\3\2\2\2\u04ad\u04af\7\u0086\2\2\u04ae"+
		"\u04b0\5\u00ba^\2\u04af\u04ae\3\2\2\2\u04af\u04b0\3\2\2\2\u04b0\u04b1"+
		"\3\2\2\2\u04b1\u04b2\7\u0082\2\2\u04b2\u00b7\3\2\2\2\u04b3\u04b5\7#\2"+
		"\2\u04b4\u04b6\t\21\2\2\u04b5\u04b4\3\2\2\2\u04b5\u04b6\3\2\2\2\u04b6"+
		"\u00b9\3\2\2\2\u04b7\u04b8\7\u0080\2\2\u04b8\u04b9\5\u00a0Q\2\u04b9\u00bb"+
		"\3\2\2\2\u04ba\u04bf\5\u00be`\2\u04bb\u04bc\7|\2\2\u04bc\u04be\5\u00be"+
		"`\2\u04bd\u04bb\3\2\2\2\u04be\u04c1\3\2\2\2\u04bf\u04bd\3\2\2\2\u04bf"+
		"\u04c0\3\2\2\2\u04c0\u00bd\3\2\2\2\u04c1\u04bf\3\2\2\2\u04c2\u04c5\5\u00c0"+
		"a\2\u04c3\u04c4\7g\2\2\u04c4\u04c6\5^\60\2\u04c5\u04c3\3\2\2\2\u04c5\u04c6"+
		"\3\2\2\2\u04c6\u00bf\3\2\2\2\u04c7\u04c8\7\u0086\2\2\u04c8\u00c1\3\2\2"+
		"\2\u04c9\u04cc\5\u00c4c\2\u04ca\u04cc\5\u00c8e\2\u04cb\u04c9\3\2\2\2\u04cb"+
		"\u04ca\3\2\2\2\u04cc\u00c3\3\2\2\2\u04cd\u04ce\7\u0086\2\2\u04ce\u00c5"+
		"\3\2\2\2\u04cf\u04d1\7.\2\2\u04d0\u04cf\3\2\2\2\u04d0\u04d1\3\2\2\2\u04d1"+
		"\u04d2\3\2\2\2\u04d2\u04d5\7\62\2\2\u04d3\u04d6\7\u0086\2\2\u04d4\u04d6"+
		"\5\u00c4c\2\u04d5\u04d3\3\2\2\2\u04d5\u04d4\3\2\2\2\u04d5\u04d6\3\2\2"+
		"\2\u04d6\u04d7\3\2\2\2\u04d7\u04d9\7[\2\2\u04d8\u04da\5\u0082B\2\u04d9"+
		"\u04d8\3\2\2\2\u04d9\u04da\3\2\2\2\u04da\u04db\3\2\2\2\u04db\u04dc\7\\"+
		"\2\2\u04dc\u00c7\3\2\2\2\u04dd\u04de\7\u0086\2\2\u04de\u00c9\3\2\2\2\u04df"+
		"\u04e0\7\62\2\2\u04e0\u04e1\7\u0086\2\2\u04e1\u04e2\7g\2\2\u04e2\u04e3"+
		"\5\u00ccg\2\u04e3\u04e4\7\u0082\2\2\u04e4\u00cb\3\2\2\2\u04e5\u04e7\5"+
		"\f\7\2\u04e6\u04e5\3\2\2\2\u04e6\u04e7\3\2\2\2\u04e7\u04e8\3\2\2\2\u04e8"+
		"\u04e9\5\u00c2b\2\u04e9\u00cd\3\2\2\2\u04ea\u04f0\7Q\2\2\u04eb\u04ed\7"+
		"N\2\2\u04ec\u04eb\3\2\2\2\u04ec\u04ed\3\2\2\2\u04ed\u04ee\3\2\2\2\u04ee"+
		"\u04f1\5\f\7\2\u04ef\u04f1\7\u0081\2\2\u04f0\u04ec\3\2\2\2\u04f0\u04ef"+
		"\3\2\2\2\u04f1\u04f2\3\2\2\2\u04f2\u04f3\5\b\5\2\u04f3\u04f4\7\u0082\2"+
		"\2\u04f4\u00cf\3\2\2\2\u04f5\u04f7\5\u00d6l\2\u04f6\u04f5\3\2\2\2\u04f6"+
		"\u04f7\3\2\2\2\u04f7\u04f8\3\2\2\2\u04f8\u04f9\7Q\2\2\u04f9\u04fb\7\62"+
		"\2\2\u04fa\u04fc\5\f\7\2\u04fb\u04fa\3\2\2\2\u04fb\u04fc\3\2\2\2\u04fc"+
		"\u04fd\3\2\2\2\u04fd\u04fe\5\u00c2b\2\u04fe\u04ff\7\u0082\2\2\u04ff\u00d1"+
		"\3\2\2\2\u0500\u0501\7\16\2\2\u0501\u0502\7W\2\2\u0502\u0503\7\6\2\2\u0503"+
		"\u0504\7X\2\2\u0504\u0505\7\u0082\2\2\u0505\u00d3\3\2\2\2\u0506\u0507"+
		"\7&\2\2\u0507\u050e\7\6\2\2\u0508\u050a\7[\2\2\u0509\u050b\5\u0082B\2"+
		"\u050a\u0509\3\2\2\2\u050a\u050b\3\2\2\2\u050b\u050c\3\2\2\2\u050c\u050f"+
		"\7\\\2\2\u050d\u050f\5\u0084C\2\u050e\u0508\3\2\2\2\u050e\u050d\3\2\2"+
		"\2\u050f\u00d5\3\2\2\2\u0510\u0512\5\u00d8m\2\u0511\u0510\3\2\2\2\u0512"+
		"\u0513\3\2\2\2\u0513\u0511\3\2\2\2\u0513\u0514\3\2\2\2\u0514\u00d7\3\2"+
		"\2\2\u0515\u0516\7Y\2\2\u0516\u0518\7Y\2\2\u0517\u0519\5\u00dco\2\u0518"+
		"\u0517\3\2\2\2\u0518\u0519\3\2\2\2\u0519\u051a\3\2\2\2\u051a\u051b\7Z"+
		"\2\2\u051b\u051e\7Z\2\2\u051c\u051e\5\u00dan\2\u051d\u0515\3\2\2\2\u051d"+
		"\u051c\3\2\2\2\u051e\u00d9\3\2\2\2\u051f\u0520\7\f\2\2\u0520\u0523\7W"+
		"\2\2\u0521\u0524\5\u0100\u0081\2\u0522\u0524\5^\60\2\u0523\u0521\3\2\2"+
		"\2\u0523\u0522\3\2\2\2\u0524\u0526\3\2\2\2\u0525\u0527\7\u0085\2\2\u0526"+
		"\u0525\3\2\2\2\u0526\u0527\3\2\2\2\u0527\u0528\3\2\2\2\u0528\u0529\7X"+
		"\2\2\u0529\u00db\3\2\2\2\u052a\u052f\5\u00dep\2\u052b\u052c\7|\2\2\u052c"+
		"\u052e\5\u00dep\2\u052d\u052b\3\2\2\2\u052e\u0531\3\2\2\2\u052f\u052d"+
		"\3\2\2\2\u052f\u0530\3\2\2\2\u0530\u0533\3\2\2\2\u0531\u052f\3\2\2\2\u0532"+
		"\u0534\7\u0085\2\2\u0533\u0532\3\2\2\2\u0533\u0534\3\2\2\2\u0534\u00dd"+
		"\3\2\2\2\u0535\u0536\5\u00e0q\2\u0536\u0537\7\u0081\2\2\u0537\u0539\3"+
		"\2\2\2\u0538\u0535\3\2\2\2\u0538\u0539\3\2\2\2\u0539\u053a\3\2\2\2\u053a"+
		"\u053c\7\u0086\2\2\u053b\u053d\5\u00e2r\2\u053c\u053b\3\2\2\2\u053c\u053d"+
		"\3\2\2\2\u053d\u00df\3\2\2\2\u053e\u053f\7\u0086\2\2\u053f\u00e1\3\2\2"+
		"\2\u0540\u0542\7W\2\2\u0541\u0543\5\u00e4s\2\u0542\u0541\3\2\2\2\u0542"+
		"\u0543\3\2\2\2\u0543\u0544\3\2\2\2\u0544\u0545\7X\2\2\u0545\u00e3\3\2"+
		"\2\2\u0546\u0548\5\u00e6t\2\u0547\u0546\3\2\2\2\u0548\u0549\3\2\2\2\u0549"+
		"\u0547\3\2\2\2\u0549\u054a\3\2\2\2\u054a\u00e5\3\2\2\2\u054b\u054c\7W"+
		"\2\2\u054c\u054d\5\u00e4s\2\u054d\u054e\7X\2\2\u054e\u055d\3\2\2\2\u054f"+
		"\u0550\7Y\2\2\u0550\u0551\5\u00e4s\2\u0551\u0552\7Z\2\2\u0552\u055d\3"+
		"\2\2\2\u0553\u0554\7[\2\2\u0554\u0555\5\u00e4s\2\u0555\u0556\7\\\2\2\u0556"+
		"\u055d\3\2\2\2\u0557\u0559\n\22\2\2\u0558\u0557\3\2\2\2\u0559\u055a\3"+
		"\2\2\2\u055a\u0558\3\2\2\2\u055a\u055b\3\2\2\2\u055b\u055d\3\2\2\2\u055c"+
		"\u054b\3\2\2\2\u055c\u054f\3\2\2\2\u055c\u0553\3\2\2\2\u055c\u0558\3\2"+
		"\2\2\u055d\u00e7\3\2\2\2\u055e\u0563\5\u00eav\2\u055f\u0560\7|\2\2\u0560"+
		"\u0562\5\u00eav\2\u0561\u055f\3\2\2\2\u0562\u0565\3\2\2\2\u0563\u0561"+
		"\3\2\2\2\u0563\u0564\3\2\2\2\u0564\u00e9\3\2\2\2\u0565\u0563\3\2\2\2\u0566"+
		"\u0568\5\u00ecw\2\u0567\u0569\5\u0116\u008c\2\u0568\u0567\3\2\2\2\u0568"+
		"\u0569\3\2\2\2\u0569\u00eb\3\2\2\2\u056a\u0570\5\u00eex\2\u056b\u056c"+
		"\5\u00f0y\2\u056c\u056d\5\u00f2z\2\u056d\u056e\5\u00f4{\2\u056e\u0570"+
		"\3\2\2\2\u056f\u056a\3\2\2\2\u056f\u056b\3\2\2\2\u0570\u00ed\3\2\2\2\u0571"+
		"\u0573\5\u00f6|\2\u0572\u0574\7\30\2\2\u0573\u0572\3\2\2\2\u0573\u0574"+
		"\3\2\2\2\u0574\u0576\3\2\2\2\u0575\u0571\3\2\2\2\u0576\u0579\3\2\2\2\u0577"+
		"\u0575\3\2\2\2\u0577\u0578\3\2\2\2\u0578\u057a\3\2\2\2\u0579\u0577\3\2"+
		"\2\2\u057a\u057b\5\u00f0y\2\u057b\u00ef\3\2\2\2\u057c\u057d\by\1\2\u057d"+
		"\u057f\5\u00fe\u0080\2\u057e\u0580\5\u00d6l\2\u057f\u057e\3\2\2\2\u057f"+
		"\u0580\3\2\2\2\u0580\u0586\3\2\2\2\u0581\u0582\7W\2\2\u0582\u0583\5\u00ee"+
		"x\2\u0583\u0584\7X\2\2\u0584\u0586\3\2\2\2\u0585\u057c\3\2\2\2\u0585\u0581"+
		"\3\2\2\2\u0586\u0595\3\2\2\2\u0587\u0591\f\4\2\2\u0588\u0592\5\u00f2z"+
		"\2\u0589\u058b\7Y\2\2\u058a\u058c\5^\60\2\u058b\u058a\3\2\2\2\u058b\u058c"+
		"\3\2\2\2\u058c\u058d\3\2\2\2\u058d\u058f\7Z\2\2\u058e\u0590\5\u00d6l\2"+
		"\u058f\u058e\3\2\2\2\u058f\u0590\3\2\2\2\u0590\u0592\3\2\2\2\u0591\u0588"+
		"\3\2\2\2\u0591\u0589\3\2\2\2\u0592\u0594\3\2\2\2\u0593\u0587\3\2\2\2\u0594"+
		"\u0597\3\2\2\2\u0595\u0593\3\2\2\2\u0595\u0596\3\2\2\2\u0596\u00f1\3\2"+
		"\2\2\u0597\u0595\3\2\2\2\u0598\u059a\7W\2\2\u0599\u059b\5\u010c\u0087"+
		"\2\u059a\u0599\3\2\2\2\u059a\u059b\3\2\2\2\u059b\u059c\3\2\2\2\u059c\u059e"+
		"\7X\2\2\u059d\u059f\5\u00f8}\2\u059e\u059d\3\2\2\2\u059e\u059f\3\2\2\2"+
		"\u059f\u05a1\3\2\2\2\u05a0\u05a2\5\u00fc\177\2\u05a1\u05a0\3\2\2\2\u05a1"+
		"\u05a2\3\2\2\2\u05a2\u05a4\3\2\2\2\u05a3\u05a5\5\u017c\u00bf\2\u05a4\u05a3"+
		"\3\2\2\2\u05a4\u05a5\3\2\2\2\u05a5\u05a7\3\2\2\2\u05a6\u05a8\5\u00d6l"+
		"\2\u05a7\u05a6\3\2\2\2\u05a7\u05a8\3\2\2\2\u05a8\u00f3\3\2\2\2\u05a9\u05aa"+
		"\7~\2\2\u05aa\u05ac\5\u00a2R\2\u05ab\u05ad\5\u0102\u0082\2\u05ac\u05ab"+
		"\3\2\2\2\u05ac\u05ad\3\2\2\2\u05ad\u00f5\3\2\2\2\u05ae\u05b0\t\23\2\2"+
		"\u05af\u05b1\5\u00d6l\2\u05b0\u05af\3\2\2\2\u05b0\u05b1\3\2\2\2\u05b1"+
		"\u05bd\3\2\2\2\u05b2\u05b4\5\f\7\2\u05b3\u05b2\3\2\2\2\u05b3\u05b4\3\2"+
		"\2\2\u05b4\u05b5\3\2\2\2\u05b5\u05b7\7_\2\2\u05b6\u05b8\5\u00d6l\2\u05b7"+
		"\u05b6\3\2\2\2\u05b7\u05b8\3\2\2\2\u05b8\u05ba\3\2\2\2\u05b9\u05bb\5\u00f8"+
		"}\2\u05ba\u05b9\3\2\2\2\u05ba\u05bb\3\2\2\2\u05bb\u05bd\3\2\2\2\u05bc"+
		"\u05ae\3\2\2\2\u05bc\u05b3\3\2\2\2\u05bd\u00f7\3\2\2\2\u05be\u05c0\5\u00fa"+
		"~\2\u05bf\u05be\3\2\2\2\u05c0\u05c1\3\2\2\2\u05c1\u05bf\3\2\2\2\u05c1"+
		"\u05c2\3\2\2\2\u05c2\u00f9\3\2\2\2\u05c3\u05c4\t\24\2\2\u05c4\u00fb\3"+
		"\2\2\2\u05c5\u05c6\t\23\2\2\u05c6\u00fd\3\2\2\2\u05c7\u05c9\7\u0085\2"+
		"\2\u05c8\u05c7\3\2\2\2\u05c8\u05c9\3\2\2\2\u05c9\u05ca\3\2\2\2\u05ca\u05cb"+
		"\5\6\4\2\u05cb\u00ff\3\2\2\2\u05cc\u05ce\5\u00a0Q\2\u05cd\u05cf\5\u0102"+
		"\u0082\2\u05ce\u05cd\3\2\2\2\u05ce\u05cf\3\2\2\2\u05cf\u0101\3\2\2\2\u05d0"+
		"\u05d9\5\u0104\u0083\2\u05d1\u05d3\5\u0106\u0084\2\u05d2\u05d1\3\2\2\2"+
		"\u05d2\u05d3\3\2\2\2\u05d3\u05d4\3\2\2\2\u05d4\u05d5\5\u00f2z\2\u05d5"+
		"\u05d6\5\u00f4{\2\u05d6\u05d9\3\2\2\2\u05d7\u05d9\5\u0108\u0085\2\u05d8"+
		"\u05d0\3\2\2\2\u05d8\u05d2\3\2\2\2\u05d8\u05d7\3\2\2\2\u05d9\u0103\3\2"+
		"\2\2\u05da\u05dc\5\u00f6|\2\u05db\u05da\3\2\2\2\u05dc\u05df\3\2\2\2\u05dd"+
		"\u05db\3\2\2\2\u05dd\u05de\3\2\2\2\u05de\u05e2\3\2\2\2\u05df\u05dd\3\2"+
		"\2\2\u05e0\u05e3\5\u0106\u0084\2\u05e1\u05e3\5\u00f6|\2\u05e2\u05e0\3"+
		"\2\2\2\u05e2\u05e1\3\2\2\2\u05e3\u0105\3\2\2\2\u05e4\u05ea\5\u00f2z\2"+
		"\u05e5\u05e6\7W\2\2\u05e6\u05e7\5\u0104\u0083\2\u05e7\u05e8\7X\2\2\u05e8"+
		"\u05ea\3\2\2\2\u05e9\u05e4\3\2\2\2\u05e9\u05e5\3\2\2\2\u05ea\u05f6\3\2"+
		"\2\2\u05eb\u05f5\5\u00f2z\2\u05ec\u05ee\7Y\2\2\u05ed\u05ef\5^\60\2\u05ee"+
		"\u05ed\3\2\2\2\u05ee\u05ef\3\2\2\2\u05ef\u05f0\3\2\2\2\u05f0\u05f2\7Z"+
		"\2\2\u05f1\u05f3\5\u00d6l\2\u05f2\u05f1\3\2\2\2\u05f2\u05f3\3\2\2\2\u05f3"+
		"\u05f5\3\2\2\2\u05f4\u05eb\3\2\2\2\u05f4\u05ec\3\2\2\2\u05f5\u05f8\3\2"+
		"\2\2\u05f6\u05f4\3\2\2\2\u05f6\u05f7\3\2\2\2\u05f7\u0107\3\2\2\2\u05f8"+
		"\u05f6\3\2\2\2\u05f9\u05fb\5\u00f6|\2\u05fa\u05f9\3\2\2\2\u05fb\u05fe"+
		"\3\2\2\2\u05fc\u05fa\3\2\2\2\u05fc\u05fd\3\2\2\2\u05fd\u05ff\3\2\2\2\u05fe"+
		"\u05fc\3\2\2\2\u05ff\u0600\5\u010a\u0086\2\u0600\u0109\3\2\2\2\u0601\u060d"+
		"\7\u0085\2\2\u0602\u060c\5\u00f2z\2\u0603\u0605\7Y\2\2\u0604\u0606\5^"+
		"\60\2\u0605\u0604\3\2\2\2\u0605\u0606\3\2\2\2\u0606\u0607\3\2\2\2\u0607"+
		"\u0609\7Z\2\2\u0608\u060a\5\u00d6l\2\u0609\u0608\3\2\2\2\u0609\u060a\3"+
		"\2\2\2\u060a\u060c\3\2\2\2\u060b\u0602\3\2\2\2\u060b\u0603\3\2\2\2\u060c"+
		"\u060f\3\2\2\2\u060d\u060b\3\2\2\2\u060d\u060e\3\2\2\2\u060e\u010b\3\2"+
		"\2\2\u060f\u060d\3\2\2\2\u0610\u0615\5\u010e\u0088\2\u0611\u0613\7|\2"+
		"\2\u0612\u0611\3\2\2\2\u0612\u0613\3\2\2\2\u0613\u0614\3\2\2\2\u0614\u0616"+
		"\7\u0085\2\2\u0615\u0612\3\2\2\2\u0615\u0616\3\2\2\2\u0616\u010d\3\2\2"+
		"\2\u0617\u061c\5\u0110\u0089\2\u0618\u0619\7|\2\2\u0619\u061b\5\u0110"+
		"\u0089\2\u061a\u0618\3\2\2\2\u061b\u061e\3\2\2\2\u061c\u061a\3\2\2\2\u061c"+
		"\u061d\3\2\2\2\u061d\u010f\3\2\2\2\u061e\u061c\3\2\2\2\u061f\u0621\5\u00d6"+
		"l\2\u0620\u061f\3\2\2\2\u0620\u0621\3\2\2\2\u0621\u0622\3\2\2\2\u0622"+
		"\u0627\5\u0094K\2\u0623\u0628\5\u00ecw\2\u0624\u0626\5\u0102\u0082\2\u0625"+
		"\u0624\3\2\2\2\u0625\u0626\3\2\2\2\u0626\u0628\3\2\2\2\u0627\u0623\3\2"+
		"\2\2\u0627\u0625\3\2\2\2\u0628\u062b\3\2\2\2\u0629\u062a\7g\2\2\u062a"+
		"\u062c\5\u011a\u008e\2\u062b\u0629\3\2\2\2\u062b\u062c\3\2\2\2\u062c\u0111"+
		"\3\2\2\2\u062d\u062f\5\u00d6l\2\u062e\u062d\3\2\2\2\u062e\u062f\3\2\2"+
		"\2\u062f\u0631\3\2\2\2\u0630\u0632\5\u0094K\2\u0631\u0630\3\2\2\2\u0631"+
		"\u0632\3\2\2\2\u0632\u0633\3\2\2\2\u0633\u0635\5\u00ecw\2\u0634\u0636"+
		"\5\u0134\u009b\2\u0635\u0634\3\2\2\2\u0635\u0636\3\2\2\2\u0636\u0637\3"+
		"\2\2\2\u0637\u0638\5\u0114\u008b\2\u0638\u0113\3\2\2\2\u0639\u063b\5\u014c"+
		"\u00a7\2\u063a\u0639\3\2\2\2\u063a\u063b\3\2\2\2\u063b\u063c\3\2\2\2\u063c"+
		"\u0642\5f\64\2\u063d\u0642\5\u0172\u00ba\2\u063e\u063f\7g\2\2\u063f\u0640"+
		"\t\25\2\2\u0640\u0642\7\u0082\2\2\u0641\u063a\3\2\2\2\u0641\u063d\3\2"+
		"\2\2\u0641\u063e\3\2\2\2\u0642\u0115\3\2\2\2\u0643\u0649\5\u0118\u008d"+
		"\2\u0644\u0645\7W\2\2\u0645\u0646\5$\23\2\u0646\u0647\7X\2\2\u0647\u0649"+
		"\3\2\2\2\u0648\u0643\3\2\2\2\u0648\u0644\3\2\2\2\u0649\u0117\3\2\2\2\u064a"+
		"\u064b\7g\2\2\u064b\u064e\5\u011a\u008e\2\u064c\u064e\5\u011e\u0090\2"+
		"\u064d\u064a\3\2\2\2\u064d\u064c\3\2\2\2\u064e\u0119\3\2\2\2\u064f\u0652"+
		"\5X-\2\u0650\u0652\5\u011e\u0090\2\u0651\u064f\3\2\2\2\u0651\u0650\3\2"+
		"\2\2\u0652\u011b\3\2\2\2\u0653\u0655\5\u011a\u008e\2\u0654\u0656\7\u0085"+
		"\2\2\u0655\u0654\3\2\2\2\u0655\u0656\3\2\2\2\u0656\u065e\3\2\2\2\u0657"+
		"\u0658\7|\2\2\u0658\u065a\5\u011a\u008e\2\u0659\u065b\7\u0085\2\2\u065a"+
		"\u0659\3\2\2\2\u065a\u065b\3\2\2\2\u065b\u065d\3\2\2\2\u065c\u0657\3\2"+
		"\2\2\u065d\u0660\3\2\2\2\u065e\u065c\3\2\2\2\u065e\u065f\3\2\2\2\u065f"+
		"\u011d\3\2\2\2\u0660\u065e\3\2\2\2\u0661\u0666\7[\2\2\u0662\u0664\5\u011c"+
		"\u008f\2\u0663\u0665\7|\2\2\u0664\u0663\3\2\2\2\u0664\u0665\3\2\2\2\u0665"+
		"\u0667\3\2\2\2\u0666\u0662\3\2\2\2\u0666\u0667\3\2\2\2\u0667\u0668\3\2"+
		"\2\2\u0668\u0669\7\\\2\2\u0669\u011f\3\2\2\2\u066a\u066d\7\u0086\2\2\u066b"+
		"\u066d\5\u0160\u00b1\2\u066c\u066a\3\2\2\2\u066c\u066b\3\2\2\2\u066d\u0121"+
		"\3\2\2\2\u066e\u066f\5\u0124\u0093\2\u066f\u0671\7[\2\2\u0670\u0672\5"+
		"\u012c\u0097\2\u0671\u0670\3\2\2\2\u0671\u0672\3\2\2\2\u0672\u0673\3\2"+
		"\2\2\u0673\u0674\7\\\2\2\u0674\u0123\3\2\2\2\u0675\u0677\5\u012a\u0096"+
		"\2\u0676\u0678\5\u00d6l\2\u0677\u0676\3\2\2\2\u0677\u0678\3\2\2\2\u0678"+
		"\u067d\3\2\2\2\u0679\u067b\5\u0126\u0094\2\u067a\u067c\5\u0128\u0095\2"+
		"\u067b\u067a\3\2\2\2\u067b\u067c\3\2\2\2\u067c\u067e\3\2\2\2\u067d\u0679"+
		"\3\2\2\2\u067d\u067e\3\2\2\2\u067e\u0680\3\2\2\2\u067f\u0681\5\u013a\u009e"+
		"\2\u0680\u067f\3\2\2\2\u0680\u0681\3\2\2\2\u0681\u068d\3\2\2\2\u0682\u0684"+
		"\7O\2\2\u0683\u0685\5\u00d6l\2\u0684\u0683\3\2\2\2\u0684\u0685\3\2\2\2"+
		"\u0685\u068a\3\2\2\2\u0686\u0688\5\u0126\u0094\2\u0687\u0689\5\u0128\u0095"+
		"\2\u0688\u0687\3\2\2\2\u0688\u0689\3\2\2\2\u0689\u068b\3\2\2\2\u068a\u0686"+
		"\3\2\2\2\u068a\u068b\3\2\2\2\u068b\u068d\3\2\2\2\u068c\u0675\3\2\2\2\u068c"+
		"\u0682\3\2\2\2\u068d\u0125\3\2\2\2\u068e\u0690\5\f\7\2\u068f\u068e\3\2"+
		"\2\2\u068f\u0690\3\2\2\2\u0690\u0691\3\2\2\2\u0691\u0692\5\u0120\u0091"+
		"\2\u0692\u0127\3\2\2\2\u0693\u0694\7(\2\2\u0694\u0129\3\2\2\2\u0695\u0696"+
		"\t\21\2\2\u0696\u012b\3\2\2\2\u0697\u069c\5\u012e\u0098\2\u0698\u0699"+
		"\5\u0144\u00a3\2\u0699\u069a\7\u0080\2\2\u069a\u069c\3\2\2\2\u069b\u0697"+
		"\3\2\2\2\u069b\u0698\3\2\2\2\u069c\u069d\3\2\2\2\u069d\u069b\3\2\2\2\u069d"+
		"\u069e\3\2\2\2\u069e\u012d\3\2\2\2\u069f\u06a1\5\u00d6l\2\u06a0\u069f"+
		"\3\2\2\2\u06a0\u06a1\3\2\2\2\u06a1\u06a3\3\2\2\2\u06a2\u06a4\5\u0094K"+
		"\2\u06a3\u06a2\3\2\2\2\u06a3\u06a4\3\2\2\2\u06a4\u06a6\3\2\2\2\u06a5\u06a7"+
		"\5\u0130\u0099\2\u06a6\u06a5\3\2\2\2\u06a6\u06a7\3\2\2\2\u06a7\u06a8\3"+
		"\2\2\2\u06a8\u06b0\7\u0082\2\2\u06a9\u06b0\5\u0112\u008a\2\u06aa\u06b0"+
		"\5\u00ceh\2\u06ab\u06b0\5\u008cG\2\u06ac\u06b0\5\u0158\u00ad\2\u06ad\u06b0"+
		"\5\u0088E\2\u06ae\u06b0\5\u008eH\2\u06af\u06a0\3\2\2\2\u06af\u06a9\3\2"+
		"\2\2\u06af\u06aa\3\2\2\2\u06af\u06ab\3\2\2\2\u06af\u06ac\3\2\2\2\u06af"+
		"\u06ad\3\2\2\2\u06af\u06ae\3\2\2\2\u06b0\u012f\3\2\2\2\u06b1\u06b6\5\u0132"+
		"\u009a\2\u06b2\u06b3\7|\2\2\u06b3\u06b5\5\u0132\u009a\2\u06b4\u06b2\3"+
		"\2\2\2\u06b5\u06b8\3\2\2\2\u06b6\u06b4\3\2\2\2\u06b6\u06b7\3\2\2\2\u06b7"+
		"\u0131\3\2\2\2\u06b8\u06b6\3\2\2\2\u06b9\u06c2\5\u00ecw\2\u06ba\u06c3"+
		"\5\u0134\u009b\2\u06bb\u06bc\6\u009a\t\2\u06bc\u06c3\5\u0138\u009d\2\u06bd"+
		"\u06be\6\u009a\n\2\u06be\u06bf\5\u0134\u009b\2\u06bf\u06c0\5\u0138\u009d"+
		"\2\u06c0\u06c3\3\2\2\2\u06c1\u06c3\5\u0118\u008d\2\u06c2\u06ba\3\2\2\2"+
		"\u06c2\u06bb\3\2\2\2\u06c2\u06bd\3\2\2\2\u06c2\u06c1\3\2\2\2\u06c3\u06ce"+
		"\3\2\2\2\u06c4\u06ce\5\u00ecw\2\u06c5\u06c7\7\u0086\2\2\u06c6\u06c5\3"+
		"\2\2\2\u06c6\u06c7\3\2\2\2\u06c7\u06c9\3\2\2\2\u06c8\u06ca\5\u00d6l\2"+
		"\u06c9\u06c8\3\2\2\2\u06c9\u06ca\3\2\2\2\u06ca\u06cb\3\2\2\2\u06cb\u06cc"+
		"\7\u0080\2\2\u06cc\u06ce\5^\60\2\u06cd\u06b9\3\2\2\2\u06cd\u06c4\3\2\2"+
		"\2\u06cd\u06c6\3\2\2\2\u06ce\u0133\3\2\2\2\u06cf\u06d1\5\u0136\u009c\2"+
		"\u06d0\u06cf\3\2\2\2\u06d1\u06d2\3\2\2\2\u06d2\u06d0\3\2\2\2\u06d2\u06d3"+
		"\3\2\2\2\u06d3\u0135\3\2\2\2\u06d4\u06d5\t\26\2\2\u06d5\u0137\3\2\2\2"+
		"\u06d6\u06d7\7g\2\2\u06d7\u06d8\7\3\2\2\u06d8\u0139\3\2\2\2\u06d9\u06da"+
		"\7\u0080\2\2\u06da\u06db\5\u013c\u009f\2\u06db\u013b\3\2\2\2\u06dc\u06de"+
		"\5\u013e\u00a0\2\u06dd\u06df\7\u0085\2\2\u06de\u06dd\3\2\2\2\u06de\u06df"+
		"\3\2\2\2\u06df\u06e7\3\2\2\2\u06e0\u06e1\7|\2\2\u06e1\u06e3\5\u013e\u00a0"+
		"\2\u06e2\u06e4\7\u0085\2\2\u06e3\u06e2\3\2\2\2\u06e3\u06e4\3\2\2\2\u06e4"+
		"\u06e6\3\2\2\2\u06e5\u06e0\3\2\2\2\u06e6\u06e9\3\2\2\2\u06e7\u06e5\3\2"+
		"\2\2\u06e7\u06e8\3\2\2\2\u06e8\u013d\3\2\2\2\u06e9\u06e7\3\2\2\2\u06ea"+
		"\u06ec\5\u00d6l\2\u06eb\u06ea\3\2\2\2\u06eb\u06ec\3\2\2\2\u06ec\u06f9"+
		"\3\2\2\2\u06ed\u06fa\5\u0142\u00a2\2\u06ee\u06f0\7R\2\2\u06ef\u06f1\5"+
		"\u0144\u00a3\2\u06f0\u06ef\3\2\2\2\u06f0\u06f1\3\2\2\2\u06f1\u06f2\3\2"+
		"\2\2\u06f2\u06fa\5\u0142\u00a2\2\u06f3\u06f5\5\u0144\u00a3\2\u06f4\u06f6"+
		"\7R\2\2\u06f5\u06f4\3\2\2\2\u06f5\u06f6\3\2\2\2\u06f6\u06f7\3\2\2\2\u06f7"+
		"\u06f8\5\u0142\u00a2\2\u06f8\u06fa\3\2\2\2\u06f9\u06ed\3\2\2\2\u06f9\u06ee"+
		"\3\2\2\2\u06f9\u06f3\3\2\2\2\u06fa\u013f\3\2\2\2\u06fb\u06fd\5\f\7\2\u06fc"+
		"\u06fb\3\2\2\2\u06fc\u06fd\3\2\2\2\u06fd\u06fe\3\2\2\2\u06fe\u0701\5\u0120"+
		"\u0091\2\u06ff\u0701\5\u00acW\2\u0700\u06fc\3\2\2\2\u0700\u06ff\3\2\2"+
		"\2\u0701\u0141\3\2\2\2\u0702\u0703\5\u0140\u00a1\2\u0703\u0143\3\2\2\2"+
		"\u0704\u0705\t\27\2\2\u0705\u0145\3\2\2\2\u0706\u0707\7\66\2\2\u0707\u0708"+
		"\5\u0148\u00a5\2\u0708\u0147\3\2\2\2\u0709\u070b\5\u00a0Q\2\u070a\u070c"+
		"\5\u014a\u00a6\2\u070b\u070a\3\2\2\2\u070b\u070c\3\2\2\2\u070c\u0149\3"+
		"\2\2\2\u070d\u070f\5\u00f6|\2\u070e\u0710\5\u014a\u00a6\2\u070f\u070e"+
		"\3\2\2\2\u070f\u0710\3\2\2\2\u0710\u014b\3\2\2\2\u0711\u0712\7\u0080\2"+
		"\2\u0712\u0713\5\u014e\u00a8\2\u0713\u014d\3\2\2\2\u0714\u0716\5\u0150"+
		"\u00a9\2\u0715\u0717\7\u0085\2\2\u0716\u0715\3\2\2\2\u0716\u0717\3\2\2"+
		"\2\u0717\u071f\3\2\2\2\u0718\u0719\7|\2\2\u0719\u071b\5\u0150\u00a9\2"+
		"\u071a\u071c\7\u0085\2\2\u071b\u071a\3\2\2\2\u071b\u071c\3\2\2\2\u071c"+
		"\u071e\3\2\2\2\u071d\u0718\3\2\2\2\u071e\u0721\3\2\2\2\u071f\u071d\3\2"+
		"\2\2\u071f\u0720\3\2\2\2\u0720\u014f\3\2\2\2\u0721\u071f\3\2\2\2\u0722"+
		"\u0729\5\u0152\u00aa\2\u0723\u0725\7W\2\2\u0724\u0726\5$\23\2\u0725\u0724"+
		"\3\2\2\2\u0725\u0726\3\2\2\2\u0726\u0727\3\2\2\2\u0727\u072a\7X\2\2\u0728"+
		"\u072a\5\u011e\u0090\2\u0729\u0723\3\2\2\2\u0729\u0728\3\2\2\2\u072a\u0151"+
		"\3\2\2\2\u072b\u072e\5\u0140\u00a1\2\u072c\u072e\7\u0086\2\2\u072d\u072b"+
		"\3\2\2\2\u072d\u072c\3\2\2\2\u072e\u0153\3\2\2\2\u072f\u0730\7\66\2\2"+
		"\u0730\u0731\5\u0184\u00c3\2\u0731\u0155\3\2\2\2\u0732\u0736\7\66\2\2"+
		"\u0733\u0734\7\6\2\2\u0734\u0737\7\u0086\2\2\u0735\u0737\7\u008e\2\2\u0736"+
		"\u0733\3\2\2\2\u0736\u0735\3\2\2\2\u0737\u0157\3\2\2\2\u0738\u0739\7F"+
		"\2\2\u0739\u073a\7h\2\2\u073a\u073b\5\u015a\u00ae\2\u073b\u073c\7i\2\2"+
		"\u073c\u073d\5\u0084C\2\u073d\u0159\3\2\2\2\u073e\u0743\5\u015c\u00af"+
		"\2\u073f\u0740\7|\2\2\u0740\u0742\5\u015c\u00af\2\u0741\u073f\3\2\2\2"+
		"\u0742\u0745\3\2\2\2\u0743\u0741\3\2\2\2\u0743\u0744\3\2\2\2\u0744\u015b"+
		"\3\2\2\2\u0745\u0743\3\2\2\2\u0746\u0749\5\u015e\u00b0\2\u0747\u0749\5"+
		"\u0110\u0089\2\u0748\u0746\3\2\2\2\u0748\u0747\3\2\2\2\u0749\u015d\3\2"+
		"\2\2\u074a\u074b\7F\2\2\u074b\u074c\7h\2\2\u074c\u074d\5\u015a\u00ae\2"+
		"\u074d\u074e\7i\2\2\u074e\u0750\3\2\2\2\u074f\u074a\3\2\2\2\u074f\u0750"+
		"\3\2\2\2\u0750\u0751\3\2\2\2\u0751\u0754\7\27\2\2\u0752\u0754\7N\2\2\u0753"+
		"\u074f\3\2\2\2\u0753\u0752\3\2\2\2\u0754\u0760\3\2\2\2\u0755\u0757\7\u0085"+
		"\2\2\u0756\u0755\3\2\2\2\u0756\u0757\3\2\2\2\u0757\u0759\3\2\2\2\u0758"+
		"\u075a\7\u0086\2\2\u0759\u0758\3\2\2\2\u0759\u075a\3\2\2\2\u075a\u0761"+
		"\3\2\2\2\u075b\u075d\7\u0086\2\2\u075c\u075b\3\2\2\2\u075c\u075d\3\2\2"+
		"\2\u075d\u075e\3\2\2\2\u075e\u075f\7g\2\2\u075f\u0761\5\u0100\u0081\2"+
		"\u0760\u0756\3\2\2\2\u0760\u075c\3\2\2\2\u0761\u015f\3\2\2\2\u0762\u0763"+
		"\5\u0164\u00b3\2\u0763\u0765\7h\2\2\u0764\u0766\5\u0166\u00b4\2\u0765"+
		"\u0764\3\2\2\2\u0765\u0766\3\2\2\2\u0766\u0767\3\2\2\2\u0767\u0768\7i"+
		"\2\2\u0768\u0161\3\2\2\2\u0769\u0775\5\u0160\u00b1\2\u076a\u076d\5\u0154"+
		"\u00ab\2\u076b\u076d\5\u0156\u00ac\2\u076c\u076a\3\2\2\2\u076c\u076b\3"+
		"\2\2\2\u076d\u076e\3\2\2\2\u076e\u0770\7h\2\2\u076f\u0771\5\u0166\u00b4"+
		"\2\u0770\u076f\3\2\2\2\u0770\u0771\3\2\2\2\u0771\u0772\3\2\2\2\u0772\u0773"+
		"\7i\2\2\u0773\u0775\3\2\2\2\u0774\u0769\3\2\2\2\u0774\u076c\3\2\2\2\u0775"+
		"\u0163\3\2\2\2\u0776\u0777\7\u0086\2\2\u0777\u0165\3\2\2\2\u0778\u077a"+
		"\5\u0168\u00b5\2\u0779\u077b\7\u0085\2\2\u077a\u0779\3\2\2\2\u077a\u077b"+
		"\3\2\2\2\u077b\u0783\3\2\2\2\u077c\u077d\7|\2\2\u077d\u077f\5\u0168\u00b5"+
		"\2\u077e\u0780\7\u0085\2\2\u077f\u077e\3\2\2\2\u077f\u0780\3\2\2\2\u0780"+
		"\u0782\3\2\2\2\u0781\u077c\3\2\2\2\u0782\u0785\3\2\2\2\u0783\u0781\3\2"+
		"\2\2\u0783\u0784\3\2\2\2\u0784\u0167\3\2\2\2\u0785\u0783\3\2\2\2\u0786"+
		"\u078a\5\u0100\u0081\2\u0787\u078a\5^\60\2\u0788\u078a\5\6\4\2\u0789\u0786"+
		"\3\2\2\2\u0789\u0787\3\2\2\2\u0789\u0788\3\2\2\2\u078a\u0169\3\2\2\2\u078b"+
		"\u078c\7N\2\2\u078c\u0792\5\f\7\2\u078d\u0793\7\u0086\2\2\u078e\u0790"+
		"\7F\2\2\u078f\u078e\3\2\2\2\u078f\u0790\3\2\2\2\u0790\u0791\3\2\2\2\u0791"+
		"\u0793\5\u0160\u00b1\2\u0792\u078d\3\2\2\2\u0792\u078f\3\2\2\2\u0793\u016b"+
		"\3\2\2\2\u0794\u0796\7&\2\2\u0795\u0794\3\2\2\2\u0795\u0796\3\2\2\2\u0796"+
		"\u0797\3\2\2\2\u0797\u0798\7F\2\2\u0798\u0799\5\u0084C\2\u0799\u016d\3"+
		"\2\2\2\u079a\u079b\7F\2\2\u079b\u079c\7h\2\2\u079c\u079d\7i\2\2\u079d"+
		"\u079e\5\u0084C\2\u079e\u016f\3\2\2\2\u079f\u07a0\7K\2\2\u07a0\u07a1\5"+
		"f\64\2\u07a1\u07a2\5\u0174\u00bb\2\u07a2\u0171\3\2\2\2\u07a3\u07a5\7K"+
		"\2\2\u07a4\u07a6\5\u014c\u00a7\2\u07a5\u07a4\3\2\2\2\u07a5\u07a6\3\2\2"+
		"\2\u07a6\u07a7\3\2\2\2\u07a7\u07a8\5f\64\2\u07a8\u07a9\5\u0174\u00bb\2"+
		"\u07a9\u0173\3\2\2\2\u07aa\u07ac\5\u0176\u00bc\2\u07ab\u07aa\3\2\2\2\u07ac"+
		"\u07ad\3\2\2\2\u07ad\u07ab\3\2\2\2\u07ad\u07ae\3\2\2\2\u07ae\u0175\3\2"+
		"\2\2\u07af\u07b0\7\23\2\2\u07b0\u07b1\7W\2\2\u07b1\u07b2\5\u0178\u00bd"+
		"\2\u07b2\u07b3\7X\2\2\u07b3\u07b4\5f\64\2\u07b4\u0177\3\2\2\2\u07b5\u07b7"+
		"\5\u00d6l\2\u07b6\u07b5\3\2\2\2\u07b6\u07b7\3\2\2\2\u07b7\u07b8\3\2\2"+
		"\2\u07b8\u07bb\5\u00a0Q\2\u07b9\u07bc\5\u00ecw\2\u07ba\u07bc\5\u0102\u0082"+
		"\2\u07bb\u07b9\3\2\2\2\u07bb\u07ba\3\2\2\2\u07bb\u07bc\3\2\2\2\u07bc\u07bf"+
		"\3\2\2\2\u07bd\u07bf\7\u0085\2\2\u07be\u07b6\3\2\2\2\u07be\u07bd\3\2\2"+
		"\2\u07bf\u0179\3\2\2\2\u07c0\u07c2\7I\2\2\u07c1\u07c3\5X-\2\u07c2\u07c1"+
		"\3\2\2\2\u07c2\u07c3\3\2\2\2\u07c3\u017b\3\2\2\2\u07c4\u07c7\5\u017e\u00c0"+
		"\2\u07c5\u07c7\5\u0182\u00c2\2\u07c6\u07c4\3\2\2\2\u07c6\u07c5\3\2\2\2"+
		"\u07c7\u017d\3\2\2\2\u07c8\u07c9\7I\2\2\u07c9\u07cb\7W\2\2\u07ca\u07cc"+
		"\5\u0180\u00c1\2\u07cb\u07ca\3\2\2\2\u07cb\u07cc\3\2\2\2\u07cc\u07cd\3"+
		"\2\2\2\u07cd\u07ce\7X\2\2\u07ce\u017f\3\2\2\2\u07cf\u07d1\5\u0100\u0081"+
		"\2\u07d0\u07d2\7\u0085\2\2\u07d1\u07d0\3\2\2\2\u07d1\u07d2\3\2\2\2\u07d2"+
		"\u07da\3\2\2\2\u07d3\u07d4\7|\2\2\u07d4\u07d6\5\u0100\u0081\2\u07d5\u07d7"+
		"\7\u0085\2\2\u07d6\u07d5\3\2\2\2\u07d6\u07d7\3\2\2\2\u07d7\u07d9\3\2\2"+
		"\2\u07d8\u07d3\3\2\2\2\u07d9\u07dc\3\2\2\2\u07da\u07d8\3\2\2\2\u07da\u07db"+
		"\3\2\2\2\u07db\u0181\3\2\2\2\u07dc\u07da\3\2\2\2\u07dd\u07de\7\64\2\2"+
		"\u07de\u07df\7W\2\2\u07df\u07e0\5^\60\2\u07e0\u07e1\7X\2\2\u07e1\u07e4"+
		"\3\2\2\2\u07e2\u07e4\7\64\2\2\u07e3\u07dd\3\2\2\2\u07e3\u07e2\3\2\2\2"+
		"\u07e4\u0183\3\2\2\2\u07e5\u07e8\7\63\2\2\u07e6\u07e7\7Y\2\2\u07e7\u07e9"+
		"\7Z\2\2\u07e8\u07e6\3\2\2\2\u07e8\u07e9\3\2\2\2\u07e9\u0819\3\2\2\2\u07ea"+
		"\u07ed\7\36\2\2\u07eb\u07ec\7Y\2\2\u07ec\u07ee\7Z\2\2\u07ed\u07eb\3\2"+
		"\2\2\u07ed\u07ee\3\2\2\2\u07ee\u0819\3\2\2\2\u07ef\u0819\7]\2\2\u07f0"+
		"\u0819\7^\2\2\u07f1\u0819\7_\2\2\u07f2\u0819\7`\2\2\u07f3\u0819\7a\2\2"+
		"\u07f4\u0819\7b\2\2\u07f5\u0819\7c\2\2\u07f6\u0819\7d\2\2\u07f7\u0819"+
		"\7e\2\2\u07f8\u0819\7f\2\2\u07f9\u0819\7g\2\2\u07fa\u0819\7i\2\2\u07fb"+
		"\u0819\7h\2\2\u07fc\u0819\7w\2\2\u07fd\u0819\7j\2\2\u07fe\u0819\7k\2\2"+
		"\u07ff\u0819\7l\2\2\u0800\u0819\7n\2\2\u0801\u0819\7o\2\2\u0802\u0819"+
		"\7p\2\2\u0803\u0819\7q\2\2\u0804\u0805\7h\2\2\u0805\u0819\7h\2\2\u0806"+
		"\u0807\7i\2\2\u0807\u0819\7i\2\2\u0808\u0819\7s\2\2\u0809\u0819\7r\2\2"+
		"\u080a\u0819\7t\2\2\u080b\u0819\7u\2\2\u080c\u0819\7v\2\2\u080d\u0819"+
		"\7x\2\2\u080e\u0819\7y\2\2\u080f\u0819\7z\2\2\u0810\u0819\7{\2\2\u0811"+
		"\u0819\7|\2\2\u0812\u0819\7}\2\2\u0813\u0819\7~\2\2\u0814\u0815\7W\2\2"+
		"\u0815\u0819\7X\2\2\u0816\u0817\7Y\2\2\u0817\u0819\7Z\2\2\u0818\u07e5"+
		"\3\2\2\2\u0818\u07ea\3\2\2\2\u0818\u07ef\3\2\2\2\u0818\u07f0\3\2\2\2\u0818"+
		"\u07f1\3\2\2\2\u0818\u07f2\3\2\2\2\u0818\u07f3\3\2\2\2\u0818\u07f4\3\2"+
		"\2\2\u0818\u07f5\3\2\2\2\u0818\u07f6\3\2\2\2\u0818\u07f7\3\2\2\2\u0818"+
		"\u07f8\3\2\2\2\u0818\u07f9\3\2\2\2\u0818\u07fa\3\2\2\2\u0818\u07fb\3\2"+
		"\2\2\u0818\u07fc\3\2\2\2\u0818\u07fd\3\2\2\2\u0818\u07fe\3\2\2\2\u0818"+
		"\u07ff\3\2\2\2\u0818\u0800\3\2\2\2\u0818\u0801\3\2\2\2\u0818\u0802\3\2"+
		"\2\2\u0818\u0803\3\2\2\2\u0818\u0804\3\2\2\2\u0818\u0806\3\2\2\2\u0818"+
		"\u0808\3\2\2\2\u0818\u0809\3\2\2\2\u0818\u080a\3\2\2\2\u0818\u080b\3\2"+
		"\2\2\u0818\u080c\3\2\2\2\u0818\u080d\3\2\2\2\u0818\u080e\3\2\2\2\u0818"+
		"\u080f\3\2\2\2\u0818\u0810\3\2\2\2\u0818\u0811\3\2\2\2\u0818\u0812\3\2"+
		"\2\2\u0818\u0813\3\2\2\2\u0818\u0814\3\2\2\2\u0818\u0816\3\2\2\2\u0819"+
		"\u0185\3\2\2\2\u081a\u081b\t\30\2\2\u081b\u0187\3\2\2\2\u0122\u0189\u0190"+
		"\u0199\u019d\u01a6\u01a9\u01ad\u01b5\u01bc\u01bf\u01c4\u01c9\u01cf\u01d7"+
		"\u01d9\u01e2\u01e6\u01ea\u01ed\u01f1\u01f4\u01fb\u01ff\u0202\u0205\u0208"+
		"\u020e\u0212\u0216\u0224\u0228\u022e\u0235\u023b\u023f\u0243\u0245\u024d"+
		"\u0252\u025f\u0266\u0272\u027c\u0281\u0285\u028c\u028f\u0297\u029b\u029e"+
		"\u02a5\u02ac\u02b0\u02b5\u02b9\u02bc\u02c1\u02d0\u02d7\u02df\u02e7\u02f0"+
		"\u02f7\u02fe\u0306\u030e\u0316\u031e\u0326\u032e\u0337\u033f\u0348\u0350"+
		"\u035c\u035e\u0361\u0367\u036d\u0373\u037a\u0392\u0399\u039b\u03af\u03b3"+
		"\u03b9\u03c0\u03c3\u03ca\u03d1\u03d5\u03de\u03e9\u03f3\u03f8\u03ff\u0402"+
		"\u0407\u040c\u0421\u0426\u0429\u0434\u043a\u043f\u0442\u0447\u044a\u0451"+
		"\u0468\u046e\u0474\u047a\u047d\u0483\u0487\u048b\u048e\u0496\u0498\u049e"+
		"\u04a1\u04a4\u04a7\u04ab\u04af\u04b5\u04bf\u04c5\u04cb\u04d0\u04d5\u04d9"+
		"\u04e6\u04ec\u04f0\u04f6\u04fb\u050a\u050e\u0513\u0518\u051d\u0523\u0526"+
		"\u052f\u0533\u0538\u053c\u0542\u0549\u055a\u055c\u0563\u0568\u056f\u0573"+
		"\u0577\u057f\u0585\u058b\u058f\u0591\u0595\u059a\u059e\u05a1\u05a4\u05a7"+
		"\u05ac\u05b0\u05b3\u05b7\u05ba\u05bc\u05c1\u05c8\u05ce\u05d2\u05d8\u05dd"+
		"\u05e2\u05e9\u05ee\u05f2\u05f4\u05f6\u05fc\u0605\u0609\u060b\u060d\u0612"+
		"\u0615\u061c\u0620\u0625\u0627\u062b\u062e\u0631\u0635\u063a\u0641\u0648"+
		"\u064d\u0651\u0655\u065a\u065e\u0664\u0666\u066c\u0671\u0677\u067b\u067d"+
		"\u0680\u0684\u0688\u068a\u068c\u068f\u069b\u069d\u06a0\u06a3\u06a6\u06af"+
		"\u06b6\u06c2\u06c6\u06c9\u06cd\u06d2\u06de\u06e3\u06e7\u06eb\u06f0\u06f5"+
		"\u06f9\u06fc\u0700\u070b\u070f\u0716\u071b\u071f\u0725\u0729\u072d\u0736"+
		"\u0743\u0748\u074f\u0753\u0756\u0759\u075c\u0760\u0765\u076c\u0770\u0774"+
		"\u077a\u077f\u0783\u0789\u078f\u0792\u0795\u07a5\u07ad\u07b6\u07bb\u07be"+
		"\u07c2\u07c6\u07cb\u07d1\u07d6\u07da\u07e3\u07e8\u07ed\u0818";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}