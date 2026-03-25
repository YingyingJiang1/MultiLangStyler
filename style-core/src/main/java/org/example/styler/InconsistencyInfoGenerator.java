package org.example.styler;

import org.antlr.v4.runtime.Token;
import org.example.semantic.intf.symbol.Symbol;
import org.example.style.InconsistencyInfo;
import org.example.style.InconsistencyType;
import org.example.style.codecontext.ASTBasedCodeContext;
import org.example.style.codecontext.StructureCodeContext;
import org.example.style.codecontext.TokenBasedContext;
import org.example.styler.format.newline.NewlineApplicator;	
import org.example.antlr.common.token.ExtendToken;
import org.example.lang.intf.MyParser;
import org.example.styler.format.newline.bodylayout.style.BodyLayoutProperty;
import org.example.styler.format.newline.inter.style.InterNewlineProperty;
import org.example.styler.format.space.style.SpaceContext;
import org.example.styler.format.space.style.SpaceProperty;
import org.example.styler.naming.format.style.NamingFormatProperty;
import org.example.styler.optionalbrace.style.OptionalBraceContext;
import org.example.styler.optionalbrace.style.OptionalBraceProperty;
import org.example.styler.structure.EquivalentStructure;
import org.example.styler.structure.style.StructPreferenceContext;
import org.example.styler.structure.style.StructPreferenceProperty;

public class InconsistencyInfoGenerator {
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
				new InconsistencyInfo.Location(token.getLine(), token.getCharPositionInLine(),
						token.getLine(), token.getCharPositionInLine() + token.getText().length()));
	}

	public static InconsistencyInfo generateForOptionalBrace(ASTBasedCodeContext codeContext, OptionalBraceContext styleContext,
															 OptionalBraceProperty current, OptionalBraceProperty target) {
		Token token = codeContext.getContextNode().getStart();

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
		StructPreferenceProperty current, StructPreferenceProperty target) {
			EquivalentStructure templateStructure = codeContext.getStructure();
			String expected = templateStructure.getCodeSkeletonStr(target.getPreferenceIndex());
			String actual = templateStructure.getCodeSkeletonStr(current.getPreferenceIndex());
			expected = expected.replaceAll("\\$\\{[^}]+\\}", "...");
			actual = actual.replaceAll("\\$\\{[^}]+\\}", "...");
			String message = "";
			return new InconsistencyInfo(
				InconsistencyType.STRUCTURAL_STYLE,
				expected, actual,
				message, new InconsistencyInfo.Location(codeContext)
			);
	}

	public static InconsistencyInfo generateForSpace(TokenBasedContext codeContext, SpaceContext styleContext,
		SpaceProperty current, SpaceProperty target) {
			// spaces around a target token
			if (styleContext.tokenName2.isEmpty()) {
				Token token = codeContext.getTokens().get(codeContext.getStartIndex());
				return new InconsistencyInfo(
					InconsistencyType.SPACING,
					(target.space1 ? "[SP]" : "[NUL]") + token.getText() + (target.space2 ? "[SP]" : "[NUL]"),
					(current.space1 ? "[SP]" : "[NUL]") + token.getText() + (current.space2 ? "[SP]" : "[NUL]"),
					"",
					new InconsistencyInfo.Location(token.getLine(), token.getCharPositionInLine(), 
					token.getLine(), token.getCharPositionInLine() + token.getText().length())
				);
            } else {
				Token token1 = codeContext.getTokens().get(codeContext.getStartIndex());
				Token token2 = codeContext.getTokens().get(codeContext.getStartIndex() + 1);
				return new InconsistencyInfo(
					InconsistencyType.SPACING,
					token1.getText() + (target.space2 ? "[SP]" : "[NUL]") + token2.getText(),
					token1.getText() + (current.space2 ? "[SP]" : "[NUL]") + token2.getText(),
					"",
					new InconsistencyInfo.Location(codeContext)
				);
			}
	}

	public static InconsistencyInfo generateForIndention(TokenBasedContext codeContext, String curIndentionStr,
		String targetIndentionStr) {
		Token anchor = codeContext.getTokens().get(codeContext.getStartIndex());
		targetIndentionStr = targetIndentionStr.replaceAll("\t", "\\t").replaceAll(" ", " ");
		curIndentionStr = curIndentionStr.replaceAll("\t", "\\t").replaceAll(" ", " ");
		String expected = targetIndentionStr.isEmpty() ? "(none)" : "'" + targetIndentionStr + "'";
		String actual = curIndentionStr.isEmpty() ? "(none)" : "'" + curIndentionStr + "'";
		String message = "Indentation does not match";
		return new InconsistencyInfo(
			InconsistencyType.INDENTATION,
			expected,
			actual,
			message,
			new InconsistencyInfo.Location(anchor.getLine(), anchor.getCharPositionInLine(),
				anchor.getLine(), anchor.getCharPositionInLine() + anchor.getText().length()));
	}

	public static InconsistencyInfo generateForBodyLayout(Token startToken, Token stopToken,
		BodyLayoutProperty current, BodyLayoutProperty target) {
			StringBuilder expected = new StringBuilder();
			StringBuilder actual = new StringBuilder();
			if (target.beforeLB != current.beforeLB || target.afterLB != current.afterLB) {
				expected.append(target.beforeLB > 0 ? "\\n" : "(none)").
				append(startToken.getText()).append(target.afterLB > 0 ? "\\n" : "(none)");
				actual.append(current.beforeLB > 0 ? "\\n" : "(none)")
				.append(startToken.getText()).append(current.afterLB > 0 ? "\\n" : "(none)");
			}
			if (target.afterRB != current.afterRB) {
				expected.append(";" + (target.afterRB > 0 ? "\\n" : "(none)")).append(stopToken.getText());
				actual.append(";" + (current.afterRB > 0 ? "\\n" : "(none)")).append(stopToken.getText());
			}
			return new InconsistencyInfo(
				InconsistencyType.NEWLINE,
				expected.toString(),
				actual.toString(),
				"",
				new InconsistencyInfo.Location(startToken.getLine(), startToken.getCharPositionInLine(), 
				stopToken.getLine(), stopToken.getCharPositionInLine() + stopToken.getText().length())
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
						: String.format("%d Newline should be removed", newlineOperation) ,
				new InconsistencyInfo.Location(anchorToken.getLine(), anchorToken.getCharPositionInLine(),
						anchorToken.getLine(), anchorToken.getCharPositionInLine() + anchorToken.getText().length())
		);
	}
}
