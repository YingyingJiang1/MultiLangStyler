package org.example.styler.structure.style;

import org.example.style.InconsistencyInfo;

public class StructureInconsistencyInfo extends InconsistencyInfo {
	public StructureInconsistencyInfo(int[] startLoc, int[] endLoc, String message) {
		super(startLoc, endLoc, message);
	}
}
