package org.example;

import org.example.controller.Controller;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.Scanner;


public class Main {

  public static void main(String[] args) {
    Configuration config = CLIArgumentParser.parseArgs(args);
    if (config != null) {
        Controller controller = new Controller(config);
        controller.execute();
//          SpringApplication.run(Application.class, args);
    }
  }

}