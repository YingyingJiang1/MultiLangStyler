package org.example;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.example.styler.FileCollector;

import java.io.*;
import java.util.*;


/*
 * @description
 * @author       Yingying Jiang
 * @create       2024/3/13 16:11
 */
public class Configuration {

  public void print() {
    System.out.println("Extraction files: " + extractionCollection.toString());
    System.out.println("Application files: " + applicationCollection.toString());
    System.out.println("Style file saved directory: " + styleFileSavedDir);
    System.out.println("Override source: " + overrideSource);
    System.out.println("Use existed style: " + useExistedStyle);
    System.out.println("Apply result saved directory: " + applyResultSaveDir);
    System.out.println("Test mode: " + testMode);
  }

  Element root = null;
  public FileCollector.FileCollection extractionCollection;
  public FileCollector.FileCollection applicationCollection;
  public String styleFileSavedDir;
  public boolean overrideSource;
  public boolean useExistedStyle;
  public String applyResultSaveDir;
  public boolean testMode;

  public void loadConf(AnActionEvent event) throws IOException, DocumentException {
    this.event = event;
    InputStream inputStream  = getClass().getResourceAsStream("/config.xml");
    SAXReader reader = new SAXReader();
    Document document = reader.read(inputStream);
    root = document.getRootElement();

    if (event != null) {
      loadExtractionInfo(root);
      loadApplicationInfo(root);
    } else {
      System.err.println("Plugin has no AnActionEvent instance.");
    }
  }

  public String getStyleFile() {
    return styleFileSavedDir + File.separator + "style.xml";
  }


  private void loadApplicationInfo(Element root) {
    Element applicationInfo = root.element("application_info");
    overrideSource = applicationInfo.elementText("override").equals("true");
//    loadSource(applicationInfo, applicationCollection);

    System.out.println("add selected file!");

    if (applicationInfo.element("result_saved_dir") != null) {
      applyResultSaveDir = applicationInfo.element("result_saved_dir").getText();
    }
  }

  private void loadExtractionInfo(Element root) {
    Element extractionInfo = root.element("extraction_info");

    loadSource(extractionInfo, extractionCollection);

    Element styleSavedDir = extractionInfo.element("style_saved_directory");
    if(styleSavedDir.attributeValue("useDefault").equals("false")) {
      styleFileSavedDir = PathManager.getTempPath();
    } else {
      styleFileSavedDir = styleSavedDir.getText();
    }
    useExistedStyle = extractionInfo.elementText("use_existed_style").equals("true");
  }

  private void loadSource(Element info, FileCollector.FileCollection collection) {
    Element source = info.element("source");
    List<String> sourcePaths = new ArrayList<>();
    List<String> excludes = Arrays.stream(source.attributeValue("excludes").split(";")).toList();
    if(source.attributeValue("useDefault").equals("true")) {
      Project project = event.getProject();
      sourcePaths.add(project.getBasePath() + File.separator + "src");
    } else {
      sourcePaths = Arrays.stream(source.getText().split(";")).toList();
    }
    collection = FileCollector.getJavaFileCollection(sourcePaths);
    collection.difference(FileCollector.getJavaFileCollection(excludes));
  }
}
