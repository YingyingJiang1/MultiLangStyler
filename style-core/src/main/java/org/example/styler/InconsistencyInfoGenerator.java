package org.example.styler;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.example.antlr.common.context.ExtendContext;
import org.example.antlr.common.token.ExtendToken;
import org.example.lang.LangAdapterCreator;
import org.example.lang.intf.ASTNodeSearcher;
import org.example.lang.intf.MyParser;
import org.example.semantic.intf.symbol.Symbol;
import org.example.style.InconsistencyInfo;
import org.example.style.InconsistencyType;
import org.example.style.StyleFileIO;
import org.example.style.StylerContainer;
import org.example.style.codecontext.ASTBasedCodeContext;
import org.example.style.codecontext.ListASTBasedCodeContext;
import org.example.style.codecontext.StructureCodeContext;
import org.example.style.codecontext.TokenBasedContext;
import org.example.stylekit.Applicator;
import org.example.styler.declaration.layout.style.DeclarationLayoutProperty;
import org.example.styler.format.indention.IndentionStyler;
import org.example.styler.format.indention.style.IndentionProperty;
import org.example.styler.format.newline.NewlineStyler;
import org.example.styler.format.newline.bodylayout.style.BodyLayoutProperty;
import org.example.styler.format.space.SpaceStyler;
import org.example.styler.format.space.style.SpaceContext;
import org.example.styler.format.space.style.SpaceProperty;
import org.example.styler.ifelse.bodyorder.style.IfElseBodyOrderProperty;
import org.example.styler.naming.format.style.NamingFormatProperty;
import org.example.styler.optionalbrace.style.OptionalBraceContext;
import org.example.styler.optionalbrace.style.OptionalBraceProperty;
import org.example.styler.structure.EquivalentStructure;
import org.example.styler.structure.style.StructPreferenceContext;
import org.example.styler.structure.style.StructPreferenceProperty;
import org.example.styler.structure.vtree.Forest;
import org.example.utils.CodeWrapResult;

public class InconsistencyInfoGenerator {
	// 内置的格式化styler容器
	private static final Map<String, StylerContainer> stylerContainers = new HashMap<>();

	private static String describeIndentation(String indentation) {
		if (indentation == null || indentation.isEmpty()) {
			return "";
		}

		StringBuilder sb = new StringBuilder();
		int i = 0;
		while (i < indentation.length()) {
			char ch = indentation.charAt(i);
			int j = i + 1;
			while (j < indentation.length() && indentation.charAt(j) == ch) {
				j++;
			}
			int count = j - i;

			String type;
			if (ch == '\t') {
				type = "<tab>";
			} else if (ch == ' ') {
				type = "<sp>";
			} else {
				type = String.format("<U+%04X>", (int) ch);
			}

			sb.append(count).append(type);
			i = j;
		}

		return sb.toString();
	}

	
	public static InconsistencyInfo generateForNaming(Symbol symbol, String newName, NamingFormatProperty property) {
		Token token = symbol.getDecIdentifierNode().getStop();
		// generate message
		StringBuilder message = new StringBuilder("Name should be ");
		message.append(property.caseFormat.name());
		if (property.startsWithUnderScore) {
			message.append(", start with underscore");
		}
		if (property.maxLength != Integer.MAX_VALUE) {
			message.append(String.format(", max length %d", property.maxLength));
		}

		return new InconsistencyInfo(
				InconsistencyType.NAMING,
				newName, token.getText(),
				message.toString(),
				new InconsistencyInfo.Location(token, token));
	}

	public static InconsistencyInfo generateForOptionalBrace(ASTBasedCodeContext codeContext, OptionalBraceContext styleContext,
															 OptionalBraceProperty current, OptionalBraceProperty target) {
		String actual = current.useBrace
				? "Braces present"
				: "Braces omitted";

		String expected = target.useBrace
				? "Braces should be present"
				: "Braces should be omitted";

		StringBuilder message = new StringBuilder();

		if (target.useBrace) {
			message.append("Braces should be added");
		} else {
			message.append("Braces should be removed");
		}

		message.append(".");

		return new InconsistencyInfo(
				InconsistencyType.OPTIONAL_BRACES,
				expected, actual,
				message.toString(),
				new InconsistencyInfo.Location(codeContext)
		);
	}

	public static InconsistencyInfo generateForStructuralStyle(StructureCodeContext codeContext, StructPreferenceContext styleContext,
		StructPreferenceProperty current, StructPreferenceProperty target, MyParser parser) {
			EquivalentStructure templateStructure = codeContext.getStructure();
			Forest forest = templateStructure.generateNewForest(current.getPreferenceIndex(), target.getPreferenceIndex(),
					codeContext.getStartNode(), parser);
			List<ParseTree> expectedTrees = forest.getTrees();
			List<? extends ParseTree> actualTrees = codeContext.getNodes();

			String expected = generateCodeStr(expectedTrees);
			String actual = generateCodeStr(actualTrees);

			String language = parser.getLanguage();
			expected = formatCodeWithStyle(expected, language);
			actual = formatCodeWithStyle(actual, language);

			// generate message
			String templateCode = templateStructure.getCodeSkeletonStr(target.getPreferenceIndex())
					.replace("$^", "").trim();
			String message = String.format("Pattern preference '%s'", templateCode);

			return new InconsistencyInfo(
				InconsistencyType.STRUCTURAL_STYLE,
				expected, actual,
				message, new InconsistencyInfo.Location(codeContext)
			);
	}

