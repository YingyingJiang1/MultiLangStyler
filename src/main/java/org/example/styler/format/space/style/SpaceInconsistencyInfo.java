package org.example.styler.format.space.style;

import org.example.style.InconsistencyInfo;

public class SpaceInconsistencyInfo extends InconsistencyInfo {
	public SpaceInconsistencyInfo(int[] startLoc, int[] endLoc, String message) {
		super(startLoc, endLoc, message);
	}
}
