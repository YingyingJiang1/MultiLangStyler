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
import org.example.styler.structure.style.CategoryResult;
import org.example.styler.structure.style.StyleCategory;
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
  private List<EquivalentStructure> equivalences = new ArrayList<>();
  private Map<StyleCategory, List<EquivalentStructure>> categoryLookupCache;
  Element rootEle = null;
  public static Logger logger = LoggerFactory.getLogger(EquivalentStructureManager.class);


  private EquivalentStructureManager() {}

  public static EquivalentStructureManager getInstance() {
    return instance;
  }

  public CategoryResult getCategoryResult(String categoryName, String style) {
    StyleCategory category = null;
    // 构建查询缓存
    if (categoryLookupCache == null) {
      categoryLookupCache = new HashMap<>();
      for (EquivalentStructure equivalentStructure : equivalences) {
        try {
          category = StyleCategory.valueOf(categoryName);
          categoryLookupCache.computeIfAbsent(category, k -> new ArrayList<>()).add(equivalentStructure);
        } catch (Exception e) {
          logger.warn("StyleCategory {} not found", categoryName);
        }
      }
    }

    // 获取当前风格类别的风格值所关联的代码结构id和写法
    List<EquivalentStructure> structures = categoryLookupCache.get(category);
    if (structures == null) {
      return null;
    }
    CategoryResult result = new CategoryResult();
    for (EquivalentStructure equivalentStructure : structures) {
      int index = equivalentStructure.getIndexOf(style);
      if (index >= 0) {
        result.add(equivalentStructure.id, index);
      }
    }
    return result;
  }

  public List<EquivalentStructure> loadEquivalences(Class<? extends MyParser> parserClass, String confFile) {
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
