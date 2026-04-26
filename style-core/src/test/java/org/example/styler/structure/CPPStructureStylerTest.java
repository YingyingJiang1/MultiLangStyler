package org.example.styler.structure;

import org.example.TestBase;
import org.junit.jupiter.api.Test;

import java.nio.file.Paths;

public class CPPStructureStylerTest extends TestBase {

	@Test
	void testCpp_checkThenAssign_id14() {
		int id = 14;
		super.testCppStructureStyle(Paths.get(cppTestCasesDir, "structure", "check-then-assign").toString(),
				new String[]{"f1.cpp"},
				createStructureStyle(id, 0),
				true
		);
	}

	@Test
	void testCpp_assignmentOp_id3() {
		int id = 3;
		super.testCppStructureStyle(Paths.get(cppTestCasesDir, "structure", "assignment").toString(),
				new String[]{"f1.cpp"},
				// Prefer "$E $HOMO_BOP_ASSIGN $E2 ;" (e.g., x += y;)
				createStructureStyle(id, 1),
				false
		);
	}

	@Test
	void testCpp_nestingIf_id4() {
		int id = 4;
		super.testCppStructureStyle(Paths.get(cppTestCasesDir, "structure", "if").toString(),
				new String[]{"f1.cpp"},
				// Prefer nested-if form: "if (E) { if (E1) S }"
				createStructureStyle(id, 1),
				false
		);
	}

	@Test
	void testCpp_loopWhile_id7() {
		int id = 7;
		super.testCppStructureStyle(Paths.get(cppTestCasesDir, "structure", "loop").toString(),
				new String[]{"f1.cpp"},
				// Prefer while form: "while ( E ) S"
				createStructureStyle(id, 1),
				false
		);
	}

	@Test
	void testCpp_continuePreference_id22() {
		int id = 22;
		super.testCppStructureStyle(Paths.get(cppTestCasesDir, "structure", "continue").toString(),
				new String[]{"f1.cpp"},
				// Prefer "if ( E ) { $S+ }" form (no continue)
				createStructureStyle(id, 2),
				false
		);
	}
}
