package org.example.analysis.io.input;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import org.example.analysis.io.InputPair;
import org.springframework.boot.jackson.JsonObjectDeserializer;

import java.io.*;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class InputGenerator {
	static String fileSuffix = ".java";

	public static MetaData loadMetaData(String jsonFile) throws IOException {
		// 读取json数据
		try (InputStream inputStream = new FileInputStream(jsonFile)) {
			ObjectMapper objectMapper = new ObjectMapper();
			MetaData metaData = new MetaData(objectMapper.readTree(inputStream));
			return metaData;
		}
	}

	public static List<InputPair> generateHumanPairs(String jsonFile) throws IOException {
		MetaData metaData = loadMetaData(jsonFile);
		List<InputPair> inputPairs = new ArrayList<>();
		for (Solution solution : metaData.getSolutions()) {
			for (int i = 0; i < solution.humanAuthors.length; i++) {
				for (int j = i + 1; j < solution.humanAuthors.length; j++) {
					String[] authors = {solution.humanAuthors[i], solution.humanAuthors[j]};
					String[] files = {solution.getHumanSolutionFile(i), solution.getHumanSolutionFile(j)};
					InputPair inputPair = new InputPair(solution.problemNumber, solution.problemID, authors, files);
					inputPairs.add(inputPair);
				}
			}
		}

		return inputPairs;
	}

	public static List<InputPair> generateLLMPairs(String jsonFile) throws IOException {
		MetaData metaData = loadMetaData(jsonFile);
		List<InputPair> inputPairs = new ArrayList<>();
		for (Solution solution : metaData.getSolutions()) {
			for (int i = 0; i < solution.llmAuthors.length; i++) {
				for (int j = i + 1; j < solution.llmAuthors.length; j++) {
					String[] authors = {solution.llmAuthors[i], solution.llmAuthors[j]};
					String[] files = {solution.getLLMSolutionFile(i), solution.getLLMSolutionFile(j)};
					inputPairs.add(new InputPair(solution.problemNumber, solution.problemID, authors, files));
				}
			}
		}
		return inputPairs;
	}

	public static List<InputPair> generateHumanLLMPairs(String jsonFile) throws IOException {
		MetaData metaData = loadMetaData(jsonFile);
		List<InputPair> inputPairs = new ArrayList<>();
		for (Solution solution : metaData.getSolutions()) {
			for (int i = 0; i < solution.llmAuthors.length; i++) {
				for (int j = 0; j < solution.humanAuthors.length; j++) {
					String[] authors = {solution.llmAuthors[i], solution.humanAuthors[j]} ;
					String[] files = {solution.getLLMSolutionFile(i), solution.getHumanSolutionFile(j)};
					inputPairs.add(new InputPair(solution.problemNumber, solution.problemID, authors, files));
				}
			}
		}
		return inputPairs;
	}

	static class MetaData{
		JsonNode jsonNode;

		public MetaData(JsonNode jsonNode) {
			this.jsonNode = jsonNode;
		}

		public List<Solution> getSolutions() throws JsonProcessingException {
			List<Solution> solutions = new ArrayList<>();
//			solutions.addAll(getSolutions(jsonNode.get("codereval").get("problems")));
			solutions.addAll(getSolutions(jsonNode.get("leetcode").get("problems")));
			return solutions;

		}

		public List<Solution> getSolutions(JsonNode problems) throws JsonProcessingException {
			List<Solution> solutions = new ArrayList<>();
			Iterator<String> iter = problems.fieldNames();
			while (iter.hasNext()) {
				Solution solution = new Solution();
				solution.problemNumber = iter.next();
				JsonNode value = problems.get(solution.problemNumber);
				solution.problemID = value.get("problem_id").asText();
				solution.llmAuthors = new ObjectMapper().convertValue(value.get("llm_authors").get("names"), String[].class);
				solution.humanAuthors = new ObjectMapper().convertValue(value.get("human_authors").get("names"), String[].class);
				solutions.add(solution);
			}
			return solutions;
		}
	}

	static class Solution {
		public static String fileSuffix = ".java";
		String problemNumber;
		String problemID;
		String[] llmAuthors;
		String[] humanAuthors;

		public String getHumanSolutionFile(int i) {
			if (i > humanAuthors.length) {
				return "";
			} else if (humanAuthors[i].equals("human")) { // 代表未知人类作者
				return "human" + fileSuffix;
			} else {
				return "human-" + humanAuthors[i] + fileSuffix;
			}
		}

		public String getLLMSolutionFile(int i) {
			if (i > llmAuthors.length) {
				return "";
			} else {
				return llmAuthors[i] + fileSuffix;
			}
		}

	}





}
