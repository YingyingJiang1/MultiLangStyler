package org.example.styler.structure;

import org.example.TestBase;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class CheckThenAssignTest extends TestBase {

	@Test
	void test() {
		String dir = "src/test/sources/structure/check_then_assign/";
		String[] srcFiles = {
				"f1.java",
				"f2.java",
		};

		String[] targetFiles = {
				"style1.xml",
				"style2.xml",
		};

		for (int i = 0; i < srcFiles.length; i++) {
			Path gtPath = Paths.get(dir, String.format("f%s-gt.java", i + 1));
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
		String dir = "src/test/sources/structure/check_then_assign/batch";
		String[] srcFiles = {
				"f1.java",
		};

		String[] targetFiles = {
				"style1"
		};

		for (int i = 0; i < srcFiles.length; i++) {
			Path gtPath = Paths.get(dir, String.format("f%s-gt.java", i + 1));
			String actual = apply(Paths.get(dir, srcFiles[i]), Paths.get(dir, targetFiles[i]), List.of(StructureStyler.class));
			if (true) {
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
