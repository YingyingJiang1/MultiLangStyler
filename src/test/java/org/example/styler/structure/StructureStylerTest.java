package org.example.styler.structure;

import org.antlr.v4.runtime.tree.ParseTree;
import org.example.parser.common.MyParser;
import org.example.parser.common.context.ExtendContext;
import org.example.parser.common.factory.MyParserFactory;
import org.example.style.rule.StyleRule;
import org.example.styler.Stage;
import org.example.styler.structure.style.StructPreferenceContext;
import org.example.styler.structure.style.StructPreferenceProperty;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StructureStylerTest {

	@Test
	void applyStyle() {
	}

	@Test
	void extractStyle_assignment() {
		StructureStyler styler = new StructureStyler();

		String code = "a = a + 3;";
		MyParser parser = MyParserFactory.createParser("java");
		ParseTree root = parser.parseFromString(code);
		if (root instanceof ExtendContext ctx) {
			styler.extractStyle(ctx, parser);
			for (StyleRule rule : styler.getStyle().getRules()) {
				if (rule.getStyleContext() instanceof StructPreferenceContext context
				&& context.getStructID() == 3) {
					System.out.printf("Test id:%s", context.getStructID());
					assertEquals(0, ((StructPreferenceProperty) rule.getStyleProperty()).getPreferenceIndex());
				}
			}
		}

	}

	@Test
	void extractStyle_continue() {
		String code = "for (int i = 0; i < 4; ++i) { if (test(i)) {a *= i; b = call(a); continue;} a -= i;}";
		StructureStyler styler = doStyler(code, "java", Stage.EXTRACT);
		for (StyleRule rule : styler.getStyle().getRules()) {
			if (rule.getStyleContext() instanceof StructPreferenceContext context
					&& context.getStructID() == 23) {
				System.out.printf("Test %s:%s...", context.getStructID(), 0);
				assertEquals(0, ((StructPreferenceProperty) rule.getStyleProperty()).getPreferenceIndex());
				System.out.println("OK!");
			}
		}

		code = "for (int i = 0; i < 4; ++i) { if (test(i)) {a *= i;} else {a -= i;b += a;}}";
		styler = doStyler(code, "java", Stage.EXTRACT);
		for (StyleRule rule : styler.getStyle().getRules()) {
			if (rule.getStyleContext() instanceof StructPreferenceContext context
					&& context.getStructID() == 23) {
				System.out.printf("Test %s:%s...", context.getStructID(), 2);
				assertEquals(2, ((StructPreferenceProperty) rule.getStyleProperty()).getPreferenceIndex());
				System.out.println("OK!");
			}
		}
	}

	@Test
	void extractStyle_redudantCode() {
		String code = "for (int i = 0; i < 4; ++i) { if (test(i)) {a *= i;b += a;} else {a -= i;b += a;}}";
		StructureStyler styler = doStyler(code, "java", Stage.EXTRACT);
		for (StyleRule rule : styler.getStyle().getRules()) {
			if (rule.getStyleContext() instanceof StructPreferenceContext context
					&& context.getStructID() == 25) {
				System.out.printf("Test %s:%s...", context.getStructID(), 1);
				assertEquals(1, ((StructPreferenceProperty) rule.getStyleProperty()).getPreferenceIndex());
				System.out.println("OK!");
			}
		}

	}


	private StructureStyler doStyler(String code, String language, Stage stage) {
		StructureStyler styler = new StructureStyler();
		MyParser parser = MyParserFactory.createParser("java");
		ParseTree root = parser.parseFromString(code);
		parser.walkTree(stage, List.of(styler));
		return styler;
	}
}