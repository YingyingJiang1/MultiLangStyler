package org.example.styler;

import org.antlr.v4.runtime.Token;
import org.example.semantic.intf.symbol.Symbol;
import org.example.style.InconsistencyInfo;
import org.example.style.InconsistencyType;
import org.example.style.rule.StyleProperty;
import org.example.styler.naming.format.style.NamingFormatProperty;

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
}
