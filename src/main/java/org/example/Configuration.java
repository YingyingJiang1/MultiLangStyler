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
    System.out.println("Style file saved directory: " + styleFile);
    System.out.println("Override source: " + overrideSource);
    System.out.println("Use existed style: " + useExistedStyle);
    System.out.println("Apply result saved directory: " + applyResultSaveDir);
    System.out.println("Test mode: " + testMode);
  }

  Element root = null;
  public FileCollector.FileCollection extractionCollection = new FileCollector.FileCollection();
  public FileCollector.FileCollection applicationCollection = new FileCollector.FileCollection();
  public String styleFile;
  public boolean overrideSource;
  public String useExistedStyle;
  public String applyResultSaveDir;
  public String styleFileSavedDir;
  public boolean testMode;

  public void loadConf() throws IOException, DocumentException {
    InputStream inputStream  = getClass().getResourceAsStream("/config.xml");
    SAXReader reader = new SAXReader();
    Document document = reader.read(inputStream);
    root = document.getRootElement();

    loadExtractionInfo(root);
    loadApplicationInfo(root);
  }

  public String getStyleFile() {
    return styleFile;
  }


  private void loadApplicationInfo(Element root) {
    Element applicationInfo = root.element("application_info");
//    overrideSource = applicationInfo.elementText("override").equals("true");
    applicationCollection = loadSource(applicationInfo);


    if (applicationInfo.element("result_saved_dir") != null) {
      applyResultSaveDir = applicationInfo.element("result_saved_dir").getText();
    }
  }

  private void loadExtractionInfo(Element root) {
    Element extractionInfo = root.element("extraction_info");
    extractionCollection = loadSource(extractionInfo);
    styleFile = extractionInfo.elementText("style_file").replace("${root}", System.getProperty("user.dir"));
    styleFileSavedDir = extractionInfo.elementText("style_saved_directory").replace("${root}", System.getProperty("user.dir"));
  }

  private FileCollector.FileCollection loadSource(Element info) {
    Element source = info.element("source");
    List<String> sourcePaths = new ArrayList<>();
    List<String> excludes = Arrays.stream(source.attributeValue("excludes").split(";")).toList();
    sourcePaths = Arrays.stream(source.getText().split(";")).toList();
    FileCollector.FileCollection collection = FileCollector.getJavaFileCollection(sourcePaths);
    collection.difference(FileCollector.getJavaFileCollection(excludes));
    return collection;
  }
}
