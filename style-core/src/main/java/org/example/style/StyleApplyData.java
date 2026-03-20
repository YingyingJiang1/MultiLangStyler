package org.example.style;

import org.example.style.codecontext.CodeContext;

public class StyleApplyData {
	public CodeContext codeContext;
	public ApplyOperation operation;

	public StyleApplyData(CodeContext codeContext) {
		this.codeContext = codeContext;
	}

	public StyleApplyData(CodeContext codeContext, ApplyOperation operation) {
		this.codeContext = codeContext;
		this.operation = operation;
	}

}
