package org.example;

import org.example.controller.Controller;

import java.util.Scanner;


public class Main {

  public static void main(String[] args) {
    while (true) {
      Scanner scanner = new Scanner(System.in);
      String inputArg = scanner.nextLine();
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
  }

}