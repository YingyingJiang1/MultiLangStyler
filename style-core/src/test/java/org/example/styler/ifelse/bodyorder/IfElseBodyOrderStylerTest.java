package org.example.styler.ifelse.bodyorder;

import org.example.TestBase;
import org.example.stylekit.Coordinator;
import org.example.styler.declaration.layout.DeclarationLayoutStyler;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

class IfElseBodyOrderStylerTest extends TestBase {

	@Test
	void testJava() {
	  String dir = "src/test/sources/if-else";
	  String[] srcFiles = {
			  "f1.java",
			  "f2.java",
	  };

	  String[] targetFiles = {
			  "f2.java",
			  "f1.java",
	  };

	  for (int i = 0; i < srcFiles.length; i++) {
		Path gtPath = Paths.get(dir, String.format("%s-gt.java", srcFiles[i].replace(".java", "")));
		String actual = apply(Paths.get(dir, srcFiles[i]), Paths.get(dir, targetFiles[i]), List.of(
				IfElseBodyOrderStyler.class
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
}