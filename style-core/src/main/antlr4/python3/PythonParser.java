// Generated from .\python3\PythonParser.g4 by ANTLR 4.9.3
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class PythonParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		ENCODING=1, INDENT=2, DEDENT=3, TYPE_COMMENT=4, FSTRING_START=5, FSTRING_MIDDLE=6, 
		FSTRING_END=7, LPAR=8, LSQB=9, LBRACE=10, RPAR=11, RSQB=12, RBRACE=13, 
		DOT=14, COLON=15, COMMA=16, SEMI=17, PLUS=18, MINUS=19, STAR=20, SLASH=21, 
		VBAR=22, AMPER=23, LESS=24, GREATER=25, EQUAL=26, PERCENT=27, EQEQUAL=28, 
		NOTEQUAL=29, LESSEQUAL=30, GREATEREQUAL=31, TILDE=32, CIRCUMFLEX=33, LEFTSHIFT=34, 
		RIGHTSHIFT=35, DOUBLESTAR=36, PLUSEQUAL=37, MINEQUAL=38, STAREQUAL=39, 
		SLASHEQUAL=40, PERCENTEQUAL=41, AMPEREQUAL=42, VBAREQUAL=43, CIRCUMFLEXEQUAL=44, 
		LEFTSHIFTEQUAL=45, RIGHTSHIFTEQUAL=46, DOUBLESTAREQUAL=47, DOUBLESLASH=48, 
		DOUBLESLASHEQUAL=49, AT=50, ATEQUAL=51, RARROW=52, ELLIPSIS=53, COLONEQUAL=54, 
		EXCLAMATION=55, FALSE=56, AWAIT=57, ELSE=58, IMPORT=59, PASS=60, NONE=61, 
		BREAK=62, EXCEPT=63, IN=64, RAISE=65, TRUE=66, CLASS=67, FINALLY=68, IS=69, 
		RETURN=70, AND=71, CONTINUE=72, FOR=73, LAMBDA=74, TRY=75, AS=76, DEF=77, 
		FROM=78, NONLOCAL=79, WHILE=80, ASSERT=81, DEL=82, GLOBAL=83, NOT=84, 
		WITH=85, ASYNC=86, ELIF=87, IF=88, OR=89, YIELD=90, NAME_OR_TYPE=91, NAME_OR_MATCH=92, 
		NAME_OR_CASE=93, NAME_OR_WILDCARD=94, NAME=95, NUMBER=96, STRING=97, NEWLINE=98, 
		COMMENT=99, WS=100, EXPLICIT_LINE_JOINING=101, ERRORTOKEN=102;
	public static final int
		RULE_file_input = 0, RULE_interactive = 1, RULE_eval = 2, RULE_func_type = 3, 
		RULE_statements = 4, RULE_statement = 5, RULE_statement_newline = 6, RULE_simple_stmts = 7, 
		RULE_simple_stmt = 8, RULE_compound_stmt = 9, RULE_assignment = 10, RULE_annotated_rhs = 11, 
		RULE_augassign = 12, RULE_return_stmt = 13, RULE_raise_stmt = 14, RULE_global_stmt = 15, 
		RULE_nonlocal_stmt = 16, RULE_del_stmt = 17, RULE_yield_stmt = 18, RULE_assert_stmt = 19, 
		RULE_import_stmt = 20, RULE_import_name = 21, RULE_import_from = 22, RULE_import_from_targets = 23, 
		RULE_import_from_as_names = 24, RULE_import_from_as_name = 25, RULE_dotted_as_names = 26, 
		RULE_dotted_as_name = 27, RULE_dotted_name = 28, RULE_block = 29, RULE_decorators = 30, 
		RULE_class_def = 31, RULE_class_def_raw = 32, RULE_function_def = 33, 
		RULE_function_def_raw = 34, RULE_params = 35, RULE_parameters = 36, RULE_slash_no_default = 37, 
		RULE_slash_with_default = 38, RULE_star_etc = 39, RULE_kwds = 40, RULE_param_no_default = 41, 
		RULE_param_no_default_star_annotation = 42, RULE_param_with_default = 43, 
		RULE_param_maybe_default = 44, RULE_param = 45, RULE_param_star_annotation = 46, 
		RULE_annotation = 47, RULE_star_annotation = 48, RULE_default_assignment = 49, 
		RULE_if_stmt = 50, RULE_elif_stmt = 51, RULE_else_block = 52, RULE_while_stmt = 53, 
		RULE_for_stmt = 54, RULE_with_stmt = 55, RULE_with_item = 56, RULE_try_stmt = 57, 
		RULE_except_block = 58, RULE_except_star_block = 59, RULE_finally_block = 60, 
		RULE_match_stmt = 61, RULE_subject_expr = 62, RULE_case_block = 63, RULE_guard = 64, 
		RULE_patterns = 65, RULE_pattern = 66, RULE_as_pattern = 67, RULE_or_pattern = 68, 
		RULE_closed_pattern = 69, RULE_literal_pattern = 70, RULE_literal_expr = 71, 
		RULE_complex_number = 72, RULE_signed_number = 73, RULE_signed_real_number = 74, 
		RULE_real_number = 75, RULE_imaginary_number = 76, RULE_capture_pattern = 77, 
		RULE_pattern_capture_target = 78, RULE_wildcard_pattern = 79, RULE_value_pattern = 80, 
		RULE_attr = 81, RULE_name_or_attr = 82, RULE_group_pattern = 83, RULE_sequence_pattern = 84, 
		RULE_open_sequence_pattern = 85, RULE_maybe_sequence_pattern = 86, RULE_maybe_star_pattern = 87, 
		RULE_star_pattern = 88, RULE_mapping_pattern = 89, RULE_items_pattern = 90, 
		RULE_key_value_pattern = 91, RULE_double_star_pattern = 92, RULE_class_pattern = 93, 
		RULE_positional_patterns = 94, RULE_keyword_patterns = 95, RULE_keyword_pattern = 96, 
		RULE_type_alias = 97, RULE_type_params = 98, RULE_type_param_seq = 99, 
		RULE_type_param = 100, RULE_type_param_bound = 101, RULE_type_param_default = 102, 
		RULE_type_param_starred_default = 103, RULE_expressions = 104, RULE_expression = 105, 
		RULE_yield_expr = 106, RULE_star_expressions = 107, RULE_star_expression = 108, 
		RULE_star_named_expressions = 109, RULE_star_named_expression = 110, RULE_assignment_expression = 111, 
		RULE_named_expression = 112, RULE_disjunction = 113, RULE_conjunction = 114, 
		RULE_inversion = 115, RULE_comparison = 116, RULE_compare_op_bitwise_or_pair = 117, 
		RULE_eq_bitwise_or = 118, RULE_noteq_bitwise_or = 119, RULE_lte_bitwise_or = 120, 
		RULE_lt_bitwise_or = 121, RULE_gte_bitwise_or = 122, RULE_gt_bitwise_or = 123, 
		RULE_notin_bitwise_or = 124, RULE_in_bitwise_or = 125, RULE_isnot_bitwise_or = 126, 
		RULE_is_bitwise_or = 127, RULE_bitwise_or = 128, RULE_bitwise_xor = 129, 
		RULE_bitwise_and = 130, RULE_shift_expr = 131, RULE_sum = 132, RULE_term = 133, 
		RULE_factor = 134, RULE_power = 135, RULE_await_primary = 136, RULE_primary = 137, 
		RULE_slices = 138, RULE_slice = 139, RULE_atom = 140, RULE_group = 141, 
		RULE_lambdef = 142, RULE_lambda_params = 143, RULE_lambda_parameters = 144, 
		RULE_lambda_slash_no_default = 145, RULE_lambda_slash_with_default = 146, 
		RULE_lambda_star_etc = 147, RULE_lambda_kwds = 148, RULE_lambda_param_no_default = 149, 
		RULE_lambda_param_with_default = 150, RULE_lambda_param_maybe_default = 151, 
		RULE_lambda_param = 152, RULE_fstring_middle = 153, RULE_fstring_replacement_field = 154, 
		RULE_fstring_conversion = 155, RULE_fstring_full_format_spec = 156, RULE_fstring_format_spec = 157, 
		RULE_fstring = 158, RULE_string = 159, RULE_strings = 160, RULE_list = 161, 
		RULE_tuple = 162, RULE_set = 163, RULE_dict = 164, RULE_double_starred_kvpairs = 165, 
		RULE_double_starred_kvpair = 166, RULE_kvpair = 167, RULE_for_if_clauses = 168, 
		RULE_for_if_clause = 169, RULE_listcomp = 170, RULE_setcomp = 171, RULE_genexp = 172, 
		RULE_dictcomp = 173, RULE_arguments = 174, RULE_args = 175, RULE_kwargs = 176, 
		RULE_starred_expression = 177, RULE_kwarg_or_starred = 178, RULE_kwarg_or_double_starred = 179, 
		RULE_star_targets = 180, RULE_star_targets_list_seq = 181, RULE_star_targets_tuple_seq = 182, 
		RULE_star_target = 183, RULE_target_with_star_atom = 184, RULE_star_atom = 185, 
		RULE_single_target = 186, RULE_single_subscript_attribute_target = 187, 
		RULE_t_primary = 188, RULE_del_targets = 189, RULE_del_target = 190, RULE_del_t_atom = 191, 
		RULE_type_expressions = 192, RULE_func_type_comment = 193, RULE_name_except_underscore = 194, 
		RULE_name = 195;
	private static String[] makeRuleNames() {
		return new String[] {
			"file_input", "interactive", "eval", "func_type", "statements", "statement", 
			"statement_newline", "simple_stmts", "simple_stmt", "compound_stmt", 
			"assignment", "annotated_rhs", "augassign", "return_stmt", "raise_stmt", 
			"global_stmt", "nonlocal_stmt", "del_stmt", "yield_stmt", "assert_stmt", 
			"import_stmt", "import_name", "import_from", "import_from_targets", "import_from_as_names", 
			"import_from_as_name", "dotted_as_names", "dotted_as_name", "dotted_name", 
			"block", "decorators", "class_def", "class_def_raw", "function_def", 
			"function_def_raw", "params", "parameters", "slash_no_default", "slash_with_default", 
			"star_etc", "kwds", "param_no_default", "param_no_default_star_annotation", 
			"param_with_default", "param_maybe_default", "param", "param_star_annotation", 
			"annotation", "star_annotation", "default_assignment", "if_stmt", "elif_stmt", 
			"else_block", "while_stmt", "for_stmt", "with_stmt", "with_item", "try_stmt", 
			"except_block", "except_star_block", "finally_block", "match_stmt", "subject_expr", 
			"case_block", "guard", "patterns", "pattern", "as_pattern", "or_pattern", 
			"closed_pattern", "literal_pattern", "literal_expr", "complex_number", 
			"signed_number", "signed_real_number", "real_number", "imaginary_number", 
			"capture_pattern", "pattern_capture_target", "wildcard_pattern", "value_pattern", 
			"attr", "name_or_attr", "group_pattern", "sequence_pattern", "open_sequence_pattern", 
			"maybe_sequence_pattern", "maybe_star_pattern", "star_pattern", "mapping_pattern", 
			"items_pattern", "key_value_pattern", "double_star_pattern", "class_pattern", 
			"positional_patterns", "keyword_patterns", "keyword_pattern", "type_alias", 
			"type_params", "type_param_seq", "type_param", "type_param_bound", "type_param_default", 
			"type_param_starred_default", "expressions", "expression", "yield_expr", 
			"star_expressions", "star_expression", "star_named_expressions", "star_named_expression", 
			"assignment_expression", "named_expression", "disjunction", "conjunction", 
			"inversion", "comparison", "compare_op_bitwise_or_pair", "eq_bitwise_or", 
			"noteq_bitwise_or", "lte_bitwise_or", "lt_bitwise_or", "gte_bitwise_or", 
			"gt_bitwise_or", "notin_bitwise_or", "in_bitwise_or", "isnot_bitwise_or", 
			"is_bitwise_or", "bitwise_or", "bitwise_xor", "bitwise_and", "shift_expr", 
			"sum", "term", "factor", "power", "await_primary", "primary", "slices", 
			"slice", "atom", "group", "lambdef", "lambda_params", "lambda_parameters", 
			"lambda_slash_no_default", "lambda_slash_with_default", "lambda_star_etc", 
			"lambda_kwds", "lambda_param_no_default", "lambda_param_with_default", 
			"lambda_param_maybe_default", "lambda_param", "fstring_middle", "fstring_replacement_field", 
			"fstring_conversion", "fstring_full_format_spec", "fstring_format_spec", 
			"fstring", "string", "strings", "list", "tuple", "set", "dict", "double_starred_kvpairs", 
			"double_starred_kvpair", "kvpair", "for_if_clauses", "for_if_clause", 
			"listcomp", "setcomp", "genexp", "dictcomp", "arguments", "args", "kwargs", 
			"starred_expression", "kwarg_or_starred", "kwarg_or_double_starred", 
			"star_targets", "star_targets_list_seq", "star_targets_tuple_seq", "star_target", 
			"target_with_star_atom", "star_atom", "single_target", "single_subscript_attribute_target", 
			"t_primary", "del_targets", "del_target", "del_t_atom", "type_expressions", 
			"func_type_comment", "name_except_underscore", "name"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, "'('", "'['", null, "')'", 
			"']'", null, "'.'", "':'", "','", "';'", "'+'", "'-'", "'*'", "'/'", 
			"'|'", "'&'", "'<'", "'>'", "'='", "'%'", "'=='", "'!='", "'<='", "'>='", 
			"'~'", "'^'", "'<<'", "'>>'", "'**'", "'+='", "'-='", "'*='", "'/='", 
			"'%='", "'&='", "'|='", "'^='", "'<<='", "'>>='", "'**='", "'//'", "'//='", 
			"'@'", "'@='", "'->'", "'...'", "':='", "'!'", "'False'", "'await'", 
			"'else'", "'import'", "'pass'", "'None'", "'break'", "'except'", "'in'", 
			"'raise'", "'True'", "'class'", "'finally'", "'is'", "'return'", "'and'", 
			"'continue'", "'for'", "'lambda'", "'try'", "'as'", "'def'", "'from'", 
			"'nonlocal'", "'while'", "'assert'", "'del'", "'global'", "'not'", "'with'", 
			"'async'", "'elif'", "'if'", "'or'", "'yield'", "'type'", "'match'", 
			"'case'", "'_'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "ENCODING", "INDENT", "DEDENT", "TYPE_COMMENT", "FSTRING_START", 
			"FSTRING_MIDDLE", "FSTRING_END", "LPAR", "LSQB", "LBRACE", "RPAR", "RSQB", 
			"RBRACE", "DOT", "COLON", "COMMA", "SEMI", "PLUS", "MINUS", "STAR", "SLASH", 
			"VBAR", "AMPER", "LESS", "GREATER", "EQUAL", "PERCENT", "EQEQUAL", "NOTEQUAL", 
			"LESSEQUAL", "GREATEREQUAL", "TILDE", "CIRCUMFLEX", "LEFTSHIFT", "RIGHTSHIFT", 
			"DOUBLESTAR", "PLUSEQUAL", "MINEQUAL", "STAREQUAL", "SLASHEQUAL", "PERCENTEQUAL", 
			"AMPEREQUAL", "VBAREQUAL", "CIRCUMFLEXEQUAL", "LEFTSHIFTEQUAL", "RIGHTSHIFTEQUAL", 
			"DOUBLESTAREQUAL", "DOUBLESLASH", "DOUBLESLASHEQUAL", "AT", "ATEQUAL", 
			"RARROW", "ELLIPSIS", "COLONEQUAL", "EXCLAMATION", "FALSE", "AWAIT", 
			"ELSE", "IMPORT", "PASS", "NONE", "BREAK", "EXCEPT", "IN", "RAISE", "TRUE", 
			"CLASS", "FINALLY", "IS", "RETURN", "AND", "CONTINUE", "FOR", "LAMBDA", 
			"TRY", "AS", "DEF", "FROM", "NONLOCAL", "WHILE", "ASSERT", "DEL", "GLOBAL", 
			"NOT", "WITH", "ASYNC", "ELIF", "IF", "OR", "YIELD", "NAME_OR_TYPE", 
			"NAME_OR_MATCH", "NAME_OR_CASE", "NAME_OR_WILDCARD", "NAME", "NUMBER", 
			"STRING", "NEWLINE", "COMMENT", "WS", "EXPLICIT_LINE_JOINING", "ERRORTOKEN"
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
	public String getGrammarFileName() { return "PythonParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public PythonParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class File_inputContext extends org.example.antlr.common.context.ExtendContext {
		public TerminalNode EOF() { return getToken(PythonParser.EOF, 0); }
		public StatementsContext statements() {
			return getRuleContext(StatementsContext.class,0);
		}
		public File_inputContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_file_input; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterFile_input(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitFile_input(this);
		}
	}

	public final File_inputContext file_input() throws RecognitionException {
		File_inputContext _localctx = new File_inputContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_file_input);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(393);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << FSTRING_START) | (1L << LPAR) | (1L << LSQB) | (1L << LBRACE) | (1L << PLUS) | (1L << MINUS) | (1L << STAR) | (1L << TILDE) | (1L << AT) | (1L << ELLIPSIS) | (1L << FALSE) | (1L << AWAIT) | (1L << IMPORT) | (1L << PASS) | (1L << NONE) | (1L << BREAK))) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (RAISE - 65)) | (1L << (TRUE - 65)) | (1L << (CLASS - 65)) | (1L << (RETURN - 65)) | (1L << (CONTINUE - 65)) | (1L << (FOR - 65)) | (1L << (LAMBDA - 65)) | (1L << (TRY - 65)) | (1L << (DEF - 65)) | (1L << (FROM - 65)) | (1L << (NONLOCAL - 65)) | (1L << (WHILE - 65)) | (1L << (ASSERT - 65)) | (1L << (DEL - 65)) | (1L << (GLOBAL - 65)) | (1L << (NOT - 65)) | (1L << (WITH - 65)) | (1L << (ASYNC - 65)) | (1L << (IF - 65)) | (1L << (YIELD - 65)) | (1L << (NAME_OR_TYPE - 65)) | (1L << (NAME_OR_MATCH - 65)) | (1L << (NAME_OR_CASE - 65)) | (1L << (NAME_OR_WILDCARD - 65)) | (1L << (NAME - 65)) | (1L << (NUMBER - 65)) | (1L << (STRING - 65)))) != 0)) {
				{
				setState(392);
				statements();
				}
			}

			setState(395);
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

	public static class InteractiveContext extends org.example.antlr.common.context.ExtendContext {
		public Statement_newlineContext statement_newline() {
			return getRuleContext(Statement_newlineContext.class,0);
		}
		public InteractiveContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_interactive; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterInteractive(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitInteractive(this);
		}
	}

	public final InteractiveContext interactive() throws RecognitionException {
		InteractiveContext _localctx = new InteractiveContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_interactive);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(397);
			statement_newline();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EvalContext extends org.example.antlr.common.context.ExtendContext {
		public ExpressionsContext expressions() {
			return getRuleContext(ExpressionsContext.class,0);
		}
		public TerminalNode EOF() { return getToken(PythonParser.EOF, 0); }
		public List<TerminalNode> NEWLINE() { return getTokens(PythonParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(PythonParser.NEWLINE, i);
		}
		public EvalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eval; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterEval(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitEval(this);
		}
	}

	public final EvalContext eval() throws RecognitionException {
		EvalContext _localctx = new EvalContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_eval);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(399);
			expressions();
			setState(403);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NEWLINE) {
				{
				{
				setState(400);
				match(NEWLINE);
				}
				}
				setState(405);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(406);
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

	public static class Func_typeContext extends org.example.antlr.common.context.ExtendContext {
		public TerminalNode LPAR() { return getToken(PythonParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(PythonParser.RPAR, 0); }
		public TerminalNode RARROW() { return getToken(PythonParser.RARROW, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode EOF() { return getToken(PythonParser.EOF, 0); }
		public Type_expressionsContext type_expressions() {
			return getRuleContext(Type_expressionsContext.class,0);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(PythonParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(PythonParser.NEWLINE, i);
		}
		public Func_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_func_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterFunc_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitFunc_type(this);
		}
	}

	public final Func_typeContext func_type() throws RecognitionException {
		Func_typeContext _localctx = new Func_typeContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_func_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(408);
			match(LPAR);
			setState(410);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << FSTRING_START) | (1L << LPAR) | (1L << LSQB) | (1L << LBRACE) | (1L << PLUS) | (1L << MINUS) | (1L << STAR) | (1L << TILDE) | (1L << DOUBLESTAR) | (1L << ELLIPSIS) | (1L << FALSE) | (1L << AWAIT) | (1L << NONE))) != 0) || ((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & ((1L << (TRUE - 66)) | (1L << (LAMBDA - 66)) | (1L << (NOT - 66)) | (1L << (NAME_OR_TYPE - 66)) | (1L << (NAME_OR_MATCH - 66)) | (1L << (NAME_OR_CASE - 66)) | (1L << (NAME_OR_WILDCARD - 66)) | (1L << (NAME - 66)) | (1L << (NUMBER - 66)) | (1L << (STRING - 66)))) != 0)) {
				{
				setState(409);
				type_expressions();
				}
			}

			setState(412);
			match(RPAR);
			setState(413);
			match(RARROW);
			setState(414);
			expression();
			setState(418);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NEWLINE) {
				{
				{
				setState(415);
				match(NEWLINE);
				}
				}
				setState(420);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(421);
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

	public static class StatementsContext extends org.example.antlr.common.context.ExtendContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public StatementsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statements; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterStatements(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitStatements(this);
		}
	}

	public final StatementsContext statements() throws RecognitionException {
		StatementsContext _localctx = new StatementsContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_statements);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(424); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(423);
				statement();
				}
				}
				setState(426); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << FSTRING_START) | (1L << LPAR) | (1L << LSQB) | (1L << LBRACE) | (1L << PLUS) | (1L << MINUS) | (1L << STAR) | (1L << TILDE) | (1L << AT) | (1L << ELLIPSIS) | (1L << FALSE) | (1L << AWAIT) | (1L << IMPORT) | (1L << PASS) | (1L << NONE) | (1L << BREAK))) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (RAISE - 65)) | (1L << (TRUE - 65)) | (1L << (CLASS - 65)) | (1L << (RETURN - 65)) | (1L << (CONTINUE - 65)) | (1L << (FOR - 65)) | (1L << (LAMBDA - 65)) | (1L << (TRY - 65)) | (1L << (DEF - 65)) | (1L << (FROM - 65)) | (1L << (NONLOCAL - 65)) | (1L << (WHILE - 65)) | (1L << (ASSERT - 65)) | (1L << (DEL - 65)) | (1L << (GLOBAL - 65)) | (1L << (NOT - 65)) | (1L << (WITH - 65)) | (1L << (ASYNC - 65)) | (1L << (IF - 65)) | (1L << (YIELD - 65)) | (1L << (NAME_OR_TYPE - 65)) | (1L << (NAME_OR_MATCH - 65)) | (1L << (NAME_OR_CASE - 65)) | (1L << (NAME_OR_WILDCARD - 65)) | (1L << (NAME - 65)) | (1L << (NUMBER - 65)) | (1L << (STRING - 65)))) != 0) );
			}
		}
		catch (RecognitionException re) {
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
		public Compound_stmtContext compound_stmt() {
			return getRuleContext(Compound_stmtContext.class,0);
		}
		public Simple_stmtsContext simple_stmts() {
			return getRuleContext(Simple_stmtsContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitStatement(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_statement);
		try {
			setState(430);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(428);
				compound_stmt();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(429);
				simple_stmts();
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

	public static class Statement_newlineContext extends org.example.antlr.common.context.ExtendContext {
		public Compound_stmtContext compound_stmt() {
			return getRuleContext(Compound_stmtContext.class,0);
		}
		public TerminalNode NEWLINE() { return getToken(PythonParser.NEWLINE, 0); }
		public Simple_stmtsContext simple_stmts() {
			return getRuleContext(Simple_stmtsContext.class,0);
		}
		public TerminalNode EOF() { return getToken(PythonParser.EOF, 0); }
		public Statement_newlineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement_newline; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterStatement_newline(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitStatement_newline(this);
		}
	}

	public final Statement_newlineContext statement_newline() throws RecognitionException {
		Statement_newlineContext _localctx = new Statement_newlineContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_statement_newline);
		try {
			setState(438);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(432);
				compound_stmt();
				setState(433);
				match(NEWLINE);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(435);
				simple_stmts();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(436);
				match(NEWLINE);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(437);
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

	public static class Simple_stmtsContext extends org.example.antlr.common.context.ExtendContext {
		public List<Simple_stmtContext> simple_stmt() {
			return getRuleContexts(Simple_stmtContext.class);
		}
		public Simple_stmtContext simple_stmt(int i) {
			return getRuleContext(Simple_stmtContext.class,i);
		}
		public TerminalNode NEWLINE() { return getToken(PythonParser.NEWLINE, 0); }
		public List<TerminalNode> SEMI() { return getTokens(PythonParser.SEMI); }
		public TerminalNode SEMI(int i) {
			return getToken(PythonParser.SEMI, i);
		}
		public Simple_stmtsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simple_stmts; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterSimple_stmts(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitSimple_stmts(this);
		}
	}

	public final Simple_stmtsContext simple_stmts() throws RecognitionException {
		Simple_stmtsContext _localctx = new Simple_stmtsContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_simple_stmts);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(440);
			simple_stmt();
			setState(445);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(441);
					match(SEMI);
					setState(442);
					simple_stmt();
					}
					} 
				}
				setState(447);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			}
			setState(449);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SEMI) {
				{
				setState(448);
				match(SEMI);
				}
			}

			setState(451);
			match(NEWLINE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Simple_stmtContext extends org.example.antlr.common.context.ExtendContext {
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public Type_aliasContext type_alias() {
			return getRuleContext(Type_aliasContext.class,0);
		}
		public Star_expressionsContext star_expressions() {
			return getRuleContext(Star_expressionsContext.class,0);
		}
		public Return_stmtContext return_stmt() {
			return getRuleContext(Return_stmtContext.class,0);
		}
		public Import_stmtContext import_stmt() {
			return getRuleContext(Import_stmtContext.class,0);
		}
		public Raise_stmtContext raise_stmt() {
			return getRuleContext(Raise_stmtContext.class,0);
		}
		public TerminalNode PASS() { return getToken(PythonParser.PASS, 0); }
		public Del_stmtContext del_stmt() {
			return getRuleContext(Del_stmtContext.class,0);
		}
		public Yield_stmtContext yield_stmt() {
			return getRuleContext(Yield_stmtContext.class,0);
		}
		public Assert_stmtContext assert_stmt() {
			return getRuleContext(Assert_stmtContext.class,0);
		}
		public TerminalNode BREAK() { return getToken(PythonParser.BREAK, 0); }
		public TerminalNode CONTINUE() { return getToken(PythonParser.CONTINUE, 0); }
		public Global_stmtContext global_stmt() {
			return getRuleContext(Global_stmtContext.class,0);
		}
		public Nonlocal_stmtContext nonlocal_stmt() {
			return getRuleContext(Nonlocal_stmtContext.class,0);
		}
		public Simple_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simple_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterSimple_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitSimple_stmt(this);
		}
	}

	public final Simple_stmtContext simple_stmt() throws RecognitionException {
		Simple_stmtContext _localctx = new Simple_stmtContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_simple_stmt);
		try {
			setState(467);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(453);
				assignment();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(454);
				type_alias();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(455);
				star_expressions();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(456);
				return_stmt();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(457);
				import_stmt();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(458);
				raise_stmt();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(459);
				match(PASS);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(460);
				del_stmt();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(461);
				yield_stmt();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(462);
				assert_stmt();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(463);
				match(BREAK);
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(464);
				match(CONTINUE);
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(465);
				global_stmt();
				}
				break;
			case 14:
				enterOuterAlt(_localctx, 14);
				{
				setState(466);
				nonlocal_stmt();
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

	public static class Compound_stmtContext extends org.example.antlr.common.context.ExtendContext {
		public Function_defContext function_def() {
			return getRuleContext(Function_defContext.class,0);
		}
		public If_stmtContext if_stmt() {
			return getRuleContext(If_stmtContext.class,0);
		}
		public Class_defContext class_def() {
			return getRuleContext(Class_defContext.class,0);
		}
		public With_stmtContext with_stmt() {
			return getRuleContext(With_stmtContext.class,0);
		}
		public For_stmtContext for_stmt() {
			return getRuleContext(For_stmtContext.class,0);
		}
		public Try_stmtContext try_stmt() {
			return getRuleContext(Try_stmtContext.class,0);
		}
		public While_stmtContext while_stmt() {
			return getRuleContext(While_stmtContext.class,0);
		}
		public Match_stmtContext match_stmt() {
			return getRuleContext(Match_stmtContext.class,0);
		}
		public Compound_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compound_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterCompound_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitCompound_stmt(this);
		}
	}

	public final Compound_stmtContext compound_stmt() throws RecognitionException {
		Compound_stmtContext _localctx = new Compound_stmtContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_compound_stmt);
		try {
			setState(477);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(469);
				function_def();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(470);
				if_stmt();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(471);
				class_def();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(472);
				with_stmt();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(473);
				for_stmt();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(474);
				try_stmt();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(475);
				while_stmt();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(476);
				match_stmt();
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

	public static class AssignmentContext extends org.example.antlr.common.context.ExtendContext {
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public TerminalNode COLON() { return getToken(PythonParser.COLON, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<TerminalNode> EQUAL() { return getTokens(PythonParser.EQUAL); }
		public TerminalNode EQUAL(int i) {
			return getToken(PythonParser.EQUAL, i);
		}
		public Annotated_rhsContext annotated_rhs() {
			return getRuleContext(Annotated_rhsContext.class,0);
		}
		public TerminalNode LPAR() { return getToken(PythonParser.LPAR, 0); }
		public Single_targetContext single_target() {
			return getRuleContext(Single_targetContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(PythonParser.RPAR, 0); }
		public Single_subscript_attribute_targetContext single_subscript_attribute_target() {
			return getRuleContext(Single_subscript_attribute_targetContext.class,0);
		}
		public Yield_exprContext yield_expr() {
			return getRuleContext(Yield_exprContext.class,0);
		}
		public Star_expressionsContext star_expressions() {
			return getRuleContext(Star_expressionsContext.class,0);
		}
		public List<Star_targetsContext> star_targets() {
			return getRuleContexts(Star_targetsContext.class);
		}
		public Star_targetsContext star_targets(int i) {
			return getRuleContext(Star_targetsContext.class,i);
		}
		public TerminalNode TYPE_COMMENT() { return getToken(PythonParser.TYPE_COMMENT, 0); }
		public AugassignContext augassign() {
			return getRuleContext(AugassignContext.class,0);
		}
		public AssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitAssignment(this);
		}
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_assignment);
		int _la;
		try {
			int _alt;
			setState(519);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(479);
				name();
				setState(480);
				match(COLON);
				setState(481);
				expression();
				setState(484);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==EQUAL) {
					{
					setState(482);
					match(EQUAL);
					setState(483);
					annotated_rhs();
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(491);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
				case 1:
					{
					setState(486);
					match(LPAR);
					setState(487);
					single_target();
					setState(488);
					match(RPAR);
					}
					break;
				case 2:
					{
					setState(490);
					single_subscript_attribute_target();
					}
					break;
				}
				setState(493);
				match(COLON);
				setState(494);
				expression();
				setState(497);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==EQUAL) {
					{
					setState(495);
					match(EQUAL);
					setState(496);
					annotated_rhs();
					}
				}

				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(502); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(499);
						star_targets();
						setState(500);
						match(EQUAL);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(504); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(508);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case YIELD:
					{
					setState(506);
					yield_expr();
					}
					break;
				case FSTRING_START:
				case LPAR:
				case LSQB:
				case LBRACE:
				case PLUS:
				case MINUS:
				case STAR:
				case TILDE:
				case ELLIPSIS:
				case FALSE:
				case AWAIT:
				case NONE:
				case TRUE:
				case LAMBDA:
				case NOT:
				case NAME_OR_TYPE:
				case NAME_OR_MATCH:
				case NAME_OR_CASE:
				case NAME_OR_WILDCARD:
				case NAME:
				case NUMBER:
				case STRING:
					{
					setState(507);
					star_expressions();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(511);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==TYPE_COMMENT) {
					{
					setState(510);
					match(TYPE_COMMENT);
					}
				}

				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(513);
				single_target();
				setState(514);
				augassign();
				setState(517);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case YIELD:
					{
					setState(515);
					yield_expr();
					}
					break;
				case FSTRING_START:
				case LPAR:
				case LSQB:
				case LBRACE:
				case PLUS:
				case MINUS:
				case STAR:
				case TILDE:
				case ELLIPSIS:
				case FALSE:
				case AWAIT:
				case NONE:
				case TRUE:
				case LAMBDA:
				case NOT:
				case NAME_OR_TYPE:
				case NAME_OR_MATCH:
				case NAME_OR_CASE:
				case NAME_OR_WILDCARD:
				case NAME:
				case NUMBER:
				case STRING:
					{
					setState(516);
					star_expressions();
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

	public static class Annotated_rhsContext extends org.example.antlr.common.context.ExtendContext {
		public Yield_exprContext yield_expr() {
			return getRuleContext(Yield_exprContext.class,0);
		}
		public Star_expressionsContext star_expressions() {
			return getRuleContext(Star_expressionsContext.class,0);
		}
		public Annotated_rhsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_annotated_rhs; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterAnnotated_rhs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitAnnotated_rhs(this);
		}
	}

	public final Annotated_rhsContext annotated_rhs() throws RecognitionException {
		Annotated_rhsContext _localctx = new Annotated_rhsContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_annotated_rhs);
		try {
			setState(523);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case YIELD:
				enterOuterAlt(_localctx, 1);
				{
				setState(521);
				yield_expr();
				}
				break;
			case FSTRING_START:
			case LPAR:
			case LSQB:
			case LBRACE:
			case PLUS:
			case MINUS:
			case STAR:
			case TILDE:
			case ELLIPSIS:
			case FALSE:
			case AWAIT:
			case NONE:
			case TRUE:
			case LAMBDA:
			case NOT:
			case NAME_OR_TYPE:
			case NAME_OR_MATCH:
			case NAME_OR_CASE:
			case NAME_OR_WILDCARD:
			case NAME:
			case NUMBER:
			case STRING:
				enterOuterAlt(_localctx, 2);
				{
				setState(522);
				star_expressions();
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

	public static class AugassignContext extends org.example.antlr.common.context.ExtendContext {
		public TerminalNode PLUSEQUAL() { return getToken(PythonParser.PLUSEQUAL, 0); }
		public TerminalNode MINEQUAL() { return getToken(PythonParser.MINEQUAL, 0); }
		public TerminalNode STAREQUAL() { return getToken(PythonParser.STAREQUAL, 0); }
		public TerminalNode ATEQUAL() { return getToken(PythonParser.ATEQUAL, 0); }
		public TerminalNode SLASHEQUAL() { return getToken(PythonParser.SLASHEQUAL, 0); }
		public TerminalNode PERCENTEQUAL() { return getToken(PythonParser.PERCENTEQUAL, 0); }
		public TerminalNode AMPEREQUAL() { return getToken(PythonParser.AMPEREQUAL, 0); }
		public TerminalNode VBAREQUAL() { return getToken(PythonParser.VBAREQUAL, 0); }
		public TerminalNode CIRCUMFLEXEQUAL() { return getToken(PythonParser.CIRCUMFLEXEQUAL, 0); }
		public TerminalNode LEFTSHIFTEQUAL() { return getToken(PythonParser.LEFTSHIFTEQUAL, 0); }
		public TerminalNode RIGHTSHIFTEQUAL() { return getToken(PythonParser.RIGHTSHIFTEQUAL, 0); }
		public TerminalNode DOUBLESTAREQUAL() { return getToken(PythonParser.DOUBLESTAREQUAL, 0); }
		public TerminalNode DOUBLESLASHEQUAL() { return getToken(PythonParser.DOUBLESLASHEQUAL, 0); }
		public AugassignContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_augassign; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterAugassign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitAugassign(this);
		}
	}

	public final AugassignContext augassign() throws RecognitionException {
		AugassignContext _localctx = new AugassignContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_augassign);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(525);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PLUSEQUAL) | (1L << MINEQUAL) | (1L << STAREQUAL) | (1L << SLASHEQUAL) | (1L << PERCENTEQUAL) | (1L << AMPEREQUAL) | (1L << VBAREQUAL) | (1L << CIRCUMFLEXEQUAL) | (1L << LEFTSHIFTEQUAL) | (1L << RIGHTSHIFTEQUAL) | (1L << DOUBLESTAREQUAL) | (1L << DOUBLESLASHEQUAL) | (1L << ATEQUAL))) != 0)) ) {
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

	public static class Return_stmtContext extends org.example.antlr.common.context.ExtendContext {
		public TerminalNode RETURN() { return getToken(PythonParser.RETURN, 0); }
		public Star_expressionsContext star_expressions() {
			return getRuleContext(Star_expressionsContext.class,0);
		}
		public Return_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_return_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterReturn_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitReturn_stmt(this);
		}
	}

	public final Return_stmtContext return_stmt() throws RecognitionException {
		Return_stmtContext _localctx = new Return_stmtContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_return_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(527);
			match(RETURN);
			setState(529);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << FSTRING_START) | (1L << LPAR) | (1L << LSQB) | (1L << LBRACE) | (1L << PLUS) | (1L << MINUS) | (1L << STAR) | (1L << TILDE) | (1L << ELLIPSIS) | (1L << FALSE) | (1L << AWAIT) | (1L << NONE))) != 0) || ((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & ((1L << (TRUE - 66)) | (1L << (LAMBDA - 66)) | (1L << (NOT - 66)) | (1L << (NAME_OR_TYPE - 66)) | (1L << (NAME_OR_MATCH - 66)) | (1L << (NAME_OR_CASE - 66)) | (1L << (NAME_OR_WILDCARD - 66)) | (1L << (NAME - 66)) | (1L << (NUMBER - 66)) | (1L << (STRING - 66)))) != 0)) {
				{
				setState(528);
				star_expressions();
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

	public static class Raise_stmtContext extends org.example.antlr.common.context.ExtendContext {
		public TerminalNode RAISE() { return getToken(PythonParser.RAISE, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode FROM() { return getToken(PythonParser.FROM, 0); }
		public Raise_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_raise_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterRaise_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitRaise_stmt(this);
		}
	}

	public final Raise_stmtContext raise_stmt() throws RecognitionException {
		Raise_stmtContext _localctx = new Raise_stmtContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_raise_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(531);
			match(RAISE);
			setState(537);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << FSTRING_START) | (1L << LPAR) | (1L << LSQB) | (1L << LBRACE) | (1L << PLUS) | (1L << MINUS) | (1L << TILDE) | (1L << ELLIPSIS) | (1L << FALSE) | (1L << AWAIT) | (1L << NONE))) != 0) || ((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & ((1L << (TRUE - 66)) | (1L << (LAMBDA - 66)) | (1L << (NOT - 66)) | (1L << (NAME_OR_TYPE - 66)) | (1L << (NAME_OR_MATCH - 66)) | (1L << (NAME_OR_CASE - 66)) | (1L << (NAME_OR_WILDCARD - 66)) | (1L << (NAME - 66)) | (1L << (NUMBER - 66)) | (1L << (STRING - 66)))) != 0)) {
				{
				setState(532);
				expression();
				setState(535);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==FROM) {
					{
					setState(533);
					match(FROM);
					setState(534);
					expression();
					}
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

	public static class Global_stmtContext extends org.example.antlr.common.context.ExtendContext {
		public TerminalNode GLOBAL() { return getToken(PythonParser.GLOBAL, 0); }
		public List<NameContext> name() {
			return getRuleContexts(NameContext.class);
		}
		public NameContext name(int i) {
			return getRuleContext(NameContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(PythonParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(PythonParser.COMMA, i);
		}
		public Global_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_global_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterGlobal_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitGlobal_stmt(this);
		}
	}

	public final Global_stmtContext global_stmt() throws RecognitionException {
		Global_stmtContext _localctx = new Global_stmtContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_global_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(539);
			match(GLOBAL);
			setState(540);
			name();
			setState(545);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(541);
				match(COMMA);
				setState(542);
				name();
				}
				}
				setState(547);
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

	public static class Nonlocal_stmtContext extends org.example.antlr.common.context.ExtendContext {
		public TerminalNode NONLOCAL() { return getToken(PythonParser.NONLOCAL, 0); }
		public List<NameContext> name() {
			return getRuleContexts(NameContext.class);
		}
		public NameContext name(int i) {
			return getRuleContext(NameContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(PythonParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(PythonParser.COMMA, i);
		}
		public Nonlocal_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nonlocal_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterNonlocal_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitNonlocal_stmt(this);
		}
	}

	public final Nonlocal_stmtContext nonlocal_stmt() throws RecognitionException {
		Nonlocal_stmtContext _localctx = new Nonlocal_stmtContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_nonlocal_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(548);
			match(NONLOCAL);
			setState(549);
			name();
			setState(554);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(550);
				match(COMMA);
				setState(551);
				name();
				}
				}
				setState(556);
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

	public static class Del_stmtContext extends org.example.antlr.common.context.ExtendContext {
		public TerminalNode DEL() { return getToken(PythonParser.DEL, 0); }
		public Del_targetsContext del_targets() {
			return getRuleContext(Del_targetsContext.class,0);
		}
		public Del_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_del_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterDel_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitDel_stmt(this);
		}
	}

	public final Del_stmtContext del_stmt() throws RecognitionException {
		Del_stmtContext _localctx = new Del_stmtContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_del_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(557);
			match(DEL);
			setState(558);
			del_targets();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Yield_stmtContext extends org.example.antlr.common.context.ExtendContext {
		public Yield_exprContext yield_expr() {
			return getRuleContext(Yield_exprContext.class,0);
		}
		public Yield_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_yield_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterYield_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitYield_stmt(this);
		}
	}

	public final Yield_stmtContext yield_stmt() throws RecognitionException {
		Yield_stmtContext _localctx = new Yield_stmtContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_yield_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(560);
			yield_expr();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Assert_stmtContext extends org.example.antlr.common.context.ExtendContext {
		public TerminalNode ASSERT() { return getToken(PythonParser.ASSERT, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode COMMA() { return getToken(PythonParser.COMMA, 0); }
		public Assert_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assert_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterAssert_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitAssert_stmt(this);
		}
	}

	public final Assert_stmtContext assert_stmt() throws RecognitionException {
		Assert_stmtContext _localctx = new Assert_stmtContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_assert_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(562);
			match(ASSERT);
			setState(563);
			expression();
			setState(566);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(564);
				match(COMMA);
				setState(565);
				expression();
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

	public static class Import_stmtContext extends org.example.antlr.common.context.ExtendContext {
		public Import_nameContext import_name() {
			return getRuleContext(Import_nameContext.class,0);
		}
		public Import_fromContext import_from() {
			return getRuleContext(Import_fromContext.class,0);
		}
		public Import_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_import_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterImport_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitImport_stmt(this);
		}
	}

	public final Import_stmtContext import_stmt() throws RecognitionException {
		Import_stmtContext _localctx = new Import_stmtContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_import_stmt);
		try {
			setState(570);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IMPORT:
				enterOuterAlt(_localctx, 1);
				{
				setState(568);
				import_name();
				}
				break;
			case FROM:
				enterOuterAlt(_localctx, 2);
				{
				setState(569);
				import_from();
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

	public static class Import_nameContext extends org.example.antlr.common.context.ExtendContext {
		public TerminalNode IMPORT() { return getToken(PythonParser.IMPORT, 0); }
		public Dotted_as_namesContext dotted_as_names() {
			return getRuleContext(Dotted_as_namesContext.class,0);
		}
		public Import_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_import_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterImport_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitImport_name(this);
		}
	}

	public final Import_nameContext import_name() throws RecognitionException {
		Import_nameContext _localctx = new Import_nameContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_import_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(572);
			match(IMPORT);
			setState(573);
			dotted_as_names();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Import_fromContext extends org.example.antlr.common.context.ExtendContext {
		public TerminalNode FROM() { return getToken(PythonParser.FROM, 0); }
		public Dotted_nameContext dotted_name() {
			return getRuleContext(Dotted_nameContext.class,0);
		}
		public TerminalNode IMPORT() { return getToken(PythonParser.IMPORT, 0); }
		public Import_from_targetsContext import_from_targets() {
			return getRuleContext(Import_from_targetsContext.class,0);
		}
		public List<TerminalNode> DOT() { return getTokens(PythonParser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(PythonParser.DOT, i);
		}
		public List<TerminalNode> ELLIPSIS() { return getTokens(PythonParser.ELLIPSIS); }
		public TerminalNode ELLIPSIS(int i) {
			return getToken(PythonParser.ELLIPSIS, i);
		}
		public Import_fromContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_import_from; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterImport_from(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitImport_from(this);
		}
	}

	public final Import_fromContext import_from() throws RecognitionException {
		Import_fromContext _localctx = new Import_fromContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_import_from);
		int _la;
		try {
			setState(594);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(575);
				match(FROM);
				setState(579);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==DOT || _la==ELLIPSIS) {
					{
					{
					setState(576);
					_la = _input.LA(1);
					if ( !(_la==DOT || _la==ELLIPSIS) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
					}
					setState(581);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(582);
				dotted_name(0);
				setState(583);
				match(IMPORT);
				setState(584);
				import_from_targets();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(586);
				match(FROM);
				setState(588); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(587);
					_la = _input.LA(1);
					if ( !(_la==DOT || _la==ELLIPSIS) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
					}
					setState(590); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==DOT || _la==ELLIPSIS );
				setState(592);
				match(IMPORT);
				setState(593);
				import_from_targets();
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

	public static class Import_from_targetsContext extends org.example.antlr.common.context.ExtendContext {
		public TerminalNode LPAR() { return getToken(PythonParser.LPAR, 0); }
		public Import_from_as_namesContext import_from_as_names() {
			return getRuleContext(Import_from_as_namesContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(PythonParser.RPAR, 0); }
		public TerminalNode COMMA() { return getToken(PythonParser.COMMA, 0); }
		public TerminalNode STAR() { return getToken(PythonParser.STAR, 0); }
		public Import_from_targetsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_import_from_targets; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterImport_from_targets(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitImport_from_targets(this);
		}
	}

	public final Import_from_targetsContext import_from_targets() throws RecognitionException {
		Import_from_targetsContext _localctx = new Import_from_targetsContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_import_from_targets);
		int _la;
		try {
			setState(605);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LPAR:
				enterOuterAlt(_localctx, 1);
				{
				setState(596);
				match(LPAR);
				setState(597);
				import_from_as_names();
				setState(599);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(598);
					match(COMMA);
					}
				}

				setState(601);
				match(RPAR);
				}
				break;
			case NAME_OR_TYPE:
			case NAME_OR_MATCH:
			case NAME_OR_CASE:
			case NAME_OR_WILDCARD:
			case NAME:
				enterOuterAlt(_localctx, 2);
				{
				setState(603);
				import_from_as_names();
				}
				break;
			case STAR:
				enterOuterAlt(_localctx, 3);
				{
				setState(604);
				match(STAR);
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

	public static class Import_from_as_namesContext extends org.example.antlr.common.context.ExtendContext {
		public List<Import_from_as_nameContext> import_from_as_name() {
			return getRuleContexts(Import_from_as_nameContext.class);
		}
		public Import_from_as_nameContext import_from_as_name(int i) {
			return getRuleContext(Import_from_as_nameContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(PythonParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(PythonParser.COMMA, i);
		}
		public Import_from_as_namesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_import_from_as_names; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterImport_from_as_names(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitImport_from_as_names(this);
		}
	}

	public final Import_from_as_namesContext import_from_as_names() throws RecognitionException {
		Import_from_as_namesContext _localctx = new Import_from_as_namesContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_import_from_as_names);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(607);
			import_from_as_name();
			setState(612);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,32,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(608);
					match(COMMA);
					setState(609);
					import_from_as_name();
					}
					} 
				}
				setState(614);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,32,_ctx);
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

	public static class Import_from_as_nameContext extends org.example.antlr.common.context.ExtendContext {
		public List<NameContext> name() {
			return getRuleContexts(NameContext.class);
		}
		public NameContext name(int i) {
			return getRuleContext(NameContext.class,i);
		}
		public TerminalNode AS() { return getToken(PythonParser.AS, 0); }
		public Import_from_as_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_import_from_as_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterImport_from_as_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitImport_from_as_name(this);
		}
	}

	public final Import_from_as_nameContext import_from_as_name() throws RecognitionException {
		Import_from_as_nameContext _localctx = new Import_from_as_nameContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_import_from_as_name);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(615);
			name();
			setState(618);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==AS) {
				{
				setState(616);
				match(AS);
				setState(617);
				name();
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

	public static class Dotted_as_namesContext extends org.example.antlr.common.context.ExtendContext {
		public List<Dotted_as_nameContext> dotted_as_name() {
			return getRuleContexts(Dotted_as_nameContext.class);
		}
		public Dotted_as_nameContext dotted_as_name(int i) {
			return getRuleContext(Dotted_as_nameContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(PythonParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(PythonParser.COMMA, i);
		}
		public Dotted_as_namesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dotted_as_names; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterDotted_as_names(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitDotted_as_names(this);
		}
	}

	public final Dotted_as_namesContext dotted_as_names() throws RecognitionException {
		Dotted_as_namesContext _localctx = new Dotted_as_namesContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_dotted_as_names);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(620);
			dotted_as_name();
			setState(625);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(621);
				match(COMMA);
				setState(622);
				dotted_as_name();
				}
				}
				setState(627);
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

	public static class Dotted_as_nameContext extends org.example.antlr.common.context.ExtendContext {
		public Dotted_nameContext dotted_name() {
			return getRuleContext(Dotted_nameContext.class,0);
		}
		public TerminalNode AS() { return getToken(PythonParser.AS, 0); }
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public Dotted_as_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dotted_as_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterDotted_as_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitDotted_as_name(this);
		}
	}

	public final Dotted_as_nameContext dotted_as_name() throws RecognitionException {
		Dotted_as_nameContext _localctx = new Dotted_as_nameContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_dotted_as_name);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(628);
			dotted_name(0);
			setState(631);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==AS) {
				{
				setState(629);
				match(AS);
				setState(630);
				name();
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

	public static class Dotted_nameContext extends org.example.antlr.common.context.ExtendContext {
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public Dotted_nameContext dotted_name() {
			return getRuleContext(Dotted_nameContext.class,0);
		}
		public TerminalNode DOT() { return getToken(PythonParser.DOT, 0); }
		public Dotted_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dotted_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterDotted_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitDotted_name(this);
		}
	}

	public final Dotted_nameContext dotted_name() throws RecognitionException {
		return dotted_name(0);
	}

	private Dotted_nameContext dotted_name(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Dotted_nameContext _localctx = new Dotted_nameContext(_ctx, _parentState);
		Dotted_nameContext _prevctx = _localctx;
		int _startState = 56;
		enterRecursionRule(_localctx, 56, RULE_dotted_name, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(634);
			name();
			}
			_ctx.stop = _input.LT(-1);
			setState(641);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,36,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Dotted_nameContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_dotted_name);
					setState(636);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(637);
					match(DOT);
					setState(638);
					name();
					}
					} 
				}
				setState(643);
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

	public static class BlockContext extends org.example.antlr.common.context.ExtendContext {
		public TerminalNode NEWLINE() { return getToken(PythonParser.NEWLINE, 0); }
		public TerminalNode INDENT() { return getToken(PythonParser.INDENT, 0); }
		public StatementsContext statements() {
			return getRuleContext(StatementsContext.class,0);
		}
		public TerminalNode DEDENT() { return getToken(PythonParser.DEDENT, 0); }
		public Simple_stmtsContext simple_stmts() {
			return getRuleContext(Simple_stmtsContext.class,0);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitBlock(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_block);
		try {
			setState(650);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NEWLINE:
				enterOuterAlt(_localctx, 1);
				{
				setState(644);
				match(NEWLINE);
				setState(645);
				match(INDENT);
				setState(646);
				statements();
				setState(647);
				match(DEDENT);
				}
				break;
			case FSTRING_START:
			case LPAR:
			case LSQB:
			case LBRACE:
			case PLUS:
			case MINUS:
			case STAR:
			case TILDE:
			case ELLIPSIS:
			case FALSE:
			case AWAIT:
			case IMPORT:
			case PASS:
			case NONE:
			case BREAK:
			case RAISE:
			case TRUE:
			case RETURN:
			case CONTINUE:
			case LAMBDA:
			case FROM:
			case NONLOCAL:
			case ASSERT:
			case DEL:
			case GLOBAL:
			case NOT:
			case YIELD:
			case NAME_OR_TYPE:
			case NAME_OR_MATCH:
			case NAME_OR_CASE:
			case NAME_OR_WILDCARD:
			case NAME:
			case NUMBER:
			case STRING:
				enterOuterAlt(_localctx, 2);
				{
				setState(649);
				simple_stmts();
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

	public static class DecoratorsContext extends org.example.antlr.common.context.ExtendContext {
		public List<TerminalNode> AT() { return getTokens(PythonParser.AT); }
		public TerminalNode AT(int i) {
			return getToken(PythonParser.AT, i);
		}
		public List<Named_expressionContext> named_expression() {
			return getRuleContexts(Named_expressionContext.class);
		}
		public Named_expressionContext named_expression(int i) {
			return getRuleContext(Named_expressionContext.class,i);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(PythonParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(PythonParser.NEWLINE, i);
		}
		public DecoratorsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decorators; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterDecorators(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitDecorators(this);
		}
	}

	public final DecoratorsContext decorators() throws RecognitionException {
		DecoratorsContext _localctx = new DecoratorsContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_decorators);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(656); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(652);
				match(AT);
				setState(653);
				named_expression();
				setState(654);
				match(NEWLINE);
				}
				}
				setState(658); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==AT );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Class_defContext extends org.example.antlr.common.context.ExtendContext {
		public DecoratorsContext decorators() {
			return getRuleContext(DecoratorsContext.class,0);
		}
		public Class_def_rawContext class_def_raw() {
			return getRuleContext(Class_def_rawContext.class,0);
		}
		public Class_defContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_class_def; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterClass_def(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitClass_def(this);
		}
	}

	public final Class_defContext class_def() throws RecognitionException {
		Class_defContext _localctx = new Class_defContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_class_def);
		try {
			setState(664);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case AT:
				enterOuterAlt(_localctx, 1);
				{
				setState(660);
				decorators();
				setState(661);
				class_def_raw();
				}
				break;
			case CLASS:
				enterOuterAlt(_localctx, 2);
				{
				setState(663);
				class_def_raw();
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

	public static class Class_def_rawContext extends org.example.antlr.common.context.ExtendContext {
		public TerminalNode CLASS() { return getToken(PythonParser.CLASS, 0); }
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public TerminalNode COLON() { return getToken(PythonParser.COLON, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public Type_paramsContext type_params() {
			return getRuleContext(Type_paramsContext.class,0);
		}
		public TerminalNode LPAR() { return getToken(PythonParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(PythonParser.RPAR, 0); }
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public Class_def_rawContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_class_def_raw; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterClass_def_raw(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitClass_def_raw(this);
		}
	}

	public final Class_def_rawContext class_def_raw() throws RecognitionException {
		Class_def_rawContext _localctx = new Class_def_rawContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_class_def_raw);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(666);
			match(CLASS);
			setState(667);
			name();
			setState(669);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LSQB) {
				{
				setState(668);
				type_params();
				}
			}

			setState(676);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LPAR) {
				{
				setState(671);
				match(LPAR);
				setState(673);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << FSTRING_START) | (1L << LPAR) | (1L << LSQB) | (1L << LBRACE) | (1L << PLUS) | (1L << MINUS) | (1L << STAR) | (1L << TILDE) | (1L << DOUBLESTAR) | (1L << ELLIPSIS) | (1L << FALSE) | (1L << AWAIT) | (1L << NONE))) != 0) || ((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & ((1L << (TRUE - 66)) | (1L << (LAMBDA - 66)) | (1L << (NOT - 66)) | (1L << (NAME_OR_TYPE - 66)) | (1L << (NAME_OR_MATCH - 66)) | (1L << (NAME_OR_CASE - 66)) | (1L << (NAME_OR_WILDCARD - 66)) | (1L << (NAME - 66)) | (1L << (NUMBER - 66)) | (1L << (STRING - 66)))) != 0)) {
					{
					setState(672);
					arguments();
					}
				}

				setState(675);
				match(RPAR);
				}
			}

			setState(678);
			match(COLON);
			setState(679);
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

	public static class Function_defContext extends org.example.antlr.common.context.ExtendContext {
		public DecoratorsContext decorators() {
			return getRuleContext(DecoratorsContext.class,0);
		}
		public Function_def_rawContext function_def_raw() {
			return getRuleContext(Function_def_rawContext.class,0);
		}
		public Function_defContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_def; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterFunction_def(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitFunction_def(this);
		}
	}

	public final Function_defContext function_def() throws RecognitionException {
		Function_defContext _localctx = new Function_defContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_function_def);
		try {
			setState(685);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case AT:
				enterOuterAlt(_localctx, 1);
				{
				setState(681);
				decorators();
				setState(682);
				function_def_raw();
				}
				break;
			case DEF:
			case ASYNC:
				enterOuterAlt(_localctx, 2);
				{
				setState(684);
				function_def_raw();
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

	public static class Function_def_rawContext extends org.example.antlr.common.context.ExtendContext {
		public TerminalNode DEF() { return getToken(PythonParser.DEF, 0); }
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public TerminalNode LPAR() { return getToken(PythonParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(PythonParser.RPAR, 0); }
		public TerminalNode COLON() { return getToken(PythonParser.COLON, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public Type_paramsContext type_params() {
			return getRuleContext(Type_paramsContext.class,0);
		}
		public ParamsContext params() {
			return getRuleContext(ParamsContext.class,0);
		}
		public TerminalNode RARROW() { return getToken(PythonParser.RARROW, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public Func_type_commentContext func_type_comment() {
			return getRuleContext(Func_type_commentContext.class,0);
		}
		public TerminalNode ASYNC() { return getToken(PythonParser.ASYNC, 0); }
		public Function_def_rawContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_def_raw; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterFunction_def_raw(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitFunction_def_raw(this);
		}
	}

	public final Function_def_rawContext function_def_raw() throws RecognitionException {
		Function_def_rawContext _localctx = new Function_def_rawContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_function_def_raw);
		int _la;
		try {
			setState(728);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DEF:
				enterOuterAlt(_localctx, 1);
				{
				setState(687);
				match(DEF);
				setState(688);
				name();
				setState(690);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LSQB) {
					{
					setState(689);
					type_params();
					}
				}

				setState(692);
				match(LPAR);
				setState(694);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==STAR || _la==DOUBLESTAR || ((((_la - 91)) & ~0x3f) == 0 && ((1L << (_la - 91)) & ((1L << (NAME_OR_TYPE - 91)) | (1L << (NAME_OR_MATCH - 91)) | (1L << (NAME_OR_CASE - 91)) | (1L << (NAME_OR_WILDCARD - 91)) | (1L << (NAME - 91)))) != 0)) {
					{
					setState(693);
					params();
					}
				}

				setState(696);
				match(RPAR);
				setState(699);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==RARROW) {
					{
					setState(697);
					match(RARROW);
					setState(698);
					expression();
					}
				}

				setState(701);
				match(COLON);
				setState(703);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,47,_ctx) ) {
				case 1:
					{
					setState(702);
					func_type_comment();
					}
					break;
				}
				setState(705);
				block();
				}
				break;
			case ASYNC:
				enterOuterAlt(_localctx, 2);
				{
				setState(707);
				match(ASYNC);
				setState(708);
				match(DEF);
				setState(709);
				name();
				setState(711);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LSQB) {
					{
					setState(710);
					type_params();
					}
				}

				setState(713);
				match(LPAR);
				setState(715);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==STAR || _la==DOUBLESTAR || ((((_la - 91)) & ~0x3f) == 0 && ((1L << (_la - 91)) & ((1L << (NAME_OR_TYPE - 91)) | (1L << (NAME_OR_MATCH - 91)) | (1L << (NAME_OR_CASE - 91)) | (1L << (NAME_OR_WILDCARD - 91)) | (1L << (NAME - 91)))) != 0)) {
					{
					setState(714);
					params();
					}
				}

				setState(717);
				match(RPAR);
				setState(720);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==RARROW) {
					{
					setState(718);
					match(RARROW);
					setState(719);
					expression();
					}
				}

				setState(722);
				match(COLON);
				setState(724);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,51,_ctx) ) {
				case 1:
					{
					setState(723);
					func_type_comment();
					}
					break;
				}
				setState(726);
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

	public static class ParamsContext extends org.example.antlr.common.context.ExtendContext {
		public ParametersContext parameters() {
			return getRuleContext(ParametersContext.class,0);
		}
		public ParamsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_params; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterParams(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitParams(this);
		}
	}

	public final ParamsContext params() throws RecognitionException {
		ParamsContext _localctx = new ParamsContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_params);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(730);
			parameters();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParametersContext extends org.example.antlr.common.context.ExtendContext {
		public Slash_no_defaultContext slash_no_default() {
			return getRuleContext(Slash_no_defaultContext.class,0);
		}
		public List<Param_no_defaultContext> param_no_default() {
			return getRuleContexts(Param_no_defaultContext.class);
		}
		public Param_no_defaultContext param_no_default(int i) {
			return getRuleContext(Param_no_defaultContext.class,i);
		}
		public List<Param_with_defaultContext> param_with_default() {
			return getRuleContexts(Param_with_defaultContext.class);
		}
		public Param_with_defaultContext param_with_default(int i) {
			return getRuleContext(Param_with_defaultContext.class,i);
		}
		public Star_etcContext star_etc() {
			return getRuleContext(Star_etcContext.class,0);
		}
		public Slash_with_defaultContext slash_with_default() {
			return getRuleContext(Slash_with_defaultContext.class,0);
		}
		public ParametersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameters; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterParameters(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitParameters(this);
		}
	}

	public final ParametersContext parameters() throws RecognitionException {
		ParametersContext _localctx = new ParametersContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_parameters);
		int _la;
		try {
			int _alt;
			setState(781);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,63,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(732);
				slash_no_default();
				setState(736);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,53,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(733);
						param_no_default();
						}
						} 
					}
					setState(738);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,53,_ctx);
				}
				setState(742);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (((((_la - 91)) & ~0x3f) == 0 && ((1L << (_la - 91)) & ((1L << (NAME_OR_TYPE - 91)) | (1L << (NAME_OR_MATCH - 91)) | (1L << (NAME_OR_CASE - 91)) | (1L << (NAME_OR_WILDCARD - 91)) | (1L << (NAME - 91)))) != 0)) {
					{
					{
					setState(739);
					param_with_default();
					}
					}
					setState(744);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(746);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==STAR || _la==DOUBLESTAR) {
					{
					setState(745);
					star_etc();
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(748);
				slash_with_default();
				setState(752);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (((((_la - 91)) & ~0x3f) == 0 && ((1L << (_la - 91)) & ((1L << (NAME_OR_TYPE - 91)) | (1L << (NAME_OR_MATCH - 91)) | (1L << (NAME_OR_CASE - 91)) | (1L << (NAME_OR_WILDCARD - 91)) | (1L << (NAME - 91)))) != 0)) {
					{
					{
					setState(749);
					param_with_default();
					}
					}
					setState(754);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(756);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==STAR || _la==DOUBLESTAR) {
					{
					setState(755);
					star_etc();
					}
				}

				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(759); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(758);
						param_no_default();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(761); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,58,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(766);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (((((_la - 91)) & ~0x3f) == 0 && ((1L << (_la - 91)) & ((1L << (NAME_OR_TYPE - 91)) | (1L << (NAME_OR_MATCH - 91)) | (1L << (NAME_OR_CASE - 91)) | (1L << (NAME_OR_WILDCARD - 91)) | (1L << (NAME - 91)))) != 0)) {
					{
					{
					setState(763);
					param_with_default();
					}
					}
					setState(768);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(770);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==STAR || _la==DOUBLESTAR) {
					{
					setState(769);
					star_etc();
					}
				}

				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(773); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(772);
					param_with_default();
					}
					}
					setState(775); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( ((((_la - 91)) & ~0x3f) == 0 && ((1L << (_la - 91)) & ((1L << (NAME_OR_TYPE - 91)) | (1L << (NAME_OR_MATCH - 91)) | (1L << (NAME_OR_CASE - 91)) | (1L << (NAME_OR_WILDCARD - 91)) | (1L << (NAME - 91)))) != 0) );
				setState(778);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==STAR || _la==DOUBLESTAR) {
					{
					setState(777);
					star_etc();
					}
				}

				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(780);
				star_etc();
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

	public static class Slash_no_defaultContext extends org.example.antlr.common.context.ExtendContext {
		public TerminalNode SLASH() { return getToken(PythonParser.SLASH, 0); }
		public List<Param_no_defaultContext> param_no_default() {
			return getRuleContexts(Param_no_defaultContext.class);
		}
		public Param_no_defaultContext param_no_default(int i) {
			return getRuleContext(Param_no_defaultContext.class,i);
		}
		public TerminalNode COMMA() { return getToken(PythonParser.COMMA, 0); }
		public Slash_no_defaultContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_slash_no_default; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterSlash_no_default(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitSlash_no_default(this);
		}
	}

	public final Slash_no_defaultContext slash_no_default() throws RecognitionException {
		Slash_no_defaultContext _localctx = new Slash_no_defaultContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_slash_no_default);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(784); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(783);
				param_no_default();
				}
				}
				setState(786); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( ((((_la - 91)) & ~0x3f) == 0 && ((1L << (_la - 91)) & ((1L << (NAME_OR_TYPE - 91)) | (1L << (NAME_OR_MATCH - 91)) | (1L << (NAME_OR_CASE - 91)) | (1L << (NAME_OR_WILDCARD - 91)) | (1L << (NAME - 91)))) != 0) );
			setState(788);
			match(SLASH);
			setState(790);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(789);
				match(COMMA);
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

	public static class Slash_with_defaultContext extends org.example.antlr.common.context.ExtendContext {
		public TerminalNode SLASH() { return getToken(PythonParser.SLASH, 0); }
		public List<Param_no_defaultContext> param_no_default() {
			return getRuleContexts(Param_no_defaultContext.class);
		}
		public Param_no_defaultContext param_no_default(int i) {
			return getRuleContext(Param_no_defaultContext.class,i);
		}
		public List<Param_with_defaultContext> param_with_default() {
			return getRuleContexts(Param_with_defaultContext.class);
		}
		public Param_with_defaultContext param_with_default(int i) {
			return getRuleContext(Param_with_defaultContext.class,i);
		}
		public TerminalNode COMMA() { return getToken(PythonParser.COMMA, 0); }
		public Slash_with_defaultContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_slash_with_default; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterSlash_with_default(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitSlash_with_default(this);
		}
	}

	public final Slash_with_defaultContext slash_with_default() throws RecognitionException {
		Slash_with_defaultContext _localctx = new Slash_with_defaultContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_slash_with_default);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(795);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,66,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(792);
					param_no_default();
					}
					} 
				}
				setState(797);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,66,_ctx);
			}
			setState(799); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(798);
				param_with_default();
				}
				}
				setState(801); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( ((((_la - 91)) & ~0x3f) == 0 && ((1L << (_la - 91)) & ((1L << (NAME_OR_TYPE - 91)) | (1L << (NAME_OR_MATCH - 91)) | (1L << (NAME_OR_CASE - 91)) | (1L << (NAME_OR_WILDCARD - 91)) | (1L << (NAME - 91)))) != 0) );
			setState(803);
			match(SLASH);
			setState(805);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(804);
				match(COMMA);
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

	public static class Star_etcContext extends org.example.antlr.common.context.ExtendContext {
		public TerminalNode STAR() { return getToken(PythonParser.STAR, 0); }
		public Param_no_defaultContext param_no_default() {
			return getRuleContext(Param_no_defaultContext.class,0);
		}
		public List<Param_maybe_defaultContext> param_maybe_default() {
			return getRuleContexts(Param_maybe_defaultContext.class);
		}
		public Param_maybe_defaultContext param_maybe_default(int i) {
			return getRuleContext(Param_maybe_defaultContext.class,i);
		}
		public KwdsContext kwds() {
			return getRuleContext(KwdsContext.class,0);
		}
		public Param_no_default_star_annotationContext param_no_default_star_annotation() {
			return getRuleContext(Param_no_default_star_annotationContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(PythonParser.COMMA, 0); }
		public Star_etcContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_star_etc; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterStar_etc(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitStar_etc(this);
		}
	}

	public final Star_etcContext star_etc() throws RecognitionException {
		Star_etcContext _localctx = new Star_etcContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_star_etc);
		int _la;
		try {
			setState(840);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,75,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(807);
				match(STAR);
				setState(808);
				param_no_default();
				setState(812);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (((((_la - 91)) & ~0x3f) == 0 && ((1L << (_la - 91)) & ((1L << (NAME_OR_TYPE - 91)) | (1L << (NAME_OR_MATCH - 91)) | (1L << (NAME_OR_CASE - 91)) | (1L << (NAME_OR_WILDCARD - 91)) | (1L << (NAME - 91)))) != 0)) {
					{
					{
					setState(809);
					param_maybe_default();
					}
					}
					setState(814);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(816);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==DOUBLESTAR) {
					{
					setState(815);
					kwds();
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(818);
				match(STAR);
				setState(819);
				param_no_default_star_annotation();
				setState(823);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (((((_la - 91)) & ~0x3f) == 0 && ((1L << (_la - 91)) & ((1L << (NAME_OR_TYPE - 91)) | (1L << (NAME_OR_MATCH - 91)) | (1L << (NAME_OR_CASE - 91)) | (1L << (NAME_OR_WILDCARD - 91)) | (1L << (NAME - 91)))) != 0)) {
					{
					{
					setState(820);
					param_maybe_default();
					}
					}
					setState(825);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(827);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==DOUBLESTAR) {
					{
					setState(826);
					kwds();
					}
				}

				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(829);
				match(STAR);
				setState(830);
				match(COMMA);
				setState(832); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(831);
					param_maybe_default();
					}
					}
					setState(834); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( ((((_la - 91)) & ~0x3f) == 0 && ((1L << (_la - 91)) & ((1L << (NAME_OR_TYPE - 91)) | (1L << (NAME_OR_MATCH - 91)) | (1L << (NAME_OR_CASE - 91)) | (1L << (NAME_OR_WILDCARD - 91)) | (1L << (NAME - 91)))) != 0) );
				setState(837);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==DOUBLESTAR) {
					{
					setState(836);
					kwds();
					}
				}

				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(839);
				kwds();
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

	public static class KwdsContext extends org.example.antlr.common.context.ExtendContext {
		public TerminalNode DOUBLESTAR() { return getToken(PythonParser.DOUBLESTAR, 0); }
		public Param_no_defaultContext param_no_default() {
			return getRuleContext(Param_no_defaultContext.class,0);
		}
		public KwdsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_kwds; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterKwds(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitKwds(this);
		}
	}

	public final KwdsContext kwds() throws RecognitionException {
		KwdsContext _localctx = new KwdsContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_kwds);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(842);
			match(DOUBLESTAR);
			setState(843);
			param_no_default();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Param_no_defaultContext extends org.example.antlr.common.context.ExtendContext {
		public ParamContext param() {
			return getRuleContext(ParamContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(PythonParser.COMMA, 0); }
		public TerminalNode TYPE_COMMENT() { return getToken(PythonParser.TYPE_COMMENT, 0); }
		public Param_no_defaultContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param_no_default; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterParam_no_default(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitParam_no_default(this);
		}
	}

	public final Param_no_defaultContext param_no_default() throws RecognitionException {
		Param_no_defaultContext _localctx = new Param_no_defaultContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_param_no_default);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(845);
			param();
			setState(847);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(846);
				match(COMMA);
				}
			}

			setState(850);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TYPE_COMMENT) {
				{
				setState(849);
				match(TYPE_COMMENT);
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

	public static class Param_no_default_star_annotationContext extends org.example.antlr.common.context.ExtendContext {
		public Param_star_annotationContext param_star_annotation() {
			return getRuleContext(Param_star_annotationContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(PythonParser.COMMA, 0); }
		public TerminalNode TYPE_COMMENT() { return getToken(PythonParser.TYPE_COMMENT, 0); }
		public Param_no_default_star_annotationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param_no_default_star_annotation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterParam_no_default_star_annotation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitParam_no_default_star_annotation(this);
		}
	}

	public final Param_no_default_star_annotationContext param_no_default_star_annotation() throws RecognitionException {
		Param_no_default_star_annotationContext _localctx = new Param_no_default_star_annotationContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_param_no_default_star_annotation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(852);
			param_star_annotation();
			setState(854);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(853);
				match(COMMA);
				}
			}

			setState(857);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TYPE_COMMENT) {
				{
				setState(856);
				match(TYPE_COMMENT);
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

	public static class Param_with_defaultContext extends org.example.antlr.common.context.ExtendContext {
		public ParamContext param() {
			return getRuleContext(ParamContext.class,0);
		}
		public Default_assignmentContext default_assignment() {
			return getRuleContext(Default_assignmentContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(PythonParser.COMMA, 0); }
		public TerminalNode TYPE_COMMENT() { return getToken(PythonParser.TYPE_COMMENT, 0); }
		public Param_with_defaultContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param_with_default; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterParam_with_default(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitParam_with_default(this);
		}
	}

	public final Param_with_defaultContext param_with_default() throws RecognitionException {
		Param_with_defaultContext _localctx = new Param_with_defaultContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_param_with_default);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(859);
			param();
			setState(860);
			default_assignment();
			setState(862);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(861);
				match(COMMA);
				}
			}

			setState(865);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TYPE_COMMENT) {
				{
				setState(864);
				match(TYPE_COMMENT);
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

	public static class Param_maybe_defaultContext extends org.example.antlr.common.context.ExtendContext {
		public ParamContext param() {
			return getRuleContext(ParamContext.class,0);
		}
		public Default_assignmentContext default_assignment() {
			return getRuleContext(Default_assignmentContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(PythonParser.COMMA, 0); }
		public TerminalNode TYPE_COMMENT() { return getToken(PythonParser.TYPE_COMMENT, 0); }
		public Param_maybe_defaultContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param_maybe_default; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterParam_maybe_default(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitParam_maybe_default(this);
		}
	}

	public final Param_maybe_defaultContext param_maybe_default() throws RecognitionException {
		Param_maybe_defaultContext _localctx = new Param_maybe_defaultContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_param_maybe_default);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(867);
			param();
			setState(869);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EQUAL) {
				{
				setState(868);
				default_assignment();
				}
			}

			setState(872);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(871);
				match(COMMA);
				}
			}

			setState(875);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TYPE_COMMENT) {
				{
				setState(874);
				match(TYPE_COMMENT);
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

	public static class ParamContext extends org.example.antlr.common.context.ExtendContext {
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public AnnotationContext annotation() {
			return getRuleContext(AnnotationContext.class,0);
		}
		public ParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterParam(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitParam(this);
		}
	}

	public final ParamContext param() throws RecognitionException {
		ParamContext _localctx = new ParamContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_param);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(877);
			name();
			setState(879);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COLON) {
				{
				setState(878);
				annotation();
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

	public static class Param_star_annotationContext extends org.example.antlr.common.context.ExtendContext {
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public Star_annotationContext star_annotation() {
			return getRuleContext(Star_annotationContext.class,0);
		}
		public Param_star_annotationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param_star_annotation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterParam_star_annotation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitParam_star_annotation(this);
		}
	}

	public final Param_star_annotationContext param_star_annotation() throws RecognitionException {
		Param_star_annotationContext _localctx = new Param_star_annotationContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_param_star_annotation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(881);
			name();
			setState(882);
			star_annotation();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AnnotationContext extends org.example.antlr.common.context.ExtendContext {
		public TerminalNode COLON() { return getToken(PythonParser.COLON, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public AnnotationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_annotation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterAnnotation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitAnnotation(this);
		}
	}

	public final AnnotationContext annotation() throws RecognitionException {
		AnnotationContext _localctx = new AnnotationContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_annotation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(884);
			match(COLON);
			setState(885);
			expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Star_annotationContext extends org.example.antlr.common.context.ExtendContext {
		public TerminalNode COLON() { return getToken(PythonParser.COLON, 0); }
		public Star_expressionContext star_expression() {
			return getRuleContext(Star_expressionContext.class,0);
		}
		public Star_annotationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_star_annotation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterStar_annotation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitStar_annotation(this);
		}
	}

	public final Star_annotationContext star_annotation() throws RecognitionException {
		Star_annotationContext _localctx = new Star_annotationContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_star_annotation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(887);
			match(COLON);
			setState(888);
			star_expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Default_assignmentContext extends org.example.antlr.common.context.ExtendContext {
		public TerminalNode EQUAL() { return getToken(PythonParser.EQUAL, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public Default_assignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_default_assignment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterDefault_assignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitDefault_assignment(this);
		}
	}

	public final Default_assignmentContext default_assignment() throws RecognitionException {
		Default_assignmentContext _localctx = new Default_assignmentContext(_ctx, getState());
		enterRule(_localctx, 98, RULE_default_assignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(890);
			match(EQUAL);
			setState(891);
			expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class If_stmtContext extends org.example.antlr.common.context.ExtendContext {
		public TerminalNode IF() { return getToken(PythonParser.IF, 0); }
		public Named_expressionContext named_expression() {
			return getRuleContext(Named_expressionContext.class,0);
		}
		public TerminalNode COLON() { return getToken(PythonParser.COLON, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public Elif_stmtContext elif_stmt() {
			return getRuleContext(Elif_stmtContext.class,0);
		}
		public Else_blockContext else_block() {
			return getRuleContext(Else_blockContext.class,0);
		}
		public If_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_if_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterIf_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitIf_stmt(this);
		}
	}

	public final If_stmtContext if_stmt() throws RecognitionException {
		If_stmtContext _localctx = new If_stmtContext(_ctx, getState());
		enterRule(_localctx, 100, RULE_if_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(893);
			match(IF);
			setState(894);
			named_expression();
			setState(895);
			match(COLON);
			setState(896);
			block();
			setState(901);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ELIF:
				{
				setState(897);
				elif_stmt();
				}
				break;
			case EOF:
			case DEDENT:
			case FSTRING_START:
			case LPAR:
			case LSQB:
			case LBRACE:
			case PLUS:
			case MINUS:
			case STAR:
			case TILDE:
			case AT:
			case ELLIPSIS:
			case FALSE:
			case AWAIT:
			case ELSE:
			case IMPORT:
			case PASS:
			case NONE:
			case BREAK:
			case RAISE:
			case TRUE:
			case CLASS:
			case RETURN:
			case CONTINUE:
			case FOR:
			case LAMBDA:
			case TRY:
			case DEF:
			case FROM:
			case NONLOCAL:
			case WHILE:
			case ASSERT:
			case DEL:
			case GLOBAL:
			case NOT:
			case WITH:
			case ASYNC:
			case IF:
			case YIELD:
			case NAME_OR_TYPE:
			case NAME_OR_MATCH:
			case NAME_OR_CASE:
			case NAME_OR_WILDCARD:
			case NAME:
			case NUMBER:
			case STRING:
			case NEWLINE:
				{
				setState(899);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ELSE) {
					{
					setState(898);
					else_block();
					}
				}

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

	public static class Elif_stmtContext extends org.example.antlr.common.context.ExtendContext {
		public TerminalNode ELIF() { return getToken(PythonParser.ELIF, 0); }
		public Named_expressionContext named_expression() {
			return getRuleContext(Named_expressionContext.class,0);
		}
		public TerminalNode COLON() { return getToken(PythonParser.COLON, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public Elif_stmtContext elif_stmt() {
			return getRuleContext(Elif_stmtContext.class,0);
		}
		public Else_blockContext else_block() {
			return getRuleContext(Else_blockContext.class,0);
		}
		public Elif_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elif_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterElif_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitElif_stmt(this);
		}
	}

	public final Elif_stmtContext elif_stmt() throws RecognitionException {
		Elif_stmtContext _localctx = new Elif_stmtContext(_ctx, getState());
		enterRule(_localctx, 102, RULE_elif_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(903);
			match(ELIF);
			setState(904);
			named_expression();
			setState(905);
			match(COLON);
			setState(906);
			block();
			setState(911);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ELIF:
				{
				setState(907);
				elif_stmt();
				}
				break;
			case EOF:
			case DEDENT:
			case FSTRING_START:
			case LPAR:
			case LSQB:
			case LBRACE:
			case PLUS:
			case MINUS:
			case STAR:
			case TILDE:
			case AT:
			case ELLIPSIS:
			case FALSE:
			case AWAIT:
			case ELSE:
			case IMPORT:
			case PASS:
			case NONE:
			case BREAK:
			case RAISE:
			case TRUE:
			case CLASS:
			case RETURN:
			case CONTINUE:
			case FOR:
			case LAMBDA:
			case TRY:
			case DEF:
			case FROM:
			case NONLOCAL:
			case WHILE:
			case ASSERT:
			case DEL:
			case GLOBAL:
			case NOT:
			case WITH:
			case ASYNC:
			case IF:
			case YIELD:
			case NAME_OR_TYPE:
			case NAME_OR_MATCH:
			case NAME_OR_CASE:
			case NAME_OR_WILDCARD:
			case NAME:
			case NUMBER:
			case STRING:
			case NEWLINE:
				{
				setState(909);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ELSE) {
					{
					setState(908);
					else_block();
					}
				}

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

	public static class Else_blockContext extends org.example.antlr.common.context.ExtendContext {
		public TerminalNode ELSE() { return getToken(PythonParser.ELSE, 0); }
		public TerminalNode COLON() { return getToken(PythonParser.COLON, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public Else_blockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_else_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterElse_block(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitElse_block(this);
		}
	}

	public final Else_blockContext else_block() throws RecognitionException {
		Else_blockContext _localctx = new Else_blockContext(_ctx, getState());
		enterRule(_localctx, 104, RULE_else_block);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(913);
			match(ELSE);
			setState(914);
			match(COLON);
			setState(915);
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

	public static class While_stmtContext extends org.example.antlr.common.context.ExtendContext {
		public TerminalNode WHILE() { return getToken(PythonParser.WHILE, 0); }
		public Named_expressionContext named_expression() {
			return getRuleContext(Named_expressionContext.class,0);
		}
		public TerminalNode COLON() { return getToken(PythonParser.COLON, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public Else_blockContext else_block() {
			return getRuleContext(Else_blockContext.class,0);
		}
		public While_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_while_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterWhile_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitWhile_stmt(this);
		}
	}

	public final While_stmtContext while_stmt() throws RecognitionException {
		While_stmtContext _localctx = new While_stmtContext(_ctx, getState());
		enterRule(_localctx, 106, RULE_while_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(917);
			match(WHILE);
			setState(918);
			named_expression();
			setState(919);
			match(COLON);
			setState(920);
			block();
			setState(922);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(921);
				else_block();
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

	public static class For_stmtContext extends org.example.antlr.common.context.ExtendContext {
		public TerminalNode FOR() { return getToken(PythonParser.FOR, 0); }
		public Star_targetsContext star_targets() {
			return getRuleContext(Star_targetsContext.class,0);
		}
		public TerminalNode IN() { return getToken(PythonParser.IN, 0); }
		public Star_expressionsContext star_expressions() {
			return getRuleContext(Star_expressionsContext.class,0);
		}
		public TerminalNode COLON() { return getToken(PythonParser.COLON, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TerminalNode ASYNC() { return getToken(PythonParser.ASYNC, 0); }
		public TerminalNode TYPE_COMMENT() { return getToken(PythonParser.TYPE_COMMENT, 0); }
		public Else_blockContext else_block() {
			return getRuleContext(Else_blockContext.class,0);
		}
		public For_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_for_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterFor_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitFor_stmt(this);
		}
	}

	public final For_stmtContext for_stmt() throws RecognitionException {
		For_stmtContext _localctx = new For_stmtContext(_ctx, getState());
		enterRule(_localctx, 108, RULE_for_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(925);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ASYNC) {
				{
				setState(924);
				match(ASYNC);
				}
			}

			setState(927);
			match(FOR);
			setState(928);
			star_targets();
			setState(929);
			match(IN);
			setState(930);
			star_expressions();
			setState(931);
			match(COLON);
			setState(933);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TYPE_COMMENT) {
				{
				setState(932);
				match(TYPE_COMMENT);
				}
			}

			setState(935);
			block();
			setState(937);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(936);
				else_block();
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

	public static class With_stmtContext extends org.example.antlr.common.context.ExtendContext {
		public TerminalNode WITH() { return getToken(PythonParser.WITH, 0); }
		public TerminalNode LPAR() { return getToken(PythonParser.LPAR, 0); }
		public List<With_itemContext> with_item() {
			return getRuleContexts(With_itemContext.class);
		}
		public With_itemContext with_item(int i) {
			return getRuleContext(With_itemContext.class,i);
		}
		public TerminalNode RPAR() { return getToken(PythonParser.RPAR, 0); }
		public TerminalNode COLON() { return getToken(PythonParser.COLON, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public List<TerminalNode> COMMA() { return getTokens(PythonParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(PythonParser.COMMA, i);
		}
		public TerminalNode TYPE_COMMENT() { return getToken(PythonParser.TYPE_COMMENT, 0); }
		public TerminalNode ASYNC() { return getToken(PythonParser.ASYNC, 0); }
		public With_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_with_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterWith_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitWith_stmt(this);
		}
	}

	public final With_stmtContext with_stmt() throws RecognitionException {
		With_stmtContext _localctx = new With_stmtContext(_ctx, getState());
		enterRule(_localctx, 110, RULE_with_stmt);
		int _la;
		try {
			int _alt;
			setState(995);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,102,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(939);
				match(WITH);
				setState(940);
				match(LPAR);
				setState(941);
				with_item();
				setState(946);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,94,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(942);
						match(COMMA);
						setState(943);
						with_item();
						}
						} 
					}
					setState(948);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,94,_ctx);
				}
				setState(950);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(949);
					match(COMMA);
					}
				}

				setState(952);
				match(RPAR);
				setState(953);
				match(COLON);
				setState(955);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==TYPE_COMMENT) {
					{
					setState(954);
					match(TYPE_COMMENT);
					}
				}

				setState(957);
				block();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(959);
				match(ASYNC);
				setState(960);
				match(WITH);
				setState(961);
				match(LPAR);
				setState(962);
				with_item();
				setState(967);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,97,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(963);
						match(COMMA);
						setState(964);
						with_item();
						}
						} 
					}
					setState(969);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,97,_ctx);
				}
				setState(971);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(970);
					match(COMMA);
					}
				}

				setState(973);
				match(RPAR);
				setState(974);
				match(COLON);
				setState(975);
				block();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(978);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ASYNC) {
					{
					setState(977);
					match(ASYNC);
					}
				}

				setState(980);
				match(WITH);
				setState(981);
				with_item();
				setState(986);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(982);
					match(COMMA);
					setState(983);
					with_item();
					}
					}
					setState(988);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(989);
				match(COLON);
				setState(991);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==TYPE_COMMENT) {
					{
					setState(990);
					match(TYPE_COMMENT);
					}
				}

				setState(993);
				block();
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

	public static class With_itemContext extends org.example.antlr.common.context.ExtendContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode AS() { return getToken(PythonParser.AS, 0); }
		public Star_targetContext star_target() {
			return getRuleContext(Star_targetContext.class,0);
		}
		public With_itemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_with_item; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterWith_item(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitWith_item(this);
		}
	}

	public final With_itemContext with_item() throws RecognitionException {
		With_itemContext _localctx = new With_itemContext(_ctx, getState());
		enterRule(_localctx, 112, RULE_with_item);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(997);
			expression();
			setState(1000);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==AS) {
				{
				setState(998);
				match(AS);
				setState(999);
				star_target();
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

	public static class Try_stmtContext extends org.example.antlr.common.context.ExtendContext {
		public TerminalNode TRY() { return getToken(PythonParser.TRY, 0); }
		public TerminalNode COLON() { return getToken(PythonParser.COLON, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public Finally_blockContext finally_block() {
			return getRuleContext(Finally_blockContext.class,0);
		}
		public List<Except_blockContext> except_block() {
			return getRuleContexts(Except_blockContext.class);
		}
		public Except_blockContext except_block(int i) {
			return getRuleContext(Except_blockContext.class,i);
		}
		public Else_blockContext else_block() {
			return getRuleContext(Else_blockContext.class,0);
		}
		public List<Except_star_blockContext> except_star_block() {
			return getRuleContexts(Except_star_blockContext.class);
		}
		public Except_star_blockContext except_star_block(int i) {
			return getRuleContext(Except_star_blockContext.class,i);
		}
		public Try_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_try_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterTry_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitTry_stmt(this);
		}
	}

	public final Try_stmtContext try_stmt() throws RecognitionException {
		Try_stmtContext _localctx = new Try_stmtContext(_ctx, getState());
		enterRule(_localctx, 114, RULE_try_stmt);
		int _la;
		try {
			setState(1035);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,110,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1002);
				match(TRY);
				setState(1003);
				match(COLON);
				setState(1004);
				block();
				setState(1005);
				finally_block();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1007);
				match(TRY);
				setState(1008);
				match(COLON);
				setState(1009);
				block();
				setState(1011); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(1010);
					except_block();
					}
					}
					setState(1013); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==EXCEPT );
				setState(1016);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ELSE) {
					{
					setState(1015);
					else_block();
					}
				}

				setState(1019);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==FINALLY) {
					{
					setState(1018);
					finally_block();
					}
				}

				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1021);
				match(TRY);
				setState(1022);
				match(COLON);
				setState(1023);
				block();
				setState(1025); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(1024);
					except_star_block();
					}
					}
					setState(1027); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==EXCEPT );
				setState(1030);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ELSE) {
					{
					setState(1029);
					else_block();
					}
				}

				setState(1033);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==FINALLY) {
					{
					setState(1032);
					finally_block();
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

	public static class Except_blockContext extends org.example.antlr.common.context.ExtendContext {
		public TerminalNode EXCEPT() { return getToken(PythonParser.EXCEPT, 0); }
		public TerminalNode COLON() { return getToken(PythonParser.COLON, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode AS() { return getToken(PythonParser.AS, 0); }
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public Except_blockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_except_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterExcept_block(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitExcept_block(this);
		}
	}

	public final Except_blockContext except_block() throws RecognitionException {
		Except_blockContext _localctx = new Except_blockContext(_ctx, getState());
		enterRule(_localctx, 116, RULE_except_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1037);
			match(EXCEPT);
			setState(1043);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << FSTRING_START) | (1L << LPAR) | (1L << LSQB) | (1L << LBRACE) | (1L << PLUS) | (1L << MINUS) | (1L << TILDE) | (1L << ELLIPSIS) | (1L << FALSE) | (1L << AWAIT) | (1L << NONE))) != 0) || ((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & ((1L << (TRUE - 66)) | (1L << (LAMBDA - 66)) | (1L << (NOT - 66)) | (1L << (NAME_OR_TYPE - 66)) | (1L << (NAME_OR_MATCH - 66)) | (1L << (NAME_OR_CASE - 66)) | (1L << (NAME_OR_WILDCARD - 66)) | (1L << (NAME - 66)) | (1L << (NUMBER - 66)) | (1L << (STRING - 66)))) != 0)) {
				{
				setState(1038);
				expression();
				setState(1041);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==AS) {
					{
					setState(1039);
					match(AS);
					setState(1040);
					name();
					}
				}

				}
			}

			setState(1045);
			match(COLON);
			setState(1046);
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

	public static class Except_star_blockContext extends org.example.antlr.common.context.ExtendContext {
		public TerminalNode EXCEPT() { return getToken(PythonParser.EXCEPT, 0); }
		public TerminalNode STAR() { return getToken(PythonParser.STAR, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode COLON() { return getToken(PythonParser.COLON, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TerminalNode AS() { return getToken(PythonParser.AS, 0); }
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public Except_star_blockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_except_star_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterExcept_star_block(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitExcept_star_block(this);
		}
	}

	public final Except_star_blockContext except_star_block() throws RecognitionException {
		Except_star_blockContext _localctx = new Except_star_blockContext(_ctx, getState());
		enterRule(_localctx, 118, RULE_except_star_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1048);
			match(EXCEPT);
			setState(1049);
			match(STAR);
			setState(1050);
			expression();
			setState(1053);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==AS) {
				{
				setState(1051);
				match(AS);
				setState(1052);
				name();
				}
			}

			setState(1055);
			match(COLON);
			setState(1056);
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

	public static class Finally_blockContext extends org.example.antlr.common.context.ExtendContext {
		public TerminalNode FINALLY() { return getToken(PythonParser.FINALLY, 0); }
		public TerminalNode COLON() { return getToken(PythonParser.COLON, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public Finally_blockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_finally_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterFinally_block(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitFinally_block(this);
		}
	}

	public final Finally_blockContext finally_block() throws RecognitionException {
		Finally_blockContext _localctx = new Finally_blockContext(_ctx, getState());
		enterRule(_localctx, 120, RULE_finally_block);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1058);
			match(FINALLY);
			setState(1059);
			match(COLON);
			setState(1060);
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

	public static class Match_stmtContext extends org.example.antlr.common.context.ExtendContext {
		public TerminalNode NAME_OR_MATCH() { return getToken(PythonParser.NAME_OR_MATCH, 0); }
		public Subject_exprContext subject_expr() {
			return getRuleContext(Subject_exprContext.class,0);
		}
		public TerminalNode COLON() { return getToken(PythonParser.COLON, 0); }
		public TerminalNode NEWLINE() { return getToken(PythonParser.NEWLINE, 0); }
		public TerminalNode INDENT() { return getToken(PythonParser.INDENT, 0); }
		public TerminalNode DEDENT() { return getToken(PythonParser.DEDENT, 0); }
		public List<Case_blockContext> case_block() {
			return getRuleContexts(Case_blockContext.class);
		}
		public Case_blockContext case_block(int i) {
			return getRuleContext(Case_blockContext.class,i);
		}
		public Match_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_match_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterMatch_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitMatch_stmt(this);
		}
	}

	public final Match_stmtContext match_stmt() throws RecognitionException {
		Match_stmtContext _localctx = new Match_stmtContext(_ctx, getState());
		enterRule(_localctx, 122, RULE_match_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1062);
			match(NAME_OR_MATCH);
			setState(1063);
			subject_expr();
			setState(1064);
			match(COLON);
			setState(1065);
			match(NEWLINE);
			setState(1066);
			match(INDENT);
			setState(1068); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(1067);
				case_block();
				}
				}
				setState(1070); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NAME_OR_CASE );
			setState(1072);
			match(DEDENT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Subject_exprContext extends org.example.antlr.common.context.ExtendContext {
		public Star_named_expressionContext star_named_expression() {
			return getRuleContext(Star_named_expressionContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(PythonParser.COMMA, 0); }
		public Star_named_expressionsContext star_named_expressions() {
			return getRuleContext(Star_named_expressionsContext.class,0);
		}
		public Named_expressionContext named_expression() {
			return getRuleContext(Named_expressionContext.class,0);
		}
		public Subject_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_subject_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterSubject_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitSubject_expr(this);
		}
	}

	public final Subject_exprContext subject_expr() throws RecognitionException {
		Subject_exprContext _localctx = new Subject_exprContext(_ctx, getState());
		enterRule(_localctx, 124, RULE_subject_expr);
		int _la;
		try {
			setState(1080);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,116,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1074);
				star_named_expression();
				setState(1075);
				match(COMMA);
				setState(1077);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << FSTRING_START) | (1L << LPAR) | (1L << LSQB) | (1L << LBRACE) | (1L << PLUS) | (1L << MINUS) | (1L << STAR) | (1L << TILDE) | (1L << ELLIPSIS) | (1L << FALSE) | (1L << AWAIT) | (1L << NONE))) != 0) || ((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & ((1L << (TRUE - 66)) | (1L << (LAMBDA - 66)) | (1L << (NOT - 66)) | (1L << (NAME_OR_TYPE - 66)) | (1L << (NAME_OR_MATCH - 66)) | (1L << (NAME_OR_CASE - 66)) | (1L << (NAME_OR_WILDCARD - 66)) | (1L << (NAME - 66)) | (1L << (NUMBER - 66)) | (1L << (STRING - 66)))) != 0)) {
					{
					setState(1076);
					star_named_expressions();
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1079);
				named_expression();
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

	public static class Case_blockContext extends org.example.antlr.common.context.ExtendContext {
		public TerminalNode NAME_OR_CASE() { return getToken(PythonParser.NAME_OR_CASE, 0); }
		public PatternsContext patterns() {
			return getRuleContext(PatternsContext.class,0);
		}
		public TerminalNode COLON() { return getToken(PythonParser.COLON, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public GuardContext guard() {
			return getRuleContext(GuardContext.class,0);
		}
		public Case_blockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_case_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterCase_block(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitCase_block(this);
		}
	}

	public final Case_blockContext case_block() throws RecognitionException {
		Case_blockContext _localctx = new Case_blockContext(_ctx, getState());
		enterRule(_localctx, 126, RULE_case_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1082);
			match(NAME_OR_CASE);
			setState(1083);
			patterns();
			setState(1085);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IF) {
				{
				setState(1084);
				guard();
				}
			}

			setState(1087);
			match(COLON);
			setState(1088);
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

	public static class GuardContext extends org.example.antlr.common.context.ExtendContext {
		public TerminalNode IF() { return getToken(PythonParser.IF, 0); }
		public Named_expressionContext named_expression() {
			return getRuleContext(Named_expressionContext.class,0);
		}
		public GuardContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_guard; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterGuard(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitGuard(this);
		}
	}

	public final GuardContext guard() throws RecognitionException {
		GuardContext _localctx = new GuardContext(_ctx, getState());
		enterRule(_localctx, 128, RULE_guard);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1090);
			match(IF);
			setState(1091);
			named_expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PatternsContext extends org.example.antlr.common.context.ExtendContext {
		public Open_sequence_patternContext open_sequence_pattern() {
			return getRuleContext(Open_sequence_patternContext.class,0);
		}
		public PatternContext pattern() {
			return getRuleContext(PatternContext.class,0);
		}
		public PatternsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_patterns; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterPatterns(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitPatterns(this);
		}
	}

	public final PatternsContext patterns() throws RecognitionException {
		PatternsContext _localctx = new PatternsContext(_ctx, getState());
		enterRule(_localctx, 130, RULE_patterns);
		try {
			setState(1095);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,118,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1093);
				open_sequence_pattern();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1094);
				pattern();
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

	public static class PatternContext extends org.example.antlr.common.context.ExtendContext {
		public As_patternContext as_pattern() {
			return getRuleContext(As_patternContext.class,0);
		}
		public Or_patternContext or_pattern() {
			return getRuleContext(Or_patternContext.class,0);
		}
		public PatternContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pattern; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterPattern(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitPattern(this);
		}
	}

	public final PatternContext pattern() throws RecognitionException {
		PatternContext _localctx = new PatternContext(_ctx, getState());
		enterRule(_localctx, 132, RULE_pattern);
		try {
			setState(1099);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,119,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1097);
				as_pattern();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1098);
				or_pattern();
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

	public static class As_patternContext extends org.example.antlr.common.context.ExtendContext {
		public Or_patternContext or_pattern() {
			return getRuleContext(Or_patternContext.class,0);
		}
		public TerminalNode AS() { return getToken(PythonParser.AS, 0); }
		public Pattern_capture_targetContext pattern_capture_target() {
			return getRuleContext(Pattern_capture_targetContext.class,0);
		}
		public As_patternContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_as_pattern; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterAs_pattern(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitAs_pattern(this);
		}
	}

	public final As_patternContext as_pattern() throws RecognitionException {
		As_patternContext _localctx = new As_patternContext(_ctx, getState());
		enterRule(_localctx, 134, RULE_as_pattern);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1101);
			or_pattern();
			setState(1102);
			match(AS);
			setState(1103);
			pattern_capture_target();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Or_patternContext extends org.example.antlr.common.context.ExtendContext {
		public List<Closed_patternContext> closed_pattern() {
			return getRuleContexts(Closed_patternContext.class);
		}
		public Closed_patternContext closed_pattern(int i) {
			return getRuleContext(Closed_patternContext.class,i);
		}
		public List<TerminalNode> VBAR() { return getTokens(PythonParser.VBAR); }
		public TerminalNode VBAR(int i) {
			return getToken(PythonParser.VBAR, i);
		}
		public Or_patternContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_or_pattern; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterOr_pattern(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitOr_pattern(this);
		}
	}

	public final Or_patternContext or_pattern() throws RecognitionException {
		Or_patternContext _localctx = new Or_patternContext(_ctx, getState());
		enterRule(_localctx, 136, RULE_or_pattern);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1105);
			closed_pattern();
			setState(1110);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VBAR) {
				{
				{
				setState(1106);
				match(VBAR);
				setState(1107);
				closed_pattern();
				}
				}
				setState(1112);
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

	public static class Closed_patternContext extends org.example.antlr.common.context.ExtendContext {
		public Literal_patternContext literal_pattern() {
			return getRuleContext(Literal_patternContext.class,0);
		}
		public Capture_patternContext capture_pattern() {
			return getRuleContext(Capture_patternContext.class,0);
		}
		public Wildcard_patternContext wildcard_pattern() {
			return getRuleContext(Wildcard_patternContext.class,0);
		}
		public Value_patternContext value_pattern() {
			return getRuleContext(Value_patternContext.class,0);
		}
		public Group_patternContext group_pattern() {
			return getRuleContext(Group_patternContext.class,0);
		}
		public Sequence_patternContext sequence_pattern() {
			return getRuleContext(Sequence_patternContext.class,0);
		}
		public Mapping_patternContext mapping_pattern() {
			return getRuleContext(Mapping_patternContext.class,0);
		}
		public Class_patternContext class_pattern() {
			return getRuleContext(Class_patternContext.class,0);
		}
		public Closed_patternContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_closed_pattern; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterClosed_pattern(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitClosed_pattern(this);
		}
	}

	public final Closed_patternContext closed_pattern() throws RecognitionException {
		Closed_patternContext _localctx = new Closed_patternContext(_ctx, getState());
		enterRule(_localctx, 138, RULE_closed_pattern);
		try {
			setState(1121);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,121,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1113);
				literal_pattern();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1114);
				capture_pattern();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1115);
				wildcard_pattern();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1116);
				value_pattern();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(1117);
				group_pattern();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(1118);
				sequence_pattern();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(1119);
				mapping_pattern();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(1120);
				class_pattern();
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

	public static class Literal_patternContext extends org.example.antlr.common.context.ExtendContext {
		public Signed_numberContext signed_number() {
			return getRuleContext(Signed_numberContext.class,0);
		}
		public Complex_numberContext complex_number() {
			return getRuleContext(Complex_numberContext.class,0);
		}
		public StringsContext strings() {
			return getRuleContext(StringsContext.class,0);
		}
		public TerminalNode NONE() { return getToken(PythonParser.NONE, 0); }
		public TerminalNode TRUE() { return getToken(PythonParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(PythonParser.FALSE, 0); }
		public Literal_patternContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal_pattern; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterLiteral_pattern(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitLiteral_pattern(this);
		}
	}

	public final Literal_patternContext literal_pattern() throws RecognitionException {
		Literal_patternContext _localctx = new Literal_patternContext(_ctx, getState());
		enterRule(_localctx, 140, RULE_literal_pattern);
		try {
			setState(1129);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,122,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1123);
				signed_number();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1124);
				complex_number();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1125);
				strings();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1126);
				match(NONE);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(1127);
				match(TRUE);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(1128);
				match(FALSE);
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

	public static class Literal_exprContext extends org.example.antlr.common.context.ExtendContext {
		public Signed_numberContext signed_number() {
			return getRuleContext(Signed_numberContext.class,0);
		}
		public Complex_numberContext complex_number() {
			return getRuleContext(Complex_numberContext.class,0);
		}
		public StringsContext strings() {
			return getRuleContext(StringsContext.class,0);
		}
		public TerminalNode NONE() { return getToken(PythonParser.NONE, 0); }
		public TerminalNode TRUE() { return getToken(PythonParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(PythonParser.FALSE, 0); }
		public Literal_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterLiteral_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitLiteral_expr(this);
		}
	}

	public final Literal_exprContext literal_expr() throws RecognitionException {
		Literal_exprContext _localctx = new Literal_exprContext(_ctx, getState());
		enterRule(_localctx, 142, RULE_literal_expr);
		try {
			setState(1137);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,123,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1131);
				signed_number();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1132);
				complex_number();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1133);
				strings();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1134);
				match(NONE);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(1135);
				match(TRUE);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(1136);
				match(FALSE);
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

	public static class Complex_numberContext extends org.example.antlr.common.context.ExtendContext {
		public Signed_real_numberContext signed_real_number() {
			return getRuleContext(Signed_real_numberContext.class,0);
		}
		public Imaginary_numberContext imaginary_number() {
			return getRuleContext(Imaginary_numberContext.class,0);
		}
		public TerminalNode PLUS() { return getToken(PythonParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(PythonParser.MINUS, 0); }
		public Complex_numberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_complex_number; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterComplex_number(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitComplex_number(this);
		}
	}

	public final Complex_numberContext complex_number() throws RecognitionException {
		Complex_numberContext _localctx = new Complex_numberContext(_ctx, getState());
		enterRule(_localctx, 144, RULE_complex_number);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1139);
			signed_real_number();
			setState(1140);
			_la = _input.LA(1);
			if ( !(_la==PLUS || _la==MINUS) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(1141);
			imaginary_number();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Signed_numberContext extends org.example.antlr.common.context.ExtendContext {
		public TerminalNode NUMBER() { return getToken(PythonParser.NUMBER, 0); }
		public TerminalNode MINUS() { return getToken(PythonParser.MINUS, 0); }
		public Signed_numberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_signed_number; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterSigned_number(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitSigned_number(this);
		}
	}

	public final Signed_numberContext signed_number() throws RecognitionException {
		Signed_numberContext _localctx = new Signed_numberContext(_ctx, getState());
		enterRule(_localctx, 146, RULE_signed_number);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1144);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==MINUS) {
				{
				setState(1143);
				match(MINUS);
				}
			}

			setState(1146);
			match(NUMBER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Signed_real_numberContext extends org.example.antlr.common.context.ExtendContext {
		public Real_numberContext real_number() {
			return getRuleContext(Real_numberContext.class,0);
		}
		public TerminalNode MINUS() { return getToken(PythonParser.MINUS, 0); }
		public Signed_real_numberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_signed_real_number; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterSigned_real_number(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitSigned_real_number(this);
		}
	}

	public final Signed_real_numberContext signed_real_number() throws RecognitionException {
		Signed_real_numberContext _localctx = new Signed_real_numberContext(_ctx, getState());
		enterRule(_localctx, 148, RULE_signed_real_number);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1149);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==MINUS) {
				{
				setState(1148);
				match(MINUS);
				}
			}

			setState(1151);
			real_number();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Real_numberContext extends org.example.antlr.common.context.ExtendContext {
		public TerminalNode NUMBER() { return getToken(PythonParser.NUMBER, 0); }
		public Real_numberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_real_number; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterReal_number(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitReal_number(this);
		}
	}

	public final Real_numberContext real_number() throws RecognitionException {
		Real_numberContext _localctx = new Real_numberContext(_ctx, getState());
		enterRule(_localctx, 150, RULE_real_number);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1153);
			match(NUMBER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Imaginary_numberContext extends org.example.antlr.common.context.ExtendContext {
		public TerminalNode NUMBER() { return getToken(PythonParser.NUMBER, 0); }
		public Imaginary_numberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_imaginary_number; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterImaginary_number(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitImaginary_number(this);
		}
	}

	public final Imaginary_numberContext imaginary_number() throws RecognitionException {
		Imaginary_numberContext _localctx = new Imaginary_numberContext(_ctx, getState());
		enterRule(_localctx, 152, RULE_imaginary_number);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1155);
			match(NUMBER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Capture_patternContext extends org.example.antlr.common.context.ExtendContext {
		public Pattern_capture_targetContext pattern_capture_target() {
			return getRuleContext(Pattern_capture_targetContext.class,0);
		}
		public Capture_patternContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_capture_pattern; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterCapture_pattern(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitCapture_pattern(this);
		}
	}

	public final Capture_patternContext capture_pattern() throws RecognitionException {
		Capture_patternContext _localctx = new Capture_patternContext(_ctx, getState());
		enterRule(_localctx, 154, RULE_capture_pattern);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1157);
			pattern_capture_target();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Pattern_capture_targetContext extends org.example.antlr.common.context.ExtendContext {
		public Name_except_underscoreContext name_except_underscore() {
			return getRuleContext(Name_except_underscoreContext.class,0);
		}
		public Pattern_capture_targetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pattern_capture_target; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterPattern_capture_target(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitPattern_capture_target(this);
		}
	}

	public final Pattern_capture_targetContext pattern_capture_target() throws RecognitionException {
		Pattern_capture_targetContext _localctx = new Pattern_capture_targetContext(_ctx, getState());
		enterRule(_localctx, 156, RULE_pattern_capture_target);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1159);
			name_except_underscore();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Wildcard_patternContext extends org.example.antlr.common.context.ExtendContext {
		public TerminalNode NAME_OR_WILDCARD() { return getToken(PythonParser.NAME_OR_WILDCARD, 0); }
		public Wildcard_patternContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_wildcard_pattern; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterWildcard_pattern(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitWildcard_pattern(this);
		}
	}

	public final Wildcard_patternContext wildcard_pattern() throws RecognitionException {
		Wildcard_patternContext _localctx = new Wildcard_patternContext(_ctx, getState());
		enterRule(_localctx, 158, RULE_wildcard_pattern);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1161);
			match(NAME_OR_WILDCARD);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Value_patternContext extends org.example.antlr.common.context.ExtendContext {
		public AttrContext attr() {
			return getRuleContext(AttrContext.class,0);
		}
		public Value_patternContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value_pattern; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterValue_pattern(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitValue_pattern(this);
		}
	}

	public final Value_patternContext value_pattern() throws RecognitionException {
		Value_patternContext _localctx = new Value_patternContext(_ctx, getState());
		enterRule(_localctx, 160, RULE_value_pattern);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1163);
			attr();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AttrContext extends org.example.antlr.common.context.ExtendContext {
		public List<NameContext> name() {
			return getRuleContexts(NameContext.class);
		}
		public NameContext name(int i) {
			return getRuleContext(NameContext.class,i);
		}
		public List<TerminalNode> DOT() { return getTokens(PythonParser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(PythonParser.DOT, i);
		}
		public AttrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterAttr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitAttr(this);
		}
	}

	public final AttrContext attr() throws RecognitionException {
		AttrContext _localctx = new AttrContext(_ctx, getState());
		enterRule(_localctx, 162, RULE_attr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1165);
			name();
			setState(1168); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(1166);
				match(DOT);
				setState(1167);
				name();
				}
				}
				setState(1170); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==DOT );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Name_or_attrContext extends org.example.antlr.common.context.ExtendContext {
		public List<NameContext> name() {
			return getRuleContexts(NameContext.class);
		}
		public NameContext name(int i) {
			return getRuleContext(NameContext.class,i);
		}
		public List<TerminalNode> DOT() { return getTokens(PythonParser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(PythonParser.DOT, i);
		}
		public Name_or_attrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_name_or_attr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterName_or_attr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitName_or_attr(this);
		}
	}

	public final Name_or_attrContext name_or_attr() throws RecognitionException {
		Name_or_attrContext _localctx = new Name_or_attrContext(_ctx, getState());
		enterRule(_localctx, 164, RULE_name_or_attr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1172);
			name();
			setState(1177);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DOT) {
				{
				{
				setState(1173);
				match(DOT);
				setState(1174);
				name();
				}
				}
				setState(1179);
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

	public static class Group_patternContext extends org.example.antlr.common.context.ExtendContext {
		public TerminalNode LPAR() { return getToken(PythonParser.LPAR, 0); }
		public PatternContext pattern() {
			return getRuleContext(PatternContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(PythonParser.RPAR, 0); }
		public Group_patternContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_group_pattern; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterGroup_pattern(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitGroup_pattern(this);
		}
	}

	public final Group_patternContext group_pattern() throws RecognitionException {
		Group_patternContext _localctx = new Group_patternContext(_ctx, getState());
		enterRule(_localctx, 166, RULE_group_pattern);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1180);
			match(LPAR);
			setState(1181);
			pattern();
			setState(1182);
			match(RPAR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Sequence_patternContext extends org.example.antlr.common.context.ExtendContext {
		public TerminalNode LSQB() { return getToken(PythonParser.LSQB, 0); }
		public TerminalNode RSQB() { return getToken(PythonParser.RSQB, 0); }
		public Maybe_sequence_patternContext maybe_sequence_pattern() {
			return getRuleContext(Maybe_sequence_patternContext.class,0);
		}
		public TerminalNode LPAR() { return getToken(PythonParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(PythonParser.RPAR, 0); }
		public Open_sequence_patternContext open_sequence_pattern() {
			return getRuleContext(Open_sequence_patternContext.class,0);
		}
		public Sequence_patternContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sequence_pattern; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterSequence_pattern(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitSequence_pattern(this);
		}
	}

	public final Sequence_patternContext sequence_pattern() throws RecognitionException {
		Sequence_patternContext _localctx = new Sequence_patternContext(_ctx, getState());
		enterRule(_localctx, 168, RULE_sequence_pattern);
		int _la;
		try {
			setState(1194);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LSQB:
				enterOuterAlt(_localctx, 1);
				{
				setState(1184);
				match(LSQB);
				setState(1186);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << FSTRING_START) | (1L << LPAR) | (1L << LSQB) | (1L << LBRACE) | (1L << MINUS) | (1L << STAR) | (1L << FALSE) | (1L << NONE))) != 0) || ((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & ((1L << (TRUE - 66)) | (1L << (NAME_OR_TYPE - 66)) | (1L << (NAME_OR_MATCH - 66)) | (1L << (NAME_OR_CASE - 66)) | (1L << (NAME_OR_WILDCARD - 66)) | (1L << (NAME - 66)) | (1L << (NUMBER - 66)) | (1L << (STRING - 66)))) != 0)) {
					{
					setState(1185);
					maybe_sequence_pattern();
					}
				}

				setState(1188);
				match(RSQB);
				}
				break;
			case LPAR:
				enterOuterAlt(_localctx, 2);
				{
				setState(1189);
				match(LPAR);
				setState(1191);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << FSTRING_START) | (1L << LPAR) | (1L << LSQB) | (1L << LBRACE) | (1L << MINUS) | (1L << STAR) | (1L << FALSE) | (1L << NONE))) != 0) || ((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & ((1L << (TRUE - 66)) | (1L << (NAME_OR_TYPE - 66)) | (1L << (NAME_OR_MATCH - 66)) | (1L << (NAME_OR_CASE - 66)) | (1L << (NAME_OR_WILDCARD - 66)) | (1L << (NAME - 66)) | (1L << (NUMBER - 66)) | (1L << (STRING - 66)))) != 0)) {
					{
					setState(1190);
					open_sequence_pattern();
					}
				}

				setState(1193);
				match(RPAR);
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

	public static class Open_sequence_patternContext extends org.example.antlr.common.context.ExtendContext {
		public Maybe_star_patternContext maybe_star_pattern() {
			return getRuleContext(Maybe_star_patternContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(PythonParser.COMMA, 0); }
		public Maybe_sequence_patternContext maybe_sequence_pattern() {
			return getRuleContext(Maybe_sequence_patternContext.class,0);
		}
		public Open_sequence_patternContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_open_sequence_pattern; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterOpen_sequence_pattern(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitOpen_sequence_pattern(this);
		}
	}

	public final Open_sequence_patternContext open_sequence_pattern() throws RecognitionException {
		Open_sequence_patternContext _localctx = new Open_sequence_patternContext(_ctx, getState());
		enterRule(_localctx, 170, RULE_open_sequence_pattern);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1196);
			maybe_star_pattern();
			setState(1197);
			match(COMMA);
			setState(1199);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << FSTRING_START) | (1L << LPAR) | (1L << LSQB) | (1L << LBRACE) | (1L << MINUS) | (1L << STAR) | (1L << FALSE) | (1L << NONE))) != 0) || ((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & ((1L << (TRUE - 66)) | (1L << (NAME_OR_TYPE - 66)) | (1L << (NAME_OR_MATCH - 66)) | (1L << (NAME_OR_CASE - 66)) | (1L << (NAME_OR_WILDCARD - 66)) | (1L << (NAME - 66)) | (1L << (NUMBER - 66)) | (1L << (STRING - 66)))) != 0)) {
				{
				setState(1198);
				maybe_sequence_pattern();
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

	public static class Maybe_sequence_patternContext extends org.example.antlr.common.context.ExtendContext {
		public List<Maybe_star_patternContext> maybe_star_pattern() {
			return getRuleContexts(Maybe_star_patternContext.class);
		}
		public Maybe_star_patternContext maybe_star_pattern(int i) {
			return getRuleContext(Maybe_star_patternContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(PythonParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(PythonParser.COMMA, i);
		}
		public Maybe_sequence_patternContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_maybe_sequence_pattern; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterMaybe_sequence_pattern(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitMaybe_sequence_pattern(this);
		}
	}

	public final Maybe_sequence_patternContext maybe_sequence_pattern() throws RecognitionException {
		Maybe_sequence_patternContext _localctx = new Maybe_sequence_patternContext(_ctx, getState());
		enterRule(_localctx, 172, RULE_maybe_sequence_pattern);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1201);
			maybe_star_pattern();
			setState(1206);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,132,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1202);
					match(COMMA);
					setState(1203);
					maybe_star_pattern();
					}
					} 
				}
				setState(1208);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,132,_ctx);
			}
			setState(1210);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(1209);
				match(COMMA);
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

	public static class Maybe_star_patternContext extends org.example.antlr.common.context.ExtendContext {
		public Star_patternContext star_pattern() {
			return getRuleContext(Star_patternContext.class,0);
		}
		public PatternContext pattern() {
			return getRuleContext(PatternContext.class,0);
		}
		public Maybe_star_patternContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_maybe_star_pattern; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterMaybe_star_pattern(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitMaybe_star_pattern(this);
		}
	}

	public final Maybe_star_patternContext maybe_star_pattern() throws RecognitionException {
		Maybe_star_patternContext _localctx = new Maybe_star_patternContext(_ctx, getState());
		enterRule(_localctx, 174, RULE_maybe_star_pattern);
		try {
			setState(1214);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STAR:
				enterOuterAlt(_localctx, 1);
				{
				setState(1212);
				star_pattern();
				}
				break;
			case FSTRING_START:
			case LPAR:
			case LSQB:
			case LBRACE:
			case MINUS:
			case FALSE:
			case NONE:
			case TRUE:
			case NAME_OR_TYPE:
			case NAME_OR_MATCH:
			case NAME_OR_CASE:
			case NAME_OR_WILDCARD:
			case NAME:
			case NUMBER:
			case STRING:
				enterOuterAlt(_localctx, 2);
				{
				setState(1213);
				pattern();
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

	public static class Star_patternContext extends org.example.antlr.common.context.ExtendContext {
		public TerminalNode STAR() { return getToken(PythonParser.STAR, 0); }
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public Star_patternContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_star_pattern; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterStar_pattern(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitStar_pattern(this);
		}
	}

	public final Star_patternContext star_pattern() throws RecognitionException {
		Star_patternContext _localctx = new Star_patternContext(_ctx, getState());
		enterRule(_localctx, 176, RULE_star_pattern);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1216);
			match(STAR);
			setState(1217);
			name();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Mapping_patternContext extends org.example.antlr.common.context.ExtendContext {
		public TerminalNode LBRACE() { return getToken(PythonParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(PythonParser.RBRACE, 0); }
		public Double_star_patternContext double_star_pattern() {
			return getRuleContext(Double_star_patternContext.class,0);
		}
		public List<TerminalNode> COMMA() { return getTokens(PythonParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(PythonParser.COMMA, i);
		}
		public Items_patternContext items_pattern() {
			return getRuleContext(Items_patternContext.class,0);
		}
		public Mapping_patternContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mapping_pattern; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterMapping_pattern(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitMapping_pattern(this);
		}
	}

	public final Mapping_patternContext mapping_pattern() throws RecognitionException {
		Mapping_patternContext _localctx = new Mapping_patternContext(_ctx, getState());
		enterRule(_localctx, 178, RULE_mapping_pattern);
		int _la;
		try {
			setState(1239);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,138,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1219);
				match(LBRACE);
				setState(1220);
				match(RBRACE);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1221);
				match(LBRACE);
				setState(1222);
				double_star_pattern();
				setState(1224);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(1223);
					match(COMMA);
					}
				}

				setState(1226);
				match(RBRACE);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1228);
				match(LBRACE);
				setState(1229);
				items_pattern();
				setState(1232);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,136,_ctx) ) {
				case 1:
					{
					setState(1230);
					match(COMMA);
					setState(1231);
					double_star_pattern();
					}
					break;
				}
				setState(1235);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(1234);
					match(COMMA);
					}
				}

				setState(1237);
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

	public static class Items_patternContext extends org.example.antlr.common.context.ExtendContext {
		public List<Key_value_patternContext> key_value_pattern() {
			return getRuleContexts(Key_value_patternContext.class);
		}
		public Key_value_patternContext key_value_pattern(int i) {
			return getRuleContext(Key_value_patternContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(PythonParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(PythonParser.COMMA, i);
		}
		public Items_patternContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_items_pattern; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterItems_pattern(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitItems_pattern(this);
		}
	}

	public final Items_patternContext items_pattern() throws RecognitionException {
		Items_patternContext _localctx = new Items_patternContext(_ctx, getState());
		enterRule(_localctx, 180, RULE_items_pattern);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1241);
			key_value_pattern();
			setState(1246);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,139,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1242);
					match(COMMA);
					setState(1243);
					key_value_pattern();
					}
					} 
				}
				setState(1248);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,139,_ctx);
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

	public static class Key_value_patternContext extends org.example.antlr.common.context.ExtendContext {
		public TerminalNode COLON() { return getToken(PythonParser.COLON, 0); }
		public PatternContext pattern() {
			return getRuleContext(PatternContext.class,0);
		}
		public Literal_exprContext literal_expr() {
			return getRuleContext(Literal_exprContext.class,0);
		}
		public AttrContext attr() {
			return getRuleContext(AttrContext.class,0);
		}
		public Key_value_patternContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_key_value_pattern; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterKey_value_pattern(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitKey_value_pattern(this);
		}
	}

	public final Key_value_patternContext key_value_pattern() throws RecognitionException {
		Key_value_patternContext _localctx = new Key_value_patternContext(_ctx, getState());
		enterRule(_localctx, 182, RULE_key_value_pattern);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1251);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FSTRING_START:
			case MINUS:
			case FALSE:
			case NONE:
			case TRUE:
			case NUMBER:
			case STRING:
				{
				setState(1249);
				literal_expr();
				}
				break;
			case NAME_OR_TYPE:
			case NAME_OR_MATCH:
			case NAME_OR_CASE:
			case NAME_OR_WILDCARD:
			case NAME:
				{
				setState(1250);
				attr();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(1253);
			match(COLON);
			setState(1254);
			pattern();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Double_star_patternContext extends org.example.antlr.common.context.ExtendContext {
		public TerminalNode DOUBLESTAR() { return getToken(PythonParser.DOUBLESTAR, 0); }
		public Pattern_capture_targetContext pattern_capture_target() {
			return getRuleContext(Pattern_capture_targetContext.class,0);
		}
		public Double_star_patternContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_double_star_pattern; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterDouble_star_pattern(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitDouble_star_pattern(this);
		}
	}

	public final Double_star_patternContext double_star_pattern() throws RecognitionException {
		Double_star_patternContext _localctx = new Double_star_patternContext(_ctx, getState());
		enterRule(_localctx, 184, RULE_double_star_pattern);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1256);
			match(DOUBLESTAR);
			setState(1257);
			pattern_capture_target();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Class_patternContext extends org.example.antlr.common.context.ExtendContext {
		public Name_or_attrContext name_or_attr() {
			return getRuleContext(Name_or_attrContext.class,0);
		}
		public TerminalNode LPAR() { return getToken(PythonParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(PythonParser.RPAR, 0); }
		public Positional_patternsContext positional_patterns() {
			return getRuleContext(Positional_patternsContext.class,0);
		}
		public Keyword_patternsContext keyword_patterns() {
			return getRuleContext(Keyword_patternsContext.class,0);
		}
		public List<TerminalNode> COMMA() { return getTokens(PythonParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(PythonParser.COMMA, i);
		}
		public Class_patternContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_class_pattern; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterClass_pattern(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitClass_pattern(this);
		}
	}

	public final Class_patternContext class_pattern() throws RecognitionException {
		Class_patternContext _localctx = new Class_patternContext(_ctx, getState());
		enterRule(_localctx, 186, RULE_class_pattern);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1259);
			name_or_attr();
			setState(1260);
			match(LPAR);
			setState(1272);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << FSTRING_START) | (1L << LPAR) | (1L << LSQB) | (1L << LBRACE) | (1L << MINUS) | (1L << FALSE) | (1L << NONE))) != 0) || ((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & ((1L << (TRUE - 66)) | (1L << (NAME_OR_TYPE - 66)) | (1L << (NAME_OR_MATCH - 66)) | (1L << (NAME_OR_CASE - 66)) | (1L << (NAME_OR_WILDCARD - 66)) | (1L << (NAME - 66)) | (1L << (NUMBER - 66)) | (1L << (STRING - 66)))) != 0)) {
				{
				setState(1267);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,142,_ctx) ) {
				case 1:
					{
					setState(1261);
					positional_patterns();
					setState(1264);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,141,_ctx) ) {
					case 1:
						{
						setState(1262);
						match(COMMA);
						setState(1263);
						keyword_patterns();
						}
						break;
					}
					}
					break;
				case 2:
					{
					setState(1266);
					keyword_patterns();
					}
					break;
				}
				setState(1270);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(1269);
					match(COMMA);
					}
				}

				}
			}

			setState(1274);
			match(RPAR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Positional_patternsContext extends org.example.antlr.common.context.ExtendContext {
		public List<PatternContext> pattern() {
			return getRuleContexts(PatternContext.class);
		}
		public PatternContext pattern(int i) {
			return getRuleContext(PatternContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(PythonParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(PythonParser.COMMA, i);
		}
		public Positional_patternsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_positional_patterns; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterPositional_patterns(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitPositional_patterns(this);
		}
	}

	public final Positional_patternsContext positional_patterns() throws RecognitionException {
		Positional_patternsContext _localctx = new Positional_patternsContext(_ctx, getState());
		enterRule(_localctx, 188, RULE_positional_patterns);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1276);
			pattern();
			setState(1281);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,145,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1277);
					match(COMMA);
					setState(1278);
					pattern();
					}
					} 
				}
				setState(1283);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,145,_ctx);
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

	public static class Keyword_patternsContext extends org.example.antlr.common.context.ExtendContext {
		public List<Keyword_patternContext> keyword_pattern() {
			return getRuleContexts(Keyword_patternContext.class);
		}
		public Keyword_patternContext keyword_pattern(int i) {
			return getRuleContext(Keyword_patternContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(PythonParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(PythonParser.COMMA, i);
		}
		public Keyword_patternsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keyword_patterns; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterKeyword_patterns(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitKeyword_patterns(this);
		}
	}

	public final Keyword_patternsContext keyword_patterns() throws RecognitionException {
		Keyword_patternsContext _localctx = new Keyword_patternsContext(_ctx, getState());
		enterRule(_localctx, 190, RULE_keyword_patterns);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1284);
			keyword_pattern();
			setState(1289);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,146,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1285);
					match(COMMA);
					setState(1286);
					keyword_pattern();
					}
					} 
				}
				setState(1291);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,146,_ctx);
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

	public static class Keyword_patternContext extends org.example.antlr.common.context.ExtendContext {
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public TerminalNode EQUAL() { return getToken(PythonParser.EQUAL, 0); }
		public PatternContext pattern() {
			return getRuleContext(PatternContext.class,0);
		}
		public Keyword_patternContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keyword_pattern; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterKeyword_pattern(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitKeyword_pattern(this);
		}
	}

	public final Keyword_patternContext keyword_pattern() throws RecognitionException {
		Keyword_patternContext _localctx = new Keyword_patternContext(_ctx, getState());
		enterRule(_localctx, 192, RULE_keyword_pattern);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1292);
			name();
			setState(1293);
			match(EQUAL);
			setState(1294);
			pattern();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Type_aliasContext extends org.example.antlr.common.context.ExtendContext {
		public TerminalNode NAME_OR_TYPE() { return getToken(PythonParser.NAME_OR_TYPE, 0); }
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public TerminalNode EQUAL() { return getToken(PythonParser.EQUAL, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public Type_paramsContext type_params() {
			return getRuleContext(Type_paramsContext.class,0);
		}
		public Type_aliasContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type_alias; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterType_alias(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitType_alias(this);
		}
	}

	public final Type_aliasContext type_alias() throws RecognitionException {
		Type_aliasContext _localctx = new Type_aliasContext(_ctx, getState());
		enterRule(_localctx, 194, RULE_type_alias);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1296);
			match(NAME_OR_TYPE);
			setState(1297);
			name();
			setState(1299);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LSQB) {
				{
				setState(1298);
				type_params();
				}
			}

			setState(1301);
			match(EQUAL);
			setState(1302);
			expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Type_paramsContext extends org.example.antlr.common.context.ExtendContext {
		public TerminalNode LSQB() { return getToken(PythonParser.LSQB, 0); }
		public Type_param_seqContext type_param_seq() {
			return getRuleContext(Type_param_seqContext.class,0);
		}
		public TerminalNode RSQB() { return getToken(PythonParser.RSQB, 0); }
		public Type_paramsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type_params; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterType_params(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitType_params(this);
		}
	}

	public final Type_paramsContext type_params() throws RecognitionException {
		Type_paramsContext _localctx = new Type_paramsContext(_ctx, getState());
		enterRule(_localctx, 196, RULE_type_params);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1304);
			match(LSQB);
			setState(1305);
			type_param_seq();
			setState(1306);
			match(RSQB);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Type_param_seqContext extends org.example.antlr.common.context.ExtendContext {
		public List<Type_paramContext> type_param() {
			return getRuleContexts(Type_paramContext.class);
		}
		public Type_paramContext type_param(int i) {
			return getRuleContext(Type_paramContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(PythonParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(PythonParser.COMMA, i);
		}
		public Type_param_seqContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type_param_seq; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterType_param_seq(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitType_param_seq(this);
		}
	}

	public final Type_param_seqContext type_param_seq() throws RecognitionException {
		Type_param_seqContext _localctx = new Type_param_seqContext(_ctx, getState());
		enterRule(_localctx, 198, RULE_type_param_seq);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1308);
			type_param();
			setState(1313);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,148,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1309);
					match(COMMA);
					setState(1310);
					type_param();
					}
					} 
				}
				setState(1315);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,148,_ctx);
			}
			setState(1317);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(1316);
				match(COMMA);
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

	public static class Type_paramContext extends org.example.antlr.common.context.ExtendContext {
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public Type_param_boundContext type_param_bound() {
			return getRuleContext(Type_param_boundContext.class,0);
		}
		public Type_param_defaultContext type_param_default() {
			return getRuleContext(Type_param_defaultContext.class,0);
		}
		public TerminalNode STAR() { return getToken(PythonParser.STAR, 0); }
		public Type_param_starred_defaultContext type_param_starred_default() {
			return getRuleContext(Type_param_starred_defaultContext.class,0);
		}
		public TerminalNode DOUBLESTAR() { return getToken(PythonParser.DOUBLESTAR, 0); }
		public Type_paramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type_param; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterType_param(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitType_param(this);
		}
	}

	public final Type_paramContext type_param() throws RecognitionException {
		Type_paramContext _localctx = new Type_paramContext(_ctx, getState());
		enterRule(_localctx, 200, RULE_type_param);
		int _la;
		try {
			setState(1336);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NAME_OR_TYPE:
			case NAME_OR_MATCH:
			case NAME_OR_CASE:
			case NAME_OR_WILDCARD:
			case NAME:
				enterOuterAlt(_localctx, 1);
				{
				setState(1319);
				name();
				setState(1321);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COLON) {
					{
					setState(1320);
					type_param_bound();
					}
				}

				setState(1324);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==EQUAL) {
					{
					setState(1323);
					type_param_default();
					}
				}

				}
				break;
			case STAR:
				enterOuterAlt(_localctx, 2);
				{
				setState(1326);
				match(STAR);
				setState(1327);
				name();
				setState(1329);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==EQUAL) {
					{
					setState(1328);
					type_param_starred_default();
					}
				}

				}
				break;
			case DOUBLESTAR:
				enterOuterAlt(_localctx, 3);
				{
				setState(1331);
				match(DOUBLESTAR);
				setState(1332);
				name();
				setState(1334);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==EQUAL) {
					{
					setState(1333);
					type_param_default();
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

	public static class Type_param_boundContext extends org.example.antlr.common.context.ExtendContext {
		public TerminalNode COLON() { return getToken(PythonParser.COLON, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public Type_param_boundContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type_param_bound; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterType_param_bound(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitType_param_bound(this);
		}
	}

	public final Type_param_boundContext type_param_bound() throws RecognitionException {
		Type_param_boundContext _localctx = new Type_param_boundContext(_ctx, getState());
		enterRule(_localctx, 202, RULE_type_param_bound);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1338);
			match(COLON);
			setState(1339);
			expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Type_param_defaultContext extends org.example.antlr.common.context.ExtendContext {
		public TerminalNode EQUAL() { return getToken(PythonParser.EQUAL, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public Type_param_defaultContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type_param_default; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterType_param_default(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitType_param_default(this);
		}
	}

	public final Type_param_defaultContext type_param_default() throws RecognitionException {
		Type_param_defaultContext _localctx = new Type_param_defaultContext(_ctx, getState());
		enterRule(_localctx, 204, RULE_type_param_default);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1341);
			match(EQUAL);
			setState(1342);
			expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Type_param_starred_defaultContext extends org.example.antlr.common.context.ExtendContext {
		public TerminalNode EQUAL() { return getToken(PythonParser.EQUAL, 0); }
		public Star_expressionContext star_expression() {
			return getRuleContext(Star_expressionContext.class,0);
		}
		public Type_param_starred_defaultContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type_param_starred_default; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterType_param_starred_default(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitType_param_starred_default(this);
		}
	}

	public final Type_param_starred_defaultContext type_param_starred_default() throws RecognitionException {
		Type_param_starred_defaultContext _localctx = new Type_param_starred_defaultContext(_ctx, getState());
		enterRule(_localctx, 206, RULE_type_param_starred_default);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1344);
			match(EQUAL);
			setState(1345);
			star_expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionsContext extends org.example.antlr.common.context.ExtendContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(PythonParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(PythonParser.COMMA, i);
		}
		public ExpressionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressions; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterExpressions(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitExpressions(this);
		}
	}

	public final ExpressionsContext expressions() throws RecognitionException {
		ExpressionsContext _localctx = new ExpressionsContext(_ctx, getState());
		enterRule(_localctx, 208, RULE_expressions);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1347);
			expression();
			setState(1352);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,155,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1348);
					match(COMMA);
					setState(1349);
					expression();
					}
					} 
				}
				setState(1354);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,155,_ctx);
			}
			setState(1356);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(1355);
				match(COMMA);
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

	public static class ExpressionContext extends org.example.antlr.common.context.ExtendContext {
		public List<DisjunctionContext> disjunction() {
			return getRuleContexts(DisjunctionContext.class);
		}
		public DisjunctionContext disjunction(int i) {
			return getRuleContext(DisjunctionContext.class,i);
		}
		public TerminalNode IF() { return getToken(PythonParser.IF, 0); }
		public TerminalNode ELSE() { return getToken(PythonParser.ELSE, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public LambdefContext lambdef() {
			return getRuleContext(LambdefContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitExpression(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 210, RULE_expression);
		int _la;
		try {
			setState(1367);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FSTRING_START:
			case LPAR:
			case LSQB:
			case LBRACE:
			case PLUS:
			case MINUS:
			case TILDE:
			case ELLIPSIS:
			case FALSE:
			case AWAIT:
			case NONE:
			case TRUE:
			case NOT:
			case NAME_OR_TYPE:
			case NAME_OR_MATCH:
			case NAME_OR_CASE:
			case NAME_OR_WILDCARD:
			case NAME:
			case NUMBER:
			case STRING:
				enterOuterAlt(_localctx, 1);
				{
				setState(1358);
				disjunction();
				setState(1364);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IF) {
					{
					setState(1359);
					match(IF);
					setState(1360);
					disjunction();
					setState(1361);
					match(ELSE);
					setState(1362);
					expression();
					}
				}

				}
				break;
			case LAMBDA:
				enterOuterAlt(_localctx, 2);
				{
				setState(1366);
				lambdef();
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

	public static class Yield_exprContext extends org.example.antlr.common.context.ExtendContext {
		public TerminalNode YIELD() { return getToken(PythonParser.YIELD, 0); }
		public TerminalNode FROM() { return getToken(PythonParser.FROM, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public Star_expressionsContext star_expressions() {
			return getRuleContext(Star_expressionsContext.class,0);
		}
		public Yield_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_yield_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterYield_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitYield_expr(this);
		}
	}

	public final Yield_exprContext yield_expr() throws RecognitionException {
		Yield_exprContext _localctx = new Yield_exprContext(_ctx, getState());
		enterRule(_localctx, 212, RULE_yield_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1369);
			match(YIELD);
			setState(1375);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FROM:
				{
				setState(1370);
				match(FROM);
				setState(1371);
				expression();
				}
				break;
			case TYPE_COMMENT:
			case FSTRING_START:
			case LPAR:
			case LSQB:
			case LBRACE:
			case RPAR:
			case RBRACE:
			case COLON:
			case SEMI:
			case PLUS:
			case MINUS:
			case STAR:
			case EQUAL:
			case TILDE:
			case ELLIPSIS:
			case EXCLAMATION:
			case FALSE:
			case AWAIT:
			case NONE:
			case TRUE:
			case LAMBDA:
			case NOT:
			case NAME_OR_TYPE:
			case NAME_OR_MATCH:
			case NAME_OR_CASE:
			case NAME_OR_WILDCARD:
			case NAME:
			case NUMBER:
			case STRING:
			case NEWLINE:
				{
				setState(1373);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << FSTRING_START) | (1L << LPAR) | (1L << LSQB) | (1L << LBRACE) | (1L << PLUS) | (1L << MINUS) | (1L << STAR) | (1L << TILDE) | (1L << ELLIPSIS) | (1L << FALSE) | (1L << AWAIT) | (1L << NONE))) != 0) || ((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & ((1L << (TRUE - 66)) | (1L << (LAMBDA - 66)) | (1L << (NOT - 66)) | (1L << (NAME_OR_TYPE - 66)) | (1L << (NAME_OR_MATCH - 66)) | (1L << (NAME_OR_CASE - 66)) | (1L << (NAME_OR_WILDCARD - 66)) | (1L << (NAME - 66)) | (1L << (NUMBER - 66)) | (1L << (STRING - 66)))) != 0)) {
					{
					setState(1372);
					star_expressions();
					}
				}

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

	public static class Star_expressionsContext extends org.example.antlr.common.context.ExtendContext {
		public List<Star_expressionContext> star_expression() {
			return getRuleContexts(Star_expressionContext.class);
		}
		public Star_expressionContext star_expression(int i) {
			return getRuleContext(Star_expressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(PythonParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(PythonParser.COMMA, i);
		}
		public Star_expressionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_star_expressions; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterStar_expressions(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitStar_expressions(this);
		}
	}

	public final Star_expressionsContext star_expressions() throws RecognitionException {
		Star_expressionsContext _localctx = new Star_expressionsContext(_ctx, getState());
		enterRule(_localctx, 214, RULE_star_expressions);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1377);
			star_expression();
			setState(1382);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,161,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1378);
					match(COMMA);
					setState(1379);
					star_expression();
					}
					} 
				}
				setState(1384);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,161,_ctx);
			}
			setState(1386);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(1385);
				match(COMMA);
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

	public static class Star_expressionContext extends org.example.antlr.common.context.ExtendContext {
		public TerminalNode STAR() { return getToken(PythonParser.STAR, 0); }
		public Bitwise_orContext bitwise_or() {
			return getRuleContext(Bitwise_orContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public Star_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_star_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterStar_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitStar_expression(this);
		}
	}

	public final Star_expressionContext star_expression() throws RecognitionException {
		Star_expressionContext _localctx = new Star_expressionContext(_ctx, getState());
		enterRule(_localctx, 216, RULE_star_expression);
		try {
			setState(1391);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STAR:
				enterOuterAlt(_localctx, 1);
				{
				setState(1388);
				match(STAR);
				setState(1389);
				bitwise_or(0);
				}
				break;
			case FSTRING_START:
			case LPAR:
			case LSQB:
			case LBRACE:
			case PLUS:
			case MINUS:
			case TILDE:
			case ELLIPSIS:
			case FALSE:
			case AWAIT:
			case NONE:
			case TRUE:
			case LAMBDA:
			case NOT:
			case NAME_OR_TYPE:
			case NAME_OR_MATCH:
			case NAME_OR_CASE:
			case NAME_OR_WILDCARD:
			case NAME:
			case NUMBER:
			case STRING:
				enterOuterAlt(_localctx, 2);
				{
				setState(1390);
				expression();
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

	public static class Star_named_expressionsContext extends org.example.antlr.common.context.ExtendContext {
		public List<Star_named_expressionContext> star_named_expression() {
			return getRuleContexts(Star_named_expressionContext.class);
		}
		public Star_named_expressionContext star_named_expression(int i) {
			return getRuleContext(Star_named_expressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(PythonParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(PythonParser.COMMA, i);
		}
		public Star_named_expressionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_star_named_expressions; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterStar_named_expressions(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitStar_named_expressions(this);
		}
	}

	public final Star_named_expressionsContext star_named_expressions() throws RecognitionException {
		Star_named_expressionsContext _localctx = new Star_named_expressionsContext(_ctx, getState());
		enterRule(_localctx, 218, RULE_star_named_expressions);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1393);
			star_named_expression();
			setState(1398);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,164,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1394);
					match(COMMA);
					setState(1395);
					star_named_expression();
					}
					} 
				}
				setState(1400);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,164,_ctx);
			}
			setState(1402);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(1401);
				match(COMMA);
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

	public static class Star_named_expressionContext extends org.example.antlr.common.context.ExtendContext {
		public TerminalNode STAR() { return getToken(PythonParser.STAR, 0); }
		public Bitwise_orContext bitwise_or() {
			return getRuleContext(Bitwise_orContext.class,0);
		}
		public Named_expressionContext named_expression() {
			return getRuleContext(Named_expressionContext.class,0);
		}
		public Star_named_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_star_named_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterStar_named_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitStar_named_expression(this);
		}
	}

	public final Star_named_expressionContext star_named_expression() throws RecognitionException {
		Star_named_expressionContext _localctx = new Star_named_expressionContext(_ctx, getState());
		enterRule(_localctx, 220, RULE_star_named_expression);
		try {
			setState(1407);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STAR:
				enterOuterAlt(_localctx, 1);
				{
				setState(1404);
				match(STAR);
				setState(1405);
				bitwise_or(0);
				}
				break;
			case FSTRING_START:
			case LPAR:
			case LSQB:
			case LBRACE:
			case PLUS:
			case MINUS:
			case TILDE:
			case ELLIPSIS:
			case FALSE:
			case AWAIT:
			case NONE:
			case TRUE:
			case LAMBDA:
			case NOT:
			case NAME_OR_TYPE:
			case NAME_OR_MATCH:
			case NAME_OR_CASE:
			case NAME_OR_WILDCARD:
			case NAME:
			case NUMBER:
			case STRING:
				enterOuterAlt(_localctx, 2);
				{
				setState(1406);
				named_expression();
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

	public static class Assignment_expressionContext extends org.example.antlr.common.context.ExtendContext {
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public TerminalNode COLONEQUAL() { return getToken(PythonParser.COLONEQUAL, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public Assignment_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterAssignment_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitAssignment_expression(this);
		}
	}

	public final Assignment_expressionContext assignment_expression() throws RecognitionException {
		Assignment_expressionContext _localctx = new Assignment_expressionContext(_ctx, getState());
		enterRule(_localctx, 222, RULE_assignment_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1409);
			name();
			setState(1410);
			match(COLONEQUAL);
			setState(1411);
			expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Named_expressionContext extends org.example.antlr.common.context.ExtendContext {
		public Assignment_expressionContext assignment_expression() {
			return getRuleContext(Assignment_expressionContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public Named_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_named_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterNamed_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitNamed_expression(this);
		}
	}

	public final Named_expressionContext named_expression() throws RecognitionException {
		Named_expressionContext _localctx = new Named_expressionContext(_ctx, getState());
		enterRule(_localctx, 224, RULE_named_expression);
		try {
			setState(1415);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,167,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1413);
				assignment_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1414);
				expression();
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

	public static class DisjunctionContext extends org.example.antlr.common.context.ExtendContext {
		public List<ConjunctionContext> conjunction() {
			return getRuleContexts(ConjunctionContext.class);
		}
		public ConjunctionContext conjunction(int i) {
			return getRuleContext(ConjunctionContext.class,i);
		}
		public List<TerminalNode> OR() { return getTokens(PythonParser.OR); }
		public TerminalNode OR(int i) {
			return getToken(PythonParser.OR, i);
		}
		public DisjunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_disjunction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterDisjunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitDisjunction(this);
		}
	}

	public final DisjunctionContext disjunction() throws RecognitionException {
		DisjunctionContext _localctx = new DisjunctionContext(_ctx, getState());
		enterRule(_localctx, 226, RULE_disjunction);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1417);
			conjunction();
			setState(1422);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OR) {
				{
				{
				setState(1418);
				match(OR);
				setState(1419);
				conjunction();
				}
				}
				setState(1424);
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

	public static class ConjunctionContext extends org.example.antlr.common.context.ExtendContext {
		public List<InversionContext> inversion() {
			return getRuleContexts(InversionContext.class);
		}
		public InversionContext inversion(int i) {
			return getRuleContext(InversionContext.class,i);
		}
		public List<TerminalNode> AND() { return getTokens(PythonParser.AND); }
		public TerminalNode AND(int i) {
			return getToken(PythonParser.AND, i);
		}
		public ConjunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conjunction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterConjunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitConjunction(this);
		}
	}

	public final ConjunctionContext conjunction() throws RecognitionException {
		ConjunctionContext _localctx = new ConjunctionContext(_ctx, getState());
		enterRule(_localctx, 228, RULE_conjunction);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1425);
			inversion();
			setState(1430);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AND) {
				{
				{
				setState(1426);
				match(AND);
				setState(1427);
				inversion();
				}
				}
				setState(1432);
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

	public static class InversionContext extends org.example.antlr.common.context.ExtendContext {
		public TerminalNode NOT() { return getToken(PythonParser.NOT, 0); }
		public InversionContext inversion() {
			return getRuleContext(InversionContext.class,0);
		}
		public ComparisonContext comparison() {
			return getRuleContext(ComparisonContext.class,0);
		}
		public InversionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inversion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterInversion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitInversion(this);
		}
	}

	public final InversionContext inversion() throws RecognitionException {
		InversionContext _localctx = new InversionContext(_ctx, getState());
		enterRule(_localctx, 230, RULE_inversion);
		try {
			setState(1436);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NOT:
				enterOuterAlt(_localctx, 1);
				{
				setState(1433);
				match(NOT);
				setState(1434);
				inversion();
				}
				break;
			case FSTRING_START:
			case LPAR:
			case LSQB:
			case LBRACE:
			case PLUS:
			case MINUS:
			case TILDE:
			case ELLIPSIS:
			case FALSE:
			case AWAIT:
			case NONE:
			case TRUE:
			case NAME_OR_TYPE:
			case NAME_OR_MATCH:
			case NAME_OR_CASE:
			case NAME_OR_WILDCARD:
			case NAME:
			case NUMBER:
			case STRING:
				enterOuterAlt(_localctx, 2);
				{
				setState(1435);
				comparison();
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

	public static class ComparisonContext extends org.example.antlr.common.context.ExtendContext {
		public Bitwise_orContext bitwise_or() {
			return getRuleContext(Bitwise_orContext.class,0);
		}
		public List<Compare_op_bitwise_or_pairContext> compare_op_bitwise_or_pair() {
			return getRuleContexts(Compare_op_bitwise_or_pairContext.class);
		}
		public Compare_op_bitwise_or_pairContext compare_op_bitwise_or_pair(int i) {
			return getRuleContext(Compare_op_bitwise_or_pairContext.class,i);
		}
		public ComparisonContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comparison; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterComparison(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitComparison(this);
		}
	}

	public final ComparisonContext comparison() throws RecognitionException {
		ComparisonContext _localctx = new ComparisonContext(_ctx, getState());
		enterRule(_localctx, 232, RULE_comparison);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1438);
			bitwise_or(0);
			setState(1442);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 24)) & ~0x3f) == 0 && ((1L << (_la - 24)) & ((1L << (LESS - 24)) | (1L << (GREATER - 24)) | (1L << (EQEQUAL - 24)) | (1L << (NOTEQUAL - 24)) | (1L << (LESSEQUAL - 24)) | (1L << (GREATEREQUAL - 24)) | (1L << (IN - 24)) | (1L << (IS - 24)) | (1L << (NOT - 24)))) != 0)) {
				{
				{
				setState(1439);
				compare_op_bitwise_or_pair();
				}
				}
				setState(1444);
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

	public static class Compare_op_bitwise_or_pairContext extends org.example.antlr.common.context.ExtendContext {
		public Eq_bitwise_orContext eq_bitwise_or() {
			return getRuleContext(Eq_bitwise_orContext.class,0);
		}
		public Noteq_bitwise_orContext noteq_bitwise_or() {
			return getRuleContext(Noteq_bitwise_orContext.class,0);
		}
		public Lte_bitwise_orContext lte_bitwise_or() {
			return getRuleContext(Lte_bitwise_orContext.class,0);
		}
		public Lt_bitwise_orContext lt_bitwise_or() {
			return getRuleContext(Lt_bitwise_orContext.class,0);
		}
		public Gte_bitwise_orContext gte_bitwise_or() {
			return getRuleContext(Gte_bitwise_orContext.class,0);
		}
		public Gt_bitwise_orContext gt_bitwise_or() {
			return getRuleContext(Gt_bitwise_orContext.class,0);
		}
		public Notin_bitwise_orContext notin_bitwise_or() {
			return getRuleContext(Notin_bitwise_orContext.class,0);
		}
		public In_bitwise_orContext in_bitwise_or() {
			return getRuleContext(In_bitwise_orContext.class,0);
		}
		public Isnot_bitwise_orContext isnot_bitwise_or() {
			return getRuleContext(Isnot_bitwise_orContext.class,0);
		}
		public Is_bitwise_orContext is_bitwise_or() {
			return getRuleContext(Is_bitwise_orContext.class,0);
		}
		public Compare_op_bitwise_or_pairContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compare_op_bitwise_or_pair; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterCompare_op_bitwise_or_pair(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitCompare_op_bitwise_or_pair(this);
		}
	}

	public final Compare_op_bitwise_or_pairContext compare_op_bitwise_or_pair() throws RecognitionException {
		Compare_op_bitwise_or_pairContext _localctx = new Compare_op_bitwise_or_pairContext(_ctx, getState());
		enterRule(_localctx, 234, RULE_compare_op_bitwise_or_pair);
		try {
			setState(1455);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,172,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1445);
				eq_bitwise_or();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1446);
				noteq_bitwise_or();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1447);
				lte_bitwise_or();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1448);
				lt_bitwise_or();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(1449);
				gte_bitwise_or();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(1450);
				gt_bitwise_or();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(1451);
				notin_bitwise_or();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(1452);
				in_bitwise_or();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(1453);
				isnot_bitwise_or();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(1454);
				is_bitwise_or();
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

	public static class Eq_bitwise_orContext extends org.example.antlr.common.context.ExtendContext {
		public TerminalNode EQEQUAL() { return getToken(PythonParser.EQEQUAL, 0); }
		public Bitwise_orContext bitwise_or() {
			return getRuleContext(Bitwise_orContext.class,0);
		}
		public Eq_bitwise_orContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eq_bitwise_or; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterEq_bitwise_or(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitEq_bitwise_or(this);
		}
	}

	public final Eq_bitwise_orContext eq_bitwise_or() throws RecognitionException {
		Eq_bitwise_orContext _localctx = new Eq_bitwise_orContext(_ctx, getState());
		enterRule(_localctx, 236, RULE_eq_bitwise_or);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1457);
			match(EQEQUAL);
			setState(1458);
			bitwise_or(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Noteq_bitwise_orContext extends org.example.antlr.common.context.ExtendContext {
		public Bitwise_orContext bitwise_or() {
			return getRuleContext(Bitwise_orContext.class,0);
		}
		public TerminalNode NOTEQUAL() { return getToken(PythonParser.NOTEQUAL, 0); }
		public Noteq_bitwise_orContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_noteq_bitwise_or; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterNoteq_bitwise_or(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitNoteq_bitwise_or(this);
		}
	}

	public final Noteq_bitwise_orContext noteq_bitwise_or() throws RecognitionException {
		Noteq_bitwise_orContext _localctx = new Noteq_bitwise_orContext(_ctx, getState());
		enterRule(_localctx, 238, RULE_noteq_bitwise_or);
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(1460);
			match(NOTEQUAL);
			}
			setState(1461);
			bitwise_or(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Lte_bitwise_orContext extends org.example.antlr.common.context.ExtendContext {
		public TerminalNode LESSEQUAL() { return getToken(PythonParser.LESSEQUAL, 0); }
		public Bitwise_orContext bitwise_or() {
			return getRuleContext(Bitwise_orContext.class,0);
		}
		public Lte_bitwise_orContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lte_bitwise_or; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterLte_bitwise_or(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitLte_bitwise_or(this);
		}
	}

	public final Lte_bitwise_orContext lte_bitwise_or() throws RecognitionException {
		Lte_bitwise_orContext _localctx = new Lte_bitwise_orContext(_ctx, getState());
		enterRule(_localctx, 240, RULE_lte_bitwise_or);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1463);
			match(LESSEQUAL);
			setState(1464);
			bitwise_or(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Lt_bitwise_orContext extends org.example.antlr.common.context.ExtendContext {
		public TerminalNode LESS() { return getToken(PythonParser.LESS, 0); }
		public Bitwise_orContext bitwise_or() {
			return getRuleContext(Bitwise_orContext.class,0);
		}
		public Lt_bitwise_orContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lt_bitwise_or; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterLt_bitwise_or(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitLt_bitwise_or(this);
		}
	}

	public final Lt_bitwise_orContext lt_bitwise_or() throws RecognitionException {
		Lt_bitwise_orContext _localctx = new Lt_bitwise_orContext(_ctx, getState());
		enterRule(_localctx, 242, RULE_lt_bitwise_or);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1466);
			match(LESS);
			setState(1467);
			bitwise_or(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Gte_bitwise_orContext extends org.example.antlr.common.context.ExtendContext {
		public TerminalNode GREATEREQUAL() { return getToken(PythonParser.GREATEREQUAL, 0); }
		public Bitwise_orContext bitwise_or() {
			return getRuleContext(Bitwise_orContext.class,0);
		}
		public Gte_bitwise_orContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_gte_bitwise_or; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterGte_bitwise_or(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitGte_bitwise_or(this);
		}
	}

	public final Gte_bitwise_orContext gte_bitwise_or() throws RecognitionException {
		Gte_bitwise_orContext _localctx = new Gte_bitwise_orContext(_ctx, getState());
		enterRule(_localctx, 244, RULE_gte_bitwise_or);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1469);
			match(GREATEREQUAL);
			setState(1470);
			bitwise_or(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Gt_bitwise_orContext extends org.example.antlr.common.context.ExtendContext {
		public TerminalNode GREATER() { return getToken(PythonParser.GREATER, 0); }
		public Bitwise_orContext bitwise_or() {
			return getRuleContext(Bitwise_orContext.class,0);
		}
		public Gt_bitwise_orContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_gt_bitwise_or; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterGt_bitwise_or(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitGt_bitwise_or(this);
		}
	}

	public final Gt_bitwise_orContext gt_bitwise_or() throws RecognitionException {
		Gt_bitwise_orContext _localctx = new Gt_bitwise_orContext(_ctx, getState());
		enterRule(_localctx, 246, RULE_gt_bitwise_or);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1472);
			match(GREATER);
			setState(1473);
			bitwise_or(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Notin_bitwise_orContext extends org.example.antlr.common.context.ExtendContext {
		public TerminalNode NOT() { return getToken(PythonParser.NOT, 0); }
		public TerminalNode IN() { return getToken(PythonParser.IN, 0); }
		public Bitwise_orContext bitwise_or() {
			return getRuleContext(Bitwise_orContext.class,0);
		}
		public Notin_bitwise_orContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_notin_bitwise_or; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterNotin_bitwise_or(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitNotin_bitwise_or(this);
		}
	}

	public final Notin_bitwise_orContext notin_bitwise_or() throws RecognitionException {
		Notin_bitwise_orContext _localctx = new Notin_bitwise_orContext(_ctx, getState());
		enterRule(_localctx, 248, RULE_notin_bitwise_or);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1475);
			match(NOT);
			setState(1476);
			match(IN);
			setState(1477);
			bitwise_or(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class In_bitwise_orContext extends org.example.antlr.common.context.ExtendContext {
		public TerminalNode IN() { return getToken(PythonParser.IN, 0); }
		public Bitwise_orContext bitwise_or() {
			return getRuleContext(Bitwise_orContext.class,0);
		}
		public In_bitwise_orContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_in_bitwise_or; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterIn_bitwise_or(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitIn_bitwise_or(this);
		}
	}

	public final In_bitwise_orContext in_bitwise_or() throws RecognitionException {
		In_bitwise_orContext _localctx = new In_bitwise_orContext(_ctx, getState());
		enterRule(_localctx, 250, RULE_in_bitwise_or);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1479);
			match(IN);
			setState(1480);
			bitwise_or(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Isnot_bitwise_orContext extends org.example.antlr.common.context.ExtendContext {
		public TerminalNode IS() { return getToken(PythonParser.IS, 0); }
		public TerminalNode NOT() { return getToken(PythonParser.NOT, 0); }
		public Bitwise_orContext bitwise_or() {
			return getRuleContext(Bitwise_orContext.class,0);
		}
		public Isnot_bitwise_orContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_isnot_bitwise_or; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterIsnot_bitwise_or(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitIsnot_bitwise_or(this);
		}
	}

	public final Isnot_bitwise_orContext isnot_bitwise_or() throws RecognitionException {
		Isnot_bitwise_orContext _localctx = new Isnot_bitwise_orContext(_ctx, getState());
		enterRule(_localctx, 252, RULE_isnot_bitwise_or);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1482);
			match(IS);
			setState(1483);
			match(NOT);
			setState(1484);
			bitwise_or(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Is_bitwise_orContext extends org.example.antlr.common.context.ExtendContext {
		public TerminalNode IS() { return getToken(PythonParser.IS, 0); }
		public Bitwise_orContext bitwise_or() {
			return getRuleContext(Bitwise_orContext.class,0);
		}
		public Is_bitwise_orContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_is_bitwise_or; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterIs_bitwise_or(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitIs_bitwise_or(this);
		}
	}

	public final Is_bitwise_orContext is_bitwise_or() throws RecognitionException {
		Is_bitwise_orContext _localctx = new Is_bitwise_orContext(_ctx, getState());
		enterRule(_localctx, 254, RULE_is_bitwise_or);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1486);
			match(IS);
			setState(1487);
			bitwise_or(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Bitwise_orContext extends org.example.antlr.common.context.ExtendContext {
		public Bitwise_xorContext bitwise_xor() {
			return getRuleContext(Bitwise_xorContext.class,0);
		}
		public Bitwise_orContext bitwise_or() {
			return getRuleContext(Bitwise_orContext.class,0);
		}
		public TerminalNode VBAR() { return getToken(PythonParser.VBAR, 0); }
		public Bitwise_orContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bitwise_or; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterBitwise_or(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitBitwise_or(this);
		}
	}

	public final Bitwise_orContext bitwise_or() throws RecognitionException {
		return bitwise_or(0);
	}

	private Bitwise_orContext bitwise_or(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Bitwise_orContext _localctx = new Bitwise_orContext(_ctx, _parentState);
		Bitwise_orContext _prevctx = _localctx;
		int _startState = 256;
		enterRecursionRule(_localctx, 256, RULE_bitwise_or, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(1490);
			bitwise_xor(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(1497);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,173,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Bitwise_orContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_bitwise_or);
					setState(1492);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(1493);
					match(VBAR);
					setState(1494);
					bitwise_xor(0);
					}
					} 
				}
				setState(1499);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,173,_ctx);
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

	public static class Bitwise_xorContext extends org.example.antlr.common.context.ExtendContext {
		public Bitwise_andContext bitwise_and() {
			return getRuleContext(Bitwise_andContext.class,0);
		}
		public Bitwise_xorContext bitwise_xor() {
			return getRuleContext(Bitwise_xorContext.class,0);
		}
		public TerminalNode CIRCUMFLEX() { return getToken(PythonParser.CIRCUMFLEX, 0); }
		public Bitwise_xorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bitwise_xor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterBitwise_xor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitBitwise_xor(this);
		}
	}

	public final Bitwise_xorContext bitwise_xor() throws RecognitionException {
		return bitwise_xor(0);
	}

	private Bitwise_xorContext bitwise_xor(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Bitwise_xorContext _localctx = new Bitwise_xorContext(_ctx, _parentState);
		Bitwise_xorContext _prevctx = _localctx;
		int _startState = 258;
		enterRecursionRule(_localctx, 258, RULE_bitwise_xor, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(1501);
			bitwise_and(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(1508);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,174,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Bitwise_xorContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_bitwise_xor);
					setState(1503);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(1504);
					match(CIRCUMFLEX);
					setState(1505);
					bitwise_and(0);
					}
					} 
				}
				setState(1510);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,174,_ctx);
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

	public static class Bitwise_andContext extends org.example.antlr.common.context.ExtendContext {
		public Shift_exprContext shift_expr() {
			return getRuleContext(Shift_exprContext.class,0);
		}
		public Bitwise_andContext bitwise_and() {
			return getRuleContext(Bitwise_andContext.class,0);
		}
		public TerminalNode AMPER() { return getToken(PythonParser.AMPER, 0); }
		public Bitwise_andContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bitwise_and; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterBitwise_and(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitBitwise_and(this);
		}
	}

	public final Bitwise_andContext bitwise_and() throws RecognitionException {
		return bitwise_and(0);
	}

	private Bitwise_andContext bitwise_and(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Bitwise_andContext _localctx = new Bitwise_andContext(_ctx, _parentState);
		Bitwise_andContext _prevctx = _localctx;
		int _startState = 260;
		enterRecursionRule(_localctx, 260, RULE_bitwise_and, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(1512);
			shift_expr(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(1519);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,175,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Bitwise_andContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_bitwise_and);
					setState(1514);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(1515);
					match(AMPER);
					setState(1516);
					shift_expr(0);
					}
					} 
				}
				setState(1521);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,175,_ctx);
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

	public static class Shift_exprContext extends org.example.antlr.common.context.ExtendContext {
		public SumContext sum() {
			return getRuleContext(SumContext.class,0);
		}
		public Shift_exprContext shift_expr() {
			return getRuleContext(Shift_exprContext.class,0);
		}
		public TerminalNode LEFTSHIFT() { return getToken(PythonParser.LEFTSHIFT, 0); }
		public TerminalNode RIGHTSHIFT() { return getToken(PythonParser.RIGHTSHIFT, 0); }
		public Shift_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_shift_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterShift_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitShift_expr(this);
		}
	}

	public final Shift_exprContext shift_expr() throws RecognitionException {
		return shift_expr(0);
	}

	private Shift_exprContext shift_expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Shift_exprContext _localctx = new Shift_exprContext(_ctx, _parentState);
		Shift_exprContext _prevctx = _localctx;
		int _startState = 262;
		enterRecursionRule(_localctx, 262, RULE_shift_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(1523);
			sum(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(1530);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,176,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Shift_exprContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_shift_expr);
					setState(1525);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(1526);
					_la = _input.LA(1);
					if ( !(_la==LEFTSHIFT || _la==RIGHTSHIFT) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(1527);
					sum(0);
					}
					} 
				}
				setState(1532);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,176,_ctx);
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

	public static class SumContext extends org.example.antlr.common.context.ExtendContext {
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public SumContext sum() {
			return getRuleContext(SumContext.class,0);
		}
		public TerminalNode PLUS() { return getToken(PythonParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(PythonParser.MINUS, 0); }
		public SumContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sum; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterSum(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitSum(this);
		}
	}

	public final SumContext sum() throws RecognitionException {
		return sum(0);
	}

	private SumContext sum(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		SumContext _localctx = new SumContext(_ctx, _parentState);
		SumContext _prevctx = _localctx;
		int _startState = 264;
		enterRecursionRule(_localctx, 264, RULE_sum, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(1534);
			term(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(1541);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,177,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new SumContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_sum);
					setState(1536);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(1537);
					_la = _input.LA(1);
					if ( !(_la==PLUS || _la==MINUS) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(1538);
					term(0);
					}
					} 
				}
				setState(1543);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,177,_ctx);
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

	public static class TermContext extends org.example.antlr.common.context.ExtendContext {
		public FactorContext factor() {
			return getRuleContext(FactorContext.class,0);
		}
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public TerminalNode STAR() { return getToken(PythonParser.STAR, 0); }
		public TerminalNode SLASH() { return getToken(PythonParser.SLASH, 0); }
		public TerminalNode DOUBLESLASH() { return getToken(PythonParser.DOUBLESLASH, 0); }
		public TerminalNode PERCENT() { return getToken(PythonParser.PERCENT, 0); }
		public TerminalNode AT() { return getToken(PythonParser.AT, 0); }
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitTerm(this);
		}
	}

	public final TermContext term() throws RecognitionException {
		return term(0);
	}

	private TermContext term(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		TermContext _localctx = new TermContext(_ctx, _parentState);
		TermContext _prevctx = _localctx;
		int _startState = 266;
		enterRecursionRule(_localctx, 266, RULE_term, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(1545);
			factor();
			}
			_ctx.stop = _input.LT(-1);
			setState(1552);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,178,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new TermContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_term);
					setState(1547);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(1548);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << STAR) | (1L << SLASH) | (1L << PERCENT) | (1L << DOUBLESLASH) | (1L << AT))) != 0)) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(1549);
					factor();
					}
					} 
				}
				setState(1554);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,178,_ctx);
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

	public static class FactorContext extends org.example.antlr.common.context.ExtendContext {
		public TerminalNode PLUS() { return getToken(PythonParser.PLUS, 0); }
		public FactorContext factor() {
			return getRuleContext(FactorContext.class,0);
		}
		public TerminalNode MINUS() { return getToken(PythonParser.MINUS, 0); }
		public TerminalNode TILDE() { return getToken(PythonParser.TILDE, 0); }
		public PowerContext power() {
			return getRuleContext(PowerContext.class,0);
		}
		public FactorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_factor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterFactor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitFactor(this);
		}
	}

	public final FactorContext factor() throws RecognitionException {
		FactorContext _localctx = new FactorContext(_ctx, getState());
		enterRule(_localctx, 268, RULE_factor);
		try {
			setState(1562);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PLUS:
				enterOuterAlt(_localctx, 1);
				{
				setState(1555);
				match(PLUS);
				setState(1556);
				factor();
				}
				break;
			case MINUS:
				enterOuterAlt(_localctx, 2);
				{
				setState(1557);
				match(MINUS);
				setState(1558);
				factor();
				}
				break;
			case TILDE:
				enterOuterAlt(_localctx, 3);
				{
				setState(1559);
				match(TILDE);
				setState(1560);
				factor();
				}
				break;
			case FSTRING_START:
			case LPAR:
			case LSQB:
			case LBRACE:
			case ELLIPSIS:
			case FALSE:
			case AWAIT:
			case NONE:
			case TRUE:
			case NAME_OR_TYPE:
			case NAME_OR_MATCH:
			case NAME_OR_CASE:
			case NAME_OR_WILDCARD:
			case NAME:
			case NUMBER:
			case STRING:
				enterOuterAlt(_localctx, 4);
				{
				setState(1561);
				power();
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

	public static class PowerContext extends org.example.antlr.common.context.ExtendContext {
		public Await_primaryContext await_primary() {
			return getRuleContext(Await_primaryContext.class,0);
		}
		public TerminalNode DOUBLESTAR() { return getToken(PythonParser.DOUBLESTAR, 0); }
		public FactorContext factor() {
			return getRuleContext(FactorContext.class,0);
		}
		public PowerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_power; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterPower(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitPower(this);
		}
	}

	public final PowerContext power() throws RecognitionException {
		PowerContext _localctx = new PowerContext(_ctx, getState());
		enterRule(_localctx, 270, RULE_power);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1564);
			await_primary();
			setState(1567);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,180,_ctx) ) {
			case 1:
				{
				setState(1565);
				match(DOUBLESTAR);
				setState(1566);
				factor();
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

	public static class Await_primaryContext extends org.example.antlr.common.context.ExtendContext {
		public TerminalNode AWAIT() { return getToken(PythonParser.AWAIT, 0); }
		public PrimaryContext primary() {
			return getRuleContext(PrimaryContext.class,0);
		}
		public Await_primaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_await_primary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterAwait_primary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitAwait_primary(this);
		}
	}

	public final Await_primaryContext await_primary() throws RecognitionException {
		Await_primaryContext _localctx = new Await_primaryContext(_ctx, getState());
		enterRule(_localctx, 272, RULE_await_primary);
		try {
			setState(1572);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case AWAIT:
				enterOuterAlt(_localctx, 1);
				{
				setState(1569);
				match(AWAIT);
				setState(1570);
				primary(0);
				}
				break;
			case FSTRING_START:
			case LPAR:
			case LSQB:
			case LBRACE:
			case ELLIPSIS:
			case FALSE:
			case NONE:
			case TRUE:
			case NAME_OR_TYPE:
			case NAME_OR_MATCH:
			case NAME_OR_CASE:
			case NAME_OR_WILDCARD:
			case NAME:
			case NUMBER:
			case STRING:
				enterOuterAlt(_localctx, 2);
				{
				setState(1571);
				primary(0);
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

	public static class PrimaryContext extends org.example.antlr.common.context.ExtendContext {
		public AtomContext atom() {
			return getRuleContext(AtomContext.class,0);
		}
		public PrimaryContext primary() {
			return getRuleContext(PrimaryContext.class,0);
		}
		public TerminalNode DOT() { return getToken(PythonParser.DOT, 0); }
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public GenexpContext genexp() {
			return getRuleContext(GenexpContext.class,0);
		}
		public TerminalNode LPAR() { return getToken(PythonParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(PythonParser.RPAR, 0); }
		public TerminalNode LSQB() { return getToken(PythonParser.LSQB, 0); }
		public SlicesContext slices() {
			return getRuleContext(SlicesContext.class,0);
		}
		public TerminalNode RSQB() { return getToken(PythonParser.RSQB, 0); }
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public PrimaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterPrimary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitPrimary(this);
		}
	}

	public final PrimaryContext primary() throws RecognitionException {
		return primary(0);
	}

	private PrimaryContext primary(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		PrimaryContext _localctx = new PrimaryContext(_ctx, _parentState);
		PrimaryContext _prevctx = _localctx;
		int _startState = 274;
		enterRecursionRule(_localctx, 274, RULE_primary, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(1575);
			atom();
			}
			_ctx.stop = _input.LT(-1);
			setState(1594);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,184,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new PrimaryContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_primary);
					setState(1577);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(1590);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,183,_ctx) ) {
					case 1:
						{
						setState(1578);
						match(DOT);
						setState(1579);
						name();
						}
						break;
					case 2:
						{
						setState(1580);
						genexp();
						}
						break;
					case 3:
						{
						setState(1581);
						match(LPAR);
						setState(1583);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << FSTRING_START) | (1L << LPAR) | (1L << LSQB) | (1L << LBRACE) | (1L << PLUS) | (1L << MINUS) | (1L << STAR) | (1L << TILDE) | (1L << DOUBLESTAR) | (1L << ELLIPSIS) | (1L << FALSE) | (1L << AWAIT) | (1L << NONE))) != 0) || ((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & ((1L << (TRUE - 66)) | (1L << (LAMBDA - 66)) | (1L << (NOT - 66)) | (1L << (NAME_OR_TYPE - 66)) | (1L << (NAME_OR_MATCH - 66)) | (1L << (NAME_OR_CASE - 66)) | (1L << (NAME_OR_WILDCARD - 66)) | (1L << (NAME - 66)) | (1L << (NUMBER - 66)) | (1L << (STRING - 66)))) != 0)) {
							{
							setState(1582);
							arguments();
							}
						}

						setState(1585);
						match(RPAR);
						}
						break;
					case 4:
						{
						setState(1586);
						match(LSQB);
						setState(1587);
						slices();
						setState(1588);
						match(RSQB);
						}
						break;
					}
					}
					} 
				}
				setState(1596);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,184,_ctx);
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

	public static class SlicesContext extends org.example.antlr.common.context.ExtendContext {
		public List<SliceContext> slice() {
			return getRuleContexts(SliceContext.class);
		}
		public SliceContext slice(int i) {
			return getRuleContext(SliceContext.class,i);
		}
		public List<Starred_expressionContext> starred_expression() {
			return getRuleContexts(Starred_expressionContext.class);
		}
		public Starred_expressionContext starred_expression(int i) {
			return getRuleContext(Starred_expressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(PythonParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(PythonParser.COMMA, i);
		}
		public SlicesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_slices; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterSlices(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitSlices(this);
		}
	}

	public final SlicesContext slices() throws RecognitionException {
		SlicesContext _localctx = new SlicesContext(_ctx, getState());
		enterRule(_localctx, 276, RULE_slices);
		int _la;
		try {
			int _alt;
			setState(1615);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,189,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1597);
				slice();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1600);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case FSTRING_START:
				case LPAR:
				case LSQB:
				case LBRACE:
				case COLON:
				case PLUS:
				case MINUS:
				case TILDE:
				case ELLIPSIS:
				case FALSE:
				case AWAIT:
				case NONE:
				case TRUE:
				case LAMBDA:
				case NOT:
				case NAME_OR_TYPE:
				case NAME_OR_MATCH:
				case NAME_OR_CASE:
				case NAME_OR_WILDCARD:
				case NAME:
				case NUMBER:
				case STRING:
					{
					setState(1598);
					slice();
					}
					break;
				case STAR:
					{
					setState(1599);
					starred_expression();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1609);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,187,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(1602);
						match(COMMA);
						setState(1605);
						_errHandler.sync(this);
						switch (_input.LA(1)) {
						case FSTRING_START:
						case LPAR:
						case LSQB:
						case LBRACE:
						case COLON:
						case PLUS:
						case MINUS:
						case TILDE:
						case ELLIPSIS:
						case FALSE:
						case AWAIT:
						case NONE:
						case TRUE:
						case LAMBDA:
						case NOT:
						case NAME_OR_TYPE:
						case NAME_OR_MATCH:
						case NAME_OR_CASE:
						case NAME_OR_WILDCARD:
						case NAME:
						case NUMBER:
						case STRING:
							{
							setState(1603);
							slice();
							}
							break;
						case STAR:
							{
							setState(1604);
							starred_expression();
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						}
						} 
					}
					setState(1611);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,187,_ctx);
				}
				setState(1613);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(1612);
					match(COMMA);
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

	public static class SliceContext extends org.example.antlr.common.context.ExtendContext {
		public List<TerminalNode> COLON() { return getTokens(PythonParser.COLON); }
		public TerminalNode COLON(int i) {
			return getToken(PythonParser.COLON, i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public Named_expressionContext named_expression() {
			return getRuleContext(Named_expressionContext.class,0);
		}
		public SliceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_slice; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterSlice(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitSlice(this);
		}
	}

	public final SliceContext slice() throws RecognitionException {
		SliceContext _localctx = new SliceContext(_ctx, getState());
		enterRule(_localctx, 278, RULE_slice);
		int _la;
		try {
			setState(1631);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,194,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1618);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << FSTRING_START) | (1L << LPAR) | (1L << LSQB) | (1L << LBRACE) | (1L << PLUS) | (1L << MINUS) | (1L << TILDE) | (1L << ELLIPSIS) | (1L << FALSE) | (1L << AWAIT) | (1L << NONE))) != 0) || ((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & ((1L << (TRUE - 66)) | (1L << (LAMBDA - 66)) | (1L << (NOT - 66)) | (1L << (NAME_OR_TYPE - 66)) | (1L << (NAME_OR_MATCH - 66)) | (1L << (NAME_OR_CASE - 66)) | (1L << (NAME_OR_WILDCARD - 66)) | (1L << (NAME - 66)) | (1L << (NUMBER - 66)) | (1L << (STRING - 66)))) != 0)) {
					{
					setState(1617);
					expression();
					}
				}

				setState(1620);
				match(COLON);
				setState(1622);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << FSTRING_START) | (1L << LPAR) | (1L << LSQB) | (1L << LBRACE) | (1L << PLUS) | (1L << MINUS) | (1L << TILDE) | (1L << ELLIPSIS) | (1L << FALSE) | (1L << AWAIT) | (1L << NONE))) != 0) || ((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & ((1L << (TRUE - 66)) | (1L << (LAMBDA - 66)) | (1L << (NOT - 66)) | (1L << (NAME_OR_TYPE - 66)) | (1L << (NAME_OR_MATCH - 66)) | (1L << (NAME_OR_CASE - 66)) | (1L << (NAME_OR_WILDCARD - 66)) | (1L << (NAME - 66)) | (1L << (NUMBER - 66)) | (1L << (STRING - 66)))) != 0)) {
					{
					setState(1621);
					expression();
					}
				}

				setState(1628);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COLON) {
					{
					setState(1624);
					match(COLON);
					setState(1626);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << FSTRING_START) | (1L << LPAR) | (1L << LSQB) | (1L << LBRACE) | (1L << PLUS) | (1L << MINUS) | (1L << TILDE) | (1L << ELLIPSIS) | (1L << FALSE) | (1L << AWAIT) | (1L << NONE))) != 0) || ((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & ((1L << (TRUE - 66)) | (1L << (LAMBDA - 66)) | (1L << (NOT - 66)) | (1L << (NAME_OR_TYPE - 66)) | (1L << (NAME_OR_MATCH - 66)) | (1L << (NAME_OR_CASE - 66)) | (1L << (NAME_OR_WILDCARD - 66)) | (1L << (NAME - 66)) | (1L << (NUMBER - 66)) | (1L << (STRING - 66)))) != 0)) {
						{
						setState(1625);
						expression();
						}
					}

					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1630);
				named_expression();
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

	public static class AtomContext extends org.example.antlr.common.context.ExtendContext {
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public TerminalNode TRUE() { return getToken(PythonParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(PythonParser.FALSE, 0); }
		public TerminalNode NONE() { return getToken(PythonParser.NONE, 0); }
		public StringsContext strings() {
			return getRuleContext(StringsContext.class,0);
		}
		public TerminalNode NUMBER() { return getToken(PythonParser.NUMBER, 0); }
		public TupleContext tuple() {
			return getRuleContext(TupleContext.class,0);
		}
		public GroupContext group() {
			return getRuleContext(GroupContext.class,0);
		}
		public GenexpContext genexp() {
			return getRuleContext(GenexpContext.class,0);
		}
		public ListContext list() {
			return getRuleContext(ListContext.class,0);
		}
		public ListcompContext listcomp() {
			return getRuleContext(ListcompContext.class,0);
		}
		public DictContext dict() {
			return getRuleContext(DictContext.class,0);
		}
		public SetContext set() {
			return getRuleContext(SetContext.class,0);
		}
		public DictcompContext dictcomp() {
			return getRuleContext(DictcompContext.class,0);
		}
		public SetcompContext setcomp() {
			return getRuleContext(SetcompContext.class,0);
		}
		public TerminalNode ELLIPSIS() { return getToken(PythonParser.ELLIPSIS, 0); }
		public AtomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atom; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterAtom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitAtom(this);
		}
	}

	public final AtomContext atom() throws RecognitionException {
		AtomContext _localctx = new AtomContext(_ctx, getState());
		enterRule(_localctx, 280, RULE_atom);
		try {
			setState(1655);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NAME_OR_TYPE:
			case NAME_OR_MATCH:
			case NAME_OR_CASE:
			case NAME_OR_WILDCARD:
			case NAME:
				enterOuterAlt(_localctx, 1);
				{
				setState(1633);
				name();
				}
				break;
			case TRUE:
				enterOuterAlt(_localctx, 2);
				{
				setState(1634);
				match(TRUE);
				}
				break;
			case FALSE:
				enterOuterAlt(_localctx, 3);
				{
				setState(1635);
				match(FALSE);
				}
				break;
			case NONE:
				enterOuterAlt(_localctx, 4);
				{
				setState(1636);
				match(NONE);
				}
				break;
			case FSTRING_START:
			case STRING:
				enterOuterAlt(_localctx, 5);
				{
				setState(1637);
				strings();
				}
				break;
			case NUMBER:
				enterOuterAlt(_localctx, 6);
				{
				setState(1638);
				match(NUMBER);
				}
				break;
			case LPAR:
				enterOuterAlt(_localctx, 7);
				{
				setState(1642);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,195,_ctx) ) {
				case 1:
					{
					setState(1639);
					tuple();
					}
					break;
				case 2:
					{
					setState(1640);
					group();
					}
					break;
				case 3:
					{
					setState(1641);
					genexp();
					}
					break;
				}
				}
				break;
			case LSQB:
				enterOuterAlt(_localctx, 8);
				{
				setState(1646);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,196,_ctx) ) {
				case 1:
					{
					setState(1644);
					list();
					}
					break;
				case 2:
					{
					setState(1645);
					listcomp();
					}
					break;
				}
				}
				break;
			case LBRACE:
				enterOuterAlt(_localctx, 9);
				{
				setState(1652);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,197,_ctx) ) {
				case 1:
					{
					setState(1648);
					dict();
					}
					break;
				case 2:
					{
					setState(1649);
					set();
					}
					break;
				case 3:
					{
					setState(1650);
					dictcomp();
					}
					break;
				case 4:
					{
					setState(1651);
					setcomp();
					}
					break;
				}
				}
				break;
			case ELLIPSIS:
				enterOuterAlt(_localctx, 10);
				{
				setState(1654);
				match(ELLIPSIS);
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

	public static class GroupContext extends org.example.antlr.common.context.ExtendContext {
		public TerminalNode LPAR() { return getToken(PythonParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(PythonParser.RPAR, 0); }
		public Yield_exprContext yield_expr() {
			return getRuleContext(Yield_exprContext.class,0);
		}
		public Named_expressionContext named_expression() {
			return getRuleContext(Named_expressionContext.class,0);
		}
		public GroupContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_group; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterGroup(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitGroup(this);
		}
	}

	public final GroupContext group() throws RecognitionException {
		GroupContext _localctx = new GroupContext(_ctx, getState());
		enterRule(_localctx, 282, RULE_group);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1657);
			match(LPAR);
			setState(1660);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case YIELD:
				{
				setState(1658);
				yield_expr();
				}
				break;
			case FSTRING_START:
			case LPAR:
			case LSQB:
			case LBRACE:
			case PLUS:
			case MINUS:
			case TILDE:
			case ELLIPSIS:
			case FALSE:
			case AWAIT:
			case NONE:
			case TRUE:
			case LAMBDA:
			case NOT:
			case NAME_OR_TYPE:
			case NAME_OR_MATCH:
			case NAME_OR_CASE:
			case NAME_OR_WILDCARD:
			case NAME:
			case NUMBER:
			case STRING:
				{
				setState(1659);
				named_expression();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(1662);
			match(RPAR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LambdefContext extends org.example.antlr.common.context.ExtendContext {
		public TerminalNode LAMBDA() { return getToken(PythonParser.LAMBDA, 0); }
		public TerminalNode COLON() { return getToken(PythonParser.COLON, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public Lambda_paramsContext lambda_params() {
			return getRuleContext(Lambda_paramsContext.class,0);
		}
		public LambdefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lambdef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterLambdef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitLambdef(this);
		}
	}

	public final LambdefContext lambdef() throws RecognitionException {
		LambdefContext _localctx = new LambdefContext(_ctx, getState());
		enterRule(_localctx, 284, RULE_lambdef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1664);
			match(LAMBDA);
			setState(1666);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==STAR || _la==DOUBLESTAR || ((((_la - 91)) & ~0x3f) == 0 && ((1L << (_la - 91)) & ((1L << (NAME_OR_TYPE - 91)) | (1L << (NAME_OR_MATCH - 91)) | (1L << (NAME_OR_CASE - 91)) | (1L << (NAME_OR_WILDCARD - 91)) | (1L << (NAME - 91)))) != 0)) {
				{
				setState(1665);
				lambda_params();
				}
			}

			setState(1668);
			match(COLON);
			setState(1669);
			expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Lambda_paramsContext extends org.example.antlr.common.context.ExtendContext {
		public Lambda_parametersContext lambda_parameters() {
			return getRuleContext(Lambda_parametersContext.class,0);
		}
		public Lambda_paramsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lambda_params; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterLambda_params(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitLambda_params(this);
		}
	}

	public final Lambda_paramsContext lambda_params() throws RecognitionException {
		Lambda_paramsContext _localctx = new Lambda_paramsContext(_ctx, getState());
		enterRule(_localctx, 286, RULE_lambda_params);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1671);
			lambda_parameters();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Lambda_parametersContext extends org.example.antlr.common.context.ExtendContext {
		public Lambda_slash_no_defaultContext lambda_slash_no_default() {
			return getRuleContext(Lambda_slash_no_defaultContext.class,0);
		}
		public List<Lambda_param_no_defaultContext> lambda_param_no_default() {
			return getRuleContexts(Lambda_param_no_defaultContext.class);
		}
		public Lambda_param_no_defaultContext lambda_param_no_default(int i) {
			return getRuleContext(Lambda_param_no_defaultContext.class,i);
		}
		public List<Lambda_param_with_defaultContext> lambda_param_with_default() {
			return getRuleContexts(Lambda_param_with_defaultContext.class);
		}
		public Lambda_param_with_defaultContext lambda_param_with_default(int i) {
			return getRuleContext(Lambda_param_with_defaultContext.class,i);
		}
		public Lambda_star_etcContext lambda_star_etc() {
			return getRuleContext(Lambda_star_etcContext.class,0);
		}
		public Lambda_slash_with_defaultContext lambda_slash_with_default() {
			return getRuleContext(Lambda_slash_with_defaultContext.class,0);
		}
		public Lambda_parametersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lambda_parameters; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterLambda_parameters(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitLambda_parameters(this);
		}
	}

	public final Lambda_parametersContext lambda_parameters() throws RecognitionException {
		Lambda_parametersContext _localctx = new Lambda_parametersContext(_ctx, getState());
		enterRule(_localctx, 288, RULE_lambda_parameters);
		int _la;
		try {
			int _alt;
			setState(1722);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,211,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1673);
				lambda_slash_no_default();
				setState(1677);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,201,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(1674);
						lambda_param_no_default();
						}
						} 
					}
					setState(1679);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,201,_ctx);
				}
				setState(1683);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (((((_la - 91)) & ~0x3f) == 0 && ((1L << (_la - 91)) & ((1L << (NAME_OR_TYPE - 91)) | (1L << (NAME_OR_MATCH - 91)) | (1L << (NAME_OR_CASE - 91)) | (1L << (NAME_OR_WILDCARD - 91)) | (1L << (NAME - 91)))) != 0)) {
					{
					{
					setState(1680);
					lambda_param_with_default();
					}
					}
					setState(1685);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1687);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==STAR || _la==DOUBLESTAR) {
					{
					setState(1686);
					lambda_star_etc();
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1689);
				lambda_slash_with_default();
				setState(1693);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (((((_la - 91)) & ~0x3f) == 0 && ((1L << (_la - 91)) & ((1L << (NAME_OR_TYPE - 91)) | (1L << (NAME_OR_MATCH - 91)) | (1L << (NAME_OR_CASE - 91)) | (1L << (NAME_OR_WILDCARD - 91)) | (1L << (NAME - 91)))) != 0)) {
					{
					{
					setState(1690);
					lambda_param_with_default();
					}
					}
					setState(1695);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1697);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==STAR || _la==DOUBLESTAR) {
					{
					setState(1696);
					lambda_star_etc();
					}
				}

				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1700); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(1699);
						lambda_param_no_default();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(1702); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,206,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(1707);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (((((_la - 91)) & ~0x3f) == 0 && ((1L << (_la - 91)) & ((1L << (NAME_OR_TYPE - 91)) | (1L << (NAME_OR_MATCH - 91)) | (1L << (NAME_OR_CASE - 91)) | (1L << (NAME_OR_WILDCARD - 91)) | (1L << (NAME - 91)))) != 0)) {
					{
					{
					setState(1704);
					lambda_param_with_default();
					}
					}
					setState(1709);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1711);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==STAR || _la==DOUBLESTAR) {
					{
					setState(1710);
					lambda_star_etc();
					}
				}

				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1714); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(1713);
					lambda_param_with_default();
					}
					}
					setState(1716); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( ((((_la - 91)) & ~0x3f) == 0 && ((1L << (_la - 91)) & ((1L << (NAME_OR_TYPE - 91)) | (1L << (NAME_OR_MATCH - 91)) | (1L << (NAME_OR_CASE - 91)) | (1L << (NAME_OR_WILDCARD - 91)) | (1L << (NAME - 91)))) != 0) );
				setState(1719);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==STAR || _la==DOUBLESTAR) {
					{
					setState(1718);
					lambda_star_etc();
					}
				}

				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(1721);
				lambda_star_etc();
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

	public static class Lambda_slash_no_defaultContext extends org.example.antlr.common.context.ExtendContext {
		public TerminalNode SLASH() { return getToken(PythonParser.SLASH, 0); }
		public List<Lambda_param_no_defaultContext> lambda_param_no_default() {
			return getRuleContexts(Lambda_param_no_defaultContext.class);
		}
		public Lambda_param_no_defaultContext lambda_param_no_default(int i) {
			return getRuleContext(Lambda_param_no_defaultContext.class,i);
		}
		public TerminalNode COMMA() { return getToken(PythonParser.COMMA, 0); }
		public Lambda_slash_no_defaultContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lambda_slash_no_default; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterLambda_slash_no_default(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitLambda_slash_no_default(this);
		}
	}

	public final Lambda_slash_no_defaultContext lambda_slash_no_default() throws RecognitionException {
		Lambda_slash_no_defaultContext _localctx = new Lambda_slash_no_defaultContext(_ctx, getState());
		enterRule(_localctx, 290, RULE_lambda_slash_no_default);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1725); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(1724);
				lambda_param_no_default();
				}
				}
				setState(1727); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( ((((_la - 91)) & ~0x3f) == 0 && ((1L << (_la - 91)) & ((1L << (NAME_OR_TYPE - 91)) | (1L << (NAME_OR_MATCH - 91)) | (1L << (NAME_OR_CASE - 91)) | (1L << (NAME_OR_WILDCARD - 91)) | (1L << (NAME - 91)))) != 0) );
			setState(1729);
			match(SLASH);
			setState(1731);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(1730);
				match(COMMA);
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

	public static class Lambda_slash_with_defaultContext extends org.example.antlr.common.context.ExtendContext {
		public TerminalNode SLASH() { return getToken(PythonParser.SLASH, 0); }
		public List<Lambda_param_no_defaultContext> lambda_param_no_default() {
			return getRuleContexts(Lambda_param_no_defaultContext.class);
		}
		public Lambda_param_no_defaultContext lambda_param_no_default(int i) {
			return getRuleContext(Lambda_param_no_defaultContext.class,i);
		}
		public List<Lambda_param_with_defaultContext> lambda_param_with_default() {
			return getRuleContexts(Lambda_param_with_defaultContext.class);
		}
		public Lambda_param_with_defaultContext lambda_param_with_default(int i) {
			return getRuleContext(Lambda_param_with_defaultContext.class,i);
		}
		public TerminalNode COMMA() { return getToken(PythonParser.COMMA, 0); }
		public Lambda_slash_with_defaultContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lambda_slash_with_default; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterLambda_slash_with_default(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitLambda_slash_with_default(this);
		}
	}

	public final Lambda_slash_with_defaultContext lambda_slash_with_default() throws RecognitionException {
		Lambda_slash_with_defaultContext _localctx = new Lambda_slash_with_defaultContext(_ctx, getState());
		enterRule(_localctx, 292, RULE_lambda_slash_with_default);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1736);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,214,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1733);
					lambda_param_no_default();
					}
					} 
				}
				setState(1738);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,214,_ctx);
			}
			setState(1740); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(1739);
				lambda_param_with_default();
				}
				}
				setState(1742); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( ((((_la - 91)) & ~0x3f) == 0 && ((1L << (_la - 91)) & ((1L << (NAME_OR_TYPE - 91)) | (1L << (NAME_OR_MATCH - 91)) | (1L << (NAME_OR_CASE - 91)) | (1L << (NAME_OR_WILDCARD - 91)) | (1L << (NAME - 91)))) != 0) );
			setState(1744);
			match(SLASH);
			setState(1746);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(1745);
				match(COMMA);
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

	public static class Lambda_star_etcContext extends org.example.antlr.common.context.ExtendContext {
		public TerminalNode STAR() { return getToken(PythonParser.STAR, 0); }
		public Lambda_param_no_defaultContext lambda_param_no_default() {
			return getRuleContext(Lambda_param_no_defaultContext.class,0);
		}
		public List<Lambda_param_maybe_defaultContext> lambda_param_maybe_default() {
			return getRuleContexts(Lambda_param_maybe_defaultContext.class);
		}
		public Lambda_param_maybe_defaultContext lambda_param_maybe_default(int i) {
			return getRuleContext(Lambda_param_maybe_defaultContext.class,i);
		}
		public Lambda_kwdsContext lambda_kwds() {
			return getRuleContext(Lambda_kwdsContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(PythonParser.COMMA, 0); }
		public Lambda_star_etcContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lambda_star_etc; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterLambda_star_etc(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitLambda_star_etc(this);
		}
	}

	public final Lambda_star_etcContext lambda_star_etc() throws RecognitionException {
		Lambda_star_etcContext _localctx = new Lambda_star_etcContext(_ctx, getState());
		enterRule(_localctx, 294, RULE_lambda_star_etc);
		int _la;
		try {
			setState(1770);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,221,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1748);
				match(STAR);
				setState(1749);
				lambda_param_no_default();
				setState(1753);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (((((_la - 91)) & ~0x3f) == 0 && ((1L << (_la - 91)) & ((1L << (NAME_OR_TYPE - 91)) | (1L << (NAME_OR_MATCH - 91)) | (1L << (NAME_OR_CASE - 91)) | (1L << (NAME_OR_WILDCARD - 91)) | (1L << (NAME - 91)))) != 0)) {
					{
					{
					setState(1750);
					lambda_param_maybe_default();
					}
					}
					setState(1755);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1757);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==DOUBLESTAR) {
					{
					setState(1756);
					lambda_kwds();
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1759);
				match(STAR);
				setState(1760);
				match(COMMA);
				setState(1762); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(1761);
					lambda_param_maybe_default();
					}
					}
					setState(1764); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( ((((_la - 91)) & ~0x3f) == 0 && ((1L << (_la - 91)) & ((1L << (NAME_OR_TYPE - 91)) | (1L << (NAME_OR_MATCH - 91)) | (1L << (NAME_OR_CASE - 91)) | (1L << (NAME_OR_WILDCARD - 91)) | (1L << (NAME - 91)))) != 0) );
				setState(1767);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==DOUBLESTAR) {
					{
					setState(1766);
					lambda_kwds();
					}
				}

				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1769);
				lambda_kwds();
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

	public static class Lambda_kwdsContext extends org.example.antlr.common.context.ExtendContext {
		public TerminalNode DOUBLESTAR() { return getToken(PythonParser.DOUBLESTAR, 0); }
		public Lambda_param_no_defaultContext lambda_param_no_default() {
			return getRuleContext(Lambda_param_no_defaultContext.class,0);
		}
		public Lambda_kwdsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lambda_kwds; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterLambda_kwds(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitLambda_kwds(this);
		}
	}

	public final Lambda_kwdsContext lambda_kwds() throws RecognitionException {
		Lambda_kwdsContext _localctx = new Lambda_kwdsContext(_ctx, getState());
		enterRule(_localctx, 296, RULE_lambda_kwds);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1772);
			match(DOUBLESTAR);
			setState(1773);
			lambda_param_no_default();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Lambda_param_no_defaultContext extends org.example.antlr.common.context.ExtendContext {
		public Lambda_paramContext lambda_param() {
			return getRuleContext(Lambda_paramContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(PythonParser.COMMA, 0); }
		public Lambda_param_no_defaultContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lambda_param_no_default; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterLambda_param_no_default(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitLambda_param_no_default(this);
		}
	}

	public final Lambda_param_no_defaultContext lambda_param_no_default() throws RecognitionException {
		Lambda_param_no_defaultContext _localctx = new Lambda_param_no_defaultContext(_ctx, getState());
		enterRule(_localctx, 298, RULE_lambda_param_no_default);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1775);
			lambda_param();
			setState(1777);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(1776);
				match(COMMA);
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

	public static class Lambda_param_with_defaultContext extends org.example.antlr.common.context.ExtendContext {
		public Lambda_paramContext lambda_param() {
			return getRuleContext(Lambda_paramContext.class,0);
		}
		public Default_assignmentContext default_assignment() {
			return getRuleContext(Default_assignmentContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(PythonParser.COMMA, 0); }
		public Lambda_param_with_defaultContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lambda_param_with_default; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterLambda_param_with_default(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitLambda_param_with_default(this);
		}
	}

	public final Lambda_param_with_defaultContext lambda_param_with_default() throws RecognitionException {
		Lambda_param_with_defaultContext _localctx = new Lambda_param_with_defaultContext(_ctx, getState());
		enterRule(_localctx, 300, RULE_lambda_param_with_default);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1779);
			lambda_param();
			setState(1780);
			default_assignment();
			setState(1782);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(1781);
				match(COMMA);
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

	public static class Lambda_param_maybe_defaultContext extends org.example.antlr.common.context.ExtendContext {
		public Lambda_paramContext lambda_param() {
			return getRuleContext(Lambda_paramContext.class,0);
		}
		public Default_assignmentContext default_assignment() {
			return getRuleContext(Default_assignmentContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(PythonParser.COMMA, 0); }
		public Lambda_param_maybe_defaultContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lambda_param_maybe_default; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterLambda_param_maybe_default(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitLambda_param_maybe_default(this);
		}
	}

	public final Lambda_param_maybe_defaultContext lambda_param_maybe_default() throws RecognitionException {
		Lambda_param_maybe_defaultContext _localctx = new Lambda_param_maybe_defaultContext(_ctx, getState());
		enterRule(_localctx, 302, RULE_lambda_param_maybe_default);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1784);
			lambda_param();
			setState(1786);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EQUAL) {
				{
				setState(1785);
				default_assignment();
				}
			}

			setState(1789);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(1788);
				match(COMMA);
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

	public static class Lambda_paramContext extends org.example.antlr.common.context.ExtendContext {
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public Lambda_paramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lambda_param; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterLambda_param(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitLambda_param(this);
		}
	}

	public final Lambda_paramContext lambda_param() throws RecognitionException {
		Lambda_paramContext _localctx = new Lambda_paramContext(_ctx, getState());
		enterRule(_localctx, 304, RULE_lambda_param);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1791);
			name();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Fstring_middleContext extends org.example.antlr.common.context.ExtendContext {
		public Fstring_replacement_fieldContext fstring_replacement_field() {
			return getRuleContext(Fstring_replacement_fieldContext.class,0);
		}
		public TerminalNode FSTRING_MIDDLE() { return getToken(PythonParser.FSTRING_MIDDLE, 0); }
		public Fstring_middleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fstring_middle; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterFstring_middle(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitFstring_middle(this);
		}
	}

	public final Fstring_middleContext fstring_middle() throws RecognitionException {
		Fstring_middleContext _localctx = new Fstring_middleContext(_ctx, getState());
		enterRule(_localctx, 306, RULE_fstring_middle);
		try {
			setState(1795);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LBRACE:
				enterOuterAlt(_localctx, 1);
				{
				setState(1793);
				fstring_replacement_field();
				}
				break;
			case FSTRING_MIDDLE:
				enterOuterAlt(_localctx, 2);
				{
				setState(1794);
				match(FSTRING_MIDDLE);
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

	public static class Fstring_replacement_fieldContext extends org.example.antlr.common.context.ExtendContext {
		public TerminalNode LBRACE() { return getToken(PythonParser.LBRACE, 0); }
		public Annotated_rhsContext annotated_rhs() {
			return getRuleContext(Annotated_rhsContext.class,0);
		}
		public TerminalNode RBRACE() { return getToken(PythonParser.RBRACE, 0); }
		public TerminalNode EQUAL() { return getToken(PythonParser.EQUAL, 0); }
		public Fstring_conversionContext fstring_conversion() {
			return getRuleContext(Fstring_conversionContext.class,0);
		}
		public Fstring_full_format_specContext fstring_full_format_spec() {
			return getRuleContext(Fstring_full_format_specContext.class,0);
		}
		public Fstring_replacement_fieldContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fstring_replacement_field; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterFstring_replacement_field(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitFstring_replacement_field(this);
		}
	}

	public final Fstring_replacement_fieldContext fstring_replacement_field() throws RecognitionException {
		Fstring_replacement_fieldContext _localctx = new Fstring_replacement_fieldContext(_ctx, getState());
		enterRule(_localctx, 308, RULE_fstring_replacement_field);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1797);
			match(LBRACE);
			setState(1798);
			annotated_rhs();
			setState(1800);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EQUAL) {
				{
				setState(1799);
				match(EQUAL);
				}
			}

			setState(1803);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EXCLAMATION) {
				{
				setState(1802);
				fstring_conversion();
				}
			}

			setState(1806);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COLON) {
				{
				setState(1805);
				fstring_full_format_spec();
				}
			}

			setState(1808);
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

	public static class Fstring_conversionContext extends org.example.antlr.common.context.ExtendContext {
		public TerminalNode EXCLAMATION() { return getToken(PythonParser.EXCLAMATION, 0); }
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public Fstring_conversionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fstring_conversion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterFstring_conversion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitFstring_conversion(this);
		}
	}

	public final Fstring_conversionContext fstring_conversion() throws RecognitionException {
		Fstring_conversionContext _localctx = new Fstring_conversionContext(_ctx, getState());
		enterRule(_localctx, 310, RULE_fstring_conversion);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1810);
			match(EXCLAMATION);
			setState(1811);
			name();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Fstring_full_format_specContext extends org.example.antlr.common.context.ExtendContext {
		public TerminalNode COLON() { return getToken(PythonParser.COLON, 0); }
		public List<Fstring_format_specContext> fstring_format_spec() {
			return getRuleContexts(Fstring_format_specContext.class);
		}
		public Fstring_format_specContext fstring_format_spec(int i) {
			return getRuleContext(Fstring_format_specContext.class,i);
		}
		public Fstring_full_format_specContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fstring_full_format_spec; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterFstring_full_format_spec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitFstring_full_format_spec(this);
		}
	}

	public final Fstring_full_format_specContext fstring_full_format_spec() throws RecognitionException {
		Fstring_full_format_specContext _localctx = new Fstring_full_format_specContext(_ctx, getState());
		enterRule(_localctx, 312, RULE_fstring_full_format_spec);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1813);
			match(COLON);
			setState(1817);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==FSTRING_MIDDLE || _la==LBRACE) {
				{
				{
				setState(1814);
				fstring_format_spec();
				}
				}
				setState(1819);
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

	public static class Fstring_format_specContext extends org.example.antlr.common.context.ExtendContext {
		public TerminalNode FSTRING_MIDDLE() { return getToken(PythonParser.FSTRING_MIDDLE, 0); }
		public Fstring_replacement_fieldContext fstring_replacement_field() {
			return getRuleContext(Fstring_replacement_fieldContext.class,0);
		}
		public Fstring_format_specContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fstring_format_spec; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterFstring_format_spec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitFstring_format_spec(this);
		}
	}

	public final Fstring_format_specContext fstring_format_spec() throws RecognitionException {
		Fstring_format_specContext _localctx = new Fstring_format_specContext(_ctx, getState());
		enterRule(_localctx, 314, RULE_fstring_format_spec);
		try {
			setState(1822);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FSTRING_MIDDLE:
				enterOuterAlt(_localctx, 1);
				{
				setState(1820);
				match(FSTRING_MIDDLE);
				}
				break;
			case LBRACE:
				enterOuterAlt(_localctx, 2);
				{
				setState(1821);
				fstring_replacement_field();
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

	public static class FstringContext extends org.example.antlr.common.context.ExtendContext {
		public TerminalNode FSTRING_START() { return getToken(PythonParser.FSTRING_START, 0); }
		public TerminalNode FSTRING_END() { return getToken(PythonParser.FSTRING_END, 0); }
		public List<Fstring_middleContext> fstring_middle() {
			return getRuleContexts(Fstring_middleContext.class);
		}
		public Fstring_middleContext fstring_middle(int i) {
			return getRuleContext(Fstring_middleContext.class,i);
		}
		public FstringContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fstring; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterFstring(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitFstring(this);
		}
	}

	public final FstringContext fstring() throws RecognitionException {
		FstringContext _localctx = new FstringContext(_ctx, getState());
		enterRule(_localctx, 316, RULE_fstring);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1824);
			match(FSTRING_START);
			setState(1828);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==FSTRING_MIDDLE || _la==LBRACE) {
				{
				{
				setState(1825);
				fstring_middle();
				}
				}
				setState(1830);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1831);
			match(FSTRING_END);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StringContext extends org.example.antlr.common.context.ExtendContext {
		public TerminalNode STRING() { return getToken(PythonParser.STRING, 0); }
		public StringContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_string; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterString(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitString(this);
		}
	}

	public final StringContext string() throws RecognitionException {
		StringContext _localctx = new StringContext(_ctx, getState());
		enterRule(_localctx, 318, RULE_string);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1833);
			match(STRING);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StringsContext extends org.example.antlr.common.context.ExtendContext {
		public List<FstringContext> fstring() {
			return getRuleContexts(FstringContext.class);
		}
		public FstringContext fstring(int i) {
			return getRuleContext(FstringContext.class,i);
		}
		public List<StringContext> string() {
			return getRuleContexts(StringContext.class);
		}
		public StringContext string(int i) {
			return getRuleContext(StringContext.class,i);
		}
		public StringsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_strings; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterStrings(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitStrings(this);
		}
	}

	public final StringsContext strings() throws RecognitionException {
		StringsContext _localctx = new StringsContext(_ctx, getState());
		enterRule(_localctx, 320, RULE_strings);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1837); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					setState(1837);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case FSTRING_START:
						{
						setState(1835);
						fstring();
						}
						break;
					case STRING:
						{
						setState(1836);
						string();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1839); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,234,_ctx);
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

	public static class ListContext extends org.example.antlr.common.context.ExtendContext {
		public TerminalNode LSQB() { return getToken(PythonParser.LSQB, 0); }
		public TerminalNode RSQB() { return getToken(PythonParser.RSQB, 0); }
		public Star_named_expressionsContext star_named_expressions() {
			return getRuleContext(Star_named_expressionsContext.class,0);
		}
		public ListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitList(this);
		}
	}

	public final ListContext list() throws RecognitionException {
		ListContext _localctx = new ListContext(_ctx, getState());
		enterRule(_localctx, 322, RULE_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1841);
			match(LSQB);
			setState(1843);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << FSTRING_START) | (1L << LPAR) | (1L << LSQB) | (1L << LBRACE) | (1L << PLUS) | (1L << MINUS) | (1L << STAR) | (1L << TILDE) | (1L << ELLIPSIS) | (1L << FALSE) | (1L << AWAIT) | (1L << NONE))) != 0) || ((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & ((1L << (TRUE - 66)) | (1L << (LAMBDA - 66)) | (1L << (NOT - 66)) | (1L << (NAME_OR_TYPE - 66)) | (1L << (NAME_OR_MATCH - 66)) | (1L << (NAME_OR_CASE - 66)) | (1L << (NAME_OR_WILDCARD - 66)) | (1L << (NAME - 66)) | (1L << (NUMBER - 66)) | (1L << (STRING - 66)))) != 0)) {
				{
				setState(1842);
				star_named_expressions();
				}
			}

			setState(1845);
			match(RSQB);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TupleContext extends org.example.antlr.common.context.ExtendContext {
		public TerminalNode LPAR() { return getToken(PythonParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(PythonParser.RPAR, 0); }
		public Star_named_expressionContext star_named_expression() {
			return getRuleContext(Star_named_expressionContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(PythonParser.COMMA, 0); }
		public Star_named_expressionsContext star_named_expressions() {
			return getRuleContext(Star_named_expressionsContext.class,0);
		}
		public TupleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tuple; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterTuple(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitTuple(this);
		}
	}

	public final TupleContext tuple() throws RecognitionException {
		TupleContext _localctx = new TupleContext(_ctx, getState());
		enterRule(_localctx, 324, RULE_tuple);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1847);
			match(LPAR);
			setState(1853);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << FSTRING_START) | (1L << LPAR) | (1L << LSQB) | (1L << LBRACE) | (1L << PLUS) | (1L << MINUS) | (1L << STAR) | (1L << TILDE) | (1L << ELLIPSIS) | (1L << FALSE) | (1L << AWAIT) | (1L << NONE))) != 0) || ((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & ((1L << (TRUE - 66)) | (1L << (LAMBDA - 66)) | (1L << (NOT - 66)) | (1L << (NAME_OR_TYPE - 66)) | (1L << (NAME_OR_MATCH - 66)) | (1L << (NAME_OR_CASE - 66)) | (1L << (NAME_OR_WILDCARD - 66)) | (1L << (NAME - 66)) | (1L << (NUMBER - 66)) | (1L << (STRING - 66)))) != 0)) {
				{
				setState(1848);
				star_named_expression();
				setState(1849);
				match(COMMA);
				setState(1851);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << FSTRING_START) | (1L << LPAR) | (1L << LSQB) | (1L << LBRACE) | (1L << PLUS) | (1L << MINUS) | (1L << STAR) | (1L << TILDE) | (1L << ELLIPSIS) | (1L << FALSE) | (1L << AWAIT) | (1L << NONE))) != 0) || ((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & ((1L << (TRUE - 66)) | (1L << (LAMBDA - 66)) | (1L << (NOT - 66)) | (1L << (NAME_OR_TYPE - 66)) | (1L << (NAME_OR_MATCH - 66)) | (1L << (NAME_OR_CASE - 66)) | (1L << (NAME_OR_WILDCARD - 66)) | (1L << (NAME - 66)) | (1L << (NUMBER - 66)) | (1L << (STRING - 66)))) != 0)) {
					{
					setState(1850);
					star_named_expressions();
					}
				}

				}
			}

			setState(1855);
			match(RPAR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SetContext extends org.example.antlr.common.context.ExtendContext {
		public TerminalNode LBRACE() { return getToken(PythonParser.LBRACE, 0); }
		public Star_named_expressionsContext star_named_expressions() {
			return getRuleContext(Star_named_expressionsContext.class,0);
		}
		public TerminalNode RBRACE() { return getToken(PythonParser.RBRACE, 0); }
		public SetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_set; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterSet(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitSet(this);
		}
	}

	public final SetContext set() throws RecognitionException {
		SetContext _localctx = new SetContext(_ctx, getState());
		enterRule(_localctx, 326, RULE_set);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1857);
			match(LBRACE);
			setState(1858);
			star_named_expressions();
			setState(1859);
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

	public static class DictContext extends org.example.antlr.common.context.ExtendContext {
		public TerminalNode LBRACE() { return getToken(PythonParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(PythonParser.RBRACE, 0); }
		public Double_starred_kvpairsContext double_starred_kvpairs() {
			return getRuleContext(Double_starred_kvpairsContext.class,0);
		}
		public DictContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dict; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterDict(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitDict(this);
		}
	}

	public final DictContext dict() throws RecognitionException {
		DictContext _localctx = new DictContext(_ctx, getState());
		enterRule(_localctx, 328, RULE_dict);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1861);
			match(LBRACE);
			setState(1863);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << FSTRING_START) | (1L << LPAR) | (1L << LSQB) | (1L << LBRACE) | (1L << PLUS) | (1L << MINUS) | (1L << TILDE) | (1L << DOUBLESTAR) | (1L << ELLIPSIS) | (1L << FALSE) | (1L << AWAIT) | (1L << NONE))) != 0) || ((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & ((1L << (TRUE - 66)) | (1L << (LAMBDA - 66)) | (1L << (NOT - 66)) | (1L << (NAME_OR_TYPE - 66)) | (1L << (NAME_OR_MATCH - 66)) | (1L << (NAME_OR_CASE - 66)) | (1L << (NAME_OR_WILDCARD - 66)) | (1L << (NAME - 66)) | (1L << (NUMBER - 66)) | (1L << (STRING - 66)))) != 0)) {
				{
				setState(1862);
				double_starred_kvpairs();
				}
			}

			setState(1865);
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

	public static class Double_starred_kvpairsContext extends org.example.antlr.common.context.ExtendContext {
		public List<Double_starred_kvpairContext> double_starred_kvpair() {
			return getRuleContexts(Double_starred_kvpairContext.class);
		}
		public Double_starred_kvpairContext double_starred_kvpair(int i) {
			return getRuleContext(Double_starred_kvpairContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(PythonParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(PythonParser.COMMA, i);
		}
		public Double_starred_kvpairsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_double_starred_kvpairs; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterDouble_starred_kvpairs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitDouble_starred_kvpairs(this);
		}
	}

	public final Double_starred_kvpairsContext double_starred_kvpairs() throws RecognitionException {
		Double_starred_kvpairsContext _localctx = new Double_starred_kvpairsContext(_ctx, getState());
		enterRule(_localctx, 330, RULE_double_starred_kvpairs);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1867);
			double_starred_kvpair();
			setState(1872);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,239,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1868);
					match(COMMA);
					setState(1869);
					double_starred_kvpair();
					}
					} 
				}
				setState(1874);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,239,_ctx);
			}
			setState(1876);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(1875);
				match(COMMA);
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

	public static class Double_starred_kvpairContext extends org.example.antlr.common.context.ExtendContext {
		public TerminalNode DOUBLESTAR() { return getToken(PythonParser.DOUBLESTAR, 0); }
		public Bitwise_orContext bitwise_or() {
			return getRuleContext(Bitwise_orContext.class,0);
		}
		public KvpairContext kvpair() {
			return getRuleContext(KvpairContext.class,0);
		}
		public Double_starred_kvpairContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_double_starred_kvpair; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterDouble_starred_kvpair(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitDouble_starred_kvpair(this);
		}
	}

	public final Double_starred_kvpairContext double_starred_kvpair() throws RecognitionException {
		Double_starred_kvpairContext _localctx = new Double_starred_kvpairContext(_ctx, getState());
		enterRule(_localctx, 332, RULE_double_starred_kvpair);
		try {
			setState(1881);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DOUBLESTAR:
				enterOuterAlt(_localctx, 1);
				{
				setState(1878);
				match(DOUBLESTAR);
				setState(1879);
				bitwise_or(0);
				}
				break;
			case FSTRING_START:
			case LPAR:
			case LSQB:
			case LBRACE:
			case PLUS:
			case MINUS:
			case TILDE:
			case ELLIPSIS:
			case FALSE:
			case AWAIT:
			case NONE:
			case TRUE:
			case LAMBDA:
			case NOT:
			case NAME_OR_TYPE:
			case NAME_OR_MATCH:
			case NAME_OR_CASE:
			case NAME_OR_WILDCARD:
			case NAME:
			case NUMBER:
			case STRING:
				enterOuterAlt(_localctx, 2);
				{
				setState(1880);
				kvpair();
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

	public static class KvpairContext extends org.example.antlr.common.context.ExtendContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode COLON() { return getToken(PythonParser.COLON, 0); }
		public KvpairContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_kvpair; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterKvpair(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitKvpair(this);
		}
	}

	public final KvpairContext kvpair() throws RecognitionException {
		KvpairContext _localctx = new KvpairContext(_ctx, getState());
		enterRule(_localctx, 334, RULE_kvpair);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1883);
			expression();
			setState(1884);
			match(COLON);
			setState(1885);
			expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class For_if_clausesContext extends org.example.antlr.common.context.ExtendContext {
		public List<For_if_clauseContext> for_if_clause() {
			return getRuleContexts(For_if_clauseContext.class);
		}
		public For_if_clauseContext for_if_clause(int i) {
			return getRuleContext(For_if_clauseContext.class,i);
		}
		public For_if_clausesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_for_if_clauses; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterFor_if_clauses(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitFor_if_clauses(this);
		}
	}

	public final For_if_clausesContext for_if_clauses() throws RecognitionException {
		For_if_clausesContext _localctx = new For_if_clausesContext(_ctx, getState());
		enterRule(_localctx, 336, RULE_for_if_clauses);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1888); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(1887);
				for_if_clause();
				}
				}
				setState(1890); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==FOR || _la==ASYNC );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class For_if_clauseContext extends org.example.antlr.common.context.ExtendContext {
		public TerminalNode FOR() { return getToken(PythonParser.FOR, 0); }
		public Star_targetsContext star_targets() {
			return getRuleContext(Star_targetsContext.class,0);
		}
		public TerminalNode IN() { return getToken(PythonParser.IN, 0); }
		public List<DisjunctionContext> disjunction() {
			return getRuleContexts(DisjunctionContext.class);
		}
		public DisjunctionContext disjunction(int i) {
			return getRuleContext(DisjunctionContext.class,i);
		}
		public TerminalNode ASYNC() { return getToken(PythonParser.ASYNC, 0); }
		public List<TerminalNode> IF() { return getTokens(PythonParser.IF); }
		public TerminalNode IF(int i) {
			return getToken(PythonParser.IF, i);
		}
		public For_if_clauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_for_if_clause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterFor_if_clause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitFor_if_clause(this);
		}
	}

	public final For_if_clauseContext for_if_clause() throws RecognitionException {
		For_if_clauseContext _localctx = new For_if_clauseContext(_ctx, getState());
		enterRule(_localctx, 338, RULE_for_if_clause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1893);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ASYNC) {
				{
				setState(1892);
				match(ASYNC);
				}
			}

			setState(1895);
			match(FOR);
			setState(1896);
			star_targets();
			setState(1897);
			match(IN);
			setState(1898);
			disjunction();
			setState(1903);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==IF) {
				{
				{
				setState(1899);
				match(IF);
				setState(1900);
				disjunction();
				}
				}
				setState(1905);
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

	public static class ListcompContext extends org.example.antlr.common.context.ExtendContext {
		public TerminalNode LSQB() { return getToken(PythonParser.LSQB, 0); }
		public Named_expressionContext named_expression() {
			return getRuleContext(Named_expressionContext.class,0);
		}
		public For_if_clausesContext for_if_clauses() {
			return getRuleContext(For_if_clausesContext.class,0);
		}
		public TerminalNode RSQB() { return getToken(PythonParser.RSQB, 0); }
		public ListcompContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listcomp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterListcomp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitListcomp(this);
		}
	}

	public final ListcompContext listcomp() throws RecognitionException {
		ListcompContext _localctx = new ListcompContext(_ctx, getState());
		enterRule(_localctx, 340, RULE_listcomp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1906);
			match(LSQB);
			setState(1907);
			named_expression();
			setState(1908);
			for_if_clauses();
			setState(1909);
			match(RSQB);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SetcompContext extends org.example.antlr.common.context.ExtendContext {
		public TerminalNode LBRACE() { return getToken(PythonParser.LBRACE, 0); }
		public Named_expressionContext named_expression() {
			return getRuleContext(Named_expressionContext.class,0);
		}
		public For_if_clausesContext for_if_clauses() {
			return getRuleContext(For_if_clausesContext.class,0);
		}
		public TerminalNode RBRACE() { return getToken(PythonParser.RBRACE, 0); }
		public SetcompContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_setcomp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterSetcomp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitSetcomp(this);
		}
	}

	public final SetcompContext setcomp() throws RecognitionException {
		SetcompContext _localctx = new SetcompContext(_ctx, getState());
		enterRule(_localctx, 342, RULE_setcomp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1911);
			match(LBRACE);
			setState(1912);
			named_expression();
			setState(1913);
			for_if_clauses();
			setState(1914);
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

	public static class GenexpContext extends org.example.antlr.common.context.ExtendContext {
		public TerminalNode LPAR() { return getToken(PythonParser.LPAR, 0); }
		public For_if_clausesContext for_if_clauses() {
			return getRuleContext(For_if_clausesContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(PythonParser.RPAR, 0); }
		public Assignment_expressionContext assignment_expression() {
			return getRuleContext(Assignment_expressionContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public GenexpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_genexp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterGenexp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitGenexp(this);
		}
	}

	public final GenexpContext genexp() throws RecognitionException {
		GenexpContext _localctx = new GenexpContext(_ctx, getState());
		enterRule(_localctx, 344, RULE_genexp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1916);
			match(LPAR);
			setState(1919);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,245,_ctx) ) {
			case 1:
				{
				setState(1917);
				assignment_expression();
				}
				break;
			case 2:
				{
				setState(1918);
				expression();
				}
				break;
			}
			setState(1921);
			for_if_clauses();
			setState(1922);
			match(RPAR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DictcompContext extends org.example.antlr.common.context.ExtendContext {
		public TerminalNode LBRACE() { return getToken(PythonParser.LBRACE, 0); }
		public KvpairContext kvpair() {
			return getRuleContext(KvpairContext.class,0);
		}
		public For_if_clausesContext for_if_clauses() {
			return getRuleContext(For_if_clausesContext.class,0);
		}
		public TerminalNode RBRACE() { return getToken(PythonParser.RBRACE, 0); }
		public DictcompContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dictcomp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterDictcomp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitDictcomp(this);
		}
	}

	public final DictcompContext dictcomp() throws RecognitionException {
		DictcompContext _localctx = new DictcompContext(_ctx, getState());
		enterRule(_localctx, 346, RULE_dictcomp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1924);
			match(LBRACE);
			setState(1925);
			kvpair();
			setState(1926);
			for_if_clauses();
			setState(1927);
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

	public static class ArgumentsContext extends org.example.antlr.common.context.ExtendContext {
		public ArgsContext args() {
			return getRuleContext(ArgsContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(PythonParser.COMMA, 0); }
		public ArgumentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arguments; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterArguments(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitArguments(this);
		}
	}

	public final ArgumentsContext arguments() throws RecognitionException {
		ArgumentsContext _localctx = new ArgumentsContext(_ctx, getState());
		enterRule(_localctx, 348, RULE_arguments);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1929);
			args();
			setState(1931);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(1930);
				match(COMMA);
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

	public static class ArgsContext extends org.example.antlr.common.context.ExtendContext {
		public List<Starred_expressionContext> starred_expression() {
			return getRuleContexts(Starred_expressionContext.class);
		}
		public Starred_expressionContext starred_expression(int i) {
			return getRuleContext(Starred_expressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(PythonParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(PythonParser.COMMA, i);
		}
		public KwargsContext kwargs() {
			return getRuleContext(KwargsContext.class,0);
		}
		public List<Assignment_expressionContext> assignment_expression() {
			return getRuleContexts(Assignment_expressionContext.class);
		}
		public Assignment_expressionContext assignment_expression(int i) {
			return getRuleContext(Assignment_expressionContext.class,i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ArgsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_args; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterArgs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitArgs(this);
		}
	}

	public final ArgsContext args() throws RecognitionException {
		ArgsContext _localctx = new ArgsContext(_ctx, getState());
		enterRule(_localctx, 350, RULE_args);
		try {
			int _alt;
			setState(1958);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,253,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1938);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case STAR:
					{
					setState(1933);
					starred_expression();
					}
					break;
				case FSTRING_START:
				case LPAR:
				case LSQB:
				case LBRACE:
				case PLUS:
				case MINUS:
				case TILDE:
				case ELLIPSIS:
				case FALSE:
				case AWAIT:
				case NONE:
				case TRUE:
				case LAMBDA:
				case NOT:
				case NAME_OR_TYPE:
				case NAME_OR_MATCH:
				case NAME_OR_CASE:
				case NAME_OR_WILDCARD:
				case NAME:
				case NUMBER:
				case STRING:
					{
					setState(1936);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,247,_ctx) ) {
					case 1:
						{
						setState(1934);
						assignment_expression();
						}
						break;
					case 2:
						{
						setState(1935);
						expression();
						}
						break;
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1950);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,251,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(1940);
						match(COMMA);
						setState(1946);
						_errHandler.sync(this);
						switch (_input.LA(1)) {
						case STAR:
							{
							setState(1941);
							starred_expression();
							}
							break;
						case FSTRING_START:
						case LPAR:
						case LSQB:
						case LBRACE:
						case PLUS:
						case MINUS:
						case TILDE:
						case ELLIPSIS:
						case FALSE:
						case AWAIT:
						case NONE:
						case TRUE:
						case LAMBDA:
						case NOT:
						case NAME_OR_TYPE:
						case NAME_OR_MATCH:
						case NAME_OR_CASE:
						case NAME_OR_WILDCARD:
						case NAME:
						case NUMBER:
						case STRING:
							{
							setState(1944);
							_errHandler.sync(this);
							switch ( getInterpreter().adaptivePredict(_input,249,_ctx) ) {
							case 1:
								{
								setState(1942);
								assignment_expression();
								}
								break;
							case 2:
								{
								setState(1943);
								expression();
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
					setState(1952);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,251,_ctx);
				}
				setState(1955);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,252,_ctx) ) {
				case 1:
					{
					setState(1953);
					match(COMMA);
					setState(1954);
					kwargs();
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1957);
				kwargs();
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

	public static class KwargsContext extends org.example.antlr.common.context.ExtendContext {
		public List<Kwarg_or_starredContext> kwarg_or_starred() {
			return getRuleContexts(Kwarg_or_starredContext.class);
		}
		public Kwarg_or_starredContext kwarg_or_starred(int i) {
			return getRuleContext(Kwarg_or_starredContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(PythonParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(PythonParser.COMMA, i);
		}
		public List<Kwarg_or_double_starredContext> kwarg_or_double_starred() {
			return getRuleContexts(Kwarg_or_double_starredContext.class);
		}
		public Kwarg_or_double_starredContext kwarg_or_double_starred(int i) {
			return getRuleContext(Kwarg_or_double_starredContext.class,i);
		}
		public KwargsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_kwargs; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterKwargs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitKwargs(this);
		}
	}

	public final KwargsContext kwargs() throws RecognitionException {
		KwargsContext _localctx = new KwargsContext(_ctx, getState());
		enterRule(_localctx, 352, RULE_kwargs);
		try {
			int _alt;
			setState(1987);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,258,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1960);
				kwarg_or_starred();
				setState(1965);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,254,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(1961);
						match(COMMA);
						setState(1962);
						kwarg_or_starred();
						}
						} 
					}
					setState(1967);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,254,_ctx);
				}
				setState(1977);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,256,_ctx) ) {
				case 1:
					{
					setState(1968);
					match(COMMA);
					setState(1969);
					kwarg_or_double_starred();
					setState(1974);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,255,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(1970);
							match(COMMA);
							setState(1971);
							kwarg_or_double_starred();
							}
							} 
						}
						setState(1976);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,255,_ctx);
					}
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1979);
				kwarg_or_double_starred();
				setState(1984);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,257,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(1980);
						match(COMMA);
						setState(1981);
						kwarg_or_double_starred();
						}
						} 
					}
					setState(1986);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,257,_ctx);
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

	public static class Starred_expressionContext extends org.example.antlr.common.context.ExtendContext {
		public TerminalNode STAR() { return getToken(PythonParser.STAR, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public Starred_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_starred_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterStarred_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitStarred_expression(this);
		}
	}

	public final Starred_expressionContext starred_expression() throws RecognitionException {
		Starred_expressionContext _localctx = new Starred_expressionContext(_ctx, getState());
		enterRule(_localctx, 354, RULE_starred_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1989);
			match(STAR);
			setState(1990);
			expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Kwarg_or_starredContext extends org.example.antlr.common.context.ExtendContext {
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public TerminalNode EQUAL() { return getToken(PythonParser.EQUAL, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public Starred_expressionContext starred_expression() {
			return getRuleContext(Starred_expressionContext.class,0);
		}
		public Kwarg_or_starredContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_kwarg_or_starred; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterKwarg_or_starred(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitKwarg_or_starred(this);
		}
	}

	public final Kwarg_or_starredContext kwarg_or_starred() throws RecognitionException {
		Kwarg_or_starredContext _localctx = new Kwarg_or_starredContext(_ctx, getState());
		enterRule(_localctx, 356, RULE_kwarg_or_starred);
		try {
			setState(1997);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NAME_OR_TYPE:
			case NAME_OR_MATCH:
			case NAME_OR_CASE:
			case NAME_OR_WILDCARD:
			case NAME:
				enterOuterAlt(_localctx, 1);
				{
				setState(1992);
				name();
				setState(1993);
				match(EQUAL);
				setState(1994);
				expression();
				}
				break;
			case STAR:
				enterOuterAlt(_localctx, 2);
				{
				setState(1996);
				starred_expression();
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

	public static class Kwarg_or_double_starredContext extends org.example.antlr.common.context.ExtendContext {
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public TerminalNode EQUAL() { return getToken(PythonParser.EQUAL, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode DOUBLESTAR() { return getToken(PythonParser.DOUBLESTAR, 0); }
		public Kwarg_or_double_starredContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_kwarg_or_double_starred; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterKwarg_or_double_starred(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitKwarg_or_double_starred(this);
		}
	}

	public final Kwarg_or_double_starredContext kwarg_or_double_starred() throws RecognitionException {
		Kwarg_or_double_starredContext _localctx = new Kwarg_or_double_starredContext(_ctx, getState());
		enterRule(_localctx, 358, RULE_kwarg_or_double_starred);
		try {
			setState(2005);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NAME_OR_TYPE:
			case NAME_OR_MATCH:
			case NAME_OR_CASE:
			case NAME_OR_WILDCARD:
			case NAME:
				enterOuterAlt(_localctx, 1);
				{
				setState(1999);
				name();
				setState(2000);
				match(EQUAL);
				setState(2001);
				expression();
				}
				break;
			case DOUBLESTAR:
				enterOuterAlt(_localctx, 2);
				{
				setState(2003);
				match(DOUBLESTAR);
				setState(2004);
				expression();
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

	public static class Star_targetsContext extends org.example.antlr.common.context.ExtendContext {
		public List<Star_targetContext> star_target() {
			return getRuleContexts(Star_targetContext.class);
		}
		public Star_targetContext star_target(int i) {
			return getRuleContext(Star_targetContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(PythonParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(PythonParser.COMMA, i);
		}
		public Star_targetsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_star_targets; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterStar_targets(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitStar_targets(this);
		}
	}

	public final Star_targetsContext star_targets() throws RecognitionException {
		Star_targetsContext _localctx = new Star_targetsContext(_ctx, getState());
		enterRule(_localctx, 360, RULE_star_targets);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(2007);
			star_target();
			setState(2012);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,261,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(2008);
					match(COMMA);
					setState(2009);
					star_target();
					}
					} 
				}
				setState(2014);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,261,_ctx);
			}
			setState(2016);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(2015);
				match(COMMA);
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

	public static class Star_targets_list_seqContext extends org.example.antlr.common.context.ExtendContext {
		public List<Star_targetContext> star_target() {
			return getRuleContexts(Star_targetContext.class);
		}
		public Star_targetContext star_target(int i) {
			return getRuleContext(Star_targetContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(PythonParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(PythonParser.COMMA, i);
		}
		public Star_targets_list_seqContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_star_targets_list_seq; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterStar_targets_list_seq(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitStar_targets_list_seq(this);
		}
	}

	public final Star_targets_list_seqContext star_targets_list_seq() throws RecognitionException {
		Star_targets_list_seqContext _localctx = new Star_targets_list_seqContext(_ctx, getState());
		enterRule(_localctx, 362, RULE_star_targets_list_seq);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(2018);
			star_target();
			setState(2023);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,263,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(2019);
					match(COMMA);
					setState(2020);
					star_target();
					}
					} 
				}
				setState(2025);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,263,_ctx);
			}
			setState(2027);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(2026);
				match(COMMA);
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

	public static class Star_targets_tuple_seqContext extends org.example.antlr.common.context.ExtendContext {
		public List<Star_targetContext> star_target() {
			return getRuleContexts(Star_targetContext.class);
		}
		public Star_targetContext star_target(int i) {
			return getRuleContext(Star_targetContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(PythonParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(PythonParser.COMMA, i);
		}
		public Star_targets_tuple_seqContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_star_targets_tuple_seq; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterStar_targets_tuple_seq(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitStar_targets_tuple_seq(this);
		}
	}

	public final Star_targets_tuple_seqContext star_targets_tuple_seq() throws RecognitionException {
		Star_targets_tuple_seqContext _localctx = new Star_targets_tuple_seqContext(_ctx, getState());
		enterRule(_localctx, 364, RULE_star_targets_tuple_seq);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(2029);
			star_target();
			setState(2040);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,267,_ctx) ) {
			case 1:
				{
				setState(2030);
				match(COMMA);
				}
				break;
			case 2:
				{
				setState(2033); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(2031);
						match(COMMA);
						setState(2032);
						star_target();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(2035); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,265,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(2038);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(2037);
					match(COMMA);
					}
				}

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

	public static class Star_targetContext extends org.example.antlr.common.context.ExtendContext {
		public TerminalNode STAR() { return getToken(PythonParser.STAR, 0); }
		public Star_targetContext star_target() {
			return getRuleContext(Star_targetContext.class,0);
		}
		public Target_with_star_atomContext target_with_star_atom() {
			return getRuleContext(Target_with_star_atomContext.class,0);
		}
		public Star_targetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_star_target; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterStar_target(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitStar_target(this);
		}
	}

	public final Star_targetContext star_target() throws RecognitionException {
		Star_targetContext _localctx = new Star_targetContext(_ctx, getState());
		enterRule(_localctx, 366, RULE_star_target);
		try {
			setState(2045);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STAR:
				enterOuterAlt(_localctx, 1);
				{
				setState(2042);
				match(STAR);
				{
				setState(2043);
				star_target();
				}
				}
				break;
			case FSTRING_START:
			case LPAR:
			case LSQB:
			case LBRACE:
			case ELLIPSIS:
			case FALSE:
			case NONE:
			case TRUE:
			case NAME_OR_TYPE:
			case NAME_OR_MATCH:
			case NAME_OR_CASE:
			case NAME_OR_WILDCARD:
			case NAME:
			case NUMBER:
			case STRING:
				enterOuterAlt(_localctx, 2);
				{
				setState(2044);
				target_with_star_atom();
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

	public static class Target_with_star_atomContext extends org.example.antlr.common.context.ExtendContext {
		public T_primaryContext t_primary() {
			return getRuleContext(T_primaryContext.class,0);
		}
		public TerminalNode DOT() { return getToken(PythonParser.DOT, 0); }
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public TerminalNode LSQB() { return getToken(PythonParser.LSQB, 0); }
		public SlicesContext slices() {
			return getRuleContext(SlicesContext.class,0);
		}
		public TerminalNode RSQB() { return getToken(PythonParser.RSQB, 0); }
		public Star_atomContext star_atom() {
			return getRuleContext(Star_atomContext.class,0);
		}
		public Target_with_star_atomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_target_with_star_atom; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterTarget_with_star_atom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitTarget_with_star_atom(this);
		}
	}

	public final Target_with_star_atomContext target_with_star_atom() throws RecognitionException {
		Target_with_star_atomContext _localctx = new Target_with_star_atomContext(_ctx, getState());
		enterRule(_localctx, 368, RULE_target_with_star_atom);
		try {
			setState(2057);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,270,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2047);
				t_primary(0);
				setState(2054);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case DOT:
					{
					setState(2048);
					match(DOT);
					setState(2049);
					name();
					}
					break;
				case LSQB:
					{
					setState(2050);
					match(LSQB);
					setState(2051);
					slices();
					setState(2052);
					match(RSQB);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2056);
				star_atom();
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

	public static class Star_atomContext extends org.example.antlr.common.context.ExtendContext {
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public TerminalNode LPAR() { return getToken(PythonParser.LPAR, 0); }
		public Target_with_star_atomContext target_with_star_atom() {
			return getRuleContext(Target_with_star_atomContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(PythonParser.RPAR, 0); }
		public Star_targets_tuple_seqContext star_targets_tuple_seq() {
			return getRuleContext(Star_targets_tuple_seqContext.class,0);
		}
		public TerminalNode LSQB() { return getToken(PythonParser.LSQB, 0); }
		public TerminalNode RSQB() { return getToken(PythonParser.RSQB, 0); }
		public Star_targets_list_seqContext star_targets_list_seq() {
			return getRuleContext(Star_targets_list_seqContext.class,0);
		}
		public Star_atomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_star_atom; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterStar_atom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitStar_atom(this);
		}
	}

	public final Star_atomContext star_atom() throws RecognitionException {
		Star_atomContext _localctx = new Star_atomContext(_ctx, getState());
		enterRule(_localctx, 370, RULE_star_atom);
		int _la;
		try {
			setState(2074);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,273,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2059);
				name();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2060);
				match(LPAR);
				setState(2061);
				target_with_star_atom();
				setState(2062);
				match(RPAR);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2064);
				match(LPAR);
				setState(2066);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << FSTRING_START) | (1L << LPAR) | (1L << LSQB) | (1L << LBRACE) | (1L << STAR) | (1L << ELLIPSIS) | (1L << FALSE) | (1L << NONE))) != 0) || ((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & ((1L << (TRUE - 66)) | (1L << (NAME_OR_TYPE - 66)) | (1L << (NAME_OR_MATCH - 66)) | (1L << (NAME_OR_CASE - 66)) | (1L << (NAME_OR_WILDCARD - 66)) | (1L << (NAME - 66)) | (1L << (NUMBER - 66)) | (1L << (STRING - 66)))) != 0)) {
					{
					setState(2065);
					star_targets_tuple_seq();
					}
				}

				setState(2068);
				match(RPAR);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(2069);
				match(LSQB);
				setState(2071);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << FSTRING_START) | (1L << LPAR) | (1L << LSQB) | (1L << LBRACE) | (1L << STAR) | (1L << ELLIPSIS) | (1L << FALSE) | (1L << NONE))) != 0) || ((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & ((1L << (TRUE - 66)) | (1L << (NAME_OR_TYPE - 66)) | (1L << (NAME_OR_MATCH - 66)) | (1L << (NAME_OR_CASE - 66)) | (1L << (NAME_OR_WILDCARD - 66)) | (1L << (NAME - 66)) | (1L << (NUMBER - 66)) | (1L << (STRING - 66)))) != 0)) {
					{
					setState(2070);
					star_targets_list_seq();
					}
				}

				setState(2073);
				match(RSQB);
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

	public static class Single_targetContext extends org.example.antlr.common.context.ExtendContext {
		public Single_subscript_attribute_targetContext single_subscript_attribute_target() {
			return getRuleContext(Single_subscript_attribute_targetContext.class,0);
		}
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public TerminalNode LPAR() { return getToken(PythonParser.LPAR, 0); }
		public Single_targetContext single_target() {
			return getRuleContext(Single_targetContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(PythonParser.RPAR, 0); }
		public Single_targetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_single_target; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterSingle_target(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitSingle_target(this);
		}
	}

	public final Single_targetContext single_target() throws RecognitionException {
		Single_targetContext _localctx = new Single_targetContext(_ctx, getState());
		enterRule(_localctx, 372, RULE_single_target);
		try {
			setState(2082);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,274,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2076);
				single_subscript_attribute_target();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2077);
				name();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2078);
				match(LPAR);
				setState(2079);
				single_target();
				setState(2080);
				match(RPAR);
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

	public static class Single_subscript_attribute_targetContext extends org.example.antlr.common.context.ExtendContext {
		public T_primaryContext t_primary() {
			return getRuleContext(T_primaryContext.class,0);
		}
		public TerminalNode DOT() { return getToken(PythonParser.DOT, 0); }
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public TerminalNode LSQB() { return getToken(PythonParser.LSQB, 0); }
		public SlicesContext slices() {
			return getRuleContext(SlicesContext.class,0);
		}
		public TerminalNode RSQB() { return getToken(PythonParser.RSQB, 0); }
		public Single_subscript_attribute_targetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_single_subscript_attribute_target; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterSingle_subscript_attribute_target(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitSingle_subscript_attribute_target(this);
		}
	}

	public final Single_subscript_attribute_targetContext single_subscript_attribute_target() throws RecognitionException {
		Single_subscript_attribute_targetContext _localctx = new Single_subscript_attribute_targetContext(_ctx, getState());
		enterRule(_localctx, 374, RULE_single_subscript_attribute_target);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2084);
			t_primary(0);
			setState(2091);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DOT:
				{
				setState(2085);
				match(DOT);
				setState(2086);
				name();
				}
				break;
			case LSQB:
				{
				setState(2087);
				match(LSQB);
				setState(2088);
				slices();
				setState(2089);
				match(RSQB);
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

	public static class T_primaryContext extends org.example.antlr.common.context.ExtendContext {
		public AtomContext atom() {
			return getRuleContext(AtomContext.class,0);
		}
		public T_primaryContext t_primary() {
			return getRuleContext(T_primaryContext.class,0);
		}
		public TerminalNode DOT() { return getToken(PythonParser.DOT, 0); }
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public TerminalNode LSQB() { return getToken(PythonParser.LSQB, 0); }
		public SlicesContext slices() {
			return getRuleContext(SlicesContext.class,0);
		}
		public TerminalNode RSQB() { return getToken(PythonParser.RSQB, 0); }
		public GenexpContext genexp() {
			return getRuleContext(GenexpContext.class,0);
		}
		public TerminalNode LPAR() { return getToken(PythonParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(PythonParser.RPAR, 0); }
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public T_primaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_t_primary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterT_primary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitT_primary(this);
		}
	}

	public final T_primaryContext t_primary() throws RecognitionException {
		return t_primary(0);
	}

	private T_primaryContext t_primary(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		T_primaryContext _localctx = new T_primaryContext(_ctx, _parentState);
		T_primaryContext _prevctx = _localctx;
		int _startState = 376;
		enterRecursionRule(_localctx, 376, RULE_t_primary, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(2094);
			atom();
			}
			_ctx.stop = _input.LT(-1);
			setState(2113);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,278,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new T_primaryContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_t_primary);
					setState(2096);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(2109);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,277,_ctx) ) {
					case 1:
						{
						setState(2097);
						match(DOT);
						setState(2098);
						name();
						}
						break;
					case 2:
						{
						setState(2099);
						match(LSQB);
						setState(2100);
						slices();
						setState(2101);
						match(RSQB);
						}
						break;
					case 3:
						{
						setState(2103);
						genexp();
						}
						break;
					case 4:
						{
						setState(2104);
						match(LPAR);
						setState(2106);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << FSTRING_START) | (1L << LPAR) | (1L << LSQB) | (1L << LBRACE) | (1L << PLUS) | (1L << MINUS) | (1L << STAR) | (1L << TILDE) | (1L << DOUBLESTAR) | (1L << ELLIPSIS) | (1L << FALSE) | (1L << AWAIT) | (1L << NONE))) != 0) || ((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & ((1L << (TRUE - 66)) | (1L << (LAMBDA - 66)) | (1L << (NOT - 66)) | (1L << (NAME_OR_TYPE - 66)) | (1L << (NAME_OR_MATCH - 66)) | (1L << (NAME_OR_CASE - 66)) | (1L << (NAME_OR_WILDCARD - 66)) | (1L << (NAME - 66)) | (1L << (NUMBER - 66)) | (1L << (STRING - 66)))) != 0)) {
							{
							setState(2105);
							arguments();
							}
						}

						setState(2108);
						match(RPAR);
						}
						break;
					}
					}
					} 
				}
				setState(2115);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,278,_ctx);
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

	public static class Del_targetsContext extends org.example.antlr.common.context.ExtendContext {
		public List<Del_targetContext> del_target() {
			return getRuleContexts(Del_targetContext.class);
		}
		public Del_targetContext del_target(int i) {
			return getRuleContext(Del_targetContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(PythonParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(PythonParser.COMMA, i);
		}
		public Del_targetsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_del_targets; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterDel_targets(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitDel_targets(this);
		}
	}

	public final Del_targetsContext del_targets() throws RecognitionException {
		Del_targetsContext _localctx = new Del_targetsContext(_ctx, getState());
		enterRule(_localctx, 378, RULE_del_targets);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(2116);
			del_target();
			setState(2121);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,279,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(2117);
					match(COMMA);
					setState(2118);
					del_target();
					}
					} 
				}
				setState(2123);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,279,_ctx);
			}
			setState(2125);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(2124);
				match(COMMA);
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

	public static class Del_targetContext extends org.example.antlr.common.context.ExtendContext {
		public T_primaryContext t_primary() {
			return getRuleContext(T_primaryContext.class,0);
		}
		public TerminalNode DOT() { return getToken(PythonParser.DOT, 0); }
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public TerminalNode LSQB() { return getToken(PythonParser.LSQB, 0); }
		public SlicesContext slices() {
			return getRuleContext(SlicesContext.class,0);
		}
		public TerminalNode RSQB() { return getToken(PythonParser.RSQB, 0); }
		public Del_t_atomContext del_t_atom() {
			return getRuleContext(Del_t_atomContext.class,0);
		}
		public Del_targetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_del_target; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterDel_target(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitDel_target(this);
		}
	}

	public final Del_targetContext del_target() throws RecognitionException {
		Del_targetContext _localctx = new Del_targetContext(_ctx, getState());
		enterRule(_localctx, 380, RULE_del_target);
		try {
			setState(2137);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,282,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2127);
				t_primary(0);
				setState(2134);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case DOT:
					{
					setState(2128);
					match(DOT);
					setState(2129);
					name();
					}
					break;
				case LSQB:
					{
					setState(2130);
					match(LSQB);
					setState(2131);
					slices();
					setState(2132);
					match(RSQB);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2136);
				del_t_atom();
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

	public static class Del_t_atomContext extends org.example.antlr.common.context.ExtendContext {
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public TerminalNode LPAR() { return getToken(PythonParser.LPAR, 0); }
		public Del_targetContext del_target() {
			return getRuleContext(Del_targetContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(PythonParser.RPAR, 0); }
		public Del_targetsContext del_targets() {
			return getRuleContext(Del_targetsContext.class,0);
		}
		public TerminalNode LSQB() { return getToken(PythonParser.LSQB, 0); }
		public TerminalNode RSQB() { return getToken(PythonParser.RSQB, 0); }
		public Del_t_atomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_del_t_atom; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterDel_t_atom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitDel_t_atom(this);
		}
	}

	public final Del_t_atomContext del_t_atom() throws RecognitionException {
		Del_t_atomContext _localctx = new Del_t_atomContext(_ctx, getState());
		enterRule(_localctx, 382, RULE_del_t_atom);
		int _la;
		try {
			setState(2154);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,285,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2139);
				name();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2140);
				match(LPAR);
				setState(2141);
				del_target();
				setState(2142);
				match(RPAR);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2144);
				match(LPAR);
				setState(2146);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << FSTRING_START) | (1L << LPAR) | (1L << LSQB) | (1L << LBRACE) | (1L << ELLIPSIS) | (1L << FALSE) | (1L << NONE))) != 0) || ((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & ((1L << (TRUE - 66)) | (1L << (NAME_OR_TYPE - 66)) | (1L << (NAME_OR_MATCH - 66)) | (1L << (NAME_OR_CASE - 66)) | (1L << (NAME_OR_WILDCARD - 66)) | (1L << (NAME - 66)) | (1L << (NUMBER - 66)) | (1L << (STRING - 66)))) != 0)) {
					{
					setState(2145);
					del_targets();
					}
				}

				setState(2148);
				match(RPAR);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(2149);
				match(LSQB);
				setState(2151);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << FSTRING_START) | (1L << LPAR) | (1L << LSQB) | (1L << LBRACE) | (1L << ELLIPSIS) | (1L << FALSE) | (1L << NONE))) != 0) || ((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & ((1L << (TRUE - 66)) | (1L << (NAME_OR_TYPE - 66)) | (1L << (NAME_OR_MATCH - 66)) | (1L << (NAME_OR_CASE - 66)) | (1L << (NAME_OR_WILDCARD - 66)) | (1L << (NAME - 66)) | (1L << (NUMBER - 66)) | (1L << (STRING - 66)))) != 0)) {
					{
					setState(2150);
					del_targets();
					}
				}

				setState(2153);
				match(RSQB);
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

	public static class Type_expressionsContext extends org.example.antlr.common.context.ExtendContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(PythonParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(PythonParser.COMMA, i);
		}
		public TerminalNode STAR() { return getToken(PythonParser.STAR, 0); }
		public TerminalNode DOUBLESTAR() { return getToken(PythonParser.DOUBLESTAR, 0); }
		public Type_expressionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type_expressions; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterType_expressions(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitType_expressions(this);
		}
	}

	public final Type_expressionsContext type_expressions() throws RecognitionException {
		Type_expressionsContext _localctx = new Type_expressionsContext(_ctx, getState());
		enterRule(_localctx, 384, RULE_type_expressions);
		int _la;
		try {
			int _alt;
			setState(2187);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FSTRING_START:
			case LPAR:
			case LSQB:
			case LBRACE:
			case PLUS:
			case MINUS:
			case TILDE:
			case ELLIPSIS:
			case FALSE:
			case AWAIT:
			case NONE:
			case TRUE:
			case LAMBDA:
			case NOT:
			case NAME_OR_TYPE:
			case NAME_OR_MATCH:
			case NAME_OR_CASE:
			case NAME_OR_WILDCARD:
			case NAME:
			case NUMBER:
			case STRING:
				enterOuterAlt(_localctx, 1);
				{
				setState(2156);
				expression();
				setState(2161);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,286,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(2157);
						match(COMMA);
						setState(2158);
						expression();
						}
						} 
					}
					setState(2163);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,286,_ctx);
				}
				setState(2176);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(2164);
					match(COMMA);
					setState(2174);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case STAR:
						{
						setState(2165);
						match(STAR);
						setState(2166);
						expression();
						setState(2170);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(2167);
							match(COMMA);
							setState(2168);
							match(DOUBLESTAR);
							setState(2169);
							expression();
							}
						}

						}
						break;
					case DOUBLESTAR:
						{
						setState(2172);
						match(DOUBLESTAR);
						setState(2173);
						expression();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
				}

				}
				break;
			case STAR:
				enterOuterAlt(_localctx, 2);
				{
				setState(2178);
				match(STAR);
				setState(2179);
				expression();
				setState(2183);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(2180);
					match(COMMA);
					setState(2181);
					match(DOUBLESTAR);
					setState(2182);
					expression();
					}
				}

				}
				break;
			case DOUBLESTAR:
				enterOuterAlt(_localctx, 3);
				{
				setState(2185);
				match(DOUBLESTAR);
				setState(2186);
				expression();
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

	public static class Func_type_commentContext extends org.example.antlr.common.context.ExtendContext {
		public TerminalNode NEWLINE() { return getToken(PythonParser.NEWLINE, 0); }
		public TerminalNode TYPE_COMMENT() { return getToken(PythonParser.TYPE_COMMENT, 0); }
		public Func_type_commentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_func_type_comment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterFunc_type_comment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitFunc_type_comment(this);
		}
	}

	public final Func_type_commentContext func_type_comment() throws RecognitionException {
		Func_type_commentContext _localctx = new Func_type_commentContext(_ctx, getState());
		enterRule(_localctx, 386, RULE_func_type_comment);
		try {
			setState(2192);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NEWLINE:
				enterOuterAlt(_localctx, 1);
				{
				setState(2189);
				match(NEWLINE);
				setState(2190);
				match(TYPE_COMMENT);
				}
				break;
			case TYPE_COMMENT:
				enterOuterAlt(_localctx, 2);
				{
				setState(2191);
				match(TYPE_COMMENT);
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

	public static class Name_except_underscoreContext extends org.example.antlr.common.context.ExtendContext {
		public TerminalNode NAME() { return getToken(PythonParser.NAME, 0); }
		public TerminalNode NAME_OR_TYPE() { return getToken(PythonParser.NAME_OR_TYPE, 0); }
		public TerminalNode NAME_OR_MATCH() { return getToken(PythonParser.NAME_OR_MATCH, 0); }
		public TerminalNode NAME_OR_CASE() { return getToken(PythonParser.NAME_OR_CASE, 0); }
		public Name_except_underscoreContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_name_except_underscore; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterName_except_underscore(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitName_except_underscore(this);
		}
	}

	public final Name_except_underscoreContext name_except_underscore() throws RecognitionException {
		Name_except_underscoreContext _localctx = new Name_except_underscoreContext(_ctx, getState());
		enterRule(_localctx, 388, RULE_name_except_underscore);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2194);
			_la = _input.LA(1);
			if ( !(((((_la - 91)) & ~0x3f) == 0 && ((1L << (_la - 91)) & ((1L << (NAME_OR_TYPE - 91)) | (1L << (NAME_OR_MATCH - 91)) | (1L << (NAME_OR_CASE - 91)) | (1L << (NAME - 91)))) != 0)) ) {
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

	public static class NameContext extends org.example.antlr.common.context.ExtendContext {
		public TerminalNode NAME_OR_WILDCARD() { return getToken(PythonParser.NAME_OR_WILDCARD, 0); }
		public Name_except_underscoreContext name_except_underscore() {
			return getRuleContext(Name_except_underscoreContext.class,0);
		}
		public NameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitName(this);
		}
	}

	public final NameContext name() throws RecognitionException {
		NameContext _localctx = new NameContext(_ctx, getState());
		enterRule(_localctx, 390, RULE_name);
		try {
			setState(2198);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NAME_OR_WILDCARD:
				enterOuterAlt(_localctx, 1);
				{
				setState(2196);
				match(NAME_OR_WILDCARD);
				}
				break;
			case NAME_OR_TYPE:
			case NAME_OR_MATCH:
			case NAME_OR_CASE:
			case NAME:
				enterOuterAlt(_localctx, 2);
				{
				setState(2197);
				name_except_underscore();
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 28:
			return dotted_name_sempred((Dotted_nameContext)_localctx, predIndex);
		case 128:
			return bitwise_or_sempred((Bitwise_orContext)_localctx, predIndex);
		case 129:
			return bitwise_xor_sempred((Bitwise_xorContext)_localctx, predIndex);
		case 130:
			return bitwise_and_sempred((Bitwise_andContext)_localctx, predIndex);
		case 131:
			return shift_expr_sempred((Shift_exprContext)_localctx, predIndex);
		case 132:
			return sum_sempred((SumContext)_localctx, predIndex);
		case 133:
			return term_sempred((TermContext)_localctx, predIndex);
		case 137:
			return primary_sempred((PrimaryContext)_localctx, predIndex);
		case 188:
			return t_primary_sempred((T_primaryContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean dotted_name_sempred(Dotted_nameContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean bitwise_or_sempred(Bitwise_orContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean bitwise_xor_sempred(Bitwise_xorContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean bitwise_and_sempred(Bitwise_andContext _localctx, int predIndex) {
		switch (predIndex) {
		case 3:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean shift_expr_sempred(Shift_exprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 4:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean sum_sempred(SumContext _localctx, int predIndex) {
		switch (predIndex) {
		case 5:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean term_sempred(TermContext _localctx, int predIndex) {
		switch (predIndex) {
		case 6:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean primary_sempred(PrimaryContext _localctx, int predIndex) {
		switch (predIndex) {
		case 7:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean t_primary_sempred(T_primaryContext _localctx, int predIndex) {
		switch (predIndex) {
		case 8:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3h\u089b\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
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
		"\t\u00c4\4\u00c5\t\u00c5\3\2\5\2\u018c\n\2\3\2\3\2\3\3\3\3\3\4\3\4\7\4"+
		"\u0194\n\4\f\4\16\4\u0197\13\4\3\4\3\4\3\5\3\5\5\5\u019d\n\5\3\5\3\5\3"+
		"\5\3\5\7\5\u01a3\n\5\f\5\16\5\u01a6\13\5\3\5\3\5\3\6\6\6\u01ab\n\6\r\6"+
		"\16\6\u01ac\3\7\3\7\5\7\u01b1\n\7\3\b\3\b\3\b\3\b\3\b\3\b\5\b\u01b9\n"+
		"\b\3\t\3\t\3\t\7\t\u01be\n\t\f\t\16\t\u01c1\13\t\3\t\5\t\u01c4\n\t\3\t"+
		"\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u01d6"+
		"\n\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u01e0\n\13\3\f\3\f\3"+
		"\f\3\f\3\f\5\f\u01e7\n\f\3\f\3\f\3\f\3\f\3\f\5\f\u01ee\n\f\3\f\3\f\3\f"+
		"\3\f\5\f\u01f4\n\f\3\f\3\f\3\f\6\f\u01f9\n\f\r\f\16\f\u01fa\3\f\3\f\5"+
		"\f\u01ff\n\f\3\f\5\f\u0202\n\f\3\f\3\f\3\f\3\f\5\f\u0208\n\f\5\f\u020a"+
		"\n\f\3\r\3\r\5\r\u020e\n\r\3\16\3\16\3\17\3\17\5\17\u0214\n\17\3\20\3"+
		"\20\3\20\3\20\5\20\u021a\n\20\5\20\u021c\n\20\3\21\3\21\3\21\3\21\7\21"+
		"\u0222\n\21\f\21\16\21\u0225\13\21\3\22\3\22\3\22\3\22\7\22\u022b\n\22"+
		"\f\22\16\22\u022e\13\22\3\23\3\23\3\23\3\24\3\24\3\25\3\25\3\25\3\25\5"+
		"\25\u0239\n\25\3\26\3\26\5\26\u023d\n\26\3\27\3\27\3\27\3\30\3\30\7\30"+
		"\u0244\n\30\f\30\16\30\u0247\13\30\3\30\3\30\3\30\3\30\3\30\3\30\6\30"+
		"\u024f\n\30\r\30\16\30\u0250\3\30\3\30\5\30\u0255\n\30\3\31\3\31\3\31"+
		"\5\31\u025a\n\31\3\31\3\31\3\31\3\31\5\31\u0260\n\31\3\32\3\32\3\32\7"+
		"\32\u0265\n\32\f\32\16\32\u0268\13\32\3\33\3\33\3\33\5\33\u026d\n\33\3"+
		"\34\3\34\3\34\7\34\u0272\n\34\f\34\16\34\u0275\13\34\3\35\3\35\3\35\5"+
		"\35\u027a\n\35\3\36\3\36\3\36\3\36\3\36\3\36\7\36\u0282\n\36\f\36\16\36"+
		"\u0285\13\36\3\37\3\37\3\37\3\37\3\37\3\37\5\37\u028d\n\37\3 \3 \3 \3"+
		" \6 \u0293\n \r \16 \u0294\3!\3!\3!\3!\5!\u029b\n!\3\"\3\"\3\"\5\"\u02a0"+
		"\n\"\3\"\3\"\5\"\u02a4\n\"\3\"\5\"\u02a7\n\"\3\"\3\"\3\"\3#\3#\3#\3#\5"+
		"#\u02b0\n#\3$\3$\3$\5$\u02b5\n$\3$\3$\5$\u02b9\n$\3$\3$\3$\5$\u02be\n"+
		"$\3$\3$\5$\u02c2\n$\3$\3$\3$\3$\3$\3$\5$\u02ca\n$\3$\3$\5$\u02ce\n$\3"+
		"$\3$\3$\5$\u02d3\n$\3$\3$\5$\u02d7\n$\3$\3$\5$\u02db\n$\3%\3%\3&\3&\7"+
		"&\u02e1\n&\f&\16&\u02e4\13&\3&\7&\u02e7\n&\f&\16&\u02ea\13&\3&\5&\u02ed"+
		"\n&\3&\3&\7&\u02f1\n&\f&\16&\u02f4\13&\3&\5&\u02f7\n&\3&\6&\u02fa\n&\r"+
		"&\16&\u02fb\3&\7&\u02ff\n&\f&\16&\u0302\13&\3&\5&\u0305\n&\3&\6&\u0308"+
		"\n&\r&\16&\u0309\3&\5&\u030d\n&\3&\5&\u0310\n&\3\'\6\'\u0313\n\'\r\'\16"+
		"\'\u0314\3\'\3\'\5\'\u0319\n\'\3(\7(\u031c\n(\f(\16(\u031f\13(\3(\6(\u0322"+
		"\n(\r(\16(\u0323\3(\3(\5(\u0328\n(\3)\3)\3)\7)\u032d\n)\f)\16)\u0330\13"+
		")\3)\5)\u0333\n)\3)\3)\3)\7)\u0338\n)\f)\16)\u033b\13)\3)\5)\u033e\n)"+
		"\3)\3)\3)\6)\u0343\n)\r)\16)\u0344\3)\5)\u0348\n)\3)\5)\u034b\n)\3*\3"+
		"*\3*\3+\3+\5+\u0352\n+\3+\5+\u0355\n+\3,\3,\5,\u0359\n,\3,\5,\u035c\n"+
		",\3-\3-\3-\5-\u0361\n-\3-\5-\u0364\n-\3.\3.\5.\u0368\n.\3.\5.\u036b\n"+
		".\3.\5.\u036e\n.\3/\3/\5/\u0372\n/\3\60\3\60\3\60\3\61\3\61\3\61\3\62"+
		"\3\62\3\62\3\63\3\63\3\63\3\64\3\64\3\64\3\64\3\64\3\64\5\64\u0386\n\64"+
		"\5\64\u0388\n\64\3\65\3\65\3\65\3\65\3\65\3\65\5\65\u0390\n\65\5\65\u0392"+
		"\n\65\3\66\3\66\3\66\3\66\3\67\3\67\3\67\3\67\3\67\5\67\u039d\n\67\38"+
		"\58\u03a0\n8\38\38\38\38\38\38\58\u03a8\n8\38\38\58\u03ac\n8\39\39\39"+
		"\39\39\79\u03b3\n9\f9\169\u03b6\139\39\59\u03b9\n9\39\39\39\59\u03be\n"+
		"9\39\39\39\39\39\39\39\39\79\u03c8\n9\f9\169\u03cb\139\39\59\u03ce\n9"+
		"\39\39\39\39\39\59\u03d5\n9\39\39\39\39\79\u03db\n9\f9\169\u03de\139\3"+
		"9\39\59\u03e2\n9\39\39\59\u03e6\n9\3:\3:\3:\5:\u03eb\n:\3;\3;\3;\3;\3"+
		";\3;\3;\3;\3;\6;\u03f6\n;\r;\16;\u03f7\3;\5;\u03fb\n;\3;\5;\u03fe\n;\3"+
		";\3;\3;\3;\6;\u0404\n;\r;\16;\u0405\3;\5;\u0409\n;\3;\5;\u040c\n;\5;\u040e"+
		"\n;\3<\3<\3<\3<\5<\u0414\n<\5<\u0416\n<\3<\3<\3<\3=\3=\3=\3=\3=\5=\u0420"+
		"\n=\3=\3=\3=\3>\3>\3>\3>\3?\3?\3?\3?\3?\3?\6?\u042f\n?\r?\16?\u0430\3"+
		"?\3?\3@\3@\3@\5@\u0438\n@\3@\5@\u043b\n@\3A\3A\3A\5A\u0440\nA\3A\3A\3"+
		"A\3B\3B\3B\3C\3C\5C\u044a\nC\3D\3D\5D\u044e\nD\3E\3E\3E\3E\3F\3F\3F\7"+
		"F\u0457\nF\fF\16F\u045a\13F\3G\3G\3G\3G\3G\3G\3G\3G\5G\u0464\nG\3H\3H"+
		"\3H\3H\3H\3H\5H\u046c\nH\3I\3I\3I\3I\3I\3I\5I\u0474\nI\3J\3J\3J\3J\3K"+
		"\5K\u047b\nK\3K\3K\3L\5L\u0480\nL\3L\3L\3M\3M\3N\3N\3O\3O\3P\3P\3Q\3Q"+
		"\3R\3R\3S\3S\3S\6S\u0493\nS\rS\16S\u0494\3T\3T\3T\7T\u049a\nT\fT\16T\u049d"+
		"\13T\3U\3U\3U\3U\3V\3V\5V\u04a5\nV\3V\3V\3V\5V\u04aa\nV\3V\5V\u04ad\n"+
		"V\3W\3W\3W\5W\u04b2\nW\3X\3X\3X\7X\u04b7\nX\fX\16X\u04ba\13X\3X\5X\u04bd"+
		"\nX\3Y\3Y\5Y\u04c1\nY\3Z\3Z\3Z\3[\3[\3[\3[\3[\5[\u04cb\n[\3[\3[\3[\3["+
		"\3[\3[\5[\u04d3\n[\3[\5[\u04d6\n[\3[\3[\5[\u04da\n[\3\\\3\\\3\\\7\\\u04df"+
		"\n\\\f\\\16\\\u04e2\13\\\3]\3]\5]\u04e6\n]\3]\3]\3]\3^\3^\3^\3_\3_\3_"+
		"\3_\3_\5_\u04f3\n_\3_\5_\u04f6\n_\3_\5_\u04f9\n_\5_\u04fb\n_\3_\3_\3`"+
		"\3`\3`\7`\u0502\n`\f`\16`\u0505\13`\3a\3a\3a\7a\u050a\na\fa\16a\u050d"+
		"\13a\3b\3b\3b\3b\3c\3c\3c\5c\u0516\nc\3c\3c\3c\3d\3d\3d\3d\3e\3e\3e\7"+
		"e\u0522\ne\fe\16e\u0525\13e\3e\5e\u0528\ne\3f\3f\5f\u052c\nf\3f\5f\u052f"+
		"\nf\3f\3f\3f\5f\u0534\nf\3f\3f\3f\5f\u0539\nf\5f\u053b\nf\3g\3g\3g\3h"+
		"\3h\3h\3i\3i\3i\3j\3j\3j\7j\u0549\nj\fj\16j\u054c\13j\3j\5j\u054f\nj\3"+
		"k\3k\3k\3k\3k\3k\5k\u0557\nk\3k\5k\u055a\nk\3l\3l\3l\3l\5l\u0560\nl\5"+
		"l\u0562\nl\3m\3m\3m\7m\u0567\nm\fm\16m\u056a\13m\3m\5m\u056d\nm\3n\3n"+
		"\3n\5n\u0572\nn\3o\3o\3o\7o\u0577\no\fo\16o\u057a\13o\3o\5o\u057d\no\3"+
		"p\3p\3p\5p\u0582\np\3q\3q\3q\3q\3r\3r\5r\u058a\nr\3s\3s\3s\7s\u058f\n"+
		"s\fs\16s\u0592\13s\3t\3t\3t\7t\u0597\nt\ft\16t\u059a\13t\3u\3u\3u\5u\u059f"+
		"\nu\3v\3v\7v\u05a3\nv\fv\16v\u05a6\13v\3w\3w\3w\3w\3w\3w\3w\3w\3w\3w\5"+
		"w\u05b2\nw\3x\3x\3x\3y\3y\3y\3z\3z\3z\3{\3{\3{\3|\3|\3|\3}\3}\3}\3~\3"+
		"~\3~\3~\3\177\3\177\3\177\3\u0080\3\u0080\3\u0080\3\u0080\3\u0081\3\u0081"+
		"\3\u0081\3\u0082\3\u0082\3\u0082\3\u0082\3\u0082\3\u0082\7\u0082\u05da"+
		"\n\u0082\f\u0082\16\u0082\u05dd\13\u0082\3\u0083\3\u0083\3\u0083\3\u0083"+
		"\3\u0083\3\u0083\7\u0083\u05e5\n\u0083\f\u0083\16\u0083\u05e8\13\u0083"+
		"\3\u0084\3\u0084\3\u0084\3\u0084\3\u0084\3\u0084\7\u0084\u05f0\n\u0084"+
		"\f\u0084\16\u0084\u05f3\13\u0084\3\u0085\3\u0085\3\u0085\3\u0085\3\u0085"+
		"\3\u0085\7\u0085\u05fb\n\u0085\f\u0085\16\u0085\u05fe\13\u0085\3\u0086"+
		"\3\u0086\3\u0086\3\u0086\3\u0086\3\u0086\7\u0086\u0606\n\u0086\f\u0086"+
		"\16\u0086\u0609\13\u0086\3\u0087\3\u0087\3\u0087\3\u0087\3\u0087\3\u0087"+
		"\7\u0087\u0611\n\u0087\f\u0087\16\u0087\u0614\13\u0087\3\u0088\3\u0088"+
		"\3\u0088\3\u0088\3\u0088\3\u0088\3\u0088\5\u0088\u061d\n\u0088\3\u0089"+
		"\3\u0089\3\u0089\5\u0089\u0622\n\u0089\3\u008a\3\u008a\3\u008a\5\u008a"+
		"\u0627\n\u008a\3\u008b\3\u008b\3\u008b\3\u008b\3\u008b\3\u008b\3\u008b"+
		"\3\u008b\3\u008b\5\u008b\u0632\n\u008b\3\u008b\3\u008b\3\u008b\3\u008b"+
		"\3\u008b\5\u008b\u0639\n\u008b\7\u008b\u063b\n\u008b\f\u008b\16\u008b"+
		"\u063e\13\u008b\3\u008c\3\u008c\3\u008c\5\u008c\u0643\n\u008c\3\u008c"+
		"\3\u008c\3\u008c\5\u008c\u0648\n\u008c\7\u008c\u064a\n\u008c\f\u008c\16"+
		"\u008c\u064d\13\u008c\3\u008c\5\u008c\u0650\n\u008c\5\u008c\u0652\n\u008c"+
		"\3\u008d\5\u008d\u0655\n\u008d\3\u008d\3\u008d\5\u008d\u0659\n\u008d\3"+
		"\u008d\3\u008d\5\u008d\u065d\n\u008d\5\u008d\u065f\n\u008d\3\u008d\5\u008d"+
		"\u0662\n\u008d\3\u008e\3\u008e\3\u008e\3\u008e\3\u008e\3\u008e\3\u008e"+
		"\3\u008e\3\u008e\5\u008e\u066d\n\u008e\3\u008e\3\u008e\5\u008e\u0671\n"+
		"\u008e\3\u008e\3\u008e\3\u008e\3\u008e\5\u008e\u0677\n\u008e\3\u008e\5"+
		"\u008e\u067a\n\u008e\3\u008f\3\u008f\3\u008f\5\u008f\u067f\n\u008f\3\u008f"+
		"\3\u008f\3\u0090\3\u0090\5\u0090\u0685\n\u0090\3\u0090\3\u0090\3\u0090"+
		"\3\u0091\3\u0091\3\u0092\3\u0092\7\u0092\u068e\n\u0092\f\u0092\16\u0092"+
		"\u0691\13\u0092\3\u0092\7\u0092\u0694\n\u0092\f\u0092\16\u0092\u0697\13"+
		"\u0092\3\u0092\5\u0092\u069a\n\u0092\3\u0092\3\u0092\7\u0092\u069e\n\u0092"+
		"\f\u0092\16\u0092\u06a1\13\u0092\3\u0092\5\u0092\u06a4\n\u0092\3\u0092"+
		"\6\u0092\u06a7\n\u0092\r\u0092\16\u0092\u06a8\3\u0092\7\u0092\u06ac\n"+
		"\u0092\f\u0092\16\u0092\u06af\13\u0092\3\u0092\5\u0092\u06b2\n\u0092\3"+
		"\u0092\6\u0092\u06b5\n\u0092\r\u0092\16\u0092\u06b6\3\u0092\5\u0092\u06ba"+
		"\n\u0092\3\u0092\5\u0092\u06bd\n\u0092\3\u0093\6\u0093\u06c0\n\u0093\r"+
		"\u0093\16\u0093\u06c1\3\u0093\3\u0093\5\u0093\u06c6\n\u0093\3\u0094\7"+
		"\u0094\u06c9\n\u0094\f\u0094\16\u0094\u06cc\13\u0094\3\u0094\6\u0094\u06cf"+
		"\n\u0094\r\u0094\16\u0094\u06d0\3\u0094\3\u0094\5\u0094\u06d5\n\u0094"+
		"\3\u0095\3\u0095\3\u0095\7\u0095\u06da\n\u0095\f\u0095\16\u0095\u06dd"+
		"\13\u0095\3\u0095\5\u0095\u06e0\n\u0095\3\u0095\3\u0095\3\u0095\6\u0095"+
		"\u06e5\n\u0095\r\u0095\16\u0095\u06e6\3\u0095\5\u0095\u06ea\n\u0095\3"+
		"\u0095\5\u0095\u06ed\n\u0095\3\u0096\3\u0096\3\u0096\3\u0097\3\u0097\5"+
		"\u0097\u06f4\n\u0097\3\u0098\3\u0098\3\u0098\5\u0098\u06f9\n\u0098\3\u0099"+
		"\3\u0099\5\u0099\u06fd\n\u0099\3\u0099\5\u0099\u0700\n\u0099\3\u009a\3"+
		"\u009a\3\u009b\3\u009b\5\u009b\u0706\n\u009b\3\u009c\3\u009c\3\u009c\5"+
		"\u009c\u070b\n\u009c\3\u009c\5\u009c\u070e\n\u009c\3\u009c\5\u009c\u0711"+
		"\n\u009c\3\u009c\3\u009c\3\u009d\3\u009d\3\u009d\3\u009e\3\u009e\7\u009e"+
		"\u071a\n\u009e\f\u009e\16\u009e\u071d\13\u009e\3\u009f\3\u009f\5\u009f"+
		"\u0721\n\u009f\3\u00a0\3\u00a0\7\u00a0\u0725\n\u00a0\f\u00a0\16\u00a0"+
		"\u0728\13\u00a0\3\u00a0\3\u00a0\3\u00a1\3\u00a1\3\u00a2\3\u00a2\6\u00a2"+
		"\u0730\n\u00a2\r\u00a2\16\u00a2\u0731\3\u00a3\3\u00a3\5\u00a3\u0736\n"+
		"\u00a3\3\u00a3\3\u00a3\3\u00a4\3\u00a4\3\u00a4\3\u00a4\5\u00a4\u073e\n"+
		"\u00a4\5\u00a4\u0740\n\u00a4\3\u00a4\3\u00a4\3\u00a5\3\u00a5\3\u00a5\3"+
		"\u00a5\3\u00a6\3\u00a6\5\u00a6\u074a\n\u00a6\3\u00a6\3\u00a6\3\u00a7\3"+
		"\u00a7\3\u00a7\7\u00a7\u0751\n\u00a7\f\u00a7\16\u00a7\u0754\13\u00a7\3"+
		"\u00a7\5\u00a7\u0757\n\u00a7\3\u00a8\3\u00a8\3\u00a8\5\u00a8\u075c\n\u00a8"+
		"\3\u00a9\3\u00a9\3\u00a9\3\u00a9\3\u00aa\6\u00aa\u0763\n\u00aa\r\u00aa"+
		"\16\u00aa\u0764\3\u00ab\5\u00ab\u0768\n\u00ab\3\u00ab\3\u00ab\3\u00ab"+
		"\3\u00ab\3\u00ab\3\u00ab\7\u00ab\u0770\n\u00ab\f\u00ab\16\u00ab\u0773"+
		"\13\u00ab\3\u00ac\3\u00ac\3\u00ac\3\u00ac\3\u00ac\3\u00ad\3\u00ad\3\u00ad"+
		"\3\u00ad\3\u00ad\3\u00ae\3\u00ae\3\u00ae\5\u00ae\u0782\n\u00ae\3\u00ae"+
		"\3\u00ae\3\u00ae\3\u00af\3\u00af\3\u00af\3\u00af\3\u00af\3\u00b0\3\u00b0"+
		"\5\u00b0\u078e\n\u00b0\3\u00b1\3\u00b1\3\u00b1\5\u00b1\u0793\n\u00b1\5"+
		"\u00b1\u0795\n\u00b1\3\u00b1\3\u00b1\3\u00b1\3\u00b1\5\u00b1\u079b\n\u00b1"+
		"\5\u00b1\u079d\n\u00b1\7\u00b1\u079f\n\u00b1\f\u00b1\16\u00b1\u07a2\13"+
		"\u00b1\3\u00b1\3\u00b1\5\u00b1\u07a6\n\u00b1\3\u00b1\5\u00b1\u07a9\n\u00b1"+
		"\3\u00b2\3\u00b2\3\u00b2\7\u00b2\u07ae\n\u00b2\f\u00b2\16\u00b2\u07b1"+
		"\13\u00b2\3\u00b2\3\u00b2\3\u00b2\3\u00b2\7\u00b2\u07b7\n\u00b2\f\u00b2"+
		"\16\u00b2\u07ba\13\u00b2\5\u00b2\u07bc\n\u00b2\3\u00b2\3\u00b2\3\u00b2"+
		"\7\u00b2\u07c1\n\u00b2\f\u00b2\16\u00b2\u07c4\13\u00b2\5\u00b2\u07c6\n"+
		"\u00b2\3\u00b3\3\u00b3\3\u00b3\3\u00b4\3\u00b4\3\u00b4\3\u00b4\3\u00b4"+
		"\5\u00b4\u07d0\n\u00b4\3\u00b5\3\u00b5\3\u00b5\3\u00b5\3\u00b5\3\u00b5"+
		"\5\u00b5\u07d8\n\u00b5\3\u00b6\3\u00b6\3\u00b6\7\u00b6\u07dd\n\u00b6\f"+
		"\u00b6\16\u00b6\u07e0\13\u00b6\3\u00b6\5\u00b6\u07e3\n\u00b6\3\u00b7\3"+
		"\u00b7\3\u00b7\7\u00b7\u07e8\n\u00b7\f\u00b7\16\u00b7\u07eb\13\u00b7\3"+
		"\u00b7\5\u00b7\u07ee\n\u00b7\3\u00b8\3\u00b8\3\u00b8\3\u00b8\6\u00b8\u07f4"+
		"\n\u00b8\r\u00b8\16\u00b8\u07f5\3\u00b8\5\u00b8\u07f9\n\u00b8\5\u00b8"+
		"\u07fb\n\u00b8\3\u00b9\3\u00b9\3\u00b9\5\u00b9\u0800\n\u00b9\3\u00ba\3"+
		"\u00ba\3\u00ba\3\u00ba\3\u00ba\3\u00ba\3\u00ba\5\u00ba\u0809\n\u00ba\3"+
		"\u00ba\5\u00ba\u080c\n\u00ba\3\u00bb\3\u00bb\3\u00bb\3\u00bb\3\u00bb\3"+
		"\u00bb\3\u00bb\5\u00bb\u0815\n\u00bb\3\u00bb\3\u00bb\3\u00bb\5\u00bb\u081a"+
		"\n\u00bb\3\u00bb\5\u00bb\u081d\n\u00bb\3\u00bc\3\u00bc\3\u00bc\3\u00bc"+
		"\3\u00bc\3\u00bc\5\u00bc\u0825\n\u00bc\3\u00bd\3\u00bd\3\u00bd\3\u00bd"+
		"\3\u00bd\3\u00bd\3\u00bd\5\u00bd\u082e\n\u00bd\3\u00be\3\u00be\3\u00be"+
		"\3\u00be\3\u00be\3\u00be\3\u00be\3\u00be\3\u00be\3\u00be\3\u00be\3\u00be"+
		"\3\u00be\5\u00be\u083d\n\u00be\3\u00be\5\u00be\u0840\n\u00be\7\u00be\u0842"+
		"\n\u00be\f\u00be\16\u00be\u0845\13\u00be\3\u00bf\3\u00bf\3\u00bf\7\u00bf"+
		"\u084a\n\u00bf\f\u00bf\16\u00bf\u084d\13\u00bf\3\u00bf\5\u00bf\u0850\n"+
		"\u00bf\3\u00c0\3\u00c0\3\u00c0\3\u00c0\3\u00c0\3\u00c0\3\u00c0\5\u00c0"+
		"\u0859\n\u00c0\3\u00c0\5\u00c0\u085c\n\u00c0\3\u00c1\3\u00c1\3\u00c1\3"+
		"\u00c1\3\u00c1\3\u00c1\3\u00c1\5\u00c1\u0865\n\u00c1\3\u00c1\3\u00c1\3"+
		"\u00c1\5\u00c1\u086a\n\u00c1\3\u00c1\5\u00c1\u086d\n\u00c1\3\u00c2\3\u00c2"+
		"\3\u00c2\7\u00c2\u0872\n\u00c2\f\u00c2\16\u00c2\u0875\13\u00c2\3\u00c2"+
		"\3\u00c2\3\u00c2\3\u00c2\3\u00c2\3\u00c2\5\u00c2\u087d\n\u00c2\3\u00c2"+
		"\3\u00c2\5\u00c2\u0881\n\u00c2\5\u00c2\u0883\n\u00c2\3\u00c2\3\u00c2\3"+
		"\u00c2\3\u00c2\3\u00c2\5\u00c2\u088a\n\u00c2\3\u00c2\3\u00c2\5\u00c2\u088e"+
		"\n\u00c2\3\u00c3\3\u00c3\3\u00c3\5\u00c3\u0893\n\u00c3\3\u00c4\3\u00c4"+
		"\3\u00c5\3\u00c5\5\u00c5\u0899\n\u00c5\3\u00c5\2\13:\u0102\u0104\u0106"+
		"\u0108\u010a\u010c\u0114\u017a\u00c6\2\4\6\b\n\f\16\20\22\24\26\30\32"+
		"\34\36 \"$&(*,.\60\62\64\668:<>@BDFHJLNPRTVXZ\\^`bdfhjlnprtvxz|~\u0080"+
		"\u0082\u0084\u0086\u0088\u008a\u008c\u008e\u0090\u0092\u0094\u0096\u0098"+
		"\u009a\u009c\u009e\u00a0\u00a2\u00a4\u00a6\u00a8\u00aa\u00ac\u00ae\u00b0"+
		"\u00b2\u00b4\u00b6\u00b8\u00ba\u00bc\u00be\u00c0\u00c2\u00c4\u00c6\u00c8"+
		"\u00ca\u00cc\u00ce\u00d0\u00d2\u00d4\u00d6\u00d8\u00da\u00dc\u00de\u00e0"+
		"\u00e2\u00e4\u00e6\u00e8\u00ea\u00ec\u00ee\u00f0\u00f2\u00f4\u00f6\u00f8"+
		"\u00fa\u00fc\u00fe\u0100\u0102\u0104\u0106\u0108\u010a\u010c\u010e\u0110"+
		"\u0112\u0114\u0116\u0118\u011a\u011c\u011e\u0120\u0122\u0124\u0126\u0128"+
		"\u012a\u012c\u012e\u0130\u0132\u0134\u0136\u0138\u013a\u013c\u013e\u0140"+
		"\u0142\u0144\u0146\u0148\u014a\u014c\u014e\u0150\u0152\u0154\u0156\u0158"+
		"\u015a\u015c\u015e\u0160\u0162\u0164\u0166\u0168\u016a\u016c\u016e\u0170"+
		"\u0172\u0174\u0176\u0178\u017a\u017c\u017e\u0180\u0182\u0184\u0186\u0188"+
		"\2\b\5\2\'\61\63\63\65\65\4\2\20\20\67\67\3\2\24\25\3\2$%\6\2\26\27\35"+
		"\35\62\62\64\64\4\2]_aa\2\u094d\2\u018b\3\2\2\2\4\u018f\3\2\2\2\6\u0191"+
		"\3\2\2\2\b\u019a\3\2\2\2\n\u01aa\3\2\2\2\f\u01b0\3\2\2\2\16\u01b8\3\2"+
		"\2\2\20\u01ba\3\2\2\2\22\u01d5\3\2\2\2\24\u01df\3\2\2\2\26\u0209\3\2\2"+
		"\2\30\u020d\3\2\2\2\32\u020f\3\2\2\2\34\u0211\3\2\2\2\36\u0215\3\2\2\2"+
		" \u021d\3\2\2\2\"\u0226\3\2\2\2$\u022f\3\2\2\2&\u0232\3\2\2\2(\u0234\3"+
		"\2\2\2*\u023c\3\2\2\2,\u023e\3\2\2\2.\u0254\3\2\2\2\60\u025f\3\2\2\2\62"+
		"\u0261\3\2\2\2\64\u0269\3\2\2\2\66\u026e\3\2\2\28\u0276\3\2\2\2:\u027b"+
		"\3\2\2\2<\u028c\3\2\2\2>\u0292\3\2\2\2@\u029a\3\2\2\2B\u029c\3\2\2\2D"+
		"\u02af\3\2\2\2F\u02da\3\2\2\2H\u02dc\3\2\2\2J\u030f\3\2\2\2L\u0312\3\2"+
		"\2\2N\u031d\3\2\2\2P\u034a\3\2\2\2R\u034c\3\2\2\2T\u034f\3\2\2\2V\u0356"+
		"\3\2\2\2X\u035d\3\2\2\2Z\u0365\3\2\2\2\\\u036f\3\2\2\2^\u0373\3\2\2\2"+
		"`\u0376\3\2\2\2b\u0379\3\2\2\2d\u037c\3\2\2\2f\u037f\3\2\2\2h\u0389\3"+
		"\2\2\2j\u0393\3\2\2\2l\u0397\3\2\2\2n\u039f\3\2\2\2p\u03e5\3\2\2\2r\u03e7"+
		"\3\2\2\2t\u040d\3\2\2\2v\u040f\3\2\2\2x\u041a\3\2\2\2z\u0424\3\2\2\2|"+
		"\u0428\3\2\2\2~\u043a\3\2\2\2\u0080\u043c\3\2\2\2\u0082\u0444\3\2\2\2"+
		"\u0084\u0449\3\2\2\2\u0086\u044d\3\2\2\2\u0088\u044f\3\2\2\2\u008a\u0453"+
		"\3\2\2\2\u008c\u0463\3\2\2\2\u008e\u046b\3\2\2\2\u0090\u0473\3\2\2\2\u0092"+
		"\u0475\3\2\2\2\u0094\u047a\3\2\2\2\u0096\u047f\3\2\2\2\u0098\u0483\3\2"+
		"\2\2\u009a\u0485\3\2\2\2\u009c\u0487\3\2\2\2\u009e\u0489\3\2\2\2\u00a0"+
		"\u048b\3\2\2\2\u00a2\u048d\3\2\2\2\u00a4\u048f\3\2\2\2\u00a6\u0496\3\2"+
		"\2\2\u00a8\u049e\3\2\2\2\u00aa\u04ac\3\2\2\2\u00ac\u04ae\3\2\2\2\u00ae"+
		"\u04b3\3\2\2\2\u00b0\u04c0\3\2\2\2\u00b2\u04c2\3\2\2\2\u00b4\u04d9\3\2"+
		"\2\2\u00b6\u04db\3\2\2\2\u00b8\u04e5\3\2\2\2\u00ba\u04ea\3\2\2\2\u00bc"+
		"\u04ed\3\2\2\2\u00be\u04fe\3\2\2\2\u00c0\u0506\3\2\2\2\u00c2\u050e\3\2"+
		"\2\2\u00c4\u0512\3\2\2\2\u00c6\u051a\3\2\2\2\u00c8\u051e\3\2\2\2\u00ca"+
		"\u053a\3\2\2\2\u00cc\u053c\3\2\2\2\u00ce\u053f\3\2\2\2\u00d0\u0542\3\2"+
		"\2\2\u00d2\u0545\3\2\2\2\u00d4\u0559\3\2\2\2\u00d6\u055b\3\2\2\2\u00d8"+
		"\u0563\3\2\2\2\u00da\u0571\3\2\2\2\u00dc\u0573\3\2\2\2\u00de\u0581\3\2"+
		"\2\2\u00e0\u0583\3\2\2\2\u00e2\u0589\3\2\2\2\u00e4\u058b\3\2\2\2\u00e6"+
		"\u0593\3\2\2\2\u00e8\u059e\3\2\2\2\u00ea\u05a0\3\2\2\2\u00ec\u05b1\3\2"+
		"\2\2\u00ee\u05b3\3\2\2\2\u00f0\u05b6\3\2\2\2\u00f2\u05b9\3\2\2\2\u00f4"+
		"\u05bc\3\2\2\2\u00f6\u05bf\3\2\2\2\u00f8\u05c2\3\2\2\2\u00fa\u05c5\3\2"+
		"\2\2\u00fc\u05c9\3\2\2\2\u00fe\u05cc\3\2\2\2\u0100\u05d0\3\2\2\2\u0102"+
		"\u05d3\3\2\2\2\u0104\u05de\3\2\2\2\u0106\u05e9\3\2\2\2\u0108\u05f4\3\2"+
		"\2\2\u010a\u05ff\3\2\2\2\u010c\u060a\3\2\2\2\u010e\u061c\3\2\2\2\u0110"+
		"\u061e\3\2\2\2\u0112\u0626\3\2\2\2\u0114\u0628\3\2\2\2\u0116\u0651\3\2"+
		"\2\2\u0118\u0661\3\2\2\2\u011a\u0679\3\2\2\2\u011c\u067b\3\2\2\2\u011e"+
		"\u0682\3\2\2\2\u0120\u0689\3\2\2\2\u0122\u06bc\3\2\2\2\u0124\u06bf\3\2"+
		"\2\2\u0126\u06ca\3\2\2\2\u0128\u06ec\3\2\2\2\u012a\u06ee\3\2\2\2\u012c"+
		"\u06f1\3\2\2\2\u012e\u06f5\3\2\2\2\u0130\u06fa\3\2\2\2\u0132\u0701\3\2"+
		"\2\2\u0134\u0705\3\2\2\2\u0136\u0707\3\2\2\2\u0138\u0714\3\2\2\2\u013a"+
		"\u0717\3\2\2\2\u013c\u0720\3\2\2\2\u013e\u0722\3\2\2\2\u0140\u072b\3\2"+
		"\2\2\u0142\u072f\3\2\2\2\u0144\u0733\3\2\2\2\u0146\u0739\3\2\2\2\u0148"+
		"\u0743\3\2\2\2\u014a\u0747\3\2\2\2\u014c\u074d\3\2\2\2\u014e\u075b\3\2"+
		"\2\2\u0150\u075d\3\2\2\2\u0152\u0762\3\2\2\2\u0154\u0767\3\2\2\2\u0156"+
		"\u0774\3\2\2\2\u0158\u0779\3\2\2\2\u015a\u077e\3\2\2\2\u015c\u0786\3\2"+
		"\2\2\u015e\u078b\3\2\2\2\u0160\u07a8\3\2\2\2\u0162\u07c5\3\2\2\2\u0164"+
		"\u07c7\3\2\2\2\u0166\u07cf\3\2\2\2\u0168\u07d7\3\2\2\2\u016a\u07d9\3\2"+
		"\2\2\u016c\u07e4\3\2\2\2\u016e\u07ef\3\2\2\2\u0170\u07ff\3\2\2\2\u0172"+
		"\u080b\3\2\2\2\u0174\u081c\3\2\2\2\u0176\u0824\3\2\2\2\u0178\u0826\3\2"+
		"\2\2\u017a\u082f\3\2\2\2\u017c\u0846\3\2\2\2\u017e\u085b\3\2\2\2\u0180"+
		"\u086c\3\2\2\2\u0182\u088d\3\2\2\2\u0184\u0892\3\2\2\2\u0186\u0894\3\2"+
		"\2\2\u0188\u0898\3\2\2\2\u018a\u018c\5\n\6\2\u018b\u018a\3\2\2\2\u018b"+
		"\u018c\3\2\2\2\u018c\u018d\3\2\2\2\u018d\u018e\7\2\2\3\u018e\3\3\2\2\2"+
		"\u018f\u0190\5\16\b\2\u0190\5\3\2\2\2\u0191\u0195\5\u00d2j\2\u0192\u0194"+
		"\7d\2\2\u0193\u0192\3\2\2\2\u0194\u0197\3\2\2\2\u0195\u0193\3\2\2\2\u0195"+
		"\u0196\3\2\2\2\u0196\u0198\3\2\2\2\u0197\u0195\3\2\2\2\u0198\u0199\7\2"+
		"\2\3\u0199\7\3\2\2\2\u019a\u019c\7\n\2\2\u019b\u019d\5\u0182\u00c2\2\u019c"+
		"\u019b\3\2\2\2\u019c\u019d\3\2\2\2\u019d\u019e\3\2\2\2\u019e\u019f\7\r"+
		"\2\2\u019f\u01a0\7\66\2\2\u01a0\u01a4\5\u00d4k\2\u01a1\u01a3\7d\2\2\u01a2"+
		"\u01a1\3\2\2\2\u01a3\u01a6\3\2\2\2\u01a4\u01a2\3\2\2\2\u01a4\u01a5\3\2"+
		"\2\2\u01a5\u01a7\3\2\2\2\u01a6\u01a4\3\2\2\2\u01a7\u01a8\7\2\2\3\u01a8"+
		"\t\3\2\2\2\u01a9\u01ab\5\f\7\2\u01aa\u01a9\3\2\2\2\u01ab\u01ac\3\2\2\2"+
		"\u01ac\u01aa\3\2\2\2\u01ac\u01ad\3\2\2\2\u01ad\13\3\2\2\2\u01ae\u01b1"+
		"\5\24\13\2\u01af\u01b1\5\20\t\2\u01b0\u01ae\3\2\2\2\u01b0\u01af\3\2\2"+
		"\2\u01b1\r\3\2\2\2\u01b2\u01b3\5\24\13\2\u01b3\u01b4\7d\2\2\u01b4\u01b9"+
		"\3\2\2\2\u01b5\u01b9\5\20\t\2\u01b6\u01b9\7d\2\2\u01b7\u01b9\7\2\2\3\u01b8"+
		"\u01b2\3\2\2\2\u01b8\u01b5\3\2\2\2\u01b8\u01b6\3\2\2\2\u01b8\u01b7\3\2"+
		"\2\2\u01b9\17\3\2\2\2\u01ba\u01bf\5\22\n\2\u01bb\u01bc\7\23\2\2\u01bc"+
		"\u01be\5\22\n\2\u01bd\u01bb\3\2\2\2\u01be\u01c1\3\2\2\2\u01bf\u01bd\3"+
		"\2\2\2\u01bf\u01c0\3\2\2\2\u01c0\u01c3\3\2\2\2\u01c1\u01bf\3\2\2\2\u01c2"+
		"\u01c4\7\23\2\2\u01c3\u01c2\3\2\2\2\u01c3\u01c4\3\2\2\2\u01c4\u01c5\3"+
		"\2\2\2\u01c5\u01c6\7d\2\2\u01c6\21\3\2\2\2\u01c7\u01d6\5\26\f\2\u01c8"+
		"\u01d6\5\u00c4c\2\u01c9\u01d6\5\u00d8m\2\u01ca\u01d6\5\34\17\2\u01cb\u01d6"+
		"\5*\26\2\u01cc\u01d6\5\36\20\2\u01cd\u01d6\7>\2\2\u01ce\u01d6\5$\23\2"+
		"\u01cf\u01d6\5&\24\2\u01d0\u01d6\5(\25\2\u01d1\u01d6\7@\2\2\u01d2\u01d6"+
		"\7J\2\2\u01d3\u01d6\5 \21\2\u01d4\u01d6\5\"\22\2\u01d5\u01c7\3\2\2\2\u01d5"+
		"\u01c8\3\2\2\2\u01d5\u01c9\3\2\2\2\u01d5\u01ca\3\2\2\2\u01d5\u01cb\3\2"+
		"\2\2\u01d5\u01cc\3\2\2\2\u01d5\u01cd\3\2\2\2\u01d5\u01ce\3\2\2\2\u01d5"+
		"\u01cf\3\2\2\2\u01d5\u01d0\3\2\2\2\u01d5\u01d1\3\2\2\2\u01d5\u01d2\3\2"+
		"\2\2\u01d5\u01d3\3\2\2\2\u01d5\u01d4\3\2\2\2\u01d6\23\3\2\2\2\u01d7\u01e0"+
		"\5D#\2\u01d8\u01e0\5f\64\2\u01d9\u01e0\5@!\2\u01da\u01e0\5p9\2\u01db\u01e0"+
		"\5n8\2\u01dc\u01e0\5t;\2\u01dd\u01e0\5l\67\2\u01de\u01e0\5|?\2\u01df\u01d7"+
		"\3\2\2\2\u01df\u01d8\3\2\2\2\u01df\u01d9\3\2\2\2\u01df\u01da\3\2\2\2\u01df"+
		"\u01db\3\2\2\2\u01df\u01dc\3\2\2\2\u01df\u01dd\3\2\2\2\u01df\u01de\3\2"+
		"\2\2\u01e0\25\3\2\2\2\u01e1\u01e2\5\u0188\u00c5\2\u01e2\u01e3\7\21\2\2"+
		"\u01e3\u01e6\5\u00d4k\2\u01e4\u01e5\7\34\2\2\u01e5\u01e7\5\30\r\2\u01e6"+
		"\u01e4\3\2\2\2\u01e6\u01e7\3\2\2\2\u01e7\u020a\3\2\2\2\u01e8\u01e9\7\n"+
		"\2\2\u01e9\u01ea\5\u0176\u00bc\2\u01ea\u01eb\7\r\2\2\u01eb\u01ee\3\2\2"+
		"\2\u01ec\u01ee\5\u0178\u00bd\2\u01ed\u01e8\3\2\2\2\u01ed\u01ec\3\2\2\2"+
		"\u01ee\u01ef\3\2\2\2\u01ef\u01f0\7\21\2\2\u01f0\u01f3\5\u00d4k\2\u01f1"+
		"\u01f2\7\34\2\2\u01f2\u01f4\5\30\r\2\u01f3\u01f1\3\2\2\2\u01f3\u01f4\3"+
		"\2\2\2\u01f4\u020a\3\2\2\2\u01f5\u01f6\5\u016a\u00b6\2\u01f6\u01f7\7\34"+
		"\2\2\u01f7\u01f9\3\2\2\2\u01f8\u01f5\3\2\2\2\u01f9\u01fa\3\2\2\2\u01fa"+
		"\u01f8\3\2\2\2\u01fa\u01fb\3\2\2\2\u01fb\u01fe\3\2\2\2\u01fc\u01ff\5\u00d6"+
		"l\2\u01fd\u01ff\5\u00d8m\2\u01fe\u01fc\3\2\2\2\u01fe\u01fd\3\2\2\2\u01ff"+
		"\u0201\3\2\2\2\u0200\u0202\7\6\2\2\u0201\u0200\3\2\2\2\u0201\u0202\3\2"+
		"\2\2\u0202\u020a\3\2\2\2\u0203\u0204\5\u0176\u00bc\2\u0204\u0207\5\32"+
		"\16\2\u0205\u0208\5\u00d6l\2\u0206\u0208\5\u00d8m\2\u0207\u0205\3\2\2"+
		"\2\u0207\u0206\3\2\2\2\u0208\u020a\3\2\2\2\u0209\u01e1\3\2\2\2\u0209\u01ed"+
		"\3\2\2\2\u0209\u01f8\3\2\2\2\u0209\u0203\3\2\2\2\u020a\27\3\2\2\2\u020b"+
		"\u020e\5\u00d6l\2\u020c\u020e\5\u00d8m\2\u020d\u020b\3\2\2\2\u020d\u020c"+
		"\3\2\2\2\u020e\31\3\2\2\2\u020f\u0210\t\2\2\2\u0210\33\3\2\2\2\u0211\u0213"+
		"\7H\2\2\u0212\u0214\5\u00d8m\2\u0213\u0212\3\2\2\2\u0213\u0214\3\2\2\2"+
		"\u0214\35\3\2\2\2\u0215\u021b\7C\2\2\u0216\u0219\5\u00d4k\2\u0217\u0218"+
		"\7P\2\2\u0218\u021a\5\u00d4k\2\u0219\u0217\3\2\2\2\u0219\u021a\3\2\2\2"+
		"\u021a\u021c\3\2\2\2\u021b\u0216\3\2\2\2\u021b\u021c\3\2\2\2\u021c\37"+
		"\3\2\2\2\u021d\u021e\7U\2\2\u021e\u0223\5\u0188\u00c5\2\u021f\u0220\7"+
		"\22\2\2\u0220\u0222\5\u0188\u00c5\2\u0221\u021f\3\2\2\2\u0222\u0225\3"+
		"\2\2\2\u0223\u0221\3\2\2\2\u0223\u0224\3\2\2\2\u0224!\3\2\2\2\u0225\u0223"+
		"\3\2\2\2\u0226\u0227\7Q\2\2\u0227\u022c\5\u0188\u00c5\2\u0228\u0229\7"+
		"\22\2\2\u0229\u022b\5\u0188\u00c5\2\u022a\u0228\3\2\2\2\u022b\u022e\3"+
		"\2\2\2\u022c\u022a\3\2\2\2\u022c\u022d\3\2\2\2\u022d#\3\2\2\2\u022e\u022c"+
		"\3\2\2\2\u022f\u0230\7T\2\2\u0230\u0231\5\u017c\u00bf\2\u0231%\3\2\2\2"+
		"\u0232\u0233\5\u00d6l\2\u0233\'\3\2\2\2\u0234\u0235\7S\2\2\u0235\u0238"+
		"\5\u00d4k\2\u0236\u0237\7\22\2\2\u0237\u0239\5\u00d4k\2\u0238\u0236\3"+
		"\2\2\2\u0238\u0239\3\2\2\2\u0239)\3\2\2\2\u023a\u023d\5,\27\2\u023b\u023d"+
		"\5.\30\2\u023c\u023a\3\2\2\2\u023c\u023b\3\2\2\2\u023d+\3\2\2\2\u023e"+
		"\u023f\7=\2\2\u023f\u0240\5\66\34\2\u0240-\3\2\2\2\u0241\u0245\7P\2\2"+
		"\u0242\u0244\t\3\2\2\u0243\u0242\3\2\2\2\u0244\u0247\3\2\2\2\u0245\u0243"+
		"\3\2\2\2\u0245\u0246\3\2\2\2\u0246\u0248\3\2\2\2\u0247\u0245\3\2\2\2\u0248"+
		"\u0249\5:\36\2\u0249\u024a\7=\2\2\u024a\u024b\5\60\31\2\u024b\u0255\3"+
		"\2\2\2\u024c\u024e\7P\2\2\u024d\u024f\t\3\2\2\u024e\u024d\3\2\2\2\u024f"+
		"\u0250\3\2\2\2\u0250\u024e\3\2\2\2\u0250\u0251\3\2\2\2\u0251\u0252\3\2"+
		"\2\2\u0252\u0253\7=\2\2\u0253\u0255\5\60\31\2\u0254\u0241\3\2\2\2\u0254"+
		"\u024c\3\2\2\2\u0255/\3\2\2\2\u0256\u0257\7\n\2\2\u0257\u0259\5\62\32"+
		"\2\u0258\u025a\7\22\2\2\u0259\u0258\3\2\2\2\u0259\u025a\3\2\2\2\u025a"+
		"\u025b\3\2\2\2\u025b\u025c\7\r\2\2\u025c\u0260\3\2\2\2\u025d\u0260\5\62"+
		"\32\2\u025e\u0260\7\26\2\2\u025f\u0256\3\2\2\2\u025f\u025d\3\2\2\2\u025f"+
		"\u025e\3\2\2\2\u0260\61\3\2\2\2\u0261\u0266\5\64\33\2\u0262\u0263\7\22"+
		"\2\2\u0263\u0265\5\64\33\2\u0264\u0262\3\2\2\2\u0265\u0268\3\2\2\2\u0266"+
		"\u0264\3\2\2\2\u0266\u0267\3\2\2\2\u0267\63\3\2\2\2\u0268\u0266\3\2\2"+
		"\2\u0269\u026c\5\u0188\u00c5\2\u026a\u026b\7N\2\2\u026b\u026d\5\u0188"+
		"\u00c5\2\u026c\u026a\3\2\2\2\u026c\u026d\3\2\2\2\u026d\65\3\2\2\2\u026e"+
		"\u0273\58\35\2\u026f\u0270\7\22\2\2\u0270\u0272\58\35\2\u0271\u026f\3"+
		"\2\2\2\u0272\u0275\3\2\2\2\u0273\u0271\3\2\2\2\u0273\u0274\3\2\2\2\u0274"+
		"\67\3\2\2\2\u0275\u0273\3\2\2\2\u0276\u0279\5:\36\2\u0277\u0278\7N\2\2"+
		"\u0278\u027a\5\u0188\u00c5\2\u0279\u0277\3\2\2\2\u0279\u027a\3\2\2\2\u027a"+
		"9\3\2\2\2\u027b\u027c\b\36\1\2\u027c\u027d\5\u0188\u00c5\2\u027d\u0283"+
		"\3\2\2\2\u027e\u027f\f\4\2\2\u027f\u0280\7\20\2\2\u0280\u0282\5\u0188"+
		"\u00c5\2\u0281\u027e\3\2\2\2\u0282\u0285\3\2\2\2\u0283\u0281\3\2\2\2\u0283"+
		"\u0284\3\2\2\2\u0284;\3\2\2\2\u0285\u0283\3\2\2\2\u0286\u0287\7d\2\2\u0287"+
		"\u0288\7\4\2\2\u0288\u0289\5\n\6\2\u0289\u028a\7\5\2\2\u028a\u028d\3\2"+
		"\2\2\u028b\u028d\5\20\t\2\u028c\u0286\3\2\2\2\u028c\u028b\3\2\2\2\u028d"+
		"=\3\2\2\2\u028e\u028f\7\64\2\2\u028f\u0290\5\u00e2r\2\u0290\u0291\7d\2"+
		"\2\u0291\u0293\3\2\2\2\u0292\u028e\3\2\2\2\u0293\u0294\3\2\2\2\u0294\u0292"+
		"\3\2\2\2\u0294\u0295\3\2\2\2\u0295?\3\2\2\2\u0296\u0297\5> \2\u0297\u0298"+
		"\5B\"\2\u0298\u029b\3\2\2\2\u0299\u029b\5B\"\2\u029a\u0296\3\2\2\2\u029a"+
		"\u0299\3\2\2\2\u029bA\3\2\2\2\u029c\u029d\7E\2\2\u029d\u029f\5\u0188\u00c5"+
		"\2\u029e\u02a0\5\u00c6d\2\u029f\u029e\3\2\2\2\u029f\u02a0\3\2\2\2\u02a0"+
		"\u02a6\3\2\2\2\u02a1\u02a3\7\n\2\2\u02a2\u02a4\5\u015e\u00b0\2\u02a3\u02a2"+
		"\3\2\2\2\u02a3\u02a4\3\2\2\2\u02a4\u02a5\3\2\2\2\u02a5\u02a7\7\r\2\2\u02a6"+
		"\u02a1\3\2\2\2\u02a6\u02a7\3\2\2\2\u02a7\u02a8\3\2\2\2\u02a8\u02a9\7\21"+
		"\2\2\u02a9\u02aa\5<\37\2\u02aaC\3\2\2\2\u02ab\u02ac\5> \2\u02ac\u02ad"+
		"\5F$\2\u02ad\u02b0\3\2\2\2\u02ae\u02b0\5F$\2\u02af\u02ab\3\2\2\2\u02af"+
		"\u02ae\3\2\2\2\u02b0E\3\2\2\2\u02b1\u02b2\7O\2\2\u02b2\u02b4\5\u0188\u00c5"+
		"\2\u02b3\u02b5\5\u00c6d\2\u02b4\u02b3\3\2\2\2\u02b4\u02b5\3\2\2\2\u02b5"+
		"\u02b6\3\2\2\2\u02b6\u02b8\7\n\2\2\u02b7\u02b9\5H%\2\u02b8\u02b7\3\2\2"+
		"\2\u02b8\u02b9\3\2\2\2\u02b9\u02ba\3\2\2\2\u02ba\u02bd\7\r\2\2\u02bb\u02bc"+
		"\7\66\2\2\u02bc\u02be\5\u00d4k\2\u02bd\u02bb\3\2\2\2\u02bd\u02be\3\2\2"+
		"\2\u02be\u02bf\3\2\2\2\u02bf\u02c1\7\21\2\2\u02c0\u02c2\5\u0184\u00c3"+
		"\2\u02c1\u02c0\3\2\2\2\u02c1\u02c2\3\2\2\2\u02c2\u02c3\3\2\2\2\u02c3\u02c4"+
		"\5<\37\2\u02c4\u02db\3\2\2\2\u02c5\u02c6\7X\2\2\u02c6\u02c7\7O\2\2\u02c7"+
		"\u02c9\5\u0188\u00c5\2\u02c8\u02ca\5\u00c6d\2\u02c9\u02c8\3\2\2\2\u02c9"+
		"\u02ca\3\2\2\2\u02ca\u02cb\3\2\2\2\u02cb\u02cd\7\n\2\2\u02cc\u02ce\5H"+
		"%\2\u02cd\u02cc\3\2\2\2\u02cd\u02ce\3\2\2\2\u02ce\u02cf\3\2\2\2\u02cf"+
		"\u02d2\7\r\2\2\u02d0\u02d1\7\66\2\2\u02d1\u02d3\5\u00d4k\2\u02d2\u02d0"+
		"\3\2\2\2\u02d2\u02d3\3\2\2\2\u02d3\u02d4\3\2\2\2\u02d4\u02d6\7\21\2\2"+
		"\u02d5\u02d7\5\u0184\u00c3\2\u02d6\u02d5\3\2\2\2\u02d6\u02d7\3\2\2\2\u02d7"+
		"\u02d8\3\2\2\2\u02d8\u02d9\5<\37\2\u02d9\u02db\3\2\2\2\u02da\u02b1\3\2"+
		"\2\2\u02da\u02c5\3\2\2\2\u02dbG\3\2\2\2\u02dc\u02dd\5J&\2\u02ddI\3\2\2"+
		"\2\u02de\u02e2\5L\'\2\u02df\u02e1\5T+\2\u02e0\u02df\3\2\2\2\u02e1\u02e4"+
		"\3\2\2\2\u02e2\u02e0\3\2\2\2\u02e2\u02e3\3\2\2\2\u02e3\u02e8\3\2\2\2\u02e4"+
		"\u02e2\3\2\2\2\u02e5\u02e7\5X-\2\u02e6\u02e5\3\2\2\2\u02e7\u02ea\3\2\2"+
		"\2\u02e8\u02e6\3\2\2\2\u02e8\u02e9\3\2\2\2\u02e9\u02ec\3\2\2\2\u02ea\u02e8"+
		"\3\2\2\2\u02eb\u02ed\5P)\2\u02ec\u02eb\3\2\2\2\u02ec\u02ed\3\2\2\2\u02ed"+
		"\u0310\3\2\2\2\u02ee\u02f2\5N(\2\u02ef\u02f1\5X-\2\u02f0\u02ef\3\2\2\2"+
		"\u02f1\u02f4\3\2\2\2\u02f2\u02f0\3\2\2\2\u02f2\u02f3\3\2\2\2\u02f3\u02f6"+
		"\3\2\2\2\u02f4\u02f2\3\2\2\2\u02f5\u02f7\5P)\2\u02f6\u02f5\3\2\2\2\u02f6"+
		"\u02f7\3\2\2\2\u02f7\u0310\3\2\2\2\u02f8\u02fa\5T+\2\u02f9\u02f8\3\2\2"+
		"\2\u02fa\u02fb\3\2\2\2\u02fb\u02f9\3\2\2\2\u02fb\u02fc\3\2\2\2\u02fc\u0300"+
		"\3\2\2\2\u02fd\u02ff\5X-\2\u02fe\u02fd\3\2\2\2\u02ff\u0302\3\2\2\2\u0300"+
		"\u02fe\3\2\2\2\u0300\u0301\3\2\2\2\u0301\u0304\3\2\2\2\u0302\u0300\3\2"+
		"\2\2\u0303\u0305\5P)\2\u0304\u0303\3\2\2\2\u0304\u0305\3\2\2\2\u0305\u0310"+
		"\3\2\2\2\u0306\u0308\5X-\2\u0307\u0306\3\2\2\2\u0308\u0309\3\2\2\2\u0309"+
		"\u0307\3\2\2\2\u0309\u030a\3\2\2\2\u030a\u030c\3\2\2\2\u030b\u030d\5P"+
		")\2\u030c\u030b\3\2\2\2\u030c\u030d\3\2\2\2\u030d\u0310\3\2\2\2\u030e"+
		"\u0310\5P)\2\u030f\u02de\3\2\2\2\u030f\u02ee\3\2\2\2\u030f\u02f9\3\2\2"+
		"\2\u030f\u0307\3\2\2\2\u030f\u030e\3\2\2\2\u0310K\3\2\2\2\u0311\u0313"+
		"\5T+\2\u0312\u0311\3\2\2\2\u0313\u0314\3\2\2\2\u0314\u0312\3\2\2\2\u0314"+
		"\u0315\3\2\2\2\u0315\u0316\3\2\2\2\u0316\u0318\7\27\2\2\u0317\u0319\7"+
		"\22\2\2\u0318\u0317\3\2\2\2\u0318\u0319\3\2\2\2\u0319M\3\2\2\2\u031a\u031c"+
		"\5T+\2\u031b\u031a\3\2\2\2\u031c\u031f\3\2\2\2\u031d\u031b\3\2\2\2\u031d"+
		"\u031e\3\2\2\2\u031e\u0321\3\2\2\2\u031f\u031d\3\2\2\2\u0320\u0322\5X"+
		"-\2\u0321\u0320\3\2\2\2\u0322\u0323\3\2\2\2\u0323\u0321\3\2\2\2\u0323"+
		"\u0324\3\2\2\2\u0324\u0325\3\2\2\2\u0325\u0327\7\27\2\2\u0326\u0328\7"+
		"\22\2\2\u0327\u0326\3\2\2\2\u0327\u0328\3\2\2\2\u0328O\3\2\2\2\u0329\u032a"+
		"\7\26\2\2\u032a\u032e\5T+\2\u032b\u032d\5Z.\2\u032c\u032b\3\2\2\2\u032d"+
		"\u0330\3\2\2\2\u032e\u032c\3\2\2\2\u032e\u032f\3\2\2\2\u032f\u0332\3\2"+
		"\2\2\u0330\u032e\3\2\2\2\u0331\u0333\5R*\2\u0332\u0331\3\2\2\2\u0332\u0333"+
		"\3\2\2\2\u0333\u034b\3\2\2\2\u0334\u0335\7\26\2\2\u0335\u0339\5V,\2\u0336"+
		"\u0338\5Z.\2\u0337\u0336\3\2\2\2\u0338\u033b\3\2\2\2\u0339\u0337\3\2\2"+
		"\2\u0339\u033a\3\2\2\2\u033a\u033d\3\2\2\2\u033b\u0339\3\2\2\2\u033c\u033e"+
		"\5R*\2\u033d\u033c\3\2\2\2\u033d\u033e\3\2\2\2\u033e\u034b\3\2\2\2\u033f"+
		"\u0340\7\26\2\2\u0340\u0342\7\22\2\2\u0341\u0343\5Z.\2\u0342\u0341\3\2"+
		"\2\2\u0343\u0344\3\2\2\2\u0344\u0342\3\2\2\2\u0344\u0345\3\2\2\2\u0345"+
		"\u0347\3\2\2\2\u0346\u0348\5R*\2\u0347\u0346\3\2\2\2\u0347\u0348\3\2\2"+
		"\2\u0348\u034b\3\2\2\2\u0349\u034b\5R*\2\u034a\u0329\3\2\2\2\u034a\u0334"+
		"\3\2\2\2\u034a\u033f\3\2\2\2\u034a\u0349\3\2\2\2\u034bQ\3\2\2\2\u034c"+
		"\u034d\7&\2\2\u034d\u034e\5T+\2\u034eS\3\2\2\2\u034f\u0351\5\\/\2\u0350"+
		"\u0352\7\22\2\2\u0351\u0350\3\2\2\2\u0351\u0352\3\2\2\2\u0352\u0354\3"+
		"\2\2\2\u0353\u0355\7\6\2\2\u0354\u0353\3\2\2\2\u0354\u0355\3\2\2\2\u0355"+
		"U\3\2\2\2\u0356\u0358\5^\60\2\u0357\u0359\7\22\2\2\u0358\u0357\3\2\2\2"+
		"\u0358\u0359\3\2\2\2\u0359\u035b\3\2\2\2\u035a\u035c\7\6\2\2\u035b\u035a"+
		"\3\2\2\2\u035b\u035c\3\2\2\2\u035cW\3\2\2\2\u035d\u035e\5\\/\2\u035e\u0360"+
		"\5d\63\2\u035f\u0361\7\22\2\2\u0360\u035f\3\2\2\2\u0360\u0361\3\2\2\2"+
		"\u0361\u0363\3\2\2\2\u0362\u0364\7\6\2\2\u0363\u0362\3\2\2\2\u0363\u0364"+
		"\3\2\2\2\u0364Y\3\2\2\2\u0365\u0367\5\\/\2\u0366\u0368\5d\63\2\u0367\u0366"+
		"\3\2\2\2\u0367\u0368\3\2\2\2\u0368\u036a\3\2\2\2\u0369\u036b\7\22\2\2"+
		"\u036a\u0369\3\2\2\2\u036a\u036b\3\2\2\2\u036b\u036d\3\2\2\2\u036c\u036e"+
		"\7\6\2\2\u036d\u036c\3\2\2\2\u036d\u036e\3\2\2\2\u036e[\3\2\2\2\u036f"+
		"\u0371\5\u0188\u00c5\2\u0370\u0372\5`\61\2\u0371\u0370\3\2\2\2\u0371\u0372"+
		"\3\2\2\2\u0372]\3\2\2\2\u0373\u0374\5\u0188\u00c5\2\u0374\u0375\5b\62"+
		"\2\u0375_\3\2\2\2\u0376\u0377\7\21\2\2\u0377\u0378\5\u00d4k\2\u0378a\3"+
		"\2\2\2\u0379\u037a\7\21\2\2\u037a\u037b\5\u00dan\2\u037bc\3\2\2\2\u037c"+
		"\u037d\7\34\2\2\u037d\u037e\5\u00d4k\2\u037ee\3\2\2\2\u037f\u0380\7Z\2"+
		"\2\u0380\u0381\5\u00e2r\2\u0381\u0382\7\21\2\2\u0382\u0387\5<\37\2\u0383"+
		"\u0388\5h\65\2\u0384\u0386\5j\66\2\u0385\u0384\3\2\2\2\u0385\u0386\3\2"+
		"\2\2\u0386\u0388\3\2\2\2\u0387\u0383\3\2\2\2\u0387\u0385\3\2\2\2\u0388"+
		"g\3\2\2\2\u0389\u038a\7Y\2\2\u038a\u038b\5\u00e2r\2\u038b\u038c\7\21\2"+
		"\2\u038c\u0391\5<\37\2\u038d\u0392\5h\65\2\u038e\u0390\5j\66\2\u038f\u038e"+
		"\3\2\2\2\u038f\u0390\3\2\2\2\u0390\u0392\3\2\2\2\u0391\u038d\3\2\2\2\u0391"+
		"\u038f\3\2\2\2\u0392i\3\2\2\2\u0393\u0394\7<\2\2\u0394\u0395\7\21\2\2"+
		"\u0395\u0396\5<\37\2\u0396k\3\2\2\2\u0397\u0398\7R\2\2\u0398\u0399\5\u00e2"+
		"r\2\u0399\u039a\7\21\2\2\u039a\u039c\5<\37\2\u039b\u039d\5j\66\2\u039c"+
		"\u039b\3\2\2\2\u039c\u039d\3\2\2\2\u039dm\3\2\2\2\u039e\u03a0\7X\2\2\u039f"+
		"\u039e\3\2\2\2\u039f\u03a0\3\2\2\2\u03a0\u03a1\3\2\2\2\u03a1\u03a2\7K"+
		"\2\2\u03a2\u03a3\5\u016a\u00b6\2\u03a3\u03a4\7B\2\2\u03a4\u03a5\5\u00d8"+
		"m\2\u03a5\u03a7\7\21\2\2\u03a6\u03a8\7\6\2\2\u03a7\u03a6\3\2\2\2\u03a7"+
		"\u03a8\3\2\2\2\u03a8\u03a9\3\2\2\2\u03a9\u03ab\5<\37\2\u03aa\u03ac\5j"+
		"\66\2\u03ab\u03aa\3\2\2\2\u03ab\u03ac\3\2\2\2\u03aco\3\2\2\2\u03ad\u03ae"+
		"\7W\2\2\u03ae\u03af\7\n\2\2\u03af\u03b4\5r:\2\u03b0\u03b1\7\22\2\2\u03b1"+
		"\u03b3\5r:\2\u03b2\u03b0\3\2\2\2\u03b3\u03b6\3\2\2\2\u03b4\u03b2\3\2\2"+
		"\2\u03b4\u03b5\3\2\2\2\u03b5\u03b8\3\2\2\2\u03b6\u03b4\3\2\2\2\u03b7\u03b9"+
		"\7\22\2\2\u03b8\u03b7\3\2\2\2\u03b8\u03b9\3\2\2\2\u03b9\u03ba\3\2\2\2"+
		"\u03ba\u03bb\7\r\2\2\u03bb\u03bd\7\21\2\2\u03bc\u03be\7\6\2\2\u03bd\u03bc"+
		"\3\2\2\2\u03bd\u03be\3\2\2\2\u03be\u03bf\3\2\2\2\u03bf\u03c0\5<\37\2\u03c0"+
		"\u03e6\3\2\2\2\u03c1\u03c2\7X\2\2\u03c2\u03c3\7W\2\2\u03c3\u03c4\7\n\2"+
		"\2\u03c4\u03c9\5r:\2\u03c5\u03c6\7\22\2\2\u03c6\u03c8\5r:\2\u03c7\u03c5"+
		"\3\2\2\2\u03c8\u03cb\3\2\2\2\u03c9\u03c7\3\2\2\2\u03c9\u03ca\3\2\2\2\u03ca"+
		"\u03cd\3\2\2\2\u03cb\u03c9\3\2\2\2\u03cc\u03ce\7\22\2\2\u03cd\u03cc\3"+
		"\2\2\2\u03cd\u03ce\3\2\2\2\u03ce\u03cf\3\2\2\2\u03cf\u03d0\7\r\2\2\u03d0"+
		"\u03d1\7\21\2\2\u03d1\u03d2\5<\37\2\u03d2\u03e6\3\2\2\2\u03d3\u03d5\7"+
		"X\2\2\u03d4\u03d3\3\2\2\2\u03d4\u03d5\3\2\2\2\u03d5\u03d6\3\2\2\2\u03d6"+
		"\u03d7\7W\2\2\u03d7\u03dc\5r:\2\u03d8\u03d9\7\22\2\2\u03d9\u03db\5r:\2"+
		"\u03da\u03d8\3\2\2\2\u03db\u03de\3\2\2\2\u03dc\u03da\3\2\2\2\u03dc\u03dd"+
		"\3\2\2\2\u03dd\u03df\3\2\2\2\u03de\u03dc\3\2\2\2\u03df\u03e1\7\21\2\2"+
		"\u03e0\u03e2\7\6\2\2\u03e1\u03e0\3\2\2\2\u03e1\u03e2\3\2\2\2\u03e2\u03e3"+
		"\3\2\2\2\u03e3\u03e4\5<\37\2\u03e4\u03e6\3\2\2\2\u03e5\u03ad\3\2\2\2\u03e5"+
		"\u03c1\3\2\2\2\u03e5\u03d4\3\2\2\2\u03e6q\3\2\2\2\u03e7\u03ea\5\u00d4"+
		"k\2\u03e8\u03e9\7N\2\2\u03e9\u03eb\5\u0170\u00b9\2\u03ea\u03e8\3\2\2\2"+
		"\u03ea\u03eb\3\2\2\2\u03ebs\3\2\2\2\u03ec\u03ed\7M\2\2\u03ed\u03ee\7\21"+
		"\2\2\u03ee\u03ef\5<\37\2\u03ef\u03f0\5z>\2\u03f0\u040e\3\2\2\2\u03f1\u03f2"+
		"\7M\2\2\u03f2\u03f3\7\21\2\2\u03f3\u03f5\5<\37\2\u03f4\u03f6\5v<\2\u03f5"+
		"\u03f4\3\2\2\2\u03f6\u03f7\3\2\2\2\u03f7\u03f5\3\2\2\2\u03f7\u03f8\3\2"+
		"\2\2\u03f8\u03fa\3\2\2\2\u03f9\u03fb\5j\66\2\u03fa\u03f9\3\2\2\2\u03fa"+
		"\u03fb\3\2\2\2\u03fb\u03fd\3\2\2\2\u03fc\u03fe\5z>\2\u03fd\u03fc\3\2\2"+
		"\2\u03fd\u03fe\3\2\2\2\u03fe\u040e\3\2\2\2\u03ff\u0400\7M\2\2\u0400\u0401"+
		"\7\21\2\2\u0401\u0403\5<\37\2\u0402\u0404\5x=\2\u0403\u0402\3\2\2\2\u0404"+
		"\u0405\3\2\2\2\u0405\u0403\3\2\2\2\u0405\u0406\3\2\2\2\u0406\u0408\3\2"+
		"\2\2\u0407\u0409\5j\66\2\u0408\u0407\3\2\2\2\u0408\u0409\3\2\2\2\u0409"+
		"\u040b\3\2\2\2\u040a\u040c\5z>\2\u040b\u040a\3\2\2\2\u040b\u040c\3\2\2"+
		"\2\u040c\u040e\3\2\2\2\u040d\u03ec\3\2\2\2\u040d\u03f1\3\2\2\2\u040d\u03ff"+
		"\3\2\2\2\u040eu\3\2\2\2\u040f\u0415\7A\2\2\u0410\u0413\5\u00d4k\2\u0411"+
		"\u0412\7N\2\2\u0412\u0414\5\u0188\u00c5\2\u0413\u0411\3\2\2\2\u0413\u0414"+
		"\3\2\2\2\u0414\u0416\3\2\2\2\u0415\u0410\3\2\2\2\u0415\u0416\3\2\2\2\u0416"+
		"\u0417\3\2\2\2\u0417\u0418\7\21\2\2\u0418\u0419\5<\37\2\u0419w\3\2\2\2"+
		"\u041a\u041b\7A\2\2\u041b\u041c\7\26\2\2\u041c\u041f\5\u00d4k\2\u041d"+
		"\u041e\7N\2\2\u041e\u0420\5\u0188\u00c5\2\u041f\u041d\3\2\2\2\u041f\u0420"+
		"\3\2\2\2\u0420\u0421\3\2\2\2\u0421\u0422\7\21\2\2\u0422\u0423\5<\37\2"+
		"\u0423y\3\2\2\2\u0424\u0425\7F\2\2\u0425\u0426\7\21\2\2\u0426\u0427\5"+
		"<\37\2\u0427{\3\2\2\2\u0428\u0429\7^\2\2\u0429\u042a\5~@\2\u042a\u042b"+
		"\7\21\2\2\u042b\u042c\7d\2\2\u042c\u042e\7\4\2\2\u042d\u042f\5\u0080A"+
		"\2\u042e\u042d\3\2\2\2\u042f\u0430\3\2\2\2\u0430\u042e\3\2\2\2\u0430\u0431"+
		"\3\2\2\2\u0431\u0432\3\2\2\2\u0432\u0433\7\5\2\2\u0433}\3\2\2\2\u0434"+
		"\u0435\5\u00dep\2\u0435\u0437\7\22\2\2\u0436\u0438\5\u00dco\2\u0437\u0436"+
		"\3\2\2\2\u0437\u0438\3\2\2\2\u0438\u043b\3\2\2\2\u0439\u043b\5\u00e2r"+
		"\2\u043a\u0434\3\2\2\2\u043a\u0439\3\2\2\2\u043b\177\3\2\2\2\u043c\u043d"+
		"\7_\2\2\u043d\u043f\5\u0084C\2\u043e\u0440\5\u0082B\2\u043f\u043e\3\2"+
		"\2\2\u043f\u0440\3\2\2\2\u0440\u0441\3\2\2\2\u0441\u0442\7\21\2\2\u0442"+
		"\u0443\5<\37\2\u0443\u0081\3\2\2\2\u0444\u0445\7Z\2\2\u0445\u0446\5\u00e2"+
		"r\2\u0446\u0083\3\2\2\2\u0447\u044a\5\u00acW\2\u0448\u044a\5\u0086D\2"+
		"\u0449\u0447\3\2\2\2\u0449\u0448\3\2\2\2\u044a\u0085\3\2\2\2\u044b\u044e"+
		"\5\u0088E\2\u044c\u044e\5\u008aF\2\u044d\u044b\3\2\2\2\u044d\u044c\3\2"+
		"\2\2\u044e\u0087\3\2\2\2\u044f\u0450\5\u008aF\2\u0450\u0451\7N\2\2\u0451"+
		"\u0452\5\u009eP\2\u0452\u0089\3\2\2\2\u0453\u0458\5\u008cG\2\u0454\u0455"+
		"\7\30\2\2\u0455\u0457\5\u008cG\2\u0456\u0454\3\2\2\2\u0457\u045a\3\2\2"+
		"\2\u0458\u0456\3\2\2\2\u0458\u0459\3\2\2\2\u0459\u008b\3\2\2\2\u045a\u0458"+
		"\3\2\2\2\u045b\u0464\5\u008eH\2\u045c\u0464\5\u009cO\2\u045d\u0464\5\u00a0"+
		"Q\2\u045e\u0464\5\u00a2R\2\u045f\u0464\5\u00a8U\2\u0460\u0464\5\u00aa"+
		"V\2\u0461\u0464\5\u00b4[\2\u0462\u0464\5\u00bc_\2\u0463\u045b\3\2\2\2"+
		"\u0463\u045c\3\2\2\2\u0463\u045d\3\2\2\2\u0463\u045e\3\2\2\2\u0463\u045f"+
		"\3\2\2\2\u0463\u0460\3\2\2\2\u0463\u0461\3\2\2\2\u0463\u0462\3\2\2\2\u0464"+
		"\u008d\3\2\2\2\u0465\u046c\5\u0094K\2\u0466\u046c\5\u0092J\2\u0467\u046c"+
		"\5\u0142\u00a2\2\u0468\u046c\7?\2\2\u0469\u046c\7D\2\2\u046a\u046c\7:"+
		"\2\2\u046b\u0465\3\2\2\2\u046b\u0466\3\2\2\2\u046b\u0467\3\2\2\2\u046b"+
		"\u0468\3\2\2\2\u046b\u0469\3\2\2\2\u046b\u046a\3\2\2\2\u046c\u008f\3\2"+
		"\2\2\u046d\u0474\5\u0094K\2\u046e\u0474\5\u0092J\2\u046f\u0474\5\u0142"+
		"\u00a2\2\u0470\u0474\7?\2\2\u0471\u0474\7D\2\2\u0472\u0474\7:\2\2\u0473"+
		"\u046d\3\2\2\2\u0473\u046e\3\2\2\2\u0473\u046f\3\2\2\2\u0473\u0470\3\2"+
		"\2\2\u0473\u0471\3\2\2\2\u0473\u0472\3\2\2\2\u0474\u0091\3\2\2\2\u0475"+
		"\u0476\5\u0096L\2\u0476\u0477\t\4\2\2\u0477\u0478\5\u009aN\2\u0478\u0093"+
		"\3\2\2\2\u0479\u047b\7\25\2\2\u047a\u0479\3\2\2\2\u047a\u047b\3\2\2\2"+
		"\u047b\u047c\3\2\2\2\u047c\u047d\7b\2\2\u047d\u0095\3\2\2\2\u047e\u0480"+
		"\7\25\2\2\u047f\u047e\3\2\2\2\u047f\u0480\3\2\2\2\u0480\u0481\3\2\2\2"+
		"\u0481\u0482\5\u0098M\2\u0482\u0097\3\2\2\2\u0483\u0484\7b\2\2\u0484\u0099"+
		"\3\2\2\2\u0485\u0486\7b\2\2\u0486\u009b\3\2\2\2\u0487\u0488\5\u009eP\2"+
		"\u0488\u009d\3\2\2\2\u0489\u048a\5\u0186\u00c4\2\u048a\u009f\3\2\2\2\u048b"+
		"\u048c\7`\2\2\u048c\u00a1\3\2\2\2\u048d\u048e\5\u00a4S\2\u048e\u00a3\3"+
		"\2\2\2\u048f\u0492\5\u0188\u00c5\2\u0490\u0491\7\20\2\2\u0491\u0493\5"+
		"\u0188\u00c5\2\u0492\u0490\3\2\2\2\u0493\u0494\3\2\2\2\u0494\u0492\3\2"+
		"\2\2\u0494\u0495\3\2\2\2\u0495\u00a5\3\2\2\2\u0496\u049b\5\u0188\u00c5"+
		"\2\u0497\u0498\7\20\2\2\u0498\u049a\5\u0188\u00c5\2\u0499\u0497\3\2\2"+
		"\2\u049a\u049d\3\2\2\2\u049b\u0499\3\2\2\2\u049b\u049c\3\2\2\2\u049c\u00a7"+
		"\3\2\2\2\u049d\u049b\3\2\2\2\u049e\u049f\7\n\2\2\u049f\u04a0\5\u0086D"+
		"\2\u04a0\u04a1\7\r\2\2\u04a1\u00a9\3\2\2\2\u04a2\u04a4\7\13\2\2\u04a3"+
		"\u04a5\5\u00aeX\2\u04a4\u04a3\3\2\2\2\u04a4\u04a5\3\2\2\2\u04a5\u04a6"+
		"\3\2\2\2\u04a6\u04ad\7\16\2\2\u04a7\u04a9\7\n\2\2\u04a8\u04aa\5\u00ac"+
		"W\2\u04a9\u04a8\3\2\2\2\u04a9\u04aa\3\2\2\2\u04aa\u04ab\3\2\2\2\u04ab"+
		"\u04ad\7\r\2\2\u04ac\u04a2\3\2\2\2\u04ac\u04a7\3\2\2\2\u04ad\u00ab\3\2"+
		"\2\2\u04ae\u04af\5\u00b0Y\2\u04af\u04b1\7\22\2\2\u04b0\u04b2\5\u00aeX"+
		"\2\u04b1\u04b0\3\2\2\2\u04b1\u04b2\3\2\2\2\u04b2\u00ad\3\2\2\2\u04b3\u04b8"+
		"\5\u00b0Y\2\u04b4\u04b5\7\22\2\2\u04b5\u04b7\5\u00b0Y\2\u04b6\u04b4\3"+
		"\2\2\2\u04b7\u04ba\3\2\2\2\u04b8\u04b6\3\2\2\2\u04b8\u04b9\3\2\2\2\u04b9"+
		"\u04bc\3\2\2\2\u04ba\u04b8\3\2\2\2\u04bb\u04bd\7\22\2\2\u04bc\u04bb\3"+
		"\2\2\2\u04bc\u04bd\3\2\2\2\u04bd\u00af\3\2\2\2\u04be\u04c1\5\u00b2Z\2"+
		"\u04bf\u04c1\5\u0086D\2\u04c0\u04be\3\2\2\2\u04c0\u04bf\3\2\2\2\u04c1"+
		"\u00b1\3\2\2\2\u04c2\u04c3\7\26\2\2\u04c3\u04c4\5\u0188\u00c5\2\u04c4"+
		"\u00b3\3\2\2\2\u04c5\u04c6\7\f\2\2\u04c6\u04da\7\17\2\2\u04c7\u04c8\7"+
		"\f\2\2\u04c8\u04ca\5\u00ba^\2\u04c9\u04cb\7\22\2\2\u04ca\u04c9\3\2\2\2"+
		"\u04ca\u04cb\3\2\2\2\u04cb\u04cc\3\2\2\2\u04cc\u04cd\7\17\2\2\u04cd\u04da"+
		"\3\2\2\2\u04ce\u04cf\7\f\2\2\u04cf\u04d2\5\u00b6\\\2\u04d0\u04d1\7\22"+
		"\2\2\u04d1\u04d3\5\u00ba^\2\u04d2\u04d0\3\2\2\2\u04d2\u04d3\3\2\2\2\u04d3"+
		"\u04d5\3\2\2\2\u04d4\u04d6\7\22\2\2\u04d5\u04d4\3\2\2\2\u04d5\u04d6\3"+
		"\2\2\2\u04d6\u04d7\3\2\2\2\u04d7\u04d8\7\17\2\2\u04d8\u04da\3\2\2\2\u04d9"+
		"\u04c5\3\2\2\2\u04d9\u04c7\3\2\2\2\u04d9\u04ce\3\2\2\2\u04da\u00b5\3\2"+
		"\2\2\u04db\u04e0\5\u00b8]\2\u04dc\u04dd\7\22\2\2\u04dd\u04df\5\u00b8]"+
		"\2\u04de\u04dc\3\2\2\2\u04df\u04e2\3\2\2\2\u04e0\u04de\3\2\2\2\u04e0\u04e1"+
		"\3\2\2\2\u04e1\u00b7\3\2\2\2\u04e2\u04e0\3\2\2\2\u04e3\u04e6\5\u0090I"+
		"\2\u04e4\u04e6\5\u00a4S\2\u04e5\u04e3\3\2\2\2\u04e5\u04e4\3\2\2\2\u04e6"+
		"\u04e7\3\2\2\2\u04e7\u04e8\7\21\2\2\u04e8\u04e9\5\u0086D\2\u04e9\u00b9"+
		"\3\2\2\2\u04ea\u04eb\7&\2\2\u04eb\u04ec\5\u009eP\2\u04ec\u00bb\3\2\2\2"+
		"\u04ed\u04ee\5\u00a6T\2\u04ee\u04fa\7\n\2\2\u04ef\u04f2\5\u00be`\2\u04f0"+
		"\u04f1\7\22\2\2\u04f1\u04f3\5\u00c0a\2\u04f2\u04f0\3\2\2\2\u04f2\u04f3"+
		"\3\2\2\2\u04f3\u04f6\3\2\2\2\u04f4\u04f6\5\u00c0a\2\u04f5\u04ef\3\2\2"+
		"\2\u04f5\u04f4\3\2\2\2\u04f6\u04f8\3\2\2\2\u04f7\u04f9\7\22\2\2\u04f8"+
		"\u04f7\3\2\2\2\u04f8\u04f9\3\2\2\2\u04f9\u04fb\3\2\2\2\u04fa\u04f5\3\2"+
		"\2\2\u04fa\u04fb\3\2\2\2\u04fb\u04fc\3\2\2\2\u04fc\u04fd\7\r\2\2\u04fd"+
		"\u00bd\3\2\2\2\u04fe\u0503\5\u0086D\2\u04ff\u0500\7\22\2\2\u0500\u0502"+
		"\5\u0086D\2\u0501\u04ff\3\2\2\2\u0502\u0505\3\2\2\2\u0503\u0501\3\2\2"+
		"\2\u0503\u0504\3\2\2\2\u0504\u00bf\3\2\2\2\u0505\u0503\3\2\2\2\u0506\u050b"+
		"\5\u00c2b\2\u0507\u0508\7\22\2\2\u0508\u050a\5\u00c2b\2\u0509\u0507\3"+
		"\2\2\2\u050a\u050d\3\2\2\2\u050b\u0509\3\2\2\2\u050b\u050c\3\2\2\2\u050c"+
		"\u00c1\3\2\2\2\u050d\u050b\3\2\2\2\u050e\u050f\5\u0188\u00c5\2\u050f\u0510"+
		"\7\34\2\2\u0510\u0511\5\u0086D\2\u0511\u00c3\3\2\2\2\u0512\u0513\7]\2"+
		"\2\u0513\u0515\5\u0188\u00c5\2\u0514\u0516\5\u00c6d\2\u0515\u0514\3\2"+
		"\2\2\u0515\u0516\3\2\2\2\u0516\u0517\3\2\2\2\u0517\u0518\7\34\2\2\u0518"+
		"\u0519\5\u00d4k\2\u0519\u00c5\3\2\2\2\u051a\u051b\7\13\2\2\u051b\u051c"+
		"\5\u00c8e\2\u051c\u051d\7\16\2\2\u051d\u00c7\3\2\2\2\u051e\u0523\5\u00ca"+
		"f\2\u051f\u0520\7\22\2\2\u0520\u0522\5\u00caf\2\u0521\u051f\3\2\2\2\u0522"+
		"\u0525\3\2\2\2\u0523\u0521\3\2\2\2\u0523\u0524\3\2\2\2\u0524\u0527\3\2"+
		"\2\2\u0525\u0523\3\2\2\2\u0526\u0528\7\22\2\2\u0527\u0526\3\2\2\2\u0527"+
		"\u0528\3\2\2\2\u0528\u00c9\3\2\2\2\u0529\u052b\5\u0188\u00c5\2\u052a\u052c"+
		"\5\u00ccg\2\u052b\u052a\3\2\2\2\u052b\u052c\3\2\2\2\u052c\u052e\3\2\2"+
		"\2\u052d\u052f\5\u00ceh\2\u052e\u052d\3\2\2\2\u052e\u052f\3\2\2\2\u052f"+
		"\u053b\3\2\2\2\u0530\u0531\7\26\2\2\u0531\u0533\5\u0188\u00c5\2\u0532"+
		"\u0534\5\u00d0i\2\u0533\u0532\3\2\2\2\u0533\u0534\3\2\2\2\u0534\u053b"+
		"\3\2\2\2\u0535\u0536\7&\2\2\u0536\u0538\5\u0188\u00c5\2\u0537\u0539\5"+
		"\u00ceh\2\u0538\u0537\3\2\2\2\u0538\u0539\3\2\2\2\u0539\u053b\3\2\2\2"+
		"\u053a\u0529\3\2\2\2\u053a\u0530\3\2\2\2\u053a\u0535\3\2\2\2\u053b\u00cb"+
		"\3\2\2\2\u053c\u053d\7\21\2\2\u053d\u053e\5\u00d4k\2\u053e\u00cd\3\2\2"+
		"\2\u053f\u0540\7\34\2\2\u0540\u0541\5\u00d4k\2\u0541\u00cf\3\2\2\2\u0542"+
		"\u0543\7\34\2\2\u0543\u0544\5\u00dan\2\u0544\u00d1\3\2\2\2\u0545\u054a"+
		"\5\u00d4k\2\u0546\u0547\7\22\2\2\u0547\u0549\5\u00d4k\2\u0548\u0546\3"+
		"\2\2\2\u0549\u054c\3\2\2\2\u054a\u0548\3\2\2\2\u054a\u054b\3\2\2\2\u054b"+
		"\u054e\3\2\2\2\u054c\u054a\3\2\2\2\u054d\u054f\7\22\2\2\u054e\u054d\3"+
		"\2\2\2\u054e\u054f\3\2\2\2\u054f\u00d3\3\2\2\2\u0550\u0556\5\u00e4s\2"+
		"\u0551\u0552\7Z\2\2\u0552\u0553\5\u00e4s\2\u0553\u0554\7<\2\2\u0554\u0555"+
		"\5\u00d4k\2\u0555\u0557\3\2\2\2\u0556\u0551\3\2\2\2\u0556\u0557\3\2\2"+
		"\2\u0557\u055a\3\2\2\2\u0558\u055a\5\u011e\u0090\2\u0559\u0550\3\2\2\2"+
		"\u0559\u0558\3\2\2\2\u055a\u00d5\3\2\2\2\u055b\u0561\7\\\2\2\u055c\u055d"+
		"\7P\2\2\u055d\u0562\5\u00d4k\2\u055e\u0560\5\u00d8m\2\u055f\u055e\3\2"+
		"\2\2\u055f\u0560\3\2\2\2\u0560\u0562\3\2\2\2\u0561\u055c\3\2\2\2\u0561"+
		"\u055f\3\2\2\2\u0562\u00d7\3\2\2\2\u0563\u0568\5\u00dan\2\u0564\u0565"+
		"\7\22\2\2\u0565\u0567\5\u00dan\2\u0566\u0564\3\2\2\2\u0567\u056a\3\2\2"+
		"\2\u0568\u0566\3\2\2\2\u0568\u0569\3\2\2\2\u0569\u056c\3\2\2\2\u056a\u0568"+
		"\3\2\2\2\u056b\u056d\7\22\2\2\u056c\u056b\3\2\2\2\u056c\u056d\3\2\2\2"+
		"\u056d\u00d9\3\2\2\2\u056e\u056f\7\26\2\2\u056f\u0572\5\u0102\u0082\2"+
		"\u0570\u0572\5\u00d4k\2\u0571\u056e\3\2\2\2\u0571\u0570\3\2\2\2\u0572"+
		"\u00db\3\2\2\2\u0573\u0578\5\u00dep\2\u0574\u0575\7\22\2\2\u0575\u0577"+
		"\5\u00dep\2\u0576\u0574\3\2\2\2\u0577\u057a\3\2\2\2\u0578\u0576\3\2\2"+
		"\2\u0578\u0579\3\2\2\2\u0579\u057c\3\2\2\2\u057a\u0578\3\2\2\2\u057b\u057d"+
		"\7\22\2\2\u057c\u057b\3\2\2\2\u057c\u057d\3\2\2\2\u057d\u00dd\3\2\2\2"+
		"\u057e\u057f\7\26\2\2\u057f\u0582\5\u0102\u0082\2\u0580\u0582\5\u00e2"+
		"r\2\u0581\u057e\3\2\2\2\u0581\u0580\3\2\2\2\u0582\u00df\3\2\2\2\u0583"+
		"\u0584\5\u0188\u00c5\2\u0584\u0585\78\2\2\u0585\u0586\5\u00d4k\2\u0586"+
		"\u00e1\3\2\2\2\u0587\u058a\5\u00e0q\2\u0588\u058a\5\u00d4k\2\u0589\u0587"+
		"\3\2\2\2\u0589\u0588\3\2\2\2\u058a\u00e3\3\2\2\2\u058b\u0590\5\u00e6t"+
		"\2\u058c\u058d\7[\2\2\u058d\u058f\5\u00e6t\2\u058e\u058c\3\2\2\2\u058f"+
		"\u0592\3\2\2\2\u0590\u058e\3\2\2\2\u0590\u0591\3\2\2\2\u0591\u00e5\3\2"+
		"\2\2\u0592\u0590\3\2\2\2\u0593\u0598\5\u00e8u\2\u0594\u0595\7I\2\2\u0595"+
		"\u0597\5\u00e8u\2\u0596\u0594\3\2\2\2\u0597\u059a\3\2\2\2\u0598\u0596"+
		"\3\2\2\2\u0598\u0599\3\2\2\2\u0599\u00e7\3\2\2\2\u059a\u0598\3\2\2\2\u059b"+
		"\u059c\7V\2\2\u059c\u059f\5\u00e8u\2\u059d\u059f\5\u00eav\2\u059e\u059b"+
		"\3\2\2\2\u059e\u059d\3\2\2\2\u059f\u00e9\3\2\2\2\u05a0\u05a4\5\u0102\u0082"+
		"\2\u05a1\u05a3\5\u00ecw\2\u05a2\u05a1\3\2\2\2\u05a3\u05a6\3\2\2\2\u05a4"+
		"\u05a2\3\2\2\2\u05a4\u05a5\3\2\2\2\u05a5\u00eb\3\2\2\2\u05a6\u05a4\3\2"+
		"\2\2\u05a7\u05b2\5\u00eex\2\u05a8\u05b2\5\u00f0y\2\u05a9\u05b2\5\u00f2"+
		"z\2\u05aa\u05b2\5\u00f4{\2\u05ab\u05b2\5\u00f6|\2\u05ac\u05b2\5\u00f8"+
		"}\2\u05ad\u05b2\5\u00fa~\2\u05ae\u05b2\5\u00fc\177\2\u05af\u05b2\5\u00fe"+
		"\u0080\2\u05b0\u05b2\5\u0100\u0081\2\u05b1\u05a7\3\2\2\2\u05b1\u05a8\3"+
		"\2\2\2\u05b1\u05a9\3\2\2\2\u05b1\u05aa\3\2\2\2\u05b1\u05ab\3\2\2\2\u05b1"+
		"\u05ac\3\2\2\2\u05b1\u05ad\3\2\2\2\u05b1\u05ae\3\2\2\2\u05b1\u05af\3\2"+
		"\2\2\u05b1\u05b0\3\2\2\2\u05b2\u00ed\3\2\2\2\u05b3\u05b4\7\36\2\2\u05b4"+
		"\u05b5\5\u0102\u0082\2\u05b5\u00ef\3\2\2\2\u05b6\u05b7\7\37\2\2\u05b7"+
		"\u05b8\5\u0102\u0082\2\u05b8\u00f1\3\2\2\2\u05b9\u05ba\7 \2\2\u05ba\u05bb"+
		"\5\u0102\u0082\2\u05bb\u00f3\3\2\2\2\u05bc\u05bd\7\32\2\2\u05bd\u05be"+
		"\5\u0102\u0082\2\u05be\u00f5\3\2\2\2\u05bf\u05c0\7!\2\2\u05c0\u05c1\5"+
		"\u0102\u0082\2\u05c1\u00f7\3\2\2\2\u05c2\u05c3\7\33\2\2\u05c3\u05c4\5"+
		"\u0102\u0082\2\u05c4\u00f9\3\2\2\2\u05c5\u05c6\7V\2\2\u05c6\u05c7\7B\2"+
		"\2\u05c7\u05c8\5\u0102\u0082\2\u05c8\u00fb\3\2\2\2\u05c9\u05ca\7B\2\2"+
		"\u05ca\u05cb\5\u0102\u0082\2\u05cb\u00fd\3\2\2\2\u05cc\u05cd\7G\2\2\u05cd"+
		"\u05ce\7V\2\2\u05ce\u05cf\5\u0102\u0082\2\u05cf\u00ff\3\2\2\2\u05d0\u05d1"+
		"\7G\2\2\u05d1\u05d2\5\u0102\u0082\2\u05d2\u0101\3\2\2\2\u05d3\u05d4\b"+
		"\u0082\1\2\u05d4\u05d5\5\u0104\u0083\2\u05d5\u05db\3\2\2\2\u05d6\u05d7"+
		"\f\4\2\2\u05d7\u05d8\7\30\2\2\u05d8\u05da\5\u0104\u0083\2\u05d9\u05d6"+
		"\3\2\2\2\u05da\u05dd\3\2\2\2\u05db\u05d9\3\2\2\2\u05db\u05dc\3\2\2\2\u05dc"+
		"\u0103\3\2\2\2\u05dd\u05db\3\2\2\2\u05de\u05df\b\u0083\1\2\u05df\u05e0"+
		"\5\u0106\u0084\2\u05e0\u05e6\3\2\2\2\u05e1\u05e2\f\4\2\2\u05e2\u05e3\7"+
		"#\2\2\u05e3\u05e5\5\u0106\u0084\2\u05e4\u05e1\3\2\2\2\u05e5\u05e8\3\2"+
		"\2\2\u05e6\u05e4\3\2\2\2\u05e6\u05e7\3\2\2\2\u05e7\u0105\3\2\2\2\u05e8"+
		"\u05e6\3\2\2\2\u05e9\u05ea\b\u0084\1\2\u05ea\u05eb\5\u0108\u0085\2\u05eb"+
		"\u05f1\3\2\2\2\u05ec\u05ed\f\4\2\2\u05ed\u05ee\7\31\2\2\u05ee\u05f0\5"+
		"\u0108\u0085\2\u05ef\u05ec\3\2\2\2\u05f0\u05f3\3\2\2\2\u05f1\u05ef\3\2"+
		"\2\2\u05f1\u05f2\3\2\2\2\u05f2\u0107\3\2\2\2\u05f3\u05f1\3\2\2\2\u05f4"+
		"\u05f5\b\u0085\1\2\u05f5\u05f6\5\u010a\u0086\2\u05f6\u05fc\3\2\2\2\u05f7"+
		"\u05f8\f\4\2\2\u05f8\u05f9\t\5\2\2\u05f9\u05fb\5\u010a\u0086\2\u05fa\u05f7"+
		"\3\2\2\2\u05fb\u05fe\3\2\2\2\u05fc\u05fa\3\2\2\2\u05fc\u05fd\3\2\2\2\u05fd"+
		"\u0109\3\2\2\2\u05fe\u05fc\3\2\2\2\u05ff\u0600\b\u0086\1\2\u0600\u0601"+
		"\5\u010c\u0087\2\u0601\u0607\3\2\2\2\u0602\u0603\f\4\2\2\u0603\u0604\t"+
		"\4\2\2\u0604\u0606\5\u010c\u0087\2\u0605\u0602\3\2\2\2\u0606\u0609\3\2"+
		"\2\2\u0607\u0605\3\2\2\2\u0607\u0608\3\2\2\2\u0608\u010b\3\2\2\2\u0609"+
		"\u0607\3\2\2\2\u060a\u060b\b\u0087\1\2\u060b\u060c\5\u010e\u0088\2\u060c"+
		"\u0612\3\2\2\2\u060d\u060e\f\4\2\2\u060e\u060f\t\6\2\2\u060f\u0611\5\u010e"+
		"\u0088\2\u0610\u060d\3\2\2\2\u0611\u0614\3\2\2\2\u0612\u0610\3\2\2\2\u0612"+
		"\u0613\3\2\2\2\u0613\u010d\3\2\2\2\u0614\u0612\3\2\2\2\u0615\u0616\7\24"+
		"\2\2\u0616\u061d\5\u010e\u0088\2\u0617\u0618\7\25\2\2\u0618\u061d\5\u010e"+
		"\u0088\2\u0619\u061a\7\"\2\2\u061a\u061d\5\u010e\u0088\2\u061b\u061d\5"+
		"\u0110\u0089\2\u061c\u0615\3\2\2\2\u061c\u0617\3\2\2\2\u061c\u0619\3\2"+
		"\2\2\u061c\u061b\3\2\2\2\u061d\u010f\3\2\2\2\u061e\u0621\5\u0112\u008a"+
		"\2\u061f\u0620\7&\2\2\u0620\u0622\5\u010e\u0088\2\u0621\u061f\3\2\2\2"+
		"\u0621\u0622\3\2\2\2\u0622\u0111\3\2\2\2\u0623\u0624\7;\2\2\u0624\u0627"+
		"\5\u0114\u008b\2\u0625\u0627\5\u0114\u008b\2\u0626\u0623\3\2\2\2\u0626"+
		"\u0625\3\2\2\2\u0627\u0113\3\2\2\2\u0628\u0629\b\u008b\1\2\u0629\u062a"+
		"\5\u011a\u008e\2\u062a\u063c\3\2\2\2\u062b\u0638\f\4\2\2\u062c\u062d\7"+
		"\20\2\2\u062d\u0639\5\u0188\u00c5\2\u062e\u0639\5\u015a\u00ae\2\u062f"+
		"\u0631\7\n\2\2\u0630\u0632\5\u015e\u00b0\2\u0631\u0630\3\2\2\2\u0631\u0632"+
		"\3\2\2\2\u0632\u0633\3\2\2\2\u0633\u0639\7\r\2\2\u0634\u0635\7\13\2\2"+
		"\u0635\u0636\5\u0116\u008c\2\u0636\u0637\7\16\2\2\u0637\u0639\3\2\2\2"+
		"\u0638\u062c\3\2\2\2\u0638\u062e\3\2\2\2\u0638\u062f\3\2\2\2\u0638\u0634"+
		"\3\2\2\2\u0639\u063b\3\2\2\2\u063a\u062b\3\2\2\2\u063b\u063e\3\2\2\2\u063c"+
		"\u063a\3\2\2\2\u063c\u063d\3\2\2\2\u063d\u0115\3\2\2\2\u063e\u063c\3\2"+
		"\2\2\u063f\u0652\5\u0118\u008d\2\u0640\u0643\5\u0118\u008d\2\u0641\u0643"+
		"\5\u0164\u00b3\2\u0642\u0640\3\2\2\2\u0642\u0641\3\2\2\2\u0643\u064b\3"+
		"\2\2\2\u0644\u0647\7\22\2\2\u0645\u0648\5\u0118\u008d\2\u0646\u0648\5"+
		"\u0164\u00b3\2\u0647\u0645\3\2\2\2\u0647\u0646\3\2\2\2\u0648\u064a\3\2"+
		"\2\2\u0649\u0644\3\2\2\2\u064a\u064d\3\2\2\2\u064b\u0649\3\2\2\2\u064b"+
		"\u064c\3\2\2\2\u064c\u064f\3\2\2\2\u064d\u064b\3\2\2\2\u064e\u0650\7\22"+
		"\2\2\u064f\u064e\3\2\2\2\u064f\u0650\3\2\2\2\u0650\u0652\3\2\2\2\u0651"+
		"\u063f\3\2\2\2\u0651\u0642\3\2\2\2\u0652\u0117\3\2\2\2\u0653\u0655\5\u00d4"+
		"k\2\u0654\u0653\3\2\2\2\u0654\u0655\3\2\2\2\u0655\u0656\3\2\2\2\u0656"+
		"\u0658\7\21\2\2\u0657\u0659\5\u00d4k\2\u0658\u0657\3\2\2\2\u0658\u0659"+
		"\3\2\2\2\u0659\u065e\3\2\2\2\u065a\u065c\7\21\2\2\u065b\u065d\5\u00d4"+
		"k\2\u065c\u065b\3\2\2\2\u065c\u065d\3\2\2\2\u065d\u065f\3\2\2\2\u065e"+
		"\u065a\3\2\2\2\u065e\u065f\3\2\2\2\u065f\u0662\3\2\2\2\u0660\u0662\5\u00e2"+
		"r\2\u0661\u0654\3\2\2\2\u0661\u0660\3\2\2\2\u0662\u0119\3\2\2\2\u0663"+
		"\u067a\5\u0188\u00c5\2\u0664\u067a\7D\2\2\u0665\u067a\7:\2\2\u0666\u067a"+
		"\7?\2\2\u0667\u067a\5\u0142\u00a2\2\u0668\u067a\7b\2\2\u0669\u066d\5\u0146"+
		"\u00a4\2\u066a\u066d\5\u011c\u008f\2\u066b\u066d\5\u015a\u00ae\2\u066c"+
		"\u0669\3\2\2\2\u066c\u066a\3\2\2\2\u066c\u066b\3\2\2\2\u066d\u067a\3\2"+
		"\2\2\u066e\u0671\5\u0144\u00a3\2\u066f\u0671\5\u0156\u00ac\2\u0670\u066e"+
		"\3\2\2\2\u0670\u066f\3\2\2\2\u0671\u067a\3\2\2\2\u0672\u0677\5\u014a\u00a6"+
		"\2\u0673\u0677\5\u0148\u00a5\2\u0674\u0677\5\u015c\u00af\2\u0675\u0677"+
		"\5\u0158\u00ad\2\u0676\u0672\3\2\2\2\u0676\u0673\3\2\2\2\u0676\u0674\3"+
		"\2\2\2\u0676\u0675\3\2\2\2\u0677\u067a\3\2\2\2\u0678\u067a\7\67\2\2\u0679"+
		"\u0663\3\2\2\2\u0679\u0664\3\2\2\2\u0679\u0665\3\2\2\2\u0679\u0666\3\2"+
		"\2\2\u0679\u0667\3\2\2\2\u0679\u0668\3\2\2\2\u0679\u066c\3\2\2\2\u0679"+
		"\u0670\3\2\2\2\u0679\u0676\3\2\2\2\u0679\u0678\3\2\2\2\u067a\u011b\3\2"+
		"\2\2\u067b\u067e\7\n\2\2\u067c\u067f\5\u00d6l\2\u067d\u067f\5\u00e2r\2"+
		"\u067e\u067c\3\2\2\2\u067e\u067d\3\2\2\2\u067f\u0680\3\2\2\2\u0680\u0681"+
		"\7\r\2\2\u0681\u011d\3\2\2\2\u0682\u0684\7L\2\2\u0683\u0685\5\u0120\u0091"+
		"\2\u0684\u0683\3\2\2\2\u0684\u0685\3\2\2\2\u0685\u0686\3\2\2\2\u0686\u0687"+
		"\7\21\2\2\u0687\u0688\5\u00d4k\2\u0688\u011f\3\2\2\2\u0689\u068a\5\u0122"+
		"\u0092\2\u068a\u0121\3\2\2\2\u068b\u068f\5\u0124\u0093\2\u068c\u068e\5"+
		"\u012c\u0097\2\u068d\u068c\3\2\2\2\u068e\u0691\3\2\2\2\u068f\u068d\3\2"+
		"\2\2\u068f\u0690\3\2\2\2\u0690\u0695\3\2\2\2\u0691\u068f\3\2\2\2\u0692"+
		"\u0694\5\u012e\u0098\2\u0693\u0692\3\2\2\2\u0694\u0697\3\2\2\2\u0695\u0693"+
		"\3\2\2\2\u0695\u0696\3\2\2\2\u0696\u0699\3\2\2\2\u0697\u0695\3\2\2\2\u0698"+
		"\u069a\5\u0128\u0095\2\u0699\u0698\3\2\2\2\u0699\u069a\3\2\2\2\u069a\u06bd"+
		"\3\2\2\2\u069b\u069f\5\u0126\u0094\2\u069c\u069e\5\u012e\u0098\2\u069d"+
		"\u069c\3\2\2\2\u069e\u06a1\3\2\2\2\u069f\u069d\3\2\2\2\u069f\u06a0\3\2"+
		"\2\2\u06a0\u06a3\3\2\2\2\u06a1\u069f\3\2\2\2\u06a2\u06a4\5\u0128\u0095"+
		"\2\u06a3\u06a2\3\2\2\2\u06a3\u06a4\3\2\2\2\u06a4\u06bd\3\2\2\2\u06a5\u06a7"+
		"\5\u012c\u0097\2\u06a6\u06a5\3\2\2\2\u06a7\u06a8\3\2\2\2\u06a8\u06a6\3"+
		"\2\2\2\u06a8\u06a9\3\2\2\2\u06a9\u06ad\3\2\2\2\u06aa\u06ac\5\u012e\u0098"+
		"\2\u06ab\u06aa\3\2\2\2\u06ac\u06af\3\2\2\2\u06ad\u06ab\3\2\2\2\u06ad\u06ae"+
		"\3\2\2\2\u06ae\u06b1\3\2\2\2\u06af\u06ad\3\2\2\2\u06b0\u06b2\5\u0128\u0095"+
		"\2\u06b1\u06b0\3\2\2\2\u06b1\u06b2\3\2\2\2\u06b2\u06bd\3\2\2\2\u06b3\u06b5"+
		"\5\u012e\u0098\2\u06b4\u06b3\3\2\2\2\u06b5\u06b6\3\2\2\2\u06b6\u06b4\3"+
		"\2\2\2\u06b6\u06b7\3\2\2\2\u06b7\u06b9\3\2\2\2\u06b8\u06ba\5\u0128\u0095"+
		"\2\u06b9\u06b8\3\2\2\2\u06b9\u06ba\3\2\2\2\u06ba\u06bd\3\2\2\2\u06bb\u06bd"+
		"\5\u0128\u0095\2\u06bc\u068b\3\2\2\2\u06bc\u069b\3\2\2\2\u06bc\u06a6\3"+
		"\2\2\2\u06bc\u06b4\3\2\2\2\u06bc\u06bb\3\2\2\2\u06bd\u0123\3\2\2\2\u06be"+
		"\u06c0\5\u012c\u0097\2\u06bf\u06be\3\2\2\2\u06c0\u06c1\3\2\2\2\u06c1\u06bf"+
		"\3\2\2\2\u06c1\u06c2\3\2\2\2\u06c2\u06c3\3\2\2\2\u06c3\u06c5\7\27\2\2"+
		"\u06c4\u06c6\7\22\2\2\u06c5\u06c4\3\2\2\2\u06c5\u06c6\3\2\2\2\u06c6\u0125"+
		"\3\2\2\2\u06c7\u06c9\5\u012c\u0097\2\u06c8\u06c7\3\2\2\2\u06c9\u06cc\3"+
		"\2\2\2\u06ca\u06c8\3\2\2\2\u06ca\u06cb\3\2\2\2\u06cb\u06ce\3\2\2\2\u06cc"+
		"\u06ca\3\2\2\2\u06cd\u06cf\5\u012e\u0098\2\u06ce\u06cd\3\2\2\2\u06cf\u06d0"+
		"\3\2\2\2\u06d0\u06ce\3\2\2\2\u06d0\u06d1\3\2\2\2\u06d1\u06d2\3\2\2\2\u06d2"+
		"\u06d4\7\27\2\2\u06d3\u06d5\7\22\2\2\u06d4\u06d3\3\2\2\2\u06d4\u06d5\3"+
		"\2\2\2\u06d5\u0127\3\2\2\2\u06d6\u06d7\7\26\2\2\u06d7\u06db\5\u012c\u0097"+
		"\2\u06d8\u06da\5\u0130\u0099\2\u06d9\u06d8\3\2\2\2\u06da\u06dd\3\2\2\2"+
		"\u06db\u06d9\3\2\2\2\u06db\u06dc\3\2\2\2\u06dc\u06df\3\2\2\2\u06dd\u06db"+
		"\3\2\2\2\u06de\u06e0\5\u012a\u0096\2\u06df\u06de\3\2\2\2\u06df\u06e0\3"+
		"\2\2\2\u06e0\u06ed\3\2\2\2\u06e1\u06e2\7\26\2\2\u06e2\u06e4\7\22\2\2\u06e3"+
		"\u06e5\5\u0130\u0099\2\u06e4\u06e3\3\2\2\2\u06e5\u06e6\3\2\2\2\u06e6\u06e4"+
		"\3\2\2\2\u06e6\u06e7\3\2\2\2\u06e7\u06e9\3\2\2\2\u06e8\u06ea\5\u012a\u0096"+
		"\2\u06e9\u06e8\3\2\2\2\u06e9\u06ea\3\2\2\2\u06ea\u06ed\3\2\2\2\u06eb\u06ed"+
		"\5\u012a\u0096\2\u06ec\u06d6\3\2\2\2\u06ec\u06e1\3\2\2\2\u06ec\u06eb\3"+
		"\2\2\2\u06ed\u0129\3\2\2\2\u06ee\u06ef\7&\2\2\u06ef\u06f0\5\u012c\u0097"+
		"\2\u06f0\u012b\3\2\2\2\u06f1\u06f3\5\u0132\u009a\2\u06f2\u06f4\7\22\2"+
		"\2\u06f3\u06f2\3\2\2\2\u06f3\u06f4\3\2\2\2\u06f4\u012d\3\2\2\2\u06f5\u06f6"+
		"\5\u0132\u009a\2\u06f6\u06f8\5d\63\2\u06f7\u06f9\7\22\2\2\u06f8\u06f7"+
		"\3\2\2\2\u06f8\u06f9\3\2\2\2\u06f9\u012f\3\2\2\2\u06fa\u06fc\5\u0132\u009a"+
		"\2\u06fb\u06fd\5d\63\2\u06fc\u06fb\3\2\2\2\u06fc\u06fd\3\2\2\2\u06fd\u06ff"+
		"\3\2\2\2\u06fe\u0700\7\22\2\2\u06ff\u06fe\3\2\2\2\u06ff\u0700\3\2\2\2"+
		"\u0700\u0131\3\2\2\2\u0701\u0702\5\u0188\u00c5\2\u0702\u0133\3\2\2\2\u0703"+
		"\u0706\5\u0136\u009c\2\u0704\u0706\7\b\2\2\u0705\u0703\3\2\2\2\u0705\u0704"+
		"\3\2\2\2\u0706\u0135\3\2\2\2\u0707\u0708\7\f\2\2\u0708\u070a\5\30\r\2"+
		"\u0709\u070b\7\34\2\2\u070a\u0709\3\2\2\2\u070a\u070b\3\2\2\2\u070b\u070d"+
		"\3\2\2\2\u070c\u070e\5\u0138\u009d\2\u070d\u070c\3\2\2\2\u070d\u070e\3"+
		"\2\2\2\u070e\u0710\3\2\2\2\u070f\u0711\5\u013a\u009e\2\u0710\u070f\3\2"+
		"\2\2\u0710\u0711\3\2\2\2\u0711\u0712\3\2\2\2\u0712\u0713\7\17\2\2\u0713"+
		"\u0137\3\2\2\2\u0714\u0715\79\2\2\u0715\u0716\5\u0188\u00c5\2\u0716\u0139"+
		"\3\2\2\2\u0717\u071b\7\21\2\2\u0718\u071a\5\u013c\u009f\2\u0719\u0718"+
		"\3\2\2\2\u071a\u071d\3\2\2\2\u071b\u0719\3\2\2\2\u071b\u071c\3\2\2\2\u071c"+
		"\u013b\3\2\2\2\u071d\u071b\3\2\2\2\u071e\u0721\7\b\2\2\u071f\u0721\5\u0136"+
		"\u009c\2\u0720\u071e\3\2\2\2\u0720\u071f\3\2\2\2\u0721\u013d\3\2\2\2\u0722"+
		"\u0726\7\7\2\2\u0723\u0725\5\u0134\u009b\2\u0724\u0723\3\2\2\2\u0725\u0728"+
		"\3\2\2\2\u0726\u0724\3\2\2\2\u0726\u0727\3\2\2\2\u0727\u0729\3\2\2\2\u0728"+
		"\u0726\3\2\2\2\u0729\u072a\7\t\2\2\u072a\u013f\3\2\2\2\u072b\u072c\7c"+
		"\2\2\u072c\u0141\3\2\2\2\u072d\u0730\5\u013e\u00a0\2\u072e\u0730\5\u0140"+
		"\u00a1\2\u072f\u072d\3\2\2\2\u072f\u072e\3\2\2\2\u0730\u0731\3\2\2\2\u0731"+
		"\u072f\3\2\2\2\u0731\u0732\3\2\2\2\u0732\u0143\3\2\2\2\u0733\u0735\7\13"+
		"\2\2\u0734\u0736\5\u00dco\2\u0735\u0734\3\2\2\2\u0735\u0736\3\2\2\2\u0736"+
		"\u0737\3\2\2\2\u0737\u0738\7\16\2\2\u0738\u0145\3\2\2\2\u0739\u073f\7"+
		"\n\2\2\u073a\u073b\5\u00dep\2\u073b\u073d\7\22\2\2\u073c\u073e\5\u00dc"+
		"o\2\u073d\u073c\3\2\2\2\u073d\u073e\3\2\2\2\u073e\u0740\3\2\2\2\u073f"+
		"\u073a\3\2\2\2\u073f\u0740\3\2\2\2\u0740\u0741\3\2\2\2\u0741\u0742\7\r"+
		"\2\2\u0742\u0147\3\2\2\2\u0743\u0744\7\f\2\2\u0744\u0745\5\u00dco\2\u0745"+
		"\u0746\7\17\2\2\u0746\u0149\3\2\2\2\u0747\u0749\7\f\2\2\u0748\u074a\5"+
		"\u014c\u00a7\2\u0749\u0748\3\2\2\2\u0749\u074a\3\2\2\2\u074a\u074b\3\2"+
		"\2\2\u074b\u074c\7\17\2\2\u074c\u014b\3\2\2\2\u074d\u0752\5\u014e\u00a8"+
		"\2\u074e\u074f\7\22\2\2\u074f\u0751\5\u014e\u00a8\2\u0750\u074e\3\2\2"+
		"\2\u0751\u0754\3\2\2\2\u0752\u0750\3\2\2\2\u0752\u0753\3\2\2\2\u0753\u0756"+
		"\3\2\2\2\u0754\u0752\3\2\2\2\u0755\u0757\7\22\2\2\u0756\u0755\3\2\2\2"+
		"\u0756\u0757\3\2\2\2\u0757\u014d\3\2\2\2\u0758\u0759\7&\2\2\u0759\u075c"+
		"\5\u0102\u0082\2\u075a\u075c\5\u0150\u00a9\2\u075b\u0758\3\2\2\2\u075b"+
		"\u075a\3\2\2\2\u075c\u014f\3\2\2\2\u075d\u075e\5\u00d4k\2\u075e\u075f"+
		"\7\21\2\2\u075f\u0760\5\u00d4k\2\u0760\u0151\3\2\2\2\u0761\u0763\5\u0154"+
		"\u00ab\2\u0762\u0761\3\2\2\2\u0763\u0764\3\2\2\2\u0764\u0762\3\2\2\2\u0764"+
		"\u0765\3\2\2\2\u0765\u0153\3\2\2\2\u0766\u0768\7X\2\2\u0767\u0766\3\2"+
		"\2\2\u0767\u0768\3\2\2\2\u0768\u0769\3\2\2\2\u0769\u076a\7K\2\2\u076a"+
		"\u076b\5\u016a\u00b6\2\u076b\u076c\7B\2\2\u076c\u0771\5\u00e4s\2\u076d"+
		"\u076e\7Z\2\2\u076e\u0770\5\u00e4s\2\u076f\u076d\3\2\2\2\u0770\u0773\3"+
		"\2\2\2\u0771\u076f\3\2\2\2\u0771\u0772\3\2\2\2\u0772\u0155\3\2\2\2\u0773"+
		"\u0771\3\2\2\2\u0774\u0775\7\13\2\2\u0775\u0776\5\u00e2r\2\u0776\u0777"+
		"\5\u0152\u00aa\2\u0777\u0778\7\16\2\2\u0778\u0157\3\2\2\2\u0779\u077a"+
		"\7\f\2\2\u077a\u077b\5\u00e2r\2\u077b\u077c\5\u0152\u00aa\2\u077c\u077d"+
		"\7\17\2\2\u077d\u0159\3\2\2\2\u077e\u0781\7\n\2\2\u077f\u0782\5\u00e0"+
		"q\2\u0780\u0782\5\u00d4k\2\u0781\u077f\3\2\2\2\u0781\u0780\3\2\2\2\u0782"+
		"\u0783\3\2\2\2\u0783\u0784\5\u0152\u00aa\2\u0784\u0785\7\r\2\2\u0785\u015b"+
		"\3\2\2\2\u0786\u0787\7\f\2\2\u0787\u0788\5\u0150\u00a9\2\u0788\u0789\5"+
		"\u0152\u00aa\2\u0789\u078a\7\17\2\2\u078a\u015d\3\2\2\2\u078b\u078d\5"+
		"\u0160\u00b1\2\u078c\u078e\7\22\2\2\u078d\u078c\3\2\2\2\u078d\u078e\3"+
		"\2\2\2\u078e\u015f\3\2\2\2\u078f\u0795\5\u0164\u00b3\2\u0790\u0793\5\u00e0"+
		"q\2\u0791\u0793\5\u00d4k\2\u0792\u0790\3\2\2\2\u0792\u0791\3\2\2\2\u0793"+
		"\u0795\3\2\2\2\u0794\u078f\3\2\2\2\u0794\u0792\3\2\2\2\u0795\u07a0\3\2"+
		"\2\2\u0796\u079c\7\22\2\2\u0797\u079d\5\u0164\u00b3\2\u0798\u079b\5\u00e0"+
		"q\2\u0799\u079b\5\u00d4k\2\u079a\u0798\3\2\2\2\u079a\u0799\3\2\2\2\u079b"+
		"\u079d\3\2\2\2\u079c\u0797\3\2\2\2\u079c\u079a\3\2\2\2\u079d\u079f\3\2"+
		"\2\2\u079e\u0796\3\2\2\2\u079f\u07a2\3\2\2\2\u07a0\u079e\3\2\2\2\u07a0"+
		"\u07a1\3\2\2\2\u07a1\u07a5\3\2\2\2\u07a2\u07a0\3\2\2\2\u07a3\u07a4\7\22"+
		"\2\2\u07a4\u07a6\5\u0162\u00b2\2\u07a5\u07a3\3\2\2\2\u07a5\u07a6\3\2\2"+
		"\2\u07a6\u07a9\3\2\2\2\u07a7\u07a9\5\u0162\u00b2\2\u07a8\u0794\3\2\2\2"+
		"\u07a8\u07a7\3\2\2\2\u07a9\u0161\3\2\2\2\u07aa\u07af\5\u0166\u00b4\2\u07ab"+
		"\u07ac\7\22\2\2\u07ac\u07ae\5\u0166\u00b4\2\u07ad\u07ab\3\2\2\2\u07ae"+
		"\u07b1\3\2\2\2\u07af\u07ad\3\2\2\2\u07af\u07b0\3\2\2\2\u07b0\u07bb\3\2"+
		"\2\2\u07b1\u07af\3\2\2\2\u07b2\u07b3\7\22\2\2\u07b3\u07b8\5\u0168\u00b5"+
		"\2\u07b4\u07b5\7\22\2\2\u07b5\u07b7\5\u0168\u00b5\2\u07b6\u07b4\3\2\2"+
		"\2\u07b7\u07ba\3\2\2\2\u07b8\u07b6\3\2\2\2\u07b8\u07b9\3\2\2\2\u07b9\u07bc"+
		"\3\2\2\2\u07ba\u07b8\3\2\2\2\u07bb\u07b2\3\2\2\2\u07bb\u07bc\3\2\2\2\u07bc"+
		"\u07c6\3\2\2\2\u07bd\u07c2\5\u0168\u00b5\2\u07be\u07bf\7\22\2\2\u07bf"+
		"\u07c1\5\u0168\u00b5\2\u07c0\u07be\3\2\2\2\u07c1\u07c4\3\2\2\2\u07c2\u07c0"+
		"\3\2\2\2\u07c2\u07c3\3\2\2\2\u07c3\u07c6\3\2\2\2\u07c4\u07c2\3\2\2\2\u07c5"+
		"\u07aa\3\2\2\2\u07c5\u07bd\3\2\2\2\u07c6\u0163\3\2\2\2\u07c7\u07c8\7\26"+
		"\2\2\u07c8\u07c9\5\u00d4k\2\u07c9\u0165\3\2\2\2\u07ca\u07cb\5\u0188\u00c5"+
		"\2\u07cb\u07cc\7\34\2\2\u07cc\u07cd\5\u00d4k\2\u07cd\u07d0\3\2\2\2\u07ce"+
		"\u07d0\5\u0164\u00b3\2\u07cf\u07ca\3\2\2\2\u07cf\u07ce\3\2\2\2\u07d0\u0167"+
		"\3\2\2\2\u07d1\u07d2\5\u0188\u00c5\2\u07d2\u07d3\7\34\2\2\u07d3\u07d4"+
		"\5\u00d4k\2\u07d4\u07d8\3\2\2\2\u07d5\u07d6\7&\2\2\u07d6\u07d8\5\u00d4"+
		"k\2\u07d7\u07d1\3\2\2\2\u07d7\u07d5\3\2\2\2\u07d8\u0169\3\2\2\2\u07d9"+
		"\u07de\5\u0170\u00b9\2\u07da\u07db\7\22\2\2\u07db\u07dd\5\u0170\u00b9"+
		"\2\u07dc\u07da\3\2\2\2\u07dd\u07e0\3\2\2\2\u07de\u07dc\3\2\2\2\u07de\u07df"+
		"\3\2\2\2\u07df\u07e2\3\2\2\2\u07e0\u07de\3\2\2\2\u07e1\u07e3\7\22\2\2"+
		"\u07e2\u07e1\3\2\2\2\u07e2\u07e3\3\2\2\2\u07e3\u016b\3\2\2\2\u07e4\u07e9"+
		"\5\u0170\u00b9\2\u07e5\u07e6\7\22\2\2\u07e6\u07e8\5\u0170\u00b9\2\u07e7"+
		"\u07e5\3\2\2\2\u07e8\u07eb\3\2\2\2\u07e9\u07e7\3\2\2\2\u07e9\u07ea\3\2"+
		"\2\2\u07ea\u07ed\3\2\2\2\u07eb\u07e9\3\2\2\2\u07ec\u07ee\7\22\2\2\u07ed"+
		"\u07ec\3\2\2\2\u07ed\u07ee\3\2\2\2\u07ee\u016d\3\2\2\2\u07ef\u07fa\5\u0170"+
		"\u00b9\2\u07f0\u07fb\7\22\2\2\u07f1\u07f2\7\22\2\2\u07f2\u07f4\5\u0170"+
		"\u00b9\2\u07f3\u07f1\3\2\2\2\u07f4\u07f5\3\2\2\2\u07f5\u07f3\3\2\2\2\u07f5"+
		"\u07f6\3\2\2\2\u07f6\u07f8\3\2\2\2\u07f7\u07f9\7\22\2\2\u07f8\u07f7\3"+
		"\2\2\2\u07f8\u07f9\3\2\2\2\u07f9\u07fb\3\2\2\2\u07fa\u07f0\3\2\2\2\u07fa"+
		"\u07f3\3\2\2\2\u07fb\u016f\3\2\2\2\u07fc\u07fd\7\26\2\2\u07fd\u0800\5"+
		"\u0170\u00b9\2\u07fe\u0800\5\u0172\u00ba\2\u07ff\u07fc\3\2\2\2\u07ff\u07fe"+
		"\3\2\2\2\u0800\u0171\3\2\2\2\u0801\u0808\5\u017a\u00be\2\u0802\u0803\7"+
		"\20\2\2\u0803\u0809\5\u0188\u00c5\2\u0804\u0805\7\13\2\2\u0805\u0806\5"+
		"\u0116\u008c\2\u0806\u0807\7\16\2\2\u0807\u0809\3\2\2\2\u0808\u0802\3"+
		"\2\2\2\u0808\u0804\3\2\2\2\u0809\u080c\3\2\2\2\u080a\u080c\5\u0174\u00bb"+
		"\2\u080b\u0801\3\2\2\2\u080b\u080a\3\2\2\2\u080c\u0173\3\2\2\2\u080d\u081d"+
		"\5\u0188\u00c5\2\u080e\u080f\7\n\2\2\u080f\u0810\5\u0172\u00ba\2\u0810"+
		"\u0811\7\r\2\2\u0811\u081d\3\2\2\2\u0812\u0814\7\n\2\2\u0813\u0815\5\u016e"+
		"\u00b8\2\u0814\u0813\3\2\2\2\u0814\u0815\3\2\2\2\u0815\u0816\3\2\2\2\u0816"+
		"\u081d\7\r\2\2\u0817\u0819\7\13\2\2\u0818\u081a\5\u016c\u00b7\2\u0819"+
		"\u0818\3\2\2\2\u0819\u081a\3\2\2\2\u081a\u081b\3\2\2\2\u081b\u081d\7\16"+
		"\2\2\u081c\u080d\3\2\2\2\u081c\u080e\3\2\2\2\u081c\u0812\3\2\2\2\u081c"+
		"\u0817\3\2\2\2\u081d\u0175\3\2\2\2\u081e\u0825\5\u0178\u00bd\2\u081f\u0825"+
		"\5\u0188\u00c5\2\u0820\u0821\7\n\2\2\u0821\u0822\5\u0176\u00bc\2\u0822"+
		"\u0823\7\r\2\2\u0823\u0825\3\2\2\2\u0824\u081e\3\2\2\2\u0824\u081f\3\2"+
		"\2\2\u0824\u0820\3\2\2\2\u0825\u0177\3\2\2\2\u0826\u082d\5\u017a\u00be"+
		"\2\u0827\u0828\7\20\2\2\u0828\u082e\5\u0188\u00c5\2\u0829\u082a\7\13\2"+
		"\2\u082a\u082b\5\u0116\u008c\2\u082b\u082c\7\16\2\2\u082c\u082e\3\2\2"+
		"\2\u082d\u0827\3\2\2\2\u082d\u0829\3\2\2\2\u082e\u0179\3\2\2\2\u082f\u0830"+
		"\b\u00be\1\2\u0830\u0831\5\u011a\u008e\2\u0831\u0843\3\2\2\2\u0832\u083f"+
		"\f\4\2\2\u0833\u0834\7\20\2\2\u0834\u0840\5\u0188\u00c5\2\u0835\u0836"+
		"\7\13\2\2\u0836\u0837\5\u0116\u008c\2\u0837\u0838\7\16\2\2\u0838\u0840"+
		"\3\2\2\2\u0839\u0840\5\u015a\u00ae\2\u083a\u083c\7\n\2\2\u083b\u083d\5"+
		"\u015e\u00b0\2\u083c\u083b\3\2\2\2\u083c\u083d\3\2\2\2\u083d\u083e\3\2"+
		"\2\2\u083e\u0840\7\r\2\2\u083f\u0833\3\2\2\2\u083f\u0835\3\2\2\2\u083f"+
		"\u0839\3\2\2\2\u083f\u083a\3\2\2\2\u0840\u0842\3\2\2\2\u0841\u0832\3\2"+
		"\2\2\u0842\u0845\3\2\2\2\u0843\u0841\3\2\2\2\u0843\u0844\3\2\2\2\u0844"+
		"\u017b\3\2\2\2\u0845\u0843\3\2\2\2\u0846\u084b\5\u017e\u00c0\2\u0847\u0848"+
		"\7\22\2\2\u0848\u084a\5\u017e\u00c0\2\u0849\u0847\3\2\2\2\u084a\u084d"+
		"\3\2\2\2\u084b\u0849\3\2\2\2\u084b\u084c\3\2\2\2\u084c\u084f\3\2\2\2\u084d"+
		"\u084b\3\2\2\2\u084e\u0850\7\22\2\2\u084f\u084e\3\2\2\2\u084f\u0850\3"+
		"\2\2\2\u0850\u017d\3\2\2\2\u0851\u0858\5\u017a\u00be\2\u0852\u0853\7\20"+
		"\2\2\u0853\u0859\5\u0188\u00c5\2\u0854\u0855\7\13\2\2\u0855\u0856\5\u0116"+
		"\u008c\2\u0856\u0857\7\16\2\2\u0857\u0859\3\2\2\2\u0858\u0852\3\2\2\2"+
		"\u0858\u0854\3\2\2\2\u0859\u085c\3\2\2\2\u085a\u085c\5\u0180\u00c1\2\u085b"+
		"\u0851\3\2\2\2\u085b\u085a\3\2\2\2\u085c\u017f\3\2\2\2\u085d\u086d\5\u0188"+
		"\u00c5\2\u085e\u085f\7\n\2\2\u085f\u0860\5\u017e\u00c0\2\u0860\u0861\7"+
		"\r\2\2\u0861\u086d\3\2\2\2\u0862\u0864\7\n\2\2\u0863\u0865\5\u017c\u00bf"+
		"\2\u0864\u0863\3\2\2\2\u0864\u0865\3\2\2\2\u0865\u0866\3\2\2\2\u0866\u086d"+
		"\7\r\2\2\u0867\u0869\7\13\2\2\u0868\u086a\5\u017c\u00bf\2\u0869\u0868"+
		"\3\2\2\2\u0869\u086a\3\2\2\2\u086a\u086b\3\2\2\2\u086b\u086d\7\16\2\2"+
		"\u086c\u085d\3\2\2\2\u086c\u085e\3\2\2\2\u086c\u0862\3\2\2\2\u086c\u0867"+
		"\3\2\2\2\u086d\u0181\3\2\2\2\u086e\u0873\5\u00d4k\2\u086f\u0870\7\22\2"+
		"\2\u0870\u0872\5\u00d4k\2\u0871\u086f\3\2\2\2\u0872\u0875\3\2\2\2\u0873"+
		"\u0871\3\2\2\2\u0873\u0874\3\2\2\2\u0874\u0882\3\2\2\2\u0875\u0873\3\2"+
		"\2\2\u0876\u0880\7\22\2\2\u0877\u0878\7\26\2\2\u0878\u087c\5\u00d4k\2"+
		"\u0879\u087a\7\22\2\2\u087a\u087b\7&\2\2\u087b\u087d\5\u00d4k\2\u087c"+
		"\u0879\3\2\2\2\u087c\u087d\3\2\2\2\u087d\u0881\3\2\2\2\u087e\u087f\7&"+
		"\2\2\u087f\u0881\5\u00d4k\2\u0880\u0877\3\2\2\2\u0880\u087e\3\2\2\2\u0881"+
		"\u0883\3\2\2\2\u0882\u0876\3\2\2\2\u0882\u0883\3\2\2\2\u0883\u088e\3\2"+
		"\2\2\u0884\u0885\7\26\2\2\u0885\u0889\5\u00d4k\2\u0886\u0887\7\22\2\2"+
		"\u0887\u0888\7&\2\2\u0888\u088a\5\u00d4k\2\u0889\u0886\3\2\2\2\u0889\u088a"+
		"\3\2\2\2\u088a\u088e\3\2\2\2\u088b\u088c\7&\2\2\u088c\u088e\5\u00d4k\2"+
		"\u088d\u086e\3\2\2\2\u088d\u0884\3\2\2\2\u088d\u088b\3\2\2\2\u088e\u0183"+
		"\3\2\2\2\u088f\u0890\7d\2\2\u0890\u0893\7\6\2\2\u0891\u0893\7\6\2\2\u0892"+
		"\u088f\3\2\2\2\u0892\u0891\3\2\2\2\u0893\u0185\3\2\2\2\u0894\u0895\t\7"+
		"\2\2\u0895\u0187\3\2\2\2\u0896\u0899\7`\2\2\u0897\u0899\5\u0186\u00c4"+
		"\2\u0898\u0896\3\2\2\2\u0898\u0897\3\2\2\2\u0899\u0189\3\2\2\2\u0128\u018b"+
		"\u0195\u019c\u01a4\u01ac\u01b0\u01b8\u01bf\u01c3\u01d5\u01df\u01e6\u01ed"+
		"\u01f3\u01fa\u01fe\u0201\u0207\u0209\u020d\u0213\u0219\u021b\u0223\u022c"+
		"\u0238\u023c\u0245\u0250\u0254\u0259\u025f\u0266\u026c\u0273\u0279\u0283"+
		"\u028c\u0294\u029a\u029f\u02a3\u02a6\u02af\u02b4\u02b8\u02bd\u02c1\u02c9"+
		"\u02cd\u02d2\u02d6\u02da\u02e2\u02e8\u02ec\u02f2\u02f6\u02fb\u0300\u0304"+
		"\u0309\u030c\u030f\u0314\u0318\u031d\u0323\u0327\u032e\u0332\u0339\u033d"+
		"\u0344\u0347\u034a\u0351\u0354\u0358\u035b\u0360\u0363\u0367\u036a\u036d"+
		"\u0371\u0385\u0387\u038f\u0391\u039c\u039f\u03a7\u03ab\u03b4\u03b8\u03bd"+
		"\u03c9\u03cd\u03d4\u03dc\u03e1\u03e5\u03ea\u03f7\u03fa\u03fd\u0405\u0408"+
		"\u040b\u040d\u0413\u0415\u041f\u0430\u0437\u043a\u043f\u0449\u044d\u0458"+
		"\u0463\u046b\u0473\u047a\u047f\u0494\u049b\u04a4\u04a9\u04ac\u04b1\u04b8"+
		"\u04bc\u04c0\u04ca\u04d2\u04d5\u04d9\u04e0\u04e5\u04f2\u04f5\u04f8\u04fa"+
		"\u0503\u050b\u0515\u0523\u0527\u052b\u052e\u0533\u0538\u053a\u054a\u054e"+
		"\u0556\u0559\u055f\u0561\u0568\u056c\u0571\u0578\u057c\u0581\u0589\u0590"+
		"\u0598\u059e\u05a4\u05b1\u05db\u05e6\u05f1\u05fc\u0607\u0612\u061c\u0621"+
		"\u0626\u0631\u0638\u063c\u0642\u0647\u064b\u064f\u0651\u0654\u0658\u065c"+
		"\u065e\u0661\u066c\u0670\u0676\u0679\u067e\u0684\u068f\u0695\u0699\u069f"+
		"\u06a3\u06a8\u06ad\u06b1\u06b6\u06b9\u06bc\u06c1\u06c5\u06ca\u06d0\u06d4"+
		"\u06db\u06df\u06e6\u06e9\u06ec\u06f3\u06f8\u06fc\u06ff\u0705\u070a\u070d"+
		"\u0710\u071b\u0720\u0726\u072f\u0731\u0735\u073d\u073f\u0749\u0752\u0756"+
		"\u075b\u0764\u0767\u0771\u0781\u078d\u0792\u0794\u079a\u079c\u07a0\u07a5"+
		"\u07a8\u07af\u07b8\u07bb\u07c2\u07c5\u07cf\u07d7\u07de\u07e2\u07e9\u07ed"+
		"\u07f5\u07f8\u07fa\u07ff\u0808\u080b\u0814\u0819\u081c\u0824\u082d\u083c"+
		"\u083f\u0843\u084b\u084f\u0858\u085b\u0864\u0869\u086c\u0873\u087c\u0880"+
		"\u0882\u0889\u088d\u0892\u0898";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}