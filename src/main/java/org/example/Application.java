package org.example;

import org.dom4j.DocumentException;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

  public static void main(String[] args) {
    Configuration conf = new Configuration();
    try {
      conf.loadConf();
      Controller controller = new Controller(conf);
      controller.execute();
    } catch (DocumentException | IOException e) {
      System.out.println("Failed to load configuration");
    }
    SpringApplication.run(Application.class, args);
  }

}