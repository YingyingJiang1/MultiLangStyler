package org.example.lang.python;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;
import org.example.antlr.common.context.ExtendContext;
import org.example.antlr.common.factory.ExtendTokenFactory;
import org.example.antlr.python.PythonLexer;
import org.example.antlr.python.PythonParser;
import org.example.lang.base.MyParserBase;

import java.util.Set;
import java.util.function.Predicate;

public class MyPythonParser extends MyParserBase {
	private static final Set<String> keywords = Set.of(
			"False", "await", "else", "import", "pass", "None", "break", "except", "in", "raise",
			"True", "class", "finally", "is", "return", "and", "continue", "for", "lambda", "try",
			"as", "def", "from", "nonlocal", "while", "assert", "del", "global", "not", "with",
			"async", "elif", "if", "or", "yield",
			// soft keywords
			"type", "match", "case", "_"
	);


	@Override
	protected Parser generateParser(String code) {
		ExtendTokenFactory tokenFactory = getTokenFactory();
		Lexer lexer = new PythonLexer(CharStreams.fromString(code));
		lexer.setTokenFactory(tokenFactory);
		CommonTokenStream tokenStream = new CommonTokenStream(lexer);
		PythonParser parser = new PythonParser(tokenStream);
		parser.setTokenFactory(tokenFactory);
		return parser;
	}

	@Override
	protected ParseTree tryParse() {
		Predicate<ExtendContext> parseFailTester = new Predicate<ExtendContext>() {
			@Override
			public boolean test(ExtendContext root) {
				return parser.getNumberOfSyntaxErrors() > 0 || root.children.isEmpty();
			}
		};

		ExtendContext root = null;
		if (this.parser instanceof PythonParser parser) {
			root = parser.file_input();
			if (parseFailTester.test(root)) {
				parser.reset();
				root = parser.interactive();
				if (parseFailTester.test(root)) {
					parser.reset();
					root = parser.eval();
					if (parseFailTester.test(root)) {
						parser.reset();
						root = parser.func_type();
						if (parseFailTester.test(root)) {
							parser.reset();
							root = parser.statements();
							if (parseFailTester.test(root)) {
								parser.reset();
								root = parser.expression();
							}
						}
					}
				}
			}
		}

		return root;
	}

	@Override
	public String getLanguage() {
		return "python";
	}

	@Override
	public int getVws() {
		return PythonParser.NEWLINE;
	}

	@Override
	public int getHws() {
		return PythonParser.WS;
	}

	@Override
	public int getLineComment() {
		return PythonParser.COMMENT;
	}

	@Override
	public int getLT() {
		return PythonParser.LESS;
	}

	@Override
	public int getGT() {
		return PythonParser.GREATER;
	}

	@Override
	public int getSub() {
		return PythonParser.MINUS;
	}

	@Override
	public int getMul() {
		return PythonParser.STAR;
	}

	@Override
	public int getBlockComment() {
		return PythonParser.COMMENT;
	}

	@Override
	public boolean isKeyword(String text) {
		return keywords.contains(text);
	}
}