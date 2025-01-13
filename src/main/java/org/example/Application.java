package org.example;

import org.dom4j.DocumentException;

import java.io.IOException;

import org.example.controller.Controller;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

  public static void main(String[] args) {
    Configuration config = CLIArgumentParser.parseArgs(args);
    Controller controller = new Controller(config);
    controller.execute();
    SpringApplication.run(Application.class, args);
  }

}