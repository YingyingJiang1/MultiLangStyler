package org.example.style;

import pascal.taie.analysis.pta.core.heap.Obj;

import java.util.Arrays;
import java.util.Objects;

public class InconsistencyInfo {
	protected int[] startLoc, endLoc; // start from 0
	protected String message;

	public InconsistencyInfo(int[] startLoc, int[] endLoc, String message) {
		this.startLoc = startLoc;
		this.endLoc = endLoc;
		this.message = message;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		InconsistencyInfo that = (InconsistencyInfo) o;
		return Objects.deepEquals(startLoc, that.startLoc) && Objects.deepEquals(endLoc, that.endLoc) && Objects.equals(message, that.message);
	}

	@Override
	public int hashCode() {
		return Objects.hash(Arrays.hashCode(startLoc), Arrays.hashCode(endLoc), message);
	}

	public int getStartRow() {
		return startLoc[0];
	}

	public int getStartColumn() {
		return startLoc[1];
	}

	public int getEndRow() {
		return endLoc[0];
	}

	public int getEndColumn() {
		return endLoc[0];
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String str) {
		message = str;
	}
}
