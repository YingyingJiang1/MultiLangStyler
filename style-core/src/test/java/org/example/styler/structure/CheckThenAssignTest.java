package org.example.styler.structure;

import org.example.TestBase;
import org.example.styler.format.indention.IndentionStyler;
import org.example.styler.format.newline.NewlineStyler;
import org.example.styler.format.newline.bodylayout.BodyLayoutStyler;
import org.example.styler.format.newline.inter.InterNewlineStyler;
import org.example.styler.format.newline.intra.IntraNewlineStyler;
import org.example.styler.format.newline.style.NewlineStyle;
import org.example.styler.format.space.SpaceStyler;
import org.junit.jupiter.api.Test;
import org.opentest4j.AssertionFailedError;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class CheckThenAssignTest extends TestBase {

	int id = 14;



	@Test
	void test() {
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

	@Test
	void testBatch() {
		StructureStyler.TEST_MODE = true;
		String dir = "src/test/sources/structure/check_then_assign/batch";
		String[] srcFiles = {
				"f1.java",
		};

		String[] targetFiles = {
				"style1"
		};

		for (int i = 0; i < srcFiles.length; i++) {
			Path gtPath = Paths.get(dir, String.format("f%s-gt.java", i + 1));
			String actual = apply(Paths.get(dir, srcFiles[i]), Paths.get(dir, targetFiles[i]), List.of(StructureStyler.class
//					, NewlineStyler.class, IntraNewlineStyler.class, InterNewlineStyler.class, BodyLayoutStyler.class
//					,IndentionStyler.class
			));
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
	void testCpp() {
		int id = 14;
		super.testCppStructureStyle(Paths.get(cppTestCasesDir, "structure", "check-then-assign").toString(),
				new String[]{"f1.cpp"},
				createStructureStyle(id, 0),
				true
		);
	}
}
