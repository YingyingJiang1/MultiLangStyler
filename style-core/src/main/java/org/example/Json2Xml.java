package org.example;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;


import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Json2Xml {
	public static void main(String[] args) throws IOException {
		File jsonFile = new File("C:\\Users\\dell\\jyy\\transformer\\style-core\\src\\main\\resources\\equivalencesConf.json");
		File xmlFile = new File(Paths.get(jsonFile.getParent(), "equivalences.xml").toString());
		convertJsonFileToXml(jsonFile, xmlFile);
	}

	/**
	 * 将 JSON 文件转换为 XML，每个 JSON 对象对应一个 <rule>
	 */
	public static void convertJsonFileToXml(File jsonFile, File xmlFile) throws IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		XmlMapper xmlMapper = new XmlMapper();

		// 读取 JSON 数组或者单个对象
		JsonNode rootNode = objectMapper.readTree(jsonFile);
		List<Map<String, Object>> rulesList = new ArrayList<>();

		if (rootNode.isArray()) {
			for (JsonNode node : rootNode) {
				rulesList.add(parseRule(node));
			}
		} else {
			rulesList.add(parseRule(rootNode));
		}

		// 封装成根节点
		Map<String, Object> rootMap = new LinkedHashMap<>();
		rootMap.put("rules", rulesList);

		// 输出 XML
		xmlMapper.writeValue(xmlFile, rootMap);
	}

	/**
	 * 将单个 JSON 对象解析为 Map，用于 <rule> 节点
	 */
	private static Map<String, Object> parseRule(JsonNode node) {
		Map<String, Object> ruleMap = new LinkedHashMap<>();
		ObjectMapper objectMapper = new ObjectMapper();

		// 基本字段
		if (node.has("id")) ruleMap.put("id", node.get("id").asInt());
		if (node.has("category")) ruleMap.put("category", node.get("category").asText());

		// codes 数组
		if (node.has("codes")) {
			String[] codes = objectMapper.convertValue(node.get("codes"), String[].class);
			ruleMap.put("codes", Arrays.asList(codes));
		}

		// checkers 数组
		if (node.has("checkers")) {
			List<Map<String, Object>> checkerList = new ArrayList<>();
			for (JsonNode checkerNode : node.get("checkers")) {
				Map<String, Object> checkerMap = new LinkedHashMap<>();
				checkerMap.put("class", checkerNode.get("class").asText());
				checkerMap.put("argsList", objectMapper.convertValue(checkerNode.get("argsList"), String[][].class));
				checkerList.add(checkerMap);
			}
			ruleMap.put("checkers", checkerList);
		}

		// handlers 数组
		if (node.has("handlers")) {
			List<Map<String, Object>> handlerList = new ArrayList<>();
			for (JsonNode handlerNode : node.get("handlers")) {
				Map<String, Object> handlerMap = new LinkedHashMap<>();
				handlerMap.put("class", handlerNode.get("class").asText());
				handlerMap.put("argsList", objectMapper.convertValue(handlerNode.get("argsList"), String[][].class));
				handlerList.add(handlerMap);
			}
			ruleMap.put("handlers", handlerList);
		}

		// banned_transfer 数组
		if (node.has("banned_transfer")) {
			String[][] bannedTransfers = objectMapper.convertValue(node.get("banned_transfer"), String[][].class);
			Map<Integer, List<Integer>> bannedMap = new HashMap<>();
			for (String[] pair : bannedTransfers) {
				int from = Integer.parseInt(pair[0]);
				int to = Integer.parseInt(pair[1]);
				bannedMap.computeIfAbsent(from, k -> new ArrayList<>()).add(to);
			}
			ruleMap.put("banned_transfer", bannedMap);
		}

		return ruleMap;
	}

}
