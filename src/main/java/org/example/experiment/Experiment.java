package org.example.experiment;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import kotlinx.serialization.json.Json;
import org.antlr.v4.runtime.*;
import org.apache.commons.lang3.StringUtils;
import org.example.Configuration;
import org.example.Controller;
import org.example.antlr.JavaLexer;
import org.example.antlr.JavaParser;
import org.example.styler.FileCollector;


import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.*;
import java.util.regex.Pattern;

/*
 * @description
 * @author       Yingying Jiang
 * @create       2024/4/22 21:07
 */
public class Experiment {
	public static final List<InputPair> inputPairs = new ArrayList<>();
	private static List<String> applyResults = new ArrayList<>();

//	public static void removeStyleConflict() {
//		for(InputPair inputPair : inputPairs) {
//			if(inputPair.getPairSize() == 100) {
//				Configuration conf = new Configuration();
//				conf.extractionPaths = constructFullPaths(inputPair.getTargetDataset(), inputPair.getRounds().get(0).targets);
//				conf.applicationPaths = conf.extractionPaths;
//				conf.applyResultSaveDir = inputPair.getTargetDataset();
//				Controller.execute(conf);
//
//				conf.extractionPaths = constructFullPaths(inputPair.getSourceDataset(),inputPair.getRounds().get(0).sources);
//				conf.applicationPaths = conf.extractionPaths;
//				conf.applyResultSaveDir = inputPair.getSourceDataset();
//				Controller.execute(conf);
//			}
//		}
//	}

