// Generated from C:/Users/dell/jyy/research/transformer/src/main/g4/java/JavaParser.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class JavaParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		BOOLEAN=1, BYTE=2, CHAR=3, DOUBLE=4, FLOAT=5, INT=6, LONG=7, SHORT=8, 
		VOID=9, CATCH=10, DO=11, ELSE=12, FINALLY=13, FOR=14, IF=15, SWITCH=16, 
		TRY=17, WHILE=18, GOTO=19, BREAK=20, CASE=21, CONTINUE=22, RETURN=23, 
		ABSTRACT=24, ASSERT=25, CLASS=26, CONST=27, DEFAULT=28, ENUM=29, EXTENDS=30, 
		FINAL=31, IMPLEMENTS=32, IMPORT=33, INSTANCEOF=34, INTERFACE=35, NATIVE=36, 
		NEW=37, PACKAGE=38, PRIVATE=39, PROTECTED=40, PUBLIC=41, STATIC=42, STRICTFP=43, 
		SUPER=44, SYNCHRONIZED=45, THIS=46, THROW=47, THROWS=48, TRANSIENT=49, 
		VOLATILE=50, MODULE=51, OPEN=52, REQUIRES=53, EXPORTS=54, OPENS=55, TO=56, 
		USES=57, PROVIDES=58, WITH=59, TRANSITIVE=60, VAR=61, YIELD=62, RECORD=63, 
		SEALED=64, PERMITS=65, NON_SEALED=66, DECIMAL_LITERAL=67, HEX_LITERAL=68, 
		OCT_LITERAL=69, BINARY_LITERAL=70, FLOAT_LITERAL=71, HEX_FLOAT_LITERAL=72, 
		CHAR_LITERAL=73, STRING_LITERAL=74, TEXT_BLOCK=75, BOOL_LITERAL=76, NULL_LITERAL=77, 
		QUESTION=78, COLON=79, GT=80, LT=81, EQUAL=82, LE=83, GE=84, NOTEQUAL=85, 
		AND=86, OR=87, ADD=88, SUB=89, MUL=90, DIV=91, MOD=92, BITAND=93, BITOR=94, 
		CARET=95, ASSIGN=96, ADD_ASSIGN=97, SUB_ASSIGN=98, MUL_ASSIGN=99, DIV_ASSIGN=100, 
		AND_ASSIGN=101, OR_ASSIGN=102, XOR_ASSIGN=103, MOD_ASSIGN=104, LSHIFT_ASSIGN=105, 
		RSHIFT_ASSIGN=106, URSHIFT_ASSIGN=107, TILDE=108, BANG=109, INC=110, DEC=111, 
		LPAREN=112, RPAREN=113, LBRACE=114, RBRACE=115, LBRACK=116, RBRACK=117, 
		SEMI=118, COMMA=119, DOT=120, HWS=121, VWS=122, BLOCK_COMMENT=123, LINE_COMMENT=124, 
		IDENTIFIER=125, ARROW=126, COLONCOLON=127, AT=128, ELLIPSIS=129, COVER=130;
	public static final int
		RULE_compilationUnit = 0, RULE_importDeclarationList = 1, RULE_typeDeclarationList = 2, 
		RULE_packageDeclaration = 3, RULE_importDeclaration = 4, RULE_modifierList = 5, 
		RULE_typeDeclaration = 6, RULE_classHead = 7, RULE_interfaceHead = 8, 
		RULE_recordHead = 9, RULE_enumHead = 10, RULE_annotationTypeHead = 11, 
		RULE_body = 12, RULE_typeParameters = 13, RULE_typeParameter = 14, RULE_typeBound = 15, 
		RULE_enumConstants = 16, RULE_enumConstant = 17, RULE_classBodyDeclaration = 18, 
		RULE_initializer = 19, RULE_initializerList = 20, RULE_fieldDeclarationList = 21, 
		RULE_constructorDeclarationList = 22, RULE_methodDeclarationList = 23, 
		RULE_methodDeclaration = 24, RULE_methodHead = 25, RULE_constructorDeclaration = 26, 
		RULE_constructorHead = 27, RULE_fieldDeclaration = 28, RULE_constDeclarationList = 29, 
		RULE_constDeclaration = 30, RULE_constantDeclarator = 31, RULE_variableDeclarators = 32, 
		RULE_variableDeclarator = 33, RULE_variableDeclaratorId = 34, RULE_variableInitializer = 35, 
		RULE_arrayInitializer = 36, RULE_classOrInterfaceType = 37, RULE_typeArgument = 38, 
		RULE_qualifiedNameList = 39, RULE_formalParameters = 40, RULE_receiverParameter = 41, 
		RULE_formalParameterList = 42, RULE_formalParameter = 43, RULE_lastFormalParameter = 44, 
		RULE_lambdaLVTIList = 45, RULE_lambdaLVTIParameter = 46, RULE_qualifiedName = 47, 
		RULE_literal = 48, RULE_integerLiteral = 49, RULE_floatLiteral = 50, RULE_altAnnotationQualifiedName = 51, 
		RULE_annotationList = 52, RULE_annotation = 53, RULE_elementValuePairs = 54, 
		RULE_elementValuePair = 55, RULE_elementValue = 56, RULE_elementValueArrayInitializer = 57, 
		RULE_annotationTypeElementDeclaration = 58, RULE_annotationTypeElementRest = 59, 
		RULE_annotationMethodOrConstantRest = 60, RULE_annotationMethodRest = 61, 
		RULE_annotationConstantRest = 62, RULE_defaultValue = 63, RULE_moduleDeclaration = 64, 
		RULE_moduleDirective = 65, RULE_requiresModifier = 66, RULE_recordHeader = 67, 
		RULE_recordComponentList = 68, RULE_recordComponent = 69, RULE_block = 70, 
		RULE_switchBlockStatementGroup = 71, RULE_localVariableDeclarationStmt = 72, 
		RULE_localVariableDeclaration = 73, RULE_identifier = 74, RULE_typeIdentifier = 75, 
		RULE_statement = 76, RULE_assertStmt = 77, RULE_ifStmt = 78, RULE_ifElseStmt = 79, 
		RULE_forStmt = 80, RULE_whileStmt = 81, RULE_doWhileStmt = 82, RULE_tryCatchStmt = 83, 
		RULE_tryResourceStmt = 84, RULE_switchStmt = 85, RULE_syncStmt = 86, RULE_returnStmt = 87, 
		RULE_throwStmt = 88, RULE_breakStmt = 89, RULE_continueStmt = 90, RULE_yieldStmt = 91, 
		RULE_expressionStmt = 92, RULE_labelStmt = 93, RULE_catchClause = 94, 
		RULE_catchType = 95, RULE_finallyBlock = 96, RULE_resourceSpecification = 97, 
		RULE_resources = 98, RULE_resource = 99, RULE_switchLabel = 100, RULE_forControl = 101, 
		RULE_forInit = 102, RULE_enhancedForControl = 103, RULE_parExpression = 104, 
		RULE_expressionList = 105, RULE_methodCall = 106, RULE_expression = 107, 
		RULE_pattern = 108, RULE_lambdaExpression = 109, RULE_lambdaParameters = 110, 
		RULE_lambdaBody = 111, RULE_switchLabeledRule = 112, RULE_guardedPattern = 113, 
		RULE_classType = 114, RULE_creator = 115, RULE_createdName = 116, RULE_innerCreator = 117, 
		RULE_arrayCreatorRest = 118, RULE_classCreatorRest = 119, RULE_explicitGenericInvocation = 120, 
		RULE_typeArgumentsOrDiamond = 121, RULE_nonWildcardTypeArguments = 122, 
		RULE_typeList = 123, RULE_typeType = 124, RULE_primitiveType = 125, RULE_typeArguments = 126, 
		RULE_superSuffix = 127, RULE_explicitGenericInvocationSuffix = 128, RULE_arguments = 129;
	private static String[] makeRuleNames() {
		return new String[] {
			"compilationUnit", "importDeclarationList", "typeDeclarationList", "packageDeclaration", 
			"importDeclaration", "modifierList", "typeDeclaration", "classHead", 
			"interfaceHead", "recordHead", "enumHead", "annotationTypeHead", "body", 
			"typeParameters", "typeParameter", "typeBound", "enumConstants", "enumConstant", 
			"classBodyDeclaration", "initializer", "initializerList", "fieldDeclarationList", 
			"constructorDeclarationList", "methodDeclarationList", "methodDeclaration", 
			"methodHead", "constructorDeclaration", "constructorHead", "fieldDeclaration", 
			"constDeclarationList", "constDeclaration", "constantDeclarator", "variableDeclarators", 
			"variableDeclarator", "variableDeclaratorId", "variableInitializer", 
			"arrayInitializer", "classOrInterfaceType", "typeArgument", "qualifiedNameList", 
			"formalParameters", "receiverParameter", "formalParameterList", "formalParameter", 
			"lastFormalParameter", "lambdaLVTIList", "lambdaLVTIParameter", "qualifiedName", 
			"literal", "integerLiteral", "floatLiteral", "altAnnotationQualifiedName", 
			"annotationList", "annotation", "elementValuePairs", "elementValuePair", 
			"elementValue", "elementValueArrayInitializer", "annotationTypeElementDeclaration", 
			"annotationTypeElementRest", "annotationMethodOrConstantRest", "annotationMethodRest", 
			"annotationConstantRest", "defaultValue", "moduleDeclaration", "moduleDirective", 
			"requiresModifier", "recordHeader", "recordComponentList", "recordComponent", 
			"block", "switchBlockStatementGroup", "localVariableDeclarationStmt", 
			"localVariableDeclaration", "identifier", "typeIdentifier", "statement", 
			"assertStmt", "ifStmt", "ifElseStmt", "forStmt", "whileStmt", "doWhileStmt", 
			"tryCatchStmt", "tryResourceStmt", "switchStmt", "syncStmt", "returnStmt", 
			"throwStmt", "breakStmt", "continueStmt", "yieldStmt", "expressionStmt", 
			"labelStmt", "catchClause", "catchType", "finallyBlock", "resourceSpecification", 
			"resources", "resource", "switchLabel", "forControl", "forInit", "enhancedForControl", 
			"parExpression", "expressionList", "methodCall", "expression", "pattern", 
			"lambdaExpression", "lambdaParameters", "lambdaBody", "switchLabeledRule", 
			"guardedPattern", "classType", "creator", "createdName", "innerCreator", 
			"arrayCreatorRest", "classCreatorRest", "explicitGenericInvocation", 
			"typeArgumentsOrDiamond", "nonWildcardTypeArguments", "typeList", "typeType", 
			"primitiveType", "typeArguments", "superSuffix", "explicitGenericInvocationSuffix", 
			"arguments"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'boolean'", "'byte'", "'char'", "'double'", "'float'", "'int'", 
			"'long'", "'short'", "'void'", "'catch'", "'do'", "'else'", "'finally'", 
			"'for'", "'if'", "'switch'", "'try'", "'while'", "'goto'", "'break'", 
			"'case'", "'continue'", "'return'", "'abstract'", "'assert'", "'class'", 
			"'const'", "'default'", "'enum'", "'extends'", "'final'", "'implements'", 
			"'import'", "'instanceof'", "'interface'", "'native'", "'new'", "'package'", 
			"'private'", "'protected'", "'public'", "'static'", "'strictfp'", "'super'", 
			"'synchronized'", "'this'", "'throw'", "'throws'", "'transient'", "'volatile'", 
			"'module'", "'open'", "'requires'", "'exports'", "'opens'", "'to'", "'uses'", 
			"'provides'", "'with'", "'transitive'", "'var'", "'yield'", "'record'", 
			"'sealed'", "'permits'", "'non-sealed'", null, null, null, null, null, 
			null, null, null, null, null, "'null'", "'?'", "':'", "'>'", "'<'", "'=='", 
			"'<='", "'>='", "'!='", "'&&'", "'||'", "'+'", "'-'", "'*'", "'/'", "'%'", 
			"'&'", "'|'", "'^'", "'='", "'+='", "'-='", "'*='", "'/='", "'&='", "'|='", 
			"'^='", "'%='", "'<<='", "'>>='", "'>>>='", "'~'", "'!'", "'++'", "'--'", 
			"'('", "')'", "'{'", "'}'", "'['", "']'", "';'", "','", "'.'", null, 
			null, null, null, null, "'->'", "'::'", "'@'", "'...'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "BOOLEAN", "BYTE", "CHAR", "DOUBLE", "FLOAT", "INT", "LONG", "SHORT", 
			"VOID", "CATCH", "DO", "ELSE", "FINALLY", "FOR", "IF", "SWITCH", "TRY", 
			"WHILE", "GOTO", "BREAK", "CASE", "CONTINUE", "RETURN", "ABSTRACT", "ASSERT", 
			"CLASS", "CONST", "DEFAULT", "ENUM", "EXTENDS", "FINAL", "IMPLEMENTS", 
			"IMPORT", "INSTANCEOF", "INTERFACE", "NATIVE", "NEW", "PACKAGE", "PRIVATE", 
			"PROTECTED", "PUBLIC", "STATIC", "STRICTFP", "SUPER", "SYNCHRONIZED", 
			"THIS", "THROW", "THROWS", "TRANSIENT", "VOLATILE", "MODULE", "OPEN", 
			"REQUIRES", "EXPORTS", "OPENS", "TO", "USES", "PROVIDES", "WITH", "TRANSITIVE", 
			"VAR", "YIELD", "RECORD", "SEALED", "PERMITS", "NON_SEALED", "DECIMAL_LITERAL", 
			"HEX_LITERAL", "OCT_LITERAL", "BINARY_LITERAL", "FLOAT_LITERAL", "HEX_FLOAT_LITERAL", 
			"CHAR_LITERAL", "STRING_LITERAL", "TEXT_BLOCK", "BOOL_LITERAL", "NULL_LITERAL", 
			"QUESTION", "COLON", "GT", "LT", "EQUAL", "LE", "GE", "NOTEQUAL", "AND", 
			"OR", "ADD", "SUB", "MUL", "DIV", "MOD", "BITAND", "BITOR", "CARET", 
			"ASSIGN", "ADD_ASSIGN", "SUB_ASSIGN", "MUL_ASSIGN", "DIV_ASSIGN", "AND_ASSIGN", 
			"OR_ASSIGN", "XOR_ASSIGN", "MOD_ASSIGN", "LSHIFT_ASSIGN", "RSHIFT_ASSIGN", 
			"URSHIFT_ASSIGN", "TILDE", "BANG", "INC", "DEC", "LPAREN", "RPAREN", 
			"LBRACE", "RBRACE", "LBRACK", "RBRACK", "SEMI", "COMMA", "DOT", "HWS", 
			"VWS", "BLOCK_COMMENT", "LINE_COMMENT", "IDENTIFIER", "ARROW", "COLONCOLON", 
			"AT", "ELLIPSIS", "COVER"
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
	public String getGrammarFileName() { return "JavaParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public JavaParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CompilationUnitContext extends org.example.myparser.common.context.ExtendContext {
		public PackageDeclarationContext packageDeclaration() {
			return getRuleContext(PackageDeclarationContext.class,0);
		}
		public ImportDeclarationListContext importDeclarationList() {
			return getRuleContext(ImportDeclarationListContext.class,0);
		}
		public List<TerminalNode> SEMI() { return getTokens(JavaParser.SEMI); }
		public TerminalNode SEMI(int i) {
			return getToken(JavaParser.SEMI, i);
		}
		public TypeDeclarationListContext typeDeclarationList() {
			return getRuleContext(TypeDeclarationListContext.class,0);
		}
		public ModuleDeclarationContext moduleDeclaration() {
			return getRuleContext(ModuleDeclarationContext.class,0);
		}
		public TerminalNode EOF() { return getToken(JavaParser.EOF, 0); }
		public CompilationUnitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compilationUnit; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).enterCompilationUnit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).exitCompilationUnit(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaParserVisitor ) return ((JavaParserVisitor<? extends T>)visitor).visitCompilationUnit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CompilationUnitContext compilationUnit() throws RecognitionException {
		CompilationUnitContext _localctx = new CompilationUnitContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_compilationUnit);
		int _la;
		try {
			int _alt;
			setState(288);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(261);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
				case 1:
					{
					setState(260);
					packageDeclaration();
					}
					break;
				}
				setState(272);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
				case 1:
					{
					setState(264);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==IMPORT) {
						{
						setState(263);
						importDeclarationList();
						}
					}

					}
					break;
				case 2:
					{
					setState(269);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(266);
							match(SEMI);
							}
							} 
						}
						setState(271);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
					}
					}
					break;
				}
				setState(283);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
				case 1:
					{
					setState(275);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (((((_la - 24)) & ~0x3f) == 0 && ((1L << (_la - 24)) & 8796062587061L) != 0) || _la==IDENTIFIER || _la==AT) {
						{
						setState(274);
						typeDeclarationList();
						}
					}

					}
					break;
				case 2:
					{
					setState(280);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==SEMI) {
						{
						{
						setState(277);
						match(SEMI);
						}
						}
						setState(282);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(285);
				moduleDeclaration();
				setState(286);
				match(EOF);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ImportDeclarationListContext extends org.example.myparser.common.context.ExtendContext {
		public List<ImportDeclarationContext> importDeclaration() {
			return getRuleContexts(ImportDeclarationContext.class);
		}
		public ImportDeclarationContext importDeclaration(int i) {
			return getRuleContext(ImportDeclarationContext.class,i);
		}
		public ImportDeclarationListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_importDeclarationList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).enterImportDeclarationList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).exitImportDeclarationList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaParserVisitor ) return ((JavaParserVisitor<? extends T>)visitor).visitImportDeclarationList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ImportDeclarationListContext importDeclarationList() throws RecognitionException {
		ImportDeclarationListContext _localctx = new ImportDeclarationListContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_importDeclarationList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(291); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(290);
				importDeclaration();
				}
				}
				setState(293); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==IMPORT );
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

	@SuppressWarnings("CheckReturnValue")
	public static class TypeDeclarationListContext extends org.example.myparser.common.context.ExtendContext {
		public List<TypeDeclarationContext> typeDeclaration() {
			return getRuleContexts(TypeDeclarationContext.class);
		}
		public TypeDeclarationContext typeDeclaration(int i) {
			return getRuleContext(TypeDeclarationContext.class,i);
		}
		public List<TerminalNode> SEMI() { return getTokens(JavaParser.SEMI); }
		public TerminalNode SEMI(int i) {
			return getToken(JavaParser.SEMI, i);
		}
		public TypeDeclarationListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeDeclarationList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).enterTypeDeclarationList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).exitTypeDeclarationList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaParserVisitor ) return ((JavaParserVisitor<? extends T>)visitor).visitTypeDeclarationList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeDeclarationListContext typeDeclarationList() throws RecognitionException {
		TypeDeclarationListContext _localctx = new TypeDeclarationListContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_typeDeclarationList);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(302); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(295);
					typeDeclaration();
					setState(299);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(296);
							match(SEMI);
							}
							} 
						}
						setState(301);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
					}
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(304); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
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

	@SuppressWarnings("CheckReturnValue")
	public static class PackageDeclarationContext extends org.example.myparser.common.context.ExtendContext {
		public AnnotationListContext annotationList() {
			return getRuleContext(AnnotationListContext.class,0);
		}
		public TerminalNode PACKAGE() { return getToken(JavaParser.PACKAGE, 0); }
		public QualifiedNameContext qualifiedName() {
			return getRuleContext(QualifiedNameContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(JavaParser.SEMI, 0); }
		public PackageDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_packageDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).enterPackageDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).exitPackageDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaParserVisitor ) return ((JavaParserVisitor<? extends T>)visitor).visitPackageDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PackageDeclarationContext packageDeclaration() throws RecognitionException {
		PackageDeclarationContext _localctx = new PackageDeclarationContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_packageDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(306);
			annotationList();
			setState(307);
			match(PACKAGE);
			setState(308);
			qualifiedName();
			setState(309);
			match(SEMI);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ImportDeclarationContext extends org.example.myparser.common.context.ExtendContext {
		public TerminalNode IMPORT() { return getToken(JavaParser.IMPORT, 0); }
		public QualifiedNameContext qualifiedName() {
			return getRuleContext(QualifiedNameContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(JavaParser.SEMI, 0); }
		public TerminalNode STATIC() { return getToken(JavaParser.STATIC, 0); }
		public TerminalNode DOT() { return getToken(JavaParser.DOT, 0); }
		public TerminalNode MUL() { return getToken(JavaParser.MUL, 0); }
		public ImportDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_importDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).enterImportDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).exitImportDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaParserVisitor ) return ((JavaParserVisitor<? extends T>)visitor).visitImportDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ImportDeclarationContext importDeclaration() throws RecognitionException {
		ImportDeclarationContext _localctx = new ImportDeclarationContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_importDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(311);
			match(IMPORT);
			setState(313);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==STATIC) {
				{
				setState(312);
				match(STATIC);
				}
			}

			setState(315);
			qualifiedName();
			setState(318);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DOT) {
				{
				setState(316);
				match(DOT);
				setState(317);
				match(MUL);
				}
			}

			setState(320);
			match(SEMI);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ModifierListContext extends org.example.myparser.common.context.ExtendContext {
		public List<AnnotationContext> annotation() {
			return getRuleContexts(AnnotationContext.class);
		}
		public AnnotationContext annotation(int i) {
			return getRuleContext(AnnotationContext.class,i);
		}
		public List<TerminalNode> PUBLIC() { return getTokens(JavaParser.PUBLIC); }
		public TerminalNode PUBLIC(int i) {
			return getToken(JavaParser.PUBLIC, i);
		}
		public List<TerminalNode> PROTECTED() { return getTokens(JavaParser.PROTECTED); }
		public TerminalNode PROTECTED(int i) {
			return getToken(JavaParser.PROTECTED, i);
		}
		public List<TerminalNode> PRIVATE() { return getTokens(JavaParser.PRIVATE); }
		public TerminalNode PRIVATE(int i) {
			return getToken(JavaParser.PRIVATE, i);
		}
		public List<TerminalNode> STATIC() { return getTokens(JavaParser.STATIC); }
		public TerminalNode STATIC(int i) {
			return getToken(JavaParser.STATIC, i);
		}
		public List<TerminalNode> ABSTRACT() { return getTokens(JavaParser.ABSTRACT); }
		public TerminalNode ABSTRACT(int i) {
			return getToken(JavaParser.ABSTRACT, i);
		}
		public List<TerminalNode> FINAL() { return getTokens(JavaParser.FINAL); }
		public TerminalNode FINAL(int i) {
			return getToken(JavaParser.FINAL, i);
		}
		public List<TerminalNode> STRICTFP() { return getTokens(JavaParser.STRICTFP); }
		public TerminalNode STRICTFP(int i) {
			return getToken(JavaParser.STRICTFP, i);
		}
		public List<TerminalNode> SEALED() { return getTokens(JavaParser.SEALED); }
		public TerminalNode SEALED(int i) {
			return getToken(JavaParser.SEALED, i);
		}
		public List<TerminalNode> NON_SEALED() { return getTokens(JavaParser.NON_SEALED); }
		public TerminalNode NON_SEALED(int i) {
			return getToken(JavaParser.NON_SEALED, i);
		}
		public List<TerminalNode> NATIVE() { return getTokens(JavaParser.NATIVE); }
		public TerminalNode NATIVE(int i) {
			return getToken(JavaParser.NATIVE, i);
		}
		public List<TerminalNode> SYNCHRONIZED() { return getTokens(JavaParser.SYNCHRONIZED); }
		public TerminalNode SYNCHRONIZED(int i) {
			return getToken(JavaParser.SYNCHRONIZED, i);
		}
		public List<TerminalNode> TRANSIENT() { return getTokens(JavaParser.TRANSIENT); }
		public TerminalNode TRANSIENT(int i) {
			return getToken(JavaParser.TRANSIENT, i);
		}
		public List<TerminalNode> VOLATILE() { return getTokens(JavaParser.VOLATILE); }
		public TerminalNode VOLATILE(int i) {
			return getToken(JavaParser.VOLATILE, i);
		}
		public List<TerminalNode> DEFAULT() { return getTokens(JavaParser.DEFAULT); }
		public TerminalNode DEFAULT(int i) {
			return getToken(JavaParser.DEFAULT, i);
		}
		public ModifierListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_modifierList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).enterModifierList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).exitModifierList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaParserVisitor ) return ((JavaParserVisitor<? extends T>)visitor).visitModifierList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ModifierListContext modifierList() throws RecognitionException {
		ModifierListContext _localctx = new ModifierListContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_modifierList);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(340);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(338);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
					case 1:
						{
						setState(322);
						annotation();
						}
						break;
					case 2:
						{
						setState(323);
						match(PUBLIC);
						}
						break;
					case 3:
						{
						setState(324);
						match(PROTECTED);
						}
						break;
					case 4:
						{
						setState(325);
						match(PRIVATE);
						}
						break;
					case 5:
						{
						setState(326);
						match(STATIC);
						}
						break;
					case 6:
						{
						setState(327);
						match(ABSTRACT);
						}
						break;
					case 7:
						{
						setState(328);
						match(FINAL);
						}
						break;
					case 8:
						{
						setState(329);
						match(STRICTFP);
						}
						break;
					case 9:
						{
						setState(330);
						match(SEALED);
						}
						break;
					case 10:
						{
						setState(331);
						match(NON_SEALED);
						}
						break;
					case 11:
						{
						setState(332);
						match(NATIVE);
						}
						break;
					case 12:
						{
						setState(333);
						match(SYNCHRONIZED);
						}
						break;
					case 13:
						{
						setState(334);
						match(TRANSIENT);
						}
						break;
					case 14:
						{
						setState(335);
						match(VOLATILE);
						}
						break;
					case 15:
						{
						setState(336);
						match(STRICTFP);
						}
						break;
					case 16:
						{
						setState(337);
						match(DEFAULT);
						}
						break;
					}
					} 
				}
				setState(342);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
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

	@SuppressWarnings("CheckReturnValue")
	public static class TypeDeclarationContext extends org.example.myparser.common.context.ExtendContext {
		public ModifierListContext modifierList() {
			return getRuleContext(ModifierListContext.class,0);
		}
		public BodyContext body() {
			return getRuleContext(BodyContext.class,0);
		}
		public ClassHeadContext classHead() {
			return getRuleContext(ClassHeadContext.class,0);
		}
		public InterfaceHeadContext interfaceHead() {
			return getRuleContext(InterfaceHeadContext.class,0);
		}
		public RecordHeadContext recordHead() {
			return getRuleContext(RecordHeadContext.class,0);
		}
		public EnumHeadContext enumHead() {
			return getRuleContext(EnumHeadContext.class,0);
		}
		public AnnotationTypeHeadContext annotationTypeHead() {
			return getRuleContext(AnnotationTypeHeadContext.class,0);
		}
		public TypeDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).enterTypeDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).exitTypeDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaParserVisitor ) return ((JavaParserVisitor<? extends T>)visitor).visitTypeDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeDeclarationContext typeDeclaration() throws RecognitionException {
		TypeDeclarationContext _localctx = new TypeDeclarationContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_typeDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(343);
			modifierList();
			setState(349);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CLASS:
				{
				setState(344);
				classHead();
				}
				break;
			case INTERFACE:
				{
				setState(345);
				interfaceHead();
				}
				break;
			case RECORD:
				{
				setState(346);
				recordHead();
				}
				break;
			case ENUM:
				{
				setState(347);
				enumHead();
				}
				break;
			case AT:
				{
				setState(348);
				annotationTypeHead();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(351);
			body();
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

	@SuppressWarnings("CheckReturnValue")
	public static class ClassHeadContext extends org.example.myparser.common.context.ExtendContext {
		public TerminalNode CLASS() { return getToken(JavaParser.CLASS, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TypeParametersContext typeParameters() {
			return getRuleContext(TypeParametersContext.class,0);
		}
		public TerminalNode EXTENDS() { return getToken(JavaParser.EXTENDS, 0); }
		public TypeTypeContext typeType() {
			return getRuleContext(TypeTypeContext.class,0);
		}
		public TerminalNode IMPLEMENTS() { return getToken(JavaParser.IMPLEMENTS, 0); }
		public List<TypeListContext> typeList() {
			return getRuleContexts(TypeListContext.class);
		}
		public TypeListContext typeList(int i) {
			return getRuleContext(TypeListContext.class,i);
		}
		public TerminalNode PERMITS() { return getToken(JavaParser.PERMITS, 0); }
		public ClassHeadContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classHead; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).enterClassHead(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).exitClassHead(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaParserVisitor ) return ((JavaParserVisitor<? extends T>)visitor).visitClassHead(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassHeadContext classHead() throws RecognitionException {
		ClassHeadContext _localctx = new ClassHeadContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_classHead);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(353);
			match(CLASS);
			setState(354);
			identifier();
			setState(356);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LT) {
				{
				setState(355);
				typeParameters();
				}
			}

			setState(360);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EXTENDS) {
				{
				setState(358);
				match(EXTENDS);
				setState(359);
				typeType();
				}
			}

			setState(364);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IMPLEMENTS) {
				{
				setState(362);
				match(IMPLEMENTS);
				setState(363);
				typeList();
				}
			}

			setState(368);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PERMITS) {
				{
				setState(366);
				match(PERMITS);
				setState(367);
				typeList();
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

	@SuppressWarnings("CheckReturnValue")
	public static class InterfaceHeadContext extends org.example.myparser.common.context.ExtendContext {
		public TerminalNode INTERFACE() { return getToken(JavaParser.INTERFACE, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TypeParametersContext typeParameters() {
			return getRuleContext(TypeParametersContext.class,0);
		}
		public TerminalNode EXTENDS() { return getToken(JavaParser.EXTENDS, 0); }
		public List<TypeListContext> typeList() {
			return getRuleContexts(TypeListContext.class);
		}
		public TypeListContext typeList(int i) {
			return getRuleContext(TypeListContext.class,i);
		}
		public TerminalNode PERMITS() { return getToken(JavaParser.PERMITS, 0); }
		public InterfaceHeadContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_interfaceHead; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).enterInterfaceHead(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).exitInterfaceHead(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaParserVisitor ) return ((JavaParserVisitor<? extends T>)visitor).visitInterfaceHead(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InterfaceHeadContext interfaceHead() throws RecognitionException {
		InterfaceHeadContext _localctx = new InterfaceHeadContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_interfaceHead);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(370);
			match(INTERFACE);
			setState(371);
			identifier();
			setState(373);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LT) {
				{
				setState(372);
				typeParameters();
				}
			}

			setState(377);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EXTENDS) {
				{
				setState(375);
				match(EXTENDS);
				setState(376);
				typeList();
				}
			}

			setState(381);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PERMITS) {
				{
				setState(379);
				match(PERMITS);
				setState(380);
				typeList();
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

	@SuppressWarnings("CheckReturnValue")
	public static class RecordHeadContext extends org.example.myparser.common.context.ExtendContext {
		public TerminalNode RECORD() { return getToken(JavaParser.RECORD, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public RecordHeaderContext recordHeader() {
			return getRuleContext(RecordHeaderContext.class,0);
		}
		public TypeParametersContext typeParameters() {
			return getRuleContext(TypeParametersContext.class,0);
		}
		public TerminalNode IMPLEMENTS() { return getToken(JavaParser.IMPLEMENTS, 0); }
		public TypeListContext typeList() {
			return getRuleContext(TypeListContext.class,0);
		}
		public RecordHeadContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_recordHead; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).enterRecordHead(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).exitRecordHead(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaParserVisitor ) return ((JavaParserVisitor<? extends T>)visitor).visitRecordHead(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RecordHeadContext recordHead() throws RecognitionException {
		RecordHeadContext _localctx = new RecordHeadContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_recordHead);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(383);
			match(RECORD);
			setState(384);
			identifier();
			setState(386);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LT) {
				{
				setState(385);
				typeParameters();
				}
			}

			setState(388);
			recordHeader();
			setState(391);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IMPLEMENTS) {
				{
				setState(389);
				match(IMPLEMENTS);
				setState(390);
				typeList();
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

	@SuppressWarnings("CheckReturnValue")
	public static class EnumHeadContext extends org.example.myparser.common.context.ExtendContext {
		public TerminalNode ENUM() { return getToken(JavaParser.ENUM, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode IMPLEMENTS() { return getToken(JavaParser.IMPLEMENTS, 0); }
		public TypeListContext typeList() {
			return getRuleContext(TypeListContext.class,0);
		}
		public EnumHeadContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumHead; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).enterEnumHead(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).exitEnumHead(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaParserVisitor ) return ((JavaParserVisitor<? extends T>)visitor).visitEnumHead(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EnumHeadContext enumHead() throws RecognitionException {
		EnumHeadContext _localctx = new EnumHeadContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_enumHead);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(393);
			match(ENUM);
			setState(394);
			identifier();
			setState(397);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IMPLEMENTS) {
				{
				setState(395);
				match(IMPLEMENTS);
				setState(396);
				typeList();
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

	@SuppressWarnings("CheckReturnValue")
	public static class AnnotationTypeHeadContext extends org.example.myparser.common.context.ExtendContext {
		public TerminalNode AT() { return getToken(JavaParser.AT, 0); }
		public TerminalNode INTERFACE() { return getToken(JavaParser.INTERFACE, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public AnnotationTypeHeadContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_annotationTypeHead; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).enterAnnotationTypeHead(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).exitAnnotationTypeHead(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaParserVisitor ) return ((JavaParserVisitor<? extends T>)visitor).visitAnnotationTypeHead(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AnnotationTypeHeadContext annotationTypeHead() throws RecognitionException {
		AnnotationTypeHeadContext _localctx = new AnnotationTypeHeadContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_annotationTypeHead);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(399);
			match(AT);
			setState(400);
			match(INTERFACE);
			setState(401);
			identifier();
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

	@SuppressWarnings("CheckReturnValue")
	public static class BodyContext extends org.example.myparser.common.context.ExtendContext {
		public TerminalNode LBRACE() { return getToken(JavaParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(JavaParser.RBRACE, 0); }
		public List<ClassBodyDeclarationContext> classBodyDeclaration() {
			return getRuleContexts(ClassBodyDeclarationContext.class);
		}
		public ClassBodyDeclarationContext classBodyDeclaration(int i) {
			return getRuleContext(ClassBodyDeclarationContext.class,i);
		}
		public EnumConstantsContext enumConstants() {
			return getRuleContext(EnumConstantsContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(JavaParser.COMMA, 0); }
		public TerminalNode SEMI() { return getToken(JavaParser.SEMI, 0); }
		public List<AnnotationTypeElementDeclarationContext> annotationTypeElementDeclaration() {
			return getRuleContexts(AnnotationTypeElementDeclarationContext.class);
		}
		public AnnotationTypeElementDeclarationContext annotationTypeElementDeclaration(int i) {
			return getRuleContext(AnnotationTypeElementDeclarationContext.class,i);
		}
		public List<ModuleDirectiveContext> moduleDirective() {
			return getRuleContexts(ModuleDirectiveContext.class);
		}
		public ModuleDirectiveContext moduleDirective(int i) {
			return getRuleContext(ModuleDirectiveContext.class,i);
		}
		public BodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_body; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).enterBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).exitBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaParserVisitor ) return ((JavaParserVisitor<? extends T>)visitor).visitBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BodyContext body() throws RecognitionException {
		BodyContext _localctx = new BodyContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_body);
		int _la;
		try {
			setState(444);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(403);
				match(LBRACE);
				setState(407);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (((((_la - 1)) & ~0x3f) == 0 && ((1L << (_la - 1)) & -255308517604865L) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & -8060880383039700989L) != 0)) {
					{
					{
					setState(404);
					classBodyDeclaration();
					}
					}
					setState(409);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(410);
				match(RBRACE);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(411);
				match(LBRACE);
				setState(413);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 51)) & ~0x3f) == 0 && ((1L << (_la - 51)) & 32767L) != 0) || _la==IDENTIFIER || _la==AT) {
					{
					setState(412);
					enumConstants();
					}
				}

				setState(416);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(415);
					match(COMMA);
					}
				}

				setState(425);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SEMI) {
					{
					setState(418);
					match(SEMI);
					setState(422);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (((((_la - 1)) & ~0x3f) == 0 && ((1L << (_la - 1)) & -255308517604865L) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & -8060880383039700989L) != 0)) {
						{
						{
						setState(419);
						classBodyDeclaration();
						}
						}
						setState(424);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(427);
				match(RBRACE);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(428);
				match(LBRACE);
				setState(432);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (((((_la - 1)) & ~0x3f) == 0 && ((1L << (_la - 1)) & -255308517604865L) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & -8061443332993187837L) != 0)) {
					{
					{
					setState(429);
					annotationTypeElementDeclaration();
					}
					}
					setState(434);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(435);
				match(RBRACE);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(436);
				match(LBRACE);
				setState(440);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 495395959010754560L) != 0)) {
					{
					{
					setState(437);
					moduleDirective();
					}
					}
					setState(442);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(443);
				match(RBRACE);
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

	@SuppressWarnings("CheckReturnValue")
	public static class TypeParametersContext extends org.example.myparser.common.context.ExtendContext {
		public TerminalNode LT() { return getToken(JavaParser.LT, 0); }
		public List<TypeParameterContext> typeParameter() {
			return getRuleContexts(TypeParameterContext.class);
		}
		public TypeParameterContext typeParameter(int i) {
			return getRuleContext(TypeParameterContext.class,i);
		}
		public TerminalNode GT() { return getToken(JavaParser.GT, 0); }
		public List<TerminalNode> COMMA() { return getTokens(JavaParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(JavaParser.COMMA, i);
		}
		public TypeParametersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeParameters; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).enterTypeParameters(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).exitTypeParameters(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaParserVisitor ) return ((JavaParserVisitor<? extends T>)visitor).visitTypeParameters(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeParametersContext typeParameters() throws RecognitionException {
		TypeParametersContext _localctx = new TypeParametersContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_typeParameters);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(446);
			match(LT);
			setState(447);
			typeParameter();
			setState(452);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(448);
				match(COMMA);
				setState(449);
				typeParameter();
				}
				}
				setState(454);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(455);
			match(GT);
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

	@SuppressWarnings("CheckReturnValue")
	public static class TypeParameterContext extends org.example.myparser.common.context.ExtendContext {
		public List<AnnotationListContext> annotationList() {
			return getRuleContexts(AnnotationListContext.class);
		}
		public AnnotationListContext annotationList(int i) {
			return getRuleContext(AnnotationListContext.class,i);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode EXTENDS() { return getToken(JavaParser.EXTENDS, 0); }
		public TypeBoundContext typeBound() {
			return getRuleContext(TypeBoundContext.class,0);
		}
		public TypeParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeParameter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).enterTypeParameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).exitTypeParameter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaParserVisitor ) return ((JavaParserVisitor<? extends T>)visitor).visitTypeParameter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeParameterContext typeParameter() throws RecognitionException {
		TypeParameterContext _localctx = new TypeParameterContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_typeParameter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(457);
			annotationList();
			setState(458);
			identifier();
			setState(463);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EXTENDS) {
				{
				setState(459);
				match(EXTENDS);
				setState(460);
				annotationList();
				setState(461);
				typeBound();
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

	@SuppressWarnings("CheckReturnValue")
	public static class TypeBoundContext extends org.example.myparser.common.context.ExtendContext {
		public List<TypeTypeContext> typeType() {
			return getRuleContexts(TypeTypeContext.class);
		}
		public TypeTypeContext typeType(int i) {
			return getRuleContext(TypeTypeContext.class,i);
		}
		public List<TerminalNode> BITAND() { return getTokens(JavaParser.BITAND); }
		public TerminalNode BITAND(int i) {
			return getToken(JavaParser.BITAND, i);
		}
		public TypeBoundContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeBound; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).enterTypeBound(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).exitTypeBound(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaParserVisitor ) return ((JavaParserVisitor<? extends T>)visitor).visitTypeBound(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeBoundContext typeBound() throws RecognitionException {
		TypeBoundContext _localctx = new TypeBoundContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_typeBound);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(465);
			typeType();
			setState(470);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==BITAND) {
				{
				{
				setState(466);
				match(BITAND);
				setState(467);
				typeType();
				}
				}
				setState(472);
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

	@SuppressWarnings("CheckReturnValue")
	public static class EnumConstantsContext extends org.example.myparser.common.context.ExtendContext {
		public List<EnumConstantContext> enumConstant() {
			return getRuleContexts(EnumConstantContext.class);
		}
		public EnumConstantContext enumConstant(int i) {
			return getRuleContext(EnumConstantContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(JavaParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(JavaParser.COMMA, i);
		}
		public EnumConstantsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumConstants; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).enterEnumConstants(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).exitEnumConstants(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaParserVisitor ) return ((JavaParserVisitor<? extends T>)visitor).visitEnumConstants(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EnumConstantsContext enumConstants() throws RecognitionException {
		EnumConstantsContext _localctx = new EnumConstantsContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_enumConstants);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(473);
			enumConstant();
			setState(478);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,37,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(474);
					match(COMMA);
					setState(475);
					enumConstant();
					}
					} 
				}
				setState(480);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,37,_ctx);
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

	@SuppressWarnings("CheckReturnValue")
	public static class EnumConstantContext extends org.example.myparser.common.context.ExtendContext {
		public BodyContext classBody;
		public AnnotationListContext annotationList() {
			return getRuleContext(AnnotationListContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public BodyContext body() {
			return getRuleContext(BodyContext.class,0);
		}
		public EnumConstantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumConstant; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).enterEnumConstant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).exitEnumConstant(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaParserVisitor ) return ((JavaParserVisitor<? extends T>)visitor).visitEnumConstant(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EnumConstantContext enumConstant() throws RecognitionException {
		EnumConstantContext _localctx = new EnumConstantContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_enumConstant);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(481);
			annotationList();
			setState(482);
			identifier();
			setState(484);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LPAREN) {
				{
				setState(483);
				arguments();
				}
			}

			setState(487);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LBRACE) {
				{
				setState(486);
				((EnumConstantContext)_localctx).classBody = body();
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

	@SuppressWarnings("CheckReturnValue")
	public static class ClassBodyDeclarationContext extends org.example.myparser.common.context.ExtendContext {
		public TerminalNode SEMI() { return getToken(JavaParser.SEMI, 0); }
		public InitializerListContext initializerList() {
			return getRuleContext(InitializerListContext.class,0);
		}
		public FieldDeclarationListContext fieldDeclarationList() {
			return getRuleContext(FieldDeclarationListContext.class,0);
		}
		public ConstructorDeclarationListContext constructorDeclarationList() {
			return getRuleContext(ConstructorDeclarationListContext.class,0);
		}
		public MethodDeclarationListContext methodDeclarationList() {
			return getRuleContext(MethodDeclarationListContext.class,0);
		}
		public TypeDeclarationListContext typeDeclarationList() {
			return getRuleContext(TypeDeclarationListContext.class,0);
		}
		public ClassBodyDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classBodyDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).enterClassBodyDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).exitClassBodyDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaParserVisitor ) return ((JavaParserVisitor<? extends T>)visitor).visitClassBodyDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassBodyDeclarationContext classBodyDeclaration() throws RecognitionException {
		ClassBodyDeclarationContext _localctx = new ClassBodyDeclarationContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_classBodyDeclaration);
		try {
			setState(495);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,40,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(489);
				match(SEMI);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(490);
				initializerList();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(491);
				fieldDeclarationList();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(492);
				constructorDeclarationList();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(493);
				methodDeclarationList();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(494);
				typeDeclarationList();
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

	@SuppressWarnings("CheckReturnValue")
	public static class InitializerContext extends org.example.myparser.common.context.ExtendContext {
		public ModifierListContext modifierList() {
			return getRuleContext(ModifierListContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public InitializerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_initializer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).enterInitializer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).exitInitializer(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaParserVisitor ) return ((JavaParserVisitor<? extends T>)visitor).visitInitializer(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InitializerContext initializer() throws RecognitionException {
		InitializerContext _localctx = new InitializerContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_initializer);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(497);
			modifierList();
			setState(498);
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

	@SuppressWarnings("CheckReturnValue")
	public static class InitializerListContext extends org.example.myparser.common.context.ExtendContext {
		public List<InitializerContext> initializer() {
			return getRuleContexts(InitializerContext.class);
		}
		public InitializerContext initializer(int i) {
			return getRuleContext(InitializerContext.class,i);
		}
		public List<TerminalNode> SEMI() { return getTokens(JavaParser.SEMI); }
		public TerminalNode SEMI(int i) {
			return getToken(JavaParser.SEMI, i);
		}
		public InitializerListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_initializerList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).enterInitializerList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).exitInitializerList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaParserVisitor ) return ((JavaParserVisitor<? extends T>)visitor).visitInitializerList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InitializerListContext initializerList() throws RecognitionException {
		InitializerListContext _localctx = new InitializerListContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_initializerList);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(507); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(500);
					initializer();
					setState(504);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,41,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(501);
							match(SEMI);
							}
							} 
						}
						setState(506);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,41,_ctx);
					}
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(509); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,42,_ctx);
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

	@SuppressWarnings("CheckReturnValue")
	public static class FieldDeclarationListContext extends org.example.myparser.common.context.ExtendContext {
		public List<FieldDeclarationContext> fieldDeclaration() {
			return getRuleContexts(FieldDeclarationContext.class);
		}
		public FieldDeclarationContext fieldDeclaration(int i) {
			return getRuleContext(FieldDeclarationContext.class,i);
		}
		public List<TerminalNode> SEMI() { return getTokens(JavaParser.SEMI); }
		public TerminalNode SEMI(int i) {
			return getToken(JavaParser.SEMI, i);
		}
		public FieldDeclarationListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldDeclarationList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).enterFieldDeclarationList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).exitFieldDeclarationList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaParserVisitor ) return ((JavaParserVisitor<? extends T>)visitor).visitFieldDeclarationList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FieldDeclarationListContext fieldDeclarationList() throws RecognitionException {
		FieldDeclarationListContext _localctx = new FieldDeclarationListContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_fieldDeclarationList);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(518); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(511);
					fieldDeclaration();
					setState(515);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,43,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(512);
							match(SEMI);
							}
							} 
						}
						setState(517);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,43,_ctx);
					}
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(520); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,44,_ctx);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ConstructorDeclarationListContext extends org.example.myparser.common.context.ExtendContext {
		public List<ConstructorDeclarationContext> constructorDeclaration() {
			return getRuleContexts(ConstructorDeclarationContext.class);
		}
		public ConstructorDeclarationContext constructorDeclaration(int i) {
			return getRuleContext(ConstructorDeclarationContext.class,i);
		}
		public List<TerminalNode> SEMI() { return getTokens(JavaParser.SEMI); }
		public TerminalNode SEMI(int i) {
			return getToken(JavaParser.SEMI, i);
		}
		public ConstructorDeclarationListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constructorDeclarationList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).enterConstructorDeclarationList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).exitConstructorDeclarationList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaParserVisitor ) return ((JavaParserVisitor<? extends T>)visitor).visitConstructorDeclarationList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstructorDeclarationListContext constructorDeclarationList() throws RecognitionException {
		ConstructorDeclarationListContext _localctx = new ConstructorDeclarationListContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_constructorDeclarationList);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(529); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(522);
					constructorDeclaration();
					setState(526);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,45,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(523);
							match(SEMI);
							}
							} 
						}
						setState(528);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,45,_ctx);
					}
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(531); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,46,_ctx);
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

	@SuppressWarnings("CheckReturnValue")
	public static class MethodDeclarationListContext extends org.example.myparser.common.context.ExtendContext {
		public List<MethodDeclarationContext> methodDeclaration() {
			return getRuleContexts(MethodDeclarationContext.class);
		}
		public MethodDeclarationContext methodDeclaration(int i) {
			return getRuleContext(MethodDeclarationContext.class,i);
		}
		public List<TerminalNode> SEMI() { return getTokens(JavaParser.SEMI); }
		public TerminalNode SEMI(int i) {
			return getToken(JavaParser.SEMI, i);
		}
		public MethodDeclarationListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodDeclarationList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).enterMethodDeclarationList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).exitMethodDeclarationList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaParserVisitor ) return ((JavaParserVisitor<? extends T>)visitor).visitMethodDeclarationList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodDeclarationListContext methodDeclarationList() throws RecognitionException {
		MethodDeclarationListContext _localctx = new MethodDeclarationListContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_methodDeclarationList);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(540); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(533);
					methodDeclaration();
					setState(537);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,47,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(534);
							match(SEMI);
							}
							} 
						}
						setState(539);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,47,_ctx);
					}
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(542); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,48,_ctx);
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

	@SuppressWarnings("CheckReturnValue")
	public static class MethodDeclarationContext extends org.example.myparser.common.context.ExtendContext {
		public ModifierListContext modifierList() {
			return getRuleContext(ModifierListContext.class,0);
		}
		public MethodHeadContext methodHead() {
			return getRuleContext(MethodHeadContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(JavaParser.SEMI, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public MethodDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).enterMethodDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).exitMethodDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaParserVisitor ) return ((JavaParserVisitor<? extends T>)visitor).visitMethodDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodDeclarationContext methodDeclaration() throws RecognitionException {
		MethodDeclarationContext _localctx = new MethodDeclarationContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_methodDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(544);
			modifierList();
			setState(545);
			methodHead();
			setState(548);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SEMI:
				{
				setState(546);
				match(SEMI);
				}
				break;
			case LBRACE:
				{
				setState(547);
				block();
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

	@SuppressWarnings("CheckReturnValue")
	public static class MethodHeadContext extends org.example.myparser.common.context.ExtendContext {
		public TypeTypeContext typeType() {
			return getRuleContext(TypeTypeContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public FormalParametersContext formalParameters() {
			return getRuleContext(FormalParametersContext.class,0);
		}
		public TypeParametersContext typeParameters() {
			return getRuleContext(TypeParametersContext.class,0);
		}
		public List<TerminalNode> LBRACK() { return getTokens(JavaParser.LBRACK); }
		public TerminalNode LBRACK(int i) {
			return getToken(JavaParser.LBRACK, i);
		}
		public List<TerminalNode> RBRACK() { return getTokens(JavaParser.RBRACK); }
		public TerminalNode RBRACK(int i) {
			return getToken(JavaParser.RBRACK, i);
		}
		public TerminalNode THROWS() { return getToken(JavaParser.THROWS, 0); }
		public QualifiedNameListContext qualifiedNameList() {
			return getRuleContext(QualifiedNameListContext.class,0);
		}
		public MethodHeadContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodHead; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).enterMethodHead(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).exitMethodHead(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaParserVisitor ) return ((JavaParserVisitor<? extends T>)visitor).visitMethodHead(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodHeadContext methodHead() throws RecognitionException {
		MethodHeadContext _localctx = new MethodHeadContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_methodHead);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(551);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LT) {
				{
				setState(550);
				typeParameters();
				}
			}

			setState(553);
			typeType();
			setState(554);
			identifier();
			setState(555);
			formalParameters();
			setState(560);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LBRACK) {
				{
				{
				setState(556);
				match(LBRACK);
				setState(557);
				match(RBRACK);
				}
				}
				setState(562);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(565);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==THROWS) {
				{
				setState(563);
				match(THROWS);
				setState(564);
				qualifiedNameList();
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

	@SuppressWarnings("CheckReturnValue")
	public static class ConstructorDeclarationContext extends org.example.myparser.common.context.ExtendContext {
		public BlockContext constructorBody;
		public ModifierListContext modifierList() {
			return getRuleContext(ModifierListContext.class,0);
		}
		public ConstructorHeadContext constructorHead() {
			return getRuleContext(ConstructorHeadContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public ConstructorDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constructorDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).enterConstructorDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).exitConstructorDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaParserVisitor ) return ((JavaParserVisitor<? extends T>)visitor).visitConstructorDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstructorDeclarationContext constructorDeclaration() throws RecognitionException {
		ConstructorDeclarationContext _localctx = new ConstructorDeclarationContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_constructorDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(567);
			modifierList();
			setState(568);
			constructorHead();
			setState(569);
			((ConstructorDeclarationContext)_localctx).constructorBody = block();
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

	@SuppressWarnings("CheckReturnValue")
	public static class ConstructorHeadContext extends org.example.myparser.common.context.ExtendContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public FormalParametersContext formalParameters() {
			return getRuleContext(FormalParametersContext.class,0);
		}
		public TypeParametersContext typeParameters() {
			return getRuleContext(TypeParametersContext.class,0);
		}
		public TerminalNode THROWS() { return getToken(JavaParser.THROWS, 0); }
		public QualifiedNameListContext qualifiedNameList() {
			return getRuleContext(QualifiedNameListContext.class,0);
		}
		public ConstructorHeadContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constructorHead; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).enterConstructorHead(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).exitConstructorHead(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaParserVisitor ) return ((JavaParserVisitor<? extends T>)visitor).visitConstructorHead(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstructorHeadContext constructorHead() throws RecognitionException {
		ConstructorHeadContext _localctx = new ConstructorHeadContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_constructorHead);
		int _la;
		try {
			setState(581);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,55,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(572);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LT) {
					{
					setState(571);
					typeParameters();
					}
				}

				setState(574);
				identifier();
				setState(575);
				formalParameters();
				setState(578);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==THROWS) {
					{
					setState(576);
					match(THROWS);
					setState(577);
					qualifiedNameList();
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(580);
				identifier();
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

	@SuppressWarnings("CheckReturnValue")
	public static class FieldDeclarationContext extends org.example.myparser.common.context.ExtendContext {
		public ModifierListContext modifierList() {
			return getRuleContext(ModifierListContext.class,0);
		}
		public TypeTypeContext typeType() {
			return getRuleContext(TypeTypeContext.class,0);
		}
		public VariableDeclaratorsContext variableDeclarators() {
			return getRuleContext(VariableDeclaratorsContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(JavaParser.SEMI, 0); }
		public FieldDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).enterFieldDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).exitFieldDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaParserVisitor ) return ((JavaParserVisitor<? extends T>)visitor).visitFieldDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FieldDeclarationContext fieldDeclaration() throws RecognitionException {
		FieldDeclarationContext _localctx = new FieldDeclarationContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_fieldDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(583);
			modifierList();
			setState(584);
			typeType();
			setState(585);
			variableDeclarators();
			setState(586);
			match(SEMI);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ConstDeclarationListContext extends org.example.myparser.common.context.ExtendContext {
		public List<ConstDeclarationContext> constDeclaration() {
			return getRuleContexts(ConstDeclarationContext.class);
		}
		public ConstDeclarationContext constDeclaration(int i) {
			return getRuleContext(ConstDeclarationContext.class,i);
		}
		public List<TerminalNode> SEMI() { return getTokens(JavaParser.SEMI); }
		public TerminalNode SEMI(int i) {
			return getToken(JavaParser.SEMI, i);
		}
		public ConstDeclarationListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constDeclarationList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).enterConstDeclarationList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).exitConstDeclarationList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaParserVisitor ) return ((JavaParserVisitor<? extends T>)visitor).visitConstDeclarationList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstDeclarationListContext constDeclarationList() throws RecognitionException {
		ConstDeclarationListContext _localctx = new ConstDeclarationListContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_constDeclarationList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(595); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(588);
				constDeclaration();
				setState(592);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==SEMI) {
					{
					{
					setState(589);
					match(SEMI);
					}
					}
					setState(594);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				setState(597); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( ((((_la - 1)) & ~0x3f) == 0 && ((1L << (_la - 1)) & -255325999463937L) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & -8070450532247928829L) != 0) );
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

	@SuppressWarnings("CheckReturnValue")
	public static class ConstDeclarationContext extends org.example.myparser.common.context.ExtendContext {
		public ModifierListContext modifierList() {
			return getRuleContext(ModifierListContext.class,0);
		}
		public TypeTypeContext typeType() {
			return getRuleContext(TypeTypeContext.class,0);
		}
		public List<ConstantDeclaratorContext> constantDeclarator() {
			return getRuleContexts(ConstantDeclaratorContext.class);
		}
		public ConstantDeclaratorContext constantDeclarator(int i) {
			return getRuleContext(ConstantDeclaratorContext.class,i);
		}
		public TerminalNode SEMI() { return getToken(JavaParser.SEMI, 0); }
		public List<TerminalNode> COMMA() { return getTokens(JavaParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(JavaParser.COMMA, i);
		}
		public ConstDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).enterConstDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).exitConstDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaParserVisitor ) return ((JavaParserVisitor<? extends T>)visitor).visitConstDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstDeclarationContext constDeclaration() throws RecognitionException {
		ConstDeclarationContext _localctx = new ConstDeclarationContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_constDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(599);
			modifierList();
			setState(600);
			typeType();
			setState(601);
			constantDeclarator();
			setState(606);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(602);
				match(COMMA);
				setState(603);
				constantDeclarator();
				}
				}
				setState(608);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(609);
			match(SEMI);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ConstantDeclaratorContext extends org.example.myparser.common.context.ExtendContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(JavaParser.ASSIGN, 0); }
		public VariableInitializerContext variableInitializer() {
			return getRuleContext(VariableInitializerContext.class,0);
		}
		public List<TerminalNode> LBRACK() { return getTokens(JavaParser.LBRACK); }
		public TerminalNode LBRACK(int i) {
			return getToken(JavaParser.LBRACK, i);
		}
		public List<TerminalNode> RBRACK() { return getTokens(JavaParser.RBRACK); }
		public TerminalNode RBRACK(int i) {
			return getToken(JavaParser.RBRACK, i);
		}
		public ConstantDeclaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constantDeclarator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).enterConstantDeclarator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).exitConstantDeclarator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaParserVisitor ) return ((JavaParserVisitor<? extends T>)visitor).visitConstantDeclarator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstantDeclaratorContext constantDeclarator() throws RecognitionException {
		ConstantDeclaratorContext _localctx = new ConstantDeclaratorContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_constantDeclarator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(611);
			identifier();
			setState(616);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LBRACK) {
				{
				{
				setState(612);
				match(LBRACK);
				setState(613);
				match(RBRACK);
				}
				}
				setState(618);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(619);
			match(ASSIGN);
			setState(620);
			variableInitializer();
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

	@SuppressWarnings("CheckReturnValue")
	public static class VariableDeclaratorsContext extends org.example.myparser.common.context.ExtendContext {
		public List<VariableDeclaratorContext> variableDeclarator() {
			return getRuleContexts(VariableDeclaratorContext.class);
		}
		public VariableDeclaratorContext variableDeclarator(int i) {
			return getRuleContext(VariableDeclaratorContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(JavaParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(JavaParser.COMMA, i);
		}
		public VariableDeclaratorsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableDeclarators; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).enterVariableDeclarators(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).exitVariableDeclarators(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaParserVisitor ) return ((JavaParserVisitor<? extends T>)visitor).visitVariableDeclarators(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableDeclaratorsContext variableDeclarators() throws RecognitionException {
		VariableDeclaratorsContext _localctx = new VariableDeclaratorsContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_variableDeclarators);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(622);
			variableDeclarator();
			setState(627);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(623);
				match(COMMA);
				setState(624);
				variableDeclarator();
				}
				}
				setState(629);
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

	@SuppressWarnings("CheckReturnValue")
	public static class VariableDeclaratorContext extends org.example.myparser.common.context.ExtendContext {
		public VariableDeclaratorIdContext variableDeclaratorId() {
			return getRuleContext(VariableDeclaratorIdContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(JavaParser.ASSIGN, 0); }
		public VariableInitializerContext variableInitializer() {
			return getRuleContext(VariableInitializerContext.class,0);
		}
		public VariableDeclaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableDeclarator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).enterVariableDeclarator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).exitVariableDeclarator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaParserVisitor ) return ((JavaParserVisitor<? extends T>)visitor).visitVariableDeclarator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableDeclaratorContext variableDeclarator() throws RecognitionException {
		VariableDeclaratorContext _localctx = new VariableDeclaratorContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_variableDeclarator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(630);
			variableDeclaratorId();
			setState(633);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ASSIGN) {
				{
				setState(631);
				match(ASSIGN);
				setState(632);
				variableInitializer();
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

	@SuppressWarnings("CheckReturnValue")
	public static class VariableDeclaratorIdContext extends org.example.myparser.common.context.ExtendContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public List<TerminalNode> LBRACK() { return getTokens(JavaParser.LBRACK); }
		public TerminalNode LBRACK(int i) {
			return getToken(JavaParser.LBRACK, i);
		}
		public List<TerminalNode> RBRACK() { return getTokens(JavaParser.RBRACK); }
		public TerminalNode RBRACK(int i) {
			return getToken(JavaParser.RBRACK, i);
		}
		public VariableDeclaratorIdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableDeclaratorId; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).enterVariableDeclaratorId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).exitVariableDeclaratorId(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaParserVisitor ) return ((JavaParserVisitor<? extends T>)visitor).visitVariableDeclaratorId(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableDeclaratorIdContext variableDeclaratorId() throws RecognitionException {
		VariableDeclaratorIdContext _localctx = new VariableDeclaratorIdContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_variableDeclaratorId);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(635);
			identifier();
			setState(640);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LBRACK) {
				{
				{
				setState(636);
				match(LBRACK);
				setState(637);
				match(RBRACK);
				}
				}
				setState(642);
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

	@SuppressWarnings("CheckReturnValue")
	public static class VariableInitializerContext extends org.example.myparser.common.context.ExtendContext {
		public ArrayInitializerContext arrayInitializer() {
			return getRuleContext(ArrayInitializerContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public VariableInitializerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableInitializer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).enterVariableInitializer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).exitVariableInitializer(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaParserVisitor ) return ((JavaParserVisitor<? extends T>)visitor).visitVariableInitializer(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableInitializerContext variableInitializer() throws RecognitionException {
		VariableInitializerContext _localctx = new VariableInitializerContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_variableInitializer);
		try {
			setState(645);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LBRACE:
				enterOuterAlt(_localctx, 1);
				{
				setState(643);
				arrayInitializer();
				}
				break;
			case BOOLEAN:
			case BYTE:
			case CHAR:
			case DOUBLE:
			case FLOAT:
			case INT:
			case LONG:
			case SHORT:
			case VOID:
			case SWITCH:
			case NEW:
			case SUPER:
			case THIS:
			case MODULE:
			case OPEN:
			case REQUIRES:
			case EXPORTS:
			case OPENS:
			case TO:
			case USES:
			case PROVIDES:
			case WITH:
			case TRANSITIVE:
			case VAR:
			case YIELD:
			case RECORD:
			case SEALED:
			case PERMITS:
			case DECIMAL_LITERAL:
			case HEX_LITERAL:
			case OCT_LITERAL:
			case BINARY_LITERAL:
			case FLOAT_LITERAL:
			case HEX_FLOAT_LITERAL:
			case CHAR_LITERAL:
			case STRING_LITERAL:
			case TEXT_BLOCK:
			case BOOL_LITERAL:
			case NULL_LITERAL:
			case LT:
			case ADD:
			case SUB:
			case TILDE:
			case BANG:
			case INC:
			case DEC:
			case LPAREN:
			case IDENTIFIER:
			case AT:
				enterOuterAlt(_localctx, 2);
				{
				setState(644);
				expression(0);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ArrayInitializerContext extends org.example.myparser.common.context.ExtendContext {
		public TerminalNode LBRACE() { return getToken(JavaParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(JavaParser.RBRACE, 0); }
		public List<VariableInitializerContext> variableInitializer() {
			return getRuleContexts(VariableInitializerContext.class);
		}
		public VariableInitializerContext variableInitializer(int i) {
			return getRuleContext(VariableInitializerContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(JavaParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(JavaParser.COMMA, i);
		}
		public ArrayInitializerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayInitializer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).enterArrayInitializer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).exitArrayInitializer(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaParserVisitor ) return ((JavaParserVisitor<? extends T>)visitor).visitArrayInitializer(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayInitializerContext arrayInitializer() throws RecognitionException {
		ArrayInitializerContext _localctx = new ArrayInitializerContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_arrayInitializer);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(647);
			match(LBRACE);
			setState(659);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 1)) & ~0x3f) == 0 && ((1L << (_la - 1)) & -1081850722221569L) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & -8069614903385579523L) != 0)) {
				{
				setState(648);
				variableInitializer();
				setState(653);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,64,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(649);
						match(COMMA);
						setState(650);
						variableInitializer();
						}
						} 
					}
					setState(655);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,64,_ctx);
				}
				setState(657);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(656);
					match(COMMA);
					}
				}

				}
			}

			setState(661);
			match(RBRACE);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ClassOrInterfaceTypeContext extends org.example.myparser.common.context.ExtendContext {
		public TypeIdentifierContext typeIdentifier() {
			return getRuleContext(TypeIdentifierContext.class,0);
		}
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public List<TerminalNode> DOT() { return getTokens(JavaParser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(JavaParser.DOT, i);
		}
		public List<TypeArgumentsContext> typeArguments() {
			return getRuleContexts(TypeArgumentsContext.class);
		}
		public TypeArgumentsContext typeArguments(int i) {
			return getRuleContext(TypeArgumentsContext.class,i);
		}
		public ClassOrInterfaceTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classOrInterfaceType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).enterClassOrInterfaceType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).exitClassOrInterfaceType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaParserVisitor ) return ((JavaParserVisitor<? extends T>)visitor).visitClassOrInterfaceType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassOrInterfaceTypeContext classOrInterfaceType() throws RecognitionException {
		ClassOrInterfaceTypeContext _localctx = new ClassOrInterfaceTypeContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_classOrInterfaceType);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(671);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,68,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(663);
					identifier();
					setState(665);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==LT) {
						{
						setState(664);
						typeArguments();
						}
					}

					setState(667);
					match(DOT);
					}
					} 
				}
				setState(673);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,68,_ctx);
			}
			setState(674);
			typeIdentifier();
			setState(676);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,69,_ctx) ) {
			case 1:
				{
				setState(675);
				typeArguments();
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

	@SuppressWarnings("CheckReturnValue")
	public static class TypeArgumentContext extends org.example.myparser.common.context.ExtendContext {
		public TypeTypeContext typeType() {
			return getRuleContext(TypeTypeContext.class,0);
		}
		public AnnotationListContext annotationList() {
			return getRuleContext(AnnotationListContext.class,0);
		}
		public TerminalNode QUESTION() { return getToken(JavaParser.QUESTION, 0); }
		public TerminalNode EXTENDS() { return getToken(JavaParser.EXTENDS, 0); }
		public TerminalNode SUPER() { return getToken(JavaParser.SUPER, 0); }
		public TypeArgumentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeArgument; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).enterTypeArgument(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).exitTypeArgument(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaParserVisitor ) return ((JavaParserVisitor<? extends T>)visitor).visitTypeArgument(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeArgumentContext typeArgument() throws RecognitionException {
		TypeArgumentContext _localctx = new TypeArgumentContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_typeArgument);
		int _la;
		try {
			setState(685);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,71,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(678);
				typeType();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(679);
				annotationList();
				setState(680);
				match(QUESTION);
				setState(683);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==EXTENDS || _la==SUPER) {
					{
					setState(681);
					_la = _input.LA(1);
					if ( !(_la==EXTENDS || _la==SUPER) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(682);
					typeType();
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

	@SuppressWarnings("CheckReturnValue")
	public static class QualifiedNameListContext extends org.example.myparser.common.context.ExtendContext {
		public List<QualifiedNameContext> qualifiedName() {
			return getRuleContexts(QualifiedNameContext.class);
		}
		public QualifiedNameContext qualifiedName(int i) {
			return getRuleContext(QualifiedNameContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(JavaParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(JavaParser.COMMA, i);
		}
		public QualifiedNameListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_qualifiedNameList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).enterQualifiedNameList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).exitQualifiedNameList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaParserVisitor ) return ((JavaParserVisitor<? extends T>)visitor).visitQualifiedNameList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QualifiedNameListContext qualifiedNameList() throws RecognitionException {
		QualifiedNameListContext _localctx = new QualifiedNameListContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_qualifiedNameList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(687);
			qualifiedName();
			setState(692);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(688);
				match(COMMA);
				setState(689);
				qualifiedName();
				}
				}
				setState(694);
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

	@SuppressWarnings("CheckReturnValue")
	public static class FormalParametersContext extends org.example.myparser.common.context.ExtendContext {
		public TerminalNode LPAREN() { return getToken(JavaParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(JavaParser.RPAREN, 0); }
		public ReceiverParameterContext receiverParameter() {
			return getRuleContext(ReceiverParameterContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(JavaParser.COMMA, 0); }
		public FormalParameterListContext formalParameterList() {
			return getRuleContext(FormalParameterListContext.class,0);
		}
		public FormalParametersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formalParameters; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).enterFormalParameters(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).exitFormalParameters(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaParserVisitor ) return ((JavaParserVisitor<? extends T>)visitor).visitFormalParameters(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FormalParametersContext formalParameters() throws RecognitionException {
		FormalParametersContext _localctx = new FormalParametersContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_formalParameters);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(695);
			match(LPAREN);
			setState(707);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,76,_ctx) ) {
			case 1:
				{
				setState(697);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 1)) & ~0x3f) == 0 && ((1L << (_la - 1)) & -1125899906842113L) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & -8070450532247928831L) != 0)) {
					{
					setState(696);
					receiverParameter();
					}
				}

				}
				break;
			case 2:
				{
				setState(699);
				receiverParameter();
				setState(702);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(700);
					match(COMMA);
					setState(701);
					formalParameterList();
					}
				}

				}
				break;
			case 3:
				{
				setState(705);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 1)) & ~0x3f) == 0 && ((1L << (_la - 1)) & -255325999463937L) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & -8070450532247928829L) != 0)) {
					{
					setState(704);
					formalParameterList();
					}
				}

				}
				break;
			}
			setState(709);
			match(RPAREN);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ReceiverParameterContext extends org.example.myparser.common.context.ExtendContext {
		public TypeTypeContext typeType() {
			return getRuleContext(TypeTypeContext.class,0);
		}
		public TerminalNode THIS() { return getToken(JavaParser.THIS, 0); }
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public List<TerminalNode> DOT() { return getTokens(JavaParser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(JavaParser.DOT, i);
		}
		public ReceiverParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_receiverParameter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).enterReceiverParameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).exitReceiverParameter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaParserVisitor ) return ((JavaParserVisitor<? extends T>)visitor).visitReceiverParameter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReceiverParameterContext receiverParameter() throws RecognitionException {
		ReceiverParameterContext _localctx = new ReceiverParameterContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_receiverParameter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(711);
			typeType();
			setState(717);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -2251799813685248L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 2305843009213693955L) != 0)) {
				{
				{
				setState(712);
				identifier();
				setState(713);
				match(DOT);
				}
				}
				setState(719);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(720);
			match(THIS);
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

	@SuppressWarnings("CheckReturnValue")
	public static class FormalParameterListContext extends org.example.myparser.common.context.ExtendContext {
		public List<FormalParameterContext> formalParameter() {
			return getRuleContexts(FormalParameterContext.class);
		}
		public FormalParameterContext formalParameter(int i) {
			return getRuleContext(FormalParameterContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(JavaParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(JavaParser.COMMA, i);
		}
		public LastFormalParameterContext lastFormalParameter() {
			return getRuleContext(LastFormalParameterContext.class,0);
		}
		public FormalParameterListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formalParameterList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).enterFormalParameterList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).exitFormalParameterList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaParserVisitor ) return ((JavaParserVisitor<? extends T>)visitor).visitFormalParameterList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FormalParameterListContext formalParameterList() throws RecognitionException {
		FormalParameterListContext _localctx = new FormalParameterListContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_formalParameterList);
		int _la;
		try {
			int _alt;
			setState(735);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,80,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(722);
				formalParameter();
				setState(727);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,78,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(723);
						match(COMMA);
						setState(724);
						formalParameter();
						}
						} 
					}
					setState(729);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,78,_ctx);
				}
				setState(732);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(730);
					match(COMMA);
					setState(731);
					lastFormalParameter();
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(734);
				lastFormalParameter();
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

	@SuppressWarnings("CheckReturnValue")
	public static class FormalParameterContext extends org.example.myparser.common.context.ExtendContext {
		public ModifierListContext modifierList() {
			return getRuleContext(ModifierListContext.class,0);
		}
		public TypeTypeContext typeType() {
			return getRuleContext(TypeTypeContext.class,0);
		}
		public VariableDeclaratorIdContext variableDeclaratorId() {
			return getRuleContext(VariableDeclaratorIdContext.class,0);
		}
		public FormalParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formalParameter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).enterFormalParameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).exitFormalParameter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaParserVisitor ) return ((JavaParserVisitor<? extends T>)visitor).visitFormalParameter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FormalParameterContext formalParameter() throws RecognitionException {
		FormalParameterContext _localctx = new FormalParameterContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_formalParameter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(737);
			modifierList();
			setState(738);
			typeType();
			setState(739);
			variableDeclaratorId();
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

	@SuppressWarnings("CheckReturnValue")
	public static class LastFormalParameterContext extends org.example.myparser.common.context.ExtendContext {
		public ModifierListContext modifierList() {
			return getRuleContext(ModifierListContext.class,0);
		}
		public TypeTypeContext typeType() {
			return getRuleContext(TypeTypeContext.class,0);
		}
		public AnnotationListContext annotationList() {
			return getRuleContext(AnnotationListContext.class,0);
		}
		public TerminalNode ELLIPSIS() { return getToken(JavaParser.ELLIPSIS, 0); }
		public VariableDeclaratorIdContext variableDeclaratorId() {
			return getRuleContext(VariableDeclaratorIdContext.class,0);
		}
		public LastFormalParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lastFormalParameter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).enterLastFormalParameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).exitLastFormalParameter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaParserVisitor ) return ((JavaParserVisitor<? extends T>)visitor).visitLastFormalParameter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LastFormalParameterContext lastFormalParameter() throws RecognitionException {
		LastFormalParameterContext _localctx = new LastFormalParameterContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_lastFormalParameter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(741);
			modifierList();
			setState(742);
			typeType();
			setState(743);
			annotationList();
			setState(744);
			match(ELLIPSIS);
			setState(745);
			variableDeclaratorId();
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

	@SuppressWarnings("CheckReturnValue")
	public static class LambdaLVTIListContext extends org.example.myparser.common.context.ExtendContext {
		public List<LambdaLVTIParameterContext> lambdaLVTIParameter() {
			return getRuleContexts(LambdaLVTIParameterContext.class);
		}
		public LambdaLVTIParameterContext lambdaLVTIParameter(int i) {
			return getRuleContext(LambdaLVTIParameterContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(JavaParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(JavaParser.COMMA, i);
		}
		public LambdaLVTIListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lambdaLVTIList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).enterLambdaLVTIList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).exitLambdaLVTIList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaParserVisitor ) return ((JavaParserVisitor<? extends T>)visitor).visitLambdaLVTIList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LambdaLVTIListContext lambdaLVTIList() throws RecognitionException {
		LambdaLVTIListContext _localctx = new LambdaLVTIListContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_lambdaLVTIList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(747);
			lambdaLVTIParameter();
			setState(752);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(748);
				match(COMMA);
				setState(749);
				lambdaLVTIParameter();
				}
				}
				setState(754);
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

	@SuppressWarnings("CheckReturnValue")
	public static class LambdaLVTIParameterContext extends org.example.myparser.common.context.ExtendContext {
		public ModifierListContext modifierList() {
			return getRuleContext(ModifierListContext.class,0);
		}
		public TerminalNode VAR() { return getToken(JavaParser.VAR, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public LambdaLVTIParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lambdaLVTIParameter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).enterLambdaLVTIParameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).exitLambdaLVTIParameter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaParserVisitor ) return ((JavaParserVisitor<? extends T>)visitor).visitLambdaLVTIParameter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LambdaLVTIParameterContext lambdaLVTIParameter() throws RecognitionException {
		LambdaLVTIParameterContext _localctx = new LambdaLVTIParameterContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_lambdaLVTIParameter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(755);
			modifierList();
			setState(756);
			match(VAR);
			setState(757);
			identifier();
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

	@SuppressWarnings("CheckReturnValue")
	public static class QualifiedNameContext extends org.example.myparser.common.context.ExtendContext {
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public List<TerminalNode> DOT() { return getTokens(JavaParser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(JavaParser.DOT, i);
		}
		public QualifiedNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_qualifiedName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).enterQualifiedName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).exitQualifiedName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaParserVisitor ) return ((JavaParserVisitor<? extends T>)visitor).visitQualifiedName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QualifiedNameContext qualifiedName() throws RecognitionException {
		QualifiedNameContext _localctx = new QualifiedNameContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_qualifiedName);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(759);
			identifier();
			setState(764);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,82,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(760);
					match(DOT);
					setState(761);
					identifier();
					}
					} 
				}
				setState(766);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,82,_ctx);
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

	@SuppressWarnings("CheckReturnValue")
	public static class LiteralContext extends org.example.myparser.common.context.ExtendContext {
		public IntegerLiteralContext integerLiteral() {
			return getRuleContext(IntegerLiteralContext.class,0);
		}
		public FloatLiteralContext floatLiteral() {
			return getRuleContext(FloatLiteralContext.class,0);
		}
		public TerminalNode CHAR_LITERAL() { return getToken(JavaParser.CHAR_LITERAL, 0); }
		public TerminalNode STRING_LITERAL() { return getToken(JavaParser.STRING_LITERAL, 0); }
		public TerminalNode BOOL_LITERAL() { return getToken(JavaParser.BOOL_LITERAL, 0); }
		public TerminalNode NULL_LITERAL() { return getToken(JavaParser.NULL_LITERAL, 0); }
		public TerminalNode TEXT_BLOCK() { return getToken(JavaParser.TEXT_BLOCK, 0); }
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).enterLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).exitLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaParserVisitor ) return ((JavaParserVisitor<? extends T>)visitor).visitLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_literal);
		try {
			setState(774);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DECIMAL_LITERAL:
			case HEX_LITERAL:
			case OCT_LITERAL:
			case BINARY_LITERAL:
				enterOuterAlt(_localctx, 1);
				{
				setState(767);
				integerLiteral();
				}
				break;
			case FLOAT_LITERAL:
			case HEX_FLOAT_LITERAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(768);
				floatLiteral();
				}
				break;
			case CHAR_LITERAL:
				enterOuterAlt(_localctx, 3);
				{
				setState(769);
				match(CHAR_LITERAL);
				}
				break;
			case STRING_LITERAL:
				enterOuterAlt(_localctx, 4);
				{
				setState(770);
				match(STRING_LITERAL);
				}
				break;
			case BOOL_LITERAL:
				enterOuterAlt(_localctx, 5);
				{
				setState(771);
				match(BOOL_LITERAL);
				}
				break;
			case NULL_LITERAL:
				enterOuterAlt(_localctx, 6);
				{
				setState(772);
				match(NULL_LITERAL);
				}
				break;
			case TEXT_BLOCK:
				enterOuterAlt(_localctx, 7);
				{
				setState(773);
				match(TEXT_BLOCK);
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

	@SuppressWarnings("CheckReturnValue")
	public static class IntegerLiteralContext extends org.example.myparser.common.context.ExtendContext {
		public TerminalNode DECIMAL_LITERAL() { return getToken(JavaParser.DECIMAL_LITERAL, 0); }
		public TerminalNode HEX_LITERAL() { return getToken(JavaParser.HEX_LITERAL, 0); }
		public TerminalNode OCT_LITERAL() { return getToken(JavaParser.OCT_LITERAL, 0); }
		public TerminalNode BINARY_LITERAL() { return getToken(JavaParser.BINARY_LITERAL, 0); }
		public IntegerLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_integerLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).enterIntegerLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).exitIntegerLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaParserVisitor ) return ((JavaParserVisitor<? extends T>)visitor).visitIntegerLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IntegerLiteralContext integerLiteral() throws RecognitionException {
		IntegerLiteralContext _localctx = new IntegerLiteralContext(_ctx, getState());
		enterRule(_localctx, 98, RULE_integerLiteral);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(776);
			_la = _input.LA(1);
			if ( !(((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & 15L) != 0)) ) {
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

	@SuppressWarnings("CheckReturnValue")
	public static class FloatLiteralContext extends org.example.myparser.common.context.ExtendContext {
		public TerminalNode FLOAT_LITERAL() { return getToken(JavaParser.FLOAT_LITERAL, 0); }
		public TerminalNode HEX_FLOAT_LITERAL() { return getToken(JavaParser.HEX_FLOAT_LITERAL, 0); }
		public FloatLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_floatLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).enterFloatLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).exitFloatLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaParserVisitor ) return ((JavaParserVisitor<? extends T>)visitor).visitFloatLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FloatLiteralContext floatLiteral() throws RecognitionException {
		FloatLiteralContext _localctx = new FloatLiteralContext(_ctx, getState());
		enterRule(_localctx, 100, RULE_floatLiteral);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(778);
			_la = _input.LA(1);
			if ( !(_la==FLOAT_LITERAL || _la==HEX_FLOAT_LITERAL) ) {
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

	@SuppressWarnings("CheckReturnValue")
	public static class AltAnnotationQualifiedNameContext extends org.example.myparser.common.context.ExtendContext {
		public TerminalNode AT() { return getToken(JavaParser.AT, 0); }
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public List<TerminalNode> DOT() { return getTokens(JavaParser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(JavaParser.DOT, i);
		}
		public AltAnnotationQualifiedNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_altAnnotationQualifiedName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).enterAltAnnotationQualifiedName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).exitAltAnnotationQualifiedName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaParserVisitor ) return ((JavaParserVisitor<? extends T>)visitor).visitAltAnnotationQualifiedName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AltAnnotationQualifiedNameContext altAnnotationQualifiedName() throws RecognitionException {
		AltAnnotationQualifiedNameContext _localctx = new AltAnnotationQualifiedNameContext(_ctx, getState());
		enterRule(_localctx, 102, RULE_altAnnotationQualifiedName);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(785);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -2251799813685248L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 2305843009213693955L) != 0)) {
				{
				{
				setState(780);
				identifier();
				setState(781);
				match(DOT);
				}
				}
				setState(787);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(788);
			match(AT);
			setState(789);
			identifier();
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

	@SuppressWarnings("CheckReturnValue")
	public static class AnnotationListContext extends org.example.myparser.common.context.ExtendContext {
		public List<AnnotationContext> annotation() {
			return getRuleContexts(AnnotationContext.class);
		}
		public AnnotationContext annotation(int i) {
			return getRuleContext(AnnotationContext.class,i);
		}
		public AnnotationListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_annotationList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).enterAnnotationList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).exitAnnotationList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaParserVisitor ) return ((JavaParserVisitor<? extends T>)visitor).visitAnnotationList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AnnotationListContext annotationList() throws RecognitionException {
		AnnotationListContext _localctx = new AnnotationListContext(_ctx, getState());
		enterRule(_localctx, 104, RULE_annotationList);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(794);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,85,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(791);
					annotation();
					}
					} 
				}
				setState(796);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,85,_ctx);
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

	@SuppressWarnings("CheckReturnValue")
	public static class AnnotationContext extends org.example.myparser.common.context.ExtendContext {
		public TerminalNode AT() { return getToken(JavaParser.AT, 0); }
		public QualifiedNameContext qualifiedName() {
			return getRuleContext(QualifiedNameContext.class,0);
		}
		public AltAnnotationQualifiedNameContext altAnnotationQualifiedName() {
			return getRuleContext(AltAnnotationQualifiedNameContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(JavaParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(JavaParser.RPAREN, 0); }
		public ElementValuePairsContext elementValuePairs() {
			return getRuleContext(ElementValuePairsContext.class,0);
		}
		public ElementValueContext elementValue() {
			return getRuleContext(ElementValueContext.class,0);
		}
		public AnnotationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_annotation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).enterAnnotation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).exitAnnotation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaParserVisitor ) return ((JavaParserVisitor<? extends T>)visitor).visitAnnotation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AnnotationContext annotation() throws RecognitionException {
		AnnotationContext _localctx = new AnnotationContext(_ctx, getState());
		enterRule(_localctx, 106, RULE_annotation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(800);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,86,_ctx) ) {
			case 1:
				{
				setState(797);
				match(AT);
				setState(798);
				qualifiedName();
				}
				break;
			case 2:
				{
				setState(799);
				altAnnotationQualifiedName();
				}
				break;
			}
			setState(808);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LPAREN) {
				{
				setState(802);
				match(LPAREN);
				setState(805);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,87,_ctx) ) {
				case 1:
					{
					setState(803);
					elementValuePairs();
					}
					break;
				case 2:
					{
					setState(804);
					elementValue();
					}
					break;
				}
				setState(807);
				match(RPAREN);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ElementValuePairsContext extends org.example.myparser.common.context.ExtendContext {
		public List<ElementValuePairContext> elementValuePair() {
			return getRuleContexts(ElementValuePairContext.class);
		}
		public ElementValuePairContext elementValuePair(int i) {
			return getRuleContext(ElementValuePairContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(JavaParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(JavaParser.COMMA, i);
		}
		public ElementValuePairsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elementValuePairs; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).enterElementValuePairs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).exitElementValuePairs(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaParserVisitor ) return ((JavaParserVisitor<? extends T>)visitor).visitElementValuePairs(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElementValuePairsContext elementValuePairs() throws RecognitionException {
		ElementValuePairsContext _localctx = new ElementValuePairsContext(_ctx, getState());
		enterRule(_localctx, 108, RULE_elementValuePairs);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(810);
			elementValuePair();
			setState(815);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(811);
				match(COMMA);
				setState(812);
				elementValuePair();
				}
				}
				setState(817);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ElementValuePairContext extends org.example.myparser.common.context.ExtendContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(JavaParser.ASSIGN, 0); }
		public ElementValueContext elementValue() {
			return getRuleContext(ElementValueContext.class,0);
		}
		public ElementValuePairContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elementValuePair; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).enterElementValuePair(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).exitElementValuePair(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaParserVisitor ) return ((JavaParserVisitor<? extends T>)visitor).visitElementValuePair(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElementValuePairContext elementValuePair() throws RecognitionException {
		ElementValuePairContext _localctx = new ElementValuePairContext(_ctx, getState());
		enterRule(_localctx, 110, RULE_elementValuePair);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(818);
			identifier();
			setState(819);
			match(ASSIGN);
			setState(820);
			elementValue();
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

	@SuppressWarnings("CheckReturnValue")
	public static class ElementValueContext extends org.example.myparser.common.context.ExtendContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public AnnotationContext annotation() {
			return getRuleContext(AnnotationContext.class,0);
		}
		public ElementValueArrayInitializerContext elementValueArrayInitializer() {
			return getRuleContext(ElementValueArrayInitializerContext.class,0);
		}
		public ElementValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elementValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).enterElementValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).exitElementValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaParserVisitor ) return ((JavaParserVisitor<? extends T>)visitor).visitElementValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElementValueContext elementValue() throws RecognitionException {
		ElementValueContext _localctx = new ElementValueContext(_ctx, getState());
		enterRule(_localctx, 112, RULE_elementValue);
		try {
			setState(825);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,90,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(822);
				expression(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(823);
				annotation();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(824);
				elementValueArrayInitializer();
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

	@SuppressWarnings("CheckReturnValue")
	public static class ElementValueArrayInitializerContext extends org.example.myparser.common.context.ExtendContext {
		public TerminalNode LBRACE() { return getToken(JavaParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(JavaParser.RBRACE, 0); }
		public List<ElementValueContext> elementValue() {
			return getRuleContexts(ElementValueContext.class);
		}
		public ElementValueContext elementValue(int i) {
			return getRuleContext(ElementValueContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(JavaParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(JavaParser.COMMA, i);
		}
		public ElementValueArrayInitializerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elementValueArrayInitializer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).enterElementValueArrayInitializer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).exitElementValueArrayInitializer(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaParserVisitor ) return ((JavaParserVisitor<? extends T>)visitor).visitElementValueArrayInitializer(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElementValueArrayInitializerContext elementValueArrayInitializer() throws RecognitionException {
		ElementValueArrayInitializerContext _localctx = new ElementValueArrayInitializerContext(_ctx, getState());
		enterRule(_localctx, 114, RULE_elementValueArrayInitializer);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(827);
			match(LBRACE);
			setState(836);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 1)) & ~0x3f) == 0 && ((1L << (_la - 1)) & -1081850722221569L) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & -8069614903385579523L) != 0)) {
				{
				setState(828);
				elementValue();
				setState(833);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,91,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(829);
						match(COMMA);
						setState(830);
						elementValue();
						}
						} 
					}
					setState(835);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,91,_ctx);
				}
				}
			}

			setState(839);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(838);
				match(COMMA);
				}
			}

			setState(841);
			match(RBRACE);
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

	@SuppressWarnings("CheckReturnValue")
	public static class AnnotationTypeElementDeclarationContext extends org.example.myparser.common.context.ExtendContext {
		public ModifierListContext modifierList() {
			return getRuleContext(ModifierListContext.class,0);
		}
		public AnnotationTypeElementRestContext annotationTypeElementRest() {
			return getRuleContext(AnnotationTypeElementRestContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(JavaParser.SEMI, 0); }
		public AnnotationTypeElementDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_annotationTypeElementDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).enterAnnotationTypeElementDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).exitAnnotationTypeElementDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaParserVisitor ) return ((JavaParserVisitor<? extends T>)visitor).visitAnnotationTypeElementDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AnnotationTypeElementDeclarationContext annotationTypeElementDeclaration() throws RecognitionException {
		AnnotationTypeElementDeclarationContext _localctx = new AnnotationTypeElementDeclarationContext(_ctx, getState());
		enterRule(_localctx, 116, RULE_annotationTypeElementDeclaration);
		try {
			setState(847);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BOOLEAN:
			case BYTE:
			case CHAR:
			case DOUBLE:
			case FLOAT:
			case INT:
			case LONG:
			case SHORT:
			case VOID:
			case ABSTRACT:
			case CLASS:
			case DEFAULT:
			case ENUM:
			case FINAL:
			case INTERFACE:
			case NATIVE:
			case PRIVATE:
			case PROTECTED:
			case PUBLIC:
			case STATIC:
			case STRICTFP:
			case SYNCHRONIZED:
			case TRANSIENT:
			case VOLATILE:
			case MODULE:
			case OPEN:
			case REQUIRES:
			case EXPORTS:
			case OPENS:
			case TO:
			case USES:
			case PROVIDES:
			case WITH:
			case TRANSITIVE:
			case VAR:
			case YIELD:
			case RECORD:
			case SEALED:
			case PERMITS:
			case NON_SEALED:
			case IDENTIFIER:
			case AT:
				enterOuterAlt(_localctx, 1);
				{
				setState(843);
				modifierList();
				setState(844);
				annotationTypeElementRest();
				}
				break;
			case SEMI:
				enterOuterAlt(_localctx, 2);
				{
				setState(846);
				match(SEMI);
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

	@SuppressWarnings("CheckReturnValue")
	public static class AnnotationTypeElementRestContext extends org.example.myparser.common.context.ExtendContext {
		public TypeTypeContext typeType() {
			return getRuleContext(TypeTypeContext.class,0);
		}
		public AnnotationMethodOrConstantRestContext annotationMethodOrConstantRest() {
			return getRuleContext(AnnotationMethodOrConstantRestContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(JavaParser.SEMI, 0); }
		public TypeDeclarationContext typeDeclaration() {
			return getRuleContext(TypeDeclarationContext.class,0);
		}
		public AnnotationTypeElementRestContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_annotationTypeElementRest; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).enterAnnotationTypeElementRest(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).exitAnnotationTypeElementRest(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaParserVisitor ) return ((JavaParserVisitor<? extends T>)visitor).visitAnnotationTypeElementRest(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AnnotationTypeElementRestContext annotationTypeElementRest() throws RecognitionException {
		AnnotationTypeElementRestContext _localctx = new AnnotationTypeElementRestContext(_ctx, getState());
		enterRule(_localctx, 118, RULE_annotationTypeElementRest);
		try {
			setState(857);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,96,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(849);
				typeType();
				setState(850);
				annotationMethodOrConstantRest();
				setState(851);
				match(SEMI);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(853);
				typeDeclaration();
				setState(855);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,95,_ctx) ) {
				case 1:
					{
					setState(854);
					match(SEMI);
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

	@SuppressWarnings("CheckReturnValue")
	public static class AnnotationMethodOrConstantRestContext extends org.example.myparser.common.context.ExtendContext {
		public AnnotationMethodRestContext annotationMethodRest() {
			return getRuleContext(AnnotationMethodRestContext.class,0);
		}
		public AnnotationConstantRestContext annotationConstantRest() {
			return getRuleContext(AnnotationConstantRestContext.class,0);
		}
		public AnnotationMethodOrConstantRestContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_annotationMethodOrConstantRest; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).enterAnnotationMethodOrConstantRest(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).exitAnnotationMethodOrConstantRest(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaParserVisitor ) return ((JavaParserVisitor<? extends T>)visitor).visitAnnotationMethodOrConstantRest(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AnnotationMethodOrConstantRestContext annotationMethodOrConstantRest() throws RecognitionException {
		AnnotationMethodOrConstantRestContext _localctx = new AnnotationMethodOrConstantRestContext(_ctx, getState());
		enterRule(_localctx, 120, RULE_annotationMethodOrConstantRest);
		try {
			setState(861);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,97,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(859);
				annotationMethodRest();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(860);
				annotationConstantRest();
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

	@SuppressWarnings("CheckReturnValue")
	public static class AnnotationMethodRestContext extends org.example.myparser.common.context.ExtendContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(JavaParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(JavaParser.RPAREN, 0); }
		public DefaultValueContext defaultValue() {
			return getRuleContext(DefaultValueContext.class,0);
		}
		public AnnotationMethodRestContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_annotationMethodRest; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).enterAnnotationMethodRest(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).exitAnnotationMethodRest(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaParserVisitor ) return ((JavaParserVisitor<? extends T>)visitor).visitAnnotationMethodRest(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AnnotationMethodRestContext annotationMethodRest() throws RecognitionException {
		AnnotationMethodRestContext _localctx = new AnnotationMethodRestContext(_ctx, getState());
		enterRule(_localctx, 122, RULE_annotationMethodRest);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(863);
			identifier();
			setState(864);
			match(LPAREN);
			setState(865);
			match(RPAREN);
			setState(867);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DEFAULT) {
				{
				setState(866);
				defaultValue();
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

	@SuppressWarnings("CheckReturnValue")
	public static class AnnotationConstantRestContext extends org.example.myparser.common.context.ExtendContext {
		public VariableDeclaratorsContext variableDeclarators() {
			return getRuleContext(VariableDeclaratorsContext.class,0);
		}
		public AnnotationConstantRestContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_annotationConstantRest; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).enterAnnotationConstantRest(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).exitAnnotationConstantRest(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaParserVisitor ) return ((JavaParserVisitor<? extends T>)visitor).visitAnnotationConstantRest(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AnnotationConstantRestContext annotationConstantRest() throws RecognitionException {
		AnnotationConstantRestContext _localctx = new AnnotationConstantRestContext(_ctx, getState());
		enterRule(_localctx, 124, RULE_annotationConstantRest);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(869);
			variableDeclarators();
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

	@SuppressWarnings("CheckReturnValue")
	public static class DefaultValueContext extends org.example.myparser.common.context.ExtendContext {
		public TerminalNode DEFAULT() { return getToken(JavaParser.DEFAULT, 0); }
		public ElementValueContext elementValue() {
			return getRuleContext(ElementValueContext.class,0);
		}
		public DefaultValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_defaultValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).enterDefaultValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).exitDefaultValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaParserVisitor ) return ((JavaParserVisitor<? extends T>)visitor).visitDefaultValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DefaultValueContext defaultValue() throws RecognitionException {
		DefaultValueContext _localctx = new DefaultValueContext(_ctx, getState());
		enterRule(_localctx, 126, RULE_defaultValue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(871);
			match(DEFAULT);
			setState(872);
			elementValue();
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

	@SuppressWarnings("CheckReturnValue")
	public static class ModuleDeclarationContext extends org.example.myparser.common.context.ExtendContext {
		public BodyContext moduleBody;
		public TerminalNode MODULE() { return getToken(JavaParser.MODULE, 0); }
		public QualifiedNameContext qualifiedName() {
			return getRuleContext(QualifiedNameContext.class,0);
		}
		public BodyContext body() {
			return getRuleContext(BodyContext.class,0);
		}
		public TerminalNode OPEN() { return getToken(JavaParser.OPEN, 0); }
		public ModuleDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_moduleDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).enterModuleDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).exitModuleDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaParserVisitor ) return ((JavaParserVisitor<? extends T>)visitor).visitModuleDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ModuleDeclarationContext moduleDeclaration() throws RecognitionException {
		ModuleDeclarationContext _localctx = new ModuleDeclarationContext(_ctx, getState());
		enterRule(_localctx, 128, RULE_moduleDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(875);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OPEN) {
				{
				setState(874);
				match(OPEN);
				}
			}

			setState(877);
			match(MODULE);
			setState(878);
			qualifiedName();
			setState(879);
			((ModuleDeclarationContext)_localctx).moduleBody = body();
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

	@SuppressWarnings("CheckReturnValue")
	public static class ModuleDirectiveContext extends org.example.myparser.common.context.ExtendContext {
		public TerminalNode REQUIRES() { return getToken(JavaParser.REQUIRES, 0); }
		public List<QualifiedNameContext> qualifiedName() {
			return getRuleContexts(QualifiedNameContext.class);
		}
		public QualifiedNameContext qualifiedName(int i) {
			return getRuleContext(QualifiedNameContext.class,i);
		}
		public TerminalNode SEMI() { return getToken(JavaParser.SEMI, 0); }
		public List<RequiresModifierContext> requiresModifier() {
			return getRuleContexts(RequiresModifierContext.class);
		}
		public RequiresModifierContext requiresModifier(int i) {
			return getRuleContext(RequiresModifierContext.class,i);
		}
		public TerminalNode EXPORTS() { return getToken(JavaParser.EXPORTS, 0); }
		public TerminalNode TO() { return getToken(JavaParser.TO, 0); }
		public TerminalNode OPENS() { return getToken(JavaParser.OPENS, 0); }
		public TerminalNode USES() { return getToken(JavaParser.USES, 0); }
		public TerminalNode PROVIDES() { return getToken(JavaParser.PROVIDES, 0); }
		public TerminalNode WITH() { return getToken(JavaParser.WITH, 0); }
		public ModuleDirectiveContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_moduleDirective; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).enterModuleDirective(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).exitModuleDirective(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaParserVisitor ) return ((JavaParserVisitor<? extends T>)visitor).visitModuleDirective(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ModuleDirectiveContext moduleDirective() throws RecognitionException {
		ModuleDirectiveContext _localctx = new ModuleDirectiveContext(_ctx, getState());
		enterRule(_localctx, 130, RULE_moduleDirective);
		int _la;
		try {
			int _alt;
			setState(917);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case REQUIRES:
				enterOuterAlt(_localctx, 1);
				{
				setState(881);
				match(REQUIRES);
				setState(885);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,100,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(882);
						requiresModifier();
						}
						} 
					}
					setState(887);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,100,_ctx);
				}
				setState(888);
				qualifiedName();
				setState(889);
				match(SEMI);
				}
				break;
			case EXPORTS:
				enterOuterAlt(_localctx, 2);
				{
				setState(891);
				match(EXPORTS);
				setState(892);
				qualifiedName();
				setState(895);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==TO) {
					{
					setState(893);
					match(TO);
					setState(894);
					qualifiedName();
					}
				}

				setState(897);
				match(SEMI);
				}
				break;
			case OPENS:
				enterOuterAlt(_localctx, 3);
				{
				setState(899);
				match(OPENS);
				setState(900);
				qualifiedName();
				setState(903);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==TO) {
					{
					setState(901);
					match(TO);
					setState(902);
					qualifiedName();
					}
				}

				setState(905);
				match(SEMI);
				}
				break;
			case USES:
				enterOuterAlt(_localctx, 4);
				{
				setState(907);
				match(USES);
				setState(908);
				qualifiedName();
				setState(909);
				match(SEMI);
				}
				break;
			case PROVIDES:
				enterOuterAlt(_localctx, 5);
				{
				setState(911);
				match(PROVIDES);
				setState(912);
				qualifiedName();
				setState(913);
				match(WITH);
				setState(914);
				qualifiedName();
				setState(915);
				match(SEMI);
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

	@SuppressWarnings("CheckReturnValue")
	public static class RequiresModifierContext extends org.example.myparser.common.context.ExtendContext {
		public TerminalNode TRANSITIVE() { return getToken(JavaParser.TRANSITIVE, 0); }
		public TerminalNode STATIC() { return getToken(JavaParser.STATIC, 0); }
		public RequiresModifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_requiresModifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).enterRequiresModifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).exitRequiresModifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaParserVisitor ) return ((JavaParserVisitor<? extends T>)visitor).visitRequiresModifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RequiresModifierContext requiresModifier() throws RecognitionException {
		RequiresModifierContext _localctx = new RequiresModifierContext(_ctx, getState());
		enterRule(_localctx, 132, RULE_requiresModifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(919);
			_la = _input.LA(1);
			if ( !(_la==STATIC || _la==TRANSITIVE) ) {
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

	@SuppressWarnings("CheckReturnValue")
	public static class RecordHeaderContext extends org.example.myparser.common.context.ExtendContext {
		public TerminalNode LPAREN() { return getToken(JavaParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(JavaParser.RPAREN, 0); }
		public RecordComponentListContext recordComponentList() {
			return getRuleContext(RecordComponentListContext.class,0);
		}
		public RecordHeaderContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_recordHeader; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).enterRecordHeader(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).exitRecordHeader(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaParserVisitor ) return ((JavaParserVisitor<? extends T>)visitor).visitRecordHeader(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RecordHeaderContext recordHeader() throws RecognitionException {
		RecordHeaderContext _localctx = new RecordHeaderContext(_ctx, getState());
		enterRule(_localctx, 134, RULE_recordHeader);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(921);
			match(LPAREN);
			setState(923);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 1)) & ~0x3f) == 0 && ((1L << (_la - 1)) & -1125899906842113L) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & -8070450532247928831L) != 0)) {
				{
				setState(922);
				recordComponentList();
				}
			}

			setState(925);
			match(RPAREN);
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

	@SuppressWarnings("CheckReturnValue")
	public static class RecordComponentListContext extends org.example.myparser.common.context.ExtendContext {
		public List<RecordComponentContext> recordComponent() {
			return getRuleContexts(RecordComponentContext.class);
		}
		public RecordComponentContext recordComponent(int i) {
			return getRuleContext(RecordComponentContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(JavaParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(JavaParser.COMMA, i);
		}
		public RecordComponentListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_recordComponentList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).enterRecordComponentList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).exitRecordComponentList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaParserVisitor ) return ((JavaParserVisitor<? extends T>)visitor).visitRecordComponentList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RecordComponentListContext recordComponentList() throws RecognitionException {
		RecordComponentListContext _localctx = new RecordComponentListContext(_ctx, getState());
		enterRule(_localctx, 136, RULE_recordComponentList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(927);
			recordComponent();
			setState(932);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(928);
				match(COMMA);
				setState(929);
				recordComponent();
				}
				}
				setState(934);
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

	@SuppressWarnings("CheckReturnValue")
	public static class RecordComponentContext extends org.example.myparser.common.context.ExtendContext {
		public TypeTypeContext typeType() {
			return getRuleContext(TypeTypeContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public RecordComponentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_recordComponent; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).enterRecordComponent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).exitRecordComponent(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaParserVisitor ) return ((JavaParserVisitor<? extends T>)visitor).visitRecordComponent(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RecordComponentContext recordComponent() throws RecognitionException {
		RecordComponentContext _localctx = new RecordComponentContext(_ctx, getState());
		enterRule(_localctx, 138, RULE_recordComponent);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(935);
			typeType();
			setState(936);
			identifier();
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

	@SuppressWarnings("CheckReturnValue")
	public static class BlockContext extends org.example.myparser.common.context.ExtendContext {
		public TerminalNode LBRACE() { return getToken(JavaParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(JavaParser.RBRACE, 0); }
		public List<TypeDeclarationContext> typeDeclaration() {
			return getRuleContexts(TypeDeclarationContext.class);
		}
		public TypeDeclarationContext typeDeclaration(int i) {
			return getRuleContext(TypeDeclarationContext.class,i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public List<SwitchBlockStatementGroupContext> switchBlockStatementGroup() {
			return getRuleContexts(SwitchBlockStatementGroupContext.class);
		}
		public SwitchBlockStatementGroupContext switchBlockStatementGroup(int i) {
			return getRuleContext(SwitchBlockStatementGroupContext.class,i);
		}
		public List<SwitchLabelContext> switchLabel() {
			return getRuleContexts(SwitchLabelContext.class);
		}
		public SwitchLabelContext switchLabel(int i) {
			return getRuleContext(SwitchLabelContext.class,i);
		}
		public List<SwitchLabeledRuleContext> switchLabeledRule() {
			return getRuleContexts(SwitchLabeledRuleContext.class);
		}
		public SwitchLabeledRuleContext switchLabeledRule(int i) {
			return getRuleContext(SwitchLabeledRuleContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).exitBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaParserVisitor ) return ((JavaParserVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 140, RULE_block);
		int _la;
		try {
			int _alt;
			setState(969);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,111,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(938);
				match(LBRACE);
				setState(943);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (((((_la - 1)) & ~0x3f) == 0 && ((1L << (_la - 1)) & -140890564991489L) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & -8060607704130838529L) != 0)) {
					{
					setState(941);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,106,_ctx) ) {
					case 1:
						{
						setState(939);
						typeDeclaration();
						}
						break;
					case 2:
						{
						setState(940);
						statement();
						}
						break;
					}
					}
					setState(945);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(946);
				match(RBRACE);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(947);
				match(LBRACE);
				setState(951);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,108,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(948);
						switchBlockStatementGroup();
						}
						} 
					}
					setState(953);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,108,_ctx);
				}
				setState(957);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==CASE || _la==DEFAULT) {
					{
					{
					setState(954);
					switchLabel();
					}
					}
					setState(959);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(960);
				match(RBRACE);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(961);
				match(LBRACE);
				setState(965);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==CASE || _la==DEFAULT) {
					{
					{
					setState(962);
					switchLabeledRule();
					}
					}
					setState(967);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(968);
				match(RBRACE);
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

	@SuppressWarnings("CheckReturnValue")
	public static class SwitchBlockStatementGroupContext extends org.example.myparser.common.context.ExtendContext {
		public List<SwitchLabelContext> switchLabel() {
			return getRuleContexts(SwitchLabelContext.class);
		}
		public SwitchLabelContext switchLabel(int i) {
			return getRuleContext(SwitchLabelContext.class,i);
		}
		public List<TypeDeclarationContext> typeDeclaration() {
			return getRuleContexts(TypeDeclarationContext.class);
		}
		public TypeDeclarationContext typeDeclaration(int i) {
			return getRuleContext(TypeDeclarationContext.class,i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public SwitchBlockStatementGroupContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_switchBlockStatementGroup; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).enterSwitchBlockStatementGroup(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).exitSwitchBlockStatementGroup(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaParserVisitor ) return ((JavaParserVisitor<? extends T>)visitor).visitSwitchBlockStatementGroup(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SwitchBlockStatementGroupContext switchBlockStatementGroup() throws RecognitionException {
		SwitchBlockStatementGroupContext _localctx = new SwitchBlockStatementGroupContext(_ctx, getState());
		enterRule(_localctx, 142, RULE_switchBlockStatementGroup);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(972); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(971);
					switchLabel();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(974); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,112,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(978); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					setState(978);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,113,_ctx) ) {
					case 1:
						{
						setState(976);
						typeDeclaration();
						}
						break;
					case 2:
						{
						setState(977);
						statement();
						}
						break;
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(980); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,114,_ctx);
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

	@SuppressWarnings("CheckReturnValue")
	public static class LocalVariableDeclarationStmtContext extends org.example.myparser.common.context.ExtendContext {
		public LocalVariableDeclarationContext localVariableDeclaration() {
			return getRuleContext(LocalVariableDeclarationContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(JavaParser.SEMI, 0); }
		public LocalVariableDeclarationStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_localVariableDeclarationStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).enterLocalVariableDeclarationStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).exitLocalVariableDeclarationStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaParserVisitor ) return ((JavaParserVisitor<? extends T>)visitor).visitLocalVariableDeclarationStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LocalVariableDeclarationStmtContext localVariableDeclarationStmt() throws RecognitionException {
		LocalVariableDeclarationStmtContext _localctx = new LocalVariableDeclarationStmtContext(_ctx, getState());
		enterRule(_localctx, 144, RULE_localVariableDeclarationStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(982);
			localVariableDeclaration();
			setState(983);
			match(SEMI);
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

	@SuppressWarnings("CheckReturnValue")
	public static class LocalVariableDeclarationContext extends org.example.myparser.common.context.ExtendContext {
		public ModifierListContext modifierList() {
			return getRuleContext(ModifierListContext.class,0);
		}
		public TerminalNode VAR() { return getToken(JavaParser.VAR, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(JavaParser.ASSIGN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TypeTypeContext typeType() {
			return getRuleContext(TypeTypeContext.class,0);
		}
		public VariableDeclaratorsContext variableDeclarators() {
			return getRuleContext(VariableDeclaratorsContext.class,0);
		}
		public LocalVariableDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_localVariableDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).enterLocalVariableDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).exitLocalVariableDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaParserVisitor ) return ((JavaParserVisitor<? extends T>)visitor).visitLocalVariableDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LocalVariableDeclarationContext localVariableDeclaration() throws RecognitionException {
		LocalVariableDeclarationContext _localctx = new LocalVariableDeclarationContext(_ctx, getState());
		enterRule(_localctx, 146, RULE_localVariableDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(985);
			modifierList();
			setState(994);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,115,_ctx) ) {
			case 1:
				{
				setState(986);
				match(VAR);
				setState(987);
				identifier();
				setState(988);
				match(ASSIGN);
				setState(989);
				expression(0);
				}
				break;
			case 2:
				{
				setState(991);
				typeType();
				setState(992);
				variableDeclarators();
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

	@SuppressWarnings("CheckReturnValue")
	public static class IdentifierContext extends org.example.myparser.common.context.ExtendContext {
		public TerminalNode IDENTIFIER() { return getToken(JavaParser.IDENTIFIER, 0); }
		public TerminalNode MODULE() { return getToken(JavaParser.MODULE, 0); }
		public TerminalNode OPEN() { return getToken(JavaParser.OPEN, 0); }
		public TerminalNode REQUIRES() { return getToken(JavaParser.REQUIRES, 0); }
		public TerminalNode EXPORTS() { return getToken(JavaParser.EXPORTS, 0); }
		public TerminalNode OPENS() { return getToken(JavaParser.OPENS, 0); }
		public TerminalNode TO() { return getToken(JavaParser.TO, 0); }
		public TerminalNode USES() { return getToken(JavaParser.USES, 0); }
		public TerminalNode PROVIDES() { return getToken(JavaParser.PROVIDES, 0); }
		public TerminalNode WITH() { return getToken(JavaParser.WITH, 0); }
		public TerminalNode TRANSITIVE() { return getToken(JavaParser.TRANSITIVE, 0); }
		public TerminalNode YIELD() { return getToken(JavaParser.YIELD, 0); }
		public TerminalNode SEALED() { return getToken(JavaParser.SEALED, 0); }
		public TerminalNode PERMITS() { return getToken(JavaParser.PERMITS, 0); }
		public TerminalNode RECORD() { return getToken(JavaParser.RECORD, 0); }
		public TerminalNode VAR() { return getToken(JavaParser.VAR, 0); }
		public IdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).enterIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).exitIdentifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaParserVisitor ) return ((JavaParserVisitor<? extends T>)visitor).visitIdentifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdentifierContext identifier() throws RecognitionException {
		IdentifierContext _localctx = new IdentifierContext(_ctx, getState());
		enterRule(_localctx, 148, RULE_identifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(996);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & -2251799813685248L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 2305843009213693955L) != 0)) ) {
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

	@SuppressWarnings("CheckReturnValue")
	public static class TypeIdentifierContext extends org.example.myparser.common.context.ExtendContext {
		public TerminalNode IDENTIFIER() { return getToken(JavaParser.IDENTIFIER, 0); }
		public TerminalNode MODULE() { return getToken(JavaParser.MODULE, 0); }
		public TerminalNode OPEN() { return getToken(JavaParser.OPEN, 0); }
		public TerminalNode REQUIRES() { return getToken(JavaParser.REQUIRES, 0); }
		public TerminalNode EXPORTS() { return getToken(JavaParser.EXPORTS, 0); }
		public TerminalNode OPENS() { return getToken(JavaParser.OPENS, 0); }
		public TerminalNode TO() { return getToken(JavaParser.TO, 0); }
		public TerminalNode USES() { return getToken(JavaParser.USES, 0); }
		public TerminalNode PROVIDES() { return getToken(JavaParser.PROVIDES, 0); }
		public TerminalNode WITH() { return getToken(JavaParser.WITH, 0); }
		public TerminalNode TRANSITIVE() { return getToken(JavaParser.TRANSITIVE, 0); }
		public TerminalNode SEALED() { return getToken(JavaParser.SEALED, 0); }
		public TerminalNode PERMITS() { return getToken(JavaParser.PERMITS, 0); }
		public TerminalNode RECORD() { return getToken(JavaParser.RECORD, 0); }
		public TypeIdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeIdentifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).enterTypeIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).exitTypeIdentifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaParserVisitor ) return ((JavaParserVisitor<? extends T>)visitor).visitTypeIdentifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeIdentifierContext typeIdentifier() throws RecognitionException {
		TypeIdentifierContext _localctx = new TypeIdentifierContext(_ctx, getState());
		enterRule(_localctx, 150, RULE_typeIdentifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(998);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & -6919780827454767104L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 2305843009213693955L) != 0)) ) {
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

	@SuppressWarnings("CheckReturnValue")
	public static class StatementContext extends org.example.myparser.common.context.ExtendContext {
		public BlockContext blockLabel;
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public LocalVariableDeclarationStmtContext localVariableDeclarationStmt() {
			return getRuleContext(LocalVariableDeclarationStmtContext.class,0);
		}
		public AssertStmtContext assertStmt() {
			return getRuleContext(AssertStmtContext.class,0);
		}
		public IfStmtContext ifStmt() {
			return getRuleContext(IfStmtContext.class,0);
		}
		public IfElseStmtContext ifElseStmt() {
			return getRuleContext(IfElseStmtContext.class,0);
		}
		public ForStmtContext forStmt() {
			return getRuleContext(ForStmtContext.class,0);
		}
		public WhileStmtContext whileStmt() {
			return getRuleContext(WhileStmtContext.class,0);
		}
		public DoWhileStmtContext doWhileStmt() {
			return getRuleContext(DoWhileStmtContext.class,0);
		}
		public TryCatchStmtContext tryCatchStmt() {
			return getRuleContext(TryCatchStmtContext.class,0);
		}
		public TryResourceStmtContext tryResourceStmt() {
			return getRuleContext(TryResourceStmtContext.class,0);
		}
		public SwitchStmtContext switchStmt() {
			return getRuleContext(SwitchStmtContext.class,0);
		}
		public SyncStmtContext syncStmt() {
			return getRuleContext(SyncStmtContext.class,0);
		}
		public ReturnStmtContext returnStmt() {
			return getRuleContext(ReturnStmtContext.class,0);
		}
		public ThrowStmtContext throwStmt() {
			return getRuleContext(ThrowStmtContext.class,0);
		}
		public BreakStmtContext breakStmt() {
			return getRuleContext(BreakStmtContext.class,0);
		}
		public ContinueStmtContext continueStmt() {
			return getRuleContext(ContinueStmtContext.class,0);
		}
		public YieldStmtContext yieldStmt() {
			return getRuleContext(YieldStmtContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(JavaParser.SEMI, 0); }
		public ExpressionStmtContext expressionStmt() {
			return getRuleContext(ExpressionStmtContext.class,0);
		}
		public LabelStmtContext labelStmt() {
			return getRuleContext(LabelStmtContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaParserVisitor ) return ((JavaParserVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 152, RULE_statement);
		try {
			setState(1020);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,116,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1000);
				((StatementContext)_localctx).blockLabel = block();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1001);
				localVariableDeclarationStmt();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1002);
				assertStmt();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1003);
				ifStmt();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(1004);
				ifElseStmt();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(1005);
				forStmt();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(1006);
				whileStmt();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(1007);
				doWhileStmt();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(1008);
				tryCatchStmt();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(1009);
				tryResourceStmt();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(1010);
				switchStmt();
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(1011);
				syncStmt();
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(1012);
				returnStmt();
				}
				break;
			case 14:
				enterOuterAlt(_localctx, 14);
				{
				setState(1013);
				throwStmt();
				}
				break;
			case 15:
				enterOuterAlt(_localctx, 15);
				{
				setState(1014);
				breakStmt();
				}
				break;
			case 16:
				enterOuterAlt(_localctx, 16);
				{
				setState(1015);
				continueStmt();
				}
				break;
			case 17:
				enterOuterAlt(_localctx, 17);
				{
				setState(1016);
				yieldStmt();
				}
				break;
			case 18:
				enterOuterAlt(_localctx, 18);
				{
				setState(1017);
				match(SEMI);
				}
				break;
			case 19:
				enterOuterAlt(_localctx, 19);
				{
				setState(1018);
				expressionStmt();
				}
				break;
			case 20:
				enterOuterAlt(_localctx, 20);
				{
				setState(1019);
				labelStmt();
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

	@SuppressWarnings("CheckReturnValue")
	public static class AssertStmtContext extends org.example.myparser.common.context.ExtendContext {
		public TerminalNode ASSERT() { return getToken(JavaParser.ASSERT, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode SEMI() { return getToken(JavaParser.SEMI, 0); }
		public TerminalNode COLON() { return getToken(JavaParser.COLON, 0); }
		public AssertStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assertStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).enterAssertStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).exitAssertStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaParserVisitor ) return ((JavaParserVisitor<? extends T>)visitor).visitAssertStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssertStmtContext assertStmt() throws RecognitionException {
		AssertStmtContext _localctx = new AssertStmtContext(_ctx, getState());
		enterRule(_localctx, 154, RULE_assertStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1022);
			match(ASSERT);
			setState(1023);
			expression(0);
			setState(1026);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COLON) {
				{
				setState(1024);
				match(COLON);
				setState(1025);
				expression(0);
				}
			}

			setState(1028);
			match(SEMI);
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

	@SuppressWarnings("CheckReturnValue")
	public static class IfStmtContext extends org.example.myparser.common.context.ExtendContext {
		public TerminalNode IF() { return getToken(JavaParser.IF, 0); }
		public ParExpressionContext parExpression() {
			return getRuleContext(ParExpressionContext.class,0);
		}
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public IfStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).enterIfStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).exitIfStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaParserVisitor ) return ((JavaParserVisitor<? extends T>)visitor).visitIfStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfStmtContext ifStmt() throws RecognitionException {
		IfStmtContext _localctx = new IfStmtContext(_ctx, getState());
		enterRule(_localctx, 156, RULE_ifStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1030);
			match(IF);
			setState(1031);
			parExpression();
			setState(1032);
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

	@SuppressWarnings("CheckReturnValue")
	public static class IfElseStmtContext extends org.example.myparser.common.context.ExtendContext {
		public TerminalNode IF() { return getToken(JavaParser.IF, 0); }
		public ParExpressionContext parExpression() {
			return getRuleContext(ParExpressionContext.class,0);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(JavaParser.ELSE, 0); }
		public IfElseStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifElseStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).enterIfElseStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).exitIfElseStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaParserVisitor ) return ((JavaParserVisitor<? extends T>)visitor).visitIfElseStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfElseStmtContext ifElseStmt() throws RecognitionException {
		IfElseStmtContext _localctx = new IfElseStmtContext(_ctx, getState());
		enterRule(_localctx, 158, RULE_ifElseStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1034);
			match(IF);
			setState(1035);
			parExpression();
			setState(1036);
			statement();
			setState(1037);
			match(ELSE);
			setState(1038);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ForStmtContext extends org.example.myparser.common.context.ExtendContext {
		public TerminalNode FOR() { return getToken(JavaParser.FOR, 0); }
		public TerminalNode LPAREN() { return getToken(JavaParser.LPAREN, 0); }
		public ForControlContext forControl() {
			return getRuleContext(ForControlContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(JavaParser.RPAREN, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public ForStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).enterForStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).exitForStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaParserVisitor ) return ((JavaParserVisitor<? extends T>)visitor).visitForStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForStmtContext forStmt() throws RecognitionException {
		ForStmtContext _localctx = new ForStmtContext(_ctx, getState());
		enterRule(_localctx, 160, RULE_forStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1040);
			match(FOR);
			setState(1041);
			match(LPAREN);
			setState(1042);
			forControl();
			setState(1043);
			match(RPAREN);
			setState(1044);
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

	@SuppressWarnings("CheckReturnValue")
	public static class WhileStmtContext extends org.example.myparser.common.context.ExtendContext {
		public TerminalNode WHILE() { return getToken(JavaParser.WHILE, 0); }
		public ParExpressionContext parExpression() {
			return getRuleContext(ParExpressionContext.class,0);
		}
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public WhileStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).enterWhileStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).exitWhileStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaParserVisitor ) return ((JavaParserVisitor<? extends T>)visitor).visitWhileStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhileStmtContext whileStmt() throws RecognitionException {
		WhileStmtContext _localctx = new WhileStmtContext(_ctx, getState());
		enterRule(_localctx, 162, RULE_whileStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1046);
			match(WHILE);
			setState(1047);
			parExpression();
			setState(1048);
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

	@SuppressWarnings("CheckReturnValue")
	public static class DoWhileStmtContext extends org.example.myparser.common.context.ExtendContext {
		public TerminalNode DO() { return getToken(JavaParser.DO, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public TerminalNode WHILE() { return getToken(JavaParser.WHILE, 0); }
		public ParExpressionContext parExpression() {
			return getRuleContext(ParExpressionContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(JavaParser.SEMI, 0); }
		public DoWhileStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_doWhileStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).enterDoWhileStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).exitDoWhileStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaParserVisitor ) return ((JavaParserVisitor<? extends T>)visitor).visitDoWhileStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DoWhileStmtContext doWhileStmt() throws RecognitionException {
		DoWhileStmtContext _localctx = new DoWhileStmtContext(_ctx, getState());
		enterRule(_localctx, 164, RULE_doWhileStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1050);
			match(DO);
			setState(1051);
			statement();
			setState(1052);
			match(WHILE);
			setState(1053);
			parExpression();
			setState(1054);
			match(SEMI);
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

	@SuppressWarnings("CheckReturnValue")
	public static class TryCatchStmtContext extends org.example.myparser.common.context.ExtendContext {
		public TerminalNode TRY() { return getToken(JavaParser.TRY, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public FinallyBlockContext finallyBlock() {
			return getRuleContext(FinallyBlockContext.class,0);
		}
		public List<CatchClauseContext> catchClause() {
			return getRuleContexts(CatchClauseContext.class);
		}
		public CatchClauseContext catchClause(int i) {
			return getRuleContext(CatchClauseContext.class,i);
		}
		public TryCatchStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tryCatchStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).enterTryCatchStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).exitTryCatchStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaParserVisitor ) return ((JavaParserVisitor<? extends T>)visitor).visitTryCatchStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TryCatchStmtContext tryCatchStmt() throws RecognitionException {
		TryCatchStmtContext _localctx = new TryCatchStmtContext(_ctx, getState());
		enterRule(_localctx, 166, RULE_tryCatchStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1056);
			match(TRY);
			setState(1057);
			block();
			setState(1067);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CATCH:
				{
				setState(1059); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(1058);
					catchClause();
					}
					}
					setState(1061); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==CATCH );
				setState(1064);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==FINALLY) {
					{
					setState(1063);
					finallyBlock();
					}
				}

				}
				break;
			case FINALLY:
				{
				setState(1066);
				finallyBlock();
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

	@SuppressWarnings("CheckReturnValue")
	public static class TryResourceStmtContext extends org.example.myparser.common.context.ExtendContext {
		public TerminalNode TRY() { return getToken(JavaParser.TRY, 0); }
		public ResourceSpecificationContext resourceSpecification() {
			return getRuleContext(ResourceSpecificationContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public List<CatchClauseContext> catchClause() {
			return getRuleContexts(CatchClauseContext.class);
		}
		public CatchClauseContext catchClause(int i) {
			return getRuleContext(CatchClauseContext.class,i);
		}
		public FinallyBlockContext finallyBlock() {
			return getRuleContext(FinallyBlockContext.class,0);
		}
		public TryResourceStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tryResourceStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).enterTryResourceStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).exitTryResourceStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaParserVisitor ) return ((JavaParserVisitor<? extends T>)visitor).visitTryResourceStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TryResourceStmtContext tryResourceStmt() throws RecognitionException {
		TryResourceStmtContext _localctx = new TryResourceStmtContext(_ctx, getState());
		enterRule(_localctx, 168, RULE_tryResourceStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1069);
			match(TRY);
			setState(1070);
			resourceSpecification();
			setState(1071);
			block();
			setState(1075);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==CATCH) {
				{
				{
				setState(1072);
				catchClause();
				}
				}
				setState(1077);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1079);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==FINALLY) {
				{
				setState(1078);
				finallyBlock();
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

	@SuppressWarnings("CheckReturnValue")
	public static class SwitchStmtContext extends org.example.myparser.common.context.ExtendContext {
		public TerminalNode SWITCH() { return getToken(JavaParser.SWITCH, 0); }
		public ParExpressionContext parExpression() {
			return getRuleContext(ParExpressionContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public SwitchStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_switchStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).enterSwitchStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).exitSwitchStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaParserVisitor ) return ((JavaParserVisitor<? extends T>)visitor).visitSwitchStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SwitchStmtContext switchStmt() throws RecognitionException {
		SwitchStmtContext _localctx = new SwitchStmtContext(_ctx, getState());
		enterRule(_localctx, 170, RULE_switchStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1081);
			match(SWITCH);
			setState(1082);
			parExpression();
			setState(1083);
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

	@SuppressWarnings("CheckReturnValue")
	public static class SyncStmtContext extends org.example.myparser.common.context.ExtendContext {
		public TerminalNode SYNCHRONIZED() { return getToken(JavaParser.SYNCHRONIZED, 0); }
		public ParExpressionContext parExpression() {
			return getRuleContext(ParExpressionContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public SyncStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_syncStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).enterSyncStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).exitSyncStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaParserVisitor ) return ((JavaParserVisitor<? extends T>)visitor).visitSyncStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SyncStmtContext syncStmt() throws RecognitionException {
		SyncStmtContext _localctx = new SyncStmtContext(_ctx, getState());
		enterRule(_localctx, 172, RULE_syncStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1085);
			match(SYNCHRONIZED);
			setState(1086);
			parExpression();
			setState(1087);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ReturnStmtContext extends org.example.myparser.common.context.ExtendContext {
		public TerminalNode RETURN() { return getToken(JavaParser.RETURN, 0); }
		public TerminalNode SEMI() { return getToken(JavaParser.SEMI, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ReturnStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).enterReturnStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).exitReturnStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaParserVisitor ) return ((JavaParserVisitor<? extends T>)visitor).visitReturnStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReturnStmtContext returnStmt() throws RecognitionException {
		ReturnStmtContext _localctx = new ReturnStmtContext(_ctx, getState());
		enterRule(_localctx, 174, RULE_returnStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1089);
			match(RETURN);
			setState(1091);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 1)) & ~0x3f) == 0 && ((1L << (_la - 1)) & -1081850722221569L) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & -8070177853339000835L) != 0)) {
				{
				setState(1090);
				expression(0);
				}
			}

			setState(1093);
			match(SEMI);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ThrowStmtContext extends org.example.myparser.common.context.ExtendContext {
		public TerminalNode THROW() { return getToken(JavaParser.THROW, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(JavaParser.SEMI, 0); }
		public ThrowStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_throwStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).enterThrowStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).exitThrowStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaParserVisitor ) return ((JavaParserVisitor<? extends T>)visitor).visitThrowStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ThrowStmtContext throwStmt() throws RecognitionException {
		ThrowStmtContext _localctx = new ThrowStmtContext(_ctx, getState());
		enterRule(_localctx, 176, RULE_throwStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1095);
			match(THROW);
			setState(1096);
			expression(0);
			setState(1097);
			match(SEMI);
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

	@SuppressWarnings("CheckReturnValue")
	public static class BreakStmtContext extends org.example.myparser.common.context.ExtendContext {
		public TerminalNode BREAK() { return getToken(JavaParser.BREAK, 0); }
		public TerminalNode SEMI() { return getToken(JavaParser.SEMI, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public BreakStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_breakStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).enterBreakStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).exitBreakStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaParserVisitor ) return ((JavaParserVisitor<? extends T>)visitor).visitBreakStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BreakStmtContext breakStmt() throws RecognitionException {
		BreakStmtContext _localctx = new BreakStmtContext(_ctx, getState());
		enterRule(_localctx, 178, RULE_breakStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1099);
			match(BREAK);
			setState(1101);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & -2251799813685248L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 2305843009213693955L) != 0)) {
				{
				setState(1100);
				identifier();
				}
			}

			setState(1103);
			match(SEMI);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ContinueStmtContext extends org.example.myparser.common.context.ExtendContext {
		public TerminalNode CONTINUE() { return getToken(JavaParser.CONTINUE, 0); }
		public TerminalNode SEMI() { return getToken(JavaParser.SEMI, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public ContinueStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_continueStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).enterContinueStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).exitContinueStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaParserVisitor ) return ((JavaParserVisitor<? extends T>)visitor).visitContinueStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ContinueStmtContext continueStmt() throws RecognitionException {
		ContinueStmtContext _localctx = new ContinueStmtContext(_ctx, getState());
		enterRule(_localctx, 180, RULE_continueStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1105);
			match(CONTINUE);
			setState(1107);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & -2251799813685248L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 2305843009213693955L) != 0)) {
				{
				setState(1106);
				identifier();
				}
			}

			setState(1109);
			match(SEMI);
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

	@SuppressWarnings("CheckReturnValue")
	public static class YieldStmtContext extends org.example.myparser.common.context.ExtendContext {
		public TerminalNode YIELD() { return getToken(JavaParser.YIELD, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(JavaParser.SEMI, 0); }
		public YieldStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_yieldStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).enterYieldStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).exitYieldStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaParserVisitor ) return ((JavaParserVisitor<? extends T>)visitor).visitYieldStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final YieldStmtContext yieldStmt() throws RecognitionException {
		YieldStmtContext _localctx = new YieldStmtContext(_ctx, getState());
		enterRule(_localctx, 182, RULE_yieldStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1111);
			match(YIELD);
			setState(1112);
			expression(0);
			setState(1113);
			match(SEMI);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionStmtContext extends org.example.myparser.common.context.ExtendContext {
		public ExpressionContext statementExpression;
		public TerminalNode SEMI() { return getToken(JavaParser.SEMI, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ExpressionStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).enterExpressionStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).exitExpressionStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaParserVisitor ) return ((JavaParserVisitor<? extends T>)visitor).visitExpressionStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionStmtContext expressionStmt() throws RecognitionException {
		ExpressionStmtContext _localctx = new ExpressionStmtContext(_ctx, getState());
		enterRule(_localctx, 184, RULE_expressionStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1115);
			((ExpressionStmtContext)_localctx).statementExpression = expression(0);
			setState(1116);
			match(SEMI);
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

	@SuppressWarnings("CheckReturnValue")
	public static class LabelStmtContext extends org.example.myparser.common.context.ExtendContext {
		public IdentifierContext identifierLabel;
		public TerminalNode COLON() { return getToken(JavaParser.COLON, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public LabelStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_labelStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).enterLabelStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).exitLabelStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaParserVisitor ) return ((JavaParserVisitor<? extends T>)visitor).visitLabelStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LabelStmtContext labelStmt() throws RecognitionException {
		LabelStmtContext _localctx = new LabelStmtContext(_ctx, getState());
		enterRule(_localctx, 186, RULE_labelStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1118);
			((LabelStmtContext)_localctx).identifierLabel = identifier();
			setState(1119);
			match(COLON);
			setState(1120);
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

	@SuppressWarnings("CheckReturnValue")
	public static class CatchClauseContext extends org.example.myparser.common.context.ExtendContext {
		public TerminalNode CATCH() { return getToken(JavaParser.CATCH, 0); }
		public TerminalNode LPAREN() { return getToken(JavaParser.LPAREN, 0); }
		public ModifierListContext modifierList() {
			return getRuleContext(ModifierListContext.class,0);
		}
		public CatchTypeContext catchType() {
			return getRuleContext(CatchTypeContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(JavaParser.RPAREN, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public CatchClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_catchClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).enterCatchClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).exitCatchClause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaParserVisitor ) return ((JavaParserVisitor<? extends T>)visitor).visitCatchClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CatchClauseContext catchClause() throws RecognitionException {
		CatchClauseContext _localctx = new CatchClauseContext(_ctx, getState());
		enterRule(_localctx, 188, RULE_catchClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1122);
			match(CATCH);
			setState(1123);
			match(LPAREN);
			setState(1124);
			modifierList();
			setState(1125);
			catchType();
			setState(1126);
			identifier();
			setState(1127);
			match(RPAREN);
			setState(1128);
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

	@SuppressWarnings("CheckReturnValue")
	public static class CatchTypeContext extends org.example.myparser.common.context.ExtendContext {
		public List<QualifiedNameContext> qualifiedName() {
			return getRuleContexts(QualifiedNameContext.class);
		}
		public QualifiedNameContext qualifiedName(int i) {
			return getRuleContext(QualifiedNameContext.class,i);
		}
		public List<TerminalNode> BITOR() { return getTokens(JavaParser.BITOR); }
		public TerminalNode BITOR(int i) {
			return getToken(JavaParser.BITOR, i);
		}
		public CatchTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_catchType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).enterCatchType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).exitCatchType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaParserVisitor ) return ((JavaParserVisitor<? extends T>)visitor).visitCatchType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CatchTypeContext catchType() throws RecognitionException {
		CatchTypeContext _localctx = new CatchTypeContext(_ctx, getState());
		enterRule(_localctx, 190, RULE_catchType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1130);
			qualifiedName();
			setState(1135);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==BITOR) {
				{
				{
				setState(1131);
				match(BITOR);
				setState(1132);
				qualifiedName();
				}
				}
				setState(1137);
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

	@SuppressWarnings("CheckReturnValue")
	public static class FinallyBlockContext extends org.example.myparser.common.context.ExtendContext {
		public TerminalNode FINALLY() { return getToken(JavaParser.FINALLY, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public FinallyBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_finallyBlock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).enterFinallyBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).exitFinallyBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaParserVisitor ) return ((JavaParserVisitor<? extends T>)visitor).visitFinallyBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FinallyBlockContext finallyBlock() throws RecognitionException {
		FinallyBlockContext _localctx = new FinallyBlockContext(_ctx, getState());
		enterRule(_localctx, 192, RULE_finallyBlock);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1138);
			match(FINALLY);
			setState(1139);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ResourceSpecificationContext extends org.example.myparser.common.context.ExtendContext {
		public TerminalNode LPAREN() { return getToken(JavaParser.LPAREN, 0); }
		public ResourcesContext resources() {
			return getRuleContext(ResourcesContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(JavaParser.RPAREN, 0); }
		public TerminalNode SEMI() { return getToken(JavaParser.SEMI, 0); }
		public ResourceSpecificationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_resourceSpecification; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).enterResourceSpecification(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).exitResourceSpecification(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaParserVisitor ) return ((JavaParserVisitor<? extends T>)visitor).visitResourceSpecification(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ResourceSpecificationContext resourceSpecification() throws RecognitionException {
		ResourceSpecificationContext _localctx = new ResourceSpecificationContext(_ctx, getState());
		enterRule(_localctx, 194, RULE_resourceSpecification);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1141);
			match(LPAREN);
			setState(1142);
			resources();
			setState(1144);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SEMI) {
				{
				setState(1143);
				match(SEMI);
				}
			}

			setState(1146);
			match(RPAREN);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ResourcesContext extends org.example.myparser.common.context.ExtendContext {
		public List<ResourceContext> resource() {
			return getRuleContexts(ResourceContext.class);
		}
		public ResourceContext resource(int i) {
			return getRuleContext(ResourceContext.class,i);
		}
		public List<TerminalNode> SEMI() { return getTokens(JavaParser.SEMI); }
		public TerminalNode SEMI(int i) {
			return getToken(JavaParser.SEMI, i);
		}
		public ResourcesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_resources; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).enterResources(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).exitResources(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaParserVisitor ) return ((JavaParserVisitor<? extends T>)visitor).visitResources(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ResourcesContext resources() throws RecognitionException {
		ResourcesContext _localctx = new ResourcesContext(_ctx, getState());
		enterRule(_localctx, 196, RULE_resources);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1148);
			resource();
			setState(1153);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,128,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1149);
					match(SEMI);
					setState(1150);
					resource();
					}
					} 
				}
				setState(1155);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ResourceContext extends org.example.myparser.common.context.ExtendContext {
		public ModifierListContext modifierList() {
			return getRuleContext(ModifierListContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(JavaParser.ASSIGN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ClassOrInterfaceTypeContext classOrInterfaceType() {
			return getRuleContext(ClassOrInterfaceTypeContext.class,0);
		}
		public VariableDeclaratorIdContext variableDeclaratorId() {
			return getRuleContext(VariableDeclaratorIdContext.class,0);
		}
		public TerminalNode VAR() { return getToken(JavaParser.VAR, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public QualifiedNameContext qualifiedName() {
			return getRuleContext(QualifiedNameContext.class,0);
		}
		public ResourceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_resource; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).enterResource(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).exitResource(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaParserVisitor ) return ((JavaParserVisitor<? extends T>)visitor).visitResource(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ResourceContext resource() throws RecognitionException {
		ResourceContext _localctx = new ResourceContext(_ctx, getState());
		enterRule(_localctx, 198, RULE_resource);
		try {
			setState(1168);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,130,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1156);
				modifierList();
				setState(1162);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,129,_ctx) ) {
				case 1:
					{
					setState(1157);
					classOrInterfaceType();
					setState(1158);
					variableDeclaratorId();
					}
					break;
				case 2:
					{
					setState(1160);
					match(VAR);
					setState(1161);
					identifier();
					}
					break;
				}
				setState(1164);
				match(ASSIGN);
				setState(1165);
				expression(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1167);
				qualifiedName();
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

	@SuppressWarnings("CheckReturnValue")
	public static class SwitchLabelContext extends org.example.myparser.common.context.ExtendContext {
		public ExpressionContext constantExpression;
		public Token enumConstantName;
		public IdentifierContext varName;
		public TerminalNode CASE() { return getToken(JavaParser.CASE, 0); }
		public TerminalNode COLON() { return getToken(JavaParser.COLON, 0); }
		public TypeTypeContext typeType() {
			return getRuleContext(TypeTypeContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode IDENTIFIER() { return getToken(JavaParser.IDENTIFIER, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode DEFAULT() { return getToken(JavaParser.DEFAULT, 0); }
		public SwitchLabelContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_switchLabel; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).enterSwitchLabel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).exitSwitchLabel(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaParserVisitor ) return ((JavaParserVisitor<? extends T>)visitor).visitSwitchLabel(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SwitchLabelContext switchLabel() throws RecognitionException {
		SwitchLabelContext _localctx = new SwitchLabelContext(_ctx, getState());
		enterRule(_localctx, 200, RULE_switchLabel);
		try {
			setState(1181);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CASE:
				enterOuterAlt(_localctx, 1);
				{
				setState(1170);
				match(CASE);
				setState(1176);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,131,_ctx) ) {
				case 1:
					{
					setState(1171);
					((SwitchLabelContext)_localctx).constantExpression = expression(0);
					}
					break;
				case 2:
					{
					setState(1172);
					((SwitchLabelContext)_localctx).enumConstantName = match(IDENTIFIER);
					}
					break;
				case 3:
					{
					setState(1173);
					typeType();
					setState(1174);
					((SwitchLabelContext)_localctx).varName = identifier();
					}
					break;
				}
				setState(1178);
				match(COLON);
				}
				break;
			case DEFAULT:
				enterOuterAlt(_localctx, 2);
				{
				setState(1179);
				match(DEFAULT);
				setState(1180);
				match(COLON);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ForControlContext extends org.example.myparser.common.context.ExtendContext {
		public ExpressionListContext forUpdate;
		public EnhancedForControlContext enhancedForControl() {
			return getRuleContext(EnhancedForControlContext.class,0);
		}
		public List<TerminalNode> SEMI() { return getTokens(JavaParser.SEMI); }
		public TerminalNode SEMI(int i) {
			return getToken(JavaParser.SEMI, i);
		}
		public ForInitContext forInit() {
			return getRuleContext(ForInitContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ExpressionListContext expressionList() {
			return getRuleContext(ExpressionListContext.class,0);
		}
		public ForControlContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forControl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).enterForControl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).exitForControl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaParserVisitor ) return ((JavaParserVisitor<? extends T>)visitor).visitForControl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForControlContext forControl() throws RecognitionException {
		ForControlContext _localctx = new ForControlContext(_ctx, getState());
		enterRule(_localctx, 202, RULE_forControl);
		int _la;
		try {
			setState(1195);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,136,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1183);
				enhancedForControl();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1185);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 1)) & ~0x3f) == 0 && ((1L << (_la - 1)) & -211276814843393L) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & -8070177853339000833L) != 0)) {
					{
					setState(1184);
					forInit();
					}
				}

				setState(1187);
				match(SEMI);
				setState(1189);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 1)) & ~0x3f) == 0 && ((1L << (_la - 1)) & -1081850722221569L) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & -8070177853339000835L) != 0)) {
					{
					setState(1188);
					expression(0);
					}
				}

				setState(1191);
				match(SEMI);
				setState(1193);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 1)) & ~0x3f) == 0 && ((1L << (_la - 1)) & -1081850722221569L) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & -8070177853339000835L) != 0)) {
					{
					setState(1192);
					((ForControlContext)_localctx).forUpdate = expressionList();
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

	@SuppressWarnings("CheckReturnValue")
	public static class ForInitContext extends org.example.myparser.common.context.ExtendContext {
		public LocalVariableDeclarationContext localVariableDeclaration() {
			return getRuleContext(LocalVariableDeclarationContext.class,0);
		}
		public ExpressionListContext expressionList() {
			return getRuleContext(ExpressionListContext.class,0);
		}
		public ForInitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forInit; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).enterForInit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).exitForInit(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaParserVisitor ) return ((JavaParserVisitor<? extends T>)visitor).visitForInit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForInitContext forInit() throws RecognitionException {
		ForInitContext _localctx = new ForInitContext(_ctx, getState());
		enterRule(_localctx, 204, RULE_forInit);
		try {
			setState(1199);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,137,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1197);
				localVariableDeclaration();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1198);
				expressionList();
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

	@SuppressWarnings("CheckReturnValue")
	public static class EnhancedForControlContext extends org.example.myparser.common.context.ExtendContext {
		public ModifierListContext modifierList() {
			return getRuleContext(ModifierListContext.class,0);
		}
		public VariableDeclaratorIdContext variableDeclaratorId() {
			return getRuleContext(VariableDeclaratorIdContext.class,0);
		}
		public TerminalNode COLON() { return getToken(JavaParser.COLON, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TypeTypeContext typeType() {
			return getRuleContext(TypeTypeContext.class,0);
		}
		public TerminalNode VAR() { return getToken(JavaParser.VAR, 0); }
		public EnhancedForControlContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enhancedForControl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).enterEnhancedForControl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).exitEnhancedForControl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaParserVisitor ) return ((JavaParserVisitor<? extends T>)visitor).visitEnhancedForControl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EnhancedForControlContext enhancedForControl() throws RecognitionException {
		EnhancedForControlContext _localctx = new EnhancedForControlContext(_ctx, getState());
		enterRule(_localctx, 206, RULE_enhancedForControl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1201);
			modifierList();
			setState(1204);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,138,_ctx) ) {
			case 1:
				{
				setState(1202);
				typeType();
				}
				break;
			case 2:
				{
				setState(1203);
				match(VAR);
				}
				break;
			}
			setState(1206);
			variableDeclaratorId();
			setState(1207);
			match(COLON);
			setState(1208);
			expression(0);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ParExpressionContext extends org.example.myparser.common.context.ExtendContext {
		public TerminalNode LPAREN() { return getToken(JavaParser.LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(JavaParser.RPAREN, 0); }
		public ParExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).enterParExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).exitParExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaParserVisitor ) return ((JavaParserVisitor<? extends T>)visitor).visitParExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParExpressionContext parExpression() throws RecognitionException {
		ParExpressionContext _localctx = new ParExpressionContext(_ctx, getState());
		enterRule(_localctx, 208, RULE_parExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1210);
			match(LPAREN);
			setState(1211);
			expression(0);
			setState(1212);
			match(RPAREN);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionListContext extends org.example.myparser.common.context.ExtendContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(JavaParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(JavaParser.COMMA, i);
		}
		public ExpressionListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).enterExpressionList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).exitExpressionList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaParserVisitor ) return ((JavaParserVisitor<? extends T>)visitor).visitExpressionList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionListContext expressionList() throws RecognitionException {
		ExpressionListContext _localctx = new ExpressionListContext(_ctx, getState());
		enterRule(_localctx, 210, RULE_expressionList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1214);
			expression(0);
			setState(1219);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(1215);
				match(COMMA);
				setState(1216);
				expression(0);
				}
				}
				setState(1221);
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

	@SuppressWarnings("CheckReturnValue")
	public static class MethodCallContext extends org.example.myparser.common.context.ExtendContext {
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode THIS() { return getToken(JavaParser.THIS, 0); }
		public TerminalNode SUPER() { return getToken(JavaParser.SUPER, 0); }
		public MethodCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodCall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).enterMethodCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).exitMethodCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaParserVisitor ) return ((JavaParserVisitor<? extends T>)visitor).visitMethodCall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodCallContext methodCall() throws RecognitionException {
		MethodCallContext _localctx = new MethodCallContext(_ctx, getState());
		enterRule(_localctx, 212, RULE_methodCall);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1225);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case MODULE:
			case OPEN:
			case REQUIRES:
			case EXPORTS:
			case OPENS:
			case TO:
			case USES:
			case PROVIDES:
			case WITH:
			case TRANSITIVE:
			case VAR:
			case YIELD:
			case RECORD:
			case SEALED:
			case PERMITS:
			case IDENTIFIER:
				{
				setState(1222);
				identifier();
				}
				break;
			case THIS:
				{
				setState(1223);
				match(THIS);
				}
				break;
			case SUPER:
				{
				setState(1224);
				match(SUPER);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(1227);
			arguments();
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

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionContext extends org.example.myparser.common.context.ExtendContext {
		public Token prefix;
		public Token bop;
		public Token postfix;
		public TerminalNode LPAREN() { return getToken(JavaParser.LPAREN, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode RPAREN() { return getToken(JavaParser.RPAREN, 0); }
		public TerminalNode THIS() { return getToken(JavaParser.THIS, 0); }
		public TerminalNode SUPER() { return getToken(JavaParser.SUPER, 0); }
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public List<TypeTypeContext> typeType() {
			return getRuleContexts(TypeTypeContext.class);
		}
		public TypeTypeContext typeType(int i) {
			return getRuleContext(TypeTypeContext.class,i);
		}
		public TerminalNode DOT() { return getToken(JavaParser.DOT, 0); }
		public TerminalNode CLASS() { return getToken(JavaParser.CLASS, 0); }
		public NonWildcardTypeArgumentsContext nonWildcardTypeArguments() {
			return getRuleContext(NonWildcardTypeArgumentsContext.class,0);
		}
		public ExplicitGenericInvocationSuffixContext explicitGenericInvocationSuffix() {
			return getRuleContext(ExplicitGenericInvocationSuffixContext.class,0);
		}
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public MethodCallContext methodCall() {
			return getRuleContext(MethodCallContext.class,0);
		}
		public TerminalNode COLONCOLON() { return getToken(JavaParser.COLONCOLON, 0); }
		public TerminalNode NEW() { return getToken(JavaParser.NEW, 0); }
		public TypeArgumentsContext typeArguments() {
			return getRuleContext(TypeArgumentsContext.class,0);
		}
		public ClassTypeContext classType() {
			return getRuleContext(ClassTypeContext.class,0);
		}
		public TerminalNode SWITCH() { return getToken(JavaParser.SWITCH, 0); }
		public ParExpressionContext parExpression() {
			return getRuleContext(ParExpressionContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TerminalNode ADD() { return getToken(JavaParser.ADD, 0); }
		public TerminalNode SUB() { return getToken(JavaParser.SUB, 0); }
		public TerminalNode INC() { return getToken(JavaParser.INC, 0); }
		public TerminalNode DEC() { return getToken(JavaParser.DEC, 0); }
		public TerminalNode TILDE() { return getToken(JavaParser.TILDE, 0); }
		public TerminalNode BANG() { return getToken(JavaParser.BANG, 0); }
		public AnnotationListContext annotationList() {
			return getRuleContext(AnnotationListContext.class,0);
		}
		public List<TerminalNode> BITAND() { return getTokens(JavaParser.BITAND); }
		public TerminalNode BITAND(int i) {
			return getToken(JavaParser.BITAND, i);
		}
		public CreatorContext creator() {
			return getRuleContext(CreatorContext.class,0);
		}
		public LambdaExpressionContext lambdaExpression() {
			return getRuleContext(LambdaExpressionContext.class,0);
		}
		public TerminalNode MUL() { return getToken(JavaParser.MUL, 0); }
		public TerminalNode DIV() { return getToken(JavaParser.DIV, 0); }
		public TerminalNode MOD() { return getToken(JavaParser.MOD, 0); }
		public List<TerminalNode> LT() { return getTokens(JavaParser.LT); }
		public TerminalNode LT(int i) {
			return getToken(JavaParser.LT, i);
		}
		public List<TerminalNode> GT() { return getTokens(JavaParser.GT); }
		public TerminalNode GT(int i) {
			return getToken(JavaParser.GT, i);
		}
		public TerminalNode LE() { return getToken(JavaParser.LE, 0); }
		public TerminalNode GE() { return getToken(JavaParser.GE, 0); }
		public TerminalNode EQUAL() { return getToken(JavaParser.EQUAL, 0); }
		public TerminalNode NOTEQUAL() { return getToken(JavaParser.NOTEQUAL, 0); }
		public TerminalNode CARET() { return getToken(JavaParser.CARET, 0); }
		public TerminalNode BITOR() { return getToken(JavaParser.BITOR, 0); }
		public TerminalNode AND() { return getToken(JavaParser.AND, 0); }
		public TerminalNode OR() { return getToken(JavaParser.OR, 0); }
		public TerminalNode COLON() { return getToken(JavaParser.COLON, 0); }
		public TerminalNode QUESTION() { return getToken(JavaParser.QUESTION, 0); }
		public TerminalNode ASSIGN() { return getToken(JavaParser.ASSIGN, 0); }
		public TerminalNode ADD_ASSIGN() { return getToken(JavaParser.ADD_ASSIGN, 0); }
		public TerminalNode SUB_ASSIGN() { return getToken(JavaParser.SUB_ASSIGN, 0); }
		public TerminalNode MUL_ASSIGN() { return getToken(JavaParser.MUL_ASSIGN, 0); }
		public TerminalNode DIV_ASSIGN() { return getToken(JavaParser.DIV_ASSIGN, 0); }
		public TerminalNode AND_ASSIGN() { return getToken(JavaParser.AND_ASSIGN, 0); }
		public TerminalNode OR_ASSIGN() { return getToken(JavaParser.OR_ASSIGN, 0); }
		public TerminalNode XOR_ASSIGN() { return getToken(JavaParser.XOR_ASSIGN, 0); }
		public TerminalNode RSHIFT_ASSIGN() { return getToken(JavaParser.RSHIFT_ASSIGN, 0); }
		public TerminalNode URSHIFT_ASSIGN() { return getToken(JavaParser.URSHIFT_ASSIGN, 0); }
		public TerminalNode LSHIFT_ASSIGN() { return getToken(JavaParser.LSHIFT_ASSIGN, 0); }
		public TerminalNode MOD_ASSIGN() { return getToken(JavaParser.MOD_ASSIGN, 0); }
		public TerminalNode LBRACK() { return getToken(JavaParser.LBRACK, 0); }
		public TerminalNode RBRACK() { return getToken(JavaParser.RBRACK, 0); }
		public InnerCreatorContext innerCreator() {
			return getRuleContext(InnerCreatorContext.class,0);
		}
		public SuperSuffixContext superSuffix() {
			return getRuleContext(SuperSuffixContext.class,0);
		}
		public ExplicitGenericInvocationContext explicitGenericInvocation() {
			return getRuleContext(ExplicitGenericInvocationContext.class,0);
		}
		public TerminalNode INSTANCEOF() { return getToken(JavaParser.INSTANCEOF, 0); }
		public PatternContext pattern() {
			return getRuleContext(PatternContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaParserVisitor ) return ((JavaParserVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 214;
		enterRecursionRule(_localctx, 214, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1287);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,146,_ctx) ) {
			case 1:
				{
				setState(1230);
				match(LPAREN);
				setState(1231);
				expression(0);
				setState(1232);
				match(RPAREN);
				}
				break;
			case 2:
				{
				setState(1234);
				match(THIS);
				}
				break;
			case 3:
				{
				setState(1235);
				match(SUPER);
				}
				break;
			case 4:
				{
				setState(1236);
				literal();
				}
				break;
			case 5:
				{
				setState(1237);
				identifier();
				}
				break;
			case 6:
				{
				setState(1238);
				typeType();
				setState(1239);
				match(DOT);
				setState(1240);
				match(CLASS);
				}
				break;
			case 7:
				{
				setState(1242);
				nonWildcardTypeArguments();
				setState(1246);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case SUPER:
				case MODULE:
				case OPEN:
				case REQUIRES:
				case EXPORTS:
				case OPENS:
				case TO:
				case USES:
				case PROVIDES:
				case WITH:
				case TRANSITIVE:
				case VAR:
				case YIELD:
				case RECORD:
				case SEALED:
				case PERMITS:
				case IDENTIFIER:
					{
					setState(1243);
					explicitGenericInvocationSuffix();
					}
					break;
				case THIS:
					{
					setState(1244);
					match(THIS);
					setState(1245);
					arguments();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case 8:
				{
				setState(1248);
				methodCall();
				}
				break;
			case 9:
				{
				setState(1249);
				typeType();
				setState(1250);
				match(COLONCOLON);
				setState(1256);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case MODULE:
				case OPEN:
				case REQUIRES:
				case EXPORTS:
				case OPENS:
				case TO:
				case USES:
				case PROVIDES:
				case WITH:
				case TRANSITIVE:
				case VAR:
				case YIELD:
				case RECORD:
				case SEALED:
				case PERMITS:
				case LT:
				case IDENTIFIER:
					{
					setState(1252);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==LT) {
						{
						setState(1251);
						typeArguments();
						}
					}

					setState(1254);
					identifier();
					}
					break;
				case NEW:
					{
					setState(1255);
					match(NEW);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case 10:
				{
				setState(1258);
				classType();
				setState(1259);
				match(COLONCOLON);
				setState(1261);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LT) {
					{
					setState(1260);
					typeArguments();
					}
				}

				setState(1263);
				match(NEW);
				}
				break;
			case 11:
				{
				setState(1265);
				match(SWITCH);
				setState(1266);
				parExpression();
				setState(1267);
				block();
				}
				break;
			case 12:
				{
				setState(1269);
				((ExpressionContext)_localctx).prefix = _input.LT(1);
				_la = _input.LA(1);
				if ( !(((((_la - 88)) & ~0x3f) == 0 && ((1L << (_la - 88)) & 15728643L) != 0)) ) {
					((ExpressionContext)_localctx).prefix = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(1270);
				expression(17);
				}
				break;
			case 13:
				{
				setState(1271);
				match(LPAREN);
				setState(1272);
				annotationList();
				setState(1273);
				typeType();
				setState(1278);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==BITAND) {
					{
					{
					setState(1274);
					match(BITAND);
					setState(1275);
					typeType();
					}
					}
					setState(1280);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1281);
				match(RPAREN);
				setState(1282);
				expression(16);
				}
				break;
			case 14:
				{
				setState(1284);
				match(NEW);
				setState(1285);
				creator();
				}
				break;
			case 15:
				{
				setState(1286);
				lambdaExpression();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(1372);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,153,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(1370);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,152,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1289);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(1290);
						((ExpressionContext)_localctx).bop = _input.LT(1);
						_la = _input.LA(1);
						if ( !(((((_la - 90)) & ~0x3f) == 0 && ((1L << (_la - 90)) & 7L) != 0)) ) {
							((ExpressionContext)_localctx).bop = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(1291);
						expression(15);
						}
						break;
					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1292);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(1293);
						((ExpressionContext)_localctx).bop = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==ADD || _la==SUB) ) {
							((ExpressionContext)_localctx).bop = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(1294);
						expression(14);
						}
						break;
					case 3:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1295);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(1303);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,147,_ctx) ) {
						case 1:
							{
							setState(1296);
							match(LT);
							setState(1297);
							match(LT);
							}
							break;
						case 2:
							{
							setState(1298);
							match(GT);
							setState(1299);
							match(GT);
							}
							break;
						case 3:
							{
							setState(1300);
							match(GT);
							setState(1301);
							match(GT);
							setState(1302);
							match(GT);
							}
							break;
						}
						setState(1305);
						expression(13);
						}
						break;
					case 4:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1306);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(1307);
						((ExpressionContext)_localctx).bop = _input.LT(1);
						_la = _input.LA(1);
						if ( !(((((_la - 80)) & ~0x3f) == 0 && ((1L << (_la - 80)) & 27L) != 0)) ) {
							((ExpressionContext)_localctx).bop = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(1308);
						expression(12);
						}
						break;
					case 5:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1309);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(1310);
						((ExpressionContext)_localctx).bop = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==EQUAL || _la==NOTEQUAL) ) {
							((ExpressionContext)_localctx).bop = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(1311);
						expression(10);
						}
						break;
					case 6:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1312);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(1313);
						((ExpressionContext)_localctx).bop = match(BITAND);
						setState(1314);
						expression(9);
						}
						break;
					case 7:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1315);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(1316);
						((ExpressionContext)_localctx).bop = match(CARET);
						setState(1317);
						expression(8);
						}
						break;
					case 8:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1318);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(1319);
						((ExpressionContext)_localctx).bop = match(BITOR);
						setState(1320);
						expression(7);
						}
						break;
					case 9:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1321);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(1322);
						((ExpressionContext)_localctx).bop = match(AND);
						setState(1323);
						expression(6);
						}
						break;
					case 10:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1324);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(1325);
						((ExpressionContext)_localctx).bop = match(OR);
						setState(1326);
						expression(5);
						}
						break;
					case 11:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1327);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(1328);
						((ExpressionContext)_localctx).bop = match(QUESTION);
						setState(1329);
						expression(0);
						setState(1330);
						match(COLON);
						setState(1331);
						expression(3);
						}
						break;
					case 12:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1333);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(1334);
						((ExpressionContext)_localctx).bop = _input.LT(1);
						_la = _input.LA(1);
						if ( !(((((_la - 96)) & ~0x3f) == 0 && ((1L << (_la - 96)) & 4095L) != 0)) ) {
							((ExpressionContext)_localctx).bop = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(1335);
						expression(2);
						}
						break;
					case 13:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1336);
						if (!(precpred(_ctx, 25))) throw new FailedPredicateException(this, "precpred(_ctx, 25)");
						setState(1337);
						match(LBRACK);
						setState(1338);
						expression(0);
						setState(1339);
						match(RBRACK);
						}
						break;
					case 14:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1341);
						if (!(precpred(_ctx, 24))) throw new FailedPredicateException(this, "precpred(_ctx, 24)");
						setState(1342);
						((ExpressionContext)_localctx).bop = match(DOT);
						setState(1354);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,149,_ctx) ) {
						case 1:
							{
							setState(1343);
							identifier();
							}
							break;
						case 2:
							{
							setState(1344);
							methodCall();
							}
							break;
						case 3:
							{
							setState(1345);
							match(THIS);
							}
							break;
						case 4:
							{
							setState(1346);
							match(NEW);
							setState(1348);
							_errHandler.sync(this);
							_la = _input.LA(1);
							if (_la==LT) {
								{
								setState(1347);
								nonWildcardTypeArguments();
								}
							}

							setState(1350);
							innerCreator();
							}
							break;
						case 5:
							{
							setState(1351);
							match(SUPER);
							setState(1352);
							superSuffix();
							}
							break;
						case 6:
							{
							setState(1353);
							explicitGenericInvocation();
							}
							break;
						}
						}
						break;
					case 15:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1356);
						if (!(precpred(_ctx, 22))) throw new FailedPredicateException(this, "precpred(_ctx, 22)");
						setState(1357);
						match(COLONCOLON);
						setState(1359);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==LT) {
							{
							setState(1358);
							typeArguments();
							}
						}

						setState(1361);
						identifier();
						}
						break;
					case 16:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1362);
						if (!(precpred(_ctx, 18))) throw new FailedPredicateException(this, "precpred(_ctx, 18)");
						setState(1363);
						((ExpressionContext)_localctx).postfix = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==INC || _la==DEC) ) {
							((ExpressionContext)_localctx).postfix = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						}
						break;
					case 17:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1364);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(1365);
						((ExpressionContext)_localctx).bop = match(INSTANCEOF);
						setState(1368);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,151,_ctx) ) {
						case 1:
							{
							setState(1366);
							typeType();
							}
							break;
						case 2:
							{
							setState(1367);
							pattern();
							}
							break;
						}
						}
						break;
					}
					} 
				}
				setState(1374);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,153,_ctx);
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

	@SuppressWarnings("CheckReturnValue")
	public static class PatternContext extends org.example.myparser.common.context.ExtendContext {
		public ModifierListContext modifierList() {
			return getRuleContext(ModifierListContext.class,0);
		}
		public TypeTypeContext typeType() {
			return getRuleContext(TypeTypeContext.class,0);
		}
		public AnnotationListContext annotationList() {
			return getRuleContext(AnnotationListContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public PatternContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pattern; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).enterPattern(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).exitPattern(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaParserVisitor ) return ((JavaParserVisitor<? extends T>)visitor).visitPattern(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PatternContext pattern() throws RecognitionException {
		PatternContext _localctx = new PatternContext(_ctx, getState());
		enterRule(_localctx, 216, RULE_pattern);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1375);
			modifierList();
			setState(1376);
			typeType();
			setState(1377);
			annotationList();
			setState(1378);
			identifier();
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

	@SuppressWarnings("CheckReturnValue")
	public static class LambdaExpressionContext extends org.example.myparser.common.context.ExtendContext {
		public LambdaParametersContext lambdaParameters() {
			return getRuleContext(LambdaParametersContext.class,0);
		}
		public TerminalNode ARROW() { return getToken(JavaParser.ARROW, 0); }
		public LambdaBodyContext lambdaBody() {
			return getRuleContext(LambdaBodyContext.class,0);
		}
		public LambdaExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lambdaExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).enterLambdaExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).exitLambdaExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaParserVisitor ) return ((JavaParserVisitor<? extends T>)visitor).visitLambdaExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LambdaExpressionContext lambdaExpression() throws RecognitionException {
		LambdaExpressionContext _localctx = new LambdaExpressionContext(_ctx, getState());
		enterRule(_localctx, 218, RULE_lambdaExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1380);
			lambdaParameters();
			setState(1381);
			match(ARROW);
			setState(1382);
			lambdaBody();
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

	@SuppressWarnings("CheckReturnValue")
	public static class LambdaParametersContext extends org.example.myparser.common.context.ExtendContext {
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public TerminalNode LPAREN() { return getToken(JavaParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(JavaParser.RPAREN, 0); }
		public FormalParameterListContext formalParameterList() {
			return getRuleContext(FormalParameterListContext.class,0);
		}
		public List<TerminalNode> COMMA() { return getTokens(JavaParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(JavaParser.COMMA, i);
		}
		public LambdaLVTIListContext lambdaLVTIList() {
			return getRuleContext(LambdaLVTIListContext.class,0);
		}
		public LambdaParametersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lambdaParameters; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).enterLambdaParameters(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).exitLambdaParameters(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaParserVisitor ) return ((JavaParserVisitor<? extends T>)visitor).visitLambdaParameters(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LambdaParametersContext lambdaParameters() throws RecognitionException {
		LambdaParametersContext _localctx = new LambdaParametersContext(_ctx, getState());
		enterRule(_localctx, 220, RULE_lambdaParameters);
		int _la;
		try {
			setState(1406);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,157,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1384);
				identifier();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1385);
				match(LPAREN);
				setState(1387);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 1)) & ~0x3f) == 0 && ((1L << (_la - 1)) & -255325999463937L) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & -8070450532247928829L) != 0)) {
					{
					setState(1386);
					formalParameterList();
					}
				}

				setState(1389);
				match(RPAREN);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1390);
				match(LPAREN);
				setState(1391);
				identifier();
				setState(1396);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(1392);
					match(COMMA);
					setState(1393);
					identifier();
					}
					}
					setState(1398);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1399);
				match(RPAREN);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1401);
				match(LPAREN);
				setState(1403);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 24)) & ~0x3f) == 0 && ((1L << (_la - 24)) & 8796062584977L) != 0) || _la==IDENTIFIER || _la==AT) {
					{
					setState(1402);
					lambdaLVTIList();
					}
				}

				setState(1405);
				match(RPAREN);
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

	@SuppressWarnings("CheckReturnValue")
	public static class LambdaBodyContext extends org.example.myparser.common.context.ExtendContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public LambdaBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lambdaBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).enterLambdaBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).exitLambdaBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaParserVisitor ) return ((JavaParserVisitor<? extends T>)visitor).visitLambdaBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LambdaBodyContext lambdaBody() throws RecognitionException {
		LambdaBodyContext _localctx = new LambdaBodyContext(_ctx, getState());
		enterRule(_localctx, 222, RULE_lambdaBody);
		try {
			setState(1410);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BOOLEAN:
			case BYTE:
			case CHAR:
			case DOUBLE:
			case FLOAT:
			case INT:
			case LONG:
			case SHORT:
			case VOID:
			case SWITCH:
			case NEW:
			case SUPER:
			case THIS:
			case MODULE:
			case OPEN:
			case REQUIRES:
			case EXPORTS:
			case OPENS:
			case TO:
			case USES:
			case PROVIDES:
			case WITH:
			case TRANSITIVE:
			case VAR:
			case YIELD:
			case RECORD:
			case SEALED:
			case PERMITS:
			case DECIMAL_LITERAL:
			case HEX_LITERAL:
			case OCT_LITERAL:
			case BINARY_LITERAL:
			case FLOAT_LITERAL:
			case HEX_FLOAT_LITERAL:
			case CHAR_LITERAL:
			case STRING_LITERAL:
			case TEXT_BLOCK:
			case BOOL_LITERAL:
			case NULL_LITERAL:
			case LT:
			case ADD:
			case SUB:
			case TILDE:
			case BANG:
			case INC:
			case DEC:
			case LPAREN:
			case IDENTIFIER:
			case AT:
				enterOuterAlt(_localctx, 1);
				{
				setState(1408);
				expression(0);
				}
				break;
			case LBRACE:
				enterOuterAlt(_localctx, 2);
				{
				setState(1409);
				block();
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

	@SuppressWarnings("CheckReturnValue")
	public static class SwitchLabeledRuleContext extends org.example.myparser.common.context.ExtendContext {
		public TerminalNode CASE() { return getToken(JavaParser.CASE, 0); }
		public TerminalNode ARROW() { return getToken(JavaParser.ARROW, 0); }
		public TerminalNode COLON() { return getToken(JavaParser.COLON, 0); }
		public ExpressionListContext expressionList() {
			return getRuleContext(ExpressionListContext.class,0);
		}
		public TerminalNode NULL_LITERAL() { return getToken(JavaParser.NULL_LITERAL, 0); }
		public GuardedPatternContext guardedPattern() {
			return getRuleContext(GuardedPatternContext.class,0);
		}
		public List<TypeDeclarationContext> typeDeclaration() {
			return getRuleContexts(TypeDeclarationContext.class);
		}
		public TypeDeclarationContext typeDeclaration(int i) {
			return getRuleContext(TypeDeclarationContext.class,i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public TerminalNode DEFAULT() { return getToken(JavaParser.DEFAULT, 0); }
		public SwitchLabeledRuleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_switchLabeledRule; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).enterSwitchLabeledRule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).exitSwitchLabeledRule(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaParserVisitor ) return ((JavaParserVisitor<? extends T>)visitor).visitSwitchLabeledRule(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SwitchLabeledRuleContext switchLabeledRule() throws RecognitionException {
		SwitchLabeledRuleContext _localctx = new SwitchLabeledRuleContext(_ctx, getState());
		enterRule(_localctx, 224, RULE_switchLabeledRule);
		int _la;
		try {
			int _alt;
			setState(1435);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CASE:
				enterOuterAlt(_localctx, 1);
				{
				setState(1412);
				match(CASE);
				setState(1416);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,159,_ctx) ) {
				case 1:
					{
					setState(1413);
					expressionList();
					}
					break;
				case 2:
					{
					setState(1414);
					match(NULL_LITERAL);
					}
					break;
				case 3:
					{
					setState(1415);
					guardedPattern(0);
					}
					break;
				}
				setState(1418);
				_la = _input.LA(1);
				if ( !(_la==COLON || _la==ARROW) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(1423);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,161,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						setState(1421);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,160,_ctx) ) {
						case 1:
							{
							setState(1419);
							typeDeclaration();
							}
							break;
						case 2:
							{
							setState(1420);
							statement();
							}
							break;
						}
						} 
					}
					setState(1425);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,161,_ctx);
				}
				}
				break;
			case DEFAULT:
				enterOuterAlt(_localctx, 2);
				{
				setState(1426);
				match(DEFAULT);
				setState(1427);
				_la = _input.LA(1);
				if ( !(_la==COLON || _la==ARROW) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(1432);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,163,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						setState(1430);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,162,_ctx) ) {
						case 1:
							{
							setState(1428);
							typeDeclaration();
							}
							break;
						case 2:
							{
							setState(1429);
							statement();
							}
							break;
						}
						} 
					}
					setState(1434);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,163,_ctx);
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

	@SuppressWarnings("CheckReturnValue")
	public static class GuardedPatternContext extends org.example.myparser.common.context.ExtendContext {
		public TerminalNode LPAREN() { return getToken(JavaParser.LPAREN, 0); }
		public GuardedPatternContext guardedPattern() {
			return getRuleContext(GuardedPatternContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(JavaParser.RPAREN, 0); }
		public ModifierListContext modifierList() {
			return getRuleContext(ModifierListContext.class,0);
		}
		public TypeTypeContext typeType() {
			return getRuleContext(TypeTypeContext.class,0);
		}
		public AnnotationListContext annotationList() {
			return getRuleContext(AnnotationListContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public List<TerminalNode> AND() { return getTokens(JavaParser.AND); }
		public TerminalNode AND(int i) {
			return getToken(JavaParser.AND, i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public GuardedPatternContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_guardedPattern; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).enterGuardedPattern(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).exitGuardedPattern(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaParserVisitor ) return ((JavaParserVisitor<? extends T>)visitor).visitGuardedPattern(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GuardedPatternContext guardedPattern() throws RecognitionException {
		return guardedPattern(0);
	}

	private GuardedPatternContext guardedPattern(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		GuardedPatternContext _localctx = new GuardedPatternContext(_ctx, _parentState);
		GuardedPatternContext _prevctx = _localctx;
		int _startState = 226;
		enterRecursionRule(_localctx, 226, RULE_guardedPattern, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1453);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LPAREN:
				{
				setState(1438);
				match(LPAREN);
				setState(1439);
				guardedPattern(0);
				setState(1440);
				match(RPAREN);
				}
				break;
			case BOOLEAN:
			case BYTE:
			case CHAR:
			case DOUBLE:
			case FLOAT:
			case INT:
			case LONG:
			case SHORT:
			case VOID:
			case ABSTRACT:
			case DEFAULT:
			case FINAL:
			case NATIVE:
			case PRIVATE:
			case PROTECTED:
			case PUBLIC:
			case STATIC:
			case STRICTFP:
			case SYNCHRONIZED:
			case TRANSIENT:
			case VOLATILE:
			case MODULE:
			case OPEN:
			case REQUIRES:
			case EXPORTS:
			case OPENS:
			case TO:
			case USES:
			case PROVIDES:
			case WITH:
			case TRANSITIVE:
			case VAR:
			case YIELD:
			case RECORD:
			case SEALED:
			case PERMITS:
			case NON_SEALED:
			case IDENTIFIER:
			case AT:
				{
				setState(1442);
				modifierList();
				setState(1443);
				typeType();
				setState(1444);
				annotationList();
				setState(1445);
				identifier();
				setState(1450);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,165,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(1446);
						match(AND);
						setState(1447);
						expression(0);
						}
						} 
					}
					setState(1452);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,165,_ctx);
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(1460);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,167,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new GuardedPatternContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_guardedPattern);
					setState(1455);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(1456);
					match(AND);
					setState(1457);
					expression(0);
					}
					} 
				}
				setState(1462);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,167,_ctx);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ClassTypeContext extends org.example.myparser.common.context.ExtendContext {
		public AnnotationListContext annotationList() {
			return getRuleContext(AnnotationListContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public ClassOrInterfaceTypeContext classOrInterfaceType() {
			return getRuleContext(ClassOrInterfaceTypeContext.class,0);
		}
		public TerminalNode DOT() { return getToken(JavaParser.DOT, 0); }
		public TypeArgumentsContext typeArguments() {
			return getRuleContext(TypeArgumentsContext.class,0);
		}
		public ClassTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).enterClassType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).exitClassType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaParserVisitor ) return ((JavaParserVisitor<? extends T>)visitor).visitClassType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassTypeContext classType() throws RecognitionException {
		ClassTypeContext _localctx = new ClassTypeContext(_ctx, getState());
		enterRule(_localctx, 228, RULE_classType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1466);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,168,_ctx) ) {
			case 1:
				{
				setState(1463);
				classOrInterfaceType();
				setState(1464);
				match(DOT);
				}
				break;
			}
			setState(1468);
			annotationList();
			setState(1469);
			identifier();
			setState(1471);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LT) {
				{
				setState(1470);
				typeArguments();
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

	@SuppressWarnings("CheckReturnValue")
	public static class CreatorContext extends org.example.myparser.common.context.ExtendContext {
		public CreatedNameContext createdName() {
			return getRuleContext(CreatedNameContext.class,0);
		}
		public ClassCreatorRestContext classCreatorRest() {
			return getRuleContext(ClassCreatorRestContext.class,0);
		}
		public NonWildcardTypeArgumentsContext nonWildcardTypeArguments() {
			return getRuleContext(NonWildcardTypeArgumentsContext.class,0);
		}
		public ArrayCreatorRestContext arrayCreatorRest() {
			return getRuleContext(ArrayCreatorRestContext.class,0);
		}
		public CreatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_creator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).enterCreator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).exitCreator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaParserVisitor ) return ((JavaParserVisitor<? extends T>)visitor).visitCreator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CreatorContext creator() throws RecognitionException {
		CreatorContext _localctx = new CreatorContext(_ctx, getState());
		enterRule(_localctx, 230, RULE_creator);
		int _la;
		try {
			setState(1482);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,171,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1474);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LT) {
					{
					setState(1473);
					nonWildcardTypeArguments();
					}
				}

				setState(1476);
				createdName();
				setState(1477);
				classCreatorRest();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1479);
				createdName();
				setState(1480);
				arrayCreatorRest();
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

	@SuppressWarnings("CheckReturnValue")
	public static class CreatedNameContext extends org.example.myparser.common.context.ExtendContext {
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public List<TypeArgumentsOrDiamondContext> typeArgumentsOrDiamond() {
			return getRuleContexts(TypeArgumentsOrDiamondContext.class);
		}
		public TypeArgumentsOrDiamondContext typeArgumentsOrDiamond(int i) {
			return getRuleContext(TypeArgumentsOrDiamondContext.class,i);
		}
		public List<TerminalNode> DOT() { return getTokens(JavaParser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(JavaParser.DOT, i);
		}
		public PrimitiveTypeContext primitiveType() {
			return getRuleContext(PrimitiveTypeContext.class,0);
		}
		public CreatedNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_createdName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).enterCreatedName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).exitCreatedName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaParserVisitor ) return ((JavaParserVisitor<? extends T>)visitor).visitCreatedName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CreatedNameContext createdName() throws RecognitionException {
		CreatedNameContext _localctx = new CreatedNameContext(_ctx, getState());
		enterRule(_localctx, 232, RULE_createdName);
		int _la;
		try {
			setState(1499);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case MODULE:
			case OPEN:
			case REQUIRES:
			case EXPORTS:
			case OPENS:
			case TO:
			case USES:
			case PROVIDES:
			case WITH:
			case TRANSITIVE:
			case VAR:
			case YIELD:
			case RECORD:
			case SEALED:
			case PERMITS:
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(1484);
				identifier();
				setState(1486);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LT) {
					{
					setState(1485);
					typeArgumentsOrDiamond();
					}
				}

				setState(1495);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==DOT) {
					{
					{
					setState(1488);
					match(DOT);
					setState(1489);
					identifier();
					setState(1491);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==LT) {
						{
						setState(1490);
						typeArgumentsOrDiamond();
						}
					}

					}
					}
					setState(1497);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case BOOLEAN:
			case BYTE:
			case CHAR:
			case DOUBLE:
			case FLOAT:
			case INT:
			case LONG:
			case SHORT:
			case VOID:
				enterOuterAlt(_localctx, 2);
				{
				setState(1498);
				primitiveType();
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

	@SuppressWarnings("CheckReturnValue")
	public static class InnerCreatorContext extends org.example.myparser.common.context.ExtendContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public ClassCreatorRestContext classCreatorRest() {
			return getRuleContext(ClassCreatorRestContext.class,0);
		}
		public TerminalNode LT() { return getToken(JavaParser.LT, 0); }
		public TerminalNode GT() { return getToken(JavaParser.GT, 0); }
		public NonWildcardTypeArgumentsContext nonWildcardTypeArguments() {
			return getRuleContext(NonWildcardTypeArgumentsContext.class,0);
		}
		public InnerCreatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_innerCreator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).enterInnerCreator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).exitInnerCreator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaParserVisitor ) return ((JavaParserVisitor<? extends T>)visitor).visitInnerCreator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InnerCreatorContext innerCreator() throws RecognitionException {
		InnerCreatorContext _localctx = new InnerCreatorContext(_ctx, getState());
		enterRule(_localctx, 234, RULE_innerCreator);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1501);
			identifier();
			setState(1505);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,176,_ctx) ) {
			case 1:
				{
				setState(1502);
				match(LT);
				setState(1503);
				match(GT);
				}
				break;
			case 2:
				{
				setState(1504);
				nonWildcardTypeArguments();
				}
				break;
			}
			setState(1507);
			classCreatorRest();
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

	@SuppressWarnings("CheckReturnValue")
	public static class ArrayCreatorRestContext extends org.example.myparser.common.context.ExtendContext {
		public ArrayInitializerContext arrayInitializer() {
			return getRuleContext(ArrayInitializerContext.class,0);
		}
		public List<TerminalNode> LBRACK() { return getTokens(JavaParser.LBRACK); }
		public TerminalNode LBRACK(int i) {
			return getToken(JavaParser.LBRACK, i);
		}
		public List<TerminalNode> RBRACK() { return getTokens(JavaParser.RBRACK); }
		public TerminalNode RBRACK(int i) {
			return getToken(JavaParser.RBRACK, i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ArrayCreatorRestContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayCreatorRest; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).enterArrayCreatorRest(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).exitArrayCreatorRest(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaParserVisitor ) return ((JavaParserVisitor<? extends T>)visitor).visitArrayCreatorRest(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayCreatorRestContext arrayCreatorRest() throws RecognitionException {
		ArrayCreatorRestContext _localctx = new ArrayCreatorRestContext(_ctx, getState());
		enterRule(_localctx, 236, RULE_arrayCreatorRest);
		int _la;
		try {
			int _alt;
			setState(1531);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,180,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1511); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(1509);
					match(LBRACK);
					setState(1510);
					match(RBRACK);
					}
					}
					setState(1513); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==LBRACK );
				setState(1515);
				arrayInitializer();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1520); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(1516);
						match(LBRACK);
						setState(1517);
						expression(0);
						setState(1518);
						match(RBRACK);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(1522); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,178,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(1528);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,179,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(1524);
						match(LBRACK);
						setState(1525);
						match(RBRACK);
						}
						} 
					}
					setState(1530);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,179,_ctx);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ClassCreatorRestContext extends org.example.myparser.common.context.ExtendContext {
		public BodyContext classBody;
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public BodyContext body() {
			return getRuleContext(BodyContext.class,0);
		}
		public ClassCreatorRestContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classCreatorRest; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).enterClassCreatorRest(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).exitClassCreatorRest(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaParserVisitor ) return ((JavaParserVisitor<? extends T>)visitor).visitClassCreatorRest(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassCreatorRestContext classCreatorRest() throws RecognitionException {
		ClassCreatorRestContext _localctx = new ClassCreatorRestContext(_ctx, getState());
		enterRule(_localctx, 238, RULE_classCreatorRest);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1533);
			arguments();
			setState(1535);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,181,_ctx) ) {
			case 1:
				{
				setState(1534);
				((ClassCreatorRestContext)_localctx).classBody = body();
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

	@SuppressWarnings("CheckReturnValue")
	public static class ExplicitGenericInvocationContext extends org.example.myparser.common.context.ExtendContext {
		public NonWildcardTypeArgumentsContext nonWildcardTypeArguments() {
			return getRuleContext(NonWildcardTypeArgumentsContext.class,0);
		}
		public ExplicitGenericInvocationSuffixContext explicitGenericInvocationSuffix() {
			return getRuleContext(ExplicitGenericInvocationSuffixContext.class,0);
		}
		public ExplicitGenericInvocationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_explicitGenericInvocation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).enterExplicitGenericInvocation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).exitExplicitGenericInvocation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaParserVisitor ) return ((JavaParserVisitor<? extends T>)visitor).visitExplicitGenericInvocation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExplicitGenericInvocationContext explicitGenericInvocation() throws RecognitionException {
		ExplicitGenericInvocationContext _localctx = new ExplicitGenericInvocationContext(_ctx, getState());
		enterRule(_localctx, 240, RULE_explicitGenericInvocation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1537);
			nonWildcardTypeArguments();
			setState(1538);
			explicitGenericInvocationSuffix();
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

	@SuppressWarnings("CheckReturnValue")
	public static class TypeArgumentsOrDiamondContext extends org.example.myparser.common.context.ExtendContext {
		public TerminalNode LT() { return getToken(JavaParser.LT, 0); }
		public TerminalNode GT() { return getToken(JavaParser.GT, 0); }
		public TypeArgumentsContext typeArguments() {
			return getRuleContext(TypeArgumentsContext.class,0);
		}
		public TypeArgumentsOrDiamondContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeArgumentsOrDiamond; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).enterTypeArgumentsOrDiamond(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).exitTypeArgumentsOrDiamond(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaParserVisitor ) return ((JavaParserVisitor<? extends T>)visitor).visitTypeArgumentsOrDiamond(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeArgumentsOrDiamondContext typeArgumentsOrDiamond() throws RecognitionException {
		TypeArgumentsOrDiamondContext _localctx = new TypeArgumentsOrDiamondContext(_ctx, getState());
		enterRule(_localctx, 242, RULE_typeArgumentsOrDiamond);
		try {
			setState(1543);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,182,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1540);
				match(LT);
				setState(1541);
				match(GT);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1542);
				typeArguments();
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

	@SuppressWarnings("CheckReturnValue")
	public static class NonWildcardTypeArgumentsContext extends org.example.myparser.common.context.ExtendContext {
		public TerminalNode LT() { return getToken(JavaParser.LT, 0); }
		public TypeListContext typeList() {
			return getRuleContext(TypeListContext.class,0);
		}
		public TerminalNode GT() { return getToken(JavaParser.GT, 0); }
		public NonWildcardTypeArgumentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nonWildcardTypeArguments; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).enterNonWildcardTypeArguments(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).exitNonWildcardTypeArguments(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaParserVisitor ) return ((JavaParserVisitor<? extends T>)visitor).visitNonWildcardTypeArguments(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NonWildcardTypeArgumentsContext nonWildcardTypeArguments() throws RecognitionException {
		NonWildcardTypeArgumentsContext _localctx = new NonWildcardTypeArgumentsContext(_ctx, getState());
		enterRule(_localctx, 244, RULE_nonWildcardTypeArguments);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1545);
			match(LT);
			setState(1546);
			typeList();
			setState(1547);
			match(GT);
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

	@SuppressWarnings("CheckReturnValue")
	public static class TypeListContext extends org.example.myparser.common.context.ExtendContext {
		public List<TypeTypeContext> typeType() {
			return getRuleContexts(TypeTypeContext.class);
		}
		public TypeTypeContext typeType(int i) {
			return getRuleContext(TypeTypeContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(JavaParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(JavaParser.COMMA, i);
		}
		public TypeListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).enterTypeList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).exitTypeList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaParserVisitor ) return ((JavaParserVisitor<? extends T>)visitor).visitTypeList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeListContext typeList() throws RecognitionException {
		TypeListContext _localctx = new TypeListContext(_ctx, getState());
		enterRule(_localctx, 246, RULE_typeList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1549);
			typeType();
			setState(1554);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(1550);
				match(COMMA);
				setState(1551);
				typeType();
				}
				}
				setState(1556);
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

	@SuppressWarnings("CheckReturnValue")
	public static class TypeTypeContext extends org.example.myparser.common.context.ExtendContext {
		public List<AnnotationListContext> annotationList() {
			return getRuleContexts(AnnotationListContext.class);
		}
		public AnnotationListContext annotationList(int i) {
			return getRuleContext(AnnotationListContext.class,i);
		}
		public ClassOrInterfaceTypeContext classOrInterfaceType() {
			return getRuleContext(ClassOrInterfaceTypeContext.class,0);
		}
		public PrimitiveTypeContext primitiveType() {
			return getRuleContext(PrimitiveTypeContext.class,0);
		}
		public List<TerminalNode> LBRACK() { return getTokens(JavaParser.LBRACK); }
		public TerminalNode LBRACK(int i) {
			return getToken(JavaParser.LBRACK, i);
		}
		public List<TerminalNode> RBRACK() { return getTokens(JavaParser.RBRACK); }
		public TerminalNode RBRACK(int i) {
			return getToken(JavaParser.RBRACK, i);
		}
		public TypeTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).enterTypeType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).exitTypeType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaParserVisitor ) return ((JavaParserVisitor<? extends T>)visitor).visitTypeType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeTypeContext typeType() throws RecognitionException {
		TypeTypeContext _localctx = new TypeTypeContext(_ctx, getState());
		enterRule(_localctx, 248, RULE_typeType);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1557);
			annotationList();
			setState(1560);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case MODULE:
			case OPEN:
			case REQUIRES:
			case EXPORTS:
			case OPENS:
			case TO:
			case USES:
			case PROVIDES:
			case WITH:
			case TRANSITIVE:
			case VAR:
			case YIELD:
			case RECORD:
			case SEALED:
			case PERMITS:
			case IDENTIFIER:
				{
				setState(1558);
				classOrInterfaceType();
				}
				break;
			case BOOLEAN:
			case BYTE:
			case CHAR:
			case DOUBLE:
			case FLOAT:
			case INT:
			case LONG:
			case SHORT:
			case VOID:
				{
				setState(1559);
				primitiveType();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(1568);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,185,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1562);
					annotationList();
					setState(1563);
					match(LBRACK);
					setState(1564);
					match(RBRACK);
					}
					} 
				}
				setState(1570);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,185,_ctx);
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

	@SuppressWarnings("CheckReturnValue")
	public static class PrimitiveTypeContext extends org.example.myparser.common.context.ExtendContext {
		public TerminalNode BOOLEAN() { return getToken(JavaParser.BOOLEAN, 0); }
		public TerminalNode CHAR() { return getToken(JavaParser.CHAR, 0); }
		public TerminalNode BYTE() { return getToken(JavaParser.BYTE, 0); }
		public TerminalNode SHORT() { return getToken(JavaParser.SHORT, 0); }
		public TerminalNode INT() { return getToken(JavaParser.INT, 0); }
		public TerminalNode LONG() { return getToken(JavaParser.LONG, 0); }
		public TerminalNode FLOAT() { return getToken(JavaParser.FLOAT, 0); }
		public TerminalNode DOUBLE() { return getToken(JavaParser.DOUBLE, 0); }
		public TerminalNode VOID() { return getToken(JavaParser.VOID, 0); }
		public PrimitiveTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primitiveType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).enterPrimitiveType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).exitPrimitiveType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaParserVisitor ) return ((JavaParserVisitor<? extends T>)visitor).visitPrimitiveType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrimitiveTypeContext primitiveType() throws RecognitionException {
		PrimitiveTypeContext _localctx = new PrimitiveTypeContext(_ctx, getState());
		enterRule(_localctx, 250, RULE_primitiveType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1571);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 1022L) != 0)) ) {
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

	@SuppressWarnings("CheckReturnValue")
	public static class TypeArgumentsContext extends org.example.myparser.common.context.ExtendContext {
		public TerminalNode LT() { return getToken(JavaParser.LT, 0); }
		public List<TypeArgumentContext> typeArgument() {
			return getRuleContexts(TypeArgumentContext.class);
		}
		public TypeArgumentContext typeArgument(int i) {
			return getRuleContext(TypeArgumentContext.class,i);
		}
		public TerminalNode GT() { return getToken(JavaParser.GT, 0); }
		public List<TerminalNode> COMMA() { return getTokens(JavaParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(JavaParser.COMMA, i);
		}
		public TypeArgumentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeArguments; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).enterTypeArguments(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).exitTypeArguments(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaParserVisitor ) return ((JavaParserVisitor<? extends T>)visitor).visitTypeArguments(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeArgumentsContext typeArguments() throws RecognitionException {
		TypeArgumentsContext _localctx = new TypeArgumentsContext(_ctx, getState());
		enterRule(_localctx, 252, RULE_typeArguments);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1573);
			match(LT);
			setState(1574);
			typeArgument();
			setState(1579);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(1575);
				match(COMMA);
				setState(1576);
				typeArgument();
				}
				}
				setState(1581);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1582);
			match(GT);
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

	@SuppressWarnings("CheckReturnValue")
	public static class SuperSuffixContext extends org.example.myparser.common.context.ExtendContext {
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public TerminalNode DOT() { return getToken(JavaParser.DOT, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TypeArgumentsContext typeArguments() {
			return getRuleContext(TypeArgumentsContext.class,0);
		}
		public SuperSuffixContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_superSuffix; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).enterSuperSuffix(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).exitSuperSuffix(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaParserVisitor ) return ((JavaParserVisitor<? extends T>)visitor).visitSuperSuffix(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SuperSuffixContext superSuffix() throws RecognitionException {
		SuperSuffixContext _localctx = new SuperSuffixContext(_ctx, getState());
		enterRule(_localctx, 254, RULE_superSuffix);
		int _la;
		try {
			setState(1593);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LPAREN:
				enterOuterAlt(_localctx, 1);
				{
				setState(1584);
				arguments();
				}
				break;
			case DOT:
				enterOuterAlt(_localctx, 2);
				{
				setState(1585);
				match(DOT);
				setState(1587);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LT) {
					{
					setState(1586);
					typeArguments();
					}
				}

				setState(1589);
				identifier();
				setState(1591);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,188,_ctx) ) {
				case 1:
					{
					setState(1590);
					arguments();
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

	@SuppressWarnings("CheckReturnValue")
	public static class ExplicitGenericInvocationSuffixContext extends org.example.myparser.common.context.ExtendContext {
		public TerminalNode SUPER() { return getToken(JavaParser.SUPER, 0); }
		public SuperSuffixContext superSuffix() {
			return getRuleContext(SuperSuffixContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public ExplicitGenericInvocationSuffixContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_explicitGenericInvocationSuffix; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).enterExplicitGenericInvocationSuffix(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).exitExplicitGenericInvocationSuffix(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaParserVisitor ) return ((JavaParserVisitor<? extends T>)visitor).visitExplicitGenericInvocationSuffix(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExplicitGenericInvocationSuffixContext explicitGenericInvocationSuffix() throws RecognitionException {
		ExplicitGenericInvocationSuffixContext _localctx = new ExplicitGenericInvocationSuffixContext(_ctx, getState());
		enterRule(_localctx, 256, RULE_explicitGenericInvocationSuffix);
		try {
			setState(1600);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SUPER:
				enterOuterAlt(_localctx, 1);
				{
				setState(1595);
				match(SUPER);
				setState(1596);
				superSuffix();
				}
				break;
			case MODULE:
			case OPEN:
			case REQUIRES:
			case EXPORTS:
			case OPENS:
			case TO:
			case USES:
			case PROVIDES:
			case WITH:
			case TRANSITIVE:
			case VAR:
			case YIELD:
			case RECORD:
			case SEALED:
			case PERMITS:
			case IDENTIFIER:
				enterOuterAlt(_localctx, 2);
				{
				setState(1597);
				identifier();
				setState(1598);
				arguments();
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

	@SuppressWarnings("CheckReturnValue")
	public static class ArgumentsContext extends org.example.myparser.common.context.ExtendContext {
		public TerminalNode LPAREN() { return getToken(JavaParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(JavaParser.RPAREN, 0); }
		public ExpressionListContext expressionList() {
			return getRuleContext(ExpressionListContext.class,0);
		}
		public ArgumentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arguments; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).enterArguments(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener ) ((JavaParserListener)listener).exitArguments(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaParserVisitor ) return ((JavaParserVisitor<? extends T>)visitor).visitArguments(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgumentsContext arguments() throws RecognitionException {
		ArgumentsContext _localctx = new ArgumentsContext(_ctx, getState());
		enterRule(_localctx, 258, RULE_arguments);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1602);
			match(LPAREN);
			setState(1604);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 1)) & ~0x3f) == 0 && ((1L << (_la - 1)) & -1081850722221569L) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & -8070177853339000835L) != 0)) {
				{
				setState(1603);
				expressionList();
				}
			}

			setState(1606);
			match(RPAREN);
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
		case 107:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		case 113:
			return guardedPattern_sempred((GuardedPatternContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 14);
		case 1:
			return precpred(_ctx, 13);
		case 2:
			return precpred(_ctx, 12);
		case 3:
			return precpred(_ctx, 11);
		case 4:
			return precpred(_ctx, 9);
		case 5:
			return precpred(_ctx, 8);
		case 6:
			return precpred(_ctx, 7);
		case 7:
			return precpred(_ctx, 6);
		case 8:
			return precpred(_ctx, 5);
		case 9:
			return precpred(_ctx, 4);
		case 10:
			return precpred(_ctx, 3);
		case 11:
			return precpred(_ctx, 2);
		case 12:
			return precpred(_ctx, 25);
		case 13:
			return precpred(_ctx, 24);
		case 14:
			return precpred(_ctx, 22);
		case 15:
			return precpred(_ctx, 18);
		case 16:
			return precpred(_ctx, 10);
		}
		return true;
	}
	private boolean guardedPattern_sempred(GuardedPatternContext _localctx, int predIndex) {
		switch (predIndex) {
		case 17:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001\u0082\u0649\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007"+
		"\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b"+
		"\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007"+
		"\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007"+
		"\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007"+
		"\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007"+
		"\u0018\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007"+
		"\u001b\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002\u001e\u0007"+
		"\u001e\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007!\u0002\"\u0007"+
		"\"\u0002#\u0007#\u0002$\u0007$\u0002%\u0007%\u0002&\u0007&\u0002\'\u0007"+
		"\'\u0002(\u0007(\u0002)\u0007)\u0002*\u0007*\u0002+\u0007+\u0002,\u0007"+
		",\u0002-\u0007-\u0002.\u0007.\u0002/\u0007/\u00020\u00070\u00021\u0007"+
		"1\u00022\u00072\u00023\u00073\u00024\u00074\u00025\u00075\u00026\u0007"+
		"6\u00027\u00077\u00028\u00078\u00029\u00079\u0002:\u0007:\u0002;\u0007"+
		";\u0002<\u0007<\u0002=\u0007=\u0002>\u0007>\u0002?\u0007?\u0002@\u0007"+
		"@\u0002A\u0007A\u0002B\u0007B\u0002C\u0007C\u0002D\u0007D\u0002E\u0007"+
		"E\u0002F\u0007F\u0002G\u0007G\u0002H\u0007H\u0002I\u0007I\u0002J\u0007"+
		"J\u0002K\u0007K\u0002L\u0007L\u0002M\u0007M\u0002N\u0007N\u0002O\u0007"+
		"O\u0002P\u0007P\u0002Q\u0007Q\u0002R\u0007R\u0002S\u0007S\u0002T\u0007"+
		"T\u0002U\u0007U\u0002V\u0007V\u0002W\u0007W\u0002X\u0007X\u0002Y\u0007"+
		"Y\u0002Z\u0007Z\u0002[\u0007[\u0002\\\u0007\\\u0002]\u0007]\u0002^\u0007"+
		"^\u0002_\u0007_\u0002`\u0007`\u0002a\u0007a\u0002b\u0007b\u0002c\u0007"+
		"c\u0002d\u0007d\u0002e\u0007e\u0002f\u0007f\u0002g\u0007g\u0002h\u0007"+
		"h\u0002i\u0007i\u0002j\u0007j\u0002k\u0007k\u0002l\u0007l\u0002m\u0007"+
		"m\u0002n\u0007n\u0002o\u0007o\u0002p\u0007p\u0002q\u0007q\u0002r\u0007"+
		"r\u0002s\u0007s\u0002t\u0007t\u0002u\u0007u\u0002v\u0007v\u0002w\u0007"+
		"w\u0002x\u0007x\u0002y\u0007y\u0002z\u0007z\u0002{\u0007{\u0002|\u0007"+
		"|\u0002}\u0007}\u0002~\u0007~\u0002\u007f\u0007\u007f\u0002\u0080\u0007"+
		"\u0080\u0002\u0081\u0007\u0081\u0001\u0000\u0003\u0000\u0106\b\u0000\u0001"+
		"\u0000\u0003\u0000\u0109\b\u0000\u0001\u0000\u0005\u0000\u010c\b\u0000"+
		"\n\u0000\f\u0000\u010f\t\u0000\u0003\u0000\u0111\b\u0000\u0001\u0000\u0003"+
		"\u0000\u0114\b\u0000\u0001\u0000\u0005\u0000\u0117\b\u0000\n\u0000\f\u0000"+
		"\u011a\t\u0000\u0003\u0000\u011c\b\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0003\u0000\u0121\b\u0000\u0001\u0001\u0004\u0001\u0124\b\u0001"+
		"\u000b\u0001\f\u0001\u0125\u0001\u0002\u0001\u0002\u0005\u0002\u012a\b"+
		"\u0002\n\u0002\f\u0002\u012d\t\u0002\u0004\u0002\u012f\b\u0002\u000b\u0002"+
		"\f\u0002\u0130\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0004\u0001\u0004\u0003\u0004\u013a\b\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0003\u0004\u013f\b\u0004\u0001\u0004\u0001\u0004\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0005\u0005\u0153\b\u0005\n\u0005"+
		"\f\u0005\u0156\t\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0003\u0006\u015e\b\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0003\u0007\u0165\b\u0007\u0001\u0007"+
		"\u0001\u0007\u0003\u0007\u0169\b\u0007\u0001\u0007\u0001\u0007\u0003\u0007"+
		"\u016d\b\u0007\u0001\u0007\u0001\u0007\u0003\u0007\u0171\b\u0007\u0001"+
		"\b\u0001\b\u0001\b\u0003\b\u0176\b\b\u0001\b\u0001\b\u0003\b\u017a\b\b"+
		"\u0001\b\u0001\b\u0003\b\u017e\b\b\u0001\t\u0001\t\u0001\t\u0003\t\u0183"+
		"\b\t\u0001\t\u0001\t\u0001\t\u0003\t\u0188\b\t\u0001\n\u0001\n\u0001\n"+
		"\u0001\n\u0003\n\u018e\b\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\f\u0001\f\u0005\f\u0196\b\f\n\f\f\f\u0199\t\f\u0001\f\u0001\f\u0001"+
		"\f\u0003\f\u019e\b\f\u0001\f\u0003\f\u01a1\b\f\u0001\f\u0001\f\u0005\f"+
		"\u01a5\b\f\n\f\f\f\u01a8\t\f\u0003\f\u01aa\b\f\u0001\f\u0001\f\u0001\f"+
		"\u0005\f\u01af\b\f\n\f\f\f\u01b2\t\f\u0001\f\u0001\f\u0001\f\u0005\f\u01b7"+
		"\b\f\n\f\f\f\u01ba\t\f\u0001\f\u0003\f\u01bd\b\f\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0005\r\u01c3\b\r\n\r\f\r\u01c6\t\r\u0001\r\u0001\r\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0003\u000e"+
		"\u01d0\b\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0005\u000f\u01d5\b"+
		"\u000f\n\u000f\f\u000f\u01d8\t\u000f\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0005\u0010\u01dd\b\u0010\n\u0010\f\u0010\u01e0\t\u0010\u0001\u0011\u0001"+
		"\u0011\u0001\u0011\u0003\u0011\u01e5\b\u0011\u0001\u0011\u0003\u0011\u01e8"+
		"\b\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001"+
		"\u0012\u0003\u0012\u01f0\b\u0012\u0001\u0013\u0001\u0013\u0001\u0013\u0001"+
		"\u0014\u0001\u0014\u0005\u0014\u01f7\b\u0014\n\u0014\f\u0014\u01fa\t\u0014"+
		"\u0004\u0014\u01fc\b\u0014\u000b\u0014\f\u0014\u01fd\u0001\u0015\u0001"+
		"\u0015\u0005\u0015\u0202\b\u0015\n\u0015\f\u0015\u0205\t\u0015\u0004\u0015"+
		"\u0207\b\u0015\u000b\u0015\f\u0015\u0208\u0001\u0016\u0001\u0016\u0005"+
		"\u0016\u020d\b\u0016\n\u0016\f\u0016\u0210\t\u0016\u0004\u0016\u0212\b"+
		"\u0016\u000b\u0016\f\u0016\u0213\u0001\u0017\u0001\u0017\u0005\u0017\u0218"+
		"\b\u0017\n\u0017\f\u0017\u021b\t\u0017\u0004\u0017\u021d\b\u0017\u000b"+
		"\u0017\f\u0017\u021e\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0003"+
		"\u0018\u0225\b\u0018\u0001\u0019\u0003\u0019\u0228\b\u0019\u0001\u0019"+
		"\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0005\u0019\u022f\b\u0019"+
		"\n\u0019\f\u0019\u0232\t\u0019\u0001\u0019\u0001\u0019\u0003\u0019\u0236"+
		"\b\u0019\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001b\u0003"+
		"\u001b\u023d\b\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0003"+
		"\u001b\u0243\b\u001b\u0001\u001b\u0003\u001b\u0246\b\u001b\u0001\u001c"+
		"\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001d\u0001\u001d"+
		"\u0005\u001d\u024f\b\u001d\n\u001d\f\u001d\u0252\t\u001d\u0004\u001d\u0254"+
		"\b\u001d\u000b\u001d\f\u001d\u0255\u0001\u001e\u0001\u001e\u0001\u001e"+
		"\u0001\u001e\u0001\u001e\u0005\u001e\u025d\b\u001e\n\u001e\f\u001e\u0260"+
		"\t\u001e\u0001\u001e\u0001\u001e\u0001\u001f\u0001\u001f\u0001\u001f\u0005"+
		"\u001f\u0267\b\u001f\n\u001f\f\u001f\u026a\t\u001f\u0001\u001f\u0001\u001f"+
		"\u0001\u001f\u0001 \u0001 \u0001 \u0005 \u0272\b \n \f \u0275\t \u0001"+
		"!\u0001!\u0001!\u0003!\u027a\b!\u0001\"\u0001\"\u0001\"\u0005\"\u027f"+
		"\b\"\n\"\f\"\u0282\t\"\u0001#\u0001#\u0003#\u0286\b#\u0001$\u0001$\u0001"+
		"$\u0001$\u0005$\u028c\b$\n$\f$\u028f\t$\u0001$\u0003$\u0292\b$\u0003$"+
		"\u0294\b$\u0001$\u0001$\u0001%\u0001%\u0003%\u029a\b%\u0001%\u0001%\u0005"+
		"%\u029e\b%\n%\f%\u02a1\t%\u0001%\u0001%\u0003%\u02a5\b%\u0001&\u0001&"+
		"\u0001&\u0001&\u0001&\u0003&\u02ac\b&\u0003&\u02ae\b&\u0001\'\u0001\'"+
		"\u0001\'\u0005\'\u02b3\b\'\n\'\f\'\u02b6\t\'\u0001(\u0001(\u0003(\u02ba"+
		"\b(\u0001(\u0001(\u0001(\u0003(\u02bf\b(\u0001(\u0003(\u02c2\b(\u0003"+
		"(\u02c4\b(\u0001(\u0001(\u0001)\u0001)\u0001)\u0001)\u0005)\u02cc\b)\n"+
		")\f)\u02cf\t)\u0001)\u0001)\u0001*\u0001*\u0001*\u0005*\u02d6\b*\n*\f"+
		"*\u02d9\t*\u0001*\u0001*\u0003*\u02dd\b*\u0001*\u0003*\u02e0\b*\u0001"+
		"+\u0001+\u0001+\u0001+\u0001,\u0001,\u0001,\u0001,\u0001,\u0001,\u0001"+
		"-\u0001-\u0001-\u0005-\u02ef\b-\n-\f-\u02f2\t-\u0001.\u0001.\u0001.\u0001"+
		".\u0001/\u0001/\u0001/\u0005/\u02fb\b/\n/\f/\u02fe\t/\u00010\u00010\u0001"+
		"0\u00010\u00010\u00010\u00010\u00030\u0307\b0\u00011\u00011\u00012\u0001"+
		"2\u00013\u00013\u00013\u00053\u0310\b3\n3\f3\u0313\t3\u00013\u00013\u0001"+
		"3\u00014\u00054\u0319\b4\n4\f4\u031c\t4\u00015\u00015\u00015\u00035\u0321"+
		"\b5\u00015\u00015\u00015\u00035\u0326\b5\u00015\u00035\u0329\b5\u0001"+
		"6\u00016\u00016\u00056\u032e\b6\n6\f6\u0331\t6\u00017\u00017\u00017\u0001"+
		"7\u00018\u00018\u00018\u00038\u033a\b8\u00019\u00019\u00019\u00019\u0005"+
		"9\u0340\b9\n9\f9\u0343\t9\u00039\u0345\b9\u00019\u00039\u0348\b9\u0001"+
		"9\u00019\u0001:\u0001:\u0001:\u0001:\u0003:\u0350\b:\u0001;\u0001;\u0001"+
		";\u0001;\u0001;\u0001;\u0003;\u0358\b;\u0003;\u035a\b;\u0001<\u0001<\u0003"+
		"<\u035e\b<\u0001=\u0001=\u0001=\u0001=\u0003=\u0364\b=\u0001>\u0001>\u0001"+
		"?\u0001?\u0001?\u0001@\u0003@\u036c\b@\u0001@\u0001@\u0001@\u0001@\u0001"+
		"A\u0001A\u0005A\u0374\bA\nA\fA\u0377\tA\u0001A\u0001A\u0001A\u0001A\u0001"+
		"A\u0001A\u0001A\u0003A\u0380\bA\u0001A\u0001A\u0001A\u0001A\u0001A\u0001"+
		"A\u0003A\u0388\bA\u0001A\u0001A\u0001A\u0001A\u0001A\u0001A\u0001A\u0001"+
		"A\u0001A\u0001A\u0001A\u0001A\u0003A\u0396\bA\u0001B\u0001B\u0001C\u0001"+
		"C\u0003C\u039c\bC\u0001C\u0001C\u0001D\u0001D\u0001D\u0005D\u03a3\bD\n"+
		"D\fD\u03a6\tD\u0001E\u0001E\u0001E\u0001F\u0001F\u0001F\u0005F\u03ae\b"+
		"F\nF\fF\u03b1\tF\u0001F\u0001F\u0001F\u0005F\u03b6\bF\nF\fF\u03b9\tF\u0001"+
		"F\u0005F\u03bc\bF\nF\fF\u03bf\tF\u0001F\u0001F\u0001F\u0005F\u03c4\bF"+
		"\nF\fF\u03c7\tF\u0001F\u0003F\u03ca\bF\u0001G\u0004G\u03cd\bG\u000bG\f"+
		"G\u03ce\u0001G\u0001G\u0004G\u03d3\bG\u000bG\fG\u03d4\u0001H\u0001H\u0001"+
		"H\u0001I\u0001I\u0001I\u0001I\u0001I\u0001I\u0001I\u0001I\u0001I\u0003"+
		"I\u03e3\bI\u0001J\u0001J\u0001K\u0001K\u0001L\u0001L\u0001L\u0001L\u0001"+
		"L\u0001L\u0001L\u0001L\u0001L\u0001L\u0001L\u0001L\u0001L\u0001L\u0001"+
		"L\u0001L\u0001L\u0001L\u0001L\u0001L\u0003L\u03fd\bL\u0001M\u0001M\u0001"+
		"M\u0001M\u0003M\u0403\bM\u0001M\u0001M\u0001N\u0001N\u0001N\u0001N\u0001"+
		"O\u0001O\u0001O\u0001O\u0001O\u0001O\u0001P\u0001P\u0001P\u0001P\u0001"+
		"P\u0001P\u0001Q\u0001Q\u0001Q\u0001Q\u0001R\u0001R\u0001R\u0001R\u0001"+
		"R\u0001R\u0001S\u0001S\u0001S\u0004S\u0424\bS\u000bS\fS\u0425\u0001S\u0003"+
		"S\u0429\bS\u0001S\u0003S\u042c\bS\u0001T\u0001T\u0001T\u0001T\u0005T\u0432"+
		"\bT\nT\fT\u0435\tT\u0001T\u0003T\u0438\bT\u0001U\u0001U\u0001U\u0001U"+
		"\u0001V\u0001V\u0001V\u0001V\u0001W\u0001W\u0003W\u0444\bW\u0001W\u0001"+
		"W\u0001X\u0001X\u0001X\u0001X\u0001Y\u0001Y\u0003Y\u044e\bY\u0001Y\u0001"+
		"Y\u0001Z\u0001Z\u0003Z\u0454\bZ\u0001Z\u0001Z\u0001[\u0001[\u0001[\u0001"+
		"[\u0001\\\u0001\\\u0001\\\u0001]\u0001]\u0001]\u0001]\u0001^\u0001^\u0001"+
		"^\u0001^\u0001^\u0001^\u0001^\u0001^\u0001_\u0001_\u0001_\u0005_\u046e"+
		"\b_\n_\f_\u0471\t_\u0001`\u0001`\u0001`\u0001a\u0001a\u0001a\u0003a\u0479"+
		"\ba\u0001a\u0001a\u0001b\u0001b\u0001b\u0005b\u0480\bb\nb\fb\u0483\tb"+
		"\u0001c\u0001c\u0001c\u0001c\u0001c\u0001c\u0003c\u048b\bc\u0001c\u0001"+
		"c\u0001c\u0001c\u0003c\u0491\bc\u0001d\u0001d\u0001d\u0001d\u0001d\u0001"+
		"d\u0003d\u0499\bd\u0001d\u0001d\u0001d\u0003d\u049e\bd\u0001e\u0001e\u0003"+
		"e\u04a2\be\u0001e\u0001e\u0003e\u04a6\be\u0001e\u0001e\u0003e\u04aa\b"+
		"e\u0003e\u04ac\be\u0001f\u0001f\u0003f\u04b0\bf\u0001g\u0001g\u0001g\u0003"+
		"g\u04b5\bg\u0001g\u0001g\u0001g\u0001g\u0001h\u0001h\u0001h\u0001h\u0001"+
		"i\u0001i\u0001i\u0005i\u04c2\bi\ni\fi\u04c5\ti\u0001j\u0001j\u0001j\u0003"+
		"j\u04ca\bj\u0001j\u0001j\u0001k\u0001k\u0001k\u0001k\u0001k\u0001k\u0001"+
		"k\u0001k\u0001k\u0001k\u0001k\u0001k\u0001k\u0001k\u0001k\u0001k\u0001"+
		"k\u0003k\u04df\bk\u0001k\u0001k\u0001k\u0001k\u0003k\u04e5\bk\u0001k\u0001"+
		"k\u0003k\u04e9\bk\u0001k\u0001k\u0001k\u0003k\u04ee\bk\u0001k\u0001k\u0001"+
		"k\u0001k\u0001k\u0001k\u0001k\u0001k\u0001k\u0001k\u0001k\u0001k\u0001"+
		"k\u0005k\u04fd\bk\nk\fk\u0500\tk\u0001k\u0001k\u0001k\u0001k\u0001k\u0001"+
		"k\u0003k\u0508\bk\u0001k\u0001k\u0001k\u0001k\u0001k\u0001k\u0001k\u0001"+
		"k\u0001k\u0001k\u0001k\u0001k\u0001k\u0001k\u0003k\u0518\bk\u0001k\u0001"+
		"k\u0001k\u0001k\u0001k\u0001k\u0001k\u0001k\u0001k\u0001k\u0001k\u0001"+
		"k\u0001k\u0001k\u0001k\u0001k\u0001k\u0001k\u0001k\u0001k\u0001k\u0001"+
		"k\u0001k\u0001k\u0001k\u0001k\u0001k\u0001k\u0001k\u0001k\u0001k\u0001"+
		"k\u0001k\u0001k\u0001k\u0001k\u0001k\u0001k\u0001k\u0001k\u0001k\u0001"+
		"k\u0001k\u0003k\u0545\bk\u0001k\u0001k\u0001k\u0001k\u0003k\u054b\bk\u0001"+
		"k\u0001k\u0001k\u0003k\u0550\bk\u0001k\u0001k\u0001k\u0001k\u0001k\u0001"+
		"k\u0001k\u0003k\u0559\bk\u0005k\u055b\bk\nk\fk\u055e\tk\u0001l\u0001l"+
		"\u0001l\u0001l\u0001l\u0001m\u0001m\u0001m\u0001m\u0001n\u0001n\u0001"+
		"n\u0003n\u056c\bn\u0001n\u0001n\u0001n\u0001n\u0001n\u0005n\u0573\bn\n"+
		"n\fn\u0576\tn\u0001n\u0001n\u0001n\u0001n\u0003n\u057c\bn\u0001n\u0003"+
		"n\u057f\bn\u0001o\u0001o\u0003o\u0583\bo\u0001p\u0001p\u0001p\u0001p\u0003"+
		"p\u0589\bp\u0001p\u0001p\u0001p\u0005p\u058e\bp\np\fp\u0591\tp\u0001p"+
		"\u0001p\u0001p\u0001p\u0005p\u0597\bp\np\fp\u059a\tp\u0003p\u059c\bp\u0001"+
		"q\u0001q\u0001q\u0001q\u0001q\u0001q\u0001q\u0001q\u0001q\u0001q\u0001"+
		"q\u0005q\u05a9\bq\nq\fq\u05ac\tq\u0003q\u05ae\bq\u0001q\u0001q\u0001q"+
		"\u0005q\u05b3\bq\nq\fq\u05b6\tq\u0001r\u0001r\u0001r\u0003r\u05bb\br\u0001"+
		"r\u0001r\u0001r\u0003r\u05c0\br\u0001s\u0003s\u05c3\bs\u0001s\u0001s\u0001"+
		"s\u0001s\u0001s\u0001s\u0003s\u05cb\bs\u0001t\u0001t\u0003t\u05cf\bt\u0001"+
		"t\u0001t\u0001t\u0003t\u05d4\bt\u0005t\u05d6\bt\nt\ft\u05d9\tt\u0001t"+
		"\u0003t\u05dc\bt\u0001u\u0001u\u0001u\u0001u\u0003u\u05e2\bu\u0001u\u0001"+
		"u\u0001v\u0001v\u0004v\u05e8\bv\u000bv\fv\u05e9\u0001v\u0001v\u0001v\u0001"+
		"v\u0001v\u0004v\u05f1\bv\u000bv\fv\u05f2\u0001v\u0001v\u0005v\u05f7\b"+
		"v\nv\fv\u05fa\tv\u0003v\u05fc\bv\u0001w\u0001w\u0003w\u0600\bw\u0001x"+
		"\u0001x\u0001x\u0001y\u0001y\u0001y\u0003y\u0608\by\u0001z\u0001z\u0001"+
		"z\u0001z\u0001{\u0001{\u0001{\u0005{\u0611\b{\n{\f{\u0614\t{\u0001|\u0001"+
		"|\u0001|\u0003|\u0619\b|\u0001|\u0001|\u0001|\u0001|\u0005|\u061f\b|\n"+
		"|\f|\u0622\t|\u0001}\u0001}\u0001~\u0001~\u0001~\u0001~\u0005~\u062a\b"+
		"~\n~\f~\u062d\t~\u0001~\u0001~\u0001\u007f\u0001\u007f\u0001\u007f\u0003"+
		"\u007f\u0634\b\u007f\u0001\u007f\u0001\u007f\u0003\u007f\u0638\b\u007f"+
		"\u0003\u007f\u063a\b\u007f\u0001\u0080\u0001\u0080\u0001\u0080\u0001\u0080"+
		"\u0001\u0080\u0003\u0080\u0641\b\u0080\u0001\u0081\u0001\u0081\u0003\u0081"+
		"\u0645\b\u0081\u0001\u0081\u0001\u0081\u0001\u0081\u0000\u0002\u00d6\u00e2"+
		"\u0082\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018"+
		"\u001a\u001c\u001e \"$&(*,.02468:<>@BDFHJLNPRTVXZ\\^`bdfhjlnprtvxz|~\u0080"+
		"\u0082\u0084\u0086\u0088\u008a\u008c\u008e\u0090\u0092\u0094\u0096\u0098"+
		"\u009a\u009c\u009e\u00a0\u00a2\u00a4\u00a6\u00a8\u00aa\u00ac\u00ae\u00b0"+
		"\u00b2\u00b4\u00b6\u00b8\u00ba\u00bc\u00be\u00c0\u00c2\u00c4\u00c6\u00c8"+
		"\u00ca\u00cc\u00ce\u00d0\u00d2\u00d4\u00d6\u00d8\u00da\u00dc\u00de\u00e0"+
		"\u00e2\u00e4\u00e6\u00e8\u00ea\u00ec\u00ee\u00f0\u00f2\u00f4\u00f6\u00f8"+
		"\u00fa\u00fc\u00fe\u0100\u0102\u0000\u000f\u0002\u0000\u001e\u001e,,\u0001"+
		"\u0000CF\u0001\u0000GH\u0002\u0000**<<\u0002\u00003A}}\u0003\u00003<?"+
		"A}}\u0002\u0000XYlo\u0001\u0000Z\\\u0001\u0000XY\u0002\u0000PQST\u0002"+
		"\u0000RRUU\u0001\u0000`k\u0001\u0000no\u0002\u0000OO~~\u0001\u0000\u0001"+
		"\t\u06e2\u0000\u0120\u0001\u0000\u0000\u0000\u0002\u0123\u0001\u0000\u0000"+
		"\u0000\u0004\u012e\u0001\u0000\u0000\u0000\u0006\u0132\u0001\u0000\u0000"+
		"\u0000\b\u0137\u0001\u0000\u0000\u0000\n\u0154\u0001\u0000\u0000\u0000"+
		"\f\u0157\u0001\u0000\u0000\u0000\u000e\u0161\u0001\u0000\u0000\u0000\u0010"+
		"\u0172\u0001\u0000\u0000\u0000\u0012\u017f\u0001\u0000\u0000\u0000\u0014"+
		"\u0189\u0001\u0000\u0000\u0000\u0016\u018f\u0001\u0000\u0000\u0000\u0018"+
		"\u01bc\u0001\u0000\u0000\u0000\u001a\u01be\u0001\u0000\u0000\u0000\u001c"+
		"\u01c9\u0001\u0000\u0000\u0000\u001e\u01d1\u0001\u0000\u0000\u0000 \u01d9"+
		"\u0001\u0000\u0000\u0000\"\u01e1\u0001\u0000\u0000\u0000$\u01ef\u0001"+
		"\u0000\u0000\u0000&\u01f1\u0001\u0000\u0000\u0000(\u01fb\u0001\u0000\u0000"+
		"\u0000*\u0206\u0001\u0000\u0000\u0000,\u0211\u0001\u0000\u0000\u0000."+
		"\u021c\u0001\u0000\u0000\u00000\u0220\u0001\u0000\u0000\u00002\u0227\u0001"+
		"\u0000\u0000\u00004\u0237\u0001\u0000\u0000\u00006\u0245\u0001\u0000\u0000"+
		"\u00008\u0247\u0001\u0000\u0000\u0000:\u0253\u0001\u0000\u0000\u0000<"+
		"\u0257\u0001\u0000\u0000\u0000>\u0263\u0001\u0000\u0000\u0000@\u026e\u0001"+
		"\u0000\u0000\u0000B\u0276\u0001\u0000\u0000\u0000D\u027b\u0001\u0000\u0000"+
		"\u0000F\u0285\u0001\u0000\u0000\u0000H\u0287\u0001\u0000\u0000\u0000J"+
		"\u029f\u0001\u0000\u0000\u0000L\u02ad\u0001\u0000\u0000\u0000N\u02af\u0001"+
		"\u0000\u0000\u0000P\u02b7\u0001\u0000\u0000\u0000R\u02c7\u0001\u0000\u0000"+
		"\u0000T\u02df\u0001\u0000\u0000\u0000V\u02e1\u0001\u0000\u0000\u0000X"+
		"\u02e5\u0001\u0000\u0000\u0000Z\u02eb\u0001\u0000\u0000\u0000\\\u02f3"+
		"\u0001\u0000\u0000\u0000^\u02f7\u0001\u0000\u0000\u0000`\u0306\u0001\u0000"+
		"\u0000\u0000b\u0308\u0001\u0000\u0000\u0000d\u030a\u0001\u0000\u0000\u0000"+
		"f\u0311\u0001\u0000\u0000\u0000h\u031a\u0001\u0000\u0000\u0000j\u0320"+
		"\u0001\u0000\u0000\u0000l\u032a\u0001\u0000\u0000\u0000n\u0332\u0001\u0000"+
		"\u0000\u0000p\u0339\u0001\u0000\u0000\u0000r\u033b\u0001\u0000\u0000\u0000"+
		"t\u034f\u0001\u0000\u0000\u0000v\u0359\u0001\u0000\u0000\u0000x\u035d"+
		"\u0001\u0000\u0000\u0000z\u035f\u0001\u0000\u0000\u0000|\u0365\u0001\u0000"+
		"\u0000\u0000~\u0367\u0001\u0000\u0000\u0000\u0080\u036b\u0001\u0000\u0000"+
		"\u0000\u0082\u0395\u0001\u0000\u0000\u0000\u0084\u0397\u0001\u0000\u0000"+
		"\u0000\u0086\u0399\u0001\u0000\u0000\u0000\u0088\u039f\u0001\u0000\u0000"+
		"\u0000\u008a\u03a7\u0001\u0000\u0000\u0000\u008c\u03c9\u0001\u0000\u0000"+
		"\u0000\u008e\u03cc\u0001\u0000\u0000\u0000\u0090\u03d6\u0001\u0000\u0000"+
		"\u0000\u0092\u03d9\u0001\u0000\u0000\u0000\u0094\u03e4\u0001\u0000\u0000"+
		"\u0000\u0096\u03e6\u0001\u0000\u0000\u0000\u0098\u03fc\u0001\u0000\u0000"+
		"\u0000\u009a\u03fe\u0001\u0000\u0000\u0000\u009c\u0406\u0001\u0000\u0000"+
		"\u0000\u009e\u040a\u0001\u0000\u0000\u0000\u00a0\u0410\u0001\u0000\u0000"+
		"\u0000\u00a2\u0416\u0001\u0000\u0000\u0000\u00a4\u041a\u0001\u0000\u0000"+
		"\u0000\u00a6\u0420\u0001\u0000\u0000\u0000\u00a8\u042d\u0001\u0000\u0000"+
		"\u0000\u00aa\u0439\u0001\u0000\u0000\u0000\u00ac\u043d\u0001\u0000\u0000"+
		"\u0000\u00ae\u0441\u0001\u0000\u0000\u0000\u00b0\u0447\u0001\u0000\u0000"+
		"\u0000\u00b2\u044b\u0001\u0000\u0000\u0000\u00b4\u0451\u0001\u0000\u0000"+
		"\u0000\u00b6\u0457\u0001\u0000\u0000\u0000\u00b8\u045b\u0001\u0000\u0000"+
		"\u0000\u00ba\u045e\u0001\u0000\u0000\u0000\u00bc\u0462\u0001\u0000\u0000"+
		"\u0000\u00be\u046a\u0001\u0000\u0000\u0000\u00c0\u0472\u0001\u0000\u0000"+
		"\u0000\u00c2\u0475\u0001\u0000\u0000\u0000\u00c4\u047c\u0001\u0000\u0000"+
		"\u0000\u00c6\u0490\u0001\u0000\u0000\u0000\u00c8\u049d\u0001\u0000\u0000"+
		"\u0000\u00ca\u04ab\u0001\u0000\u0000\u0000\u00cc\u04af\u0001\u0000\u0000"+
		"\u0000\u00ce\u04b1\u0001\u0000\u0000\u0000\u00d0\u04ba\u0001\u0000\u0000"+
		"\u0000\u00d2\u04be\u0001\u0000\u0000\u0000\u00d4\u04c9\u0001\u0000\u0000"+
		"\u0000\u00d6\u0507\u0001\u0000\u0000\u0000\u00d8\u055f\u0001\u0000\u0000"+
		"\u0000\u00da\u0564\u0001\u0000\u0000\u0000\u00dc\u057e\u0001\u0000\u0000"+
		"\u0000\u00de\u0582\u0001\u0000\u0000\u0000\u00e0\u059b\u0001\u0000\u0000"+
		"\u0000\u00e2\u05ad\u0001\u0000\u0000\u0000\u00e4\u05ba\u0001\u0000\u0000"+
		"\u0000\u00e6\u05ca\u0001\u0000\u0000\u0000\u00e8\u05db\u0001\u0000\u0000"+
		"\u0000\u00ea\u05dd\u0001\u0000\u0000\u0000\u00ec\u05fb\u0001\u0000\u0000"+
		"\u0000\u00ee\u05fd\u0001\u0000\u0000\u0000\u00f0\u0601\u0001\u0000\u0000"+
		"\u0000\u00f2\u0607\u0001\u0000\u0000\u0000\u00f4\u0609\u0001\u0000\u0000"+
		"\u0000\u00f6\u060d\u0001\u0000\u0000\u0000\u00f8\u0615\u0001\u0000\u0000"+
		"\u0000\u00fa\u0623\u0001\u0000\u0000\u0000\u00fc\u0625\u0001\u0000\u0000"+
		"\u0000\u00fe\u0639\u0001\u0000\u0000\u0000\u0100\u0640\u0001\u0000\u0000"+
		"\u0000\u0102\u0642\u0001\u0000\u0000\u0000\u0104\u0106\u0003\u0006\u0003"+
		"\u0000\u0105\u0104\u0001\u0000\u0000\u0000\u0105\u0106\u0001\u0000\u0000"+
		"\u0000\u0106\u0110\u0001\u0000\u0000\u0000\u0107\u0109\u0003\u0002\u0001"+
		"\u0000\u0108\u0107\u0001\u0000\u0000\u0000\u0108\u0109\u0001\u0000\u0000"+
		"\u0000\u0109\u0111\u0001\u0000\u0000\u0000\u010a\u010c\u0005v\u0000\u0000"+
		"\u010b\u010a\u0001\u0000\u0000\u0000\u010c\u010f\u0001\u0000\u0000\u0000"+
		"\u010d\u010b\u0001\u0000\u0000\u0000\u010d\u010e\u0001\u0000\u0000\u0000"+
		"\u010e\u0111\u0001\u0000\u0000\u0000\u010f\u010d\u0001\u0000\u0000\u0000"+
		"\u0110\u0108\u0001\u0000\u0000\u0000\u0110\u010d\u0001\u0000\u0000\u0000"+
		"\u0111\u011b\u0001\u0000\u0000\u0000\u0112\u0114\u0003\u0004\u0002\u0000"+
		"\u0113\u0112\u0001\u0000\u0000\u0000\u0113\u0114\u0001\u0000\u0000\u0000"+
		"\u0114\u011c\u0001\u0000\u0000\u0000\u0115\u0117\u0005v\u0000\u0000\u0116"+
		"\u0115\u0001\u0000\u0000\u0000\u0117\u011a\u0001\u0000\u0000\u0000\u0118"+
		"\u0116\u0001\u0000\u0000\u0000\u0118\u0119\u0001\u0000\u0000\u0000\u0119"+
		"\u011c\u0001\u0000\u0000\u0000\u011a\u0118\u0001\u0000\u0000\u0000\u011b"+
		"\u0113\u0001\u0000\u0000\u0000\u011b\u0118\u0001\u0000\u0000\u0000\u011c"+
		"\u0121\u0001\u0000\u0000\u0000\u011d\u011e\u0003\u0080@\u0000\u011e\u011f"+
		"\u0005\u0000\u0000\u0001\u011f\u0121\u0001\u0000\u0000\u0000\u0120\u0105"+
		"\u0001\u0000\u0000\u0000\u0120\u011d\u0001\u0000\u0000\u0000\u0121\u0001"+
		"\u0001\u0000\u0000\u0000\u0122\u0124\u0003\b\u0004\u0000\u0123\u0122\u0001"+
		"\u0000\u0000\u0000\u0124\u0125\u0001\u0000\u0000\u0000\u0125\u0123\u0001"+
		"\u0000\u0000\u0000\u0125\u0126\u0001\u0000\u0000\u0000\u0126\u0003\u0001"+
		"\u0000\u0000\u0000\u0127\u012b\u0003\f\u0006\u0000\u0128\u012a\u0005v"+
		"\u0000\u0000\u0129\u0128\u0001\u0000\u0000\u0000\u012a\u012d\u0001\u0000"+
		"\u0000\u0000\u012b\u0129\u0001\u0000\u0000\u0000\u012b\u012c\u0001\u0000"+
		"\u0000\u0000\u012c\u012f\u0001\u0000\u0000\u0000\u012d\u012b\u0001\u0000"+
		"\u0000\u0000\u012e\u0127\u0001\u0000\u0000\u0000\u012f\u0130\u0001\u0000"+
		"\u0000\u0000\u0130\u012e\u0001\u0000\u0000\u0000\u0130\u0131\u0001\u0000"+
		"\u0000\u0000\u0131\u0005\u0001\u0000\u0000\u0000\u0132\u0133\u0003h4\u0000"+
		"\u0133\u0134\u0005&\u0000\u0000\u0134\u0135\u0003^/\u0000\u0135\u0136"+
		"\u0005v\u0000\u0000\u0136\u0007\u0001\u0000\u0000\u0000\u0137\u0139\u0005"+
		"!\u0000\u0000\u0138\u013a\u0005*\u0000\u0000\u0139\u0138\u0001\u0000\u0000"+
		"\u0000\u0139\u013a\u0001\u0000\u0000\u0000\u013a\u013b\u0001\u0000\u0000"+
		"\u0000\u013b\u013e\u0003^/\u0000\u013c\u013d\u0005x\u0000\u0000\u013d"+
		"\u013f\u0005Z\u0000\u0000\u013e\u013c\u0001\u0000\u0000\u0000\u013e\u013f"+
		"\u0001\u0000\u0000\u0000\u013f\u0140\u0001\u0000\u0000\u0000\u0140\u0141"+
		"\u0005v\u0000\u0000\u0141\t\u0001\u0000\u0000\u0000\u0142\u0153\u0003"+
		"j5\u0000\u0143\u0153\u0005)\u0000\u0000\u0144\u0153\u0005(\u0000\u0000"+
		"\u0145\u0153\u0005\'\u0000\u0000\u0146\u0153\u0005*\u0000\u0000\u0147"+
		"\u0153\u0005\u0018\u0000\u0000\u0148\u0153\u0005\u001f\u0000\u0000\u0149"+
		"\u0153\u0005+\u0000\u0000\u014a\u0153\u0005@\u0000\u0000\u014b\u0153\u0005"+
		"B\u0000\u0000\u014c\u0153\u0005$\u0000\u0000\u014d\u0153\u0005-\u0000"+
		"\u0000\u014e\u0153\u00051\u0000\u0000\u014f\u0153\u00052\u0000\u0000\u0150"+
		"\u0153\u0005+\u0000\u0000\u0151\u0153\u0005\u001c\u0000\u0000\u0152\u0142"+
		"\u0001\u0000\u0000\u0000\u0152\u0143\u0001\u0000\u0000\u0000\u0152\u0144"+
		"\u0001\u0000\u0000\u0000\u0152\u0145\u0001\u0000\u0000\u0000\u0152\u0146"+
		"\u0001\u0000\u0000\u0000\u0152\u0147\u0001\u0000\u0000\u0000\u0152\u0148"+
		"\u0001\u0000\u0000\u0000\u0152\u0149\u0001\u0000\u0000\u0000\u0152\u014a"+
		"\u0001\u0000\u0000\u0000\u0152\u014b\u0001\u0000\u0000\u0000\u0152\u014c"+
		"\u0001\u0000\u0000\u0000\u0152\u014d\u0001\u0000\u0000\u0000\u0152\u014e"+
		"\u0001\u0000\u0000\u0000\u0152\u014f\u0001\u0000\u0000\u0000\u0152\u0150"+
		"\u0001\u0000\u0000\u0000\u0152\u0151\u0001\u0000\u0000\u0000\u0153\u0156"+
		"\u0001\u0000\u0000\u0000\u0154\u0152\u0001\u0000\u0000\u0000\u0154\u0155"+
		"\u0001\u0000\u0000\u0000\u0155\u000b\u0001\u0000\u0000\u0000\u0156\u0154"+
		"\u0001\u0000\u0000\u0000\u0157\u015d\u0003\n\u0005\u0000\u0158\u015e\u0003"+
		"\u000e\u0007\u0000\u0159\u015e\u0003\u0010\b\u0000\u015a\u015e\u0003\u0012"+
		"\t\u0000\u015b\u015e\u0003\u0014\n\u0000\u015c\u015e\u0003\u0016\u000b"+
		"\u0000\u015d\u0158\u0001\u0000\u0000\u0000\u015d\u0159\u0001\u0000\u0000"+
		"\u0000\u015d\u015a\u0001\u0000\u0000\u0000\u015d\u015b\u0001\u0000\u0000"+
		"\u0000\u015d\u015c\u0001\u0000\u0000\u0000\u015e\u015f\u0001\u0000\u0000"+
		"\u0000\u015f\u0160\u0003\u0018\f\u0000\u0160\r\u0001\u0000\u0000\u0000"+
		"\u0161\u0162\u0005\u001a\u0000\u0000\u0162\u0164\u0003\u0094J\u0000\u0163"+
		"\u0165\u0003\u001a\r\u0000\u0164\u0163\u0001\u0000\u0000\u0000\u0164\u0165"+
		"\u0001\u0000\u0000\u0000\u0165\u0168\u0001\u0000\u0000\u0000\u0166\u0167"+
		"\u0005\u001e\u0000\u0000\u0167\u0169\u0003\u00f8|\u0000\u0168\u0166\u0001"+
		"\u0000\u0000\u0000\u0168\u0169\u0001\u0000\u0000\u0000\u0169\u016c\u0001"+
		"\u0000\u0000\u0000\u016a\u016b\u0005 \u0000\u0000\u016b\u016d\u0003\u00f6"+
		"{\u0000\u016c\u016a\u0001\u0000\u0000\u0000\u016c\u016d\u0001\u0000\u0000"+
		"\u0000\u016d\u0170\u0001\u0000\u0000\u0000\u016e\u016f\u0005A\u0000\u0000"+
		"\u016f\u0171\u0003\u00f6{\u0000\u0170\u016e\u0001\u0000\u0000\u0000\u0170"+
		"\u0171\u0001\u0000\u0000\u0000\u0171\u000f\u0001\u0000\u0000\u0000\u0172"+
		"\u0173\u0005#\u0000\u0000\u0173\u0175\u0003\u0094J\u0000\u0174\u0176\u0003"+
		"\u001a\r\u0000\u0175\u0174\u0001\u0000\u0000\u0000\u0175\u0176\u0001\u0000"+
		"\u0000\u0000\u0176\u0179\u0001\u0000\u0000\u0000\u0177\u0178\u0005\u001e"+
		"\u0000\u0000\u0178\u017a\u0003\u00f6{\u0000\u0179\u0177\u0001\u0000\u0000"+
		"\u0000\u0179\u017a\u0001\u0000\u0000\u0000\u017a\u017d\u0001\u0000\u0000"+
		"\u0000\u017b\u017c\u0005A\u0000\u0000\u017c\u017e\u0003\u00f6{\u0000\u017d"+
		"\u017b\u0001\u0000\u0000\u0000\u017d\u017e\u0001\u0000\u0000\u0000\u017e"+
		"\u0011\u0001\u0000\u0000\u0000\u017f\u0180\u0005?\u0000\u0000\u0180\u0182"+
		"\u0003\u0094J\u0000\u0181\u0183\u0003\u001a\r\u0000\u0182\u0181\u0001"+
		"\u0000\u0000\u0000\u0182\u0183\u0001\u0000\u0000\u0000\u0183\u0184\u0001"+
		"\u0000\u0000\u0000\u0184\u0187\u0003\u0086C\u0000\u0185\u0186\u0005 \u0000"+
		"\u0000\u0186\u0188\u0003\u00f6{\u0000\u0187\u0185\u0001\u0000\u0000\u0000"+
		"\u0187\u0188\u0001\u0000\u0000\u0000\u0188\u0013\u0001\u0000\u0000\u0000"+
		"\u0189\u018a\u0005\u001d\u0000\u0000\u018a\u018d\u0003\u0094J\u0000\u018b"+
		"\u018c\u0005 \u0000\u0000\u018c\u018e\u0003\u00f6{\u0000\u018d\u018b\u0001"+
		"\u0000\u0000\u0000\u018d\u018e\u0001\u0000\u0000\u0000\u018e\u0015\u0001"+
		"\u0000\u0000\u0000\u018f\u0190\u0005\u0080\u0000\u0000\u0190\u0191\u0005"+
		"#\u0000\u0000\u0191\u0192\u0003\u0094J\u0000\u0192\u0017\u0001\u0000\u0000"+
		"\u0000\u0193\u0197\u0005r\u0000\u0000\u0194\u0196\u0003$\u0012\u0000\u0195"+
		"\u0194\u0001\u0000\u0000\u0000\u0196\u0199\u0001\u0000\u0000\u0000\u0197"+
		"\u0195\u0001\u0000\u0000\u0000\u0197\u0198\u0001\u0000\u0000\u0000\u0198"+
		"\u019a\u0001\u0000\u0000\u0000\u0199\u0197\u0001\u0000\u0000\u0000\u019a"+
		"\u01bd\u0005s\u0000\u0000\u019b\u019d\u0005r\u0000\u0000\u019c\u019e\u0003"+
		" \u0010\u0000\u019d\u019c\u0001\u0000\u0000\u0000\u019d\u019e\u0001\u0000"+
		"\u0000\u0000\u019e\u01a0\u0001\u0000\u0000\u0000\u019f\u01a1\u0005w\u0000"+
		"\u0000\u01a0\u019f\u0001\u0000\u0000\u0000\u01a0\u01a1\u0001\u0000\u0000"+
		"\u0000\u01a1\u01a9\u0001\u0000\u0000\u0000\u01a2\u01a6\u0005v\u0000\u0000"+
		"\u01a3\u01a5\u0003$\u0012\u0000\u01a4\u01a3\u0001\u0000\u0000\u0000\u01a5"+
		"\u01a8\u0001\u0000\u0000\u0000\u01a6\u01a4\u0001\u0000\u0000\u0000\u01a6"+
		"\u01a7\u0001\u0000\u0000\u0000\u01a7\u01aa\u0001\u0000\u0000\u0000\u01a8"+
		"\u01a6\u0001\u0000\u0000\u0000\u01a9\u01a2\u0001\u0000\u0000\u0000\u01a9"+
		"\u01aa\u0001\u0000\u0000\u0000\u01aa\u01ab\u0001\u0000\u0000\u0000\u01ab"+
		"\u01bd\u0005s\u0000\u0000\u01ac\u01b0\u0005r\u0000\u0000\u01ad\u01af\u0003"+
		"t:\u0000\u01ae\u01ad\u0001\u0000\u0000\u0000\u01af\u01b2\u0001\u0000\u0000"+
		"\u0000\u01b0\u01ae\u0001\u0000\u0000\u0000\u01b0\u01b1\u0001\u0000\u0000"+
		"\u0000\u01b1\u01b3\u0001\u0000\u0000\u0000\u01b2\u01b0\u0001\u0000\u0000"+
		"\u0000\u01b3\u01bd\u0005s\u0000\u0000\u01b4\u01b8\u0005r\u0000\u0000\u01b5"+
		"\u01b7\u0003\u0082A\u0000\u01b6\u01b5\u0001\u0000\u0000\u0000\u01b7\u01ba"+
		"\u0001\u0000\u0000\u0000\u01b8\u01b6\u0001\u0000\u0000\u0000\u01b8\u01b9"+
		"\u0001\u0000\u0000\u0000\u01b9\u01bb\u0001\u0000\u0000\u0000\u01ba\u01b8"+
		"\u0001\u0000\u0000\u0000\u01bb\u01bd\u0005s\u0000\u0000\u01bc\u0193\u0001"+
		"\u0000\u0000\u0000\u01bc\u019b\u0001\u0000\u0000\u0000\u01bc\u01ac\u0001"+
		"\u0000\u0000\u0000\u01bc\u01b4\u0001\u0000\u0000\u0000\u01bd\u0019\u0001"+
		"\u0000\u0000\u0000\u01be\u01bf\u0005Q\u0000\u0000\u01bf\u01c4\u0003\u001c"+
		"\u000e\u0000\u01c0\u01c1\u0005w\u0000\u0000\u01c1\u01c3\u0003\u001c\u000e"+
		"\u0000\u01c2\u01c0\u0001\u0000\u0000\u0000\u01c3\u01c6\u0001\u0000\u0000"+
		"\u0000\u01c4\u01c2\u0001\u0000\u0000\u0000\u01c4\u01c5\u0001\u0000\u0000"+
		"\u0000\u01c5\u01c7\u0001\u0000\u0000\u0000\u01c6\u01c4\u0001\u0000\u0000"+
		"\u0000\u01c7\u01c8\u0005P\u0000\u0000\u01c8\u001b\u0001\u0000\u0000\u0000"+
		"\u01c9\u01ca\u0003h4\u0000\u01ca\u01cf\u0003\u0094J\u0000\u01cb\u01cc"+
		"\u0005\u001e\u0000\u0000\u01cc\u01cd\u0003h4\u0000\u01cd\u01ce\u0003\u001e"+
		"\u000f\u0000\u01ce\u01d0\u0001\u0000\u0000\u0000\u01cf\u01cb\u0001\u0000"+
		"\u0000\u0000\u01cf\u01d0\u0001\u0000\u0000\u0000\u01d0\u001d\u0001\u0000"+
		"\u0000\u0000\u01d1\u01d6\u0003\u00f8|\u0000\u01d2\u01d3\u0005]\u0000\u0000"+
		"\u01d3\u01d5\u0003\u00f8|\u0000\u01d4\u01d2\u0001\u0000\u0000\u0000\u01d5"+
		"\u01d8\u0001\u0000\u0000\u0000\u01d6\u01d4\u0001\u0000\u0000\u0000\u01d6"+
		"\u01d7\u0001\u0000\u0000\u0000\u01d7\u001f\u0001\u0000\u0000\u0000\u01d8"+
		"\u01d6\u0001\u0000\u0000\u0000\u01d9\u01de\u0003\"\u0011\u0000\u01da\u01db"+
		"\u0005w\u0000\u0000\u01db\u01dd\u0003\"\u0011\u0000\u01dc\u01da\u0001"+
		"\u0000\u0000\u0000\u01dd\u01e0\u0001\u0000\u0000\u0000\u01de\u01dc\u0001"+
		"\u0000\u0000\u0000\u01de\u01df\u0001\u0000\u0000\u0000\u01df!\u0001\u0000"+
		"\u0000\u0000\u01e0\u01de\u0001\u0000\u0000\u0000\u01e1\u01e2\u0003h4\u0000"+
		"\u01e2\u01e4\u0003\u0094J\u0000\u01e3\u01e5\u0003\u0102\u0081\u0000\u01e4"+
		"\u01e3\u0001\u0000\u0000\u0000\u01e4\u01e5\u0001\u0000\u0000\u0000\u01e5"+
		"\u01e7\u0001\u0000\u0000\u0000\u01e6\u01e8\u0003\u0018\f\u0000\u01e7\u01e6"+
		"\u0001\u0000\u0000\u0000\u01e7\u01e8\u0001\u0000\u0000\u0000\u01e8#\u0001"+
		"\u0000\u0000\u0000\u01e9\u01f0\u0005v\u0000\u0000\u01ea\u01f0\u0003(\u0014"+
		"\u0000\u01eb\u01f0\u0003*\u0015\u0000\u01ec\u01f0\u0003,\u0016\u0000\u01ed"+
		"\u01f0\u0003.\u0017\u0000\u01ee\u01f0\u0003\u0004\u0002\u0000\u01ef\u01e9"+
		"\u0001\u0000\u0000\u0000\u01ef\u01ea\u0001\u0000\u0000\u0000\u01ef\u01eb"+
		"\u0001\u0000\u0000\u0000\u01ef\u01ec\u0001\u0000\u0000\u0000\u01ef\u01ed"+
		"\u0001\u0000\u0000\u0000\u01ef\u01ee\u0001\u0000\u0000\u0000\u01f0%\u0001"+
		"\u0000\u0000\u0000\u01f1\u01f2\u0003\n\u0005\u0000\u01f2\u01f3\u0003\u008c"+
		"F\u0000\u01f3\'\u0001\u0000\u0000\u0000\u01f4\u01f8\u0003&\u0013\u0000"+
		"\u01f5\u01f7\u0005v\u0000\u0000\u01f6\u01f5\u0001\u0000\u0000\u0000\u01f7"+
		"\u01fa\u0001\u0000\u0000\u0000\u01f8\u01f6\u0001\u0000\u0000\u0000\u01f8"+
		"\u01f9\u0001\u0000\u0000\u0000\u01f9\u01fc\u0001\u0000\u0000\u0000\u01fa"+
		"\u01f8\u0001\u0000\u0000\u0000\u01fb\u01f4\u0001\u0000\u0000\u0000\u01fc"+
		"\u01fd\u0001\u0000\u0000\u0000\u01fd\u01fb\u0001\u0000\u0000\u0000\u01fd"+
		"\u01fe\u0001\u0000\u0000\u0000\u01fe)\u0001\u0000\u0000\u0000\u01ff\u0203"+
		"\u00038\u001c\u0000\u0200\u0202\u0005v\u0000\u0000\u0201\u0200\u0001\u0000"+
		"\u0000\u0000\u0202\u0205\u0001\u0000\u0000\u0000\u0203\u0201\u0001\u0000"+
		"\u0000\u0000\u0203\u0204\u0001\u0000\u0000\u0000\u0204\u0207\u0001\u0000"+
		"\u0000\u0000\u0205\u0203\u0001\u0000\u0000\u0000\u0206\u01ff\u0001\u0000"+
		"\u0000\u0000\u0207\u0208\u0001\u0000\u0000\u0000\u0208\u0206\u0001\u0000"+
		"\u0000\u0000\u0208\u0209\u0001\u0000\u0000\u0000\u0209+\u0001\u0000\u0000"+
		"\u0000\u020a\u020e\u00034\u001a\u0000\u020b\u020d\u0005v\u0000\u0000\u020c"+
		"\u020b\u0001\u0000\u0000\u0000\u020d\u0210\u0001\u0000\u0000\u0000\u020e"+
		"\u020c\u0001\u0000\u0000\u0000\u020e\u020f\u0001\u0000\u0000\u0000\u020f"+
		"\u0212\u0001\u0000\u0000\u0000\u0210\u020e\u0001\u0000\u0000\u0000\u0211"+
		"\u020a\u0001\u0000\u0000\u0000\u0212\u0213\u0001\u0000\u0000\u0000\u0213"+
		"\u0211\u0001\u0000\u0000\u0000\u0213\u0214\u0001\u0000\u0000\u0000\u0214"+
		"-\u0001\u0000\u0000\u0000\u0215\u0219\u00030\u0018\u0000\u0216\u0218\u0005"+
		"v\u0000\u0000\u0217\u0216\u0001\u0000\u0000\u0000\u0218\u021b\u0001\u0000"+
		"\u0000\u0000\u0219\u0217\u0001\u0000\u0000\u0000\u0219\u021a\u0001\u0000"+
		"\u0000\u0000\u021a\u021d\u0001\u0000\u0000\u0000\u021b\u0219\u0001\u0000"+
		"\u0000\u0000\u021c\u0215\u0001\u0000\u0000\u0000\u021d\u021e\u0001\u0000"+
		"\u0000\u0000\u021e\u021c\u0001\u0000\u0000\u0000\u021e\u021f\u0001\u0000"+
		"\u0000\u0000\u021f/\u0001\u0000\u0000\u0000\u0220\u0221\u0003\n\u0005"+
		"\u0000\u0221\u0224\u00032\u0019\u0000\u0222\u0225\u0005v\u0000\u0000\u0223"+
		"\u0225\u0003\u008cF\u0000\u0224\u0222\u0001\u0000\u0000\u0000\u0224\u0223"+
		"\u0001\u0000\u0000\u0000\u02251\u0001\u0000\u0000\u0000\u0226\u0228\u0003"+
		"\u001a\r\u0000\u0227\u0226\u0001\u0000\u0000\u0000\u0227\u0228\u0001\u0000"+
		"\u0000\u0000\u0228\u0229\u0001\u0000\u0000\u0000\u0229\u022a\u0003\u00f8"+
		"|\u0000\u022a\u022b\u0003\u0094J\u0000\u022b\u0230\u0003P(\u0000\u022c"+
		"\u022d\u0005t\u0000\u0000\u022d\u022f\u0005u\u0000\u0000\u022e\u022c\u0001"+
		"\u0000\u0000\u0000\u022f\u0232\u0001\u0000\u0000\u0000\u0230\u022e\u0001"+
		"\u0000\u0000\u0000\u0230\u0231\u0001\u0000\u0000\u0000\u0231\u0235\u0001"+
		"\u0000\u0000\u0000\u0232\u0230\u0001\u0000\u0000\u0000\u0233\u0234\u0005"+
		"0\u0000\u0000\u0234\u0236\u0003N\'\u0000\u0235\u0233\u0001\u0000\u0000"+
		"\u0000\u0235\u0236\u0001\u0000\u0000\u0000\u02363\u0001\u0000\u0000\u0000"+
		"\u0237\u0238\u0003\n\u0005\u0000\u0238\u0239\u00036\u001b\u0000\u0239"+
		"\u023a\u0003\u008cF\u0000\u023a5\u0001\u0000\u0000\u0000\u023b\u023d\u0003"+
		"\u001a\r\u0000\u023c\u023b\u0001\u0000\u0000\u0000\u023c\u023d\u0001\u0000"+
		"\u0000\u0000\u023d\u023e\u0001\u0000\u0000\u0000\u023e\u023f\u0003\u0094"+
		"J\u0000\u023f\u0242\u0003P(\u0000\u0240\u0241\u00050\u0000\u0000\u0241"+
		"\u0243\u0003N\'\u0000\u0242\u0240\u0001\u0000\u0000\u0000\u0242\u0243"+
		"\u0001\u0000\u0000\u0000\u0243\u0246\u0001\u0000\u0000\u0000\u0244\u0246"+
		"\u0003\u0094J\u0000\u0245\u023c\u0001\u0000\u0000\u0000\u0245\u0244\u0001"+
		"\u0000\u0000\u0000\u02467\u0001\u0000\u0000\u0000\u0247\u0248\u0003\n"+
		"\u0005\u0000\u0248\u0249\u0003\u00f8|\u0000\u0249\u024a\u0003@ \u0000"+
		"\u024a\u024b\u0005v\u0000\u0000\u024b9\u0001\u0000\u0000\u0000\u024c\u0250"+
		"\u0003<\u001e\u0000\u024d\u024f\u0005v\u0000\u0000\u024e\u024d\u0001\u0000"+
		"\u0000\u0000\u024f\u0252\u0001\u0000\u0000\u0000\u0250\u024e\u0001\u0000"+
		"\u0000\u0000\u0250\u0251\u0001\u0000\u0000\u0000\u0251\u0254\u0001\u0000"+
		"\u0000\u0000\u0252\u0250\u0001\u0000\u0000\u0000\u0253\u024c\u0001\u0000"+
		"\u0000\u0000\u0254\u0255\u0001\u0000\u0000\u0000\u0255\u0253\u0001\u0000"+
		"\u0000\u0000\u0255\u0256\u0001\u0000\u0000\u0000\u0256;\u0001\u0000\u0000"+
		"\u0000\u0257\u0258\u0003\n\u0005\u0000\u0258\u0259\u0003\u00f8|\u0000"+
		"\u0259\u025e\u0003>\u001f\u0000\u025a\u025b\u0005w\u0000\u0000\u025b\u025d"+
		"\u0003>\u001f\u0000\u025c\u025a\u0001\u0000\u0000\u0000\u025d\u0260\u0001"+
		"\u0000\u0000\u0000\u025e\u025c\u0001\u0000\u0000\u0000\u025e\u025f\u0001"+
		"\u0000\u0000\u0000\u025f\u0261\u0001\u0000\u0000\u0000\u0260\u025e\u0001"+
		"\u0000\u0000\u0000\u0261\u0262\u0005v\u0000\u0000\u0262=\u0001\u0000\u0000"+
		"\u0000\u0263\u0268\u0003\u0094J\u0000\u0264\u0265\u0005t\u0000\u0000\u0265"+
		"\u0267\u0005u\u0000\u0000\u0266\u0264\u0001\u0000\u0000\u0000\u0267\u026a"+
		"\u0001\u0000\u0000\u0000\u0268\u0266\u0001\u0000\u0000\u0000\u0268\u0269"+
		"\u0001\u0000\u0000\u0000\u0269\u026b\u0001\u0000\u0000\u0000\u026a\u0268"+
		"\u0001\u0000\u0000\u0000\u026b\u026c\u0005`\u0000\u0000\u026c\u026d\u0003"+
		"F#\u0000\u026d?\u0001\u0000\u0000\u0000\u026e\u0273\u0003B!\u0000\u026f"+
		"\u0270\u0005w\u0000\u0000\u0270\u0272\u0003B!\u0000\u0271\u026f\u0001"+
		"\u0000\u0000\u0000\u0272\u0275\u0001\u0000\u0000\u0000\u0273\u0271\u0001"+
		"\u0000\u0000\u0000\u0273\u0274\u0001\u0000\u0000\u0000\u0274A\u0001\u0000"+
		"\u0000\u0000\u0275\u0273\u0001\u0000\u0000\u0000\u0276\u0279\u0003D\""+
		"\u0000\u0277\u0278\u0005`\u0000\u0000\u0278\u027a\u0003F#\u0000\u0279"+
		"\u0277\u0001\u0000\u0000\u0000\u0279\u027a\u0001\u0000\u0000\u0000\u027a"+
		"C\u0001\u0000\u0000\u0000\u027b\u0280\u0003\u0094J\u0000\u027c\u027d\u0005"+
		"t\u0000\u0000\u027d\u027f\u0005u\u0000\u0000\u027e\u027c\u0001\u0000\u0000"+
		"\u0000\u027f\u0282\u0001\u0000\u0000\u0000\u0280\u027e\u0001\u0000\u0000"+
		"\u0000\u0280\u0281\u0001\u0000\u0000\u0000\u0281E\u0001\u0000\u0000\u0000"+
		"\u0282\u0280\u0001\u0000\u0000\u0000\u0283\u0286\u0003H$\u0000\u0284\u0286"+
		"\u0003\u00d6k\u0000\u0285\u0283\u0001\u0000\u0000\u0000\u0285\u0284\u0001"+
		"\u0000\u0000\u0000\u0286G\u0001\u0000\u0000\u0000\u0287\u0293\u0005r\u0000"+
		"\u0000\u0288\u028d\u0003F#\u0000\u0289\u028a\u0005w\u0000\u0000\u028a"+
		"\u028c\u0003F#\u0000\u028b\u0289\u0001\u0000\u0000\u0000\u028c\u028f\u0001"+
		"\u0000\u0000\u0000\u028d\u028b\u0001\u0000\u0000\u0000\u028d\u028e\u0001"+
		"\u0000\u0000\u0000\u028e\u0291\u0001\u0000\u0000\u0000\u028f\u028d\u0001"+
		"\u0000\u0000\u0000\u0290\u0292\u0005w\u0000\u0000\u0291\u0290\u0001\u0000"+
		"\u0000\u0000\u0291\u0292\u0001\u0000\u0000\u0000\u0292\u0294\u0001\u0000"+
		"\u0000\u0000\u0293\u0288\u0001\u0000\u0000\u0000\u0293\u0294\u0001\u0000"+
		"\u0000\u0000\u0294\u0295\u0001\u0000\u0000\u0000\u0295\u0296\u0005s\u0000"+
		"\u0000\u0296I\u0001\u0000\u0000\u0000\u0297\u0299\u0003\u0094J\u0000\u0298"+
		"\u029a\u0003\u00fc~\u0000\u0299\u0298\u0001\u0000\u0000\u0000\u0299\u029a"+
		"\u0001\u0000\u0000\u0000\u029a\u029b\u0001\u0000\u0000\u0000\u029b\u029c"+
		"\u0005x\u0000\u0000\u029c\u029e\u0001\u0000\u0000\u0000\u029d\u0297\u0001"+
		"\u0000\u0000\u0000\u029e\u02a1\u0001\u0000\u0000\u0000\u029f\u029d\u0001"+
		"\u0000\u0000\u0000\u029f\u02a0\u0001\u0000\u0000\u0000\u02a0\u02a2\u0001"+
		"\u0000\u0000\u0000\u02a1\u029f\u0001\u0000\u0000\u0000\u02a2\u02a4\u0003"+
		"\u0096K\u0000\u02a3\u02a5\u0003\u00fc~\u0000\u02a4\u02a3\u0001\u0000\u0000"+
		"\u0000\u02a4\u02a5\u0001\u0000\u0000\u0000\u02a5K\u0001\u0000\u0000\u0000"+
		"\u02a6\u02ae\u0003\u00f8|\u0000\u02a7\u02a8\u0003h4\u0000\u02a8\u02ab"+
		"\u0005N\u0000\u0000\u02a9\u02aa\u0007\u0000\u0000\u0000\u02aa\u02ac\u0003"+
		"\u00f8|\u0000\u02ab\u02a9\u0001\u0000\u0000\u0000\u02ab\u02ac\u0001\u0000"+
		"\u0000\u0000\u02ac\u02ae\u0001\u0000\u0000\u0000\u02ad\u02a6\u0001\u0000"+
		"\u0000\u0000\u02ad\u02a7\u0001\u0000\u0000\u0000\u02aeM\u0001\u0000\u0000"+
		"\u0000\u02af\u02b4\u0003^/\u0000\u02b0\u02b1\u0005w\u0000\u0000\u02b1"+
		"\u02b3\u0003^/\u0000\u02b2\u02b0\u0001\u0000\u0000\u0000\u02b3\u02b6\u0001"+
		"\u0000\u0000\u0000\u02b4\u02b2\u0001\u0000\u0000\u0000\u02b4\u02b5\u0001"+
		"\u0000\u0000\u0000\u02b5O\u0001\u0000\u0000\u0000\u02b6\u02b4\u0001\u0000"+
		"\u0000\u0000\u02b7\u02c3\u0005p\u0000\u0000\u02b8\u02ba\u0003R)\u0000"+
		"\u02b9\u02b8\u0001\u0000\u0000\u0000\u02b9\u02ba\u0001\u0000\u0000\u0000"+
		"\u02ba\u02c4\u0001\u0000\u0000\u0000\u02bb\u02be\u0003R)\u0000\u02bc\u02bd"+
		"\u0005w\u0000\u0000\u02bd\u02bf\u0003T*\u0000\u02be\u02bc\u0001\u0000"+
		"\u0000\u0000\u02be\u02bf\u0001\u0000\u0000\u0000\u02bf\u02c4\u0001\u0000"+
		"\u0000\u0000\u02c0\u02c2\u0003T*\u0000\u02c1\u02c0\u0001\u0000\u0000\u0000"+
		"\u02c1\u02c2\u0001\u0000\u0000\u0000\u02c2\u02c4\u0001\u0000\u0000\u0000"+
		"\u02c3\u02b9\u0001\u0000\u0000\u0000\u02c3\u02bb\u0001\u0000\u0000\u0000"+
		"\u02c3\u02c1\u0001\u0000\u0000\u0000\u02c4\u02c5\u0001\u0000\u0000\u0000"+
		"\u02c5\u02c6\u0005q\u0000\u0000\u02c6Q\u0001\u0000\u0000\u0000\u02c7\u02cd"+
		"\u0003\u00f8|\u0000\u02c8\u02c9\u0003\u0094J\u0000\u02c9\u02ca\u0005x"+
		"\u0000\u0000\u02ca\u02cc\u0001\u0000\u0000\u0000\u02cb\u02c8\u0001\u0000"+
		"\u0000\u0000\u02cc\u02cf\u0001\u0000\u0000\u0000\u02cd\u02cb\u0001\u0000"+
		"\u0000\u0000\u02cd\u02ce\u0001\u0000\u0000\u0000\u02ce\u02d0\u0001\u0000"+
		"\u0000\u0000\u02cf\u02cd\u0001\u0000\u0000\u0000\u02d0\u02d1\u0005.\u0000"+
		"\u0000\u02d1S\u0001\u0000\u0000\u0000\u02d2\u02d7\u0003V+\u0000\u02d3"+
		"\u02d4\u0005w\u0000\u0000\u02d4\u02d6\u0003V+\u0000\u02d5\u02d3\u0001"+
		"\u0000\u0000\u0000\u02d6\u02d9\u0001\u0000\u0000\u0000\u02d7\u02d5\u0001"+
		"\u0000\u0000\u0000\u02d7\u02d8\u0001\u0000\u0000\u0000\u02d8\u02dc\u0001"+
		"\u0000\u0000\u0000\u02d9\u02d7\u0001\u0000\u0000\u0000\u02da\u02db\u0005"+
		"w\u0000\u0000\u02db\u02dd\u0003X,\u0000\u02dc\u02da\u0001\u0000\u0000"+
		"\u0000\u02dc\u02dd\u0001\u0000\u0000\u0000\u02dd\u02e0\u0001\u0000\u0000"+
		"\u0000\u02de\u02e0\u0003X,\u0000\u02df\u02d2\u0001\u0000\u0000\u0000\u02df"+
		"\u02de\u0001\u0000\u0000\u0000\u02e0U\u0001\u0000\u0000\u0000\u02e1\u02e2"+
		"\u0003\n\u0005\u0000\u02e2\u02e3\u0003\u00f8|\u0000\u02e3\u02e4\u0003"+
		"D\"\u0000\u02e4W\u0001\u0000\u0000\u0000\u02e5\u02e6\u0003\n\u0005\u0000"+
		"\u02e6\u02e7\u0003\u00f8|\u0000\u02e7\u02e8\u0003h4\u0000\u02e8\u02e9"+
		"\u0005\u0081\u0000\u0000\u02e9\u02ea\u0003D\"\u0000\u02eaY\u0001\u0000"+
		"\u0000\u0000\u02eb\u02f0\u0003\\.\u0000\u02ec\u02ed\u0005w\u0000\u0000"+
		"\u02ed\u02ef\u0003\\.\u0000\u02ee\u02ec\u0001\u0000\u0000\u0000\u02ef"+
		"\u02f2\u0001\u0000\u0000\u0000\u02f0\u02ee\u0001\u0000\u0000\u0000\u02f0"+
		"\u02f1\u0001\u0000\u0000\u0000\u02f1[\u0001\u0000\u0000\u0000\u02f2\u02f0"+
		"\u0001\u0000\u0000\u0000\u02f3\u02f4\u0003\n\u0005\u0000\u02f4\u02f5\u0005"+
		"=\u0000\u0000\u02f5\u02f6\u0003\u0094J\u0000\u02f6]\u0001\u0000\u0000"+
		"\u0000\u02f7\u02fc\u0003\u0094J\u0000\u02f8\u02f9\u0005x\u0000\u0000\u02f9"+
		"\u02fb\u0003\u0094J\u0000\u02fa\u02f8\u0001\u0000\u0000\u0000\u02fb\u02fe"+
		"\u0001\u0000\u0000\u0000\u02fc\u02fa\u0001\u0000\u0000\u0000\u02fc\u02fd"+
		"\u0001\u0000\u0000\u0000\u02fd_\u0001\u0000\u0000\u0000\u02fe\u02fc\u0001"+
		"\u0000\u0000\u0000\u02ff\u0307\u0003b1\u0000\u0300\u0307\u0003d2\u0000"+
		"\u0301\u0307\u0005I\u0000\u0000\u0302\u0307\u0005J\u0000\u0000\u0303\u0307"+
		"\u0005L\u0000\u0000\u0304\u0307\u0005M\u0000\u0000\u0305\u0307\u0005K"+
		"\u0000\u0000\u0306\u02ff\u0001\u0000\u0000\u0000\u0306\u0300\u0001\u0000"+
		"\u0000\u0000\u0306\u0301\u0001\u0000\u0000\u0000\u0306\u0302\u0001\u0000"+
		"\u0000\u0000\u0306\u0303\u0001\u0000\u0000\u0000\u0306\u0304\u0001\u0000"+
		"\u0000\u0000\u0306\u0305\u0001\u0000\u0000\u0000\u0307a\u0001\u0000\u0000"+
		"\u0000\u0308\u0309\u0007\u0001\u0000\u0000\u0309c\u0001\u0000\u0000\u0000"+
		"\u030a\u030b\u0007\u0002\u0000\u0000\u030be\u0001\u0000\u0000\u0000\u030c"+
		"\u030d\u0003\u0094J\u0000\u030d\u030e\u0005x\u0000\u0000\u030e\u0310\u0001"+
		"\u0000\u0000\u0000\u030f\u030c\u0001\u0000\u0000\u0000\u0310\u0313\u0001"+
		"\u0000\u0000\u0000\u0311\u030f\u0001\u0000\u0000\u0000\u0311\u0312\u0001"+
		"\u0000\u0000\u0000\u0312\u0314\u0001\u0000\u0000\u0000\u0313\u0311\u0001"+
		"\u0000\u0000\u0000\u0314\u0315\u0005\u0080\u0000\u0000\u0315\u0316\u0003"+
		"\u0094J\u0000\u0316g\u0001\u0000\u0000\u0000\u0317\u0319\u0003j5\u0000"+
		"\u0318\u0317\u0001\u0000\u0000\u0000\u0319\u031c\u0001\u0000\u0000\u0000"+
		"\u031a\u0318\u0001\u0000\u0000\u0000\u031a\u031b\u0001\u0000\u0000\u0000"+
		"\u031bi\u0001\u0000\u0000\u0000\u031c\u031a\u0001\u0000\u0000\u0000\u031d"+
		"\u031e\u0005\u0080\u0000\u0000\u031e\u0321\u0003^/\u0000\u031f\u0321\u0003"+
		"f3\u0000\u0320\u031d\u0001\u0000\u0000\u0000\u0320\u031f\u0001\u0000\u0000"+
		"\u0000\u0321\u0328\u0001\u0000\u0000\u0000\u0322\u0325\u0005p\u0000\u0000"+
		"\u0323\u0326\u0003l6\u0000\u0324\u0326\u0003p8\u0000\u0325\u0323\u0001"+
		"\u0000\u0000\u0000\u0325\u0324\u0001\u0000\u0000\u0000\u0325\u0326\u0001"+
		"\u0000\u0000\u0000\u0326\u0327\u0001\u0000\u0000\u0000\u0327\u0329\u0005"+
		"q\u0000\u0000\u0328\u0322\u0001\u0000\u0000\u0000\u0328\u0329\u0001\u0000"+
		"\u0000\u0000\u0329k\u0001\u0000\u0000\u0000\u032a\u032f\u0003n7\u0000"+
		"\u032b\u032c\u0005w\u0000\u0000\u032c\u032e\u0003n7\u0000\u032d\u032b"+
		"\u0001\u0000\u0000\u0000\u032e\u0331\u0001\u0000\u0000\u0000\u032f\u032d"+
		"\u0001\u0000\u0000\u0000\u032f\u0330\u0001\u0000\u0000\u0000\u0330m\u0001"+
		"\u0000\u0000\u0000\u0331\u032f\u0001\u0000\u0000\u0000\u0332\u0333\u0003"+
		"\u0094J\u0000\u0333\u0334\u0005`\u0000\u0000\u0334\u0335\u0003p8\u0000"+
		"\u0335o\u0001\u0000\u0000\u0000\u0336\u033a\u0003\u00d6k\u0000\u0337\u033a"+
		"\u0003j5\u0000\u0338\u033a\u0003r9\u0000\u0339\u0336\u0001\u0000\u0000"+
		"\u0000\u0339\u0337\u0001\u0000\u0000\u0000\u0339\u0338\u0001\u0000\u0000"+
		"\u0000\u033aq\u0001\u0000\u0000\u0000\u033b\u0344\u0005r\u0000\u0000\u033c"+
		"\u0341\u0003p8\u0000\u033d\u033e\u0005w\u0000\u0000\u033e\u0340\u0003"+
		"p8\u0000\u033f\u033d\u0001\u0000\u0000\u0000\u0340\u0343\u0001\u0000\u0000"+
		"\u0000\u0341\u033f\u0001\u0000\u0000\u0000\u0341\u0342\u0001\u0000\u0000"+
		"\u0000\u0342\u0345\u0001\u0000\u0000\u0000\u0343\u0341\u0001\u0000\u0000"+
		"\u0000\u0344\u033c\u0001\u0000\u0000\u0000\u0344\u0345\u0001\u0000\u0000"+
		"\u0000\u0345\u0347\u0001\u0000\u0000\u0000\u0346\u0348\u0005w\u0000\u0000"+
		"\u0347\u0346\u0001\u0000\u0000\u0000\u0347\u0348\u0001\u0000\u0000\u0000"+
		"\u0348\u0349\u0001\u0000\u0000\u0000\u0349\u034a\u0005s\u0000\u0000\u034a"+
		"s\u0001\u0000\u0000\u0000\u034b\u034c\u0003\n\u0005\u0000\u034c\u034d"+
		"\u0003v;\u0000\u034d\u0350\u0001\u0000\u0000\u0000\u034e\u0350\u0005v"+
		"\u0000\u0000\u034f\u034b\u0001\u0000\u0000\u0000\u034f\u034e\u0001\u0000"+
		"\u0000\u0000\u0350u\u0001\u0000\u0000\u0000\u0351\u0352\u0003\u00f8|\u0000"+
		"\u0352\u0353\u0003x<\u0000\u0353\u0354\u0005v\u0000\u0000\u0354\u035a"+
		"\u0001\u0000\u0000\u0000\u0355\u0357\u0003\f\u0006\u0000\u0356\u0358\u0005"+
		"v\u0000\u0000\u0357\u0356\u0001\u0000\u0000\u0000\u0357\u0358\u0001\u0000"+
		"\u0000\u0000\u0358\u035a\u0001\u0000\u0000\u0000\u0359\u0351\u0001\u0000"+
		"\u0000\u0000\u0359\u0355\u0001\u0000\u0000\u0000\u035aw\u0001\u0000\u0000"+
		"\u0000\u035b\u035e\u0003z=\u0000\u035c\u035e\u0003|>\u0000\u035d\u035b"+
		"\u0001\u0000\u0000\u0000\u035d\u035c\u0001\u0000\u0000\u0000\u035ey\u0001"+
		"\u0000\u0000\u0000\u035f\u0360\u0003\u0094J\u0000\u0360\u0361\u0005p\u0000"+
		"\u0000\u0361\u0363\u0005q\u0000\u0000\u0362\u0364\u0003~?\u0000\u0363"+
		"\u0362\u0001\u0000\u0000\u0000\u0363\u0364\u0001\u0000\u0000\u0000\u0364"+
		"{\u0001\u0000\u0000\u0000\u0365\u0366\u0003@ \u0000\u0366}\u0001\u0000"+
		"\u0000\u0000\u0367\u0368\u0005\u001c\u0000\u0000\u0368\u0369\u0003p8\u0000"+
		"\u0369\u007f\u0001\u0000\u0000\u0000\u036a\u036c\u00054\u0000\u0000\u036b"+
		"\u036a\u0001\u0000\u0000\u0000\u036b\u036c\u0001\u0000\u0000\u0000\u036c"+
		"\u036d\u0001\u0000\u0000\u0000\u036d\u036e\u00053\u0000\u0000\u036e\u036f"+
		"\u0003^/\u0000\u036f\u0370\u0003\u0018\f\u0000\u0370\u0081\u0001\u0000"+
		"\u0000\u0000\u0371\u0375\u00055\u0000\u0000\u0372\u0374\u0003\u0084B\u0000"+
		"\u0373\u0372\u0001\u0000\u0000\u0000\u0374\u0377\u0001\u0000\u0000\u0000"+
		"\u0375\u0373\u0001\u0000\u0000\u0000\u0375\u0376\u0001\u0000\u0000\u0000"+
		"\u0376\u0378\u0001\u0000\u0000\u0000\u0377\u0375\u0001\u0000\u0000\u0000"+
		"\u0378\u0379\u0003^/\u0000\u0379\u037a\u0005v\u0000\u0000\u037a\u0396"+
		"\u0001\u0000\u0000\u0000\u037b\u037c\u00056\u0000\u0000\u037c\u037f\u0003"+
		"^/\u0000\u037d\u037e\u00058\u0000\u0000\u037e\u0380\u0003^/\u0000\u037f"+
		"\u037d\u0001\u0000\u0000\u0000\u037f\u0380\u0001\u0000\u0000\u0000\u0380"+
		"\u0381\u0001\u0000\u0000\u0000\u0381\u0382\u0005v\u0000\u0000\u0382\u0396"+
		"\u0001\u0000\u0000\u0000\u0383\u0384\u00057\u0000\u0000\u0384\u0387\u0003"+
		"^/\u0000\u0385\u0386\u00058\u0000\u0000\u0386\u0388\u0003^/\u0000\u0387"+
		"\u0385\u0001\u0000\u0000\u0000\u0387\u0388\u0001\u0000\u0000\u0000\u0388"+
		"\u0389\u0001\u0000\u0000\u0000\u0389\u038a\u0005v\u0000\u0000\u038a\u0396"+
		"\u0001\u0000\u0000\u0000\u038b\u038c\u00059\u0000\u0000\u038c\u038d\u0003"+
		"^/\u0000\u038d\u038e\u0005v\u0000\u0000\u038e\u0396\u0001\u0000\u0000"+
		"\u0000\u038f\u0390\u0005:\u0000\u0000\u0390\u0391\u0003^/\u0000\u0391"+
		"\u0392\u0005;\u0000\u0000\u0392\u0393\u0003^/\u0000\u0393\u0394\u0005"+
		"v\u0000\u0000\u0394\u0396\u0001\u0000\u0000\u0000\u0395\u0371\u0001\u0000"+
		"\u0000\u0000\u0395\u037b\u0001\u0000\u0000\u0000\u0395\u0383\u0001\u0000"+
		"\u0000\u0000\u0395\u038b\u0001\u0000\u0000\u0000\u0395\u038f\u0001\u0000"+
		"\u0000\u0000\u0396\u0083\u0001\u0000\u0000\u0000\u0397\u0398\u0007\u0003"+
		"\u0000\u0000\u0398\u0085\u0001\u0000\u0000\u0000\u0399\u039b\u0005p\u0000"+
		"\u0000\u039a\u039c\u0003\u0088D\u0000\u039b\u039a\u0001\u0000\u0000\u0000"+
		"\u039b\u039c\u0001\u0000\u0000\u0000\u039c\u039d\u0001\u0000\u0000\u0000"+
		"\u039d\u039e\u0005q\u0000\u0000\u039e\u0087\u0001\u0000\u0000\u0000\u039f"+
		"\u03a4\u0003\u008aE\u0000\u03a0\u03a1\u0005w\u0000\u0000\u03a1\u03a3\u0003"+
		"\u008aE\u0000\u03a2\u03a0\u0001\u0000\u0000\u0000\u03a3\u03a6\u0001\u0000"+
		"\u0000\u0000\u03a4\u03a2\u0001\u0000\u0000\u0000\u03a4\u03a5\u0001\u0000"+
		"\u0000\u0000\u03a5\u0089\u0001\u0000\u0000\u0000\u03a6\u03a4\u0001\u0000"+
		"\u0000\u0000\u03a7\u03a8\u0003\u00f8|\u0000\u03a8\u03a9\u0003\u0094J\u0000"+
		"\u03a9\u008b\u0001\u0000\u0000\u0000\u03aa\u03af\u0005r\u0000\u0000\u03ab"+
		"\u03ae\u0003\f\u0006\u0000\u03ac\u03ae\u0003\u0098L\u0000\u03ad\u03ab"+
		"\u0001\u0000\u0000\u0000\u03ad\u03ac\u0001\u0000\u0000\u0000\u03ae\u03b1"+
		"\u0001\u0000\u0000\u0000\u03af\u03ad\u0001\u0000\u0000\u0000\u03af\u03b0"+
		"\u0001\u0000\u0000\u0000\u03b0\u03b2\u0001\u0000\u0000\u0000\u03b1\u03af"+
		"\u0001\u0000\u0000\u0000\u03b2\u03ca\u0005s\u0000\u0000\u03b3\u03b7\u0005"+
		"r\u0000\u0000\u03b4\u03b6\u0003\u008eG\u0000\u03b5\u03b4\u0001\u0000\u0000"+
		"\u0000\u03b6\u03b9\u0001\u0000\u0000\u0000\u03b7\u03b5\u0001\u0000\u0000"+
		"\u0000\u03b7\u03b8\u0001\u0000\u0000\u0000\u03b8\u03bd\u0001\u0000\u0000"+
		"\u0000\u03b9\u03b7\u0001\u0000\u0000\u0000\u03ba\u03bc\u0003\u00c8d\u0000"+
		"\u03bb\u03ba\u0001\u0000\u0000\u0000\u03bc\u03bf\u0001\u0000\u0000\u0000"+
		"\u03bd\u03bb\u0001\u0000\u0000\u0000\u03bd\u03be\u0001\u0000\u0000\u0000"+
		"\u03be\u03c0\u0001\u0000\u0000\u0000\u03bf\u03bd\u0001\u0000\u0000\u0000"+
		"\u03c0\u03ca\u0005s\u0000\u0000\u03c1\u03c5\u0005r\u0000\u0000\u03c2\u03c4"+
		"\u0003\u00e0p\u0000\u03c3\u03c2\u0001\u0000\u0000\u0000\u03c4\u03c7\u0001"+
		"\u0000\u0000\u0000\u03c5\u03c3\u0001\u0000\u0000\u0000\u03c5\u03c6\u0001"+
		"\u0000\u0000\u0000\u03c6\u03c8\u0001\u0000\u0000\u0000\u03c7\u03c5\u0001"+
		"\u0000\u0000\u0000\u03c8\u03ca\u0005s\u0000\u0000\u03c9\u03aa\u0001\u0000"+
		"\u0000\u0000\u03c9\u03b3\u0001\u0000\u0000\u0000\u03c9\u03c1\u0001\u0000"+
		"\u0000\u0000\u03ca\u008d\u0001\u0000\u0000\u0000\u03cb\u03cd\u0003\u00c8"+
		"d\u0000\u03cc\u03cb\u0001\u0000\u0000\u0000\u03cd\u03ce\u0001\u0000\u0000"+
		"\u0000\u03ce\u03cc\u0001\u0000\u0000\u0000\u03ce\u03cf\u0001\u0000\u0000"+
		"\u0000\u03cf\u03d2\u0001\u0000\u0000\u0000\u03d0\u03d3\u0003\f\u0006\u0000"+
		"\u03d1\u03d3\u0003\u0098L\u0000\u03d2\u03d0\u0001\u0000\u0000\u0000\u03d2"+
		"\u03d1\u0001\u0000\u0000\u0000\u03d3\u03d4\u0001\u0000\u0000\u0000\u03d4"+
		"\u03d2\u0001\u0000\u0000\u0000\u03d4\u03d5\u0001\u0000\u0000\u0000\u03d5"+
		"\u008f\u0001\u0000\u0000\u0000\u03d6\u03d7\u0003\u0092I\u0000\u03d7\u03d8"+
		"\u0005v\u0000\u0000\u03d8\u0091\u0001\u0000\u0000\u0000\u03d9\u03e2\u0003"+
		"\n\u0005\u0000\u03da\u03db\u0005=\u0000\u0000\u03db\u03dc\u0003\u0094"+
		"J\u0000\u03dc\u03dd\u0005`\u0000\u0000\u03dd\u03de\u0003\u00d6k\u0000"+
		"\u03de\u03e3\u0001\u0000\u0000\u0000\u03df\u03e0\u0003\u00f8|\u0000\u03e0"+
		"\u03e1\u0003@ \u0000\u03e1\u03e3\u0001\u0000\u0000\u0000\u03e2\u03da\u0001"+
		"\u0000\u0000\u0000\u03e2\u03df\u0001\u0000\u0000\u0000\u03e3\u0093\u0001"+
		"\u0000\u0000\u0000\u03e4\u03e5\u0007\u0004\u0000\u0000\u03e5\u0095\u0001"+
		"\u0000\u0000\u0000\u03e6\u03e7\u0007\u0005\u0000\u0000\u03e7\u0097\u0001"+
		"\u0000\u0000\u0000\u03e8\u03fd\u0003\u008cF\u0000\u03e9\u03fd\u0003\u0090"+
		"H\u0000\u03ea\u03fd\u0003\u009aM\u0000\u03eb\u03fd\u0003\u009cN\u0000"+
		"\u03ec\u03fd\u0003\u009eO\u0000\u03ed\u03fd\u0003\u00a0P\u0000\u03ee\u03fd"+
		"\u0003\u00a2Q\u0000\u03ef\u03fd\u0003\u00a4R\u0000\u03f0\u03fd\u0003\u00a6"+
		"S\u0000\u03f1\u03fd\u0003\u00a8T\u0000\u03f2\u03fd\u0003\u00aaU\u0000"+
		"\u03f3\u03fd\u0003\u00acV\u0000\u03f4\u03fd\u0003\u00aeW\u0000\u03f5\u03fd"+
		"\u0003\u00b0X\u0000\u03f6\u03fd\u0003\u00b2Y\u0000\u03f7\u03fd\u0003\u00b4"+
		"Z\u0000\u03f8\u03fd\u0003\u00b6[\u0000\u03f9\u03fd\u0005v\u0000\u0000"+
		"\u03fa\u03fd\u0003\u00b8\\\u0000\u03fb\u03fd\u0003\u00ba]\u0000\u03fc"+
		"\u03e8\u0001\u0000\u0000\u0000\u03fc\u03e9\u0001\u0000\u0000\u0000\u03fc"+
		"\u03ea\u0001\u0000\u0000\u0000\u03fc\u03eb\u0001\u0000\u0000\u0000\u03fc"+
		"\u03ec\u0001\u0000\u0000\u0000\u03fc\u03ed\u0001\u0000\u0000\u0000\u03fc"+
		"\u03ee\u0001\u0000\u0000\u0000\u03fc\u03ef\u0001\u0000\u0000\u0000\u03fc"+
		"\u03f0\u0001\u0000\u0000\u0000\u03fc\u03f1\u0001\u0000\u0000\u0000\u03fc"+
		"\u03f2\u0001\u0000\u0000\u0000\u03fc\u03f3\u0001\u0000\u0000\u0000\u03fc"+
		"\u03f4\u0001\u0000\u0000\u0000\u03fc\u03f5\u0001\u0000\u0000\u0000\u03fc"+
		"\u03f6\u0001\u0000\u0000\u0000\u03fc\u03f7\u0001\u0000\u0000\u0000\u03fc"+
		"\u03f8\u0001\u0000\u0000\u0000\u03fc\u03f9\u0001\u0000\u0000\u0000\u03fc"+
		"\u03fa\u0001\u0000\u0000\u0000\u03fc\u03fb\u0001\u0000\u0000\u0000\u03fd"+
		"\u0099\u0001\u0000\u0000\u0000\u03fe\u03ff\u0005\u0019\u0000\u0000\u03ff"+
		"\u0402\u0003\u00d6k\u0000\u0400\u0401\u0005O\u0000\u0000\u0401\u0403\u0003"+
		"\u00d6k\u0000\u0402\u0400\u0001\u0000\u0000\u0000\u0402\u0403\u0001\u0000"+
		"\u0000\u0000\u0403\u0404\u0001\u0000\u0000\u0000\u0404\u0405\u0005v\u0000"+
		"\u0000\u0405\u009b\u0001\u0000\u0000\u0000\u0406\u0407\u0005\u000f\u0000"+
		"\u0000\u0407\u0408\u0003\u00d0h\u0000\u0408\u0409\u0003\u0098L\u0000\u0409"+
		"\u009d\u0001\u0000\u0000\u0000\u040a\u040b\u0005\u000f\u0000\u0000\u040b"+
		"\u040c\u0003\u00d0h\u0000\u040c\u040d\u0003\u0098L\u0000\u040d\u040e\u0005"+
		"\f\u0000\u0000\u040e\u040f\u0003\u0098L\u0000\u040f\u009f\u0001\u0000"+
		"\u0000\u0000\u0410\u0411\u0005\u000e\u0000\u0000\u0411\u0412\u0005p\u0000"+
		"\u0000\u0412\u0413\u0003\u00cae\u0000\u0413\u0414\u0005q\u0000\u0000\u0414"+
		"\u0415\u0003\u0098L\u0000\u0415\u00a1\u0001\u0000\u0000\u0000\u0416\u0417"+
		"\u0005\u0012\u0000\u0000\u0417\u0418\u0003\u00d0h\u0000\u0418\u0419\u0003"+
		"\u0098L\u0000\u0419\u00a3\u0001\u0000\u0000\u0000\u041a\u041b\u0005\u000b"+
		"\u0000\u0000\u041b\u041c\u0003\u0098L\u0000\u041c\u041d\u0005\u0012\u0000"+
		"\u0000\u041d\u041e\u0003\u00d0h\u0000\u041e\u041f\u0005v\u0000\u0000\u041f"+
		"\u00a5\u0001\u0000\u0000\u0000\u0420\u0421\u0005\u0011\u0000\u0000\u0421"+
		"\u042b\u0003\u008cF\u0000\u0422\u0424\u0003\u00bc^\u0000\u0423\u0422\u0001"+
		"\u0000\u0000\u0000\u0424\u0425\u0001\u0000\u0000\u0000\u0425\u0423\u0001"+
		"\u0000\u0000\u0000\u0425\u0426\u0001\u0000\u0000\u0000\u0426\u0428\u0001"+
		"\u0000\u0000\u0000\u0427\u0429\u0003\u00c0`\u0000\u0428\u0427\u0001\u0000"+
		"\u0000\u0000\u0428\u0429\u0001\u0000\u0000\u0000\u0429\u042c\u0001\u0000"+
		"\u0000\u0000\u042a\u042c\u0003\u00c0`\u0000\u042b\u0423\u0001\u0000\u0000"+
		"\u0000\u042b\u042a\u0001\u0000\u0000\u0000\u042c\u00a7\u0001\u0000\u0000"+
		"\u0000\u042d\u042e\u0005\u0011\u0000\u0000\u042e\u042f\u0003\u00c2a\u0000"+
		"\u042f\u0433\u0003\u008cF\u0000\u0430\u0432\u0003\u00bc^\u0000\u0431\u0430"+
		"\u0001\u0000\u0000\u0000\u0432\u0435\u0001\u0000\u0000\u0000\u0433\u0431"+
		"\u0001\u0000\u0000\u0000\u0433\u0434\u0001\u0000\u0000\u0000\u0434\u0437"+
		"\u0001\u0000\u0000\u0000\u0435\u0433\u0001\u0000\u0000\u0000\u0436\u0438"+
		"\u0003\u00c0`\u0000\u0437\u0436\u0001\u0000\u0000\u0000\u0437\u0438\u0001"+
		"\u0000\u0000\u0000\u0438\u00a9\u0001\u0000\u0000\u0000\u0439\u043a\u0005"+
		"\u0010\u0000\u0000\u043a\u043b\u0003\u00d0h\u0000\u043b\u043c\u0003\u008c"+
		"F\u0000\u043c\u00ab\u0001\u0000\u0000\u0000\u043d\u043e\u0005-\u0000\u0000"+
		"\u043e\u043f\u0003\u00d0h\u0000\u043f\u0440\u0003\u008cF\u0000\u0440\u00ad"+
		"\u0001\u0000\u0000\u0000\u0441\u0443\u0005\u0017\u0000\u0000\u0442\u0444"+
		"\u0003\u00d6k\u0000\u0443\u0442\u0001\u0000\u0000\u0000\u0443\u0444\u0001"+
		"\u0000\u0000\u0000\u0444\u0445\u0001\u0000\u0000\u0000\u0445\u0446\u0005"+
		"v\u0000\u0000\u0446\u00af\u0001\u0000\u0000\u0000\u0447\u0448\u0005/\u0000"+
		"\u0000\u0448\u0449\u0003\u00d6k\u0000\u0449\u044a\u0005v\u0000\u0000\u044a"+
		"\u00b1\u0001\u0000\u0000\u0000\u044b\u044d\u0005\u0014\u0000\u0000\u044c"+
		"\u044e\u0003\u0094J\u0000\u044d\u044c\u0001\u0000\u0000\u0000\u044d\u044e"+
		"\u0001\u0000\u0000\u0000\u044e\u044f\u0001\u0000\u0000\u0000\u044f\u0450"+
		"\u0005v\u0000\u0000\u0450\u00b3\u0001\u0000\u0000\u0000\u0451\u0453\u0005"+
		"\u0016\u0000\u0000\u0452\u0454\u0003\u0094J\u0000\u0453\u0452\u0001\u0000"+
		"\u0000\u0000\u0453\u0454\u0001\u0000\u0000\u0000\u0454\u0455\u0001\u0000"+
		"\u0000\u0000\u0455\u0456\u0005v\u0000\u0000\u0456\u00b5\u0001\u0000\u0000"+
		"\u0000\u0457\u0458\u0005>\u0000\u0000\u0458\u0459\u0003\u00d6k\u0000\u0459"+
		"\u045a\u0005v\u0000\u0000\u045a\u00b7\u0001\u0000\u0000\u0000\u045b\u045c"+
		"\u0003\u00d6k\u0000\u045c\u045d\u0005v\u0000\u0000\u045d\u00b9\u0001\u0000"+
		"\u0000\u0000\u045e\u045f\u0003\u0094J\u0000\u045f\u0460\u0005O\u0000\u0000"+
		"\u0460\u0461\u0003\u0098L\u0000\u0461\u00bb\u0001\u0000\u0000\u0000\u0462"+
		"\u0463\u0005\n\u0000\u0000\u0463\u0464\u0005p\u0000\u0000\u0464\u0465"+
		"\u0003\n\u0005\u0000\u0465\u0466\u0003\u00be_\u0000\u0466\u0467\u0003"+
		"\u0094J\u0000\u0467\u0468\u0005q\u0000\u0000\u0468\u0469\u0003\u008cF"+
		"\u0000\u0469\u00bd\u0001\u0000\u0000\u0000\u046a\u046f\u0003^/\u0000\u046b"+
		"\u046c\u0005^\u0000\u0000\u046c\u046e\u0003^/\u0000\u046d\u046b\u0001"+
		"\u0000\u0000\u0000\u046e\u0471\u0001\u0000\u0000\u0000\u046f\u046d\u0001"+
		"\u0000\u0000\u0000\u046f\u0470\u0001\u0000\u0000\u0000\u0470\u00bf\u0001"+
		"\u0000\u0000\u0000\u0471\u046f\u0001\u0000\u0000\u0000\u0472\u0473\u0005"+
		"\r\u0000\u0000\u0473\u0474\u0003\u008cF\u0000\u0474\u00c1\u0001\u0000"+
		"\u0000\u0000\u0475\u0476\u0005p\u0000\u0000\u0476\u0478\u0003\u00c4b\u0000"+
		"\u0477\u0479\u0005v\u0000\u0000\u0478\u0477\u0001\u0000\u0000\u0000\u0478"+
		"\u0479\u0001\u0000\u0000\u0000\u0479\u047a\u0001\u0000\u0000\u0000\u047a"+
		"\u047b\u0005q\u0000\u0000\u047b\u00c3\u0001\u0000\u0000\u0000\u047c\u0481"+
		"\u0003\u00c6c\u0000\u047d\u047e\u0005v\u0000\u0000\u047e\u0480\u0003\u00c6"+
		"c\u0000\u047f\u047d\u0001\u0000\u0000\u0000\u0480\u0483\u0001\u0000\u0000"+
		"\u0000\u0481\u047f\u0001\u0000\u0000\u0000\u0481\u0482\u0001\u0000\u0000"+
		"\u0000\u0482\u00c5\u0001\u0000\u0000\u0000\u0483\u0481\u0001\u0000\u0000"+
		"\u0000\u0484\u048a\u0003\n\u0005\u0000\u0485\u0486\u0003J%\u0000\u0486"+
		"\u0487\u0003D\"\u0000\u0487\u048b\u0001\u0000\u0000\u0000\u0488\u0489"+
		"\u0005=\u0000\u0000\u0489\u048b\u0003\u0094J\u0000\u048a\u0485\u0001\u0000"+
		"\u0000\u0000\u048a\u0488\u0001\u0000\u0000\u0000\u048b\u048c\u0001\u0000"+
		"\u0000\u0000\u048c\u048d\u0005`\u0000\u0000\u048d\u048e\u0003\u00d6k\u0000"+
		"\u048e\u0491\u0001\u0000\u0000\u0000\u048f\u0491\u0003^/\u0000\u0490\u0484"+
		"\u0001\u0000\u0000\u0000\u0490\u048f\u0001\u0000\u0000\u0000\u0491\u00c7"+
		"\u0001\u0000\u0000\u0000\u0492\u0498\u0005\u0015\u0000\u0000\u0493\u0499"+
		"\u0003\u00d6k\u0000\u0494\u0499\u0005}\u0000\u0000\u0495\u0496\u0003\u00f8"+
		"|\u0000\u0496\u0497\u0003\u0094J\u0000\u0497\u0499\u0001\u0000\u0000\u0000"+
		"\u0498\u0493\u0001\u0000\u0000\u0000\u0498\u0494\u0001\u0000\u0000\u0000"+
		"\u0498\u0495\u0001\u0000\u0000\u0000\u0499\u049a\u0001\u0000\u0000\u0000"+
		"\u049a\u049e\u0005O\u0000\u0000\u049b\u049c\u0005\u001c\u0000\u0000\u049c"+
		"\u049e\u0005O\u0000\u0000\u049d\u0492\u0001\u0000\u0000\u0000\u049d\u049b"+
		"\u0001\u0000\u0000\u0000\u049e\u00c9\u0001\u0000\u0000\u0000\u049f\u04ac"+
		"\u0003\u00ceg\u0000\u04a0\u04a2\u0003\u00ccf\u0000\u04a1\u04a0\u0001\u0000"+
		"\u0000\u0000\u04a1\u04a2\u0001\u0000\u0000\u0000\u04a2\u04a3\u0001\u0000"+
		"\u0000\u0000\u04a3\u04a5\u0005v\u0000\u0000\u04a4\u04a6\u0003\u00d6k\u0000"+
		"\u04a5\u04a4\u0001\u0000\u0000\u0000\u04a5\u04a6\u0001\u0000\u0000\u0000"+
		"\u04a6\u04a7\u0001\u0000\u0000\u0000\u04a7\u04a9\u0005v\u0000\u0000\u04a8"+
		"\u04aa\u0003\u00d2i\u0000\u04a9\u04a8\u0001\u0000\u0000\u0000\u04a9\u04aa"+
		"\u0001\u0000\u0000\u0000\u04aa\u04ac\u0001\u0000\u0000\u0000\u04ab\u049f"+
		"\u0001\u0000\u0000\u0000\u04ab\u04a1\u0001\u0000\u0000\u0000\u04ac\u00cb"+
		"\u0001\u0000\u0000\u0000\u04ad\u04b0\u0003\u0092I\u0000\u04ae\u04b0\u0003"+
		"\u00d2i\u0000\u04af\u04ad\u0001\u0000\u0000\u0000\u04af\u04ae\u0001\u0000"+
		"\u0000\u0000\u04b0\u00cd\u0001\u0000\u0000\u0000\u04b1\u04b4\u0003\n\u0005"+
		"\u0000\u04b2\u04b5\u0003\u00f8|\u0000\u04b3\u04b5\u0005=\u0000\u0000\u04b4"+
		"\u04b2\u0001\u0000\u0000\u0000\u04b4\u04b3\u0001\u0000\u0000\u0000\u04b5"+
		"\u04b6\u0001\u0000\u0000\u0000\u04b6\u04b7\u0003D\"\u0000\u04b7\u04b8"+
		"\u0005O\u0000\u0000\u04b8\u04b9\u0003\u00d6k\u0000\u04b9\u00cf\u0001\u0000"+
		"\u0000\u0000\u04ba\u04bb\u0005p\u0000\u0000\u04bb\u04bc\u0003\u00d6k\u0000"+
		"\u04bc\u04bd\u0005q\u0000\u0000\u04bd\u00d1\u0001\u0000\u0000\u0000\u04be"+
		"\u04c3\u0003\u00d6k\u0000\u04bf\u04c0\u0005w\u0000\u0000\u04c0\u04c2\u0003"+
		"\u00d6k\u0000\u04c1\u04bf\u0001\u0000\u0000\u0000\u04c2\u04c5\u0001\u0000"+
		"\u0000\u0000\u04c3\u04c1\u0001\u0000\u0000\u0000\u04c3\u04c4\u0001\u0000"+
		"\u0000\u0000\u04c4\u00d3\u0001\u0000\u0000\u0000\u04c5\u04c3\u0001\u0000"+
		"\u0000\u0000\u04c6\u04ca\u0003\u0094J\u0000\u04c7\u04ca\u0005.\u0000\u0000"+
		"\u04c8\u04ca\u0005,\u0000\u0000\u04c9\u04c6\u0001\u0000\u0000\u0000\u04c9"+
		"\u04c7\u0001\u0000\u0000\u0000\u04c9\u04c8\u0001\u0000\u0000\u0000\u04ca"+
		"\u04cb\u0001\u0000\u0000\u0000\u04cb\u04cc\u0003\u0102\u0081\u0000\u04cc"+
		"\u00d5\u0001\u0000\u0000\u0000\u04cd\u04ce\u0006k\uffff\uffff\u0000\u04ce"+
		"\u04cf\u0005p\u0000\u0000\u04cf\u04d0\u0003\u00d6k\u0000\u04d0\u04d1\u0005"+
		"q\u0000\u0000\u04d1\u0508\u0001\u0000\u0000\u0000\u04d2\u0508\u0005.\u0000"+
		"\u0000\u04d3\u0508\u0005,\u0000\u0000\u04d4\u0508\u0003`0\u0000\u04d5"+
		"\u0508\u0003\u0094J\u0000\u04d6\u04d7\u0003\u00f8|\u0000\u04d7\u04d8\u0005"+
		"x\u0000\u0000\u04d8\u04d9\u0005\u001a\u0000\u0000\u04d9\u0508\u0001\u0000"+
		"\u0000\u0000\u04da\u04de\u0003\u00f4z\u0000\u04db\u04df\u0003\u0100\u0080"+
		"\u0000\u04dc\u04dd\u0005.\u0000\u0000\u04dd\u04df\u0003\u0102\u0081\u0000"+
		"\u04de\u04db\u0001\u0000\u0000\u0000\u04de\u04dc\u0001\u0000\u0000\u0000"+
		"\u04df\u0508\u0001\u0000\u0000\u0000\u04e0\u0508\u0003\u00d4j\u0000\u04e1"+
		"\u04e2\u0003\u00f8|\u0000\u04e2\u04e8\u0005\u007f\u0000\u0000\u04e3\u04e5"+
		"\u0003\u00fc~\u0000\u04e4\u04e3\u0001\u0000\u0000\u0000\u04e4\u04e5\u0001"+
		"\u0000\u0000\u0000\u04e5\u04e6\u0001\u0000\u0000\u0000\u04e6\u04e9\u0003"+
		"\u0094J\u0000\u04e7\u04e9\u0005%\u0000\u0000\u04e8\u04e4\u0001\u0000\u0000"+
		"\u0000\u04e8\u04e7\u0001\u0000\u0000\u0000\u04e9\u0508\u0001\u0000\u0000"+
		"\u0000\u04ea\u04eb\u0003\u00e4r\u0000\u04eb\u04ed\u0005\u007f\u0000\u0000"+
		"\u04ec\u04ee\u0003\u00fc~\u0000\u04ed\u04ec\u0001\u0000\u0000\u0000\u04ed"+
		"\u04ee\u0001\u0000\u0000\u0000\u04ee\u04ef\u0001\u0000\u0000\u0000\u04ef"+
		"\u04f0\u0005%\u0000\u0000\u04f0\u0508\u0001\u0000\u0000\u0000\u04f1\u04f2"+
		"\u0005\u0010\u0000\u0000\u04f2\u04f3\u0003\u00d0h\u0000\u04f3\u04f4\u0003"+
		"\u008cF\u0000\u04f4\u0508\u0001\u0000\u0000\u0000\u04f5\u04f6\u0007\u0006"+
		"\u0000\u0000\u04f6\u0508\u0003\u00d6k\u0011\u04f7\u04f8\u0005p\u0000\u0000"+
		"\u04f8\u04f9\u0003h4\u0000\u04f9\u04fe\u0003\u00f8|\u0000\u04fa\u04fb"+
		"\u0005]\u0000\u0000\u04fb\u04fd\u0003\u00f8|\u0000\u04fc\u04fa\u0001\u0000"+
		"\u0000\u0000\u04fd\u0500\u0001\u0000\u0000\u0000\u04fe\u04fc\u0001\u0000"+
		"\u0000\u0000\u04fe\u04ff\u0001\u0000\u0000\u0000\u04ff\u0501\u0001\u0000"+
		"\u0000\u0000\u0500\u04fe\u0001\u0000\u0000\u0000\u0501\u0502\u0005q\u0000"+
		"\u0000\u0502\u0503\u0003\u00d6k\u0010\u0503\u0508\u0001\u0000\u0000\u0000"+
		"\u0504\u0505\u0005%\u0000\u0000\u0505\u0508\u0003\u00e6s\u0000\u0506\u0508"+
		"\u0003\u00dam\u0000\u0507\u04cd\u0001\u0000\u0000\u0000\u0507\u04d2\u0001"+
		"\u0000\u0000\u0000\u0507\u04d3\u0001\u0000\u0000\u0000\u0507\u04d4\u0001"+
		"\u0000\u0000\u0000\u0507\u04d5\u0001\u0000\u0000\u0000\u0507\u04d6\u0001"+
		"\u0000\u0000\u0000\u0507\u04da\u0001\u0000\u0000\u0000\u0507\u04e0\u0001"+
		"\u0000\u0000\u0000\u0507\u04e1\u0001\u0000\u0000\u0000\u0507\u04ea\u0001"+
		"\u0000\u0000\u0000\u0507\u04f1\u0001\u0000\u0000\u0000\u0507\u04f5\u0001"+
		"\u0000\u0000\u0000\u0507\u04f7\u0001\u0000\u0000\u0000\u0507\u0504\u0001"+
		"\u0000\u0000\u0000\u0507\u0506\u0001\u0000\u0000\u0000\u0508\u055c\u0001"+
		"\u0000\u0000\u0000\u0509\u050a\n\u000e\u0000\u0000\u050a\u050b\u0007\u0007"+
		"\u0000\u0000\u050b\u055b\u0003\u00d6k\u000f\u050c\u050d\n\r\u0000\u0000"+
		"\u050d\u050e\u0007\b\u0000\u0000\u050e\u055b\u0003\u00d6k\u000e\u050f"+
		"\u0517\n\f\u0000\u0000\u0510\u0511\u0005Q\u0000\u0000\u0511\u0518\u0005"+
		"Q\u0000\u0000\u0512\u0513\u0005P\u0000\u0000\u0513\u0518\u0005P\u0000"+
		"\u0000\u0514\u0515\u0005P\u0000\u0000\u0515\u0516\u0005P\u0000\u0000\u0516"+
		"\u0518\u0005P\u0000\u0000\u0517\u0510\u0001\u0000\u0000\u0000\u0517\u0512"+
		"\u0001\u0000\u0000\u0000\u0517\u0514\u0001\u0000\u0000\u0000\u0518\u0519"+
		"\u0001\u0000\u0000\u0000\u0519\u055b\u0003\u00d6k\r\u051a\u051b\n\u000b"+
		"\u0000\u0000\u051b\u051c\u0007\t\u0000\u0000\u051c\u055b\u0003\u00d6k"+
		"\f\u051d\u051e\n\t\u0000\u0000\u051e\u051f\u0007\n\u0000\u0000\u051f\u055b"+
		"\u0003\u00d6k\n\u0520\u0521\n\b\u0000\u0000\u0521\u0522\u0005]\u0000\u0000"+
		"\u0522\u055b\u0003\u00d6k\t\u0523\u0524\n\u0007\u0000\u0000\u0524\u0525"+
		"\u0005_\u0000\u0000\u0525\u055b\u0003\u00d6k\b\u0526\u0527\n\u0006\u0000"+
		"\u0000\u0527\u0528\u0005^\u0000\u0000\u0528\u055b\u0003\u00d6k\u0007\u0529"+
		"\u052a\n\u0005\u0000\u0000\u052a\u052b\u0005V\u0000\u0000\u052b\u055b"+
		"\u0003\u00d6k\u0006\u052c\u052d\n\u0004\u0000\u0000\u052d\u052e\u0005"+
		"W\u0000\u0000\u052e\u055b\u0003\u00d6k\u0005\u052f\u0530\n\u0003\u0000"+
		"\u0000\u0530\u0531\u0005N\u0000\u0000\u0531\u0532\u0003\u00d6k\u0000\u0532"+
		"\u0533\u0005O\u0000\u0000\u0533\u0534\u0003\u00d6k\u0003\u0534\u055b\u0001"+
		"\u0000\u0000\u0000\u0535\u0536\n\u0002\u0000\u0000\u0536\u0537\u0007\u000b"+
		"\u0000\u0000\u0537\u055b\u0003\u00d6k\u0002\u0538\u0539\n\u0019\u0000"+
		"\u0000\u0539\u053a\u0005t\u0000\u0000\u053a\u053b\u0003\u00d6k\u0000\u053b"+
		"\u053c\u0005u\u0000\u0000\u053c\u055b\u0001\u0000\u0000\u0000\u053d\u053e"+
		"\n\u0018\u0000\u0000\u053e\u054a\u0005x\u0000\u0000\u053f\u054b\u0003"+
		"\u0094J\u0000\u0540\u054b\u0003\u00d4j\u0000\u0541\u054b\u0005.\u0000"+
		"\u0000\u0542\u0544\u0005%\u0000\u0000\u0543\u0545\u0003\u00f4z\u0000\u0544"+
		"\u0543\u0001\u0000\u0000\u0000\u0544\u0545\u0001\u0000\u0000\u0000\u0545"+
		"\u0546\u0001\u0000\u0000\u0000\u0546\u054b\u0003\u00eau\u0000\u0547\u0548"+
		"\u0005,\u0000\u0000\u0548\u054b\u0003\u00fe\u007f\u0000\u0549\u054b\u0003"+
		"\u00f0x\u0000\u054a\u053f\u0001\u0000\u0000\u0000\u054a\u0540\u0001\u0000"+
		"\u0000\u0000\u054a\u0541\u0001\u0000\u0000\u0000\u054a\u0542\u0001\u0000"+
		"\u0000\u0000\u054a\u0547\u0001\u0000\u0000\u0000\u054a\u0549\u0001\u0000"+
		"\u0000\u0000\u054b\u055b\u0001\u0000\u0000\u0000\u054c\u054d\n\u0016\u0000"+
		"\u0000\u054d\u054f\u0005\u007f\u0000\u0000\u054e\u0550\u0003\u00fc~\u0000"+
		"\u054f\u054e\u0001\u0000\u0000\u0000\u054f\u0550\u0001\u0000\u0000\u0000"+
		"\u0550\u0551\u0001\u0000\u0000\u0000\u0551\u055b\u0003\u0094J\u0000\u0552"+
		"\u0553\n\u0012\u0000\u0000\u0553\u055b\u0007\f\u0000\u0000\u0554\u0555"+
		"\n\n\u0000\u0000\u0555\u0558\u0005\"\u0000\u0000\u0556\u0559\u0003\u00f8"+
		"|\u0000\u0557\u0559\u0003\u00d8l\u0000\u0558\u0556\u0001\u0000\u0000\u0000"+
		"\u0558\u0557\u0001\u0000\u0000\u0000\u0559\u055b\u0001\u0000\u0000\u0000"+
		"\u055a\u0509\u0001\u0000\u0000\u0000\u055a\u050c\u0001\u0000\u0000\u0000"+
		"\u055a\u050f\u0001\u0000\u0000\u0000\u055a\u051a\u0001\u0000\u0000\u0000"+
		"\u055a\u051d\u0001\u0000\u0000\u0000\u055a\u0520\u0001\u0000\u0000\u0000"+
		"\u055a\u0523\u0001\u0000\u0000\u0000\u055a\u0526\u0001\u0000\u0000\u0000"+
		"\u055a\u0529\u0001\u0000\u0000\u0000\u055a\u052c\u0001\u0000\u0000\u0000"+
		"\u055a\u052f\u0001\u0000\u0000\u0000\u055a\u0535\u0001\u0000\u0000\u0000"+
		"\u055a\u0538\u0001\u0000\u0000\u0000\u055a\u053d\u0001\u0000\u0000\u0000"+
		"\u055a\u054c\u0001\u0000\u0000\u0000\u055a\u0552\u0001\u0000\u0000\u0000"+
		"\u055a\u0554\u0001\u0000\u0000\u0000\u055b\u055e\u0001\u0000\u0000\u0000"+
		"\u055c\u055a\u0001\u0000\u0000\u0000\u055c\u055d\u0001\u0000\u0000\u0000"+
		"\u055d\u00d7\u0001\u0000\u0000\u0000\u055e\u055c\u0001\u0000\u0000\u0000"+
		"\u055f\u0560\u0003\n\u0005\u0000\u0560\u0561\u0003\u00f8|\u0000\u0561"+
		"\u0562\u0003h4\u0000\u0562\u0563\u0003\u0094J\u0000\u0563\u00d9\u0001"+
		"\u0000\u0000\u0000\u0564\u0565\u0003\u00dcn\u0000\u0565\u0566\u0005~\u0000"+
		"\u0000\u0566\u0567\u0003\u00deo\u0000\u0567\u00db\u0001\u0000\u0000\u0000"+
		"\u0568\u057f\u0003\u0094J\u0000\u0569\u056b\u0005p\u0000\u0000\u056a\u056c"+
		"\u0003T*\u0000\u056b\u056a\u0001\u0000\u0000\u0000\u056b\u056c\u0001\u0000"+
		"\u0000\u0000\u056c\u056d\u0001\u0000\u0000\u0000\u056d\u057f\u0005q\u0000"+
		"\u0000\u056e\u056f\u0005p\u0000\u0000\u056f\u0574\u0003\u0094J\u0000\u0570"+
		"\u0571\u0005w\u0000\u0000\u0571\u0573\u0003\u0094J\u0000\u0572\u0570\u0001"+
		"\u0000\u0000\u0000\u0573\u0576\u0001\u0000\u0000\u0000\u0574\u0572\u0001"+
		"\u0000\u0000\u0000\u0574\u0575\u0001\u0000\u0000\u0000\u0575\u0577\u0001"+
		"\u0000\u0000\u0000\u0576\u0574\u0001\u0000\u0000\u0000\u0577\u0578\u0005"+
		"q\u0000\u0000\u0578\u057f\u0001\u0000\u0000\u0000\u0579\u057b\u0005p\u0000"+
		"\u0000\u057a\u057c\u0003Z-\u0000\u057b\u057a\u0001\u0000\u0000\u0000\u057b"+
		"\u057c\u0001\u0000\u0000\u0000\u057c\u057d\u0001\u0000\u0000\u0000\u057d"+
		"\u057f\u0005q\u0000\u0000\u057e\u0568\u0001\u0000\u0000\u0000\u057e\u0569"+
		"\u0001\u0000\u0000\u0000\u057e\u056e\u0001\u0000\u0000\u0000\u057e\u0579"+
		"\u0001\u0000\u0000\u0000\u057f\u00dd\u0001\u0000\u0000\u0000\u0580\u0583"+
		"\u0003\u00d6k\u0000\u0581\u0583\u0003\u008cF\u0000\u0582\u0580\u0001\u0000"+
		"\u0000\u0000\u0582\u0581\u0001\u0000\u0000\u0000\u0583\u00df\u0001\u0000"+
		"\u0000\u0000\u0584\u0588\u0005\u0015\u0000\u0000\u0585\u0589\u0003\u00d2"+
		"i\u0000\u0586\u0589\u0005M\u0000\u0000\u0587\u0589\u0003\u00e2q\u0000"+
		"\u0588\u0585\u0001\u0000\u0000\u0000\u0588\u0586\u0001\u0000\u0000\u0000"+
		"\u0588\u0587\u0001\u0000\u0000\u0000\u0589\u058a\u0001\u0000\u0000\u0000"+
		"\u058a\u058f\u0007\r\u0000\u0000\u058b\u058e\u0003\f\u0006\u0000\u058c"+
		"\u058e\u0003\u0098L\u0000\u058d\u058b\u0001\u0000\u0000\u0000\u058d\u058c"+
		"\u0001\u0000\u0000\u0000\u058e\u0591\u0001\u0000\u0000\u0000\u058f\u058d"+
		"\u0001\u0000\u0000\u0000\u058f\u0590\u0001\u0000\u0000\u0000\u0590\u059c"+
		"\u0001\u0000\u0000\u0000\u0591\u058f\u0001\u0000\u0000\u0000\u0592\u0593"+
		"\u0005\u001c\u0000\u0000\u0593\u0598\u0007\r\u0000\u0000\u0594\u0597\u0003"+
		"\f\u0006\u0000\u0595\u0597\u0003\u0098L\u0000\u0596\u0594\u0001\u0000"+
		"\u0000\u0000\u0596\u0595\u0001\u0000\u0000\u0000\u0597\u059a\u0001\u0000"+
		"\u0000\u0000\u0598\u0596\u0001\u0000\u0000\u0000\u0598\u0599\u0001\u0000"+
		"\u0000\u0000\u0599\u059c\u0001\u0000\u0000\u0000\u059a\u0598\u0001\u0000"+
		"\u0000\u0000\u059b\u0584\u0001\u0000\u0000\u0000\u059b\u0592\u0001\u0000"+
		"\u0000\u0000\u059c\u00e1\u0001\u0000\u0000\u0000\u059d\u059e\u0006q\uffff"+
		"\uffff\u0000\u059e\u059f\u0005p\u0000\u0000\u059f\u05a0\u0003\u00e2q\u0000"+
		"\u05a0\u05a1\u0005q\u0000\u0000\u05a1\u05ae\u0001\u0000\u0000\u0000\u05a2"+
		"\u05a3\u0003\n\u0005\u0000\u05a3\u05a4\u0003\u00f8|\u0000\u05a4\u05a5"+
		"\u0003h4\u0000\u05a5\u05aa\u0003\u0094J\u0000\u05a6\u05a7\u0005V\u0000"+
		"\u0000\u05a7\u05a9\u0003\u00d6k\u0000\u05a8\u05a6\u0001\u0000\u0000\u0000"+
		"\u05a9\u05ac\u0001\u0000\u0000\u0000\u05aa\u05a8\u0001\u0000\u0000\u0000"+
		"\u05aa\u05ab\u0001\u0000\u0000\u0000\u05ab\u05ae\u0001\u0000\u0000\u0000"+
		"\u05ac\u05aa\u0001\u0000\u0000\u0000\u05ad\u059d\u0001\u0000\u0000\u0000"+
		"\u05ad\u05a2\u0001\u0000\u0000\u0000\u05ae\u05b4\u0001\u0000\u0000\u0000"+
		"\u05af\u05b0\n\u0001\u0000\u0000\u05b0\u05b1\u0005V\u0000\u0000\u05b1"+
		"\u05b3\u0003\u00d6k\u0000\u05b2\u05af\u0001\u0000\u0000\u0000\u05b3\u05b6"+
		"\u0001\u0000\u0000\u0000\u05b4\u05b2\u0001\u0000\u0000\u0000\u05b4\u05b5"+
		"\u0001\u0000\u0000\u0000\u05b5\u00e3\u0001\u0000\u0000\u0000\u05b6\u05b4"+
		"\u0001\u0000\u0000\u0000\u05b7\u05b8\u0003J%\u0000\u05b8\u05b9\u0005x"+
		"\u0000\u0000\u05b9\u05bb\u0001\u0000\u0000\u0000\u05ba\u05b7\u0001\u0000"+
		"\u0000\u0000\u05ba\u05bb\u0001\u0000\u0000\u0000\u05bb\u05bc\u0001\u0000"+
		"\u0000\u0000\u05bc\u05bd\u0003h4\u0000\u05bd\u05bf\u0003\u0094J\u0000"+
		"\u05be\u05c0\u0003\u00fc~\u0000\u05bf\u05be\u0001\u0000\u0000\u0000\u05bf"+
		"\u05c0\u0001\u0000\u0000\u0000\u05c0\u00e5\u0001\u0000\u0000\u0000\u05c1"+
		"\u05c3\u0003\u00f4z\u0000\u05c2\u05c1\u0001\u0000\u0000\u0000\u05c2\u05c3"+
		"\u0001\u0000\u0000\u0000\u05c3\u05c4\u0001\u0000\u0000\u0000\u05c4\u05c5"+
		"\u0003\u00e8t\u0000\u05c5\u05c6\u0003\u00eew\u0000\u05c6\u05cb\u0001\u0000"+
		"\u0000\u0000\u05c7\u05c8\u0003\u00e8t\u0000\u05c8\u05c9\u0003\u00ecv\u0000"+
		"\u05c9\u05cb\u0001\u0000\u0000\u0000\u05ca\u05c2\u0001\u0000\u0000\u0000"+
		"\u05ca\u05c7\u0001\u0000\u0000\u0000\u05cb\u00e7\u0001\u0000\u0000\u0000"+
		"\u05cc\u05ce\u0003\u0094J\u0000\u05cd\u05cf\u0003\u00f2y\u0000\u05ce\u05cd"+
		"\u0001\u0000\u0000\u0000\u05ce\u05cf\u0001\u0000\u0000\u0000\u05cf\u05d7"+
		"\u0001\u0000\u0000\u0000\u05d0\u05d1\u0005x\u0000\u0000\u05d1\u05d3\u0003"+
		"\u0094J\u0000\u05d2\u05d4\u0003\u00f2y\u0000\u05d3\u05d2\u0001\u0000\u0000"+
		"\u0000\u05d3\u05d4\u0001\u0000\u0000\u0000\u05d4\u05d6\u0001\u0000\u0000"+
		"\u0000\u05d5\u05d0\u0001\u0000\u0000\u0000\u05d6\u05d9\u0001\u0000\u0000"+
		"\u0000\u05d7\u05d5\u0001\u0000\u0000\u0000\u05d7\u05d8\u0001\u0000\u0000"+
		"\u0000\u05d8\u05dc\u0001\u0000\u0000\u0000\u05d9\u05d7\u0001\u0000\u0000"+
		"\u0000\u05da\u05dc\u0003\u00fa}\u0000\u05db\u05cc\u0001\u0000\u0000\u0000"+
		"\u05db\u05da\u0001\u0000\u0000\u0000\u05dc\u00e9\u0001\u0000\u0000\u0000"+
		"\u05dd\u05e1\u0003\u0094J\u0000\u05de\u05df\u0005Q\u0000\u0000\u05df\u05e2"+
		"\u0005P\u0000\u0000\u05e0\u05e2\u0003\u00f4z\u0000\u05e1\u05de\u0001\u0000"+
		"\u0000\u0000\u05e1\u05e0\u0001\u0000\u0000\u0000\u05e1\u05e2\u0001\u0000"+
		"\u0000\u0000\u05e2\u05e3\u0001\u0000\u0000\u0000\u05e3\u05e4\u0003\u00ee"+
		"w\u0000\u05e4\u00eb\u0001\u0000\u0000\u0000\u05e5\u05e6\u0005t\u0000\u0000"+
		"\u05e6\u05e8\u0005u\u0000\u0000\u05e7\u05e5\u0001\u0000\u0000\u0000\u05e8"+
		"\u05e9\u0001\u0000\u0000\u0000\u05e9\u05e7\u0001\u0000\u0000\u0000\u05e9"+
		"\u05ea\u0001\u0000\u0000\u0000\u05ea\u05eb\u0001\u0000\u0000\u0000\u05eb"+
		"\u05fc\u0003H$\u0000\u05ec\u05ed\u0005t\u0000\u0000\u05ed\u05ee\u0003"+
		"\u00d6k\u0000\u05ee\u05ef\u0005u\u0000\u0000\u05ef\u05f1\u0001\u0000\u0000"+
		"\u0000\u05f0\u05ec\u0001\u0000\u0000\u0000\u05f1\u05f2\u0001\u0000\u0000"+
		"\u0000\u05f2\u05f0\u0001\u0000\u0000\u0000\u05f2\u05f3\u0001\u0000\u0000"+
		"\u0000\u05f3\u05f8\u0001\u0000\u0000\u0000\u05f4\u05f5\u0005t\u0000\u0000"+
		"\u05f5\u05f7\u0005u\u0000\u0000\u05f6\u05f4\u0001\u0000\u0000\u0000\u05f7"+
		"\u05fa\u0001\u0000\u0000\u0000\u05f8\u05f6\u0001\u0000\u0000\u0000\u05f8"+
		"\u05f9\u0001\u0000\u0000\u0000\u05f9\u05fc\u0001\u0000\u0000\u0000\u05fa"+
		"\u05f8\u0001\u0000\u0000\u0000\u05fb\u05e7\u0001\u0000\u0000\u0000\u05fb"+
		"\u05f0\u0001\u0000\u0000\u0000\u05fc\u00ed\u0001\u0000\u0000\u0000\u05fd"+
		"\u05ff\u0003\u0102\u0081\u0000\u05fe\u0600\u0003\u0018\f\u0000\u05ff\u05fe"+
		"\u0001\u0000\u0000\u0000\u05ff\u0600\u0001\u0000\u0000\u0000\u0600\u00ef"+
		"\u0001\u0000\u0000\u0000\u0601\u0602\u0003\u00f4z\u0000\u0602\u0603\u0003"+
		"\u0100\u0080\u0000\u0603\u00f1\u0001\u0000\u0000\u0000\u0604\u0605\u0005"+
		"Q\u0000\u0000\u0605\u0608\u0005P\u0000\u0000\u0606\u0608\u0003\u00fc~"+
		"\u0000\u0607\u0604\u0001\u0000\u0000\u0000\u0607\u0606\u0001\u0000\u0000"+
		"\u0000\u0608\u00f3\u0001\u0000\u0000\u0000\u0609\u060a\u0005Q\u0000\u0000"+
		"\u060a\u060b\u0003\u00f6{\u0000\u060b\u060c\u0005P\u0000\u0000\u060c\u00f5"+
		"\u0001\u0000\u0000\u0000\u060d\u0612\u0003\u00f8|\u0000\u060e\u060f\u0005"+
		"w\u0000\u0000\u060f\u0611\u0003\u00f8|\u0000\u0610\u060e\u0001\u0000\u0000"+
		"\u0000\u0611\u0614\u0001\u0000\u0000\u0000\u0612\u0610\u0001\u0000\u0000"+
		"\u0000\u0612\u0613\u0001\u0000\u0000\u0000\u0613\u00f7\u0001\u0000\u0000"+
		"\u0000\u0614\u0612\u0001\u0000\u0000\u0000\u0615\u0618\u0003h4\u0000\u0616"+
		"\u0619\u0003J%\u0000\u0617\u0619\u0003\u00fa}\u0000\u0618\u0616\u0001"+
		"\u0000\u0000\u0000\u0618\u0617\u0001\u0000\u0000\u0000\u0619\u0620\u0001"+
		"\u0000\u0000\u0000\u061a\u061b\u0003h4\u0000\u061b\u061c\u0005t\u0000"+
		"\u0000\u061c\u061d\u0005u\u0000\u0000\u061d\u061f\u0001\u0000\u0000\u0000"+
		"\u061e\u061a\u0001\u0000\u0000\u0000\u061f\u0622\u0001\u0000\u0000\u0000"+
		"\u0620\u061e\u0001\u0000\u0000\u0000\u0620\u0621\u0001\u0000\u0000\u0000"+
		"\u0621\u00f9\u0001\u0000\u0000\u0000\u0622\u0620\u0001\u0000\u0000\u0000"+
		"\u0623\u0624\u0007\u000e\u0000\u0000\u0624\u00fb\u0001\u0000\u0000\u0000"+
		"\u0625\u0626\u0005Q\u0000\u0000\u0626\u062b\u0003L&\u0000\u0627\u0628"+
		"\u0005w\u0000\u0000\u0628\u062a\u0003L&\u0000\u0629\u0627\u0001\u0000"+
		"\u0000\u0000\u062a\u062d\u0001\u0000\u0000\u0000\u062b\u0629\u0001\u0000"+
		"\u0000\u0000\u062b\u062c\u0001\u0000\u0000\u0000\u062c\u062e\u0001\u0000"+
		"\u0000\u0000\u062d\u062b\u0001\u0000\u0000\u0000\u062e\u062f\u0005P\u0000"+
		"\u0000\u062f\u00fd\u0001\u0000\u0000\u0000\u0630\u063a\u0003\u0102\u0081"+
		"\u0000\u0631\u0633\u0005x\u0000\u0000\u0632\u0634\u0003\u00fc~\u0000\u0633"+
		"\u0632\u0001\u0000\u0000\u0000\u0633\u0634\u0001\u0000\u0000\u0000\u0634"+
		"\u0635\u0001\u0000\u0000\u0000\u0635\u0637\u0003\u0094J\u0000\u0636\u0638"+
		"\u0003\u0102\u0081\u0000\u0637\u0636\u0001\u0000\u0000\u0000\u0637\u0638"+
		"\u0001\u0000\u0000\u0000\u0638\u063a\u0001\u0000\u0000\u0000\u0639\u0630"+
		"\u0001\u0000\u0000\u0000\u0639\u0631\u0001\u0000\u0000\u0000\u063a\u00ff"+
		"\u0001\u0000\u0000\u0000\u063b\u063c\u0005,\u0000\u0000\u063c\u0641\u0003"+
		"\u00fe\u007f\u0000\u063d\u063e\u0003\u0094J\u0000\u063e\u063f\u0003\u0102"+
		"\u0081\u0000\u063f\u0641\u0001\u0000\u0000\u0000\u0640\u063b\u0001\u0000"+
		"\u0000\u0000\u0640\u063d\u0001\u0000\u0000\u0000\u0641\u0101\u0001\u0000"+
		"\u0000\u0000\u0642\u0644\u0005p\u0000\u0000\u0643\u0645\u0003\u00d2i\u0000"+
		"\u0644\u0643\u0001\u0000\u0000\u0000\u0644\u0645\u0001\u0000\u0000\u0000"+
		"\u0645\u0646\u0001\u0000\u0000\u0000\u0646\u0647\u0005q\u0000\u0000\u0647"+
		"\u0103\u0001\u0000\u0000\u0000\u00c0\u0105\u0108\u010d\u0110\u0113\u0118"+
		"\u011b\u0120\u0125\u012b\u0130\u0139\u013e\u0152\u0154\u015d\u0164\u0168"+
		"\u016c\u0170\u0175\u0179\u017d\u0182\u0187\u018d\u0197\u019d\u01a0\u01a6"+
		"\u01a9\u01b0\u01b8\u01bc\u01c4\u01cf\u01d6\u01de\u01e4\u01e7\u01ef\u01f8"+
		"\u01fd\u0203\u0208\u020e\u0213\u0219\u021e\u0224\u0227\u0230\u0235\u023c"+
		"\u0242\u0245\u0250\u0255\u025e\u0268\u0273\u0279\u0280\u0285\u028d\u0291"+
		"\u0293\u0299\u029f\u02a4\u02ab\u02ad\u02b4\u02b9\u02be\u02c1\u02c3\u02cd"+
		"\u02d7\u02dc\u02df\u02f0\u02fc\u0306\u0311\u031a\u0320\u0325\u0328\u032f"+
		"\u0339\u0341\u0344\u0347\u034f\u0357\u0359\u035d\u0363\u036b\u0375\u037f"+
		"\u0387\u0395\u039b\u03a4\u03ad\u03af\u03b7\u03bd\u03c5\u03c9\u03ce\u03d2"+
		"\u03d4\u03e2\u03fc\u0402\u0425\u0428\u042b\u0433\u0437\u0443\u044d\u0453"+
		"\u046f\u0478\u0481\u048a\u0490\u0498\u049d\u04a1\u04a5\u04a9\u04ab\u04af"+
		"\u04b4\u04c3\u04c9\u04de\u04e4\u04e8\u04ed\u04fe\u0507\u0517\u0544\u054a"+
		"\u054f\u0558\u055a\u055c\u056b\u0574\u057b\u057e\u0582\u0588\u058d\u058f"+
		"\u0596\u0598\u059b\u05aa\u05ad\u05b4\u05ba\u05bf\u05c2\u05ca\u05ce\u05d3"+
		"\u05d7\u05db\u05e1\u05e9\u05f2\u05f8\u05fb\u05ff\u0607\u0612\u0618\u0620"+
		"\u062b\u0633\u0637\u0639\u0640\u0644";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}