package org.example.styler.structure;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.example.parser.common.MyParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
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
  Element rootEle = null;
  public static Logger logger = LoggerFactory.getLogger(EquivalentStructureManager.class);


  private EquivalentStructureManager() {}

  public static EquivalentStructureManager getInstance() {
    return instance;
  }

  public List<EquivalentStructure> loadEquivalences(Class<? extends MyParser> parserClass, String confFile) {
    List<EquivalentStructure> equivalences = new ArrayList<>();
    try {
      loadConfFile(confFile);

      for(Element node : rootEle.elements()) {
        EquivalentStructure structure = EquivalentStructure.create(node, parserClass);

        if (structure != null) {
          equivalences.add(structure);
        }
      }
    } catch (Exception e) {
      logger.error("Failed to load equivalent structures: {}", e.getMessage());
      logger.error("Exception details:", e);
    }
    return equivalences;
  }


  public void loadConfFile(String confFile) {
    try {
      InputStream is = getClass().getResourceAsStream(confFile);
      SAXReader reader = new SAXReader();
      Document document = reader.read(is);
      rootEle = document.getRootElement();
    }  catch (DocumentException e) {
      logger.error("Failed to parse configuration file: {}", e.getMessage());
	}

  }




}
