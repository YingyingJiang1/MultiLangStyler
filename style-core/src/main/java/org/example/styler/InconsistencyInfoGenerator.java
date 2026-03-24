package org.example.styler;

import org.antlr.v4.runtime.Token;
import org.example.semantic.intf.symbol.Symbol;
import org.example.style.InconsistencyInfo;
import org.example.style.InconsistencyType;
import org.example.style.codecontext.ASTBasedCodeContext;
import org.example.style.codecontext.StructureCodeContext;
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

}
