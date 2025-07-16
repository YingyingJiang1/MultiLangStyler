package org.example.styler.naming.format.style;

import org.example.style.InconsistencyInfo;

public class NamingInconsistencyInfo extends InconsistencyInfo {
	public NamingInconsistencyInfo(int[] startLoc, int[] endLoc, String message) {
		super(startLoc, endLoc, message);
	}
}
