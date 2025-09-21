package org.example.styler.body.optionalbrace;

import org.example.TestBase;
import org.example.styler.format.indention.IndentionStyler;
import org.example.styler.format.newline.NewlineStyler;
import org.example.styler.format.newline.bodylayout.BodyLayoutStyler;
import org.example.styler.format.newline.inter.InterNewlineStyler;
import org.example.styler.format.newline.intra.IntraNewlineStyler;
import org.example.styler.format.space.SpaceStyler;
import org.example.styler.optionalbrace.OptionalBraceStyler;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

class OptionalBraceStylerTest extends TestBase {

	@Test
	void test() {
		String dir = "src/test/sources/optional_brace";
		String[] srcFiles = {
				"f1.java",
				"f2.java",
				"f3.java",
				"f4.java",
				"f5.java"
		};

		String[] targetFiles = {
				"f2.java",
				"f1.java",
				"f4.java",
				"f3.java",
				"style1.java",
		};

		for (int i = 0; i < srcFiles.length; i++) {
			Path gtPath = Paths.get(dir, String.format("%s-gt.java", srcFiles[i].replace(".java", "")));
			String actual = apply(Paths.get(dir, srcFiles[i]), Paths.get(dir, targetFiles[i]), List.of(
					OptionalBraceStyler.class,
					IndentionStyler.class,
					InterNewlineStyler.class,
					NewlineStyler.class,
					BodyLayoutStyler.class,
					IntraNewlineStyler.class));
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