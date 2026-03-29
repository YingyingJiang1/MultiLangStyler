package org.example.styler.format.space;

import org.example.TestBase;
import org.example.styler.format.indention.IndentionStyler;
import org.example.styler.format.newline.NewlineStyler;
import org.junit.jupiter.api.Test;
import org.opentest4j.AssertionFailedError;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SpaceStylerTest extends TestBase {

	@Test
	void analyzeInconsistency_matchesGolden() {
		String dir = Paths.get(javaTestCasesDir, "format", "space").toString();
		assertAnalyzeInconsistencyMatchesGolden(dir,
				new String[] {"f1.java", "f1-gt.java", "f2.java", "f2-gt.java"},
				new String[] {"f2.java", "f2.java", "f1.java", "f1.java"},
				List.of(SpaceStyler.class));
	}

	@Test
	void applyStyle() {
		String dir = Paths.get(javaTestCasesDir, "format", "space").toString();
		String[] srcFiles = {
				"f1.java",
				"f2.java",
		};

		String[] targetFiles = {
				"f2.java",
				"f1.java",
		};

		for (int i = 0; i < srcFiles.length; i++) {
			Path gtPath = Paths.get(dir, String.format("%s-gt.java", i + 1));
			String actual = apply(Paths.get(dir, srcFiles[i]), Paths.get(dir, targetFiles[i]), "java", List.of(SpaceStyler.class));
			if (false) {
				try{
					Files.writeString(gtPath, actual);
				}	catch (Exception e) {
					e.printStackTrace();
				}
			}

			try {
				testCodeEqual(actual, gtPath);
			} catch (AssertionFailedError e) {
				System.out.printf("Pair %d test failed%n", i + 1);
			}
//			break;
		}
	}

	@Test
	void applyStyleCpp() {
		String fileExt = ".cpp";
		String dir = Paths.get(cppTestCasesDir, "space").toString();
		String[] srcFiles = {
//				"f1" + fileExt,
//				"f2" + fileExt,
				"f3" + fileExt,
//				"f4" + fileExt
		};

		String[] targetFiles = {
//				"f2" + fileExt,
//				"f1" + fileExt,
				"f4" + fileExt,
//				"f3" + fileExt
		};

		for (int i = 0; i < srcFiles.length; i++) {
			Path gtPath = Paths.get(dir, String.format("%s-gt" + fileExt, srcFiles[i].replace(fileExt, "")));
			String actual = apply(Paths.get(dir, srcFiles[i]), Paths.get(dir, targetFiles[i]), "cpp", List.of(SpaceStyler.class));
			if (false) {
				try{
					Files.writeString(gtPath, actual);
				}	catch (Exception e) {
					e.printStackTrace();
				}
			}

			try {
				testCodeEqual(actual, gtPath);
			} catch (AssertionFailedError e) {
				logger.error("Pair `{}` test failed%n", i + 1, e);
			}
//			break;
		}
	}


	@Test
	void applyStylePython() {
		String fileExt = ".py";
		String language = "python";
		String dir = "src/test/python-sources/space/";
		String[] srcFiles = {
				"f1" + fileExt,
				"f2" + fileExt,
//				"f3" + fileExt,
//				"f4" + fileExt
		};

		String[] targetFiles = {
				"f2" + fileExt,
				"f1" + fileExt,
//				"f4" + fileExt,
//				"f3" + fileExt
		};

		for (int i = 0; i < srcFiles.length; i++) {
			Path gtPath = Paths.get(dir, String.format("%sto%sgt" + fileExt, srcFiles[i].replace(fileExt, ""), targetFiles[i].replace(fileExt, "")));
			String actual = apply(Paths.get(dir, srcFiles[i]), Paths.get(dir, targetFiles[i]), language, List.of(SpaceStyler.class));
			if (false) {
				try{
					Files.writeString(gtPath, actual);
				}	catch (Exception e) {
					e.printStackTrace();
				}
			}

			try {
				testCodeEqual(actual, gtPath);
			} catch (AssertionFailedError e) {
				logger.error("Pair `{}` test failed%n", i + 1, e);
			}
//			break;
		}
	}
}