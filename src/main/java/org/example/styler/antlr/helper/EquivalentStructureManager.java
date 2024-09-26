package org.example.styler.antlr.helper;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.antlr.JavaParser;
import org.example.styler.antlr.helper.checker.Checker;
import org.example.styler.antlr.helper.handler.Handler;

import java.io.File;
import java.util.*;

/*
 * @description
 * @author       Yingying Jiang
 * @create       2024/4/3 0:00
 */
public class EquivalentStructureManager {
  private static EquivalentStructureManager instance = new EquivalentStructureManager();
  private static Map<Integer, List<EquivalentStructure>> equivalences = null;


  private EquivalentStructureManager() {}

  public static EquivalentStructureManager getInstance() {
    return instance;
  }

  public Map<Integer, List<EquivalentStructure>> loadEquivalences() {
    if (equivalences != null) {
      return equivalences;
    }

    equivalences = new HashMap<>();
    equivalences.put(JavaParser.RULE_expressionStmt, new ArrayList<>());
    equivalences.put(JavaParser.RULE_ifStmt, new ArrayList<>());
    equivalences.put(JavaParser.RULE_ifElseStmt, new ArrayList<>());
    equivalences.put(JavaParser.RULE_forStmt, new ArrayList<>());
    equivalences.put(JavaParser.RULE_whileStmt, new ArrayList<>());
    equivalences.put(JavaParser.RULE_returnStmt, new ArrayList<>());
    equivalences.put(JavaParser.RULE_block, new ArrayList<>());
    equivalences.put(JavaParser.RULE_expression, new ArrayList<>());
    equivalences.put(JavaParser.RULE_localVariableDeclarationStmt, new ArrayList<>());

    File file = new File("D:\\user\\pity\\notes\\毕设\\plugin\\code-style-transfer\\equivalences.json");
    try {
      ObjectMapper objectMapper = new ObjectMapper();
      JsonNode jsonNode =  objectMapper.readTree(file);
      for(JsonNode node : jsonNode) {
        // Skip comment
        if (node.get("id") == null) {
          continue;
        }
        int id = node.get("id").asInt();
        String[] codes = objectMapper.convertValue(node.get("codes"), String[].class);
        String[] holders = objectMapper.convertValue(node.get("holders"), String[].class);
        String[] ruleNames = objectMapper.convertValue(node.get("rules"), String[].class);
        String[][] bannedTransfers = objectMapper.convertValue(node.get("banned_transfer"), String[][].class);

        List<Checker> checkers = null;
        JsonNode checkersNode = node.get("checkers");
        if (checkersNode != null) {
          checkers = new ArrayList<>();
          for(JsonNode checkerNode : checkersNode) {
            Checker checker = Checker.createChecker(checkerNode.get("class").asText(),
                objectMapper.convertValue(checkerNode.get("argsList"), String[][].class));
            checkers.add(checker);
          }
        }

        List<Handler> handlers = null;
        JsonNode handlersNode = node.get("handlers");
        if (handlersNode != null) {
          handlers = new ArrayList<>();
          for(JsonNode handlerNode : handlersNode) {
            Handler handler = Handler.createHandler(handlerNode.get("class").asText(),
                objectMapper.convertValue(handlerNode.get("argsList"), String[][].class));
            handlers.add(handler);
          }
        }


        int[] rules = new int[ruleNames.length];
        for (int i = 0; i < ruleNames.length; i++) {
          String ruleName = ruleNames[i];
          int rule = Arrays.asList(JavaParser.ruleNames).indexOf(ruleName);
          rules[i] = rule;
        }

        Map<Integer, List<Integer>> bannedTransferMap = null;
        if (bannedTransfers != null) {
          bannedTransferMap = new HashMap<>();
          for(String[] bannedTransfer : bannedTransfers) {
            int from = Integer.parseInt(bannedTransfer[0]);
            int to = Integer.parseInt(bannedTransfer[1]);
            bannedTransferMap.computeIfAbsent(from, v -> new ArrayList<>());
            bannedTransferMap.get(from).add(to);
          }
        }

        EquivalentStructure structure = new EquivalentStructure(id, rules, checkers, handlers, bannedTransferMap);
        structure.compile(codes, holders);

        Set<Integer> ruleSet = new HashSet<>(Arrays.stream(rules).boxed().toList());
        for(int rule : ruleSet) {
          if (equivalences.get(rule) == null) {
            System.err.println("rule " + rule + " isn't added in equivalences map.");
          } else {
            equivalences.get(rule).add(structure);
          }
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
      System.err.println("load Equivalent structures failed from " + file.getAbsolutePath() + ":" + e.getMessage());
    }
    return equivalences;
  }


}
