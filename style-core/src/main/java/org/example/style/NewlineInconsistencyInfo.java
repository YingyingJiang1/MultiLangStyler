package org.example.style;

import org.antlr.v4.runtime.Token;

public class NewlineInconsistencyInfo extends InconsistencyInfo{
	Token anchorToken; // newline inconsistency occurs after this token
	int newlineOperation; // positive: add newline; negative: remove newline

	public NewlineInconsistencyInfo(int[] startLoc, int[] endLoc, String message) {
		super(startLoc, endLoc, message);
	}

	public NewlineInconsistencyInfo(InconsistencyType type, String expected, String actual, String message, Location location) {
		super(type, expected, actual, message, location);
	}

	public NewlineInconsistencyInfo(Token anchorToken, int newlineOperation) {
		this.anchorToken = anchorToken;
		this.newlineOperation = newlineOperation;
	}

	public Token getAnchorToken() {
		return anchorToken;
	}

	public int getNewlineOperation() {
		return newlineOperation;
	}
}
