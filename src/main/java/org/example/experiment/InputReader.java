package org.example.experiment;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/*
 * @description
 * @author       Yingying Jiang
 * @create       2024/4/23 17:13
 */
public class InputReader {
	public static List<InputPair> readPairs(String jsonPath) throws IOException {
		List<InputPair> inputPairs = new ArrayList<>();
		ObjectMapper mapper = new ObjectMapper();
		File file = new File(jsonPath);
		if (!file.exists()) {
			throw new IOException("File not found: " + jsonPath);
		}
		// 读取JSON文件
		ArrayNode arrayNode = (ArrayNode) mapper.readTree(file);
		for (int i = 0; i < arrayNode.size(); i++) {
			inputPairs.add(readPair(arrayNode.get(i)));
		}
		return inputPairs;
	}

	public static InputPair readPair(JsonNode jsonNode) {
		int pairSize = jsonNode.get("pairSize").asInt();
		int roundSize = jsonNode.get("roundsSize").asInt();
		String sourceDataset = jsonNode.get("sourceDataset").asText();
		String targetDataset = jsonNode.get("targetDataset").asText();
		String resultBaseDir = jsonNode.get("resultBaseDir").asText();
		String experimentResult = jsonNode.get("experimentResult") == null ? null :
				jsonNode.get("experimentResult").asText();
		List<InputPair.Round> rounds = new ArrayList<>();
		JsonNode roundsNode = jsonNode.get("rounds");
		for(JsonNode roundNode : roundsNode) {
			InputPair.Round round = readRound(roundNode);
			rounds.add(round);
		}
		return new InputPair(pairSize, roundSize, sourceDataset, targetDataset, resultBaseDir, rounds, experimentResult);
	}

	protected static InputPair.Round readRound(JsonNode roundNode) {
		ObjectMapper objectMapper = new ObjectMapper();
		InputPair.Round round = new InputPair.Round();
		round.sources = objectMapper.convertValue(roundNode.get("sources"), String[].class);
		round.targets = objectMapper.convertValue(roundNode.get("targets"), String[].class);
		round.results = objectMapper.convertValue(roundNode.get("results"), String[].class);
		return round;
	}

}
