package org.example.analysis;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.style.ProgramStyle;
import org.example.style.Style;
import org.example.utils.FileCollection;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExecuteLogger {

	static boolean DEBUG = true;
	private static Map<String, AnalysisResult> results  = new HashMap<>();

	static void setCoveredStyleTypes(ProgramStyle programStyle, String filepath, FileCollection targetCollection) {
		if (!DEBUG) {
			return;
		}
		String fileId = Paths.get(filepath).getFileName().toString().replace(".java", "");
		AnalysisResult result = results.computeIfAbsent(fileId, k -> new AnalysisResult(filepath, targetCollection));

		for (Style style : programStyle.getStyles()) {
			if (style.getRules().size() > 1) {
				result.coveredTargetStyleTypes.add(style.getStyleName());
			}
		}
	}

	static void addOperation(Style style, String filepath, FileCollection targetCollection) {
		if (!DEBUG) {
			return;
		}

		String fileId = Paths.get(filepath).getFileName().toString().replace(".java", "");
		AnalysisResult result = results.computeIfAbsent(fileId, k -> new AnalysisResult(filepath, targetCollection));
		String styleName = style.getStyleName();
		result.operationStat.put(styleName, result.operationStat.getOrDefault(styleName, 0) + 1);
	}

	static void log() {
		if (!DEBUG) {
			return;
		}

		String outputPath = "../tmp-data/execution-log/log.jsonl";  // 注意：你原来写的是 .josnl，已修正为 .jsonl
		ObjectMapper mapper = new ObjectMapper();
		try {
			Files.createDirectories(Paths.get(outputPath).getParent()); // 确保父目录存在
			try (BufferedWriter writer = Files.newBufferedWriter(
					Paths.get(outputPath),
					StandardCharsets.UTF_8,
					StandardOpenOption.CREATE,
					StandardOpenOption.APPEND)) {

				for (AnalysisResult result : results.values()) {
					String json = mapper.writeValueAsString(result);
					writer.write(json);
					writer.newLine();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	static class AnalysisResult implements Serializable {
		public List<String> authorPairs;
		public String fileId;
		public List<String> coveredTargetStyleTypes = new ArrayList<>();
		// 每种风格执行的操作次数
		public Map<String, Integer> operationStat = new HashMap<>();

		public AnalysisResult(String filepath, FileCollection targetCollection) {
			fileId = Paths.get(filepath).getFileName().toString().replace(".java", "");
			String srcAuthor = Paths.get(filepath).getParent().getFileName().toString();
			String targetAuthor = Paths.get(targetCollection.getFilePath(0)).getParent().getFileName().toString();
			authorPairs = List.of(srcAuthor, targetAuthor);
		}
	}



}
