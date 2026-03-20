package org.example.style;

import lombok.Data;

import java.util.Arrays;
import java.util.Objects;

public class InconsistencyInfo {
	protected InconsistencyType type;
	protected String message;
	protected String expected, actual;
	protected Location location;
	protected StyleApplyData styleApplyData; // used to apply style without re-extracting and re-comparing code style.

	public InconsistencyInfo(int[] startLoc, int[] endLoc, String message){}

	public InconsistencyInfo(InconsistencyType type, String expected, String actual,String message,
							 Location location) {
		this.type = type;
		this.expected = expected;
		this.actual = actual;
		this.location = location;
		this.message = message;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		InconsistencyInfo that = (InconsistencyInfo) o;
		return Objects.equals(location, that.location) && Objects.equals(message, that.message)
				&& Objects.equals(expected, that.expected) && Objects.equals(actual, that.actual);
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
		return Objects.hash(location, message, expected, actual);
	}

	public int getStartRow() {
		return location.getStartRow();
	}

	public int getStartColumn() {
		return location.getStartColumn();
	}

	public int getEndRow() {
		return location.getEndRow();
	}

	public int getEndColumn() {
		return location.getEndColumn();
	}

	public StyleApplyData getStyleApplyData() {
		return styleApplyData;
	}

	public void setStyleApplyData(StyleApplyData styleApplyData) {
		this.styleApplyData = styleApplyData;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String str) {
		message = str;
	}

	@Data
	public static class Location {
		private int startRow, startColumn, endRow, endColumn;
		private String source;
		private int type;

		public final static int FILE = 1;
		public final static int STRING = 2;

		public Location(int startRow, int startColumn, int endRow, int endColumn) {
			this.startRow = startRow;
			this.startColumn = startColumn;
			this.endRow = endRow;
			this.endColumn = endColumn;
		}
	}
}
