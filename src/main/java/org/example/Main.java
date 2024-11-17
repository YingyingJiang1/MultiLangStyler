package org.example;

import org.dom4j.DocumentException;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Main {

  public static void main(String[] args) throws IOException {

    Configuration conf = new Configuration();
    try {
      conf.loadConf();
      Controller controller = new Controller(conf);
      controller.execute();
    } catch (DocumentException e) {
        throw new RuntimeException(e);
    }
  }
}