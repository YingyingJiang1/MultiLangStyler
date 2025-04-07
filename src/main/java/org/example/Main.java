package org.example;

import org.example.controller.Controller;
import org.example.global.GlobalInfo;


public class Main {

    public static void main(String[] args) {
        Configuration config = CLIArgumentParser.parseArgs(args);
        if (config != null) {
            GlobalInfo.setConf(config);
            Controller controller = new Controller(config);
            controller.execute();
            RunStatistic.printStatistic();
        }
    }
//
//    public static void main(String[] args) {
//        String code = "List<String> arr = new ArrayList<>();";
//        MyParser parser = MyParserFactory.createParser("java");
//        ParseTree t = parser.parseFromString(code);
//        System.out.println(t.toStringTree(new JavaParser(null)));
//
//    }
}