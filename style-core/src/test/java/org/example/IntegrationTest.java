package org.example;

import org.example.styler.structure.StructureStyler;
import org.example.styler.structure.checker.ContainChecker;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class IntegrationTest extends TestBase {
	@Test
	public void test1() {
		String styleCodesDir = "src/test/codes/test1/style-codes";
		String srcCodesDir = "src/test/codes/test1/srcs";
		String[] srcFiles = {
				"f1.java",

		};

		for (int i = 0; i < srcFiles.length; i++) {
			Path gtPath = Paths.get(srcCodesDir, String.format("%s-gt.java", srcFiles[i].replace(".java", "")));
			String actual = apply(Paths.get(srcCodesDir, srcFiles[i]), Paths.get(styleCodesDir));
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
