package org.example.stylekit;

import java.io.File;
import java.nio.file.Files;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.List;

import org.apache.commons.io.FileUtils;
import static org.assertj.core.api.Assertions.assertThat;
import org.example.MyEnvironment;
import org.example.styler.arrangement.modifier.ModifierOrderStyler;
import org.example.styler.declaration.layout.DeclarationLayoutStyler;
import org.example.styler.format.newline.NewlineStyler;
import org.example.styler.format.space.SpaceStyler;
import org.example.styler.ifelse.bodyorder.IfElseBodyOrderStyler;
import org.example.styler.naming.format.NamingStyler;
import org.example.styler.optionalbrace.OptionalBraceStyler;
import org.example.styler.structure.StructureStyler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TestCoordinatorAnalyzeJava {
	private static final String LANG = "java";
	private static final String SOURCES = "src/test/sources";
	private static final boolean UPDATE_GOLDENS = false;

	private Coordinator coordinatorUnderTest;

	@BeforeEach
	void setUp() {
		coordinatorUnderTest = new Coordinator();
	}

	@Test
	void testAnalyzeInconsistency_modifierOrder() {
		final String dir = Paths.get(SOURCES, "arrangement", "modifier").toString();
		String[] srcFiles = {"f1.java", "f1-gt.java"};
		String[] targetFiles = {"style1.xml", "style1.xml"};
		doAnalyze(dir, srcFiles, targetFiles, List.of(ModifierOrderStyler.class));
	}

	@Test
	void testAnalyzeInconsistency_declarationLayout() {
		final String dir = Paths.get(SOURCES, "declaration").toString();
		String[] srcFiles = {"f1.java", "f3.java", "f1-gt.java", "f3-gt.java"};
		String[] targetFiles = {"f2.java", "f4.java", "f2.java", "f4.java"};
		doAnalyze(dir, srcFiles, targetFiles, List.of(DeclarationLayoutStyler.class));
	}

	@Test
	void testAnalyzeInconsistency_ifElseBodyOrder() {
		final String dir = Paths.get(SOURCES, "if-else").toString();
		String[] srcFiles = {"f1.java", "f2.java", "f1-gt.java", "f2-gt.java"};
		String[] targetFiles = {"f2.java", "f1.java", "f2.java", "f1.java"};
		doAnalyze(dir, srcFiles, targetFiles, List.of(IfElseBodyOrderStyler.class));
	}

	@Test
	void testAnalyzeInconsistency_naming() {
		final String dir = Paths.get(SOURCES, "naming").toString();
		String[] srcFiles = {"f1.java", "f2.java", "f1-gt.java", "f2-gt.java"};
		String[] targetFiles = {"f2.java", "f1.java", "f2.java", "f1.java"};
		doAnalyze(dir, srcFiles, targetFiles, List.of(NamingStyler.class));
	}

	@Test
	void testAnalyzeInconsistency_optionalBrace() {
		final String dir = Paths.get(SOURCES, "optional_brace").toString();
		String[] srcFiles = {"f2.java", "f2-gt.java", "f5.java", "f5-gt.java"};
		String[] targetFiles = {"f1.java", "f1.java", "style1.java", "style1.java"};
		doAnalyze(dir, srcFiles, targetFiles, List.of(OptionalBraceStyler.class));
	}

	@Test
	void testAnalyzeInconsistency_structurePreference_redundantCode() {
		List<Class<?>> enabled = List.of(StructureStyler.class);
		final String dir = Paths.get(SOURCES, "structure", "redundant_code").toString();
		String[] srcFiles = {"f1.java", "f2.java", "f2-gt.java"};
		String[] targetFiles = {"f2.java", "f3.java", "f2.java"};
		doAnalyze(dir, srcFiles, targetFiles, enabled);
	}

	@Test
	void testAnalyzeInconsistency_structurePreference_continuePreference() {
		List<Class<?>> enabled = List.of(StructureStyler.class);
		final String dir = Paths.get(SOURCES, "structure", "continue").toString();
		String[] srcFiles = {"f2.java", "f2-gt.java", "f4.java", "f4-gt.java"};
		String[] targetFiles = {"style2.xml", "f2.java", "style4.xml", "f4.java"};
		doAnalyze(dir, srcFiles, targetFiles, enabled);
	}

	@Test
	void testAnalyzeInconsistency_structurePreference_checkThenAssign() {
		List<Class<?>> enabled = List.of(StructureStyler.class);
		final String dir = Paths.get(SOURCES, "structure", "check_then_assign").toString();
		String[] srcFiles = {"f1.java", "f1-gt.java", "f2.java", "f2-gt.java"};
		String[] targetFiles = {"style1.xml", "f1.java", "style2.xml", "f2.java"};
		doAnalyze(dir, srcFiles, targetFiles, enabled);
	}

	@Test
	void testAnalyzeInconsistency_structurePreference_if() {
		List<Class<?>> enabled = List.of(StructureStyler.class);
		final String dir = Paths.get(SOURCES, "structure", "if").toString();
		String[] srcFiles = {"f1.java", "f1-gt.java", "f3.java", "f3-gt.java"};
		String[] targetFiles = {"style1.xml", "f1.java", "style2.xml", "f3.java"};
		doAnalyze(dir, srcFiles, targetFiles, enabled);
	}

	@Test
	void testAnalyzeInconsistency_structurePreference_loop() {
		List<Class<?>> enabled = List.of(StructureStyler.class);
		final String dir = Paths.get(SOURCES, "structure", "loop").toString();
		String[] srcFiles = {"f1.java", "f1-gt.java", "f3.java", "f3-gt.java"};
		String[] targetFiles = {"style1.xml", "f1.java", "style3.xml", "f3.java"};
		doAnalyze(dir, srcFiles, targetFiles, enabled);
	}

	@Test
	void testAnalyzeInconsistency_newline() {
		final String dir = Paths.get(SOURCES, "format", "newline").toString();
		String[] srcFiles = {"f1.java", };
		String[] targetFiles = {"f2.java",};

		doAnalyze(dir, srcFiles, targetFiles, List.of(NewlineStyler.class));
	}

	@Test
	void testAnalyzeInconsistency_space() {
		final String dir = Paths.get(SOURCES, "format", "space").toString();
		String[] srcFiles = {"f1.java", };
		String[] targetFiles = {"f2.java",};
		doAnalyze(dir, srcFiles, targetFiles, List.of(SpaceStyler.class));
	}


	TaskOptions createTaskOptions(String dir, String srcFile, String targetFile) {
		TaskOptions taskOptions = new TaskOptions();
		taskOptions.setSrc(Paths.get(dir, srcFile).toString());
		taskOptions.setTarget(Paths.get(dir, targetFile).toString());
		taskOptions.setResOutPath(taskOptions.getSrc().replace("."+LANG, "-inc.txt"));
		taskOptions.setLanguage(LANG);
		return taskOptions;
	}

	void doAnalyze(String dir, String[] srcFiles, String[] targetFiles, List<Class<?>> enabledClass) {
		MyEnvironment.getProjectConfig().setEnabledStylers(LANG, enabledClass);
		for (int i = 0; i < srcFiles.length; i++) {
			TaskOptions taskOptions = createTaskOptions(dir, srcFiles[i], targetFiles[i]);
			File gtFile = new File(taskOptions.getResOutPath());
			String tmpPath = Paths.get(taskOptions.getSrc().replace("."+LANG, "-inc-tmp.txt")).toString();
			if (!gtFile.exists()) {
				coordinatorUnderTest.analyzeInconsistency(taskOptions);
			} else {
				taskOptions.setResOutPath(tmpPath);
				coordinatorUnderTest.analyzeInconsistency(taskOptions);
			}

			// 读取两个文件内容并比较
			try {
				String result = FileUtils.readFileToString(new File(tmpPath), "UTF-8");
				String expectedResult = FileUtils.readFileToString(gtFile, "UTF-8");
				assertThat(result).isEqualTo(expectedResult);
				FileUtils.deleteQuietly(new File(tmpPath));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
