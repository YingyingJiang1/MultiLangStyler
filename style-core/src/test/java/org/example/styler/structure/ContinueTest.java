package org.example.styler.structure;

import org.example.TestBase;
import org.example.style.rule.StyleRule;
import org.example.styler.Stage;
import org.example.styler.format.indention.IndentionStyler;
import org.example.styler.format.newline.NewlineStyler;
import org.example.styler.format.newline.bodylayout.BodyLayoutStyler;
import org.example.styler.format.newline.inter.InterNewlineStyler;
import org.example.styler.format.newline.intra.IntraNewlineStyler;
import org.example.styler.structure.style.StructPreferenceContext;
import org.example.styler.structure.style.StructPreferenceProperty;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ContinueTest extends TestBase {


	@Test
	void testApplyStyle_continuePreference() {
		StructureStyler.TEST_MODE = true;
		String dir = "src/test/sources/structure/continue/";
		String[] srcFiles = {
				"f2.java",
				"f3.java",
				"f4.java",
				"f5.java",

		};

		String[] targetFiles = {
				"style2.xml",
				"style3.xml",
				"style4.xml",
				"style5.xml",
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
