package org.example.styler.structure;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.example.parser.common.MyParser;
import org.example.parser.common.factory.MyParserFactory;
import org.example.styler.structure.checker.Checker;
import org.example.styler.structure.handler.Handler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/*
 * @description
 * @author       Yingying Jiang
 * @create       2024/4/3 0:00
 */
public class EquivalentStructureManager {
  private static EquivalentStructureManager instance = new EquivalentStructureManager();
  private static List<EquivalentStructure> equivalences = new ArrayList<>();
  JsonNode configJson = null;
  public String confFile = "/equivalencesConf.json";
  public static Logger logger = LoggerFactory.getLogger(EquivalentStructureManager.class);


  private EquivalentStructureManager() {}

  public static EquivalentStructureManager getInstance() {
    return instance;
  }

  public List<EquivalentStructure> loadEquivalences(Class<? extends MyParser> parserClass) {
    try {
      loadConfFile();
      MyParser parser = MyParserFactory.createParser(parserClass);
      ObjectMapper objectMapper = new ObjectMapper();
      for(JsonNode node : configJson) {
        // Skip comment
        if (node.get("id") == null) {
          continue;
        }

        // Parse json data.
        int id = node.get("id").asInt();
        String category = node.get("category") == null ? "" : node.get("category").asText();
        if (category.isEmpty()) {
          logger.warn("Category is empty for equivalent structure: {}", id);
        }
        String[] codes = objectMapper.convertValue(node.get("codes"), String[].class);
//        String[] holders = objectMapper.convertValue(node.get("holders"), String[].class);
        List<Checker> checkers = parseChecks(node.get("checkers"), objectMapper, parser);
        List<Handler> handlers = parseHandlers(node.get("handlers"), objectMapper, parser);
//        int[] rules = parseRules(node.get("rules"), objectMapper, parser);
        Map<Integer, List<Integer>> bannedTransferMap = parseBannedTransferMap(node.get("banned_transfer"), objectMapper, parser);

        EquivalentStructure structure = new EquivalentStructure(id, category, checkers, handlers, bannedTransferMap);
        structure.compile(codes);

        equivalences.add(structure);
      }
    } catch (Exception e) {
      logger.error("Failed to load equivalent structures: {}", e.getMessage());
      logger.error("Exception details:", e);
    }
    return equivalences;
  }

  public void writeJsonData(String file) throws IOException {
    if (configJson != null) {
      ObjectMapper objectMapper = new ObjectMapper();
      int id = 1;
      for (JsonNode node : configJson) {
        if (node.get("id") != null) {
          ((ObjectNode) node).put("id", id++);
        }
      }
      objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(file), configJson);
    }
  }

  public void loadConfFile() throws IOException {
    InputStream is = getClass().getResourceAsStream(confFile);
    ObjectMapper objectMapper = new ObjectMapper();
    configJson =  objectMapper.readTree(is);
  }

  private List<Checker> parseChecks(JsonNode checkersNode, ObjectMapper objectMapper, MyParser parser) {
    List<Checker> checkers = null;
    if (checkersNode != null) {
      checkers = new ArrayList<>();
      for(JsonNode checkerNode : checkersNode) {
        if (checkerNode.get("class") == null) {
          continue;
        }
        Checker checker = Checker.createChecker(checkerNode.get("class").asText(),
                objectMapper.convertValue(checkerNode.get("argsList"), String[][].class));
        checkers.add(checker);
      }
    }
    return checkers;
  }

  private List<Handler> parseHandlers(JsonNode handlersNode, ObjectMapper objectMapper, MyParser parser) {
    List<Handler> handlers = null;
    if (handlersNode != null) {
      handlers = new ArrayList<>();
      for(JsonNode handlerNode : handlersNode) {
        if (handlerNode.get("class") == null) {
          continue;
        }
        Handler handler = Handler.createHandler(handlerNode.get("class").asText(),
                objectMapper.convertValue(handlerNode.get("argsList"), String[][].class), parser);
        handlers.add(handler);
      }
    }
    return null;
  }

  private int[] parseRules(JsonNode rulesNode, ObjectMapper objectMapper, MyParser parser) {
    String[] ruleNames = objectMapper.convertValue(rulesNode, String[].class);
    int[] rules = new int[ruleNames.length];
    for (int i = 0; i < ruleNames.length; i++) {
      String ruleName = ruleNames[i];
      int rule = parser.getRuleIndex(ruleName);
      rules[i] = rule;
    }
    return rules;
  }

  private Map<Integer, List<Integer>> parseBannedTransferMap(JsonNode bannedTransfersNode, ObjectMapper objectMapper, MyParser parser) {
    Map<Integer, List<Integer>> bannedTransferMap = null;
    String[][] bannedTransfers = objectMapper.convertValue(bannedTransfersNode, String[][].class);
    if (bannedTransfers != null) {
      bannedTransferMap = new HashMap<>();
      for(String[] bannedTransfer : bannedTransfers) {
        int from = Integer.parseInt(bannedTransfer[0]);
        int to = Integer.parseInt(bannedTransfer[1]);
        bannedTransferMap.computeIfAbsent(from, v -> new ArrayList<>());
        bannedTransferMap.get(from).add(to);
      }
    }
    return bannedTransferMap;
  }


}
