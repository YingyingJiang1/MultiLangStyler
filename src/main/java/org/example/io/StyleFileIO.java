package org.example.io;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.example.Configuration;
import org.example.parser.java.antlr.JavaParser;
import org.example.style.ProgramStyle;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/*
 * @description:
 * @author     : Jiang Yingying
 * @create     : 2024/1/20 22:15
 */
public class StyleFileIO {

  public static ProgramStyle read(String file) throws DocumentException {
      ProgramStyle programStyle = new ProgramStyle();
      SAXReader reader = new SAXReader();
      Document document = reader.read(new File(file));
      Element root = document.getRootElement();
      programStyle.parseElement(root, new JavaParser(null));
      return programStyle;
  }

  public static void write(ProgramStyle programStyle, String file) throws IOException {
    // 创建xml文件并写入内容
    Document document = DocumentHelper.createDocument();
    Element root = document.addElement("program_style");
    programStyle.addElement(root, new JavaParser(null));

    XMLWriter writer = new XMLWriter(new FileWriter(new File(file)),
            OutputFormat.createPrettyPrint());
    writer.write(document);
    writer.close();

    System.out.println("style result saved in:" + file);
  }

}
