// Generated from C:/Users/pity/IdeaProjects/code-style-transfer/src/main/antlr4/JavaParser.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class JavaParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

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
		ASSIGN=78, QUESTION=79, COLON=80, GT=81, LT=82, EQUAL=83, LE=84, GE=85, 
		NOTEQUAL=86, AND=87, OR=88, ADD=89, SUB=90, MUL=91, DIV=92, BITAND=93, 
		BITOR=94, CARET=95, MOD=96, ADD_ASSIGN=97, SUB_ASSIGN=98, MUL_ASSIGN=99, 
		DIV_ASSIGN=100, AND_ASSIGN=101, OR_ASSIGN=102, XOR_ASSIGN=103, MOD_ASSIGN=104, 
		LSHIFT_ASSIGN=105, RSHIFT_ASSIGN=106, URSHIFT_ASSIGN=107, TILDE=108, BANG=109, 
		INC=110, DEC=111, LPAREN=112, RPAREN=113, LBRACE=114, RBRACE=115, LBRACK=116, 
		RBRACK=117, SEMI=118, COMMA=119, DOT=120, HWS=121, VWS=122, BLOCK_COMMENT=123, 
		LINE_COMMENT=124, IDENTIFIER=125, ARROW=126, COLONCOLON=127, AT=128, ELLIPSIS=129;
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
			null, null, null, null, null, "'null'", "'='", "'?'", null, "'>'", "'<'", 
			"'=='", "'<='", "'>='", "'!='", "'&&'", "'||'", "'+'", "'-'", "'*'", 
			"'/'", "'&'", "'|'", "'^'", "'%'", "'+='", "'-='", "'*='", "'/='", "'&='", 
			"'|='", "'^='", "'%='", "'<<='", "'>>='", "'>>>='", "'~'", "'!'", "'++'", 
			"'--'", "'('", "')'", "'{'", "'}'", "'['", "']'", null, "','", "'.'", 
			null, null, null, null, null, "'->'", "'::'", "'@'", "'...'"
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
			"ASSIGN", "QUESTION", "COLON", "GT", "LT", "EQUAL", "LE", "GE", "NOTEQUAL", 
			"AND", "OR", "ADD", "SUB", "MUL", "DIV", "BITAND", "BITOR", "CARET", 
			"MOD", "ADD_ASSIGN", "SUB_ASSIGN", "MUL_ASSIGN", "DIV_ASSIGN", "AND_ASSIGN", 
			"OR_ASSIGN", "XOR_ASSIGN", "MOD_ASSIGN", "LSHIFT_ASSIGN", "RSHIFT_ASSIGN", 
			"URSHIFT_ASSIGN", "TILDE", "BANG", "INC", "DEC", "LPAREN", "RPAREN", 
			"LBRACE", "RBRACE", "LBRACK", "RBRACK", "SEMI", "COMMA", "DOT", "HWS", 
			"VWS", "BLOCK_COMMENT", "LINE_COMMENT", "IDENTIFIER", "ARROW", "COLONCOLON", 
			"AT", "ELLIPSIS"
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
	public static class CompilationUnitContext extends org.example.parser.java.antlr.myExtends.ExtendContext {
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
	public static class ImportDeclarationListContext extends org.example.parser.java.antlr.myExtends.ExtendContext {
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
	public static class TypeDeclarationListContext extends org.example.parser.java.antlr.myExtends.ExtendContext {
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
	public static class PackageDeclarationContext extends org.example.parser.java.antlr.myExtends.ExtendContext {
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
	public static class ImportDeclarationContext extends org.example.parser.java.antlr.myExtends.ExtendContext {
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
	public static class ModifierListContext extends org.example.parser.java.antlr.myExtends.ExtendContext {
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
	public static class TypeDeclarationContext extends org.example.parser.java.antlr.myExtends.ExtendContext {
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
	public static class ClassHeadContext extends org.example.parser.java.antlr.myExtends.ExtendContext {
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
	public static class InterfaceHeadContext extends org.example.parser.java.antlr.myExtends.ExtendContext {
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
	public static class RecordHeadContext extends org.example.parser.java.antlr.myExtends.ExtendContext {
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
	public static class EnumHeadContext extends org.example.parser.java.antlr.myExtends.ExtendContext {
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
	public static class AnnotationTypeHeadContext extends org.example.parser.java.antlr.myExtends.ExtendContext {
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
	public static class BodyContext extends org.example.parser.java.antlr.myExtends.ExtendContext {
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
				while (((((_la - 1)) & ~0x3f) == 0 && ((1L << (_la - 1)) & -255308517604865L) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & -8060880383039635453L) != 0)) {
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
					while (((((_la - 1)) & ~0x3f) == 0 && ((1L << (_la - 1)) & -255308517604865L) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & -8060880383039635453L) != 0)) {
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
	public static class TypeParametersContext extends org.example.parser.java.antlr.myExtends.ExtendContext {
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
	public static class TypeParameterContext extends org.example.parser.java.antlr.myExtends.ExtendContext {
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
	public static class TypeBoundContext extends org.example.parser.java.antlr.myExtends.ExtendContext {
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
	public static class EnumConstantsContext extends org.example.parser.java.antlr.myExtends.ExtendContext {
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
	public static class EnumConstantContext extends org.example.parser.java.antlr.myExtends.ExtendContext {
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
	public static class ClassBodyDeclarationContext extends org.example.parser.java.antlr.myExtends.ExtendContext {
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
	public static class InitializerContext extends org.example.parser.java.antlr.myExtends.ExtendContext {
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TerminalNode STATIC() { return getToken(JavaParser.STATIC, 0); }
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
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(498);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==STATIC) {
				{
				setState(497);
				match(STATIC);
				}
			}

			setState(500);
			block();
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
	public static class InitializerListContext extends org.example.parser.java.antlr.myExtends.ExtendContext {
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
			setState(509); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(502);
					initializer();
					setState(506);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,42,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(503);
							match(SEMI);
							}
							} 
						}
						setState(508);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,42,_ctx);
					}
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(511); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,43,_ctx);
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
	public static class FieldDeclarationListContext extends org.example.parser.java.antlr.myExtends.ExtendContext {
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
			setState(520); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(513);
					fieldDeclaration();
					setState(517);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,44,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(514);
							match(SEMI);
							}
							} 
						}
						setState(519);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,44,_ctx);
					}
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(522); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,45,_ctx);
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
	public static class ConstructorDeclarationListContext extends org.example.parser.java.antlr.myExtends.ExtendContext {
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
			setState(531); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(524);
					constructorDeclaration();
					setState(528);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,46,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(525);
							match(SEMI);
							}
							} 
						}
						setState(530);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,46,_ctx);
					}
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(533); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,47,_ctx);
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
	public static class MethodDeclarationListContext extends org.example.parser.java.antlr.myExtends.ExtendContext {
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
			setState(542); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(535);
					methodDeclaration();
					setState(539);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,48,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(536);
							match(SEMI);
							}
							} 
						}
						setState(541);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,48,_ctx);
					}
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(544); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,49,_ctx);
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
	public static class MethodDeclarationContext extends org.example.parser.java.antlr.myExtends.ExtendContext {
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
			setState(546);
			modifierList();
			setState(547);
			methodHead();
			setState(550);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SEMI:
				{
				setState(548);
				match(SEMI);
				}
				break;
			case LBRACE:
				{
				setState(549);
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
	public static class MethodHeadContext extends org.example.parser.java.antlr.myExtends.ExtendContext {
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
			setState(553);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LT) {
				{
				setState(552);
				typeParameters();
				}
			}

			setState(555);
			typeType();
			setState(556);
			identifier();
			setState(557);
			formalParameters();
			setState(562);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LBRACK) {
				{
				{
				setState(558);
				match(LBRACK);
				setState(559);
				match(RBRACK);
				}
				}
				setState(564);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(567);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==THROWS) {
				{
				setState(565);
				match(THROWS);
				setState(566);
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
	public static class ConstructorDeclarationContext extends org.example.parser.java.antlr.myExtends.ExtendContext {
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
			setState(569);
			modifierList();
			setState(570);
			constructorHead();
			setState(571);
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
	public static class ConstructorHeadContext extends org.example.parser.java.antlr.myExtends.ExtendContext {
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
			setState(583);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,56,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(574);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LT) {
					{
					setState(573);
					typeParameters();
					}
				}

				setState(576);
				identifier();
				setState(577);
				formalParameters();
				setState(580);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==THROWS) {
					{
					setState(578);
					match(THROWS);
					setState(579);
					qualifiedNameList();
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(582);
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
	public static class FieldDeclarationContext extends org.example.parser.java.antlr.myExtends.ExtendContext {
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
			setState(585);
			modifierList();
			setState(586);
			typeType();
			setState(587);
			variableDeclarators();
			setState(588);
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
	public static class ConstDeclarationListContext extends org.example.parser.java.antlr.myExtends.ExtendContext {
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
			setState(597); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(590);
				constDeclaration();
				setState(594);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==SEMI) {
					{
					{
					setState(591);
					match(SEMI);
					}
					}
					setState(596);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				setState(599); 
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
	public static class ConstDeclarationContext extends org.example.parser.java.antlr.myExtends.ExtendContext {
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
			setState(601);
			modifierList();
			setState(602);
			typeType();
			setState(603);
			constantDeclarator();
			setState(608);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(604);
				match(COMMA);
				setState(605);
				constantDeclarator();
				}
				}
				setState(610);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(611);
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
	public static class ConstantDeclaratorContext extends org.example.parser.java.antlr.myExtends.ExtendContext {
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
			setState(613);
			identifier();
			setState(618);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LBRACK) {
				{
				{
				setState(614);
				match(LBRACK);
				setState(615);
				match(RBRACK);
				}
				}
				setState(620);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(621);
			match(ASSIGN);
			setState(622);
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
	public static class VariableDeclaratorsContext extends org.example.parser.java.antlr.myExtends.ExtendContext {
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
			setState(624);
			variableDeclarator();
			setState(629);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(625);
				match(COMMA);
				setState(626);
				variableDeclarator();
				}
				}
				setState(631);
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
	public static class VariableDeclaratorContext extends org.example.parser.java.antlr.myExtends.ExtendContext {
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
			setState(632);
			variableDeclaratorId();
			setState(635);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ASSIGN) {
				{
				setState(633);
				match(ASSIGN);
				setState(634);
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
	public static class VariableDeclaratorIdContext extends org.example.parser.java.antlr.myExtends.ExtendContext {
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
			setState(637);
			identifier();
			setState(642);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LBRACK) {
				{
				{
				setState(638);
				match(LBRACK);
				setState(639);
				match(RBRACK);
				}
				}
				setState(644);
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
	public static class VariableInitializerContext extends org.example.parser.java.antlr.myExtends.ExtendContext {
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
			setState(647);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LBRACE:
				enterOuterAlt(_localctx, 1);
				{
				setState(645);
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
				setState(646);
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
	public static class ArrayInitializerContext extends org.example.parser.java.antlr.myExtends.ExtendContext {
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
			setState(649);
			match(LBRACE);
			setState(661);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 1)) & ~0x3f) == 0 && ((1L << (_la - 1)) & -1081850722221569L) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & -8069614903360348163L) != 0)) {
				{
				setState(650);
				variableInitializer();
				setState(655);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,65,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(651);
						match(COMMA);
						setState(652);
						variableInitializer();
						}
						} 
					}
					setState(657);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,65,_ctx);
				}
				setState(659);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(658);
					match(COMMA);
					}
				}

				}
			}

			setState(663);
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
	public static class ClassOrInterfaceTypeContext extends org.example.parser.java.antlr.myExtends.ExtendContext {
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
			setState(673);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,69,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(665);
					identifier();
					setState(667);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==LT) {
						{
						setState(666);
						typeArguments();
						}
					}

					setState(669);
					match(DOT);
					}
					} 
				}
				setState(675);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,69,_ctx);
			}
			setState(676);
			typeIdentifier();
			setState(678);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,70,_ctx) ) {
			case 1:
				{
				setState(677);
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
	public static class TypeArgumentContext extends org.example.parser.java.antlr.myExtends.ExtendContext {
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
			setState(687);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,72,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(680);
				typeType();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(681);
				annotationList();
				setState(682);
				match(QUESTION);
				setState(685);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==EXTENDS || _la==SUPER) {
					{
					setState(683);
					_la = _input.LA(1);
					if ( !(_la==EXTENDS || _la==SUPER) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(684);
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
	public static class QualifiedNameListContext extends org.example.parser.java.antlr.myExtends.ExtendContext {
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
			setState(689);
			qualifiedName();
			setState(694);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(690);
				match(COMMA);
				setState(691);
				qualifiedName();
				}
				}
				setState(696);
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
	public static class FormalParametersContext extends org.example.parser.java.antlr.myExtends.ExtendContext {
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
			setState(697);
			match(LPAREN);
			setState(709);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,77,_ctx) ) {
			case 1:
				{
				setState(699);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 1)) & ~0x3f) == 0 && ((1L << (_la - 1)) & -1125899906842113L) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & -8070450532247928831L) != 0)) {
					{
					setState(698);
					receiverParameter();
					}
				}

				}
				break;
			case 2:
				{
				setState(701);
				receiverParameter();
				setState(704);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(702);
					match(COMMA);
					setState(703);
					formalParameterList();
					}
				}

				}
				break;
			case 3:
				{
				setState(707);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 1)) & ~0x3f) == 0 && ((1L << (_la - 1)) & -255325999463937L) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & -8070450532247928829L) != 0)) {
					{
					setState(706);
					formalParameterList();
					}
				}

				}
				break;
			}
			setState(711);
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
	public static class ReceiverParameterContext extends org.example.parser.java.antlr.myExtends.ExtendContext {
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
			setState(713);
			typeType();
			setState(719);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -2251799813685248L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 2305843009213693955L) != 0)) {
				{
				{
				setState(714);
				identifier();
				setState(715);
				match(DOT);
				}
				}
				setState(721);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(722);
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
	public static class FormalParameterListContext extends org.example.parser.java.antlr.myExtends.ExtendContext {
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
			setState(737);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,81,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(724);
				formalParameter();
				setState(729);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,79,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(725);
						match(COMMA);
						setState(726);
						formalParameter();
						}
						} 
					}
					setState(731);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,79,_ctx);
				}
				setState(734);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(732);
					match(COMMA);
					setState(733);
					lastFormalParameter();
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(736);
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
	public static class FormalParameterContext extends org.example.parser.java.antlr.myExtends.ExtendContext {
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
			setState(739);
			modifierList();
			setState(740);
			typeType();
			setState(741);
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
	public static class LastFormalParameterContext extends org.example.parser.java.antlr.myExtends.ExtendContext {
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
			setState(743);
			modifierList();
			setState(744);
			typeType();
			setState(745);
			annotationList();
			setState(746);
			match(ELLIPSIS);
			setState(747);
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
	public static class LambdaLVTIListContext extends org.example.parser.java.antlr.myExtends.ExtendContext {
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
			setState(749);
			lambdaLVTIParameter();
			setState(754);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(750);
				match(COMMA);
				setState(751);
				lambdaLVTIParameter();
				}
				}
				setState(756);
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
	public static class LambdaLVTIParameterContext extends org.example.parser.java.antlr.myExtends.ExtendContext {
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
			setState(757);
			modifierList();
			setState(758);
			match(VAR);
			setState(759);
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
	public static class QualifiedNameContext extends org.example.parser.java.antlr.myExtends.ExtendContext {
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
			setState(761);
			identifier();
			setState(766);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,83,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(762);
					match(DOT);
					setState(763);
					identifier();
					}
					} 
				}
				setState(768);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,83,_ctx);
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
	public static class LiteralContext extends org.example.parser.java.antlr.myExtends.ExtendContext {
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
			setState(776);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DECIMAL_LITERAL:
			case HEX_LITERAL:
			case OCT_LITERAL:
			case BINARY_LITERAL:
				enterOuterAlt(_localctx, 1);
				{
				setState(769);
				integerLiteral();
				}
				break;
			case FLOAT_LITERAL:
			case HEX_FLOAT_LITERAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(770);
				floatLiteral();
				}
				break;
			case CHAR_LITERAL:
				enterOuterAlt(_localctx, 3);
				{
				setState(771);
				match(CHAR_LITERAL);
				}
				break;
			case STRING_LITERAL:
				enterOuterAlt(_localctx, 4);
				{
				setState(772);
				match(STRING_LITERAL);
				}
				break;
			case BOOL_LITERAL:
				enterOuterAlt(_localctx, 5);
				{
				setState(773);
				match(BOOL_LITERAL);
				}
				break;
			case NULL_LITERAL:
				enterOuterAlt(_localctx, 6);
				{
				setState(774);
				match(NULL_LITERAL);
				}
				break;
			case TEXT_BLOCK:
				enterOuterAlt(_localctx, 7);
				{
				setState(775);
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
	public static class IntegerLiteralContext extends org.example.parser.java.antlr.myExtends.ExtendContext {
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
			setState(778);
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
	public static class FloatLiteralContext extends org.example.parser.java.antlr.myExtends.ExtendContext {
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
			setState(780);
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
	public static class AltAnnotationQualifiedNameContext extends org.example.parser.java.antlr.myExtends.ExtendContext {
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
			setState(787);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -2251799813685248L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 2305843009213693955L) != 0)) {
				{
				{
				setState(782);
				identifier();
				setState(783);
				match(DOT);
				}
				}
				setState(789);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(790);
			match(AT);
			setState(791);
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
	public static class AnnotationListContext extends org.example.parser.java.antlr.myExtends.ExtendContext {
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
			setState(796);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,86,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(793);
					annotation();
					}
					} 
				}
				setState(798);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,86,_ctx);
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
	public static class AnnotationContext extends org.example.parser.java.antlr.myExtends.ExtendContext {
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
			setState(802);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,87,_ctx) ) {
			case 1:
				{
				setState(799);
				match(AT);
				setState(800);
				qualifiedName();
				}
				break;
			case 2:
				{
				setState(801);
				altAnnotationQualifiedName();
				}
				break;
			}
			setState(810);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LPAREN) {
				{
				setState(804);
				match(LPAREN);
				setState(807);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,88,_ctx) ) {
				case 1:
					{
					setState(805);
					elementValuePairs();
					}
					break;
				case 2:
					{
					setState(806);
					elementValue();
					}
					break;
				}
				setState(809);
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
	public static class ElementValuePairsContext extends org.example.parser.java.antlr.myExtends.ExtendContext {
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
			setState(812);
			elementValuePair();
			setState(817);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(813);
				match(COMMA);
				setState(814);
				elementValuePair();
				}
				}
				setState(819);
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
	public static class ElementValuePairContext extends org.example.parser.java.antlr.myExtends.ExtendContext {
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
			setState(820);
			identifier();
			setState(821);
			match(ASSIGN);
			setState(822);
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
	public static class ElementValueContext extends org.example.parser.java.antlr.myExtends.ExtendContext {
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
			setState(827);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,91,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(824);
				expression(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(825);
				annotation();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(826);
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
	public static class ElementValueArrayInitializerContext extends org.example.parser.java.antlr.myExtends.ExtendContext {
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
			setState(829);
			match(LBRACE);
			setState(838);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 1)) & ~0x3f) == 0 && ((1L << (_la - 1)) & -1081850722221569L) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & -8069614903360348163L) != 0)) {
				{
				setState(830);
				elementValue();
				setState(835);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,92,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(831);
						match(COMMA);
						setState(832);
						elementValue();
						}
						} 
					}
					setState(837);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,92,_ctx);
				}
				}
			}

			setState(841);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(840);
				match(COMMA);
				}
			}

			setState(843);
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
	public static class AnnotationTypeElementDeclarationContext extends org.example.parser.java.antlr.myExtends.ExtendContext {
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
			setState(849);
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
				setState(845);
				modifierList();
				setState(846);
				annotationTypeElementRest();
				}
				break;
			case SEMI:
				enterOuterAlt(_localctx, 2);
				{
				setState(848);
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
	public static class AnnotationTypeElementRestContext extends org.example.parser.java.antlr.myExtends.ExtendContext {
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
			setState(859);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,97,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(851);
				typeType();
				setState(852);
				annotationMethodOrConstantRest();
				setState(853);
				match(SEMI);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(855);
				typeDeclaration();
				setState(857);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,96,_ctx) ) {
				case 1:
					{
					setState(856);
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
	public static class AnnotationMethodOrConstantRestContext extends org.example.parser.java.antlr.myExtends.ExtendContext {
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
			setState(863);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,98,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(861);
				annotationMethodRest();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(862);
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
	public static class AnnotationMethodRestContext extends org.example.parser.java.antlr.myExtends.ExtendContext {
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
			setState(865);
			identifier();
			setState(866);
			match(LPAREN);
			setState(867);
			match(RPAREN);
			setState(869);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DEFAULT) {
				{
				setState(868);
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
	public static class AnnotationConstantRestContext extends org.example.parser.java.antlr.myExtends.ExtendContext {
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
			setState(871);
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
	public static class DefaultValueContext extends org.example.parser.java.antlr.myExtends.ExtendContext {
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
			setState(873);
			match(DEFAULT);
			setState(874);
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
	public static class ModuleDeclarationContext extends org.example.parser.java.antlr.myExtends.ExtendContext {
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
			setState(877);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OPEN) {
				{
				setState(876);
				match(OPEN);
				}
			}

			setState(879);
			match(MODULE);
			setState(880);
			qualifiedName();
			setState(881);
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
	public static class ModuleDirectiveContext extends org.example.parser.java.antlr.myExtends.ExtendContext {
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
			setState(919);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case REQUIRES:
				enterOuterAlt(_localctx, 1);
				{
				setState(883);
				match(REQUIRES);
				setState(887);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,101,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(884);
						requiresModifier();
						}
						} 
					}
					setState(889);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,101,_ctx);
				}
				setState(890);
				qualifiedName();
				setState(891);
				match(SEMI);
				}
				break;
			case EXPORTS:
				enterOuterAlt(_localctx, 2);
				{
				setState(893);
				match(EXPORTS);
				setState(894);
				qualifiedName();
				setState(897);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==TO) {
					{
					setState(895);
					match(TO);
					setState(896);
					qualifiedName();
					}
				}

				setState(899);
				match(SEMI);
				}
				break;
			case OPENS:
				enterOuterAlt(_localctx, 3);
				{
				setState(901);
				match(OPENS);
				setState(902);
				qualifiedName();
				setState(905);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==TO) {
					{
					setState(903);
					match(TO);
					setState(904);
					qualifiedName();
					}
				}

				setState(907);
				match(SEMI);
				}
				break;
			case USES:
				enterOuterAlt(_localctx, 4);
				{
				setState(909);
				match(USES);
				setState(910);
				qualifiedName();
				setState(911);
				match(SEMI);
				}
				break;
			case PROVIDES:
				enterOuterAlt(_localctx, 5);
				{
				setState(913);
				match(PROVIDES);
				setState(914);
				qualifiedName();
				setState(915);
				match(WITH);
				setState(916);
				qualifiedName();
				setState(917);
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
	public static class RequiresModifierContext extends org.example.parser.java.antlr.myExtends.ExtendContext {
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
			setState(921);
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
	public static class RecordHeaderContext extends org.example.parser.java.antlr.myExtends.ExtendContext {
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
			setState(923);
			match(LPAREN);
			setState(925);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 1)) & ~0x3f) == 0 && ((1L << (_la - 1)) & -1125899906842113L) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & -8070450532247928831L) != 0)) {
				{
				setState(924);
				recordComponentList();
				}
			}

			setState(927);
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
	public static class RecordComponentListContext extends org.example.parser.java.antlr.myExtends.ExtendContext {
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
			setState(929);
			recordComponent();
			setState(934);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(930);
				match(COMMA);
				setState(931);
				recordComponent();
				}
				}
				setState(936);
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
	public static class RecordComponentContext extends org.example.parser.java.antlr.myExtends.ExtendContext {
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
			setState(937);
			typeType();
			setState(938);
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
	public static class BlockContext extends org.example.parser.java.antlr.myExtends.ExtendContext {
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
			setState(971);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,112,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(940);
				match(LBRACE);
				setState(945);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (((((_la - 1)) & ~0x3f) == 0 && ((1L << (_la - 1)) & -140890564991489L) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & -8060607704105607169L) != 0)) {
					{
					setState(943);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,107,_ctx) ) {
					case 1:
						{
						setState(941);
						typeDeclaration();
						}
						break;
					case 2:
						{
						setState(942);
						statement();
						}
						break;
					}
					}
					setState(947);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(948);
				match(RBRACE);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(949);
				match(LBRACE);
				setState(953);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,109,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(950);
						switchBlockStatementGroup();
						}
						} 
					}
					setState(955);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,109,_ctx);
				}
				setState(959);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==CASE || _la==DEFAULT) {
					{
					{
					setState(956);
					switchLabel();
					}
					}
					setState(961);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(962);
				match(RBRACE);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(963);
				match(LBRACE);
				setState(967);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==CASE || _la==DEFAULT) {
					{
					{
					setState(964);
					switchLabeledRule();
					}
					}
					setState(969);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(970);
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
	public static class SwitchBlockStatementGroupContext extends org.example.parser.java.antlr.myExtends.ExtendContext {
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
			setState(974); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(973);
					switchLabel();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(976); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,113,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(980); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					setState(980);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,114,_ctx) ) {
					case 1:
						{
						setState(978);
						typeDeclaration();
						}
						break;
					case 2:
						{
						setState(979);
						statement();
						}
						break;
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(982); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,115,_ctx);
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
	public static class LocalVariableDeclarationStmtContext extends org.example.parser.java.antlr.myExtends.ExtendContext {
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
			setState(984);
			localVariableDeclaration();
			setState(985);
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
	public static class LocalVariableDeclarationContext extends org.example.parser.java.antlr.myExtends.ExtendContext {
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
			setState(987);
			modifierList();
			setState(996);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,116,_ctx) ) {
			case 1:
				{
				setState(988);
				match(VAR);
				setState(989);
				identifier();
				setState(990);
				match(ASSIGN);
				setState(991);
				expression(0);
				}
				break;
			case 2:
				{
				setState(993);
				typeType();
				setState(994);
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
	public static class IdentifierContext extends org.example.parser.java.antlr.myExtends.ExtendContext {
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
			setState(998);
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
	public static class TypeIdentifierContext extends org.example.parser.java.antlr.myExtends.ExtendContext {
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
			setState(1000);
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
	public static class StatementContext extends org.example.parser.java.antlr.myExtends.ExtendContext {
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
			setState(1022);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,117,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1002);
				((StatementContext)_localctx).blockLabel = block();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1003);
				localVariableDeclarationStmt();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1004);
				assertStmt();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1005);
				ifStmt();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(1006);
				ifElseStmt();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(1007);
				forStmt();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(1008);
				whileStmt();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(1009);
				doWhileStmt();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(1010);
				tryCatchStmt();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(1011);
				tryResourceStmt();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(1012);
				switchStmt();
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(1013);
				syncStmt();
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(1014);
				returnStmt();
				}
				break;
			case 14:
				enterOuterAlt(_localctx, 14);
				{
				setState(1015);
				throwStmt();
				}
				break;
			case 15:
				enterOuterAlt(_localctx, 15);
				{
				setState(1016);
				breakStmt();
				}
				break;
			case 16:
				enterOuterAlt(_localctx, 16);
				{
				setState(1017);
				continueStmt();
				}
				break;
			case 17:
				enterOuterAlt(_localctx, 17);
				{
				setState(1018);
				yieldStmt();
				}
				break;
			case 18:
				enterOuterAlt(_localctx, 18);
				{
				setState(1019);
				match(SEMI);
				}
				break;
			case 19:
				enterOuterAlt(_localctx, 19);
				{
				setState(1020);
				expressionStmt();
				}
				break;
			case 20:
				enterOuterAlt(_localctx, 20);
				{
				setState(1021);
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
	public static class AssertStmtContext extends org.example.parser.java.antlr.myExtends.ExtendContext {
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
			setState(1024);
			match(ASSERT);
			setState(1025);
			expression(0);
			setState(1028);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COLON) {
				{
				setState(1026);
				match(COLON);
				setState(1027);
				expression(0);
				}
			}

			setState(1030);
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
	public static class IfStmtContext extends org.example.parser.java.antlr.myExtends.ExtendContext {
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
			setState(1032);
			match(IF);
			setState(1033);
			parExpression();
			setState(1034);
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
	public static class IfElseStmtContext extends org.example.parser.java.antlr.myExtends.ExtendContext {
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
			setState(1036);
			match(IF);
			setState(1037);
			parExpression();
			setState(1038);
			statement();
			setState(1039);
			match(ELSE);
			setState(1040);
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
	public static class ForStmtContext extends org.example.parser.java.antlr.myExtends.ExtendContext {
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
			setState(1042);
			match(FOR);
			setState(1043);
			match(LPAREN);
			setState(1044);
			forControl();
			setState(1045);
			match(RPAREN);
			setState(1046);
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
	public static class WhileStmtContext extends org.example.parser.java.antlr.myExtends.ExtendContext {
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
			setState(1048);
			match(WHILE);
			setState(1049);
			parExpression();
			setState(1050);
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
	public static class DoWhileStmtContext extends org.example.parser.java.antlr.myExtends.ExtendContext {
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
			setState(1052);
			match(DO);
			setState(1053);
			statement();
			setState(1054);
			match(WHILE);
			setState(1055);
			parExpression();
			setState(1056);
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
	public static class TryCatchStmtContext extends org.example.parser.java.antlr.myExtends.ExtendContext {
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
			setState(1058);
			match(TRY);
			setState(1059);
			block();
			setState(1069);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CATCH:
				{
				setState(1061); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(1060);
					catchClause();
					}
					}
					setState(1063); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==CATCH );
				setState(1066);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==FINALLY) {
					{
					setState(1065);
					finallyBlock();
					}
				}

				}
				break;
			case FINALLY:
				{
				setState(1068);
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
	public static class TryResourceStmtContext extends org.example.parser.java.antlr.myExtends.ExtendContext {
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
			setState(1071);
			match(TRY);
			setState(1072);
			resourceSpecification();
			setState(1073);
			block();
			setState(1077);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==CATCH) {
				{
				{
				setState(1074);
				catchClause();
				}
				}
				setState(1079);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1081);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==FINALLY) {
				{
				setState(1080);
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
	public static class SwitchStmtContext extends org.example.parser.java.antlr.myExtends.ExtendContext {
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
			setState(1083);
			match(SWITCH);
			setState(1084);
			parExpression();
			setState(1085);
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
	public static class SyncStmtContext extends org.example.parser.java.antlr.myExtends.ExtendContext {
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
			setState(1087);
			match(SYNCHRONIZED);
			setState(1088);
			parExpression();
			setState(1089);
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
	public static class ReturnStmtContext extends org.example.parser.java.antlr.myExtends.ExtendContext {
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
			setState(1091);
			match(RETURN);
			setState(1093);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 1)) & ~0x3f) == 0 && ((1L << (_la - 1)) & -1081850722221569L) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & -8070177853313769475L) != 0)) {
				{
				setState(1092);
				expression(0);
				}
			}

			setState(1095);
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
	public static class ThrowStmtContext extends org.example.parser.java.antlr.myExtends.ExtendContext {
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
			setState(1097);
			match(THROW);
			setState(1098);
			expression(0);
			setState(1099);
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
	public static class BreakStmtContext extends org.example.parser.java.antlr.myExtends.ExtendContext {
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
			setState(1101);
			match(BREAK);
			setState(1103);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & -2251799813685248L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 2305843009213693955L) != 0)) {
				{
				setState(1102);
				identifier();
				}
			}

			setState(1105);
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
	public static class ContinueStmtContext extends org.example.parser.java.antlr.myExtends.ExtendContext {
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
			setState(1107);
			match(CONTINUE);
			setState(1109);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & -2251799813685248L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 2305843009213693955L) != 0)) {
				{
				setState(1108);
				identifier();
				}
			}

			setState(1111);
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
	public static class YieldStmtContext extends org.example.parser.java.antlr.myExtends.ExtendContext {
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
			setState(1113);
			match(YIELD);
			setState(1114);
			expression(0);
			setState(1115);
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
	public static class ExpressionStmtContext extends org.example.parser.java.antlr.myExtends.ExtendContext {
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
			setState(1117);
			((ExpressionStmtContext)_localctx).statementExpression = expression(0);
			setState(1118);
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
	public static class LabelStmtContext extends org.example.parser.java.antlr.myExtends.ExtendContext {
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
			setState(1120);
			((LabelStmtContext)_localctx).identifierLabel = identifier();
			setState(1121);
			match(COLON);
			setState(1122);
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
	public static class CatchClauseContext extends org.example.parser.java.antlr.myExtends.ExtendContext {
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
			setState(1124);
			match(CATCH);
			setState(1125);
			match(LPAREN);
			setState(1126);
			modifierList();
			setState(1127);
			catchType();
			setState(1128);
			identifier();
			setState(1129);
			match(RPAREN);
			setState(1130);
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
	public static class CatchTypeContext extends org.example.parser.java.antlr.myExtends.ExtendContext {
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
			setState(1132);
			qualifiedName();
			setState(1137);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==BITOR) {
				{
				{
				setState(1133);
				match(BITOR);
				setState(1134);
				qualifiedName();
				}
				}
				setState(1139);
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
	public static class FinallyBlockContext extends org.example.parser.java.antlr.myExtends.ExtendContext {
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
			setState(1140);
			match(FINALLY);
			setState(1141);
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
	public static class ResourceSpecificationContext extends org.example.parser.java.antlr.myExtends.ExtendContext {
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
			setState(1143);
			match(LPAREN);
			setState(1144);
			resources();
			setState(1146);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SEMI) {
				{
				setState(1145);
				match(SEMI);
				}
			}

			setState(1148);
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
	public static class ResourcesContext extends org.example.parser.java.antlr.myExtends.ExtendContext {
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
			setState(1150);
			resource();
			setState(1155);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,129,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1151);
					match(SEMI);
					setState(1152);
					resource();
					}
					} 
				}
				setState(1157);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,129,_ctx);
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
	public static class ResourceContext extends org.example.parser.java.antlr.myExtends.ExtendContext {
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
			setState(1170);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,131,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1158);
				modifierList();
				setState(1164);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,130,_ctx) ) {
				case 1:
					{
					setState(1159);
					classOrInterfaceType();
					setState(1160);
					variableDeclaratorId();
					}
					break;
				case 2:
					{
					setState(1162);
					match(VAR);
					setState(1163);
					identifier();
					}
					break;
				}
				setState(1166);
				match(ASSIGN);
				setState(1167);
				expression(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1169);
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
	public static class SwitchLabelContext extends org.example.parser.java.antlr.myExtends.ExtendContext {
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
			setState(1183);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CASE:
				enterOuterAlt(_localctx, 1);
				{
				setState(1172);
				match(CASE);
				setState(1178);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,132,_ctx) ) {
				case 1:
					{
					setState(1173);
					((SwitchLabelContext)_localctx).constantExpression = expression(0);
					}
					break;
				case 2:
					{
					setState(1174);
					((SwitchLabelContext)_localctx).enumConstantName = match(IDENTIFIER);
					}
					break;
				case 3:
					{
					setState(1175);
					typeType();
					setState(1176);
					((SwitchLabelContext)_localctx).varName = identifier();
					}
					break;
				}
				setState(1180);
				match(COLON);
				}
				break;
			case DEFAULT:
				enterOuterAlt(_localctx, 2);
				{
				setState(1181);
				match(DEFAULT);
				setState(1182);
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
	public static class ForControlContext extends org.example.parser.java.antlr.myExtends.ExtendContext {
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
			setState(1197);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,137,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1185);
				enhancedForControl();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1187);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 1)) & ~0x3f) == 0 && ((1L << (_la - 1)) & -211276814843393L) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & -8070177853313769473L) != 0)) {
					{
					setState(1186);
					forInit();
					}
				}

				setState(1189);
				match(SEMI);
				setState(1191);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 1)) & ~0x3f) == 0 && ((1L << (_la - 1)) & -1081850722221569L) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & -8070177853313769475L) != 0)) {
					{
					setState(1190);
					expression(0);
					}
				}

				setState(1193);
				match(SEMI);
				setState(1195);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 1)) & ~0x3f) == 0 && ((1L << (_la - 1)) & -1081850722221569L) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & -8070177853313769475L) != 0)) {
					{
					setState(1194);
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
	public static class ForInitContext extends org.example.parser.java.antlr.myExtends.ExtendContext {
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
			setState(1201);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,138,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1199);
				localVariableDeclaration();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1200);
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
	public static class EnhancedForControlContext extends org.example.parser.java.antlr.myExtends.ExtendContext {
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
			setState(1203);
			modifierList();
			setState(1206);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,139,_ctx) ) {
			case 1:
				{
				setState(1204);
				typeType();
				}
				break;
			case 2:
				{
				setState(1205);
				match(VAR);
				}
				break;
			}
			setState(1208);
			variableDeclaratorId();
			setState(1209);
			match(COLON);
			setState(1210);
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
	public static class ParExpressionContext extends org.example.parser.java.antlr.myExtends.ExtendContext {
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
			setState(1212);
			match(LPAREN);
			setState(1213);
			expression(0);
			setState(1214);
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
	public static class ExpressionListContext extends org.example.parser.java.antlr.myExtends.ExtendContext {
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
			setState(1216);
			expression(0);
			setState(1221);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(1217);
				match(COMMA);
				setState(1218);
				expression(0);
				}
				}
				setState(1223);
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
	public static class MethodCallContext extends org.example.parser.java.antlr.myExtends.ExtendContext {
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
			setState(1227);
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
				setState(1224);
				identifier();
				}
				break;
			case THIS:
				{
				setState(1225);
				match(THIS);
				}
				break;
			case SUPER:
				{
				setState(1226);
				match(SUPER);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(1229);
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
	public static class ExpressionContext extends org.example.parser.java.antlr.myExtends.ExtendContext {
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
			setState(1289);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,147,_ctx) ) {
			case 1:
				{
				setState(1232);
				match(LPAREN);
				setState(1233);
				expression(0);
				setState(1234);
				match(RPAREN);
				}
				break;
			case 2:
				{
				setState(1236);
				match(THIS);
				}
				break;
			case 3:
				{
				setState(1237);
				match(SUPER);
				}
				break;
			case 4:
				{
				setState(1238);
				literal();
				}
				break;
			case 5:
				{
				setState(1239);
				identifier();
				}
				break;
			case 6:
				{
				setState(1240);
				typeType();
				setState(1241);
				match(DOT);
				setState(1242);
				match(CLASS);
				}
				break;
			case 7:
				{
				setState(1244);
				nonWildcardTypeArguments();
				setState(1248);
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
					setState(1245);
					explicitGenericInvocationSuffix();
					}
					break;
				case THIS:
					{
					setState(1246);
					match(THIS);
					setState(1247);
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
				setState(1250);
				methodCall();
				}
				break;
			case 9:
				{
				setState(1251);
				typeType();
				setState(1252);
				match(COLONCOLON);
				setState(1258);
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
					setState(1254);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==LT) {
						{
						setState(1253);
						typeArguments();
						}
					}

					setState(1256);
					identifier();
					}
					break;
				case NEW:
					{
					setState(1257);
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
				setState(1260);
				classType();
				setState(1261);
				match(COLONCOLON);
				setState(1263);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LT) {
					{
					setState(1262);
					typeArguments();
					}
				}

				setState(1265);
				match(NEW);
				}
				break;
			case 11:
				{
				setState(1267);
				match(SWITCH);
				setState(1268);
				parExpression();
				setState(1269);
				block();
				}
				break;
			case 12:
				{
				setState(1271);
				((ExpressionContext)_localctx).prefix = _input.LT(1);
				_la = _input.LA(1);
				if ( !(((((_la - 89)) & ~0x3f) == 0 && ((1L << (_la - 89)) & 7864323L) != 0)) ) {
					((ExpressionContext)_localctx).prefix = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(1272);
				expression(17);
				}
				break;
			case 13:
				{
				setState(1273);
				match(LPAREN);
				setState(1274);
				annotationList();
				setState(1275);
				typeType();
				setState(1280);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==BITAND) {
					{
					{
					setState(1276);
					match(BITAND);
					setState(1277);
					typeType();
					}
					}
					setState(1282);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1283);
				match(RPAREN);
				setState(1284);
				expression(16);
				}
				break;
			case 14:
				{
				setState(1286);
				match(NEW);
				setState(1287);
				creator();
				}
				break;
			case 15:
				{
				setState(1288);
				lambdaExpression();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(1374);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,154,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(1372);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,153,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1291);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(1292);
						((ExpressionContext)_localctx).bop = _input.LT(1);
						_la = _input.LA(1);
						if ( !(((((_la - 91)) & ~0x3f) == 0 && ((1L << (_la - 91)) & 35L) != 0)) ) {
							((ExpressionContext)_localctx).bop = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(1293);
						expression(15);
						}
						break;
					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1294);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(1295);
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
						setState(1296);
						expression(14);
						}
						break;
					case 3:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1297);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(1305);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,148,_ctx) ) {
						case 1:
							{
							setState(1298);
							match(LT);
							setState(1299);
							match(LT);
							}
							break;
						case 2:
							{
							setState(1300);
							match(GT);
							setState(1301);
							match(GT);
							setState(1302);
							match(GT);
							}
							break;
						case 3:
							{
							setState(1303);
							match(GT);
							setState(1304);
							match(GT);
							}
							break;
						}
						setState(1307);
						expression(13);
						}
						break;
					case 4:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1308);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(1309);
						((ExpressionContext)_localctx).bop = _input.LT(1);
						_la = _input.LA(1);
						if ( !(((((_la - 81)) & ~0x3f) == 0 && ((1L << (_la - 81)) & 27L) != 0)) ) {
							((ExpressionContext)_localctx).bop = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(1310);
						expression(12);
						}
						break;
					case 5:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1311);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(1312);
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
						setState(1313);
						expression(10);
						}
						break;
					case 6:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1314);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(1315);
						((ExpressionContext)_localctx).bop = match(BITAND);
						setState(1316);
						expression(9);
						}
						break;
					case 7:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1317);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(1318);
						((ExpressionContext)_localctx).bop = match(CARET);
						setState(1319);
						expression(8);
						}
						break;
					case 8:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1320);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(1321);
						((ExpressionContext)_localctx).bop = match(BITOR);
						setState(1322);
						expression(7);
						}
						break;
					case 9:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1323);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(1324);
						((ExpressionContext)_localctx).bop = match(AND);
						setState(1325);
						expression(6);
						}
						break;
					case 10:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1326);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(1327);
						((ExpressionContext)_localctx).bop = match(OR);
						setState(1328);
						expression(5);
						}
						break;
					case 11:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1329);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(1330);
						((ExpressionContext)_localctx).bop = match(QUESTION);
						setState(1331);
						expression(0);
						setState(1332);
						match(COLON);
						setState(1333);
						expression(3);
						}
						break;
					case 12:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1335);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(1336);
						((ExpressionContext)_localctx).bop = _input.LT(1);
						_la = _input.LA(1);
						if ( !(((((_la - 78)) & ~0x3f) == 0 && ((1L << (_la - 78)) & 1073217537L) != 0)) ) {
							((ExpressionContext)_localctx).bop = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(1337);
						expression(2);
						}
						break;
					case 13:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1338);
						if (!(precpred(_ctx, 25))) throw new FailedPredicateException(this, "precpred(_ctx, 25)");
						setState(1339);
						match(LBRACK);
						setState(1340);
						expression(0);
						setState(1341);
						match(RBRACK);
						}
						break;
					case 14:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1343);
						if (!(precpred(_ctx, 24))) throw new FailedPredicateException(this, "precpred(_ctx, 24)");
						setState(1344);
						((ExpressionContext)_localctx).bop = match(DOT);
						setState(1356);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,150,_ctx) ) {
						case 1:
							{
							setState(1345);
							identifier();
							}
							break;
						case 2:
							{
							setState(1346);
							methodCall();
							}
							break;
						case 3:
							{
							setState(1347);
							match(THIS);
							}
							break;
						case 4:
							{
							setState(1348);
							match(NEW);
							setState(1350);
							_errHandler.sync(this);
							_la = _input.LA(1);
							if (_la==LT) {
								{
								setState(1349);
								nonWildcardTypeArguments();
								}
							}

							setState(1352);
							innerCreator();
							}
							break;
						case 5:
							{
							setState(1353);
							match(SUPER);
							setState(1354);
							superSuffix();
							}
							break;
						case 6:
							{
							setState(1355);
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
						setState(1358);
						if (!(precpred(_ctx, 22))) throw new FailedPredicateException(this, "precpred(_ctx, 22)");
						setState(1359);
						match(COLONCOLON);
						setState(1361);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==LT) {
							{
							setState(1360);
							typeArguments();
							}
						}

						setState(1363);
						identifier();
						}
						break;
					case 16:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1364);
						if (!(precpred(_ctx, 18))) throw new FailedPredicateException(this, "precpred(_ctx, 18)");
						setState(1365);
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
						setState(1366);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(1367);
						((ExpressionContext)_localctx).bop = match(INSTANCEOF);
						setState(1370);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,152,_ctx) ) {
						case 1:
							{
							setState(1368);
							typeType();
							}
							break;
						case 2:
							{
							setState(1369);
							pattern();
							}
							break;
						}
						}
						break;
					}
					} 
				}
				setState(1376);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,154,_ctx);
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
	public static class PatternContext extends org.example.parser.java.antlr.myExtends.ExtendContext {
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
			setState(1377);
			modifierList();
			setState(1378);
			typeType();
			setState(1379);
			annotationList();
			setState(1380);
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
	public static class LambdaExpressionContext extends org.example.parser.java.antlr.myExtends.ExtendContext {
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
			setState(1382);
			lambdaParameters();
			setState(1383);
			match(ARROW);
			setState(1384);
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
	public static class LambdaParametersContext extends org.example.parser.java.antlr.myExtends.ExtendContext {
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
			setState(1408);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,158,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1386);
				identifier();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1387);
				match(LPAREN);
				setState(1389);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 1)) & ~0x3f) == 0 && ((1L << (_la - 1)) & -255325999463937L) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & -8070450532247928829L) != 0)) {
					{
					setState(1388);
					formalParameterList();
					}
				}

				setState(1391);
				match(RPAREN);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1392);
				match(LPAREN);
				setState(1393);
				identifier();
				setState(1398);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(1394);
					match(COMMA);
					setState(1395);
					identifier();
					}
					}
					setState(1400);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1401);
				match(RPAREN);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1403);
				match(LPAREN);
				setState(1405);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 24)) & ~0x3f) == 0 && ((1L << (_la - 24)) & 8796062584977L) != 0) || _la==IDENTIFIER || _la==AT) {
					{
					setState(1404);
					lambdaLVTIList();
					}
				}

				setState(1407);
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
	public static class LambdaBodyContext extends org.example.parser.java.antlr.myExtends.ExtendContext {
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
			setState(1412);
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
				setState(1410);
				expression(0);
				}
				break;
			case LBRACE:
				enterOuterAlt(_localctx, 2);
				{
				setState(1411);
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
	public static class SwitchLabeledRuleContext extends org.example.parser.java.antlr.myExtends.ExtendContext {
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
			setState(1437);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CASE:
				enterOuterAlt(_localctx, 1);
				{
				setState(1414);
				match(CASE);
				setState(1418);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,160,_ctx) ) {
				case 1:
					{
					setState(1415);
					expressionList();
					}
					break;
				case 2:
					{
					setState(1416);
					match(NULL_LITERAL);
					}
					break;
				case 3:
					{
					setState(1417);
					guardedPattern(0);
					}
					break;
				}
				setState(1420);
				_la = _input.LA(1);
				if ( !(_la==COLON || _la==ARROW) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(1425);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,162,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						setState(1423);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,161,_ctx) ) {
						case 1:
							{
							setState(1421);
							typeDeclaration();
							}
							break;
						case 2:
							{
							setState(1422);
							statement();
							}
							break;
						}
						} 
					}
					setState(1427);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,162,_ctx);
				}
				}
				break;
			case DEFAULT:
				enterOuterAlt(_localctx, 2);
				{
				setState(1428);
				match(DEFAULT);
				setState(1429);
				_la = _input.LA(1);
				if ( !(_la==COLON || _la==ARROW) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(1434);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,164,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						setState(1432);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,163,_ctx) ) {
						case 1:
							{
							setState(1430);
							typeDeclaration();
							}
							break;
						case 2:
							{
							setState(1431);
							statement();
							}
							break;
						}
						} 
					}
					setState(1436);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,164,_ctx);
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
	public static class GuardedPatternContext extends org.example.parser.java.antlr.myExtends.ExtendContext {
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
			setState(1455);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LPAREN:
				{
				setState(1440);
				match(LPAREN);
				setState(1441);
				guardedPattern(0);
				setState(1442);
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
				setState(1444);
				modifierList();
				setState(1445);
				typeType();
				setState(1446);
				annotationList();
				setState(1447);
				identifier();
				setState(1452);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,166,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(1448);
						match(AND);
						setState(1449);
						expression(0);
						}
						} 
					}
					setState(1454);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,166,_ctx);
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(1462);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,168,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new GuardedPatternContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_guardedPattern);
					setState(1457);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(1458);
					match(AND);
					setState(1459);
					expression(0);
					}
					} 
				}
				setState(1464);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,168,_ctx);
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
	public static class ClassTypeContext extends org.example.parser.java.antlr.myExtends.ExtendContext {
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
			setState(1468);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,169,_ctx) ) {
			case 1:
				{
				setState(1465);
				classOrInterfaceType();
				setState(1466);
				match(DOT);
				}
				break;
			}
			setState(1470);
			annotationList();
			setState(1471);
			identifier();
			setState(1473);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LT) {
				{
				setState(1472);
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
	public static class CreatorContext extends org.example.parser.java.antlr.myExtends.ExtendContext {
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
			setState(1484);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,172,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1476);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LT) {
					{
					setState(1475);
					nonWildcardTypeArguments();
					}
				}

				setState(1478);
				createdName();
				setState(1479);
				classCreatorRest();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1481);
				createdName();
				setState(1482);
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
	public static class CreatedNameContext extends org.example.parser.java.antlr.myExtends.ExtendContext {
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
			setState(1501);
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
				setState(1486);
				identifier();
				setState(1488);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LT) {
					{
					setState(1487);
					typeArgumentsOrDiamond();
					}
				}

				setState(1497);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==DOT) {
					{
					{
					setState(1490);
					match(DOT);
					setState(1491);
					identifier();
					setState(1493);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==LT) {
						{
						setState(1492);
						typeArgumentsOrDiamond();
						}
					}

					}
					}
					setState(1499);
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
				setState(1500);
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
	public static class InnerCreatorContext extends org.example.parser.java.antlr.myExtends.ExtendContext {
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
			setState(1503);
			identifier();
			setState(1507);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,177,_ctx) ) {
			case 1:
				{
				setState(1504);
				match(LT);
				setState(1505);
				match(GT);
				}
				break;
			case 2:
				{
				setState(1506);
				nonWildcardTypeArguments();
				}
				break;
			}
			setState(1509);
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
	public static class ArrayCreatorRestContext extends org.example.parser.java.antlr.myExtends.ExtendContext {
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
			setState(1533);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,181,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1513); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(1511);
					match(LBRACK);
					setState(1512);
					match(RBRACK);
					}
					}
					setState(1515); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==LBRACK );
				setState(1517);
				arrayInitializer();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1522); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(1518);
						match(LBRACK);
						setState(1519);
						expression(0);
						setState(1520);
						match(RBRACK);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(1524); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,179,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(1530);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,180,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(1526);
						match(LBRACK);
						setState(1527);
						match(RBRACK);
						}
						} 
					}
					setState(1532);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,180,_ctx);
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
	public static class ClassCreatorRestContext extends org.example.parser.java.antlr.myExtends.ExtendContext {
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
			setState(1535);
			arguments();
			setState(1537);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,182,_ctx) ) {
			case 1:
				{
				setState(1536);
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
	public static class ExplicitGenericInvocationContext extends org.example.parser.java.antlr.myExtends.ExtendContext {
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
			setState(1539);
			nonWildcardTypeArguments();
			setState(1540);
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
	public static class TypeArgumentsOrDiamondContext extends org.example.parser.java.antlr.myExtends.ExtendContext {
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
			setState(1545);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,183,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1542);
				match(LT);
				setState(1543);
				match(GT);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1544);
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
	public static class NonWildcardTypeArgumentsContext extends org.example.parser.java.antlr.myExtends.ExtendContext {
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
			setState(1547);
			match(LT);
			setState(1548);
			typeList();
			setState(1549);
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
	public static class TypeListContext extends org.example.parser.java.antlr.myExtends.ExtendContext {
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
			setState(1551);
			typeType();
			setState(1556);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(1552);
				match(COMMA);
				setState(1553);
				typeType();
				}
				}
				setState(1558);
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
	public static class TypeTypeContext extends org.example.parser.java.antlr.myExtends.ExtendContext {
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
			setState(1559);
			annotationList();
			setState(1562);
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
				setState(1560);
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
				setState(1561);
				primitiveType();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(1570);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,186,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1564);
					annotationList();
					setState(1565);
					match(LBRACK);
					setState(1566);
					match(RBRACK);
					}
					} 
				}
				setState(1572);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,186,_ctx);
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
	public static class PrimitiveTypeContext extends org.example.parser.java.antlr.myExtends.ExtendContext {
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
			setState(1573);
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
	public static class TypeArgumentsContext extends org.example.parser.java.antlr.myExtends.ExtendContext {
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
			setState(1575);
			match(LT);
			setState(1576);
			typeArgument();
			setState(1581);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(1577);
				match(COMMA);
				setState(1578);
				typeArgument();
				}
				}
				setState(1583);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1584);
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
	public static class SuperSuffixContext extends org.example.parser.java.antlr.myExtends.ExtendContext {
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
			setState(1595);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LPAREN:
				enterOuterAlt(_localctx, 1);
				{
				setState(1586);
				arguments();
				}
				break;
			case DOT:
				enterOuterAlt(_localctx, 2);
				{
				setState(1587);
				match(DOT);
				setState(1589);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LT) {
					{
					setState(1588);
					typeArguments();
					}
				}

				setState(1591);
				identifier();
				setState(1593);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,189,_ctx) ) {
				case 1:
					{
					setState(1592);
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
	public static class ExplicitGenericInvocationSuffixContext extends org.example.parser.java.antlr.myExtends.ExtendContext {
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
			setState(1602);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SUPER:
				enterOuterAlt(_localctx, 1);
				{
				setState(1597);
				match(SUPER);
				setState(1598);
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
				setState(1599);
				identifier();
				setState(1600);
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
	public static class ArgumentsContext extends org.example.parser.java.antlr.myExtends.ExtendContext {
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
			setState(1604);
			match(LPAREN);
			setState(1606);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 1)) & ~0x3f) == 0 && ((1L << (_la - 1)) & -1081850722221569L) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & -8070177853313769475L) != 0)) {
				{
				setState(1605);
				expressionList();
				}
			}

			setState(1608);
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
		"\u0004\u0001\u0081\u064b\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
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
		"\u0012\u0003\u0012\u01f0\b\u0012\u0001\u0013\u0003\u0013\u01f3\b\u0013"+
		"\u0001\u0013\u0001\u0013\u0001\u0014\u0001\u0014\u0005\u0014\u01f9\b\u0014"+
		"\n\u0014\f\u0014\u01fc\t\u0014\u0004\u0014\u01fe\b\u0014\u000b\u0014\f"+
		"\u0014\u01ff\u0001\u0015\u0001\u0015\u0005\u0015\u0204\b\u0015\n\u0015"+
		"\f\u0015\u0207\t\u0015\u0004\u0015\u0209\b\u0015\u000b\u0015\f\u0015\u020a"+
		"\u0001\u0016\u0001\u0016\u0005\u0016\u020f\b\u0016\n\u0016\f\u0016\u0212"+
		"\t\u0016\u0004\u0016\u0214\b\u0016\u000b\u0016\f\u0016\u0215\u0001\u0017"+
		"\u0001\u0017\u0005\u0017\u021a\b\u0017\n\u0017\f\u0017\u021d\t\u0017\u0004"+
		"\u0017\u021f\b\u0017\u000b\u0017\f\u0017\u0220\u0001\u0018\u0001\u0018"+
		"\u0001\u0018\u0001\u0018\u0003\u0018\u0227\b\u0018\u0001\u0019\u0003\u0019"+
		"\u022a\b\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019"+
		"\u0005\u0019\u0231\b\u0019\n\u0019\f\u0019\u0234\t\u0019\u0001\u0019\u0001"+
		"\u0019\u0003\u0019\u0238\b\u0019\u0001\u001a\u0001\u001a\u0001\u001a\u0001"+
		"\u001a\u0001\u001b\u0003\u001b\u023f\b\u001b\u0001\u001b\u0001\u001b\u0001"+
		"\u001b\u0001\u001b\u0003\u001b\u0245\b\u001b\u0001\u001b\u0003\u001b\u0248"+
		"\b\u001b\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001"+
		"\u001d\u0001\u001d\u0005\u001d\u0251\b\u001d\n\u001d\f\u001d\u0254\t\u001d"+
		"\u0004\u001d\u0256\b\u001d\u000b\u001d\f\u001d\u0257\u0001\u001e\u0001"+
		"\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0005\u001e\u025f\b\u001e\n"+
		"\u001e\f\u001e\u0262\t\u001e\u0001\u001e\u0001\u001e\u0001\u001f\u0001"+
		"\u001f\u0001\u001f\u0005\u001f\u0269\b\u001f\n\u001f\f\u001f\u026c\t\u001f"+
		"\u0001\u001f\u0001\u001f\u0001\u001f\u0001 \u0001 \u0001 \u0005 \u0274"+
		"\b \n \f \u0277\t \u0001!\u0001!\u0001!\u0003!\u027c\b!\u0001\"\u0001"+
		"\"\u0001\"\u0005\"\u0281\b\"\n\"\f\"\u0284\t\"\u0001#\u0001#\u0003#\u0288"+
		"\b#\u0001$\u0001$\u0001$\u0001$\u0005$\u028e\b$\n$\f$\u0291\t$\u0001$"+
		"\u0003$\u0294\b$\u0003$\u0296\b$\u0001$\u0001$\u0001%\u0001%\u0003%\u029c"+
		"\b%\u0001%\u0001%\u0005%\u02a0\b%\n%\f%\u02a3\t%\u0001%\u0001%\u0003%"+
		"\u02a7\b%\u0001&\u0001&\u0001&\u0001&\u0001&\u0003&\u02ae\b&\u0003&\u02b0"+
		"\b&\u0001\'\u0001\'\u0001\'\u0005\'\u02b5\b\'\n\'\f\'\u02b8\t\'\u0001"+
		"(\u0001(\u0003(\u02bc\b(\u0001(\u0001(\u0001(\u0003(\u02c1\b(\u0001(\u0003"+
		"(\u02c4\b(\u0003(\u02c6\b(\u0001(\u0001(\u0001)\u0001)\u0001)\u0001)\u0005"+
		")\u02ce\b)\n)\f)\u02d1\t)\u0001)\u0001)\u0001*\u0001*\u0001*\u0005*\u02d8"+
		"\b*\n*\f*\u02db\t*\u0001*\u0001*\u0003*\u02df\b*\u0001*\u0003*\u02e2\b"+
		"*\u0001+\u0001+\u0001+\u0001+\u0001,\u0001,\u0001,\u0001,\u0001,\u0001"+
		",\u0001-\u0001-\u0001-\u0005-\u02f1\b-\n-\f-\u02f4\t-\u0001.\u0001.\u0001"+
		".\u0001.\u0001/\u0001/\u0001/\u0005/\u02fd\b/\n/\f/\u0300\t/\u00010\u0001"+
		"0\u00010\u00010\u00010\u00010\u00010\u00030\u0309\b0\u00011\u00011\u0001"+
		"2\u00012\u00013\u00013\u00013\u00053\u0312\b3\n3\f3\u0315\t3\u00013\u0001"+
		"3\u00013\u00014\u00054\u031b\b4\n4\f4\u031e\t4\u00015\u00015\u00015\u0003"+
		"5\u0323\b5\u00015\u00015\u00015\u00035\u0328\b5\u00015\u00035\u032b\b"+
		"5\u00016\u00016\u00016\u00056\u0330\b6\n6\f6\u0333\t6\u00017\u00017\u0001"+
		"7\u00017\u00018\u00018\u00018\u00038\u033c\b8\u00019\u00019\u00019\u0001"+
		"9\u00059\u0342\b9\n9\f9\u0345\t9\u00039\u0347\b9\u00019\u00039\u034a\b"+
		"9\u00019\u00019\u0001:\u0001:\u0001:\u0001:\u0003:\u0352\b:\u0001;\u0001"+
		";\u0001;\u0001;\u0001;\u0001;\u0003;\u035a\b;\u0003;\u035c\b;\u0001<\u0001"+
		"<\u0003<\u0360\b<\u0001=\u0001=\u0001=\u0001=\u0003=\u0366\b=\u0001>\u0001"+
		">\u0001?\u0001?\u0001?\u0001@\u0003@\u036e\b@\u0001@\u0001@\u0001@\u0001"+
		"@\u0001A\u0001A\u0005A\u0376\bA\nA\fA\u0379\tA\u0001A\u0001A\u0001A\u0001"+
		"A\u0001A\u0001A\u0001A\u0003A\u0382\bA\u0001A\u0001A\u0001A\u0001A\u0001"+
		"A\u0001A\u0003A\u038a\bA\u0001A\u0001A\u0001A\u0001A\u0001A\u0001A\u0001"+
		"A\u0001A\u0001A\u0001A\u0001A\u0001A\u0003A\u0398\bA\u0001B\u0001B\u0001"+
		"C\u0001C\u0003C\u039e\bC\u0001C\u0001C\u0001D\u0001D\u0001D\u0005D\u03a5"+
		"\bD\nD\fD\u03a8\tD\u0001E\u0001E\u0001E\u0001F\u0001F\u0001F\u0005F\u03b0"+
		"\bF\nF\fF\u03b3\tF\u0001F\u0001F\u0001F\u0005F\u03b8\bF\nF\fF\u03bb\t"+
		"F\u0001F\u0005F\u03be\bF\nF\fF\u03c1\tF\u0001F\u0001F\u0001F\u0005F\u03c6"+
		"\bF\nF\fF\u03c9\tF\u0001F\u0003F\u03cc\bF\u0001G\u0004G\u03cf\bG\u000b"+
		"G\fG\u03d0\u0001G\u0001G\u0004G\u03d5\bG\u000bG\fG\u03d6\u0001H\u0001"+
		"H\u0001H\u0001I\u0001I\u0001I\u0001I\u0001I\u0001I\u0001I\u0001I\u0001"+
		"I\u0003I\u03e5\bI\u0001J\u0001J\u0001K\u0001K\u0001L\u0001L\u0001L\u0001"+
		"L\u0001L\u0001L\u0001L\u0001L\u0001L\u0001L\u0001L\u0001L\u0001L\u0001"+
		"L\u0001L\u0001L\u0001L\u0001L\u0001L\u0001L\u0003L\u03ff\bL\u0001M\u0001"+
		"M\u0001M\u0001M\u0003M\u0405\bM\u0001M\u0001M\u0001N\u0001N\u0001N\u0001"+
		"N\u0001O\u0001O\u0001O\u0001O\u0001O\u0001O\u0001P\u0001P\u0001P\u0001"+
		"P\u0001P\u0001P\u0001Q\u0001Q\u0001Q\u0001Q\u0001R\u0001R\u0001R\u0001"+
		"R\u0001R\u0001R\u0001S\u0001S\u0001S\u0004S\u0426\bS\u000bS\fS\u0427\u0001"+
		"S\u0003S\u042b\bS\u0001S\u0003S\u042e\bS\u0001T\u0001T\u0001T\u0001T\u0005"+
		"T\u0434\bT\nT\fT\u0437\tT\u0001T\u0003T\u043a\bT\u0001U\u0001U\u0001U"+
		"\u0001U\u0001V\u0001V\u0001V\u0001V\u0001W\u0001W\u0003W\u0446\bW\u0001"+
		"W\u0001W\u0001X\u0001X\u0001X\u0001X\u0001Y\u0001Y\u0003Y\u0450\bY\u0001"+
		"Y\u0001Y\u0001Z\u0001Z\u0003Z\u0456\bZ\u0001Z\u0001Z\u0001[\u0001[\u0001"+
		"[\u0001[\u0001\\\u0001\\\u0001\\\u0001]\u0001]\u0001]\u0001]\u0001^\u0001"+
		"^\u0001^\u0001^\u0001^\u0001^\u0001^\u0001^\u0001_\u0001_\u0001_\u0005"+
		"_\u0470\b_\n_\f_\u0473\t_\u0001`\u0001`\u0001`\u0001a\u0001a\u0001a\u0003"+
		"a\u047b\ba\u0001a\u0001a\u0001b\u0001b\u0001b\u0005b\u0482\bb\nb\fb\u0485"+
		"\tb\u0001c\u0001c\u0001c\u0001c\u0001c\u0001c\u0003c\u048d\bc\u0001c\u0001"+
		"c\u0001c\u0001c\u0003c\u0493\bc\u0001d\u0001d\u0001d\u0001d\u0001d\u0001"+
		"d\u0003d\u049b\bd\u0001d\u0001d\u0001d\u0003d\u04a0\bd\u0001e\u0001e\u0003"+
		"e\u04a4\be\u0001e\u0001e\u0003e\u04a8\be\u0001e\u0001e\u0003e\u04ac\b"+
		"e\u0003e\u04ae\be\u0001f\u0001f\u0003f\u04b2\bf\u0001g\u0001g\u0001g\u0003"+
		"g\u04b7\bg\u0001g\u0001g\u0001g\u0001g\u0001h\u0001h\u0001h\u0001h\u0001"+
		"i\u0001i\u0001i\u0005i\u04c4\bi\ni\fi\u04c7\ti\u0001j\u0001j\u0001j\u0003"+
		"j\u04cc\bj\u0001j\u0001j\u0001k\u0001k\u0001k\u0001k\u0001k\u0001k\u0001"+
		"k\u0001k\u0001k\u0001k\u0001k\u0001k\u0001k\u0001k\u0001k\u0001k\u0001"+
		"k\u0003k\u04e1\bk\u0001k\u0001k\u0001k\u0001k\u0003k\u04e7\bk\u0001k\u0001"+
		"k\u0003k\u04eb\bk\u0001k\u0001k\u0001k\u0003k\u04f0\bk\u0001k\u0001k\u0001"+
		"k\u0001k\u0001k\u0001k\u0001k\u0001k\u0001k\u0001k\u0001k\u0001k\u0001"+
		"k\u0005k\u04ff\bk\nk\fk\u0502\tk\u0001k\u0001k\u0001k\u0001k\u0001k\u0001"+
		"k\u0003k\u050a\bk\u0001k\u0001k\u0001k\u0001k\u0001k\u0001k\u0001k\u0001"+
		"k\u0001k\u0001k\u0001k\u0001k\u0001k\u0001k\u0003k\u051a\bk\u0001k\u0001"+
		"k\u0001k\u0001k\u0001k\u0001k\u0001k\u0001k\u0001k\u0001k\u0001k\u0001"+
		"k\u0001k\u0001k\u0001k\u0001k\u0001k\u0001k\u0001k\u0001k\u0001k\u0001"+
		"k\u0001k\u0001k\u0001k\u0001k\u0001k\u0001k\u0001k\u0001k\u0001k\u0001"+
		"k\u0001k\u0001k\u0001k\u0001k\u0001k\u0001k\u0001k\u0001k\u0001k\u0001"+
		"k\u0001k\u0003k\u0547\bk\u0001k\u0001k\u0001k\u0001k\u0003k\u054d\bk\u0001"+
		"k\u0001k\u0001k\u0003k\u0552\bk\u0001k\u0001k\u0001k\u0001k\u0001k\u0001"+
		"k\u0001k\u0003k\u055b\bk\u0005k\u055d\bk\nk\fk\u0560\tk\u0001l\u0001l"+
		"\u0001l\u0001l\u0001l\u0001m\u0001m\u0001m\u0001m\u0001n\u0001n\u0001"+
		"n\u0003n\u056e\bn\u0001n\u0001n\u0001n\u0001n\u0001n\u0005n\u0575\bn\n"+
		"n\fn\u0578\tn\u0001n\u0001n\u0001n\u0001n\u0003n\u057e\bn\u0001n\u0003"+
		"n\u0581\bn\u0001o\u0001o\u0003o\u0585\bo\u0001p\u0001p\u0001p\u0001p\u0003"+
		"p\u058b\bp\u0001p\u0001p\u0001p\u0005p\u0590\bp\np\fp\u0593\tp\u0001p"+
		"\u0001p\u0001p\u0001p\u0005p\u0599\bp\np\fp\u059c\tp\u0003p\u059e\bp\u0001"+
		"q\u0001q\u0001q\u0001q\u0001q\u0001q\u0001q\u0001q\u0001q\u0001q\u0001"+
		"q\u0005q\u05ab\bq\nq\fq\u05ae\tq\u0003q\u05b0\bq\u0001q\u0001q\u0001q"+
		"\u0005q\u05b5\bq\nq\fq\u05b8\tq\u0001r\u0001r\u0001r\u0003r\u05bd\br\u0001"+
		"r\u0001r\u0001r\u0003r\u05c2\br\u0001s\u0003s\u05c5\bs\u0001s\u0001s\u0001"+
		"s\u0001s\u0001s\u0001s\u0003s\u05cd\bs\u0001t\u0001t\u0003t\u05d1\bt\u0001"+
		"t\u0001t\u0001t\u0003t\u05d6\bt\u0005t\u05d8\bt\nt\ft\u05db\tt\u0001t"+
		"\u0003t\u05de\bt\u0001u\u0001u\u0001u\u0001u\u0003u\u05e4\bu\u0001u\u0001"+
		"u\u0001v\u0001v\u0004v\u05ea\bv\u000bv\fv\u05eb\u0001v\u0001v\u0001v\u0001"+
		"v\u0001v\u0004v\u05f3\bv\u000bv\fv\u05f4\u0001v\u0001v\u0005v\u05f9\b"+
		"v\nv\fv\u05fc\tv\u0003v\u05fe\bv\u0001w\u0001w\u0003w\u0602\bw\u0001x"+
		"\u0001x\u0001x\u0001y\u0001y\u0001y\u0003y\u060a\by\u0001z\u0001z\u0001"+
		"z\u0001z\u0001{\u0001{\u0001{\u0005{\u0613\b{\n{\f{\u0616\t{\u0001|\u0001"+
		"|\u0001|\u0003|\u061b\b|\u0001|\u0001|\u0001|\u0001|\u0005|\u0621\b|\n"+
		"|\f|\u0624\t|\u0001}\u0001}\u0001~\u0001~\u0001~\u0001~\u0005~\u062c\b"+
		"~\n~\f~\u062f\t~\u0001~\u0001~\u0001\u007f\u0001\u007f\u0001\u007f\u0003"+
		"\u007f\u0636\b\u007f\u0001\u007f\u0001\u007f\u0003\u007f\u063a\b\u007f"+
		"\u0003\u007f\u063c\b\u007f\u0001\u0080\u0001\u0080\u0001\u0080\u0001\u0080"+
		"\u0001\u0080\u0003\u0080\u0643\b\u0080\u0001\u0081\u0001\u0081\u0003\u0081"+
		"\u0647\b\u0081\u0001\u0081\u0001\u0081\u0001\u0081\u0000\u0002\u00d6\u00e2"+
		"\u0082\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018"+
		"\u001a\u001c\u001e \"$&(*,.02468:<>@BDFHJLNPRTVXZ\\^`bdfhjlnprtvxz|~\u0080"+
		"\u0082\u0084\u0086\u0088\u008a\u008c\u008e\u0090\u0092\u0094\u0096\u0098"+
		"\u009a\u009c\u009e\u00a0\u00a2\u00a4\u00a6\u00a8\u00aa\u00ac\u00ae\u00b0"+
		"\u00b2\u00b4\u00b6\u00b8\u00ba\u00bc\u00be\u00c0\u00c2\u00c4\u00c6\u00c8"+
		"\u00ca\u00cc\u00ce\u00d0\u00d2\u00d4\u00d6\u00d8\u00da\u00dc\u00de\u00e0"+
		"\u00e2\u00e4\u00e6\u00e8\u00ea\u00ec\u00ee\u00f0\u00f2\u00f4\u00f6\u00f8"+
		"\u00fa\u00fc\u00fe\u0100\u0102\u0000\u000f\u0002\u0000\u001e\u001e,,\u0001"+
		"\u0000CF\u0001\u0000GH\u0002\u0000**<<\u0002\u00003A}}\u0003\u00003<?"+
		"A}}\u0002\u0000YZlo\u0002\u0000[\\``\u0001\u0000YZ\u0002\u0000QRTU\u0002"+
		"\u0000SSVV\u0002\u0000NNak\u0001\u0000no\u0002\u0000PP~~\u0001\u0000\u0001"+
		"\t\u06e5\u0000\u0120\u0001\u0000\u0000\u0000\u0002\u0123\u0001\u0000\u0000"+
		"\u0000\u0004\u012e\u0001\u0000\u0000\u0000\u0006\u0132\u0001\u0000\u0000"+
		"\u0000\b\u0137\u0001\u0000\u0000\u0000\n\u0154\u0001\u0000\u0000\u0000"+
		"\f\u0157\u0001\u0000\u0000\u0000\u000e\u0161\u0001\u0000\u0000\u0000\u0010"+
		"\u0172\u0001\u0000\u0000\u0000\u0012\u017f\u0001\u0000\u0000\u0000\u0014"+
		"\u0189\u0001\u0000\u0000\u0000\u0016\u018f\u0001\u0000\u0000\u0000\u0018"+
		"\u01bc\u0001\u0000\u0000\u0000\u001a\u01be\u0001\u0000\u0000\u0000\u001c"+
		"\u01c9\u0001\u0000\u0000\u0000\u001e\u01d1\u0001\u0000\u0000\u0000 \u01d9"+
		"\u0001\u0000\u0000\u0000\"\u01e1\u0001\u0000\u0000\u0000$\u01ef\u0001"+
		"\u0000\u0000\u0000&\u01f2\u0001\u0000\u0000\u0000(\u01fd\u0001\u0000\u0000"+
		"\u0000*\u0208\u0001\u0000\u0000\u0000,\u0213\u0001\u0000\u0000\u0000."+
		"\u021e\u0001\u0000\u0000\u00000\u0222\u0001\u0000\u0000\u00002\u0229\u0001"+
		"\u0000\u0000\u00004\u0239\u0001\u0000\u0000\u00006\u0247\u0001\u0000\u0000"+
		"\u00008\u0249\u0001\u0000\u0000\u0000:\u0255\u0001\u0000\u0000\u0000<"+
		"\u0259\u0001\u0000\u0000\u0000>\u0265\u0001\u0000\u0000\u0000@\u0270\u0001"+
		"\u0000\u0000\u0000B\u0278\u0001\u0000\u0000\u0000D\u027d\u0001\u0000\u0000"+
		"\u0000F\u0287\u0001\u0000\u0000\u0000H\u0289\u0001\u0000\u0000\u0000J"+
		"\u02a1\u0001\u0000\u0000\u0000L\u02af\u0001\u0000\u0000\u0000N\u02b1\u0001"+
		"\u0000\u0000\u0000P\u02b9\u0001\u0000\u0000\u0000R\u02c9\u0001\u0000\u0000"+
		"\u0000T\u02e1\u0001\u0000\u0000\u0000V\u02e3\u0001\u0000\u0000\u0000X"+
		"\u02e7\u0001\u0000\u0000\u0000Z\u02ed\u0001\u0000\u0000\u0000\\\u02f5"+
		"\u0001\u0000\u0000\u0000^\u02f9\u0001\u0000\u0000\u0000`\u0308\u0001\u0000"+
		"\u0000\u0000b\u030a\u0001\u0000\u0000\u0000d\u030c\u0001\u0000\u0000\u0000"+
		"f\u0313\u0001\u0000\u0000\u0000h\u031c\u0001\u0000\u0000\u0000j\u0322"+
		"\u0001\u0000\u0000\u0000l\u032c\u0001\u0000\u0000\u0000n\u0334\u0001\u0000"+
		"\u0000\u0000p\u033b\u0001\u0000\u0000\u0000r\u033d\u0001\u0000\u0000\u0000"+
		"t\u0351\u0001\u0000\u0000\u0000v\u035b\u0001\u0000\u0000\u0000x\u035f"+
		"\u0001\u0000\u0000\u0000z\u0361\u0001\u0000\u0000\u0000|\u0367\u0001\u0000"+
		"\u0000\u0000~\u0369\u0001\u0000\u0000\u0000\u0080\u036d\u0001\u0000\u0000"+
		"\u0000\u0082\u0397\u0001\u0000\u0000\u0000\u0084\u0399\u0001\u0000\u0000"+
		"\u0000\u0086\u039b\u0001\u0000\u0000\u0000\u0088\u03a1\u0001\u0000\u0000"+
		"\u0000\u008a\u03a9\u0001\u0000\u0000\u0000\u008c\u03cb\u0001\u0000\u0000"+
		"\u0000\u008e\u03ce\u0001\u0000\u0000\u0000\u0090\u03d8\u0001\u0000\u0000"+
		"\u0000\u0092\u03db\u0001\u0000\u0000\u0000\u0094\u03e6\u0001\u0000\u0000"+
		"\u0000\u0096\u03e8\u0001\u0000\u0000\u0000\u0098\u03fe\u0001\u0000\u0000"+
		"\u0000\u009a\u0400\u0001\u0000\u0000\u0000\u009c\u0408\u0001\u0000\u0000"+
		"\u0000\u009e\u040c\u0001\u0000\u0000\u0000\u00a0\u0412\u0001\u0000\u0000"+
		"\u0000\u00a2\u0418\u0001\u0000\u0000\u0000\u00a4\u041c\u0001\u0000\u0000"+
		"\u0000\u00a6\u0422\u0001\u0000\u0000\u0000\u00a8\u042f\u0001\u0000\u0000"+
		"\u0000\u00aa\u043b\u0001\u0000\u0000\u0000\u00ac\u043f\u0001\u0000\u0000"+
		"\u0000\u00ae\u0443\u0001\u0000\u0000\u0000\u00b0\u0449\u0001\u0000\u0000"+
		"\u0000\u00b2\u044d\u0001\u0000\u0000\u0000\u00b4\u0453\u0001\u0000\u0000"+
		"\u0000\u00b6\u0459\u0001\u0000\u0000\u0000\u00b8\u045d\u0001\u0000\u0000"+
		"\u0000\u00ba\u0460\u0001\u0000\u0000\u0000\u00bc\u0464\u0001\u0000\u0000"+
		"\u0000\u00be\u046c\u0001\u0000\u0000\u0000\u00c0\u0474\u0001\u0000\u0000"+
		"\u0000\u00c2\u0477\u0001\u0000\u0000\u0000\u00c4\u047e\u0001\u0000\u0000"+
		"\u0000\u00c6\u0492\u0001\u0000\u0000\u0000\u00c8\u049f\u0001\u0000\u0000"+
		"\u0000\u00ca\u04ad\u0001\u0000\u0000\u0000\u00cc\u04b1\u0001\u0000\u0000"+
		"\u0000\u00ce\u04b3\u0001\u0000\u0000\u0000\u00d0\u04bc\u0001\u0000\u0000"+
		"\u0000\u00d2\u04c0\u0001\u0000\u0000\u0000\u00d4\u04cb\u0001\u0000\u0000"+
		"\u0000\u00d6\u0509\u0001\u0000\u0000\u0000\u00d8\u0561\u0001\u0000\u0000"+
		"\u0000\u00da\u0566\u0001\u0000\u0000\u0000\u00dc\u0580\u0001\u0000\u0000"+
		"\u0000\u00de\u0584\u0001\u0000\u0000\u0000\u00e0\u059d\u0001\u0000\u0000"+
		"\u0000\u00e2\u05af\u0001\u0000\u0000\u0000\u00e4\u05bc\u0001\u0000\u0000"+
		"\u0000\u00e6\u05cc\u0001\u0000\u0000\u0000\u00e8\u05dd\u0001\u0000\u0000"+
		"\u0000\u00ea\u05df\u0001\u0000\u0000\u0000\u00ec\u05fd\u0001\u0000\u0000"+
		"\u0000\u00ee\u05ff\u0001\u0000\u0000\u0000\u00f0\u0603\u0001\u0000\u0000"+
		"\u0000\u00f2\u0609\u0001\u0000\u0000\u0000\u00f4\u060b\u0001\u0000\u0000"+
		"\u0000\u00f6\u060f\u0001\u0000\u0000\u0000\u00f8\u0617\u0001\u0000\u0000"+
		"\u0000\u00fa\u0625\u0001\u0000\u0000\u0000\u00fc\u0627\u0001\u0000\u0000"+
		"\u0000\u00fe\u063b\u0001\u0000\u0000\u0000\u0100\u0642\u0001\u0000\u0000"+
		"\u0000\u0102\u0644\u0001\u0000\u0000\u0000\u0104\u0106\u0003\u0006\u0003"+
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
		"\u013f\u0005[\u0000\u0000\u013e\u013c\u0001\u0000\u0000\u0000\u013e\u013f"+
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
		"\u0000\u0000\u0000\u01be\u01bf\u0005R\u0000\u0000\u01bf\u01c4\u0003\u001c"+
		"\u000e\u0000\u01c0\u01c1\u0005w\u0000\u0000\u01c1\u01c3\u0003\u001c\u000e"+
		"\u0000\u01c2\u01c0\u0001\u0000\u0000\u0000\u01c3\u01c6\u0001\u0000\u0000"+
		"\u0000\u01c4\u01c2\u0001\u0000\u0000\u0000\u01c4\u01c5\u0001\u0000\u0000"+
		"\u0000\u01c5\u01c7\u0001\u0000\u0000\u0000\u01c6\u01c4\u0001\u0000\u0000"+
		"\u0000\u01c7\u01c8\u0005Q\u0000\u0000\u01c8\u001b\u0001\u0000\u0000\u0000"+
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
		"\u0000\u0000\u0000\u01f1\u01f3\u0005*\u0000\u0000\u01f2\u01f1\u0001\u0000"+
		"\u0000\u0000\u01f2\u01f3\u0001\u0000\u0000\u0000\u01f3\u01f4\u0001\u0000"+
		"\u0000\u0000\u01f4\u01f5\u0003\u008cF\u0000\u01f5\'\u0001\u0000\u0000"+
		"\u0000\u01f6\u01fa\u0003&\u0013\u0000\u01f7\u01f9\u0005v\u0000\u0000\u01f8"+
		"\u01f7\u0001\u0000\u0000\u0000\u01f9\u01fc\u0001\u0000\u0000\u0000\u01fa"+
		"\u01f8\u0001\u0000\u0000\u0000\u01fa\u01fb\u0001\u0000\u0000\u0000\u01fb"+
		"\u01fe\u0001\u0000\u0000\u0000\u01fc\u01fa\u0001\u0000\u0000\u0000\u01fd"+
		"\u01f6\u0001\u0000\u0000\u0000\u01fe\u01ff\u0001\u0000\u0000\u0000\u01ff"+
		"\u01fd\u0001\u0000\u0000\u0000\u01ff\u0200\u0001\u0000\u0000\u0000\u0200"+
		")\u0001\u0000\u0000\u0000\u0201\u0205\u00038\u001c\u0000\u0202\u0204\u0005"+
		"v\u0000\u0000\u0203\u0202\u0001\u0000\u0000\u0000\u0204\u0207\u0001\u0000"+
		"\u0000\u0000\u0205\u0203\u0001\u0000\u0000\u0000\u0205\u0206\u0001\u0000"+
		"\u0000\u0000\u0206\u0209\u0001\u0000\u0000\u0000\u0207\u0205\u0001\u0000"+
		"\u0000\u0000\u0208\u0201\u0001\u0000\u0000\u0000\u0209\u020a\u0001\u0000"+
		"\u0000\u0000\u020a\u0208\u0001\u0000\u0000\u0000\u020a\u020b\u0001\u0000"+
		"\u0000\u0000\u020b+\u0001\u0000\u0000\u0000\u020c\u0210\u00034\u001a\u0000"+
		"\u020d\u020f\u0005v\u0000\u0000\u020e\u020d\u0001\u0000\u0000\u0000\u020f"+
		"\u0212\u0001\u0000\u0000\u0000\u0210\u020e\u0001\u0000\u0000\u0000\u0210"+
		"\u0211\u0001\u0000\u0000\u0000\u0211\u0214\u0001\u0000\u0000\u0000\u0212"+
		"\u0210\u0001\u0000\u0000\u0000\u0213\u020c\u0001\u0000\u0000\u0000\u0214"+
		"\u0215\u0001\u0000\u0000\u0000\u0215\u0213\u0001\u0000\u0000\u0000\u0215"+
		"\u0216\u0001\u0000\u0000\u0000\u0216-\u0001\u0000\u0000\u0000\u0217\u021b"+
		"\u00030\u0018\u0000\u0218\u021a\u0005v\u0000\u0000\u0219\u0218\u0001\u0000"+
		"\u0000\u0000\u021a\u021d\u0001\u0000\u0000\u0000\u021b\u0219\u0001\u0000"+
		"\u0000\u0000\u021b\u021c\u0001\u0000\u0000\u0000\u021c\u021f\u0001\u0000"+
		"\u0000\u0000\u021d\u021b\u0001\u0000\u0000\u0000\u021e\u0217\u0001\u0000"+
		"\u0000\u0000\u021f\u0220\u0001\u0000\u0000\u0000\u0220\u021e\u0001\u0000"+
		"\u0000\u0000\u0220\u0221\u0001\u0000\u0000\u0000\u0221/\u0001\u0000\u0000"+
		"\u0000\u0222\u0223\u0003\n\u0005\u0000\u0223\u0226\u00032\u0019\u0000"+
		"\u0224\u0227\u0005v\u0000\u0000\u0225\u0227\u0003\u008cF\u0000\u0226\u0224"+
		"\u0001\u0000\u0000\u0000\u0226\u0225\u0001\u0000\u0000\u0000\u02271\u0001"+
		"\u0000\u0000\u0000\u0228\u022a\u0003\u001a\r\u0000\u0229\u0228\u0001\u0000"+
		"\u0000\u0000\u0229\u022a\u0001\u0000\u0000\u0000\u022a\u022b\u0001\u0000"+
		"\u0000\u0000\u022b\u022c\u0003\u00f8|\u0000\u022c\u022d\u0003\u0094J\u0000"+
		"\u022d\u0232\u0003P(\u0000\u022e\u022f\u0005t\u0000\u0000\u022f\u0231"+
		"\u0005u\u0000\u0000\u0230\u022e\u0001\u0000\u0000\u0000\u0231\u0234\u0001"+
		"\u0000\u0000\u0000\u0232\u0230\u0001\u0000\u0000\u0000\u0232\u0233\u0001"+
		"\u0000\u0000\u0000\u0233\u0237\u0001\u0000\u0000\u0000\u0234\u0232\u0001"+
		"\u0000\u0000\u0000\u0235\u0236\u00050\u0000\u0000\u0236\u0238\u0003N\'"+
		"\u0000\u0237\u0235\u0001\u0000\u0000\u0000\u0237\u0238\u0001\u0000\u0000"+
		"\u0000\u02383\u0001\u0000\u0000\u0000\u0239\u023a\u0003\n\u0005\u0000"+
		"\u023a\u023b\u00036\u001b\u0000\u023b\u023c\u0003\u008cF\u0000\u023c5"+
		"\u0001\u0000\u0000\u0000\u023d\u023f\u0003\u001a\r\u0000\u023e\u023d\u0001"+
		"\u0000\u0000\u0000\u023e\u023f\u0001\u0000\u0000\u0000\u023f\u0240\u0001"+
		"\u0000\u0000\u0000\u0240\u0241\u0003\u0094J\u0000\u0241\u0244\u0003P("+
		"\u0000\u0242\u0243\u00050\u0000\u0000\u0243\u0245\u0003N\'\u0000\u0244"+
		"\u0242\u0001\u0000\u0000\u0000\u0244\u0245\u0001\u0000\u0000\u0000\u0245"+
		"\u0248\u0001\u0000\u0000\u0000\u0246\u0248\u0003\u0094J\u0000\u0247\u023e"+
		"\u0001\u0000\u0000\u0000\u0247\u0246\u0001\u0000\u0000\u0000\u02487\u0001"+
		"\u0000\u0000\u0000\u0249\u024a\u0003\n\u0005\u0000\u024a\u024b\u0003\u00f8"+
		"|\u0000\u024b\u024c\u0003@ \u0000\u024c\u024d\u0005v\u0000\u0000\u024d"+
		"9\u0001\u0000\u0000\u0000\u024e\u0252\u0003<\u001e\u0000\u024f\u0251\u0005"+
		"v\u0000\u0000\u0250\u024f\u0001\u0000\u0000\u0000\u0251\u0254\u0001\u0000"+
		"\u0000\u0000\u0252\u0250\u0001\u0000\u0000\u0000\u0252\u0253\u0001\u0000"+
		"\u0000\u0000\u0253\u0256\u0001\u0000\u0000\u0000\u0254\u0252\u0001\u0000"+
		"\u0000\u0000\u0255\u024e\u0001\u0000\u0000\u0000\u0256\u0257\u0001\u0000"+
		"\u0000\u0000\u0257\u0255\u0001\u0000\u0000\u0000\u0257\u0258\u0001\u0000"+
		"\u0000\u0000\u0258;\u0001\u0000\u0000\u0000\u0259\u025a\u0003\n\u0005"+
		"\u0000\u025a\u025b\u0003\u00f8|\u0000\u025b\u0260\u0003>\u001f\u0000\u025c"+
		"\u025d\u0005w\u0000\u0000\u025d\u025f\u0003>\u001f\u0000\u025e\u025c\u0001"+
		"\u0000\u0000\u0000\u025f\u0262\u0001\u0000\u0000\u0000\u0260\u025e\u0001"+
		"\u0000\u0000\u0000\u0260\u0261\u0001\u0000\u0000\u0000\u0261\u0263\u0001"+
		"\u0000\u0000\u0000\u0262\u0260\u0001\u0000\u0000\u0000\u0263\u0264\u0005"+
		"v\u0000\u0000\u0264=\u0001\u0000\u0000\u0000\u0265\u026a\u0003\u0094J"+
		"\u0000\u0266\u0267\u0005t\u0000\u0000\u0267\u0269\u0005u\u0000\u0000\u0268"+
		"\u0266\u0001\u0000\u0000\u0000\u0269\u026c\u0001\u0000\u0000\u0000\u026a"+
		"\u0268\u0001\u0000\u0000\u0000\u026a\u026b\u0001\u0000\u0000\u0000\u026b"+
		"\u026d\u0001\u0000\u0000\u0000\u026c\u026a\u0001\u0000\u0000\u0000\u026d"+
		"\u026e\u0005N\u0000\u0000\u026e\u026f\u0003F#\u0000\u026f?\u0001\u0000"+
		"\u0000\u0000\u0270\u0275\u0003B!\u0000\u0271\u0272\u0005w\u0000\u0000"+
		"\u0272\u0274\u0003B!\u0000\u0273\u0271\u0001\u0000\u0000\u0000\u0274\u0277"+
		"\u0001\u0000\u0000\u0000\u0275\u0273\u0001\u0000\u0000\u0000\u0275\u0276"+
		"\u0001\u0000\u0000\u0000\u0276A\u0001\u0000\u0000\u0000\u0277\u0275\u0001"+
		"\u0000\u0000\u0000\u0278\u027b\u0003D\"\u0000\u0279\u027a\u0005N\u0000"+
		"\u0000\u027a\u027c\u0003F#\u0000\u027b\u0279\u0001\u0000\u0000\u0000\u027b"+
		"\u027c\u0001\u0000\u0000\u0000\u027cC\u0001\u0000\u0000\u0000\u027d\u0282"+
		"\u0003\u0094J\u0000\u027e\u027f\u0005t\u0000\u0000\u027f\u0281\u0005u"+
		"\u0000\u0000\u0280\u027e\u0001\u0000\u0000\u0000\u0281\u0284\u0001\u0000"+
		"\u0000\u0000\u0282\u0280\u0001\u0000\u0000\u0000\u0282\u0283\u0001\u0000"+
		"\u0000\u0000\u0283E\u0001\u0000\u0000\u0000\u0284\u0282\u0001\u0000\u0000"+
		"\u0000\u0285\u0288\u0003H$\u0000\u0286\u0288\u0003\u00d6k\u0000\u0287"+
		"\u0285\u0001\u0000\u0000\u0000\u0287\u0286\u0001\u0000\u0000\u0000\u0288"+
		"G\u0001\u0000\u0000\u0000\u0289\u0295\u0005r\u0000\u0000\u028a\u028f\u0003"+
		"F#\u0000\u028b\u028c\u0005w\u0000\u0000\u028c\u028e\u0003F#\u0000\u028d"+
		"\u028b\u0001\u0000\u0000\u0000\u028e\u0291\u0001\u0000\u0000\u0000\u028f"+
		"\u028d\u0001\u0000\u0000\u0000\u028f\u0290\u0001\u0000\u0000\u0000\u0290"+
		"\u0293\u0001\u0000\u0000\u0000\u0291\u028f\u0001\u0000\u0000\u0000\u0292"+
		"\u0294\u0005w\u0000\u0000\u0293\u0292\u0001\u0000\u0000\u0000\u0293\u0294"+
		"\u0001\u0000\u0000\u0000\u0294\u0296\u0001\u0000\u0000\u0000\u0295\u028a"+
		"\u0001\u0000\u0000\u0000\u0295\u0296\u0001\u0000\u0000\u0000\u0296\u0297"+
		"\u0001\u0000\u0000\u0000\u0297\u0298\u0005s\u0000\u0000\u0298I\u0001\u0000"+
		"\u0000\u0000\u0299\u029b\u0003\u0094J\u0000\u029a\u029c\u0003\u00fc~\u0000"+
		"\u029b\u029a\u0001\u0000\u0000\u0000\u029b\u029c\u0001\u0000\u0000\u0000"+
		"\u029c\u029d\u0001\u0000\u0000\u0000\u029d\u029e\u0005x\u0000\u0000\u029e"+
		"\u02a0\u0001\u0000\u0000\u0000\u029f\u0299\u0001\u0000\u0000\u0000\u02a0"+
		"\u02a3\u0001\u0000\u0000\u0000\u02a1\u029f\u0001\u0000\u0000\u0000\u02a1"+
		"\u02a2\u0001\u0000\u0000\u0000\u02a2\u02a4\u0001\u0000\u0000\u0000\u02a3"+
		"\u02a1\u0001\u0000\u0000\u0000\u02a4\u02a6\u0003\u0096K\u0000\u02a5\u02a7"+
		"\u0003\u00fc~\u0000\u02a6\u02a5\u0001\u0000\u0000\u0000\u02a6\u02a7\u0001"+
		"\u0000\u0000\u0000\u02a7K\u0001\u0000\u0000\u0000\u02a8\u02b0\u0003\u00f8"+
		"|\u0000\u02a9\u02aa\u0003h4\u0000\u02aa\u02ad\u0005O\u0000\u0000\u02ab"+
		"\u02ac\u0007\u0000\u0000\u0000\u02ac\u02ae\u0003\u00f8|\u0000\u02ad\u02ab"+
		"\u0001\u0000\u0000\u0000\u02ad\u02ae\u0001\u0000\u0000\u0000\u02ae\u02b0"+
		"\u0001\u0000\u0000\u0000\u02af\u02a8\u0001\u0000\u0000\u0000\u02af\u02a9"+
		"\u0001\u0000\u0000\u0000\u02b0M\u0001\u0000\u0000\u0000\u02b1\u02b6\u0003"+
		"^/\u0000\u02b2\u02b3\u0005w\u0000\u0000\u02b3\u02b5\u0003^/\u0000\u02b4"+
		"\u02b2\u0001\u0000\u0000\u0000\u02b5\u02b8\u0001\u0000\u0000\u0000\u02b6"+
		"\u02b4\u0001\u0000\u0000\u0000\u02b6\u02b7\u0001\u0000\u0000\u0000\u02b7"+
		"O\u0001\u0000\u0000\u0000\u02b8\u02b6\u0001\u0000\u0000\u0000\u02b9\u02c5"+
		"\u0005p\u0000\u0000\u02ba\u02bc\u0003R)\u0000\u02bb\u02ba\u0001\u0000"+
		"\u0000\u0000\u02bb\u02bc\u0001\u0000\u0000\u0000\u02bc\u02c6\u0001\u0000"+
		"\u0000\u0000\u02bd\u02c0\u0003R)\u0000\u02be\u02bf\u0005w\u0000\u0000"+
		"\u02bf\u02c1\u0003T*\u0000\u02c0\u02be\u0001\u0000\u0000\u0000\u02c0\u02c1"+
		"\u0001\u0000\u0000\u0000\u02c1\u02c6\u0001\u0000\u0000\u0000\u02c2\u02c4"+
		"\u0003T*\u0000\u02c3\u02c2\u0001\u0000\u0000\u0000\u02c3\u02c4\u0001\u0000"+
		"\u0000\u0000\u02c4\u02c6\u0001\u0000\u0000\u0000\u02c5\u02bb\u0001\u0000"+
		"\u0000\u0000\u02c5\u02bd\u0001\u0000\u0000\u0000\u02c5\u02c3\u0001\u0000"+
		"\u0000\u0000\u02c6\u02c7\u0001\u0000\u0000\u0000\u02c7\u02c8\u0005q\u0000"+
		"\u0000\u02c8Q\u0001\u0000\u0000\u0000\u02c9\u02cf\u0003\u00f8|\u0000\u02ca"+
		"\u02cb\u0003\u0094J\u0000\u02cb\u02cc\u0005x\u0000\u0000\u02cc\u02ce\u0001"+
		"\u0000\u0000\u0000\u02cd\u02ca\u0001\u0000\u0000\u0000\u02ce\u02d1\u0001"+
		"\u0000\u0000\u0000\u02cf\u02cd\u0001\u0000\u0000\u0000\u02cf\u02d0\u0001"+
		"\u0000\u0000\u0000\u02d0\u02d2\u0001\u0000\u0000\u0000\u02d1\u02cf\u0001"+
		"\u0000\u0000\u0000\u02d2\u02d3\u0005.\u0000\u0000\u02d3S\u0001\u0000\u0000"+
		"\u0000\u02d4\u02d9\u0003V+\u0000\u02d5\u02d6\u0005w\u0000\u0000\u02d6"+
		"\u02d8\u0003V+\u0000\u02d7\u02d5\u0001\u0000\u0000\u0000\u02d8\u02db\u0001"+
		"\u0000\u0000\u0000\u02d9\u02d7\u0001\u0000\u0000\u0000\u02d9\u02da\u0001"+
		"\u0000\u0000\u0000\u02da\u02de\u0001\u0000\u0000\u0000\u02db\u02d9\u0001"+
		"\u0000\u0000\u0000\u02dc\u02dd\u0005w\u0000\u0000\u02dd\u02df\u0003X,"+
		"\u0000\u02de\u02dc\u0001\u0000\u0000\u0000\u02de\u02df\u0001\u0000\u0000"+
		"\u0000\u02df\u02e2\u0001\u0000\u0000\u0000\u02e0\u02e2\u0003X,\u0000\u02e1"+
		"\u02d4\u0001\u0000\u0000\u0000\u02e1\u02e0\u0001\u0000\u0000\u0000\u02e2"+
		"U\u0001\u0000\u0000\u0000\u02e3\u02e4\u0003\n\u0005\u0000\u02e4\u02e5"+
		"\u0003\u00f8|\u0000\u02e5\u02e6\u0003D\"\u0000\u02e6W\u0001\u0000\u0000"+
		"\u0000\u02e7\u02e8\u0003\n\u0005\u0000\u02e8\u02e9\u0003\u00f8|\u0000"+
		"\u02e9\u02ea\u0003h4\u0000\u02ea\u02eb\u0005\u0081\u0000\u0000\u02eb\u02ec"+
		"\u0003D\"\u0000\u02ecY\u0001\u0000\u0000\u0000\u02ed\u02f2\u0003\\.\u0000"+
		"\u02ee\u02ef\u0005w\u0000\u0000\u02ef\u02f1\u0003\\.\u0000\u02f0\u02ee"+
		"\u0001\u0000\u0000\u0000\u02f1\u02f4\u0001\u0000\u0000\u0000\u02f2\u02f0"+
		"\u0001\u0000\u0000\u0000\u02f2\u02f3\u0001\u0000\u0000\u0000\u02f3[\u0001"+
		"\u0000\u0000\u0000\u02f4\u02f2\u0001\u0000\u0000\u0000\u02f5\u02f6\u0003"+
		"\n\u0005\u0000\u02f6\u02f7\u0005=\u0000\u0000\u02f7\u02f8\u0003\u0094"+
		"J\u0000\u02f8]\u0001\u0000\u0000\u0000\u02f9\u02fe\u0003\u0094J\u0000"+
		"\u02fa\u02fb\u0005x\u0000\u0000\u02fb\u02fd\u0003\u0094J\u0000\u02fc\u02fa"+
		"\u0001\u0000\u0000\u0000\u02fd\u0300\u0001\u0000\u0000\u0000\u02fe\u02fc"+
		"\u0001\u0000\u0000\u0000\u02fe\u02ff\u0001\u0000\u0000\u0000\u02ff_\u0001"+
		"\u0000\u0000\u0000\u0300\u02fe\u0001\u0000\u0000\u0000\u0301\u0309\u0003"+
		"b1\u0000\u0302\u0309\u0003d2\u0000\u0303\u0309\u0005I\u0000\u0000\u0304"+
		"\u0309\u0005J\u0000\u0000\u0305\u0309\u0005L\u0000\u0000\u0306\u0309\u0005"+
		"M\u0000\u0000\u0307\u0309\u0005K\u0000\u0000\u0308\u0301\u0001\u0000\u0000"+
		"\u0000\u0308\u0302\u0001\u0000\u0000\u0000\u0308\u0303\u0001\u0000\u0000"+
		"\u0000\u0308\u0304\u0001\u0000\u0000\u0000\u0308\u0305\u0001\u0000\u0000"+
		"\u0000\u0308\u0306\u0001\u0000\u0000\u0000\u0308\u0307\u0001\u0000\u0000"+
		"\u0000\u0309a\u0001\u0000\u0000\u0000\u030a\u030b\u0007\u0001\u0000\u0000"+
		"\u030bc\u0001\u0000\u0000\u0000\u030c\u030d\u0007\u0002\u0000\u0000\u030d"+
		"e\u0001\u0000\u0000\u0000\u030e\u030f\u0003\u0094J\u0000\u030f\u0310\u0005"+
		"x\u0000\u0000\u0310\u0312\u0001\u0000\u0000\u0000\u0311\u030e\u0001\u0000"+
		"\u0000\u0000\u0312\u0315\u0001\u0000\u0000\u0000\u0313\u0311\u0001\u0000"+
		"\u0000\u0000\u0313\u0314\u0001\u0000\u0000\u0000\u0314\u0316\u0001\u0000"+
		"\u0000\u0000\u0315\u0313\u0001\u0000\u0000\u0000\u0316\u0317\u0005\u0080"+
		"\u0000\u0000\u0317\u0318\u0003\u0094J\u0000\u0318g\u0001\u0000\u0000\u0000"+
		"\u0319\u031b\u0003j5\u0000\u031a\u0319\u0001\u0000\u0000\u0000\u031b\u031e"+
		"\u0001\u0000\u0000\u0000\u031c\u031a\u0001\u0000\u0000\u0000\u031c\u031d"+
		"\u0001\u0000\u0000\u0000\u031di\u0001\u0000\u0000\u0000\u031e\u031c\u0001"+
		"\u0000\u0000\u0000\u031f\u0320\u0005\u0080\u0000\u0000\u0320\u0323\u0003"+
		"^/\u0000\u0321\u0323\u0003f3\u0000\u0322\u031f\u0001\u0000\u0000\u0000"+
		"\u0322\u0321\u0001\u0000\u0000\u0000\u0323\u032a\u0001\u0000\u0000\u0000"+
		"\u0324\u0327\u0005p\u0000\u0000\u0325\u0328\u0003l6\u0000\u0326\u0328"+
		"\u0003p8\u0000\u0327\u0325\u0001\u0000\u0000\u0000\u0327\u0326\u0001\u0000"+
		"\u0000\u0000\u0327\u0328\u0001\u0000\u0000\u0000\u0328\u0329\u0001\u0000"+
		"\u0000\u0000\u0329\u032b\u0005q\u0000\u0000\u032a\u0324\u0001\u0000\u0000"+
		"\u0000\u032a\u032b\u0001\u0000\u0000\u0000\u032bk\u0001\u0000\u0000\u0000"+
		"\u032c\u0331\u0003n7\u0000\u032d\u032e\u0005w\u0000\u0000\u032e\u0330"+
		"\u0003n7\u0000\u032f\u032d\u0001\u0000\u0000\u0000\u0330\u0333\u0001\u0000"+
		"\u0000\u0000\u0331\u032f\u0001\u0000\u0000\u0000\u0331\u0332\u0001\u0000"+
		"\u0000\u0000\u0332m\u0001\u0000\u0000\u0000\u0333\u0331\u0001\u0000\u0000"+
		"\u0000\u0334\u0335\u0003\u0094J\u0000\u0335\u0336\u0005N\u0000\u0000\u0336"+
		"\u0337\u0003p8\u0000\u0337o\u0001\u0000\u0000\u0000\u0338\u033c\u0003"+
		"\u00d6k\u0000\u0339\u033c\u0003j5\u0000\u033a\u033c\u0003r9\u0000\u033b"+
		"\u0338\u0001\u0000\u0000\u0000\u033b\u0339\u0001\u0000\u0000\u0000\u033b"+
		"\u033a\u0001\u0000\u0000\u0000\u033cq\u0001\u0000\u0000\u0000\u033d\u0346"+
		"\u0005r\u0000\u0000\u033e\u0343\u0003p8\u0000\u033f\u0340\u0005w\u0000"+
		"\u0000\u0340\u0342\u0003p8\u0000\u0341\u033f\u0001\u0000\u0000\u0000\u0342"+
		"\u0345\u0001\u0000\u0000\u0000\u0343\u0341\u0001\u0000\u0000\u0000\u0343"+
		"\u0344\u0001\u0000\u0000\u0000\u0344\u0347\u0001\u0000\u0000\u0000\u0345"+
		"\u0343\u0001\u0000\u0000\u0000\u0346\u033e\u0001\u0000\u0000\u0000\u0346"+
		"\u0347\u0001\u0000\u0000\u0000\u0347\u0349\u0001\u0000\u0000\u0000\u0348"+
		"\u034a\u0005w\u0000\u0000\u0349\u0348\u0001\u0000\u0000\u0000\u0349\u034a"+
		"\u0001\u0000\u0000\u0000\u034a\u034b\u0001\u0000\u0000\u0000\u034b\u034c"+
		"\u0005s\u0000\u0000\u034cs\u0001\u0000\u0000\u0000\u034d\u034e\u0003\n"+
		"\u0005\u0000\u034e\u034f\u0003v;\u0000\u034f\u0352\u0001\u0000\u0000\u0000"+
		"\u0350\u0352\u0005v\u0000\u0000\u0351\u034d\u0001\u0000\u0000\u0000\u0351"+
		"\u0350\u0001\u0000\u0000\u0000\u0352u\u0001\u0000\u0000\u0000\u0353\u0354"+
		"\u0003\u00f8|\u0000\u0354\u0355\u0003x<\u0000\u0355\u0356\u0005v\u0000"+
		"\u0000\u0356\u035c\u0001\u0000\u0000\u0000\u0357\u0359\u0003\f\u0006\u0000"+
		"\u0358\u035a\u0005v\u0000\u0000\u0359\u0358\u0001\u0000\u0000\u0000\u0359"+
		"\u035a\u0001\u0000\u0000\u0000\u035a\u035c\u0001\u0000\u0000\u0000\u035b"+
		"\u0353\u0001\u0000\u0000\u0000\u035b\u0357\u0001\u0000\u0000\u0000\u035c"+
		"w\u0001\u0000\u0000\u0000\u035d\u0360\u0003z=\u0000\u035e\u0360\u0003"+
		"|>\u0000\u035f\u035d\u0001\u0000\u0000\u0000\u035f\u035e\u0001\u0000\u0000"+
		"\u0000\u0360y\u0001\u0000\u0000\u0000\u0361\u0362\u0003\u0094J\u0000\u0362"+
		"\u0363\u0005p\u0000\u0000\u0363\u0365\u0005q\u0000\u0000\u0364\u0366\u0003"+
		"~?\u0000\u0365\u0364\u0001\u0000\u0000\u0000\u0365\u0366\u0001\u0000\u0000"+
		"\u0000\u0366{\u0001\u0000\u0000\u0000\u0367\u0368\u0003@ \u0000\u0368"+
		"}\u0001\u0000\u0000\u0000\u0369\u036a\u0005\u001c\u0000\u0000\u036a\u036b"+
		"\u0003p8\u0000\u036b\u007f\u0001\u0000\u0000\u0000\u036c\u036e\u00054"+
		"\u0000\u0000\u036d\u036c\u0001\u0000\u0000\u0000\u036d\u036e\u0001\u0000"+
		"\u0000\u0000\u036e\u036f\u0001\u0000\u0000\u0000\u036f\u0370\u00053\u0000"+
		"\u0000\u0370\u0371\u0003^/\u0000\u0371\u0372\u0003\u0018\f\u0000\u0372"+
		"\u0081\u0001\u0000\u0000\u0000\u0373\u0377\u00055\u0000\u0000\u0374\u0376"+
		"\u0003\u0084B\u0000\u0375\u0374\u0001\u0000\u0000\u0000\u0376\u0379\u0001"+
		"\u0000\u0000\u0000\u0377\u0375\u0001\u0000\u0000\u0000\u0377\u0378\u0001"+
		"\u0000\u0000\u0000\u0378\u037a\u0001\u0000\u0000\u0000\u0379\u0377\u0001"+
		"\u0000\u0000\u0000\u037a\u037b\u0003^/\u0000\u037b\u037c\u0005v\u0000"+
		"\u0000\u037c\u0398\u0001\u0000\u0000\u0000\u037d\u037e\u00056\u0000\u0000"+
		"\u037e\u0381\u0003^/\u0000\u037f\u0380\u00058\u0000\u0000\u0380\u0382"+
		"\u0003^/\u0000\u0381\u037f\u0001\u0000\u0000\u0000\u0381\u0382\u0001\u0000"+
		"\u0000\u0000\u0382\u0383\u0001\u0000\u0000\u0000\u0383\u0384\u0005v\u0000"+
		"\u0000\u0384\u0398\u0001\u0000\u0000\u0000\u0385\u0386\u00057\u0000\u0000"+
		"\u0386\u0389\u0003^/\u0000\u0387\u0388\u00058\u0000\u0000\u0388\u038a"+
		"\u0003^/\u0000\u0389\u0387\u0001\u0000\u0000\u0000\u0389\u038a\u0001\u0000"+
		"\u0000\u0000\u038a\u038b\u0001\u0000\u0000\u0000\u038b\u038c\u0005v\u0000"+
		"\u0000\u038c\u0398\u0001\u0000\u0000\u0000\u038d\u038e\u00059\u0000\u0000"+
		"\u038e\u038f\u0003^/\u0000\u038f\u0390\u0005v\u0000\u0000\u0390\u0398"+
		"\u0001\u0000\u0000\u0000\u0391\u0392\u0005:\u0000\u0000\u0392\u0393\u0003"+
		"^/\u0000\u0393\u0394\u0005;\u0000\u0000\u0394\u0395\u0003^/\u0000\u0395"+
		"\u0396\u0005v\u0000\u0000\u0396\u0398\u0001\u0000\u0000\u0000\u0397\u0373"+
		"\u0001\u0000\u0000\u0000\u0397\u037d\u0001\u0000\u0000\u0000\u0397\u0385"+
		"\u0001\u0000\u0000\u0000\u0397\u038d\u0001\u0000\u0000\u0000\u0397\u0391"+
		"\u0001\u0000\u0000\u0000\u0398\u0083\u0001\u0000\u0000\u0000\u0399\u039a"+
		"\u0007\u0003\u0000\u0000\u039a\u0085\u0001\u0000\u0000\u0000\u039b\u039d"+
		"\u0005p\u0000\u0000\u039c\u039e\u0003\u0088D\u0000\u039d\u039c\u0001\u0000"+
		"\u0000\u0000\u039d\u039e\u0001\u0000\u0000\u0000\u039e\u039f\u0001\u0000"+
		"\u0000\u0000\u039f\u03a0\u0005q\u0000\u0000\u03a0\u0087\u0001\u0000\u0000"+
		"\u0000\u03a1\u03a6\u0003\u008aE\u0000\u03a2\u03a3\u0005w\u0000\u0000\u03a3"+
		"\u03a5\u0003\u008aE\u0000\u03a4\u03a2\u0001\u0000\u0000\u0000\u03a5\u03a8"+
		"\u0001\u0000\u0000\u0000\u03a6\u03a4\u0001\u0000\u0000\u0000\u03a6\u03a7"+
		"\u0001\u0000\u0000\u0000\u03a7\u0089\u0001\u0000\u0000\u0000\u03a8\u03a6"+
		"\u0001\u0000\u0000\u0000\u03a9\u03aa\u0003\u00f8|\u0000\u03aa\u03ab\u0003"+
		"\u0094J\u0000\u03ab\u008b\u0001\u0000\u0000\u0000\u03ac\u03b1\u0005r\u0000"+
		"\u0000\u03ad\u03b0\u0003\f\u0006\u0000\u03ae\u03b0\u0003\u0098L\u0000"+
		"\u03af\u03ad\u0001\u0000\u0000\u0000\u03af\u03ae\u0001\u0000\u0000\u0000"+
		"\u03b0\u03b3\u0001\u0000\u0000\u0000\u03b1\u03af\u0001\u0000\u0000\u0000"+
		"\u03b1\u03b2\u0001\u0000\u0000\u0000\u03b2\u03b4\u0001\u0000\u0000\u0000"+
		"\u03b3\u03b1\u0001\u0000\u0000\u0000\u03b4\u03cc\u0005s\u0000\u0000\u03b5"+
		"\u03b9\u0005r\u0000\u0000\u03b6\u03b8\u0003\u008eG\u0000\u03b7\u03b6\u0001"+
		"\u0000\u0000\u0000\u03b8\u03bb\u0001\u0000\u0000\u0000\u03b9\u03b7\u0001"+
		"\u0000\u0000\u0000\u03b9\u03ba\u0001\u0000\u0000\u0000\u03ba\u03bf\u0001"+
		"\u0000\u0000\u0000\u03bb\u03b9\u0001\u0000\u0000\u0000\u03bc\u03be\u0003"+
		"\u00c8d\u0000\u03bd\u03bc\u0001\u0000\u0000\u0000\u03be\u03c1\u0001\u0000"+
		"\u0000\u0000\u03bf\u03bd\u0001\u0000\u0000\u0000\u03bf\u03c0\u0001\u0000"+
		"\u0000\u0000\u03c0\u03c2\u0001\u0000\u0000\u0000\u03c1\u03bf\u0001\u0000"+
		"\u0000\u0000\u03c2\u03cc\u0005s\u0000\u0000\u03c3\u03c7\u0005r\u0000\u0000"+
		"\u03c4\u03c6\u0003\u00e0p\u0000\u03c5\u03c4\u0001\u0000\u0000\u0000\u03c6"+
		"\u03c9\u0001\u0000\u0000\u0000\u03c7\u03c5\u0001\u0000\u0000\u0000\u03c7"+
		"\u03c8\u0001\u0000\u0000\u0000\u03c8\u03ca\u0001\u0000\u0000\u0000\u03c9"+
		"\u03c7\u0001\u0000\u0000\u0000\u03ca\u03cc\u0005s\u0000\u0000\u03cb\u03ac"+
		"\u0001\u0000\u0000\u0000\u03cb\u03b5\u0001\u0000\u0000\u0000\u03cb\u03c3"+
		"\u0001\u0000\u0000\u0000\u03cc\u008d\u0001\u0000\u0000\u0000\u03cd\u03cf"+
		"\u0003\u00c8d\u0000\u03ce\u03cd\u0001\u0000\u0000\u0000\u03cf\u03d0\u0001"+
		"\u0000\u0000\u0000\u03d0\u03ce\u0001\u0000\u0000\u0000\u03d0\u03d1\u0001"+
		"\u0000\u0000\u0000\u03d1\u03d4\u0001\u0000\u0000\u0000\u03d2\u03d5\u0003"+
		"\f\u0006\u0000\u03d3\u03d5\u0003\u0098L\u0000\u03d4\u03d2\u0001\u0000"+
		"\u0000\u0000\u03d4\u03d3\u0001\u0000\u0000\u0000\u03d5\u03d6\u0001\u0000"+
		"\u0000\u0000\u03d6\u03d4\u0001\u0000\u0000\u0000\u03d6\u03d7\u0001\u0000"+
		"\u0000\u0000\u03d7\u008f\u0001\u0000\u0000\u0000\u03d8\u03d9\u0003\u0092"+
		"I\u0000\u03d9\u03da\u0005v\u0000\u0000\u03da\u0091\u0001\u0000\u0000\u0000"+
		"\u03db\u03e4\u0003\n\u0005\u0000\u03dc\u03dd\u0005=\u0000\u0000\u03dd"+
		"\u03de\u0003\u0094J\u0000\u03de\u03df\u0005N\u0000\u0000\u03df\u03e0\u0003"+
		"\u00d6k\u0000\u03e0\u03e5\u0001\u0000\u0000\u0000\u03e1\u03e2\u0003\u00f8"+
		"|\u0000\u03e2\u03e3\u0003@ \u0000\u03e3\u03e5\u0001\u0000\u0000\u0000"+
		"\u03e4\u03dc\u0001\u0000\u0000\u0000\u03e4\u03e1\u0001\u0000\u0000\u0000"+
		"\u03e5\u0093\u0001\u0000\u0000\u0000\u03e6\u03e7\u0007\u0004\u0000\u0000"+
		"\u03e7\u0095\u0001\u0000\u0000\u0000\u03e8\u03e9\u0007\u0005\u0000\u0000"+
		"\u03e9\u0097\u0001\u0000\u0000\u0000\u03ea\u03ff\u0003\u008cF\u0000\u03eb"+
		"\u03ff\u0003\u0090H\u0000\u03ec\u03ff\u0003\u009aM\u0000\u03ed\u03ff\u0003"+
		"\u009cN\u0000\u03ee\u03ff\u0003\u009eO\u0000\u03ef\u03ff\u0003\u00a0P"+
		"\u0000\u03f0\u03ff\u0003\u00a2Q\u0000\u03f1\u03ff\u0003\u00a4R\u0000\u03f2"+
		"\u03ff\u0003\u00a6S\u0000\u03f3\u03ff\u0003\u00a8T\u0000\u03f4\u03ff\u0003"+
		"\u00aaU\u0000\u03f5\u03ff\u0003\u00acV\u0000\u03f6\u03ff\u0003\u00aeW"+
		"\u0000\u03f7\u03ff\u0003\u00b0X\u0000\u03f8\u03ff\u0003\u00b2Y\u0000\u03f9"+
		"\u03ff\u0003\u00b4Z\u0000\u03fa\u03ff\u0003\u00b6[\u0000\u03fb\u03ff\u0005"+
		"v\u0000\u0000\u03fc\u03ff\u0003\u00b8\\\u0000\u03fd\u03ff\u0003\u00ba"+
		"]\u0000\u03fe\u03ea\u0001\u0000\u0000\u0000\u03fe\u03eb\u0001\u0000\u0000"+
		"\u0000\u03fe\u03ec\u0001\u0000\u0000\u0000\u03fe\u03ed\u0001\u0000\u0000"+
		"\u0000\u03fe\u03ee\u0001\u0000\u0000\u0000\u03fe\u03ef\u0001\u0000\u0000"+
		"\u0000\u03fe\u03f0\u0001\u0000\u0000\u0000\u03fe\u03f1\u0001\u0000\u0000"+
		"\u0000\u03fe\u03f2\u0001\u0000\u0000\u0000\u03fe\u03f3\u0001\u0000\u0000"+
		"\u0000\u03fe\u03f4\u0001\u0000\u0000\u0000\u03fe\u03f5\u0001\u0000\u0000"+
		"\u0000\u03fe\u03f6\u0001\u0000\u0000\u0000\u03fe\u03f7\u0001\u0000\u0000"+
		"\u0000\u03fe\u03f8\u0001\u0000\u0000\u0000\u03fe\u03f9\u0001\u0000\u0000"+
		"\u0000\u03fe\u03fa\u0001\u0000\u0000\u0000\u03fe\u03fb\u0001\u0000\u0000"+
		"\u0000\u03fe\u03fc\u0001\u0000\u0000\u0000\u03fe\u03fd\u0001\u0000\u0000"+
		"\u0000\u03ff\u0099\u0001\u0000\u0000\u0000\u0400\u0401\u0005\u0019\u0000"+
		"\u0000\u0401\u0404\u0003\u00d6k\u0000\u0402\u0403\u0005P\u0000\u0000\u0403"+
		"\u0405\u0003\u00d6k\u0000\u0404\u0402\u0001\u0000\u0000\u0000\u0404\u0405"+
		"\u0001\u0000\u0000\u0000\u0405\u0406\u0001\u0000\u0000\u0000\u0406\u0407"+
		"\u0005v\u0000\u0000\u0407\u009b\u0001\u0000\u0000\u0000\u0408\u0409\u0005"+
		"\u000f\u0000\u0000\u0409\u040a\u0003\u00d0h\u0000\u040a\u040b\u0003\u0098"+
		"L\u0000\u040b\u009d\u0001\u0000\u0000\u0000\u040c\u040d\u0005\u000f\u0000"+
		"\u0000\u040d\u040e\u0003\u00d0h\u0000\u040e\u040f\u0003\u0098L\u0000\u040f"+
		"\u0410\u0005\f\u0000\u0000\u0410\u0411\u0003\u0098L\u0000\u0411\u009f"+
		"\u0001\u0000\u0000\u0000\u0412\u0413\u0005\u000e\u0000\u0000\u0413\u0414"+
		"\u0005p\u0000\u0000\u0414\u0415\u0003\u00cae\u0000\u0415\u0416\u0005q"+
		"\u0000\u0000\u0416\u0417\u0003\u0098L\u0000\u0417\u00a1\u0001\u0000\u0000"+
		"\u0000\u0418\u0419\u0005\u0012\u0000\u0000\u0419\u041a\u0003\u00d0h\u0000"+
		"\u041a\u041b\u0003\u0098L\u0000\u041b\u00a3\u0001\u0000\u0000\u0000\u041c"+
		"\u041d\u0005\u000b\u0000\u0000\u041d\u041e\u0003\u0098L\u0000\u041e\u041f"+
		"\u0005\u0012\u0000\u0000\u041f\u0420\u0003\u00d0h\u0000\u0420\u0421\u0005"+
		"v\u0000\u0000\u0421\u00a5\u0001\u0000\u0000\u0000\u0422\u0423\u0005\u0011"+
		"\u0000\u0000\u0423\u042d\u0003\u008cF\u0000\u0424\u0426\u0003\u00bc^\u0000"+
		"\u0425\u0424\u0001\u0000\u0000\u0000\u0426\u0427\u0001\u0000\u0000\u0000"+
		"\u0427\u0425\u0001\u0000\u0000\u0000\u0427\u0428\u0001\u0000\u0000\u0000"+
		"\u0428\u042a\u0001\u0000\u0000\u0000\u0429\u042b\u0003\u00c0`\u0000\u042a"+
		"\u0429\u0001\u0000\u0000\u0000\u042a\u042b\u0001\u0000\u0000\u0000\u042b"+
		"\u042e\u0001\u0000\u0000\u0000\u042c\u042e\u0003\u00c0`\u0000\u042d\u0425"+
		"\u0001\u0000\u0000\u0000\u042d\u042c\u0001\u0000\u0000\u0000\u042e\u00a7"+
		"\u0001\u0000\u0000\u0000\u042f\u0430\u0005\u0011\u0000\u0000\u0430\u0431"+
		"\u0003\u00c2a\u0000\u0431\u0435\u0003\u008cF\u0000\u0432\u0434\u0003\u00bc"+
		"^\u0000\u0433\u0432\u0001\u0000\u0000\u0000\u0434\u0437\u0001\u0000\u0000"+
		"\u0000\u0435\u0433\u0001\u0000\u0000\u0000\u0435\u0436\u0001\u0000\u0000"+
		"\u0000\u0436\u0439\u0001\u0000\u0000\u0000\u0437\u0435\u0001\u0000\u0000"+
		"\u0000\u0438\u043a\u0003\u00c0`\u0000\u0439\u0438\u0001\u0000\u0000\u0000"+
		"\u0439\u043a\u0001\u0000\u0000\u0000\u043a\u00a9\u0001\u0000\u0000\u0000"+
		"\u043b\u043c\u0005\u0010\u0000\u0000\u043c\u043d\u0003\u00d0h\u0000\u043d"+
		"\u043e\u0003\u008cF\u0000\u043e\u00ab\u0001\u0000\u0000\u0000\u043f\u0440"+
		"\u0005-\u0000\u0000\u0440\u0441\u0003\u00d0h\u0000\u0441\u0442\u0003\u008c"+
		"F\u0000\u0442\u00ad\u0001\u0000\u0000\u0000\u0443\u0445\u0005\u0017\u0000"+
		"\u0000\u0444\u0446\u0003\u00d6k\u0000\u0445\u0444\u0001\u0000\u0000\u0000"+
		"\u0445\u0446\u0001\u0000\u0000\u0000\u0446\u0447\u0001\u0000\u0000\u0000"+
		"\u0447\u0448\u0005v\u0000\u0000\u0448\u00af\u0001\u0000\u0000\u0000\u0449"+
		"\u044a\u0005/\u0000\u0000\u044a\u044b\u0003\u00d6k\u0000\u044b\u044c\u0005"+
		"v\u0000\u0000\u044c\u00b1\u0001\u0000\u0000\u0000\u044d\u044f\u0005\u0014"+
		"\u0000\u0000\u044e\u0450\u0003\u0094J\u0000\u044f\u044e\u0001\u0000\u0000"+
		"\u0000\u044f\u0450\u0001\u0000\u0000\u0000\u0450\u0451\u0001\u0000\u0000"+
		"\u0000\u0451\u0452\u0005v\u0000\u0000\u0452\u00b3\u0001\u0000\u0000\u0000"+
		"\u0453\u0455\u0005\u0016\u0000\u0000\u0454\u0456\u0003\u0094J\u0000\u0455"+
		"\u0454\u0001\u0000\u0000\u0000\u0455\u0456\u0001\u0000\u0000\u0000\u0456"+
		"\u0457\u0001\u0000\u0000\u0000\u0457\u0458\u0005v\u0000\u0000\u0458\u00b5"+
		"\u0001\u0000\u0000\u0000\u0459\u045a\u0005>\u0000\u0000\u045a\u045b\u0003"+
		"\u00d6k\u0000\u045b\u045c\u0005v\u0000\u0000\u045c\u00b7\u0001\u0000\u0000"+
		"\u0000\u045d\u045e\u0003\u00d6k\u0000\u045e\u045f\u0005v\u0000\u0000\u045f"+
		"\u00b9\u0001\u0000\u0000\u0000\u0460\u0461\u0003\u0094J\u0000\u0461\u0462"+
		"\u0005P\u0000\u0000\u0462\u0463\u0003\u0098L\u0000\u0463\u00bb\u0001\u0000"+
		"\u0000\u0000\u0464\u0465\u0005\n\u0000\u0000\u0465\u0466\u0005p\u0000"+
		"\u0000\u0466\u0467\u0003\n\u0005\u0000\u0467\u0468\u0003\u00be_\u0000"+
		"\u0468\u0469\u0003\u0094J\u0000\u0469\u046a\u0005q\u0000\u0000\u046a\u046b"+
		"\u0003\u008cF\u0000\u046b\u00bd\u0001\u0000\u0000\u0000\u046c\u0471\u0003"+
		"^/\u0000\u046d\u046e\u0005^\u0000\u0000\u046e\u0470\u0003^/\u0000\u046f"+
		"\u046d\u0001\u0000\u0000\u0000\u0470\u0473\u0001\u0000\u0000\u0000\u0471"+
		"\u046f\u0001\u0000\u0000\u0000\u0471\u0472\u0001\u0000\u0000\u0000\u0472"+
		"\u00bf\u0001\u0000\u0000\u0000\u0473\u0471\u0001\u0000\u0000\u0000\u0474"+
		"\u0475\u0005\r\u0000\u0000\u0475\u0476\u0003\u008cF\u0000\u0476\u00c1"+
		"\u0001\u0000\u0000\u0000\u0477\u0478\u0005p\u0000\u0000\u0478\u047a\u0003"+
		"\u00c4b\u0000\u0479\u047b\u0005v\u0000\u0000\u047a\u0479\u0001\u0000\u0000"+
		"\u0000\u047a\u047b\u0001\u0000\u0000\u0000\u047b\u047c\u0001\u0000\u0000"+
		"\u0000\u047c\u047d\u0005q\u0000\u0000\u047d\u00c3\u0001\u0000\u0000\u0000"+
		"\u047e\u0483\u0003\u00c6c\u0000\u047f\u0480\u0005v\u0000\u0000\u0480\u0482"+
		"\u0003\u00c6c\u0000\u0481\u047f\u0001\u0000\u0000\u0000\u0482\u0485\u0001"+
		"\u0000\u0000\u0000\u0483\u0481\u0001\u0000\u0000\u0000\u0483\u0484\u0001"+
		"\u0000\u0000\u0000\u0484\u00c5\u0001\u0000\u0000\u0000\u0485\u0483\u0001"+
		"\u0000\u0000\u0000\u0486\u048c\u0003\n\u0005\u0000\u0487\u0488\u0003J"+
		"%\u0000\u0488\u0489\u0003D\"\u0000\u0489\u048d\u0001\u0000\u0000\u0000"+
		"\u048a\u048b\u0005=\u0000\u0000\u048b\u048d\u0003\u0094J\u0000\u048c\u0487"+
		"\u0001\u0000\u0000\u0000\u048c\u048a\u0001\u0000\u0000\u0000\u048d\u048e"+
		"\u0001\u0000\u0000\u0000\u048e\u048f\u0005N\u0000\u0000\u048f\u0490\u0003"+
		"\u00d6k\u0000\u0490\u0493\u0001\u0000\u0000\u0000\u0491\u0493\u0003^/"+
		"\u0000\u0492\u0486\u0001\u0000\u0000\u0000\u0492\u0491\u0001\u0000\u0000"+
		"\u0000\u0493\u00c7\u0001\u0000\u0000\u0000\u0494\u049a\u0005\u0015\u0000"+
		"\u0000\u0495\u049b\u0003\u00d6k\u0000\u0496\u049b\u0005}\u0000\u0000\u0497"+
		"\u0498\u0003\u00f8|\u0000\u0498\u0499\u0003\u0094J\u0000\u0499\u049b\u0001"+
		"\u0000\u0000\u0000\u049a\u0495\u0001\u0000\u0000\u0000\u049a\u0496\u0001"+
		"\u0000\u0000\u0000\u049a\u0497\u0001\u0000\u0000\u0000\u049b\u049c\u0001"+
		"\u0000\u0000\u0000\u049c\u04a0\u0005P\u0000\u0000\u049d\u049e\u0005\u001c"+
		"\u0000\u0000\u049e\u04a0\u0005P\u0000\u0000\u049f\u0494\u0001\u0000\u0000"+
		"\u0000\u049f\u049d\u0001\u0000\u0000\u0000\u04a0\u00c9\u0001\u0000\u0000"+
		"\u0000\u04a1\u04ae\u0003\u00ceg\u0000\u04a2\u04a4\u0003\u00ccf\u0000\u04a3"+
		"\u04a2\u0001\u0000\u0000\u0000\u04a3\u04a4\u0001\u0000\u0000\u0000\u04a4"+
		"\u04a5\u0001\u0000\u0000\u0000\u04a5\u04a7\u0005v\u0000\u0000\u04a6\u04a8"+
		"\u0003\u00d6k\u0000\u04a7\u04a6\u0001\u0000\u0000\u0000\u04a7\u04a8\u0001"+
		"\u0000\u0000\u0000\u04a8\u04a9\u0001\u0000\u0000\u0000\u04a9\u04ab\u0005"+
		"v\u0000\u0000\u04aa\u04ac\u0003\u00d2i\u0000\u04ab\u04aa\u0001\u0000\u0000"+
		"\u0000\u04ab\u04ac\u0001\u0000\u0000\u0000\u04ac\u04ae\u0001\u0000\u0000"+
		"\u0000\u04ad\u04a1\u0001\u0000\u0000\u0000\u04ad\u04a3\u0001\u0000\u0000"+
		"\u0000\u04ae\u00cb\u0001\u0000\u0000\u0000\u04af\u04b2\u0003\u0092I\u0000"+
		"\u04b0\u04b2\u0003\u00d2i\u0000\u04b1\u04af\u0001\u0000\u0000\u0000\u04b1"+
		"\u04b0\u0001\u0000\u0000\u0000\u04b2\u00cd\u0001\u0000\u0000\u0000\u04b3"+
		"\u04b6\u0003\n\u0005\u0000\u04b4\u04b7\u0003\u00f8|\u0000\u04b5\u04b7"+
		"\u0005=\u0000\u0000\u04b6\u04b4\u0001\u0000\u0000\u0000\u04b6\u04b5\u0001"+
		"\u0000\u0000\u0000\u04b7\u04b8\u0001\u0000\u0000\u0000\u04b8\u04b9\u0003"+
		"D\"\u0000\u04b9\u04ba\u0005P\u0000\u0000\u04ba\u04bb\u0003\u00d6k\u0000"+
		"\u04bb\u00cf\u0001\u0000\u0000\u0000\u04bc\u04bd\u0005p\u0000\u0000\u04bd"+
		"\u04be\u0003\u00d6k\u0000\u04be\u04bf\u0005q\u0000\u0000\u04bf\u00d1\u0001"+
		"\u0000\u0000\u0000\u04c0\u04c5\u0003\u00d6k\u0000\u04c1\u04c2\u0005w\u0000"+
		"\u0000\u04c2\u04c4\u0003\u00d6k\u0000\u04c3\u04c1\u0001\u0000\u0000\u0000"+
		"\u04c4\u04c7\u0001\u0000\u0000\u0000\u04c5\u04c3\u0001\u0000\u0000\u0000"+
		"\u04c5\u04c6\u0001\u0000\u0000\u0000\u04c6\u00d3\u0001\u0000\u0000\u0000"+
		"\u04c7\u04c5\u0001\u0000\u0000\u0000\u04c8\u04cc\u0003\u0094J\u0000\u04c9"+
		"\u04cc\u0005.\u0000\u0000\u04ca\u04cc\u0005,\u0000\u0000\u04cb\u04c8\u0001"+
		"\u0000\u0000\u0000\u04cb\u04c9\u0001\u0000\u0000\u0000\u04cb\u04ca\u0001"+
		"\u0000\u0000\u0000\u04cc\u04cd\u0001\u0000\u0000\u0000\u04cd\u04ce\u0003"+
		"\u0102\u0081\u0000\u04ce\u00d5\u0001\u0000\u0000\u0000\u04cf\u04d0\u0006"+
		"k\uffff\uffff\u0000\u04d0\u04d1\u0005p\u0000\u0000\u04d1\u04d2\u0003\u00d6"+
		"k\u0000\u04d2\u04d3\u0005q\u0000\u0000\u04d3\u050a\u0001\u0000\u0000\u0000"+
		"\u04d4\u050a\u0005.\u0000\u0000\u04d5\u050a\u0005,\u0000\u0000\u04d6\u050a"+
		"\u0003`0\u0000\u04d7\u050a\u0003\u0094J\u0000\u04d8\u04d9\u0003\u00f8"+
		"|\u0000\u04d9\u04da\u0005x\u0000\u0000\u04da\u04db\u0005\u001a\u0000\u0000"+
		"\u04db\u050a\u0001\u0000\u0000\u0000\u04dc\u04e0\u0003\u00f4z\u0000\u04dd"+
		"\u04e1\u0003\u0100\u0080\u0000\u04de\u04df\u0005.\u0000\u0000\u04df\u04e1"+
		"\u0003\u0102\u0081\u0000\u04e0\u04dd\u0001\u0000\u0000\u0000\u04e0\u04de"+
		"\u0001\u0000\u0000\u0000\u04e1\u050a\u0001\u0000\u0000\u0000\u04e2\u050a"+
		"\u0003\u00d4j\u0000\u04e3\u04e4\u0003\u00f8|\u0000\u04e4\u04ea\u0005\u007f"+
		"\u0000\u0000\u04e5\u04e7\u0003\u00fc~\u0000\u04e6\u04e5\u0001\u0000\u0000"+
		"\u0000\u04e6\u04e7\u0001\u0000\u0000\u0000\u04e7\u04e8\u0001\u0000\u0000"+
		"\u0000\u04e8\u04eb\u0003\u0094J\u0000\u04e9\u04eb\u0005%\u0000\u0000\u04ea"+
		"\u04e6\u0001\u0000\u0000\u0000\u04ea\u04e9\u0001\u0000\u0000\u0000\u04eb"+
		"\u050a\u0001\u0000\u0000\u0000\u04ec\u04ed\u0003\u00e4r\u0000\u04ed\u04ef"+
		"\u0005\u007f\u0000\u0000\u04ee\u04f0\u0003\u00fc~\u0000\u04ef\u04ee\u0001"+
		"\u0000\u0000\u0000\u04ef\u04f0\u0001\u0000\u0000\u0000\u04f0\u04f1\u0001"+
		"\u0000\u0000\u0000\u04f1\u04f2\u0005%\u0000\u0000\u04f2\u050a\u0001\u0000"+
		"\u0000\u0000\u04f3\u04f4\u0005\u0010\u0000\u0000\u04f4\u04f5\u0003\u00d0"+
		"h\u0000\u04f5\u04f6\u0003\u008cF\u0000\u04f6\u050a\u0001\u0000\u0000\u0000"+
		"\u04f7\u04f8\u0007\u0006\u0000\u0000\u04f8\u050a\u0003\u00d6k\u0011\u04f9"+
		"\u04fa\u0005p\u0000\u0000\u04fa\u04fb\u0003h4\u0000\u04fb\u0500\u0003"+
		"\u00f8|\u0000\u04fc\u04fd\u0005]\u0000\u0000\u04fd\u04ff\u0003\u00f8|"+
		"\u0000\u04fe\u04fc\u0001\u0000\u0000\u0000\u04ff\u0502\u0001\u0000\u0000"+
		"\u0000\u0500\u04fe\u0001\u0000\u0000\u0000\u0500\u0501\u0001\u0000\u0000"+
		"\u0000\u0501\u0503\u0001\u0000\u0000\u0000\u0502\u0500\u0001\u0000\u0000"+
		"\u0000\u0503\u0504\u0005q\u0000\u0000\u0504\u0505\u0003\u00d6k\u0010\u0505"+
		"\u050a\u0001\u0000\u0000\u0000\u0506\u0507\u0005%\u0000\u0000\u0507\u050a"+
		"\u0003\u00e6s\u0000\u0508\u050a\u0003\u00dam\u0000\u0509\u04cf\u0001\u0000"+
		"\u0000\u0000\u0509\u04d4\u0001\u0000\u0000\u0000\u0509\u04d5\u0001\u0000"+
		"\u0000\u0000\u0509\u04d6\u0001\u0000\u0000\u0000\u0509\u04d7\u0001\u0000"+
		"\u0000\u0000\u0509\u04d8\u0001\u0000\u0000\u0000\u0509\u04dc\u0001\u0000"+
		"\u0000\u0000\u0509\u04e2\u0001\u0000\u0000\u0000\u0509\u04e3\u0001\u0000"+
		"\u0000\u0000\u0509\u04ec\u0001\u0000\u0000\u0000\u0509\u04f3\u0001\u0000"+
		"\u0000\u0000\u0509\u04f7\u0001\u0000\u0000\u0000\u0509\u04f9\u0001\u0000"+
		"\u0000\u0000\u0509\u0506\u0001\u0000\u0000\u0000\u0509\u0508\u0001\u0000"+
		"\u0000\u0000\u050a\u055e\u0001\u0000\u0000\u0000\u050b\u050c\n\u000e\u0000"+
		"\u0000\u050c\u050d\u0007\u0007\u0000\u0000\u050d\u055d\u0003\u00d6k\u000f"+
		"\u050e\u050f\n\r\u0000\u0000\u050f\u0510\u0007\b\u0000\u0000\u0510\u055d"+
		"\u0003\u00d6k\u000e\u0511\u0519\n\f\u0000\u0000\u0512\u0513\u0005R\u0000"+
		"\u0000\u0513\u051a\u0005R\u0000\u0000\u0514\u0515\u0005Q\u0000\u0000\u0515"+
		"\u0516\u0005Q\u0000\u0000\u0516\u051a\u0005Q\u0000\u0000\u0517\u0518\u0005"+
		"Q\u0000\u0000\u0518\u051a\u0005Q\u0000\u0000\u0519\u0512\u0001\u0000\u0000"+
		"\u0000\u0519\u0514\u0001\u0000\u0000\u0000\u0519\u0517\u0001\u0000\u0000"+
		"\u0000\u051a\u051b\u0001\u0000\u0000\u0000\u051b\u055d\u0003\u00d6k\r"+
		"\u051c\u051d\n\u000b\u0000\u0000\u051d\u051e\u0007\t\u0000\u0000\u051e"+
		"\u055d\u0003\u00d6k\f\u051f\u0520\n\t\u0000\u0000\u0520\u0521\u0007\n"+
		"\u0000\u0000\u0521\u055d\u0003\u00d6k\n\u0522\u0523\n\b\u0000\u0000\u0523"+
		"\u0524\u0005]\u0000\u0000\u0524\u055d\u0003\u00d6k\t\u0525\u0526\n\u0007"+
		"\u0000\u0000\u0526\u0527\u0005_\u0000\u0000\u0527\u055d\u0003\u00d6k\b"+
		"\u0528\u0529\n\u0006\u0000\u0000\u0529\u052a\u0005^\u0000\u0000\u052a"+
		"\u055d\u0003\u00d6k\u0007\u052b\u052c\n\u0005\u0000\u0000\u052c\u052d"+
		"\u0005W\u0000\u0000\u052d\u055d\u0003\u00d6k\u0006\u052e\u052f\n\u0004"+
		"\u0000\u0000\u052f\u0530\u0005X\u0000\u0000\u0530\u055d\u0003\u00d6k\u0005"+
		"\u0531\u0532\n\u0003\u0000\u0000\u0532\u0533\u0005O\u0000\u0000\u0533"+
		"\u0534\u0003\u00d6k\u0000\u0534\u0535\u0005P\u0000\u0000\u0535\u0536\u0003"+
		"\u00d6k\u0003\u0536\u055d\u0001\u0000\u0000\u0000\u0537\u0538\n\u0002"+
		"\u0000\u0000\u0538\u0539\u0007\u000b\u0000\u0000\u0539\u055d\u0003\u00d6"+
		"k\u0002\u053a\u053b\n\u0019\u0000\u0000\u053b\u053c\u0005t\u0000\u0000"+
		"\u053c\u053d\u0003\u00d6k\u0000\u053d\u053e\u0005u\u0000\u0000\u053e\u055d"+
		"\u0001\u0000\u0000\u0000\u053f\u0540\n\u0018\u0000\u0000\u0540\u054c\u0005"+
		"x\u0000\u0000\u0541\u054d\u0003\u0094J\u0000\u0542\u054d\u0003\u00d4j"+
		"\u0000\u0543\u054d\u0005.\u0000\u0000\u0544\u0546\u0005%\u0000\u0000\u0545"+
		"\u0547\u0003\u00f4z\u0000\u0546\u0545\u0001\u0000\u0000\u0000\u0546\u0547"+
		"\u0001\u0000\u0000\u0000\u0547\u0548\u0001\u0000\u0000\u0000\u0548\u054d"+
		"\u0003\u00eau\u0000\u0549\u054a\u0005,\u0000\u0000\u054a\u054d\u0003\u00fe"+
		"\u007f\u0000\u054b\u054d\u0003\u00f0x\u0000\u054c\u0541\u0001\u0000\u0000"+
		"\u0000\u054c\u0542\u0001\u0000\u0000\u0000\u054c\u0543\u0001\u0000\u0000"+
		"\u0000\u054c\u0544\u0001\u0000\u0000\u0000\u054c\u0549\u0001\u0000\u0000"+
		"\u0000\u054c\u054b\u0001\u0000\u0000\u0000\u054d\u055d\u0001\u0000\u0000"+
		"\u0000\u054e\u054f\n\u0016\u0000\u0000\u054f\u0551\u0005\u007f\u0000\u0000"+
		"\u0550\u0552\u0003\u00fc~\u0000\u0551\u0550\u0001\u0000\u0000\u0000\u0551"+
		"\u0552\u0001\u0000\u0000\u0000\u0552\u0553\u0001\u0000\u0000\u0000\u0553"+
		"\u055d\u0003\u0094J\u0000\u0554\u0555\n\u0012\u0000\u0000\u0555\u055d"+
		"\u0007\f\u0000\u0000\u0556\u0557\n\n\u0000\u0000\u0557\u055a\u0005\"\u0000"+
		"\u0000\u0558\u055b\u0003\u00f8|\u0000\u0559\u055b\u0003\u00d8l\u0000\u055a"+
		"\u0558\u0001\u0000\u0000\u0000\u055a\u0559\u0001\u0000\u0000\u0000\u055b"+
		"\u055d\u0001\u0000\u0000\u0000\u055c\u050b\u0001\u0000\u0000\u0000\u055c"+
		"\u050e\u0001\u0000\u0000\u0000\u055c\u0511\u0001\u0000\u0000\u0000\u055c"+
		"\u051c\u0001\u0000\u0000\u0000\u055c\u051f\u0001\u0000\u0000\u0000\u055c"+
		"\u0522\u0001\u0000\u0000\u0000\u055c\u0525\u0001\u0000\u0000\u0000\u055c"+
		"\u0528\u0001\u0000\u0000\u0000\u055c\u052b\u0001\u0000\u0000\u0000\u055c"+
		"\u052e\u0001\u0000\u0000\u0000\u055c\u0531\u0001\u0000\u0000\u0000\u055c"+
		"\u0537\u0001\u0000\u0000\u0000\u055c\u053a\u0001\u0000\u0000\u0000\u055c"+
		"\u053f\u0001\u0000\u0000\u0000\u055c\u054e\u0001\u0000\u0000\u0000\u055c"+
		"\u0554\u0001\u0000\u0000\u0000\u055c\u0556\u0001\u0000\u0000\u0000\u055d"+
		"\u0560\u0001\u0000\u0000\u0000\u055e\u055c\u0001\u0000\u0000\u0000\u055e"+
		"\u055f\u0001\u0000\u0000\u0000\u055f\u00d7\u0001\u0000\u0000\u0000\u0560"+
		"\u055e\u0001\u0000\u0000\u0000\u0561\u0562\u0003\n\u0005\u0000\u0562\u0563"+
		"\u0003\u00f8|\u0000\u0563\u0564\u0003h4\u0000\u0564\u0565\u0003\u0094"+
		"J\u0000\u0565\u00d9\u0001\u0000\u0000\u0000\u0566\u0567\u0003\u00dcn\u0000"+
		"\u0567\u0568\u0005~\u0000\u0000\u0568\u0569\u0003\u00deo\u0000\u0569\u00db"+
		"\u0001\u0000\u0000\u0000\u056a\u0581\u0003\u0094J\u0000\u056b\u056d\u0005"+
		"p\u0000\u0000\u056c\u056e\u0003T*\u0000\u056d\u056c\u0001\u0000\u0000"+
		"\u0000\u056d\u056e\u0001\u0000\u0000\u0000\u056e\u056f\u0001\u0000\u0000"+
		"\u0000\u056f\u0581\u0005q\u0000\u0000\u0570\u0571\u0005p\u0000\u0000\u0571"+
		"\u0576\u0003\u0094J\u0000\u0572\u0573\u0005w\u0000\u0000\u0573\u0575\u0003"+
		"\u0094J\u0000\u0574\u0572\u0001\u0000\u0000\u0000\u0575\u0578\u0001\u0000"+
		"\u0000\u0000\u0576\u0574\u0001\u0000\u0000\u0000\u0576\u0577\u0001\u0000"+
		"\u0000\u0000\u0577\u0579\u0001\u0000\u0000\u0000\u0578\u0576\u0001\u0000"+
		"\u0000\u0000\u0579\u057a\u0005q\u0000\u0000\u057a\u0581\u0001\u0000\u0000"+
		"\u0000\u057b\u057d\u0005p\u0000\u0000\u057c\u057e\u0003Z-\u0000\u057d"+
		"\u057c\u0001\u0000\u0000\u0000\u057d\u057e\u0001\u0000\u0000\u0000\u057e"+
		"\u057f\u0001\u0000\u0000\u0000\u057f\u0581\u0005q\u0000\u0000\u0580\u056a"+
		"\u0001\u0000\u0000\u0000\u0580\u056b\u0001\u0000\u0000\u0000\u0580\u0570"+
		"\u0001\u0000\u0000\u0000\u0580\u057b\u0001\u0000\u0000\u0000\u0581\u00dd"+
		"\u0001\u0000\u0000\u0000\u0582\u0585\u0003\u00d6k\u0000\u0583\u0585\u0003"+
		"\u008cF\u0000\u0584\u0582\u0001\u0000\u0000\u0000\u0584\u0583\u0001\u0000"+
		"\u0000\u0000\u0585\u00df\u0001\u0000\u0000\u0000\u0586\u058a\u0005\u0015"+
		"\u0000\u0000\u0587\u058b\u0003\u00d2i\u0000\u0588\u058b\u0005M\u0000\u0000"+
		"\u0589\u058b\u0003\u00e2q\u0000\u058a\u0587\u0001\u0000\u0000\u0000\u058a"+
		"\u0588\u0001\u0000\u0000\u0000\u058a\u0589\u0001\u0000\u0000\u0000\u058b"+
		"\u058c\u0001\u0000\u0000\u0000\u058c\u0591\u0007\r\u0000\u0000\u058d\u0590"+
		"\u0003\f\u0006\u0000\u058e\u0590\u0003\u0098L\u0000\u058f\u058d\u0001"+
		"\u0000\u0000\u0000\u058f\u058e\u0001\u0000\u0000\u0000\u0590\u0593\u0001"+
		"\u0000\u0000\u0000\u0591\u058f\u0001\u0000\u0000\u0000\u0591\u0592\u0001"+
		"\u0000\u0000\u0000\u0592\u059e\u0001\u0000\u0000\u0000\u0593\u0591\u0001"+
		"\u0000\u0000\u0000\u0594\u0595\u0005\u001c\u0000\u0000\u0595\u059a\u0007"+
		"\r\u0000\u0000\u0596\u0599\u0003\f\u0006\u0000\u0597\u0599\u0003\u0098"+
		"L\u0000\u0598\u0596\u0001\u0000\u0000\u0000\u0598\u0597\u0001\u0000\u0000"+
		"\u0000\u0599\u059c\u0001\u0000\u0000\u0000\u059a\u0598\u0001\u0000\u0000"+
		"\u0000\u059a\u059b\u0001\u0000\u0000\u0000\u059b\u059e\u0001\u0000\u0000"+
		"\u0000\u059c\u059a\u0001\u0000\u0000\u0000\u059d\u0586\u0001\u0000\u0000"+
		"\u0000\u059d\u0594\u0001\u0000\u0000\u0000\u059e\u00e1\u0001\u0000\u0000"+
		"\u0000\u059f\u05a0\u0006q\uffff\uffff\u0000\u05a0\u05a1\u0005p\u0000\u0000"+
		"\u05a1\u05a2\u0003\u00e2q\u0000\u05a2\u05a3\u0005q\u0000\u0000\u05a3\u05b0"+
		"\u0001\u0000\u0000\u0000\u05a4\u05a5\u0003\n\u0005\u0000\u05a5\u05a6\u0003"+
		"\u00f8|\u0000\u05a6\u05a7\u0003h4\u0000\u05a7\u05ac\u0003\u0094J\u0000"+
		"\u05a8\u05a9\u0005W\u0000\u0000\u05a9\u05ab\u0003\u00d6k\u0000\u05aa\u05a8"+
		"\u0001\u0000\u0000\u0000\u05ab\u05ae\u0001\u0000\u0000\u0000\u05ac\u05aa"+
		"\u0001\u0000\u0000\u0000\u05ac\u05ad\u0001\u0000\u0000\u0000\u05ad\u05b0"+
		"\u0001\u0000\u0000\u0000\u05ae\u05ac\u0001\u0000\u0000\u0000\u05af\u059f"+
		"\u0001\u0000\u0000\u0000\u05af\u05a4\u0001\u0000\u0000\u0000\u05b0\u05b6"+
		"\u0001\u0000\u0000\u0000\u05b1\u05b2\n\u0001\u0000\u0000\u05b2\u05b3\u0005"+
		"W\u0000\u0000\u05b3\u05b5\u0003\u00d6k\u0000\u05b4\u05b1\u0001\u0000\u0000"+
		"\u0000\u05b5\u05b8\u0001\u0000\u0000\u0000\u05b6\u05b4\u0001\u0000\u0000"+
		"\u0000\u05b6\u05b7\u0001\u0000\u0000\u0000\u05b7\u00e3\u0001\u0000\u0000"+
		"\u0000\u05b8\u05b6\u0001\u0000\u0000\u0000\u05b9\u05ba\u0003J%\u0000\u05ba"+
		"\u05bb\u0005x\u0000\u0000\u05bb\u05bd\u0001\u0000\u0000\u0000\u05bc\u05b9"+
		"\u0001\u0000\u0000\u0000\u05bc\u05bd\u0001\u0000\u0000\u0000\u05bd\u05be"+
		"\u0001\u0000\u0000\u0000\u05be\u05bf\u0003h4\u0000\u05bf\u05c1\u0003\u0094"+
		"J\u0000\u05c0\u05c2\u0003\u00fc~\u0000\u05c1\u05c0\u0001\u0000\u0000\u0000"+
		"\u05c1\u05c2\u0001\u0000\u0000\u0000\u05c2\u00e5\u0001\u0000\u0000\u0000"+
		"\u05c3\u05c5\u0003\u00f4z\u0000\u05c4\u05c3\u0001\u0000\u0000\u0000\u05c4"+
		"\u05c5\u0001\u0000\u0000\u0000\u05c5\u05c6\u0001\u0000\u0000\u0000\u05c6"+
		"\u05c7\u0003\u00e8t\u0000\u05c7\u05c8\u0003\u00eew\u0000\u05c8\u05cd\u0001"+
		"\u0000\u0000\u0000\u05c9\u05ca\u0003\u00e8t\u0000\u05ca\u05cb\u0003\u00ec"+
		"v\u0000\u05cb\u05cd\u0001\u0000\u0000\u0000\u05cc\u05c4\u0001\u0000\u0000"+
		"\u0000\u05cc\u05c9\u0001\u0000\u0000\u0000\u05cd\u00e7\u0001\u0000\u0000"+
		"\u0000\u05ce\u05d0\u0003\u0094J\u0000\u05cf\u05d1\u0003\u00f2y\u0000\u05d0"+
		"\u05cf\u0001\u0000\u0000\u0000\u05d0\u05d1\u0001\u0000\u0000\u0000\u05d1"+
		"\u05d9\u0001\u0000\u0000\u0000\u05d2\u05d3\u0005x\u0000\u0000\u05d3\u05d5"+
		"\u0003\u0094J\u0000\u05d4\u05d6\u0003\u00f2y\u0000\u05d5\u05d4\u0001\u0000"+
		"\u0000\u0000\u05d5\u05d6\u0001\u0000\u0000\u0000\u05d6\u05d8\u0001\u0000"+
		"\u0000\u0000\u05d7\u05d2\u0001\u0000\u0000\u0000\u05d8\u05db\u0001\u0000"+
		"\u0000\u0000\u05d9\u05d7\u0001\u0000\u0000\u0000\u05d9\u05da\u0001\u0000"+
		"\u0000\u0000\u05da\u05de\u0001\u0000\u0000\u0000\u05db\u05d9\u0001\u0000"+
		"\u0000\u0000\u05dc\u05de\u0003\u00fa}\u0000\u05dd\u05ce\u0001\u0000\u0000"+
		"\u0000\u05dd\u05dc\u0001\u0000\u0000\u0000\u05de\u00e9\u0001\u0000\u0000"+
		"\u0000\u05df\u05e3\u0003\u0094J\u0000\u05e0\u05e1\u0005R\u0000\u0000\u05e1"+
		"\u05e4\u0005Q\u0000\u0000\u05e2\u05e4\u0003\u00f4z\u0000\u05e3\u05e0\u0001"+
		"\u0000\u0000\u0000\u05e3\u05e2\u0001\u0000\u0000\u0000\u05e3\u05e4\u0001"+
		"\u0000\u0000\u0000\u05e4\u05e5\u0001\u0000\u0000\u0000\u05e5\u05e6\u0003"+
		"\u00eew\u0000\u05e6\u00eb\u0001\u0000\u0000\u0000\u05e7\u05e8\u0005t\u0000"+
		"\u0000\u05e8\u05ea\u0005u\u0000\u0000\u05e9\u05e7\u0001\u0000\u0000\u0000"+
		"\u05ea\u05eb\u0001\u0000\u0000\u0000\u05eb\u05e9\u0001\u0000\u0000\u0000"+
		"\u05eb\u05ec\u0001\u0000\u0000\u0000\u05ec\u05ed\u0001\u0000\u0000\u0000"+
		"\u05ed\u05fe\u0003H$\u0000\u05ee\u05ef\u0005t\u0000\u0000\u05ef\u05f0"+
		"\u0003\u00d6k\u0000\u05f0\u05f1\u0005u\u0000\u0000\u05f1\u05f3\u0001\u0000"+
		"\u0000\u0000\u05f2\u05ee\u0001\u0000\u0000\u0000\u05f3\u05f4\u0001\u0000"+
		"\u0000\u0000\u05f4\u05f2\u0001\u0000\u0000\u0000\u05f4\u05f5\u0001\u0000"+
		"\u0000\u0000\u05f5\u05fa\u0001\u0000\u0000\u0000\u05f6\u05f7\u0005t\u0000"+
		"\u0000\u05f7\u05f9\u0005u\u0000\u0000\u05f8\u05f6\u0001\u0000\u0000\u0000"+
		"\u05f9\u05fc\u0001\u0000\u0000\u0000\u05fa\u05f8\u0001\u0000\u0000\u0000"+
		"\u05fa\u05fb\u0001\u0000\u0000\u0000\u05fb\u05fe\u0001\u0000\u0000\u0000"+
		"\u05fc\u05fa\u0001\u0000\u0000\u0000\u05fd\u05e9\u0001\u0000\u0000\u0000"+
		"\u05fd\u05f2\u0001\u0000\u0000\u0000\u05fe\u00ed\u0001\u0000\u0000\u0000"+
		"\u05ff\u0601\u0003\u0102\u0081\u0000\u0600\u0602\u0003\u0018\f\u0000\u0601"+
		"\u0600\u0001\u0000\u0000\u0000\u0601\u0602\u0001\u0000\u0000\u0000\u0602"+
		"\u00ef\u0001\u0000\u0000\u0000\u0603\u0604\u0003\u00f4z\u0000\u0604\u0605"+
		"\u0003\u0100\u0080\u0000\u0605\u00f1\u0001\u0000\u0000\u0000\u0606\u0607"+
		"\u0005R\u0000\u0000\u0607\u060a\u0005Q\u0000\u0000\u0608\u060a\u0003\u00fc"+
		"~\u0000\u0609\u0606\u0001\u0000\u0000\u0000\u0609\u0608\u0001\u0000\u0000"+
		"\u0000\u060a\u00f3\u0001\u0000\u0000\u0000\u060b\u060c\u0005R\u0000\u0000"+
		"\u060c\u060d\u0003\u00f6{\u0000\u060d\u060e\u0005Q\u0000\u0000\u060e\u00f5"+
		"\u0001\u0000\u0000\u0000\u060f\u0614\u0003\u00f8|\u0000\u0610\u0611\u0005"+
		"w\u0000\u0000\u0611\u0613\u0003\u00f8|\u0000\u0612\u0610\u0001\u0000\u0000"+
		"\u0000\u0613\u0616\u0001\u0000\u0000\u0000\u0614\u0612\u0001\u0000\u0000"+
		"\u0000\u0614\u0615\u0001\u0000\u0000\u0000\u0615\u00f7\u0001\u0000\u0000"+
		"\u0000\u0616\u0614\u0001\u0000\u0000\u0000\u0617\u061a\u0003h4\u0000\u0618"+
		"\u061b\u0003J%\u0000\u0619\u061b\u0003\u00fa}\u0000\u061a\u0618\u0001"+
		"\u0000\u0000\u0000\u061a\u0619\u0001\u0000\u0000\u0000\u061b\u0622\u0001"+
		"\u0000\u0000\u0000\u061c\u061d\u0003h4\u0000\u061d\u061e\u0005t\u0000"+
		"\u0000\u061e\u061f\u0005u\u0000\u0000\u061f\u0621\u0001\u0000\u0000\u0000"+
		"\u0620\u061c\u0001\u0000\u0000\u0000\u0621\u0624\u0001\u0000\u0000\u0000"+
		"\u0622\u0620\u0001\u0000\u0000\u0000\u0622\u0623\u0001\u0000\u0000\u0000"+
		"\u0623\u00f9\u0001\u0000\u0000\u0000\u0624\u0622\u0001\u0000\u0000\u0000"+
		"\u0625\u0626\u0007\u000e\u0000\u0000\u0626\u00fb\u0001\u0000\u0000\u0000"+
		"\u0627\u0628\u0005R\u0000\u0000\u0628\u062d\u0003L&\u0000\u0629\u062a"+
		"\u0005w\u0000\u0000\u062a\u062c\u0003L&\u0000\u062b\u0629\u0001\u0000"+
		"\u0000\u0000\u062c\u062f\u0001\u0000\u0000\u0000\u062d\u062b\u0001\u0000"+
		"\u0000\u0000\u062d\u062e\u0001\u0000\u0000\u0000\u062e\u0630\u0001\u0000"+
		"\u0000\u0000\u062f\u062d\u0001\u0000\u0000\u0000\u0630\u0631\u0005Q\u0000"+
		"\u0000\u0631\u00fd\u0001\u0000\u0000\u0000\u0632\u063c\u0003\u0102\u0081"+
		"\u0000\u0633\u0635\u0005x\u0000\u0000\u0634\u0636\u0003\u00fc~\u0000\u0635"+
		"\u0634\u0001\u0000\u0000\u0000\u0635\u0636\u0001\u0000\u0000\u0000\u0636"+
		"\u0637\u0001\u0000\u0000\u0000\u0637\u0639\u0003\u0094J\u0000\u0638\u063a"+
		"\u0003\u0102\u0081\u0000\u0639\u0638\u0001\u0000\u0000\u0000\u0639\u063a"+
		"\u0001\u0000\u0000\u0000\u063a\u063c\u0001\u0000\u0000\u0000\u063b\u0632"+
		"\u0001\u0000\u0000\u0000\u063b\u0633\u0001\u0000\u0000\u0000\u063c\u00ff"+
		"\u0001\u0000\u0000\u0000\u063d\u063e\u0005,\u0000\u0000\u063e\u0643\u0003"+
		"\u00fe\u007f\u0000\u063f\u0640\u0003\u0094J\u0000\u0640\u0641\u0003\u0102"+
		"\u0081\u0000\u0641\u0643\u0001\u0000\u0000\u0000\u0642\u063d\u0001\u0000"+
		"\u0000\u0000\u0642\u063f\u0001\u0000\u0000\u0000\u0643\u0101\u0001\u0000"+
		"\u0000\u0000\u0644\u0646\u0005p\u0000\u0000\u0645\u0647\u0003\u00d2i\u0000"+
		"\u0646\u0645\u0001\u0000\u0000\u0000\u0646\u0647\u0001\u0000\u0000\u0000"+
		"\u0647\u0648\u0001\u0000\u0000\u0000\u0648\u0649\u0005q\u0000\u0000\u0649"+
		"\u0103\u0001\u0000\u0000\u0000\u00c1\u0105\u0108\u010d\u0110\u0113\u0118"+
		"\u011b\u0120\u0125\u012b\u0130\u0139\u013e\u0152\u0154\u015d\u0164\u0168"+
		"\u016c\u0170\u0175\u0179\u017d\u0182\u0187\u018d\u0197\u019d\u01a0\u01a6"+
		"\u01a9\u01b0\u01b8\u01bc\u01c4\u01cf\u01d6\u01de\u01e4\u01e7\u01ef\u01f2"+
		"\u01fa\u01ff\u0205\u020a\u0210\u0215\u021b\u0220\u0226\u0229\u0232\u0237"+
		"\u023e\u0244\u0247\u0252\u0257\u0260\u026a\u0275\u027b\u0282\u0287\u028f"+
		"\u0293\u0295\u029b\u02a1\u02a6\u02ad\u02af\u02b6\u02bb\u02c0\u02c3\u02c5"+
		"\u02cf\u02d9\u02de\u02e1\u02f2\u02fe\u0308\u0313\u031c\u0322\u0327\u032a"+
		"\u0331\u033b\u0343\u0346\u0349\u0351\u0359\u035b\u035f\u0365\u036d\u0377"+
		"\u0381\u0389\u0397\u039d\u03a6\u03af\u03b1\u03b9\u03bf\u03c7\u03cb\u03d0"+
		"\u03d4\u03d6\u03e4\u03fe\u0404\u0427\u042a\u042d\u0435\u0439\u0445\u044f"+
		"\u0455\u0471\u047a\u0483\u048c\u0492\u049a\u049f\u04a3\u04a7\u04ab\u04ad"+
		"\u04b1\u04b6\u04c5\u04cb\u04e0\u04e6\u04ea\u04ef\u0500\u0509\u0519\u0546"+
		"\u054c\u0551\u055a\u055c\u055e\u056d\u0576\u057d\u0580\u0584\u058a\u058f"+
		"\u0591\u0598\u059a\u059d\u05ac\u05af\u05b6\u05bc\u05c1\u05c4\u05cc\u05d0"+
		"\u05d5\u05d9\u05dd\u05e3\u05eb\u05f4\u05fa\u05fd\u0601\u0609\u0614\u061a"+
		"\u0622\u062d\u0635\u0639\u063b\u0642\u0646";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}