	// 只拼接格式化前的原始字符串序列
	private static String generateCodeStr(List<? extends ParseTree> trees) {
		StringBuilder str = new StringBuilder();
		for (ParseTree tree : trees) {
			if (tree instanceof TerminalNode node) {
				str.append(((ExtendToken) node.getSymbol()).getFormattedText());
			} else if (tree instanceof ExtendContext ctx) {
				ctx.getAllTokensRec().forEach(
					t -> str.append(((ExtendToken) t).getFormattedText())
				);
			}
		}
		return str.toString();
	}

	// 从resource目录载入标准 style.xml 并缓存
	private static void loadStandardStylerContainer(String language) {
		String lang = language == null ? "" : language.toLowerCase();
		String xmlPath = "/style/" + lang + "_style.xml";
		try (InputStream is = InconsistencyInfoGenerator.class.getResourceAsStream(xmlPath)) {
			if (is == null) {
				return;
			}

			Path tmp = Files.createTempFile("style-", "-" + lang + ".xml");
			try {
				Files.copy(is, tmp, StandardCopyOption.REPLACE_EXISTING);
				var styleProfile = StyleFileIO.read(tmp.toString());
				if (styleProfile == null) {
					return;
				}

				List<Class<?>> formatters = List.of(
						NewlineStyler.class, SpaceStyler.class, IndentionStyler.class
				);
				StylerContainer container = LangAdapterCreator.createStylerContainer(lang, formatters);
				container.fillStyle(styleProfile);
				stylerContainers.put(lang, container);
			} finally {
				try {
					Files.deleteIfExists(tmp);
				} catch (IOException ignored) {
				}
			}
		} catch (Exception ignored) {
		}
	}

	private static String formatCodeWithStyle(String code, String language) {
		if (code == null || code.isEmpty()) {
			return code;
		}
		String lang = language == null ? "" : language.toLowerCase();
		if (!stylerContainers.containsKey(lang)) {
			loadStandardStylerContainer(lang);
		}
		StylerContainer container = stylerContainers.get(lang);
		if (container == null) {
			return code;
		}
		org.example.utils.CodeWrapper wrapper = org.example.utils.CodeWrapperFactory.createWrapper(lang);
		CodeWrapResult wrapResult = wrapper.wrap(code);

		String formatted = Applicator.applyStyleFromString(wrapResult.getWrappedCode(), lang, container);
		wrapResult.setWrappedCode(formatted);
		return wrapper.unwrap(wrapResult);
	}



	public static InconsistencyInfo generateForSpace(TokenBasedContext codeContext,
			SpaceContext styleContext, SpaceProperty current, SpaceProperty target) {
		// around(tokenName1): space1/space2 都有意义，分别表示 token 左/右是否有空格
		String spaceSymbol = "\u00b7";
		if (styleContext.tokenName2.isEmpty()) {
			Token token = codeContext.getToken(0);
			return new InconsistencyInfo(
					InconsistencyType.SPACING,
					(target.space1 ? spaceSymbol : "") + token.getText() + (target.space2 ? spaceSymbol : ""),
					(current.space1 ? spaceSymbol : "") + token.getText() + (current.space2 ? spaceSymbol : ""),
					String.format("Space around '%s' is%s required", token.getText(), target.space1 ? "" : " not"),
					new InconsistencyInfo.Location(token, token)
				);
		} else {
			Token token1 = codeContext.getToken(0);
			Token token2 = codeContext.getToken(1);
			return new InconsistencyInfo(
				InconsistencyType.SPACING,
				token1.getText() + (target.space2 ? spaceSymbol : "") + token2.getText(),
				token1.getText() + (current.space2 ? spaceSymbol : "") + token2.getText(),
				String.format("Space between '%s' and '%s' is%s required", 
				token1.getText(), token2.getText(), target.space2 ? "" : " not"),
				new InconsistencyInfo.Location(codeContext)
			);
		}
	}

	

	public static InconsistencyInfo generateForIndention(TokenBasedContext codeContext, String curIndentionStr,
														 String targetIndentionStr, IndentionProperty targetProperty) {
		String expected = describeIndentation(targetIndentionStr);
		String actual = describeIndentation(curIndentionStr);

		String message = String.format(
				"Indentation style:  %d %s per level; top-level offset: %d; %s empty lines",
				targetProperty.indentionUnit,
				targetProperty.indentionType == '\t' ? "tabs" : "spaces",
				targetProperty.topHierarchyIndention,
				targetProperty.indentEmptyLine ? "indented" : "not indented"
		);

		return new InconsistencyInfo(
			InconsistencyType.INDENTATION,
			expected,
			actual,
			message,
			new InconsistencyInfo.Location(codeContext));
	}

