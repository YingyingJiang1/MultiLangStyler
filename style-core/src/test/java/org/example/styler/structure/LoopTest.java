package org.example.styler.structure;

import org.example.TestBase;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class LoopTest extends TestBase {
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


}
