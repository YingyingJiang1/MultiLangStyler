package org.example.styler.structure;

import org.example.TestBase;
import org.junit.jupiter.api.Test;

import java.nio.file.Paths;

public class CPPStructureStylerTest extends TestBase {

	@Test
	void testCpp_inc_id1() {
		int id = 1;
		super.testCppStructureStyle(Paths.get(cppTestCasesDir, "structure", "inc").toString(),
				new String[]{"f1.cpp"},
				// Prefer "$E += 1 ;"
				createStructureStyle(id, 2),
				false
		);
	}

	@Test
	void testCpp_dec_id2() {
		int id = 2;
		super.testCppStructureStyle(Paths.get(cppTestCasesDir, "structure", "dec").toString(),
				new String[]{"f1.cpp"},
				// Prefer "$E -= 1 ;"
				createStructureStyle(id, 2),
				false
		);
	}

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
	void testCpp_checkThenAssign_id15() {
		int id = 15;
		super.testCppStructureStyle(Paths.get(cppTestCasesDir, "structure", "check-then-assign2").toString(),
				new String[]{"f1.cpp"},
				// Prefer ternary form: "$E = $E1 ? $E2 : $E3 ;"
				createStructureStyle(id, 1),
				false
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
	void testCpp_cascadingIf_id5() {
		int id = 5;
		super.testCppStructureStyle(Paths.get(cppTestCasesDir, "structure", "cascading-if").toString(),
				new String[]{"f1.cpp"},
				// Prefer cascading-if form
				createStructureStyle(id, 1),
				false
		);
	}

	@Test
	void testCpp_loopEmpty_id6() {
		int id = 6;
		super.testCppStructureStyle(Paths.get(cppTestCasesDir, "structure", "loop-empty").toString(),
				new String[]{"f1.cpp"},
				// Prefer while(true) form
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
	void testCpp_loopVarDeclHoist_id9() {
		int id = 9;
		super.testCppStructureStyle(Paths.get(cppTestCasesDir, "structure", "loop3").toString(),
				new String[]{"f1.cpp"},
				// Prefer hoisted var-decl form
				createStructureStyle(id, 1),
				false
		);
	}

	@Test
	void testCpp_loopVarDeclUpdate_id12() {
		int id = 12;
		super.testCppStructureStyle(Paths.get(cppTestCasesDir, "structure", "loop6").toString(),
				new String[]{"f1.cpp"},
				// Prefer hoisted var-decl form
				createStructureStyle(id, 1),
				false
		);
	}

	@Test
	void testCpp_checkThenReturn_id13() {
		int id = 13;
		super.testCppStructureStyle(Paths.get(cppTestCasesDir, "structure", "check-then-return").toString(),
				new String[]{"f1.cpp"},
				// Prefer if-else return form
				createStructureStyle(id, 1),
				false
		);
	}

	@Test
	void testCpp_opNotFalse_id18() {
		int id = 18;
		super.testCppStructureStyle(Paths.get(cppTestCasesDir, "structure", "op-not-false").toString(),
				new String[]{"f1.cpp"},
				// Prefer "! $E" form
				createStructureStyle(id, 1),
				false
		);
	}

	@Test
	void testCpp_literalPosition_id19() {
		int id = 19;
		super.testCppStructureStyle(Paths.get(cppTestCasesDir, "structure", "literal-position").toString(),
				new String[]{"f1.cpp"},
				// Prefer "$E == $LITERAL" form
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

	@Test
	void testCpp_continuePreference2_id23() {
		int id = 23;
		super.testCppStructureStyle(Paths.get(cppTestCasesDir, "structure", "continue2").toString(),
				new String[]{"f1.cpp"},
				// Prefer "if ( E ) { $S+ } else { $S1+ }" form (no continue)
				createStructureStyle(id, 2),
				false
		);
	}

	@Test
	void testCpp_redundantCode_id24() {
		int id = 24;
		super.testCppStructureStyle(Paths.get(cppTestCasesDir, "structure", "redundant1").toString(),
				new String[]{"f1.cpp"},
				createStructureStyle(id, 1),
				false
		);
	}

	@Test
	void testCpp_redundantCode_id25() {
		int id = 25;
		super.testCppStructureStyle(Paths.get(cppTestCasesDir, "structure", "redundant2").toString(),
				new String[]{"f1.cpp"},
				createStructureStyle(id, 1),
				false
		);
	}
}
