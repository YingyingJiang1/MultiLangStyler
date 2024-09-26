package org.example.styler;

import org.dom4j.DocumentException;

import java.io.IOException;

/*
 * @description:
 * @author     : Jiang Yingying
 * @create     : 2024/1/20 22:15
 */
public interface Extractor {
  public void extractStyle() throws IOException, DocumentException;
  public void writeStyleInXml(String dir) throws IOException;
}