	public static void execute() throws IOException {
		Configuration conf = new Configuration();
		for (InputPair inputPair : inputPairs) {
			int count = 0;
			String pairName = getPairName(inputPair);

			File dir = new File(inputPair.getResultBaseDir());
			if(!dir.exists()) {
				dir.mkdir();
			}
			dir = new File(dir + File.separator + inputPair.pairSize);
			if (!dir.exists()) {
				dir.mkdir();
			}

			StringBuilder failedMessages = new StringBuilder();
			for (int i = 0; i < inputPair.getRounds().size(); i++) {
				applyResults = new ArrayList<>();

				conf.applyResultSaveDir =
						inputPair.getResultBaseDir() + File.separator + inputPair.pairSize + File.separator + "group" + (i + 1);
				dir = new File(conf.applyResultSaveDir);
				if(!dir.exists()) {
					dir.mkdir();
				}

				if (inputPair.getRounds().isEmpty()) {
					continue;
				}
				conf.extractionCollection = FileCollector.getJavaFileCollection(
						inputPair.getTargetDataset(), Arrays.stream(inputPair.getRounds().get(i).targets).toList());
				conf.applicationCollection = FileCollector.getJavaFileCollection(
						inputPair.getSourceDataset(), Arrays.stream(inputPair.getRounds().get(i).sources).toList());
				Controller.execute(conf);
				inputPair.getRounds().get(i).results = applyResults.toArray(new String[0]);
				if (applyResults.size() != inputPair.getRounds().get(i).sources.length) {
					Set<String> resultsSet = new HashSet<>(applyResults);
					Set<String> sourcesSet = new HashSet<>(Arrays.asList(inputPair.getRounds().get(i).sources));
					String errName = sourcesSet.stream().distinct().toList().get(0);
					System.err.println("error file:" + inputPair.getSourceDataset() + File.separator + errName);

					failedMessages.append("the " + (i + 1) + " group failed!" + System.lineSeparator());
					inputPair.getRounds().get(i).results = new String[0];
				} else {
					++count;
				}
			}

			if (count != inputPair.roundsSize) {
				StringBuilder message = new StringBuilder();
				message.append("-------------------------------------------------------------" + System.lineSeparator());
				message.append("execute pair:" + pairName + System.lineSeparator());
				message.append(failedMessages.toString());
				message.append("successful groups:" + count + System.lineSeparator());
				message.append("failed groups:" + (inputPair.roundsSize - count) + System.lineSeparator());
				message.append("-------------------------------------------------------------" + System.lineSeparator());
				try(BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("failures.txt", true),
						StandardCharsets.UTF_8))) {
					writer.write(message.toString());
				}
				System.out.println("-------------------------------------------------------------");
				System.out.println("execute pair:" + pairName);
				System.out.println("successful groups:" + count);
				System.out.println("failed groups:" + (inputPair.roundsSize - count));
				System.out.println("-------------------------------------------------------------");
			}
		}
	}

	private static String getPairName(InputPair inputPair) {
		String source = new File(inputPair.getSourceDataset()).getName();
		String target = new File(inputPair.getTargetDataset()).getName();
		source = source.replace("leetcode_", "");
		source = source.replace("project_", "");
		target = target.replace("leetcode_", "");
		target = target.replace("project_", "");
		return source + "-" + target;
	}

	private static List<String> constructFullPaths(String dir, String[] names) {
		List<String> fullPaths = new ArrayList<>();
		for (String name : names) {
			fullPaths.add(dir + File.separator + name);
		}
		return fullPaths;
	}

	public static void addApplyResult(String fileName) {
		applyResults.add(fileName);
	}

	public static void modifyLeetcodeTopClass() throws IOException {
		String[] dirs = {
				"D:\\user\\pity\\notes\\毕设\\dataset\\leetcode_AnasImloul",
//		"D:\\user\\pity\\notes\\毕设\\dataset\\leetcode_chatGPT",
		"D:\\user\\pity\\notes\\毕设\\dataset\\leetcode_varunu28",
		// "D:\\user\\pity\\notes\\毕设\\dataset\\leetcode_gouthamvidyapradhan",
//				"D:\\user\\pity\\notes\\毕设\\dataset\\leetcode_SouthWind9984",
		};
		for(String directoryPath : dirs){
			System.out.println(directoryPath);
			File directory = new File(directoryPath);
			File[] files = directory.listFiles();
			

			for (File file : files) {
				if (file.isFile() && file.getName().endsWith(".java")) {
					Lexer lexer = new JavaLexer(CharStreams.fromPath(Paths.get(file.getPath())));
					CommonTokenStream tokenStream = new CommonTokenStream(lexer);
					tokenStream.fill();
					for (int i = 0; i < tokenStream.size(); i++) {
						if(tokenStream.get(i).getText().equals("package")) {
							while (!tokenStream.get(i).getText().equals(";")) {
								((CommonToken)tokenStream.get(i)).setText("");
								++i;
							}
							((CommonToken)tokenStream.get(i)).setText("");
							if(tokenStream.get(i + 1).getType() == JavaLexer.VWS) {
								((CommonToken)tokenStream.get(i + 1)).setText("");
							}
						}
						if(tokenStream.get(i).getText().equals("class")) {
							((CommonToken)tokenStream.get(i + 2)).setText("Solution");
							break;
						}
					}
					String newCode = tokenStream.getText();
					BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file.getPath()), StandardCharsets.UTF_8));
					writer.write(newCode);
					writer.flush();
				}
			}
		}
	}

	public static void preprocessDataset() throws IOException {
		String[] dirs = {
//				"D:\\user\\pity\\notes\\毕设\\dataset\\leetcode_AnasImloul",
//				"D:\\user\\pity\\notes\\毕设\\dataset\\leetcode_chatGPT",
				"D:\\user\\pity\\notes\\毕设\\dataset\\leetcode_CodeWhisperer",
//				"D:\\user\\pity\\notes\\毕设\\dataset\\leetcode_oumanatsumi",
//				"D:\\user\\pity\\notes\\毕设\\dataset\\leetcode_SouthWind9984",
//				"D:\\user\\pity\\notes\\毕设\\dataset\\project_gpt35_代码翻译",
//				"D:\\user\\pity\\notes\\毕设\\dataset\\project_gpt4_代码翻译",
//				"D:\\user\\pity\\notes\\毕设\\dataset\\project_ImCzf233",
//				"D:\\user\\pity\\notes\\毕设\\dataset\\project_HausemasterIssue",
//				"D:\\user\\pity\\notes\\毕设\\dataset\\project_trhacknon",

		};
		int lowerBound = 0, upperBound = 7;
		for (String directoryPath : dirs) {
			File directory = new File(directoryPath);
			File[] files = directory.listFiles();

			for (File file : files) {
				if (file.isFile() && file.getName().endsWith(".java")) {
					long kb = file.length() /  1024;
					if(kb < lowerBound || kb > upperBound) {
						file.delete();
					} else {
						Lexer lexer = new JavaLexer(CharStreams.fromPath(Paths.get(file.getPath())));
						CommonTokenStream tokenStream = new CommonTokenStream(lexer);
						JavaParser parser = new JavaParser(tokenStream);
						parser.compilationUnit();
						if (parser.getNumberOfSyntaxErrors() > 0) {
							file.delete();
						}
					}
				} else {
					file.delete();
				}
			}
		}
	}

	private static void inputCheck() throws IOException {
		for(InputPair inputPair : inputPairs) {
			String pairName = getPairName(inputPair);
			StringBuilder errorMessages = new StringBuilder();
			for (int i = 0; i < inputPair.getRounds().size(); i++) {
				if(inputPair.getPairSize() != inputPair.getRounds().get(i).sources.length) {
					errorMessages.append("wrong size of sources of group " + (i + 1)  + "th");
				}
				if(inputPair.getPairSize() != inputPair.getRounds().get(i).targets.length) {
					errorMessages.append("wrong size of targets of group " + (i + 1)  + "th");
				}
			}
			if(!errorMessages.isEmpty()) {
				System.err.println("pair :" + pairName);
				System.err.println(errorMessages.toString());
			}
		}
	}

	// 删除指定目录下所有行数小于threshold的Java文件
	public static void deleteShortJavaFiles(int threshold) throws IOException {
		String[] dirs = {
				"D:\\user\\pity\\notes\\毕设\\dataset\\leetcode_AnasImloul",
				"D:\\user\\pity\\notes\\毕设\\dataset\\leetcode_chatGPT",
				"D:\\user\\pity\\notes\\毕设\\dataset\\leetcode_CodeWhisperer",

				"D:\\user\\pity\\notes\\毕设\\dataset\\leetcode_varunu28",
//				"D:\\user\\pity\\notes\\毕设\\dataset\\leetcode_SouthWind9984",

		};
		for(String directoryPath : dirs) {
			File directory = new File(directoryPath);
			File[] files = directory.listFiles();
			if (files != null) {
				for (File file : files) {
					if (file.isFile() && file.getName().endsWith(".java")) {
						int lines = countLines(file);
						if (lines < threshold) {
							file.delete();
						}
					}
				}
			}
		}

	}

	public static void datasetInfo() throws IOException {
		String[] dirs = {
				"D:\\user\\pity\\notes\\毕设\\dataset\\leetcode_AnasImloul",
				"D:\\user\\pity\\notes\\毕设\\dataset\\leetcode_chatGPT",
				"D:\\user\\pity\\notes\\毕设\\dataset\\leetcode_CodeWhisperer",
								"D:\\user\\pity\\notes\\毕设\\dataset\\leetcode_varunu28",
		};
		StringBuilder result = new StringBuilder();
		for(String dir : dirs) {
			int maxCount = 0, minCount = Integer.MAX_VALUE;
			long total = 0;
			File[] files = new File(dir).listFiles();
			for (File file : files) {
				if (file.isFile() && file.getName().endsWith(".java")) {
					int lines = countLines(file);
					maxCount = Math.max(maxCount, lines);
					minCount = Math.min(minCount, lines);
					total += lines;
				}
			}
			int avg = (int) (total / files.length);
			result.append(dir).append(": \n")
					.append("max:").append(maxCount).append("\n")
					.append("min:").append(minCount).append("\n")
					.append("avg:").append(avg).append("\n");
		}
		System.out.println(result.toString());
	}

	// 计算文件的行数
	private static int countLines(File file) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(file));
		int lines = 0;
		while (reader.readLine() != null) {
			lines++;
		}
		reader.close();
		return lines;
	}

	public static void renameFiles(String sourceDir, String targetDir) throws IOException {
		// 构建源目录路径和目标目录路径
		File sourceDirectory = new File(sourceDir);
		File targetDirectory = new File(targetDir);

		// 构建源目录文件名集合
		List<String> targetFileNames = new ArrayList<>();
		for (File file : targetDirectory.listFiles()) {
			if (file.isFile()) {
				targetFileNames.add(file.getName().split("\\.")[0]);
			}
		}

		// 遍历目标目录中的所有文件
		for (File file  : sourceDirectory.listFiles()) {
			// 检查是否为文件
			if (file.isFile()) {
				// 获取目标文件的名称（不包括扩展名）
				String fileName = file.getName().substring(0, file.getName().indexOf(".")).toLowerCase().replace(" ", "-");

				// 检查目标文件名是否在源目录中
				for(String targetName : targetFileNames) {
					if(targetName.substring(5).equals(fileName)) {
//						File newFile = new File(targetDir ,targetName + ".java");
						Files.move(file.toPath(), sourceDirectory.toPath().resolve(targetName + ".java"));
//						if(file.renameTo(newFile)) {
//							System.out.println("success!");
//						}
					}
				}
			}
		}
	}

	public static String camelCaseToDashSeparated(String camelCase) {
		StringBuilder result = new StringBuilder();
		String[] strs = StringUtils.splitByCharacterTypeCamelCase(camelCase);
		for(String str : strs) {
			result.append(str.toLowerCase() + "-");
		}
		return result.toString().substring(0,result.length() - 1);
	}

	public static void sort(String jsonFilePath, String dir) throws IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		ArrayNode rootNode = (ArrayNode) objectMapper.readTree(new File(jsonFilePath));
		TreeSet<JsonNode> list = new TreeSet<>(new Comparator<JsonNode>() {
			@Override
			public int compare(JsonNode o1, JsonNode o2) {
				if(o1 == o2) {
					return 0;
				}
				return o1.get("file_name").asText().compareTo(o2.get("file_name").asText());
 			}
		});
		for(JsonNode jsonNode : rootNode) {
			list.add(jsonNode);
		}
		objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(jsonFilePath), list.toArray());
	}

	public static void processJSON(String jsonFilePath, String outputFilePath) {
		try {
			// 创建 ObjectMapper 对象
			ObjectMapper objectMapper = new ObjectMapper();

			// 读取 JSON 文件内容并解析为 JsonNode 对象
			JsonNode rootNode = (ArrayNode) objectMapper.readTree(new File(jsonFilePath));
			List<JsonNode> list = new ArrayList<>();
			for(JsonNode jsonNode : rootNode) {
				String taskDescription = jsonNode.get("task_description").asText();
				taskDescription = taskDescription.replaceAll("(Example|Input|Output|Explanation|Constraints) *[0-9]*.*\n",
						"");
				taskDescription = taskDescription.replaceAll("\\*", "");
				taskDescription = taskDescription.replaceAll("\n{2,}", "");

				ObjectNode newRootNode = objectMapper.createObjectNode();
				newRootNode.put("file_name", jsonNode.get("file_name").asText());
				newRootNode.put("task_description", taskDescription);
				list.add(newRootNode);
			}

			// 写入到新的 JSON 文件
			objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(outputFilePath), list.toArray());
			System.out.println("新的 JSON 文件已生成：" + outputFilePath);

		} catch (IOException e) {
			System.err.println("处理 JSON 文件时出错：" + e.getMessage());
		}
	}

	public static void deleteNonACFile() {
		String[] paths = {
				"D:\\user\\pity\\notes\\毕设\\dataset\\leetcode_AnasImloul",
				"D:\\user\\pity\\notes\\毕设\\dataset\\leetcode_chatGPT",
				"D:\\user\\pity\\notes\\毕设\\dataset\\leetcode_CodeWhisperer",
				"D:\\user\\pity\\notes\\毕设\\dataset\\leetcode_varunu28",
//				"D:\\user\\pity\\notes\\毕设\\dataset\\leetcode_SouthWind9984",

		};
		String[] acInfoFilenames = {
				"D:\\user\\pity\\notes\\毕设\\dataset\\submission_result\\leetcode_AnasImloul.txt",
				"D:\\user\\pity\\notes\\毕设\\dataset\\submission_result\\leetcode_chatGPT.txt",
				"D:\\user\\pity\\notes\\毕设\\dataset\\submission_result\\leetcode_CodeWhisperer.txt",
				"D:\\user\\pity\\notes\\毕设\\dataset\\submission_result\\leetcode_varunu28.txt",
//				"D:\\user\\pity\\notes\\毕设\\dataset\\submission_result\\leetcode_SouthWind9984.txt",
		};
		for (int i = 0; i < paths.length; i++) {
			File dir = new File(paths[i]);
			File[] files = dir.listFiles();
			String acInfoFilename = acInfoFilenames[i];
			Set<String> correctFile = getCorrectFile(acInfoFilename);
			if (files != null) {
				for (File file : files) {
					String name = file.getName().substring(0, file.getName().indexOf("."));
					if(!correctFile.contains(name)) {
						file.delete();
					}
				}
			}
		}
	}

	public static Set<String> getCorrectFile(String filename) {
		Set<String> set = new HashSet<>(); // 创建一个集合存放符合条件的字符串

		try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
			String line;
			while ((line = br.readLine()) != null) {
				// 对每一行进行处理
				if (line.contains(":")) {
					String[] parts = line.split(":"); // 使用":"分割字符串
					if (parts.length == 2) {
						String key = parts[0].trim(); // 去除前后空格
						String value = parts[1].trim();
						if (value.equals("通过") || value.equals("Accepted")) {
							set.add(key); // 如果符合条件，将key加入集合
						}
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return set;
	}

	public static void main(String[] args) throws IOException {
//		deleteShortJavaFiles(20);
//		modifyLeetcodeTopClass();
//		 preprocessDataset();
//		deleteNonACFile();
		//		new LeetcodeInputGenerator().generatePairs("leetcodeInput.json", true);
//		new InputGenerator().generatePairs("projectInput.json", true);
//		new LeetcodeInputGenerator1().generatePairs("leetcodeInput.json", true);
		datasetInfo();

		String[] jsonPaths = {
				"leetcodeInput.json",
//				"projectInput.json",
//				"debugInput.json"
		};

		for(String jsonPath : jsonPaths) {
			inputPairs.addAll(InputReader.readPairs(jsonPath));
		}
//		inputCheck();
//		execute();
//		removeStyleConflict();

//		processJSON("leetcode.json", "leetcode.json");
//		renameFiles("D:\\user\\pity\\notes\\毕设\\dataset\\leetcode_varunu28", "D:\\user\\pity\\notes\\毕设\\dataset\\leetcode_chatGPT");
//		sort("leetcode.json", "leetcode_CodeWhisperer");
//		deleteNonACFile();
	}
}
