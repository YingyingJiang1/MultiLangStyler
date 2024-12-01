package org.example.analysis.io.input;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import org.example.analysis.io.InputPair;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InputGenerator {

	public static List<InputPair> generateHumanPairs(String xmlConf) throws IOException {
		List<InputPair> inputPairs = new ArrayList<>();
		return inputPairs;
	}

	public static List<InputPair> generateLLMPairs(String xmlConf) throws IOException {
		List<InputPair> inputPairs = new ArrayList<>();
		return inputPairs;
	}

	public static List<InputPair> generateHumanLLMPairs(String xmlConf) throws IOException {
		List<InputPair> inputPairs = new ArrayList<>();
		return inputPairs;
	}


}
