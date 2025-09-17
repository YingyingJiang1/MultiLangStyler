package org.example.styler.structure;

import org.antlr.v4.runtime.tree.ParseTree;
import org.example.TestBase;
import org.example.parser.common.MyParser;
import org.example.parser.common.context.ExtendContext;
import org.example.parser.common.factory.MyParserFactory;
import org.example.style.rule.StyleRule;
import org.example.styler.Stage;
import org.example.styler.Styler;
import org.example.styler.format.indention.IndentionStyler;
import org.example.styler.format.newline.NewlineStyler;
import org.example.styler.structure.style.StructPreferenceContext;
import org.example.styler.structure.style.StructPreferenceProperty;
import org.junit.jupiter.api.Test;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StructureStylerTest extends TestBase {
	/********************************************************** Note!!!  **********************************************************/
	// 配置文件中结构id会影响使用风格文件作为目标风格的测试用例，不要变更结构id
	/**********************************************************   **********************************************************/

	private static final Logger log = LoggerFactory.getLogger(StructureStylerTest.class);

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
	void testRedudantCode() {
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

		String dir = "src/test/sources/structure/redundant_code/";
		String[] srcFiles = {
				"f1.java",
				"f2.java",
				"f3.java",
				"f4.java",
		};

		String[] targetFiles = {
				"f2.java",
				"f3.java",
				"style2.xml",
				"style3.xml",
		};

		for (int i = 0; i < srcFiles.length; i++) {
			Path gtPath = Paths.get(dir, String.format("%s-gt.java", srcFiles[i].replace(".java", "")));
			String actual = apply(Paths.get(dir, srcFiles[i]), Paths.get(dir, targetFiles[i]), List.of(StructureStyler.class));
			if (false) {
				try{
					Files.writeString(gtPath, actual);
				}	catch (Exception e) {
					e.printStackTrace();
				}
			}
			testCodeEqual(actual, gtPath);
		}

	}

	private String doApply(Path srcPath, StructureStyler styler) {
		try {
			MyParser parser = MyParserFactory.createParser("java");
			ParseTree root = parser.parse(srcPath);
			parser.walkTree(Stage.APPLY, List.of(styler));
			if (root instanceof ExtendContext ctx) {
				return getFormattedText(ctx);
			}
			return root.getText();
		} catch (IOException e) {
			log.error("e: ", e);
		}
		return "";
	}


	private StructureStyler doStyler(String code, String language, Stage stage) {
		StructureStyler styler = new StructureStyler();
		MyParser parser = MyParserFactory.createParser("java");
		ParseTree root = parser.parseFromString(code);
		parser.walkTree(stage, List.of(styler));
		return styler;
	}


	@Test
	void testIf() {
		String dir = "src/test/sources/structure/if/";
		String[] srcFiles = {
				"f1.java",
				"f2.java",
				"f3.java",
				"f4.java",
				"f5.java",
				"f6.java",
		};

		String[] targetFiles = {
				"style1.xml",
				"style1.xml",
				"style2.xml",
				"style2.xml",
				"style1.xml",
				"style2.xml",
		};

		for (int i = 0; i < srcFiles.length; i++) {
			Path gtPath = Paths.get(dir, String.format("%s-gt.java", srcFiles[i].replace(".java", "")));
			String actual = apply(Paths.get(dir, srcFiles[i]), Paths.get(dir, targetFiles[i]), List.of(StructureStyler.class));
			if (false) {
				try {
					Files.writeString(gtPath, actual);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}


			testCodeEqual(actual, gtPath);
		}
	}





	@Test
	void testCombination1() {
		String dir = "src/test/sources/combination-test/test1";
		String[] srcFiles = {
//				"f4.java",
				"f7.java",
		};

		String[] targetFiles = {
				"style1",
				"style1",
		};

		for (int i = 0; i < srcFiles.length; i++) {
			Path gtPath = Paths.get(dir, String.format("%s-gt.java", srcFiles[i].replace(".java", "")));
			String actual = apply(Paths.get(dir, srcFiles[i]), Paths.get(dir, targetFiles[i]), List.of(
					StructureStyler.class));
			if (false) {
				try{
					Files.writeString(gtPath, actual);
				}	catch (Exception e) {
					e.printStackTrace();
				}
			}

			testCodeEqual(actual, gtPath);
//			break;
		}
	}



}