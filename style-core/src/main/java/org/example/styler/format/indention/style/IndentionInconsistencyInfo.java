package org.example.styler.format.indention.style;

import org.example.style.InconsistencyInfo;

public class IndentionInconsistencyInfo extends InconsistencyInfo {
	public IndentionInconsistencyInfo(int[] startLoc, int[] endLoc, String message) {
		super(startLoc, endLoc, message);
	}
}
