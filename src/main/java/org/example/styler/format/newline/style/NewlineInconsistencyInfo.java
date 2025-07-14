package org.example.styler.format.newline.style;

import org.example.style.InconsistencyInfo;

public class NewlineInconsistencyInfo extends InconsistencyInfo {
	public NewlineInconsistencyInfo(int[] startLoc, int[] endLoc, String message) {
		super(startLoc, endLoc, message);
	}
}
