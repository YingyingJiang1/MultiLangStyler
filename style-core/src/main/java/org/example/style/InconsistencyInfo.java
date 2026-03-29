package org.example.style;

import java.util.Comparator;
import java.util.Objects;

import org.antlr.v4.runtime.Token;
import org.example.style.codecontext.CodeContext;

import lombok.Data;

public class InconsistencyInfo {
	protected InconsistencyType type;
	protected String message;
	protected String expected, actual;
	protected Location location;
	protected StyleApplyData styleApplyData; // TODO: remove this field

	public InconsistencyInfo() {
	}

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

	public Location getLocation() {
		return location;
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
	public static class Location implements Comparable<Location> {
		private int startRow, startColumn, endRow, endColumn; // row start from 1, column start from 0. endXXX is inclusive.

		public Location(CodeContext codeContext) {
			this.startRow = codeContext.getStartRow();
			this.startColumn = codeContext.getStartColumn();
			this.endRow = codeContext.getEndRow();
			this.endColumn = codeContext.getEndColumn();
		}

		public Location(Token startToken, Token stopToken) {
			this.startRow = startToken.getLine();
			this.startColumn = startToken.getCharPositionInLine();
			this.endRow = stopToken.getLine();
			this.endColumn = stopToken.getCharPositionInLine() + stopToken.getText().length() - 1;
		}

		@Override
		public int compareTo(Location o) {
			if (startRow != o.startRow) return startRow - o.startRow;
			if (startColumn != o.startColumn) return startColumn - o.startColumn;
			if (endRow != o.endRow) return endRow - o.endRow;
			return endColumn - o.endColumn;
		}
	}
}
