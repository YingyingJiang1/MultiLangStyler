package org.example.style;

import java.util.Arrays;
import java.util.Objects;

public class InconsistencyInfo {
	protected String source;
	protected int[] startLoc, endLoc; // start from 0
	protected InconsistencyType type;
	protected String message;
	protected String expected, actual;

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
		return Objects.deepEquals(startLoc, that.startLoc) && Objects.deepEquals(endLoc, that.endLoc)
				&& Objects.equals(expected, that.expected) && Objects.equals(actual, that.actual)
				&& Objects.equals(message, that.message);
	}

	@Override
	public String toString() {
		return String.format("""
				Type     : %s
				BeginLocation : line %d, column %d
				EndLocation   : line %d, column %d
				Expected : %s
				Actual   : %s
				Message  : %s
				""",
				type.name(),
				getStartRow(), getStartColumn(),
				getEndRow(), getEndColumn(),
				expected,
				actual,
				message);
	}

	@Override
	public int hashCode() {
		return Objects.hash(Arrays.hashCode(startLoc), Arrays.hashCode(endLoc), message, expected, actual);
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
