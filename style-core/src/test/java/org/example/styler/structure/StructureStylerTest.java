package org.example.styler.structure;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.antlr.v4.runtime.tree.ParseTree;
import org.example.TestBase;
import org.example.antlr.common.context.ExtendContext;
import org.example.lang.LangAdapterCreator;
import org.example.lang.intf.MyParser;
import org.example.style.rule.StyleRule;
import org.example.styler.structure.style.StructPreferenceContext;
import org.example.styler.structure.style.StructPreferenceProperty;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class StructureStylerTest extends TestBase {
	/********************************************************** Note!!!  **********************************************************/
	// 配置文件中结构id会影响使用风格文件作为目标风格的测试用例，不要变更结构id
	/**********************************************************   **********************************************************/

	private static final Logger log = LoggerFactory.getLogger(StructureStylerTest.class);

	@Test
	void extractStyle_assignment() {
		StructureStyler styler = new StructureStyler();

		String code = "a = a + 3;";
		MyParser parser = LangAdapterCreator.createParser("java");
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
				"f7.java",
		};
		String[] targetFiles = {
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
		}
	}

	@Test
	void testLoop() {
		StructureStyler.TEST_MODE = true;
		String dir = "src/test/sources/structure/loop/";
		String[] srcFiles = {
				"f1.java", // 0
				"f2.java",
				"f3.java",
				"f4.java",
				"f5.java", // 4
				"f6.java",
				"f7.java",
				"f8.java",
				"f9.java",
				"f10.java"

		};

		String[] targetFiles = {
				"style1.xml", // 0
				"style2.xml",
				"style3.xml",
				"style4.xml",
				"style4.xml", // 4
				"style5.xml",
				"style4.xml",
				"style6.xml",
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

	@Test
	void testApplyStyle_continuePreference() {
		StructureStyler.TEST_MODE = true;
		String dir = "src/test/sources/structure/continue/";
		String[] srcFiles = {
				"f2.java",
				"f3.java",
				"f4.java",
				"f5.java",
				"f6.java"

		};
		String[] targetFiles = {
				"style2.xml",
				"style3.xml",
				"style4.xml",
				"style5.xml",
				"style6.xml"
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

	@Test
	void testCheckThenAssign() {
		StructureStyler.TEST_MODE = true;
		String dir = "src/test/sources/structure/check_then_assign/";
		String[] srcFiles = {
				"f1.java",
				"f2.java",
				"f4.java"
		};

		String[] targetFiles = {
				"style1.xml",
				"style2.xml",
				"style4.xml",
		};

		for (int i = 0; i < srcFiles.length; i++) {
			Path gtPath = Paths.get(dir, String.format(srcFiles[i].replace(".java", "-gt.java")));
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

}