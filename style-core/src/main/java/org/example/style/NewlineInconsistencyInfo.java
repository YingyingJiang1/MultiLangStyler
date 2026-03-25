package org.example.style;

import org.antlr.v4.runtime.Token;

public class NewlineInconsistencyInfo extends InconsistencyInfo{
	Token startToken, stopToken;
	int newlineNum;

	public NewlineInconsistencyInfo(int[] startLoc, int[] endLoc, String message) {
		super(startLoc, endLoc, message);
	}

	public NewlineInconsistencyInfo(InconsistencyType type, String expected, String actual, String message, Location location) {
		super(type, expected, actual, message, location);
	}
}
