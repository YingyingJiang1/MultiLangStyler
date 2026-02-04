package org.example.config;

import lombok.Data;
import org.dom4j.Element;
import org.example.MyEnvironment;
import org.example.style.StylerContainer;
import org.example.utils.FileCollection;
import org.example.utils.FileCollector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.*;


/*
 * Store configuration data.
 * @author       Yingying Jiang
 * @create       2024/3/13 16:11
 */
@Component
@Data
public class MyConfiguration implements IConfig {

	private static final Logger log = LoggerFactory.getLogger(MyConfiguration.class);
	Element root = null;

  public String styleFile;
//  public String styleFileSavedPath;

  private String src;
  private String target;
  public FileCollection extractionCollection = new FileCollection();
  public FileCollection applicationCollection = new FileCollection();

  // This field controls which stylers are enabled dynamically for languages.
  private Map<String, List<Class<?>>> enabledStylers;

  @Autowired
  private LLMConfig llmConfig;

  @Autowired
  private AllLanguageConfigs  languageConfigs;

  @Autowired
  private ProjectConfig projectConfig;


  private FileCollection collectFile(String path) {
    if (path == null) {
      return new FileCollection();
    }
    List<String> sourcePaths = Arrays.stream(path.split(";")).toList();
    FileCollection collection = FileCollector.getFileCollection(sourcePaths);
    return collection;
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
      MyEnvironment.setLanguage(language);
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

  @Override
  public Class<?> getMyParserClass(String lang) {
    return doGetClass(lang + ".parser");
  }

  @Override
  public Class<?> getTreeNodeFactoryClass(String lang) {
    return doGetClass(lang + ".treeNodeFactory");
  }

  @Override
  public Class<?> getASTRewriterClass(String lang) {
    return doGetClass(lang + ".astRewriter");
  }

  @Override
  public String getEquivalencesConfig(String lang) {
    return doGetString(lang + ".equivalencesConfig");
  }

  @Override
  public Class<?> getNodeSearcherFactory(String lang) {
    return doGetClass(lang + ".nodeSearcherFactory");
  }

  @Override
  public Class<?> getPlaceholderParser(String lang) {
    return doGetClass(lang + ".placeholderParser");
  }

  @Override
  public Class<?> getSymbolResolver(String lang) {
    return doGetClass(lang + ".symbolResolver");
  }

  @Override
  public Class<?> getTypeResolver(String lang) {
    return doGetClass(lang + ".typeResolver");
  }

  private Class<?> doGetClass(String key) {
    try {
      return Class.forName(languageConfigs.all.getOrDefault(key, null));
    } catch (Exception e) {
      log.error("Failed to get class for key: " + key, e);
      return null;
    }
  }

  private String doGetString(String key) {
    return languageConfigs.all.getOrDefault(key, null);
  }

  public double getMinDominantRatio() {
    return projectConfig.minDominantRatio;
  }

  @Override
  public String getLLMUrl() {
    return llmConfig.url;
  }

  @Override
  public String getLLMApiKey() {
    return llmConfig.apikey;
  }

  @Override
  public String getLLMModel() {
    return llmConfig.model;
  }

  @Override
  public double getLLMTemperature() {
    return llmConfig.temperature;
  }

  @Override
  public double getLLMMaxTokens() {
    return llmConfig.maxNewTokens;
  }

  @Override
  public StylerContainer creasteStylerContainer(String lang) {
    if (enabledStylers != null && enabledStylers.containsKey(lang)) {
      return new StylerContainer(enabledStylers.get(lang));
    }
    return new StylerContainer();
  }

  @Override
  public void SetEnabledStylers(String lang, List<Class<?>> stylerClasses) {
    if (enabledStylers == null) {
      this.enabledStylers = new HashMap<>();
    }
    this.enabledStylers.put(lang, stylerClasses);
  }


  @Configuration
  @ConfigurationProperties(prefix = "llm")
  public static class LLMConfig{
    String apikey;
    String url;
    String model;
    int identifierLengthLimit;
    double temperature = 0.6;
    double maxNewTokens = 1024;



    public String getModel() {
      return model;
    }

    public void setModel(String model) {
      this.model = model;
    }

    public String getApikey() {
      return apikey;
    }

    public void setApikey(String apikey) {
      this.apikey = apikey;
    }

    public String getUrl() {
      return url;
    }

    public void setUrl(String url) {
      this.url = url;
    }

    public int getIdentifierLengthLimit() {
      return identifierLengthLimit;
    }

    public void setIdentifierLengthLimit(int identifierLengthLimit) {
      this.identifierLengthLimit = identifierLengthLimit;
    }

    public double getTemperature() {
      return temperature;
    }

    public void setTemperature(double temperature) {
      this.temperature = temperature;
    }

    public double getMaxNewTokens() {
      return maxNewTokens;
    }

    public void setMaxNewTokens(double maxNewTokens) {
      this.maxNewTokens = maxNewTokens;
    }


  }

  @Configuration
  @ConfigurationProperties(prefix = "lang")
  public static class AllLanguageConfigs {
    Map<String, String> all = new HashMap<>();

    public Map<String, String> getAll() {
      return all;
    }

    public void setAll(Map<String, String> all) {
      this.all = all;
    }
  }

  @Configuration
  @ConfigurationProperties(prefix = "project")
  @Data
  public static class ProjectConfig {
    double minDominantRatio;
    int identifierLengthLimit;
    String styleOutputDir;
    String projectsFile;
    String styleProfilesFile;
    ThreadPoolConfig threadPool;


    @Data
    public static class ThreadPoolConfig {
      int corePoolSize;
      int maxPoolSize;
      int keepAliveSeconds;
      int queueCapacity;
    }
  }
}
