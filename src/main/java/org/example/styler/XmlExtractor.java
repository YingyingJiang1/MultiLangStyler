package org.example.styler;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.example.Configuration;
import org.example.antlr.JavaParser;
import org.example.style.ProgramStyle;

import java.io.File;
import java.io.IOException;

/*
 * @description:
 * @author     : Jiang Yingying
 * @create     : 2024/1/20 22:15
 */
public class XmlExtractor extends Styler {

  public XmlExtractor(Configuration conf, ProgramStyle programStyle) throws IOException {
    super(conf, programStyle);
  }
  @Override
  public void extractStyle() throws DocumentException, IOException {
    SAXReader reader = new SAXReader();
    Document document = reader.read(new File(conf.getStyleFile()));
    Element root = document.getRootElement();
    programStyle.parseElement(root, new JavaParser(null));
  }

  public void parseStyleFromXml(String file) throws DocumentException {

  }


  @Override
  public void applyStyle() {
    System.out.println("Implement StyleConfiguration.applyStyle!");
  }
}
