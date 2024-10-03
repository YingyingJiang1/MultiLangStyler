package org.example.styler;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;
import org.example.Configuration;
import org.example.antlr.JavaParser;
import org.example.style.ProgramStyle;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/*
 * @description:
 * @author     : Jiang Yingying
 * @create     : 2024/1/21 10:44
 */
public class Styler implements Extractor, Applicator {
  protected String filePath;
  protected ProgramStyle programStyle;
  protected Configuration conf;
  protected FileCollector.FileCollection files;

  public static final int EXTRACTION_PROCESS = 1;
  public static final int APPLICATION_PROCESS = 2;


  public Styler(Configuration conf, ProgramStyle programStyle) throws IOException {
    this.conf = conf;
    this.programStyle = programStyle;
  }

  public void applyStyle() throws IOException {
  }

  public void extractStyle() throws IOException, DocumentException {
  }

  public void writeStyleInXml(String dir) throws IOException {
    // 创建xml文件并写入内容
    Document document = DocumentHelper.createDocument();
    Element root = document.addElement("program_style");
    programStyle.addElement(root, new JavaParser(null));
    if(!dir.endsWith("/")) {
      dir = dir + "/";
    }

    String fileName = "";
    // fileName = Paths.get(filePath).getFileName().toString().replace(".java", "") + "-";
    String styleXmlPath = dir + fileName + "style.xml";

    XMLWriter writer = new XMLWriter(new FileWriter(new File(styleXmlPath)),
        OutputFormat.createPrettyPrint());
    writer.write(document);
    writer.close();

    System.out.println("style result saved in:" + styleXmlPath);
  }

}
