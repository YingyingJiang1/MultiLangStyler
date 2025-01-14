package org.example;

import org.example.controller.Controller;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.Scanner;


public class Main {

  public static void main(String[] args) {
    while (true) {
      try{
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNext()) {
          String inputArg = scanner.nextLine();
          LoggerFactory.getLogger(Main.class).info("args: {}", Arrays.toString(inputArg.split(" ")));
          if (inputArg.equals("exit")) {
            break;
          }
          Configuration config = CLIArgumentParser.parseArgs(inputArg.split(" "));
          if (config != null) {
            Controller controller = new Controller(config);
            controller.execute();
//          SpringApplication.run(Application.class, args);
          }
        }

      } catch (Exception e) {
        LoggerFactory.getLogger(Main.class).error("Error: ", e);
      }

    }
  }

}