package org.example.parser.java.antlr;// Generated from .\src\main\antlr4\JavaParser.g4 by ANTLR 4.9.3
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import org.example.parser.common.context.ExtendContext;

import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class JavaParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.3", RuntimeMetaData.VERSION); }

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

	public static class CompilationUnitContext extends ExtendContext {
		@Override
		public CompilationUnitContext clone() throws CloneNotSupportedException {
			return new CompilationUnitContext(getParent(), invokingState);
		}
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
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).enterCompilationUnit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).exitCompilationUnit(this);
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
					while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
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
					if (((((_la - 24)) & ~0x3f) == 0 && ((1L << (_la - 24)) & ((1L << (ABSTRACT - 24)) | (1L << (CLASS - 24)) | (1L << (DEFAULT - 24)) | (1L << (ENUM - 24)) | (1L << (FINAL - 24)) | (1L << (INTERFACE - 24)) | (1L << (NATIVE - 24)) | (1L << (PRIVATE - 24)) | (1L << (PROTECTED - 24)) | (1L << (PUBLIC - 24)) | (1L << (STATIC - 24)) | (1L << (STRICTFP - 24)) | (1L << (SYNCHRONIZED - 24)) | (1L << (TRANSIENT - 24)) | (1L << (VOLATILE - 24)) | (1L << (MODULE - 24)) | (1L << (OPEN - 24)) | (1L << (REQUIRES - 24)) | (1L << (EXPORTS - 24)) | (1L << (OPENS - 24)) | (1L << (TO - 24)) | (1L << (USES - 24)) | (1L << (PROVIDES - 24)) | (1L << (WITH - 24)) | (1L << (TRANSITIVE - 24)) | (1L << (VAR - 24)) | (1L << (YIELD - 24)) | (1L << (RECORD - 24)) | (1L << (SEALED - 24)) | (1L << (PERMITS - 24)) | (1L << (NON_SEALED - 24)))) != 0) || _la==IDENTIFIER || _la==AT) {
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

	public static class ImportDeclarationListContext extends ExtendContext {
		@Override
		public ImportDeclarationListContext clone() throws CloneNotSupportedException {
			return new ImportDeclarationListContext(getParent(), invokingState);
		}
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
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).enterImportDeclarationList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).exitImportDeclarationList(this);
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

	public static class TypeDeclarationListContext extends ExtendContext {
		@Override
		public TypeDeclarationListContext clone() throws CloneNotSupportedException {
			return new TypeDeclarationListContext(getParent(), invokingState);
		}
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
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).enterTypeDeclarationList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).exitTypeDeclarationList(this);
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
					while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
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
			} while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PackageDeclarationContext extends ExtendContext {
		@Override
		public PackageDeclarationContext clone() throws CloneNotSupportedException {
			return new PackageDeclarationContext(getParent(), invokingState);
		}
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
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).enterPackageDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).exitPackageDeclaration(this);
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

	public static class ImportDeclarationContext extends ExtendContext {
		@Override
		public ImportDeclarationContext clone() throws CloneNotSupportedException {
			return new ImportDeclarationContext(getParent(), invokingState);
		}
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
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).enterImportDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).exitImportDeclaration(this);
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

	public static class ModifierListContext extends ExtendContext {
		@Override
		public ModifierListContext clone() throws CloneNotSupportedException {
			return new ModifierListContext(getParent(), invokingState);
		}
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
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).enterModifierList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).exitModifierList(this);
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
			while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
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

	public static class TypeDeclarationContext extends ExtendContext {
		@Override
		public TypeDeclarationContext clone() throws CloneNotSupportedException {
			return new TypeDeclarationContext(getParent(), invokingState);
		}
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
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).enterTypeDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).exitTypeDeclaration(this);
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

	public static class ClassHeadContext extends ExtendContext {
		@Override
		public ClassHeadContext clone() throws CloneNotSupportedException {
			return new ClassHeadContext(getParent(), invokingState);
		}
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
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).enterClassHead(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).exitClassHead(this);
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

	public static class InterfaceHeadContext extends ExtendContext {
		@Override
		public InterfaceHeadContext clone() throws CloneNotSupportedException {
			return new InterfaceHeadContext(getParent(), invokingState);
		}
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
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).enterInterfaceHead(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).exitInterfaceHead(this);
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

	public static class RecordHeadContext extends ExtendContext {
		@Override
		public RecordHeadContext clone() throws CloneNotSupportedException {
			return new RecordHeadContext(getParent(), invokingState);
		}
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
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).enterRecordHead(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).exitRecordHead(this);
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

	public static class EnumHeadContext extends ExtendContext {
		@Override
		public EnumHeadContext clone() throws CloneNotSupportedException {
			return new EnumHeadContext(getParent(), invokingState);
		}
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
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).enterEnumHead(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).exitEnumHead(this);
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

	public static class AnnotationTypeHeadContext extends ExtendContext {
		@Override
		public AnnotationTypeHeadContext clone() throws CloneNotSupportedException {
			return new AnnotationTypeHeadContext(getParent(), invokingState);
		}
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
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).enterAnnotationTypeHead(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).exitAnnotationTypeHead(this);
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

	public static class BodyContext extends ExtendContext {
		@Override
		public BodyContext clone() throws CloneNotSupportedException {
			return new BodyContext(getParent(), invokingState);
		}
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
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).enterBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).exitBody(this);
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
				while (((((_la - 1)) & ~0x3f) == 0 && ((1L << (_la - 1)) & ((1L << (BOOLEAN - 1)) | (1L << (BYTE - 1)) | (1L << (CHAR - 1)) | (1L << (DOUBLE - 1)) | (1L << (FLOAT - 1)) | (1L << (INT - 1)) | (1L << (LONG - 1)) | (1L << (SHORT - 1)) | (1L << (VOID - 1)) | (1L << (ABSTRACT - 1)) | (1L << (CLASS - 1)) | (1L << (DEFAULT - 1)) | (1L << (ENUM - 1)) | (1L << (FINAL - 1)) | (1L << (INTERFACE - 1)) | (1L << (NATIVE - 1)) | (1L << (PRIVATE - 1)) | (1L << (PROTECTED - 1)) | (1L << (PUBLIC - 1)) | (1L << (STATIC - 1)) | (1L << (STRICTFP - 1)) | (1L << (SYNCHRONIZED - 1)) | (1L << (TRANSIENT - 1)) | (1L << (VOLATILE - 1)) | (1L << (MODULE - 1)) | (1L << (OPEN - 1)) | (1L << (REQUIRES - 1)) | (1L << (EXPORTS - 1)) | (1L << (OPENS - 1)) | (1L << (TO - 1)) | (1L << (USES - 1)) | (1L << (PROVIDES - 1)) | (1L << (WITH - 1)) | (1L << (TRANSITIVE - 1)) | (1L << (VAR - 1)) | (1L << (YIELD - 1)) | (1L << (RECORD - 1)) | (1L << (SEALED - 1)))) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (PERMITS - 65)) | (1L << (NON_SEALED - 65)) | (1L << (LT - 65)) | (1L << (LBRACE - 65)) | (1L << (SEMI - 65)) | (1L << (IDENTIFIER - 65)) | (1L << (AT - 65)))) != 0)) {
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
				if (((((_la - 51)) & ~0x3f) == 0 && ((1L << (_la - 51)) & ((1L << (MODULE - 51)) | (1L << (OPEN - 51)) | (1L << (REQUIRES - 51)) | (1L << (EXPORTS - 51)) | (1L << (OPENS - 51)) | (1L << (TO - 51)) | (1L << (USES - 51)) | (1L << (PROVIDES - 51)) | (1L << (WITH - 51)) | (1L << (TRANSITIVE - 51)) | (1L << (VAR - 51)) | (1L << (YIELD - 51)) | (1L << (RECORD - 51)) | (1L << (SEALED - 51)) | (1L << (PERMITS - 51)))) != 0) || _la==IDENTIFIER || _la==AT) {
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
					while (((((_la - 1)) & ~0x3f) == 0 && ((1L << (_la - 1)) & ((1L << (BOOLEAN - 1)) | (1L << (BYTE - 1)) | (1L << (CHAR - 1)) | (1L << (DOUBLE - 1)) | (1L << (FLOAT - 1)) | (1L << (INT - 1)) | (1L << (LONG - 1)) | (1L << (SHORT - 1)) | (1L << (VOID - 1)) | (1L << (ABSTRACT - 1)) | (1L << (CLASS - 1)) | (1L << (DEFAULT - 1)) | (1L << (ENUM - 1)) | (1L << (FINAL - 1)) | (1L << (INTERFACE - 1)) | (1L << (NATIVE - 1)) | (1L << (PRIVATE - 1)) | (1L << (PROTECTED - 1)) | (1L << (PUBLIC - 1)) | (1L << (STATIC - 1)) | (1L << (STRICTFP - 1)) | (1L << (SYNCHRONIZED - 1)) | (1L << (TRANSIENT - 1)) | (1L << (VOLATILE - 1)) | (1L << (MODULE - 1)) | (1L << (OPEN - 1)) | (1L << (REQUIRES - 1)) | (1L << (EXPORTS - 1)) | (1L << (OPENS - 1)) | (1L << (TO - 1)) | (1L << (USES - 1)) | (1L << (PROVIDES - 1)) | (1L << (WITH - 1)) | (1L << (TRANSITIVE - 1)) | (1L << (VAR - 1)) | (1L << (YIELD - 1)) | (1L << (RECORD - 1)) | (1L << (SEALED - 1)))) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (PERMITS - 65)) | (1L << (NON_SEALED - 65)) | (1L << (LT - 65)) | (1L << (LBRACE - 65)) | (1L << (SEMI - 65)) | (1L << (IDENTIFIER - 65)) | (1L << (AT - 65)))) != 0)) {
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
				while (((((_la - 1)) & ~0x3f) == 0 && ((1L << (_la - 1)) & ((1L << (BOOLEAN - 1)) | (1L << (BYTE - 1)) | (1L << (CHAR - 1)) | (1L << (DOUBLE - 1)) | (1L << (FLOAT - 1)) | (1L << (INT - 1)) | (1L << (LONG - 1)) | (1L << (SHORT - 1)) | (1L << (VOID - 1)) | (1L << (ABSTRACT - 1)) | (1L << (CLASS - 1)) | (1L << (DEFAULT - 1)) | (1L << (ENUM - 1)) | (1L << (FINAL - 1)) | (1L << (INTERFACE - 1)) | (1L << (NATIVE - 1)) | (1L << (PRIVATE - 1)) | (1L << (PROTECTED - 1)) | (1L << (PUBLIC - 1)) | (1L << (STATIC - 1)) | (1L << (STRICTFP - 1)) | (1L << (SYNCHRONIZED - 1)) | (1L << (TRANSIENT - 1)) | (1L << (VOLATILE - 1)) | (1L << (MODULE - 1)) | (1L << (OPEN - 1)) | (1L << (REQUIRES - 1)) | (1L << (EXPORTS - 1)) | (1L << (OPENS - 1)) | (1L << (TO - 1)) | (1L << (USES - 1)) | (1L << (PROVIDES - 1)) | (1L << (WITH - 1)) | (1L << (TRANSITIVE - 1)) | (1L << (VAR - 1)) | (1L << (YIELD - 1)) | (1L << (RECORD - 1)) | (1L << (SEALED - 1)))) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (PERMITS - 65)) | (1L << (NON_SEALED - 65)) | (1L << (SEMI - 65)) | (1L << (IDENTIFIER - 65)) | (1L << (AT - 65)))) != 0)) {
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
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << REQUIRES) | (1L << EXPORTS) | (1L << OPENS) | (1L << USES) | (1L << PROVIDES))) != 0)) {
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

	public static class TypeParametersContext extends ExtendContext {
		@Override
		public TypeParametersContext clone() throws CloneNotSupportedException {
			return new TypeParametersContext(getParent(), invokingState);
		}
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
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).enterTypeParameters(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).exitTypeParameters(this);
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

	public static class TypeParameterContext extends ExtendContext {
		@Override
		public TypeParameterContext clone() throws CloneNotSupportedException {
			return new TypeParameterContext(getParent(), invokingState);
		}
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
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).enterTypeParameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).exitTypeParameter(this);
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

	public static class TypeBoundContext extends ExtendContext {
		@Override
		public TypeBoundContext clone() throws CloneNotSupportedException {
			return new TypeBoundContext(getParent(), invokingState);
		}
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
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).enterTypeBound(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).exitTypeBound(this);
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

	public static class EnumConstantsContext extends ExtendContext {
		@Override
		public EnumConstantsContext clone() throws CloneNotSupportedException {
			return new EnumConstantsContext(getParent(), invokingState);
		}
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
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).enterEnumConstants(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).exitEnumConstants(this);
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
			while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
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

	public static class EnumConstantContext extends ExtendContext {
		@Override
		public EnumConstantContext clone() throws CloneNotSupportedException {
			return new EnumConstantContext(getParent(), invokingState);
		}
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
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).enterEnumConstant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).exitEnumConstant(this);
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

	public static class ClassBodyDeclarationContext extends ExtendContext {
		@Override
		public ClassBodyDeclarationContext clone() throws CloneNotSupportedException {
			return new ClassBodyDeclarationContext(getParent(), invokingState);
		}
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
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).enterClassBodyDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).exitClassBodyDeclaration(this);
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

	public static class InitializerContext extends ExtendContext {
		@Override
		public InitializerContext clone() throws CloneNotSupportedException {
			return new InitializerContext(getParent(), invokingState);
		}
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
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).enterInitializer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).exitInitializer(this);
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

	public static class InitializerListContext extends ExtendContext {
		@Override
		public InitializerListContext clone() throws CloneNotSupportedException {
			return new InitializerListContext(getParent(), invokingState);
		}
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
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).enterInitializerList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).exitInitializerList(this);
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
					while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
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
			} while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FieldDeclarationListContext extends ExtendContext {
		@Override
		public FieldDeclarationListContext clone() throws CloneNotSupportedException {
			return new FieldDeclarationListContext(getParent(), invokingState);
		}
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
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).enterFieldDeclarationList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).exitFieldDeclarationList(this);
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
					while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
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
			} while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstructorDeclarationListContext extends ExtendContext {
		@Override
		public ConstructorDeclarationListContext clone() throws CloneNotSupportedException {
			return new ConstructorDeclarationListContext(getParent(), invokingState);
		}
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
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).enterConstructorDeclarationList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).exitConstructorDeclarationList(this);
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
					while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
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
			} while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MethodDeclarationListContext extends ExtendContext {
		@Override
		public MethodDeclarationListContext clone() throws CloneNotSupportedException {
			return new MethodDeclarationListContext(getParent(), invokingState);
		}
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
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).enterMethodDeclarationList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).exitMethodDeclarationList(this);
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
					while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
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
			} while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MethodDeclarationContext extends ExtendContext {
		@Override
		public MethodDeclarationContext clone() throws CloneNotSupportedException {
			return new MethodDeclarationContext(getParent(), invokingState);
		}
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
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).enterMethodDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).exitMethodDeclaration(this);
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

	public static class MethodHeadContext extends ExtendContext {
		@Override
		public MethodHeadContext clone() throws CloneNotSupportedException {
			return new MethodHeadContext(getParent(), invokingState);
		}
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
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).enterMethodHead(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).exitMethodHead(this);
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

	public static class ConstructorDeclarationContext extends ExtendContext {
		@Override
		public ConstructorDeclarationContext clone() throws CloneNotSupportedException {
			return new ConstructorDeclarationContext(getParent(), invokingState);
		}
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
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).enterConstructorDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).exitConstructorDeclaration(this);
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

	public static class ConstructorHeadContext extends ExtendContext {
		@Override
		public ConstructorHeadContext clone() throws CloneNotSupportedException {
			return new ConstructorHeadContext(getParent(), invokingState);
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
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).enterConstructorHead(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).exitConstructorHead(this);
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

	public static class FieldDeclarationContext extends ExtendContext {
		@Override
		public FieldDeclarationContext clone() throws CloneNotSupportedException {
			return new FieldDeclarationContext(getParent(), invokingState);
		}
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
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).enterFieldDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).exitFieldDeclaration(this);
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

	public static class ConstDeclarationListContext extends ExtendContext {
		@Override
		public ConstDeclarationListContext clone() throws CloneNotSupportedException {
			return new ConstDeclarationListContext(getParent(), invokingState);
		}
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
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).enterConstDeclarationList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).exitConstDeclarationList(this);
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
			} while ( ((((_la - 1)) & ~0x3f) == 0 && ((1L << (_la - 1)) & ((1L << (BOOLEAN - 1)) | (1L << (BYTE - 1)) | (1L << (CHAR - 1)) | (1L << (DOUBLE - 1)) | (1L << (FLOAT - 1)) | (1L << (INT - 1)) | (1L << (LONG - 1)) | (1L << (SHORT - 1)) | (1L << (VOID - 1)) | (1L << (ABSTRACT - 1)) | (1L << (DEFAULT - 1)) | (1L << (FINAL - 1)) | (1L << (NATIVE - 1)) | (1L << (PRIVATE - 1)) | (1L << (PROTECTED - 1)) | (1L << (PUBLIC - 1)) | (1L << (STATIC - 1)) | (1L << (STRICTFP - 1)) | (1L << (SYNCHRONIZED - 1)) | (1L << (TRANSIENT - 1)) | (1L << (VOLATILE - 1)) | (1L << (MODULE - 1)) | (1L << (OPEN - 1)) | (1L << (REQUIRES - 1)) | (1L << (EXPORTS - 1)) | (1L << (OPENS - 1)) | (1L << (TO - 1)) | (1L << (USES - 1)) | (1L << (PROVIDES - 1)) | (1L << (WITH - 1)) | (1L << (TRANSITIVE - 1)) | (1L << (VAR - 1)) | (1L << (YIELD - 1)) | (1L << (RECORD - 1)) | (1L << (SEALED - 1)))) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (PERMITS - 65)) | (1L << (NON_SEALED - 65)) | (1L << (IDENTIFIER - 65)) | (1L << (AT - 65)))) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstDeclarationContext extends ExtendContext {
		@Override
		public ConstDeclarationContext clone() throws CloneNotSupportedException {
			return new ConstDeclarationContext(getParent(), invokingState);
		}
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
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).enterConstDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).exitConstDeclaration(this);
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

	public static class ConstantDeclaratorContext extends ExtendContext {
		@Override
		public ConstantDeclaratorContext clone() throws CloneNotSupportedException {
			return new ConstantDeclaratorContext(getParent(), invokingState);
		}
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
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).enterConstantDeclarator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).exitConstantDeclarator(this);
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

	public static class VariableDeclaratorsContext extends ExtendContext {
		@Override
		public VariableDeclaratorsContext clone() throws CloneNotSupportedException {
			return new VariableDeclaratorsContext(getParent(), invokingState);
		}
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
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).enterVariableDeclarators(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).exitVariableDeclarators(this);
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

	public static class VariableDeclaratorContext extends ExtendContext {

		@Override
		public VariableDeclaratorContext clone() throws CloneNotSupportedException {
			return new VariableDeclaratorContext(getParent(), invokingState);
		}
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
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).enterVariableDeclarator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).exitVariableDeclarator(this);
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

	public static class VariableDeclaratorIdContext extends ExtendContext {
		@Override
		public VariableDeclaratorIdContext clone() throws CloneNotSupportedException {
			return new VariableDeclaratorIdContext(getParent(), invokingState);
		}
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
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).enterVariableDeclaratorId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).exitVariableDeclaratorId(this);
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

	public static class VariableInitializerContext extends ExtendContext {
		@Override
		public VariableInitializerContext clone() throws CloneNotSupportedException {
			return new VariableInitializerContext(getParent(), invokingState);
		}
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
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).enterVariableInitializer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).exitVariableInitializer(this);
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

	public static class ArrayInitializerContext extends ExtendContext {
		@Override
		public ArrayInitializerContext clone() throws CloneNotSupportedException {
			return new ArrayInitializerContext(getParent(), invokingState);
		}
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
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).enterArrayInitializer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).exitArrayInitializer(this);
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
			if (((((_la - 1)) & ~0x3f) == 0 && ((1L << (_la - 1)) & ((1L << (BOOLEAN - 1)) | (1L << (BYTE - 1)) | (1L << (CHAR - 1)) | (1L << (DOUBLE - 1)) | (1L << (FLOAT - 1)) | (1L << (INT - 1)) | (1L << (LONG - 1)) | (1L << (SHORT - 1)) | (1L << (VOID - 1)) | (1L << (SWITCH - 1)) | (1L << (NEW - 1)) | (1L << (SUPER - 1)) | (1L << (THIS - 1)) | (1L << (MODULE - 1)) | (1L << (OPEN - 1)) | (1L << (REQUIRES - 1)) | (1L << (EXPORTS - 1)) | (1L << (OPENS - 1)) | (1L << (TO - 1)) | (1L << (USES - 1)) | (1L << (PROVIDES - 1)) | (1L << (WITH - 1)) | (1L << (TRANSITIVE - 1)) | (1L << (VAR - 1)) | (1L << (YIELD - 1)) | (1L << (RECORD - 1)) | (1L << (SEALED - 1)))) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (PERMITS - 65)) | (1L << (DECIMAL_LITERAL - 65)) | (1L << (HEX_LITERAL - 65)) | (1L << (OCT_LITERAL - 65)) | (1L << (BINARY_LITERAL - 65)) | (1L << (FLOAT_LITERAL - 65)) | (1L << (HEX_FLOAT_LITERAL - 65)) | (1L << (CHAR_LITERAL - 65)) | (1L << (STRING_LITERAL - 65)) | (1L << (TEXT_BLOCK - 65)) | (1L << (BOOL_LITERAL - 65)) | (1L << (NULL_LITERAL - 65)) | (1L << (LT - 65)) | (1L << (ADD - 65)) | (1L << (SUB - 65)) | (1L << (TILDE - 65)) | (1L << (BANG - 65)) | (1L << (INC - 65)) | (1L << (DEC - 65)) | (1L << (LPAREN - 65)) | (1L << (LBRACE - 65)) | (1L << (IDENTIFIER - 65)) | (1L << (AT - 65)))) != 0)) {
				{
				setState(648);
				variableInitializer();
				setState(653);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,64,_ctx);
				while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
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

	public static class ClassOrInterfaceTypeContext extends ExtendContext {
		@Override
		public ClassOrInterfaceTypeContext clone() throws CloneNotSupportedException {
			return new ClassOrInterfaceTypeContext(getParent(), invokingState);
		}
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
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).enterClassOrInterfaceType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).exitClassOrInterfaceType(this);
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
			while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
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

	public static class TypeArgumentContext extends ExtendContext {
		@Override
		public TypeArgumentContext clone() throws CloneNotSupportedException {
			return new TypeArgumentContext(getParent(), invokingState);
		}
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
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).enterTypeArgument(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).exitTypeArgument(this);
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

	public static class QualifiedNameListContext extends ExtendContext {
		@Override
		public QualifiedNameListContext clone() throws CloneNotSupportedException {
			return new QualifiedNameListContext(getParent(), invokingState);
		}
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
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).enterQualifiedNameList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).exitQualifiedNameList(this);
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

	public static class FormalParametersContext extends ExtendContext {
		@Override
		public FormalParametersContext clone() throws CloneNotSupportedException {
			return new FormalParametersContext(getParent(), invokingState);
		}
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
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).enterFormalParameters(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).exitFormalParameters(this);
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
				if (((((_la - 1)) & ~0x3f) == 0 && ((1L << (_la - 1)) & ((1L << (BOOLEAN - 1)) | (1L << (BYTE - 1)) | (1L << (CHAR - 1)) | (1L << (DOUBLE - 1)) | (1L << (FLOAT - 1)) | (1L << (INT - 1)) | (1L << (LONG - 1)) | (1L << (SHORT - 1)) | (1L << (VOID - 1)) | (1L << (MODULE - 1)) | (1L << (OPEN - 1)) | (1L << (REQUIRES - 1)) | (1L << (EXPORTS - 1)) | (1L << (OPENS - 1)) | (1L << (TO - 1)) | (1L << (USES - 1)) | (1L << (PROVIDES - 1)) | (1L << (WITH - 1)) | (1L << (TRANSITIVE - 1)) | (1L << (VAR - 1)) | (1L << (YIELD - 1)) | (1L << (RECORD - 1)) | (1L << (SEALED - 1)))) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (PERMITS - 65)) | (1L << (IDENTIFIER - 65)) | (1L << (AT - 65)))) != 0)) {
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
				if (((((_la - 1)) & ~0x3f) == 0 && ((1L << (_la - 1)) & ((1L << (BOOLEAN - 1)) | (1L << (BYTE - 1)) | (1L << (CHAR - 1)) | (1L << (DOUBLE - 1)) | (1L << (FLOAT - 1)) | (1L << (INT - 1)) | (1L << (LONG - 1)) | (1L << (SHORT - 1)) | (1L << (VOID - 1)) | (1L << (ABSTRACT - 1)) | (1L << (DEFAULT - 1)) | (1L << (FINAL - 1)) | (1L << (NATIVE - 1)) | (1L << (PRIVATE - 1)) | (1L << (PROTECTED - 1)) | (1L << (PUBLIC - 1)) | (1L << (STATIC - 1)) | (1L << (STRICTFP - 1)) | (1L << (SYNCHRONIZED - 1)) | (1L << (TRANSIENT - 1)) | (1L << (VOLATILE - 1)) | (1L << (MODULE - 1)) | (1L << (OPEN - 1)) | (1L << (REQUIRES - 1)) | (1L << (EXPORTS - 1)) | (1L << (OPENS - 1)) | (1L << (TO - 1)) | (1L << (USES - 1)) | (1L << (PROVIDES - 1)) | (1L << (WITH - 1)) | (1L << (TRANSITIVE - 1)) | (1L << (VAR - 1)) | (1L << (YIELD - 1)) | (1L << (RECORD - 1)) | (1L << (SEALED - 1)))) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (PERMITS - 65)) | (1L << (NON_SEALED - 65)) | (1L << (IDENTIFIER - 65)) | (1L << (AT - 65)))) != 0)) {
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

	public static class ReceiverParameterContext extends ExtendContext {
		@Override
		public ReceiverParameterContext clone() throws CloneNotSupportedException {
			return new ReceiverParameterContext(getParent(), invokingState);
		}
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
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).enterReceiverParameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).exitReceiverParameter(this);
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
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MODULE) | (1L << OPEN) | (1L << REQUIRES) | (1L << EXPORTS) | (1L << OPENS) | (1L << TO) | (1L << USES) | (1L << PROVIDES) | (1L << WITH) | (1L << TRANSITIVE) | (1L << VAR) | (1L << YIELD) | (1L << RECORD))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (SEALED - 64)) | (1L << (PERMITS - 64)) | (1L << (IDENTIFIER - 64)))) != 0)) {
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

	public static class FormalParameterListContext extends ExtendContext {
		@Override
		public FormalParameterListContext clone() throws CloneNotSupportedException {
			return new FormalParameterListContext(getParent(), invokingState);
		}
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
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).enterFormalParameterList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).exitFormalParameterList(this);
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
				while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
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

	public static class FormalParameterContext extends ExtendContext {
		@Override
		public FormalParameterContext clone() throws CloneNotSupportedException {
			return new FormalParameterContext(getParent(), invokingState);
		}
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
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).enterFormalParameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).exitFormalParameter(this);
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

	public static class LastFormalParameterContext extends ExtendContext {
		@Override
		public LastFormalParameterContext clone() throws CloneNotSupportedException {
			return new LastFormalParameterContext(getParent(), invokingState);
		}
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
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).enterLastFormalParameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).exitLastFormalParameter(this);
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

	public static class LambdaLVTIListContext extends ExtendContext {
		@Override
		public LambdaLVTIListContext clone() throws CloneNotSupportedException {
			return new LambdaLVTIListContext(getParent(), invokingState);
		}
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
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).enterLambdaLVTIList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).exitLambdaLVTIList(this);
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

	public static class LambdaLVTIParameterContext extends ExtendContext {
		@Override
		public LambdaLVTIParameterContext clone() throws CloneNotSupportedException {
			return new LambdaLVTIParameterContext(getParent(), invokingState);
		}
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
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).enterLambdaLVTIParameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).exitLambdaLVTIParameter(this);
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

	public static class QualifiedNameContext extends ExtendContext {
		@Override
		public QualifiedNameContext clone() throws CloneNotSupportedException {
			return new QualifiedNameContext(getParent(), invokingState);
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
		public QualifiedNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_qualifiedName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).enterQualifiedName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).exitQualifiedName(this);
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
			while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
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

	public static class LiteralContext extends ExtendContext {
		@Override
		public LiteralContext clone() throws CloneNotSupportedException {
			return new LiteralContext(getParent(), invokingState);
		}
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
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).enterLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).exitLiteral(this);
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

	public static class IntegerLiteralContext extends ExtendContext {
		@Override
		public IntegerLiteralContext clone() throws CloneNotSupportedException {
			return new IntegerLiteralContext(getParent(), invokingState);
		}
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
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).enterIntegerLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).exitIntegerLiteral(this);
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
			if ( !(((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & ((1L << (DECIMAL_LITERAL - 67)) | (1L << (HEX_LITERAL - 67)) | (1L << (OCT_LITERAL - 67)) | (1L << (BINARY_LITERAL - 67)))) != 0)) ) {
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

	public static class FloatLiteralContext extends ExtendContext {
		@Override
		public FloatLiteralContext clone() throws CloneNotSupportedException {
			return new FloatLiteralContext(getParent(), invokingState);
		}
		public TerminalNode FLOAT_LITERAL() { return getToken(JavaParser.FLOAT_LITERAL, 0); }
		public TerminalNode HEX_FLOAT_LITERAL() { return getToken(JavaParser.HEX_FLOAT_LITERAL, 0); }
		public FloatLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_floatLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).enterFloatLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).exitFloatLiteral(this);
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

	public static class AltAnnotationQualifiedNameContext extends ExtendContext {
		@Override
		public AltAnnotationQualifiedNameContext clone() throws CloneNotSupportedException {
			return new AltAnnotationQualifiedNameContext(getParent(), invokingState);
		}
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
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).enterAltAnnotationQualifiedName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).exitAltAnnotationQualifiedName(this);
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
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MODULE) | (1L << OPEN) | (1L << REQUIRES) | (1L << EXPORTS) | (1L << OPENS) | (1L << TO) | (1L << USES) | (1L << PROVIDES) | (1L << WITH) | (1L << TRANSITIVE) | (1L << VAR) | (1L << YIELD) | (1L << RECORD))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (SEALED - 64)) | (1L << (PERMITS - 64)) | (1L << (IDENTIFIER - 64)))) != 0)) {
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

	public static class AnnotationListContext extends ExtendContext {
		@Override
		public AnnotationListContext clone() throws CloneNotSupportedException {
			return new AnnotationListContext(getParent(), invokingState);
		}
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
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).enterAnnotationList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).exitAnnotationList(this);
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
			while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
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

	public static class AnnotationContext extends ExtendContext {
		@Override
		public AnnotationContext clone() throws CloneNotSupportedException {
			return new AnnotationContext(getParent(), invokingState);
		}
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
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).enterAnnotation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).exitAnnotation(this);
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

	public static class ElementValuePairsContext extends ExtendContext {
		@Override
		public ElementValuePairsContext clone() throws CloneNotSupportedException {
			return new ElementValuePairsContext(getParent(), invokingState);
		}
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
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).enterElementValuePairs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).exitElementValuePairs(this);
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

	public static class ElementValuePairContext extends ExtendContext {
		@Override
		public ElementValuePairContext clone() throws CloneNotSupportedException {
			return new ElementValuePairContext(getParent(), invokingState);
		}
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
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).enterElementValuePair(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).exitElementValuePair(this);
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

	public static class ElementValueContext extends ExtendContext {
		@Override
		public ElementValueContext clone() throws CloneNotSupportedException {
			return new ElementValueContext(getParent(), invokingState);
		}
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
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).enterElementValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).exitElementValue(this);
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

	public static class ElementValueArrayInitializerContext extends ExtendContext {

		@Override
		public ElementValueArrayInitializerContext clone() throws CloneNotSupportedException {
			return new ElementValueArrayInitializerContext(getParent(), invokingState);
		}
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
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).enterElementValueArrayInitializer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).exitElementValueArrayInitializer(this);
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
			if (((((_la - 1)) & ~0x3f) == 0 && ((1L << (_la - 1)) & ((1L << (BOOLEAN - 1)) | (1L << (BYTE - 1)) | (1L << (CHAR - 1)) | (1L << (DOUBLE - 1)) | (1L << (FLOAT - 1)) | (1L << (INT - 1)) | (1L << (LONG - 1)) | (1L << (SHORT - 1)) | (1L << (VOID - 1)) | (1L << (SWITCH - 1)) | (1L << (NEW - 1)) | (1L << (SUPER - 1)) | (1L << (THIS - 1)) | (1L << (MODULE - 1)) | (1L << (OPEN - 1)) | (1L << (REQUIRES - 1)) | (1L << (EXPORTS - 1)) | (1L << (OPENS - 1)) | (1L << (TO - 1)) | (1L << (USES - 1)) | (1L << (PROVIDES - 1)) | (1L << (WITH - 1)) | (1L << (TRANSITIVE - 1)) | (1L << (VAR - 1)) | (1L << (YIELD - 1)) | (1L << (RECORD - 1)) | (1L << (SEALED - 1)))) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (PERMITS - 65)) | (1L << (DECIMAL_LITERAL - 65)) | (1L << (HEX_LITERAL - 65)) | (1L << (OCT_LITERAL - 65)) | (1L << (BINARY_LITERAL - 65)) | (1L << (FLOAT_LITERAL - 65)) | (1L << (HEX_FLOAT_LITERAL - 65)) | (1L << (CHAR_LITERAL - 65)) | (1L << (STRING_LITERAL - 65)) | (1L << (TEXT_BLOCK - 65)) | (1L << (BOOL_LITERAL - 65)) | (1L << (NULL_LITERAL - 65)) | (1L << (LT - 65)) | (1L << (ADD - 65)) | (1L << (SUB - 65)) | (1L << (TILDE - 65)) | (1L << (BANG - 65)) | (1L << (INC - 65)) | (1L << (DEC - 65)) | (1L << (LPAREN - 65)) | (1L << (LBRACE - 65)) | (1L << (IDENTIFIER - 65)) | (1L << (AT - 65)))) != 0)) {
				{
				setState(828);
				elementValue();
				setState(833);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,91,_ctx);
				while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
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

	public static class AnnotationTypeElementDeclarationContext extends ExtendContext {
		@Override
		public AnnotationTypeElementDeclarationContext clone() throws CloneNotSupportedException {
			return new AnnotationTypeElementDeclarationContext(getParent(), invokingState);
		}
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
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).enterAnnotationTypeElementDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).exitAnnotationTypeElementDeclaration(this);
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

	public static class AnnotationTypeElementRestContext extends ExtendContext {
		@Override
		public AnnotationTypeElementRestContext clone() throws CloneNotSupportedException {
			return new AnnotationTypeElementRestContext(getParent(), invokingState);
		}
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
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).enterAnnotationTypeElementRest(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).exitAnnotationTypeElementRest(this);
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

	public static class AnnotationMethodOrConstantRestContext extends ExtendContext {
		@Override
		public AnnotationMethodOrConstantRestContext clone() throws CloneNotSupportedException {
			return new AnnotationMethodOrConstantRestContext(getParent(), invokingState);
		}
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
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).enterAnnotationMethodOrConstantRest(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).exitAnnotationMethodOrConstantRest(this);
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

	public static class AnnotationMethodRestContext extends ExtendContext {
		@Override
		public AnnotationMethodRestContext clone() throws CloneNotSupportedException {
			return new AnnotationMethodRestContext(getParent(), invokingState);
		}
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
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).enterAnnotationMethodRest(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).exitAnnotationMethodRest(this);
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

	public static class AnnotationConstantRestContext extends ExtendContext {
		@Override
		public AnnotationConstantRestContext clone() throws CloneNotSupportedException {
			return new AnnotationConstantRestContext(getParent(), invokingState);
		}
		public VariableDeclaratorsContext variableDeclarators() {
			return getRuleContext(VariableDeclaratorsContext.class,0);
		}
		public AnnotationConstantRestContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_annotationConstantRest; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).enterAnnotationConstantRest(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).exitAnnotationConstantRest(this);
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

	public static class DefaultValueContext extends ExtendContext {
		@Override
		public DefaultValueContext clone() throws CloneNotSupportedException {
			return new DefaultValueContext(getParent(), invokingState);
		}
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
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).enterDefaultValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).exitDefaultValue(this);
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

	public static class ModuleDeclarationContext extends ExtendContext {
		@Override
		public ModuleDeclarationContext clone() throws CloneNotSupportedException {
			return new ModuleDeclarationContext(getParent(), invokingState);
		}
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
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).enterModuleDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).exitModuleDeclaration(this);
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

	public static class ModuleDirectiveContext extends ExtendContext {
		@Override
		public ModuleDirectiveContext clone() throws CloneNotSupportedException {
			return new ModuleDirectiveContext(getParent(), invokingState);
		}
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
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).enterModuleDirective(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).exitModuleDirective(this);
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
				while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
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

	public static class RequiresModifierContext extends ExtendContext {
		@Override
		public RequiresModifierContext clone() throws CloneNotSupportedException {
			return new RequiresModifierContext(getParent(), invokingState);
		}
		public TerminalNode TRANSITIVE() { return getToken(JavaParser.TRANSITIVE, 0); }
		public TerminalNode STATIC() { return getToken(JavaParser.STATIC, 0); }
		public RequiresModifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_requiresModifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).enterRequiresModifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).exitRequiresModifier(this);
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

	public static class RecordHeaderContext extends ExtendContext {
		@Override
		public RecordHeaderContext clone() throws CloneNotSupportedException {
			return new RecordHeaderContext(getParent(), invokingState);
		}
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
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).enterRecordHeader(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).exitRecordHeader(this);
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
			if (((((_la - 1)) & ~0x3f) == 0 && ((1L << (_la - 1)) & ((1L << (BOOLEAN - 1)) | (1L << (BYTE - 1)) | (1L << (CHAR - 1)) | (1L << (DOUBLE - 1)) | (1L << (FLOAT - 1)) | (1L << (INT - 1)) | (1L << (LONG - 1)) | (1L << (SHORT - 1)) | (1L << (VOID - 1)) | (1L << (MODULE - 1)) | (1L << (OPEN - 1)) | (1L << (REQUIRES - 1)) | (1L << (EXPORTS - 1)) | (1L << (OPENS - 1)) | (1L << (TO - 1)) | (1L << (USES - 1)) | (1L << (PROVIDES - 1)) | (1L << (WITH - 1)) | (1L << (TRANSITIVE - 1)) | (1L << (VAR - 1)) | (1L << (YIELD - 1)) | (1L << (RECORD - 1)) | (1L << (SEALED - 1)))) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (PERMITS - 65)) | (1L << (IDENTIFIER - 65)) | (1L << (AT - 65)))) != 0)) {
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

	public static class RecordComponentListContext extends ExtendContext {
		@Override
		public RecordComponentListContext clone() throws CloneNotSupportedException {
			return new RecordComponentListContext(getParent(), invokingState);
		}
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
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).enterRecordComponentList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).exitRecordComponentList(this);
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

	public static class RecordComponentContext extends ExtendContext {
		@Override
		public RecordComponentContext clone() throws CloneNotSupportedException {
			return new RecordComponentContext(getParent(), invokingState);
		}
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
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).enterRecordComponent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).exitRecordComponent(this);
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

	public static class BlockContext extends ExtendContext {
		@Override
		public BlockContext clone() throws CloneNotSupportedException {
			return new BlockContext(getParent(), invokingState);
		}
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
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).exitBlock(this);
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
				while (((((_la - 1)) & ~0x3f) == 0 && ((1L << (_la - 1)) & ((1L << (BOOLEAN - 1)) | (1L << (BYTE - 1)) | (1L << (CHAR - 1)) | (1L << (DOUBLE - 1)) | (1L << (FLOAT - 1)) | (1L << (INT - 1)) | (1L << (LONG - 1)) | (1L << (SHORT - 1)) | (1L << (VOID - 1)) | (1L << (DO - 1)) | (1L << (FOR - 1)) | (1L << (IF - 1)) | (1L << (SWITCH - 1)) | (1L << (TRY - 1)) | (1L << (WHILE - 1)) | (1L << (BREAK - 1)) | (1L << (CONTINUE - 1)) | (1L << (RETURN - 1)) | (1L << (ABSTRACT - 1)) | (1L << (ASSERT - 1)) | (1L << (CLASS - 1)) | (1L << (DEFAULT - 1)) | (1L << (ENUM - 1)) | (1L << (FINAL - 1)) | (1L << (INTERFACE - 1)) | (1L << (NATIVE - 1)) | (1L << (NEW - 1)) | (1L << (PRIVATE - 1)) | (1L << (PROTECTED - 1)) | (1L << (PUBLIC - 1)) | (1L << (STATIC - 1)) | (1L << (STRICTFP - 1)) | (1L << (SUPER - 1)) | (1L << (SYNCHRONIZED - 1)) | (1L << (THIS - 1)) | (1L << (THROW - 1)) | (1L << (TRANSIENT - 1)) | (1L << (VOLATILE - 1)) | (1L << (MODULE - 1)) | (1L << (OPEN - 1)) | (1L << (REQUIRES - 1)) | (1L << (EXPORTS - 1)) | (1L << (OPENS - 1)) | (1L << (TO - 1)) | (1L << (USES - 1)) | (1L << (PROVIDES - 1)) | (1L << (WITH - 1)) | (1L << (TRANSITIVE - 1)) | (1L << (VAR - 1)) | (1L << (YIELD - 1)) | (1L << (RECORD - 1)) | (1L << (SEALED - 1)))) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (PERMITS - 65)) | (1L << (NON_SEALED - 65)) | (1L << (DECIMAL_LITERAL - 65)) | (1L << (HEX_LITERAL - 65)) | (1L << (OCT_LITERAL - 65)) | (1L << (BINARY_LITERAL - 65)) | (1L << (FLOAT_LITERAL - 65)) | (1L << (HEX_FLOAT_LITERAL - 65)) | (1L << (CHAR_LITERAL - 65)) | (1L << (STRING_LITERAL - 65)) | (1L << (TEXT_BLOCK - 65)) | (1L << (BOOL_LITERAL - 65)) | (1L << (NULL_LITERAL - 65)) | (1L << (LT - 65)) | (1L << (ADD - 65)) | (1L << (SUB - 65)) | (1L << (TILDE - 65)) | (1L << (BANG - 65)) | (1L << (INC - 65)) | (1L << (DEC - 65)) | (1L << (LPAREN - 65)) | (1L << (LBRACE - 65)) | (1L << (SEMI - 65)) | (1L << (IDENTIFIER - 65)) | (1L << (AT - 65)))) != 0)) {
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
				while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
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

	public static class SwitchBlockStatementGroupContext extends ExtendContext {
		@Override
		public SwitchBlockStatementGroupContext clone() throws CloneNotSupportedException {
			return new SwitchBlockStatementGroupContext(getParent(), invokingState);
		}
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
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).enterSwitchBlockStatementGroup(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).exitSwitchBlockStatementGroup(this);
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
			} while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER );
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
			} while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LocalVariableDeclarationStmtContext extends ExtendContext {
		@Override
		public LocalVariableDeclarationStmtContext clone() throws CloneNotSupportedException {
			return new LocalVariableDeclarationStmtContext(getParent(), invokingState);
		}
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
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).enterLocalVariableDeclarationStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).exitLocalVariableDeclarationStmt(this);
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

	public static class LocalVariableDeclarationContext extends ExtendContext {
		@Override
		public LocalVariableDeclarationContext clone() throws CloneNotSupportedException {
			return new LocalVariableDeclarationContext(getParent(), invokingState);
		}
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
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).enterLocalVariableDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).exitLocalVariableDeclaration(this);
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

	public static class IdentifierContext extends ExtendContext {
		@Override
		public IdentifierContext clone() throws CloneNotSupportedException {
			return new IdentifierContext(getParent(), invokingState);
		}
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
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).enterIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).exitIdentifier(this);
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
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MODULE) | (1L << OPEN) | (1L << REQUIRES) | (1L << EXPORTS) | (1L << OPENS) | (1L << TO) | (1L << USES) | (1L << PROVIDES) | (1L << WITH) | (1L << TRANSITIVE) | (1L << VAR) | (1L << YIELD) | (1L << RECORD))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (SEALED - 64)) | (1L << (PERMITS - 64)) | (1L << (IDENTIFIER - 64)))) != 0)) ) {
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

	public static class TypeIdentifierContext extends ExtendContext {
		@Override
		public TypeIdentifierContext clone() throws CloneNotSupportedException {
			return new TypeIdentifierContext(getParent(), invokingState);
		}
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
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).enterTypeIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).exitTypeIdentifier(this);
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
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MODULE) | (1L << OPEN) | (1L << REQUIRES) | (1L << EXPORTS) | (1L << OPENS) | (1L << TO) | (1L << USES) | (1L << PROVIDES) | (1L << WITH) | (1L << TRANSITIVE) | (1L << RECORD))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (SEALED - 64)) | (1L << (PERMITS - 64)) | (1L << (IDENTIFIER - 64)))) != 0)) ) {
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

	public static class StatementContext extends ExtendContext {
		@Override
		public StatementContext clone() throws CloneNotSupportedException {
			return new StatementContext(getParent(), invokingState);
		}
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
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).exitStatement(this);
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

	public static class AssertStmtContext extends ExtendContext {

		@Override
		public AssertStmtContext clone() throws CloneNotSupportedException {
			return new AssertStmtContext(getParent(), invokingState);
		}
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
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).enterAssertStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).exitAssertStmt(this);
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

	public static class IfStmtContext extends ExtendContext {
		@Override
		public IfStmtContext clone() throws CloneNotSupportedException {
			return new IfStmtContext(getParent(), invokingState);
		}
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
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).enterIfStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).exitIfStmt(this);
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

	public static class IfElseStmtContext extends ExtendContext {
		@Override
		public IfElseStmtContext clone() throws CloneNotSupportedException {
			return new IfElseStmtContext(getParent(), invokingState);
		}

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
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).enterIfElseStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).exitIfElseStmt(this);
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

	public static class ForStmtContext extends ExtendContext {
		@Override
		public ForStmtContext clone() throws CloneNotSupportedException {
			return new ForStmtContext(getParent(), invokingState);
		}
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
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).enterForStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).exitForStmt(this);
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

	public static class WhileStmtContext extends ExtendContext {
		@Override
		public WhileStmtContext clone() throws CloneNotSupportedException {
			return new WhileStmtContext(getParent(), invokingState);
		}
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
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).enterWhileStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).exitWhileStmt(this);
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

	public static class DoWhileStmtContext extends ExtendContext {
		@Override
		public DoWhileStmtContext clone() throws CloneNotSupportedException {
			return new DoWhileStmtContext(getParent(), invokingState);
		}
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
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).enterDoWhileStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).exitDoWhileStmt(this);
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

	public static class TryCatchStmtContext extends ExtendContext {
		@Override
		public TryCatchStmtContext clone() throws CloneNotSupportedException {
			return new TryCatchStmtContext(getParent(), invokingState);
		}
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
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).enterTryCatchStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).exitTryCatchStmt(this);
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

	public static class TryResourceStmtContext extends ExtendContext {
		@Override
		public TryResourceStmtContext clone() throws CloneNotSupportedException {
			return new TryResourceStmtContext(getParent(), invokingState);
		}
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
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).enterTryResourceStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).exitTryResourceStmt(this);
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

	public static class SwitchStmtContext extends ExtendContext {
		@Override
		public SwitchStmtContext clone() throws CloneNotSupportedException {
			return new SwitchStmtContext(getParent(), invokingState);
		}
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
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).enterSwitchStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).exitSwitchStmt(this);
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

	public static class SyncStmtContext extends ExtendContext {
		@Override
		public SyncStmtContext clone() throws CloneNotSupportedException {
			return new SyncStmtContext(getParent(), invokingState);
		}
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
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).enterSyncStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).exitSyncStmt(this);
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

	public static class ReturnStmtContext extends ExtendContext {
		@Override
		public ReturnStmtContext clone() throws CloneNotSupportedException {
			return new ReturnStmtContext(getParent(), invokingState);
		}
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
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).enterReturnStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).exitReturnStmt(this);
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
			if (((((_la - 1)) & ~0x3f) == 0 && ((1L << (_la - 1)) & ((1L << (BOOLEAN - 1)) | (1L << (BYTE - 1)) | (1L << (CHAR - 1)) | (1L << (DOUBLE - 1)) | (1L << (FLOAT - 1)) | (1L << (INT - 1)) | (1L << (LONG - 1)) | (1L << (SHORT - 1)) | (1L << (VOID - 1)) | (1L << (SWITCH - 1)) | (1L << (NEW - 1)) | (1L << (SUPER - 1)) | (1L << (THIS - 1)) | (1L << (MODULE - 1)) | (1L << (OPEN - 1)) | (1L << (REQUIRES - 1)) | (1L << (EXPORTS - 1)) | (1L << (OPENS - 1)) | (1L << (TO - 1)) | (1L << (USES - 1)) | (1L << (PROVIDES - 1)) | (1L << (WITH - 1)) | (1L << (TRANSITIVE - 1)) | (1L << (VAR - 1)) | (1L << (YIELD - 1)) | (1L << (RECORD - 1)) | (1L << (SEALED - 1)))) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (PERMITS - 65)) | (1L << (DECIMAL_LITERAL - 65)) | (1L << (HEX_LITERAL - 65)) | (1L << (OCT_LITERAL - 65)) | (1L << (BINARY_LITERAL - 65)) | (1L << (FLOAT_LITERAL - 65)) | (1L << (HEX_FLOAT_LITERAL - 65)) | (1L << (CHAR_LITERAL - 65)) | (1L << (STRING_LITERAL - 65)) | (1L << (TEXT_BLOCK - 65)) | (1L << (BOOL_LITERAL - 65)) | (1L << (NULL_LITERAL - 65)) | (1L << (LT - 65)) | (1L << (ADD - 65)) | (1L << (SUB - 65)) | (1L << (TILDE - 65)) | (1L << (BANG - 65)) | (1L << (INC - 65)) | (1L << (DEC - 65)) | (1L << (LPAREN - 65)) | (1L << (IDENTIFIER - 65)) | (1L << (AT - 65)))) != 0)) {
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

	public static class ThrowStmtContext extends ExtendContext {
		@Override
		public ThrowStmtContext clone() throws CloneNotSupportedException {
			return new ThrowStmtContext(getParent(), invokingState);
		}
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
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).enterThrowStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).exitThrowStmt(this);
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

	public static class BreakStmtContext extends ExtendContext {
		@Override
		public BreakStmtContext clone() throws CloneNotSupportedException {
			return new BreakStmtContext(getParent(), invokingState);
		}
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
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).enterBreakStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).exitBreakStmt(this);
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
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MODULE) | (1L << OPEN) | (1L << REQUIRES) | (1L << EXPORTS) | (1L << OPENS) | (1L << TO) | (1L << USES) | (1L << PROVIDES) | (1L << WITH) | (1L << TRANSITIVE) | (1L << VAR) | (1L << YIELD) | (1L << RECORD))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (SEALED - 64)) | (1L << (PERMITS - 64)) | (1L << (IDENTIFIER - 64)))) != 0)) {
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

	public static class ContinueStmtContext extends ExtendContext {
		@Override
		public ContinueStmtContext clone() throws CloneNotSupportedException {
			return new ContinueStmtContext(getParent(), invokingState);
		}
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
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).enterContinueStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).exitContinueStmt(this);
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
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MODULE) | (1L << OPEN) | (1L << REQUIRES) | (1L << EXPORTS) | (1L << OPENS) | (1L << TO) | (1L << USES) | (1L << PROVIDES) | (1L << WITH) | (1L << TRANSITIVE) | (1L << VAR) | (1L << YIELD) | (1L << RECORD))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (SEALED - 64)) | (1L << (PERMITS - 64)) | (1L << (IDENTIFIER - 64)))) != 0)) {
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

	public static class YieldStmtContext extends ExtendContext {
		@Override
		public YieldStmtContext clone() throws CloneNotSupportedException {
			return new YieldStmtContext(getParent(), invokingState);
		}
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
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).enterYieldStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).exitYieldStmt(this);
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

	public static class ExpressionStmtContext extends ExtendContext {
		@Override
		public ExpressionStmtContext clone() throws CloneNotSupportedException {
			return new ExpressionStmtContext(getParent(), invokingState);
		}
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
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).enterExpressionStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).exitExpressionStmt(this);
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

	public static class LabelStmtContext extends ExtendContext {
		@Override
		public LabelStmtContext clone() throws CloneNotSupportedException {
			return new LabelStmtContext(getParent(), invokingState);
		}
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
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).enterLabelStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).exitLabelStmt(this);
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

	public static class CatchClauseContext extends ExtendContext {
		@Override
		public CatchClauseContext clone() throws CloneNotSupportedException {
			return new CatchClauseContext(getParent(), invokingState);
		}
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
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).enterCatchClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).exitCatchClause(this);
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

	public static class CatchTypeContext extends ExtendContext {
		@Override
		public CatchTypeContext clone() throws CloneNotSupportedException {
			return new CatchTypeContext(getParent(), invokingState);
		}
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
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).enterCatchType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).exitCatchType(this);
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

	public static class FinallyBlockContext extends ExtendContext {
		@Override
		public FinallyBlockContext clone() throws CloneNotSupportedException {
			return new FinallyBlockContext(getParent(), invokingState);
		}
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
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).enterFinallyBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).exitFinallyBlock(this);
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

	public static class ResourceSpecificationContext extends ExtendContext {
		@Override
		public ResourceSpecificationContext clone() throws CloneNotSupportedException {
			return new ResourceSpecificationContext(getParent(), invokingState);
		}
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
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).enterResourceSpecification(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).exitResourceSpecification(this);
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

	public static class ResourcesContext extends ExtendContext {

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
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).enterResources(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).exitResources(this);
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
			while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
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

	public static class ResourceContext extends ExtendContext {
		@Override
		public ResourceContext clone() throws CloneNotSupportedException {
			return new ResourceContext(getParent(), invokingState);
		}
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
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).enterResource(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).exitResource(this);
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

	public static class SwitchLabelContext extends ExtendContext {
		@Override
		public SwitchLabelContext clone() throws CloneNotSupportedException {
			return new SwitchLabelContext(getParent(), invokingState);
		}
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
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).enterSwitchLabel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).exitSwitchLabel(this);
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

	public static class ForControlContext extends ExtendContext {
		@Override
		public ForControlContext clone() throws CloneNotSupportedException {
			return new ForControlContext(getParent(), invokingState);
		}
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
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).enterForControl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).exitForControl(this);
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
				if (((((_la - 1)) & ~0x3f) == 0 && ((1L << (_la - 1)) & ((1L << (BOOLEAN - 1)) | (1L << (BYTE - 1)) | (1L << (CHAR - 1)) | (1L << (DOUBLE - 1)) | (1L << (FLOAT - 1)) | (1L << (INT - 1)) | (1L << (LONG - 1)) | (1L << (SHORT - 1)) | (1L << (VOID - 1)) | (1L << (SWITCH - 1)) | (1L << (ABSTRACT - 1)) | (1L << (DEFAULT - 1)) | (1L << (FINAL - 1)) | (1L << (NATIVE - 1)) | (1L << (NEW - 1)) | (1L << (PRIVATE - 1)) | (1L << (PROTECTED - 1)) | (1L << (PUBLIC - 1)) | (1L << (STATIC - 1)) | (1L << (STRICTFP - 1)) | (1L << (SUPER - 1)) | (1L << (SYNCHRONIZED - 1)) | (1L << (THIS - 1)) | (1L << (TRANSIENT - 1)) | (1L << (VOLATILE - 1)) | (1L << (MODULE - 1)) | (1L << (OPEN - 1)) | (1L << (REQUIRES - 1)) | (1L << (EXPORTS - 1)) | (1L << (OPENS - 1)) | (1L << (TO - 1)) | (1L << (USES - 1)) | (1L << (PROVIDES - 1)) | (1L << (WITH - 1)) | (1L << (TRANSITIVE - 1)) | (1L << (VAR - 1)) | (1L << (YIELD - 1)) | (1L << (RECORD - 1)) | (1L << (SEALED - 1)))) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (PERMITS - 65)) | (1L << (NON_SEALED - 65)) | (1L << (DECIMAL_LITERAL - 65)) | (1L << (HEX_LITERAL - 65)) | (1L << (OCT_LITERAL - 65)) | (1L << (BINARY_LITERAL - 65)) | (1L << (FLOAT_LITERAL - 65)) | (1L << (HEX_FLOAT_LITERAL - 65)) | (1L << (CHAR_LITERAL - 65)) | (1L << (STRING_LITERAL - 65)) | (1L << (TEXT_BLOCK - 65)) | (1L << (BOOL_LITERAL - 65)) | (1L << (NULL_LITERAL - 65)) | (1L << (LT - 65)) | (1L << (ADD - 65)) | (1L << (SUB - 65)) | (1L << (TILDE - 65)) | (1L << (BANG - 65)) | (1L << (INC - 65)) | (1L << (DEC - 65)) | (1L << (LPAREN - 65)) | (1L << (IDENTIFIER - 65)) | (1L << (AT - 65)))) != 0)) {
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
				if (((((_la - 1)) & ~0x3f) == 0 && ((1L << (_la - 1)) & ((1L << (BOOLEAN - 1)) | (1L << (BYTE - 1)) | (1L << (CHAR - 1)) | (1L << (DOUBLE - 1)) | (1L << (FLOAT - 1)) | (1L << (INT - 1)) | (1L << (LONG - 1)) | (1L << (SHORT - 1)) | (1L << (VOID - 1)) | (1L << (SWITCH - 1)) | (1L << (NEW - 1)) | (1L << (SUPER - 1)) | (1L << (THIS - 1)) | (1L << (MODULE - 1)) | (1L << (OPEN - 1)) | (1L << (REQUIRES - 1)) | (1L << (EXPORTS - 1)) | (1L << (OPENS - 1)) | (1L << (TO - 1)) | (1L << (USES - 1)) | (1L << (PROVIDES - 1)) | (1L << (WITH - 1)) | (1L << (TRANSITIVE - 1)) | (1L << (VAR - 1)) | (1L << (YIELD - 1)) | (1L << (RECORD - 1)) | (1L << (SEALED - 1)))) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (PERMITS - 65)) | (1L << (DECIMAL_LITERAL - 65)) | (1L << (HEX_LITERAL - 65)) | (1L << (OCT_LITERAL - 65)) | (1L << (BINARY_LITERAL - 65)) | (1L << (FLOAT_LITERAL - 65)) | (1L << (HEX_FLOAT_LITERAL - 65)) | (1L << (CHAR_LITERAL - 65)) | (1L << (STRING_LITERAL - 65)) | (1L << (TEXT_BLOCK - 65)) | (1L << (BOOL_LITERAL - 65)) | (1L << (NULL_LITERAL - 65)) | (1L << (LT - 65)) | (1L << (ADD - 65)) | (1L << (SUB - 65)) | (1L << (TILDE - 65)) | (1L << (BANG - 65)) | (1L << (INC - 65)) | (1L << (DEC - 65)) | (1L << (LPAREN - 65)) | (1L << (IDENTIFIER - 65)) | (1L << (AT - 65)))) != 0)) {
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
				if (((((_la - 1)) & ~0x3f) == 0 && ((1L << (_la - 1)) & ((1L << (BOOLEAN - 1)) | (1L << (BYTE - 1)) | (1L << (CHAR - 1)) | (1L << (DOUBLE - 1)) | (1L << (FLOAT - 1)) | (1L << (INT - 1)) | (1L << (LONG - 1)) | (1L << (SHORT - 1)) | (1L << (VOID - 1)) | (1L << (SWITCH - 1)) | (1L << (NEW - 1)) | (1L << (SUPER - 1)) | (1L << (THIS - 1)) | (1L << (MODULE - 1)) | (1L << (OPEN - 1)) | (1L << (REQUIRES - 1)) | (1L << (EXPORTS - 1)) | (1L << (OPENS - 1)) | (1L << (TO - 1)) | (1L << (USES - 1)) | (1L << (PROVIDES - 1)) | (1L << (WITH - 1)) | (1L << (TRANSITIVE - 1)) | (1L << (VAR - 1)) | (1L << (YIELD - 1)) | (1L << (RECORD - 1)) | (1L << (SEALED - 1)))) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (PERMITS - 65)) | (1L << (DECIMAL_LITERAL - 65)) | (1L << (HEX_LITERAL - 65)) | (1L << (OCT_LITERAL - 65)) | (1L << (BINARY_LITERAL - 65)) | (1L << (FLOAT_LITERAL - 65)) | (1L << (HEX_FLOAT_LITERAL - 65)) | (1L << (CHAR_LITERAL - 65)) | (1L << (STRING_LITERAL - 65)) | (1L << (TEXT_BLOCK - 65)) | (1L << (BOOL_LITERAL - 65)) | (1L << (NULL_LITERAL - 65)) | (1L << (LT - 65)) | (1L << (ADD - 65)) | (1L << (SUB - 65)) | (1L << (TILDE - 65)) | (1L << (BANG - 65)) | (1L << (INC - 65)) | (1L << (DEC - 65)) | (1L << (LPAREN - 65)) | (1L << (IDENTIFIER - 65)) | (1L << (AT - 65)))) != 0)) {
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

	public static class ForInitContext extends ExtendContext {
		@Override
		public ForInitContext clone() throws CloneNotSupportedException {
			return new ForInitContext(getParent(), invokingState);
		}
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
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).enterForInit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).exitForInit(this);
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

	public static class EnhancedForControlContext extends ExtendContext {
		@Override
		public EnhancedForControlContext clone() throws CloneNotSupportedException {
			return new EnhancedForControlContext(getParent(), invokingState);
		}
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
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).enterEnhancedForControl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).exitEnhancedForControl(this);
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

	public static class ParExpressionContext extends ExtendContext {
		@Override
		public ParExpressionContext clone() throws CloneNotSupportedException {
			return new ParExpressionContext(getParent(), invokingState);
		}
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
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).enterParExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).exitParExpression(this);
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

	public static class ExpressionListContext extends ExtendContext {
		@Override
		public ExpressionListContext clone() throws CloneNotSupportedException {
			return new ExpressionListContext(getParent(), invokingState);
		}
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
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).enterExpressionList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).exitExpressionList(this);
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

	public static class MethodCallContext extends ExtendContext {
		@Override
		public MethodCallContext clone() throws CloneNotSupportedException {
			return new MethodCallContext(getParent(), invokingState);
		}
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
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).enterMethodCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).exitMethodCall(this);
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

	public static class ExpressionContext extends ExtendContext {
		@Override
		public ExpressionContext clone() throws CloneNotSupportedException {
			return new ExpressionContext(getParent(), invokingState);
		}
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
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).exitExpression(this);
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
				if ( !(((((_la - 88)) & ~0x3f) == 0 && ((1L << (_la - 88)) & ((1L << (ADD - 88)) | (1L << (SUB - 88)) | (1L << (TILDE - 88)) | (1L << (BANG - 88)) | (1L << (INC - 88)) | (1L << (DEC - 88)))) != 0)) ) {
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
			while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
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
						if ( !(((((_la - 90)) & ~0x3f) == 0 && ((1L << (_la - 90)) & ((1L << (MUL - 90)) | (1L << (DIV - 90)) | (1L << (MOD - 90)))) != 0)) ) {
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
						if ( !(((((_la - 80)) & ~0x3f) == 0 && ((1L << (_la - 80)) & ((1L << (GT - 80)) | (1L << (LT - 80)) | (1L << (LE - 80)) | (1L << (GE - 80)))) != 0)) ) {
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
						if ( !(((((_la - 96)) & ~0x3f) == 0 && ((1L << (_la - 96)) & ((1L << (ASSIGN - 96)) | (1L << (ADD_ASSIGN - 96)) | (1L << (SUB_ASSIGN - 96)) | (1L << (MUL_ASSIGN - 96)) | (1L << (DIV_ASSIGN - 96)) | (1L << (AND_ASSIGN - 96)) | (1L << (OR_ASSIGN - 96)) | (1L << (XOR_ASSIGN - 96)) | (1L << (MOD_ASSIGN - 96)) | (1L << (LSHIFT_ASSIGN - 96)) | (1L << (RSHIFT_ASSIGN - 96)) | (1L << (URSHIFT_ASSIGN - 96)))) != 0)) ) {
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

	public static class PatternContext extends ExtendContext {
		@Override
		public PatternContext clone() throws CloneNotSupportedException {
			return new PatternContext(getParent(), invokingState);
		}
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
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).enterPattern(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).exitPattern(this);
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

	public static class LambdaExpressionContext extends ExtendContext {
		@Override
		public LambdaExpressionContext clone() throws CloneNotSupportedException {
			return new LambdaExpressionContext(getParent(), invokingState);
		}
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
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).enterLambdaExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).exitLambdaExpression(this);
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

	public static class LambdaParametersContext extends ExtendContext {
		@Override
		public LambdaParametersContext clone() throws CloneNotSupportedException {
			return new LambdaParametersContext(getParent(), invokingState);
		}
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
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).enterLambdaParameters(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).exitLambdaParameters(this);
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
				if (((((_la - 1)) & ~0x3f) == 0 && ((1L << (_la - 1)) & ((1L << (BOOLEAN - 1)) | (1L << (BYTE - 1)) | (1L << (CHAR - 1)) | (1L << (DOUBLE - 1)) | (1L << (FLOAT - 1)) | (1L << (INT - 1)) | (1L << (LONG - 1)) | (1L << (SHORT - 1)) | (1L << (VOID - 1)) | (1L << (ABSTRACT - 1)) | (1L << (DEFAULT - 1)) | (1L << (FINAL - 1)) | (1L << (NATIVE - 1)) | (1L << (PRIVATE - 1)) | (1L << (PROTECTED - 1)) | (1L << (PUBLIC - 1)) | (1L << (STATIC - 1)) | (1L << (STRICTFP - 1)) | (1L << (SYNCHRONIZED - 1)) | (1L << (TRANSIENT - 1)) | (1L << (VOLATILE - 1)) | (1L << (MODULE - 1)) | (1L << (OPEN - 1)) | (1L << (REQUIRES - 1)) | (1L << (EXPORTS - 1)) | (1L << (OPENS - 1)) | (1L << (TO - 1)) | (1L << (USES - 1)) | (1L << (PROVIDES - 1)) | (1L << (WITH - 1)) | (1L << (TRANSITIVE - 1)) | (1L << (VAR - 1)) | (1L << (YIELD - 1)) | (1L << (RECORD - 1)) | (1L << (SEALED - 1)))) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (PERMITS - 65)) | (1L << (NON_SEALED - 65)) | (1L << (IDENTIFIER - 65)) | (1L << (AT - 65)))) != 0)) {
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
				if (((((_la - 24)) & ~0x3f) == 0 && ((1L << (_la - 24)) & ((1L << (ABSTRACT - 24)) | (1L << (DEFAULT - 24)) | (1L << (FINAL - 24)) | (1L << (NATIVE - 24)) | (1L << (PRIVATE - 24)) | (1L << (PROTECTED - 24)) | (1L << (PUBLIC - 24)) | (1L << (STATIC - 24)) | (1L << (STRICTFP - 24)) | (1L << (SYNCHRONIZED - 24)) | (1L << (TRANSIENT - 24)) | (1L << (VOLATILE - 24)) | (1L << (MODULE - 24)) | (1L << (OPEN - 24)) | (1L << (REQUIRES - 24)) | (1L << (EXPORTS - 24)) | (1L << (OPENS - 24)) | (1L << (TO - 24)) | (1L << (USES - 24)) | (1L << (PROVIDES - 24)) | (1L << (WITH - 24)) | (1L << (TRANSITIVE - 24)) | (1L << (VAR - 24)) | (1L << (YIELD - 24)) | (1L << (RECORD - 24)) | (1L << (SEALED - 24)) | (1L << (PERMITS - 24)) | (1L << (NON_SEALED - 24)))) != 0) || _la==IDENTIFIER || _la==AT) {
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

	public static class LambdaBodyContext extends ExtendContext {
		@Override
		public LambdaBodyContext clone() throws CloneNotSupportedException {
			return new LambdaBodyContext(getParent(), invokingState);
		}
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
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).enterLambdaBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).exitLambdaBody(this);
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

	public static class SwitchLabeledRuleContext extends ExtendContext {
		@Override
		public SwitchLabeledRuleContext clone() throws CloneNotSupportedException {
			return new SwitchLabeledRuleContext(getParent(), invokingState);
		}
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
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).enterSwitchLabeledRule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).exitSwitchLabeledRule(this);
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
				while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
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
				while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
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

	public static class GuardedPatternContext extends ExtendContext {
		@Override
		public GuardedPatternContext clone() throws CloneNotSupportedException {
			return new GuardedPatternContext(getParent(), invokingState);
		}
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
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).enterGuardedPattern(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).exitGuardedPattern(this);
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
				while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
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
			while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
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

	public static class ClassTypeContext extends ExtendContext {
		@Override
		public ClassTypeContext clone() throws CloneNotSupportedException {
			return new ClassTypeContext(getParent(), invokingState);
		}
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
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).enterClassType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).exitClassType(this);
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

	public static class CreatorContext extends ExtendContext {
		@Override
		public CreatorContext clone() throws CloneNotSupportedException {
			return new CreatorContext(getParent(), invokingState);
		}
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
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).enterCreator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).exitCreator(this);
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

	public static class CreatedNameContext extends ExtendContext {
		@Override
		public CreatedNameContext clone() throws CloneNotSupportedException {
			return new CreatedNameContext(getParent(), invokingState);
		}
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
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).enterCreatedName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).exitCreatedName(this);
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

	public static class InnerCreatorContext extends ExtendContext {
		@Override
		public InnerCreatorContext clone() throws CloneNotSupportedException {
			return new InnerCreatorContext(getParent(), invokingState);
		}
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
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).enterInnerCreator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).exitInnerCreator(this);
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

	public static class ArrayCreatorRestContext extends ExtendContext {
		@Override
		public ArrayCreatorRestContext clone() throws CloneNotSupportedException {
			return new ArrayCreatorRestContext(getParent(), invokingState);
		}
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
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).enterArrayCreatorRest(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).exitArrayCreatorRest(this);
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
				} while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER );
				setState(1528);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,179,_ctx);
				while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
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

	public static class ClassCreatorRestContext extends ExtendContext {
		@Override
		public ClassCreatorRestContext clone() throws CloneNotSupportedException {
			return new ClassCreatorRestContext(getParent(), invokingState);
		}
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
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).enterClassCreatorRest(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).exitClassCreatorRest(this);
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

	public static class ExplicitGenericInvocationContext extends ExtendContext {
		@Override
		public ExplicitGenericInvocationContext clone() throws CloneNotSupportedException {
			return new ExplicitGenericInvocationContext(getParent(), invokingState);
		}
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
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).enterExplicitGenericInvocation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).exitExplicitGenericInvocation(this);
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

	public static class TypeArgumentsOrDiamondContext extends ExtendContext {
		@Override
		public TypeArgumentsOrDiamondContext clone() throws CloneNotSupportedException {
			return new TypeArgumentsOrDiamondContext(getParent(), invokingState);
		}
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
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).enterTypeArgumentsOrDiamond(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).exitTypeArgumentsOrDiamond(this);
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

	public static class NonWildcardTypeArgumentsContext extends ExtendContext {
		@Override
		public NonWildcardTypeArgumentsContext clone() throws CloneNotSupportedException {
			return new NonWildcardTypeArgumentsContext(getParent(), invokingState);
		}
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
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).enterNonWildcardTypeArguments(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).exitNonWildcardTypeArguments(this);
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

	public static class TypeListContext extends ExtendContext {
		@Override
		public TypeListContext clone() throws CloneNotSupportedException {
			return new TypeListContext(getParent(), invokingState);
		}
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
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).enterTypeList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).exitTypeList(this);
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

	public static class TypeTypeContext extends ExtendContext {
		@Override
		public TypeTypeContext clone() throws CloneNotSupportedException {
			return new TypeTypeContext(getParent(), invokingState);
		}
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
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).enterTypeType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).exitTypeType(this);
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
			while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
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

	public static class PrimitiveTypeContext extends ExtendContext {
		@Override
		public PrimitiveTypeContext clone() throws CloneNotSupportedException {
			return new PrimitiveTypeContext(getParent(), invokingState);
		}
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
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).enterPrimitiveType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).exitPrimitiveType(this);
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
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << BYTE) | (1L << CHAR) | (1L << DOUBLE) | (1L << FLOAT) | (1L << INT) | (1L << LONG) | (1L << SHORT) | (1L << VOID))) != 0)) ) {
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

	public static class TypeArgumentsContext extends ExtendContext {
		@Override
		public TypeArgumentsContext clone() throws CloneNotSupportedException {
			return new TypeArgumentsContext(getParent(), invokingState);
		}
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
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).enterTypeArguments(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).exitTypeArguments(this);
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

	public static class SuperSuffixContext extends ExtendContext {
		@Override
		public SuperSuffixContext clone() throws CloneNotSupportedException {
			return new SuperSuffixContext(getParent(), invokingState);
		}
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
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).enterSuperSuffix(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).exitSuperSuffix(this);
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

	public static class ExplicitGenericInvocationSuffixContext extends ExtendContext {
		@Override
		public ExplicitGenericInvocationSuffixContext clone() throws CloneNotSupportedException {
			return new ExplicitGenericInvocationSuffixContext(getParent(), invokingState);
		}
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
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).enterExplicitGenericInvocationSuffix(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).exitExplicitGenericInvocationSuffix(this);
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

	public static class ArgumentsContext extends ExtendContext {
		@Override
		public ArgumentsContext clone() throws CloneNotSupportedException {
			return new ArgumentsContext(getParent(), invokingState);
		}
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
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).enterArguments(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaParserListener) ((JavaParserListener)listener).exitArguments(this);
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
			if (((((_la - 1)) & ~0x3f) == 0 && ((1L << (_la - 1)) & ((1L << (BOOLEAN - 1)) | (1L << (BYTE - 1)) | (1L << (CHAR - 1)) | (1L << (DOUBLE - 1)) | (1L << (FLOAT - 1)) | (1L << (INT - 1)) | (1L << (LONG - 1)) | (1L << (SHORT - 1)) | (1L << (VOID - 1)) | (1L << (SWITCH - 1)) | (1L << (NEW - 1)) | (1L << (SUPER - 1)) | (1L << (THIS - 1)) | (1L << (MODULE - 1)) | (1L << (OPEN - 1)) | (1L << (REQUIRES - 1)) | (1L << (EXPORTS - 1)) | (1L << (OPENS - 1)) | (1L << (TO - 1)) | (1L << (USES - 1)) | (1L << (PROVIDES - 1)) | (1L << (WITH - 1)) | (1L << (TRANSITIVE - 1)) | (1L << (VAR - 1)) | (1L << (YIELD - 1)) | (1L << (RECORD - 1)) | (1L << (SEALED - 1)))) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (PERMITS - 65)) | (1L << (DECIMAL_LITERAL - 65)) | (1L << (HEX_LITERAL - 65)) | (1L << (OCT_LITERAL - 65)) | (1L << (BINARY_LITERAL - 65)) | (1L << (FLOAT_LITERAL - 65)) | (1L << (HEX_FLOAT_LITERAL - 65)) | (1L << (CHAR_LITERAL - 65)) | (1L << (STRING_LITERAL - 65)) | (1L << (TEXT_BLOCK - 65)) | (1L << (BOOL_LITERAL - 65)) | (1L << (NULL_LITERAL - 65)) | (1L << (LT - 65)) | (1L << (ADD - 65)) | (1L << (SUB - 65)) | (1L << (TILDE - 65)) | (1L << (BANG - 65)) | (1L << (INC - 65)) | (1L << (DEC - 65)) | (1L << (LPAREN - 65)) | (1L << (IDENTIFIER - 65)) | (1L << (AT - 65)))) != 0)) {
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\u0084\u064b\4\2\t"+
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
		"\4\u0081\t\u0081\4\u0082\t\u0082\4\u0083\t\u0083\3\2\5\2\u0108\n\2\3\2"+
		"\5\2\u010b\n\2\3\2\7\2\u010e\n\2\f\2\16\2\u0111\13\2\5\2\u0113\n\2\3\2"+
		"\5\2\u0116\n\2\3\2\7\2\u0119\n\2\f\2\16\2\u011c\13\2\5\2\u011e\n\2\3\2"+
		"\3\2\3\2\5\2\u0123\n\2\3\3\6\3\u0126\n\3\r\3\16\3\u0127\3\4\3\4\7\4\u012c"+
		"\n\4\f\4\16\4\u012f\13\4\6\4\u0131\n\4\r\4\16\4\u0132\3\5\3\5\3\5\3\5"+
		"\3\5\3\6\3\6\5\6\u013c\n\6\3\6\3\6\3\6\5\6\u0141\n\6\3\6\3\6\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\7\7\u0155\n\7\f"+
		"\7\16\7\u0158\13\7\3\b\3\b\3\b\3\b\3\b\3\b\5\b\u0160\n\b\3\b\3\b\3\t\3"+
		"\t\3\t\5\t\u0167\n\t\3\t\3\t\5\t\u016b\n\t\3\t\3\t\5\t\u016f\n\t\3\t\3"+
		"\t\5\t\u0173\n\t\3\n\3\n\3\n\5\n\u0178\n\n\3\n\3\n\5\n\u017c\n\n\3\n\3"+
		"\n\5\n\u0180\n\n\3\13\3\13\3\13\5\13\u0185\n\13\3\13\3\13\3\13\5\13\u018a"+
		"\n\13\3\f\3\f\3\f\3\f\5\f\u0190\n\f\3\r\3\r\3\r\3\r\3\16\3\16\7\16\u0198"+
		"\n\16\f\16\16\16\u019b\13\16\3\16\3\16\3\16\5\16\u01a0\n\16\3\16\5\16"+
		"\u01a3\n\16\3\16\3\16\7\16\u01a7\n\16\f\16\16\16\u01aa\13\16\5\16\u01ac"+
		"\n\16\3\16\3\16\3\16\7\16\u01b1\n\16\f\16\16\16\u01b4\13\16\3\16\3\16"+
		"\3\16\7\16\u01b9\n\16\f\16\16\16\u01bc\13\16\3\16\5\16\u01bf\n\16\3\17"+
		"\3\17\3\17\3\17\7\17\u01c5\n\17\f\17\16\17\u01c8\13\17\3\17\3\17\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\5\20\u01d2\n\20\3\21\3\21\3\21\7\21\u01d7\n"+
		"\21\f\21\16\21\u01da\13\21\3\22\3\22\3\22\7\22\u01df\n\22\f\22\16\22\u01e2"+
		"\13\22\3\23\3\23\3\23\5\23\u01e7\n\23\3\23\5\23\u01ea\n\23\3\24\3\24\3"+
		"\24\3\24\3\24\3\24\5\24\u01f2\n\24\3\25\3\25\3\25\3\26\3\26\7\26\u01f9"+
		"\n\26\f\26\16\26\u01fc\13\26\6\26\u01fe\n\26\r\26\16\26\u01ff\3\27\3\27"+
		"\7\27\u0204\n\27\f\27\16\27\u0207\13\27\6\27\u0209\n\27\r\27\16\27\u020a"+
		"\3\30\3\30\7\30\u020f\n\30\f\30\16\30\u0212\13\30\6\30\u0214\n\30\r\30"+
		"\16\30\u0215\3\31\3\31\7\31\u021a\n\31\f\31\16\31\u021d\13\31\6\31\u021f"+
		"\n\31\r\31\16\31\u0220\3\32\3\32\3\32\3\32\5\32\u0227\n\32\3\33\5\33\u022a"+
		"\n\33\3\33\3\33\3\33\3\33\3\33\7\33\u0231\n\33\f\33\16\33\u0234\13\33"+
		"\3\33\3\33\5\33\u0238\n\33\3\34\3\34\3\34\3\34\3\35\5\35\u023f\n\35\3"+
		"\35\3\35\3\35\3\35\5\35\u0245\n\35\3\35\5\35\u0248\n\35\3\36\3\36\3\36"+
		"\3\36\3\36\3\37\3\37\7\37\u0251\n\37\f\37\16\37\u0254\13\37\6\37\u0256"+
		"\n\37\r\37\16\37\u0257\3 \3 \3 \3 \3 \7 \u025f\n \f \16 \u0262\13 \3 "+
		"\3 \3!\3!\3!\7!\u0269\n!\f!\16!\u026c\13!\3!\3!\3!\3\"\3\"\3\"\7\"\u0274"+
		"\n\"\f\"\16\"\u0277\13\"\3#\3#\3#\5#\u027c\n#\3$\3$\3$\7$\u0281\n$\f$"+
		"\16$\u0284\13$\3%\3%\5%\u0288\n%\3&\3&\3&\3&\7&\u028e\n&\f&\16&\u0291"+
		"\13&\3&\5&\u0294\n&\5&\u0296\n&\3&\3&\3\'\3\'\5\'\u029c\n\'\3\'\3\'\7"+
		"\'\u02a0\n\'\f\'\16\'\u02a3\13\'\3\'\3\'\5\'\u02a7\n\'\3(\3(\3(\3(\3("+
		"\5(\u02ae\n(\5(\u02b0\n(\3)\3)\3)\7)\u02b5\n)\f)\16)\u02b8\13)\3*\3*\5"+
		"*\u02bc\n*\3*\3*\3*\5*\u02c1\n*\3*\5*\u02c4\n*\5*\u02c6\n*\3*\3*\3+\3"+
		"+\3+\3+\7+\u02ce\n+\f+\16+\u02d1\13+\3+\3+\3,\3,\3,\7,\u02d8\n,\f,\16"+
		",\u02db\13,\3,\3,\5,\u02df\n,\3,\5,\u02e2\n,\3-\3-\3-\3-\3.\3.\3.\3.\3"+
		".\3.\3/\3/\3/\7/\u02f1\n/\f/\16/\u02f4\13/\3\60\3\60\3\60\3\60\3\61\3"+
		"\61\3\61\7\61\u02fd\n\61\f\61\16\61\u0300\13\61\3\62\3\62\3\62\3\62\3"+
		"\62\3\62\3\62\5\62\u0309\n\62\3\63\3\63\3\64\3\64\3\65\3\65\3\65\7\65"+
		"\u0312\n\65\f\65\16\65\u0315\13\65\3\65\3\65\3\65\3\66\7\66\u031b\n\66"+
		"\f\66\16\66\u031e\13\66\3\67\3\67\3\67\5\67\u0323\n\67\3\67\3\67\3\67"+
		"\5\67\u0328\n\67\3\67\5\67\u032b\n\67\38\38\38\78\u0330\n8\f8\168\u0333"+
		"\138\39\39\39\39\3:\3:\3:\5:\u033c\n:\3;\3;\3;\3;\7;\u0342\n;\f;\16;\u0345"+
		"\13;\5;\u0347\n;\3;\5;\u034a\n;\3;\3;\3<\3<\3<\3<\5<\u0352\n<\3=\3=\3"+
		"=\3=\3=\3=\5=\u035a\n=\5=\u035c\n=\3>\3>\5>\u0360\n>\3?\3?\3?\3?\5?\u0366"+
		"\n?\3@\3@\3A\3A\3A\3B\5B\u036e\nB\3B\3B\3B\3B\3C\3C\7C\u0376\nC\fC\16"+
		"C\u0379\13C\3C\3C\3C\3C\3C\3C\3C\5C\u0382\nC\3C\3C\3C\3C\3C\3C\5C\u038a"+
		"\nC\3C\3C\3C\3C\3C\3C\3C\3C\3C\3C\3C\3C\5C\u0398\nC\3D\3D\3E\3E\5E\u039e"+
		"\nE\3E\3E\3F\3F\3F\7F\u03a5\nF\fF\16F\u03a8\13F\3G\3G\3G\3H\3H\3H\7H\u03b0"+
		"\nH\fH\16H\u03b3\13H\3H\3H\3H\7H\u03b8\nH\fH\16H\u03bb\13H\3H\7H\u03be"+
		"\nH\fH\16H\u03c1\13H\3H\3H\3H\7H\u03c6\nH\fH\16H\u03c9\13H\3H\5H\u03cc"+
		"\nH\3I\6I\u03cf\nI\rI\16I\u03d0\3I\3I\6I\u03d5\nI\rI\16I\u03d6\3J\3J\3"+
		"J\3K\3K\3K\3K\3K\3K\3K\3K\3K\5K\u03e5\nK\3L\3L\3M\3M\3N\3N\3N\3N\3N\3"+
		"N\3N\3N\3N\3N\3N\3N\3N\3N\3N\3N\3N\3N\3N\3N\5N\u03ff\nN\3O\3O\3O\3O\5"+
		"O\u0405\nO\3O\3O\3P\3P\3P\3P\3Q\3Q\3Q\3Q\3Q\3Q\3R\3R\3R\3R\3R\3R\3S\3"+
		"S\3S\3S\3T\3T\3T\3T\3T\3T\3U\3U\3U\6U\u0426\nU\rU\16U\u0427\3U\5U\u042b"+
		"\nU\3U\5U\u042e\nU\3V\3V\3V\3V\7V\u0434\nV\fV\16V\u0437\13V\3V\5V\u043a"+
		"\nV\3W\3W\3W\3W\3X\3X\3X\3X\3Y\3Y\5Y\u0446\nY\3Y\3Y\3Z\3Z\3Z\3Z\3[\3["+
		"\5[\u0450\n[\3[\3[\3\\\3\\\5\\\u0456\n\\\3\\\3\\\3]\3]\3]\3]\3^\3^\3^"+
		"\3_\3_\3_\3_\3`\3`\3`\3`\3`\3`\3`\3`\3a\3a\3a\7a\u0470\na\fa\16a\u0473"+
		"\13a\3b\3b\3b\3c\3c\3c\5c\u047b\nc\3c\3c\3d\3d\3d\7d\u0482\nd\fd\16d\u0485"+
		"\13d\3e\3e\3e\3e\3e\3e\5e\u048d\ne\3e\3e\3e\3e\5e\u0493\ne\3f\3f\3f\3"+
		"f\3f\3f\5f\u049b\nf\3f\3f\3f\5f\u04a0\nf\3g\3g\5g\u04a4\ng\3g\3g\5g\u04a8"+
		"\ng\3g\3g\5g\u04ac\ng\5g\u04ae\ng\3h\3h\5h\u04b2\nh\3i\3i\3i\5i\u04b7"+
		"\ni\3i\3i\3i\3i\3j\3j\3j\3j\3k\3k\3k\7k\u04c4\nk\fk\16k\u04c7\13k\3l\3"+
		"l\3l\5l\u04cc\nl\3l\3l\3m\3m\3m\3m\3m\3m\3m\3m\3m\3m\3m\3m\3m\3m\3m\3"+
		"m\3m\5m\u04e1\nm\3m\3m\3m\3m\5m\u04e7\nm\3m\3m\5m\u04eb\nm\3m\3m\3m\5"+
		"m\u04f0\nm\3m\3m\3m\3m\3m\3m\3m\3m\3m\3m\3m\3m\3m\7m\u04ff\nm\fm\16m\u0502"+
		"\13m\3m\3m\3m\3m\3m\3m\5m\u050a\nm\3m\3m\3m\3m\3m\3m\3m\3m\3m\3m\3m\3"+
		"m\3m\3m\5m\u051a\nm\3m\3m\3m\3m\3m\3m\3m\3m\3m\3m\3m\3m\3m\3m\3m\3m\3"+
		"m\3m\3m\3m\3m\3m\3m\3m\3m\3m\3m\3m\3m\3m\3m\3m\3m\3m\3m\3m\3m\3m\3m\3"+
		"m\3m\3m\3m\5m\u0547\nm\3m\3m\3m\3m\5m\u054d\nm\3m\3m\3m\5m\u0552\nm\3"+
		"m\3m\3m\3m\3m\3m\3m\5m\u055b\nm\7m\u055d\nm\fm\16m\u0560\13m\3n\3n\3n"+
		"\3n\3n\3o\3o\3o\3o\3p\3p\3p\5p\u056e\np\3p\3p\3p\3p\3p\7p\u0575\np\fp"+
		"\16p\u0578\13p\3p\3p\3p\3p\5p\u057e\np\3p\5p\u0581\np\3q\3q\5q\u0585\n"+
		"q\3r\3r\3r\3r\5r\u058b\nr\3r\3r\3r\7r\u0590\nr\fr\16r\u0593\13r\3r\3r"+
		"\3r\3r\7r\u0599\nr\fr\16r\u059c\13r\5r\u059e\nr\3s\3s\3s\3s\3s\3s\3s\3"+
		"s\3s\3s\3s\7s\u05ab\ns\fs\16s\u05ae\13s\5s\u05b0\ns\3s\3s\3s\7s\u05b5"+
		"\ns\fs\16s\u05b8\13s\3t\3t\3t\5t\u05bd\nt\3t\3t\3t\5t\u05c2\nt\3u\5u\u05c5"+
		"\nu\3u\3u\3u\3u\3u\3u\5u\u05cd\nu\3v\3v\5v\u05d1\nv\3v\3v\3v\5v\u05d6"+
		"\nv\7v\u05d8\nv\fv\16v\u05db\13v\3v\5v\u05de\nv\3w\3w\3w\3w\5w\u05e4\n"+
		"w\3w\3w\3x\3x\6x\u05ea\nx\rx\16x\u05eb\3x\3x\3x\3x\3x\6x\u05f3\nx\rx\16"+
		"x\u05f4\3x\3x\7x\u05f9\nx\fx\16x\u05fc\13x\5x\u05fe\nx\3y\3y\5y\u0602"+
		"\ny\3z\3z\3z\3{\3{\3{\5{\u060a\n{\3|\3|\3|\3|\3}\3}\3}\7}\u0613\n}\f}"+
		"\16}\u0616\13}\3~\3~\3~\5~\u061b\n~\3~\3~\3~\3~\7~\u0621\n~\f~\16~\u0624"+
		"\13~\3\177\3\177\3\u0080\3\u0080\3\u0080\3\u0080\7\u0080\u062c\n\u0080"+
		"\f\u0080\16\u0080\u062f\13\u0080\3\u0080\3\u0080\3\u0081\3\u0081\3\u0081"+
		"\5\u0081\u0636\n\u0081\3\u0081\3\u0081\5\u0081\u063a\n\u0081\5\u0081\u063c"+
		"\n\u0081\3\u0082\3\u0082\3\u0082\3\u0082\3\u0082\5\u0082\u0643\n\u0082"+
		"\3\u0083\3\u0083\5\u0083\u0647\n\u0083\3\u0083\3\u0083\3\u0083\2\4\u00d8"+
		"\u00e4\u0084\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64"+
		"\668:<>@BDFHJLNPRTVXZ\\^`bdfhjlnprtvxz|~\u0080\u0082\u0084\u0086\u0088"+
		"\u008a\u008c\u008e\u0090\u0092\u0094\u0096\u0098\u009a\u009c\u009e\u00a0"+
		"\u00a2\u00a4\u00a6\u00a8\u00aa\u00ac\u00ae\u00b0\u00b2\u00b4\u00b6\u00b8"+
		"\u00ba\u00bc\u00be\u00c0\u00c2\u00c4\u00c6\u00c8\u00ca\u00cc\u00ce\u00d0"+
		"\u00d2\u00d4\u00d6\u00d8\u00da\u00dc\u00de\u00e0\u00e2\u00e4\u00e6\u00e8"+
		"\u00ea\u00ec\u00ee\u00f0\u00f2\u00f4\u00f6\u00f8\u00fa\u00fc\u00fe\u0100"+
		"\u0102\u0104\2\21\4\2  ..\3\2EH\3\2IJ\4\2,,>>\4\2\65C\177\177\5\2\65>"+
		"AC\177\177\4\2Z[nq\3\2\\^\3\2Z[\4\2RSUV\4\2TTWW\3\2bm\3\2pq\4\2QQ\u0080"+
		"\u0080\3\2\3\13\2\u06e4\2\u0122\3\2\2\2\4\u0125\3\2\2\2\6\u0130\3\2\2"+
		"\2\b\u0134\3\2\2\2\n\u0139\3\2\2\2\f\u0156\3\2\2\2\16\u0159\3\2\2\2\20"+
		"\u0163\3\2\2\2\22\u0174\3\2\2\2\24\u0181\3\2\2\2\26\u018b\3\2\2\2\30\u0191"+
		"\3\2\2\2\32\u01be\3\2\2\2\34\u01c0\3\2\2\2\36\u01cb\3\2\2\2 \u01d3\3\2"+
		"\2\2\"\u01db\3\2\2\2$\u01e3\3\2\2\2&\u01f1\3\2\2\2(\u01f3\3\2\2\2*\u01fd"+
		"\3\2\2\2,\u0208\3\2\2\2.\u0213\3\2\2\2\60\u021e\3\2\2\2\62\u0222\3\2\2"+
		"\2\64\u0229\3\2\2\2\66\u0239\3\2\2\28\u0247\3\2\2\2:\u0249\3\2\2\2<\u0255"+
		"\3\2\2\2>\u0259\3\2\2\2@\u0265\3\2\2\2B\u0270\3\2\2\2D\u0278\3\2\2\2F"+
		"\u027d\3\2\2\2H\u0287\3\2\2\2J\u0289\3\2\2\2L\u02a1\3\2\2\2N\u02af\3\2"+
		"\2\2P\u02b1\3\2\2\2R\u02b9\3\2\2\2T\u02c9\3\2\2\2V\u02e1\3\2\2\2X\u02e3"+
		"\3\2\2\2Z\u02e7\3\2\2\2\\\u02ed\3\2\2\2^\u02f5\3\2\2\2`\u02f9\3\2\2\2"+
		"b\u0308\3\2\2\2d\u030a\3\2\2\2f\u030c\3\2\2\2h\u0313\3\2\2\2j\u031c\3"+
		"\2\2\2l\u0322\3\2\2\2n\u032c\3\2\2\2p\u0334\3\2\2\2r\u033b\3\2\2\2t\u033d"+
		"\3\2\2\2v\u0351\3\2\2\2x\u035b\3\2\2\2z\u035f\3\2\2\2|\u0361\3\2\2\2~"+
		"\u0367\3\2\2\2\u0080\u0369\3\2\2\2\u0082\u036d\3\2\2\2\u0084\u0397\3\2"+
		"\2\2\u0086\u0399\3\2\2\2\u0088\u039b\3\2\2\2\u008a\u03a1\3\2\2\2\u008c"+
		"\u03a9\3\2\2\2\u008e\u03cb\3\2\2\2\u0090\u03ce\3\2\2\2\u0092\u03d8\3\2"+
		"\2\2\u0094\u03db\3\2\2\2\u0096\u03e6\3\2\2\2\u0098\u03e8\3\2\2\2\u009a"+
		"\u03fe\3\2\2\2\u009c\u0400\3\2\2\2\u009e\u0408\3\2\2\2\u00a0\u040c\3\2"+
		"\2\2\u00a2\u0412\3\2\2\2\u00a4\u0418\3\2\2\2\u00a6\u041c\3\2\2\2\u00a8"+
		"\u0422\3\2\2\2\u00aa\u042f\3\2\2\2\u00ac\u043b\3\2\2\2\u00ae\u043f\3\2"+
		"\2\2\u00b0\u0443\3\2\2\2\u00b2\u0449\3\2\2\2\u00b4\u044d\3\2\2\2\u00b6"+
		"\u0453\3\2\2\2\u00b8\u0459\3\2\2\2\u00ba\u045d\3\2\2\2\u00bc\u0460\3\2"+
		"\2\2\u00be\u0464\3\2\2\2\u00c0\u046c\3\2\2\2\u00c2\u0474\3\2\2\2\u00c4"+
		"\u0477\3\2\2\2\u00c6\u047e\3\2\2\2\u00c8\u0492\3\2\2\2\u00ca\u049f\3\2"+
		"\2\2\u00cc\u04ad\3\2\2\2\u00ce\u04b1\3\2\2\2\u00d0\u04b3\3\2\2\2\u00d2"+
		"\u04bc\3\2\2\2\u00d4\u04c0\3\2\2\2\u00d6\u04cb\3\2\2\2\u00d8\u0509\3\2"+
		"\2\2\u00da\u0561\3\2\2\2\u00dc\u0566\3\2\2\2\u00de\u0580\3\2\2\2\u00e0"+
		"\u0584\3\2\2\2\u00e2\u059d\3\2\2\2\u00e4\u05af\3\2\2\2\u00e6\u05bc\3\2"+
		"\2\2\u00e8\u05cc\3\2\2\2\u00ea\u05dd\3\2\2\2\u00ec\u05df\3\2\2\2\u00ee"+
		"\u05fd\3\2\2\2\u00f0\u05ff\3\2\2\2\u00f2\u0603\3\2\2\2\u00f4\u0609\3\2"+
		"\2\2\u00f6\u060b\3\2\2\2\u00f8\u060f\3\2\2\2\u00fa\u0617\3\2\2\2\u00fc"+
		"\u0625\3\2\2\2\u00fe\u0627\3\2\2\2\u0100\u063b\3\2\2\2\u0102\u0642\3\2"+
		"\2\2\u0104\u0644\3\2\2\2\u0106\u0108\5\b\5\2\u0107\u0106\3\2\2\2\u0107"+
		"\u0108\3\2\2\2\u0108\u0112\3\2\2\2\u0109\u010b\5\4\3\2\u010a\u0109\3\2"+
		"\2\2\u010a\u010b\3\2\2\2\u010b\u0113\3\2\2\2\u010c\u010e\7x\2\2\u010d"+
		"\u010c\3\2\2\2\u010e\u0111\3\2\2\2\u010f\u010d\3\2\2\2\u010f\u0110\3\2"+
		"\2\2\u0110\u0113\3\2\2\2\u0111\u010f\3\2\2\2\u0112\u010a\3\2\2\2\u0112"+
		"\u010f\3\2\2\2\u0113\u011d\3\2\2\2\u0114\u0116\5\6\4\2\u0115\u0114\3\2"+
		"\2\2\u0115\u0116\3\2\2\2\u0116\u011e\3\2\2\2\u0117\u0119\7x\2\2\u0118"+
		"\u0117\3\2\2\2\u0119\u011c\3\2\2\2\u011a\u0118\3\2\2\2\u011a\u011b\3\2"+
		"\2\2\u011b\u011e\3\2\2\2\u011c\u011a\3\2\2\2\u011d\u0115\3\2\2\2\u011d"+
		"\u011a\3\2\2\2\u011e\u0123\3\2\2\2\u011f\u0120\5\u0082B\2\u0120\u0121"+
		"\7\2\2\3\u0121\u0123\3\2\2\2\u0122\u0107\3\2\2\2\u0122\u011f\3\2\2\2\u0123"+
		"\3\3\2\2\2\u0124\u0126\5\n\6\2\u0125\u0124\3\2\2\2\u0126\u0127\3\2\2\2"+
		"\u0127\u0125\3\2\2\2\u0127\u0128\3\2\2\2\u0128\5\3\2\2\2\u0129\u012d\5"+
		"\16\b\2\u012a\u012c\7x\2\2\u012b\u012a\3\2\2\2\u012c\u012f\3\2\2\2\u012d"+
		"\u012b\3\2\2\2\u012d\u012e\3\2\2\2\u012e\u0131\3\2\2\2\u012f\u012d\3\2"+
		"\2\2\u0130\u0129\3\2\2\2\u0131\u0132\3\2\2\2\u0132\u0130\3\2\2\2\u0132"+
		"\u0133\3\2\2\2\u0133\7\3\2\2\2\u0134\u0135\5j\66\2\u0135\u0136\7(\2\2"+
		"\u0136\u0137\5`\61\2\u0137\u0138\7x\2\2\u0138\t\3\2\2\2\u0139\u013b\7"+
		"#\2\2\u013a\u013c\7,\2\2\u013b\u013a\3\2\2\2\u013b\u013c\3\2\2\2\u013c"+
		"\u013d\3\2\2\2\u013d\u0140\5`\61\2\u013e\u013f\7z\2\2\u013f\u0141\7\\"+
		"\2\2\u0140\u013e\3\2\2\2\u0140\u0141\3\2\2\2\u0141\u0142\3\2\2\2\u0142"+
		"\u0143\7x\2\2\u0143\13\3\2\2\2\u0144\u0155\5l\67\2\u0145\u0155\7+\2\2"+
		"\u0146\u0155\7*\2\2\u0147\u0155\7)\2\2\u0148\u0155\7,\2\2\u0149\u0155"+
		"\7\32\2\2\u014a\u0155\7!\2\2\u014b\u0155\7-\2\2\u014c\u0155\7B\2\2\u014d"+
		"\u0155\7D\2\2\u014e\u0155\7&\2\2\u014f\u0155\7/\2\2\u0150\u0155\7\63\2"+
		"\2\u0151\u0155\7\64\2\2\u0152\u0155\7-\2\2\u0153\u0155\7\36\2\2\u0154"+
		"\u0144\3\2\2\2\u0154\u0145\3\2\2\2\u0154\u0146\3\2\2\2\u0154\u0147\3\2"+
		"\2\2\u0154\u0148\3\2\2\2\u0154\u0149\3\2\2\2\u0154\u014a\3\2\2\2\u0154"+
		"\u014b\3\2\2\2\u0154\u014c\3\2\2\2\u0154\u014d\3\2\2\2\u0154\u014e\3\2"+
		"\2\2\u0154\u014f\3\2\2\2\u0154\u0150\3\2\2\2\u0154\u0151\3\2\2\2\u0154"+
		"\u0152\3\2\2\2\u0154\u0153\3\2\2\2\u0155\u0158\3\2\2\2\u0156\u0154\3\2"+
		"\2\2\u0156\u0157\3\2\2\2\u0157\r\3\2\2\2\u0158\u0156\3\2\2\2\u0159\u015f"+
		"\5\f\7\2\u015a\u0160\5\20\t\2\u015b\u0160\5\22\n\2\u015c\u0160\5\24\13"+
		"\2\u015d\u0160\5\26\f\2\u015e\u0160\5\30\r\2\u015f\u015a\3\2\2\2\u015f"+
		"\u015b\3\2\2\2\u015f\u015c\3\2\2\2\u015f\u015d\3\2\2\2\u015f\u015e\3\2"+
		"\2\2\u0160\u0161\3\2\2\2\u0161\u0162\5\32\16\2\u0162\17\3\2\2\2\u0163"+
		"\u0164\7\34\2\2\u0164\u0166\5\u0096L\2\u0165\u0167\5\34\17\2\u0166\u0165"+
		"\3\2\2\2\u0166\u0167\3\2\2\2\u0167\u016a\3\2\2\2\u0168\u0169\7 \2\2\u0169"+
		"\u016b\5\u00fa~\2\u016a\u0168\3\2\2\2\u016a\u016b\3\2\2\2\u016b\u016e"+
		"\3\2\2\2\u016c\u016d\7\"\2\2\u016d\u016f\5\u00f8}\2\u016e\u016c\3\2\2"+
		"\2\u016e\u016f\3\2\2\2\u016f\u0172\3\2\2\2\u0170\u0171\7C\2\2\u0171\u0173"+
		"\5\u00f8}\2\u0172\u0170\3\2\2\2\u0172\u0173\3\2\2\2\u0173\21\3\2\2\2\u0174"+
		"\u0175\7%\2\2\u0175\u0177\5\u0096L\2\u0176\u0178\5\34\17\2\u0177\u0176"+
		"\3\2\2\2\u0177\u0178\3\2\2\2\u0178\u017b\3\2\2\2\u0179\u017a\7 \2\2\u017a"+
		"\u017c\5\u00f8}\2\u017b\u0179\3\2\2\2\u017b\u017c\3\2\2\2\u017c\u017f"+
		"\3\2\2\2\u017d\u017e\7C\2\2\u017e\u0180\5\u00f8}\2\u017f\u017d\3\2\2\2"+
		"\u017f\u0180\3\2\2\2\u0180\23\3\2\2\2\u0181\u0182\7A\2\2\u0182\u0184\5"+
		"\u0096L\2\u0183\u0185\5\34\17\2\u0184\u0183\3\2\2\2\u0184\u0185\3\2\2"+
		"\2\u0185\u0186\3\2\2\2\u0186\u0189\5\u0088E\2\u0187\u0188\7\"\2\2\u0188"+
		"\u018a\5\u00f8}\2\u0189\u0187\3\2\2\2\u0189\u018a\3\2\2\2\u018a\25\3\2"+
		"\2\2\u018b\u018c\7\37\2\2\u018c\u018f\5\u0096L\2\u018d\u018e\7\"\2\2\u018e"+
		"\u0190\5\u00f8}\2\u018f\u018d\3\2\2\2\u018f\u0190\3\2\2\2\u0190\27\3\2"+
		"\2\2\u0191\u0192\7\u0082\2\2\u0192\u0193\7%\2\2\u0193\u0194\5\u0096L\2"+
		"\u0194\31\3\2\2\2\u0195\u0199\7t\2\2\u0196\u0198\5&\24\2\u0197\u0196\3"+
		"\2\2\2\u0198\u019b\3\2\2\2\u0199\u0197\3\2\2\2\u0199\u019a\3\2\2\2\u019a"+
		"\u019c\3\2\2\2\u019b\u0199\3\2\2\2\u019c\u01bf\7u\2\2\u019d\u019f\7t\2"+
		"\2\u019e\u01a0\5\"\22\2\u019f\u019e\3\2\2\2\u019f\u01a0\3\2\2\2\u01a0"+
		"\u01a2\3\2\2\2\u01a1\u01a3\7y\2\2\u01a2\u01a1\3\2\2\2\u01a2\u01a3\3\2"+
		"\2\2\u01a3\u01ab\3\2\2\2\u01a4\u01a8\7x\2\2\u01a5\u01a7\5&\24\2\u01a6"+
		"\u01a5\3\2\2\2\u01a7\u01aa\3\2\2\2\u01a8\u01a6\3\2\2\2\u01a8\u01a9\3\2"+
		"\2\2\u01a9\u01ac\3\2\2\2\u01aa\u01a8\3\2\2\2\u01ab\u01a4\3\2\2\2\u01ab"+
		"\u01ac\3\2\2\2\u01ac\u01ad\3\2\2\2\u01ad\u01bf\7u\2\2\u01ae\u01b2\7t\2"+
		"\2\u01af\u01b1\5v<\2\u01b0\u01af\3\2\2\2\u01b1\u01b4\3\2\2\2\u01b2\u01b0"+
		"\3\2\2\2\u01b2\u01b3\3\2\2\2\u01b3\u01b5\3\2\2\2\u01b4\u01b2\3\2\2\2\u01b5"+
		"\u01bf\7u\2\2\u01b6\u01ba\7t\2\2\u01b7\u01b9\5\u0084C\2\u01b8\u01b7\3"+
		"\2\2\2\u01b9\u01bc\3\2\2\2\u01ba\u01b8\3\2\2\2\u01ba\u01bb\3\2\2\2\u01bb"+
		"\u01bd\3\2\2\2\u01bc\u01ba\3\2\2\2\u01bd\u01bf\7u\2\2\u01be\u0195\3\2"+
		"\2\2\u01be\u019d\3\2\2\2\u01be\u01ae\3\2\2\2\u01be\u01b6\3\2\2\2\u01bf"+
		"\33\3\2\2\2\u01c0\u01c1\7S\2\2\u01c1\u01c6\5\36\20\2\u01c2\u01c3\7y\2"+
		"\2\u01c3\u01c5\5\36\20\2\u01c4\u01c2\3\2\2\2\u01c5\u01c8\3\2\2\2\u01c6"+
		"\u01c4\3\2\2\2\u01c6\u01c7\3\2\2\2\u01c7\u01c9\3\2\2\2\u01c8\u01c6\3\2"+
		"\2\2\u01c9\u01ca\7R\2\2\u01ca\35\3\2\2\2\u01cb\u01cc\5j\66\2\u01cc\u01d1"+
		"\5\u0096L\2\u01cd\u01ce\7 \2\2\u01ce\u01cf\5j\66\2\u01cf\u01d0\5 \21\2"+
		"\u01d0\u01d2\3\2\2\2\u01d1\u01cd\3\2\2\2\u01d1\u01d2\3\2\2\2\u01d2\37"+
		"\3\2\2\2\u01d3\u01d8\5\u00fa~\2\u01d4\u01d5\7_\2\2\u01d5\u01d7\5\u00fa"+
		"~\2\u01d6\u01d4\3\2\2\2\u01d7\u01da\3\2\2\2\u01d8\u01d6\3\2\2\2\u01d8"+
		"\u01d9\3\2\2\2\u01d9!\3\2\2\2\u01da\u01d8\3\2\2\2\u01db\u01e0\5$\23\2"+
		"\u01dc\u01dd\7y\2\2\u01dd\u01df\5$\23\2\u01de\u01dc\3\2\2\2\u01df\u01e2"+
		"\3\2\2\2\u01e0\u01de\3\2\2\2\u01e0\u01e1\3\2\2\2\u01e1#\3\2\2\2\u01e2"+
		"\u01e0\3\2\2\2\u01e3\u01e4\5j\66\2\u01e4\u01e6\5\u0096L\2\u01e5\u01e7"+
		"\5\u0104\u0083\2\u01e6\u01e5\3\2\2\2\u01e6\u01e7\3\2\2\2\u01e7\u01e9\3"+
		"\2\2\2\u01e8\u01ea\5\32\16\2\u01e9\u01e8\3\2\2\2\u01e9\u01ea\3\2\2\2\u01ea"+
		"%\3\2\2\2\u01eb\u01f2\7x\2\2\u01ec\u01f2\5*\26\2\u01ed\u01f2\5,\27\2\u01ee"+
		"\u01f2\5.\30\2\u01ef\u01f2\5\60\31\2\u01f0\u01f2\5\6\4\2\u01f1\u01eb\3"+
		"\2\2\2\u01f1\u01ec\3\2\2\2\u01f1\u01ed\3\2\2\2\u01f1\u01ee\3\2\2\2\u01f1"+
		"\u01ef\3\2\2\2\u01f1\u01f0\3\2\2\2\u01f2\'\3\2\2\2\u01f3\u01f4\5\f\7\2"+
		"\u01f4\u01f5\5\u008eH\2\u01f5)\3\2\2\2\u01f6\u01fa\5(\25\2\u01f7\u01f9"+
		"\7x\2\2\u01f8\u01f7\3\2\2\2\u01f9\u01fc\3\2\2\2\u01fa\u01f8\3\2\2\2\u01fa"+
		"\u01fb\3\2\2\2\u01fb\u01fe\3\2\2\2\u01fc\u01fa\3\2\2\2\u01fd\u01f6\3\2"+
		"\2\2\u01fe\u01ff\3\2\2\2\u01ff\u01fd\3\2\2\2\u01ff\u0200\3\2\2\2\u0200"+
		"+\3\2\2\2\u0201\u0205\5:\36\2\u0202\u0204\7x\2\2\u0203\u0202\3\2\2\2\u0204"+
		"\u0207\3\2\2\2\u0205\u0203\3\2\2\2\u0205\u0206\3\2\2\2\u0206\u0209\3\2"+
		"\2\2\u0207\u0205\3\2\2\2\u0208\u0201\3\2\2\2\u0209\u020a\3\2\2\2\u020a"+
		"\u0208\3\2\2\2\u020a\u020b\3\2\2\2\u020b-\3\2\2\2\u020c\u0210\5\66\34"+
		"\2\u020d\u020f\7x\2\2\u020e\u020d\3\2\2\2\u020f\u0212\3\2\2\2\u0210\u020e"+
		"\3\2\2\2\u0210\u0211\3\2\2\2\u0211\u0214\3\2\2\2\u0212\u0210\3\2\2\2\u0213"+
		"\u020c\3\2\2\2\u0214\u0215\3\2\2\2\u0215\u0213\3\2\2\2\u0215\u0216\3\2"+
		"\2\2\u0216/\3\2\2\2\u0217\u021b\5\62\32\2\u0218\u021a\7x\2\2\u0219\u0218"+
		"\3\2\2\2\u021a\u021d\3\2\2\2\u021b\u0219\3\2\2\2\u021b\u021c\3\2\2\2\u021c"+
		"\u021f\3\2\2\2\u021d\u021b\3\2\2\2\u021e\u0217\3\2\2\2\u021f\u0220\3\2"+
		"\2\2\u0220\u021e\3\2\2\2\u0220\u0221\3\2\2\2\u0221\61\3\2\2\2\u0222\u0223"+
		"\5\f\7\2\u0223\u0226\5\64\33\2\u0224\u0227\7x\2\2\u0225\u0227\5\u008e"+
		"H\2\u0226\u0224\3\2\2\2\u0226\u0225\3\2\2\2\u0227\63\3\2\2\2\u0228\u022a"+
		"\5\34\17\2\u0229\u0228\3\2\2\2\u0229\u022a\3\2\2\2\u022a\u022b\3\2\2\2"+
		"\u022b\u022c\5\u00fa~\2\u022c\u022d\5\u0096L\2\u022d\u0232\5R*\2\u022e"+
		"\u022f\7v\2\2\u022f\u0231\7w\2\2\u0230\u022e\3\2\2\2\u0231\u0234\3\2\2"+
		"\2\u0232\u0230\3\2\2\2\u0232\u0233\3\2\2\2\u0233\u0237\3\2\2\2\u0234\u0232"+
		"\3\2\2\2\u0235\u0236\7\62\2\2\u0236\u0238\5P)\2\u0237\u0235\3\2\2\2\u0237"+
		"\u0238\3\2\2\2\u0238\65\3\2\2\2\u0239\u023a\5\f\7\2\u023a\u023b\58\35"+
		"\2\u023b\u023c\5\u008eH\2\u023c\67\3\2\2\2\u023d\u023f\5\34\17\2\u023e"+
		"\u023d\3\2\2\2\u023e\u023f\3\2\2\2\u023f\u0240\3\2\2\2\u0240\u0241\5\u0096"+
		"L\2\u0241\u0244\5R*\2\u0242\u0243\7\62\2\2\u0243\u0245\5P)\2\u0244\u0242"+
		"\3\2\2\2\u0244\u0245\3\2\2\2\u0245\u0248\3\2\2\2\u0246\u0248\5\u0096L"+
		"\2\u0247\u023e\3\2\2\2\u0247\u0246\3\2\2\2\u02489\3\2\2\2\u0249\u024a"+
		"\5\f\7\2\u024a\u024b\5\u00fa~\2\u024b\u024c\5B\"\2\u024c\u024d\7x\2\2"+
		"\u024d;\3\2\2\2\u024e\u0252\5> \2\u024f\u0251\7x\2\2\u0250\u024f\3\2\2"+
		"\2\u0251\u0254\3\2\2\2\u0252\u0250\3\2\2\2\u0252\u0253\3\2\2\2\u0253\u0256"+
		"\3\2\2\2\u0254\u0252\3\2\2\2\u0255\u024e\3\2\2\2\u0256\u0257\3\2\2\2\u0257"+
		"\u0255\3\2\2\2\u0257\u0258\3\2\2\2\u0258=\3\2\2\2\u0259\u025a\5\f\7\2"+
		"\u025a\u025b\5\u00fa~\2\u025b\u0260\5@!\2\u025c\u025d\7y\2\2\u025d\u025f"+
		"\5@!\2\u025e\u025c\3\2\2\2\u025f\u0262\3\2\2\2\u0260\u025e\3\2\2\2\u0260"+
		"\u0261\3\2\2\2\u0261\u0263\3\2\2\2\u0262\u0260\3\2\2\2\u0263\u0264\7x"+
		"\2\2\u0264?\3\2\2\2\u0265\u026a\5\u0096L\2\u0266\u0267\7v\2\2\u0267\u0269"+
		"\7w\2\2\u0268\u0266\3\2\2\2\u0269\u026c\3\2\2\2\u026a\u0268\3\2\2\2\u026a"+
		"\u026b\3\2\2\2\u026b\u026d\3\2\2\2\u026c\u026a\3\2\2\2\u026d\u026e\7b"+
		"\2\2\u026e\u026f\5H%\2\u026fA\3\2\2\2\u0270\u0275\5D#\2\u0271\u0272\7"+
		"y\2\2\u0272\u0274\5D#\2\u0273\u0271\3\2\2\2\u0274\u0277\3\2\2\2\u0275"+
		"\u0273\3\2\2\2\u0275\u0276\3\2\2\2\u0276C\3\2\2\2\u0277\u0275\3\2\2\2"+
		"\u0278\u027b\5F$\2\u0279\u027a\7b\2\2\u027a\u027c\5H%\2\u027b\u0279\3"+
		"\2\2\2\u027b\u027c\3\2\2\2\u027cE\3\2\2\2\u027d\u0282\5\u0096L\2\u027e"+
		"\u027f\7v\2\2\u027f\u0281\7w\2\2\u0280\u027e\3\2\2\2\u0281\u0284\3\2\2"+
		"\2\u0282\u0280\3\2\2\2\u0282\u0283\3\2\2\2\u0283G\3\2\2\2\u0284\u0282"+
		"\3\2\2\2\u0285\u0288\5J&\2\u0286\u0288\5\u00d8m\2\u0287\u0285\3\2\2\2"+
		"\u0287\u0286\3\2\2\2\u0288I\3\2\2\2\u0289\u0295\7t\2\2\u028a\u028f\5H"+
		"%\2\u028b\u028c\7y\2\2\u028c\u028e\5H%\2\u028d\u028b\3\2\2\2\u028e\u0291"+
		"\3\2\2\2\u028f\u028d\3\2\2\2\u028f\u0290\3\2\2\2\u0290\u0293\3\2\2\2\u0291"+
		"\u028f\3\2\2\2\u0292\u0294\7y\2\2\u0293\u0292\3\2\2\2\u0293\u0294\3\2"+
		"\2\2\u0294\u0296\3\2\2\2\u0295\u028a\3\2\2\2\u0295\u0296\3\2\2\2\u0296"+
		"\u0297\3\2\2\2\u0297\u0298\7u\2\2\u0298K\3\2\2\2\u0299\u029b\5\u0096L"+
		"\2\u029a\u029c\5\u00fe\u0080\2\u029b\u029a\3\2\2\2\u029b\u029c\3\2\2\2"+
		"\u029c\u029d\3\2\2\2\u029d\u029e\7z\2\2\u029e\u02a0\3\2\2\2\u029f\u0299"+
		"\3\2\2\2\u02a0\u02a3\3\2\2\2\u02a1\u029f\3\2\2\2\u02a1\u02a2\3\2\2\2\u02a2"+
		"\u02a4\3\2\2\2\u02a3\u02a1\3\2\2\2\u02a4\u02a6\5\u0098M\2\u02a5\u02a7"+
		"\5\u00fe\u0080\2\u02a6\u02a5\3\2\2\2\u02a6\u02a7\3\2\2\2\u02a7M\3\2\2"+
		"\2\u02a8\u02b0\5\u00fa~\2\u02a9\u02aa\5j\66\2\u02aa\u02ad\7P\2\2\u02ab"+
		"\u02ac\t\2\2\2\u02ac\u02ae\5\u00fa~\2\u02ad\u02ab\3\2\2\2\u02ad\u02ae"+
		"\3\2\2\2\u02ae\u02b0\3\2\2\2\u02af\u02a8\3\2\2\2\u02af\u02a9\3\2\2\2\u02b0"+
		"O\3\2\2\2\u02b1\u02b6\5`\61\2\u02b2\u02b3\7y\2\2\u02b3\u02b5\5`\61\2\u02b4"+
		"\u02b2\3\2\2\2\u02b5\u02b8\3\2\2\2\u02b6\u02b4\3\2\2\2\u02b6\u02b7\3\2"+
		"\2\2\u02b7Q\3\2\2\2\u02b8\u02b6\3\2\2\2\u02b9\u02c5\7r\2\2\u02ba\u02bc"+
		"\5T+\2\u02bb\u02ba\3\2\2\2\u02bb\u02bc\3\2\2\2\u02bc\u02c6\3\2\2\2\u02bd"+
		"\u02c0\5T+\2\u02be\u02bf\7y\2\2\u02bf\u02c1\5V,\2\u02c0\u02be\3\2\2\2"+
		"\u02c0\u02c1\3\2\2\2\u02c1\u02c6\3\2\2\2\u02c2\u02c4\5V,\2\u02c3\u02c2"+
		"\3\2\2\2\u02c3\u02c4\3\2\2\2\u02c4\u02c6\3\2\2\2\u02c5\u02bb\3\2\2\2\u02c5"+
		"\u02bd\3\2\2\2\u02c5\u02c3\3\2\2\2\u02c6\u02c7\3\2\2\2\u02c7\u02c8\7s"+
		"\2\2\u02c8S\3\2\2\2\u02c9\u02cf\5\u00fa~\2\u02ca\u02cb\5\u0096L\2\u02cb"+
		"\u02cc\7z\2\2\u02cc\u02ce\3\2\2\2\u02cd\u02ca\3\2\2\2\u02ce\u02d1\3\2"+
		"\2\2\u02cf\u02cd\3\2\2\2\u02cf\u02d0\3\2\2\2\u02d0\u02d2\3\2\2\2\u02d1"+
		"\u02cf\3\2\2\2\u02d2\u02d3\7\60\2\2\u02d3U\3\2\2\2\u02d4\u02d9\5X-\2\u02d5"+
		"\u02d6\7y\2\2\u02d6\u02d8\5X-\2\u02d7\u02d5\3\2\2\2\u02d8\u02db\3\2\2"+
		"\2\u02d9\u02d7\3\2\2\2\u02d9\u02da\3\2\2\2\u02da\u02de\3\2\2\2\u02db\u02d9"+
		"\3\2\2\2\u02dc\u02dd\7y\2\2\u02dd\u02df\5Z.\2\u02de\u02dc\3\2\2\2\u02de"+
		"\u02df\3\2\2\2\u02df\u02e2\3\2\2\2\u02e0\u02e2\5Z.\2\u02e1\u02d4\3\2\2"+
		"\2\u02e1\u02e0\3\2\2\2\u02e2W\3\2\2\2\u02e3\u02e4\5\f\7\2\u02e4\u02e5"+
		"\5\u00fa~\2\u02e5\u02e6\5F$\2\u02e6Y\3\2\2\2\u02e7\u02e8\5\f\7\2\u02e8"+
		"\u02e9\5\u00fa~\2\u02e9\u02ea\5j\66\2\u02ea\u02eb\7\u0083\2\2\u02eb\u02ec"+
		"\5F$\2\u02ec[\3\2\2\2\u02ed\u02f2\5^\60\2\u02ee\u02ef\7y\2\2\u02ef\u02f1"+
		"\5^\60\2\u02f0\u02ee\3\2\2\2\u02f1\u02f4\3\2\2\2\u02f2\u02f0\3\2\2\2\u02f2"+
		"\u02f3\3\2\2\2\u02f3]\3\2\2\2\u02f4\u02f2\3\2\2\2\u02f5\u02f6\5\f\7\2"+
		"\u02f6\u02f7\7?\2\2\u02f7\u02f8\5\u0096L\2\u02f8_\3\2\2\2\u02f9\u02fe"+
		"\5\u0096L\2\u02fa\u02fb\7z\2\2\u02fb\u02fd\5\u0096L\2\u02fc\u02fa\3\2"+
		"\2\2\u02fd\u0300\3\2\2\2\u02fe\u02fc\3\2\2\2\u02fe\u02ff\3\2\2\2\u02ff"+
		"a\3\2\2\2\u0300\u02fe\3\2\2\2\u0301\u0309\5d\63\2\u0302\u0309\5f\64\2"+
		"\u0303\u0309\7K\2\2\u0304\u0309\7L\2\2\u0305\u0309\7N\2\2\u0306\u0309"+
		"\7O\2\2\u0307\u0309\7M\2\2\u0308\u0301\3\2\2\2\u0308\u0302\3\2\2\2\u0308"+
		"\u0303\3\2\2\2\u0308\u0304\3\2\2\2\u0308\u0305\3\2\2\2\u0308\u0306\3\2"+
		"\2\2\u0308\u0307\3\2\2\2\u0309c\3\2\2\2\u030a\u030b\t\3\2\2\u030be\3\2"+
		"\2\2\u030c\u030d\t\4\2\2\u030dg\3\2\2\2\u030e\u030f\5\u0096L\2\u030f\u0310"+
		"\7z\2\2\u0310\u0312\3\2\2\2\u0311\u030e\3\2\2\2\u0312\u0315\3\2\2\2\u0313"+
		"\u0311\3\2\2\2\u0313\u0314\3\2\2\2\u0314\u0316\3\2\2\2\u0315\u0313\3\2"+
		"\2\2\u0316\u0317\7\u0082\2\2\u0317\u0318\5\u0096L\2\u0318i\3\2\2\2\u0319"+
		"\u031b\5l\67\2\u031a\u0319\3\2\2\2\u031b\u031e\3\2\2\2\u031c\u031a\3\2"+
		"\2\2\u031c\u031d\3\2\2\2\u031dk\3\2\2\2\u031e\u031c\3\2\2\2\u031f\u0320"+
		"\7\u0082\2\2\u0320\u0323\5`\61\2\u0321\u0323\5h\65\2\u0322\u031f\3\2\2"+
		"\2\u0322\u0321\3\2\2\2\u0323\u032a\3\2\2\2\u0324\u0327\7r\2\2\u0325\u0328"+
		"\5n8\2\u0326\u0328\5r:\2\u0327\u0325\3\2\2\2\u0327\u0326\3\2\2\2\u0327"+
		"\u0328\3\2\2\2\u0328\u0329\3\2\2\2\u0329\u032b\7s\2\2\u032a\u0324\3\2"+
		"\2\2\u032a\u032b\3\2\2\2\u032bm\3\2\2\2\u032c\u0331\5p9\2\u032d\u032e"+
		"\7y\2\2\u032e\u0330\5p9\2\u032f\u032d\3\2\2\2\u0330\u0333\3\2\2\2\u0331"+
		"\u032f\3\2\2\2\u0331\u0332\3\2\2\2\u0332o\3\2\2\2\u0333\u0331\3\2\2\2"+
		"\u0334\u0335\5\u0096L\2\u0335\u0336\7b\2\2\u0336\u0337\5r:\2\u0337q\3"+
		"\2\2\2\u0338\u033c\5\u00d8m\2\u0339\u033c\5l\67\2\u033a\u033c\5t;\2\u033b"+
		"\u0338\3\2\2\2\u033b\u0339\3\2\2\2\u033b\u033a\3\2\2\2\u033cs\3\2\2\2"+
		"\u033d\u0346\7t\2\2\u033e\u0343\5r:\2\u033f\u0340\7y\2\2\u0340\u0342\5"+
		"r:\2\u0341\u033f\3\2\2\2\u0342\u0345\3\2\2\2\u0343\u0341\3\2\2\2\u0343"+
		"\u0344\3\2\2\2\u0344\u0347\3\2\2\2\u0345\u0343\3\2\2\2\u0346\u033e\3\2"+
		"\2\2\u0346\u0347\3\2\2\2\u0347\u0349\3\2\2\2\u0348\u034a\7y\2\2\u0349"+
		"\u0348\3\2\2\2\u0349\u034a\3\2\2\2\u034a\u034b\3\2\2\2\u034b\u034c\7u"+
		"\2\2\u034cu\3\2\2\2\u034d\u034e\5\f\7\2\u034e\u034f\5x=\2\u034f\u0352"+
		"\3\2\2\2\u0350\u0352\7x\2\2\u0351\u034d\3\2\2\2\u0351\u0350\3\2\2\2\u0352"+
		"w\3\2\2\2\u0353\u0354\5\u00fa~\2\u0354\u0355\5z>\2\u0355\u0356\7x\2\2"+
		"\u0356\u035c\3\2\2\2\u0357\u0359\5\16\b\2\u0358\u035a\7x\2\2\u0359\u0358"+
		"\3\2\2\2\u0359\u035a\3\2\2\2\u035a\u035c\3\2\2\2\u035b\u0353\3\2\2\2\u035b"+
		"\u0357\3\2\2\2\u035cy\3\2\2\2\u035d\u0360\5|?\2\u035e\u0360\5~@\2\u035f"+
		"\u035d\3\2\2\2\u035f\u035e\3\2\2\2\u0360{\3\2\2\2\u0361\u0362\5\u0096"+
		"L\2\u0362\u0363\7r\2\2\u0363\u0365\7s\2\2\u0364\u0366\5\u0080A\2\u0365"+
		"\u0364\3\2\2\2\u0365\u0366\3\2\2\2\u0366}\3\2\2\2\u0367\u0368\5B\"\2\u0368"+
		"\177\3\2\2\2\u0369\u036a\7\36\2\2\u036a\u036b\5r:\2\u036b\u0081\3\2\2"+
		"\2\u036c\u036e\7\66\2\2\u036d\u036c\3\2\2\2\u036d\u036e\3\2\2\2\u036e"+
		"\u036f\3\2\2\2\u036f\u0370\7\65\2\2\u0370\u0371\5`\61\2\u0371\u0372\5"+
		"\32\16\2\u0372\u0083\3\2\2\2\u0373\u0377\7\67\2\2\u0374\u0376\5\u0086"+
		"D\2\u0375\u0374\3\2\2\2\u0376\u0379\3\2\2\2\u0377\u0375\3\2\2\2\u0377"+
		"\u0378\3\2\2\2\u0378\u037a\3\2\2\2\u0379\u0377\3\2\2\2\u037a\u037b\5`"+
		"\61\2\u037b\u037c\7x\2\2\u037c\u0398\3\2\2\2\u037d\u037e\78\2\2\u037e"+
		"\u0381\5`\61\2\u037f\u0380\7:\2\2\u0380\u0382\5`\61\2\u0381\u037f\3\2"+
		"\2\2\u0381\u0382\3\2\2\2\u0382\u0383\3\2\2\2\u0383\u0384\7x\2\2\u0384"+
		"\u0398\3\2\2\2\u0385\u0386\79\2\2\u0386\u0389\5`\61\2\u0387\u0388\7:\2"+
		"\2\u0388\u038a\5`\61\2\u0389\u0387\3\2\2\2\u0389\u038a\3\2\2\2\u038a\u038b"+
		"\3\2\2\2\u038b\u038c\7x\2\2\u038c\u0398\3\2\2\2\u038d\u038e\7;\2\2\u038e"+
		"\u038f\5`\61\2\u038f\u0390\7x\2\2\u0390\u0398\3\2\2\2\u0391\u0392\7<\2"+
		"\2\u0392\u0393\5`\61\2\u0393\u0394\7=\2\2\u0394\u0395\5`\61\2\u0395\u0396"+
		"\7x\2\2\u0396\u0398\3\2\2\2\u0397\u0373\3\2\2\2\u0397\u037d\3\2\2\2\u0397"+
		"\u0385\3\2\2\2\u0397\u038d\3\2\2\2\u0397\u0391\3\2\2\2\u0398\u0085\3\2"+
		"\2\2\u0399\u039a\t\5\2\2\u039a\u0087\3\2\2\2\u039b\u039d\7r\2\2\u039c"+
		"\u039e\5\u008aF\2\u039d\u039c\3\2\2\2\u039d\u039e\3\2\2\2\u039e\u039f"+
		"\3\2\2\2\u039f\u03a0\7s\2\2\u03a0\u0089\3\2\2\2\u03a1\u03a6\5\u008cG\2"+
		"\u03a2\u03a3\7y\2\2\u03a3\u03a5\5\u008cG\2\u03a4\u03a2\3\2\2\2\u03a5\u03a8"+
		"\3\2\2\2\u03a6\u03a4\3\2\2\2\u03a6\u03a7\3\2\2\2\u03a7\u008b\3\2\2\2\u03a8"+
		"\u03a6\3\2\2\2\u03a9\u03aa\5\u00fa~\2\u03aa\u03ab\5\u0096L\2\u03ab\u008d"+
		"\3\2\2\2\u03ac\u03b1\7t\2\2\u03ad\u03b0\5\16\b\2\u03ae\u03b0\5\u009aN"+
		"\2\u03af\u03ad\3\2\2\2\u03af\u03ae\3\2\2\2\u03b0\u03b3\3\2\2\2\u03b1\u03af"+
		"\3\2\2\2\u03b1\u03b2\3\2\2\2\u03b2\u03b4\3\2\2\2\u03b3\u03b1\3\2\2\2\u03b4"+
		"\u03cc\7u\2\2\u03b5\u03b9\7t\2\2\u03b6\u03b8\5\u0090I\2\u03b7\u03b6\3"+
		"\2\2\2\u03b8\u03bb\3\2\2\2\u03b9\u03b7\3\2\2\2\u03b9\u03ba\3\2\2\2\u03ba"+
		"\u03bf\3\2\2\2\u03bb\u03b9\3\2\2\2\u03bc\u03be\5\u00caf\2\u03bd\u03bc"+
		"\3\2\2\2\u03be\u03c1\3\2\2\2\u03bf\u03bd\3\2\2\2\u03bf\u03c0\3\2\2\2\u03c0"+
		"\u03c2\3\2\2\2\u03c1\u03bf\3\2\2\2\u03c2\u03cc\7u\2\2\u03c3\u03c7\7t\2"+
		"\2\u03c4\u03c6\5\u00e2r\2\u03c5\u03c4\3\2\2\2\u03c6\u03c9\3\2\2\2\u03c7"+
		"\u03c5\3\2\2\2\u03c7\u03c8\3\2\2\2\u03c8\u03ca\3\2\2\2\u03c9\u03c7\3\2"+
		"\2\2\u03ca\u03cc\7u\2\2\u03cb\u03ac\3\2\2\2\u03cb\u03b5\3\2\2\2\u03cb"+
		"\u03c3\3\2\2\2\u03cc\u008f\3\2\2\2\u03cd\u03cf\5\u00caf\2\u03ce\u03cd"+
		"\3\2\2\2\u03cf\u03d0\3\2\2\2\u03d0\u03ce\3\2\2\2\u03d0\u03d1\3\2\2\2\u03d1"+
		"\u03d4\3\2\2\2\u03d2\u03d5\5\16\b\2\u03d3\u03d5\5\u009aN\2\u03d4\u03d2"+
		"\3\2\2\2\u03d4\u03d3\3\2\2\2\u03d5\u03d6\3\2\2\2\u03d6\u03d4\3\2\2\2\u03d6"+
		"\u03d7\3\2\2\2\u03d7\u0091\3\2\2\2\u03d8\u03d9\5\u0094K\2\u03d9\u03da"+
		"\7x\2\2\u03da\u0093\3\2\2\2\u03db\u03e4\5\f\7\2\u03dc\u03dd\7?\2\2\u03dd"+
		"\u03de\5\u0096L\2\u03de\u03df\7b\2\2\u03df\u03e0\5\u00d8m\2\u03e0\u03e5"+
		"\3\2\2\2\u03e1\u03e2\5\u00fa~\2\u03e2\u03e3\5B\"\2\u03e3\u03e5\3\2\2\2"+
		"\u03e4\u03dc\3\2\2\2\u03e4\u03e1\3\2\2\2\u03e5\u0095\3\2\2\2\u03e6\u03e7"+
		"\t\6\2\2\u03e7\u0097\3\2\2\2\u03e8\u03e9\t\7\2\2\u03e9\u0099\3\2\2\2\u03ea"+
		"\u03ff\5\u008eH\2\u03eb\u03ff\5\u0092J\2\u03ec\u03ff\5\u009cO\2\u03ed"+
		"\u03ff\5\u009eP\2\u03ee\u03ff\5\u00a0Q\2\u03ef\u03ff\5\u00a2R\2\u03f0"+
		"\u03ff\5\u00a4S\2\u03f1\u03ff\5\u00a6T\2\u03f2\u03ff\5\u00a8U\2\u03f3"+
		"\u03ff\5\u00aaV\2\u03f4\u03ff\5\u00acW\2\u03f5\u03ff\5\u00aeX\2\u03f6"+
		"\u03ff\5\u00b0Y\2\u03f7\u03ff\5\u00b2Z\2\u03f8\u03ff\5\u00b4[\2\u03f9"+
		"\u03ff\5\u00b6\\\2\u03fa\u03ff\5\u00b8]\2\u03fb\u03ff\7x\2\2\u03fc\u03ff"+
		"\5\u00ba^\2\u03fd\u03ff\5\u00bc_\2\u03fe\u03ea\3\2\2\2\u03fe\u03eb\3\2"+
		"\2\2\u03fe\u03ec\3\2\2\2\u03fe\u03ed\3\2\2\2\u03fe\u03ee\3\2\2\2\u03fe"+
		"\u03ef\3\2\2\2\u03fe\u03f0\3\2\2\2\u03fe\u03f1\3\2\2\2\u03fe\u03f2\3\2"+
		"\2\2\u03fe\u03f3\3\2\2\2\u03fe\u03f4\3\2\2\2\u03fe\u03f5\3\2\2\2\u03fe"+
		"\u03f6\3\2\2\2\u03fe\u03f7\3\2\2\2\u03fe\u03f8\3\2\2\2\u03fe\u03f9\3\2"+
		"\2\2\u03fe\u03fa\3\2\2\2\u03fe\u03fb\3\2\2\2\u03fe\u03fc\3\2\2\2\u03fe"+
		"\u03fd\3\2\2\2\u03ff\u009b\3\2\2\2\u0400\u0401\7\33\2\2\u0401\u0404\5"+
		"\u00d8m\2\u0402\u0403\7Q\2\2\u0403\u0405\5\u00d8m\2\u0404\u0402\3\2\2"+
		"\2\u0404\u0405\3\2\2\2\u0405\u0406\3\2\2\2\u0406\u0407\7x\2\2\u0407\u009d"+
		"\3\2\2\2\u0408\u0409\7\21\2\2\u0409\u040a\5\u00d2j\2\u040a\u040b\5\u009a"+
		"N\2\u040b\u009f\3\2\2\2\u040c\u040d\7\21\2\2\u040d\u040e\5\u00d2j\2\u040e"+
		"\u040f\5\u009aN\2\u040f\u0410\7\16\2\2\u0410\u0411\5\u009aN\2\u0411\u00a1"+
		"\3\2\2\2\u0412\u0413\7\20\2\2\u0413\u0414\7r\2\2\u0414\u0415\5\u00ccg"+
		"\2\u0415\u0416\7s\2\2\u0416\u0417\5\u009aN\2\u0417\u00a3\3\2\2\2\u0418"+
		"\u0419\7\24\2\2\u0419\u041a\5\u00d2j\2\u041a\u041b\5\u009aN\2\u041b\u00a5"+
		"\3\2\2\2\u041c\u041d\7\r\2\2\u041d\u041e\5\u009aN\2\u041e\u041f\7\24\2"+
		"\2\u041f\u0420\5\u00d2j\2\u0420\u0421\7x\2\2\u0421\u00a7\3\2\2\2\u0422"+
		"\u0423\7\23\2\2\u0423\u042d\5\u008eH\2\u0424\u0426\5\u00be`\2\u0425\u0424"+
		"\3\2\2\2\u0426\u0427\3\2\2\2\u0427\u0425\3\2\2\2\u0427\u0428\3\2\2\2\u0428"+
		"\u042a\3\2\2\2\u0429\u042b\5\u00c2b\2\u042a\u0429\3\2\2\2\u042a\u042b"+
		"\3\2\2\2\u042b\u042e\3\2\2\2\u042c\u042e\5\u00c2b\2\u042d\u0425\3\2\2"+
		"\2\u042d\u042c\3\2\2\2\u042e\u00a9\3\2\2\2\u042f\u0430\7\23\2\2\u0430"+
		"\u0431\5\u00c4c\2\u0431\u0435\5\u008eH\2\u0432\u0434\5\u00be`\2\u0433"+
		"\u0432\3\2\2\2\u0434\u0437\3\2\2\2\u0435\u0433\3\2\2\2\u0435\u0436\3\2"+
		"\2\2\u0436\u0439\3\2\2\2\u0437\u0435\3\2\2\2\u0438\u043a\5\u00c2b\2\u0439"+
		"\u0438\3\2\2\2\u0439\u043a\3\2\2\2\u043a\u00ab\3\2\2\2\u043b\u043c\7\22"+
		"\2\2\u043c\u043d\5\u00d2j\2\u043d\u043e\5\u008eH\2\u043e\u00ad\3\2\2\2"+
		"\u043f\u0440\7/\2\2\u0440\u0441\5\u00d2j\2\u0441\u0442\5\u008eH\2\u0442"+
		"\u00af\3\2\2\2\u0443\u0445\7\31\2\2\u0444\u0446\5\u00d8m\2\u0445\u0444"+
		"\3\2\2\2\u0445\u0446\3\2\2\2\u0446\u0447\3\2\2\2\u0447\u0448\7x\2\2\u0448"+
		"\u00b1\3\2\2\2\u0449\u044a\7\61\2\2\u044a\u044b\5\u00d8m\2\u044b\u044c"+
		"\7x\2\2\u044c\u00b3\3\2\2\2\u044d\u044f\7\26\2\2\u044e\u0450\5\u0096L"+
		"\2\u044f\u044e\3\2\2\2\u044f\u0450\3\2\2\2\u0450\u0451\3\2\2\2\u0451\u0452"+
		"\7x\2\2\u0452\u00b5\3\2\2\2\u0453\u0455\7\30\2\2\u0454\u0456\5\u0096L"+
		"\2\u0455\u0454\3\2\2\2\u0455\u0456\3\2\2\2\u0456\u0457\3\2\2\2\u0457\u0458"+
		"\7x\2\2\u0458\u00b7\3\2\2\2\u0459\u045a\7@\2\2\u045a\u045b\5\u00d8m\2"+
		"\u045b\u045c\7x\2\2\u045c\u00b9\3\2\2\2\u045d\u045e\5\u00d8m\2\u045e\u045f"+
		"\7x\2\2\u045f\u00bb\3\2\2\2\u0460\u0461\5\u0096L\2\u0461\u0462\7Q\2\2"+
		"\u0462\u0463\5\u009aN\2\u0463\u00bd\3\2\2\2\u0464\u0465\7\f\2\2\u0465"+
		"\u0466\7r\2\2\u0466\u0467\5\f\7\2\u0467\u0468\5\u00c0a\2\u0468\u0469\5"+
		"\u0096L\2\u0469\u046a\7s\2\2\u046a\u046b\5\u008eH\2\u046b\u00bf\3\2\2"+
		"\2\u046c\u0471\5`\61\2\u046d\u046e\7`\2\2\u046e\u0470\5`\61\2\u046f\u046d"+
		"\3\2\2\2\u0470\u0473\3\2\2\2\u0471\u046f\3\2\2\2\u0471\u0472\3\2\2\2\u0472"+
		"\u00c1\3\2\2\2\u0473\u0471\3\2\2\2\u0474\u0475\7\17\2\2\u0475\u0476\5"+
		"\u008eH\2\u0476\u00c3\3\2\2\2\u0477\u0478\7r\2\2\u0478\u047a\5\u00c6d"+
		"\2\u0479\u047b\7x\2\2\u047a\u0479\3\2\2\2\u047a\u047b\3\2\2\2\u047b\u047c"+
		"\3\2\2\2\u047c\u047d\7s\2\2\u047d\u00c5\3\2\2\2\u047e\u0483\5\u00c8e\2"+
		"\u047f\u0480\7x\2\2\u0480\u0482\5\u00c8e\2\u0481\u047f\3\2\2\2\u0482\u0485"+
		"\3\2\2\2\u0483\u0481\3\2\2\2\u0483\u0484\3\2\2\2\u0484\u00c7\3\2\2\2\u0485"+
		"\u0483\3\2\2\2\u0486\u048c\5\f\7\2\u0487\u0488\5L\'\2\u0488\u0489\5F$"+
		"\2\u0489\u048d\3\2\2\2\u048a\u048b\7?\2\2\u048b\u048d\5\u0096L\2\u048c"+
		"\u0487\3\2\2\2\u048c\u048a\3\2\2\2\u048d\u048e\3\2\2\2\u048e\u048f\7b"+
		"\2\2\u048f\u0490\5\u00d8m\2\u0490\u0493\3\2\2\2\u0491\u0493\5`\61\2\u0492"+
		"\u0486\3\2\2\2\u0492\u0491\3\2\2\2\u0493\u00c9\3\2\2\2\u0494\u049a\7\27"+
		"\2\2\u0495\u049b\5\u00d8m\2\u0496\u049b\7\177\2\2\u0497\u0498\5\u00fa"+
		"~\2\u0498\u0499\5\u0096L\2\u0499\u049b\3\2\2\2\u049a\u0495\3\2\2\2\u049a"+
		"\u0496\3\2\2\2\u049a\u0497\3\2\2\2\u049b\u049c\3\2\2\2\u049c\u04a0\7Q"+
		"\2\2\u049d\u049e\7\36\2\2\u049e\u04a0\7Q\2\2\u049f\u0494\3\2\2\2\u049f"+
		"\u049d\3\2\2\2\u04a0\u00cb\3\2\2\2\u04a1\u04ae\5\u00d0i\2\u04a2\u04a4"+
		"\5\u00ceh\2\u04a3\u04a2\3\2\2\2\u04a3\u04a4\3\2\2\2\u04a4\u04a5\3\2\2"+
		"\2\u04a5\u04a7\7x\2\2\u04a6\u04a8\5\u00d8m\2\u04a7\u04a6\3\2\2\2\u04a7"+
		"\u04a8\3\2\2\2\u04a8\u04a9\3\2\2\2\u04a9\u04ab\7x\2\2\u04aa\u04ac\5\u00d4"+
		"k\2\u04ab\u04aa\3\2\2\2\u04ab\u04ac\3\2\2\2\u04ac\u04ae\3\2\2\2\u04ad"+
		"\u04a1\3\2\2\2\u04ad\u04a3\3\2\2\2\u04ae\u00cd\3\2\2\2\u04af\u04b2\5\u0094"+
		"K\2\u04b0\u04b2\5\u00d4k\2\u04b1\u04af\3\2\2\2\u04b1\u04b0\3\2\2\2\u04b2"+
		"\u00cf\3\2\2\2\u04b3\u04b6\5\f\7\2\u04b4\u04b7\5\u00fa~\2\u04b5\u04b7"+
		"\7?\2\2\u04b6\u04b4\3\2\2\2\u04b6\u04b5\3\2\2\2\u04b7\u04b8\3\2\2\2\u04b8"+
		"\u04b9\5F$\2\u04b9\u04ba\7Q\2\2\u04ba\u04bb\5\u00d8m\2\u04bb\u00d1\3\2"+
		"\2\2\u04bc\u04bd\7r\2\2\u04bd\u04be\5\u00d8m\2\u04be\u04bf\7s\2\2\u04bf"+
		"\u00d3\3\2\2\2\u04c0\u04c5\5\u00d8m\2\u04c1\u04c2\7y\2\2\u04c2\u04c4\5"+
		"\u00d8m\2\u04c3\u04c1\3\2\2\2\u04c4\u04c7\3\2\2\2\u04c5\u04c3\3\2\2\2"+
		"\u04c5\u04c6\3\2\2\2\u04c6\u00d5\3\2\2\2\u04c7\u04c5\3\2\2\2\u04c8\u04cc"+
		"\5\u0096L\2\u04c9\u04cc\7\60\2\2\u04ca\u04cc\7.\2\2\u04cb\u04c8\3\2\2"+
		"\2\u04cb\u04c9\3\2\2\2\u04cb\u04ca\3\2\2\2\u04cc\u04cd\3\2\2\2\u04cd\u04ce"+
		"\5\u0104\u0083\2\u04ce\u00d7\3\2\2\2\u04cf\u04d0\bm\1\2\u04d0\u04d1\7"+
		"r\2\2\u04d1\u04d2\5\u00d8m\2\u04d2\u04d3\7s\2\2\u04d3\u050a\3\2\2\2\u04d4"+
		"\u050a\7\60\2\2\u04d5\u050a\7.\2\2\u04d6\u050a\5b\62\2\u04d7\u050a\5\u0096"+
		"L\2\u04d8\u04d9\5\u00fa~\2\u04d9\u04da\7z\2\2\u04da\u04db\7\34\2\2\u04db"+
		"\u050a\3\2\2\2\u04dc\u04e0\5\u00f6|\2\u04dd\u04e1\5\u0102\u0082\2\u04de"+
		"\u04df\7\60\2\2\u04df\u04e1\5\u0104\u0083\2\u04e0\u04dd\3\2\2\2\u04e0"+
		"\u04de\3\2\2\2\u04e1\u050a\3\2\2\2\u04e2\u050a\5\u00d6l\2\u04e3\u04e4"+
		"\5\u00fa~\2\u04e4\u04ea\7\u0081\2\2\u04e5\u04e7\5\u00fe\u0080\2\u04e6"+
		"\u04e5\3\2\2\2\u04e6\u04e7\3\2\2\2\u04e7\u04e8\3\2\2\2\u04e8\u04eb\5\u0096"+
		"L\2\u04e9\u04eb\7\'\2\2\u04ea\u04e6\3\2\2\2\u04ea\u04e9\3\2\2\2\u04eb"+
		"\u050a\3\2\2\2\u04ec\u04ed\5\u00e6t\2\u04ed\u04ef\7\u0081\2\2\u04ee\u04f0"+
		"\5\u00fe\u0080\2\u04ef\u04ee\3\2\2\2\u04ef\u04f0\3\2\2\2\u04f0\u04f1\3"+
		"\2\2\2\u04f1\u04f2\7\'\2\2\u04f2\u050a\3\2\2\2\u04f3\u04f4\7\22\2\2\u04f4"+
		"\u04f5\5\u00d2j\2\u04f5\u04f6\5\u008eH\2\u04f6\u050a\3\2\2\2\u04f7\u04f8"+
		"\t\b\2\2\u04f8\u050a\5\u00d8m\23\u04f9\u04fa\7r\2\2\u04fa\u04fb\5j\66"+
		"\2\u04fb\u0500\5\u00fa~\2\u04fc\u04fd\7_\2\2\u04fd\u04ff\5\u00fa~\2\u04fe"+
		"\u04fc\3\2\2\2\u04ff\u0502\3\2\2\2\u0500\u04fe\3\2\2\2\u0500\u0501\3\2"+
		"\2\2\u0501\u0503\3\2\2\2\u0502\u0500\3\2\2\2\u0503\u0504\7s\2\2\u0504"+
		"\u0505\5\u00d8m\22\u0505\u050a\3\2\2\2\u0506\u0507\7\'\2\2\u0507\u050a"+
		"\5\u00e8u\2\u0508\u050a\5\u00dco\2\u0509\u04cf\3\2\2\2\u0509\u04d4\3\2"+
		"\2\2\u0509\u04d5\3\2\2\2\u0509\u04d6\3\2\2\2\u0509\u04d7\3\2\2\2\u0509"+
		"\u04d8\3\2\2\2\u0509\u04dc\3\2\2\2\u0509\u04e2\3\2\2\2\u0509\u04e3\3\2"+
		"\2\2\u0509\u04ec\3\2\2\2\u0509\u04f3\3\2\2\2\u0509\u04f7\3\2\2\2\u0509"+
		"\u04f9\3\2\2\2\u0509\u0506\3\2\2\2\u0509\u0508\3\2\2\2\u050a\u055e\3\2"+
		"\2\2\u050b\u050c\f\20\2\2\u050c\u050d\t\t\2\2\u050d\u055d\5\u00d8m\21"+
		"\u050e\u050f\f\17\2\2\u050f\u0510\t\n\2\2\u0510\u055d\5\u00d8m\20\u0511"+
		"\u0519\f\16\2\2\u0512\u0513\7S\2\2\u0513\u051a\7S\2\2\u0514\u0515\7R\2"+
		"\2\u0515\u051a\7R\2\2\u0516\u0517\7R\2\2\u0517\u0518\7R\2\2\u0518\u051a"+
		"\7R\2\2\u0519\u0512\3\2\2\2\u0519\u0514\3\2\2\2\u0519\u0516\3\2\2\2\u051a"+
		"\u051b\3\2\2\2\u051b\u055d\5\u00d8m\17\u051c\u051d\f\r\2\2\u051d\u051e"+
		"\t\13\2\2\u051e\u055d\5\u00d8m\16\u051f\u0520\f\13\2\2\u0520\u0521\t\f"+
		"\2\2\u0521\u055d\5\u00d8m\f\u0522\u0523\f\n\2\2\u0523\u0524\7_\2\2\u0524"+
		"\u055d\5\u00d8m\13\u0525\u0526\f\t\2\2\u0526\u0527\7a\2\2\u0527\u055d"+
		"\5\u00d8m\n\u0528\u0529\f\b\2\2\u0529\u052a\7`\2\2\u052a\u055d\5\u00d8"+
		"m\t\u052b\u052c\f\7\2\2\u052c\u052d\7X\2\2\u052d\u055d\5\u00d8m\b\u052e"+
		"\u052f\f\6\2\2\u052f\u0530\7Y\2\2\u0530\u055d\5\u00d8m\7\u0531\u0532\f"+
		"\5\2\2\u0532\u0533\7P\2\2\u0533\u0534\5\u00d8m\2\u0534\u0535\7Q\2\2\u0535"+
		"\u0536\5\u00d8m\5\u0536\u055d\3\2\2\2\u0537\u0538\f\4\2\2\u0538\u0539"+
		"\t\r\2\2\u0539\u055d\5\u00d8m\4\u053a\u053b\f\33\2\2\u053b\u053c\7v\2"+
		"\2\u053c\u053d\5\u00d8m\2\u053d\u053e\7w\2\2\u053e\u055d\3\2\2\2\u053f"+
		"\u0540\f\32\2\2\u0540\u054c\7z\2\2\u0541\u054d\5\u0096L\2\u0542\u054d"+
		"\5\u00d6l\2\u0543\u054d\7\60\2\2\u0544\u0546\7\'\2\2\u0545\u0547\5\u00f6"+
		"|\2\u0546\u0545\3\2\2\2\u0546\u0547\3\2\2\2\u0547\u0548\3\2\2\2\u0548"+
		"\u054d\5\u00ecw\2\u0549\u054a\7.\2\2\u054a\u054d\5\u0100\u0081\2\u054b"+
		"\u054d\5\u00f2z\2\u054c\u0541\3\2\2\2\u054c\u0542\3\2\2\2\u054c\u0543"+
		"\3\2\2\2\u054c\u0544\3\2\2\2\u054c\u0549\3\2\2\2\u054c\u054b\3\2\2\2\u054d"+
		"\u055d\3\2\2\2\u054e\u054f\f\30\2\2\u054f\u0551\7\u0081\2\2\u0550\u0552"+
		"\5\u00fe\u0080\2\u0551\u0550\3\2\2\2\u0551\u0552\3\2\2\2\u0552\u0553\3"+
		"\2\2\2\u0553\u055d\5\u0096L\2\u0554\u0555\f\24\2\2\u0555\u055d\t\16\2"+
		"\2\u0556\u0557\f\f\2\2\u0557\u055a\7$\2\2\u0558\u055b\5\u00fa~\2\u0559"+
		"\u055b\5\u00dan\2\u055a\u0558\3\2\2\2\u055a\u0559\3\2\2\2\u055b\u055d"+
		"\3\2\2\2\u055c\u050b\3\2\2\2\u055c\u050e\3\2\2\2\u055c\u0511\3\2\2\2\u055c"+
		"\u051c\3\2\2\2\u055c\u051f\3\2\2\2\u055c\u0522\3\2\2\2\u055c\u0525\3\2"+
		"\2\2\u055c\u0528\3\2\2\2\u055c\u052b\3\2\2\2\u055c\u052e\3\2\2\2\u055c"+
		"\u0531\3\2\2\2\u055c\u0537\3\2\2\2\u055c\u053a\3\2\2\2\u055c\u053f\3\2"+
		"\2\2\u055c\u054e\3\2\2\2\u055c\u0554\3\2\2\2\u055c\u0556\3\2\2\2\u055d"+
		"\u0560\3\2\2\2\u055e\u055c\3\2\2\2\u055e\u055f\3\2\2\2\u055f\u00d9\3\2"+
		"\2\2\u0560\u055e\3\2\2\2\u0561\u0562\5\f\7\2\u0562\u0563\5\u00fa~\2\u0563"+
		"\u0564\5j\66\2\u0564\u0565\5\u0096L\2\u0565\u00db\3\2\2\2\u0566\u0567"+
		"\5\u00dep\2\u0567\u0568\7\u0080\2\2\u0568\u0569\5\u00e0q\2\u0569\u00dd"+
		"\3\2\2\2\u056a\u0581\5\u0096L\2\u056b\u056d\7r\2\2\u056c\u056e\5V,\2\u056d"+
		"\u056c\3\2\2\2\u056d\u056e\3\2\2\2\u056e\u056f\3\2\2\2\u056f\u0581\7s"+
		"\2\2\u0570\u0571\7r\2\2\u0571\u0576\5\u0096L\2\u0572\u0573\7y\2\2\u0573"+
		"\u0575\5\u0096L\2\u0574\u0572\3\2\2\2\u0575\u0578\3\2\2\2\u0576\u0574"+
		"\3\2\2\2\u0576\u0577\3\2\2\2\u0577\u0579\3\2\2\2\u0578\u0576\3\2\2\2\u0579"+
		"\u057a\7s\2\2\u057a\u0581\3\2\2\2\u057b\u057d\7r\2\2\u057c\u057e\5\\/"+
		"\2\u057d\u057c\3\2\2\2\u057d\u057e\3\2\2\2\u057e\u057f\3\2\2\2\u057f\u0581"+
		"\7s\2\2\u0580\u056a\3\2\2\2\u0580\u056b\3\2\2\2\u0580\u0570\3\2\2\2\u0580"+
		"\u057b\3\2\2\2\u0581\u00df\3\2\2\2\u0582\u0585\5\u00d8m\2\u0583\u0585"+
		"\5\u008eH\2\u0584\u0582\3\2\2\2\u0584\u0583\3\2\2\2\u0585\u00e1\3\2\2"+
		"\2\u0586\u058a\7\27\2\2\u0587\u058b\5\u00d4k\2\u0588\u058b\7O\2\2\u0589"+
		"\u058b\5\u00e4s\2\u058a\u0587\3\2\2\2\u058a\u0588\3\2\2\2\u058a\u0589"+
		"\3\2\2\2\u058b\u058c\3\2\2\2\u058c\u0591\t\17\2\2\u058d\u0590\5\16\b\2"+
		"\u058e\u0590\5\u009aN\2\u058f\u058d\3\2\2\2\u058f\u058e\3\2\2\2\u0590"+
		"\u0593\3\2\2\2\u0591\u058f\3\2\2\2\u0591\u0592\3\2\2\2\u0592\u059e\3\2"+
		"\2\2\u0593\u0591\3\2\2\2\u0594\u0595\7\36\2\2\u0595\u059a\t\17\2\2\u0596"+
		"\u0599\5\16\b\2\u0597\u0599\5\u009aN\2\u0598\u0596\3\2\2\2\u0598\u0597"+
		"\3\2\2\2\u0599\u059c\3\2\2\2\u059a\u0598\3\2\2\2\u059a\u059b\3\2\2\2\u059b"+
		"\u059e\3\2\2\2\u059c\u059a\3\2\2\2\u059d\u0586\3\2\2\2\u059d\u0594\3\2"+
		"\2\2\u059e\u00e3\3\2\2\2\u059f\u05a0\bs\1\2\u05a0\u05a1\7r\2\2\u05a1\u05a2"+
		"\5\u00e4s\2\u05a2\u05a3\7s\2\2\u05a3\u05b0\3\2\2\2\u05a4\u05a5\5\f\7\2"+
		"\u05a5\u05a6\5\u00fa~\2\u05a6\u05a7\5j\66\2\u05a7\u05ac\5\u0096L\2\u05a8"+
		"\u05a9\7X\2\2\u05a9\u05ab\5\u00d8m\2\u05aa\u05a8\3\2\2\2\u05ab\u05ae\3"+
		"\2\2\2\u05ac\u05aa\3\2\2\2\u05ac\u05ad\3\2\2\2\u05ad\u05b0\3\2\2\2\u05ae"+
		"\u05ac\3\2\2\2\u05af\u059f\3\2\2\2\u05af\u05a4\3\2\2\2\u05b0\u05b6\3\2"+
		"\2\2\u05b1\u05b2\f\3\2\2\u05b2\u05b3\7X\2\2\u05b3\u05b5\5\u00d8m\2\u05b4"+
		"\u05b1\3\2\2\2\u05b5\u05b8\3\2\2\2\u05b6\u05b4\3\2\2\2\u05b6\u05b7\3\2"+
		"\2\2\u05b7\u00e5\3\2\2\2\u05b8\u05b6\3\2\2\2\u05b9\u05ba\5L\'\2\u05ba"+
		"\u05bb\7z\2\2\u05bb\u05bd\3\2\2\2\u05bc\u05b9\3\2\2\2\u05bc\u05bd\3\2"+
		"\2\2\u05bd\u05be\3\2\2\2\u05be\u05bf\5j\66\2\u05bf\u05c1\5\u0096L\2\u05c0"+
		"\u05c2\5\u00fe\u0080\2\u05c1\u05c0\3\2\2\2\u05c1\u05c2\3\2\2\2\u05c2\u00e7"+
		"\3\2\2\2\u05c3\u05c5\5\u00f6|\2\u05c4\u05c3\3\2\2\2\u05c4\u05c5\3\2\2"+
		"\2\u05c5\u05c6\3\2\2\2\u05c6\u05c7\5\u00eav\2\u05c7\u05c8\5\u00f0y\2\u05c8"+
		"\u05cd\3\2\2\2\u05c9\u05ca\5\u00eav\2\u05ca\u05cb\5\u00eex\2\u05cb\u05cd"+
		"\3\2\2\2\u05cc\u05c4\3\2\2\2\u05cc\u05c9\3\2\2\2\u05cd\u00e9\3\2\2\2\u05ce"+
		"\u05d0\5\u0096L\2\u05cf\u05d1\5\u00f4{\2\u05d0\u05cf\3\2\2\2\u05d0\u05d1"+
		"\3\2\2\2\u05d1\u05d9\3\2\2\2\u05d2\u05d3\7z\2\2\u05d3\u05d5\5\u0096L\2"+
		"\u05d4\u05d6\5\u00f4{\2\u05d5\u05d4\3\2\2\2\u05d5\u05d6\3\2\2\2\u05d6"+
		"\u05d8\3\2\2\2\u05d7\u05d2\3\2\2\2\u05d8\u05db\3\2\2\2\u05d9\u05d7\3\2"+
		"\2\2\u05d9\u05da\3\2\2\2\u05da\u05de\3\2\2\2\u05db\u05d9\3\2\2\2\u05dc"+
		"\u05de\5\u00fc\177\2\u05dd\u05ce\3\2\2\2\u05dd\u05dc\3\2\2\2\u05de\u00eb"+
		"\3\2\2\2\u05df\u05e3\5\u0096L\2\u05e0\u05e1\7S\2\2\u05e1\u05e4\7R\2\2"+
		"\u05e2\u05e4\5\u00f6|\2\u05e3\u05e0\3\2\2\2\u05e3\u05e2\3\2\2\2\u05e3"+
		"\u05e4\3\2\2\2\u05e4\u05e5\3\2\2\2\u05e5\u05e6\5\u00f0y\2\u05e6\u00ed"+
		"\3\2\2\2\u05e7\u05e8\7v\2\2\u05e8\u05ea\7w\2\2\u05e9\u05e7\3\2\2\2\u05ea"+
		"\u05eb\3\2\2\2\u05eb\u05e9\3\2\2\2\u05eb\u05ec\3\2\2\2\u05ec\u05ed\3\2"+
		"\2\2\u05ed\u05fe\5J&\2\u05ee\u05ef\7v\2\2\u05ef\u05f0\5\u00d8m\2\u05f0"+
		"\u05f1\7w\2\2\u05f1\u05f3\3\2\2\2\u05f2\u05ee\3\2\2\2\u05f3\u05f4\3\2"+
		"\2\2\u05f4\u05f2\3\2\2\2\u05f4\u05f5\3\2\2\2\u05f5\u05fa\3\2\2\2\u05f6"+
		"\u05f7\7v\2\2\u05f7\u05f9\7w\2\2\u05f8\u05f6\3\2\2\2\u05f9\u05fc\3\2\2"+
		"\2\u05fa\u05f8\3\2\2\2\u05fa\u05fb\3\2\2\2\u05fb\u05fe\3\2\2\2\u05fc\u05fa"+
		"\3\2\2\2\u05fd\u05e9\3\2\2\2\u05fd\u05f2\3\2\2\2\u05fe\u00ef\3\2\2\2\u05ff"+
		"\u0601\5\u0104\u0083\2\u0600\u0602\5\32\16\2\u0601\u0600\3\2\2\2\u0601"+
		"\u0602\3\2\2\2\u0602\u00f1\3\2\2\2\u0603\u0604\5\u00f6|\2\u0604\u0605"+
		"\5\u0102\u0082\2\u0605\u00f3\3\2\2\2\u0606\u0607\7S\2\2\u0607\u060a\7"+
		"R\2\2\u0608\u060a\5\u00fe\u0080\2\u0609\u0606\3\2\2\2\u0609\u0608\3\2"+
		"\2\2\u060a\u00f5\3\2\2\2\u060b\u060c\7S\2\2\u060c\u060d\5\u00f8}\2\u060d"+
		"\u060e\7R\2\2\u060e\u00f7\3\2\2\2\u060f\u0614\5\u00fa~\2\u0610\u0611\7"+
		"y\2\2\u0611\u0613\5\u00fa~\2\u0612\u0610\3\2\2\2\u0613\u0616\3\2\2\2\u0614"+
		"\u0612\3\2\2\2\u0614\u0615\3\2\2\2\u0615\u00f9\3\2\2\2\u0616\u0614\3\2"+
		"\2\2\u0617\u061a\5j\66\2\u0618\u061b\5L\'\2\u0619\u061b\5\u00fc\177\2"+
		"\u061a\u0618\3\2\2\2\u061a\u0619\3\2\2\2\u061b\u0622\3\2\2\2\u061c\u061d"+
		"\5j\66\2\u061d\u061e\7v\2\2\u061e\u061f\7w\2\2\u061f\u0621\3\2\2\2\u0620"+
		"\u061c\3\2\2\2\u0621\u0624\3\2\2\2\u0622\u0620\3\2\2\2\u0622\u0623\3\2"+
		"\2\2\u0623\u00fb\3\2\2\2\u0624\u0622\3\2\2\2\u0625\u0626\t\20\2\2\u0626"+
		"\u00fd\3\2\2\2\u0627\u0628\7S\2\2\u0628\u062d\5N(\2\u0629\u062a\7y\2\2"+
		"\u062a\u062c\5N(\2\u062b\u0629\3\2\2\2\u062c\u062f\3\2\2\2\u062d\u062b"+
		"\3\2\2\2\u062d\u062e\3\2\2\2\u062e\u0630\3\2\2\2\u062f\u062d\3\2\2\2\u0630"+
		"\u0631\7R\2\2\u0631\u00ff\3\2\2\2\u0632\u063c\5\u0104\u0083\2\u0633\u0635"+
		"\7z\2\2\u0634\u0636\5\u00fe\u0080\2\u0635\u0634\3\2\2\2\u0635\u0636\3"+
		"\2\2\2\u0636\u0637\3\2\2\2\u0637\u0639\5\u0096L\2\u0638\u063a\5\u0104"+
		"\u0083\2\u0639\u0638\3\2\2\2\u0639\u063a\3\2\2\2\u063a\u063c\3\2\2\2\u063b"+
		"\u0632\3\2\2\2\u063b\u0633\3\2\2\2\u063c\u0101\3\2\2\2\u063d\u063e\7."+
		"\2\2\u063e\u0643\5\u0100\u0081\2\u063f\u0640\5\u0096L\2\u0640\u0641\5"+
		"\u0104\u0083\2\u0641\u0643\3\2\2\2\u0642\u063d\3\2\2\2\u0642\u063f\3\2"+
		"\2\2\u0643\u0103\3\2\2\2\u0644\u0646\7r\2\2\u0645\u0647\5\u00d4k\2\u0646"+
		"\u0645\3\2\2\2\u0646\u0647\3\2\2\2\u0647\u0648\3\2\2\2\u0648\u0649\7s"+
		"\2\2\u0649\u0105\3\2\2\2\u00c2\u0107\u010a\u010f\u0112\u0115\u011a\u011d"+
		"\u0122\u0127\u012d\u0132\u013b\u0140\u0154\u0156\u015f\u0166\u016a\u016e"+
		"\u0172\u0177\u017b\u017f\u0184\u0189\u018f\u0199\u019f\u01a2\u01a8\u01ab"+
		"\u01b2\u01ba\u01be\u01c6\u01d1\u01d8\u01e0\u01e6\u01e9\u01f1\u01fa\u01ff"+
		"\u0205\u020a\u0210\u0215\u021b\u0220\u0226\u0229\u0232\u0237\u023e\u0244"+
		"\u0247\u0252\u0257\u0260\u026a\u0275\u027b\u0282\u0287\u028f\u0293\u0295"+
		"\u029b\u02a1\u02a6\u02ad\u02af\u02b6\u02bb\u02c0\u02c3\u02c5\u02cf\u02d9"+
		"\u02de\u02e1\u02f2\u02fe\u0308\u0313\u031c\u0322\u0327\u032a\u0331\u033b"+
		"\u0343\u0346\u0349\u0351\u0359\u035b\u035f\u0365\u036d\u0377\u0381\u0389"+
		"\u0397\u039d\u03a6\u03af\u03b1\u03b9\u03bf\u03c7\u03cb\u03d0\u03d4\u03d6"+
		"\u03e4\u03fe\u0404\u0427\u042a\u042d\u0435\u0439\u0445\u044f\u0455\u0471"+
		"\u047a\u0483\u048c\u0492\u049a\u049f\u04a3\u04a7\u04ab\u04ad\u04b1\u04b6"+
		"\u04c5\u04cb\u04e0\u04e6\u04ea\u04ef\u0500\u0509\u0519\u0546\u054c\u0551"+
		"\u055a\u055c\u055e\u056d\u0576\u057d\u0580\u0584\u058a\u058f\u0591\u0598"+
		"\u059a\u059d\u05ac\u05af\u05b6\u05bc\u05c1\u05c4\u05cc\u05d0\u05d5\u05d9"+
		"\u05dd\u05e3\u05eb\u05f4\u05fa\u05fd\u0601\u0609\u0614\u061a\u0622\u062d"+
		"\u0635\u0639\u063b\u0642\u0646";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}