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
//  private static List<EquivalentStructure> equivalences = new ArrayList<>();
  JsonNode configJson = null;
  public static Logger logger = LoggerFactory.getLogger(EquivalentStructureManager.class);


  private EquivalentStructureManager() {}

  public static EquivalentStructureManager getInstance() {
    return instance;
  }

  public List<EquivalentStructure> loadEquivalences(Class<? extends MyParser> parserClass, String confFile) {
    List<EquivalentStructure> equivalences = new ArrayList<>();
    try {
      loadConfFile(confFile);
      MyParser parser = MyParserFactory.createParser(parserClass);
      ObjectMapper objectMapper = new ObjectMapper();
      for(JsonNode node : configJson) {
        // Skip comment
        if (node.get("id") == null) {
          continue;
        }

        EquivalentStructure structure = EquivalentStructure.create(node, parserClass);
        equivalences.add(structure);
      }
    } catch (Exception e) {
      logger.error("Failed to load equivalent structures: {}", e.getMessage());
      logger.error("Exception details:", e);
    }
    return equivalences;
  }


  public void loadConfFile(String confFile) throws IOException {
    InputStream is = getClass().getResourceAsStream(confFile);
    ObjectMapper objectMapper = new ObjectMapper();
    configJson =  objectMapper.readTree(is);
  }

  public void updateConfFile(String confFile) throws IOException {
    InputStream is = getClass().getResourceAsStream("/equivalencesConf.json");
    ObjectMapper objectMapper = new ObjectMapper();
    configJson =  objectMapper.readTree(is);

    if (configJson != null) {
      objectMapper = new ObjectMapper();
      int id = 1;
      for (JsonNode node : configJson) {
        if (node.get("id") != null) {
          ((ObjectNode) node).put("id", id++);
        }
      }

      objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(confFile), configJson);
    }
  }




}
