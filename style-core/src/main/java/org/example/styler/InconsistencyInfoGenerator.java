package org.example.styler;

import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.example.antlr.common.context.ExtendContext;
import org.example.semantic.intf.symbol.Symbol;
import org.example.style.InconsistencyInfo;
import org.example.style.InconsistencyType;
import org.example.style.codecontext.ASTBasedCodeContext;
import org.example.style.codecontext.CodeContext;
import org.example.style.rule.StyleProperty;
import org.example.styler.naming.format.style.NamingFormatProperty;
import org.example.styler.optionalbrace.style.OptionalBraceContext;
import org.example.styler.optionalbrace.style.OptionalBraceProperty;
import org.example.styler.structure.style.StructureInconsistencyInfo;

import java.util.ArrayList;

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

	public static InconsistencyInfo generateForStructuralStyle() {
		String expected = "Inconsistent syntax structure";
		String actual = "Inconsistent syntax structure";
		String message = "Inconsistent syntax structure";

		// Create inconsistency info
//		int[] startLoc = { ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine() };
//		Token stopToken = ctx.getStop();
//		int off = structure.getForests().get(targetIndex).getTrees().size() - 1;
//		if (off > 0) {
//			ExtendContext parent = (ExtendContext) ctx.getParent();
//			ParseTree lastMatchedTreeRoot = parent.getChild(parent.children.indexOf(ctx) + off);
//			if (lastMatchedTreeRoot instanceof ExtendContext ctx1) {
//				stopToken = ctx1.getStop();
//			} else if (lastMatchedTreeRoot instanceof TerminalNode ter) {
//				stopToken = ter.getSymbol();
//			}
//		}
//		int[] endLoc = { stopToken.getLine(), stopToken.getCharPositionInLine() };
//
//		infos = new ArrayList<>();
//		infos.add(new StructureInconsistencyInfo(startLoc, endLoc, "Inconsistent syntax structure"));
		return null;
	}

}
