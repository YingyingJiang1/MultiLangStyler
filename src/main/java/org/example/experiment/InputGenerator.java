package org.example.analysis.input;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InputGenerator {
	/**
	 * 读取json文件，生成一个Pair数组，在将生成的Pair数组写入json文件
	 *
	 * @param jsonPath 要读取的JSON文件的路径
	 * @return 生成的Pair数组
	 * @throws IOException 如果读取或写入JSON文件时发生错误
	 */
	public List<InputPair> generatePairs(String jsonPath, boolean write) throws IOException {
		List<InputPair> inputPairs = new ArrayList<>();
		ObjectMapper mapper = new ObjectMapper();
		File file = new File(jsonPath);
		if (!file.exists()) {
			throw new IOException("File not found: " + jsonPath);
		}
		// 读取JSON文件
		ArrayNode arrayNode = (ArrayNode) mapper.readTree(file);
		for (int i = 0; i < arrayNode.size(); i++) {
			inputPairs.add(generatePair(arrayNode.get(i)));
		}
		// 将生成的Pair写入JSON文件（可选）
		if (write) {
			mapper.writerWithDefaultPrettyPrinter().writeValue(
					new BufferedWriter(new OutputStreamWriter(new FileOutputStream(jsonPath), StandardCharsets.UTF_8)),
					inputPairs.toArray());
		}
		return inputPairs;
	}

	/**
	 * 按照json格式输出Pair对象
	 *
	 * @param jsonNode 包含Pair信息的JSON节点
	 * @return 生成的Pair对象
	 */
	public InputPair generatePair(JsonNode jsonNode) {
		int pairSize = jsonNode.get("pairSize").asInt();
		int roundSize = jsonNode.get("roundsSize").asInt();
		String sourceDataset = jsonNode.get("sourceDataset").asText();
		String targetDataset = jsonNode.get("targetDataset").asText();
		String resultBaseDir = jsonNode.get("resultBaseDir").asText();
		String experimentResult = jsonNode.get("experimentResult").asText();
		List<InputPair.Round> rounds = new ArrayList<>();
		for (int i = 0; i < roundSize; i++) {
			InputPair.Round round = generateRound(sourceDataset, targetDataset, pairSize);
			if (round == null || round.sources.length != round.targets.length || round.sources.length != pairSize) {
				System.err.println("Fail to construct the " + i + " round of input pair:("
						+ sourceDataset + "," + targetDataset + ") with pair size of " + pairSize + ".");
				continue;
			}
			rounds.add(round);
		}
		if (rounds.size() != roundSize) {
			System.err.println("Fail to construct the input pair:("
					+ sourceDataset + "," + targetDataset + ") with pair size of " + pairSize + ".");
		}
		return new InputPair(pairSize, roundSize, sourceDataset, targetDataset, resultBaseDir, rounds, experimentResult);
	}

	protected InputPair.Round generateRound(String sourceDataset, String targetDataset, int pairSize) {
		InputPair.Round round = new InputPair.Round();
		List<String> sourceFiles = getRandomFiles(sourceDataset, pairSize);
		List<String> targetFiles = getRandomFiles(targetDataset, pairSize);
		round.sources = sourceFiles.toArray(new String[0]);
		round.targets = targetFiles.toArray(new String[0]);
		round.results = new String[0];
		return round;
	}

	private List<String> getRandomFiles(String dataset, int pairSize) {
		List<String> fileList = getFileList(dataset);
		Collections.shuffle(fileList);
		return fileList.subList(0, Math.min(pairSize, fileList.size()));
	}

	protected List<String> getFileList(String dataset) {
		File folder = new File(dataset);
		if (!folder.exists() || !folder.isDirectory()) {
			throw new IllegalArgumentException("Invalid dataset folder: " + dataset);
		}
		File[] files = folder.listFiles();
		if (files == null) {
			throw new IllegalArgumentException("Failed to list files in folder: " + dataset);
		}
		List<String> fileList = new ArrayList<>();
		for (File file : files) {
			if (file.isFile()) {
				fileList.add(file.getName());
			}
		}
		return fileList;
	}
}
