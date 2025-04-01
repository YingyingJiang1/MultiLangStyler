package org.example;

import org.dom4j.Element;
import org.example.global.GlobalInfo;
import org.example.parser.common.factory.MyParserFactory;
import org.example.utils.FileCollection;
import org.example.utils.FileCollector;
import org.example.utils.searcher.NodeSearcherFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.*;
import java.util.*;


/*
 * @description
 * @author       Yingying Jiang
 * @create       2024/3/13 16:11
 */
@org.springframework.context.annotation.Configuration
public class Configuration {

	private static final Logger log = LoggerFactory.getLogger(Configuration.class);
	Element root = null;

  public String styleFile;
//  public String styleFileSavedPath;

  private String src;
  private String target;
  public boolean overrideSource = false;
  public boolean isSaveSelfStyle = true;
  public FileCollection extractionCollection = new FileCollection();
  public FileCollection applicationCollection = new FileCollection();
  private String resOutFile;
  private String resOutDir;
  private String styleOutPath;


  @Autowired
  private LLMConfig llmConfig;

  @Autowired
  private LanguageConfig languageConfig;

  public Configuration() {
    ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
    llmConfig = context.getBean(Configuration.LLMConfig.class);
    languageConfig = context.getBean(Configuration.LanguageConfig.class);
  }


//  public void loadConf() {
//    try {
//      InputStream inputStream  = getClass().getResourceAsStream("/config.xml");
//      SAXReader reader = new SAXReader();
//      Document document = reader.read(inputStream);
//      root = document.getRootElement();
//
//
//    } catch (DocumentException e) {
//      log.error("Failed to load configuration", e);
//    }
//
//  }

  public String getStyleFile() {
    return styleFile;
  }


  private FileCollection collectFile(String path) {
    List<String> sourcePaths = Arrays.stream(path.split(";")).toList();
    FileCollection collection = FileCollector.getJavaFileCollection(sourcePaths);
    collection.difference(FileCollector.getJavaFileCollection(List.of()));
    return collection;
  }

  public String getResOutFile() {
    return resOutFile;
  }

  public String getResOutDir() {
    return resOutDir;
  }

  public LLMConfig getLlmConfig() {
    return llmConfig;
  }

  public LanguageConfig getLanguageConfig() {
    return languageConfig;
  }


  public void setSrc(String src) {
    this.src = src;
    applicationCollection = collectFile(src);
    if (!applicationCollection.isEmpty()) {
      String suffix = applicationCollection.getFilePath(0).substring(applicationCollection.getFilePath(0).lastIndexOf(".") + 1);
      String language = switch (suffix) {
        case "java" -> "java";
        case "py" -> "python";
        case "cpp" -> "cpp";
        default -> null;
      };
      if (language == null) {
        throw new IllegalArgumentException("Failed to identify the language of " + src);
      }
      GlobalInfo.setLanguage(language);
    }

  }

  public void setTarget(String target) {
    this.target = target;
    if (target.endsWith(".xml")) {
      styleFile = target;
    } else {
      extractionCollection = collectFile(target);
    }
  }

  public void setStyleOutPath(String styleOut) {
    this.styleOutPath = styleOut;
  }

  public String getTarget() {
    return target;
  }

  public String getSrc() {
    return src;
  }

  public void setResOutFile(String resOutFile) {
    this.resOutFile = resOutFile;
  }

  public void setResOutDir(String resOutDir) {
    this.resOutDir = resOutDir;
  }

  public void setOverrideSource(boolean overrideSource) {
    this.overrideSource = overrideSource;
  }

  public String getCodeOutPath(String srcPath) {
    if (resOutFile != null) {
      return resOutFile;
    } else if (resOutDir != null) {
      return resOutDir + File.separator + new File((srcPath)).getName();
    } else {
      return null;
//      return srcPath;
    }
  }

  public String getStyleOutPath() {
    return styleOutPath;
  }

  public static class LLMConfig{
    public String url;
    public int identifierLengthLimit;

    public String getModelURL() {
      return url;
    }

    public int getIdentifierLengthLimit() {
      return identifierLengthLimit;
    }

    public void setUrl(String url) {
      this.url = url;
    }

    public void setIdentifierLengthLimit(int identifierLengthLimit) {
      this.identifierLengthLimit = identifierLengthLimit;
    }

  }



  public static class LanguageConfig{
    private String language;
    private NodeSearcherFactory nodeSearcherFactory;
    private MyParserFactory parserFactory;

    public String getLanguage() {
      return language;
    }

    public void setLanguage(String language) {
      this.language = language;
    }

    public NodeSearcherFactory getNodeSearcherFactory() {
      return nodeSearcherFactory;
    }

    public void setNodeSearcherFactory(NodeSearcherFactory nodeSearcherFactory) {
      this.nodeSearcherFactory = nodeSearcherFactory;
    }

    public MyParserFactory getParserFactory() {
      return parserFactory;
    }

    public void setParserFactory(MyParserFactory parserFactory) {
      this.parserFactory = parserFactory;
    }

  }
}
