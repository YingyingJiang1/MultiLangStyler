package org.example;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.example.global.GlobalInfo;
import org.example.utils.FileCollection;
import org.example.utils.FileCollector;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import java.io.*;
import java.util.*;


/*
 * @description
 * @author       Yingying Jiang
 * @create       2024/3/13 16:11
 */
@EnableConfigurationProperties(Configuration.class)
@ConfigurationProperties(prefix = "config")
public class Configuration {

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

  @Deprecated
  public void loadConf() throws IOException, DocumentException {
    InputStream inputStream  = getClass().getResourceAsStream("/config.xml");
    SAXReader reader = new SAXReader();
    Document document = reader.read(inputStream);
    root = document.getRootElement();

    Element extractionInfo = root.element("extraction_info");
    extractionCollection = collectFile(extractionInfo.element("source").getText());
    styleFile = extractionInfo.elementText("style_file").replace("${root}", System.getProperty("user.dir"));
//    styleFileSavedPath = extractionInfo.elementText("style_path").replace("${root}", System.getProperty("user.dir"));

    Element applicationInfo = root.element("application_info");
//    overrideSource = applicationInfo.elementText("override").equals("true");
    Element source = applicationInfo.element("source");
    applicationCollection = collectFile(source.getText());


//    if (applicationInfo.element("result_saved_dir") != null) {
//      applyResultSaveDir = applicationInfo.element("result_saved_dir").getText();
//    }
  }

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
}
