package org.example.styler.format.space;

import org.antlr.v4.runtime.Token;
import org.example.RunStatistic;
import org.example.parser.common.MyParser;
import org.example.parser.common.token.ExtendToken;
import org.example.styler.format.space.style.SpaceStyle;

import java.util.List;

public class SpaceApplicator {
	public static void addRightSpace(List<Token> tokens, int index, MyParser parser) {
		ExtendToken cur = (ExtendToken) tokens.get(index);
		String curText = cur.getText();
		boolean noNeedCheck = !curText.equals("<") && !curText.equals(">");

		// Only add a space after the last '<'/'>' of shift operators.
		boolean isShiftEnd = (curText.equals("<") || curText.equals(">")) &&
				tokens.get(index - 1).getText().equals(curText) && !tokens.get(index + 1).getText().equals(curText);
		if (noNeedCheck || isShiftEnd) {
			cur.addTokenAfter(parser.getTokenFactory().create(parser.getHws(), " "), parser);
			RunStatistic.addTriggeredStyle(parser.getSourceFile(), new SpaceStyle().getStyleName());
		}
	}

	public static void addLeftSpace(List<Token> tokens, int index, MyParser parser) {
		ExtendToken cur = (ExtendToken) tokens.get(index);
		String curText = cur.getText();
		boolean noNeedCheck = !curText.equals("<") && !curText.equals(">");


		// Only add space before the first '<'/'>' of shift operators.
		boolean isShiftBegin = (curText.equals("<") || curText.equals(">")) &&
				tokens.get(index + 1).getText().equals(curText) && !tokens.get(index - 1).getText().equals(curText);
		if (noNeedCheck ||isShiftBegin ){
			cur.addTokenBefore(parser.getTokenFactory().create(parser.getHws(), " "), parser);
			RunStatistic.addTriggeredStyle(parser.getSourceFile(), new SpaceStyle().getStyleName());
		}
	}

	public static void removeRightSpace(List<Token> tokens, int index, MyParser parser) {
		ExtendToken cur = (ExtendToken) tokens.get(index);
		if (index + 1 < tokens.size() && parser.getHws() == tokens.get(index + 1).getType()) {
			SpaceApplicator.remove(tokens, index + 1);
			RunStatistic.addTriggeredStyle(parser.getSourceFile(), new SpaceStyle().getStyleName());
		}
	}

	public static void removeLeftSpace(List<Token> tokens, int index, MyParser parser) {
		ExtendToken cur = (ExtendToken) tokens.get(index);
		if (index - 1 >= 0 && parser.getHws() == tokens.get(index - 1).getType()) {
			SpaceApplicator.remove(tokens, index - 1);
			RunStatistic.addTriggeredStyle(parser.getSourceFile(), new SpaceStyle().getStyleName());
		}
	}

	private static void remove(List<Token> tokens, int index) {
		if (tokens.get(index) instanceof ExtendToken extendToken) {
			extendToken.setText("");
			extendToken.setType(-1);
		}
	}
}
