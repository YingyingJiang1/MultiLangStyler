package org.example.style;

import org.antlr.v4.runtime.Token;
import org.example.styler.format.newline.AnnotationNewlinePatchStyler;
import org.example.styler.format.newline.NewlineStyler;
import org.example.styler.format.newline.bodylayout.BodyLayoutStyler;
import org.example.styler.format.newline.inter.InterNewlineStyler;
import org.example.styler.format.newline.intra.IntraNewlineStyler;

import java.util.Map;

public class NewlineInconsistencyInfo extends InconsistencyInfo{
	private static final Map<Class<?>, Integer> priorityMap = Map.of(
			BodyLayoutStyler.class, 0 ,
			IntraNewlineStyler.class, 1,
			AnnotationNewlinePatchStyler.class, 2,
			InterNewlineStyler.class, 3,
			NewlineStyler.class, 4
	);
	Token anchorToken; // newline inconsistency occurs after this token
	int newlineOperation; // positive: add newline; negative: remove newline
	int priority;

	public NewlineInconsistencyInfo(Token anchorToken, int newlineOperation) {
		this.anchorToken = anchorToken;
		this.newlineOperation = newlineOperation;
	}

	public void setPriority(Class<?> clazz) {
		priority = priorityMap.getOrDefault(clazz, 5);
	}

	public Token getAnchorToken() {
		return anchorToken;
	}

	public int getNewlineOperation() {
		return newlineOperation;
	}

	public int getPriority() {
		return priority;
	}
}
