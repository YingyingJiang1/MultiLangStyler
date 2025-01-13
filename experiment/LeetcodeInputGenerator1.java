package org.example.experiment;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.antlr.v4.runtime.misc.Pair;

import java.io.*;
import java.lang.reflect.Array;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @description
 * @author       Yingying Jiang
 * @create       2024/4/30 18:00
 */
public class LeetcodeInputGenerator1 extends LeetcodeInputGenerator{

  @Override
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
      JsonNode jsonNode = arrayNode.get(i);
      int pairSize = jsonNode.get("pairSize").asInt();
      // int roundSize = jsonNode.get("roundsSize").asInt();
      String sourceDataset = jsonNode.get("sourceDataset").asText();
      String targetDataset = jsonNode.get("targetDataset").asText();
      String resultBaseDir = jsonNode.get("resultBaseDir").asText();
      Pair<String[], String[]> sameFilePair =
          generateSameNamePairs(getFileList(sourceDataset), getFileList(targetDataset), 100);
      if (sameFilePair == null) {
        System.out.println(sourceDataset + "," + targetDataset);
        continue;
      }
      InputPair pair1 = new InputPair(1, sourceDataset, targetDataset, resultBaseDir);
      InputPair pair2 = new InputPair(10, sourceDataset, targetDataset, resultBaseDir);
      InputPair pair3 = new InputPair(50, sourceDataset, targetDataset, resultBaseDir);
      InputPair pair4 = new InputPair(100, sourceDataset, targetDataset, resultBaseDir);
      generateRounds(pair1,  sameFilePair);
      generateRounds(pair2, sameFilePair);
      generateRounds(pair3, sameFilePair);
      generateRounds(pair4, sameFilePair);
      inputPairs.add(pair1);
      inputPairs.add(pair2);
      inputPairs.add(pair3);
      inputPairs.add(pair4);
    }


    // 将生成的Pair写入JSON文件（可选）
    if (write) {
      mapper.writerWithDefaultPrettyPrinter().writeValue(
          new BufferedWriter(new OutputStreamWriter(new FileOutputStream(jsonPath), StandardCharsets.UTF_8)),
          inputPairs.toArray());
    }
    return inputPairs;
  }

  public void generateRounds(InputPair pair, Pair<String[], String[]> sameFilePair) {
    int pairSize = pair.getPairSize();
    int fileSize = sameFilePair.a.length;
    for (int i = 0; i < fileSize; i += pairSize) {
      InputPair.Round round = new InputPair.Round(
          Arrays.copyOfRange(sameFilePair.a, i, i + pairSize),
          Arrays.copyOfRange(sameFilePair.b, i, i + pairSize),
          null
          );
      pair.getRounds().add(round);
    }
    pair.roundsSize = pair.getRounds().size();
  }
}
