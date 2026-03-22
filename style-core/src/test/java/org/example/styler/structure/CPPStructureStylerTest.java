package org.example.styler.structure;

import org.example.TestBase;
import org.junit.jupiter.api.Test;

import java.nio.file.Paths;

public class CPPStructureStylerTest extends TestBase {

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
