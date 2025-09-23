package org.example.styler.format.newline;

import org.example.TestBase;
import org.example.styler.format.indention.IndentionStyler;
import org.example.styler.format.newline.bodylayout.BodyLayoutStyler;
import org.example.styler.format.newline.inter.InterNewlineStyler;
import org.example.styler.format.newline.intra.IntraNewlineStyler;
import org.example.styler.structure.StructureStyler;
import org.junit.jupiter.api.Test;
import org.opentest4j.AssertionFailedError;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
class NewlineStylerTest extends TestBase {

	@Test
	void applyStyle() {
		String dir = "src/test/sources/format/newline/";
		String[] srcFiles = {
				"f1.java",
				"f2.java",
				"f7.java",
				"f8.java",
				"f13.java",
		};
		
		String[] targetFiles = {
				"f2.java",
				"f7.java",
				"f3.java",
				"f1.java",
				"style4.java",
		};

		for (int i = 0; i < srcFiles.length; i++) {
			Path gtPath = Paths.get(dir, String.format("%s-gt.java", srcFiles[i].replace(".java", "")));
			String actual = apply(Paths.get(dir, srcFiles[i]), Paths.get(dir, targetFiles[i]), List.of(
					NewlineStyler.class,
					IntraNewlineStyler.class,
					InterNewlineStyler.class,
					BodyLayoutStyler.class,
					IndentionStyler.class));
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

	@Test
	void testLineWrapping() {
		String dir = "src/test/sources/format/newline/";
		String[] srcFiles = {
				"f6.java",

		};

		String[] targetFiles = {
				"f5.java",

		};

		for (int i = 0; i < srcFiles.length; i++) {
			Path gtPath = Paths.get(dir, String.format("%s-gt.java", srcFiles[i].replace(".java", "")));
			String actual = apply(Paths.get(dir, srcFiles[i]), Paths.get(dir, targetFiles[i]), List.of(
					NewlineStyler.class,
					IntraNewlineStyler.class,
					InterNewlineStyler.class,
					BodyLayoutStyler.class,
					IndentionStyler.class));
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

	@Test
	void testCombination() {
		String dir = "src/test/sources/combination-test/test1";
		String[] srcFiles = {
				"f1.java",
				"f2.java",
				"f5.java",
				"f3.java",
				"f6.java",
		};

		String[] targetFiles = {
				"style1",
				"style1",
				"style1",
				"style1",
				"style1",
		};

		for (int i = 0; i < srcFiles.length; i++) {
			Path gtPath = Paths.get(dir, String.format("%s-gt.java", srcFiles[i].replace(".java", "")));
			String actual = apply(Paths.get(dir, srcFiles[i]), Paths.get(dir, targetFiles[i]), List.of(
					NewlineStyler.class,
					IntraNewlineStyler.class,
					InterNewlineStyler.class,
					BodyLayoutStyler.class,
					IndentionStyler.class));
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

	@Test
	void testLambdaExp() {
		String dir = "src/test/sources/format/newline";
		String[] srcFiles = {
				"f9.java",
				"f10.java",
				"f11.java",
				"f12.java"
		};

		String[] targetFiles = {
				"style1.java",
				"style2.java",
				"style3.java",
				"style4.java",
		};

		for (int i = 0; i < srcFiles.length; i++) {
			Path gtPath = Paths.get(dir, String.format("%s-gt.java", srcFiles[i].replace(".java", "")));
			String actual = apply(Paths.get(dir, srcFiles[i]), Paths.get(dir, targetFiles[i]), List.of(
					NewlineStyler.class,
					IntraNewlineStyler.class,
					InterNewlineStyler.class,
					BodyLayoutStyler.class,
					IndentionStyler.class));
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