	public static InconsistencyInfo generateForBodyLayout(Token startToken, Token stopToken,
		BodyLayoutProperty current, BodyLayoutProperty target) {
			String newlineSymbol = "\u21B5 ";
			StringBuilder expected = new StringBuilder();
			StringBuilder actual = new StringBuilder();
			if (target.beforeLB != current.beforeLB || target.afterLB != current.afterLB) {
				expected.append(target.beforeLB > 0 ? "\\n" : "[NUL]").
				append(startToken.getText()).append(target.afterLB > 0 ? "\\n" : "[NUL]");
				actual.append(current.beforeLB > 0 ? "\\n" : "[NUL]")
				.append(startToken.getText()).append(current.afterLB > 0 ? "\\n" : "[NUL]");
			}
			if (target.afterRB != current.afterRB) {
				expected.append(";" + (target.afterRB > 0 ? "\\n" : "[NUL]")).append(stopToken.getText());
				actual.append(";" + (current.afterRB > 0 ? "\\n" : "[NUL]")).append(stopToken.getText());
			}
			return new InconsistencyInfo(
				InconsistencyType.NEWLINE,
				expected.toString(),
				actual.toString(),
				"",
				new InconsistencyInfo.Location(startToken, stopToken)
			);
	}

	public static InconsistencyInfo generateForNewline(ExtendToken anchorToken, int newlineOperation, MyParser parser) {
		// original newlines
		int originalNewlines = (int) anchorToken.getContextTokens().stream()
				.filter(t -> t.getType() == parser.getVws())
				.mapToLong(t -> t.getText().chars().filter(ch -> ch == '\n').count())
				.sum();
		int expectedNewlines = originalNewlines + newlineOperation;
		return new InconsistencyInfo(
				InconsistencyType.NEWLINE,
				String.format("%d newlines after %s", Integer.max(expectedNewlines, 0), String.format("'%s'", anchorToken.getText())),
				String.format("%d newlines after %s", Integer.max(originalNewlines, 0), String.format("'%s'", anchorToken.getText())),
				newlineOperation > 0 ? String.format("%d Newline should be added", newlineOperation)
						: String.format("%d Newline should be removed", -newlineOperation) ,
				new InconsistencyInfo.Location(anchorToken, anchorToken));
	}

	public static InconsistencyInfo generateForDeclarationLayout(ListASTBasedCodeContext codeContext,
																 DeclarationLayoutProperty current, DeclarationLayoutProperty target, MyParser parser) {
		ASTNodeSearcher searcher = LangAdapterCreator.createASTNodeSearcher(parser.getLanguage());
		if (target.isMerge()) {
			// 获取分开声明的变量
			List<String> identifierNames = new ArrayList<>();
			for (ParseTree node : codeContext.getNodes()) {
				if (node instanceof ExtendContext ctx) {
					List<ParseTree> identifiers = searcher.searchAllDeclaredIdentifiers(ctx);
					if (identifiers.size() == 1) {
						identifierNames.add(identifiers.get(0).getText());
					}
				}
			}

			String vars = identifierNames.stream()
					.map(name -> "'" + name + "'")
					.collect(Collectors.joining(", "));
			return new InconsistencyInfo(
				InconsistencyType.DECLARATION_LAYOUT,
				"merged declaration", // 单独生命的变量应该被合并
				"separate declarations",
					vars + " should be merged with an existing declaration",
				new InconsistencyInfo.Location(codeContext)
			);

		} else {
			List<String> identifierNames = new ArrayList<>();
			for (ParseTree node : codeContext.getNodes()) {
				if (node instanceof ExtendContext ctx) {
					List<String> identifiers = searcher.searchAllDeclaredIdentifiers(ctx)
							.stream().map(ParseTree::getText).toList();
					if (identifiers.size() > 1) {
						identifierNames.addAll(identifiers);
					}
				}
			}

			String vars = String.join(", ", identifierNames);
			return new InconsistencyInfo(
				InconsistencyType.DECLARATION_LAYOUT,
				"separate declarations",
				"merged declaration",
				"'" + vars + "'" + " should be declared individually",
				new InconsistencyInfo.Location(codeContext)
			);
		}
	}

	public static InconsistencyInfo generateForIfElseBodyOrder(ASTBasedCodeContext codeContext, 
		IfElseBodyOrderProperty current, IfElseBodyOrderProperty target) {
		InconsistencyInfo.Location location = new InconsistencyInfo.Location(codeContext);
            String message = target.shortBodyComesFirst ?
                    "branches should be ordered by line count in ascending order."
                    : "branches should be ordered by line count in descending order.";
            if (target.shortBodyComesFirst) {
                return new InconsistencyInfo(
                        InconsistencyType.IF_ELSE_ORDER,
                        "shorter branch first", "longer branch first",
                        message,
                        location
                );

            } else {
                return new InconsistencyInfo(
                        InconsistencyType.IF_ELSE_ORDER,
                        "longer branch first", "shorter branch first",
                        message,
                        location
                );

            }
	}

	public static void setStandardStylerContainer(String language, StylerContainer container) {
		stylerContainers.put(language, container);
	}
}
